package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*
import com.mrpython.app.domain.CourseUnit

internal val module55 = CourseUnit(
    id = "u55",
    title = "Project: calculator",
    description = "We build a calculator step by step",
    lessons = listOf(
        lesson(
            "u55l1", "Operation functions",
            output(
                "def add(a, b):\n    return a + b\n\ndef subtract(a, b):\n    return a - b\n\nprint(add(2, 3), subtract(2, 3))",
                "5 -1",
                "Each operation is a separate, small function.",
            ),
            fill(
                "Fill in the operator so the function multiplies the numbers.",
                "def multiply(a, b):\n    return a ____ b\n\nprint(multiply(4, 5))",
                listOf("*", "x", "**"),
                "*",
                "Multiplication in Python is *, and ** is exponentiation.",
            ),
            output(
                "def divide(a, b):\n    return a / b\n\nprint(divide(7, 2))",
                "3.5",
                "The / operator always gives a floating-point number.",
            ),
            choice(
                "Why do we write each calculator operation as a separate function?",
                listOf("They are easy to test and fix", "Because Python doesn't allow operators in print", "To make the code longer", "Because functions run faster than operators"),
                0,
                "Small functions are independent building blocks of a program – easy to test, fix and call from different places.",
            ),
            tiles(
                "Write, in one line, the function subtract that returns a minus b.",
                listOf("def subtract(a, b):", "return", "a - b"),
                listOf("b - a", "print("),
                "The function returns a reduced by b.",
            ),
            output(
                "def add(a, b):\n    return a + b\n\ndef multiply(a, b):\n    return a * b\n\nprint(add(multiply(2, 3), 4))",
                "10",
                "First 2 * 3 = 6, then 6 + 4 = 10.",
            ),
            output(
                "def power(a, b):\n    return a ** b\n\nprint(power(2, 10))",
                "1024",
                "2 to the power of 10 is 1024.",
            ),
            choice(
                "What happens when you call divide(1, 0)?",
                listOf("ZeroDivisionError", "It returns 0", "It returns None", "It returns inf"),
                0,
                "Dividing by zero raises an exception – we'll deal with it in lesson 4.",
                code = "def divide(a, b):\n    return a / b\n\nprint(divide(1, 0))",
            ),
        ),
        lesson(
            "u55l2", "A dictionary of functions",
            output(
                "def add(a, b):\n    return a + b\n\noperations = {\"+\": add}\nprint(operations[\"+\"](2, 3))",
                "5",
                "We take the function out of the dictionary and call it right away.",
            ),
            choice(
                "What is the value in the dictionary {\"+\": add}?",
                listOf("The function add", "The result of an addition", "The string \"add\"", "A number"),
                0,
                "add without parentheses is the function itself, not its result. Functions are objects – you can store them in a dictionary.",
            ),
            fill(
                "Fill in the dictionary so the * symbol points to the function times.",
                "def times(a, b):\n    return a * b\n\noperations = {\"*\": ____}\nprint(operations[\"*\"](3, 4))",
                listOf("times", "times()", "\"times\""),
                "times",
                "We put in the function itself, without parentheses and without quotes.",
            ),
            output(
                "operations = {\n    \"+\": lambda a, b: a + b,\n    \"-\": lambda a, b: a - b,\n}\nfor op in operations:\n    print(op, operations[op](8, 2))",
                "+ 10\n- 6",
                "Short operations are convenient to write as lambdas.",
            ),
            output(
                "operations = {\"+\": lambda a, b: a + b}\nf = operations.get(\"%\")\nprint(f)",
                "None",
                "get returns None when the operation isn't in the dictionary.",
            ),
            tiles(
                "Call the operation for the given symbol and store the result.",
                listOf("result =", "operations[op]", "(a, b)"),
                listOf("operations(op)", "[a, b]"),
                "First we pick the function from the dictionary, then we call it.",
            ),
            output(
                "import operator\n\noperations = {\"+\": operator.add, \"*\": operator.mul}\nprint(operations[\"*\"](6, 7))",
                "42",
                "The operator module has ready-made functions for operators, e.g. mul is multiplication.",
            ),
            choice(
                "Why is a dictionary of functions better than a long if/elif?",
                listOf("A new operation is a new entry", "A dictionary doesn't need functions", "if/elif doesn't work with symbols", "A dictionary checks for errors by itself"),
                0,
                "A new operation is one new entry in the dictionary, and the code that picks the operation doesn't change.",
            ),
        ),
        lesson(
            "u55l3", "Parsing an expression",
            output(
                "text = \"2 + 3\"\nprint(text.split())",
                "['2', '+', '3']",
                "split() splits a string on spaces.",
            ),
            output(
                "a, op, b = \"10 * 4\".split()\nprint(int(a) * int(b))",
                "40",
                "We unpack the three parts and convert the numbers with int.",
            ),
            fill(
                "Fill in the method that splits the expression into parts.",
                "a, op, b = \"7 - 2\".____()\nprint(op)",
                listOf("split", "strip", "join"),
                "split",
                "split() returns a list of the string's parts.",
            ),
            output(
                "a, op, b = \"1.5 + 2\".split()\nprint(float(a) + float(b))",
                "3.5",
                "float lets you handle numbers with a decimal point.",
            ),
            choice(
                "What does \"2+3\".split() return?",
                listOf("['2+3']", "['2', '+', '3']", "['2', '3']", "An error"),
                0,
                "Without spaces there is nothing to split on – you get a one-element list.",
            ),
            output(
                "ops = {\"+\": lambda a, b: a + b,\n       \"*\": lambda a, b: a * b}\n\ndef calculate(text):\n    a, op, b = text.split()\n    return ops[op](int(a), int(b))\n\nprint(calculate(\"6 * 7\"))\nprint(calculate(\"6 + 7\"))",
                "42\n13",
                "Parsing and a dictionary of functions together make a working calculator.",
            ),
            tiles(
                "Split text into two numbers and a symbol.",
                listOf("a, op, b", "=", "text.split()"),
                listOf("text.split", "=="),
                "split() must be called with parentheses, and the result unpacked into three variables.",
            ),
            choice(
                "What happens when you run this code?",
                listOf("It raises ValueError", "a = 2, op = +, b = 3", "It raises TypeError", "Nothing happens"),
                0,
                "Without split, the string \"2 + 3\" is unpacked character by character: it has 5 characters but there are only 3 variables – too many values, so ValueError.",
                code = "a, op, b = \"2 + 3\"",
            ),
        ),
        lesson(
            "u55l4", "Error handling",
            output(
                "def divide(a, b):\n    if b == 0:\n        return \"Error: division by 0\"\n    return a / b\n\nprint(divide(8, 0))",
                "Error: division by 0",
                "We check for zero before we try to divide.",
            ),
            output(
                "def calculate(text):\n    try:\n        a, op, b = text.split()\n        return int(a) + int(b)\n    except ValueError:\n        return \"Bad input\"\n\nprint(calculate(\"2 +\"))\nprint(calculate(\"x + 1\"))\nprint(calculate(\"2 + 2\"))",
                "Bad input\nBad input\n4",
                "A wrong number of parts and an invalid number are both a ValueError.",
            ),
            fill(
                "Fill in the name of the exception for division by zero.",
                "try:\n    print(5 / 0)\nexcept ____:\n    print(\"Don't divide by 0!\")",
                listOf("ZeroDivisionError", "ValueError", "KeyError"),
                "ZeroDivisionError",
                "Dividing by zero raises ZeroDivisionError.",
            ),
            output(
                "ops = {\"+\": lambda a, b: a + b}\ntry:\n    print(ops[\"^\"](2, 3))\nexcept KeyError:\n    print(\"Unknown operation\")",
                "Unknown operation",
                "A symbol missing from the dictionary gives a KeyError.",
            ),
            choice(
                "What happens when you run this code?",
                listOf("A ZeroDivisionError", "It prints \"Bad input\"", "It prints 0", "It prints inf"),
                0,
                "except ValueError doesn't catch division by zero, so the uncaught ZeroDivisionError stops the program.",
                code = "try:\n    a, op, b = \"3 / 0\".split()\n    print(int(a) / int(b))\nexcept ValueError:\n    print(\"Bad input\")",
            ),
            tiles(
                "Raise a ValueError with the message \"Unknown operation\".",
                listOf("raise", "ValueError(", "\"Unknown operation\"", ")"),
                listOf("return", "except"),
                "raise raises an exception with a message.",
            ),
            output(
                "def calculate(a, op, b):\n    if op not in \"+-\":\n        raise ValueError(\"bad operator\")\n    return a + b if op == \"+\" else a - b\n\ntry:\n    calculate(1, \"?\", 2)\nexcept ValueError as e:\n    print(e)",
                "bad operator",
                "The function raises the error, and the caller catches it.",
            ),
            output(
                "for t in [\"12\", \"1a\", \"\"]:\n    print(t.isdigit())",
                "True\nFalse\nFalse",
                "isdigit() helps you check the data before converting it to a number.",
            ),
        ),
        lesson(
            "u55l5", "History and project summary",
            output(
                "history = []\nfor r in [3 + 4, 10 / 4]:\n    history.append(r)\nprint(history)",
                "[7, 2.5]",
                "We add each result to the end of the history list.",
            ),
            fill(
                "Fill in the method that adds the result to the history.",
                "history = []\nresult = 5\nhistory.____(result)\nprint(history)",
                listOf("append", "add", "push"),
                "append",
                "Lists have the append method; add is for sets.",
            ),
            output(
                "class Calculator:\n    def __init__(self):\n        self.history = []\n    def add(self, a, b):\n        r = a + b\n        self.history.append(r)\n        return r\n\nc = Calculator()\nc.add(1, 2)\nc.add(5, 5)\nprint(c.history)",
                "[3, 10]",
                "The object remembers the history in its attribute.",
            ),
            output(
                "history = [5, 12, 7]\nprint(\"Last:\", history[-1])\nprint(\"Sum:\", sum(history))",
                "Last: 7\nSum: 24",
                "history[-1] is the last result.",
            ),
            output(
                "history = [(\"2 + 3\", 5), (\"4 * 2\", 8)]\nfor expr, r in history:\n    print(f\"{expr} = {r}\")",
                "2 + 3 = 5\n4 * 2 = 8",
                "A tuple stores the expression together with its result.",
            ),
            choice(
                "In what order does our calculator work for the text \"6 * 7\"?",
                listOf("split → dictionary → call → history", "history → split → dictionary → call", "call → split → dictionary → history", "dictionary → history → split → call"),
                0,
                "First we break up the text, then we pick the function from the dictionary and calculate, and finally we save the result to the history.",
            ),
            tiles(
                "Add a tuple with the text and the result to the history.",
                listOf("history.append(", "(text, result)", ")"),
                listOf("history.add(", "[text]"),
                "append adds one element – here, a tuple.",
            ),
            output(
                "ops = {\"+\": lambda a, b: a + b,\n       \"/\": lambda a, b: a / b}\nhistory = []\nfor t in [\"1 + 2\", \"9 / 3\"]:\n    a, op, b = t.split()\n    history.append(ops[op](int(a), int(b)))\nprint(history)",
                "[3, 3.0]",
                "Division with / gives a float, which is why it's 3.0.",
            ),
        ),
    ),
)
