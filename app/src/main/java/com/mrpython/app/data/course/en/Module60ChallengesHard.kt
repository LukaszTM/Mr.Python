package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*
import com.mrpython.app.domain.CourseUnit

internal val module60 = CourseUnit(
    id = "u60",
    title = "Challenges: hard",
    description = "Tricky puzzles: closures, copies, iterators, MRO and decorators",
    lessons = listOf(
        lesson(
            "u60l1", "Challenge 1: mutable default values",
            output(
                "def f(x, a=[]):\n    a.append(x)\n    return a\n\nf(1)\nprint(f(2))",
                "[1, 2]",
                "The default list is created once and shared by all calls.",
            ),
            output(
                "def f(x, a=None):\n    if a is None:\n        a = []\n    a.append(x)\n    return a\n\nf(1)\nprint(f(2))",
                "[2]",
                "A new list is created on every call.",
            ),
            choice(
                "What does this code print?",
                listOf("[0, 1] [0, 1]", "[0] [0, 1]", "[0] [0]", "[0] [1]"),
                0,
                "Both calls return the same list, and print sees it after both changes.",
                code = "def f(a=[]):\n    a.append(len(a))\n    return a\n\nprint(f(), f())",
            ),
            output(
                "def f(d={}):\n    d[\"n\"] = d.get(\"n\", 0) + 1\n    return d[\"n\"]\n\nf()\nf()\nprint(f())",
                "3",
                "The default dictionary remembers its state between calls.",
            ),
            output(
                "def f(x, a=[]):\n    a = a + [x]\n    return a\n\nf(1)\nprint(f(2))",
                "[2]",
                "a + [x] creates a new list, so the default list doesn't change.",
            ),
            choice(
                "When is the default list in def f(a=[]) created?",
                listOf("Once – when the def statement runs", "On every call to f", "On the first call without a", "Only at the first append"),
                0,
                "Default values are evaluated once, at the moment the function is defined.",
            ),
            fill(
                "Fill in the blank to print [2].",
                "def add(x, items=____):\n    if items is None:\n        items = []\n    items.append(x)\n    return items\n\nadd(1)\nprint(add(2))",
                listOf("None", "[]", "()"),
                "None",
                "None as the default value lets you create a new list on every call.",
            ),
            tiles(
                "Create a new list when the argument a was not given",
                listOf("if", "a", "is", "None:", "a = []"),
                listOf("not", "False:"),
                "This is the safe pattern to use instead of a default list.",
            ),
        ),
        lesson(
            "u60l2", "Challenge 2: closures and late binding",
            output(
                "fs = [lambda: i for i in range(3)]\nprint([f() for f in fs])",
                "[2, 2, 2]",
                "The lambdas read i only when called, and by then i = 2.",
            ),
            output(
                "fs = [lambda i=i: i for i in range(3)]\nprint([f() for f in fs])",
                "[0, 1, 2]",
                "The default value captures i at the moment the lambda is created.",
            ),
            output(
                "def counter():\n    n = 0\n    def inc():\n        nonlocal n\n        n += 1\n        return n\n    return inc\n\nc = counter()\nc()\nprint(c())",
                "2",
                "The closure remembers n between calls.",
            ),
            choice(
                "What does this code print?",
                listOf("2", "1", "Error", "None"),
                0,
                "The function reads x when it is called, not when it is defined.",
                code = "x = 1\ndef f():\n    return x\n\nx = 2\nprint(f())",
            ),
            output(
                "def multiply(k):\n    return lambda x: x * k\n\ntimes3 = multiply(3)\nprint(times3(5))",
                "15",
                "The lambda remembers k = 3 from the multiply function.",
            ),
            output(
                "i = 10\nf = lambda: i\ni = 20\nprint(f())",
                "20",
                "The lambda doesn't copy i – it looks it up when called.",
            ),
            choice(
                "What happens?",
                listOf("UnboundLocalError", "x will equal 2", "SyntaxError", "Nothing"),
                0,
                "Assigning to x makes x a local variable that hasn't been given a value yet.",
                code = "x = 1\ndef f():\n    x += 1\n\nf()",
            ),
            fill(
                "Fill in the blank to print 2.",
                "def counter():\n    n = 0\n    def inc():\n        ____ n\n        n += 1\n        return n\n    return inc\n\nc = counter()\nc()\nprint(c())",
                listOf("nonlocal", "global", "del"),
                "nonlocal",
                "nonlocal lets you change a variable from the enclosing function.",
            ),
        ),
        lesson(
            "u60l3", "Challenge 3: is vs. ==",
            output(
                "a = [1, 2]\nb = [1, 2]\nprint(a == b, a is b)",
                "True False",
                "The lists are equal, but they are two different objects.",
            ),
            output(
                "a = [1]\nb = a\nb += [2]\nprint(a, a is b)",
                "[1, 2] True",
                "+= on a list changes it in place.",
            ),
            output(
                "a = [1]\nb = a\nb = b + [2]\nprint(a, a is b)",
                "[1] False",
                "b + [2] creates a new list and b now points to it.",
            ),
            choice(
                "What does this code print?",
                listOf("False", "True", "Error", "None"),
                0,
                "Without __eq__, the == operator compares object identity.",
                code = "class A:\n    pass\n\nprint(A() == A())",
            ),
            output(
                "a = \"ab\"\nb = a\na += \"c\"\nprint(b)",
                "ab",
                "Strings are immutable – a += \"c\" creates a new string.",
            ),
            choice(
                "What is the is operator best used for?",
                listOf("Comparing with None", "Comparing numbers", "Comparing strings", "Always instead of =="),
                0,
                "is checks identity – perfect for None, but not for values.",
            ),
            choice(
                "What does this code print?",
                listOf("True False", "True True", "False False", "False True"),
                0,
                "The slice [:] creates a new list with the same contents.",
                code = "a = [1, 2, 3]\nb = a[:]\nprint(a == b, a is b)",
            ),
            fill(
                "Fill in the blank to print \"missing\".",
                "result = None\nif result ____ None:\n    print(\"missing\")",
                listOf("is", "is not", "!="),
                "is",
                "We compare with None using is.",
            ),
        ),
        lesson(
            "u60l4", "Challenge 4: shallow and deep copies",
            output(
                "a = [[0] * 2] * 2\na[0][0] = 1\nprint(a)",
                "[[1, 0], [1, 0]]",
                "* 2 repeats a reference to the same inner list.",
            ),
            output(
                "a = [[0] * 2 for _ in range(2)]\na[0][0] = 1\nprint(a)",
                "[[1, 0], [0, 0]]",
                "The list comprehension creates a separate list for each row.",
            ),
            output(
                "a = [[1], [2]]\nb = a.copy()\nb[0].append(9)\nprint(a)",
                "[[1, 9], [2]]",
                "copy() is shallow – the inner lists are shared.",
            ),
            output(
                "a = [[1], [2]]\nb = a.copy()\nb.append([3])\nprint(len(a))",
                "2",
                "The outer list is a separate object now.",
            ),
            output(
                "import copy\na = [[1]]\nb = copy.deepcopy(a)\nb[0].append(2)\nprint(a)",
                "[[1]]",
                "deepcopy copies the inner lists too.",
            ),
            choice(
                "What does this code print?",
                listOf("1", "9", "[9, 2, 3]", "Error"),
                0,
                "a[:] is a new list, so changing b doesn't touch a.",
                code = "a = [1, 2, 3]\nb = a[:]\nb[0] = 9\nprint(a[0])",
            ),
            choice(
                "What does this code print?",
                listOf("{'k': [1, 2]}", "{'k': [1]}", "{'k': [2]}", "Error"),
                0,
                "dict(d) is a shallow copy – the list under the key is shared.",
                code = "d = {\"k\": [1]}\ne = dict(d)\ne[\"k\"].append(2)\nprint(d)",
            ),
            fill(
                "Fill in the blank to print [[1], [2]].",
                "import copy\na = [[1], [2]]\nb = copy.____(a)\nb[0].append(5)\nprint(a)",
                listOf("deepcopy", "copy", "replace"),
                "deepcopy",
                "Only a deep copy separates the inner lists.",
            ),
        ),
        lesson(
            "u60l5", "Challenge 5: exhausted iterators",
            output(
                "g = (x for x in range(3))\nprint(sum(g), sum(g))",
                "3 0",
                "A generator can be iterated only once – the second time it's empty.",
            ),
            choice(
                "What does this code print?",
                listOf("True [3]", "True [1, 2, 3]", "True []", "False [3]"),
                0,
                "in consumes elements until it finds 2.",
                code = "g = iter([1, 2, 3])\nprint(2 in g, list(g))",
            ),
            output(
                "z = zip([1, 2], [3, 4])\nlist(z)\nprint(list(z))",
                "[]",
                "zip is an iterator – after one pass it's empty.",
            ),
            output(
                "m = map(str, [1, 2])\nprint(len(list(m)) + len(list(m)))",
                "2",
                "The first list() takes both elements, the second gets an empty list.",
            ),
            output(
                "g = (x * x for x in range(4))\nnext(g)\nprint(list(g))",
                "[1, 4, 9]",
                "next() already took the first value, 0.",
            ),
            choice(
                "What happens?",
                listOf("StopIteration", "It prints 1", "It prints None", "Nothing"),
                0,
                "The generator had one value – the second next() raises StopIteration.",
                code = "g = (x for x in [1])\nnext(g)\nprint(next(g))",
            ),
            fill(
                "Fill in the blank to print 6 6.",
                "data = ____(x * 2 for x in range(3))\nprint(sum(data), sum(data))",
                listOf("list", "iter", "next"),
                "list",
                "A list can be iterated many times, a generator only once.",
            ),
            tiles(
                "Create an iterator from the list data and get its first element",
                listOf("first =", "next(", "iter(data)", ")"),
                listOf("list(data)", "len("),
                "iter() creates an iterator, and next() gets the next element from it.",
            ),
        ),
        lesson(
            "u60l6", "Challenge 6: MRO and decorators",
            choice(
                "What does this code print?",
                listOf("C", "A", "B", "Error"),
                0,
                "The lookup order is D, B, C, A – C has the method before A does.",
                code = "class A:\n    def k(self): return \"A\"\nclass B(A): pass\nclass C(A):\n    def k(self): return \"C\"\nclass D(B, C): pass\n\nprint(D().k())",
            ),
            output(
                "class A: pass\nclass B(A): pass\nclass C(A): pass\nclass D(B, C): pass\n\nprint([k.__name__ for k in D.__mro__])",
                "['D', 'B', 'C', 'A', 'object']",
                "The MRO visits A only after both intermediate classes.",
            ),
            output(
                "class A:\n    def h(self): return \"A\"\nclass B(A):\n    def h(self): return \"B\" + super().h()\nclass C(A):\n    def h(self): return \"C\" + super().h()\nclass D(B, C):\n    def h(self): return \"D\" + super().h()\n\nprint(D().h())",
                "DBCA",
                "super() in B leads to C, because it follows the MRO of class D.",
            ),
            output(
                "def a(f):\n    return lambda: \"a\" + f()\ndef b(f):\n    return lambda: \"b\" + f()\n\n@a\n@b\ndef f():\n    return \"f\"\n\nprint(f())",
                "abf",
                "The closest decorator is applied first: f = a(b(f)).",
            ),
            output(
                "def d(f):\n    print(\"dec\")\n    return f\n\n@d\ndef g():\n    print(\"g\")\n\ng()\ng()",
                "dec\ng\ng",
                "The decorator runs once – when the function is defined.",
            ),
            choice(
                "What is writing @x above @y above def f equivalent to?",
                listOf("f = x(y(f))", "f = y(x(f))", "f = x(f) + y(f)", "f = x(f), and y is skipped"),
                0,
                "Decorators are applied from bottom to top.",
            ),
            fill(
                "Fill in the blank to print \"hello\".",
                "import functools\n\ndef d(f):\n    @functools.____(f)\n    def w():\n        return f()\n    return w\n\n@d\ndef hello(): pass\n\nprint(hello.__name__)",
                listOf("wraps", "partial", "cache"),
                "wraps",
                "functools.wraps copies the name and docstring of the original function.",
            ),
            tiles(
                "Define an empty class D that inherits first from B, then from C",
                listOf("class", "D(B, C):", "pass"),
                listOf("D(C, B):", "def"),
                "The order of base classes in the parentheses affects the MRO.",
            ),
        ),
        lesson(
            "u60l7", "Challenge 7: comparisons and short-circuiting",
            choice(
                "What does this code print?",
                listOf("True", "False", "Error", "2"),
                0,
                "It means 1 < 3 and 3 > 2.",
                code = "print(1 < 3 > 2)",
            ),
            output(
                "print(5 > 3 == 3, (5 > 3) == 3)",
                "True False",
                "The chain is 5 > 3 and 3 == 3, while in parentheses we compare True with 3.",
            ),
            output(
                "print(0 or [] or \"x\", 1 and 0 and 2)",
                "x 0",
                "or returns the first truthy value, and – the first falsy one.",
            ),
            output(
                "def f():\n    print(\"f\")\n    return True\n\nprint(False and f())",
                "False",
                "and stops at False, so f() is never called.",
            ),
            output(
                "def f(x):\n    print(x)\n    return x\n\nr = f(0) or f(2) or f(3)\nprint(r)",
                "0\n2\n2",
                "or stops at the first truthy value – f(3) is never called.",
            ),
            choice(
                "What does this code print?",
                listOf("0", "None", "False", "True"),
                0,
                "When both values are falsy, or returns the last one.",
                code = "print(None or 0)",
            ),
            fill(
                "Fill in the blank to print False without an error.",
                "d = 0\nok = d != 0 ____ 10 / d > 1\nprint(ok)",
                listOf("and", "or", "&"),
                "and",
                "and doesn't evaluate the right side when the left is falsy – we don't divide by zero.",
            ),
            tiles(
                "Check whether x is in the range from 0 (inclusive) to 10 (exclusive)",
                listOf("if", "0 <=", "x", "< 10:"),
                listOf("and", "=<"),
                "Comparisons can be chained.",
            ),
        ),
    ),
)
