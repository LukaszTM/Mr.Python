package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

internal val module54Cards = listOf(
    cards(
        "u54l1",
        explain(
            "Methods and attributes",
            "Methods in a class are functions too, so we write their names in `snake_case`, and the same goes " +
                "for object attributes. A constant in a class, e.g. `MAX_LIVES`, stays in uppercase.",
            code = "class Game:\n    MAX_LIVES = 3\n    def lives_after_hit(self):\n        return Game.MAX_LIVES - 1\n\nprint(Game().lives_after_hit())",
            output = "2",
        ),
        explain(
            "Long lines in brackets",
            "PEP 8 recommends short lines. Inside `( )`, `[ ]` or `{ }` you can move to a new " +
                "line, and Python will treat the whole thing as one expression.",
            code = "total = sum(x for x in [1, 2, 3]\n            if x > 1)\nprint(total)",
            output = "5",
        ),
    ),
    cards(
        "u54l2",
        explain(
            "The docstring must come first",
            "Only a string that is the first statement in the function body is a docstring. A string after " +
                "other code or a `#` comment doesn't count – then `__doc__` is `None`.",
            code = "def f():\n    x = 1\n    \"\"\"Description.\"\"\"\n    return x\n\nprint(f.__doc__)",
            output = "None",
        ),
        explain(
            "Class and method docstrings",
            "A class and each of its methods can have a docstring too – we write it right below `class` or `def`. " +
                "You read it with `Class.__doc__` or `Class.method.__doc__`.",
            code = "class Account:\n    \"\"\"A bank account.\"\"\"\n    def deposit(self):\n        \"\"\"Adds an amount.\"\"\"\n\nprint(Account.__doc__, Account.deposit.__doc__)",
            output = "A bank account. Adds an amount.",
        ),
        explain(
            "A longer docstring",
            "Triple quotes let you write across several lines. The convention: the first line is a short " +
                "summary, then a blank line and the details. You can get the first line with `splitlines()[0]`.",
            code = "def f():\n    \"\"\"Short.\n\n    Longer.\"\"\"\n\nprint(f.__doc__.splitlines()[0])",
            output = "Short.",
        ),
    ),
    cards(
        "u54l4",
        explain(
            "in instead of many ors",
            "Instead of `x == \"a\" or x == \"b\"` write `x in (\"a\", \"b\")`. Careful: `x == \"a\" or \"b\"` " +
                "is always true, because `\"b\"` on its own is a non-empty, and so truthy, string.",
            code = "color = \"green\"\nprint(color in (\"red\", \"green\"))",
            output = "True",
        ),
        explain(
            "An empty list is falsy",
            "An empty list, an empty string and 0 are falsy, so instead of `if len(items) == 0:` you can just write " +
                "`if not items:`. And `not (x < 0 or x > 10)` is more readable as `0 <= x <= 10`.",
            code = "items = []\nif not items:\n    print(\"empty\")",
            output = "empty",
        ),
    ),
    cards(
        "u54l5",
        explain(
            "Code after return",
            "Once `return` runs, the function ends immediately – statements written after it in the same " +
                "block will never run.",
            code = "def f():\n    return \"zero\"\n    print(\"end\")\n\nprint(f())",
            output = "zero",
        ),
    ),
)
