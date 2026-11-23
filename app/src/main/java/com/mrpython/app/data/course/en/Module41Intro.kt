package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

internal val module41Intro = lesson(
    "u41l0", "Introduction: decorators",
    explain(
        "A function is an object",
        "In Python you can assign a function to a variable, pass it as an argument, or return it " +
            "from another function. `hi` is the function itself, and `hi()` calls it.",
        code = "def hi():\n    return \"hi!\"\nf = hi\nprint(f())",
        output = "hi!",
    ),
    explain(
        "A function inside a function",
        "A function can define another function inside it and return it (without parentheses). " +
            "The inner function runs only when we call it.",
        code = "def make():\n    def inner():\n        return \"inside\"\n    return inner\ng = make()\nprint(g())",
        output = "inside",
    ),
    explain(
        "What is a decorator?",
        "A decorator is a function that takes a function and returns a new one – usually a `wrapper` that " +
            "adds something before or after the original. That way you change a function's behavior without " +
            "changing its code.",
        code = "def decorate(f):\n    def wrapper():\n        print(\"before\")\n        f()\n    return wrapper",
    ),
    explain(
        "The @ syntax",
        "`@decorate` above `def` is shorthand for `hi = decorate(hi)`. When the wrapper should return the " +
            "result, we write `return f()`, and `*args` lets it accept any arguments.",
        code = "def bracket(f):\n    def w(): return \"[\" + f() + \"]\"\n    return w\n@bracket\ndef name(): return \"Amy\"\nprint(name())",
        output = "[Amy]",
    ),
    explain(
        "Arguments and stacking",
        "A decorator with an argument, e.g. `@repeat(3)`, is a factory: `repeat(3)` returns a decorator. " +
            "Several decorators on one function are applied from the bottom up: `@a` above `@b` is `x = a(b(x))`.",
        code = "def a(f): return lambda: \"a\" + f()\ndef b(f): return lambda: \"b\" + f()\n@a\n@b\ndef x(): return \"x\"\nprint(x())",
        output = "abx",
    ),
    choice(
        "Which line is equivalent to @log above def hi()?",
        listOf("hi = log(hi)", "log = hi(log)", "hi = log()", "log(hi())"),
        0,
        "The @ syntax is shorthand for this assignment.",
    ),
    output(
        "def double(f):\n    def w():\n        return f() * 2\n    return w\n@double\ndef number():\n    return 5\nprint(number())",
        "10",
        "wrapper doubles the result of the original function.",
    ),
    fill(
        "Fill in the blank so the decorator returns the wrapping function.",
        "def decorate(f):\n    def wrapper():\n        return f()\n    return ____\n@decorate\ndef hi():\n    return 1\nprint(hi())",
        listOf("wrapper", "wrapper()", "f()", "None"),
        "wrapper",
        "A decorator returns the wrapper function object, without parentheses.",
    ),
)
