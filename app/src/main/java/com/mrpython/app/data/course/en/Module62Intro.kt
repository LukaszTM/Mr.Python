package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

internal val module62Intro = lesson(
    "u62l0", "Introduction: review week – data structures",
    explain(
        "Lists and tuples",
        "This week is a daily review of data structures. We start with lists: you can change them " +
            "(`append`, `insert`, `remove`). A tuple `( )` looks similar, but once created it's immutable.",
        code = "a = [3, 1, 2]\na.append(4)\nt = (7, 8)\nprint(a, t[0])",
        output = "[3, 1, 2, 4] 7",
    ),
    explain(
        "Sets",
        "A set `{ }` stores elements without duplicates and without order. It's great for " +
            "intersection `&`, union `|` and difference `-`.",
        code = "a = {1, 2, 3}\nb = {2, 3, 4}\nprint(a & b, a | b)",
        output = "{2, 3} {1, 2, 3, 4}",
    ),
    explain(
        "Dictionaries",
        "A dictionary maps keys to values. `d[k]` raises `KeyError` when the key is missing, while `d.get(k, 0)` " +
            "returns a default value instead.",
        code = "d = {\"a\": 1}\nd[\"b\"] = 2\nprint(d.get(\"c\", 0), len(d))",
        output = "0 2",
    ),
    explain(
        "Nesting and list comprehensions",
        "Structures can be nested: a list of lists is a table, and `m[1][0]` is row 1, column 0. " +
            "A list comprehension `[... for x in ...]` builds a new list in one line.",
        code = "m = [[1, 2], [3, 4]]\nprint(m[1][0])\nprint([x * 2 for x in m[0]])",
        output = "3\n[2, 4]",
    ),
    explain(
        "The collections module",
        "`Counter` counts occurrences, `defaultdict` creates missing values by itself, and `deque` is a fast " +
            "queue that works from both ends. Day 7 is all about them.",
        code = "from collections import Counter\nc = Counter(\"abaca\")\nprint(c[\"a\"], c.most_common(1))",
        output = "3 [('a', 3)]",
    ),
    choice(
        "Which structure automatically removes duplicates?",
        listOf("a set", "a list", "a tuple", "a dictionary with a list"),
        0,
        "A set stores each element only once.",
    ),
    output(
        "d = {\"x\": 5}\nprint(d.get(\"y\", 1) + d[\"x\"])",
        "6",
        "There's no key \"y\", so get returns 1, and 1 + 5 = 6.",
    ),
)
