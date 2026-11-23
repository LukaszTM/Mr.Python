package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

internal val module15Intro = lesson(
    "u15l0", "Introduction: function parameters",
    explain(
        "Default values",
        "A parameter can have a default value: `name=\"guest\"`. If you don't pass an argument, Python " +
            "uses that value. Careful: as a default value use `None` instead of `[]` – the list is created only once.",
        code = "def greet(name=\"guest\"):\n    print(\"Hello,\", name)\n\ngreet()\ngreet(\"Lily\")",
        output = "Hello, guest\nHello, Lily",
    ),
    explain(
        "Any number: *args",
        "A star before a parameter (`*numbers`) collects all the arguments passed into a tuple. " +
            "This lets you call the function with any number of values – even zero.",
        code = "def total(*numbers):\n    print(numbers)\n    return sum(numbers)\n\nprint(total(1, 2, 3))",
        output = "(1, 2, 3)\n6",
    ),
    explain(
        "Keyword arguments: **kwargs",
        "Two stars (`**data`) collect the arguments passed by name, e.g. `color=\"red\"`, into a dictionary. " +
            "The keys are the argument names, and the values are what was assigned to them.",
        code = "def profile(**data):\n    print(data)\n\nprofile(name=\"Amy\", age=7)",
        output = "{'name': 'Amy', 'age': 7}",
    ),
    explain(
        "By name only",
        "Parameters written after a bare star `*` must be passed by name, e.g. `b=2`. " +
            "This protects you from mixing up the order of the arguments.",
        code = "def f(a, *, b):\n    print(a + b)\n\nf(1, b=2)",
        output = "3",
    ),
    explain(
        "Unpacking",
        "In a call it works the other way around: `*items` spreads a list into separate arguments, " +
            "and `**dictionary` spreads a dictionary into keyword arguments.",
        code = "def f(x, y):\n    print(x - y)\n\nf(*[5, 1])\nf(**{\"y\": 2, \"x\": 9})",
        output = "4\n7",
    ),
    output(
        "def power(x, n=2):\n    return x ** n\n\nprint(power(3))",
        "9",
        "Without the second argument n is 2, so 3 ** 2 = 9.",
    ),
    choice(
        "What type is args in the function def f(*args)?",
        listOf("A tuple", "A list", "A dictionary", "A string"),
        0,
        "*args collects the arguments into a tuple.",
    ),
    fill(
        "Complete the code so the function collects keyword arguments into a dictionary.",
        "def configure(____options):\n    print(options)\n\nconfigure(color=\"red\")",
        listOf("**", "*", "&"),
        "**",
        "Two stars collect keyword arguments into a dictionary.",
    ),
)
