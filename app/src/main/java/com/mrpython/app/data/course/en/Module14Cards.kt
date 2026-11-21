package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

internal val module14Cards = listOf(
    cards(
        "u14l1",
        explain(
            "Changing a matrix",
            "Two indexes let you change a single element: `m[0][1] = 9`. `len(m)` is the number of rows, " +
                "and `len(m[0])` is the number of elements in a row, that is, the number of columns.",
            code = "m = [[1, 2], [3, 4], [5, 6]]\nm[0][1] = 9\nprint(m[0])\nprint(len(m), len(m[0]))",
            output = "[1, 9]\n3 2",
        ),
        explain(
            "Columns and negative indexes",
            "To get a column, take the same index from every row, e.g. with a list comprehension. " +
                "Negative indexes work too: `m[-1][-1]` is the last element of the last row.",
            code = "m = [[1, 2], [3, 4]]\nprint([row[0] for row in m])\nprint(m[-1][-1])",
            output = "[1, 3]\n4",
        ),
    ),
    cards(
        "u14l2",
        explain(
            "Picking records",
            "Loops and list comprehensions work on a list of dictionaries: from each record you take " +
                "the value you need, and `if` keeps only the matching records.",
            code = "people = [{\"n\": \"Amy\", \"a\": 9}, {\"n\": \"John\", \"a\": 30}]\nprint([p[\"n\"] for p in people if p[\"a\"] > 18])",
            output = "['John']",
        ),
        explain(
            "Changing records in a loop",
            "The loop variable points to the same dictionary that sits in the list, so `p[\"pts\"] += 1` changes " +
                "the record in the list. Remember: first the list index, then the key – `people[\"name\"]` is an error.",
            code = "people = [{\"pts\": 1}, {\"pts\": 5}]\nfor p in people:\n    p[\"pts\"] += 1\nprint(people)",
            output = "[{'pts': 2}, {'pts': 6}]",
        ),
    ),
    cards(
        "u14l3",
        explain(
            "Grouping in a dictionary of lists",
            "A common pattern: if the key isn't there yet, we create an empty list for it, and then " +
                "we append the element to it. This is how we split data into groups.",
            code = "g = {}\nfor n in [1, 2, 3]:\n    if n % 2 not in g:\n        g[n % 2] = []\n    g[n % 2].append(n)\nprint(g)",
            output = "{1: [1, 3], 0: [2]}",
        ),
    ),
    cards(
        "u14l4",
        explain(
            "Other shallow copies",
            "You can also make a shallow copy of a list with the slice `a[:]` or the function `list(a)`. Dictionaries " +
                "have a `copy()` method too. All of these copy only the outer level.",
            code = "a = [1, 2]\nb = a[:]\nc = list(a)\nb.append(3)\nprint(a, b, c)",
            output = "[1, 2] [1, 2, 3] [1, 2]",
        ),
        explain(
            "Trap: a list times 2",
            "`[[0] * 2] * 2` doesn't create two rows – it points to the same list twice, so changing " +
                "one row changes both. Create independent rows with a list comprehension.",
            code = "m = [[0] * 2] * 2\nm[0][0] = 1\nprint(m)\nok = [[0] * 2 for _ in range(2)]\nok[0][0] = 1\nprint(ok)",
            output = "[[1, 0], [1, 0]]\n[[1, 0], [0, 0]]",
        ),
        explain(
            "The copy module",
            "The `deepcopy` function lives in the `copy` module, so first we write `import copy`, and then " +
                "`copy.deepcopy(...)`. A deep copy also works for dictionaries with lists inside.",
            code = "import copy\na = {\"x\": [1]}\nb = copy.deepcopy(a)\nb[\"x\"].append(2)\nprint(a)",
            output = "{'x': [1]}",
        ),
    ),
)
