package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

internal val module64Cards = listOf(
    cards(
        "u64l4",
        explain(
            "__call__ – an object like a function",
            "The `__call__` method lets you call an object with parentheses, like a function: `obj(x)` runs " +
                "`obj.__call__(x)`. Meanwhile the object remembers its state in its attributes.",
            code = "class Times:\n    def __init__(self, k):\n        self.k = k\n    def __call__(self, x):\n        return x * self.k\nprint(Times(3)(5))",
            output = "15",
        ),
        explain(
            "__iter__ – an object in a loop",
            "A `for` loop and `list()` call `__iter__`, which returns an iterator – most simply `iter()` of a list " +
                "kept inside. Without `__iter__`, Python tries `__getitem__` with indexes 0, 1, 2… until `IndexError`.",
            code = "class Queue:\n    def __init__(self):\n        self.people = [\"Amy\", \"Tom\"]\n    def __iter__(self):\n        return iter(self.people)\nprint(list(Queue()))",
            output = "['Amy', 'Tom']",
        ),
    ),
)
