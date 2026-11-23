package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

internal val module46Intro = lesson(
    "u46l0", "Introduction: JSON",
    explain(
        "What is JSON?",
        "JSON is a popular text format for exchanging data – it's used by websites, apps and " +
            "configuration files. It looks like Python dictionaries and lists, but it's an ordinary " +
            "string. The built-in `json` module handles it.",
        code = "import json\nt = '{\"name\": \"Amy\", \"age\": 30}'\nprint(type(t).__name__)",
        output = "str",
    ),
    explain(
        "json.dumps – Python to text",
        "`json.dumps()` converts Python data to a JSON string. `True` becomes `true`, `None` – " +
            "`null`, and a tuple – an array. A set can't be written (TypeError).",
        code = "import json\nprint(json.dumps({\"ok\": True, \"x\": None}))\nprint(json.dumps((1, 2)))",
        output = "{\"ok\": true, \"x\": null}\n[1, 2]",
    ),
    explain(
        "json.loads – text to Python",
        "`json.loads()` works the other way: it reads a JSON string and returns a dictionary or " +
            "a list. JSON requires double quotes, and object keys are always strings. The letter s " +
            "in the name stands for string.",
        code = "import json\nd = json.loads('{\"x\": [1, 2]}')\nprint(d[\"x\"][1])\nprint(json.loads(json.dumps({1: \"a\"})))",
        output = "2\n{'1': 'a'}",
    ),
    explain(
        "Nested data",
        "JSON often contains dictionaries inside dictionaries and lists of dictionaries. We reach " +
            "into them with one index after another and iterate as over ordinary data.",
        code = "import json\nt = '{\"user\": {\"tags\": [\"a\", \"b\"]}}'\nd = json.loads(t)\nprint(d[\"user\"][\"tags\"][0])",
        output = "a",
    ),
    explain(
        "Formatting",
        "`indent=2` spreads the JSON over several lines with indentation, `sort_keys=True` sorts the " +
            "keys, and `ensure_ascii=False` keeps accented letters instead of `\\u` codes.",
        code = "import json\nd = {\"b\": \"café\", \"a\": 1}\nprint(json.dumps(d, sort_keys=True, ensure_ascii=False))",
        output = "{\"a\": 1, \"b\": \"café\"}",
    ),
    choice(
        "What does json.loads() do?",
        listOf("Converts JSON text to Python objects", "Converts Python objects to JSON text", "Saves a file", "Sorts the keys"),
        0,
        "loads reads a string containing JSON.",
    ),
    output(
        "import json\nprint(json.dumps([1, False, None]))",
        "[1, false, null]",
        "False is false, and None is null.",
    ),
    fill(
        "Complete the code to convert the dictionary to JSON text.",
        "import json\ndata = {\"a\": 1}\nprint(json.____(data))",
        listOf("dumps", "loads", "dump"),
        "dumps",
        "dumps() returns a string; loads() works the other way, and dump() needs a file.",
    ),
)
