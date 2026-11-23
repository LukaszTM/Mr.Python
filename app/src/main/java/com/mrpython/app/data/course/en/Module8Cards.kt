package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

internal val module8Cards = listOf(
    cards(
        "u8l1",
        explain(
            "An empty dictionary and len()",
            "Empty braces `{}` create an empty dictionary, which you can add pairs to later. `len()` tells you " +
                "how many pairs the dictionary has.",
            code = "d = {}\nd[\"x\"] = 1\nd[\"y\"] = 2\nprint(len(d))",
            output = "2",
        ),
        explain(
            "A dictionary has no indexes",
            "A dictionary has no position numbers – in `d[...]` you always give a key. A key can also be a number, " +
                "but `d[0]` looks for the key 0, not the first pair.",
            code = "days = {1: \"Mon\", 2: \"Tue\"}\nprint(days[1])",
            output = "Mon",
        ),
    ),
    cards(
        "u8l2",
        explain(
            "get() without a default",
            "When you don't pass a second argument, `get()` returns `None` for a missing key. Careful: `del` " +
                "with a missing key ends with a `KeyError`.",
            code = "d = {\"a\": 1}\nprint(d.get(\"a\"))\nprint(d.get(\"z\"))",
            output = "1\nNone",
        ),
        explain(
            "in checks the keys",
            "`in` looks only among the dictionary's keys, not among its values.",
            code = "d = {\"a\": 1}\nprint(\"a\" in d)\nprint(1 in d)",
            output = "True\nFalse",
        ),
        explain(
            "Keys as a list",
            "`keys()` and `values()` give special \"views\" of the dictionary. `list()` turns them into a regular " +
                "list. You can also pass them to `sum()` or `sorted()`.",
            code = "d = {\"b\": 2, \"a\": 5}\nprint(list(d.keys()))\nprint(sum(d.values()))\nprint(sorted(d.keys()))",
            output = "['b', 'a']\n7\n['a', 'b']",
        ),
    ),
    cards(
        "u8l3",
        explain(
            "The value in a loop over keys",
            "The loop `for k in d` gives the keys. Inside the loop you can read the value for a given key with `d[k]`.",
            code = "d = {\"x\": 3, \"y\": 4}\nfor k in d:\n    print(k, d[k])",
            output = "x 3\ny 4",
        ),
        explain(
            "Counting occurrences",
            "Writing `d[ch] = d.get(ch, 0) + 1` takes the counter so far (or 0 when the key isn't there yet), " +
                "adds 1 and saves the result back under the same key.",
            code = "d = {}\nfor ch in \"eye\":\n    d[ch] = d.get(ch, 0) + 1\nprint(d)",
            output = "{'e': 2, 'y': 1}",
        ),
    ),
    cards(
        "u8l4",
        explain(
            "A list in a dictionary",
            "A value in a dictionary can be a list. `d[\"a\"]` then gives a list, so you can append an element " +
                "to it or reach for an index: `d[\"a\"][0]`.",
            code = "d = {\"a\": [1, 2]}\nd[\"a\"].append(3)\nprint(d[\"a\"][2])",
            output = "3",
        ),
        explain(
            "A dictionary in an f-string",
            "When the f-string is in double quotes `\"`, write the key inside the braces in single quotes `'`. " +
                "The same kind of quote would close the string too early.",
            code = "p = {\"name\": \"Tom\"}\nprint(f\"Hi, {p['name']}!\")",
            output = "Hi, Tom!",
        ),
        explain(
            "A repeated key",
            "If the same key appears twice inside the braces, only the last value stays – " +
                "keys in a dictionary don't repeat.",
            code = "d = {\"x\": 1, \"x\": 9}\nprint(d)",
            output = "{'x': 9}",
        ),
    ),
)
