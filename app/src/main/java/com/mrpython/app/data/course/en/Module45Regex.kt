package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*
import com.mrpython.app.domain.CourseUnit

internal val module45 = CourseUnit(
    id = "u45",
    title = "Regular expressions",
    description = "The re module: searching, groups, replacing and validating text",
    lessons = listOf(
        lesson(
            "u45l1", "re.search and matching",
            output(
                "import re\nm = re.search(r\"\\d+\", \"I'm 25 years old\")\nprint(m.group())",
                "25",
                "re.search() finds the first match, and group() returns the matched text.",
            ),
            output(
                "import re\nm = re.search(r\"\\d\", \"abc123\")\nprint(m.start())",
                "3",
                "start() returns the index where the match begins.",
            ),
            choice(
                "What does re.search() return when the pattern doesn't match anywhere in the string?",
                listOf("None", "An empty list", "False", "It raises a ValueError"),
                0,
                "No match means None, so it's worth checking the result before calling group().",
            ),
            output(
                "import re\nm = re.search(\"cat\", \"Amy has cats\")\nprint(m.span())",
                "(8, 11)",
                "span() returns a tuple (start, end) of the match.",
            ),
            choice(
                "What will this code print?",
                listOf("None", "cat", "(8, 11)", "True"),
                0,
                "re.match() checks only the beginning of the string, and the string starts with \"Amy\".",
                code = "import re\nprint(re.match(\"cat\", \"Amy has cats\"))",
            ),
            output(
                "import re\nm = re.match(r\"\\d+\", \"123abc\")\nprint(m.group())",
                "123",
                "Here the string starts with digits, so re.match() succeeds.",
            ),
            choice(
                "Why do we write r before a pattern, e.g. r\"\\d+\"?",
                listOf(
                    "So the backslash \\ isn't treated as a special string character",
                    "So the pattern runs faster",
                    "So letter case doesn't matter",
                    "Without r the re module doesn't work at all",
                ),
                0,
                "A raw string passes backslashes to re unchanged.",
            ),
            fill(
                "Complete the code to find the first number in the string.",
                "import re\nm = re.____(r\"\\d+\", \"no. 42\")\nprint(m.group())",
                listOf("search", "match", "split", "findall"),
                "search",
                "search() looks through the whole string; match() looks only at the beginning and returns None here.",
            ),
        ),
        lesson(
            "u45l2", "re.findall",
            output(
                "import re\nt = \"1 cat, 22 dogs, 333 fish\"\nprint(re.findall(r\"\\d+\", t))",
                "['1', '22', '333']",
                "findall() returns a list of all matches.",
            ),
            choice(
                "How is re.findall() different from re.search()?",
                listOf(
                    "findall() returns a list of all matches, search() only the first one",
                    "findall() works only on numbers",
                    "search() returns a list, findall() a match object",
                    "It isn't, they're synonyms",
                ),
                0,
                "search() gives a single match object, and findall() a list of strings.",
            ),
            output(
                "import re\nprint(re.findall(r\"\\d\", \"a1b2\"))",
                "['1', '2']",
                "\\d matches a single digit, so we get the digits separately.",
            ),
            output(
                "import re\nprint(re.findall(r\"\\d+\", \"nothing\"))",
                "[]",
                "No matches means an empty list, not None.",
            ),
            choice(
                "What does re.findall() return for a pattern without groups?",
                listOf("A list of strings", "A single match object", "The number of matches", "A tuple of indexes"),
                0,
                "findall() returns a list of all the matched pieces.",
            ),
            output(
                "import re\nt = \"3 + 4 + 5\"\nnumbers = re.findall(r\"\\d+\", t)\nprint(sum(int(x) for x in numbers))",
                "12",
                "Matches are strings, so we convert them to int before adding.",
            ),
            tiles(
                "Find all the numbers in the string text and store them in the variable results",
                listOf("results", "=", "re.findall(", "r\"\\d+\",", "text)"),
                listOf("re.search(", "text.findall("),
                "re.findall(pattern, text) returns a list of all matches.",
            ),
            fill(
                "Complete the code to count the words \"yes\" in the string.",
                "import re\nt = \"yes no yes yes\"\nprint(len(re.____(\"yes\", t)))",
                listOf("findall", "search", "match"),
                "findall",
                "findall() returns a list whose length is the number of matches; a match object has no len().",
            ),
        ),
        lesson(
            "u45l3", "Character classes and quantifiers",
            output(
                "import re\nprint(re.findall(r\"\\w+\", \"Amy has cats\"))",
                "['Amy', 'has', 'cats']",
                "\\w is a letter, digit or _, and + means \"one or more\".",
            ),
            output(
                "import re\nprint(re.findall(r\"\\d{3}\", \"12345678\"))",
                "['123', '456']",
                "{3} means exactly three repetitions; the leftover \"78\" is too short.",
            ),
            output(
                "import re\nprint(re.findall(\"ab*\", \"a ab abbb\"))",
                "['a', 'ab', 'abbb']",
                "* means \"zero or more\", so a on its own matches too.",
            ),
            fill(
                "Complete the pattern to match numbers made of one or more digits.",
                "import re\nprint(re.findall(r\"\\d____\", \"5 and 120\"))",
                listOf("+", "?", "{2}"),
                "+",
                "+ means \"at least once\", so we get ['5', '120'].",
            ),
            output(
                "import re\nt = \"color colour\"\nprint(re.findall(\"colou?r\", t))",
                "['color', 'colour']",
                "? means the character is optional (0 or 1 time).",
            ),
            output(
                "import re\nprint(re.findall(\"[aeiou]\", \"calculator\"))",
                "['a', 'u', 'a', 'o']",
                "Square brackets make a class: any one character from the list matches.",
            ),
            choice(
                "What does \\s match in a pattern?",
                listOf("A whitespace character, e.g. a space", "Any letter", "A digit", "The letter s"),
                0,
                "\\s is a space, a tab, a newline and so on.",
            ),
            fill(
                "Complete the pattern to match exactly 4 digits at a time.",
                "import re\nprint(re.findall(r\"\\d____\", \"12345678\"))",
                listOf("{4}", "+", "*", "?"),
                "{4}",
                "{4} requires exactly four digits, so we get ['1234', '5678'].",
            ),
        ),
        lesson(
            "u45l4", "Groups and named groups",
            output(
                "import re\nm = re.search(r\"(\\d+)-(\\d+)\", \"tel 12-34\")\nprint(m.group(1))",
                "12",
                "Parentheses create a group; group(1) is the first one.",
            ),
            output(
                "import re\nm = re.search(r\"(\\d+)-(\\d+)\", \"tel 12-34\")\nprint(m.groups())",
                "('12', '34')",
                "groups() returns a tuple of all the groups.",
            ),
            choice(
                "What does m.group(0) return?",
                listOf("The whole match", "The first group", "The start index", "None"),
                0,
                "group(0) is the whole match, just like group() with no argument.",
            ),
            output(
                "import re\np = r\"(?P<year>\\d{4})-(?P<month>\\d{2})\"\nm = re.search(p, \"2026-10\")\nprint(m.group(\"month\"))",
                "10",
                "We refer to a named group by its name.",
            ),
            output(
                "import re\np = r\"(?P<year>\\d{4})-(?P<month>\\d{2})\"\nm = re.search(p, \"2026-10\")\nprint(m.groupdict())",
                "{'year': '2026', 'month': '10'}",
                "groupdict() returns a dictionary: group name → text.",
            ),
            output(
                "import re\nprint(re.findall(r\"(\\w)=(\\d)\", \"a=1 b=2\"))",
                "[('a', '1'), ('b', '2')]",
                "When a pattern has several groups, findall() returns a list of tuples.",
            ),
            choice(
                "How do you write a named group called \"code\"?",
                listOf("(?P<code>...)", "(code: ...)", "{code}...", "<code>(...)"),
                0,
                "The syntax for a named group in Python is (?P<name>pattern).",
            ),
            fill(
                "Complete the code to print the first group.",
                "import re\nm = re.search(r\"(\\d+)kg\", \"weight 15kg\")\nprint(m.____(1))",
                listOf("group", "get", "find"),
                "group",
                "group(n) returns the text of the n-th group; a match object has no get or find.",
            ),
        ),
        lesson(
            "u45l5", "re.sub, re.split and validation",
            output(
                "import re\nprint(re.sub(r\"\\d\", \"#\", \"pin 1234\"))",
                "pin ####",
                "re.sub() replaces every match with the given text.",
            ),
            output(
                "import re\nprint(re.sub(r\"\\s+\", \" \", \"a   b    c\"))",
                "a b c",
                "We replace several spaces in a row with a single one.",
            ),
            output(
                "import re\nprint(re.sub(r\"(\\d+)-(\\d+)\", r\"\\2-\\1\", \"12-34\"))",
                "34-12",
                "In the replacement text, \\1 and \\2 stand for the contents of the groups.",
            ),
            output(
                "import re\nprint(re.split(r\"[,;]\", \"a,b;c\"))",
                "['a', 'b', 'c']",
                "re.split() splits the string at every place that matches the pattern.",
            ),
            output(
                "import re\np = r\"\\d{5}-\\d{4}\"\nfor k in [\"90210-1234\", \"9021-1234\", \"902101234\"]:\n    print(bool(re.fullmatch(p, k)))",
                "True\nFalse\nFalse",
                "fullmatch() checks whether the whole string is a valid ZIP+4 code.",
            ),
            choice(
                "Why is fullmatch() better than search() for validating a ZIP+4 code?",
                listOf(
                    "search() would also find a code in the string \"x90210-1234x\"",
                    "search() doesn't support {n}",
                    "fullmatch() is the only function that returns True",
                    "search() works only on numbers",
                ),
                0,
                "fullmatch() requires the pattern to match the whole string, not just a part of it.",
            ),
            output(
                "import re\np = r\"[\\w.]+@\\w+\\.\\w+\"\nprint(re.fullmatch(p, \"amy@mail.com\") is not None)\nprint(re.fullmatch(p, \"amy@com\") is not None)",
                "True\nFalse",
                "The simplified email pattern requires a dot after the @.",
            ),
            tiles(
                "Replace every digit in the string text with an asterisk and store the result in the variable new",
                listOf("new", "=", "re.sub(", "r\"\\d\",", "\"*\",", "text)"),
                listOf("re.split(", "text.sub("),
                "re.sub(pattern, replacement, text) returns a new string.",
            ),
        ),
        lesson(
            "u45l6", "Review: regular expressions",
            output(
                "import re\nm = re.search(r\"\\d+\", \"ok 7 and 80\")\nprint(m.group())",
                "7",
                "search() returns only the first match.",
            ),
            output(
                "import re\nprint(re.findall(r\"\\d+\", \"ok 7 and 80\"))",
                "['7', '80']",
                "findall() collects all the matches.",
            ),
            choice(
                "Which pattern matches one or more letters, digits or _?",
                listOf("\\w+", "\\d*", "\\s+", "\\w?"),
                0,
                "\\w is a word character, and + means \"at least once\".",
            ),
            output(
                "import re\nm = re.search(r\"(?P<x>\\d+)x(?P<y>\\d+)\", \"1920x1080\")\nprint(m.group(\"y\"))",
                "1080",
                "The named group y captured the second number.",
            ),
            output(
                "import re\nprint(re.sub(\"a+\", \"a\", \"baaad\"))",
                "bad",
                "We replace a run of several letters a with a single one.",
            ),
            output(
                "import re\nprint(re.split(r\"\\s*;\\s*\", \"x ; y;z\"))",
                "['x', 'y', 'z']",
                "\\s* allows any number of spaces around the semicolon.",
            ),
            fill(
                "Complete the code to check whether the WHOLE string is exactly 3 digits.",
                "import re\nprint(re.____(r\"\\d{3}\", \"1234\"))",
                listOf("fullmatch", "search", "findall"),
                "fullmatch",
                "fullmatch() returns None for \"1234\", while search() and findall() would find the piece \"123\".",
            ),
            tiles(
                "Find the first match of pattern in the string text and store it in the variable m",
                listOf("m", "=", "re.search(", "pattern,", "text)"),
                listOf("re.sub(", "m.group("),
                "re.search(pattern, text) returns a match object or None.",
            ),
        ),
    ),
)
