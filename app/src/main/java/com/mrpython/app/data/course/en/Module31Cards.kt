package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

internal val module31Cards = listOf(
    cards(
        "u31l1",
        explain(
            "Object first, then class",
            "Reading `a.x` looks for x in the object first, and if it isn't there – in the class. The assignment " +
                "`a.x = 5` (or `a.x += 1`) creates an attribute in the object itself, and `A.x` doesn't change.",
            code = "class A:\n    x = 1\n\na = A()\na.x = 5\nprint(a.x, A.x)",
            output = "5 1",
        ),
        explain(
            "A shared list in the class",
            "Watch out for lists in class attributes: `append()` doesn't create a new attribute, it changes " +
                "the one shared list. A change made through one object is visible in all of them.",
            code = "class Basket:\n    items = []\n\na = Basket()\nb = Basket()\na.items.append(\"cheese\")\nprint(b.items)",
            output = "['cheese']",
        ),
    ),
    cards(
        "u31l2",
        explain(
            "An object from a string",
            "A class method can prepare the data and then call the regular constructor `cls(...)`. Here it splits " +
                "the string “24.12” into two parts and converts them to numbers.",
            code = "class Date:\n    def __init__(self, d, m):\n        self.d, self.m = d, m\n    @classmethod\n    def from_string(cls, s):\n        d, m = s.split(\".\")\n        return cls(int(d), int(m))\nprint(Date.from_string(\"24.12\").m)",
            output = "12",
        ),
        explain(
            "cls changes the class",
            "Through `cls` a class method reads and changes class attributes, e.g. `cls.count += 1`. " +
                "`cls.__name__` is the name of the class as a string.",
            code = "class Counter:\n    count = 0\n    @classmethod\n    def increase(cls):\n        cls.count += 1\n\nCounter.increase()\nprint(Counter.count, Counter.__name__)",
            output = "1 Counter",
        ),
        explain(
            "Calling through an object",
            "Static methods and class methods can be called through the class, but also through an object – inside " +
                "the class as well, e.g. `self.square(x)`.",
            code = "class Math:\n    @staticmethod\n    def sq(x):\n        return x * x\n\nprint(Math.sq(3), Math().sq(4))",
            output = "9 16",
        ),
    ),
    cards(
        "u31l3",
        explain(
            "No parentheses!",
            "Reading a property gives you the result right away, e.g. a number. If you add parentheses `obj.x()`, Python " +
                "will try to call that number and raise a `TypeError`. Without a setter a property is read-only: " +
                "the assignment `obj.x = 10` raises an `AttributeError`.",
            code = "class A:\n    @property\n    def x(self):\n        return 7\n\nprint(A().x)",
            output = "7",
        ),
    ),
    cards(
        "u31l4",
        explain(
            "The setter works in __init__ too",
            "When you write `self.c = c` in `__init__` and `c` is a property with a setter, the assignment " +
                "goes through the setter. Thanks to that, validation already works when the object is created.",
            code = "class Temp:\n    def __init__(self, c):\n        self.c = c\n    @property\n    def c(self):\n        return self._c\n    @c.setter\n    def c(self, v):\n        self._c = round(v)\nprint(Temp(21.7).c)",
            output = "22",
        ),
        explain(
            "Why self._age?",
            "Inside the getter and the setter we use the hidden `self._age`. Reading `self.age` in the getter " +
                "would call the same getter endlessly (`RecursionError`). Writing straight to `_age` bypasses the setter.",
            code = "class T:\n    @property\n    def x(self):\n        return self._x\n    @x.setter\n    def x(self, v):\n        self._x = max(0, v)\nt = T()\nt._x = -5\nprint(t.x)",
            output = "-5",
        ),
        explain(
            "Rejecting a bad value",
            "Whatever a setter returns is ignored. To reject a bad value, the setter raises an exception, " +
                "e.g. `if v < 0: raise ValueError(\"negative\")` – then the assignment doesn't happen.",
        ),
    ),
    cards(
        "u31l5",
        explain(
            "A default value with or",
            "`x or y` returns x when x is “truthy”, and y otherwise. When a parameter has the value " +
                "`None` (or an empty string), `n or default` substitutes the default value.",
            code = "print(None or \"black\")\nprint(\"green\" or \"black\")",
            output = "black\ngreen",
        ),
    ),
)
