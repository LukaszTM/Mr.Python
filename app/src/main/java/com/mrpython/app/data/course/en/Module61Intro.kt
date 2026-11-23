package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

internal val module61Intro = lesson(
    "u61l0", "Introduction: review week",
    explain(
        "Review week",
        "Over seven \"days\" you'll review the basics: `print` and variables, types, conditions, loops, " +
            "strings and formatting. One short lesson a day is enough to make the knowledge stick.",
    ),
    explain(
        "print and variables",
        "`end=` changes what `print` adds at the end (a new line by default). You can assign several " +
            "variables at once, e.g. `a, b = b, a + b` – the right side is evaluated first.",
        code = "print(\"x\", end=\"-\")\nprint(\"y\")\na, b = 1, 2\na, b = b, a + b\nprint(a, b)",
        output = "x-y\n2 3",
    ),
    explain(
        "Types and conversions",
        "`int()`, `float()` and `str()` convert between types. `\"2\" + \"3\"` joins strings, while " +
            "`int(\"2\") + 3` adds numbers. `type()` shows the type of a value.",
        code = "print(\"2\" + \"3\", int(\"2\") + 3)\nprint(type(3.5))",
        output = "23 5\n<class 'float'>",
    ),
    explain(
        "Conditions and loops",
        "`if/elif/else` picks the first true branch, and `a if condition else b` fits the choice " +
            "on one line. In loops, `continue` skips an iteration and `break` ends the loop.",
        code = "t = 25\nprint(\"warm\" if t > 20 else \"cold\")\nfor i in range(1, 4):\n    print(i * \"*\")",
        output = "warm\n*\n**\n***",
    ),
    explain(
        "Strings and formatting",
        "The slice `s[a:b]` takes the characters from `a` to `b - 1`, and `s[::-1]` reverses the string. " +
            "In f-strings, `:.2f` gives two decimal places, and `:.0%` writes a number as a percentage.",
        code = "s = \"programming\"\nprint(s[3:7], s[::-1][:3])\nx = 3.14159\nprint(f\"{x:.2f} {0.5:.0%}\")",
        output = "gram gni\n3.14 50%",
    ),
    output(
        "a, b = 3, 4\na, b = b, a\nprint(a, b)",
        "4 3",
        "Multiple assignment swaps the values.",
    ),
    output(
        "print(f\"{2 / 3:.2f}\")",
        "0.67",
        ":.2f rounds to two decimal places.",
    ),
    choice(
        "What does print(\"5\" + \"5\") print?",
        listOf("55", "10", "5 5", "TypeError"),
        0,
        "+ on strings joins them together.",
    ),
)
