package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

internal val module17Cards = listOf(
    cards(
        "u17l1",
        explain(
            "Code after the call",
            "Statements after a recursive call run only once that call has finished – " +
                "on the way back. That's why a `print` after the call prints the numbers from the smallest.",
            code = "def f(n):\n    if n == 0:\n        return\n    f(n - 1)\n    print(n)\nf(2)",
            output = "1\n2",
        ),
        explain(
            "A bare return",
            "`return` without a value simply ends the function. A base case often looks like this. " +
                "Every call has to get closer to that case – otherwise you get a `RecursionError`.",
            code = "def f(n):\n    if n > 2:\n        return\n    print(n)\n    f(n + 1)\nf(1)",
            output = "1\n2",
        ),
    ),
    cards(
        "u17l2",
        explain(
            "The digits of a number",
            "`n % 10` is the last digit of a number, and `n // 10` is the number without its last digit. " +
                "Recursion can cut digits off this way until one is left (`n < 10`).",
            code = "n = 507\nprint(n % 10, n // 10)",
            output = "7 50",
        ),
    ),
    cards(
        "u17l3",
        explain(
            "An empty list is falsy",
            "An empty list `[]`, just like an empty string, is \"falsy\". That's why we often write " +
                "the base case in a short form: `if not items:`.",
            code = "print(not [], not [1])\nprint(not \"\")",
            output = "True False\nTrue",
        ),
        explain(
            "The middle and joining lists",
            "`s[1:-1]` is the string without its first and last character – handy for palindromes. " +
                "We join lists with `+`, so a single element goes in brackets: `[l[0]] + rest`.",
            code = "print(\"kayak\"[1:-1])\nprint([1] + [2, 3])",
            output = "aya\n[1, 2, 3]",
        ),
    ),
    cards(
        "u17l4",
        explain(
            "Fibonacci in a loop",
            "`a, b = b, a + b` first computes both values on the right and then assigns them at once. " +
                "This way the loop moves along the Fibonacci sequence without repeating calculations.",
            code = "a, b = 0, 1\nfor _ in range(5):\n    a, b = b, a + b\nprint(a)",
            output = "5",
        ),
        explain(
            "The limit in the sys module",
            "The recursion depth limit is given by the function `getrecursionlimit()` from the `sys` module. " +
                "Exceeding it raises a `RecursionError`, which you can catch with `try` and `except`.",
            code = "import sys\nprint(sys.getrecursionlimit())",
            output = "1000",
        ),
    ),
)
