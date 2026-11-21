package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

internal val module26Cards = listOf(
    cards(
        "u26l1",
        explain(
            "Swapping places",
            "Writing `x, y = y, x` swaps the values of two variables in one step, without a helper variable. " +
                "You can swap two list elements the same way: `a[i], a[i + 1] = a[i + 1], a[i]`.",
            code = "x, y = 4, 9\nx, y = y, x\nprint(x, y)\na = [3, 1]\na[0], a[1] = a[1], a[0]\nprint(a)",
            output = "9 4\n[1, 3]",
        ),
        explain(
            "The full sort",
            "One pass puts only one element in place at the end, so we repeat it n - 1 times " +
                "(a loop inside a loop). The last k elements are already in place – hence `range(n - 1 - k)`. " +
                "The condition `<` instead of `>` sorts in descending order.",
            code = "a = [5, 2, 4, 1]\nn = len(a)\nfor k in range(n - 1):\n    for i in range(n - 1 - k):\n        if a[i] > a[i + 1]:\n            a[i], a[i + 1] = a[i + 1], a[i]",
        ),
    ),
    cards(
        "u26l2",
        explain(
            "The full algorithm",
            "One step: for position `i` we look for the index `m` of the smallest element from `i` to the end " +
                "and swap `a[i]` with `a[m]`. The full algorithm repeats this step in a `for i in range(len(a))` loop.",
            code = "a = [3, 1, 2]\ni, m = 0, 0\nfor j in range(i + 1, len(a)):\n    if a[j] < a[m]:\n        m = j\na[i], a[m] = a[m], a[i]",
        ),
        explain(
            "The while list: loop",
            "In a condition, a non-empty list counts as true and an empty one as false. So `while a:` runs " +
                "as long as something is left in the list. This lets you pick and remove one minimum after another.",
            code = "a = [7, 3, 5]\nresult = []\nwhile a:\n    m = min(a)\n    result.append(m)\n    a.remove(m)",
        ),
    ),
    cards(
        "u26l3",
        explain(
            "Shifting to the right",
            "To insert `x = a[i]`, we walk left starting from `j = i - 1`. Every element greater than `x` " +
                "is shifted one place to the right (`a[j + 1] = a[j]`), and `x` goes into the gap: `a[j + 1] = x`.",
            code = "a = [1, 4, 2]\nx, j = a[2], 1\nwhile j >= 0 and a[j] > x:\n    a[j + 1] = a[j]\n    j -= 1\na[j + 1] = x",
        ),
        explain(
            "A safe and condition",
            "`and` checks conditions from the left and stops at the first false one. In `j >= 0 and a[j] > x` " +
                "the second condition isn't evaluated once `j` has dropped below zero – so we never go past the " +
                "start of the list.",
            code = "a = [5]\nj = -1\nprint(j >= 0 and a[j] > 3)",
            output = "False",
        ),
    ),
    cards(
        "u26l4",
        explain(
            "Uppercase first",
            "Strings are sorted by character codes, and uppercase letters have smaller codes than lowercase ones. " +
                "`key=str.lower` compares the lowercase versions without changing the strings themselves.",
            code = "names = [\"tom\", \"Eve\", \"adam\"]\nprint(sorted(names))\nprint(sorted(names, key=str.lower))",
            output = "['Eve', 'adam', 'tom']\n['adam', 'Eve', 'tom']",
        ),
    ),
    cards(
        "u26l5",
        explain(
            "A minus flips the order",
            "In a tuple key, every criterion is sorted in ascending order. To sort one of them – a number – " +
                "in descending order, we put a minus in front of it: `(-age, name)`.",
            code = "people = [(\"Zoe\", 20), (\"Tom\", 18), (\"Eve\", 20)]\nr = sorted(people, key=lambda p: (-p[1], p[0]))\nprint([p[0] for p in r])",
            output = "['Eve', 'Zoe', 'Tom']",
        ),
        explain(
            "Key: dictionary.get",
            "A dictionary's `get` method returns the value for a key, so `key=d.get` sorts the keys by " +
                "their values. We pass it without parentheses, like any function used as `key`.",
            code = "votes = {\"A\": 3, \"B\": 8, \"C\": 5}\nprint(sorted(votes, key=votes.get))",
            output = "['A', 'C', 'B']",
        ),
    ),
    cards(
        "u26l6",
        explain(
            "Numbers stored as strings",
            "Strings are compared character by character, so \"10\" comes before \"9\" (because 1 < 9). " +
                "`key=int` makes them compare as numbers.",
            code = "a = [\"9\", \"100\", \"10\"]\nprint(sorted(a))\nprint(sorted(a, key=int))",
            output = "['10', '100', '9']\n['9', '10', '100']",
        ),
    ),
)
