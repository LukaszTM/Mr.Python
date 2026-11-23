package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

internal val module63Cards = listOf(
    cards(
        "u63l3",
        explain(
            "** inside a dictionary",
            "Inside braces `{ }`, writing `**d` pastes in all the pairs from the dictionary `d`. That's how you " +
                "build a new dictionary with extra keys; a key given later overwrites an earlier one.",
            code = "d = {\"a\": 1, \"b\": 2}\nprint({**d, \"c\": 3})\nprint({**d, \"a\": 0})",
            output = "{'a': 1, 'b': 2, 'c': 3}\n{'a': 0, 'b': 2}",
        ),
    ),
    cards(
        "u63l4",
        explain(
            "map with two lists",
            "When a function has two parameters, give `map` two lists: it gets one element from each, " +
                "pair by pair. Like `zip`, it stops at the shortest list.",
            code = "add = lambda a, b: a + b\nprint(list(map(add, [1, 2], [10, 20])))",
            output = "[11, 22]",
        ),
    ),
    cards(
        "u63l6",
        explain(
            "A semicolon on one line",
            "A semicolon `;` lets you write several short statements on one line – `c(); c()` is two " +
                "calls in a row. It works, but it's usually more readable to write each statement separately.",
            code = "x = 1; y = 2\nprint(x + y); print(\"done\")",
            output = "3\ndone",
        ),
    ),
)
