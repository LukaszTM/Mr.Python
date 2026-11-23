package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

internal val module49Cards = listOf(
    cards(
        "u49l1",
        explain(
            "Which fractions are exact?",
            "Only fractions made up of halves, quarters, eighths and so on are stored exactly, e.g. 0.5, " +
                "0.25 or 0.75. You can compare their sums with `==` without any trouble. 0.1, 0.2 and 0.3 already " +
                "carry a tiny error, which grows as you add.",
            code = "print(0.5 + 0.25 == 0.75)\nprint(sum([0.1] * 3))",
            output = "True\n0.30000000000000004",
        ),
        explain(
            "Comparing with a tolerance",
            "Instead of `==` you can check whether the difference is very small: `abs(a - b) < 1e-9`. " +
                "The notation `1e-9` is 0.000000001 (1 times 10 to the power of -9). `math.isclose()` works the same way.",
            code = "x = 0.1 + 0.2\nprint(abs(x - 0.3) < 1e-9)\nprint(1e-3)",
            output = "True\n0.001",
        ),
    ),
    cards(
        "u49l2",
        explain(
            "Negative places in round",
            "A negative number of places rounds before the decimal point: `-1` to tens, `-2` to hundreds. " +
                "`round(x, n)` with `n` given returns a float, and for a whole number – an int. The format " +
                "`{x:.0f}` also rounds ties to the even number.",
            code = "print(round(1567, -1), round(1234, -2))\nprint(round(2.567, 1))\nprint(f\"{0.5:.0f} {1.5:.0f}\")",
            output = "1570 1200\n2.6\n0 2",
        ),
        explain(
            "A trap: round(2.675, 2)",
            "The number 2.675 is stored in memory as a tiny bit less than 2.675, so `round` gives 2.67. " +
                "It's not a Python bug, just a consequence of floats being stored in binary.",
            code = "print(round(2.675, 2))\nprint(round(1.005, 2))",
            output = "2.67\n1.0",
        ),
    ),
    cards(
        "u49l3",
        explain(
            "Rounding a Decimal",
            "`x.quantize(Decimal(\"0.01\"), rounding=ROUND_HALF_UP)` rounds to 2 places the way you learned in school " +
                "– a five always goes up. The pattern `Decimal(\"0.01\")` says how many places to keep.",
            code = "from decimal import Decimal, ROUND_HALF_UP\nx = Decimal(\"2.675\")\npattern = Decimal(\"0.01\")\nprint(x.quantize(pattern, rounding=ROUND_HALF_UP))",
            output = "2.68",
        ),
        explain(
            "Decimal in calculations",
            "`Decimal` remembers the number of decimal places, so `Decimal(\"2.50\") * 2` gives 5.00. " +
                "You can combine it with an int, but adding a float raises a `TypeError`.",
            code = "from decimal import Decimal\nprint(Decimal(\"2.50\") * 2)\nprint(Decimal(\"1.5\") + Decimal(\"1.5\"))",
            output = "5.00\n3.0",
        ),
        explain(
            "Numerator and denominator",
            "`numerator` is the top number and `denominator` the bottom number of a `Fraction`. You can also create " +
                "a fraction from a string, e.g. `Fraction(\"0.75\")`, and compare it with an ordinary number.",
            code = "from fractions import Fraction\nf = Fraction(\"0.75\")\nprint(f, f.numerator, f.denominator)\nprint(Fraction(1, 2) == 0.5)",
            output = "3/4 3 4\nTrue",
        ),
    ),
    cards(
        "u49l4",
        explain(
            "Prefixed numbers in code",
            "You can type a number in code directly in another system: `0b` for binary, `0o` for octal, `0x` " +
                "for hexadecimal. Python prints it in decimal anyway. In hexadecimal A is 10 and F is 15.",
            code = "print(0b111, 0o17, 0x1F)",
            output = "7 15 31",
        ),
        explain(
            "The b, o, x formats",
            "In an f-string `:b`, `:o` and `:x` convert a number to its binary, octal and hexadecimal form – " +
                "without the prefix. `:08b` pads with zeros to 8 digits. And `int(\"12\", 2)` raises a `ValueError`, " +
                "because binary has no digit 2.",
            code = "print(f\"{10:b}\", f\"{10:o}\", f\"{255:x}\")\nprint(f\"{3:08b}\")",
            output = "1010 12 ff\n00000011",
        ),
    ),
)
