package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

internal val module3Cards = listOf(
    cards(
        "u3l1",
        explain(
            "Order of operations",
            "First comes the power `**`, then `*`, `/`, `//`, and `%`, and finally `+` and `-`. Parentheses change " +
                "this order – whatever is in parentheses is calculated first.",
            code = "print(2 * 3 ** 2)\nprint((2 + 3) * 4)",
            output = "18\n20",
        ),
        explain(
            "How to find a remainder",
            "To work out `17 % 5`, check how many times 5 fits into 17: 3 times, which is 15. The remainder is " +
                "17 - 15 = 2. When the number is smaller than the divisor, the remainder is the whole number: `3 % 10` is 3.",
            code = "print(17 // 5)\nprint(17 % 5)\nprint(3 % 10)",
            output = "3\n2\n3",
        ),
        explain(
            "// rounds down",
            "`//` always rounds the result down, to the smaller number. For negative numbers that means " +
                "moving away from zero: -7 / 2 is -3.5, so `-7 // 2` gives -4.",
            code = "print(7 // 2)\nprint(-7 // 2)",
            output = "3\n-4",
        ),
    ),
    cards(
        "u3l2",
        explain(
            "Comparing strings",
            "`==` and `!=` work on strings too. Strings are equal only when they have exactly the same " +
                "characters – an uppercase and a lowercase letter are different characters.",
            code = "print(\"cat\" == \"cat\")\nprint(\"A\" == \"a\")",
            output = "True\nFalse",
        ),
        explain(
            "Chained comparisons",
            "Comparisons can be chained: `1 < x < 5` means \"x is greater than 1 and less than 5\". " +
                "It's a shorter way to write `1 < x and x < 5`.",
            code = "x = 4\nprint(1 < x < 5)\nprint(0 <= x <= 3)",
            output = "True\nFalse",
        ),
        explain(
            "not before a comparison",
            "Python works out the comparison first, and only then `not` flips it: `not 3 > 1` is `not True`, " +
                "which is `False`. `not (...)` with parentheses flips the result of the whole expression inside.",
            code = "print(not 3 > 1)\nprint(not (2 > 5 and 1 > 0))",
            output = "False\nTrue",
        ),
    ),
    cards(
        "u3l3",
        explain(
            "Where does a block end?",
            "All the indented lines under an `if` belong to its block. The first line without indentation is already " +
                "outside the block – it always runs, no matter what the condition is.",
            code = "x = 1\nif x > 5:\n    print(\"big\")\n    print(\"very\")\nprint(\"end\")",
            output = "end",
        ),
        explain(
            "A value as a condition",
            "You can put just a value in an `if`. `0` and the empty string `\"\"` work like `False`, while other numbers " +
                "and non-empty strings work like `True`. So `if not s:` checks whether a string is empty.",
            code = "s = \"\"\nif not s:\n    print(\"empty\")\nif 5:\n    print(\"yes\")",
            output = "empty\nyes",
        ),
        explain(
            "Even or odd?",
            "A number is even when it divides by 2 with no remainder: `n % 2 == 0`. Python first calculates " +
                "`n % 2`, and then compares the result with 0. A remainder of 1 means an odd number.",
            code = "n = 7\nprint(n % 2)\nprint(n % 2 == 0)",
            output = "1\nFalse",
        ),
    ),
    cards(
        "u3l4",
        explain(
            "String length: len()",
            "The `len()` function returns the number of characters in a string – spaces count too. The result is " +
                "a regular number, so you can compare it.",
            code = "print(len(\"cat\"))\nprint(len(\"a b\") > 2)",
            output = "3\nTrue",
        ),
        explain(
            "An if inside an if",
            "An `if` block can contain another `if` – then we indent it even more (8 spaces). The inner " +
                "condition is checked only when the outer one is true.",
            code = "x = 4\nif x > 0:\n    if x > 10:\n        print(\"big\")\n    else:\n        print(\"small\")",
            output = "small",
        ),
    ),
    cards(
        "u3l5",
        explain(
            "Two ifs or elif?",
            "With `if` / `elif`, at most one block runs. Two separate `if`s are independent – Python " +
                "checks each of them, so it can run both.",
            code = "x = 8\nif x > 5:\n    print(\"A\")\nif x > 2:\n    print(\"B\")",
            output = "A\nB",
        ),
    ),
)
