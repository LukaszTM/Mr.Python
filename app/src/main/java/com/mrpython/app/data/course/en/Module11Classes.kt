package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*
import com.mrpython.app.domain.CourseUnit

internal val module11 = CourseUnit(
    id = "u11",
    title = "Classes and objects",
    description = "Create your own data types",
    lessons = listOf(
        lesson(
            "u11l1", "Your first class",
            choice(
                "Which keyword creates a class?",
                listOf("class", "def", "object", "new"),
                0,
                "We define a class with the class keyword.",
            ),
            output(
                "class Dog:\n    pass\n\nbuddy = Dog()\nprint(type(buddy).__name__)",
                "Dog",
                "buddy is an object (an instance) of the Dog class.",
            ),
            output(
                "class Dog:\n    def __init__(self, name):\n        self.name = name\n\nd = Dog(\"Buddy\")\nprint(d.name)",
                "Buddy",
                "__init__ sets the attributes of a new object.",
            ),
            choice(
                "What is __init__ for?",
                listOf("It sets the object's initial state", "It deletes the object", "It prints the object", "It creates a new class"),
                0,
                "__init__ is called automatically when an object is created.",
            ),
            output(
                "class Cat:\n    def __init__(self, name, age):\n        self.name = name\n        self.age = age\n\nc = Cat(\"Whiskers\", 3)\nprint(c.name, c.age)",
                "Whiskers 3",
                "Every object has its own attributes.",
            ),
            output(
                "class Point:\n    def __init__(self, x, y):\n        self.x = x\n        self.y = y\n\np = Point(2, 5)\np.x = 10\nprint(p.x + p.y)",
                "15",
                "An object's attributes can be changed.",
            ),
            fill(
                "Fill in the blank to store the name in the object.",
                "class Student:\n    def __init__(self, name):\n        ____.name = name\n\ns = Student(\"Kate\")\nprint(s.name)",
                listOf("self", "this", "obj"),
                "self",
                "self means the object being created.",
            ),
        ),
        lesson(
            "u11l2", "Methods",
            output("class Dog:\n    def bark(self):\n        print(\"Woof!\")\n\nDog().bark()", "Woof!", "A method is a function defined in a class."),
            output(
                "class Counter:\n    def __init__(self):\n        self.n = 0\n    def add(self):\n        self.n += 1\n\nc = Counter()\nc.add()\nc.add()\nprint(c.n)",
                "2",
                "A method changes the object's state through self.",
            ),
            output(
                "class Rectangle:\n    def __init__(self, a, b):\n        self.a = a\n        self.b = b\n    def area(self):\n        return self.a * self.b\n\nprint(Rectangle(3, 4).area())",
                "12",
                "A method can return a result.",
            ),
            choice(
                "What is self in a method?",
                listOf(
                    "The object the method was called on",
                    "The name of the class",
                    "A keyword like if",
                    "An argument we always pass by hand",
                ),
                0,
                "Python passes the object as self on its own.",
            ),
            output(
                "class Account:\n    def __init__(self):\n        self.balance = 100\n    def withdraw(self, amount):\n        self.balance -= amount\n\na = Account()\na.withdraw(30)\nprint(a.balance)",
                "70",
                "100 - 30 = 70.",
            ),
            output(
                "class A:\n    def __init__(self, x):\n        self.x = x\n\na = A(1)\nb = A(2)\nprint(a.x, b.x)",
                "1 2",
                "Every object has its own attribute values.",
            ),
            tiles(
                "Call the area() method of object p and store the result in the variable result",
                listOf("result", "=", "p.area()"),
                listOf("area(p)", "p.area"),
                "We call a method with a dot and parentheses.",
            ),
            fill(
                "Complete the method definition.",
                "class Cat:\n    def meow(____):\n        return \"Meow\"\n\nprint(Cat().meow())",
                listOf("self", "Cat()", "1"),
                "self",
                "The first parameter of a method is self.",
            ),
        ),
        lesson(
            "u11l3", "__str__ and inheritance",
            output(
                "class Dog:\n    def __init__(self, name):\n        self.name = name\n    def __str__(self):\n        return \"Dog \" + self.name\n\nprint(Dog(\"Rex\"))",
                "Dog Rex",
                "__str__ decides what the object looks like in print().",
            ),
            output(
                "class Animal:\n    def sound(self):\n        return \"...\"\n\nclass Cat(Animal):\n    pass\n\nprint(Cat().sound())",
                "...",
                "Cat inherits the sound method from the Animal class.",
            ),
            output(
                "class Animal:\n    def sound(self):\n        return \"...\"\n\nclass Cat(Animal):\n    def sound(self):\n        return \"Meow\"\n\nprint(Cat().sound())",
                "Meow",
                "A child class can override a method.",
            ),
            choice(
                "What does class Cat(Animal) mean?",
                listOf("Cat inherits from Animal", "Animal inherits from Cat", "Cat is an attribute", "Cat calls Animal"),
                0,
                "The base class goes in the parentheses.",
            ),
            output(
                "class A:\n    def __init__(self):\n        self.x = 1\n\nclass B(A):\n    def __init__(self):\n        super().__init__()\n        self.y = 2\n\nb = B()\nprint(b.x + b.y)",
                "3",
                "super().__init__() runs the base class's __init__.",
            ),
            output(
                "class Animal:\n    pass\n\nclass Dog(Animal):\n    pass\n\nprint(isinstance(Dog(), Animal))",
                "True",
                "A Dog is also an Animal.",
            ),
            fill(
                "Fill in the blank so the Dog class inherits from Animal.",
                "class Animal:\n    pass\n\nclass Dog(____):\n    pass\n\nprint(isinstance(Dog(), Animal))",
                listOf("Animal", "self", "object"),
                "Animal",
                "The class we inherit from goes in the parentheses.",
            ),
        ),
        lesson(
            "u11l4", "Review: classes",
            output(
                "class Counter:\n    def __init__(self, start=0):\n        self.n = start\n\nprint(Counter().n, Counter(5).n)",
                "0 5",
                "The parameters of __init__ can have default values too.",
            ),
            output(
                "class Book:\n    def __init__(self, title, pages):\n        self.title = title\n        self.pages = pages\n    def is_thick(self):\n        return self.pages > 300\n\nprint(Book(\"Moby Dick\", 700).is_thick())",
                "True",
                "700 > 300.",
            ),
            choice(
                "What will this code print?",
                listOf("[]", "[1]", "None", "An error"),
                0,
                "In __init__ every object gets its own new list.",
                code = "class A:\n    def __init__(self):\n        self.items = []\n\na = A()\nb = A()\na.items.append(1)\nprint(b.items)",
            ),
            output(
                "class Cart:\n    def __init__(self):\n        self.items = []\n    def add(self, item):\n        self.items.append(item)\n    def count(self):\n        return len(self.items)\n\nc = Cart()\nc.add(\"apple\")\nc.add(\"pear\")\nprint(c.count())",
                "2",
                "The object stores a list and has methods for working with it.",
            ),
            output(
                "class Person:\n    def __init__(self, name):\n        self.name = name\n    def greet(self, other):\n        return f\"{self.name} greets {other.name}\"\n\na = Person(\"Amy\")\nb = Person(\"Kate\")\nprint(a.greet(b))",
                "Amy greets Kate",
                "A method can take other objects.",
            ),
            tiles(
                "Create an object of the Dog class named \"Max\" in the variable d",
                listOf("d", "=", "Dog(", "\"Max\"", ")"),
                listOf("new", "class"),
                "We create an object by calling the class like a function.",
            ),
            output(
                "class Square:\n    def __init__(self, a):\n        self.a = a\n    def __str__(self):\n        return f\"Square {self.a}x{self.a}\"\n\nprint(Square(3))",
                "Square 3x3",
                "print() uses the __str__ method.",
            ),
            choice(
                "What do we call an object created from a class?",
                listOf("An instance", "A method", "An attribute", "A module"),
                0,
                "An object created from a class is an instance of it.",
            ),
        ),
    ),
)
