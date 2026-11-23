package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*
import com.mrpython.app.domain.CourseUnit

internal val module18 = CourseUnit(
    id = "u18",
    title = "The math module and import",
    description = "import, from … import, as and math functions",
    lessons = listOf(
        lesson(
            "u18l1", "The import statement",
            output("import math\nprint(math.sqrt(16))", "4.0", "math.sqrt computes the square root and returns a float."),
            choice(
                "What does the statement import math do?",
                listOf(
                    "It loads the math module",
                    "It creates a new numeric variable",
                    "It reinstalls Python",
                    "It prints all the math functions",
                ),
                0,
                "After the import, the module's functions are available as math.name.",
            ),
            fill(
                "Fill in the blank to import the math module.",
                "____ math\nprint(math.floor(2.5))",
                listOf("import", "include", "using"),
                "import",
                "In Python we load modules with the word import.",
            ),
            output("import math\nprint(math.floor(7.9))", "7", "floor rounds down to a whole number."),
            choice(
                "What happens when you run this code?",
                listOf("NameError", "It prints 3.0", "It prints 3", "SyntaxError"),
                0,
                "After import math we call functions with the prefix: math.sqrt(9). A bare sqrt doesn't exist, so you get a NameError.",
                code = "import math\nprint(sqrt(9))",
            ),
            tiles(
                "Print the square root of 25 (the math module is already imported).",
                listOf("print(", "math.sqrt(", "25", "))"),
                listOf("sqrt.math(", "import"),
                "First the module name, then a dot and the function name.",
            ),
            output("import math\nx = math.ceil(4.1)\nprint(x + 1)", "6", "ceil rounds up: 4.1 → 5, and 5 + 1 = 6."),
            output("import math\nprint(math.pi > 3)", "True", "math.pi is about 3.14159, so it is greater than 3."),
        ),
        lesson(
            "u18l2", "from … import and as",
            output("from math import sqrt\nprint(sqrt(49))", "7.0", "After from math import sqrt we write just sqrt."),
            choice(
                "How do you call the function after from math import floor?",
                listOf("floor(2.5)", "math.floor(2.5)", "import.floor(2.5)", "from.floor(2.5)"),
                0,
                "from … import loads just the name – without the math. prefix.",
            ),
            fill(
                "Fill in the blank to import only the function ceil.",
                "____ math import ceil\nprint(ceil(1.2))",
                listOf("from", "import", "in"),
                "from",
                "The syntax is from module import name.",
            ),
            output("import math as m\nprint(m.floor(3.99))", "3", "as gives the module the shorter name m."),
            fill(
                "Fill in the blank to give the module the shorter name m.",
                "import math ____ m\nprint(m.ceil(2.1))",
                listOf("as", "is", "to"),
                "as",
                "import module as short_name creates an alias.",
            ),
            output(
                "from math import pi, sqrt\nprint(round(pi, 2))\nprint(sqrt(4))",
                "3.14\n2.0",
                "You can import several names at once, separating them with commas.",
            ),
            tiles(
                "Import the functions sqrt and floor from the math module.",
                listOf("from", "math", "import", "sqrt,", "floor"),
                listOf("as", "include"),
                "After import we list the names separated by commas.",
            ),
            choice(
                "What happens when you run this code?",
                listOf("NameError", "It prints 3.141592653589793", "It prints m", "SyntaxError"),
                0,
                "After import math as m the module is visible only under the name m, so math gives a NameError.",
                code = "import math as m\nprint(math.pi)",
            ),
        ),
        lesson(
            "u18l3", "Functions of the math module",
            output("import math\nprint(math.floor(2.7))\nprint(math.ceil(2.1))", "2\n3", "floor rounds down, ceil rounds up."),
            output("import math\nprint(math.pow(2, 3))", "8.0", "math.pow always returns a float."),
            output("import math\nprint(math.gcd(12, 18))", "6", "gcd is the greatest common divisor – for 12 and 18 it is 6."),
            choice(
                "What does math.ceil(5.0) return?",
                listOf("5", "6", "5.5", "4"),
                0,
                "5.0 is already whole, so ceil returns 5.",
            ),
            output(
                "import math\nprint(0.1 + 0.2 == 0.3)\nprint(math.isclose(0.1 + 0.2, 0.3))",
                "False\nTrue",
                "Floats have tiny rounding errors – isclose compares them with a tolerance.",
            ),
            fill(
                "Fill in the blank to round 4.2 up to 5.",
                "import math\nprint(math.____(4.2))",
                listOf("ceil", "floor", "sqrt"),
                "ceil",
                "ceil (ceiling) rounds up.",
            ),
            choice(
                "What does math.floor(-2.5) return?",
                listOf("-3", "-2", "-2.5", "2"),
                0,
                "floor rounds down, toward smaller numbers: to -3.",
            ),
            output(
                "import math\nr = 2\narea = math.pi * r ** 2\nprint(round(area, 1))",
                "12.6",
                "The area of a circle is π·r², which is about 12.566.",
            ),
        ),
        lesson(
            "u18l4", "What a module is",
            choice(
                "What is a module in Python?",
                listOf(
                    "A .py file with code",
                    "A kind of loop",
                    "A type of number",
                    "A comment in the code",
                ),
                0,
                "Every .py file is a module that other files can import.",
            ),
            choice(
                "You have a file helper.py with a function greet(). How do you import it in a file next to it?",
                listOf(
                    "from helper import greet",
                    "import greet from helper",
                    "from helper.py import greet",
                    "include helper",
                ),
                0,
                "The module name is the file name without the .py ending.",
            ),
            tiles(
                "Import the math module under the name m.",
                listOf("import", "math", "as", "m"),
                listOf("from", "is"),
                "import module as alias.",
            ),
            output("import math\nprint(type(math.pi))", "<class 'float'>", "math.pi is an ordinary constant of type float."),
            choice(
                "Why is it worth splitting a program into modules?",
                listOf(
                    "The code is easier to organize and reuse",
                    "The program always runs faster",
                    "Modules remove bugs on their own",
                    "Python requires it",
                ),
                0,
                "Modules organize code and let you use it in many places.",
            ),
            choice(
                "What does from math import * mean?",
                listOf(
                    "It imports all the names from math",
                    "It imports only the constant pi",
                    "It imports the module under the name *",
                    "It's a syntax error",
                ),
                0,
                "The star imports all the module's public names, but name conflicts happen easily then – better to avoid it.",
            ),
            output(
                "import math\nimport math\nprint(math.gcd(8, 12))",
                "4",
                "A second import of the same module changes nothing – a module is loaded once.",
            ),
            choice(
                "What happens after import mathematics if no such module exists?",
                listOf("ModuleNotFoundError", "NameError", "Nothing happens", "ValueError"),
                0,
                "When Python can't find a module, it raises ModuleNotFoundError.",
            ),
        ),
        lesson(
            "u18l5", "Review: math and import",
            output("from math import floor, ceil\nx = 3.5\nprint(floor(x) + ceil(x))", "7", "floor(3.5) is 3, ceil(3.5) is 4."),
            output("import math as m\nprint(m.sqrt(81) + 1)", "10.0", "sqrt returns the float 9.0, so the result is 10.0."),
            fill(
                "Fill in the blank to compute the GCD of 20 and 8.",
                "import math\nprint(math.____(20, 8))",
                listOf("gcd", "pow", "floor"),
                "gcd",
                "gcd is the greatest common divisor.",
            ),
            choice(
                "Which line lets you write sqrt(2) without a prefix?",
                listOf("from math import sqrt", "import math", "import math as sqrt", "import sqrt"),
                0,
                "from … import loads the name directly.",
            ),
            output(
                "import math\nsides = [3, 4]\nc = math.sqrt(sides[0]**2 + sides[1]**2)\nprint(c)",
                "5.0",
                "By the Pythagorean theorem: √(9 + 16) = 5.",
            ),
            tiles(
                "Round 9.8 down (you already have from math import floor).",
                listOf("print(", "floor(", "9.8", "))"),
                listOf("ceil(", "round("),
                "floor rounds down – the result is 9.",
            ),
            output(
                "import math\nprint(math.isclose(1.0, 1.0000000001))",
                "True",
                "The difference is so small that isclose treats the numbers as equal.",
            ),
            output(
                "import math\nnumbers = [1.2, 2.7, 3.5]\nprint([math.ceil(x) for x in numbers])",
                "[2, 3, 4]",
                "ceil rounds every number up.",
            ),
        ),
    ),
)
