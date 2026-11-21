package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

internal val module5Cards = listOf(
    cards(
        "u5l1",
        explain(
            "Indexes from the end",
            "-1 is the last element, -2 the second-to-last, -3 the one before that, and so on. An index outside " +
                "the list (e.g. 3 in a 3-element list) ends with an `IndexError`.",
            code = "x = [7, 8, 9]\nprint(x[-2])\nprint(x[-3])",
            output = "8\n7",
        ),
        explain(
            "How is a list printed?",
            "`print()` shows a list together with its square brackets and commas. Strings inside a list " +
                "are wrapped in single quotes.",
            code = "print([1, 2])\nprint([\"Tom\", \"Ann\"])",
            output = "[1, 2]\n['Tom', 'Ann']",
        ),
    ),
    cards(
        "u5l2",
        explain(
            "Is the element in the list?",
            "The `in` operator checks whether a value is in the list and gives `True` or `False`.",
            code = "x = [\"cat\", \"dog\"]\nprint(\"cat\" in x)\nprint(3 in [1, 2])",
            output = "True\nFalse",
        ),
        explain(
            "A slice without a start or end",
            "You can leave out one number in a slice: `x[:2]` is the elements from the beginning up to index 2 " +
                "(not including it), and `x[2:]` – from index 2 to the end.",
            code = "x = [1, 2, 3, 4]\nprint(x[:2])\nprint(x[2:])",
            output = "[1, 2]\n[3, 4]",
        ),
        explain(
            "Sorting strings",
            "`sort()` orders numbers from the smallest, and strings – alphabetically.",
            code = "x = [\"owl\", \"ant\", \"bee\"]\nx.sort()\nprint(x)",
            output = "['ant', 'bee', 'owl']",
        ),
    ),
    cards(
        "u5l3",
        explain(
            "pop(i) and index()",
            "`pop(i)` removes and returns the element at index `i` (e.g. `pop(0)` – the first one). `index(v)` gives " +
                "the index of the first `v`. When the value isn't in the list, `index()` and `remove()` raise a `ValueError`.",
            code = "x = [\"a\", \"b\", \"c\"]\nprint(x.pop(0))\nprint(x.index(\"c\"))",
            output = "a\n1",
        ),
        explain(
            "sort() or sorted()?",
            "`x.sort()` changes the list itself. `sorted(x)` returns a new, sorted list, and `x` stays " +
                "unchanged. `reverse=True` sorts in descending order.",
            code = "x = [3, 1, 2]\nprint(sorted(x))\nprint(x)\nx.sort(reverse=True)\nprint(x)",
            output = "[1, 2, 3]\n[3, 1, 2]\n[3, 2, 1]",
        ),
        explain(
            "Joining lists: +",
            "The `+` sign joins two lists into a new list – first the elements of the first one, then of the second.",
            code = "a = [1, 2]\nb = [3]\nprint(a + b)",
            output = "[1, 2, 3]",
        ),
    ),
    cards(
        "u5l4",
        explain(
            "Looping over indexes",
            "`range(len(x))` gives the list's indexes in order: 0, 1, 2… That way the loop has the number `i` " +
                "and the element `x[i]` – you can replace it too.",
            code = "x = [5, 6]\nfor i in range(len(x)):\n    x[i] = x[i] * 2\nprint(x)",
            output = "[10, 12]",
        ),
        explain(
            "Finding the largest",
            "We start with the first element, then in the loop we swap it for every larger one. " +
                "After the loop the largest is left – that's how `max()` works under the hood.",
            code = "x = [4, 2, 9, 5]\nbiggest = x[0]\nfor n in x:\n    if n > biggest:\n        biggest = n\nprint(biggest)",
            output = "9",
        ),
    ),
    cards(
        "u5l5",
        explain(
            "Two names, one list",
            "`y = x` doesn't copy the list – both names point to the same list. So a change made through `y` " +
                "(e.g. `append`) is also visible in `x`.",
            code = "x = [1]\ny = x\ny.append(2)\nprint(x)",
            output = "[1, 2]",
        ),
        explain(
            "A slice with a step",
            "The third number in a slice is the step: `x[::2]` takes every second element from the beginning, " +
                "and `x[1:4:2]` – every second one from index 1 to 4 (not including 4).",
            code = "x = [\"a\", \"b\", \"c\", \"d\", \"e\"]\nprint(x[::2])\nprint(x[1:4:2])",
            output = "['a', 'c', 'e']\n['b', 'd']",
        ),
        explain(
            "An empty list and the average",
            "`[]` is an empty list: it has length 0, and in a condition it acts like `False`. You can compute " +
                "the average of numbers as `sum(x) / len(x)`.",
            code = "x = []\nprint(len(x))\nprint(bool(x))\nprint(sum([2, 4]) / len([2, 4]))",
            output = "0\nFalse\n3.0",
        ),
    ),
)
