package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

internal val module26Intro = lesson(
    "u26l0", "Introduction: sorting",
    explain(
        "Bubble sort",
        "Sorting means putting elements in order. The simplest way: compare neighbors " +
            "and swap them when they're in the wrong order. After one pass the largest element " +
            "“floats up” to the end like a bubble.",
        code = "a = [3, 1, 2]\nfor i in range(len(a) - 1):\n    if a[i] > a[i + 1]:\n        a[i], a[i + 1] = a[i + 1], a[i]\nprint(a)",
        output = "[1, 2, 3]",
    ),
    explain(
        "Selection sort",
        "Selection sort looks for the smallest element and puts it in the first " +
            "position, then the next minimum in the second, and so on. `min()` and `index()` help with that.",
        code = "a = [4, 2, 7, 1]\nm = a.index(min(a))\na[0], a[m] = a[m], a[0]\nprint(a)",
        output = "[1, 2, 7, 4]",
    ),
    explain(
        "Insertion sort",
        "Insertion sort works like arranging cards in your hand: we take the next element " +
            "and slide it into the right place in the part that's already sorted. Bigger elements shift to the right.",
        code = "cards = [2, 5, 8]\nx = 6\ni = 0\nwhile cards[i] < x:\n    i += 1\ncards.insert(i, x)\nprint(cards)",
        output = "[2, 5, 6, 8]",
    ),
    explain(
        "sorted() with key and reverse",
        "In practice we use the built-in `sorted()` – it returns a new list and leaves the original alone. " +
            "`reverse=True` sorts in descending order, and `key=` says what to compare by, e.g. `key=len`. " +
            "The method `a.sort()` sorts the list in place and returns `None`.",
        code = "words = [\"peach\", \"kiwi\", \"banana\"]\nprint(sorted(words, key=len))\nprint(sorted([3, 1, 2], reverse=True))",
        output = "['kiwi', 'peach', 'banana']\n[3, 2, 1]",
    ),
    explain(
        "Multiple keys and dictionaries",
        "A key can return a tuple – then on a tie the second element decides. Sorting is " +
            "stable: equal elements keep their order, even with `reverse=True`. We sort a dictionary by its values using " +
            "`items()` and `key=lambda x: x[1]`.",
        code = "points = {\"Zoe\": 7, \"Tom\": 9, \"Eve\": 5}\nfor name, p in sorted(points.items(), key=lambda x: x[1]):\n    print(name, p)",
        output = "Eve 5\nZoe 7\nTom 9",
    ),
    output(
        "print(sorted([5, 1, 4], reverse=True))",
        "[5, 4, 1]",
        "reverse=True orders the elements starting from the largest.",
    ),
    choice(
        "What does the method a.sort() return?",
        listOf("None", "A new sorted list", "The smallest element", "The length of the list"),
        0,
        "sort() changes the list itself and returns nothing.",
    ),
    fill(
        "Fill in the blank to sort the words by length.",
        "words = [\"amy\", \"a\", \"kitten\"]\nprint(sorted(words, ____=len))",
        listOf("key", "by", "len"),
        "key",
        "The key parameter says what to compare the elements by.",
    ),
)
