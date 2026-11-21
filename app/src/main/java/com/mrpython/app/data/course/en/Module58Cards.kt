package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

internal val module58Cards = listOf(
    cards(
        "u58l1",
        explain(
            "Splitting with a limit",
            "`split(sep, n)` splits a string at most `n` times, counting from the left. The rest of " +
                "the string stays in one piece as the last element.",
            code = "print(\"2026-10-22\".split(\"-\", 1))",
            output = "['2026', '10-22']",
        ),
        explain(
            "Comparing strings",
            "Strings are compared character by character, like words in a dictionary: the first " +
                "different letter decides. Careful: uppercase letters are “smaller” than lowercase " +
                "ones, so `\"Z\" < \"a\"` is `True`.",
            code = "print(\"cat\" < \"cave\")\nprint(\"Zebra\" < \"apple\")",
            output = "True\nTrue",
        ),
    ),
    cards(
        "u58l2",
        explain(
            "Exponentiation goes right to left",
            "Most operations are evaluated from the left, but `**` goes from the right. `2 ** 2 ** 3` is " +
                "`2 ** (2 ** 3)`, which is `2 ** 8`. Parentheses change the order.",
            code = "print(2 ** 2 ** 3)\nprint((2 ** 2) ** 3)",
            output = "256\n64",
        ),
        explain(
            "The 1e3 notation and negative powers",
            "`1e3` is short for 1 · 10³, which is 1000 – this notation always gives a `float`, so you " +
                "see `.0`. A negative exponent means a fraction: `2 ** -1` is 1/2.",
            code = "print(1e3)\nprint(2.5e2)\nprint(2 ** -1)",
            output = "1000.0\n250.0\n0.5",
        ),
    ),
)
