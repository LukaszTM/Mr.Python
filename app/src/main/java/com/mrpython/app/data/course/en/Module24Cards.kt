package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

internal val module24Cards = listOf(
    cards(
        "u24l1",
        explain(
            "min and max on strings",
            "Strings are compared alphabetically, letter by letter. `min(\"banana\")` gives the smallest letter, " +
                "and `max()` of a list of words – the last one in the alphabet. On a tie, the item that came first wins.",
            code = "print(min(\"banana\"))\nprint(max([\"ant\", \"cat\", \"owl\"]))\nprint(min([\"dog\", \"cat\"], key=len))",
            output = "a\nowl\ndog",
        ),
    ),
    cards(
        "u24l2",
        explain(
            "The start value in sum()",
            "The second argument of `sum()` is the starting value: `sum(items, 10)` is 10 plus the sum of the items. " +
                "For an empty list the result is just the starting value.",
            code = "print(sum([1, 2, 3], 10))\nprint(sum([], 7))",
            output = "16\n7",
        ),
        explain(
            "round and the exact half",
            "`round(x)` without a second argument gives an integer. At an exact half (2.5, 3.5) " +
                "it picks the even number – that's why `round(2.5)` is 2, and `round(3.5)` is 4.",
            code = "print(round(9.99))\nprint(round(2.5), round(3.5))",
            output = "10\n2 4",
        ),
        explain(
            "Powers: pow",
            "`pow(a, b)` is the same as `a ** b`. With a third argument, `pow(a, b, m)` right away computes " +
                "the remainder of dividing the power by m, that is `a ** b % m`.",
            code = "print(pow(2, 5))\nprint(pow(2, 5, 7))",
            output = "32\n4",
        ),
    ),
    cards(
        "u24l3",
        explain(
            "type() or isinstance()?",
            "`type(x) == float` checks for exactly one type. `isinstance()` is handier: it accepts " +
                "a tuple of types and also recognizes \"derived\" types.",
            code = "print(type(3.0) == float)\nprint(type(7) == float)",
            output = "True\nFalse",
        ),
        explain(
            "bool is an int too",
            "In Python `True` and `False` are a special kind of integers (1 and 0). That's why " +
                "`isinstance(True, int)` gives `True`. It doesn't work the other way: 1 is not of type `bool`.",
            code = "print(isinstance(True, int))\nprint(isinstance(1, bool))",
            output = "True\nFalse",
        ),
    ),
    cards(
        "u24l4",
        explain(
            "What has a length?",
            "`len()` works on strings, lists, tuples, sets and dictionaries (it counts the pairs). " +
                "A number has no length – `len(5)` raises a `TypeError`.",
            code = "print(len(\"cat\"), len([1, 2]), len({\"a\": 1}))",
            output = "3 2 1",
        ),
        explain(
            "Conversion pitfalls",
            "`int()` won't accept a string with a dot: `int(\"3.5\")` is a `ValueError` – use `float()`. " +
                "`float(4)` gives 4.0, and `int(-2.7)` cuts toward zero, to -2.",
            code = "print(float(\"2.5\") * 2)\nprint(float(4), int(-2.7))",
            output = "5.0\n4.0 -2",
        ),
    ),
    cards(
        "u24l5",
        explain(
            "The bool() function",
            "`bool()` tells you whether a value is \"truthy\". These are falsy: 0, an empty string and an empty list. " +
                "Careful: the string \"0\" is not empty, so it is truthy, just like the list `[0]`.",
            code = "print(bool(0), bool(\"0\"))\nprint(bool([]), bool([0]))",
            output = "False True\nFalse True",
        ),
        explain(
            "Is it all digits?",
            "The `isdigit()` method returns `True` when a string consists of digits only. This lets you " +
                "check before `int()` whether the conversion will succeed.",
            code = "print(\"42\".isdigit())\nprint(\"4a\".isdigit())",
            output = "True\nFalse",
        ),
    ),
)
