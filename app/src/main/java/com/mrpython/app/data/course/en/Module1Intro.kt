package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

internal val module1Intro = lesson(
    "u1l0", "Introduction: your first program",
    explain(
        "What is a program?",
        "A program is a list of instructions for the computer. Python runs them in order, from top to bottom – " +
            "line by line. In this app you can think of every example as a `main.py` file.",
    ),
    explain(
        "The print() function",
        "To show something on the screen, we use the `print()` function. Whatever you want to print " +
            "goes inside the parentheses.",
        code = "print(\"Hi!\")",
        output = "Hi!",
    ),
    explain(
        "Strings in quotes",
        "Text in Python is called a string. We always wrap it in double quotes \" \" or " +
            "single quotes ' '. The quotes don't appear on the screen.",
        code = "print(\"Python\")\nprint('is fun')",
        output = "Python\nis fun",
    ),
    explain(
        "Numbers and math",
        "We don't put numbers and calculations in quotes – then Python works them out and `print()` shows the result. " +
            "Anything inside quotes is text: it is printed exactly as written, even if it looks like a calculation.",
        code = "print(2 + 3)\nprint(\"2 + 3\")",
        output = "5\n2 + 3",
    ),
    explain(
        "Comments",
        "The `#` sign starts a comment – from there to the end of the line is a note for people. Python skips it.",
        code = "# this is a comment\nprint(\"It works!\")",
        output = "It works!",
    ),
    choice(
        "What appears on the screen first?",
        listOf("Start", "Hidden", "End", "Nothing"),
        0,
        "Python runs lines from the top and skips the line with # – so it prints Start first.",
        code = "print(\"Start\")\n# print(\"Hidden\")\nprint(\"End\")",
    ),
    output(
        "print(\"Hello\")\nprint(10 + 5)",
        "Hello\n15",
        "The string is printed without quotes, and the calculation is worked out.",
    ),
)
