package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*
import com.mrpython.app.domain.CourseUnit

internal val module15 = CourseUnit(
    id = "u15",
    title = "Function parameters",
    description = "Default values, *args, **kwargs and unpacking",
    lessons = listOf(
        lesson(
            "u15l1", "Default values",
            output(
                "def greet(name=\"guest\"):\n    print(\"Hello,\", name)\n\ngreet()\ngreet(\"Lily\")",
                "Hello, guest\nHello, Lily",
                "When we don't pass an argument, the default value is used.",
            ),
            output(
                "def power(x, n=2):\n    return x ** n\n\nprint(power(3), power(2, 3))",
                "9 8",
                "power(3) uses n=2, and power(2, 3) passes n=3.",
            ),
            choice(
                "Which definition is wrong?",
                listOf("def f(a=1, b):", "def f(a, b=1):", "def f(a=1, b=2):", "def f(a, b):"),
                0,
                "Parameters with a default value must come after the parameters without one.",
            ),
            output(
                "def add(x, items=[]):\n    items.append(x)\n    return items\n\nprint(add(1))\nprint(add(2))",
                "[1]\n[1, 2]",
                "The default list is created once and is shared by all the calls.",
            ),
            output(
                "def add(x, items=None):\n    if items is None:\n        items = []\n    items.append(x)\n    return items\n\nprint(add(1))\nprint(add(2))",
                "[1]\n[2]",
                "None as the default value and a new list inside the function solve the problem.",
            ),
            choice(
                "Why is items=[] dangerous as a default value?",
                listOf(
                    "The list is created once and shared between calls",
                    "An empty list causes a syntax error",
                    "Lists can't be parameters",
                    "The list is copied on every call",
                ),
                0,
                "Default values are created once, when the function is defined.",
            ),
            fill(
                "Complete the code to divide by 2 by default.",
                "def divide(x, d____):\n    return x / d\n\nprint(divide(10))",
                listOf("=2", "==2", ":2"),
                "=2",
                "The default value goes after the = sign in the function header.",
            ),
            tiles(
                "Define a function describe with the parameters name and age, where age defaults to 18",
                listOf("def", "describe(", "name,", "age=18", "):"),
                listOf("age==18", "18=age"),
                "A default value is written as name=value.",
            ),
        ),
        lesson(
            "u15l2", "Any number of arguments: *args",
            output(
                "def total(*numbers):\n    return sum(numbers)\n\nprint(total(1, 2, 3))",
                "6",
                "*numbers collects all the arguments into a tuple.",
            ),
            output("def f(*args):\n    print(args)\n\nf(1, \"a\")", "(1, 'a')", "args is a tuple with the arguments that were passed."),
            output("def f(*args):\n    print(len(args))\n\nf()", "0", "With no arguments, args is an empty tuple."),
            choice(
                "What type is args in the function def f(*args)?",
                listOf("A tuple", "A list", "A dictionary", "A set"),
                0,
                "Arguments collected by * go into a tuple.",
            ),
            output(
                "def first(x, *rest):\n    print(x, rest)\n\nfirst(1, 2, 3)",
                "1 (2, 3)",
                "The first argument goes to x, the others go to rest.",
            ),
            fill(
                "Complete the code so the function accepts any number of arguments.",
                "def biggest(____numbers):\n    return max(numbers)\n\nprint(biggest(4, 9, 2))",
                listOf("*", "**", "&"),
                "*",
                "A single star collects positional arguments into a tuple.",
            ),
            choice(
                "What will this code print?",
                listOf("a-b-c", "abc", "('a', 'b', 'c')", "Error"),
                0,
                "words is a tuple of strings, and join() glues them together with the separator.",
                code = "def link(*words):\n    return \"-\".join(words)\n\nprint(link(\"a\", \"b\", \"c\"))",
            ),
            tiles(
                "Define a function average that accepts any number of numbers",
                listOf("def", "average(", "*numbers", "):"),
                listOf("[numbers]", "def:"),
                "*numbers lets you pass any number of arguments.",
            ),
        ),
        lesson(
            "u15l3", "Keyword arguments: **kwargs",
            output("def f(**kwargs):\n    print(kwargs)\n\nf(a=1, b=2)", "{'a': 1, 'b': 2}", "**kwargs collects keyword arguments into a dictionary."),
            output(
                "def profile(**data):\n    for k, v in data.items():\n        print(k, v)\n\nprofile(name=\"Amy\", age=7)",
                "name Amy\nage 7",
                "The argument names become the dictionary keys.",
            ),
            choice(
                "What type is kwargs in the function def f(**kwargs)?",
                listOf("A dictionary", "A tuple", "A list", "A string"),
                0,
                "Two stars collect name=value pairs into a dictionary.",
            ),
            output(
                "def f(a, **options):\n    print(a, len(options))\n\nf(1, x=2, y=3)",
                "1 2",
                "1 goes to a, and x and y go to the dictionary options.",
            ),
            choice(
                "What will happen?",
                listOf("A TypeError", "It prints {1: 2}", "It prints (1, 2)", "It prints {}"),
                0,
                "**kw accepts only keyword arguments, and 1 and 2 are positional.",
                code = "def f(**kw):\n    print(kw)\n\nf(1, 2)",
            ),
            fill(
                "Complete the code so the function accepts any keyword arguments.",
                "def configure(____options):\n    print(options)\n\nconfigure(color=\"red\")",
                listOf("**", "*", "#"),
                "**",
                "Two stars collect keyword arguments.",
            ),
            output(
                "def f(*args, **kwargs):\n    print(args, kwargs)\n\nf(1, x=2)",
                "(1,) {'x': 2}",
                "Positional arguments go to args, keyword arguments to kwargs.",
            ),
            tiles(
                "Define a function order that accepts any keyword arguments",
                listOf("def", "order(", "**data", "):"),
                listOf("{data}", "def:"),
                "**data collects keyword arguments into a dictionary.",
            ),
        ),
        lesson(
            "u15l4", "Keyword-only parameters and unpacking",
            output("def f(a, *, b):\n    print(a + b)\n\nf(1, b=2)", "3", "A parameter after * must be passed by name: b=2."),
            choice(
                "What will happen?",
                listOf("A TypeError", "It prints 3", "It prints 1 2", "It prints 1"),
                0,
                "b comes after *, so it can only be passed as b=…",
                code = "def f(a, *, b):\n    print(a + b)\n\nf(1, 2)",
            ),
            output(
                "def f(a, b, c):\n    print(a, b, c)\n\nitems = [1, 2, 3]\nf(*items)",
                "1 2 3",
                "*items unpacks the list into separate arguments.",
            ),
            output(
                "def f(x, y):\n    print(x - y)\n\nd = {\"y\": 1, \"x\": 5}\nf(**d)",
                "4",
                "**d passes x=5 and y=1 as keyword arguments.",
            ),
            output("numbers = [3, 1, 2]\nprint(*numbers)", "3 1 2", "print(*numbers) is the same as print(3, 1, 2)."),
            output("print(*\"abc\", sep=\"-\")", "a-b-c", "A string can be unpacked into single characters too."),
            fill(
                "Complete the code to unpack the dictionary as keyword arguments.",
                "def greet(name, age):\n    print(name, age)\n\nd = {\"name\": \"Lily\", \"age\": 9}\ngreet(____d)",
                listOf("**", "*", "&"),
                "**",
                "** passes the key–value pairs as keyword arguments.",
            ),
            tiles(
                "Call f, passing the elements of the list data as separate arguments",
                listOf("f(", "*data", ")"),
                listOf("**data", "data[]"),
                "A single star unpacks a list into positional arguments.",
            ),
        ),
        lesson(
            "u15l5", "Review: function parameters",
            output("def f(a, b=10):\n    return a + b\n\nprint(f(1), f(1, 1))", "11 2", "Without the second argument, b is 10."),
            output("def f(*a):\n    return a[-1]\n\nprint(f(4, 5, 6))", "6", "a is the tuple (4, 5, 6), and a[-1] is its last element."),
            output("def f(**k):\n    return list(k)\n\nprint(f(x=1, y=2))", "['x', 'y']", "list() of a dictionary gives a list of its keys."),
            choice(
                "Which parameter order is correct?",
                listOf("def f(a, b=1, *args, **kwargs):", "def f(**kwargs, *args, a):", "def f(*args, a=1, **kwargs, b):", "def f(b=1, a, **kwargs):"),
                0,
                "The order is: regular, default, *args, and **kwargs at the end.",
            ),
            output(
                "def f(a, *, sep=\"/\"):\n    return sep.join(a)\n\nprint(f([\"a\", \"b\"], sep=\".\"))",
                "a.b",
                "sep is keyword-only, and here it is \".\".",
            ),
            choice(
                "What will this code print?",
                listOf("6", "(2, 3)", "5", "Error"),
                0,
                "*size unpacks the tuple: area(2, 3) = 6.",
                code = "def area(a, b):\n    return a * b\n\nsize = (2, 3)\nprint(area(*size))",
            ),
            fill(
                "Complete the code to avoid the default-list trap.",
                "def f(x, lst=____):\n    if lst is None:\n        lst = []\n    lst.append(x)\n    return lst\n\nprint(f(1), f(2))",
                listOf("None", "[]", "0"),
                "None",
                "With None, every call creates a new list, so the result is [1] [2].",
            ),
            tiles(
                "Call the function f, passing the dictionary options as keyword arguments",
                listOf("f(", "**options", ")"),
                listOf("*options", "options**"),
                "** unpacks a dictionary into keyword arguments.",
            ),
        ),
    ),
)
