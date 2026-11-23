package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*
import com.mrpython.app.domain.CourseUnit

internal val module41 = CourseUnit(
    id = "u41",
    title = "Decorators",
    description = "Functions as objects, decorators, and stacking them",
    lessons = listOf(
        lesson(
            "u41l1", "Functions as objects",
            output(
                "def hi():\n    return \"hi!\"\nf = hi\nprint(f())",
                "hi!",
                "You can assign a function to a variable and call it by the new name.",
            ),
            output(
                "def double(x):\n    return x * 2\ndef apply(f, v):\n    return f(v)\nprint(apply(double, 7))",
                "14",
                "You can pass a function as an argument to another function.",
            ),
            choice(
                "What's the difference between hi and hi()?",
                listOf("hi is the function, hi() calls it", "Nothing, they mean the same", "hi() is the function, hi calls it", "hi without parentheses is a syntax error"),
                0,
                "Parentheses call the function; without them you have the function object.",
            ),
            output(
                "def a():\n    return 1\ndef b():\n    return 2\nfor f in [a, b]:\n    print(f())",
                "1\n2",
                "Functions can be stored in a list like any other object.",
            ),
            output(
                "def make():\n    def inner():\n        return \"inside\"\n    return inner\ng = make()\nprint(g())",
                "inside",
                "A function can return a function defined inside it.",
            ),
            fill(
                "Fill in the blank so the function returns the function inner (not its result).",
                "def make():\n    def inner():\n        return 5\n    return ____\nprint(make()())",
                listOf("inner", "inner()", "make", "5"),
                "inner",
                "We return the function object, without parentheses.",
            ),
            output(
                "def outer():\n    def inner():\n        print(\"B\")\n    print(\"A\")\n    inner()\nouter()",
                "A\nB",
                "The inner function runs only when we call it.",
            ),
            tiles(
                "Assign the print function to the variable p (without calling it)",
                listOf("p", "=", "print"),
                listOf("print(", ")"),
                "Without parentheses we assign the function itself.",
            ),
        ),
        lesson(
            "u41l2", "Your first decorator",
            output(
                "def decorate(f):\n    def wrapper():\n        print(\"before\")\n        f()\n        print(\"after\")\n    return wrapper\ndef hi():\n    print(\"hi\")\nhi = decorate(hi)\nhi()",
                "before\nhi\nafter",
                "A decorator wraps a function in new behavior.",
            ),
            choice(
                "What is a decorator?",
                listOf("A function that takes a function and returns a new function", "A special class that Python attaches to a function", "A comment above a function that Python skips", "A way to import a function from another module"),
                0,
                "A decorator gets a function and returns an improved version of it.",
            ),
            output(
                "def loud(f):\n    def wrapper():\n        return f().upper()\n    return wrapper\ndef hi():\n    return \"hi\"\nhi = loud(hi)\nprint(hi())",
                "HI",
                "wrapper changes the result of the original function.",
            ),
            output(
                "def decorate(f):\n    print(\"decorating\")\n    return f\ndef g():\n    print(\"g\")\ng = decorate(g)\ng()",
                "decorating\ng",
                "The decorator's code runs at decoration time, and g runs later.",
            ),
            fill(
                "Fill in the blank so the decorator returns the wrapping function.",
                "def decorate(f):\n    def wrapper():\n        print(\"*\")\n        f()\n    return ____\ndef hi():\n    print(\"hi\")\nhi = decorate(hi)\nhi()",
                listOf("wrapper", "wrapper()", "f()", "None"),
                "wrapper",
                "A decorator returns the wrapper function, not its result.",
            ),
            output(
                "def twice(f):\n    def wrapper():\n        f()\n        f()\n    return wrapper\ndef hi():\n    print(\"hi\")\nhi = twice(hi)\nhi()",
                "hi\nhi",
                "wrapper calls the original twice.",
            ),
            choice(
                "What do you need to do so that wrapper returns the result of f?",
                listOf("Write return f()", "Nothing – it returns it on its own", "Write print(f())", "Write yield f"),
                0,
                "Without return, wrapper would return None.",
            ),
        ),
        lesson(
            "u41l3", "The @ syntax",
            output(
                "def decorate(f):\n    def wrapper():\n        return \"[\" + f() + \"]\"\n    return wrapper\n@decorate\ndef name():\n    return \"Amy\"\nprint(name())",
                "[Amy]",
                "@decorate above def is shorthand for name = decorate(name).",
            ),
            choice(
                "Which line is equivalent to @decorate above def hi()?",
                listOf("hi = decorate(hi)", "decorate = hi(decorate)", "hi = decorate()", "hi(decorate)"),
                0,
                "The @ syntax is just a more convenient way to write this assignment.",
            ),
            output(
                "def log(f):\n    def wrapper(*args):\n        print(\"call\", args)\n        return f(*args)\n    return wrapper\n@log\ndef add(a, b):\n    return a + b\nprint(add(2, 3))",
                "call (2, 3)\n5",
                "*args passes any arguments on to the original.",
            ),
            fill(
                "Fill in the blank so wrapper accepts any arguments.",
                "def log(f):\n    def wrapper(____):\n        return f(*args)\n    return wrapper\n@log\ndef sq(x):\n    return x * x\nprint(sq(4))",
                listOf("*args", "args", "x, y", "args=0"),
                "*args",
                "*args collects all positional arguments into a tuple.",
            ),
            output(
                "def counter(f):\n    def wrapper():\n        wrapper.count += 1\n        return f()\n    wrapper.count = 0\n    return wrapper\n@counter\ndef hi():\n    pass\nhi()\nhi()\nprint(hi.count)",
                "2",
                "A function is an object, so it can have its own attributes.",
            ),
            output(
                "def zero_if_negative(f):\n    def wrapper(x):\n        r = f(x)\n        return r if r > 0 else 0\n    return wrapper\n@zero_if_negative\ndef minus5(x):\n    return x - 5\nprint(minus5(3), minus5(9))",
                "0 4",
                "The decorator fixes the result: it turns -2 into 0.",
            ),
            tiles(
                "Decorate the function hi with the decorator log without using @",
                listOf("hi", "=", "log(", "hi", ")"),
                listOf("hi()", "@log"),
                "@log above def is shorthand for hi = log(hi).",
            ),
        ),
        lesson(
            "u41l4", "Decorators with arguments and stacking",
            output(
                "def repeat(n):\n    def decorator(f):\n        def wrapper():\n            for _ in range(n):\n                f()\n        return wrapper\n    return decorator\n@repeat(3)\ndef hi():\n    print(\"hi\")\nhi()",
                "hi\nhi\nhi",
                "repeat(3) returns a decorator, which then wraps the function.",
            ),
            choice(
                "How many levels of functions does a decorator with arguments have, e.g. @repeat(3)?",
                listOf("Three: factory, decorator, wrapper", "One", "Two: decorator and wrapper", "Four"),
                0,
                "First repeat(3) creates a decorator, and that returns the wrapper.",
            ),
            output(
                "def add(char):\n    def dec(f):\n        def w():\n            return f() + char\n        return w\n    return dec\n@add(\"?\")\ndef question():\n    return \"How\"\nprint(question())",
                "How?",
                "The decorator's argument is available in the inner function.",
            ),
            output(
                "def a(f):\n    def w():\n        return \"a\" + f()\n    return w\ndef b(f):\n    def w():\n        return \"b\" + f()\n    return w\n@a\n@b\ndef x():\n    return \"x\"\nprint(x())",
                "abx",
                "The decorator closest to def (b) is applied first, and a wraps the result.",
            ),
            output(
                "def a(f):\n    def w():\n        return \"a\" + f()\n    return w\ndef b(f):\n    def w():\n        return \"b\" + f()\n    return w\n@b\n@a\ndef x():\n    return \"x\"\nprint(x())",
                "bax",
                "Swapping the order of the decorators changes the result.",
            ),
            choice(
                "Which line is equivalent to @a above @b above def x()?",
                listOf("x = a(b(x))", "x = b(a(x))", "x = a(x) + b(x)", "x = a(b)(x)"),
                0,
                "The decorator closest to def is applied first.",
            ),
            fill(
                "Fill in the blank so the function runs 2 times.",
                "def repeat(n):\n    def dec(f):\n        def w():\n            for _ in range(n):\n                f()\n        return w\n    return dec\n@____\ndef hi():\n    print(\"hi\")\nhi()",
                listOf("repeat(2)", "repeat", "dec(2)", "repeat(1)"),
                "repeat(2)",
                "A decorator with an argument is called with parentheses.",
            ),
        ),
        lesson(
            "u41l5", "Review: decorators",
            output(
                "def decorate(f):\n    def w():\n        return f() * 2\n    return w\n@decorate\ndef number():\n    return 21\nprint(number())",
                "42",
                "The decorator doubles the function's result.",
            ),
            output(
                "def frame(f):\n    def w(s):\n        print(\"--\")\n        f(s)\n        print(\"--\")\n    return w\n@frame\ndef show(s):\n    print(s)\nshow(\"Hi\")",
                "--\nHi\n--",
                "wrapper prints a frame before and after the call.",
            ),
            choice(
                "What will this code print?",
                listOf("A", "B", "AB", "Nothing"),
                0,
                "The decorator returned a different function than the original, so only that one runs.",
                code = "def replace(f):\n    def w():\n        print(\"A\")\n    return w\n@replace\ndef g():\n    print(\"B\")\ng()",
            ),
            output(
                "def plus(n):\n    def dec(f):\n        def w(x):\n            return f(x) + n\n        return w\n    return dec\n@plus(10)\ndef sq(x):\n    return x * x\nprint(sq(3))",
                "19",
                "sq(3) gives 9, and the decorator adds 10.",
            ),
            output(
                "def star(f):\n    def w():\n        return \"*\" + f() + \"*\"\n    return w\n@star\n@star\ndef s():\n    return \"x\"\nprint(s())",
                "**x**",
                "The same decorator used twice wraps the result twice.",
            ),
            fill(
                "Fill in the blank so wrapper returns the result of the original function.",
                "def log(f):\n    def w():\n        print(\"start\")\n        ____ f()\n    return w\n@log\ndef data():\n    return 7\nprint(data())",
                listOf("return", "print", "yield", "raise"),
                "return",
                "Without return, the decorated function would return None.",
            ),
            tiles(
                "Apply the decorator repeat with the argument 3 to hi without using @",
                listOf("hi", "=", "repeat(3)(", "hi", ")"),
                listOf("repeat(", "hi()"),
                "@repeat(3) is shorthand for hi = repeat(3)(hi).",
            ),
            choice(
                "Why is functools.wraps used in decorators?",
                listOf("To keep the original function's name and description", "To make the function faster", "To remember results", "To let the decorator take arguments"),
                0,
                "wraps copies metadata, e.g. __name__, from the original to the wrapper.",
            ),
        ),
    ),
)
