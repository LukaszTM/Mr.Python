package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

internal val module40Intro = lesson(
    "u40l0", "Introduction: the functools module",
    explain(
        "reduce – folding a list",
        "`reduce(f, items)` from the `functools` module folds a list into a single value: it " +
            "applies a two-argument function to the result so far and the next element. The third " +
            "argument is the initial value.",
        code = "from functools import reduce\nprint(reduce(lambda a, b: a * b, [2, 3, 4]))\nprint(reduce(lambda a, b: a + b, [], 0))",
        output = "24\n0",
    ),
    explain(
        "partial – fixed arguments",
        "`partial(f, ...)` creates a new function in which some of the arguments are already " +
            "fixed. It doesn't call f right away – it's a handy replacement for a simple lambda.",
        code = "from functools import partial\ndef power(x, n):\n    return x ** n\nsquare = partial(power, n=2)\nprint(square(4))",
        output = "16",
    ),
    explain(
        "lru_cache – remembering results",
        "The `@lru_cache` decorator remembers a function's results. When you call it again with " +
            "the same arguments, the result comes from the cache and the function doesn't run. " +
            "It's great for speeding up recursion.",
        code = "from functools import lru_cache\n@lru_cache\ndef sq(x):\n    print(\"computing\")\n    return x * x\nprint(sq(3), sq(3))",
        output = "computing\n9 9",
    ),
    explain(
        "cache_info",
        "A function with `lru_cache` has a `cache_info()` method. `hits` are the cache hits, and " +
            "`misses` are the calls that had to be computed.",
        code = "from functools import lru_cache\n@lru_cache\ndef f(x):\n    return x + 1\nprint(f(1), f(1), f(2))\nprint(f.cache_info().hits)",
        output = "2 2 3\n1",
    ),
    explain(
        "wraps – keeping the name",
        "A function wrapped in another one loses its name, `__name__`. `@wraps(f)` used on the " +
            "inner function copies the name and docstring of the original.",
        code = "from functools import wraps\ndef decorate(f):\n    @wraps(f)\n    def w():\n        return f()\n    return w",
    ),
    choice(
        "What does partial(f, 1) return?",
        listOf("A new function", "The result of f(1)", "The number 1", "A list of arguments"),
        0,
        "partial creates a new function with the argument 1 fixed and doesn't call f.",
    ),
    output(
        "from functools import reduce\nprint(reduce(lambda a, b: a + b, [1, 2, 3]))",
        "6",
        "reduce adds one after another: (1 + 2) + 3.",
    ),
    fill(
        "Fill in the decorator that remembers the function's results.",
        "from functools import lru_cache\n@____\ndef double(x):\n    return 2 * x\nprint(double(5))",
        listOf("lru_cache", "reduce", "partial", "cache_info"),
        "lru_cache",
        "@lru_cache gives a function a cache.",
    ),
)
