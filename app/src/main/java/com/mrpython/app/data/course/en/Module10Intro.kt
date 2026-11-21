package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

internal val module10Intro = lesson(
    "u10l0", "Introduction: error handling",
    explain(
        "Kinds of errors",
        "When something goes wrong, Python raises an error (an exception) and stops the program. The name " +
            "tells you what happened: `ValueError` – a bad value, like `int(\"abc\")`; `ZeroDivisionError` – " +
            "division by zero; `TypeError` – the wrong type, like `\"a\" + 1`; `IndexError`, `KeyError`, `NameError`.",
    ),
    explain(
        "try and except",
        "We put risky code in a `try` block. If an error occurs, Python stops the `try`, jumps " +
            "to the matching `except`, and the program keeps running instead of stopping.",
        code = "try:\n    x = int(\"abc\")\n    print(\"this won't be printed\")\nexcept ValueError:\n    print(\"not a number\")",
        output = "not a number",
    ),
    explain(
        "When everything works: else",
        "An `else` block after `except` runs only when there was no error in `try`.",
        code = "try:\n    x = 10 / 2\nexcept ZeroDivisionError:\n    print(\"error\")\nelse:\n    print(x)",
        output = "5.0",
    ),
    explain(
        "Always: finally",
        "A `finally` block always runs – whether there was an error or not. It's handy for cleaning up " +
            "at the end.",
        code = "try:\n    print(1 / 0)\nexcept ZeroDivisionError:\n    print(\"error\")\nfinally:\n    print(\"done\")",
        output = "error\ndone",
    ),
    explain(
        "raise and as e",
        "With the `raise` keyword you raise an error yourself, for example when the data is invalid. Writing " +
            "`except ValueError as e` stores the error in the variable `e`, so you can print its description.",
        code = "try:\n    raise ValueError(\"negative age\")\nexcept ValueError as e:\n    print(\"Error:\", e)",
        output = "Error: negative age",
    ),
    choice(
        "What error does 1 / 0 raise?",
        listOf("ZeroDivisionError", "ValueError", "TypeError", "KeyError"),
        0,
        "Dividing by zero is a ZeroDivisionError.",
    ),
    output(
        "try:\n    print(int(\"5\") + 1)\nexcept ValueError:\n    print(\"error\")",
        "6",
        "\"5\" can be converted to a number, so there's no error.",
    ),
    fill(
        "Fill in the missing keyword.",
        "try:\n    x = [1, 2][5]\n____ IndexError:\n    print(\"missing\")",
        listOf("except", "else", "catch"),
        "except",
        "The except block catches the error.",
    ),
)
