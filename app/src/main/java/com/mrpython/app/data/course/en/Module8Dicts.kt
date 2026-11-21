package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*
import com.mrpython.app.domain.CourseUnit

internal val module8 = CourseUnit(
    id = "u8",
    title = "Dictionaries",
    description = "Key–value pairs",
    lessons = listOf(
        lesson(
            "u8l1", "Creating dictionaries",
            choice(
                "How do you create a dictionary with a name and an age?",
                listOf(
                    "{\"name\": \"Ann\", \"age\": 10}",
                    "[\"name\": \"Ann\", \"age\": 10]",
                    "(\"name\" = \"Ann\", \"age\" = 10)",
                    "{\"name\", \"Ann\", \"age\", 10}",
                ),
                0,
                "A dictionary is key: value pairs inside curly braces.",
            ),
            output(
                "person = {\"name\": \"Ann\", \"age\": 10}\nprint(person[\"name\"])",
                "Ann",
                "You read a value by its key in square brackets.",
            ),
            output("prices = {\"bread\": 5, \"milk\": 4}\nprint(prices[\"bread\"] + prices[\"milk\"])", "9", "5 + 4 = 9."),
            output("d = {\"a\": 1}\nd[\"b\"] = 2\nprint(d)", "{'a': 1, 'b': 2}", "You add a new key with a plain assignment."),
            output("d = {\"a\": 1}\nd[\"a\"] = 5\nprint(d)", "{'a': 5}", "Assigning to an existing key overwrites the value."),
            output("print(len({\"x\": 1, \"y\": 2, \"z\": 3}))", "3", "len() returns the number of pairs in a dictionary."),
            choice(
                "What will happen?",
                listOf("A KeyError – there is no key b", "It prints None", "It prints 0", "It prints b"),
                0,
                "Reading a key that doesn't exist with [] causes a KeyError.",
                code = "d = {\"a\": 1}\nprint(d[\"b\"])",
            ),
            tiles(
                "Add the key \"Tom\" with the value 5 to the dictionary grades",
                listOf("grades[", "\"Tom\"", "]", "=", "5"),
                listOf("(", ")"),
                "dictionary[key] = value",
            ),
        ),
        lesson(
            "u8l2", "Dictionary methods",
            output("d = {\"a\": 1}\nprint(d.get(\"b\", 0))", "0", "get() returns the default value when the key isn't there."),
            output("d = {\"a\": 1, \"b\": 2}\nprint(\"a\" in d)", "True", "in checks whether a key is in the dictionary."),
            output("d = {\"a\": 1, \"b\": 2}\nprint(list(d.keys()))", "['a', 'b']", "keys() returns the keys."),
            output("d = {\"a\": 1, \"b\": 2}\nprint(list(d.values()))", "[1, 2]", "values() returns the values."),
            output("d = {\"a\": 1, \"b\": 2}\ndel d[\"a\"]\nprint(d)", "{'b': 2}", "del removes the pair with the given key."),
            output("d = {\"x\": 10}\nvalue = d.pop(\"x\")\nprint(value, d)", "10 {}", "pop() removes a key and returns its value."),
            fill(
                "Fill in the blank to read a value without risking an error.",
                "d = {\"a\": 1}\nprint(d.____(\"z\"))",
                listOf("get", "pop", "keys"),
                "get",
                "get() returns None when the key isn't there, instead of raising an error.",
            ),
        ),
        lesson(
            "u8l3", "Dictionaries and loops",
            output("d = {\"a\": 1, \"b\": 2}\nfor k in d:\n    print(k)", "a\nb", "A loop over a dictionary goes through its keys."),
            output(
                "d = {\"Ann\": 5, \"Tom\": 4}\nfor name, grade in d.items():\n    print(name, grade)",
                "Ann 5\nTom 4",
                "items() gives (key, value) pairs.",
            ),
            output(
                "counter = {}\nfor ch in \"abca\":\n    counter[ch] = counter.get(ch, 0) + 1\nprint(counter)",
                "{'a': 2, 'b': 1, 'c': 1}",
                "This is the most common way to count occurrences of elements.",
            ),
            output(
                "prices = {\"a\": 3, \"b\": 7}\ntotal = 0\nfor p in prices.values():\n    total += p\nprint(total)",
                "10",
                "We add up all the values of the dictionary.",
            ),
            output(
                "grades = {\"Ann\": 5, \"Tom\": 3}\nfor name in grades:\n    if grades[name] >= 4:\n        print(name)",
                "Ann",
                "We print only the people with a grade of at least 4.",
            ),
            tiles(
                "Build the header of a loop over the key–value pairs of the dictionary d",
                listOf("for", "k,", "v", "in", "d.items()", ":"),
                listOf("d.keys()", "d"),
                "items() returns pairs, which we unpack into k and v.",
            ),
            choice(
                "What does d.items() return?",
                listOf("(key, value) pairs", "Only the keys", "Only the values", "The number of elements"),
                0,
                "items() returns key–value pairs.",
            ),
        ),
        lesson(
            "u8l4", "Review: dictionaries",
            output("d = {1: \"one\", 2: \"two\"}\nprint(d[2])", "two", "A key can also be a number."),
            output("d = {\"a\": [1, 2]}\nd[\"a\"].append(3)\nprint(d[\"a\"])", "[1, 2, 3]", "A value in a dictionary can be a list."),
            output(
                "countries = {\"PL\": \"Warsaw\", \"DE\": \"Berlin\"}\nprint(countries.get(\"FR\", \"unknown\"))",
                "unknown",
                "There is no key FR, so get() returns the default value.",
            ),
            choice(
                "Which sentence is true?",
                listOf(
                    "Keys in a dictionary are unique",
                    "Keys can repeat",
                    "A dictionary has a fixed length",
                    "Values must be strings",
                ),
                0,
                "Each key appears only once – assigning again overwrites the value.",
            ),
            output("d = {\"a\": 1, \"a\": 2}\nprint(d)", "{'a': 2}", "With a repeated key, the last value stays."),
            output(
                "d = {}\nd[\"x\"] = d.get(\"x\", 0) + 1\nd[\"x\"] = d.get(\"x\", 0) + 1\nprint(d[\"x\"])",
                "2",
                "Each time the value grows by 1.",
            ),
            fill(
                "Fill in the blank to loop over the dictionary's values.",
                "d = {\"a\": 1, \"b\": 2}\nfor v in d.____():\n    print(v)",
                listOf("values", "keys", "items"),
                "values",
                "values() returns only the values.",
            ),
            output(
                "person = {\"name\": \"Eve\", \"age\": 30}\nprint(f\"{person['name']} is {person['age']} years old\")",
                "Eve is 30 years old",
                "In an f-string, write the key in a different kind of quotes than the whole string.",
            ),
        ),
    ),
)
