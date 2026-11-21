package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

internal val module9Cards = listOf(
    cards(
        "u9l1",
        explain(
            "Joining and slicing tuples",
            "You join tuples with `+`, and `*` repeats their elements – the result is always a new tuple. " +
                "A slice of a tuple is a tuple too, and `in` checks whether an element is in the tuple.",
            code = "t = (1, 2) + (3,)\nprint(t)\nprint(t[1:])\nprint(3 in t)",
            output = "(1, 2, 3)\n(2, 3)\nTrue",
        ),
        explain(
            "How many variables?",
            "When unpacking, the number of variables must match the number of elements – otherwise you get " +
                "an error. You can unpack a string too: each variable gets one character.",
            code = "a, b = \"ok\"\nprint(b)\nx, y, z = (1, 2, 3)\nprint(z)",
            output = "k\n3",
        ),
        explain(
            "Parentheses don't make a tuple",
            "Parentheses alone don't create a tuple: `(5)` is just the number 5. The comma makes the tuple: " +
                "`(5,)`. The `tuple()` function turns a list into a tuple.",
            code = "print((5) + 1)\nprint(tuple([1, 2]))",
            output = "6\n(1, 2)",
        ),
    ),
    cards(
        "u9l2",
        explain(
            "Creating a set: set()",
            "An empty `{}` is a dictionary, so you create an empty set with `set()`. `set()` on a list or " +
                "a string keeps only the distinct elements.",
            code = "s = set()\ns.add(4)\nprint(s)\nprint(len(set(\"abba\")))",
            output = "{4}\n2",
        ),
        explain(
            "A set has no order",
            "The elements of a set have no positions, so `s[0]` ends in an error. You can loop over a set, " +
                "and `sorted(s)` returns a sorted list.",
            code = "s = {3, 1, 2}\nprint(sorted(s))",
            output = "[1, 2, 3]",
        ),
        explain(
            "Removing from a set",
            "`remove(x)` removes the element `x` from the set.",
            code = "s = {1, 2, 3}\ns.remove(2)\nprint(s)",
            output = "{1, 3}",
        ),
    ),
    cards(
        "u9l3",
        explain(
            "Subset: <=",
            "`a <= b` checks whether every element of set `a` is also in `b`, that is, whether `a` is a subset of `b`.",
            code = "a = {1, 2}\nb = {1, 2, 3}\nprint(a <= b)\nprint(b <= a)",
            output = "True\nFalse",
        ),
        explain(
            "Empty result: set()",
            "When an operation leaves no elements, Python prints the empty set as `set()`. " +
                "You can't join sets with `+` – use `|` for that, even several times in a row.",
            code = "print({1, 2} & {3})\nprint({1} | {2} | {3})",
            output = "set()\n{1, 2, 3}",
        ),
    ),
    cards(
        "u9l4",
        explain(
            "A tuple turned into a list",
            "You can't change a tuple, but `list(t)` makes a list out of it, and a list can be changed. " +
                "Tuples have a `count()` method, and `==` compares them element by element.",
            code = "t = (1, 2, 1)\nprint(t.count(1))\nx = list(t)\nx.append(5)\nprint(x)\nprint((1, 2) == (1, 2))",
            output = "2\n[1, 2, 1, 5]\nTrue",
        ),
    ),
)
