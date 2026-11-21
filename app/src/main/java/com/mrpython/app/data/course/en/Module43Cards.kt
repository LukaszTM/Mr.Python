package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

internal val module43Cards = listOf(
    cards(
        "u43l1",
        explain(
            "Assignment makes a variable local",
            "If a function assigns `x = ...` anywhere, then `x` is local in the whole function. " +
                "Reading it before that assignment gives an `UnboundLocalError`, even when a global `x` exists.",
            code = "x = 1\ndef f():\n    print(x)\n    x = 2\ntry: f()\nexcept UnboundLocalError: print(\"error\")",
            output = "error",
        ),
        explain(
            "Shadowing built-ins",
            "A local variable with a built-in name, e.g. `len`, hides it only in that function. " +
                "Outside the function `len` works normally.",
            code = "def f():\n    len = 99\n    return len\nprint(f(), len(\"ab\"))",
            output = "99 2",
        ),
    ),
    cards(
        "u43l2",
        explain(
            "Changing an object is not assignment",
            "`global` and `nonlocal` are needed only for assignment (`=`, `+=`). Methods such as " +
                "`append` change an existing object, so they work without a declaration.",
            code = "items = []\ndef add(x):\n    items.append(x)\nadd(1); add(2)\nprint(items)",
            output = "[1, 2]",
        ),
        explain(
            "Where nonlocal works",
            "`nonlocal` works only in a nested function, when the variable exists in an enclosing " +
                "function – otherwise it's a `SyntaxError`. `global` can even create a new module variable.",
            code = "def f():\n    global new\n    new = \"here\"\nf()\nprint(new)",
            output = "here",
        ),
    ),
    cards(
        "u43l3",
        explain(
            "A closure with state",
            "With `nonlocal` a closure can change the remembered variable between calls. Every " +
                "call to the factory creates separate state.",
            code = "def counter():\n    n = 0\n    def f():\n        nonlocal n; n += 1; return n\n    return f\na = counter(); a(); print(a(), counter()())",
            output = "2 1",
        ),
    ),
    cards(
        "u43l4",
        explain(
            "Names are looked up at call time",
            "A function reads a variable's value only when you call it, not when you create it. " +
                "That's why `y` can be created after the `def`. To get its own copy of a value, a function " +
                "needs a new scope, e.g. a separate call to a factory.",
            code = "def f():\n    return y\ny = 5\nprint(f())",
            output = "5",
        ),
    ),
)
