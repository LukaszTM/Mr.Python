package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

internal val module33Cards = listOf(
    cards(
        "u33l1",
        explain(
            "The forgotten super().__init__()",
            "A class without its own `__init__` inherits the parent's constructor. But when you write your own `__init__` " +
                "and don't call `super().__init__()`, the parent's attributes are never created (`AttributeError`).",
            code = "class A:\n    def __init__(self, x):\n        self.x = x\n\nclass B(A):\n    pass\n\nprint(B(7).x)",
            output = "7",
        ),
        explain(
            "self picks the child's version",
            "When a parent's method calls `self.describe()`, Python looks for `describe` starting from the object's class. If the " +
                "derived class has overridden it, that version is used.",
            code = "class Base:\n    def describe(self):\n        return \"base\"\n    def show(self):\n        return \"[\" + self.describe() + \"]\"\nclass Sub(Base):\n    def describe(self):\n        return \"sub\"\nprint(Sub().show())",
            output = "[sub]",
        ),
    ),
    cards(
        "u33l2",
        explain(
            "isinstance for types",
            "`isinstance` works with built-in types too: `int`, `str`, `list`… Instead of a single class you can " +
                "pass a tuple of classes – the result is True when the object matches any of them.",
            code = "print(isinstance(\"abc\", str), isinstance(3.5, int))\nprint(isinstance(7, (int, float)))",
            output = "True False\nTrue",
        ),
        explain(
            "type() vs. isinstance()",
            "`type(object)` returns the exact class, while `isinstance` takes inheritance into account. Fun fact: " +
                "`bool` inherits from `int`, so `True` is an integer too.",
            code = "class Animal:\n    pass\nclass Dog(Animal):\n    pass\nd = Dog()\nprint(type(d) == Animal, isinstance(d, Animal))\nprint(isinstance(True, int))",
            output = "False True\nTrue",
        ),
    ),
    cards(
        "u33l3",
        explain(
            "Peeking at the MRO",
            "`Class.__mro__` is a tuple of classes in the order methods are looked up. The class itself comes first, " +
                "and `object` is always last – every class inherits from it.",
            code = "class A:\n    pass\nclass B(A):\n    pass\nprint([c.__name__ for c in B.__mro__])",
            output = "['B', 'A', 'object']",
        ),
        explain(
            "The inheritance diamond",
            "When B and C inherit from A, and `D(B, C)` inherits from both, the order is D, B, C, A. The shared parent A " +
                "is checked only at the end, after all of its children.",
            code = "class A:\n    pass\nclass B(A):\n    pass\nclass C(A):\n    pass\nclass D(B, C):\n    pass\nprint([c.__name__ for c in D.__mro__])",
            output = "['D', 'B', 'C', 'A', 'object']",
        ),
    ),
    cards(
        "u33l4",
        explain(
            "Regular methods in the template",
            "An abstract class can also have regular methods that use the abstract ones. " +
                "We write the shared part once, and derived classes fill in only the missing piece.",
            code = "from abc import ABC, abstractmethod\nclass Animal(ABC):\n    @abstractmethod\n    def sound(self):\n        pass\n    def introduce(self):\n        return \"Me: \" + self.sound()\nclass Cat(Animal):\n    def sound(self):\n        return \"meow\"\nprint(Cat().introduce())",
            output = "Me: meow",
        ),
        explain(
            "A missing method means it's still a template",
            "A derived class that doesn't implement all the abstract methods is abstract too – " +
                "creating its object raises a `TypeError`. A class that inherits from `ABC` but has no abstract methods can be created normally.",
            code = "from abc import ABC, abstractmethod\nclass Base(ABC):\n    @abstractmethod\n    def run(self):\n        pass\nclass Bad(Base):\n    pass\ntry:\n    Bad()\nexcept TypeError:\n    print(\"no run\")",
            output = "no run",
        ),
    ),
)
