package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

internal val module9Intro = lesson(
    "u9l0", "Introduction: tuples and sets",
    explain(
        "Tuple",
        "A tuple looks like a list, but it uses parentheses and can't be changed. " +
            "It's good for data that should stay fixed, like the coordinates of a point. Indexes work as in a list.",
        code = "point = (3, 4)\nprint(point[0])\nprint(len(point))",
        output = "3\n2",
    ),
    explain(
        "Unpacking",
        "You can assign the elements of a tuple to several variables at once. A tuple with one element " +
            "needs a comma: `(5,)`.",
        code = "x, y = (3, 4)\nprint(x + y)\nfor a, b in [(1, 2), (3, 4)]:\n    print(a * b)",
        output = "7\n2\n12",
    ),
    explain(
        "Set",
        "A set in curly braces `{}` stores only unique elements – duplicates disappear. " +
            "It has no indexes. `add()` adds an element, and `in` quickly checks whether an element is in it.",
        code = "s = {1, 2, 2, 3}\ns.add(4)\nprint(s)\nprint(2 in s)",
        output = "{1, 2, 3, 4}\nTrue",
    ),
    explain(
        "Removing duplicates",
        "`set()` turns a list into a set, so you can easily count the distinct elements.",
        code = "x = [1, 1, 2, 3, 3]\nprint(len(set(x)))",
        output = "3",
    ),
    explain(
        "Set operations",
        "`&` gives the intersection, `|` the union, and `-` the difference (elements of the first set " +
            "that aren't in the second).",
        code = "a = {1, 2, 3}\nb = {2, 3, 4}\nprint(a & b)\nprint(a | b)\nprint(a - b)",
        output = "{2, 3}\n{1, 2, 3, 4}\n{1}",
    ),
    choice(
        "How is a tuple different from a list?",
        listOf("A tuple can't be changed", "A tuple has no indexes", "A tuple can only hold numbers", "It isn't"),
        0,
        "A tuple is immutable.",
    ),
    output(
        "print({5, 5, 6})",
        "{5, 6}",
        "A set removes duplicates.",
    ),
    fill(
        "Fill in the blank to print the common elements.",
        "a = {1, 2}\nb = {2, 3}\nprint(a ____ b)",
        listOf("&", "|", "-"),
        "&",
        "& gives the intersection of the sets.",
    ),
)
