package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

internal val module3Intro = lesson(
    "u3l0", "Introduction: operators and conditions",
    explain(
        "Math operations",
        "Besides `+`, `-`, `*`, and `/`, Python has `//` (floor division), `%` (remainder) " +
            "and `**` (power). Multiplication happens before addition, unless you use parentheses.",
        code = "print(7 // 2)\nprint(7 % 2)\nprint(2 ** 3)\nprint(2 + 3 * 4)",
        output = "3\n1\n8\n14",
    ),
    explain(
        "Comparisons",
        "A comparison gives `True` or `False`. `==` checks for equality (a single `=` is assignment!), " +
            "`!=` checks for inequality, and `<`, `>`, `<=`, `>=` compare size.",
        code = "print(3 > 2)\nprint(5 == 4)\nprint(5 != 4)",
        output = "True\nFalse\nTrue",
    ),
    explain(
        "and, or, and not",
        "We combine conditions with words: `and` – both have to be true, `or` – one is enough, " +
            "and `not` flips the result.",
        code = "print(5 > 1 and 2 > 3)\nprint(5 > 1 or 2 > 3)\nprint(not True)",
        output = "False\nTrue\nFalse",
    ),
    explain(
        "The if statement",
        "`if` runs code only when the condition is true, and `else` runs otherwise. " +
            "We put a colon after the condition and indent the code inside with 4 spaces.",
        code = "age = 12\nif age >= 18:\n    print(\"adult\")\nelse:\n    print(\"child\")",
        output = "child",
    ),
    explain(
        "Many options: elif",
        "`elif` means \"otherwise, if\". Python checks the conditions from the top " +
            "and runs only the first block that matches.",
        code = "t = 15\nif t > 25:\n    print(\"hot\")\nelif t > 10:\n    print(\"warm\")",
        output = "warm",
    ),
    output(
        "print(10 % 3)",
        "1",
        "10 = 3 · 3 + 1, so the remainder is 1.",
    ),
    choice(
        "Which operator checks whether two values are equal?",
        listOf("==", "=", "!=", "=>"),
        0,
        "== compares, while a single = assigns a value.",
    ),
    output(
        "x = 3\nif x > 5:\n    print(\"big\")\nelse:\n    print(\"small\")",
        "small",
        "3 is not greater than 5, so the else block runs.",
    ),
)
