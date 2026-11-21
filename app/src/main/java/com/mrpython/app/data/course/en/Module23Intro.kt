package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

internal val module23Intro = lesson(
    "u23l0", "Introduction: generators",
    explain(
        "iter and next",
        "Under the hood, a `for` loop uses an iterator – an object that hands out items one after another. " +
            "`iter(items)` creates an iterator, and `next(it)` takes the next item from it.",
        code = "it = iter([10, 20, 30])\nprint(next(it))\nprint(next(it))",
        output = "10\n20",
    ),
    explain(
        "The end: StopIteration",
        "When the items run out, `next()` raises the `StopIteration` exception. You can go through an " +
            "iterator only once – used items don't come back.",
        code = "it = iter([1, 2])\nprint(list(it))\nprint(list(it))",
        output = "[1, 2]\n[]",
    ),
    explain(
        "A function with yield",
        "A function with `yield` is a generator. `yield` hands out a value and pauses the function – at " +
            "the next `next()` the function carries on from that spot.",
        code = "def squares(n):\n    for i in range(n):\n        yield i * i\n\nprint(list(squares(4)))",
        output = "[0, 1, 4, 9]",
    ),
    explain(
        "Generator expression",
        "Written like a list comprehension but in round brackets, it creates a generator. It doesn't " +
            "build the whole list in memory – it computes values on demand. You can pass it straight " +
            "to `sum()` or `max()`.",
        code = "print(sum(x * x for x in range(4)))",
        output = "14",
    ),
    explain(
        "Lazy and infinite",
        "A generator computes the next value only when you ask for it. That's why it can go on forever " +
            "(`while True`) – you just need to stop the loop in time with `break`.",
        code = "def naturals():\n    n = 1\n    while True:\n        yield n\n        n += 1\n\ng = naturals()\nprint([next(g) for _ in range(3)])",
        output = "[1, 2, 3]",
    ),
    output(
        "def gen():\n    yield \"a\"\n    yield \"b\"\n\nfor x in gen():\n    print(x)",
        "a\nb",
        "The for loop takes the values from yield one by one.",
    ),
    choice(
        "Which keyword turns a function into a generator?",
        listOf("yield", "return", "lambda", "next"),
        0,
        "A function with yield returns a generator when called.",
    ),
    fill(
        "Fill in the blank to get the first item of the generator.",
        "g = (x * 10 for x in range(3))\nprint(____(g))",
        listOf("next", "iter", "len"),
        "next",
        "next() returns the next item – here 0.",
    ),
)
