package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

internal val module63Intro = lesson(
    "u63l0", "Introduction: review week – functions",
    explain(
        "Parameters and return",
        "This week we review functions. A parameter can have a default value, and `return` hands back " +
            "the result. Careful: don't use a list as a default value – `None` is better.",
        code = "def describe(name, age=18):\n    return f\"{name}:{age}\"\nprint(describe(\"Amy\"))\nprint(describe(\"Jack\", 30))",
        output = "Amy:18\nJack:30",
    ),
    explain(
        "*args and **kwargs",
        "`*args` collects any number of positional arguments into a tuple, and `**kwargs` collects keyword " +
            "arguments into a dictionary. That way the function accepts as many as you pass.",
        code = "def f(*args, **kwargs):\n    print(args, kwargs)\nf(1, 2, x=3)",
        output = "(1, 2) {'x': 3}",
    ),
    explain(
        "Lambda",
        "`lambda` is a short, anonymous one-line function. Most often we pass it as `key=` " +
            "to `sorted`, `max` or `min`.",
        code = "words = [\"bbb\", \"a\", \"cc\"]\nprint(sorted(words, key=lambda s: len(s)))",
        output = "['a', 'cc', 'bbb']",
    ),
    explain(
        "Recursion",
        "A recursive function calls itself for a smaller problem. It always needs " +
            "a base case that ends the calls.",
        code = "def factorial(n):\n    if n <= 1:\n        return 1\n    return n * factorial(n - 1)\nprint(factorial(5))",
        output = "120",
    ),
    explain(
        "Closures and decorators",
        "A closure is an inner function that remembers the variables of the outer function (to change them, use " +
            "`nonlocal`). A decorator `@` is a function that wraps another one and changes how it behaves.",
        code = "def loud(f):\n    return lambda x: f(x).upper()\n@loud\ndef hey(x): return \"hey \" + x\nprint(hey(\"amy\"))",
        output = "HEY AMY",
    ),
    output(
        "def total(*numbers):\n    return sum(numbers)\nprint(total(1, 2, 3))",
        "6",
        "*numbers collects the arguments into the tuple (1, 2, 3), and its sum is 6.",
    ),
    choice(
        "What does every recursive function need in order to finish?",
        listOf("a base case", "a while loop", "a decorator", "an *args argument"),
        0,
        "The base case stops further calls.",
    ),
)
