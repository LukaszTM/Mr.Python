package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

internal val module7Cards = listOf(
    cards(
        "u7l1",
        explain(
            "Counting from the end in slices",
            "You can count from the end in slices too: `s[-3:]` is the last three characters, and `s[1:-1]` " +
                "is the string without its first and last character.",
            code = "s = \"Boston\"\nprint(s[-3:])\nprint(s[1:-1])",
            output = "ton\nosto",
        ),
        explain(
            "Start and step together",
            "In `s[start::step]` you say which index to start from and how many characters to move each time. " +
                "`s[1::2]` starts at index 1 and takes every second character up to the end.",
            code = "print(\"abcdefg\"[1::2])",
            output = "bdf",
        ),
        explain(
            "Changing a letter in a string",
            "You can't change a string through an index – `s[0] = \"h\"` ends with an error. Instead, glue a new " +
                "string together from pieces. An index outside the string, just like in a list, gives an `IndexError`.",
            code = "s = \"cat\"\ns = \"h\" + s[1:]\nprint(s)",
            output = "hat",
        ),
    ),
    cards(
        "u7l2",
        explain(
            "title() and capitalize()",
            "`title()` capitalizes the first letter of every word, and `capitalize()` – only " +
                "the first letter of the whole string.",
            code = "print(\"ann has a cat\".title())\nprint(\"ann has a cat\".capitalize())",
            output = "Ann Has A Cat\nAnn has a cat",
        ),
        explain(
            "String edges and find()",
            "`startswith()` and `endswith()` check what a string starts or ends with (they give `True` or " +
                "`False`). `strip(\"*\")` removes the given character from the edges instead of spaces, and `find()` " +
                "gives -1 when the substring isn't there.",
            code = "print(\"photo.jpg\".endswith(\".jpg\"))\nprint(\"**ok**\".strip(\"*\"))\nprint(\"cat\".find(\"x\"))",
            output = "True\nok\n-1",
        ),
        explain(
            "Methods give a new string",
            "Methods don't change the string – they return a new one, so you have to save the result, e.g. " +
                "`s = s.upper()`. Methods can be chained with dots; they run from left to right.",
            code = "s = \"hey\"\ns.upper()\nprint(s)\nprint(\" eve \".strip().title())",
            output = "hey\nEve",
        ),
    ),
    cards(
        "u7l3",
        explain(
            "split() with a separator",
            "With no argument, `split()` splits on spaces (even several in a row). When you give a separator, " +
                "e.g. `split(\",\")`, the string is cut at that character, and the separator itself disappears.",
            code = "print(\"1;2;3\".split(\";\"))\nprint(\"a   b\".split())",
            output = "['1', '2', '3']\n['a', 'b']",
        ),
        explain(
            "What's missing: not in",
            "`not in` is the opposite of `in` – it gives `True` when the substring isn't in the string " +
                "(or the element isn't in the list).",
            code = "print(\"x\" not in \"cat\")\nprint(\"a\" not in \"cat\")",
            output = "True\nFalse",
        ),
        explain(
            "The pieces are strings",
            "`split()` always gives a list of strings – to do math, convert them with `int()`. `join()` glues " +
                "only strings, so numbers have to be converted with `str()` first.",
            code = "parts = \"2 5\".split()\nprint(int(parts[0]) + int(parts[1]))\nprint(\"-\".join([\"a\", str(1)]))",
            output = "7\na-1",
        ),
    ),
)
