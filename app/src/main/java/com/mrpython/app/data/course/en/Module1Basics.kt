package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*
import com.mrpython.app.domain.CourseUnit

internal val module1 = CourseUnit(
    id = "u1",
    title = "First steps",
    description = "print(), strings, and comments",
    lessons = listOf(
        lesson(
            "u1l1", "Hello, world!",
            choice(
                "Which statement prints text on the screen?",
                listOf("print(\"Hi\")", "Print(\"Hi\")", "print \"Hi\"", "print(Hi)"),
                0,
                "print is written in lowercase, with parentheses, and the string goes in quotes.",
            ),
            output(
                "print(\"Hello, world!\")",
                "Hello, world!",
                "print() shows the string without the quotes.",
            ),
            tiles(
                "Arrange the code to print: Hey",
                listOf("print(", "\"Hey\"", ")"),
                listOf("Print(", "Hey"),
                "The string has to be in quotes and inside the parentheses of print.",
            ),
            fill(
                "Fill in the blank to print the word Python.",
                "____(\"Python\")",
                listOf("print", "Print", "write"),
                "print",
                "The function that prints text is print.",
            ),
            output(
                "print(\"Anna\")\nprint(\"has a cat\")",
                "Anna\nhas a cat",
                "Every print() call ends with a new line.",
            ),
            choice(
                "What is missing from this code?",
                listOf("A closing parenthesis )", "An opening parenthesis (", "A quote at the end", "Nothing – the code is correct"),
                0,
                "Every opening parenthesis has to be closed.",
                code = "print(\"Hey\"",
            ),
            output(
                "print(\"2 + 3\")\nprint(2 + 3)",
                "2 + 3\n5",
                "Inside quotes it's text; without quotes it's a calculation.",
            ),
        ),
        lesson(
            "u1l2", "Strings and comments",
            choice(
                "What does the # character mean in Python?",
                listOf(
                    "The start of a comment",
                    "A number",
                    "The end of the program",
                    "Multiplication",
                ),
                0,
                "From # to the end of the line is a comment – a note for people that Python skips.",
            ),
            output(
                "# print(\"A\")\nprint(\"B\")",
                "B",
                "The first line is a comment, so it doesn't run.",
            ),
            choice(
                "Are both ways of writing a string correct: \"text\" and 'text'?",
                listOf("Yes, both", "Only \"text\"", "Only 'text'", "No, neither"),
                0,
                "Python accepts both double quotes and single quotes.",
            ),
            output(
                "print(\"Py\" + \"thon\")",
                "Python",
                "The + operator joins (concatenates) strings.",
            ),
            output(
                "print(\"ha\" * 3)",
                "hahaha",
                "A string multiplied by a number is repeated that many times.",
            ),
            output(
                "print(\"Anna\", \"has\", \"a cat\")",
                "Anna has a cat",
                "print() separates multiple arguments with spaces.",
            ),
            output(
                "print(\"Anna\" + \" \" + \"Emma\")",
                "Anna Emma",
                "You have to add the space yourself – + doesn't insert one.",
            ),
            choice(
                "Which line correctly prints: It's OK",
                listOf("print(\"It's OK\")", "print('It's OK')", "print(It's OK)", "print(\"It\"s OK\")"),
                0,
                "An apostrophe inside a string wrapped in double quotes \" \" causes no trouble.",
            ),
        ),
        lesson(
            "u1l3", "Special characters and print()",
            output("print(\"Anna\\nhas a cat\")", "Anna\nhas a cat", "\\n inside a string means: go to a new line."),
            choice(
                "What does \\t mean in a string?",
                listOf("A tab", "A new line", "The letter t", "The end of the string"),
                0,
                "\\t inserts a tab character, which is a wide gap.",
            ),
            output("print(\"A\", end=\"\")\nprint(\"B\")", "AB", "end=\"\" stops print from moving to a new line."),
            output("print(\"A\", \"B\", \"C\", sep=\"-\")", "A-B-C", "sep sets what goes between the arguments."),
            fill(
                "Fill in the blank so both words appear on one line.",
                "print(\"One\", ____=\" \")\nprint(\"two\")",
                listOf("end", "sep", "new"),
                "end",
                "The end parameter sets what print adds at the end instead of a new line.",
            ),
            output("print(\"Price:\", 5, \"dollars\")", "Price: 5 dollars", "print() prints strings and numbers together and puts a space between the arguments."),
            choice(
                "How many lines does this code print?",
                listOf("3", "1", "2", "0"),
                0,
                "Two \\n characters split the text into three lines.",
                code = "print(\"a\\nb\\nc\")",
            ),
            tiles(
                "Arrange the code to print: A,B",
                listOf("print(", "\"A\",", "\"B\",", "sep=\",\"", ")"),
                listOf("end=\",\"", "+"),
                "sep=\",\" separates the arguments with a comma instead of a space.",
            ),
        ),
        lesson(
            "u1l4", "Review: first steps",
            output("print(\"Py\" * 2 + \"!\")", "PyPy!", "First the string is multiplied, then joined."),
            choice(
                "Which line does NOT print anything?",
                listOf("# print(\"Hey\")", "print(\"Hey\")", "print('Hey')", "print(\"# Hey\")"),
                0,
                "A line that starts with # is a comment.",
            ),
            output("print(\"# not a comment\")", "# not a comment", "A # inside a string is just a regular character."),
            output("print(\"Result:\", 10 * 3)", "Result: 30", "Python calculates 10 * 3 and prints the result next to the text."),
            fill(
                "Fill in the blank to repeat the string 3 times.",
                "print(\"la\" ____ 3)",
                listOf("*", "+", "x"),
                "*",
                "A string multiplied by a number is repeated.",
            ),
            tiles(
                "Arrange the code to print: Hey, Emma!",
                listOf("print(", "\"Hey, \"", "+", "\"Emma!\"", ")"),
                listOf("-", "*"),
                "+ joins two strings into one.",
            ),
            output("print(\"1\" + \"2\")\nprint(1 + 2)", "12\n3", "Strings are joined, numbers are added."),
            output(
                "print(\"A\", end=\" \")\nprint(\"B\", end=\" \")\nprint(\"C\")",
                "A B C",
                "end=\" \" replaces the new line with a space.",
            ),
        ),
    ),
)
