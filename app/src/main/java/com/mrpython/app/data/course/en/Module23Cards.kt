package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

internal val module23Cards = listOf(
    cards(
        "u23l1",
        explain(
            "An iterator remembers its place",
            "An iterator remembers how much it has already handed out. After a few `next()` calls, `list()` " +
                "or `sum()` get only the remaining items, and on the next use the iterator is empty.",
            code = "it = iter([10, 20, 30])\nnext(it)\nprint(sum(it))\nprint(sum(it))",
            output = "50\n0",
        ),
        explain(
            "Strings, dictionaries and for",
            "`iter()` works on any collection: a string gives letters, and a dictionary gives keys. A `for` " +
                "loop calls `next()` itself and handles `StopIteration` itself, which is why you never see it.",
            code = "it = iter(\"abc\")\nprint(next(it))\nprint(next(iter({\"x\": 1, \"y\": 2})))",
            output = "a\nx",
        ),
    ),
    cards(
        "u23l2",
        explain(
            "It starts only at next()",
            "Calling a function with `yield` doesn't run its code – it returns a generator object. " +
                "The code starts only at the first `next()` and pauses at `yield`.",
            code = "def gen():\n    print(\"start\")\n    yield 1\ng = gen()\nprint(type(g))\nprint(next(g))",
            output = "<class 'generator'>\nstart\n1",
        ),
        explain(
            "The end of a generator",
            "A generator ends when it reaches the end of the function or a `return`. After that, the next " +
                "`next()` raises `StopIteration`. `yield` can appear in a function many times.",
            code = "def gen():\n    yield 1\n    return\n    yield 2\n\nprint(list(gen()))",
            output = "[1]",
        ),
    ),
    cards(
        "u23l3",
        explain(
            "Filter and join",
            "In a generator expression, just like in a list comprehension, you can add an `if` at the end. " +
                "You can also pass a generator to `\"\".join()`, `any()` or `all()` – with no extra brackets.",
            code = "print(sum(x for x in range(7) if x % 2 == 0))\nprint(\"-\".join(str(x) for x in [1, 2, 3]))",
            output = "12\n1-2-3",
        ),
        explain(
            "Counting with sum",
            "A trick: `sum(1 for x in a if condition)` adds 1 for every matching item, so it counts them.",
            code = "a = [3, -1, 5, -2]\nprint(sum(1 for x in a if x < 0))",
            output = "2",
        ),
        explain(
            "A generator has no indexes",
            "A generator doesn't store values, so there is no `g[0]` or `len(g)` – that's a `TypeError`. " +
                "When you need indexes, turn it into a list: `list(g)`.",
            code = "g = (x * 2 for x in [1, 2, 3])\nprint(list(g)[0])",
            output = "2",
        ),
    ),
    cards(
        "u23l4",
        explain(
            "The variable _",
            "When the loop counter isn't needed, we name the variable `_`. Writing " +
                "`[next(g) for _ in range(3)]` simply means: \"get the next value 3 times\".",
            code = "g = (x * 10 for x in range(100))\nprint([next(g) for _ in range(3)])",
            output = "[0, 10, 20]",
        ),
        explain(
            "Don't take everything",
            "Never call `list(g)` or `sum(g)` on an infinite generator – the program would never finish. " +
                "Take only as much as you need: with `next()` or a loop with `break`.",
        ),
    ),
)
