package com.mrpython.app.domain

/** Snake colour variants; each league tier unlocks more of them. */
enum class SnakeSkin(private val titlePl: String, val requiredTier: Tier) {
    GREEN("Zielony pyton", Tier.INTERN),
    YELLOW("Żółty pyton", Tier.INTERN),
    BLUE("Niebieski pyton", Tier.JUNIOR),
    CORAL("Wąż koralowy", Tier.MID),
    PURPLE("Fioletowa żmija", Tier.SENIOR),
    MAMBA("Czarna mamba", Tier.TECH_LEAD),
    GOLD("Złoty pyton", Tier.ARCHITECT),
    COSMIC("Kosmiczny wąż", Tier.CTO);

    /** The name in the current language. */
    val title: String get() = titlePl.t()
}

enum class AccessorySlot(private val titlePl: String) {
    HEAD("Na głowę"),
    EYES("Okulary"),
    EXTRA("Dodatek");

    /** The name in the current language. */
    val title: String get() = titlePl.t()
}

/** Things the snake can wear, one per [slot]. */
enum class Accessory(private val titlePl: String, val slot: AccessorySlot, val requiredTier: Tier) {
    CAP("Czapka z daszkiem", AccessorySlot.HEAD, Tier.INTERN),
    HEADPHONES("Słuchawki", AccessorySlot.HEAD, Tier.JUNIOR),
    BEANIE("Czapka zimowa", AccessorySlot.HEAD, Tier.MID),
    TOP_HAT("Cylinder", AccessorySlot.HEAD, Tier.TECH_LEAD),
    CROWN("Korona", AccessorySlot.HEAD, Tier.CTO),

    GLASSES("Okulary", AccessorySlot.EYES, Tier.INTERN),
    SUNGLASSES("Okulary przeciwsłoneczne", AccessorySlot.EYES, Tier.MID),
    MONOCLE("Monokl", AccessorySlot.EYES, Tier.ARCHITECT),

    COFFEE("Kubek kawy", AccessorySlot.EXTRA, Tier.JUNIOR),
    BOW_TIE("Muszka", AccessorySlot.EXTRA, Tier.SENIOR),
    TIE("Krawat", AccessorySlot.EXTRA, Tier.ARCHITECT);

    /** The name in the current language. */
    val title: String get() = titlePl.t()
}

/** The learner's avatar: a snake and at most one accessory per slot. */
data class Avatar(
    val skin: SnakeSkin = SnakeSkin.GREEN,
    val head: Accessory? = null,
    val eyes: Accessory? = null,
    val extra: Accessory? = null,
) {
    val accessories: List<Accessory> get() = listOfNotNull(head, eyes, extra)

    fun accessory(slot: AccessorySlot): Accessory? = when (slot) {
        AccessorySlot.HEAD -> head
        AccessorySlot.EYES -> eyes
        AccessorySlot.EXTRA -> extra
    }

    /** Puts [accessory] in [slot], or empties the slot when it is null. */
    fun with(slot: AccessorySlot, accessory: Accessory?): Avatar = when (slot) {
        AccessorySlot.HEAD -> copy(head = accessory)
        AccessorySlot.EYES -> copy(eyes = accessory)
        AccessorySlot.EXTRA -> copy(extra = accessory)
    }
}

object Avatars {
    /** Test builds switch this on, so every skin and accessory can be tried without promotions. */
    @Volatile
    var unlockAll: Boolean = false

    fun isUnlocked(skin: SnakeSkin, tier: Tier): Boolean = unlockAll || tier >= skin.requiredTier

    fun isUnlocked(accessory: Accessory, tier: Tier): Boolean = unlockAll || tier >= accessory.requiredTier

    fun accessories(slot: AccessorySlot): List<Accessory> = Accessory.entries.filter { it.slot == slot }

    /** Titles of everything that a promotion to [tier] unlocks. */
    fun unlockedAt(tier: Tier): List<String> =
        SnakeSkin.entries.filter { it.requiredTier == tier }.map { it.title } +
            Accessory.entries.filter { it.requiredTier == tier }.map { it.title }

    /** True when every part of [avatar] is unlocked at [tier] and sits in its own slot. */
    fun isAllowed(avatar: Avatar, tier: Tier): Boolean =
        isUnlocked(avatar.skin, tier) &&
            avatar.accessories.all { isUnlocked(it, tier) } &&
            AccessorySlot.entries.all { slot -> avatar.accessory(slot)?.slot in listOf(null, slot) }

    /** [avatar] with anything not allowed at [tier] removed. */
    fun sanitize(avatar: Avatar, tier: Tier): Avatar {
        var result = if (isUnlocked(avatar.skin, tier)) avatar else avatar.copy(skin = SnakeSkin.GREEN)
        for (slot in AccessorySlot.entries) {
            val item = result.accessory(slot) ?: continue
            if (item.slot != slot || !isUnlocked(item, tier)) result = result.with(slot, null)
        }
        return result
    }
}
