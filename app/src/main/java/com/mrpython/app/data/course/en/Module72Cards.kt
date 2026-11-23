package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

internal val module72Cards = listOf(
    cards(
        "u72l2",
        explain(
            "discard and ^ on sets",
            "`discard(x)` removes an element from a set, and if it isn't there, nothing happens (`remove` would raise an error). " +
                "`a ^ b` is the symmetric difference: elements that are in only one of the sets.",
            code = "s = {1, 2, 3}\ns.discard(7)\ns.discard(1)\nprint(s)\nprint({1, 2} ^ {2, 3})",
            output = "{2, 3}\n{1, 3}",
        ),
        explain(
            "Merging dictionaries: |",
            "`a | b` creates a new dictionary with the keys of both. When a key repeats, the value " +
                "from the right dictionary wins.",
            code = "a = {\"x\": 1, \"y\": 2}\nb = {\"y\": 9}\nprint(a | b)",
            output = "{'x': 1, 'y': 9}",
        ),
    ),
    cards(
        "u72l5",
        explain(
            "A key from itemgetter",
            "`itemgetter(\"age\")` from the `operator` module creates a function that takes the " +
                "`\"age\"` field from each element – it works like `lambda d: d[\"age\"]` and is a great fit for `key=`.",
            code = "from operator import itemgetter\npeople = [{\"name\": \"Olivia\", \"age\": 30},\n          {\"name\": \"Jack\", \"age\": 17}]\nfor p in sorted(people, key=itemgetter(\"age\")):\n    print(p[\"name\"])",
            output = "Jack\nOlivia",
        ),
    ),
    cards(
        "u72l6",
        explain(
            "Remembering results: @cache",
            "`@cache` from `functools` is a simpler version of `@lru_cache` with no size limit: it remembers the result " +
                "for every argument, so the second call computes nothing.",
            code = "from functools import cache\n@cache\ndef sq(x):\n    print(\"computing\", x)\n    return x * x\nprint(sq(3) + sq(3))",
            output = "computing 3\n18",
        ),
    ),
)
