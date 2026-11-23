package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*
import com.mrpython.app.domain.CourseUnit

internal val module7 = CourseUnit(
    id = "u7",
    title = "Strings inside out",
    description = "Indexes, slices and string methods",
    lessons = listOf(
        lesson(
            "u7l1", "Indexes and slices",
            output("s = \"Python\"\nprint(s[0])", "P", "String indexes also start at 0."),
            output("s = \"Python\"\nprint(s[-1])", "n", "-1 is the last character."),
            output("s = \"Python\"\nprint(s[0:2])", "Py", "The slice [0:2] is the characters at indexes 0 and 1."),
            output("s = \"Python\"\nprint(s[2:])", "thon", "From index 2 to the end."),
            output("print(\"abcdef\"[::2])", "ace", "A step of 2 takes every second character."),
            output("print(\"kitten\"[::-1])", "nettik", "[::-1] reverses a string."),
            choice(
                "What will happen?",
                listOf("An error", "s changes to \"hat\"", "s changes to \"h\"", "Nothing happens"),
                0,
                "A string can't be changed through an index, so this is an error. You have to create a new string: \"h\" + s[1:].",
                code = "s = \"cat\"\ns[0] = \"h\"",
            ),
            output("print(len(\"Ann has a cat\"))", "13", "Spaces are characters too."),
        ),
        lesson(
            "u7l2", "String methods",
            output("print(\"python\".upper())", "PYTHON", "upper() changes letters to uppercase."),
            output("print(\"PyThOn\".lower())", "python", "lower() changes letters to lowercase."),
            output("print(\"  hey  \".strip() + \"!\")", "hey!", "strip() removes spaces from the beginning and the end."),
            output("print(\"Ann has a cat\".replace(\"cat\", \"dog\"))", "Ann has a dog", "replace() swaps a part of a string."),
            output("print(\"banana\".count(\"a\"))", "3", "count() counts the occurrences of a substring."),
            output("print(\"python\".find(\"th\"))", "2", "find() returns the index where the substring starts."),
            output("print(\"john smith\".title())", "John Smith", "title() starts every word with a capital letter."),
            fill(
                "Fill in the blank to check whether the file has the .py extension.",
                "file = \"main.py\"\nprint(file.____(\".py\"))",
                listOf("endswith", "startswith", "find"),
                "endswith",
                "endswith() checks what a string ends with.",
            ),
        ),
        lesson(
            "u7l3", "split() and join()",
            output("print(\"a,b,c\".split(\",\"))", "['a', 'b', 'c']", "split() cuts a string into a list at the separator."),
            output("words = \"Ann likes cats\".split()\nprint(len(words))", "3", "split() with no argument splits on spaces."),
            output("print(\"-\".join([\"2026\", \"10\", \"22\"]))", "2026-10-22", "join() glues a list of strings together, inserting the separator."),
            output("print(\"\".join([\"P\", \"y\"]))", "Py", "An empty separator joins the elements with no gaps."),
            output(
                "sentence = \"i like learning python\"\nprint(sentence.split()[-1])",
                "python",
                "split() gives a list, and [-1] takes its last word.",
            ),
            output("print(\"Python\" in \"I am learning Python\")", "True", "in checks whether a substring appears in a string."),
            fill(
                "Fill in the blank to join the words with spaces.",
                "words = [\"Hi\", \"Tom\"]\nprint(\" \".____(words))",
                listOf("join", "split", "append"),
                "join",
                "separator.join(list) glues the elements of a list together.",
            ),
            tiles(
                "Split the string text into words and store them in the variable words",
                listOf("words", "=", "text.split()"),
                listOf("text.join()", "split(text)"),
                "split() is called on the string: text.split().",
            ),
        ),
        lesson(
            "u7l4", "Review: strings",
            output("s = \"Mr.Python\"\nprint(s[3:])", "Python", "From index 3 to the end."),
            output("print(\"abc\".upper()[::-1])", "CBA", "First upper(), then the reversal."),
            output("name = \"tom\"\nprint(name[0].upper() + name[1:])", "Tom", "The first letter uppercase, the rest unchanged."),
            output("text = \"a b c\"\nprint(text.replace(\" \", \"\"))", "abc", "Replacing spaces with an empty string removes them."),
            choice(
                "Which method turns \"hey\" into \"HEY\"?",
                listOf("upper()", "capitalize()", "big()", "title()"),
                0,
                "upper() changes all letters to uppercase.",
            ),
            output(
                "count = 0\nfor ch in \"Programming\":\n    if ch in \"aeiou\":\n        count += 1\nprint(count)",
                "3",
                "The vowels in the word are: o, a, i.",
            ),
            fill(
                "Fill in the blank to remove the spaces from the beginning and the end.",
                "s = \"  Text  \"\nprint(s.____())",
                listOf("strip", "split", "lower"),
                "strip",
                "strip() removes the spaces from the beginning and the end, while lower() only changes letters to lowercase.",
            ),
            output("print(\"ab\" * 2 + \"c\".upper())", "ababC", "First the string is repeated, then an uppercase C is added."),
        ),
    ),
)
