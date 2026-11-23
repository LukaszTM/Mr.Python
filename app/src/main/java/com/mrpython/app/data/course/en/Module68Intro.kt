package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

internal val module68Intro = lesson(
    "u68l0", "Introduction: the text analysis project",
    explain(
        "Project plan",
        "In this module you build a text analyzer step by step: cleaning, counting words, " +
            "most common words, average length and finally a report. We start by tidying up the text.",
        code = "text = \"  Alice HAS a Cat!  \"\nprint(text.strip().lower().replace(\"!\", \"\"))",
        output = "alice has a cat",
    ),
    explain(
        "Words from text",
        "`split()` with no argument splits the text on any whitespace and gives a list of words. " +
            "We count the words in a dictionary with `get(w, 0) + 1`.",
        code = "counts = {}\nfor w in \"cat dog cat\".split():\n    counts[w] = counts.get(w, 0) + 1\nprint(counts)",
        output = "{'cat': 2, 'dog': 1}",
    ),
    explain(
        "Most common words",
        "`Counter` does the same thing in less code, and `most_common(n)` returns n (word, count) pairs starting " +
            "from the most common. Words like “and” or “in” are worth filtering out with a set.",
        code = "from collections import Counter\nc = Counter(\"a b a c a b\".split())\nprint(c.most_common(2))",
        output = "[('a', 3), ('b', 2)]",
    ),
    explain(
        "Average word length",
        "The average is the sum of the lengths divided by the number of words. `max(words, key=len)` finds the longest word.",
        code = "words = [\"cat\", \"is\", \"cute\"]\nprint(sum(len(w) for w in words) / len(words))\nprint(max(words, key=len))",
        output = "3.0\ncute",
    ),
    explain(
        "Report",
        "At the end we print the results nicely: `:.2f` rounds to two decimal places, and `\"#\" * n` " +
            "draws a simple bar chart.",
        code = "avg = 3.14159\nprint(f\"Average: {avg:.2f}\")\nprint(\"cat:\", \"#\" * 3)",
        output = "Average: 3.14\ncat: ###",
    ),
    output(
        "from collections import Counter\nc = Counter(\"x y x\".split())\nprint(c[\"x\"], c[\"z\"])",
        "2 0",
        "Counter returns 0 for a word that never appeared.",
    ),
    choice(
        "What does \"Ann  has\\ncats\".split() return?",
        listOf("['Ann', 'has', 'cats']", "['Ann', '', 'has', 'cats']", "['Ann  has', 'cats']", "'Ann has cats'"),
        0,
        "split() with no argument splits on any whitespace and skips empty pieces.",
    ),
)
