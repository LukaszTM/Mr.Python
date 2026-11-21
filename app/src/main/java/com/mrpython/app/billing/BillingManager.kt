package com.mrpython.app.billing

import android.app.Activity
import android.content.Context
import com.android.billingclient.api.AcknowledgePurchaseParams
import com.android.billingclient.api.BillingClient
import com.android.billingclient.api.BillingClientStateListener
import com.android.billingclient.api.BillingFlowParams
import com.android.billingclient.api.BillingResult
import com.android.billingclient.api.PendingPurchasesParams
import com.android.billingclient.api.ProductDetails
import com.android.billingclient.api.Purchase
import com.android.billingclient.api.PurchasesUpdatedListener
import com.android.billingclient.api.QueryProductDetailsParams
import com.android.billingclient.api.QueryPurchasesParams

/**
 * The one-time "full course" purchase through Google Play Billing.
 *
 * Callbacks may arrive on any thread:
 * - [onOwned] reports whether the account owns the full course, each time Google Play answers,
 * - [onPrice] delivers the localized price once the product is known,
 * - [onMessage] carries a text for the learner (a pending payment, an error).
 */
class BillingManager(
    context: Context,
    private val onOwned: (Boolean) -> Unit,
    private val onPrice: (String) -> Unit,
    private val onMessage: (String) -> Unit,
) {
    private var product: ProductDetails? = null

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

    /** True when the Google Play purchase sheet can be opened right now. */
    val canBuy: Boolean get() = client.isReady && product != null

    /** Opens the Google Play purchase sheet; returns false when the shop is not reachable. */
    fun buy(activity: Activity): Boolean {
        val details = product
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
        val products = QueryProductDetailsParams.newBuilder()
            .setProductList(
                listOf(
                    QueryProductDetailsParams.Product.newBuilder()
                        .setProductId(FULL_COURSE)
                        .setProductType(BillingClient.ProductType.INAPP)
                        .build()
                )
            )
            .build()
        client.queryProductDetailsAsync(products) { result, response ->
            if (result.responseCode == BillingClient.BillingResponseCode.OK) {
                product = response.productDetailsList.firstOrNull()
                product?.oneTimePurchaseOfferDetails?.formattedPrice?.let(onPrice)
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
            mine.any { it.purchaseState == Purchase.PurchaseState.PENDING } ->
                onMessage("Płatność oczekuje na potwierdzenie. Kurs odblokuje się, gdy tylko zostanie zaksięgowana.")
            authoritative -> onOwned(false)
        }
    }

    companion object {
        /** The product ID that has to exist in the Play Console (a one-time, non-consumable product). */
        const val FULL_COURSE = "full_course"
    }
}
