package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

internal val module7Intro = lesson(
    "u7l0", "Introduction: strings inside out",
    explain(
        "A string is a sequence of characters",
        "Every character of a string has an index, just like a list element – the first is 0 and the last is -1. " +
            "`len()` tells you how many characters a string has (spaces count too).",
        code = "s = \"Python\"\nprint(s[0])\nprint(s[-1])\nprint(len(s))",
        output = "P\nn\n6",
    ),
    explain(
        "Slices",
        "`s[start:end]` cuts out a part of a string (without the character at index `end`). The third number " +
            "is the step, and `[::-1]` reverses the string. Strings can't be changed – a new one is always created.",
        code = "s = \"Python\"\nprint(s[0:2])\nprint(s[2:])\nprint(s[::-1])",
        output = "Py\nthon\nnohtyP",
    ),
    explain(
        "String methods",
        "Methods are called after a dot. `upper()` and `lower()` change the letter case, `strip()` removes " +
            "spaces from the edges, and `replace()` swaps a part of the string.",
        code = "print(\"hey\".upper())\nprint(\"  ok  \".strip() + \"!\")\nprint(\"Ann has a cat\".replace(\"cat\", \"dog\"))",
        output = "HEY\nok!\nAnn has a dog",
    ),
    explain(
        "split() and join()",
        "`split()` cuts a string into a list of words, and `join()` glues a list of strings into one, " +
            "inserting a separator between them.",
        code = "words = \"Ann likes cats\".split()\nprint(words)\nprint(\"-\".join(words))",
        output = "['Ann', 'likes', 'cats']\nAnn-likes-cats",
    ),
    explain(
        "Searching in a string",
        "`in` checks whether a substring appears in a string, `count()` counts the occurrences, " +
            "and `find()` gives the index where the substring starts.",
        code = "print(\"th\" in \"Python\")\nprint(\"banana\".count(\"a\"))\nprint(\"python\".find(\"th\"))",
        output = "True\n3\n2",
    ),
    output(
        "s = \"kitten\"\nprint(s[1:3])",
        "it",
        "The slice [1:3] is the characters at indexes 1 and 2.",
    ),
    choice(
        "Which method turns \"ann\" into \"ANN\"?",
        listOf("upper()", "lower()", "strip()", "split()"),
        0,
        "upper() changes letters to uppercase.",
    ),
    fill(
        "Fill in the blank to split the sentence into words.",
        "sentence = \"I like Python\"\nprint(sentence.____())",
        listOf("split", "upper", "strip"),
        "split",
        "split() cuts a string into a list of words.",
    ),
)
