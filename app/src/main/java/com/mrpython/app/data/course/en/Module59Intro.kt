package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

internal val module59Intro = lesson(
    "u59l0", "Introduction: medium challenges",
    explain(
        "What are these challenges about?",
        "Puzzles on list comprehensions, dictionaries, sorting, recursion, generators and classes " +
            "are waiting for you. Before you answer, predict the result in your head step by step – " +
            "that's the best training.",
    ),
    explain(
        "List comprehensions and dictionaries",
        "`[x for x in data if condition]` builds a list in one line. In a dictionary, `d.get(k, 0)` " +
            "returns a default value when the key is missing – perfect for counting occurrences.",
        code = "d = {}\nfor c in \"abca\":\n    d[c] = d.get(c, 0) + 1\nprint(d)\nprint([x * x for x in range(4) if x % 2])",
        output = "{'a': 2, 'b': 1, 'c': 1}\n[1, 9]",
    ),
    explain(
        "Sorting with key",
        "`sorted(data, key=function)` orders the elements by the function's result, e.g. `len`. " +
            "Sorting is stable: elements with equal keys keep their order.",
        code = "words = [\"cat\", \"a\", \"bird\", \"ox\"]\nprint(sorted(words, key=len))",
        output = "['a', 'ox', 'cat', 'bird']",
    ),
    explain(
        "Recursion",
        "A recursive function calls itself on a smaller problem. It must have a stopping " +
            "condition, otherwise it will never finish.",
        code = "def factorial(n):\n    if n <= 1:\n        return 1\n    return n * factorial(n - 1)\n\nprint(factorial(4))",
        output = "24",
    ),
    explain(
        "Generators and classes",
        "`yield` hands back values one after another. In classes, special methods such as `__str__` " +
            "or `__len__` decide how an object behaves in `print()` and `len()`.",
        code = "def g():\n    for i in range(3):\n        yield i * 10\n\nprint(list(g()))",
        output = "[0, 10, 20]",
    ),
    output(
        "print([c.upper() for c in \"ab\"])",
        "['A', 'B']",
        "The list comprehension converts each letter to uppercase.",
    ),
    output(
        "def f(n):\n    if n == 0:\n        return 0\n    return n + f(n - 1)\n\nprint(f(3))",
        "6",
        "3 + 2 + 1 + 0 = 6.",
    ),
    choice(
        "What does every recursive function need?",
        listOf("A stopping condition", "A while loop", "A global variable", "A yield statement"),
        0,
        "Without a stopping condition the function would call itself forever.",
    ),
)
