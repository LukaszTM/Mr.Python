package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

internal val module27Intro = lesson(
    "u27l0", "Introduction: complexity",
    explain(
        "Counting steps",
        "We judge how fast a program is by counting how many steps it takes. A loop over `range(n)` is n steps, " +
            "and two nested loops multiply: n · m steps.",
        code = "steps = 0\nfor i in range(3):\n    for j in range(4):\n        steps += 1\nprint(steps)",
        output = "12",
    ),
    explain(
        "Big O notation",
        "Big O notation says how the number of steps grows as the data grows. `O(1)` – constant (e.g. `a[5]`), " +
            "`O(n)` – one loop, `O(n²)` – a loop in a loop. Doubling n in `O(n²)` means four times as much work.",
        code = "for n in [2, 4, 8]:\n    print(n * n)",
        output = "4\n16\n64",
    ),
    explain(
        "Halving: O(log n)",
        "When we cut the problem in half at every step, there are very few steps – that's `O(log n)`. " +
            "This is how binary search works: 1000 elements take only about 10 steps.",
        code = "n = 32\nsteps = 0\nwhile n > 1:\n    n //= 2\n    steps += 1\nprint(steps)",
        output = "5",
    ),
    explain(
        "List or set?",
        "`x in a_list` goes through the elements one by one – that's `O(n)`. `x in a_set` uses hashing, " +
            "so it runs in `O(1)` on average. If you check membership often, convert the list to a `set()` once.",
        code = "banned = set([\"spam\", \"ad\"])\nprint(\"spam\" in banned)",
        output = "True",
    ),
    explain(
        "A smarter way",
        "Sometimes a formula is enough instead of a loop. `n * (n + 1) // 2` gives the sum of the numbers " +
            "from 1 to n in one step, while `sum(range(n + 1))` needs n steps.",
        code = "n = 100\nprint(n * (n + 1) // 2)\nprint(sum(range(n + 1)))",
        output = "5050\n5050",
    ),
    choice(
        "What is the complexity of a loop in a loop, both over n elements?",
        listOf("O(n²)", "O(n)", "O(1)", "O(log n)"),
        0,
        "For each of the n iterations we do n more – n · n in total.",
    ),
    output(
        "steps = 0\nfor i in range(5):\n    steps += 1\nfor j in range(5):\n    steps += 1\nprint(steps)",
        "10",
        "Loops one after the other add up: 5 + 5.",
    ),
    choice(
        "Where is checking x in ... fastest on average?",
        listOf("In a set", "In a list", "In a string", "In a tuple"),
        0,
        "A set uses hashing, so in runs in O(1).",
    ),
)
