package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

internal val module15Cards = listOf(
    cards(
        "u15l1",
        explain(
            "Parameter order",
            "Parameters with a default value must come after those without one: `def f(a, b=1)` is fine, " +
                "and `def f(a=1, b)` is an error. By passing an argument by name, you change only the chosen parameter.",
            code = "def f(a, b=2, c=3):\n    print(a, b, c)\n\nf(1, c=9)",
            output = "1 2 9",
        ),
        explain(
            "The list trap: is None",
            "A default list is created once, when Python runs `def`, so it remembers earlier calls. " +
                "That is why we use `None` and check `if lst is None:` inside – `is` checks whether it is exactly `None`.",
            code = "def add(x, lst=None):\n    if lst is None:\n        lst = []\n    lst.append(x)\n    return lst\nprint(add(1), add(2))",
            output = "[1] [2]",
        ),
    ),
    cards(
        "u15l2",
        explain(
            "Regular parameters and *rest",
            "Regular parameters can come before `*args`. They get their arguments first, and the rest goes " +
                "into a tuple – sometimes an empty one. The name `args` is just a convention; the star is what matters.",
            code = "def f(a, *rest):\n    print(a, rest)\n\nf(1, 2, 3)\nf(4)",
            output = "1 (2, 3)\n4 ()",
        ),
    ),
    cards(
        "u15l3",
        explain(
            "*args and **kwargs together",
            "A function can have both at once: arguments without a name go into the tuple, and keyword arguments " +
                "go into the dictionary. `**kwargs` always comes last and won't accept an argument without a name " +
                "(that is a `TypeError`).",
            code = "def f(a, *args, **kw):\n    print(a, args, kw)\n\nf(1, 2, x=3)",
            output = "1 (2,) {'x': 3}",
        ),
        explain(
            "kwargs is an ordinary dictionary",
            "Everything you know from dictionaries works on `kwargs`: `get()`, `items()`, `len()`. " +
                "`list(dictionary)` gives a list of its keys.",
            code = "def f(**k):\n    print(list(k), k.get(\"mode\", \"none\"))\n\nf(a=1, b=2)",
            output = "['a', 'b'] none",
        ),
    ),
    cards(
        "u15l4",
        explain(
            "Unpacking in print()",
            "`print(*items)` works as if you passed the elements separately, so it prints them without brackets. " +
                "The star also works for a string and a tuple, and `sep` sets the separator.",
            code = "print(*[1, 2, 3])\nprint(*\"ab\", sep=\"-\")",
            output = "1 2 3\na-b",
        ),
        explain(
            "The arguments must match",
            "You can combine unpacking with regular arguments: `f(1, *[2, 3])`. There must be as many elements " +
                "as parameters – otherwise you get a `TypeError`. You get the same error when a parameter " +
                "after a lone `*` is passed without its name.",
            code = "def f(a, b, c):\n    print(a + b + c)\n\nf(1, *[2, 3])",
            output = "6",
        ),
    ),
    cards(
        "u15l5",
        explain(
            "The full parameter order",
            "When you combine all the kinds of parameters, the order is fixed: regular ones, ones with " +
                "a default value, `*args`, and `**kwargs` at the very end.",
            code = "def f(a, b=1, *args, **kw):\n    print(a, b, args, kw)\n\nf(5)",
            output = "5 1 () {}",
        ),
    ),
)
