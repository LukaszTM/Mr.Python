package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*
import com.mrpython.app.domain.CourseUnit

internal val module71 = CourseUnit(
    id = "u71",
    title = "Python idioms",
    description = "How to write code that looks truly Pythonic",
    lessons = listOf(
        lesson(
            "u71l1", "EAFP or LBYL",
            choice(
                "What does the EAFP style mean?",
                listOf("Try first, and catch a possible error in except", "Always check conditions with if before acting", "Never use exceptions", "Write everything on one line"),
                0,
                "EAFP: it's Easier to Ask Forgiveness than Permission.",
            ),
            output(
                "d = {\"a\": 1}\nif \"b\" in d:\n    print(d[\"b\"])\nelse:\n    print(\"missing\")",
                "missing",
                "LBYL: we check first (if), and only then act.",
            ),
            output(
                "d = {\"a\": 1}\ntry:\n    print(d[\"b\"])\nexcept KeyError:\n    print(\"no such key\")",
                "no such key",
                "EAFP: we just try and catch the KeyError.",
            ),
            fill(
                "Convert the text to a number in the EAFP style.",
                "text = \"12a\"\ntry:\n    n = int(text)\nexcept ____:\n    n = 0\nprint(n)",
                listOf("ValueError", "KeyError", "IndexError"),
                "ValueError",
                "int() on a bad string raises ValueError.",
            ),
            output(
                "def to_number(t):\n    try:\n        return int(t)\n    except ValueError:\n        return 0\nprint([to_number(x) for x in [\"3\", \"x\", \"7\"]])",
                "[3, 0, 7]",
                "Bad strings turn into 0 and the program keeps running.",
            ),
            choice(
                "When is EAFP clearly better than LBYL?",
                listOf("When the state can change between the check and the use, e.g. a file disappears", "When we want the code to be slower", "When we don't know any exceptions", "Never"),
                0,
                "An if check can go stale, while try works at the moment of use.",
            ),
            tiles(
                "Write the LBYL version: convert t to a number if it is all digits, otherwise give 0",
                listOf("n", "=", "int(t)", "if", "t.isdigit()", "else", "0"),
                listOf("except", "t.isalpha()"),
                "LBYL checks the condition first (isdigit), and only then acts.",
            ),
            output(
                "class Cat:\n    name = \"Whiskers\"\nprint(getattr(Cat, \"name\", \"?\"))\nprint(getattr(Cat, \"age\", \"?\"))",
                "Whiskers\n?",
                "getattr with a default value doesn't raise AttributeError.",
            ),
        ),
        lesson(
            "u71l2", "Unpacking and swapping",
            output(
                "a, b = 1, 2\na, b = b, a\nprint(a, b)",
                "2 1",
                "Swapping values without a helper variable is a classic idiom.",
            ),
            output(
                "first, *rest = [1, 2, 3, 4]\nprint(first, rest)",
                "1 [2, 3, 4]",
                "The star collects all the remaining elements into a list.",
            ),
            output(
                "*start, last = \"abc\"\nprint(start, last)",
                "['a', 'b'] c",
                "The star can also come first.",
            ),
            fill(
                "Swap the values of x and y.",
                "x, y = \"left\", \"right\"\nx, y = ____\nprint(x, y)",
                listOf("y, x", "x, y", "y"),
                "y, x",
                "On the right we build the tuple (y, x) and unpack it.",
            ),
            output(
                "people = [(\"Amy\", 7), (\"Zoe\", 9)]\nfor name, age in people:\n    print(name, age)",
                "Amy 7\nZoe 9",
                "Unpacking in the loop header replaces the indexes [0] and [1].",
            ),
            output(
                "(a, b), c = (1, 2), 3\nprint(a + b + c)",
                "6",
                "You can unpack nested structures too.",
            ),
            tiles(
                "Take the first and last elements of the list numbers and skip the middle",
                listOf("first,", "*_,", "last", "=", "numbers"),
                listOf("**_,", "numbers[0]"),
                "*_ collects the unneeded middle into the variable _.",
            ),
            choice(
                "What happens when this code runs?",
                listOf("ValueError – too many values to unpack", "a = 1, b = [2, 3]", "a = 1, b = 2, and 3 is skipped", "a = [1, 2], b = 3"),
                0,
                "Without a star, the number of variables must match the number of elements.",
                code = "a, b = [1, 2, 3]",
            ),
        ),
        lesson(
            "u71l3", "enumerate and zip instead of indexes",
            output(
                "for i, ch in enumerate(\"ab\", 1):\n    print(i, ch)",
                "1 a\n2 b",
                "enumerate gives the number and the element together; here we count from 1.",
            ),
            output(
                "names = [\"Amy\", \"Zoe\"]\nscores = [5, 8]\nfor name, s in zip(names, scores):\n    print(f\"{name}: {s}\")",
                "Amy: 5\nZoe: 8",
                "zip joins lists element by element.",
            ),
            choice(
                "Which version is the most Pythonic?",
                listOf("for i, x in enumerate(items):", "for i in range(len(items)): x = items[i]", "i = 0, and then while i < len(items):", "for x in items: i = items.index(x)"),
                0,
                "enumerate is readable and needs no manual indexing.",
            ),
            output(
                "print(list(zip([1, 2, 3], \"ab\")))",
                "[(1, 'a'), (2, 'b')]",
                "zip stops at the shortest sequence.",
            ),
            fill(
                "Build a dictionary from a list of keys and a list of values.",
                "keys = [\"a\", \"b\"]\nvalues = [1, 2]\nd = ____(zip(keys, values))\nprint(d[\"b\"])",
                listOf("dict", "list", "tuple"),
                "dict",
                "dict() accepts the (key, value) pairs from zip.",
            ),
            output(
                "pairs = [(\"a\", 1), (\"b\", 2)]\nletters, numbers = zip(*pairs)\nprint(letters, numbers)",
                "('a', 'b') (1, 2)",
                "zip(*pairs) \"unzips\" the pairs back into two tuples.",
            ),
            tiles(
                "Loop over the indexes and elements of a list at the same time",
                listOf("for", "i, x", "in", "enumerate(items):"),
                listOf("range(items):", "zip(items):"),
                "enumerate(items) returns (index, element) pairs.",
            ),
            output(
                "items = [3, 8, 1, 9]\nbig = [i for i, x in enumerate(items) if x > 2]\nprint(big)",
                "[0, 1, 3]",
                "We collect the indexes of the elements greater than 2.",
            ),
        ),
        lesson(
            "u71l4", "get, setdefault and list comprehensions",
            output(
                "d = {\"a\": 1}\nprint(d.get(\"a\"), d.get(\"b\"), d.get(\"b\", 0))",
                "1 None 0",
                "get() returns None or the given default value when the key is missing.",
            ),
            output(
                "groups = {}\nfor w in [\"cat\", \"cow\", \"dog\"]:\n    groups.setdefault(w[0], []).append(w)\nprint(groups)",
                "{'c': ['cat', 'cow'], 'd': ['dog']}",
                "setdefault creates an empty list only the first time a key is used.",
            ),
            fill(
                "Append each word to the list under its first letter, creating the list if it's missing.",
                "groups = {}\nfor w in [\"ant\", \"ape\"]:\n    groups.____(w[0], []).append(w)\nprint(groups)",
                listOf("setdefault", "get", "pop"),
                "setdefault",
                "Only setdefault stores the new list in the dictionary.",
            ),
            output(
                "from collections import defaultdict\nd = defaultdict(int)\nfor ch in \"abca\":\n    d[ch] += 1\nprint(dict(d))",
                "{'a': 2, 'b': 1, 'c': 1}",
                "defaultdict(int) creates a zero for a new key by itself.",
            ),
            output(
                "sq = [x * x for x in range(5) if x % 2 == 0]\nprint(sq)",
                "[0, 4, 16]",
                "A list comprehension replaces a loop with append().",
            ),
            output(
                "words = [\"big\", \"ox\", \"runs\"]\nprint({w: len(w) for w in words})",
                "{'big': 3, 'ox': 2, 'runs': 4}",
                "A dictionary can be built with a comprehension too.",
            ),
            choice(
                "When is a regular loop better than a list comprehension?",
                listOf("When there is a lot of logic or side effects, e.g. print()", "Always, because list comprehensions are slow", "When the list has fewer than 10 elements", "Never"),
                0,
                "A list comprehension is for building a list, not for performing actions.",
            ),
            tiles(
                "Build a dictionary: number → its square for the numbers 1, 2, 3",
                listOf("{n:", "n * n", "for n in", "range(1, 4)}"),
                listOf("[n:", "range(3)}"),
                "A dictionary comprehension has the form {key: value for ...}.",
            ),
        ),
        lesson(
            "u71l5", "Review: truthiness, with and :=",
            output(
                "print(bool([]), bool(\"0\"), bool(0))",
                "False True False",
                "An empty list and zero are falsy, while the non-empty string \"0\" is truthy.",
            ),
            output(
                "items = []\nif not items:\n    print(\"empty\")",
                "empty",
                "The Pythonic way to check for emptiness is the object itself, without len().",
            ),
            choice(
                "Which version is idiomatic?",
                listOf("if items:", "if len(items) > 0:", "if items == True:", "if items != []:"),
                0,
                "A non-empty list is truthy all by itself.",
            ),
            output(
                "with open(\"notes.txt\", \"w\") as f:\n    f.write(\"hi\")\nprint(f.closed)",
                "True",
                "with closes the file automatically when the block ends.",
            ),
            fill(
                "Open the file so that it closes itself.",
                "with open(\"notes.txt\", \"w\") as f:\n    f.write(\"Python\")\n____ open(\"notes.txt\") as f:\n    print(f.read())",
                listOf("with", "try", "for"),
                "with",
                "with is the idiom for working with files and resources.",
            ),
            output(
                "data = [1, 5, 9]\nif (n := len(data)) > 2:\n    print(f\"Long list: {n}\")",
                "Long list: 3",
                "The := operator assigns a value and uses it right away.",
            ),
            output(
                "it = iter([\"a\", \"b\", \"\", \"c\"])\nwhile (k := next(it)):\n    print(k)",
                "a\nb",
                "The loop ends at the empty string because it is falsy.",
            ),
            tiles(
                "Collect the squares of the numbers in the list data, but only those greater than 10",
                listOf("big", "=", "[y for x in data", "if (y := x * x) > 10]"),
                listOf("if y = x * x > 10]", "(y for x in data"),
                "The walrus in the condition computes x * x only once.",
            ),
        ),
    ),
)
