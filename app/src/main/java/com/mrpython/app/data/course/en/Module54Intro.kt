package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

internal val module54Intro = lesson(
    "u54l0", "Introduction: good practices",
    explain(
        "Names according to PEP 8",
        "PEP 8 is Python's official style guide. Variables and functions are written in `snake_case`, " +
            "classes in `CapWords`, and constants in `UPPER_CASE`.",
        code = "MAX_ATTEMPTS = 3\nstudent_count = 25\n\nclass BankAccount:\n    pass",
    ),
    explain(
        "Docstrings",
        "A docstring is a string in triple quotes right below `def`. It describes what the function does " +
            "and ends up in the `__doc__` attribute. A regular `#` comment is not a docstring.",
        code = "def add(a, b):\n    \"\"\"Returns the sum of a and b.\"\"\"\n    return a + b\n\nprint(add.__doc__)",
        output = "Returns the sum of a and b.",
    ),
    explain(
        "Small functions and DRY",
        "DRY stands for Don't Repeat Yourself. When the same formula shows up several times, " +
            "extract it into a function. Ideally, each function does one thing.",
        code = "def with_tax(price):\n    return round(price * 1.23, 2)\n\nprint(with_tax(10), with_tax(20))",
        output = "12.3 24.6",
    ),
    explain(
        "Constants and readable conditions",
        "A number with no explanation, e.g. `0.23`, is a \"magic number\" – give it a constant's name. Simplify " +
            "conditions too: `if ready:` instead of `if ready == True:`, and `1 < x < 10` instead of two comparisons.",
        code = "TAX_RATE = 0.23\nprice = 100\nprint(price * (1 + TAX_RATE))\nprint(1 < 5 < 10)",
        output = "123.0\nTrue",
    ),
    explain(
        "Early return",
        "Handle special cases at the start of the function and exit right away with `return`. " +
            "That way the main logic doesn't hide inside deeply nested `if`s.",
        code = "def divide(a, b):\n    if b == 0:\n        return \"error\"\n    return a / b\n\nprint(divide(6, 3), divide(1, 0))",
        output = "2.0 error",
    ),
    choice(
        "According to PEP 8, how should you name a function that calculates an average?",
        listOf("calc_average", "CalcAverage", "calcAverage", "CALC_AVERAGE"),
        0,
        "Functions are written in snake_case.",
    ),
    output(
        "def f():\n    \"\"\"Greets.\"\"\"\n    return 1\n\nprint(f.__doc__)",
        "Greets.",
        "__doc__ stores the function's docstring.",
    ),
    tiles(
        "Define a PEP 8-compliant constant with the number of days in a week.",
        listOf("DAYS_PER_WEEK", "=", "7"),
        listOf("days_per_week", "=="),
        "Constants are written in uppercase letters with underscores.",
    ),
)
