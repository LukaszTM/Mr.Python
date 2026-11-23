package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*
import com.mrpython.app.domain.CourseUnit

internal val module2 = CourseUnit(
    id = "u2",
    title = "Variables and types",
    description = "Store data and get to know its types",
    lessons = listOf(
        lesson(
            "u2l1", "Variables",
            choice(
                "How do you store the number 5 in the variable x?",
                listOf("x = 5", "x == 5", "5 = x", "let x = 5"),
                0,
                "A single = sign assigns a value to a variable.",
            ),
            output(
                "x = 3\nx = x + 2\nprint(x)",
                "5",
                "First x is 3, then we overwrite it with the value 3 + 2.",
            ),
            tiles(
                "Create a variable name with the value \"Emma\"",
                listOf("name", "=", "\"Emma\""),
                listOf("==", "Emma"),
                "The variable name, the = sign, and the value – in that order.",
            ),
            choice(
                "Which variable name is invalid?",
                listOf("my_variable", "age2", "2age", "_hidden"),
                2,
                "A variable name can't start with a digit.",
            ),
            output(
                "a = \"cat\"\nb = a\nprint(b)",
                "cat",
                "b gets the same value as a.",
            ),
            output(
                "a = 5\nb = a\na = 10\nprint(b)",
                "5",
                "b got the value 5; changing a later doesn't affect it.",
            ),
            output(
                "x = 2\nx += 3\nx *= 2\nprint(x)",
                "10",
                "x += 3 is short for x = x + 3, and x *= 2 is short for x = x * 2.",
            ),
            choice(
                "How many different variables does this code create?",
                listOf("3", "1", "2", "Error"),
                0,
                "Python is case-sensitive: name, Name, and NAME are three different names.",
                code = "name = \"Emma\"\nName = \"Anna\"\nNAME = \"Ella\"",
            ),
        ),
        lesson(
            "u2l2", "Data types",
            choice(
                "What type is the value 3.14?",
                listOf("int", "float", "str", "bool"),
                1,
                "Numbers with a decimal point are floats (floating-point numbers).",
            ),
            output(
                "print(type(7))",
                "<class 'int'>",
                "7 is a whole number, which is an int.",
            ),
            output(
                "print(int(\"4\") + 1)",
                "5",
                "int() converts the string \"4\" to the number 4.",
            ),
            choice(
                "What does this code print?",
                listOf("5", "41", "Error", "4 1"),
                1,
                "\"4\" and \"1\" are strings, so + joins them.",
                code = "print(\"4\" + \"1\")",
            ),
            fill(
                "Convert the string to a whole number.",
                "age = ____(\"18\")",
                listOf("int", "str", "text"),
                "int",
                "int() creates a whole number.",
            ),
            output(
                "print(str(10) + \"0\")",
                "100",
                "str(10) is the string \"10\", and adding \"0\" to it gives \"100\".",
            ),
            output("print(type(\"7\"))", "<class 'str'>", "Anything in quotes is a string."),
            output("print(int(3.9))", "3", "int() cuts off the fractional part – it doesn't round."),
        ),
        lesson(
            "u2l3", "f-strings and input()",
            choice(
                "What does the input() function return?",
                listOf("Always a string (str)", "Always a number", "True or False", "Nothing"),
                0,
                "input() returns whatever the user typed, as a string.",
            ),
            output(
                "name = \"Eve\"\nprint(f\"Hi, {name}!\")",
                "Hi, Eve!",
                "In an f-string, {name} is replaced with the value of the variable.",
            ),
            fill(
                "Fill in the blank so the expression in braces gets calculated.",
                "print(____\"Result: {2 + 2}\")",
                listOf("f", "$", "#"),
                "f",
                "The letter f before the quote creates an f-string.",
            ),
            output(
                "x = 7\nprint(f\"{x} * 2 = {x * 2}\")",
                "7 * 2 = 14",
                "You can put any expression inside the braces.",
            ),
            tiles(
                "Read a name from the user into the variable name",
                listOf("name", "=", "input(", "\"Name: \"", ")"),
                listOf("print("),
                "input() shows the prompt and returns the text that was typed.",
            ),
            output(
                "price = 4.5\nprint(f\"Total: {price * 2} dollars\")",
                "Total: 9.0 dollars",
                "4.5 * 2 is a float, so the result is 9.0.",
            ),
            choice(
                "The user types 5. What happens?",
                listOf("An error – you can't add str and int", "It prints 6", "It prints 51", "It prints 5 1"),
                0,
                "input() returns the string \"5\". You have to convert it: int(x) + 1.",
                code = "x = input(\"Number: \")\nprint(x + 1)",
            ),
        ),
        lesson(
            "u2l4", "True, False, and None",
            choice(
                "What type is the value True?",
                listOf("bool", "str", "int", "None"),
                0,
                "True and False are logical values – the bool type.",
            ),
            output("print(type(False))", "<class 'bool'>", "False is a value of type bool."),
            output("print(bool(0))\nprint(bool(7))", "False\nTrue", "0 is \"falsy\", any other number is \"truthy\"."),
            output("print(bool(\"\"))\nprint(bool(\"a\"))", "False\nTrue", "An empty string is falsy, a non-empty one is truthy."),
            choice(
                "What does None mean?",
                listOf("No value", "Zero", "An empty string", "False"),
                0,
                "None is a special value that means \"nothing\".",
            ),
            output("x = None\nprint(x)", "None", "print shows None as the word None."),
            output("print(round(3.14159, 2))", "3.14", "round(number, 2) rounds to 2 decimal places."),
            output("print(round(2.7))", "3", "round() without a second argument rounds to a whole number."),
        ),
        lesson(
            "u2l5", "Review: variables and types",
            output("a = \"3\"\nb = 3\nprint(a * b)", "333", "A string times a number repeats the string."),
            output("x = 10\ny = 3\nx, y = y, x\nprint(x, y)", "3 10", "x, y = y, x swaps the two values."),
            choice(
                "What type is the result of 7 / 7?",
                listOf("float", "int", "str", "bool"),
                0,
                "The / operator always returns a float – here 1.0.",
            ),
            output("print(int(\"12\") + int(\"8\"))", "20", "After converting to int, the strings are added like numbers."),
            fill(
                "Fill in the blank to join a number to a string.",
                "age = 20\nprint(\"I am \" + ____(age) + \" years old\")",
                listOf("str", "int", "float"),
                "str",
                "A number has to be converted to a string before you can join it.",
            ),
            output(
                "name = \"Jake\"\nage = 9\nprint(f\"{name} is {age + 1} years old\")",
                "Jake is 10 years old",
                "You can do math inside the braces of an f-string.",
            ),
            tiles(
                "Increase the value of the variable points by 10",
                listOf("points", "+=", "10"),
                listOf("-=", "++"),
                "+= adds a value to a variable.",
            ),
            output("x = 5\nx = x * 2 - 1\nprint(x)", "9", "5 * 2 - 1 = 9."),
        ),
    ),
)
