package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

internal val module2Cards = listOf(
    cards(
        "u2l1",
        explain(
            "Rules for variable names",
            "A variable name can contain letters, digits, and the underscore `_`, but it can't start with a digit " +
                "or contain spaces or hyphens. Case matters: `name` and `Name` are two different variables.",
            code = "point_count = 5\nage2 = 9\nprint(point_count, age2)",
            output = "5 9",
        ),
        explain(
            "The -= and *= shortcuts",
            "Just like `+=`, there are also `-=` (subtract) and `*=` (multiply): `x -= 2` means `x = x - 2`. " +
                "`+=` works on strings too – it adds text to the end.",
            code = "x = 10\nx -= 4\nx *= 2\ns = \"Py\"\ns += \"thon\"\nprint(x, s)",
            output = "12 Python",
        ),
        explain(
            "Assignment copies the value",
            "`b = a` stores the current value of `a` in `b`. If you change `a` later, `b` stays as it was. " +
                "`print(b)` prints the value of the variable, not its name.",
            code = "a = 1\nb = a\na = 7\nprint(a, b)",
            output = "7 1",
        ),
    ),
    cards(
        "u2l2",
        explain(
            "int() cuts, it doesn't round",
            "`int()` simply cuts off the part after the decimal point: `int(3.9)` is 3. It converts a string " +
                "to a number only if the string looks like a whole number – `int(\"abc\")` ends with an error.",
            code = "print(int(3.9))\nprint(int(\"12\") + 1)",
            output = "3\n13",
        ),
        explain(
            "float() and division",
            "`float()` converts a value to a number with a decimal point. Division with `/` always gives a `float`, even when " +
                "it divides evenly. Any calculation that involves a `float` gives a `float` too.",
            code = "print(float(3))\nprint(10 / 2)\nprint(type(2 * 1.0))",
            output = "3.0\n5.0\n<class 'float'>",
        ),
    ),
    cards(
        "u2l3",
        explain(
            "Calculations in braces",
            "Inside the braces of an f-string you can write any expression, such as a calculation – Python works it out. " +
                "Without the letter `f`, the braces are plain text and are printed exactly as written.",
            code = "x = 3\nprint(f\"{x} * 2 = {x * 2}\")\nprint(\"{x}\")",
            output = "3 * 2 = 6\n{x}",
        ),
        explain(
            "The prompt in input()",
            "The text in the parentheses of `input(\"Name: \")` is the prompt the user sees. Whatever they type, " +
                "we store in a variable with the `=` sign.",
            code = "name = input(\"Name: \")\nprint(f\"Hey, {name}!\")",
        ),
        explain(
            "A number from input()",
            "`input()` always gives a string, so `input() + 1` ends with an error – you can't add a string " +
                "and a number. Convert the text to a number first: `int(input())`.",
            code = "x = int(input(\"Number: \"))\nprint(x + 1)",
        ),
    ),
    cards(
        "u2l4",
        explain(
            "Rounding: round()",
            "`round(x)` rounds a number to a whole number, and `round(x, 2)` rounds it to 2 decimal places. " +
                "The second argument says how many digits to keep after the decimal point.",
            code = "print(round(2.7))\nprint(round(3.14159, 2))\nprint(round(4.567, 1))",
            output = "3\n3.14\n4.6",
        ),
        explain(
            "What is falsy?",
            "Of the values you know so far, these are falsy: `False`, `0`, `0.0`, the empty string `\"\"`, and `None`. " +
                "The others are truthy – including the string `\"0\"`, a string with a space, and the string `\"False\"`, because they are not empty.",
            code = "print(bool(None))\nprint(bool(\"0\"))\nprint(bool(-3))",
            output = "False\nTrue\nTrue",
        ),
        explain(
            "The type of None",
            "`None` has its own type – `NoneType`. We write it without quotes: `\"None\"` in quotes " +
                "is just a regular string.",
            code = "x = None\nprint(type(x))",
            output = "<class 'NoneType'>",
        ),
    ),
    cards(
        "u2l5",
        explain(
            "Swapping values",
            "You can assign several values at once: `a, b = 1, 2`. Writing `a, b = b, a` swaps the values " +
                "of the variables – with no extra variable needed.",
            code = "a, b = 1, 2\na, b = b, a\nprint(a, b)",
            output = "2 1",
        ),
    ),
)
