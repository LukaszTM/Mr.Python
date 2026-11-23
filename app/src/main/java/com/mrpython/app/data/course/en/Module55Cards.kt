package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

internal val module55Cards = listOf(
    cards(
        "u55l2",
        explain(
            "The operator module",
            "The `operator` module has ready-made functions for operations: `add` (+), `sub` (-), `mul` (*) and " +
                "`truediv` (/). You can put them straight into the operations dictionary instead of writing a `lambda`.",
            code = "import operator\nops = {\"+\": operator.add, \"*\": operator.mul}\nprint(ops[\"*\"](6, 7), operator.sub(9, 4))",
            output = "42 5",
        ),
        explain(
            "get for an unknown symbol",
            "`ops[op]` raises a `KeyError` for a missing key, while `ops.get(op)` returns `None`. " +
                "As the second argument of `get` you can pass a fallback value – it can even be a function.",
            code = "ops = {\"+\": lambda a, b: a + b}\nf = ops.get(\"?\", lambda a, b: \"unknown\")\nprint(ops.get(\"%\"), f(1, 2))",
            output = "None unknown",
        ),
    ),
    cards(
        "u55l3",
        explain(
            "split with no argument",
            "`split()` with no argument cuts on any number of spaces and skips them at the edges. When the text " +
                "has no spaces, you get a single element – then `split(\"+\")` helps.",
            code = "print(\"  7   *  6 \".split())\nprint(\"2+3\".split(), \"2+3\".split(\"+\"))",
            output = "['7', '*', '6']\n['2+3'] ['2', '3']",
        ),
        explain(
            "Too few or too many parts",
            "Unpacking with `a, op, b = ...` requires exactly three elements. When there are fewer or " +
                "more, Python raises a `ValueError`.",
            code = "try:\n    a, op, b = \"4 +\".split()\nexcept ValueError:\n    print(\"bad input\")",
            output = "bad input",
        ),
    ),
    cards(
        "u55l4",
        explain(
            "except catches only its own type",
            "`except ValueError` catches only a `ValueError`. Another error, e.g. `ZeroDivisionError`, " +
                "passes through and stops the program. You can catch several types with a tuple: " +
                "`except (ValueError, ZeroDivisionError)`.",
            code = "try:\n    10 / 0\nexcept (ValueError, ZeroDivisionError) as e:\n    print(type(e).__name__)",
            output = "ZeroDivisionError",
        ),
        explain(
            "finally runs even with return",
            "The `finally` block always runs – even when there is a `return` in `try` or `except`. " +
                "It happens just before the function exits.",
            code = "def f():\n    try:\n        return \"result\"\n    finally:\n        print(\"end\")\nprint(f())",
            output = "end\nresult",
        ),
        explain(
            "Choosing in one line",
            "The expression `a if condition else b` also works outside a list comprehension, e.g. in a `return` or " +
                "an assignment: it gives `a` when the condition is true, and `b` otherwise.",
            code = "t = \"1a\"\nn = int(t) if t.isdigit() else 0\nprint(n)",
            output = "0",
        ),
    ),
)
