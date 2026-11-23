package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*
import com.mrpython.app.domain.CourseUnit

internal val module39 = CourseUnit(
    id = "u39",
    title = "The itertools module",
    description = "count, chain, product, permutations, groupby and accumulate",
    lessons = listOf(
        lesson(
            "u39l1", "count and islice",
            output(
                "from itertools import count, islice\nprint(list(islice(count(1), 4)))",
                "[1, 2, 3, 4]",
                "count(1) counts forever, and islice takes only the first 4 values.",
            ),
            output(
                "from itertools import count, islice\nprint(list(islice(count(0, 5), 3)))",
                "[0, 5, 10]",
                "The second argument of count is the step.",
            ),
            choice(
                "What happens when you call list(count())?",
                listOf("The list grows forever", "An empty list is created", "The list [0] is created", "ValueError"),
                0,
                "count() is infinite, so list() keeps collecting numbers until memory runs out – you never get a result.",
            ),
            output(
                "from itertools import islice\nprint(list(islice(\"python\", 2, 5)))",
                "['t', 'h', 'o']",
                "islice works like the slice [2:5], but on anything you can iterate over, iterators included.",
            ),
            fill(
                "Fill in the blank to take the first 3 elements from an infinite counter.",
                "from itertools import count, islice\nprint(list(____(count(10), 3)))",
                listOf("islice", "slice", "range", "count"),
                "islice",
                "islice cuts a piece out of an iterator.",
            ),
            output(
                "from itertools import count\nfor i in count(3):\n    if i > 5:\n        break\n    print(i)",
                "3\n4\n5",
                "A loop over count has to be stopped with break.",
            ),
            tiles(
                "Take the first 5 numbers from count()",
                listOf("list(", "islice(", "count(),", "5", "))"),
                listOf("count[", "slice("),
                "islice(iterator, n) takes the first n elements.",
            ),
        ),
        lesson(
            "u39l2", "chain and product",
            output(
                "from itertools import chain\nprint(list(chain([1, 2], [3], [4, 5])))",
                "[1, 2, 3, 4, 5]",
                "chain joins the lists one after another into a single sequence.",
            ),
            output(
                "from itertools import chain\nprint(\"\".join(chain(\"ab\", \"cd\")))",
                "abcd",
                "chain works on strings too.",
            ),
            output(
                "from itertools import product\nfor a, b in product([1, 2], \"xy\"):\n    print(a, b)",
                "1 x\n1 y\n2 x\n2 y",
                "product creates all the pairs – like nested loops.",
            ),
            output(
                "from itertools import product\nprint(len(list(product(\"abc\", repeat=2))))",
                "9",
                "repeat=2 means pairs from the same set: 3 × 3 = 9.",
            ),
            choice(
                "Which code does product(A, B) correspond to?",
                listOf("Two nested for loops", "One loop over A + B", "zip(A, B)", "A * B"),
                0,
                "product is the Cartesian product – every element of A with every element of B.",
            ),
            fill(
                "Fill in the blank to join two lists into one sequence.",
                "from itertools import chain\nprint(list(____([1], [2])))",
                listOf("chain", "product", "zip", "count"),
                "chain",
                "chain joins the lists one after another.",
            ),
            output(
                "from itertools import chain\nlists = [[1, 2], [3], [4]]\nprint(list(chain.from_iterable(lists)))",
                "[1, 2, 3, 4]",
                "chain.from_iterable flattens a list of lists.",
            ),
            tiles(
                "Print all the pairs from \"ab\" and \"cd\"",
                listOf("print(", "list(", "product(", "\"ab\",", "\"cd\"", ")))"),
                listOf("zip(", "chain("),
                "product returns an iterator of pairs, which we convert to a list.",
            ),
        ),
        lesson(
            "u39l3", "permutations and combinations",
            output(
                "from itertools import permutations\nprint(list(permutations([1, 2])))",
                "[(1, 2), (2, 1)]",
                "Permutations are all the orderings of the elements.",
            ),
            output(
                "from itertools import permutations\nprint(len(list(permutations(\"abc\"))))",
                "6",
                "3 elements can be arranged in 3! = 6 ways.",
            ),
            output(
                "from itertools import combinations\nprint(list(combinations([1, 2, 3], 2)))",
                "[(1, 2), (1, 3), (2, 3)]",
                "Combinations ignore order, so (2, 1) doesn't show up.",
            ),
            output(
                "from itertools import combinations\nprint(len(list(combinations(range(5), 2))))",
                "10",
                "There are 10 unordered pairs from 5 elements.",
            ),
            choice(
                "What is the difference between permutations(x, 2) and combinations(x, 2)?",
                listOf("In permutations order matters", "Nothing", "combinations gives more results", "permutations doesn't accept 2"),
                0,
                "Permutations take order into account, so (a, b) and (b, a) are two different results; combinations give only one of them.",
            ),
            output(
                "from itertools import permutations\nprint(len(list(permutations(\"abcd\", 2))))",
                "12",
                "There are 4 × 3 = 12 ordered pairs from 4 elements.",
            ),
            fill(
                "Fill in the blank to get pairs with no repeats, ignoring order.",
                "from itertools import combinations\nfor p in ____(\"xyz\", 2):\n    print(p)",
                listOf("combinations", "permutations", "product", "chain"),
                "combinations",
                "Combinations ignore order, so (\"y\", \"x\") won't show up.",
            ),
            tiles(
                "Count the permutations of the string \"cat\"",
                listOf("len(", "list(", "permutations(", "\"cat\"", ")))"),
                listOf("combinations(", "count("),
                "permutations returns an iterator, so we convert it to a list first.",
            ),
        ),
        lesson(
            "u39l4", "groupby and accumulate",
            output(
                "from itertools import groupby\nfor k, g in groupby(\"aaabbc\"):\n    print(k, len(list(g)))",
                "a 3\nb 2\nc 1",
                "groupby groups consecutive equal elements.",
            ),
            output(
                "from itertools import groupby\nfor k, g in groupby(\"abab\"):\n    print(k, end=\"\")",
                "abab",
                "groupby only joins neighboring elements – that's why the data is usually sorted first.",
            ),
            output(
                "from itertools import groupby\nwords = sorted([\"eve\", \"amy\", \"ella\", \"adam\"])\nfor k, g in groupby(words, key=lambda s: s[0]):\n    print(k, list(g))",
                "a ['adam', 'amy']\ne ['ella', 'eve']",
                "After sorting, words with the same first letter sit next to each other.",
            ),
            choice(
                "Why do we usually sort the data before groupby?",
                listOf("groupby only joins neighboring elements", "groupby doesn't work on lists", "Without sorting it raises an error", "Sorting speeds up the program"),
                0,
                "Equal values have to sit next to each other to land in one group.",
            ),
            output(
                "from itertools import accumulate\nprint(list(accumulate([1, 2, 3, 4])))",
                "[1, 3, 6, 10]",
                "accumulate returns the running totals.",
            ),
            output(
                "from itertools import accumulate\nprint(list(accumulate([3, 1, 5, 2], max)))",
                "[3, 3, 5, 5]",
                "With the max function we get the running maximum.",
            ),
            fill(
                "Fill in the blank to get the running products [1, 2, 6, 24].",
                "from itertools import accumulate\nprint(list(accumulate([1, 2, 3, 4], ____)))",
                listOf("lambda a, b: a * b", "lambda a, b: a + b", "max", "min"),
                "lambda a, b: a * b",
                "A function that multiplies gives the running products.",
            ),
            tiles(
                "Print the running totals of the list data",
                listOf("print(", "list(", "accumulate(", "data", ")))"),
                listOf("sum(", "groupby("),
                "By default, accumulate adds up the elements one by one.",
            ),
        ),
        lesson(
            "u39l5", "Review: itertools",
            choice(
                "Which function gives all the orderings of a list?",
                listOf("permutations", "combinations", "chain", "groupby"),
                0,
                "Orderings are permutations.",
            ),
            output(
                "from itertools import chain\nprint(list(chain(\"ab\", [1])))",
                "['a', 'b', 1]",
                "chain joins sequences of different types, here a string and a list.",
            ),
            output(
                "from itertools import count, islice\nprint(list(islice(count(2, 2), 3)))",
                "[2, 4, 6]",
                "Start 2, step 2, three elements.",
            ),
            output(
                "from itertools import combinations\nprint(len(list(combinations(\"abcd\", 3))))",
                "4",
                "There are 4 unordered triples from 4 elements.",
            ),
            output(
                "from itertools import groupby\nfor k, g in groupby(sorted([2, 1, 2, 1, 1])):\n    print(k, len(list(g)))",
                "1 3\n2 2",
                "After sorting, the ones and the twos each form a single group.",
            ),
            fill(
                "Fill in the blank to get the running totals [5, 7, 8].",
                "from itertools import accumulate\nprint(list(____([5, 2, 1])))",
                listOf("accumulate", "chain", "count", "product"),
                "accumulate",
                "accumulate computes running totals.",
            ),
            choice(
                "How many elements does product(\"ab\", \"xyz\") give?",
                listOf("6", "5", "3", "2"),
                0,
                "Each of the 2 letters with each of the 3 letters: 2 × 3 = 6.",
            ),
            tiles(
                "Import the functions chain and product",
                listOf("from", "itertools", "import", "chain,", "product"),
                listOf("collections", "Itertools"),
                "We import several names by separating them with commas.",
            ),
        ),
    ),
)
