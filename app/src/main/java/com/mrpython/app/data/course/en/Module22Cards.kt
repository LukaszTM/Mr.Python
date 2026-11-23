package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

internal val module22Cards = listOf(
    cards(
        "u22l1",
        explain(
            "What does enumerate give you?",
            "`enumerate()` creates tuples (index, item) – you can see them after converting with `list()`. " +
                "If you use a single variable in the loop, it gets the whole tuple. It works on strings too.",
            code = "print(list(enumerate(\"ab\")))\nfor x in enumerate([\"a\"]):\n    print(x)",
            output = "[(0, 'a'), (1, 'b')]\n(0, 'a')",
        ),
    ),
    cards(
        "u22l2",
        explain(
            "A peek inside and three lists",
            "`zip()` – just like `map()` – returns a special object, so use `list()` to peek at the pairs. " +
                "You can also join three lists or strings: you'll get triples.",
            code = "print(list(zip([1, 2], [3, 4], [5, 6])))\nprint(list(zip(\"ab\", \"cd\")))",
            output = "[(1, 3, 5), (2, 4, 6)]\n[('a', 'c'), ('b', 'd')]",
        ),
    ),
    cards(
        "u22l3",
        explain(
            "You always get a list",
            "`sorted()` accepts a string, a tuple or a dictionary and always returns a list. For a string – " +
                "a list of letters, for a dictionary – its sorted keys. Glue the letters back with `\"\".join()`.",
            code = "print(sorted(\"cat\"))\nprint(sorted({\"b\": 2, \"a\": 1}))\nprint(\"\".join(sorted(\"lemon\")))",
            output = "['a', 'c', 't']\n['a', 'b']\nelmno",
        ),
        explain(
            "reversed and list()",
            "`reversed()` also returns a special object, not a list. To see the result, use `list()`, " +
                "and for a string – `\"\".join()`. There is also the method `items.reverse()`: like `sort()`, " +
                "it reverses the list itself in place and returns `None`.",
            code = "print(list(reversed(\"abc\")))\nprint(\"\".join(reversed(\"cat\")))\na = [1, 2, 3]\na.reverse()\nprint(a)",
            output = "['c', 'b', 'a']\ntac\n[3, 2, 1]",
        ),
    ),
    cards(
        "u22l4",
        explain(
            "Without a condition",
            "`any()` and `all()` work on any values, not just `True` and `False`. " +
                "Zero, an empty string and `None` count as false, and everything else counts as true.",
            code = "print(all([\"cat\", \"\", \"dog\"]))\nprint(any([0, 0, 3]))",
            output = "False\nTrue",
        ),
        explain(
            "An empty list",
            "For an empty list `any([])` gives `False` – there is no true item at all. " +
                "But `all([])` gives `True`, because there isn't a single false one.",
            code = "print(any([]), all([]))",
            output = "False True",
        ),
    ),
    cards(
        "u22l5",
        explain(
            "Unpacking in parentheses",
            "`enumerate(zip(...))` gives pairs (number, tuple). To unpack the inner part right away, " +
                "write parentheses in the loop: `for i, (a, b) in ...`.",
            code = "for i, (a, b) in enumerate(zip(\"xy\", [1, 2])):\n    print(i, a, b)",
            output = "0 x 1\n1 y 2",
        ),
        explain(
            "Sorting tuples",
            "Tuples are compared item by item: the first one first, and the second one on a tie. " +
                "That's why `sorted()` on a list of pairs orders them by their first items.",
            code = "print(sorted([(2, \"b\"), (1, \"z\"), (2, \"a\")]))",
            output = "[(1, 'z'), (2, 'a'), (2, 'b')]",
        ),
    ),
)
