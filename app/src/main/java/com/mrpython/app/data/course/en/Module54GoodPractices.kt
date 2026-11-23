package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*
import com.mrpython.app.domain.CourseUnit

internal val module54 = CourseUnit(
    id = "u54",
    title = "Good practices",
    description = "PEP 8, docstrings, small functions and readable code",
    lessons = listOf(
        lesson(
            "u54l1", "Naming according to PEP 8",
            choice(
                "According to PEP 8, how should you name a variable that stores the number of students?",
                listOf("student_count", "StudentCount", "studentCount", "STUDENT-COUNT"),
                0,
                "Variables and functions are written in snake_case.",
            ),
            choice(
                "According to PEP 8, how should you name a bank account class?",
                listOf("BankAccount", "bank_account", "bankAccount", "BANK_ACCOUNT"),
                0,
                "Classes are written in CapWords – every word starts with a capital letter.",
            ),
            choice(
                "According to PEP 8, how should you name a constant with the maximum number of attempts?",
                listOf("MAX_ATTEMPTS", "max_attempts", "MaxAttempts", "maxAttempts"),
                0,
                "Constants are written in uppercase letters with underscores.",
            ),
            choice(
                "Which name in this code breaks the PEP 8 rules?",
                listOf("CalculateArea", "a", "result", "None of them"),
                0,
                "CalculateArea is a function name, and functions are named in snake_case, e.g. calculate_area. The names a and result are fine.",
                code = "def CalculateArea(a, b):\n    result = a * b\n    return result",
            ),
            fill(
                "Fill in a function name that follows PEP 8 and matches the call.",
                "def ____(a, b):\n    return a + b\n\nprint(add_numbers(2, 3))",
                listOf("add_numbers", "AddNumbers", "addNumbers"),
                "add_numbers",
                "Functions in Python are named in snake_case.",
            ),
            tiles(
                "Write the header of a passenger car class according to PEP 8.",
                listOf("class", "PassengerCar:"),
                listOf("passenger_car:", "def"),
                "Class names are written in CapWords.",
            ),
            output(
                "MAX_ATTEMPTS = 3\nattempts = 0\nwhile attempts < MAX_ATTEMPTS:\n    attempts += 1\nprint(\"Attempts:\", attempts)",
                "Attempts: 3",
                "The constant MAX_ATTEMPTS tells you right away what the number 3 means.",
            ),
            output(
                "class HouseCat:\n    def __init__(self, name):\n        self.name = name\n\nalices_cat = HouseCat(\"Whiskers\")\nprint(alices_cat.name)",
                "Whiskers",
                "The class is in CapWords, the object and attribute in snake_case.",
            ),
        ),
        lesson(
            "u54l2", "Docstrings and __doc__",
            output(
                "def add(a, b):\n    \"\"\"Returns the sum of a and b.\"\"\"\n    return a + b\n\nprint(add.__doc__)",
                "Returns the sum of a and b.",
                "The docstring ends up in the __doc__ attribute.",
            ),
            choice(
                "Where do you put a function's docstring?",
                listOf("At the start of the function body", "Above the def line", "At the end of the function body", "In a # comment"),
                0,
                "Only a string right below the def header becomes the docstring.",
            ),
            output(
                "def f():\n    return 1\n\nprint(f.__doc__)",
                "None",
                "A function without a docstring has __doc__ equal to None.",
            ),
            output(
                "def f():\n    # this is just a comment\n    return 1\n\nprint(f.__doc__)",
                "None",
                "A # comment is not a docstring.",
            ),
            fill(
                "Fill in the blank to print the function's docstring.",
                "def square(x):\n    \"\"\"Returns x squared.\"\"\"\n    return x * x\n\nprint(square.____)",
                listOf("__doc__", "doc", "__name__"),
                "__doc__",
                "The docstring is available as __doc__.",
            ),
            output(
                "class Point:\n    \"\"\"A point on a plane.\"\"\"\n\nprint(Point.__doc__)",
                "A point on a plane.",
                "Classes can have a docstring too.",
            ),
            choice(
                "What should a function's docstring describe?",
                listOf("What it does and returns", "Who wrote it and when", "Every line of the code", "Its test results"),
                0,
                "A docstring says what the function does and what it returns, so you can use it without reading its code.",
            ),
            output(
                "def f():\n    \"\"\"First line.\n\n    Details.\"\"\"\n\nprint(f.__doc__.splitlines()[0])",
                "First line.",
                "The first line of a docstring is a short summary.",
            ),
        ),
        lesson(
            "u54l3", "Small functions and DRY",
            choice(
                "What does the DRY principle mean?",
                listOf("Don't Repeat Yourself", "Write short names", "Avoid classes", "Don't use loops"),
                0,
                "Repeated code is worth moving into one place.",
            ),
            choice(
                "What is the best way to improve this code?",
                listOf("Extract a function", "Add a fourth print", "Change 1.23 to 1.2", "Remove round"),
                0,
                "The same formula in several places is a sign you should create a function, e.g. with_tax(price).",
                code = "print(round(10 * 1.23, 2))\nprint(round(20 * 1.23, 2))\nprint(round(35 * 1.23, 2))",
            ),
            output(
                "def with_tax(price):\n    return round(price * 1.23, 2)\n\nfor price in [10, 20]:\n    print(with_tax(price))",
                "12.3\n24.6",
                "The formula lives in one place, and we call the function many times.",
            ),
            fill(
                "Fill in the function call.",
                "def greeting(name):\n    return \"Hi, \" + name + \"!\"\n\nprint(____(\"Amy\"))",
                listOf("greeting", "greet", "Greeting"),
                "greeting",
                "We call a function by its exact name.",
            ),
            output(
                "def is_even(n):\n    return n % 2 == 0\n\ndef evens(numbers):\n    return [x for x in numbers if is_even(x)]\n\nprint(evens([1, 2, 3, 4]))",
                "[2, 4]",
                "A small helper function makes the second function more readable.",
            ),
            choice(
                "How many jobs should a well-written function have?",
                listOf("One", "As many as possible", "At least three", "It doesn't matter"),
                0,
                "A function that does one thing is easy to name and test.",
            ),
            tiles(
                "Write the header of a function that computes the area of a rectangle, following PEP 8.",
                listOf("def", "rectangle_area(", "a, b", "):"),
                listOf("class", "RectangleArea("),
                "Functions are named in snake_case.",
            ),
            output(
                "def line(n):\n    return \"-\" * n\n\nprint(line(3) + \"x\" + line(3))",
                "---x---",
                "The same function used twice instead of repeating code.",
            ),
        ),
        lesson(
            "u54l4", "Constants and readable conditions",
            choice(
                "What is a magic number?",
                listOf("A number with no name or explanation", "A number the program draws at random", "A very large number in the code", "A number written as text"),
                0,
                "A magic number is a number in code whose meaning isn't clear. It is better given a name, e.g. TAX_RATE = 0.23.",
            ),
            output(
                "TAX_RATE = 0.23\nprice = 100\nprint(price * (1 + TAX_RATE))",
                "123.0",
                "The constant TAX_RATE tells you what 0.23 means.",
            ),
            fill(
                "Fill in the blank using the constant instead of a magic number.",
                "SECONDS_PER_MINUTE = 60\nminutes = 5\nprint(minutes * ____)",
                listOf("SECONDS_PER_MINUTE", "seconds_per_minute", "MINUTE"),
                "SECONDS_PER_MINUTE",
                "The constant's name must be written exactly as it was defined.",
            ),
            output(
                "DAYS_PER_WEEK = 7\ndays = 23\nprint(days // DAYS_PER_WEEK, days % DAYS_PER_WEEK)",
                "3 2",
                "23 days is 3 full weeks and 2 days.",
            ),
            output(
                "age = 20\nhas_ticket = True\ncan_enter = age >= 18 and has_ticket\nprint(can_enter)",
                "True",
                "A named condition reads like a sentence.",
            ),
            choice(
                "What is a simpler way to write the condition if ready == True:?",
                listOf("if ready:", "if ready = True:", "if not ready:", "if \"ready\":"),
                0,
                "A boolean value can be checked directly. = is assignment, not reverses the condition, and the non-empty string \"ready\" is always true.",
            ),
            output(
                "x = 5\nprint(1 < x < 10)",
                "True",
                "Python lets you chain comparisons like in math.",
            ),
            choice(
                "Which line is a more readable version of this condition?",
                listOf("if 0 <= x <= 10:", "if x < 0 and x > 10:", "if 0 < x < 10:", "if x <= 0 or x >= 10:"),
                0,
                "x is not outside the range, so it lies between 0 and 10 inclusive.",
                code = "x = 4\nif not (x < 0 or x > 10):\n    print(\"in range\")",
            ),
        ),
        lesson(
            "u54l5", "Review: early return and style",
            output(
                "def divide(a, b):\n    if b == 0:\n        return \"error\"\n    return a / b\n\nprint(divide(6, 3), divide(1, 0))",
                "2.0 error",
                "We handle the special case at the start and exit right away.",
            ),
            choice(
                "What is the main advantage of an early return?",
                listOf("Fewer nested ifs", "The function runs faster", "You don't need to write tests", "You can skip the docstring"),
                0,
                "Special cases are handled at the start, so the main logic isn't hidden inside deeply nested ifs.",
            ),
            fill(
                "Fill in the blank so the function exits right away for an empty string.",
                "def first_letter(s):\n    if not s:\n        ____ \"\"\n    return s[0]\n\nprint(first_letter(\"\") == \"\")",
                listOf("return", "print", "pass"),
                "return",
                "return ends the function before it reaches s[0].",
            ),
            output(
                "def grade(pts):\n    if pts < 0:\n        return \"error\"\n    if pts >= 50:\n        return \"passed\"\n    return \"failed\"\n\nprint(grade(-1), grade(80), grade(10))",
                "error passed failed",
                "Each case ends the function with its own return.",
            ),
            choice(
                "Which set of names fully follows PEP 8?",
                listOf("calc_average, Student, MAX_GRADE", "CalcAverage, student, max_grade", "calcAverage, STUDENT, MaxGrade", "calc-average, Student, maxGrade"),
                0,
                "The function in snake_case, the class in CapWords, the constant in uppercase.",
            ),
            tiles(
                "Write the header of an early exit: is the list empty.",
                listOf("if", "not", "items:"),
                listOf("else:", "== []"),
                "not items is true for an empty list.",
            ),
            output(
                "def f():\n    \"\"\"Does nothing.\"\"\"\n\nprint(f.__doc__, f())",
                "Does nothing. None",
                "The docstring is __doc__, and a function without return returns None.",
            ),
            choice(
                "What is worth changing in this code?",
                listOf("Replace 0.77 with a constant", "Rename price to Price", "Remove the print", "Add a loop"),
                0,
                "0.77 is a magic number – a named constant, e.g. AFTER_DISCOUNT, explains what it means.",
                code = "price = 100 * 0.77\nprint(price)",
            ),
        ),
    ),
)
