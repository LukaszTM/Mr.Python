package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

internal val module40Cards = listOf(
    cards(
        "u40l1",
        explain(
            "reduce step by step",
            "reduce goes from the left: `reduce(f, [a, b, c])` computes `f(f(a, b), c)`. The result " +
                "of the previous step is always the first argument. The initial value becomes the " +
                "first `a`.",
            code = "from functools import reduce\nprint(reduce(lambda a, b: a - b, [10, 3, 2]))\nprint(reduce(lambda a, b: a + b, [1, 2], 10))",
            output = "5\n13",
        ),
        explain(
            "An empty list and a single element",
            "For a single element, reduce returns it without calling the function. An empty list " +
                "without an initial value gives a `TypeError`, because there is nothing to start from.",
            code = "from functools import reduce\nprint(reduce(lambda a, b: a * b, [5]))\ntry:\n    reduce(lambda a, b: a + b, [])\nexcept TypeError:\n    print(\"TypeError\")",
            output = "5\nTypeError",
        ),
    ),
    cards(
        "u40l2",
        explain(
            "Arguments in partial",
            "Positional arguments in `partial` go to the first parameters, in order. A fixed " +
                "keyword argument can be overridden when calling.",
            code = "from functools import partial\ndef subtract(a, b=0):\n    return a - b\nf = partial(subtract, 10, b=1)\nprint(f(), f(b=3))",
            output = "9 7",
        ),
        explain(
            "int with a base",
            "`int(string, base=n)` reads a string as a number in base n: 2 is binary, " +
                "16 is hexadecimal. With `partial` you can turn this into a handy function.",
            code = "print(int(\"101\", base=2))\nprint(int(\"ff\", base=16))",
            output = "5\n255",
        ),
    ),
    cards(
        "u40l3",
        explain(
            "maxsize and LRU",
            "`@lru_cache(maxsize=n)` remembers at most n results. When the cache is full, the " +
                "least recently used result drops out (Least Recently Used). Without parentheses " +
                "it remembers 128 results.",
            code = "from functools import lru_cache\n@lru_cache(maxsize=1)\ndef f(x):\n    print(\"computing\", x)\n    return x\nf(1); f(2); f(1)",
            output = "computing 1\ncomputing 2\ncomputing 1",
        ),
        explain(
            "cache_clear and currsize",
            "`cache_info().currsize` tells you how many results are in the cache right now. " +
                "`cache_clear()` empties the cache, so the next calls are computed from scratch.",
            code = "from functools import lru_cache\n@lru_cache\ndef f(x): return x\nf(1); f(2); f(1)\nprint(f.cache_info().currsize)\nf.cache_clear(); print(f.cache_info().currsize)",
            output = "2\n0",
        ),
    ),
    cards(
        "u40l4",
        explain(
            "Decorators in short",
            "A decorator is a function that takes a function and returns a new one. `@decorate` " +
                "above `def hello` is short for `hello = decorate(hello)`. That's why, without " +
                "`wraps`, the name is the name of the inner function.",
            code = "def decorate(f):\n    def wrapper(): return f()\n    return wrapper\n@decorate\ndef hello(): pass\nprint(hello.__name__)",
            output = "wrapper",
        ),
        explain(
            "A function's description: __doc__",
            "A string on the first line of a function's body is its description (docstring), " +
                "available as `__doc__`. `@wraps(f)` copies it together with the name.",
            code = "def hello():\n    \"Says hello.\"\n    return \"hello\"\nprint(hello.__doc__)",
            output = "Says hello.",
        ),
    ),
)
