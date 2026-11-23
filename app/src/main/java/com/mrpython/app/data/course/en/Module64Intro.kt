package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

internal val module64Intro = lesson(
    "u64l0", "Introduction: review week – objects",
    explain(
        "Classes and objects",
        "This week reviews object-oriented programming. A class is a recipe, an object is one item made from it. " +
            "`__init__` sets the attributes, and `self` means the current object.",
        code = "class Dog:\n    def __init__(self, name):\n        self.name = name\n    def speak(self):\n        return self.name + \": woof\"\nprint(Dog(\"Buddy\").speak())",
        output = "Buddy: woof",
    ),
    explain(
        "Properties and class methods",
        "`@property` turns a method into an attribute computed on the fly – you write it without parentheses. " +
            "`@classmethod` receives the class (`cls`), and `@staticmethod` receives neither `self` nor `cls`.",
        code = "class Circle:\n    def __init__(self, r): self.r = r\n    @property\n    def diameter(self): return 2 * self.r\nprint(Circle(3).diameter)",
        output = "6",
    ),
    explain(
        "Special methods",
        "Methods with double underscores teach an object to work with Python: `__str__` for `print`, " +
            "`__len__` for `len()`, `__add__` for `+`, `__lt__` for `<`.",
        code = "class Deck:\n    def __init__(self):\n        self.cards = [\"A\", \"K\"]\n    def __len__(self):\n        return len(self.cards)\nprint(len(Deck()))",
        output = "2",
    ),
    explain(
        "Inheritance and custom exceptions",
        "A class `B(A)` inherits the methods of `A`, can override them and call the original with `super()`. " +
            "A custom exception is simply a class that inherits from `Exception`.",
        code = "class AgeError(Exception):\n    pass\ntry:\n    raise AgeError(\"too young\")\nexcept Exception as e:\n    print(\"Error:\", e)",
        output = "Error: too young",
    ),
    explain(
        "dataclasses",
        "`@dataclass` creates `__init__`, a readable `__repr__` and `==` comparison for you, based on the fields. " +
            "All you do is list the fields with their types.",
        code = "from dataclasses import dataclass\n@dataclass\nclass Point:\n    x: int\n    y: int\nprint(Point(1, 2))",
        output = "Point(x=1, y=2)",
    ),
    choice(
        "Which decorator lets you read a method like an attribute, without parentheses?",
        listOf("@property", "@staticmethod", "@classmethod", "@dataclass"),
        0,
        "@property turns a method into an attribute computed on the fly.",
    ),
    output(
        "from dataclasses import dataclass\n@dataclass\nclass Color:\n    name: str\nprint(Color(\"red\") == Color(\"red\"))",
        "True",
        "A dataclass compares objects by the values of their fields.",
    ),
)
