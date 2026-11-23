package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

internal val module57Intro = lesson(
    "u57l0", "Introduction: the quiz project",
    explain(
        "Project goal",
        "You'll build a quiz: questions stored as data, checking answers, counting points " +
            "and percentages, a random question order, and finally a `Question` class. " +
            "Each lesson adds one piece.",
    ),
    explain(
        "Questions as dictionaries",
        "A question is a dictionary with a text and an answer, and the whole quiz is a list of such dictionaries. " +
            "A `for` loop goes through the questions one by one.",
        code = "questions = [\n    {\"text\": \"2 + 2?\", \"answer\": \"4\"},\n    {\"text\": \"3 * 3?\", \"answer\": \"9\"},\n]\nfor q in questions:\n    print(q[\"text\"])",
        output = "2 + 2?\n3 * 3?",
    ),
    explain(
        "Checking answers",
        "The player may type spaces or capital letters. That's why we clean up the answer before comparing: " +
            "`strip()` removes spaces from the edges, and `lower()` turns the letters into lowercase.",
        code = "correct = \"Paris\"\nanswer = \" PARIS \"\nprint(answer == correct)\nprint(answer.strip().lower() == correct.lower())",
        output = "False\nTrue",
    ),
    explain(
        "Points and percentages",
        "`True` counts as 1, so `sum()` of the results list gives the number of points. The percentage is " +
            "`points / total * 100` or the `:.0%` format in an f-string.",
        code = "results = [True, False, True, True]\npoints = sum(results)\nprint(points, f\"{points / len(results):.0%}\")",
        output = "3 75%",
    ),
    explain(
        "Shuffling questions",
        "`random.shuffle(items)` shuffles a list in place, so the order is different every time. " +
            "To keep the original intact, shuffle a copy: `questions[:]`.",
        code = "import random\n\nquestions = [\"Q1\", \"Q2\", \"Q3\"]\nqueue = questions[:]\nrandom.shuffle(queue)\nprint(sorted(queue) == questions)",
        output = "True",
    ),
    output(
        "print(sum([True, True, False]))",
        "2",
        "Every True counts as 1.",
    ),
    choice(
        "What does random.shuffle(items) do?",
        listOf("Shuffles the list's elements in place", "Returns a sorted list", "Picks one random element", "Removes a random element"),
        0,
        "shuffle changes the order of the elements of the list itself.",
    ),
    fill(
        "Fill in the blank so that the answer \" YES \" is accepted as correct.",
        "answer = \" YES \"\nprint(answer.strip().____() == \"yes\")",
        listOf("lower", "upper", "title"),
        "lower",
        "After lower() we have \"yes\"; upper() gives \"YES\", and title() gives \"Yes\".",
    ),
)
