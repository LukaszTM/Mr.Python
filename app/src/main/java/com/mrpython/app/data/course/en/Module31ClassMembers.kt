package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*
import com.mrpython.app.domain.CourseUnit

internal val module31 = CourseUnit(
    id = "u31",
    title = "Class attributes and methods",
    description = "Class attributes, @classmethod, @staticmethod and @property",
    lessons = listOf(
        lesson(
            "u31l1", "Class attributes",
            output(
                "class Cat:\n    species = \"cat\"\n\na = Cat()\nb = Cat()\nprint(a.species, b.species)",
                "cat cat",
                "A class attribute is shared by all objects of that class.",
            ),
            output(
                "class Player:\n    count = 0\n    def __init__(self):\n        Player.count += 1\n\nPlayer()\nPlayer()\nprint(Player.count)",
                "2",
                "Every time an object is created, the shared counter in the class goes up.",
            ),
            choice(
                "Where do we define a class attribute?",
                listOf("In the class body, outside the methods", "In __init__ through self", "Only in a separate function", "In a for loop"),
                0,
                "A class attribute is written directly in the class body, not through self.",
            ),
            output(
                "class A:\n    x = 1\n\na = A()\na.x = 5\nprint(a.x, A.x)",
                "5 1",
                "Assigning a.x creates an object attribute that hides the class attribute.",
            ),
            fill(
                "Fill in the blank so the counter in the class equals 2.",
                "class Dog:\n    count = 0\n    def __init__(self):\n        ____.count += 1\n\nDog()\nDog()\nprint(Dog.count)",
                listOf("Dog", "self", "count"),
                "Dog",
                "We change a class attribute through the class name; self.count += 1 would create an object attribute.",
            ),
            output(
                "class Basket:\n    items = []\n\na = Basket()\nb = Basket()\na.items.append(\"apple\")\nprint(b.items)",
                "['apple']",
                "There is only one list in the class attribute, shared by all objects.",
            ),
            tiles(
                "Increase the class attribute counter in the class Car by 1",
                listOf("Car.counter", "+=", "1"),
                listOf("==", "self"),
                "We refer to a class attribute through the class name.",
            ),
            choice(
                "What will this code print?",
                listOf("0", "1", "AttributeError", "None"),
                0,
                "a.n += 1 creates a new attribute in the object a, and A.n stays equal to 0.",
                code = "class A:\n    n = 0\n\na = A()\na.n += 1\nprint(A.n)",
            ),
        ),
        lesson(
            "u31l2", "@classmethod and @staticmethod",
            output(
                "class Point:\n    def __init__(self, x, y):\n        self.x = x\n        self.y = y\n    @classmethod\n    def zero(cls):\n        return cls(0, 0)\n\np = Point.zero()\nprint(p.x, p.y)",
                "0 0",
                "A class method can create new objects – this is called an alternative constructor.",
            ),
            choice(
                "What goes into the cls parameter in a method with @classmethod?",
                listOf("The class the method was called on", "A specific object (instance)", "The method's name as a string", "Nothing – the parameter is empty"),
                0,
                "cls is the class itself, just like self is the object.",
            ),
            output(
                "class Date:\n    def __init__(self, d, m):\n        self.d = d\n        self.m = m\n    @classmethod\n    def from_string(cls, s):\n        d, m = s.split(\".\")\n        return cls(int(d), int(m))\n\nprint(Date.from_string(\"24.12\").m)",
                "12",
                "from_string splits the string and calls the regular constructor cls(...).",
            ),
            fill(
                "Fill in the decorator so zero() works as an alternative constructor.",
                "class Point:\n    def __init__(self, x, y):\n        self.x = x\n        self.y = y\n    ____\n    def zero(cls):\n        return cls(0, 0)\n\nprint(Point.zero().x)",
                listOf("@classmethod", "@staticmethod", "@property"),
                "@classmethod",
                "Only @classmethod passes the class as the first argument cls.",
            ),
            output(
                "class Math:\n    @staticmethod\n    def add(a, b):\n        return a + b\n\nprint(Math.add(2, 3))",
                "5",
                "A static method gets neither self nor cls – it's a regular function inside a class.",
            ),
            fill(
                "Fill in the blank so the program prints 212.0.",
                "class Temp:\n    ____\n    def to_f(c):\n        return c * 9 / 5 + 32\n\nprint(Temp.to_f(100))",
                listOf("@staticmethod", "@classmethod", "@property"),
                "@staticmethod",
                "to_f needs neither an object nor the class, so it's a static method.",
            ),
            choice(
                "A method uses neither the object nor the class. Which decorator should you use?",
                listOf("@staticmethod", "@classmethod", "@property", "None – it must have self"),
                0,
                "@staticmethod is for helper functions related to the class.",
            ),
            tiles(
                "Call the static method add of the class Math with the arguments 1, 2 and print the result",
                listOf("print(", "Math.add(", "1, 2", "))"),
                listOf("self.", "cls."),
                "We call a static method through the class name.",
            ),
        ),
        lesson(
            "u31l3", "@property",
            output(
                "class Rectangle:\n    def __init__(self, a, b):\n        self.a = a\n        self.b = b\n    @property\n    def area(self):\n        return self.a * self.b\n\nprint(Rectangle(3, 4).area)",
                "12",
                "We read a property like an attribute, without parentheses.",
            ),
            choice(
                "How do you read the property area of the object p?",
                listOf("p.area", "p.area()", "area(p)", "p[\"area\"]"),
                0,
                "@property lets us read a method like a regular attribute.",
            ),
            output(
                "class Person:\n    def __init__(self, first, last):\n        self.first = first\n        self.last = last\n    @property\n    def full(self):\n        return self.first + \" \" + self.last\n\np = Person(\"John\", \"Smith\")\np.first = \"Anna\"\nprint(p.full)",
                "Anna Smith",
                "The property is computed on every read, so it sees the new first name.",
            ),
            choice(
                "What happens when you run this code?",
                listOf("AttributeError – the property has no setter", "x will change to 10", "SyntaxError", "x will stay 5, with no error"),
                0,
                "@property alone only allows reading; assignment requires a setter.",
                code = "class K:\n    @property\n    def x(self):\n        return 5\n\nk = K()\nk.x = 10",
            ),
            fill(
                "Fill in the blank so the program prints 20.",
                "class Square:\n    def __init__(self, a):\n        self.a = a\n    ____\n    def perimeter(self):\n        return 4 * self.a\n\nprint(Square(5).perimeter)",
                listOf("@property", "@staticmethod", "@classmethod"),
                "@property",
                "Thanks to @property we read perimeter without parentheses and get a number.",
            ),
            output(
                "class Account:\n    def __init__(self):\n        self._balance = 100\n    @property\n    def balance(self):\n        return self._balance\n\nprint(Account().balance)",
                "100",
                "The balance property returns the value hidden in the _balance attribute.",
            ),
            choice(
                "What does the underscore at the start of the name self._balance mean?",
                listOf("A convention: it's an internal attribute, don't change it from outside", "The attribute is completely inaccessible", "The attribute is a constant", "A syntax error"),
                0,
                "Python doesn't block access – the underscore is just a convention among programmers.",
            ),
            tiles(
                "Print the property area of the object p",
                listOf("print(", "p.area", ")"),
                listOf("()", "self"),
                "We read a property without call parentheses.",
            ),
        ),
        lesson(
            "u31l4", "Setter with validation",
            output(
                "class Person:\n    def __init__(self, age):\n        self._age = age\n    @property\n    def age(self):\n        return self._age\n    @age.setter\n    def age(self, a):\n        self._age = max(0, a)\n\np = Person(20)\np.age = -5\nprint(p.age)",
                "0",
                "The setter corrects a negative age to 0.",
            ),
            fill(
                "Fill in the setter's decorator.",
                "class Player:\n    def __init__(self):\n        self._hp = 10\n    @property\n    def hp(self):\n        return self._hp\n    @hp.____\n    def hp(self, v):\n        self._hp = v\n\ng = Player()\ng.hp = 3\nprint(g.hp)",
                listOf("setter", "property", "set"),
                "setter",
                "We create a setter with the decorator @name.setter.",
            ),
            output(
                "class Product:\n    _price = 0\n    @property\n    def price(self):\n        return self._price\n    @price.setter\n    def price(self, c):\n        if c >= 0:\n            self._price = c\n\np = Product()\np.price = 50\np.price = -1\nprint(p.price)",
                "50",
                "The setter ignores a negative price, so it stays 50.",
            ),
            choice(
                "What does the setter decorator for the property age look like?",
                listOf("@age.setter", "@setter", "@property.setter", "@set_age"),
                0,
                "We link the setter to the property through its name: @age.setter.",
            ),
            output(
                "class Temp:\n    def __init__(self, c):\n        self.c = c\n    @property\n    def c(self):\n        return self._c\n    @c.setter\n    def c(self, v):\n        self._c = round(v)\n\nprint(Temp(21.7).c)",
                "22",
                "The assignment self.c in __init__ also goes through the setter, which rounds the value.",
            ),
            choice(
                "Why does the getter age return self._age and not self.age?",
                listOf("self.age would call the getter endlessly (RecursionError)", "self.age is slower", "The decorator's syntax requires it", "No difference"),
                0,
                "Reading self.age in the getter would call the same getter – that's infinite recursion.",
            ),
            tiles(
                "Set the property age of the object p to 30 (the setter will run)",
                listOf("p.age", "=", "30"),
                listOf("==", "p.age("),
                "The setter is called on a regular assignment.",
            ),
        ),
        lesson(
            "u31l5", "Review: class attributes and methods",
            output(
                "class Ticket:\n    sold = 0\n    def __init__(self):\n        Ticket.sold += 1\n    @classmethod\n    def how_many(cls):\n        return cls.sold\n\nfor _ in range(3):\n    Ticket()\nprint(Ticket.how_many())",
                "3",
                "Three objects increased the shared counter, and the class method returns it.",
            ),
            choice(
                "Which method gets the class as its first argument?",
                listOf("One with the @classmethod decorator", "One with the @staticmethod decorator", "A regular method", "One with the @property decorator"),
                0,
                "@classmethod passes the class in the cls parameter.",
            ),
            output(
                "class Circle:\n    def __init__(self, r):\n        self.r = r\n    @staticmethod\n    def square(x):\n        return x * x\n    def area(self):\n        return 3 * self.square(self.r)\n\nprint(Circle(2).area())",
                "12",
                "A static method can also be called through self.",
            ),
            output(
                "class Password:\n    @staticmethod\n    def is_good(p):\n        return len(p) >= 8\n\nprint(Password.is_good(\"abc\"))\nprint(Password.is_good(\"secret1234\"))",
                "False\nTrue",
                "The static method only checks the length of the given string.",
            ),
            fill(
                "Fill in the blank so the program prints 8.",
                "class Circle:\n    def __init__(self, r):\n        self.r = r\n    @property\n    def diameter(self):\n        return 2 * self.r\n\nk = Circle(4)\nprint(k.____)",
                listOf("diameter", "diameter()", "r()"),
                "diameter",
                "We read a property without parentheses.",
            ),
            output(
                "class Temp:\n    def __init__(self, c):\n        self.c = c\n    @property\n    def c(self):\n        return self._c\n    @c.setter\n    def c(self, v):\n        self._c = max(-273, v)\n\nprint(Temp(-300).c)",
                "-273",
                "The setter doesn't let the value go below -273.",
            ),
            choice(
                "What will this code print?",
                listOf("1", "2", "None", "AttributeError"),
                0,
                "a.x = 2 changes only the object a; b still sees the class attribute.",
                code = "class A:\n    x = 1\n\na = A()\nb = A()\na.x = 2\nprint(b.x)",
            ),
            tiles(
                "Create the object d with the class method from_string of the class Date, using the string \"1.5\"",
                listOf("d", "=", "Date.from_string(", "\"1.5\"", ")"),
                listOf("new", "self."),
                "We call an alternative constructor through the class name.",
            ),
        ),
    ),
)
