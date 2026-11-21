package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

internal val module6Intro = lesson(
    "u6l0", "Introduction: functions",
    explain(
        "Your own command",
        "A function is a named piece of code that you can run many times. You define it with the word " +
            "`def`, a name, parentheses and a colon. You call it by writing its name with parentheses.",
        code = "def greet():\n    print(\"Hello!\")\n\ngreet()\ngreet()",
        output = "Hello!\nHello!",
    ),
    explain(
        "Parameters",
        "Inside the parentheses you can list parameters – data the function receives when it is called. " +
            "A value passed in a call is an argument.",
        code = "def hi(name):\n    print(\"Hi, \" + name)\n\nhi(\"Ann\")\nhi(\"Tom\")",
        output = "Hi, Ann\nHi, Tom",
    ),
    explain(
        "Returning a result",
        "`return` hands the result back to the place of the call, so you can store it in a variable or keep " +
            "calculating. Code after `return` no longer runs.",
        code = "def double(x):\n    return x * 2\n\nresult = double(4)\nprint(result + 1)",
        output = "9",
    ),
    explain(
        "Default values",
        "A parameter can have a default value, used when you don't pass an argument. Arguments can also " +
            "be passed by name, in any order.",
        code = "def greet(name=\"guest\"):\n    return \"Hi, \" + name\n\nprint(greet())\nprint(greet(name=\"Jake\"))",
        output = "Hi, guest\nHi, Jake",
    ),
    explain(
        "Scope and multiple results",
        "Variables created inside a function exist only there. A function can return several values " +
            "separated by commas – you unpack them into several variables.",
        code = "def min_max(items):\n    return min(items), max(items)\n\na, b = min_max([4, 9, 1])\nprint(a, b)",
        output = "1 9",
    ),
    choice(
        "Which keyword starts a function definition?",
        listOf("def", "func", "return", "function"),
        0,
        "In Python, functions are defined with the word def.",
    ),
    output(
        "def add(a, b):\n    return a + b\n\nprint(add(2, 5))",
        "7",
        "The function returns the sum 2 + 5.",
    ),
    fill(
        "Fill in the blank so the function hands back a result.",
        "def square(x):\n    ____ x * x\n\nprint(square(3))",
        listOf("return", "print", "def"),
        "return",
        "return hands back the function's result.",
    ),
)
