package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

internal val module14Intro = lesson(
    "u14l0", "Introduction: nested structures",
    explain(
        "A list inside a list",
        "An element of a list can be… another list. Such a list of lists works like a table: each inner " +
            "list is a row. The first index picks the row, the second one picks the element in that row.",
        code = "m = [[1, 2, 3], [4, 5, 6]]\nprint(m[0])\nprint(m[1][2])",
        output = "[1, 2, 3]\n6",
    ),
    explain(
        "A list of dictionaries",
        "When we describe many similar things, e.g. people, we write each one as a dictionary and keep " +
            "them all in a list. `people[0]` is a dictionary, and `people[0][\"name\"]` is a value from it.",
        code = "people = [{\"name\": \"Amy\"}, {\"name\": \"Bob\"}]\nprint(people[1][\"name\"])",
        output = "Bob",
    ),
    explain(
        "A dictionary of lists",
        "A value in a dictionary can be a list, e.g. a student's list of grades. First you give the key, then " +
            "the index – and you can use list methods such as `append()`.",
        code = "grades = {\"Amy\": [5, 4]}\ngrades[\"Amy\"].append(3)\nprint(grades[\"Amy\"][0], grades)",
        output = "5 {'Amy': [5, 4, 3]}",
    ),
    explain(
        "A loop inside a loop",
        "To visit every element of a list of lists, we use two loops: the outer one gives the rows, " +
            "and the inner one gives the numbers in each row.",
        code = "m = [[1, 2], [3, 4]]\nfor row in m:\n    for x in row:\n        print(x, end=\" \")",
        output = "1 2 3 4 ",
    ),
    explain(
        "Shallow and deep copies",
        "`b = a` doesn't copy the list – it is a second name for the same object. `a.copy()` copies only the " +
            "outer list (a shallow copy), and `copy.deepcopy(a)` copies everything inside as well.",
        code = "import copy\na = [[1], [2]]\nb = copy.deepcopy(a)\nb[0].append(9)\nprint(a)",
        output = "[[1], [2]]",
    ),
    output(
        "m = [[7, 8], [9, 10]]\nprint(m[1][0])",
        "9",
        "m[1] is the row [9, 10], and [0] is its first element.",
    ),
    choice(
        "How do you read the age of the first person?",
        listOf("people[0][\"age\"]", "people[\"age\"][0]", "people.age[0]", "people[0].age"),
        0,
        "First the list index, then the dictionary key.",
        code = "people = [{\"age\": 20}, {\"age\": 30}]",
    ),
    choice(
        "What does b = a do when a is a list?",
        listOf("Gives the same list a second name", "Creates a deep copy", "Creates an empty list", "Deletes the list a"),
        0,
        "Assignment doesn't copy – both names point to the same object.",
    ),
)
