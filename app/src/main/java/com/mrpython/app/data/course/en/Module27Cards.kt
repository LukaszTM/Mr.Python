package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

internal val module27Cards = listOf(
    cards(
        "u27l1",
        explain(
            "A loop that depends on i",
            "When the inner loop goes over `range(i)`, it has a different length each time: 0, 1, 2, 3… " +
                "Then you have to add up the steps: for `range(4)` that's 0 + 1 + 2 + 3 = 6.",
            code = "steps = 0\nfor i in range(4):\n    for j in range(i):\n        steps += 1\nprint(steps)",
            output = "6",
        ),
    ),
    cards(
        "u27l2",
        explain(
            "We drop the constants",
            "Big O notation only looks at how the result grows with n. Two loops in a row (2n steps) are still " +
                "`O(n)`, and a loop in a loop with a constant 10 iterations inside (10n) is `O(n)` too.",
            code = "n = 5\nsteps = 0\nfor i in range(n):\n    for j in range(10):\n        steps += 1\nprint(steps)",
            output = "50",
        ),
        explain(
            "From the fastest",
            "The order from the fastest: `O(1)` < `O(log n)` < `O(n)` < `O(n²)`. Reading `a[i]` and `len(a)` " +
                "is `O(1)` – a list knows its length and jumps straight to an index.",
            code = "a = list(range(1000))\nprint(a[-1], len(a))",
            output = "999 1000",
        ),
    ),
    cards(
        "u27l3",
        explain(
            "An empty set: set()",
            "You create an empty set with `set()`, because `{}` is an empty dictionary. You add elements with the " +
                "`add()` method (a set has no `append()`). A set of \"seen\" items like this quickly detects repeats.",
            code = "seen = set()\nfor x in [4, 2, 4]:\n    if x in seen:\n        print(\"repeat:\", x)\n    seen.add(x)",
            output = "repeat: 4",
        ),
        explain(
            "Are there duplicates?",
            "A set removes repeats, so if `set(items)` is shorter than the list, something was repeated. " +
                "Remember: a set has no order and no indexes.",
            code = "numbers = [3, 1, 4, 1]\nprint(len(numbers) != len(set(numbers)))",
            output = "True",
        ),
    ),
    cards(
        "u27l4",
        explain(
            "End or beginning of the list?",
            "`append()` adds to the end in `O(1)`. `insert(0, x)` inserts at the beginning, so it has to shift " +
                "all the other elements – that's `O(n)`. The same goes for `pop(0)`.",
            code = "a = [2, 3]\na.append(4)\na.insert(0, 1)\nprint(a)",
            output = "[1, 2, 3, 4]",
        ),
    ),
)
