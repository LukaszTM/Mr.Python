package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

internal val module45Cards = listOf(
    cards(
        "u45l1",
        explain(
            "Where is the match?",
            "A match object knows its position: `start()` is the index where it begins, `end()` the " +
                "index just past its end, and `span()` returns both at once as a tuple.",
            code = "import re\nm = re.search(\"has\", \"Amy has cats\")\nprint(m.start(), m.end(), m.span())",
            output = "4 7 (4, 7)",
        ),
        explain(
            "Check whether anything was found",
            "When nothing matches we get `None`, and `None.group()` ends with an `AttributeError`. " +
                "That's why we check the result in an `if` – `None` is falsy, and a match is truthy.",
            code = "import re\nm = re.search(r\"\\d\", \"no digits\")\nif m:\n    print(m.group())\nelse:\n    print(\"none\")",
            output = "none",
        ),
    ),
    cards(
        "u45l2",
        explain(
            "Matches are strings",
            "`findall()` returns a list of strings, even when it finds numbers – before doing math we " +
                "convert them with `int()`. The `len()` of that list tells you how many matches there were.",
            code = "import re\nw = re.findall(r\"\\d+\", \"3 + 4 + 5\")\nprint(w, len(w))\nprint(sum(int(x) for x in w))",
            output = "['3', '4', '5'] 3\n12",
        ),
        explain(
            "Plus grabs as much as it can",
            "`\\d+` takes the longest possible run of digits. Any other character, e.g. a space or " +
                "a hyphen, ends the match and the next one begins.",
            code = "import re\nprint(re.findall(r\"\\d+\", \"12 3 600-700\"))",
            output = "['12', '3', '600', '700']",
        ),
    ),
    cards(
        "u45l3",
        explain(
            "A quantifier and the character before it",
            "A quantifier applies only to what's right before it: in `ab*` the asterisk works on " +
                "`b`, not on the whole `ab`. After a class, `[aeiou]+` grabs a run of characters from that class.",
            code = "import re\nprint(re.findall(\"ab*\", \"a ab abb\"))\nprint(re.findall(\"[aeiouy]+\", \"beautiful\"))",
            output = "['a', 'ab', 'abb']\n['eau', 'i', 'u']",
        ),
    ),
    cards(
        "u45l4",
        explain(
            "group(0) and groupdict()",
            "`group(0)` is the whole match (like `group()`), and groups are counted from 1, from the " +
                "left. `groupdict()` returns a dictionary of the named groups: name → text.",
            code = "import re\nm = re.search(r\"(?P<h>\\d+):(?P<m>\\d+)\", \"at 9:45\")\nprint(m.group(0), m.group(1))\nprint(m.groupdict())",
            output = "9:45 9\n{'h': '9', 'm': '45'}",
        ),
        explain(
            "findall with groups",
            "When a pattern has groups, `findall()` returns only their contents: with one group a list " +
                "of strings, with several – a list of tuples.",
            code = "import re\nprint(re.findall(r\"(\\d+)kg\", \"5kg 20kg 7g\"))\nprint(re.findall(r\"(\\w)=(\\d)\", \"a=1 b=2\"))",
            output = "['5', '20']\n[('a', '1'), ('b', '2')]",
        ),
    ),
    cards(
        "u45l5",
        explain(
            "Groups in the replacement",
            "In the replacement text of `re.sub()`, `\\1`, `\\2` insert the contents of the groups – " +
                "that's how you can swap parts around. Replacing with an empty string `\"\"` removes the matches.",
            code = "import re\nprint(re.sub(r\"(\\w+) (\\w+)\", r\"\\2 \\1\", \"John Smith\"))\nprint(re.sub(\"[aeiou]\", \"\", \"cauliflower\"))",
            output = "Smith John\nclflwr",
        ),
        explain(
            "The dot in a pattern",
            "A dot `.` in a pattern means any character. To match an actual dot, we write " +
                "`\\.`. Inside square brackets, e.g. `[\\w.]`, the dot is an ordinary character.",
            code = "import re\nprint(re.findall(\"c.t\", \"cat cut c.t\"))\nprint(re.findall(r\"c\\.t\", \"cat cut c.t\"))",
            output = "['cat', 'cut', 'c.t']\n['c.t']",
        ),
    ),
)
