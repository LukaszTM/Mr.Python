package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

internal val module59Cards = listOf(
    cards(
        "u59l2",
        explain(
            "setdefault – insert if missing",
            "`d.setdefault(k, default)` returns the value of key `k`, and if the key is missing, it first " +
                "inserts it with the default value. That's why `d.setdefault(k, []).append(x)` groups " +
                "elements into lists.",
            code = "d = {}\nd.setdefault(\"a\", []).append(1)\nd.setdefault(\"a\", []).append(2)\nprint(d)",
            output = "{'a': [1, 2]}",
        ),
        explain(
            "True is 1 as a key",
            "`True == 1` and `False == 0`, so in a dictionary they are the same key: the second entry " +
                "overwrites the value, but the key stays as it was first written. The set `{0, False}` " +
                "has just one element.",
            code = "d = {0: \"zero\", False: \"false\"}\nprint(d)\nprint(len({0, False}))",
            output = "{0: 'false'}\n1",
        ),
    ),
    cards(
        "u59l6",
        explain(
            "__bool__ and truthiness",
            "The `__bool__` method decides whether an object is truthy in `if` and `bool()`. If it's " +
                "missing, Python checks `__len__` – a length of 0 means falsy. Without both methods an " +
                "object is always truthy.",
            code = "class Box:\n    def __init__(self, n):\n        self.n = n\n    def __bool__(self):\n        return self.n > 0\nprint(bool(Box(0)), bool(Box(2)))",
            output = "False True",
        ),
    ),
    cards(
        "u59l7",
        explain(
            "filter with None",
            "Instead of calling a function, `filter(None, data)` checks the truthiness of the elements " +
                "themselves: only truthy ones stay. `0`, `\"\"`, `None` and empty lists are dropped.",
            code = "print(list(filter(None, [3, 0, \"\", \"x\", None])))",
            output = "[3, 'x']",
        ),
        explain(
            "Undoing zip with zip(*...)",
            "The star `*` unpacks a list into separate arguments, so `zip(*pairs)` is " +
                "`zip(pairs[0], pairs[1], ...)`. This way a list of pairs gives you the first and the " +
                "second elements separately.",
            code = "pairs = [(1, \"a\"), (2, \"b\"), (3, \"c\")]\nprint(list(zip(*pairs)))",
            output = "[(1, 2, 3), ('a', 'b', 'c')]",
        ),
        explain(
            "sum with a start value",
            "`sum(data, start)` starts counting from `start` instead of 0. When start is `[]`, `sum` " +
                "glues lists together, because `+` joins lists.",
            code = "print(sum([1, 2], 10))\nprint(sum([[1, 2], [3]], []))",
            output = "13\n[1, 2, 3]",
        ),
    ),
)
