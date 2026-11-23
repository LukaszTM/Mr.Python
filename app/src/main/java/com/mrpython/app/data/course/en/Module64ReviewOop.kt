package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*
import com.mrpython.app.domain.CourseUnit

internal val module64 = CourseUnit(
    id = "u64",
    title = "Review week: object-oriented programming",
    description = "Classes, properties, special methods, inheritance and exceptions",
    lessons = listOf(
        lesson(
            "u64l1", "Day 1: Classes and objects",
            output(
                "class Dog:\n    def __init__(self, name):\n        self.name = name\n    def speak(self):\n        return self.name + \": woof\"\nd = Dog(\"Buddy\")\nprint(d.speak())",
                "Buddy: woof",
                "The method reads the object's attribute through self.",
            ),
            output(
                "class Cat:\n    legs = 4\n    def __init__(self, name):\n        self.name = name\na = Cat(\"Whiskers\")\nb = Cat(\"Felix\")\na.legs = 3\nprint(a.legs, b.legs, Cat.legs)",
                "3 4 4",
                "a.legs = 3 creates an attribute only in object a; the class attribute doesn't change.",
            ),
            choice(
                "What is self in a method?",
                listOf("The object the method was called on", "The class the method is defined in", "A keyword, just like def", "A copy of the object made for the call"),
                0,
                "When you call p.method(), Python passes p as self.",
            ),
            output(
                "class Basket:\n    items = []\n    def add(self, item):\n        self.items.append(item)\na = Basket()\nb = Basket()\na.add(\"apple\")\nprint(b.items)",
                "['apple']",
                "A list that is a class attribute is shared by all objects.",
            ),
            fill(
                "Fill in the name of the initializer method.",
                "class Point:\n    def ____(self, x, y):\n        self.x = x\n        self.y = y\np = Point(2, 3)\nprint(p.x + p.y)",
                listOf("__init__", "init", "__new__"),
                "__init__",
                "__init__ sets the attributes of a new object.",
            ),
            output(
                "class Counter:\n    def __init__(self):\n        self.n = 0\n    def click(self):\n        self.n += 1\n        return self\nc = Counter()\nc.click().click().click()\nprint(c.n)",
                "3",
                "click() returns self, so the calls can be chained.",
            ),
            tiles(
                "Create an object of the Car class with the brand \"Fiat\" and store it in the variable a",
                listOf("a", "=", "Car(", "\"Fiat\"", ")"),
                listOf("new", "Car."),
                "You create an object by calling the class like a function – without the word new.",
            ),
            choice(
                "What will this code print?",
                listOf("True A", "False A", "True object", "Error"),
                0,
                "x is an object of class A, and type(x).__name__ is the name of that class.",
                code = "class A:\n    pass\nx = A()\nprint(isinstance(x, A), type(x).__name__)",
            ),
        ),
        lesson(
            "u64l2", "Day 2: Properties",
            output(
                "class Circle:\n    def __init__(self, r):\n        self.r = r\n    @property\n    def diameter(self):\n        return 2 * self.r\nc = Circle(5)\nprint(c.diameter)",
                "10",
                "You read a property like an attribute, without parentheses.",
            ),
            choice(
                "How do you read the diameter property of the object c?",
                listOf("c.diameter", "c.diameter()", "c.get_diameter()", "diameter(c)"),
                0,
                "@property makes a method readable like a regular attribute.",
            ),
            output(
                "class Account:\n    _balance = 0\n    @property\n    def balance(self):\n        return self._balance\n    @balance.setter\n    def balance(self, v):\n        self._balance = max(0, v)\na = Account()\na.balance = -50\nprint(a.balance)",
                "0",
                "The setter makes sure the balance never drops below zero.",
            ),
            output(
                "class Person:\n    def __init__(self, year):\n        self.year = year\n    @property\n    def age(self):\n        return 2026 - self.year\np = Person(2000)\ntry:\n    p.age = 5\nexcept AttributeError:\n    print(\"read-only\")\nprint(p.age)",
                "read-only\n26",
                "A property without a setter can only be read.",
            ),
            fill(
                "Fill in the blank so the value of t.c can be set.",
                "class Temp:\n    _c = 0\n    @property\n    def c(self):\n        return self._c\n    @c.____\n    def c(self, v):\n        self._c = v\nt = Temp()\nt.c = 21\nprint(t.c)",
                listOf("setter", "getter", "property"),
                "setter",
                "@name.setter defines the method called on assignment.",
            ),
            output(
                "class Rectangle:\n    def __init__(self, a, b):\n        self.a, self.b = a, b\n    @property\n    def area(self):\n        return self.a * self.b\nr = Rectangle(2, 3)\nr.a = 10\nprint(r.area)",
                "30",
                "A property is computed on every read, so it sees the new a.",
            ),
            choice(
                "What does the underscore at the start of the name self._balance mean?",
                listOf("A convention: the attribute is for internal use", "A lock: Python won't let you read it", "A constant: the attribute can't be changed", "A speed-up: the attribute is faster"),
                0,
                "A single underscore is only a convention – access is still possible.",
            ),
            tiles(
                "Write the method area (to be used under @property) that returns the product of a and b",
                listOf("def", "area(self):", "return", "self.a * self.b"),
                listOf("area():", "self.a + self.b"),
                "A property is a method with a single parameter, self.",
            ),
        ),
        lesson(
            "u64l3", "Day 3: Class methods and static methods",
            output(
                "class Date:\n    def __init__(self, d, m):\n        self.d, self.m = d, m\n    @classmethod\n    def from_string(cls, s):\n        d, m = s.split(\".\")\n        return cls(int(d), int(m))\nx = Date.from_string(\"22.10\")\nprint(x.d + x.m)",
                "32",
                "A class method is a handy alternative constructor: 22 + 10 = 32.",
            ),
            output(
                "class Math:\n    @staticmethod\n    def is_even(n):\n        return n % 2 == 0\nprint(Math.is_even(4), Math().is_even(7))",
                "True False",
                "A static method can be called on the class and on an object.",
            ),
            choice(
                "What does a method with @classmethod receive as its first argument?",
                listOf("The class (cls)", "The object (self)", "Nothing", "The module"),
                0,
                "A class method receives the class it was called on.",
            ),
            output(
                "class Player:\n    count = 0\n    def __init__(self):\n        Player.count += 1\n    @classmethod\n    def how_many(cls):\n        return cls.count\nPlayer(); Player(); Player()\nprint(Player.how_many())",
                "3",
                "Every new object increases the counter stored in the class.",
            ),
            fill(
                "Fill in the blank so the method can be called without self and cls.",
                "class Converter:\n    @____\n    def km_to_m(km):\n        return km * 1000\nprint(Converter.km_to_m(3))",
                listOf("staticmethod", "classmethod", "property"),
                "staticmethod",
                "A static method receives neither the object nor the class.",
            ),
            output(
                "class Animal:\n    @classmethod\n    def new(cls):\n        return cls()\nclass Cat(Animal):\n    pass\nprint(type(Cat.new()).__name__)",
                "Cat",
                "cls is the class the method was called on – here Cat.",
            ),
            choice(
                "When is @staticmethod the best choice?",
                listOf("When the method needs neither self nor cls", "When the method changes the object's attributes", "When you create an alternative constructor", "Always in classes"),
                0,
                "A static method is a regular function placed in a class to keep things organized.",
            ),
            tiles(
                "Write the header of the class method from_list that takes a list called data",
                listOf("def", "from_list(", "cls,", "data", "):"),
                listOf("cls.", "data)"),
                "The first parameter of a class method is cls.",
            ),
        ),
        lesson(
            "u64l4", "Day 4: Special methods",
            output(
                "class Fraction:\n    def __init__(self, n, d):\n        self.n, self.d = n, d\n    def __str__(self):\n        return f\"{self.n}/{self.d}\"\nf = Fraction(3, 4)\nprint(f)\nprint(f\"[{f}]\")",
                "3/4\n[3/4]",
                "print and f-strings use __str__.",
            ),
            output(
                "class Vector:\n    def __init__(self, x, y):\n        self.x, self.y = x, y\n    def __add__(self, o):\n        return Vector(self.x + o.x, self.y + o.y)\nv = Vector(1, 2) + Vector(3, 4)\nprint(v.x, v.y)",
                "4 6",
                "The + operator calls the __add__ method.",
            ),
            output(
                "class Deck:\n    def __init__(self):\n        self.cards = [\"A\", \"K\", \"Q\"]\n    def __len__(self):\n        return len(self.cards)\n    def __getitem__(self, i):\n        return self.cards[i]\nd = Deck()\nprint(len(d), d[-1])",
                "3 Q",
                "len() calls __len__, and indexing calls __getitem__.",
            ),
            choice(
                "Which method do you need to define so that a == b compares objects by value?",
                listOf("__eq__", "__cmp__", "__equal__", "__is__"),
                0,
                "The == operator calls __eq__.",
            ),
            output(
                "class Score:\n    def __init__(self, p):\n        self.p = p\n    def __lt__(self, o):\n        return self.p < o.p\ns = sorted([Score(5), Score(2), Score(9)])\nprint([x.p for x in s])",
                "[2, 5, 9]",
                "sorted() compares objects with the < operator, that is, the __lt__ method.",
            ),
            fill(
                "Fill in the blank so the in operator works.",
                "class Team:\n    def __init__(self, *people):\n        self.people = people\n    def ____(self, x):\n        return x in self.people\nt = Team(\"Amy\", \"Tom\")\nprint(\"Amy\" in t)",
                listOf("__contains__", "__in__", "__has__"),
                "__contains__",
                "x in obj calls __contains__.",
            ),
            output(
                "class Box:\n    def __init__(self, items):\n        self.items = items\n    def __len__(self):\n        return len(self.items)\nprint(bool(Box([])), bool(Box([1])))",
                "False True",
                "Without __bool__, Python checks __len__: a length of 0 is false.",
            ),
            tiles(
                "Write the header of the method that lets an object be called like a function: obj(x)",
                listOf("def", "__call__(", "self,", "x", "):"),
                listOf("__init__(", "__run__("),
                "Calling obj(x) runs the __call__ method.",
            ),
        ),
        lesson(
            "u64l5", "Day 5: Inheritance",
            output(
                "class Animal:\n    def describe(self):\n        return \"animal\"\nclass Dog(Animal):\n    def describe(self):\n        return \"dog, \" + super().describe()\nprint(Dog().describe())",
                "dog, animal",
                "super().describe() calls the base class version of the method.",
            ),
            output(
                "class Person:\n    def __init__(self, name):\n        self.name = name\nclass Student(Person):\n    def __init__(self, name, grade):\n        super().__init__(name)\n        self.grade = grade\ns = Student(\"Amy\", \"3b\")\nprint(s.name, s.grade)",
                "Amy 3b",
                "super().__init__ sets the attributes from the base class.",
            ),
            choice(
                "What will happen?",
                listOf("AttributeError", "It prints 1", "It prints 2", "It prints None"),
                0,
                "B overrides __init__ and doesn't call super().__init__(), so x doesn't exist.",
                code = "class A:\n    def __init__(self):\n        self.x = 1\nclass B(A):\n    def __init__(self):\n        self.y = 2\nprint(B().x)",
            ),
            output(
                "class Shape:\n    def area(self):\n        return 0\nclass Square(Shape):\n    def __init__(self, a):\n        self.a = a\n    def area(self):\n        return self.a ** 2\nshapes = [Shape(), Square(3)]\nprint(sum(s.area() for s in shapes))",
                "9",
                "Each object uses its own version of area(): 0 + 9.",
            ),
            choice(
                "What will this code print?",
                listOf("True False", "True True", "False True", "False False"),
                0,
                "b is also an object of class A, but A is not a subclass of B.",
                code = "class A: pass\nclass B(A): pass\nb = B()\nprint(isinstance(b, A), issubclass(A, B))",
            ),
            fill(
                "Fill in the blank so Bike inherits from Vehicle (the program should print 2 True).",
                "class Vehicle:\n    wheels = 4\nclass Bike(____):\n    wheels = 2\nb = Bike()\nprint(b.wheels, isinstance(b, Vehicle))",
                listOf("Vehicle", "self", "object"),
                "Vehicle",
                "The base class goes in parentheses after the class name.",
            ),
            output(
                "class A:\n    def who(self): return \"A\"\nclass B(A):\n    def who(self): return \"B\"\nclass C(A):\n    def who(self): return \"C\"\nclass D(B, C):\n    pass\nprint(D().who())",
                "B",
                "Python looks for the method in the base classes from the left: B first.",
            ),
            tiles(
                "Store in the variable result the result of the base class method describe with \"!\" added",
                listOf("result", "=", "super().describe()", "+", "\"!\""),
                listOf("self.describe()", "super.describe()"),
                "super() gives you access to the methods of the base class.",
            ),
        ),
        lesson(
            "u64l6", "Day 6: dataclasses",
            output(
                "from dataclasses import dataclass\n@dataclass\nclass Point:\n    x: int\n    y: int\np = Point(1, 2)\nprint(p)",
                "Point(x=1, y=2)",
                "@dataclass creates __init__ and a readable __repr__ for you.",
            ),
            output(
                "from dataclasses import dataclass\n@dataclass\nclass Color:\n    name: str\nprint(Color(\"red\") == Color(\"red\"))",
                "True",
                "A dataclass adds an __eq__ that compares the fields.",
            ),
            output(
                "from dataclasses import dataclass, field\n@dataclass\nclass Basket:\n    owner: str\n    items: list = field(default_factory=list)\na = Basket(\"Amy\")\na.items.append(\"cheese\")\nprint(Basket(\"Tom\").items, len(a.items))",
                "[] 1",
                "default_factory creates a new list for every object.",
            ),
            choice(
                "Why don't we write items: list = [] in a dataclass?",
                listOf("Python raises ValueError – the list would be shared", "Python raises TypeError – lists can't be fields", "Python raises SyntaxError – you must write list()", "We can, it works just like field(...)"),
                0,
                "A single [] would be shared by all objects, so dataclass forbids it; field(default_factory=list) gives each object a new list.",
            ),
            output(
                "from dataclasses import dataclass\n@dataclass(frozen=True)\nclass Pair:\n    a: int\n    b: int\np = Pair(1, 2)\ntry:\n    p.a = 5\nexcept Exception as e:\n    print(type(e).__name__)",
                "FrozenInstanceError",
                "frozen=True forbids changing the fields.",
            ),
            fill(
                "Fill in the blank so the objects can be compared with the < operator.",
                "from dataclasses import dataclass\n@dataclass(____=True)\nclass Version:\n    major: int\n    minor: int\nprint(Version(1, 9) < Version(2, 0))",
                listOf("order", "frozen", "eq"),
                "order",
                "order=True adds <, <=, > and >=, which compare the fields in order.",
            ),
            output(
                "from dataclasses import dataclass\n@dataclass\nclass Product:\n    price: float\n    quantity: int\n    def value(self):\n        return self.price * self.quantity\nprint(Product(2.5, 4).value())",
                "10.0",
                "You can write regular methods in a dataclass.",
            ),
            tiles(
                "In a dataclass, declare the field age of type int with a default value of 0",
                listOf("age", ":", "int", "=", "0"),
                listOf("==", "->"),
                "A field is a type annotation with an optional default value.",
            ),
        ),
        lesson(
            "u64l7", "Day 7: Custom exceptions",
            output(
                "class AgeError(Exception):\n    pass\ntry:\n    raise AgeError(\"too young\")\nexcept AgeError as e:\n    print(\"Error:\", e)",
                "Error: too young",
                "A custom exception works like the built-in ones – it has a message.",
            ),
            output(
                "class AppError(Exception): pass\nclass NoFunds(AppError): pass\ntry:\n    raise NoFunds()\nexcept AppError:\n    print(\"caught by the base class\")",
                "caught by the base class",
                "except also catches exceptions of derived classes.",
            ),
            choice(
                "Which class does a custom exception usually inherit from?",
                listOf("Exception", "object", "Error", "str"),
                0,
                "Custom exceptions inherit from Exception (or one of its subclasses).",
            ),
            output(
                "class OutOfStock(Exception):\n    def __init__(self, name):\n        super().__init__(f\"out of: {name}\")\n        self.name = name\ntry:\n    raise OutOfStock(\"milk\")\nexcept OutOfStock as e:\n    print(e.name)\n    print(e)",
                "milk\nout of: milk",
                "An exception can have its own attributes and message.",
            ),
            choice(
                "What will this code print?",
                listOf("A", "B", "A and B", "Nothing"),
                0,
                "The first matching except runs, and B is a subclass of A.",
                code = "class A(Exception): pass\nclass B(A): pass\ntry:\n    raise B()\nexcept A:\n    print(\"A\")\nexcept B:\n    print(\"B\")",
            ),
            fill(
                "Fill in the blank so the function raises an exception for a bad code.",
                "class BadCode(Exception):\n    pass\ndef check(code):\n    if len(code) != 4:\n        ____ BadCode(code)\ntry:\n    check(\"12\")\nexcept BadCode:\n    print(\"bad code\")",
                listOf("raise", "return", "except"),
                "raise",
                "You raise an exception with the raise keyword.",
            ),
            output(
                "class DataError(Exception): pass\ndef load(s):\n    try:\n        return int(s)\n    except ValueError:\n        raise DataError(\"not a number\")\nfor s in [\"7\", \"x\"]:\n    try:\n        print(load(s))\n    except DataError as e:\n        print(e)",
                "7\nnot a number",
                "The ValueError is turned into our own exception.",
            ),
            tiles(
                "Define the exception LoginError that inherits from Exception",
                listOf("class", "LoginError(", "Exception", "):"),
                listOf("def", "Error"),
                "An exception is a class that inherits from Exception.",
            ),
        ),
    ),
)
