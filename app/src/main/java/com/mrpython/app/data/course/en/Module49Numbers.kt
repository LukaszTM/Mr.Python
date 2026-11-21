package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*
import com.mrpython.app.domain.CourseUnit

internal val module49 = CourseUnit(
    id = "u49",
    title = "Numbers in practice",
    description = "Float precision, rounding, Decimal, Fraction and number systems",
    lessons = listOf(
        lesson(
            "u49l1", "Float precision",
            output("print(0.1 + 0.2)", "0.30000000000000004", "0.1 and 0.2 have no exact binary representation, so a tiny error appears."),
            output("print(0.1 + 0.2 == 0.3)", "False", "Because of the rounding error the result isn't exactly equal to 0.3."),
            output(
                "import math\nprint(math.isclose(0.1 + 0.2, 0.3))",
                "True",
                "math.isclose() checks whether numbers are almost equal.",
            ),
            output(
                "s = 0\nfor _ in range(10):\n    s += 0.1\nprint(s)",
                "0.9999999999999999",
                "Small errors add up over many additions.",
            ),
            output(
                "import math\nprint(math.fsum([0.1] * 10))",
                "1.0",
                "math.fsum() sums floats accurately, without the errors building up.",
            ),
            choice(
                "How do you safely compare two floats?",
                listOf("math.isclose(a, b)", "a == b", "a is b", "str(a) == str(b)"),
                0,
                "Because of rounding errors we compare with a tolerance.",
            ),
            fill(
                "Fill in the blank so the comparison returns True.",
                "import math\nprint(math.____(0.1 * 3, 0.3))",
                listOf("isclose", "floor", "fsum"),
                "isclose",
                "isclose() compares with a tolerance; floor() and fsum() don't accept two arguments like these.",
            ),
            choice(
                "Why doesn't 0.1 + 0.2 give exactly 0.3?",
                listOf(
                    "The computer stores floats in binary and 0.1 has no exact representation",
                    "It's a bug in Python",
                    "Python rounds every addition up",
                    "0.1 is too small for the float type",
                ),
                0,
                "Decimal fractions like 0.1 are infinite in the binary system.",
            ),
        ),
        lesson(
            "u49l2", "Rounding",
            output("print(round(2.5))", "2", "On a tie round() picks the even number (banker's rounding)."),
            output("print(round(3.5))", "4", "4 is even, so 3.5 goes up."),
            output("print(round(0.5), round(1.5))", "0 2", "Ties always go to the nearest even number."),
            output("print(round(3.14159, 2))", "3.14", "The second argument is the number of decimal places."),
            choice(
                "What will round(1234, -2) return?",
                listOf("1200", "1234.0", "12.34", "Error"),
                0,
                "A negative number of places rounds to tens, hundreds and so on.",
            ),
            output("print(type(round(2.7)).__name__)", "int", "round() with one argument returns an int."),
            choice(
                "What will this code print?",
                listOf("2.67", "2.68", "2.7", "2.675"),
                0,
                "2.675 as a float is actually a little less than 2.675.",
                code = "print(round(2.675, 2))",
            ),
            fill(
                "Fill in the blank to print the number with two decimal places.",
                "x = 3.14159\nprint(f\"{x:.____f}\")",
                listOf("2", "3", "0"),
                "2",
                ".2f means two decimal places: 3.14.",
            ),
        ),
        lesson(
            "u49l3", "Decimal and Fraction",
            output(
                "from decimal import Decimal\nprint(Decimal(\"0.1\") + Decimal(\"0.2\"))",
                "0.3",
                "Decimal calculates exactly in the decimal system.",
            ),
            output(
                "from decimal import Decimal\nprint(Decimal(\"1.10\") + Decimal(\"2.20\"))",
                "3.30",
                "Decimal keeps the number of decimal places – handy for money.",
            ),
            choice(
                "Why do we create a Decimal from a string, e.g. Decimal(\"0.1\"), and not Decimal(0.1)?",
                listOf(
                    "The float 0.1 already has an error, which Decimal would copy exactly",
                    "Decimal doesn't accept numbers",
                    "A string is faster",
                    "There is no difference",
                ),
                0,
                "Decimal(0.1) gives the long number 0.1000000000000000055511…",
            ),
            output(
                "from decimal import Decimal, ROUND_HALF_UP\nx = Decimal(\"2.675\")\nprint(x.quantize(Decimal(\"0.01\"), rounding=ROUND_HALF_UP))",
                "2.68",
                "quantize() with ROUND_HALF_UP rounds the way you learned in school.",
            ),
            output(
                "from fractions import Fraction\nprint(Fraction(1, 3) + Fraction(1, 6))",
                "1/2",
                "Fraction calculates with common fractions and reduces them on its own.",
            ),
            output(
                "from fractions import Fraction\nprint(Fraction(3, 6))",
                "1/2",
                "The fraction is reduced right away.",
            ),
            output(
                "from fractions import Fraction\nprint(float(Fraction(1, 4)))",
                "0.25",
                "float() converts the fraction to a floating-point number.",
            ),
            fill(
                "Fill in the blank so the calculation is exact.",
                "from decimal import Decimal\na = Decimal(\"0.7\")\nb = ____(\"0.1\")\nprint(a + b)",
                listOf("Decimal", "float", "str"),
                "Decimal",
                "float + Decimal raises a TypeError, and str + Decimal is an error too.",
            ),
        ),
        lesson(
            "u49l4", "Number systems",
            output("print(bin(10))", "0b1010", "bin() returns the binary form with the prefix 0b."),
            output("print(hex(255))", "0xff", "hex() returns the hexadecimal form with the prefix 0x."),
            output("print(int(\"ff\", 16))", "255", "The second argument of int() is the base of the system."),
            output("print(int(\"1010\", 2))", "10", "We convert a binary string to a number with base 2."),
            tiles(
                "Store the binary form of the number n in the variable b",
                listOf("b", "=", "bin(n)"),
                listOf("hex(n)", "int(n, 2)"),
                "bin() returns a string with the binary form.",
            ),
            output("print(f\"{10:b}\", f\"{255:x}\")", "1010 ff", "In an f-string b means binary and x hexadecimal."),
            choice(
                "What does the prefix 0o mean, e.g. 0o17?",
                listOf("An octal number", "A hexadecimal number", "A binary number", "Zero"),
                0,
                "0o is the octal system (oct), so 0o17 is 15.",
            ),
            fill(
                "Fill in the blank to convert the hexadecimal string to a number.",
                "print(int(\"1A\", ____))",
                listOf("16", "2", "10"),
                "16",
                "The letter A exists only in the hexadecimal system; for 2 and 10 there will be a ValueError.",
            ),
        ),
        lesson(
            "u49l5", "Review: numbers",
            output("print(round(4.5), round(5.5))", "4 6", "Ties are rounded to the even number."),
            output(
                "import math\nprint(0.3 - 0.1 == 0.2, math.isclose(0.3 - 0.1, 0.2))",
                "False True",
                "== fails because of the float error, isclose() doesn't.",
            ),
            output(
                "from fractions import Fraction\nprint(Fraction(2, 3) * 3)",
                "2",
                "A fraction with denominator 1 is printed like a whole number.",
            ),
            output(
                "from decimal import Decimal\nprint(Decimal(\"10\") / Decimal(\"4\"))",
                "2.5",
                "Decimal division gives an exact decimal result.",
            ),
            output("print(int(\"777\", 8))", "511", "7·64 + 7·8 + 7 = 511."),
            choice(
                "Which type should you choose for amounts of money to avoid rounding errors?",
                listOf("Decimal", "float", "complex", "bool"),
                0,
                "Decimal calculates exactly in the decimal system.",
            ),
            fill(
                "Fill in the blank to print the binary form of the number 5.",
                "print(____(5))",
                listOf("bin", "hex", "oct"),
                "bin",
                "bin(5) is 0b101; hex and oct give other systems.",
            ),
            tiles(
                "Convert the hexadecimal string s to a number and store it in the variable n",
                listOf("n", "=", "int(s,", "16)"),
                listOf("hex(s)", "2)"),
                "int(string, 16) reads a hexadecimal number.",
            ),
        ),
    ),
)
