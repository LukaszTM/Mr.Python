package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

internal val module39Intro = lesson(
    "u39l0", "Introduction: the itertools module",
    explain(
        "count and islice",
        "The `itertools` module contains ready-made tools for working with iterators. " +
            "`count(start, step)` counts forever, so we take a piece of it with " +
            "`islice(iterator, n)` or stop the loop with `break`.",
        code = "from itertools import count, islice\nprint(list(islice(count(5), 3)))\nprint(list(islice(count(0, 2), 3)))",
        output = "[5, 6, 7]\n[0, 2, 4]",
    ),
    explain(
        "chain and product",
        "`chain` joins several sequences (lists, strings, iterators) into one, one after another. `product` " +
            "creates all the pairs – it works like two nested `for` loops.",
        code = "from itertools import chain, product\nprint(list(chain([1, 2], [3])))\nprint(list(product(\"ab\", [1, 2])))",
        output = "[1, 2, 3]\n[('a', 1), ('a', 2), ('b', 1), ('b', 2)]",
    ),
    explain(
        "permutations and combinations",
        "`permutations` gives all the orderings – order matters, so (1, 2) and (2, 1) are " +
            "different results. `combinations(x, k)` picks k elements without paying attention " +
            "to order.",
        code = "from itertools import permutations, combinations\nprint(list(permutations([1, 2])))\nprint(list(combinations([1, 2, 3], 2)))",
        output = "[(1, 2), (2, 1)]\n[(1, 2), (1, 3), (2, 3)]",
    ),
    explain(
        "groupby",
        "`groupby` puts consecutive equal elements into groups and returns (key, group) pairs. " +
            "It only groups neighbors, which is why we usually sort the data first.",
        code = "from itertools import groupby\nfor k, g in groupby(\"aabccc\"):\n    print(k, len(list(g)))",
        output = "a 2\nb 1\nc 3",
    ),
    explain(
        "accumulate",
        "`accumulate` returns partial results – by default, running totals. You can pass your " +
            "own two-argument function, e.g. `max`, to get the running maximum.",
        code = "from itertools import accumulate\nprint(list(accumulate([1, 2, 3])))\nprint(list(accumulate([2, 5, 1], max)))",
        output = "[1, 3, 6]\n[2, 5, 5]",
    ),
    choice(
        "Which function gives all the pairs without paying attention to order?",
        listOf("combinations", "permutations", "chain", "count"),
        0,
        "Combinations ignore the order of the elements.",
    ),
    output(
        "from itertools import chain\nprint(list(chain(\"ab\", \"c\")))",
        "['a', 'b', 'c']",
        "chain joins sequences one after another – here two strings.",
    ),
    fill(
        "Fill in the blank to get the running totals [1, 3, 6].",
        "from itertools import accumulate\nprint(list(____([1, 2, 3])))",
        listOf("accumulate", "groupby", "count", "islice"),
        "accumulate",
        "accumulate computes running totals.",
    ),
)
