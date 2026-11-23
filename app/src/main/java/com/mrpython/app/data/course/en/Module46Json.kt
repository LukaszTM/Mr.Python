package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*
import com.mrpython.app.domain.CourseUnit

internal val module46 = CourseUnit(
    id = "u46",
    title = "JSON",
    description = "Converting Python data to JSON text and back",
    lessons = listOf(
        lesson(
            "u46l1", "json.dumps",
            output(
                "import json\nprint(json.dumps({\"a\": 1}))",
                "{\"a\": 1}",
                "json.dumps() converts a dictionary to text in JSON format.",
            ),
            output(
                "import json\nprint(json.dumps([1, True, None]))",
                "[1, true, null]",
                "In JSON, True is true and None is null.",
            ),
            output(
                "import json\nt = json.dumps({\"x\": 2})\nprint(type(t).__name__)",
                "str",
                "The result of dumps() is an ordinary string.",
            ),
            output(
                "import json\nprint(json.dumps((1, 2)))",
                "[1, 2]",
                "JSON has no tuples, so a tuple becomes an array.",
            ),
            choice(
                "What does json.dumps() turn a Python dictionary into?",
                listOf("A JSON object in {} braces", "A JSON array in [] brackets", "A list of tuples", "A file"),
                0,
                "In JSON, a dictionary is an object with key: value pairs.",
            ),
            choice(
                "What will happen?",
                listOf("TypeError", "It prints [1, 2]", "It prints {1, 2}", "It prints null"),
                0,
                "JSON has no set type; you have to convert it first, e.g. to a list.",
                code = "import json\nprint(json.dumps({1, 2}))",
            ),
            fill(
                "Complete the code to convert the dictionary data to JSON text.",
                "import json\ndata = {\"ok\": True}\ntext = json.____(data)\nprint(text)",
                listOf("dumps", "loads", "dump"),
                "dumps",
                "dumps() (dump string) returns a string; loads() works the other way, and dump() needs a file.",
            ),
            tiles(
                "Convert the list results to JSON text and store it in the variable text",
                listOf("text", "=", "json.dumps(", "results)"),
                listOf("json.loads(", "results.dumps("),
                "json.dumps(object) returns JSON text.",
            ),
        ),
        lesson(
            "u46l2", "json.loads",
            output(
                "import json\nd = json.loads('{\"x\": 5}')\nprint(d[\"x\"])",
                "5",
                "json.loads() converts JSON text to a Python dictionary.",
            ),
            output(
                "import json\nprint(json.loads(\"[1, 2, 3]\")[1])",
                "2",
                "A JSON array becomes a list.",
            ),
            output(
                "import json\nprint(json.loads(\"[true, null]\"))",
                "[True, None]",
                "true is True, and null is None.",
            ),
            output(
                "import json\nd = json.loads('{\"a\": 1}')\nprint(type(d).__name__)",
                "dict",
                "A JSON object is loaded as a dict.",
            ),
            choice(
                "What will happen?",
                listOf("JSONDecodeError", "It prints {'a': 1}", "It prints 1", "It prints None"),
                0,
                "Single quotes aren't valid JSON, so loads() raises a JSONDecodeError.",
                code = "import json\nprint(json.loads(\"{'a': 1}\"))",
            ),
            output(
                "import json\nd = {1: \"a\"}\nprint(json.loads(json.dumps(d)))",
                "{'1': 'a'}",
                "Keys in JSON are always strings, so the number 1 comes back as \"1\".",
            ),
            fill(
                "Complete the code to convert JSON text to a dictionary.",
                "import json\nt = '{\"name\": \"Amy\"}'\nd = json.____(t)\nprint(d[\"name\"])",
                listOf("loads", "dumps", "load"),
                "loads",
                "loads() (load string) reads JSON from a string; load() expects a file.",
            ),
            choice(
                "How can you remember the difference between dumps and loads?",
                listOf(
                    "dumps: Python → text, loads: text → Python",
                    "dumps: text → Python, loads: Python → text",
                    "Both do the same thing",
                    "dumps saves a file, loads deletes it",
                ),
                0,
                "The letter s at the end stands for string: dumps creates a string, loads reads one.",
            ),
        ),
        lesson(
            "u46l3", "Nesting and formatting",
            output(
                "import json\nt = '{\"user\": {\"tags\": [\"a\", \"b\"]}}'\nd = json.loads(t)\nprint(d[\"user\"][\"tags\"][1])",
                "b",
                "We reach into nested data with one index after another.",
            ),
            output(
                "import json\nd = {\"items\": [{\"x\": 1}, {\"x\": 2}]}\nprint(sum(e[\"x\"] for e in d[\"items\"]))",
                "3",
                "JSON often contains lists of dictionaries – we iterate over them as usual.",
            ),
            output(
                "import json\nprint(json.dumps({\"a\": 1, \"b\": 2}, indent=2))",
                "{\n  \"a\": 1,\n  \"b\": 2\n}",
                "indent=2 spreads the JSON over several lines with a 2-space indentation.",
            ),
            output(
                "import json\nd = {\"b\": 1, \"a\": 2}\nprint(json.dumps(d, sort_keys=True))",
                "{\"a\": 2, \"b\": 1}",
                "sort_keys=True sorts the keys alphabetically.",
            ),
            output(
                "import json\nprint(json.dumps(\"café\"))",
                "\"caf\\u00e9\"",
                "By default, non-ASCII characters are replaced with \\u codes.",
            ),
            output(
                "import json\nprint(json.dumps(\"café\", ensure_ascii=False))",
                "\"café\"",
                "ensure_ascii=False leaves accented letters unchanged.",
            ),
            fill(
                "Complete the code so the accented letter stays readable in the result.",
                "import json\nd = {\"city\": \"Málaga\"}\nprint(json.dumps(d, ____=False))",
                listOf("ensure_ascii", "sort_keys", "indent"),
                "ensure_ascii",
                "sort_keys=False changes nothing, and indent=False doesn't turn off the \\u codes.",
            ),
            choice(
                "What does the indent parameter of json.dumps() do?",
                listOf("Adds indentation", "Sorts the keys", "Removes spaces", "Compresses the data"),
                0,
                "indent sets the number of indentation spaces, which makes the JSON readable.",
            ),
        ),
        lesson(
            "u46l4", "Review: JSON",
            output(
                "import json\nprint(json.dumps({\"ok\": False, \"x\": None}))",
                "{\"ok\": false, \"x\": null}",
                "False is false, None is null.",
            ),
            output(
                "import json\nd = json.loads('{\"n\": [3, 4]}')\nprint(d[\"n\"][0] * 2)",
                "6",
                "loads() gives a dictionary with a list whose first item is 3.",
            ),
            choice(
                "Which Python type corresponds to a JSON array [ ] after json.loads()?",
                listOf("list", "tuple", "set", "dict"),
                0,
                "A JSON array always becomes a list.",
            ),
            output(
                "import json\nd = {\"c\": 3, \"a\": 1}\nprint(json.dumps(d, sort_keys=True))",
                "{\"a\": 1, \"c\": 3}",
                "The keys have been sorted.",
            ),
            output(
                "import json\nprint(json.dumps([\"é\"], ensure_ascii=False))",
                "[\"é\"]",
                "With ensure_ascii=False the letter é stays unchanged.",
            ),
            output(
                "import json\nt = json.dumps({\"k\": (1, 2)})\nprint(json.loads(t))",
                "{'k': [1, 2]}",
                "After a trip through JSON, a tuple comes back as a list.",
            ),
            fill(
                "Complete the code to print the JSON with a 4-space indentation.",
                "import json\nprint(json.dumps({\"a\": 1}, ____=4))",
                listOf("indent", "sort_keys", "ensure_ascii"),
                "indent",
                "indent=4 sets the indentation to 4 spaces; the other parameters don't add indentation.",
            ),
            tiles(
                "Load JSON text from the string t into the variable data",
                listOf("data", "=", "json.loads(", "t)"),
                listOf("json.dumps(", "t.loads("),
                "json.loads(string) converts JSON to Python objects.",
            ),
        ),
    ),
)
