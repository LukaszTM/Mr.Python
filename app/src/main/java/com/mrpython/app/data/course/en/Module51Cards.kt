package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

internal val module51Cards = listOf(
    cards(
        "u51l1",
        explain(
            "A slice never raises an error",
            "An out-of-range index in a slice doesn't cause an error – Python simply clips it to the length. " +
                "Slices can also be chained: `x[:-1][::-1]` first cuts off the last element, then reverses the rest.",
            code = "print(\"abc\"[5:0:-1])\nx = [0, 1, 2, 3]\nprint(x[:-1][::-1])",
            output = "cb\n[2, 1, 0]",
        ),
    ),
    cards(
        "u51l2",
        explain(
            "A slice with a step",
            "A slice with a step, e.g. `x[::2]`, can only be replaced with a list of the same length – otherwise " +
                "you get a `ValueError`. `del x[::2]` removes every second element.",
            code = "x = [1, 2, 3, 4]\nx[::2] = [0, 0]\nprint(x)\ndel x[::2]\nprint(x)",
            output = "[0, 2, 0, 4]\n[2, 4]",
        ),
        explain(
            "slice with one argument",
            "`slice(3)` is just `stop`, which means `[:3]`. Omitted parts are given as `None`: " +
                "`slice(None, None, -1)` works like `[::-1]`.",
            code = "print([5, 6, 7, 8][slice(2)])\nprint(\"abc\"[slice(None, None, -1)])",
            output = "[5, 6]\ncba",
        ),
    ),
    cards(
        "u51l3",
        explain(
            "The same or equal?",
            "`==` checks whether the values are equal, while `is` checks whether it's exactly the same object. " +
                "Two separate `[1]` lists are equal, but they are not the same object.",
            code = "a = [1]\nb = [1]\nc = a\nprint(a == b, a is b, a is c)",
            output = "True False True",
        ),
        explain(
            "+= or a = a + ...?",
            "`a += [2]` changes the list in place, so all of its names see the change. `a = a + [2]` " +
                "creates a new list and attaches only the name `a` to it.",
            code = "a = [1]\nb = a\na += [2]\nprint(b)\na = a + [3]\nprint(b)",
            output = "[1, 2]\n[1, 2]",
        ),
        explain(
            "copy.copy and multiplying lists",
            "`copy.copy(a)` is a shallow copy, like `a[:]`. Careful: `[[0] * 2] * 2` doesn't create two lists, " +
                "just two references to one – a change in one row shows up in both.",
            code = "m = [[0] * 2] * 2\nm[0][0] = 1\nprint(m)",
            output = "[[1, 0], [1, 0]]",
        ),
    ),
)
