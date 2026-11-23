package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

internal val module19Intro = lesson(
    "u19l0", "Introduction: randomness",
    explain(
        "The random module",
        "Games, quizzes and simulations need randomness. The `random` module provides it. " +
            "The result can be different on every run – that's why the examples check whether it falls within a range.",
        code = "import random\nx = random.randint(1, 6)\nprint(1 <= x <= 6)",
        output = "True",
    ),
    explain(
        "randint and random",
        "`random.randint(a, b)` picks a random integer from `a` to `b` – both limits included, like rolling a die. " +
            "`random.random()` gives a float from 0 (inclusive) up to 1 (not including 1).",
        code = "import random\nx = random.random()\nprint(0 <= x < 1)",
        output = "True",
    ),
    explain(
        "choice – pick one",
        "`random.choice(my_list)` picks one random item from a list or a string. You can't pick anything " +
            "from an empty list – that causes an error.",
        code = "import random\ncolors = [\"red\", \"blue\"]\nc = random.choice(colors)\nprint(c in colors)",
        output = "True",
    ),
    explain(
        "shuffle and sample",
        "`random.shuffle(my_list)` shuffles the list in place and returns `None`. `random.sample(my_list, k)` " +
            "returns a new list of `k` different items – no repeats.",
        code = "import random\ncards = [1, 2, 3, 4]\nrandom.shuffle(cards)\nprint(sorted(cards))\nprint(len(random.sample(cards, 2)))",
        output = "[1, 2, 3, 4]\n2",
    ),
    explain(
        "The seed",
        "`random.seed(42)` sets the random seed. After the same seed, the numbers you get are " +
            "always the same – that's useful when testing programs.",
        code = "import random\nrandom.seed(42)\na = random.randint(1, 100)\nrandom.seed(42)\nb = random.randint(1, 100)\nprint(a == b)",
        output = "True",
    ),
    choice(
        "What does random.randint(1, 6) return?",
        listOf("An integer from 1 to 6", "An integer from 1 to 5", "A float from 1 to 6", "An integer from 0 to 6"),
        0,
        "randint includes both limits of the range.",
    ),
    output(
        "import random\nitems = [1, 2]\nprint(random.shuffle(items))",
        "None",
        "shuffle shuffles the list in place and returns None.",
    ),
    fill(
        "Fill in the blank to pick one random name from the list.",
        "import random\nnames = [\"Ann\", \"Bob\"]\nprint(random.____(names))",
        listOf("choice", "shuffle", "randint"),
        "choice",
        "choice returns one random item from the list.",
    ),
)
