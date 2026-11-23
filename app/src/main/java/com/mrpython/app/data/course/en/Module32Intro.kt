package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

internal val module32Intro = lesson(
    "u32l0", "Introduction: special methods",
    explain(
        "__repr__ and __str__",
        "Python calls methods with double underscores on its own. `__str__` gives pretty text for " +
            "`print()`, and `__repr__` gives a technical description – used e.g. inside a list and when there's no `__str__`.",
        code = "class Dog:\n    def __init__(self, name):\n        self.name = name\n    def __repr__(self):\n        return f\"Dog('{self.name}')\"\n\nprint([Dog(\"Rex\")])",
        output = "[Dog('Rex')]",
    ),
    explain(
        "Comparisons: __eq__ and __lt__",
        "By default, `==` checks whether it's the same object. `__eq__` teaches a class to compare attributes, " +
            "and `__lt__` handles `<` – it's what makes `sorted()`, `min()`, and `max()` work.",
        code = "class P:\n    def __init__(self, x):\n        self.x = x\n    def __eq__(self, other):\n        return self.x == other.x\n\nprint(P(1) == P(1))",
        output = "True",
    ),
    explain(
        "Your own collections",
        "A class can behave like a list: `__len__` handles `len()`, `__contains__` handles the " +
            "`in` operator, and `__getitem__` handles the brackets in `object[i]`.",
        code = "class Club:\n    def __init__(self):\n        self.people = [\"Anna\", \"Olivia\"]\n    def __len__(self):\n        return len(self.people)\n\nprint(len(Club()))",
        output = "2",
    ),
    explain(
        "Operators: __add__ and others",
        "The `+` operator calls `__add__`, `-` calls `__sub__`, and `*` calls `__mul__`. The method usually " +
            "returns a new object holding the result, e.g. the sum of two vectors.",
        code = "class Vector:\n    def __init__(self, x, y):\n        self.x, self.y = x, y\n    def __add__(self, o):\n        return Vector(self.x + o.x, self.y + o.y)\n\nv = Vector(1, 2) + Vector(3, 4)\nprint(v.x, v.y)",
        output = "4 6",
    ),
    choice(
        "Which method does the in operator call?",
        listOf("__contains__", "__in__", "__getitem__", "__eq__"),
        0,
        "x in object calls __contains__.",
    ),
    fill(
        "Fill in the blank so the + operator works (prints 15).",
        "class Time:\n    def __init__(self, m):\n        self.m = m\n    def ____(self, o):\n        return Time(self.m + o.m)\n\nprint((Time(10) + Time(5)).m)",
        listOf("__add__", "__plus__", "__sum__"),
        "__add__",
        "Addition is handled by the __add__ method.",
    ),
    output(
        "class A:\n    def __str__(self):\n        return \"pretty\"\n    def __repr__(self):\n        return \"A()\"\n\nprint(A())\nprint([A()])",
        "pretty\n[A()]",
        "print() uses __str__, while a list shows its items with __repr__.",
    ),
)
