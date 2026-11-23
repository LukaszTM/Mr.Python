package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

internal val module32Cards = listOf(
    cards(
        "u32l1",
        explain(
            "The str() and repr() functions",
            "`str(object)` calls `__str__`, and `repr(object)` calls `__repr__`. Both methods must " +
                "return a string – returning a number, for example, ends in a `TypeError`.",
            code = "class A:\n    def __str__(self):\n        return \"pretty\"\n    def __repr__(self):\n        return \"A()\"\n\nprint(str(A()), repr(A()))",
            output = "pretty A()",
        ),
        explain(
            "The default description",
            "When a class has neither `__str__` nor `__repr__`, `print()` shows only the class name and a memory address, " +
                "e.g. `<__main__.Cat object at 0x7f…>`. A good `__repr__` usually looks like the code that creates the object, e.g. `Point(1, 2)`.",
        ),
    ),
    cards(
        "u32l2",
        explain(
            "!= and > for free",
            "When a class has `__eq__`, Python works out `!=` by itself as its opposite. When it has only `__lt__`, " +
                "it turns `a > b` into `b < a`.",
            code = "class W:\n    def __init__(self, w):\n        self.w = w\n    def __lt__(self, o):\n        return self.w < o.w\n\nprint(W(5) > W(2))",
            output = "True",
        ),
        explain(
            "No comparison",
            "Without `__lt__`, Python doesn't know how to compare objects with the `<` operator, so it raises a `TypeError` – " +
                "that's why `sorted()` can't sort objects without this method (unless you pass `key`).",
        ),
    ),
    cards(
        "u32l3",
        explain(
            "Indexes and slices",
            "`__getitem__` receives exactly what's inside the brackets: a number, a negative index, or even a slice " +
                "like `1:3`. When we pass it on to a list, it works just like it does on a list.",
            code = "class W:\n    days = [\"Mon\", \"Tue\", \"Wed\"]\n    def __getitem__(self, i):\n        return self.days[i]\n\nw = W()\nprint(w[-1], w[0:2])",
            output = "Wed ['Mon', 'Tue']",
        ),
        explain(
            "Looping thanks to __getitem__",
            "If a class has `__getitem__`, a `for` loop asks for indexes 0, 1, 2… until the method raises an `IndexError`. " +
                "`__len__` must return a non-negative integer – without that method, `len()` gives a `TypeError`.",
            code = "class Three:\n    def __getitem__(self, i):\n        if i >= 3:\n            raise IndexError\n        return i * 10\n\nfor x in Three():\n    print(x)",
            output = "0\n10\n20",
        ),
    ),
    cards(
        "u32l4",
        explain(
            "Multiplying by a number",
            "`__mul__` handles `object * 3`. The reversed form, `3 * object`, calls the object's `__rmul__` – " +
                "without that method it ends in a `TypeError`.",
            code = "class Money:\n    def __init__(self, dollars):\n        self.dollars = dollars\n    def __mul__(self, n):\n        return Money(self.dollars * n)\n    def __rmul__(self, n):\n        return self * n\nprint((Money(5) * 3).dollars, (2 * Money(7)).dollars)",
            output = "15 14",
        ),
        explain(
            "+= and the unary minus",
            "When a class has `__add__`, writing `c += 5` works like `c = c + 5` and creates a new object. " +
                "A minus in front of an object, `-w`, calls the `__neg__` method.",
            code = "class W:\n    def __init__(self, x):\n        self.x = x\n    def __neg__(self):\n        return W(-self.x)\n\nprint((-W(4)).x)",
            output = "-4",
        ),
    ),
)
