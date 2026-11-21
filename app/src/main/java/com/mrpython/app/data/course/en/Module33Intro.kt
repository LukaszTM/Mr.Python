package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

internal val module33Intro = lesson(
    "u33l0", "Introduction: inheritance",
    explain(
        "Overriding and super()",
        "A derived class can override a parent's method by writing its own with the same name. `super()` " +
            "lets you call the parent's version – e.g. `super().__init__(name)` in the constructor – and then add your own part.",
        code = "class A:\n    def describe(self):\n        return \"A\"\n\nclass B(A):\n    def describe(self):\n        return super().describe() + \"B\"\n\nprint(B().describe())",
        output = "AB",
    ),
    explain(
        "Polymorphism",
        "Different classes can have a method with the same name. Then we call it the same way in a loop, " +
            "and each object answers in its own way – that's polymorphism.",
        code = "class Cat:\n    def sound(self):\n        return \"meow\"\n\nclass Dog:\n    def sound(self):\n        return \"woof\"\n\nfor a in [Cat(), Dog()]:\n    print(a.sound())",
        output = "meow\nwoof",
    ),
    explain(
        "isinstance and issubclass",
        "`isinstance(object, Class)` checks whether an object belongs to a class – including through inheritance. " +
            "`issubclass(B, A)` compares two classes: does B inherit from A?",
        code = "class Animal:\n    pass\n\nclass Dog(Animal):\n    pass\n\nprint(isinstance(Dog(), Animal))\nprint(issubclass(Animal, Dog))",
        output = "True\nFalse",
    ),
    explain(
        "Multiple inheritance and MRO",
        "A class can inherit from several classes: `class C(A, B)`. When both have the same method, " +
            "the one listed earlier wins. The order in which methods are looked up is the MRO, visible in `C.__mro__`.",
        code = "class A:\n    def who(self):\n        return \"A\"\n\nclass B:\n    def who(self):\n        return \"B\"\n\nclass C(A, B):\n    pass\n\nprint(C().who())",
        output = "A",
    ),
    explain(
        "Abstract classes",
        "An abstract class is a template: it inherits from `ABC`, and methods marked with `@abstractmethod` must " +
            "be implemented by derived classes. You can't create an object of the abstract class itself (`TypeError`).",
        code = "from abc import ABC, abstractmethod\nclass Shape(ABC):\n    @abstractmethod\n    def area(self):\n        pass\nclass Square(Shape):\n    def area(self):\n        return 4\nprint(Square().area())",
        output = "4",
    ),
    fill(
        "Fill in the blank to call the base class's constructor (prints 4).",
        "class Vehicle:\n    def __init__(self, wheels):\n        self.wheels = wheels\n\nclass Car(Vehicle):\n    def __init__(self):\n        ____().__init__(4)\n\nprint(Car().wheels)",
        listOf("super", "self", "Car"),
        "super",
        "super() gives access to the methods of the base class.",
    ),
    choice(
        "What does this code print?",
        listOf("True", "False", "TypeError", "None"),
        0,
        "Cat inherits from Animal, so it's an instance of Animal too.",
        code = "class Animal:\n    pass\n\nclass Cat(Animal):\n    pass\n\nprint(isinstance(Cat(), Animal))",
    ),
    tiles(
        "Write the header of the class Duck that inherits from Flyer and Swimmer",
        listOf("class", "Duck(", "Flyer,", "Swimmer", "):"),
        listOf("def", "extends"),
        "Base classes go in the parentheses, separated by commas.",
    ),
)
