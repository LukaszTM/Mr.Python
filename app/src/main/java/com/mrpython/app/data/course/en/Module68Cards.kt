package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

internal val module68Cards = listOf(
    cards(
        "u68l1",
        explain(
            "The string module",
            "The `string` module has ready-made sets of characters: `string.punctuation` is the punctuation marks, " +
                "`string.digits` – the digits, and `string.ascii_letters` – the letters a–z and A–Z.",
            code = "import string\nprint(string.digits)\nprint(\"?\" in string.punctuation)",
            output = "0123456789\nTrue",
        ),
        explain(
            "maketrans and translate",
            "`str.maketrans(\"ae\", \"43\")` builds a character-for-character replacement table, and `translate` applies it. " +
                "The third argument of `maketrans` is the characters to delete.",
            code = "tab = str.maketrans(\"ae\", \"43\")\nprint(\"great\".translate(tab))\nremove = str.maketrans(\"\", \"\", \",!\")\nprint(\"Yes, me!\".translate(remove))",
            output = "gr34t\nYes me",
        ),
        explain(
            "strip with an argument",
            "`strip(\".!\")` removes the given characters from both ends of a string, not just spaces. " +
                "`lstrip` cleans only the left side, and `rstrip` – the right side.",
            code = "print(\"...Hey!!!\".strip(\".!\"))\nprint(\"!!yes!!\".lstrip(\"!\"))",
            output = "Hey\nyes!!",
        ),
    ),
    cards(
        "u68l2",
        explain(
            "Adding more: update",
            "`update` adds new elements to a `Counter` – it increases the counts instead of overwriting them " +
                "(in a regular dictionary `update` would overwrite the values).",
            code = "from collections import Counter\nc = Counter([\"cat\"])\nc.update([\"cat\", \"dog\"])\nprint(c)",
            output = "Counter({'cat': 2, 'dog': 1})",
        ),
    ),
    cards(
        "u68l4",
        explain(
            "The statistics module",
            "The `statistics` module computes statistics for us: `mean` is the average, `median` – the median " +
                "(the middle value), and `mode` – the value that appears most often.",
            code = "from statistics import mean, median, mode\nd = [3, 2, 4, 3]\nprint(mean(d), median(d), mode(d))",
            output = "3 3.0 3",
        ),
    ),
)
