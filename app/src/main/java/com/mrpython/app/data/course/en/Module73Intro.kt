package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

internal val module73Intro = lesson(
    "u73l0", "Introduction: the grand finale",
    explain(
        "The home stretch",
        "This is the last module of the course! Puzzles that combine everything you've learned are waiting, " +
            "and at the end you'll celebrate the title of Python Master.",
        code = "days = 365\nprint(f\"Days completed: {days}\")\nprint(days // 7, days % 7)",
        output = "Days completed: 365\n52 1",
    ),
    explain(
        "Strings and numbers",
        "Many puzzles are about playing with strings: `join` glues characters together, `isalnum()` filters out " +
            "punctuation, and `[::-1]` reverses a string – and there's your palindrome test.",
        code = "def pal(s):\n    s = \"\".join(c for c in s.lower() if c.isalnum())\n    return s == s[::-1]\nprint(pal(\"Kayak!\"), pal(\"cat\"))",
        output = "True False",
    ),
    explain(
        "Data structures",
        "`zip(*m)` swaps rows with columns, and a double list comprehension flattens a list of lists.",
        code = "m = [[1, 2], [3, 4]]\nprint([list(r) for r in zip(*m)])\nprint([x for w in m for x in w])",
        output = "[[1, 3], [2, 4]]\n[1, 2, 3, 4]",
    ),
    explain(
        "Functions as values",
        "You can keep functions in a list and call them one after another – that's how a simple text-processing pipeline is built.",
        code = "steps = [str.strip, str.lower, str.title]\nt = \"  mR pYTHON \"\nfor f in steps:\n    t = f(t)\nprint(t)",
        output = "Mr Python",
    ),
    explain(
        "Everything at once",
        "The hardest tasks combine several tools, e.g. `Counter` and sorting with a key. " +
            "Break the task into steps and check the result of each one.",
        code = "from collections import Counter\nc = Counter(\"to be or not to be\".split())\nprint(sorted(c, key=lambda s: (-c[s], s))[:2])",
        output = "['be', 'to']",
    ),
    output(
        "print(\"kayak\" == \"kayak\"[::-1])",
        "True",
        "\"kayak\" reversed is still \"kayak\", so it's a palindrome.",
    ),
    output(
        "m = [[1], [2, 3]]\nprint([x for w in m for x in w])",
        "[1, 2, 3]",
        "A double list comprehension flattens a list of lists.",
    ),
)
