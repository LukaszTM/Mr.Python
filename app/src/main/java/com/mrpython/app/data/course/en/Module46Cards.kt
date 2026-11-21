package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

internal val module46Cards = listOf(
    cards(
        "u46l1",
        explain(
            "Single values",
            "`dumps()` converts more than just dictionaries and lists to JSON. A string gets double " +
                "quotes, and a number becomes text – the result is always of type `str`.",
            code = "import json\nprint(json.dumps(\"yes\"))\nprint(json.dumps(42) + \"!\")",
            output = "\"yes\"\n42!",
        ),
        explain(
            "dump and load – files",
            "The functions without the letter s work on files: `json.dump(data, file)` writes JSON to " +
                "an open file, and `json.load(file)` reads it back.",
            code = "import json\nwith open(\"data.json\", \"w\") as f:\n    json.dump({\"a\": 1}, f)\nwith open(\"data.json\") as f:\n    print(json.load(f))",
            output = "{'a': 1}",
        ),
    ),
    cards(
        "u46l2",
        explain(
            "Simple values from JSON",
            "`loads()` reads single values too: `false` gives `False`, `null` – `None`, a number with " +
                "a decimal point is a `float`, and a string in quotes is an ordinary `str`.",
            code = "import json\nprint(json.loads(\"false\"), json.loads(\"null\"))\nprint(json.loads(\"3.5\") + 1, json.loads('\"amy\"'))",
            output = "False None\n4.5 amy",
        ),
        explain(
            "Invalid JSON",
            "Text that isn't valid JSON, e.g. with single quotes or a capitalized `True`, raises " +
                "a `json.JSONDecodeError`.",
            code = "import json\ntry:\n    json.loads(\"[True]\")\nexcept json.JSONDecodeError:\n    print(\"not JSON\")",
            output = "not JSON",
        ),
    ),
    cards(
        "u46l3",
        explain(
            "What indent looks like",
            "With `indent`, each item goes on its own line, indented by the given number of spaces, " +
                "and the closing brackets sit on lines of their own.",
            code = "import json\nprint(json.dumps([1, 2], indent=2))",
            output = "[\n  1,\n  2\n]",
        ),
    ),
)
