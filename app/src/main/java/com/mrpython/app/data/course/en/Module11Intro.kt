package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

internal val module11Intro = lesson(
    "u11l0", "Introduction: classes and objects",
    explain(
        "Class and object",
        "A class is a recipe for a new kind of data, like \"Dog\". An object is a specific thing made " +
            "from that recipe, like Buddy. You create a class with `class`, and an object by calling it like a function.",
        code = "class Dog:\n    pass\n\nbuddy = Dog()\nprint(type(buddy).__name__)",
        output = "Dog",
    ),
    explain(
        "__init__ and self",
        "The `__init__` method runs when an object is created and stores its data. " +
            "`self` is that particular object, and `self.name` is its attribute.",
        code = "class Dog:\n    def __init__(self, name):\n        self.name = name\n\nd = Dog(\"Buddy\")\nprint(d.name)",
        output = "Buddy",
    ),
    explain(
        "Methods",
        "A method is a function defined in a class. Its first parameter is always `self`, " +
            "which gives the method access to the object's data. You call it after a dot.",
        code = "class Rectangle:\n    def __init__(self, a, b):\n        self.a, self.b = a, b\n    def area(self):\n        return self.a * self.b\nprint(Rectangle(2, 3).area())",
        output = "6",
    ),
    explain(
        "A readable description: __str__",
        "The `__str__` method returns the string that `print()` shows for the object. Without it you'll " +
            "see a technical description that's hard to read. `str(obj)` uses the same string.",
        code = "class Cat:\n    def __init__(self, name):\n        self.name = name\n    def __str__(self):\n        return \"Cat \" + self.name\nprint(Cat(\"Whiskers\"))",
        output = "Cat Whiskers",
    ),
    explain(
        "Inheritance",
        "`class Cat(Animal)` means that Cat inherits everything from the Animal class. " +
            "It can also override a method with its own version.",
        code = "class Animal:\n    def sound(self):\n        return \"...\"\nclass Cat(Animal):\n    pass\nprint(Cat().sound())",
        output = "...",
    ),
    choice(
        "Which keyword creates a class?",
        listOf("class", "def", "object", "Class"),
        0,
        "We define classes with the class keyword.",
    ),
    output(
        "class Point:\n    def __init__(self, x):\n        self.x = x\n\np = Point(4)\nprint(p.x * 2)",
        "8",
        "The attribute p.x has the value 4.",
    ),
    fill(
        "Fill in the blank to store the name in the object.",
        "class Person:\n    def __init__(self, name):\n        ____.name = name\n\np = Person(\"Amy\")\nprint(p.name)",
        listOf("self", "p", "name"),
        "self",
        "We store the object's data through self – the variable p doesn't exist yet at that point.",
    ),
)
