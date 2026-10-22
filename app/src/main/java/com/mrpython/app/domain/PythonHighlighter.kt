package com.mrpython.app.domain

enum class TokenType { KEYWORD, BUILTIN, STRING, NUMBER, COMMENT, PLAIN }

data class CodeToken(val text: String, val type: TokenType)

/** A tiny Python tokenizer, good enough to colour lesson snippets. */
object PythonHighlighter {

    private val keywords = setOf(
        "False", "None", "True", "and", "as", "break", "class", "continue", "def", "del",
        "elif", "else", "except", "finally", "for", "from", "if", "import", "in", "is",
        "lambda", "not", "or", "pass", "return", "try", "while", "with", "yield",
    )

    private val builtins = setOf(
        "print", "input", "len", "range", "int", "float", "str", "bool", "list", "dict",
        "type", "sum", "max", "min", "abs", "round", "sorted",
    )

    fun tokenize(code: String): List<CodeToken> {
        val tokens = mutableListOf<CodeToken>()
        var i = 0
        while (i < code.length) {
            val c = code[i]
            when {
                c == '#' -> {
                    val end = code.indexOf('\n', i).let { if (it < 0) code.length else it }
                    tokens += CodeToken(code.substring(i, end), TokenType.COMMENT)
                    i = end
                }
                c == '"' || c == '\'' -> {
                    var j = i + 1
                    while (j < code.length && code[j] != c && code[j] != '\n') {
                        if (code[j] == '\\') j++
                        j++
                    }
                    val end = (j + 1).coerceAtMost(code.length)
                    tokens += CodeToken(code.substring(i, end), TokenType.STRING)
                    i = end
                }
                c.isDigit() -> {
                    var j = i
                    while (j < code.length && (code[j].isDigit() || code[j] == '.')) j++
                    tokens += CodeToken(code.substring(i, j), TokenType.NUMBER)
                    i = j
                }
                c.isLetter() || c == '_' -> {
                    var j = i
                    while (j < code.length && (code[j].isLetterOrDigit() || code[j] == '_')) j++
                    val word = code.substring(i, j)
                    // f-strings: keep the prefix together with the string literal.
                    if (word == "f" && j < code.length && (code[j] == '"' || code[j] == '\'')) {
                        val rest = tokenize(code.substring(j)).first()
                        tokens += CodeToken(word + rest.text, TokenType.STRING)
                        i = j + rest.text.length
                    } else {
                        val type = when (word) {
                            in keywords -> TokenType.KEYWORD
                            in builtins -> TokenType.BUILTIN
                            else -> TokenType.PLAIN
                        }
                        tokens += CodeToken(word, type)
                        i = j
                    }
                }
                else -> {
                    tokens += CodeToken(c.toString(), TokenType.PLAIN)
                    i++
                }
            }
        }
        return tokens
    }
}
