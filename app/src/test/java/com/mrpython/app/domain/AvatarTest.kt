package com.mrpython.app.domain

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class AvatarTest {

    @Test
    fun rivalsLookTheSameEveryTimeAndWearOnlyWhatTheirTierUnlocks() {
        val names = listOf("Ada", "Bartek", "Celina", "Dawid", "Ewa", "Filip", "Gosia", "Hubert")
        Tier.entries.forEach { tier ->
            names.forEach { name ->
                val avatar = Avatars.forRival(name, tier)
                assertEquals(avatar, Avatars.forRival(name, tier))
                assertTrue(tier >= avatar.skin.requiredTier)
                assertTrue(avatar.accessories.all { tier >= it.requiredTier })
                assertEquals(avatar.head?.slot ?: AccessorySlot.HEAD, AccessorySlot.HEAD)
            }
        }
        // Not everyone gets the same snake.
        assertTrue(names.map { Avatars.forRival(it, Tier.SENIOR).skin }.toSet().size > 1)
    }

    @Test
    fun defaultAvatarIsAllowedFromTheStart() {
        assertTrue(Avatars.isAllowed(Avatar(), Tier.INTERN))
        assertTrue(SnakeSkin.entries.count { Avatars.isUnlocked(it, Tier.INTERN) } >= 2)
    }

    @Test
    fun everyPromotionUnlocksSomething() {
        Tier.entries.drop(1).forEach { tier ->
            assertTrue(tier.title, Avatars.unlockedAt(tier).isNotEmpty())
        }
        assertEquals(listOf("Niebieski pyton", "Słuchawki", "Kubek kawy"), Avatars.unlockedAt(Tier.JUNIOR))
    }

    @Test
    fun higherTiersKeepEarlierItems() {
        assertTrue(Avatars.isUnlocked(SnakeSkin.BLUE, Tier.CTO))
        assertTrue(Avatars.isUnlocked(Accessory.CAP, Tier.SENIOR))
        assertFalse(Avatars.isUnlocked(Accessory.CROWN, Tier.ARCHITECT))
        assertTrue(SnakeSkin.entries.all { Avatars.isUnlocked(it, Tier.CTO) })
        assertTrue(Accessory.entries.all { Avatars.isUnlocked(it, Tier.CTO) })
    }

    @Test
    fun accessoriesGoIntoTheirOwnSlots() {
        val avatar = Avatar()
            .with(AccessorySlot.HEAD, Accessory.CAP)
            .with(AccessorySlot.EYES, Accessory.GLASSES)
        assertEquals(Accessory.CAP, avatar.accessory(AccessorySlot.HEAD))
        assertEquals(listOf(Accessory.CAP, Accessory.GLASSES), avatar.accessories)
        assertEquals(null, avatar.with(AccessorySlot.HEAD, null).head)
        assertTrue(AccessorySlot.entries.all { Avatars.accessories(it).isNotEmpty() })
        // Glasses can't be worn as a hat.
        assertFalse(Avatars.isAllowed(Avatar(head = Accessory.GLASSES), Tier.CTO))
    }

    @Test
    fun lockedPartsAreRejectedAndSanitized() {
        val fancy = Avatar(SnakeSkin.GOLD, head = Accessory.CROWN, eyes = Accessory.GLASSES)
        assertFalse(Avatars.isAllowed(fancy, Tier.JUNIOR))
        assertEquals(Avatar(SnakeSkin.GREEN, eyes = Accessory.GLASSES), Avatars.sanitize(fancy, Tier.JUNIOR))
        assertEquals(fancy, Avatars.sanitize(fancy, Tier.CTO))
    }
}
