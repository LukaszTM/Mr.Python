package com.mrpython.app.domain

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class AnswerCheckerTest {

    private val choice = MultipleChoice("c", "?", null, listOf("a", "b"), 1, "")
    private val blank = FillInBlank("f", "?", "____(1)", listOf("print", "say"), "print", "")
    private val tiles = ArrangeTiles(
        "t", "?", listOf("x", "=", "1", "=="), listOf("x", "=", "1"),
        alternatives = listOf(listOf("1", "=", "x")), explanation = "",
    )
    private val output = PredictOutput("o", "?", "print(1)", listOf("0\n1\n2"), "")

    @Test
    fun multipleChoice() {
        assertTrue(AnswerChecker.isCorrect(choice, Answer.Choice(1)))
        assertFalse(AnswerChecker.isCorrect(choice, Answer.Choice(0)))
        assertFalse(AnswerChecker.isCorrect(choice, Answer.Text("b")))
    }

    @Test
    fun fillInBlankComparesOptionText() {
        assertTrue(AnswerChecker.isCorrect(blank, Answer.Choice(0)))
        assertFalse(AnswerChecker.isCorrect(blank, Answer.Choice(1)))
        assertFalse(AnswerChecker.isCorrect(blank, Answer.Choice(7)))
    }

    @Test
    fun arrangeTilesAcceptsSolutionAndAlternatives() {
        assertTrue(AnswerChecker.isCorrect(tiles, Answer.Tiles(listOf("x", "=", "1"))))
        assertTrue(AnswerChecker.isCorrect(tiles, Answer.Tiles(listOf("1", "=", "x"))))
        assertFalse(AnswerChecker.isCorrect(tiles, Answer.Tiles(listOf("x", "==", "1"))))
        assertFalse(AnswerChecker.isCorrect(tiles, Answer.Tiles(listOf("x", "="))))
    }

    @Test
    fun predictOutputIgnoresWhitespaceButNotCase() {
        assertTrue(AnswerChecker.isCorrect(output, Answer.Text("0\n1\n2")))
        assertTrue(AnswerChecker.isCorrect(output, Answer.Text("  0 \r\n1\n 2\n\n")))
        assertFalse(AnswerChecker.isCorrect(output, Answer.Text("0 1 2")))
        val bool = output.copy(accepted = listOf("True"))
        assertFalse(AnswerChecker.isCorrect(bool, Answer.Text("true")))
    }

    @Test
    fun theoryCardIsAlwaysAccepted() {
        val card = Explanation("x", "Tytuł", "Tekst", code = "print(1)", output = "1")
        assertTrue(AnswerChecker.isCorrect(card, Answer.Seen))
        assertEquals("", card.explanation)
    }

    @Test
    fun correctAnswerText() {
        assertEquals("b", AnswerChecker.correctAnswerText(choice))
        assertEquals("x = 1", AnswerChecker.correctAnswerText(tiles))
    }

    private fun typo(expected: String, typed: String, code: String = ""): Boolean =
        AnswerChecker.isTypo(PredictOutput("o", "?", code, listOf(expected), ""), Answer.Text(typed))

    @Test
    fun keyboardSlipsAreForgiven() {
        assertTrue(typo("witaj", "Witaj"))
        assertTrue(typo("Witaj\n15", "witaj\n15"))
        assertTrue(typo("True", "true"))
        assertTrue(typo("To jest 'kot'", "To jest \u2019kot\u2019"))
        assertTrue(typo("a - b", "a \u2013 b"))
        assertTrue(typo("Hello World", "Hello Worle"))
        assertTrue(typo("Hello World", "Hello Wrold"))
        assertTrue(typo("raz\npython", "Raz\npyhton"))
    }

    @Test
    fun whatALessonMayTestIsNotForgiven() {
        assertFalse(typo("HELLO", "Hello", code = "print(\"hello\".upper())"))
        assertFalse(typo("Witaj", "witaj", code = "print(\"witaj\".capitalize())"))
        assertFalse(typo("True", "true", code = "print(\"ABC\".isupper())"))
        assertFalse(typo("Pytho", "Python"))
        assertFalse(typo("wynik: 12", "wynik: 13"))
        assertFalse(typo("a b c d e f", "abcdef"))
        assertFalse(typo("kot", "kat"))
        assertFalse(typo("0\n1\n2", "0 1 2"))
        assertFalse(typo("hello", "hello"))
    }
}
