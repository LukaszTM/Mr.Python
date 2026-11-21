package com.mrpython.app.domain

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class PaywallTest {
    private val course = (1..7).map { u ->
        CourseUnit("u$u", "Moduł $u", "", listOf(Lesson("u${u}l1", "a", emptyList()), Lesson("u${u}l2", "b", emptyList())))
    }

    @Test
    fun firstModulesAreFree() {
        assertFalse(Paywall.isPaid(course, "u1l1"))
        assertFalse(Paywall.isPaid(course, "u5l2"))
        assertTrue(Paywall.isPaid(course, "u6l1"))
        assertTrue(Paywall.isPaid(course, "u7l2"))
        assertFalse(Paywall.isPaid(course, "nope"))
    }

    @Test
    fun countsPaidLessons() {
        assertEquals(4, Paywall.paidLessons(course))
    }
}
