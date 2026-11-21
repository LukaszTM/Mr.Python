package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

internal val module13Intro = lesson(
    "u13l0", "Introduction: list comprehensions",
    explain(
        "A list in one line",
        "A list comprehension is a shortcut for a loop that builds a list. `[x * 2 for x in numbers]` means: " +
            "“for each x in numbers, take x * 2”. The result is the same as with a loop and `append()`.",
        code = "result = []\nfor x in range(4):\n    result.append(x * 2)\nprint(result)\nprint([x * 2 for x in range(4)])",
        output = "[0, 2, 4, 6]\n[0, 2, 4, 6]",
    ),
    explain(
        "Filtering: if at the end",
        "An `if` added at the end lets into the list only the elements that meet the condition.",
        code = "print([x for x in range(10) if x % 3 == 0])\npets = [\"cat\", \"bird\", \"fish\"]\nprint([s for s in pets if len(s) > 3])",
        output = "[0, 3, 6, 9]\n['bird', 'fish']",
    ),
    explain(
        "Choosing: if-else at the start",
        "When every element should go into the list, but in a different form, use `a if condition else b` " +
            "before the word `for`.",
        code = "print([0 if x < 0 else x for x in [4, -2, 3]])",
        output = "[4, 0, 3]",
    ),
    explain(
        "Nested comprehensions",
        "You can use two `for`s – the first one is the outer loop. That is how you flatten a list of lists. " +
            "A comprehension inside a comprehension, in turn, creates a list of lists, e.g. a matrix.",
        code = "m = [[1, 2], [3, 4]]\nprint([x for row in m for x in row])\nprint([[0] * 3 for _ in range(2)])",
        output = "[1, 2, 3, 4]\n[[0, 0, 0], [0, 0, 0]]",
    ),
    explain(
        "Dictionaries and sets",
        "Curly braces with a colon, `{key: value for ...}`, create a dictionary, and curly braces " +
            "without a colon create a set, in which duplicates disappear.",
        code = "print({x: x * x for x in range(3)})\nprint({x % 3 for x in range(10)})",
        output = "{0: 0, 1: 1, 2: 4}\n{0, 1, 2}",
    ),
    output(
        "print([x + 10 for x in range(3)])",
        "[10, 11, 12]",
        "Each number from range(3) increased by 10.",
    ),
    fill(
        "Complete the code to keep only numbers greater than 2.",
        "print([x for x in range(5) ____ x > 2])",
        listOf("if", "for", "else"),
        "if",
        "An if at the end filters the elements.",
    ),
    choice(
        "What does the expression {s: len(s) for s in words} create?",
        listOf("A dictionary", "A list", "A set", "A tuple"),
        0,
        "Curly braces with a colon create a dictionary.",
    ),
)
