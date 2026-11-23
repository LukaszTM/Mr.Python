package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

internal val module2Intro = lesson(
    "u2l0", "Introduction: variables and types",
    explain(
        "What is a variable?",
        "A variable is a box with a name where the program keeps a value. You create it with the `=` sign: " +
            "the name on the left, the value on the right. Later you can overwrite it, for example with the `+=` shortcut.",
        code = "points = 3\npoints = points + 2\npoints += 1\nprint(points)",
        output = "6",
    ),
    explain(
        "Data types",
        "Every value has a type. `int` is a whole number, `float` is a number with a decimal point, `str` is a string, " +
            "and `bool` is true or false. You can check a type with the `type()` function.",
        code = "print(type(7))\nprint(type(3.5))\nprint(type(\"7\"))",
        output = "<class 'int'>\n<class 'float'>\n<class 'str'>",
    ),
    explain(
        "Converting types",
        "The string \"4\" is not a number – plus joins it. The `int()` function converts a string to a number, " +
            "and `str()` converts a number to a string.",
        code = "print(\"4\" + \"1\")\nprint(int(\"4\") + 1)\nprint(str(5) + \"0\")",
        output = "41\n5\n50",
    ),
    explain(
        "f-strings and input()",
        "A string with the letter `f` before the quote can contain variables in braces `{}`. " +
            "The `input()` function asks the user for text and always returns a string.",
        code = "name = \"Eve\"\nage = 9\nprint(f\"{name} is {age} years old\")",
        output = "Eve is 9 years old",
    ),
    explain(
        "True, False, and None",
        "`True` and `False` are logical values (the `bool` type). The `bool()` function tells whether a value is \"truthy\" (`True`) " +
            "or \"falsy\" (`False`): the number 0 and the empty string are falsy. " +
            "`None` means there is no value.",
        code = "print(bool(0))\nprint(bool(\"a\"))\nprint(None)",
        output = "False\nTrue\nNone",
    ),
    output(
        "x = 4\nx += 6\nprint(x)",
        "10",
        "x += 6 is short for x = x + 6.",
    ),
    choice(
        "What type is the value \"12\"?",
        listOf("str", "int", "float", "bool"),
        0,
        "Anything in quotes is a string.",
    ),
    fill(
        "Fill in the blank so the variable gets inserted into the string.",
        "name = \"Emma\"\nprint(____\"Hey, {name}!\")",
        listOf("f", "s", "#"),
        "f",
        "The letter f before the quote creates an f-string.",
    ),
)
