package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

internal val module24Intro = lesson(
    "u24l0", "Introduction: built-in functions",
    explain(
        "min and max",
        "`min()` and `max()` accept several arguments or a single list. With `key` they compare the result " +
            "of a function, and `default` gives the result for an empty list (without it an empty list is an error).",
        code = "print(max([4, 2, 8]))\nprint(min([\"apple\", \"fig\"], key=len))\nprint(max([], default=0))",
        output = "8\nfig\n0",
    ),
    explain(
        "Number functions",
        "`sum()` adds things up, `abs()` gives the absolute value, `round(x, 2)` rounds to 2 decimal places, " +
            "and `divmod(a, b)` returns the whole quotient and the remainder at once.",
        code = "print(sum([1, 2, 3]))\nprint(abs(-7))\nprint(round(3.14159, 2))\nprint(divmod(17, 5))",
        output = "6\n7\n3.14\n(3, 2)",
    ),
    explain(
        "isinstance – what type is it?",
        "`isinstance(x, int)` checks whether a value is of a given type. You can pass several types at once " +
            "in a tuple: `(int, float)`. It comes in handy when the data is mixed.",
        code = "print(isinstance(5, int))\nprint(isinstance(\"5\", int))\nprint(isinstance(2.5, (int, float)))",
        output = "True\nFalse\nTrue",
    ),
    explain(
        "chr and ord",
        "Every character has its own number (code). `ord(\"A\")` returns the code of a character, and `chr(66)` – " +
            "the character with a given code. Consecutive letters have consecutive codes.",
        code = "print(ord(\"A\"))\nprint(chr(66))\nprint(chr(ord(\"a\") + 1))",
        output = "65\nB\nb",
    ),
    explain(
        "Type conversions",
        "`int()`, `float()`, `str()`, `list()` and `tuple()` convert values to another type. " +
            "Careful: `int(3.9)` cuts off the fractional part, it doesn't round.",
        code = "print(int(\"42\") + 1)\nprint(str(42) + \"1\")\nprint(int(3.9))",
        output = "43\n421\n3",
    ),
    output(
        "print(min(4, 2, 8))\nprint(abs(-3))",
        "2\n3",
        "min picks the smallest number, abs removes the minus sign.",
    ),
    choice(
        "What does isinstance(x, str) check?",
        listOf("Whether x is a string", "It converts x to a string", "Whether x is empty", "The length of x"),
        0,
        "isinstance checks the type of a value.",
    ),
    fill(
        "Fill in the blank to print the code of the character \"a\".",
        "print(____(\"a\"))",
        listOf("ord", "chr", "int"),
        "ord",
        "ord turns a character into its code.",
    ),
)
