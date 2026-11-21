package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

internal val module16Intro = lesson(
    "u16l0", "Introduction: lambda",
    explain(
        "The lambda expression",
        "`lambda` creates a small function in one line, without `def` and without a name. After the colon comes " +
            "a single expression – its result is returned automatically, without `return`.",
        code = "double = lambda x: x * 2\nprint(double(4))",
        output = "8",
    ),
    explain(
        "The key parameter",
        "`sorted()`, `min()` and `max()` accept `key` – a function whose result is used for comparing. " +
            "For example, `key=len` compares lengths, and a lambda can pick any part of an element.",
        code = "words = [\"kiwi\", \"banana\", \"fig\"]\nprint(sorted(words, key=len))\nprint(max(words, key=len))",
        output = "['fig', 'kiwi', 'banana']\nbanana",
    ),
    explain(
        "map – change each one",
        "`map(f, lst)` calls the function `f` for every element. It returns a map object, so " +
            "we usually turn it into a list with `list()`.",
        code = "print(list(map(str, [1, 2])))\nprint(list(map(lambda x: x * 10, [1, 2])))",
        output = "['1', '2']\n[10, 20]",
    ),
    explain(
        "filter – keep the matching ones",
        "`filter(f, lst)` keeps only the elements for which the function returns `True`. " +
            "It's like a list comprehension with an `if` condition.",
        code = "print(list(filter(lambda x: x > 2, [1, 5, 2, 7])))",
        output = "[5, 7]",
    ),
    explain(
        "A function as a value",
        "A function can be stored in a variable or passed to another function – without parentheses, because `f` " +
            "is the function itself, while `f()` is a call and its result.",
        code = "def apply(f, x):\n    return f(x)\n\nprint(apply(abs, -7))",
        output = "7",
    ),
    output(
        "add = lambda a, b: a + b\nprint(add(2, 3))",
        "5",
        "The lambda returns the sum of its two arguments.",
    ),
    choice(
        "What is the key parameter of sorted() for?",
        listOf(
            "It gives a function whose result is used for comparing",
            "It sets how many elements to sort",
            "It reverses the order",
            "It removes duplicates",
        ),
        0,
        "sorted compares the results of the key function, not the elements themselves.",
    ),
    fill(
        "Fill in the blank to keep only the non-empty strings.",
        "s = [\"a\", \"\", \"b\"]\nprint(list(____(lambda x: x != \"\", s)))",
        listOf("filter", "map", "sorted"),
        "filter",
        "filter keeps the elements for which the lambda returns True.",
    ),
)
