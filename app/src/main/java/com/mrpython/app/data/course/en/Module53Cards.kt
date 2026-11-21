package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

internal val module53Cards = listOf(
    cards(
        "u53l1",
        explain(
            "How many numbers does range give?",
            "`range(a, b)` gives exactly `b - a` numbers, because `b` is not included. With a step, count " +
                "the successive values: `range(10, 20, 2)` is 10, 12, 14, 16, 18 – five numbers.",
            code = "print(len(range(2, 10)))\nprint(list(range(10, 20, 2)))",
            output = "8\n[10, 12, 14, 16, 18]",
        ),
        explain(
            "The fencepost error",
            "A 10-foot fence with a post every foot (including both ends) has 11 posts, not 10. " +
                "When you count points from–to inclusive, add 1 – hence `range(0, 101, 10)`.",
            code = "print(len(range(0, 101, 10)))",
            output = "11",
        ),
    ),
    cards(
        "u53l2",
        explain(
            "Returning too early",
            "`return` ends the function immediately. If `return False` sits inside the loop, the function checks " +
                "only the first element. Return “not found” only after the loop, not indented under `for`.",
            code = "def find(items, target):\n    for x in items:\n        if x == target:\n            return \"found\"\n    return \"missing\"\nprint(find([1, 2, 3], 3))",
            output = "found",
        ),
        explain(
            "A comparison changes nothing",
            "A bare `x == 20` on its own line just computes `True`/`False` and changes nothing. Similarly, " +
                "`total = x` in a loop overwrites the total instead of adding to it – you need `+=`.",
            code = "x = 10\nx == 20\nprint(x)",
            output = "10",
        ),
    ),
    cards(
        "u53l3",
        explain(
            "Methods return None",
            "`append()`, `sort()` and `clear()` change the list in place and return `None`. So writing " +
                "`x = x.sort()` loses the list. `sorted(x)` gives you a sorted copy.",
            code = "x = [3, 1, 2]\nresult = x.sort()\nprint(result, x)",
            output = "None [1, 2, 3]",
        ),
        explain(
            "Removing safely",
            "The simplest way to remove elements is to build a new list with a list comprehension and a condition. " +
                "Only the elements you want to keep remain.",
            code = "numbers = [1, 1, 2, 3]\nnumbers = [x for x in numbers if x != 1]\nprint(numbers)",
            output = "[2, 3]",
        ),
        explain(
            "The same list twice",
            "`[row, row]` puts the same list into the grid twice – a change in one row shows up " +
                "in both. A list comprehension creates separate rows: `[[0] * 2 for _ in range(2)]`.",
            code = "grid = [[0] * 2 for _ in range(2)]\ngrid[0][0] = 1\nprint(grid)",
            output = "[[1, 0], [0, 0]]",
        ),
    ),
    cards(
        "u53l4",
        explain(
            "del restores the name",
            "When you shadow a built-in function with a variable, `del name` removes that variable and " +
                "the original function is visible again.",
            code = "max = 5\ndel max\nprint(max(1, 2))",
            output = "2",
        ),
        explain(
            "Shadowing inside a function",
            "A variable `sum` created inside a function is local – it shadows the built-in `sum` only " +
                "in that function. Outside it, `sum()` works normally.",
            code = "def f():\n    sum = 10\n    return sum\n\nprint(f(), sum([1, 2]))",
            output = "10 3",
        ),
    ),
    cards(
        "u53l5",
        explain(
            "// rounds down",
            "`//` always rounds down, toward the smaller number. So for negative numbers it gives " +
                "“one more into the negatives”: `-7 // 2` is -4. `int()`, on the other hand, simply cuts off " +
                "the fractional part.",
            code = "print(7 // 2, -7 // 2)\nprint(int(-3.5))",
            output = "3 -4\n-3",
        ),
        explain(
            "print is not return",
            "`print` only shows a value on the screen – a function without `return` still returns `None`. " +
                "Further math on such a result, e.g. `None * 2`, ends in a `TypeError`.",
            code = "def add(a, b):\n    print(a + b)\n\nx = add(2, 3)\nprint(x)",
            output = "5\nNone",
        ),
    ),
)
