package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

internal val module22Intro = lesson(
    "u22l0", "Introduction: enumerate and zip",
    explain(
        "enumerate – number and item",
        "In a loop you often need both the item and its number. `enumerate()` gives pairs (index, item), " +
            "so you don't have to write `range(len(items))`. The argument `start=1` starts counting at 1.",
        code = "for i, x in enumerate([\"a\", \"b\"], start=1):\n    print(i, x)",
        output = "1 a\n2 b",
    ),
    explain(
        "zip – walk in parallel",
        "`zip()` joins several lists item by item into tuples. It stops at the shortest list. " +
            "You can also quickly build a dictionary from two lists: `dict(zip(keys, values))`.",
        code = "names = [\"Anna\", \"Emma\"]\nages = [7, 9]\nfor a, b in zip(names, ages):\n    print(a, b)\nprint(dict(zip(names, ages)))",
        output = "Anna 7\nEmma 9\n{'Anna': 7, 'Emma': 9}",
    ),
    explain(
        "reversed – from the end",
        "`reversed()` lets you go through a list or a string from the last item to the first, " +
            "without changing the original.",
        code = "for x in reversed([1, 2, 3]):\n    print(x)",
        output = "3\n2\n1",
    ),
    explain(
        "sorted versus sort",
        "`sorted(items)` returns a new, sorted list, and the original stays unchanged. " +
            "`items.sort()` sorts the list in place and returns `None`. Both accept `reverse=True`.",
        code = "a = [3, 1, 2]\nprint(sorted(a))\nprint(a)\na.sort()\nprint(a)",
        output = "[1, 2, 3]\n[3, 1, 2]\n[1, 2, 3]",
    ),
    explain(
        "any and all",
        "`any()` returns `True` when at least one item is true. `all()` – when all of them are " +
            "true. They pair up nicely with a list comprehension that has a condition.",
        code = "numbers = [2, 4, 7]\nprint(any([x > 5 for x in numbers]))\nprint(all([x % 2 == 0 for x in numbers]))",
        output = "True\nFalse",
    ),
    output(
        "for i, x in enumerate([\"cat\", \"dog\"]):\n    print(i, x)",
        "0 cat\n1 dog",
        "Without start= the numbering begins at 0.",
    ),
    choice(
        "What does zip do when the lists have different lengths?",
        listOf("It stops at the shortest list", "It raises an error", "It fills the gaps with None", "It repeats the shorter list"),
        0,
        "zip makes pairs only as long as every list still has items.",
    ),
    fill(
        "Fill in the blank to check whether any number is negative.",
        "numbers = [3, -1, 5]\nprint(____([x < 0 for x in numbers]))",
        listOf("any", "all", "min"),
        "any",
        "any returns True when at least one condition is met.",
    ),
)
