package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

internal val module66Cards = listOf(
    cards(
        "u66l1",
        explain(
            "Distance: hypot and dist",
            "`math.hypot(a, b)` computes the hypotenuse using the Pythagorean theorem, " +
                "and `math.dist(p, q)` gives the distance between two points passed as tuples.",
            code = "import math\nprint(math.hypot(3, 4))\nprint(math.dist((0, 0), (6, 8)))",
            output = "5.0\n10.0",
        ),
        explain(
            "Counting choices: comb and perm",
            "`math.comb(n, k)` tells you how many ways there are to choose k things out of n (order doesn't matter). " +
                "`math.perm(n, k)` counts arrangements where order matters; `perm(n)` is n!.",
            code = "import math\nprint(math.comb(4, 2), math.perm(4, 2), math.perm(4))",
            output = "6 12 24",
        ),
    ),
    cards(
        "u66l2",
        explain(
            "Date with time: datetime",
            "The `datetime` class is a date together with an hour and a minute. The `hour` and `minute` fields " +
                "give the time, and in `strftime` the codes `%H` and `%M` print the hour and the minutes.",
            code = "from datetime import datetime\nt = datetime(2026, 7, 4, 9, 5)\nprint(t.hour, t.minute)\nprint(t.strftime(\"%d.%m %H:%M\"))",
            output = "9 5\n04.07 09:05",
        ),
        explain(
            "String to date: strptime",
            "`datetime.strptime(string, pattern)` works the opposite way from `strftime`: it reads a date " +
                "from a string according to the given pattern (p – parse, f – format).",
            code = "from datetime import datetime\nt = datetime.strptime(\"15/08/2025\", \"%d/%m/%Y\")\nprint(t.day, t.month, t.year)",
            output = "15 8 2025",
        ),
        explain(
            "Hours in timedelta",
            "`timedelta` also accepts `hours=`, `minutes=` and `weeks=`. When printed, it shows the time as " +
                "`h:mm:ss`, with whole days in front (`1 day, …`, `2 days, …`). It can be multiplied by a number, " +
                "and `total_seconds()` converts it to a number of seconds.",
            code = "from datetime import timedelta\nt = timedelta(hours=1, minutes=30)\nprint(t, t * 3)\nprint(timedelta(days=2, hours=3))\nprint(t.total_seconds())",
            output = "1:30:00 4:30:00\n2 days, 3:00:00\n5400.0",
        ),
    ),
    cards(
        "u66l5",
        explain(
            "A full set of comparisons: total_ordering",
            "The `@total_ordering` decorator from `functools` adds the missing comparisons (`<=`, `>`, `>=`). " +
                "You only need to define `__lt__` (and usually `__eq__` too).",
            code = "from functools import total_ordering\n@total_ordering\nclass W:\n    def __init__(self, p): self.p = p\n    def __lt__(self, o): return self.p < o.p\nprint(W(2) <= W(3), W(5) > W(3))",
            output = "True True",
        ),
    ),
    cards(
        "u66l7",
        explain(
            "JSON in a file: dump and load",
            "Without the letter \"s\" the functions work on files: `json.dump(data, f)` writes data to an open file, " +
                "and `json.load(f)` reads it back. The versions with \"s\" (`dumps`, `loads`) work on strings.",
            code = "import json\nwith open(\"data.json\", \"w\") as f:\n    json.dump({\"pts\": 10}, f)\nwith open(\"data.json\") as f:\n    print(json.load(f))",
            output = "{'pts': 10}",
        ),
    ),
)
