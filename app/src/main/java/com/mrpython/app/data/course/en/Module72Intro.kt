package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

internal val module72Intro = lesson(
    "u72l0", "Introduction: the final exam",
    explain(
        "What the exam looks like",
        "The exam has six parts: basics, data structures, functions, objects, the standard library, " +
            "and algorithms. The questions are a bit harder – trace the code line by line and write down the variables' values.",
        code = "x = 5\nx += x * 2\nprint(x)",
        output = "15",
    ),
    explain(
        "Trap: two names, one list",
        "`b = a` doesn't copy the list – both names point to the same object, so a change made through `b` shows up in `a`. " +
            "To make a copy, use `a.copy()` or `a[:]`.",
        code = "a = [1, 2]\nb = a\nb.append(3)\nprint(a, a is b)",
        output = "[1, 2, 3] True",
    ),
    explain(
        "Trap: a default list",
        "A parameter's default value is created once, when the function is defined. A list used as a default " +
            "\"remembers\" earlier calls – that's why it's safer to use `None`.",
        code = "def f(x, items=[]):\n    items.append(x)\n    return items\nf(1)\nprint(f(2))",
        output = "[1, 2]",
    ),
    explain(
        "Trap: float",
        "Floating-point numbers are approximate, so `0.1 * 3` is not exactly `0.3`. " +
            "Compare after rounding or with a tolerance.",
        code = "print(0.1 * 3 == 0.3)\nprint(round(0.1 * 3, 2) == 0.3)",
        output = "False\nTrue",
    ),
    explain(
        "Trap: for with else",
        "A loop's `else` block runs only when the loop finished without `break`. " +
            "The loop variable stays around afterward with its last value.",
        code = "for i in range(3):\n    if i == 5:\n        break\nelse:\n    print(\"no break\")\nprint(i)",
        output = "no break\n2",
    ),
    output(
        "a = [1]\nb = a\nb.append(2)\nprint(a)",
        "[1, 2]",
        "a and b are the same list, so appending through b changes a too.",
    ),
    choice(
        "When does the else block of a for loop run?",
        listOf("when the loop finishes without break", "always after break", "when the loop never runs, and only then", "never"),
        0,
        "A loop's else runs only when the loop ends without break.",
    ),
)
