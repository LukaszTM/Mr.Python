package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

internal val module67Intro = lesson(
    "u67l0", "Introduction: review week – everything at once",
    explain(
        "Putting the blocks together",
        "This week every day is a small, real program: text analysis, a gradebook, a store. " +
            "In them you combine strings, dictionaries, functions and modules. Read the code step by step.",
        code = "from collections import Counter\nc = Counter(\"day by day\".split())\nprint(c.most_common(1))",
        output = "[('day', 2)]",
    ),
    explain(
        "A dictionary of lists",
        "A dictionary whose values are lists is a good model of a gradebook. `items()` gives key–value " +
            "pairs, and `:.1f` in an f-string formats the average.",
        code = "grades = {\"Amy\": [5, 4], \"Tom\": [3]}\nfor name, g in grades.items():\n    print(f\"{name}: {sum(g) / len(g):.1f}\")",
        output = "Amy: 4.5\nTom: 3.0",
    ),
    explain(
        "Money and Decimal",
        "`float` numbers can be inexact, so for money use `Decimal` created from a string, or " +
            "round the result with `round`.",
        code = "from decimal import Decimal\nprint(0.1 + 0.2)\nprint(Decimal(\"0.1\") + Decimal(\"0.2\"))",
        output = "0.30000000000000004\n0.3",
    ),
    explain(
        "Generators",
        "A function with `yield` is a generator – it hands out values one at a time, on demand. `next(gen, None)` " +
            "gets the next one, or returns `None` when they run out.",
        code = "def evens(n):\n    for i in range(n):\n        if i % 2 == 0:\n            yield i\nprint(list(evens(7)))",
        output = "[0, 2, 4, 6]",
    ),
    explain(
        "Programmer's tools",
        "Decorators, `with` context managers and simple tests make code more reliable. " +
            "For example, `suppress` silently ignores the given exception.",
        code = "from contextlib import suppress\nwith suppress(KeyError):\n    print({}[\"x\"])\nprint(\"moving on\")",
        output = "moving on",
    ),
    output(
        "g = (x * 2 for x in range(4))\nprint(sum(g))",
        "12",
        "The generator yields 0, 2, 4, 6, and their sum is 12.",
    ),
    choice(
        "What is best for exact calculations on amounts of money?",
        listOf("Decimal", "float", "str", "bool"),
        0,
        "Decimal works on decimal numbers without float's rounding errors.",
    ),
)
