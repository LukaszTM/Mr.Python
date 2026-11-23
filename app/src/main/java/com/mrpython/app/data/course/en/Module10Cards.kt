package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

internal val module10Cards = listOf(
    cards(
        "u10l1",
        explain(
            "SyntaxError – badly written code",
            "A syntax error is code that's written incorrectly, like a missing colon after `if` or an " +
                "unclosed parenthesis. Python detects it before running the program, so not a single line runs.",
        ),
        explain(
            "NameError – unknown name",
            "A `NameError` appears when you use a name Python doesn't know: a variable that was never " +
                "created, or a function with a typo, like `pirnt(\"hi\")`.",
        ),
        explain(
            "TypeError or ValueError?",
            "`TypeError` means the wrong type, like `\"a\" + 1`, `len(5)` (a number has no length), or a string " +
                "as a list index. `ValueError` means the right type but a bad value: `int(\"3.5\")` or " +
                "`int(\"\")` – `int()` only converts a string that holds a whole number.",
        ),
    ),
    cards(
        "u10l2",
        explain(
            "A bare except:",
            "`except:` without an error name catches every error. When you give a name, like " +
                "`except ValueError:`, other kinds of errors won't be caught and will stop the program.",
            code = "try:\n    print(1 / 0)\nexcept:\n    print(\"some error\")",
            output = "some error",
        ),
        explain(
            "Several except blocks",
            "One `try` can be followed by several `except` blocks. Python picks the one that matches the " +
                "kind of error and runs only that one.",
            code = "try:\n    \"a\" + 1\nexcept ValueError:\n    print(\"V\")\nexcept TypeError:\n    print(\"T\")",
            output = "T",
        ),
    ),
    cards(
        "u10l3",
        explain(
            "Several errors in one except",
            "In parentheses after `except` you can list several kinds of errors, like " +
                "`except (ValueError, TypeError):` – such a block catches any of them.",
            code = "try:\n    [1][5]\nexcept (IndexError, KeyError):\n    print(\"missing\")",
            output = "missing",
        ),
        explain(
            "finally without except",
            "A `try` can have just a `finally`, with no `except`. `finally` runs even when the function " +
                "ends with `return` – right before leaving it.",
            code = "def f():\n    try:\n        return 1\n    finally:\n        print(\"cleaning up\")\nprint(f())",
            output = "cleaning up\n1",
        ),
        explain(
            "raise in a function",
            "An error raised with `raise` inside a function \"flies out\" to the place where the function " +
                "was called. You can catch it there by wrapping the call in a `try` block.",
            code = "def f(x):\n    if x < 0: raise ValueError(\"negative\")\ntry:\n    f(-1)\nexcept ValueError as e:\n    print(e)",
            output = "negative",
        ),
    ),
    cards(
        "u10l4",
        explain(
            "Order of the blocks",
            "We always write the blocks in this order: `try`, `except`, `else`, and `finally` at the end. " +
                "When there's no error, `try`, `else`, and `finally` run.",
            code = "try: x = 1\nexcept: print(\"error\")\nelse: print(\"ok\")\nfinally: print(\"done\")",
            output = "ok\ndone",
        ),
    ),
)
