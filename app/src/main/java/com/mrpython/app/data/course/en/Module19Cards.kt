package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

internal val module19Cards = listOf(
    cards(
        "u19l1",
        explain(
            "Chained comparison",
            "Writing `1 <= x <= 6` checks whether x lies between 1 and 6 – it's short for `1 <= x and x <= 6`. " +
                "It's handy when the result is random but we know its range.",
            code = "x = 4\nprint(1 <= x <= 6, 5 <= x <= 9)",
            output = "True False",
        ),
        explain(
            "The limits of randint",
            "When both limits are equal, `randint(5, 5)` always returns 5. The first limit can't " +
                "be greater than the second – `randint(5, 1)` is a `ValueError`.",
            code = "import random\nprint(random.randint(5, 5))",
            output = "5",
        ),
    ),
    cards(
        "u19l2",
        explain(
            "sample returns a list",
            "`random.choice()` also works on a string and returns one letter. `random.sample()` always " +
                "returns a new list – even when it picks from a string or a `range`. The original doesn't change.",
            code = "import random\nx = random.sample(\"ab\", 2)\nprint(type(x), sorted(x))",
            output = "<class 'list'> ['a', 'b']",
        ),
        explain(
            "Don't assign shuffle",
            "`shuffle` returns `None`, so writing `l = random.shuffle(l)` loses the list! Call " +
                "`shuffle` on its own line and keep using the same variable.",
            code = "import random\nl = [1, 2, 3]\nrandom.shuffle(l)\nprint(len(l))",
            output = "3",
        ),
    ),
    cards(
        "u19l3",
        explain(
            "Errors when picking",
            "You can't pick more different items than the list contains – `sample` then raises a " +
                "`ValueError`. `choice` on an empty list gives an `IndexError`.",
            code = "import random\ntry:\n    random.sample([1], 2)\nexcept ValueError:\n    print(\"not enough\")",
            output = "not enough",
        ),
        explain(
            "Subset: <=",
            "For sets, `a <= b` checks whether every item of `a` is also in `b`. It's an easy way to check " +
                "that random results come from the allowed pool.",
            code = "print({1, 2} <= {1, 2, 3})\nprint({1, 4} <= {1, 2, 3})",
            output = "True\nFalse",
        ),
    ),
)
