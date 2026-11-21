package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*
import com.mrpython.app.domain.CourseUnit

internal val module40 = CourseUnit(
    id = "u40",
    title = "The functools module",
    description = "reduce, partial, lru_cache and wraps",
    lessons = listOf(
        lesson(
            "u40l1", "reduce",
            output(
                "from functools import reduce\nprint(reduce(lambda a, b: a + b, [1, 2, 3, 4]))",
                "10",
                "reduce folds a list into a single value: ((1 + 2) + 3) + 4.",
            ),
            output(
                "from functools import reduce\nprint(reduce(lambda a, b: a * b, [2, 3, 4]))",
                "24",
                "One multiplication after another: 2 × 3 = 6, 6 × 4 = 24.",
            ),
            output(
                "from functools import reduce\nprint(reduce(lambda a, b: a + b, [], 100))",
                "100",
                "The third argument is the initial value – with an empty list, it is what gets returned.",
            ),
            choice(
                "What happens with reduce on an empty list without an initial value?",
                listOf("TypeError", "The result is 0", "The result is None", "An empty list"),
                0,
                "reduce has nothing to start from, so it raises TypeError.",
                code = "from functools import reduce\nreduce(lambda a, b: a + b, [])",
            ),
            output(
                "from functools import reduce\nprint(reduce(lambda a, b: a if a > b else b, [3, 8, 2]))",
                "8",
                "This lambda keeps the larger number – it's a search for the maximum.",
            ),
            fill(
                "Fill in the blank to join the letters into the string \"abc\".",
                "from functools import reduce\nprint(reduce(____, [\"a\", \"b\", \"c\"]))",
                listOf("lambda a, b: a + b", "lambda a, b: b + a", "lambda a, b: a", "max"),
                "lambda a, b: a + b",
                "Adding b to the end of a gives \"abc\".",
            ),
            tiles(
                "Import reduce from functools",
                listOf("from", "functools", "import", "reduce"),
                listOf("itertools", "include"),
                "In Python 3, reduce has to be imported from functools.",
            ),
        ),
        lesson(
            "u40l2", "partial",
            output(
                "from functools import partial\ndef power(x, n):\n    return x ** n\nsquare = partial(power, n=2)\nprint(square(5))",
                "25",
                "partial fixes the argument n=2 for good.",
            ),
            output(
                "from functools import partial\ndef add(a, b):\n    return a + b\nplus10 = partial(add, 10)\nprint(plus10(5))",
                "15",
                "The positional argument 10 goes to a.",
            ),
            output(
                "from functools import partial\nhex2 = partial(int, base=16)\nprint(hex2(\"ff\"))",
                "255",
                "partial works with built-in functions too.",
            ),
            choice(
                "What does partial(f, 1) return?",
                listOf("A new function with the first argument fixed", "The result of f(1)", "A list of arguments", "An unchanged copy of f"),
                0,
                "partial creates a new callable object; it doesn't call f.",
            ),
            output(
                "from functools import partial\nshout = partial(print, end=\"!\\n\")\nshout(\"Hey\")",
                "Hey!",
                "We fixed the end parameter of the print function for good.",
            ),
            fill(
                "Fill in the blank so that cube(2) returns 8.",
                "from functools import partial\ndef power(x, n):\n    return x ** n\ncube = partial(power, ____)\nprint(cube(2))",
                listOf("n=3", "x=3", "3", "n=2"),
                "n=3",
                "We fix the exponent n, and pass x when calling.",
            ),
            choice(
                "Which expression gives the same as partial(add, 10)?",
                listOf("lambda b: add(10, b)", "lambda b: add(b)", "add(10)", "lambda: add(10, 10)"),
                0,
                "partial is a handy replacement for a simple lambda.",
            ),
        ),
        lesson(
            "u40l3", "lru_cache",
            output(
                "from functools import lru_cache\n@lru_cache\ndef fib(n):\n    if n < 2:\n        return n\n    return fib(n - 1) + fib(n - 2)\nprint(fib(30))",
                "832040",
                "Thanks to the cache, each fib(n) is computed only once.",
            ),
            output(
                "from functools import lru_cache\n@lru_cache\ndef sq(x):\n    print(\"computing\")\n    return x * x\nprint(sq(3))\nprint(sq(3))",
                "computing\n9\n9",
                "The second call with the same argument takes the result from the cache – the function doesn't run.",
            ),
            output(
                "from functools import lru_cache\n@lru_cache\ndef f(x):\n    return x + 1\nf(1)\nf(1)\nf(2)\nprint(f.cache_info().hits)",
                "1",
                "There was only one cache hit – on the second f(1).",
            ),
            output(
                "from functools import lru_cache\n@lru_cache\ndef f(x):\n    return x\nfor i in [1, 2, 1, 1]:\n    f(i)\nprint(f.cache_info().misses)",
                "2",
                "The misses are the first calls for 1 and for 2.",
            ),
            choice(
                "Why is fib with lru_cache much faster than plain recursion?",
                listOf("It doesn't compute the same values again", "It uses a loop instead of recursion", "It runs on many cores", "It skips every other call"),
                0,
                "The results are remembered, so the number of calls drops from exponential to linear.",
            ),
            fill(
                "Fill in the decorator that remembers results.",
                "from functools import lru_cache\n@____\ndef factorial(n):\n    return 1 if n == 0 else n * factorial(n - 1)\nprint(factorial(5))",
                listOf("lru_cache", "cache_info", "reduce", "partial"),
                "lru_cache",
                "@lru_cache adds a cache to a function.",
            ),
            choice(
                "What does maxsize=128 mean in @lru_cache(maxsize=128)?",
                listOf("The cache holds at most the 128 most recent results", "The function accepts at most 128 arguments", "The result won't exceed 128", "The function will run at most 128 times"),
                0,
                "When the cache is full, the least recently used result is removed (LRU).",
            ),
            tiles(
                "Print the number of cache hits of the function fib",
                listOf("print(", "fib.cache_info()", ".hits", ")"),
                listOf("fib(", ".misses"),
                "cache_info() returns the cache statistics, and hits is the number of hits.",
            ),
        ),
        lesson(
            "u40l4", "Review: functools and wraps",
            output(
                "def decorate(f):\n    def wrapper():\n        return f()\n    return wrapper\n@decorate\ndef hello():\n    pass\nprint(hello.__name__)",
                "wrapper",
                "Without wraps the function loses its name – you see the name of the inner function.",
            ),
            output(
                "from functools import wraps\ndef decorate(f):\n    @wraps(f)\n    def wrapper():\n        return f()\n    return wrapper\n@decorate\ndef hello():\n    pass\nprint(hello.__name__)",
                "hello",
                "@wraps(f) copies the name and docstring of the original function.",
            ),
            fill(
                "Fill in the blank so the decorated function keeps its name.",
                "from functools import wraps\ndef log(f):\n    @____(f)\n    def w(*a):\n        return f(*a)\n    return w\n@log\ndef add(x, y):\n    return x + y\nprint(add.__name__)",
                listOf("wraps", "partial", "lru_cache", "reduce"),
                "wraps",
                "wraps carries the metadata over from f to the inner function.",
            ),
            output(
                "from functools import reduce\nprint(reduce(lambda a, b: a * 10 + b, [1, 2, 3]))",
                "123",
                "(1 × 10 + 2) × 10 + 3 = 123.",
            ),
            output(
                "from functools import partial\ndef greet(name, mark):\n    return \"Hello \" + name + mark\nshout = partial(greet, mark=\"!\")\nprint(shout(\"Amy\"))",
                "Hello Amy!",
                "partial fixed mark to \"!\".",
            ),
            choice(
                "Which functools tool folds a list into a single value?",
                listOf("reduce", "partial", "wraps", "lru_cache"),
                0,
                "reduce applies a two-argument function to the elements one after another.",
            ),
            choice(
                "When will lru_cache NOT help?",
                listOf("When the function gets different arguments every time", "With a recursive fib", "When the function is slow", "When we call it many times with the same data"),
                0,
                "The cache only works when arguments repeat.",
            ),
            tiles(
                "Create a function double with a=2 fixed",
                listOf("double", "=", "partial(", "multiply,", "a=2", ")"),
                listOf("reduce(", "lambda"),
                "partial(function, arguments) returns a new function.",
            ),
        ),
    ),
)
