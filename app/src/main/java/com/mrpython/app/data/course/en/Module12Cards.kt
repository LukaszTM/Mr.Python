package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

internal val module12Cards = listOf(
    cards(
        "u12l1",
        explain(
            "Percentages: %",
            "The `%` format multiplies the number by 100 and adds a percent sign. The number before it sets " +
                "the decimal places: `.1%` is one place, and `.0%` is none.",
            code = "p = 0.256\nprint(f\"{p:.1%}\")\nprint(f\"{0.5:.0%}\")",
            output = "25.6%\n50%",
        ),
        explain(
            "Combining formats",
            "The letter `d` means a whole number, and `f` a number with a decimal point. Formats can be " +
                "combined: `:,.2f` gives a thousands separator and two decimal places. The braces can hold " +
                "a whole expression.",
            code = "print(f\"{1234.5:,.2f}\")\nprint(f\"{10 / 4:.1f}\")",
            output = "1,234.50\n2.5",
        ),
    ),
    cards(
        "u12l2",
        explain(
            "Width is a minimum",
            "The field width is the smallest number of characters – text that's too long won't be cut off. " +
                "With `^`, when the number of free spots is odd, the extra space goes on the right.",
            code = "print(f\"[{'python':>3}]\")\nprint(f\"[{'ab':^5}]\")",
            output = "[python]\n[ ab  ]",
        ),
        explain(
            "Alignment and precision",
            "You write the alignment and the number of decimal places together: first the alignment " +
                "character and the width, then the precision, like `>8.2f`.",
            code = "x = 3.14159\nprint(f\"[{x:>8.2f}]\")",
            output = "[    3.14]",
        ),
    ),
    cards(
        "u12l3",
        explain(
            "Numbers in the braces",
            "In `format()` you can put an argument number in the braces: `{0}` is the first, and `{1}` " +
                "the second. You can use the same number several times.",
            code = "print(\"{1}-{0}-{1}\".format(\"a\", \"b\"))",
            output = "b-a-b",
        ),
        explain(
            "Names and formats in format()",
            "The braces can hold a name, like `{name}`, and you pass the value later as `name=...`. " +
                "After a colon, the same formats work as in f-strings, like `{:.1f}` or `{:>4}`.",
            code = "print(\"{name}: {pts:.1f}\".format(name=\"Kate\", pts=4.56))",
            output = "Kate: 4.6",
        ),
        explain(
            "A longer string stays as it is",
            "`zfill()`, `ljust()`, `rjust()`, and `center()` only pad the string – when it's already longer, " +
                "they change nothing. The second argument of `rjust()` is the fill character, like a zero.",
            code = "print(\"12345\".zfill(3))\nprint(\"7\".rjust(3, \"0\"))",
            output = "12345\n007",
        ),
    ),
    cards(
        "u12l4",
        explain(
            "A special character is one character",
            "You write `\\n`, `\\t`, or `\\\"` with two characters, but in the string it's one character – " +
                "you can see that with `len()`. In a raw string `r\"...\"` the backslash and the letter are " +
                "two separate characters.",
            code = "print(len(\"a\\nb\"))\nprint(len(\"\\t\"))",
            output = "3\n1",
        ),
        explain(
            "Triple quotes",
            "A string in triple quotes `\"\"\"...\"\"\"` can run across several lines. " +
                "Inside it you can also use a regular quotation mark without a backslash.",
            code = "t = \"\"\"Amy \"has\"\na cat\"\"\"\nprint(t)",
            output = "Amy \"has\"\na cat",
        ),
        explain(
            "A trap in paths",
            "In a regular string `\"C:\\temp\"` the `\\t` part turns into a tab! Write paths " +
                "as a raw string `r\"C:\\temp\"` or double the backslashes: `\\\\`.",
            code = "print(r\"C:\\temp\")\nprint(\"C:\\\\temp\")",
            output = "C:\\temp\nC:\\temp",
        ),
    ),
)
