package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

internal val module39Cards = listOf(
    cards(
        "u39l1",
        explain(
            "islice is like a slice",
            "`islice(x, start, stop, step)` works like the slice `[start:stop:step]` – the stop is not " +
                "included. With a single number it takes the first n elements. It returns an " +
                "iterator, so we look at the result with `list()`.",
            code = "from itertools import islice\nprint(list(islice(\"python\", 2, 5)))\nprint(list(islice(range(10), 0, 10, 3)))",
            output = "['t', 'h', 'o']\n[0, 3, 6, 9]",
        ),
        explain(
            "count is an iterator",
            "`count` is an iterator: each `next()` gives the next number. The step can be negative – " +
                "then it counts down. In a `zip` with a list, it stops together with the shorter list.",
            code = "from itertools import count\nc = count(10, -3)\nprint(next(c), next(c))\nfor num, s in zip(count(1), [\"a\", \"b\"]):\n    print(num, s)",
            output = "10 7\n1 a\n2 b",
        ),
    ),
    cards(
        "u39l2",
        explain(
            "product with repeat",
            "`product(x, repeat=2)` creates all the pairs from the same set – like `product(x, x)`. " +
                "The number of results is the product of the lengths, e.g. 2 × 2 = 4.",
            code = "from itertools import product\nfor p in product(\"01\", repeat=2):\n    print(\"\".join(p))",
            output = "00\n01\n10\n11",
        ),
        explain(
            "chain.from_iterable",
            "`chain(a, b)` takes several separate sequences. When you have them collected in one " +
                "list, use `chain.from_iterable(lists)` – it flattens a list of lists.",
            code = "from itertools import chain\ndata = [[1, 2], [3], [4]]\nprint(list(chain(data)))\nprint(list(chain.from_iterable(data)))",
            output = "[[1, 2], [3], [4]]\n[1, 2, 3, 4]",
        ),
    ),
    cards(
        "u39l3",
        explain(
            "Permutations of length r",
            "`permutations(x, r)` gives ordered arrangements of r elements. Without r it takes all " +
                "the elements. From 3 letters there are 3 × 2 = 6 pairs.",
            code = "from itertools import permutations\nprint([\"\".join(p) for p in permutations(\"abc\", 2)])",
            output = "['ab', 'ac', 'ba', 'bc', 'ca', 'cb']",
        ),
        explain(
            "Order and repeats",
            "Combinations keep the order of the input, so there is (1, 2) but not (2, 1). The " +
                "functions look at positions, not values: in \"aab\" the two letters a are different " +
                "elements, so the permutations repeat.",
            code = "from itertools import combinations, permutations\nprint((2, 1) in combinations([1, 2, 3], 2))\np = list(permutations(\"aab\"))\nprint(len(p), len(set(p)))",
            output = "False\n6 3",
        ),
    ),
    cards(
        "u39l4",
        explain(
            "groupby with a key",
            "The `key` parameter is the function we group by, e.g. `len` or `lambda s: s[0]`. " +
                "The group's key is the result of that function, and we sort the data by the same key.",
            code = "from itertools import groupby\nwords = sorted([\"ab\", \"c\", \"de\"], key=len)\nfor k, g in groupby(words, key=len):\n    print(k, list(g))",
            output = "1 ['c']\n2 ['ab', 'de']",
        ),
        explain(
            "accumulate with a lambda",
            "You can pass `accumulate` a lambda with two arguments: the result so far and the next " +
                "element. On strings, the default \"addition\" joins them up step by step.",
            code = "from itertools import accumulate\nprint(list(accumulate([1, 2, 3, 4], lambda a, b: a * b)))\nprint(list(accumulate(\"abc\")))",
            output = "[1, 2, 6, 24]\n['a', 'ab', 'abc']",
        ),
    ),
)
