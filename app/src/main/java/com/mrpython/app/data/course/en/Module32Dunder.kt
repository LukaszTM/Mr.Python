package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*
import com.mrpython.app.domain.CourseUnit

internal val module32 = CourseUnit(
    id = "u32",
    title = "Special methods",
    description = "__repr__, comparisons, operators, and your own collections",
    lessons = listOf(
        lesson(
            "u32l1", "__repr__ and __str__",
            output(
                "class Dog:\n    def __init__(self, name):\n        self.name = name\n    def __repr__(self):\n        return f\"Dog('{self.name}')\"\n\nprint(Dog(\"Rex\"))",
                "Dog('Rex')",
                "Without __str__, print uses __repr__.",
            ),
            output(
                "class P:\n    def __init__(self, x):\n        self.x = x\n    def __repr__(self):\n        return f\"P({self.x})\"\n\nprint([P(1), P(2)])",
                "[P(1), P(2)]",
                "A list shows its items using __repr__.",
            ),
            output(
                "class Pill:\n    def __str__(self):\n        return \"pill\"\n    def __repr__(self):\n        return \"Pill()\"\n\np = Pill()\nprint(p)\nprint([p])",
                "pill\n[Pill()]",
                "print(object) uses __str__, while the list uses __repr__ for what's inside.",
            ),
            choice(
                "What is __repr__ for?",
                listOf("An unambiguous description of the object for the programmer", "Pretty text for the user", "Comparing objects", "Creating an object"),
                0,
                "__repr__ is a technical description, often looking like the code that creates the object.",
            ),
            output(
                "class A:\n    def __str__(self):\n        return \"pretty\"\n    def __repr__(self):\n        return \"technical\"\n\na = A()\nprint(str(a), repr(a))",
                "pretty technical",
                "str() calls __str__, and repr() calls __repr__.",
            ),
            fill(
                "Fill in the blank so the program prints [Point(1, 2)].",
                "class Point:\n    def ____(self):\n        return \"Point(1, 2)\"\n\nprint([Point()])",
                listOf("__repr__", "__str__", "__init__"),
                "__repr__",
                "List items are shown with __repr__, not __str__.",
            ),
            choice(
                "What does print(object) show when the class has neither __str__ nor __repr__?",
                listOf("Something like <__main__.Class object at 0x...>", "Nothing", "A TypeError", "A list of attributes"),
                0,
                "The default description contains only the class name and a memory address.",
            ),
            tiles(
                "Write the header of the __repr__ method",
                listOf("def", "__repr__(", "self", "):"),
                listOf("return", "__print__("),
                "__repr__ takes only self and returns a string.",
            ),
        ),
        lesson(
            "u32l2", "__eq__ and __lt__",
            output(
                "class P:\n    def __init__(self, x):\n        self.x = x\n\nprint(P(1) == P(1))",
                "False",
                "Without __eq__, the == operator checks whether it's the same object.",
            ),
            output(
                "class P:\n    def __init__(self, x):\n        self.x = x\n    def __eq__(self, other):\n        return self.x == other.x\n\nprint(P(1) == P(1))\nprint(P(1) != P(2))",
                "True\nTrue",
                "__eq__ compares attributes, and Python works out != from __eq__.",
            ),
            choice(
                "What does == check by default for objects of your own class?",
                listOf("Whether it's the same object", "Whether all attributes are equal", "Whether they have the same class", "It always returns True"),
                0,
                "Without __eq__, two different objects are never equal.",
            ),
            output(
                "class Task:\n    def __init__(self, p):\n        self.p = p\n    def __lt__(self, other):\n        return self.p < other.p\n    def __repr__(self):\n        return f\"Task({self.p})\"\n\nprint(sorted([Task(3), Task(1), Task(2)]))",
                "[Task(1), Task(2), Task(3)]",
                "sorted compares objects with the < operator, which means the __lt__ method.",
            ),
            fill(
                "Fill in the blank so sorted orders people by age, youngest first (prints 20).",
                "class Person:\n    def __init__(self, age):\n        self.age = age\n    def ____(self, other):\n        return self.age < other.age\n\npeople = sorted([Person(30), Person(20)])\nprint(people[0].age)",
                listOf("__lt__", "__eq__", "__gt__"),
                "__lt__",
                "__lt__ (less than) handles the < operator, which sorted uses.",
            ),
            output(
                "class Card:\n    def __init__(self, v):\n        self.v = v\n    def __lt__(self, o):\n        return self.v < o.v\n\nc = max([Card(5), Card(9), Card(2)])\nprint(c.v)",
                "9",
                "max can compare objects too, as long as they have __lt__.",
            ),
            choice(
                "What happens when you run this code?",
                listOf("TypeError – no < comparison", "It prints True", "It prints False", "SyntaxError"),
                0,
                "Without __lt__, Python doesn't know how to compare two objects with the < operator.",
                code = "class P:\n    def __init__(self, x):\n        self.x = x\n\nprint(P(1) < P(2))",
            ),
            tiles(
                "Compare objects a and b with the equality operator and print the result",
                listOf("print(", "a", "==", "b", ")"),
                listOf("=", "equals("),
                "The == operator calls the __eq__ method.",
            ),
        ),
        lesson(
            "u32l3", "__len__, __contains__, and __getitem__",
            output(
                "class Playlist:\n    def __init__(self, songs):\n        self.songs = songs\n    def __len__(self):\n        return len(self.songs)\n\np = Playlist([\"a\", \"b\", \"c\"])\nprint(len(p))",
                "3",
                "len(object) calls the __len__ method.",
            ),
            output(
                "class Club:\n    def __init__(self):\n        self.members = [\"Anna\", \"Olivia\"]\n    def __contains__(self, name):\n        return name in self.members\n\nc = Club()\nprint(\"Anna\" in c, \"Eve\" in c)",
                "True False",
                "The in operator calls the __contains__ method.",
            ),
            output(
                "class Week:\n    days = [\"Mon\", \"Tue\", \"Wed\"]\n    def __getitem__(self, i):\n        return self.days[i]\n\nw = Week()\nprint(w[0], w[-1])",
                "Mon Wed",
                "Square brackets, object[i], call __getitem__.",
            ),
            output(
                "class Three:\n    def __getitem__(self, i):\n        if i >= 3:\n            raise IndexError\n        return i * 10\n\nfor x in Three():\n    print(x)",
                "0\n10\n20",
                "The for loop asks for one index after another until it gets an IndexError.",
            ),
            fill(
                "Fill in the blank so len(b) works.",
                "class Box:\n    def __init__(self):\n        self.data = [1, 2]\n    def ____(self):\n        return len(self.data)\n\nb = Box()\nprint(len(b))",
                listOf("__len__", "len", "__size__"),
                "__len__",
                "The len() function looks for the __len__ method.",
            ),
            choice(
                "Which special method handles the in operator?",
                listOf("__contains__", "__in__", "__has__", "__include__"),
                0,
                "x in object calls object.__contains__(x).",
            ),
            choice(
                "Which method lets you write object[0]?",
                listOf("__getitem__", "__get__", "__item__", "__at__"),
                0,
                "Reading with square brackets is handled by __getitem__.",
            ),
            tiles(
                "Check whether \"Anna\" belongs to the object club, and print the result",
                listOf("print(", "\"Anna\"", "in", "club", ")"),
                listOf("club.has(", "=="),
                "The in operator uses __contains__.",
            ),
        ),
        lesson(
            "u32l4", "__add__ and other operators",
            output(
                "class Vector:\n    def __init__(self, x, y):\n        self.x = x\n        self.y = y\n    def __add__(self, o):\n        return Vector(self.x + o.x, self.y + o.y)\n\nv = Vector(1, 2) + Vector(3, 4)\nprint(v.x, v.y)",
                "4 6",
                "The + operator calls __add__, which returns a new vector.",
            ),
            output(
                "class Money:\n    def __init__(self, dollars):\n        self.dollars = dollars\n    def __mul__(self, n):\n        return Money(self.dollars * n)\n\nprint((Money(5) * 3).dollars)",
                "15",
                "The * operator calls __mul__.",
            ),
            choice(
                "Which method handles the subtraction a - b?",
                listOf("__sub__", "__minus__", "__neg__", "__del__"),
                0,
                "__sub__ is subtraction; __neg__ handles the unary minus (-a).",
            ),
            fill(
                "Fill in the blank so the program prints 15.",
                "class Time:\n    def __init__(self, m):\n        self.m = m\n    def ____(self, o):\n        return Time(self.m + o.m)\n\nprint((Time(10) + Time(5)).m)",
                listOf("__add__", "__plus__", "__sum__"),
                "__add__",
                "The + operator looks for the __add__ method.",
            ),
            choice(
                "What happens when you run this code?",
                listOf("TypeError – a number can't multiply itself by a Money", "m will be a Money with dollars = 15", "m will be the number 15", "SyntaxError"),
                0,
                "3 * object requires the __rmul__ method; __mul__ alone only works for object * 3.",
                code = "class Money:\n    def __init__(self, dollars):\n        self.dollars = dollars\n    def __mul__(self, n):\n        return Money(self.dollars * n)\n\nm = 3 * Money(5)",
            ),
            output(
                "class Basket:\n    def __init__(self, items):\n        self.items = items\n    def __add__(self, o):\n        return Basket(self.items + o.items)\n\nb = Basket([\"bread\"]) + Basket([\"milk\"])\nprint(b.items)",
                "['bread', 'milk']",
                "__add__ joins the lists from both baskets.",
            ),
            output(
                "class Counter:\n    def __init__(self, n):\n        self.n = n\n    def __add__(self, k):\n        return Counter(self.n + k)\n\nc = Counter(1)\nc += 5\nprint(c.n)",
                "6",
                "Without __iadd__, writing c += 5 uses __add__.",
            ),
            tiles(
                "Write the header of the method that handles the + operator",
                listOf("def", "__add__(", "self,", "other):"),
                listOf("__plus__(", "+"),
                "Addition is handled by __add__(self, other).",
            ),
        ),
        lesson(
            "u32l5", "Review: special methods",
            output(
                "class Grade:\n    def __init__(self, v):\n        self.v = v\n    def __lt__(self, o):\n        return self.v < o.v\n    def __repr__(self):\n        return str(self.v)\n\nprint(sorted([Grade(4), Grade(2)]))",
                "[2, 4]",
                "__lt__ makes sorting possible, and __repr__ decides how items look in the list.",
            ),
            choice(
                "Which method does len(object) call?",
                listOf("__len__", "__size__", "__count__", "__getitem__"),
                0,
                "len() uses __len__.",
            ),
            output(
                "class Color:\n    def __init__(self, n):\n        self.n = n\n    def __eq__(self, o):\n        return self.n.lower() == o.n.lower()\n\nprint(Color(\"RED\") == Color(\"red\"))",
                "True",
                "Our __eq__ compares the names ignoring upper and lower case.",
            ),
            output(
                "class Word:\n    def __init__(self, s):\n        self.s = s\n    def __len__(self):\n        return len(self.s)\n    def __getitem__(self, i):\n        return self.s[i]\n\nw = Word(\"cat\")\nprint(len(w), w[1])",
                "3 a",
                "len() uses __len__, and w[1] uses __getitem__.",
            ),
            fill(
                "Fill in the blank so the program prints 7.",
                "class Points:\n    def __init__(self, n):\n        self.n = n\n    def ____(self, o):\n        return Points(self.n - o.n)\n\nprint((Points(10) - Points(3)).n)",
                listOf("__sub__", "__add__", "__minus__"),
                "__sub__",
                "The - operator calls __sub__.",
            ),
            choice(
                "Which method does print(x) use when the class has only __repr__?",
                listOf("__repr__", "__len__", "__init__", "__eq__"),
                0,
                "When there's no __str__, Python uses __repr__.",
            ),
            output(
                "class Range:\n    def __init__(self, a, b):\n        self.a = a\n        self.b = b\n    def __contains__(self, x):\n        return self.a <= x <= self.b\n\nr = Range(1, 10)\nprint(5 in r, 11 in r)",
                "True False",
                "__contains__ checks whether the number falls within the range.",
            ),
            tiles(
                "Add vectors a and b and store the result in v",
                listOf("v", "=", "a", "+", "b"),
                listOf("a.add(", "=="),
                "Thanks to __add__, you add objects with a plain plus sign.",
            ),
        ),
    ),
)
