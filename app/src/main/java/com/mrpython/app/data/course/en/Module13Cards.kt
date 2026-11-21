package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

internal val module13Cards = listOf(
    cards(
        "u13l1",
        explain(
            "Absolute value: abs()",
            "`abs(x)` returns the number without the minus sign – its distance from zero. " +
                "A positive number stays unchanged.",
            code = "print(abs(-3), abs(2))",
            output = "3 2",
        ),
        explain(
            "Strings and functions",
            "A list comprehension works on any collection – including a string, character by character. " +
                "As the expression you can use a method, a built-in function or your own function.",
            code = "print([c.upper() for c in \"ok\"])\nprint([len(s) for s in [\"ab\", \"c\"]])",
            output = "['O', 'K']\n[2, 1]",
        ),
    ),
    cards(
        "u13l2",
        explain(
            "Filter and transform at once",
            "You can filter and transform at the same time: first the `if` at the end picks the elements, " +
                "and then each picked element is transformed.",
            code = "print([x * 10 for x in range(6) if x % 2 == 1])",
            output = "[10, 30, 50]",
        ),
        explain(
            "Where does the if go?",
            "An `if` at the end drops elements. `a if condition else b` before `for` removes nothing – " +
                "it picks a value for each element. When there is an `else`, the whole thing must go before `for`.",
            code = "nums = [3, -1]\nprint([x for x in nums if x > 0])\nprint([x if x > 0 else 0 for x in nums])",
            output = "[3]\n[3, 0]",
        ),
    ),
    cards(
        "u13l3",
        explain(
            "Two loops: all the pairs",
            "Two `for`s in one comprehension create all the pairs: for each element of the first loop " +
                "we go through the whole second one. That is why the second variable changes faster.",
            code = "print([a + b for a in \"xy\" for b in \"12\"])",
            output = "['x1', 'x2', 'y1', 'y2']",
        ),
        explain(
            "The _ variable",
            "When you don't need the value of the loop variable, name it `_`. It is an ordinary name " +
                "that says: “just repeat this that many times”.",
            code = "print([\"hi\" for _ in range(3)])",
            output = "['hi', 'hi', 'hi']",
        ),
    ),
    cards(
        "u13l4",
        explain(
            "A dictionary from a dictionary",
            "`items()` gives you the key and the value, so it is easy to build a new dictionary: change the values, " +
                "swap keys with values or add an `if` filter.",
            code = "d = {\"a\": 1, \"b\": 5}\nprint({k: v * 2 for k, v in d.items() if v > 2})\nprint({v: k for k, v in d.items()})",
            output = "{'b': 10}\n{1: 'a', 5: 'b'}",
        ),
        explain(
            "Repeated keys",
            "Keys in a dictionary never repeat. When the comprehension produces the same key a second time, " +
                "the new value overwrites the old one.",
            code = "print({s[0]: s for s in [\"amy\", \"anna\"]})",
            output = "{'a': 'anna'}",
        ),
    ),
)
