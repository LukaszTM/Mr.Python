package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

internal val module41Cards = listOf(
    cards(
        "u41l1",
        explain(
            "Functions in a list and a dictionary",
            "Functions can be stored in a list or a dictionary like any other value. `ops[\"-\"]` gets " +
                "the function, and only the parentheses `(9, 4)` call it.",
            code = "def plus(a, b):\n    return a + b\ndef minus(a, b):\n    return a - b\nops = {\"+\": plus, \"-\": minus}\nprint(ops[\"-\"](9, 4))",
            output = "5",
        ),
        explain(
            "A function's name and printout",
            "Every function knows its own name in `__name__`. `print(f)` without parentheses doesn't " +
                "call the function, it just shows a description like `<function f at 0x...>`. A method " +
                "is a function too, e.g. `str.upper`.",
            code = "f = len\nprint(f(\"abc\"), f.__name__)\nprint(str.upper(\"a\"))",
            output = "3 len\nA",
        ),
        explain(
            "A function from a factory",
            "An inner function remembers the arguments of the function that created it. Every call " +
                "to the factory gives a new function with its own value.",
            code = "def multiplier(n):\n    def times(x):\n        return x * n\n    return times\ntriple = multiplier(3)\nprint(triple(5), multiplier(2)(8))",
            output = "15 16",
        ),
    ),
    cards(
        "u41l2",
        explain(
            "When does a decorator run?",
            "The decorator's own code runs once – at decoration time. The wrapper runs on " +
                "every call to the function. Without a call, nothing gets printed.",
            code = "def decorate(f):\n    print(\"decorating\")\n    def w(): print(\"call\")\n    return w\ndef a(): pass\na = decorate(a); a(); a()",
            output = "decorating\ncall\ncall",
        ),
    ),
    cards(
        "u41l3",
        explain(
            "Passing arguments along",
            "The wrapper replaces the original, so it has to accept the same arguments – otherwise you get a " +
                "`TypeError`. `*args, **kwargs` collects them all, and `f(*args, **kwargs)` passes them on.",
            code = "def log(f):\n    def w(*args, **kwargs):\n        print(args, kwargs)\n        return f(*args, **kwargs)\n    return w\nprint(log(round)(3.14159, ndigits=2))",
            output = "(3.14159,) {'ndigits': 2}\n3.14",
        ),
        explain(
            "Function attributes",
            "A function is an object, so you can give it your own attribute, e.g. a call counter. " +
                "We set it once, and the wrapper increases it on every call.",
            code = "def f():\n    f.count += 1\nf.count = 0\nf()\nf()\nprint(f.count)",
            output = "2",
        ),
    ),
    cards(
        "u41l4",
        explain(
            "Order of execution",
            "With `@factory(1)` the factory runs first, then the returned decorator, and the function itself " +
                "only when it's called. With several decorators, the one closest to `def` runs first.",
            code = "def a(f): print(\"a\"); return f\ndef b(f): print(\"b\"); return f\n@a\n@b\ndef x(): pass",
            output = "b\na",
        ),
    ),
)
