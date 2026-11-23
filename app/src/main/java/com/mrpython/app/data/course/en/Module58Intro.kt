package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

internal val module58Intro = lesson(
    "u58l0", "Introduction: easy challenges",
    explain(
        "What are the challenges about?",
        "This module is a set of short puzzles on the basics: strings, numbers, lists, loops, " +
            "conditions and functions. There's no new theory – read the code line by line and " +
            "track how the variables change.",
        code = "x = 5\nx += x * 2\nprint(x)",
        output = "15",
    ),
    explain(
        "Strings and lists",
        "The slice `s[1:-1]` skips the first and the last character. `append` adds a single element – " +
            "even a whole list – while `extend` adds each element separately.",
        code = "a = [1]\na.append([2, 3])\nprint(len(a))\nprint(\"Python\"[1:-1])",
        output = "2\nytho",
    ),
    explain(
        "Loops: break and continue",
        "`break` stops the loop, and `continue` jumps to the next iteration. A loop's `else` " +
            "block runs only if there was no `break`.",
        code = "for i in range(5):\n    if i == 1:\n        continue\n    if i == 3:\n        break\n    print(i)",
        output = "0\n2",
    ),
    explain(
        "Conditions and truthiness",
        "`0`, an empty string and an empty list are falsy; almost everything else is truthy. " +
            "In `if/elif` only the first matching branch runs. `x or y` returns `x` if it is truthy, " +
            "otherwise `y`; `x and y` returns `x` if it is falsy, otherwise `y`.",
        code = "x = 8\nif x > 10:\n    print(\"a\")\nelif x > 5:\n    print(\"b\")\nprint(bool(0), bool([0]))\nprint(0 or \"none\", 3 and 5)",
        output = "b\nFalse True\nnone 5",
    ),
    explain(
        "Functions",
        "A default argument (e.g. `b=2`) is used when you don't pass one. A function without `return` " +
            "returns `None`, and a list passed to a function can be changed by it.",
        code = "def f(a, b=2):\n    return a * b\n\nprint(f(3), f(3, 3))",
        output = "6 9",
    ),
    output(
        "print(\"cat\" * 2 + \"!\")",
        "catcat!",
        "Multiplying a string repeats it, and + sticks the exclamation mark on the end.",
    ),
    output(
        "s = 0\nfor i in range(4):\n    if i == 2:\n        break\n    s += i\nprint(s)",
        "1",
        "The loop adds 0 and 1, and stops at 2.",
    ),
    choice(
        "What does a function without a return statement return?",
        listOf("None", "0", "False", "An empty string"),
        0,
        "Without return, a function always returns None.",
    ),
)
