package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*
import com.mrpython.app.domain.CourseUnit

internal val module10 = CourseUnit(
    id = "u10",
    title = "Error handling",
    description = "try, except, and kinds of exceptions",
    lessons = listOf(
        lesson(
            "u10l1", "Kinds of errors",
            choice(
                "What error does int(\"abc\") raise?",
                listOf("ValueError", "TypeError", "NameError", "KeyError"),
                0,
                "The string \"abc\" can't be converted to a number – that's a ValueError.",
            ),
            choice(
                "What error does 1 / 0 raise?",
                listOf("ZeroDivisionError", "ValueError", "MathError", "None – the result is 0"),
                0,
                "Dividing by zero is a ZeroDivisionError.",
            ),
            choice(
                "What error do you get when you use a variable that was never created?",
                listOf("NameError", "ValueError", "IndexError", "SyntaxError"),
                0,
                "An unknown name is a NameError.",
            ),
            choice(
                "What error does \"a\" + 1 raise?",
                listOf("TypeError", "ValueError", "NameError", "None"),
                0,
                "You can't add a string and a number – that's a type error.",
            ),
            choice(
                "What error does [1, 2][5] raise?",
                listOf("IndexError", "KeyError", "ValueError", "None"),
                0,
                "An index outside the list's range is an IndexError.",
            ),
            choice(
                "What error does {\"a\": 1}[\"b\"] raise?",
                listOf("KeyError", "IndexError", "NameError", "ValueError"),
                0,
                "A missing dictionary key is a KeyError.",
            ),
            choice(
                "What's wrong with this code?",
                listOf("A colon is missing – SyntaxError", "A parenthesis is missing", "Nothing", "Wrong function name"),
                0,
                "Python detects a syntax error (SyntaxError) before it runs the program.",
                code = "if True\n    print(\"yes\")",
            ),
        ),
        lesson(
            "u10l2", "try and except",
            output(
                "try:\n    x = 1 / 0\nexcept ZeroDivisionError:\n    print(\"don't divide by zero\")",
                "don't divide by zero",
                "except catches the error and the program keeps running.",
            ),
            output(
                "try:\n    print(\"A\")\n    int(\"x\")\n    print(\"B\")\nexcept ValueError:\n    print(\"C\")",
                "A\nC",
                "After an error, the rest of the try block is skipped.",
            ),
            output("try:\n    print(\"OK\")\nexcept:\n    print(\"error\")", "OK", "When there's no error, except doesn't run."),
            output(
                "numbers = [1, 2]\ntry:\n    print(numbers[5])\nexcept IndexError:\n    print(\"no such element\")",
                "no such element",
                "The IndexError was caught.",
            ),
            fill(
                "Fill in the missing keyword.",
                "try:\n    x = int(\"abc\")\n____ ValueError:\n    print(\"not a number\")",
                listOf("except", "catch", "error"),
                "except",
                "In Python we write try / except.",
            ),
            output(
                "def divide(a, b):\n    try:\n        return a / b\n    except ZeroDivisionError:\n        return None\n\nprint(divide(6, 3))\nprint(divide(1, 0))",
                "2.0\nNone",
                "The function returns None instead of stopping the program.",
            ),
            output(
                "try:\n    print(int(\"5\") + 1)\nexcept ValueError:\n    print(\"error\")",
                "6",
                "\"5\" can be converted to a number, so there's no error.",
            ),
        ),
        lesson(
            "u10l3", "else, finally, and raise",
            output(
                "try:\n    x = 5\nexcept:\n    print(\"error\")\nelse:\n    print(\"no errors\")",
                "no errors",
                "else runs when there was no error in try.",
            ),
            output(
                "try:\n    1 / 0\nexcept ZeroDivisionError:\n    print(\"error\")\nfinally:\n    print(\"done\")",
                "error\ndone",
                "finally always runs.",
            ),
            output("try:\n    print(\"start\")\nfinally:\n    print(\"cleanup\")", "start\ncleanup", "finally runs even without an error."),
            output(
                "def check(age):\n    if age < 0:\n        raise ValueError(\"negative age\")\n    return age\n\ntry:\n    check(-1)\nexcept ValueError as e:\n    print(e)",
                "negative age",
                "raise raises an error, and as e lets you read its message.",
            ),
            tiles(
                "Raise a ValueError with the message \"bad value\"",
                listOf("raise", "ValueError(", "\"bad value\"", ")"),
                listOf("except", "return"),
                "raise raises an exception.",
            ),
            choice(
                "When does the finally block run?",
                listOf("Always", "Only on an error", "Only without an error", "Never"),
                0,
                "finally is for cleanup and always runs.",
            ),
            output(
                "try:\n    int(\"x\")\nexcept (ValueError, TypeError):\n    print(\"bad type or value\")",
                "bad type or value",
                "You can list several kinds of errors in parentheses.",
            ),
            fill(
                "Fill in the blank to store the error in the variable e.",
                "try:\n    int(\"abc\")\nexcept ValueError ____ e:\n    print(\"Error!\")",
                listOf("as", "in", "is"),
                "as",
                "except SomeError as e: stores the error in the variable e.",
            ),
        ),
        lesson(
            "u10l4", "Review: errors",
            output(
                "try:\n    d = {}\n    print(d[\"x\"])\nexcept KeyError:\n    print(\"no such key\")",
                "no such key",
                "A missing key is a KeyError.",
            ),
            output(
                "results = []\nfor t in [\"1\", \"a\", \"3\"]:\n    try:\n        results.append(int(t))\n    except ValueError:\n        pass\nprint(results)",
                "[1, 3]",
                "Invalid values are skipped.",
            ),
            choice(
                "Which block runs only when there was NO error?",
                listOf("else", "finally", "except", "try"),
                0,
                "else after except runs only when there's no error.",
            ),
            output(
                "def safe_int(s):\n    try:\n        return int(s)\n    except ValueError:\n        return 0\n\nprint(safe_int(\"7\") + safe_int(\"x\"))",
                "7",
                "7 + 0 = 7.",
            ),
            output(
                "try:\n    x = [1, 2, 3]\n    print(x[1])\nexcept IndexError:\n    print(\"error\")\nelse:\n    print(\"OK\")",
                "2\nOK",
                "There was no error, so else runs too.",
            ),
            fill(
                "Fill in the blank to catch division by zero.",
                "try:\n    print(10 / 0)\nexcept ____:\n    print(\"can't do that\")",
                listOf("ZeroDivisionError", "ValueError", "IndexError"),
                "ZeroDivisionError",
                "Dividing by zero raises a ZeroDivisionError.",
            ),
            choice(
                "What will this code print?",
                listOf("a and c", "a, b, and c", "only a", "b and c"),
                0,
                "There was no error, so try and finally run.",
                code = "try:\n    print(\"a\")\nexcept:\n    print(\"b\")\nfinally:\n    print(\"c\")",
            ),
            output(
                "count = 0\nfor x in [2, 0, 5]:\n    try:\n        print(10 // x)\n    except ZeroDivisionError:\n        count += 1\nprint(count)",
                "5\n2\n1",
                "For 0 the error is counted, and the other results are printed.",
            ),
        ),
    ),
)
