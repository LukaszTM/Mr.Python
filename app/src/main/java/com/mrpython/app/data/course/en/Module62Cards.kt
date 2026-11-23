package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

internal val module62Cards = listOf(
    cards(
        "u62l2",
        explain(
            "Unpacking with a star",
            "When unpacking, one variable can have a star `*`. The other variables get one element each, " +
                "and the starred one collects all the rest – always into a list, even when there's a tuple on the right.",
            code = "t = (1, 2, 3, 4)\nfirst, *rest = t\nprint(first, rest)\n*start, last = t\nprint(start, last)",
            output = "1 [2, 3, 4]\n[1, 2, 3] 4",
        ),
    ),
    cards(
        "u62l3",
        explain(
            "Symmetric difference ^",
            "`a ^ b` gives the elements that are in only one of the two sets – without the part they share. " +
                "It's the same as `(a | b) - (a & b)`.",
            code = "a = {1, 2, 3}\nb = {3, 4}\nprint(sorted(a ^ b))",
            output = "[1, 2, 4]",
        ),
    ),
    cards(
        "u62l4",
        explain(
            "update – merging dictionaries",
            "`d.update(other)` adds the pairs from another dictionary to `d`. Existing keys get new " +
                "values, and missing ones are added at the end.",
            code = "d = {\"a\": 1, \"b\": 2}\nd.update({\"b\": 9, \"c\": 3})\nprint(d)",
            output = "{'a': 1, 'b': 9, 'c': 3}",
        ),
        explain(
            "pop with a default value",
            "`d.pop(k)` raises `KeyError` when the key is missing. With a second argument, `d.pop(k, default)` " +
                "returns it instead of raising an error and removes nothing.",
            code = "d = {\"a\": 1}\nprint(d.pop(\"x\", 0), d)",
            output = "0 {'a': 1}",
        ),
        explain(
            "A tuple as a key",
            "A key can be a tuple because it's immutable (a list can't be a key). A comma creates a tuple even " +
                "without parentheses, so `d[1, 2]` is the same as `d[(1, 2)]`.",
            code = "d = {(0, 0): \"start\"}\nprint(d[0, 0])",
            output = "start",
        ),
    ),
    cards(
        "u62l7",
        explain(
            "Adding Counters",
            "You can add two `Counter`s with `+` – the counts for the same keys are summed. " +
                "Subtracting with `-` subtracts the counts and removes keys left with 0 or less. " +
                "You can also create a Counter with the counts given directly: `Counter(a=3, b=1)`.",
            code = "from collections import Counter\na = Counter(\"aab\")\nb = Counter(\"abc\")\nprint(dict(a + b))\nprint(dict(a - b))",
            output = "{'a': 3, 'b': 2, 'c': 1}\n{'a': 1}",
        ),
    ),
)
