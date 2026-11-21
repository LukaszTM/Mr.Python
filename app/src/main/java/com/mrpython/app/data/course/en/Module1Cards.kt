package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

internal val module1Cards = listOf(
    cards(
        "u1l1",
        explain(
            "Math operations",
            "Python calculates like a calculator: `+` adds, `-` subtracts, `*` multiplies, and `/` divides. " +
                "The result of a calculation inside `print()` shows up on the screen.",
            code = "print(10 - 3)\nprint(3 * 5)",
            output = "7\n15",
        ),
        explain(
            "Uppercase and lowercase matter",
            "Python tells lowercase and uppercase letters apart. Only `print` in lowercase works – " +
                "`Print` or `PRINT` are completely different, unknown words to Python.",
            code = "print(\"Good\")",
            output = "Good",
        ),
    ),
    cards(
        "u1l2",
        explain(
            "Double or single quotes?",
            "You can wrap a string in double quotes \" \" or single quotes ' ' – both work the same. " +
                "This is handy when the string contains an apostrophe: then we wrap it in double quotes.",
            code = "print('Anna')\nprint(\"It's OK\")",
            output = "Anna\nIt's OK",
        ),
        explain(
            "Joining and repeating strings",
            "The `+` sign joins two strings into one (with no extra space!). A string multiplied by " +
                "a number with `*` is repeated that many times.",
            code = "print(\"Py\" + \"thon\")\nprint(\"ha\" * 3)",
            output = "Python\nhahaha",
        ),
        explain(
            "Several values in print()",
            "You can give `print()` several values separated by commas. Python prints them " +
                "on one line and puts a space between them for you.",
            code = "print(\"Anna\", \"has\", 2, \"cats\")",
            output = "Anna has 2 cats",
        ),
    ),
    cards(
        "u1l3",
        explain(
            "New line: \\n",
            "Inside a string, `\\n` means: go to a new line. We write it with two characters " +
                "(a backslash and n), but Python treats it as one special character.",
            code = "print(\"Anna\\nhas a cat\")",
            output = "Anna\nhas a cat",
        ),
        explain(
            "Tab: \\t",
            "`\\t` is a tab – a wide gap that is useful for lining up text in columns. " +
                "Characters like these, written with a backslash, are called special characters.",
        ),
        explain(
            "The end and sep parameters",
            "After every `print()` Python moves to a new line – `end=\"\"` changes what " +
                "gets added at the end. `sep` sets what separates several values (a space by default).",
            code = "print(\"A\", end=\"\")\nprint(\"B\")\nprint(\"x\", \"y\", sep=\"-\")",
            output = "AB\nx-y",
        ),
    ),
)
