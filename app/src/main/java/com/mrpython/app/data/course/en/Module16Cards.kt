package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

internal val module16Cards = listOf(
    cards(
        "u16l1",
        explain(
            "Lambda parameters",
            "A lambda can have several comma-separated parameters or none at all: `lambda: 0`. After the colon " +
                "comes a single expression – even `a if condition else b` – but never `return`.",
            code = "bigger = lambda a, b: a if a > b else b\nhi = lambda: \"hi\"\nprint(bigger(3, 8), hi())",
            output = "8 hi",
        ),
        explain(
            "Calling it right away",
            "You can call a lambda right away, without storing it in a variable: wrap it in parentheses and add " +
                "the arguments in a second pair of parentheses.",
            code = "print((lambda x: x * 3)(5))",
            output = "15",
        ),
    ),
    cards(
        "u16l2",
        explain(
            "Your own key with a lambda",
            "When the elements are pairs or dictionaries, a lambda picks what to compare, e.g. `key=lambda p: p[1]`. " +
                "`min()` and `max()` return the whole element, not just the key.",
            code = "pairs = [(\"a\", 3), (\"b\", 1)]\nprint(max(pairs, key=lambda p: p[1]))\nprint(min([-4, 2], key=abs))",
            output = "('a', 3)\n2",
        ),
        explain(
            "Reverse order",
            "`reverse=True` sorts starting from the largest key. You can also reverse numbers with a negated key: " +
                "`key=lambda x: -x`. Elements with equal keys stay in their original order.",
            code = "print(sorted([\"bb\", \"a\", \"ccc\"], key=len, reverse=True))\nprint(sorted([5, 8, 2], key=lambda x: -x))",
            output = "['ccc', 'bb', 'a']\n[8, 5, 2]",
        ),
    ),
    cards(
        "u16l3",
        explain(
            "String to numbers",
            "A popular trick: `split()` cuts a string into pieces, and `map(int, ...)` turns each one into a number. " +
                "`sum()` works on a map object directly, without `list()`.",
            code = "print(sum(map(int, \"3 4 5\".split())))",
            output = "12",
        ),
        explain(
            "map or filter?",
            "`map()` changes every element – the number of elements stays the same. `filter()` changes " +
                "nothing, it only drops the elements for which the function gives `False`.",
            code = "l = [1, 3]\nprint(list(map(lambda x: x > 2, l)))\nprint(list(filter(lambda x: x > 2, l)))",
            output = "[False, True]\n[3]",
        ),
    ),
    cards(
        "u16l4",
        explain(
            "A function returns a function",
            "A function can create and return a new function, e.g. a lambda. The returned function remembers " +
                "the values it had when it was created – here `n`.",
            code = "def adder(n):\n    return lambda x: x + n\n\nplus2 = adder(2)\nprint(plus2(5))",
            output = "7",
        ),
        explain(
            "Functions in a dictionary",
            "Functions are ordinary values, so you can keep them in a list or a dictionary. `ops[\"+\"]` " +
                "gives the function itself, and adding `(2, 3)` calls it.",
            code = "ops = {\"+\": lambda a, b: a + b, \"max\": max}\nprint(ops[\"+\"](2, 3), ops[\"max\"](2, 3))",
            output = "5 3",
        ),
    ),
    cards(
        "u16l5",
        explain(
            "A method as the key",
            "As `key` you can pass a string method, e.g. `str.lower`. Then `sorted()` compares the words " +
                "in lowercase but returns them in their original form.",
            code = "print(sorted([\"b\", \"C\", \"a\"]))\nprint(sorted([\"b\", \"C\", \"a\"], key=str.lower))",
            output = "['C', 'a', 'b']\n['a', 'b', 'C']",
        ),
        explain(
            "A lambda is like a function",
            "Lambda parameters work like in `def`: they can have default values, and `*a` collects " +
                "any number of arguments into a tuple.",
            code = "f = lambda a, b=2: a * b\ng = lambda *a: sum(a)\nprint(f(5), g(1, 2, 3))",
            output = "10 6",
        ),
    ),
)
