package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

internal val module45Intro = lesson(
    "u45l0", "Introduction: regular expressions",
    explain(
        "Patterns and re.search",
        "A regular expression is a pattern that describes a piece of text, e.g. `\\d+` – \"one or more " +
            "digits\". `re.search()` finds the first match (or returns None), and `group()` " +
            "gives the matched text. The letter `r` before the pattern leaves backslashes unchanged.",
        code = "import re\nm = re.search(r\"\\d+\", \"I'm 25 years old\")\nprint(m.group(), m.start())",
        output = "25 4",
    ),
    explain(
        "re.findall – all the matches",
        "`re.findall()` returns a list of all the matched pieces (empty when nothing " +
            "matches). `re.match()` checks only the beginning of the string.",
        code = "import re\nt = \"1 cat, 22 dogs\"\nprint(re.findall(r\"\\d+\", t))\nprint(re.match(\"cat\", t))",
        output = "['1', '22']\nNone",
    ),
    explain(
        "Character classes and quantifiers",
        "`\\d` is a digit, `\\w` a letter, digit or _, `\\s` whitespace, and `[aeo]` any character from the " +
            "list. Quantifiers say \"how many times\": `+` at least once, `*` zero or more, `?` optional, " +
            "`{3}` exactly 3.",
        code = "import re\nprint(re.findall(r\"\\w+\", \"Amy has cats\"))\nprint(re.findall(r\"\\d{2}\", \"12345\"))\nprint(re.findall(\"colou?r\", \"color colour\"))",
        output = "['Amy', 'has', 'cats']\n['12', '34']\n['color', 'colour']",
    ),
    explain(
        "Groups",
        "Parentheses create a group, which you read with `group(1)` or `groups()`. A named group " +
            "`(?P<name>...)` lets you write `group(\"name\")`.",
        code = "import re\np = r\"(?P<year>\\d{4})-(\\d{2})\"\nm = re.search(p, \"2026-10\")\nprint(m.group(\"year\"), m.group(2))\nprint(m.groups())",
        output = "2026 10\n('2026', '10')",
    ),
    explain(
        "Replacing, splitting and validating",
        "`re.sub()` replaces every match with other text, and `re.split()` splits a string by a " +
            "pattern. `re.fullmatch()` checks whether the whole string matches – perfect for " +
            "validation, e.g. of a ZIP+4 code.",
        code = "import re\nprint(re.sub(r\"\\d\", \"#\", \"pin 123\"))\nprint(re.split(r\"[,;]\", \"a,b;c\"))\nprint(bool(re.fullmatch(r\"\\d{5}-\\d{4}\", \"90210-1234\")))",
        output = "pin ###\n['a', 'b', 'c']\nTrue",
    ),
    output(
        "import re\nprint(re.findall(r\"\\d+\", \"a1 b22 c333\"))",
        "['1', '22', '333']",
        "findall() returns a list of all the numbers as strings.",
    ),
    choice(
        "What does + mean in the pattern \\d+?",
        listOf("At least one repetition", "Exactly one repetition", "Zero or more", "Adding numbers"),
        0,
        "+ means \"one or more times\".",
    ),
    fill(
        "Complete the code to replace every digit with an asterisk.",
        "import re\nprint(re.____(r\"\\d\", \"*\", \"code 42\"))",
        listOf("sub", "split", "findall", "search"),
        "sub",
        "re.sub(pattern, replacement, text) returns a new string.",
    ),
)
