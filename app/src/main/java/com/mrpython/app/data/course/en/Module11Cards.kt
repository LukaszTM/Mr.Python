package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

internal val module11Cards = listOf(
    cards(
        "u11l1",
        explain(
            "Changing attributes",
            "You change an object's attribute with a plain assignment, like `p.x = 10`. You can also add " +
                "a new attribute after the object has been created. The change affects only that one object.",
            code = "class Point:\n    pass\n\np = Point()\np.x = 10\nprint(p.x)",
            output = "10",
        ),
        explain(
            "An object is an instance",
            "An object created from a class is also called an instance of it. `type(obj).__name__` gives " +
                "the name of its class. If `__init__` requires arguments and you don't pass them, you get a `TypeError`.",
            code = "class Cat:\n    pass\n\nc = Cat()\nprint(type(c).__name__)",
            output = "Cat",
        ),
    ),
    cards(
        "u11l2",
        explain(
            "Methods with parameters",
            "A method can have more parameters than just `self`. When calling it you pass only the others – " +
                "Python puts the object before the dot in as `self` by itself.",
            code = "class Cat:\n    def sound(self, times):\n        return \"purr\" * times\n\nprint(Cat().sound(3))",
            output = "purrpurrpurr",
        ),
        explain(
            "A method calls a method",
            "Inside a class, one method can call another with `self.name()`. Remember the parentheses: " +
                "`obj.method` without `()` doesn't run the method, it only refers to it.",
            code = "class A:\n    def a(self):\n        return 2\n    def b(self):\n        return self.a() * 5\nprint(A().b())",
            output = "10",
        ),
    ),
    cards(
        "u11l3",
        explain(
            "Checking the type: isinstance",
            "`isinstance(obj, Class)` returns `True` when the object is of that class or of a class that " +
                "inherits from it. Every Cat is an Animal, but not every Animal is a Cat.",
            code = "class Animal:\n    pass\nclass Cat(Animal):\n    pass\nprint(isinstance(Cat(), Animal))\nprint(isinstance(Animal(), Cat))",
            output = "True\nFalse",
        ),
        explain(
            "super() – the parent's version",
            "In a child class, `super()` gives access to the methods of the base class. Most often we write " +
                "`super().__init__(...)` so the parent sets its attributes, and then we add our own.",
            code = "class A:\n    def who(self): return \"A\"\nclass B(A):\n    def who(self):\n        return super().who() + \"B\"\nprint(B().who())",
            output = "AB",
        ),
    ),
    cards(
        "u11l4",
        explain(
            "A method returns self",
            "When a method ends with `return self`, it returns the same object. That lets you call " +
                "methods one after another, like `c.click().click()`.",
            code = "class C:\n    def __init__(self): self.n = 0\n    def click(self):\n        self.n += 1\n        return self\nprint(C().click().click().n)",
            output = "2",
        ),
        explain(
            "Missing attribute",
            "Reading an attribute the object doesn't have ends in an `AttributeError`. Each object gets " +
                "the attributes set in `__init__` separately – for example its own new list.",
            code = "class Cat:\n    pass\ntry:\n    print(Cat().age)\nexcept AttributeError:\n    print(\"missing\")",
            output = "missing",
        ),
    ),
)
