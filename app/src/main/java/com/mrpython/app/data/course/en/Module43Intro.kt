package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

internal val module43Intro = lesson(
    "u43l0", "Introduction: scope and closures",
    explain(
        "Variable scope",
        "Scope is the place where a name is visible. A variable created in a function is " +
            "local: it shadows the global one only inside the function and disappears when the function finishes.",
        code = "x = \"global\"\ndef f():\n    x = \"local\"\n    print(x)\nf()\nprint(x)",
        output = "local\nglobal",
    ),
    explain(
        "The LEGB rule",
        "Python looks for a name in this order: Local (the function), Enclosing (the enclosing function), " +
            "Global (the file), Built-in (e.g. `len`). It takes the first one it finds.",
        code = "x = 1\ndef outer():\n    x = 2\n    def inner():\n        print(x)\n    inner()\nouter()",
        output = "2",
    ),
    explain(
        "global and nonlocal",
        "An assignment in a function creates a local variable. To change a variable from the file, we write " +
            "`global name`, and to change a variable of the enclosing function – `nonlocal name`. Without " +
            "that, `counter += 1` gives an UnboundLocalError.",
        code = "counter = 0\ndef add():\n    global counter\n    counter += 1\nadd()\nprint(counter)",
        output = "1",
    ),
    explain(
        "Closures",
        "A closure is an inner function that remembers variables from the place where it was created – " +
            "even after the outer function has finished. That's how we build function \"factories\".",
        code = "def multiplier(n):\n    def f(x):\n        return x * n\n    return f\ntimes3 = multiplier(3)\nprint(times3(5))",
        output = "15",
    ),
    explain(
        "The loop trap",
        "Lambdas created in a loop remember the variable, not its value – after the loop they all see " +
            "the last one. A default argument `i=i` helps, because it stores the current value.",
        code = "fs = [lambda: i for i in range(3)]\nprint([f() for f in fs])\ngs = [lambda i=i: i for i in range(3)]\nprint([g() for g in gs])",
        output = "[2, 2, 2]\n[0, 1, 2]",
    ),
    choice(
        "Where does Python first look for a name used in a function?",
        listOf("In the local scope", "In the global scope", "In the built-in names", "In the enclosing function"),
        0,
        "The L in LEGB is Local – the search starts locally.",
    ),
    output(
        "def adder(n):\n    def f(x):\n        return x + n\n    return f\nplus2 = adder(2)\nprint(plus2(10))",
        "12",
        "f remembers n = 2 – that's a closure.",
    ),
    fill(
        "Fill in the blank so inner changes the variable n of the function outer.",
        "def outer():\n    n = 0\n    def inner():\n        ____ n\n        n += 1\n    inner()\n    print(n)\nouter()",
        listOf("nonlocal", "global", "local", "def"),
        "nonlocal",
        "n belongs to the enclosing function, so we use nonlocal.",
    ),
)
