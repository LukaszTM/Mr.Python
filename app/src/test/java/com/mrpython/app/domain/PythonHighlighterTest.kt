package com.mrpython.app.domain

import org.junit.Assert.assertEquals
import org.junit.Test

class PythonHighlighterTest {

    @Test
    fun tokensCoverTheWholeSource() {
        val code = "def f(x):\n    # komentarz\n    return f\"{x}\" + 'a\\'b' * 2.5"
        assertEquals(code, PythonHighlighter.tokenize(code).joinToString("") { it.text })
    }

    @Test
    fun classifiesTokens() {
        val tokens = PythonHighlighter.tokenize("for i in range(3): print(\"hi\") # x")
            .filter { it.text.isNotBlank() }
            .associate { it.text to it.type }
        assertEquals(TokenType.KEYWORD, tokens["for"])
        assertEquals(TokenType.BUILTIN, tokens["range"])
        assertEquals(TokenType.NUMBER, tokens["3"])
        assertEquals(TokenType.STRING, tokens["\"hi\""])
        assertEquals(TokenType.COMMENT, tokens["# x"])
        assertEquals(TokenType.PLAIN, tokens["i"])
    }

    @Test
    fun fStringPrefixStaysWithString() {
        val tokens = PythonHighlighter.tokenize("f\"{a}\"")
        assertEquals(listOf(CodeToken("f\"{a}\"", TokenType.STRING)), tokens)
    }
}
