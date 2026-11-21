package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

internal val module6Cards = listOf(
    cards(
        "u6l1",
        explain(
            "Defining is not calling",
            "A `def` definition does nothing by itself – it only remembers the function. The code inside runs " +
                "only when the function is called, exactly at that point in the program.",
            code = "def line():\n    print(\"---\")\n\nprint(\"Start\")\nline()",
            output = "Start\n---",
        ),
        explain(
            "return or print?",
            "`print()` only shows something on the screen. `return` hands the result back to the place of the call – " +
                "you can store it in a variable and keep calculating with it.",
            code = "def times3(x):\n    return x * 3\n\nw = times3(2) + 1\nprint(w)",
            output = "7",
        ),
        explain(
            "A function on one line",
            "When a function has only one statement, you can write it after the colon on the same line – " +
                "just like in a loop.",
            code = "def add(a, b): return a + b\n\nprint(add(2, 3))",
            output = "5",
        ),
    ),
    cards(
        "u6l2",
        explain(
            "A function without return",
            "A function that has no `return` still returns something – the value `None`. If a function only " +
                "prints text, its result is exactly that `None`.",
            code = "def hi():\n    print(\"Hi\")\n\nw = hi()\nprint(w)",
            output = "Hi\nNone",
        ),
        explain(
            "A missing argument",
            "A parameter without a default value must be given when calling – otherwise Python raises an error. " +
                "A parameter with a default value is still a parameter, you can just leave it out.",
            code = "def area(a, b=2):\n    return a * b\n\nprint(area(5))\nprint(area(5, 3))",
            output = "10\n15",
        ),
        explain(
            "return inside if",
            "`return` ends the function right away. That's why after an `if` with a `return` you can write a second " +
                "`return` without `else` – it runs only when the condition was false.",
            code = "def positive(n):\n    if n < 0:\n        return -n\n    return n\n\nprint(positive(-4))",
            output = "4",
        ),
    ),
    cards(
        "u6l3",
        explain(
            "Same name, two variables",
            "A variable created inside a function is local – even if it has the same name as a variable outside " +
                "the function, it is a different variable and the outer one doesn't change. Outside the function " +
                "the local one doesn't exist (`NameError`).",
            code = "x = 1\ndef f():\n    x = 50\n    print(x)\nf()\nprint(x)",
            output = "50\n1",
        ),
        explain(
            "A function calls a function",
            "A function can use another function, and the result of one call can be the argument of another. " +
                "In `f(f(1))` Python first works out the inner `f(1)`.",
            code = "def plus2(n):\n    return n + 2\n\nprint(plus2(plus2(1)))",
            output = "5",
        ),
        explain(
            "Several results in parentheses",
            "When a function returns several values and you don't unpack them into variables, you get them together " +
                "in parentheses, e.g. `(3, 1)`.",
            code = "def two():\n    return 3, 1\n\nprint(two())",
            output = "(3, 1)",
        ),
    ),
    cards(
        "u6l4",
        explain(
            "A placeholder: pass",
            "`pass` means \"do nothing\". We put it where Python requires a block but we don't have " +
                "any code yet – e.g. in an empty function.",
            code = "def later():\n    pass\n\nprint(later())",
            output = "None",
        ),
    ),
)
