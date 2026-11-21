package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*
import com.mrpython.app.domain.CourseUnit

internal val module19 = CourseUnit(
    id = "u19",
    title = "Randomness",
    description = "The random module: random numbers, choosing and shuffling",
    lessons = listOf(
        lesson(
            "u19l1", "randint and random",
            choice(
                "What does random.randint(1, 6) return?",
                listOf(
                    "An integer from 1 to 6 (inclusive)",
                    "An integer from 1 to 5",
                    "A float from 1 to 6",
                    "Always 6",
                ),
                0,
                "randint includes both ends of the range – like rolling a die.",
            ),
            output(
                "import random\nx = random.randint(1, 6)\nprint(1 <= x <= 6)",
                "True",
                "The result is random, but it always falls in the range 1–6.",
            ),
            choice(
                "What does random.random() return?",
                listOf(
                    "A float from the range [0, 1)",
                    "The integer 0 or 1",
                    "A number from 1 to 100",
                    "A random string",
                ),
                0,
                "random() gives a fraction from 0 (inclusive) up to 1 (not including 1).",
            ),
            output(
                "import random\nx = random.random()\nprint(0 <= x < 1)",
                "True",
                "random() never returns 1 or a negative number.",
            ),
            fill(
                "Fill in the blank to pick a random integer from 1 to 10.",
                "import random\nprint(random.____(1, 10))",
                listOf("randint", "random", "choice"),
                "randint",
                "randint(a, b) picks a random integer from the range a–b.",
            ),
            output("import random\nx = random.randint(5, 5)\nprint(x)", "5", "The range 5–5 contains only one number."),
            output(
                "import random\nx = random.randint(1, 3)\nprint(type(x))",
                "<class 'int'>",
                "randint always returns an integer.",
            ),
            tiles(
                "Pick a random number from 1 to 100 and store it in the variable x.",
                listOf("x =", "random.randint(", "1, 100", ")"),
                listOf("random.random(", "1, 101"),
                "randint(1, 100) includes both ends.",
            ),
        ),
        lesson(
            "u19l2", "choice, shuffle and sample",
            output("import random\nprint(random.choice([\"a\"]))", "a", "From a list with one item you can only pick that item."),
            output(
                "import random\ncolors = [\"red\", \"blue\"]\nc = random.choice(colors)\nprint(c in colors)",
                "True",
                "choice always returns one of the list's items.",
            ),
            choice(
                "What does random.shuffle(my_list) do?",
                listOf(
                    "Shuffles the list's items in place and returns None",
                    "Returns a new, sorted list",
                    "Removes a random item",
                    "Returns one random item",
                ),
                0,
                "shuffle changes the order inside the list itself and returns nothing.",
            ),
            output(
                "import random\nnumbers = [1, 2, 3, 4]\nrandom.shuffle(numbers)\nprint(sorted(numbers))",
                "[1, 2, 3, 4]",
                "Shuffling changes the order, not the items – after sorting we're back where we started.",
            ),
            output(
                "import random\nx = random.sample(range(10), 3)\nprint(len(x))",
                "3",
                "sample(data, k) returns a list of k random items.",
            ),
            choice(
                "How is random.sample(my_list, 2) different from two calls to random.choice?",
                listOf(
                    "sample doesn't repeat items",
                    "sample always returns the first two items",
                    "choice returns a list",
                    "There is no difference",
                ),
                0,
                "sample picks without repeats, while two choice calls can hit the same item.",
            ),
            fill(
                "Fill in the blank to pick one random item from the list.",
                "import random\nnames = [\"Ann\", \"Bob\"]\nprint(random.____(names))",
                listOf("choice", "shuffle", "sample"),
                "choice",
                "choice picks one item from a sequence.",
            ),
            output(
                "import random\nitems = [1, 2, 3]\nresult = random.shuffle(items)\nprint(result)",
                "None",
                "shuffle shuffles the list in place and returns None.",
            ),
        ),
        lesson(
            "u19l3", "Randomness in practice",
            output(
                "import random\ndie = random.randint(1, 6)\nif die > 6:\n    print(\"error\")\nelse:\n    print(\"ok\")",
                "ok",
                "A die never gives more than 6.",
            ),
            output(
                "import random\nx = random.sample([5, 6, 7], 3)\nprint(sorted(x))",
                "[5, 6, 7]",
                "A sample the size of the whole list contains all of its items.",
            ),
            choice(
                "What happens after random.sample([1, 2], 5)?",
                listOf(
                    "ValueError – the sample is larger than the list",
                    "It returns [1, 2]",
                    "It returns 5 items with repeats",
                    "It returns None",
                ),
                0,
                "Without repeats you can't pick 5 items out of 2.",
            ),
            choice(
                "What happens after random.choice([])?",
                listOf("IndexError", "It returns None", "It returns []", "It prints 0"),
                0,
                "You can't pick anything from an empty list – that's an IndexError.",
            ),
            output(
                "import random\nrolls = [random.randint(1, 6) for _ in range(5)]\nprint(len(rolls))",
                "5",
                "The list comprehension made 5 rolls.",
            ),
            tiles(
                "Shuffle the list deck in place.",
                listOf("random.shuffle(", "deck", ")"),
                listOf("deck =", "random.sample("),
                "shuffle changes the list in place – we don't assign the result.",
            ),
            choice(
                "What is random.seed(42) for?",
                listOf(
                    "It sets the seed so the random results can be repeated",
                    "It picks the number 42",
                    "It picks 42 random numbers",
                    "It turns randomness off forever",
                ),
                0,
                "The same seed gives the same sequence of \"random\" numbers – handy in tests.",
            ),
            output(
                "import random\nm = [random.choice(\"HT\") for _ in range(4)]\nok = set(m) <= {\"H\", \"T\"}\nprint(len(m), ok)",
                "4 True",
                "Every toss is H or T, so the set of results is contained in {H, T}.",
            ),
        ),
        lesson(
            "u19l4", "Review: randomness",
            output(
                "import random\nx = random.randint(10, 20)\nprint(10 <= x <= 20)",
                "True",
                "randint stays within the given range.",
            ),
            choice(
                "Which function returns several different items from a list?",
                listOf("random.sample", "random.choice", "random.shuffle", "random.randint"),
                0,
                "sample returns a list of items without repeats.",
            ),
            fill(
                "Fill in the blank to shuffle the list cards.",
                "import random\ncards = [1, 2, 3]\nrandom.____(cards)\nprint(len(cards))",
                listOf("shuffle", "shuffled", "mix"),
                "shuffle",
                "The function that shuffles a list is shuffle.",
            ),
            output("from random import choice\nprint(choice(\"x\"))", "x", "choice works on strings too – here there's only one letter."),
            output(
                "import random as r\nx = r.sample([1, 2, 3, 4], 2)\nprint(len(set(x)))",
                "2",
                "sample doesn't repeat items, so the two are different.",
            ),
            choice(
                "How many different results can random.randint(0, 3) give?",
                listOf("4", "3", "2", "Infinitely many"),
                0,
                "The possible results are 0, 1, 2 and 3 – both ends count.",
            ),
            output(
                "import random\nletters = list(\"abc\")\nrandom.shuffle(letters)\nprint(\"\".join(sorted(letters)))",
                "abc",
                "After sorting, the shuffled order no longer matters.",
            ),
            tiles(
                "Pick 2 different items from the list players.",
                listOf("random.sample(", "players,", "2", ")"),
                listOf("random.choice(", "random.randint("),
                "sample(my_list, k) picks k different items.",
            ),
        ),
    ),
)
