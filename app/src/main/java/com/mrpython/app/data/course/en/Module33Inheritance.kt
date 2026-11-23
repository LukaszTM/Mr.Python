package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*
import com.mrpython.app.domain.CourseUnit

internal val module33 = CourseUnit(
    id = "u33",
    title = "Inheritance in practice",
    description = "super(), polymorphism, multiple inheritance, and abstract classes",
    lessons = listOf(
        lesson(
            "u33l1", "Overriding and super()",
            output(
                "class Animal:\n    def sound(self):\n        return \"...\"\n\nclass Cat(Animal):\n    def sound(self):\n        return \"meow\"\n\nprint(Cat().sound(), Animal().sound())",
                "meow ...",
                "Cat overrides the sound method, while Animal keeps its own version.",
            ),
            output(
                "class Person:\n    def __init__(self, name):\n        self.name = name\n\nclass Student(Person):\n    def __init__(self, name, grade):\n        super().__init__(name)\n        self.grade = grade\n\ns = Student(\"Olivia\", 3)\nprint(s.name, s.grade)",
                "Olivia 3",
                "super().__init__ sets name, and Student adds the grade.",
            ),
            output(
                "class A:\n    def describe(self):\n        return \"A\"\n\nclass B(A):\n    def describe(self):\n        return super().describe() + \"B\"\n\nprint(B().describe())",
                "AB",
                "B extends the parent's method instead of writing it from scratch.",
            ),
            choice(
                "What is super() for?",
                listOf("Calling a method from the base class", "Creating a new class", "Removing a parent's method", "Checking the type of an object"),
                0,
                "super() gives access to the methods of the parent class.",
            ),
            fill(
                "Fill in the blank so the program prints 2.",
                "class Vehicle:\n    def __init__(self, wheels):\n        self.wheels = wheels\n\nclass Bike(Vehicle):\n    def __init__(self):\n        ____().__init__(2)\n\nprint(Bike().wheels)",
                listOf("super", "self", "parent"),
                "super",
                "super().__init__(2) runs the constructor of the Vehicle class.",
            ),
            choice(
                "What happens when you run this code?",
                listOf("AttributeError", "It prints 1", "It prints None", "It prints 2"),
                0,
                "B overrode __init__ and didn't call super().__init__(), so x was never created.",
                code = "class A:\n    def __init__(self):\n        self.x = 1\n\nclass B(A):\n    def __init__(self):\n        self.y = 2\n\nprint(B().x)",
            ),
            output(
                "class Account:\n    def __str__(self):\n        return \"Account\"\n\nclass Savings(Account):\n    def __str__(self):\n        return super().__str__() + \" (savings)\"\n\nprint(Savings())",
                "Account (savings)",
                "A special method can use the parent's version through super() too.",
            ),
            tiles(
                "Call the base class's __init__ with the argument name",
                listOf("super()", ".__init__(", "name", ")"),
                listOf("self,", "super"),
                "super().__init__(name) – self is passed automatically.",
            ),
        ),
        lesson(
            "u33l2", "Polymorphism and isinstance",
            output(
                "class Cat:\n    def sound(self):\n        return \"meow\"\n\nclass Dog:\n    def sound(self):\n        return \"woof\"\n\nfor a in [Cat(), Dog(), Cat()]:\n    print(a.sound())",
                "meow\nwoof\nmeow",
                "Each object answers sound() in its own way – that's polymorphism.",
            ),
            choice(
                "What is polymorphism?",
                listOf("Different classes have a method with the same name", "One class has several different constructors", "An object changes its class while the program runs", "One class inherits from several other classes"),
                0,
                "Different classes have a method with the same name, so a loop calls it the same way and each object answers in its own way.",
            ),
            output(
                "class Animal:\n    pass\n\nclass Dog(Animal):\n    pass\n\nd = Dog()\nprint(isinstance(d, Dog), isinstance(d, Animal))",
                "True True",
                "An object of a derived class is also an instance of the base class.",
            ),
            output(
                "class A:\n    pass\n\nclass B(A):\n    pass\n\nprint(issubclass(B, A), issubclass(A, B))",
                "True False",
                "B inherits from A, but not the other way around.",
            ),
            output(
                "class Dog:\n    pass\n\nclass Cat:\n    pass\n\nfor a in [Dog(), Cat(), Dog()]:\n    if isinstance(a, Dog):\n        print(\"woof\")",
                "woof\nwoof",
                "The condition lets through only objects of the Dog class.",
            ),
            fill(
                "Check whether 5 is an integer (prints True).",
                "print(____(5, int))",
                listOf("isinstance", "issubclass", "type"),
                "isinstance",
                "isinstance(object, class) checks the type of an object; issubclass compares classes.",
            ),
            tiles(
                "Check whether the object a is an instance of the Dog class",
                listOf("isinstance(", "a,", "Dog", ")"),
                listOf("issubclass(", "type("),
                "isinstance takes an object and a class.",
            ),
            choice(
                "What does this code print?",
                listOf("True", "False", "TypeError", "None"),
                0,
                "bool inherits from int, so True is also an instance of int.",
                code = "print(isinstance(True, int))",
            ),
        ),
        lesson(
            "u33l3", "Multiple inheritance and MRO",
            output(
                "class Flyer:\n    def fly(self):\n        return \"flying\"\n\nclass Swimmer:\n    def swim(self):\n        return \"swimming\"\n\nclass Duck(Flyer, Swimmer):\n    pass\n\nd = Duck()\nprint(d.fly(), d.swim())",
                "flying swimming",
                "Duck inherits methods from both classes.",
            ),
            output(
                "class A:\n    def who(self):\n        return \"A\"\n\nclass B:\n    def who(self):\n        return \"B\"\n\nclass C(A, B):\n    pass\n\nprint(C().who())",
                "A",
                "When there's a conflict, the class listed earlier in the parentheses wins.",
            ),
            choice(
                "What does this code print?",
                listOf("B", "A", "AB", "TypeError"),
                0,
                "C(B, A) – class B is searched first.",
                code = "class A:\n    def who(self):\n        return \"A\"\n\nclass B:\n    def who(self):\n        return \"B\"\n\nclass C(B, A):\n    pass\n\nprint(C().who())",
            ),
            output(
                "class A:\n    pass\n\nclass B(A):\n    pass\n\nprint([c.__name__ for c in B.__mro__])",
                "['B', 'A', 'object']",
                "__mro__ shows the order in which methods are looked up; object is always last.",
            ),
            choice(
                "What does the abbreviation MRO mean?",
                listOf("The method search order", "A list of a class's objects", "A method that creates objects", "A kind of class error"),
                0,
                "MRO (Method Resolution Order) is the order in which classes are searched.",
            ),
            output(
                "class A:\n    def who(self):\n        return \"A\"\nclass B(A):\n    pass\nclass C(A):\n    def who(self):\n        return \"C\"\nclass D(B, C):\n    pass\nprint(D().who())",
                "C",
                "The order is D, B, C, A – C has who() before Python gets to A.",
            ),
            fill(
                "Fill in the blank so the duck can swim.",
                "class Flyer:\n    def fly(self):\n        return \"flying\"\n\nclass Swimmer:\n    def swim(self):\n        return \"swimming\"\n\nclass Duck(Flyer, ____):\n    pass\n\nprint(Duck().swim())",
                listOf("Swimmer", "Flyer", "object"),
                "Swimmer",
                "The swim method comes from the Swimmer class, so Duck has to inherit from it.",
            ),
            tiles(
                "Write the header of class C that inherits from A and B",
                listOf("class", "C(", "A,", "B", "):"),
                listOf("def", "and"),
                "Base classes are listed in the parentheses, separated by commas.",
            ),
        ),
        lesson(
            "u33l4", "Abstract classes",
            output(
                "from abc import ABC, abstractmethod\n\nclass Shape(ABC):\n    @abstractmethod\n    def area(self):\n        pass\n\nclass Square(Shape):\n    def area(self):\n        return 4\n\nprint(Square().area())",
                "4",
                "Square implements the abstract method, so it can be created.",
            ),
            choice(
                "What happens when you run this code?",
                listOf("TypeError", "An object s is created", "NameError", "s.area() returns None"),
                0,
                "A class with an unimplemented abstract method can't be instantiated – Python raises a TypeError.",
                code = "from abc import ABC, abstractmethod\n\nclass Shape(ABC):\n    @abstractmethod\n    def area(self):\n        pass\n\ns = Shape()",
            ),
            output(
                "from abc import ABC, abstractmethod\nclass Base(ABC):\n    @abstractmethod\n    def run(self):\n        pass\nclass Bad(Base):\n    pass\ntry:\n    Bad()\nexcept TypeError:\n    print(\"no run method\")",
                "no run method",
                "Bad didn't implement run(), so it's abstract too.",
            ),
            fill(
                "Fill in the blank so an Animal object can't be created (prints \"abstract\").",
                "from abc import ABC, abstractmethod\n\nclass Animal(ABC):\n    @____\n    def sound(self):\n        pass\n\ntry:\n    Animal()\nexcept TypeError:\n    print(\"abstract\")",
                listOf("abstractmethod", "staticmethod", "property"),
                "abstractmethod",
                "@abstractmethod marks a method that derived classes must implement.",
            ),
            choice(
                "What does an abstract class inherit from in Python?",
                listOf("ABC", "abstractmethod", "Exception", "Abstract"),
                0,
                "An abstract class inherits from ABC from the abc module; abstractmethod is a decorator for methods, not a base class.",
            ),
            output(
                "from abc import ABC, abstractmethod\nclass Animal(ABC):\n    @abstractmethod\n    def sound(self):\n        pass\n    def introduce(self):\n        return \"Me: \" + self.sound()\nclass Cat(Animal):\n    def sound(self):\n        return \"meow\"\nprint(Cat().introduce())",
                "Me: meow",
                "An abstract class can have regular methods that use the abstract ones.",
            ),
            tiles(
                "Import ABC and abstractmethod",
                listOf("from", "abc", "import", "ABC,", "abstractmethod"),
                listOf("Abc", "abstract"),
                "Both come from the abc module.",
            ),
            choice(
                "Why do we use abstract classes?",
                listOf("To force methods in derived classes", "To make the program run faster", "To hide attributes from others", "To allow only one object of a class"),
                0,
                "An abstract class is a template – it says which methods derived classes must have.",
            ),
        ),
        lesson(
            "u33l5", "Review: inheritance",
            output(
                "class A:\n    def __init__(self):\n        print(\"A\")\n\nclass B(A):\n    def __init__(self):\n        print(\"B\")\n        super().__init__()\n\nB()",
                "B\nA",
                "First B is printed, then super() calls the __init__ from A.",
            ),
            output(
                "class Payment:\n    def amount(self):\n        return 10\n\nclass Card(Payment):\n    def amount(self):\n        return super().amount() + 2\n\nfor p in [Payment(), Card()]:\n    print(p.amount())",
                "10\n12",
                "Card extends the parent's method with a fee of 2.",
            ),
            choice(
                "What does this code print?",
                listOf("True", "False", "TypeError", "Cat"),
                0,
                "Cat inherits from Animal, so its object is an Animal too.",
                code = "class Animal:\n    pass\n\nclass Cat(Animal):\n    pass\n\nprint(isinstance(Cat(), Animal))",
            ),
            output(
                "class X:\n    name = \"X\"\n\nclass Y:\n    name = \"Y\"\n\nclass Z(Y, X):\n    pass\n\nprint(Z.name)",
                "Y",
                "The MRO of class Z is Z, Y, X – the first attribute found comes from Y.",
            ),
            fill(
                "Fill in the blank so the program checks whether B inherits from A (prints True).",
                "class A:\n    pass\n\nclass B(A):\n    pass\n\nprint(____(B, A))",
                listOf("issubclass", "isinstance", "super"),
                "issubclass",
                "issubclass compares two classes.",
            ),
            choice(
                "Which expression calls the describe method from the base class?",
                listOf("super().describe()", "super.describe()", "super().describe", "self.super().describe()"),
                0,
                "super() is a function, so it needs parentheses (self.super() doesn't exist); without parentheses after describe, the method isn't called.",
            ),
            output(
                "from abc import ABC, abstractmethod\nclass Shape(ABC):\n    @abstractmethod\n    def area(self):\n        pass\nclass Circle(Shape):\n    def area(self):\n        return 3\ns = Circle()\nprint(isinstance(s, Shape), s.area())",
                "True 3",
                "Circle implements area() and is an instance of the abstract class Shape.",
            ),
            tiles(
                "Write the header of the class Cat that inherits from Animal",
                listOf("class", "Cat(", "Animal", "):"),
                listOf("def", "self,"),
                "The base class goes in the parentheses.",
            ),
        ),
    ),
)
