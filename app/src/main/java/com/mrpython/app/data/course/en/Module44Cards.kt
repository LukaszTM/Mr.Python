package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

internal val module44Cards = listOf(
    cards(
        "u44l1",
        explain(
            "Tuples and sets",
            "`tuple[str, int]` describes each position of the tuple in order: here a string, then an " +
                "integer. `set[int]` is a set of integers.",
            code = "pair: tuple[str, int] = (\"x\", 7)\ntags: set[int] = {3, 1}\nprint(pair[1] + 1, sorted(tags))",
            output = "8 [1, 3]",
        ),
        explain(
            "A function with no result: -> None",
            "`-> None` means the function returns nothing – it just does something, like printing. " +
                "The result of calling it is `None`.",
            code = "def info() -> None:\n    print(\"hi\")\nx = info()\nprint(x)",
            output = "hi\nNone",
        ),
    ),
    cards(
        "u44l2",
        explain(
            "Several types at once",
            "The bar `|` in a hint means \"or\": `int | str` is an integer or a string. `X | None` " +
                "is just a special case of this notation.",
            code = "def text(x: int | str) -> str:\n    return str(x) * 2\nprint(text(4), text(\"a\"))",
            output = "44 aa",
        ),
        explain(
            "Checking for None",
            "When a value can be `None`, we check it with `is None` before using it. An optional " +
                "parameter often defaults to `None`.",
            code = "def age(x: int | None = None) -> str:\n    if x is None:\n        return \"unknown\"\n    return str(x)\nprint(age(), age(30))",
            output = "unknown 30",
        ),
    ),
    cards(
        "u44l3",
        explain(
            "The __annotations__ dictionary",
            "The keys are the parameter names and `\"return\"`, and the values are the types themselves. " +
                "`.__name__` gives the type's name as a string. Parameters without a hint aren't in " +
                "the dictionary.",
            code = "def f(a, b: int) -> str:\n    pass\nprint(list(f.__annotations__))\nprint(f.__annotations__[\"return\"].__name__)",
            output = "['b', 'return']\nstr",
        ),
    ),
    cards(
        "u44l4",
        explain(
            "A hint with a default value",
            "We combine a hint and a default value like this: first the type after the colon, then `=` " +
                "and the value.",
            code = "def repeat(s: str, n: int = 2) -> str:\n    return s * n\nprint(repeat(\"ha\"))",
            output = "haha",
        ),
        explain(
            "Nested types",
            "Types can be nested: `dict[str, list[int]]` is a dictionary whose values are lists of " +
                "integers, and `list[tuple[str, int]]` is a list of tuples.",
            code = "m: dict[str, list[int]] = {\"a\": [1, 2]}\np: list[tuple[str, int]] = [(\"x\", 1)]\nprint(sum(m[\"a\"]), p[0][0])",
            output = "3 x",
        ),
    ),
)
