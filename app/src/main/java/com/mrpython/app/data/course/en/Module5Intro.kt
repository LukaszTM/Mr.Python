package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

internal val module5Intro = lesson(
    "u5l0", "Introduction: lists",
    explain(
        "What is a list?",
        "A list stores many values in one variable. You write the elements inside square brackets " +
            "`[]`, separated by commas. Each element has a number (an index) counted from 0, and -1 is the last one.",
        code = "fruits = [\"apple\", \"banana\", \"kiwi\"]\nprint(fruits[0])\nprint(fruits[-1])",
        output = "apple\nkiwi",
    ),
    explain(
        "Adding and length",
        "`append()` adds an element to the end of a list, and `len()` tells you how many elements it has. " +
            "You can also replace an element using its index.",
        code = "x = [1, 2]\nx.append(3)\nx[0] = 9\nprint(x)\nprint(len(x))",
        output = "[9, 2, 3]\n3",
    ),
    explain(
        "Slices and sorting",
        "Writing `x[1:3]` cuts out the elements from index 1 to 3 (not including 3). The `sort()` method sorts " +
            "the list in place, and `sum()`, `min()` and `max()` work on the whole list at once.",
        code = "x = [5, 1, 4, 2]\nprint(x[1:3])\nx.sort()\nprint(x)\nprint(sum(x))",
        output = "[1, 4]\n[1, 2, 4, 5]\n12",
    ),
    explain(
        "Removing and inserting",
        "`pop()` removes the last element and returns it, `remove(v)` removes the first element with the value `v`, " +
            "and `insert(i, v)` puts `v` at position `i`.",
        code = "x = [\"a\", \"b\", \"c\"]\nprint(x.pop())\nx.insert(0, \"z\")\nprint(x)",
        output = "c\n['z', 'a', 'b']",
    ),
    explain(
        "Lists and loops",
        "A `for` loop goes through the elements of a list one by one. You can fill an empty list `[]` " +
            "inside a loop using `append()`.",
        code = "results = []\nfor n in [1, 2, 3]:\n    results.append(n * 10)\nprint(results)",
        output = "[10, 20, 30]",
    ),
    output(
        "x = [\"p\", \"y\", \"t\"]\nprint(x[1])",
        "y",
        "Indexes are counted from 0, so x[1] is the second element.",
    ),
    fill(
        "Add 4 to the end of the list.",
        "x = [1, 2, 3]\nx.____(4)\nprint(x)",
        listOf("append", "pop", "sort"),
        "append",
        "append() adds an element to the end of a list.",
    ),
    choice(
        "What will this code print?",
        listOf("3", "2", "4", "[1, 2, 3]"),
        0,
        "len() returns the number of elements in a list.",
        code = "print(len([7, 8, 9]))",
    ),
)
