package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

internal val module60Intro = lesson(
    "u60l0", "Introduction: hard challenges",
    explain(
        "Mutable default values",
        "A default `[]` or `{}` in a parameter is created once, when the function is defined, and is shared " +
            "by all calls. The safe pattern: `a=None`, and a new list inside when `a is None`.",
        code = "def f(x, a=[]):\n    a.append(x)\n    return a\n\nf(1)\nprint(f(2))",
        output = "[1, 2]",
    ),
    explain(
        "Closures and late binding",
        "An inner function remembers variables from its surroundings, but reads them only when it is called – " +
            "that's why lambdas from a loop see the last `i`. `lambda i=i: i` helps, and `nonlocal` lets you " +
            "change a variable from the enclosing function.",
        code = "fs = [lambda: i for i in range(3)]\nprint([f() for f in fs])\nfs = [lambda i=i: i for i in range(3)]\nprint([f() for f in fs])",
        output = "[2, 2, 2]\n[0, 1, 2]",
    ),
    explain(
        "is vs. ==",
        "`==` checks whether the values are equal, and `is` – whether it's the same object. `+=` changes " +
            "a list in place, while `b = b + [x]` creates a new one. Compare with `None` using `is`.",
        code = "a = [1, 2]\nb = [1, 2]\nprint(a == b, a is b)\nc = a\nc += [3]\nprint(a, a is c)",
        output = "True False\n[1, 2, 3] True",
    ),
    explain(
        "Copies and iterators",
        "`[[0] * 2] * 2` repeats the same inner list, and a shallow copy shares nested lists – " +
            "`copy.deepcopy` gives you a full copy. A generator, `zip` or `map` can be iterated only once.",
        code = "a = [[0] * 2] * 2\na[0][0] = 1\nprint(a)\ng = (x for x in range(3))\nprint(sum(g), sum(g))",
        output = "[[1, 0], [1, 0]]\n3 0",
    ),
    explain(
        "MRO, decorators and short-circuiting",
        "With multiple inheritance, `super()` follows the MRO order (`Class.__mro__`). Decorators " +
            "are applied from bottom to top. `and` and `or` evaluate only as much as needed and return one " +
            "of the values.",
        code = "print(0 or 2 or 3)\nprint(False and 1 / 0)\nprint(\"\" or \"default\")",
        output = "2\nFalse\ndefault",
    ),
    output(
        "a = [1]\nb = a\nb.append(2)\nprint(a is b, a)",
        "True [1, 2]",
        "b is just a second name for the same list.",
    ),
    output(
        "g = (x for x in [1, 2])\nprint(list(g), list(g))",
        "[1, 2] []",
        "A generator is exhausted after the first pass.",
    ),
    choice(
        "What is the recommended way to check whether the variable x is None?",
        listOf("x is None", "x = None", "x is \"None\"", "x in None"),
        0,
        "None is a single object, so we compare with it using is.",
    ),
)
