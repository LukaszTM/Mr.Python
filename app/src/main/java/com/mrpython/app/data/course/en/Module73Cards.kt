package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

internal val module73Cards = listOf(
    cards(
        "u73l2",
        explain(
            "Keys from a list: fromkeys",
            "`dict.fromkeys(items, value)` creates a dictionary with the given keys. Keys never repeat " +
                "and they keep their order, so `list(dict.fromkeys(t))` removes duplicates without messing up the order.",
            code = "print(dict.fromkeys([\"b\", \"a\"], 0))\nprint(list(dict.fromkeys(\"abca\")))",
            output = "{'b': 0, 'a': 0}\n['a', 'b', 'c']",
        ),
    ),
    cards(
        "u73l3",
        explain(
            "Your own iterator",
            "A `for` loop calls the object's `__iter__`, and then `__next__` until it raises `StopIteration`. " +
                "The easiest way is to write `__iter__` as a generator with `yield`.",
            code = "class Countdown:\n    def __init__(self, n): self.n = n\n    def __iter__(self):\n        for i in range(self.n, 0, -1):\n            yield i\nprint(list(Countdown(4)))",
            output = "[4, 3, 2, 1]",
        ),
        explain(
            "An object like a function",
            "The `__call__` method makes an object callable like a function: `obj(x)` " +
                "runs `obj.__call__(x)`.",
            code = "class Times:\n    def __init__(self, n): self.n = n\n    def __call__(self, x): return x * self.n\ndouble = Times(2)\nprint(double(7))",
            output = "14",
        ),
        explain(
            "yield from",
            "`yield from collection` hands back all of its elements one by one – it's shorthand for the loop " +
                "`for x in collection: yield x`.",
            code = "def g():\n    yield from [1, 2]\n    yield 3\nprint(list(g()))",
            output = "[1, 2, 3]",
        ),
    ),
    cards(
        "u73l5",
        explain(
            "The Zen of Python",
            "The statement `import this` prints the \"Zen of Python\" – short principles of good code, such as " +
                "\"Simple is better than complex.\" and \"Readability counts.\"",
        ),
    ),
)
