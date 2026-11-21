package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

internal val module71Intro = lesson(
    "u71l0", "Introduction: Python idioms",
    explain(
        "EAFP or LBYL",
        "Idioms are proven, \"Pythonic\" ways of writing code. LBYL means \"look before you leap\" (`if`), " +
            "and EAFP means \"easier to ask forgiveness than permission\" (`try/except`). " +
            "Python code often goes with EAFP.",
        code = "d = {\"a\": 1}\ntry:\n    print(d[\"b\"])\nexcept KeyError:\n    print(\"no such key\")",
        output = "no such key",
    ),
    explain(
        "Unpacking and swapping",
        "You can assign values to several variables at once and swap two variables without a helper. " +
            "The star `*` collects the rest of the elements into a list.",
        code = "a, b = 1, 2\na, b = b, a\nfirst, *rest = [1, 2, 3]\nprint(a, b, first, rest)",
        output = "2 1 1 [2, 3]",
    ),
    explain(
        "enumerate and zip",
        "Instead of `range(len(...))` use `enumerate`, which gives you the number and the element, " +
            "and `zip`, which walks through several lists in parallel.",
        code = "for i, ch in enumerate(\"ab\", 1):\n    print(i, ch)\nfor n, s in zip([\"Amy\"], [5]):\n    print(n, s)",
        output = "1 a\n2 b\nAmy 5",
    ),
    explain(
        "get, setdefault and comprehensions",
        "`get` gives you a default value, `setdefault` inserts it when the key is missing, and list " +
            "and dictionary comprehensions replace many loops with `append`.",
        code = "g = {}\nfor w in [\"cat\", \"cow\", \"dog\"]:\n    g.setdefault(w[0], []).append(w)\nprint(g)\nprint({w: len(w) for w in [\"big\", \"ox\"]})",
        output = "{'c': ['cat', 'cow'], 'd': ['dog']}\n{'big': 3, 'ox': 2}",
    ),
    explain(
        "Truthiness, with and :=",
        "An empty list, `0` and `\"\"` are falsy, so we write `if not items:`. `with` closes the file by itself, " +
            "and the walrus `:=` assigns a value inside a condition.",
        code = "items = [1, 5, 9]\nif not []:\n    print(\"empty\")\nif (n := len(items)) > 2:\n    print(\"length\", n)",
        output = "empty\nlength 3",
    ),
    output(
        "x, y = 3, 7\nx, y = y, x\nprint(x, y)",
        "7 3",
        "Writing x, y = y, x swaps the two values.",
    ),
    choice(
        "What does enumerate(\"ab\") give you in a for loop?",
        listOf("(number, element) pairs", "only the numbers", "only the elements", "(element, length) pairs"),
        0,
        "enumerate attaches a number to every element.",
    ),
)
