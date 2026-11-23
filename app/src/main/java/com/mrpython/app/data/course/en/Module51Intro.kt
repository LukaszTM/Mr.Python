package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

internal val module51Intro = lesson(
    "u51l0", "Introduction: slices and copying",
    explain(
        "Slices with a step",
        "The slice `x[start:stop:step]` takes a piece of a list or string. A negative step goes from the end: " +
            "`x[::-1]` reverses the list, and `x[-3:]` gives the last three elements.",
        code = "x = [0, 1, 2, 3, 4, 5]\nprint(x[::-2])\nprint(x[-3:])",
        output = "[5, 3, 1]\n[3, 4, 5]",
    ),
    explain(
        "Start and stop going backward",
        "With a negative step, start must be greater than stop, and stop is still not included in the result. " +
            "If it's the other way around, the slice is empty.",
        code = "x = [0, 1, 2, 3, 4, 5]\nprint(x[4:1:-1])\nprint(x[1:4:-1])",
        output = "[4, 3, 2]\n[]",
    ),
    explain(
        "Slice assignment",
        "A slice of a list can be replaced with another list – even one of a different length. An empty slice, " +
            "e.g. `x[1:1]`, inserts elements, and `del x[a:b]` removes them.",
        code = "x = [1, 2, 3, 4]\nx[1:3] = [9]\nprint(x)\ndel x[:1]\nprint(x)",
        output = "[1, 9, 4]\n[9, 4]",
    ),
    explain(
        "The slice object",
        "`slice(start, stop, step)` is a slice stored in a variable – you can use it many times. " +
            "`None` means “to the end”.",
        code = "s = slice(1, None)\nprint([10, 20, 30][s])",
        output = "[20, 30]",
    ),
    explain(
        "Alias or copy?",
        "`b = a` doesn't copy the list – it's a second name for the same object. `a[:]`, `list(a)` " +
            "and `a.copy()` give you a copy, but a shallow one: the inner lists stay shared. " +
            "`copy.deepcopy()` makes a full (deep) copy.",
        code = "a = [1, 2]\nb = a\nc = a[:]\nb.append(3)\nprint(a, c)",
        output = "[1, 2, 3] [1, 2]",
    ),
    output(
        "print(\"abcde\"[::-1])",
        "edcba",
        "A step of -1 walks through the string from the end.",
    ),
    choice(
        "Which statement creates a copy of list a?",
        listOf("b = a[:]", "b = a", "b = a[0]"),
        0,
        "a[:] is a new list; b = a is just a second name for the same list.",
    ),
    tiles(
        "Store the reversed list x in the variable y.",
        listOf("y", "=", "x[::-1]"),
        listOf("x[::1]", "=="),
        "A slice with a step of -1 reverses the order.",
    ),
)
