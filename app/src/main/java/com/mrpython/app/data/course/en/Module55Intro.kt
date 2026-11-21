package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

internal val module55Intro = lesson(
    "u55l0", "Introduction: the calculator project",
    explain(
        "The goal of the project",
        "In this module you'll build, step by step, a calculator that evaluates an expression written as text, " +
            "e.g. `\"6 * 7\"`. You'll combine functions, dictionaries, strings, exceptions and lists – " +
            "everything you already know.",
    ),
    explain(
        "Operations as functions",
        "Each operation is a small function with two arguments. Building blocks like these are easy to test " +
            "and combine. Remember: `/` always gives a float, and `**` is exponentiation.",
        code = "def multiply(a, b):\n    return a * b\n\nprint(multiply(4, 5), 7 / 2)",
        output = "20 3.5",
    ),
    explain(
        "A dictionary of functions",
        "Functions are objects, so you can keep them in a dictionary under a symbol key. Short operations " +
            "are convenient to write as a `lambda`. Instead of a long `if/elif`, `ops[op](a, b)` is enough.",
        code = "ops = {\"+\": lambda a, b: a + b,\n       \"-\": lambda a, b: a - b}\nprint(ops[\"-\"](8, 2))",
        output = "6",
    ),
    explain(
        "Breaking up the text",
        "`split()` splits a string on spaces. We unpack the result into three variables " +
            "and convert the numbers with `int()` or `float()`.",
        code = "a, op, b = \"10 * 4\".split()\nprint(a, op, b)\nprint(int(a) * int(b))",
        output = "10 * 4\n40",
    ),
    explain(
        "Errors and history",
        "Bad input gives a `ValueError`, an unknown symbol a `KeyError`, and division by zero a " +
            "`ZeroDivisionError`. We catch them with `try/except`. Successful results go into the history list.",
        code = "history = []\ntry:\n    history.append(5 / 0)\nexcept ZeroDivisionError:\n    print(\"Don't divide by 0!\")\nprint(history)",
        output = "Don't divide by 0!\n[]",
    ),
    output(
        "a, op, b = \"3 + 4\".split()\nprint(int(a) + int(b))",
        "7",
        "split() gives three parts, and int() converts them to numbers.",
    ),
    choice(
        "Which exception does int(\"x\") raise?",
        listOf("ValueError", "KeyError", "ZeroDivisionError", "IndexError"),
        0,
        "The string \"x\" can't be converted to a number – that's a ValueError.",
    ),
    fill(
        "Fill in the blank to call the multiplication function from the dictionary.",
        "ops = {\"*\": lambda a, b: a * b}\nprint(ops____(3, 4))",
        listOf("[\"*\"]", "(\"*\")", "[*]"),
        "[\"*\"]",
        "We take a function out of the dictionary by its key in square brackets.",
    ),
)
