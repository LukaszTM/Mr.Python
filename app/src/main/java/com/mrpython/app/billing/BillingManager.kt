package com.mrpython.app.billing

import android.app.Activity
import android.content.Context
import com.android.billingclient.api.AcknowledgePurchaseParams
import com.android.billingclient.api.BillingClient
import com.android.billingclient.api.BillingClientStateListener
import com.android.billingclient.api.BillingFlowParams
import com.android.billingclient.api.BillingResult
import com.android.billingclient.api.ConsumeParams
import com.android.billingclient.api.PendingPurchasesParams
import com.android.billingclient.api.ProductDetails
import com.android.billingclient.api.Purchase
import com.android.billingclient.api.PurchasesUpdatedListener
import com.android.billingclient.api.QueryProductDetailsParams
import com.android.billingclient.api.QueryPurchasesParams

/**
 * Purchases through Google Play Billing: the one-time "full course" and the repeatable
 * "full hearts" refill.
 *
 * Callbacks may arrive on any thread:
 * - [onOwned] reports whether the account owns the full course, each time Google Play answers,
 * - [onHearts] fires once for every paid hearts refill, after Google Play has used it up,
 * - [onPrice] delivers the localized price of a product once it is known,
 * - [onMessage] carries a text for the learner (a pending payment, an error).
 */
class BillingManager(
    context: Context,
    private val onOwned: (Boolean) -> Unit,
    private val onHearts: () -> Unit,
    private val onPrice: (productId: String, price: String) -> Unit,
    private val onMessage: (String) -> Unit,
) {
    @Volatile
    private var products: Map<String, ProductDetails> = emptyMap()

    private val purchasesListener = PurchasesUpdatedListener { result, purchases ->
        when (result.responseCode) {
            BillingClient.BillingResponseCode.OK -> handle(purchases.orEmpty(), authoritative = false)
            BillingClient.BillingResponseCode.USER_CANCELED -> Unit
            BillingClient.BillingResponseCode.ITEM_ALREADY_OWNED -> refresh()
            else -> onMessage("Zakup się nie powiódł. Spróbuj ponownie za chwilę.")
        }
    }

    private val client: BillingClient = BillingClient.newBuilder(context.applicationContext)
        .setListener(purchasesListener)
        .enablePendingPurchases(PendingPurchasesParams.newBuilder().enableOneTimeProducts().build())
        .build()

    /** Connects to Google Play (if needed), then loads the product and the owned purchases. */
    fun refresh() {
        if (client.isReady) {
            query()
            return
        }
        client.startConnection(object : BillingClientStateListener {
            override fun onBillingSetupFinished(result: BillingResult) {
                if (result.responseCode == BillingClient.BillingResponseCode.OK) query()
            }

            override fun onBillingServiceDisconnected() = Unit
        })
    }

    /** Opens the Google Play purchase sheet for [productId]; returns false when the shop is not reachable. */
    fun buy(activity: Activity, productId: String): Boolean {
        val details = products[productId]
        if (!client.isReady || details == null) {
            refresh()
            return false
        }
        val params = BillingFlowParams.newBuilder()
            .setProductDetailsParamsList(
                listOf(BillingFlowParams.ProductDetailsParams.newBuilder().setProductDetails(details).build())
            )
            .build()
        return client.launchBillingFlow(activity, params).responseCode == BillingClient.BillingResponseCode.OK
    }

    private fun query() {
        val wanted = QueryProductDetailsParams.newBuilder()
            .setProductList(
                listOf(FULL_COURSE, HEARTS_REFILL).map { id ->
                    QueryProductDetailsParams.Product.newBuilder()
                        .setProductId(id)
                        .setProductType(BillingClient.ProductType.INAPP)
                        .build()
                }
            )
            .build()
        client.queryProductDetailsAsync(wanted) { result, response ->
            if (result.responseCode == BillingClient.BillingResponseCode.OK) {
                val found = response.productDetailsList
                products = found.associateBy { it.productId }
                found.forEach { details ->
                    details.oneTimePurchaseOfferDetails?.formattedPrice?.let { onPrice(details.productId, it) }
                }
            }
        }
        val owned = QueryPurchasesParams.newBuilder().setProductType(BillingClient.ProductType.INAPP).build()
        client.queryPurchasesAsync(owned) { result, purchases ->
            if (result.responseCode == BillingClient.BillingResponseCode.OK) handle(purchases, authoritative = true)
        }
    }

    /**
     * [authoritative] lists are the full set of what the account owns, so a missing purchase
     * (for example after a refund) takes the full course away again.
     */
    private fun handle(purchases: List<Purchase>, authoritative: Boolean) {
        // A hearts refill is used up at once, so it can be bought again; the hearts are
        // handed out only after Google Play confirms, which makes each payment count once.
        purchases
            .filter { HEARTS_REFILL in it.products && it.purchaseState == Purchase.PurchaseState.PURCHASED }
            .forEach { refill ->
                val params = ConsumeParams.newBuilder().setPurchaseToken(refill.purchaseToken).build()
                client.consumeAsync(params) { result, _ ->
                    if (result.responseCode == BillingClient.BillingResponseCode.OK) onHearts()
                }
            }
        val mine = purchases.filter { FULL_COURSE in it.products }
        val bought = mine.firstOrNull { it.purchaseState == Purchase.PurchaseState.PURCHASED }
        when {
            bought != null -> {
                if (!bought.isAcknowledged) {
                    val params = AcknowledgePurchaseParams.newBuilder().setPurchaseToken(bought.purchaseToken).build()
                    client.acknowledgePurchase(params) { }
                }
                onOwned(true)
            }
            purchases.any { it.purchaseState == Purchase.PurchaseState.PENDING } ->
                onMessage("Płatność oczekuje na potwierdzenie. Zakup pojawi się, gdy tylko zostanie zaksięgowana.")
            authoritative -> onOwned(false)
        }
    }

    companion object {
        /** The product ID that has to exist in the Play Console (a one-time, non-consumable product). */
        const val FULL_COURSE = "full_course"

        /** A consumable product in the Play Console: fills the hearts up, can be bought again. */
        const val HEARTS_REFILL = "hearts_refill"
    }
}
