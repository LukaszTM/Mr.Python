package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*
import com.mrpython.app.domain.CourseUnit

internal val module6 = CourseUnit(
    id = "u6",
    title = "Functions",
    description = "Create your own commands",
    lessons = listOf(
        lesson(
            "u6l1", "Defining functions",
            choice(
                "Which keyword defines a function?",
                listOf("def", "function", "fun", "func"),
                0,
                "In Python, functions are defined with the word def.",
            ),
            output(
                "def greet():\n    print(\"Hello!\")\n\ngreet()\ngreet()",
                "Hello!\nHello!",
                "The function was called twice, so the text appears twice.",
            ),
            tiles(
                "Build the header of a function add with the parameters a and b",
                listOf("def", "add(a, b)", ":"),
                listOf("function", "add[a, b]"),
                "def name(parameters): – with a colon at the end.",
            ),
            output(
                "def double(x):\n    return x * 2\n\nprint(double(4))",
                "8",
                "return hands back the function's result.",
            ),
            fill(
                "Fill in the blank so the function returns the square of a number.",
                "def square(x):\n    ____ x * x",
                listOf("return", "print", "give"),
                "return",
                "A function's result is returned with the word return.",
            ),
            output(
                "def hi(name):\n    print(\"Hi, \" + name)\n\nhi(\"Ann\")\nhi(\"Tom\")",
                "Hi, Ann\nHi, Tom",
                "The parameter name takes a different value on each call.",
            ),
            choice(
                "What will this code print?",
                listOf("B", "A B", "A", "Nothing"),
                0,
                "The function f was never called, so \"A\" isn't printed.",
                code = "def f():\n    print(\"A\")\n\nprint(\"B\")",
            ),
        ),
        lesson(
            "u6l2", "Parameters and results",
            output(
                "def greet(name=\"guest\"):\n    return \"Hi, \" + name\n\nprint(greet())\nprint(greet(\"Jake\"))",
                "Hi, guest\nHi, Jake",
                "A parameter with a default value can be left out when calling.",
            ),
            choice(
                "What will this code print?",
                listOf("None", "1", "0", "An error"),
                0,
                "A function without return returns None.",
                code = "def f():\n    x = 1\n\nprint(f())",
            ),
            output(
                "def bigger(a, b):\n    if a > b:\n        return a\n    return b\n\nprint(bigger(3, 9))",
                "9",
                "3 > 9 is false, so the function returns b.",
            ),
            output(
                "def list_sum(items):\n    s = 0\n    for e in items:\n        s += e\n    return s\n\nprint(list_sum([2, 4, 6]))",
                "12",
                "The function adds the elements one by one: 2 + 4 + 6.",
            ),
            choice(
                "What is a function argument?",
                listOf(
                    "A value passed to the function when it is called",
                    "The name of the function",
                    "A comment inside the function",
                    "An error in the function",
                ),
                0,
                "In double(4), the number 4 is the argument.",
            ),
            output("def area(a, b):\n    return a * b\n\nprint(area(3, 4) + 1)", "13", "You can keep using a function's result in calculations."),
            output(
                "def describe(name, age):\n    return f\"{name}: {age}\"\n\nprint(describe(age=7, name=\"Ella\"))",
                "Ella: 7",
                "Keyword arguments can be given in any order.",
            ),
        ),
        lesson(
            "u6l3", "Scope and multiple results",
            output(
                "def f():\n    x = 5\n    return x\n\nx = 1\nf()\nprint(x)",
                "1",
                "The x inside the function is a different, local variable.",
            ),
            choice(
                "What will happen?",
                listOf("A NameError – y exists only inside the function", "It prints 10", "It prints None", "It prints 0"),
                0,
                "Variables created inside a function aren't visible outside it.",
                code = "def f():\n    y = 10\n\nf()\nprint(y)",
            ),
            output(
                "def min_max(items):\n    return min(items), max(items)\n\na, b = min_max([4, 9, 1])\nprint(a, b)",
                "1 9",
                "A function can return several values at once.",
            ),
            output(
                "def square(x):\n    return x * x\n\ndef sum_of_squares(a, b):\n    return square(a) + square(b)\n\nprint(sum_of_squares(2, 3))",
                "13",
                "Functions can call other functions: 4 + 9 = 13.",
            ),
            output(
                "def f(x):\n    if x > 0:\n        return \"plus\"\n    return \"minus\"\n\nprint(f(5))\nprint(f(-2))",
                "plus\nminus",
                "return ends the function right away.",
            ),
            output("def f():\n    print(\"A\")\n    return\n    print(\"B\")\n\nf()", "A", "Code after return no longer runs."),
            fill(
                "Fill in the blank so the function returns two values.",
                "def divide(a, b):\n    return a // b____ a % b\n\nprint(divide(7, 2))",
                listOf(",", ":", "+"),
                ",",
                "Values separated by a comma are returned together: (3, 1).",
            ),
            tiles(
                "Store the result of the function add(2, 3) in the variable w",
                listOf("w", "=", "add(2, 3)"),
                listOf("return", "def"),
                "You assign a function's result to a variable with the = sign.",
            ),
        ),
        lesson(
            "u6l4", "Review: functions",
            output("def f(n):\n    return n + 1\n\nprint(f(f(1)))", "3", "First f(1) = 2, then f(2) = 3."),
            output(
                "def is_even(n):\n    return n % 2 == 0\n\nprint(is_even(4))\nprint(is_even(7))",
                "True\nFalse",
                "A function can return a Boolean value.",
            ),
            choice(
                "How many parameters does this function have?",
                listOf("3", "2", "1", "0"),
                0,
                "first_name, last_name and age – the last one has a default value, but it is still a parameter.",
                code = "def introduce(first_name, last_name, age=18):\n    pass",
            ),
            output(
                "def count(items, target):\n    n = 0\n    for e in items:\n        if e == target:\n            n += 1\n    return n\n\nprint(count([1, 2, 1, 1], 1))",
                "3",
                "The function counts how many times an element appears in the list.",
            ),
            fill(
                "Complete the function definition.",
                "____ greeting():\n    return \"Hello\"\n\nprint(greeting())",
                listOf("def", "fun", "function"),
                "def",
                "Every function starts with the word def.",
            ),
            output(
                "def reverse(s):\n    result = \"\"\n    for ch in s:\n        result = ch + result\n    return result\n\nprint(reverse(\"abc\"))",
                "cba",
                "Each next letter goes to the front of the result.",
            ),
            output("def f(a, b=2):\n    return a ** b\n\nprint(f(3))\nprint(f(2, 3))", "9\n8", "3² = 9, and 2³ = 8."),
            output(
                "def factorial(n):\n    result = 1\n    for i in range(2, n + 1):\n        result *= i\n    return result\n\nprint(factorial(5))",
                "120",
                "5! = 1 · 2 · 3 · 4 · 5 = 120.",
            ),
        ),
    ),
)
