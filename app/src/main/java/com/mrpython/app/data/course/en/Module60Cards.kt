package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

internal val module60Cards = listOf(
    cards(
        "u60l5",
        explain(
            "next with a default value",
            "`next(it)` on an exhausted iterator raises `StopIteration`. If you pass a second argument, " +
                "`next(it, default)` returns it instead of raising an error.",
            code = "it = iter([7])\nprint(next(it, None))\nprint(next(it, None))",
            output = "7\nNone",
        ),
    ),
    cards(
        "u60l7",
        explain(
            "Comparison chains",
            "Python chains consecutive comparisons: `a < b > c` means `a < b and b > c`. This also applies " +
                "to `==` and `in`. Parentheses change the meaning: `(4 > 2) == 2` compares `True` with the number 2.",
            code = "print(1 < 5 > 2)\nprint(4 > 2 == 2, (4 > 2) == 2)\nprint(1 == 1 in [1])",
            output = "True\nTrue False\nTrue",
        ),
        explain(
            "not is applied last",
            "`not` has lower precedence than arithmetic and comparisons, so it is evaluated at the very end. " +
                "`not 3 - 2` is `not (3 - 2)`, and `not 1 == 2` is `not (1 == 2)`.",
            code = "print(not 3 - 2)\nprint(not 1 == 2)",
            output = "False\nTrue",
        ),
    ),
)
