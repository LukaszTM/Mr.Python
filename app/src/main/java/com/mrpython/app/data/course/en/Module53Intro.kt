package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

internal val module53Intro = lesson(
    "u53l0", "Introduction: debugging",
    explain(
        "Off-by-one errors",
        "`range(1, 5)` ends at 4, and the last index of a list is `len(items) - 1`. Being off by one " +
            "is the most common bug in loops – always check the first and the last value.",
        code = "print(list(range(1, 5)))\nitems = [10, 20, 30]\nprint(items[len(items) - 1])",
        output = "[1, 2, 3, 4]\n30",
    ),
    explain(
        "= or ==?",
        "`=` assigns a value, while `==` compares – in an `if` condition you need `==`. Watch your " +
            "indentation too: a `print` indented inside a loop runs on every iteration; unindented, it runs " +
            "once, after the loop. A missing indentation where one is required (e.g. under `if` or `else:`) " +
            "gives an `IndentationError`.",
        code = "total = 0\nfor x in [1, 2, 3]:\n    total += x\nprint(total == 6)",
        output = "True",
    ),
    explain(
        "List pitfalls",
        "A default list in a parameter (`items=[]`) is created once and shared by all calls – " +
            "it's safer to use `None`. Also, don't remove elements from a list you're iterating over; " +
            "loop over a `[:]` copy.",
        code = "def add(x, items=[]):\n    items.append(x)\n    return items\n\nadd(1)\nprint(add(2))",
        output = "[1, 2]",
    ),
    explain(
        "Don't shadow built-in names",
        "A variable named `list`, `sum` or `max` shadows the built-in function – calling it afterward " +
            "ends in a `TypeError`. Use your own names, e.g. `total` or `items`.",
        code = "sum = 10\ntry:\n    print(sum([1, 2]))\nexcept TypeError:\n    print(\"sum is shadowed\")",
        output = "sum is shadowed",
    ),
    explain(
        "Division and the missing return",
        "`/` gives a result with a fraction, while `//` rounds it down to a whole number – use `/` for an average. And when " +
            "a function returns `None`, check whether it's missing a `return`.",
        code = "def double(x):\n    result = x * 2\n\nprint(7 / 2, 7 // 2)\nprint(double(5))",
        output = "3.5 3\nNone",
    ),
    output(
        "print(list(range(2, 5)))",
        "[2, 3, 4]",
        "The end of the range, 5, is not included in the result.",
    ),
    choice(
        "Which line correctly checks whether x is equal to 5?",
        listOf("if x == 5:", "if x = 5:", "if x == 5"),
        0,
        "Comparison is ==, and a line with if ends with a colon; = is assignment.",
    ),
    fill(
        "Fill in the blank so the function gives its result back to the caller.",
        "def sq(x):\n    ____ x * x\n\nprint(sq(3))",
        listOf("return", "print", "pass"),
        "return",
        "Only return gives the result back; with print the function would still return None.",
    ),
)
