package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

internal val module66Intro = lesson(
    "u66l0", "Introduction: review week – the standard library",
    explain(
        "math and datetime",
        "This week is a tour of ready-made modules. `math` has square roots and rounding, and `datetime` " +
            "does arithmetic on dates – the difference between two dates is a `timedelta`.",
        code = "import math\nfrom datetime import date\nprint(math.sqrt(16), math.ceil(2.1))\nprint((date(2026, 3, 1) - date(2026, 2, 1)).days)",
        output = "4.0 3\n28",
    ),
    explain(
        "collections",
        "`Counter` counts, `deque` is a queue, `namedtuple` is a tuple with named fields, and `defaultdict` " +
            "creates a missing value by itself – perfect for grouping.",
        code = "from collections import defaultdict\ng = defaultdict(list)\nfor s in [\"cat\", \"cow\", \"dog\"]:\n    g[s[0]].append(s)\nprint(dict(g))",
        output = "{'c': ['cat', 'cow'], 'd': ['dog']}",
    ),
    explain(
        "itertools",
        "`itertools` gives you ready-made iterators: `chain` joins, `combinations` picks pairs, " +
            "`accumulate` computes running totals, and `groupby` groups neighboring items.",
        code = "from itertools import accumulate, combinations\nprint(list(accumulate([1, 2, 3])))\nprint(list(combinations(\"ABC\", 2)))",
        output = "[1, 3, 6]\n[('A', 'B'), ('A', 'C'), ('B', 'C')]",
    ),
    explain(
        "functools",
        "`reduce` folds a list into a single value, `partial` creates a function with some arguments " +
            "set in advance, and `lru_cache` remembers the results of calls.",
        code = "from functools import reduce, partial\nprint(reduce(lambda a, b: a * b, [1, 2, 3, 4]))\nfrom_binary = partial(int, base=2)\nprint(from_binary(\"101\"))",
        output = "24\n5",
    ),
    explain(
        "re and json",
        "`re` searches for patterns in text, e.g. `\\d+` is a run of digits. `json.dumps` turns data into " +
            "JSON text, and `json.loads` turns the text back into data.",
        code = "import re, json\nprint(re.findall(r\"\\d+\", \"3 cats and 12 dogs\"))\nprint(json.dumps({\"ok\": True}))",
        output = "['3', '12']\n{\"ok\": true}",
    ),
    output(
        "from itertools import accumulate\nprint(list(accumulate([2, 2, 2])))",
        "[2, 4, 6]",
        "accumulate returns running totals: 2, 2+2, 2+2+2.",
    ),
    choice(
        "Which function turns a dictionary into text in JSON format?",
        listOf("json.dumps", "json.loads", "re.findall", "str.split"),
        0,
        "dumps writes data as text, loads does the opposite.",
    ),
)
