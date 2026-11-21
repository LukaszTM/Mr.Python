package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

internal val module17Intro = lesson(
    "u17l0", "Introduction: recursion",
    explain(
        "A function calls itself",
        "Recursion is when a function calls itself for a smaller problem. " +
            "Instead of a loop: \"do one step and ask yourself for the rest\".",
        code = "def countdown(n):\n    if n == 0:\n        print(\"Go!\")\n        return\n    print(n)\n    countdown(n - 1)\n\ncountdown(2)",
        output = "2\n1\nGo!",
    ),
    explain(
        "The base case",
        "Every recursion needs a base case (a stop condition) – a case where the function ends without " +
            "calling itself. Without it the calls would never end.",
        code = "def factorial(n):\n    if n <= 1:\n        return 1\n    return n * factorial(n - 1)\n\nprint(factorial(4))",
        output = "24",
    ),
    explain(
        "Fibonacci",
        "Every term of the Fibonacci sequence is the sum of the two before it – that is naturally written " +
            "with recursion. But the same values are computed many times, so it's slow for large n.",
        code = "def fib(n):\n    if n < 2:\n        return n\n    return fib(n - 1) + fib(n - 2)\n\nprint(fib(6))",
        output = "8",
    ),
    explain(
        "Strings and lists",
        "With strings and lists we often take the first element and the rest: `s[1:]`. Every call " +
            "gets a shorter string until an empty one is left.",
        code = "def reverse(s):\n    if s == \"\":\n        return \"\"\n    return reverse(s[1:]) + s[0]\n\nprint(reverse(\"cat\"))",
        output = "tac",
    ),
    explain(
        "The depth limit",
        "Python allows about 1000 nested calls – after that it raises a `RecursionError`. " +
            "When there may be a great many steps, it's better to use a regular loop.",
        code = "result = 1\nfor i in range(1, 5):\n    result *= i\nprint(result)",
        output = "24",
    ),
    output(
        "def total(n):\n    if n == 0:\n        return 0\n    return n + total(n - 1)\n\nprint(total(3))",
        "6",
        "total(3) = 3 + 2 + 1 + 0 = 6.",
    ),
    choice(
        "What is the base case in recursion?",
        listOf(
            "The case where the function ends without calling itself",
            "A break statement in a loop",
            "The first call of the function",
            "An error that stops the program",
        ),
        0,
        "The base case ends the chain of calls.",
    ),
)
