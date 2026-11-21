package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

internal val module8Intro = lesson(
    "u8l0", "Introduction: dictionaries",
    explain(
        "Key and value",
        "A dictionary stores key–value pairs, like a real dictionary: a word and its meaning. " +
            "We write it in curly braces `{}`, and read a value by its key in square brackets.",
        code = "person = {\"name\": \"Ann\", \"age\": 10}\nprint(person[\"name\"])",
        output = "Ann",
    ),
    explain(
        "Adding and changing",
        "Assigning to a new key adds a pair, and assigning to an existing one overwrites the value. " +
            "Keys are unique. Reading a key that doesn't exist ends with a `KeyError`.",
        code = "d = {\"a\": 1}\nd[\"b\"] = 2\nd[\"a\"] = 5\nprint(d)",
        output = "{'a': 5, 'b': 2}",
    ),
    explain(
        "Safe reading",
        "`get(key, default)` returns the value, or the default value when the key isn't there – with no error. " +
            "`in` checks whether a key is in the dictionary.",
        code = "d = {\"a\": 1}\nprint(d.get(\"b\", 0))\nprint(\"a\" in d)",
        output = "0\nTrue",
    ),
    explain(
        "Keys, values, removing",
        "`keys()` gives the keys, `values()` – the values, and `items()` – the pairs. `del d[k]` removes a pair, " +
            "and `pop(k)` removes it and returns the value.",
        code = "d = {\"a\": 1, \"b\": 2}\nprint(list(d.values()))\ndel d[\"a\"]\nprint(d)",
        output = "[1, 2]\n{'b': 2}",
    ),
    explain(
        "Dictionaries in a loop",
        "A loop over a dictionary goes through its keys. With `items()` you get the key and the value at once.",
        code = "grades = {\"Ann\": 5, \"Tom\": 4}\nfor name, grade in grades.items():\n    print(name, grade)",
        output = "Ann 5\nTom 4",
    ),
    output(
        "prices = {\"bread\": 5, \"milk\": 4}\nprint(prices[\"milk\"])",
        "4",
        "You read a value by its key.",
    ),
    fill(
        "Fill in the blank to read a value without risking an error.",
        "d = {\"x\": 1}\nprint(d.____(\"y\", 0))",
        listOf("get", "items", "keys"),
        "get",
        "get() returns the default value when the key isn't there.",
    ),
    choice(
        "What does d.items() return?",
        listOf("(key, value) pairs", "Only the keys", "Only the values", "The number of pairs"),
        0,
        "items() gives key–value pairs.",
    ),
)
