package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

internal val module31Intro = lesson(
    "u31l0", "Introduction: class attributes and methods",
    explain(
        "Class attributes",
        "An attribute written in the class body, outside the methods, is shared by all objects. " +
            "We change it through the class name, e.g. `Player.count += 1`. Note: `self.x = ...` creates a separate object attribute.",
        code = "class Player:\n    count = 0\n    def __init__(self):\n        Player.count += 1\n\nPlayer()\nPlayer()\nprint(Player.count)",
        output = "2",
    ),
    explain(
        "@classmethod",
        "A method with the `@classmethod` decorator gets the class in the `cls` parameter instead of an object. " +
            "It often serves as an alternative constructor: it creates an object in a different way, e.g. from a string.",
        code = "class Point:\n    def __init__(self, x, y):\n        self.x, self.y = x, y\n    @classmethod\n    def zero(cls):\n        return cls(0, 0)\n\nprint(Point.zero().x)",
        output = "0",
    ),
    explain(
        "@staticmethod",
        "A static method gets neither `self` nor `cls` – it's a regular function tucked inside a class " +
            "because it belongs there. We call it through the class name.",
        code = "class Math:\n    @staticmethod\n    def add(a, b):\n        return a + b\n\nprint(Math.add(2, 3))",
        output = "5",
    ),
    explain(
        "@property",
        "`@property` turns a method into a property that we read like an attribute – without parentheses. " +
            "The value is computed on every read. An underscore, as in `_balance`, is a convention: an internal attribute.",
        code = "class Rectangle:\n    def __init__(self, a, b):\n        self.a, self.b = a, b\n    @property\n    def area(self):\n        return self.a * self.b\n\nprint(Rectangle(3, 4).area)",
        output = "12",
    ),
    explain(
        "Setter with validation",
        "`@property` alone only allows reading. The `@name.setter` decorator adds a method that is called on " +
            "assignment – it can check or correct the value. The getter and the setter use the hidden `self._age`.",
        code = "class Person:\n    @property\n    def age(self):\n        return self._age\n    @age.setter\n    def age(self, a):\n        self._age = max(0, a)\n\np = Person()\np.age = -5\nprint(p.age)",
        output = "0",
    ),
    choice(
        "Which decorator passes the class as the first argument cls?",
        listOf("@classmethod", "@staticmethod", "@property", "@setter"),
        0,
        "@classmethod gives the method access to the class through cls.",
    ),
    output(
        "class Dog:\n    species = \"dog\"\n\na = Dog()\nb = Dog()\nprint(a.species, b.species)",
        "dog dog",
        "A class attribute is visible to all of its objects.",
    ),
    fill(
        "Fill in the blank so perimeter can be read without parentheses (it prints 8).",
        "class Square:\n    def __init__(self, a):\n        self.a = a\n    ____\n    def perimeter(self):\n        return 4 * self.a\n\nprint(Square(2).perimeter)",
        listOf("@property", "@staticmethod", "@classmethod"),
        "@property",
        "We read a property like an attribute, and its value is computed by a method.",
    ),
)
