package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

internal val module49Intro = lesson(
    "u49l0", "Introduction: numbers in practice",
    explain(
        "Float precision",
        "A computer stores `float` numbers in binary, and 0.1 has no exact representation there. " +
            "That's where the tiny errors come from. Use `math.isclose()` for comparisons, and " +
            "`math.fsum()` for summing many fractions.",
        code = "import math\nprint(0.1 + 0.2)\nprint(0.1 + 0.2 == 0.3)\nprint(math.isclose(0.1 + 0.2, 0.3))",
        output = "0.30000000000000004\nFalse\nTrue",
    ),
    explain(
        "Rounding",
        "`round(x)` returns an int, and `round(x, n)` keeps n decimal places. On a tie (e.g. 2.5) " +
            "Python picks the even number. For printing, the f-string `{x:.2f}` is handy.",
        code = "print(round(2.5), round(3.5))\nprint(round(3.14159, 2))\nprint(f\"{2/3:.2f}\")",
        output = "2 4\n3.14\n0.67",
    ),
    explain(
        "Decimal – exact decimal fractions",
        "`Decimal` from the `decimal` module calculates exactly in the decimal system – perfect for money. " +
            "We create it from a string, e.g. `Decimal(\"0.1\")`, because the float 0.1 already has an error.",
        code = "from decimal import Decimal\nprint(Decimal(\"0.1\") + Decimal(\"0.2\"))\nprint(Decimal(\"1.10\") + Decimal(\"2.20\"))",
        output = "0.3\n3.30",
    ),
    explain(
        "Fraction – common fractions",
        "`Fraction(numerator, denominator)` from the `fractions` module stores a common fraction and reduces " +
            "it on its own. `float()` converts it to a decimal number.",
        code = "from fractions import Fraction\nprint(Fraction(1, 3) + Fraction(1, 6))\nprint(float(Fraction(1, 4)))",
        output = "1/2\n0.25",
    ),
    explain(
        "Number systems",
        "`bin()` gives the binary form (0b), `hex()` the hexadecimal one (0x), and `oct()` the octal one (0o). " +
            "You can convert a string in another system to a number with `int(string, base)`.",
        code = "print(bin(10), hex(255))\nprint(int(\"ff\", 16), int(\"1010\", 2))",
        output = "0b1010 0xff\n255 10",
    ),
    output(
        "print(round(4.5), round(5.5))",
        "4 6",
        "Ties go to the nearest even number.",
    ),
    choice(
        "Which type should you choose for amounts of money?",
        listOf("Decimal", "float", "bool", "complex"),
        0,
        "Decimal calculates exactly in the decimal system.",
    ),
    fill(
        "Fill in the blank to convert the binary string to the number 5.",
        "print(int(\"101\", ____))",
        listOf("2", "10", "16"),
        "2",
        "Base 2 is the binary system; the other bases would give 101 or 257.",
    ),
)
