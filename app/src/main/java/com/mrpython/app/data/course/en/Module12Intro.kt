package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

internal val module12Intro = lesson(
    "u12l0", "Introduction: text formatting",
    explain(
        "Numbers in f-strings",
        "After a colon inside the braces of an f-string you give a format. `:.2f` shows two decimal places " +
            "(for prices, say), `:,` separates thousands, and `:05d` pads the number with zeros to 5 digits.",
        code = "x = 3.14159\nprint(f\"{x:.2f}\")\nprint(f\"{1234567:,}\")\nprint(f\"{42:05d}\")",
        output = "3.14\n1,234,567\n00042",
    ),
    explain(
        "Alignment",
        "The number in the format is the field width. `<` aligns to the left, `>` to the right, and `^` centers. " +
            "The empty space is filled with spaces or with the character given before the alignment sign (like `*^5`). " +
            "That's how you make neat tables.",
        code = "print(f\"[{'ok':>5}]\")\nprint(f\"[{'ok':<5}]\")\nprint(f\"{'a':*^5}\")",
        output = "[   ok]\n[ok   ]\n**a**",
    ),
    explain(
        "format() and string methods",
        "The `format()` method puts the arguments into the `{}` slots in order. Strings also have ready-made " +
            "methods: `zfill()` pads with zeros, and `ljust()`, `rjust()`, and `center()` align.",
        code = "print(\"{} + {} = {}\".format(2, 3, 5))\nprint(\"7\".zfill(3))\nprint(\"ab\".ljust(4, \".\") + \"|\")",
        output = "2 + 3 = 5\n007\nab..|",
    ),
    explain(
        "Special characters",
        "A backslash creates special characters: `\\n` is a new line, `\\\"` a quotation mark inside a string, " +
            "and `\\\\` a single backslash. Triple quotes let you write a string across several lines.",
        code = "print(\"one\\ntwo\")\nprint(\"a\\\\b\")",
        output = "one\ntwo\na\\b",
    ),
    explain(
        "Raw strings",
        "The letter `r` before the quotation mark creates a raw string: backslashes in it are ordinary " +
            "characters. It's handy for Windows paths.",
        code = "print(r\"C:\\new\")\nprint(len(r\"a\\nb\"))",
        output = "C:\\new\n4",
    ),
    output(
        "print(f\"{7:.2f}\")",
        "7.00",
        "The .2f format always shows two decimal places.",
    ),
    choice(
        "Which format character aligns text to the right?",
        listOf(">", "<", "^", "|"),
        0,
        "> aligns to the right, < to the left, and ^ centers.",
    ),
    fill(
        "Fill in the blank to print: 05",
        "print(\"5\".____(2))",
        listOf("zfill", "ljust", "upper"),
        "zfill",
        "zfill() pads the string with zeros on the left.",
    ),
)
