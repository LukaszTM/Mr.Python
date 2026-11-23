package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*
import com.mrpython.app.domain.CourseUnit

internal val module68 = CourseUnit(
    id = "u68",
    title = "Project: text analysis",
    description = "We build a text analyzer step by step",
    lessons = listOf(
        lesson(
            "u68l1", "Step 1: cleaning the text",
            output(
                "text = \"  Alice HAS a Cat!  \"\nprint(text.strip().lower())",
                "alice has a cat!",
                "strip() removes spaces from the edges, and lower() turns the letters into lowercase.",
            ),
            output(
                "text = \"Hey, you! What?\"\nfor ch in \",!?\":\n    text = text.replace(ch, \"\")\nprint(text)",
                "Hey you What",
                "We replace each punctuation mark with an empty string.",
            ),
            fill(
                "Remove all punctuation marks from the text.",
                "import string\ntext = \"Yes, it is me!\"\ntable = str.maketrans(\"\", \"\", ____)\nprint(text.translate(table))",
                listOf("string.punctuation", "string.digits", "string.ascii_letters"),
                "string.punctuation",
                "string.punctuation contains all the common punctuation marks.",
            ),
            output(
                "from string import punctuation\nt = \"Cat, dog; fish.\"\nremove = str.maketrans(\"\", \"\", punctuation)\nt = t.translate(remove)\nprint(t.lower().split())",
                "['cat', 'dog', 'fish']",
                "With the punctuation removed, split() divides the text into clean words.",
            ),
            choice(
                "What does this code print?",
                listOf("['a', 'b', 'c']", "['a', '', 'b', 'c']", "['a  b', 'c']", "['a', 'b', '\\n', 'c']"),
                0,
                "split() with no argument splits on any whitespace and skips empty pieces.",
                code = "print(\"a  b\\n c\".split())",
            ),
            tiles(
                "Store in words all the words of the text without periods and commas at the edges",
                listOf("words", "=", "[w.strip(\".,\")", "for", "w", "in", "text.split()]"),
                listOf("while", "text.join()]"),
                "The list comprehension cleans each word with strip(\".,\").",
            ),
            output(
                "def clean(text):\n    for ch in \".,!?\":\n        text = text.replace(ch, \" \")\n    return text.lower().split()\n\nprint(clean(\"Alice, has a CAT!\"))",
                "['alice', 'has', 'a', 'cat']",
                "The clean() function is the first building block of our analyzer.",
            ),
            choice(
                "Why do we convert the text to lowercase before counting words?",
                listOf("So that “Cat” and “cat” count as the same word", "Because Counter doesn't support uppercase letters", "So that the text takes up less memory", "Because split() only works on lowercase letters"),
                0,
                "Without lower(), the same word written differently would be counted separately.",
            ),
        ),
        lesson(
            "u68l2", "Step 2: counting words",
            output(
                "words = [\"cat\", \"dog\", \"cat\"]\ncounts = {}\nfor w in words:\n    counts[w] = counts.get(w, 0) + 1\nprint(counts)",
                "{'cat': 2, 'dog': 1}",
                "get(w, 0) returns 0 for a new word, so we can add 1 right away.",
            ),
            fill(
                "Count how many times each word appears.",
                "words = [\"a\", \"b\", \"a\"]\ncounts = {}\nfor w in words:\n    counts[w] = counts.get(w, ____) + 1\nprint(counts)",
                listOf("0", "1", "None"),
                "0",
                "A new word starts at 0 occurrences, and then we add 1.",
            ),
            output(
                "from collections import Counter\nc = Counter(\"a b a c a\".split())\nprint(c[\"a\"], c[\"z\"])",
                "3 0",
                "Counter returns 0 for a missing key instead of raising KeyError.",
            ),
            output(
                "from collections import Counter\nprint(Counter([\"cat\", \"dog\", \"cat\"]))",
                "Counter({'cat': 2, 'dog': 1})",
                "A Counter prints itself starting from the most common element.",
            ),
            choice(
                "What does Counter return for a key that isn't there?",
                listOf("0", "None", "KeyError", "-1"),
                0,
                "Counter treats a missing element as zero occurrences.",
            ),
            output(
                "from collections import Counter\nc = Counter(\"red fish blue fish\".split())\nprint(len(c))\nprint(sum(c.values()))",
                "3\n4",
                "len() is the number of different words, and the sum of the values is the number of all words.",
            ),
            tiles(
                "Count the words from the list words using Counter",
                listOf("counts", "=", "Counter(", "words", ")"),
                listOf("words.count(", "len("),
                "Counter(list) counts all the elements right away.",
            ),
            output(
                "from collections import Counter\nc = Counter(\"abba\")\nc.update(\"ab\")\nprint(c[\"a\"], c[\"b\"])",
                "3 3",
                "update() adds new occurrences to an existing counter.",
            ),
        ),
        lesson(
            "u68l3", "Step 3: most common words",
            output(
                "from collections import Counter\nc = Counter(\"a b a c a b\".split())\nprint(c.most_common(2))",
                "[('a', 3), ('b', 2)]",
                "most_common(2) returns two (word, count) pairs, starting from the highest count.",
            ),
            output(
                "from collections import Counter\nc = Counter(\"no means no and no\".split())\nfor word, count in c.most_common(2):\n    print(word, count)",
                "no 3\nmeans 1",
                "The pairs from most_common() are easy to unpack in a loop.",
            ),
            fill(
                "Print only the single most common word and its count.",
                "from collections import Counter\nc = Counter(\"x y x\".split())\nprint(c.most_common(____))",
                listOf("1", "0", "3"),
                "1",
                "most_common(1) returns a list with one pair, the most common one.",
            ),
            choice(
                "What does most_common() return with no argument?",
                listOf("All pairs from the most common", "Only the most common pair", "The dictionary unchanged", "An empty list"),
                0,
                "With no argument we get a list of all the pairs, sorted from the most common.",
            ),
            output(
                "STOP = {\"and\", \"in\", \"a\"}\nwords = \"cat and dog in house\".split()\nkept = [w for w in words if w not in STOP]\nprint(kept)",
                "['cat', 'dog', 'house']",
                "We drop unimportant words (stop words) before counting.",
            ),
            output(
                "from collections import Counter\nc = Counter(\"b a b a c\".split())\nkey = lambda p: (-p[1], p[0])\npairs = sorted(c.items(), key=key)\nprint(pairs[0])",
                "('a', 2)",
                "We sort by count in descending order, and alphabetically when there is a tie.",
            ),
            tiles(
                "Keep only the words that have at least 3 letters",
                listOf("long_words", "=", "[w for w in words", "if", "len(w) >= 3]"),
                listOf("while", "len(w) < 3]"),
                "The if condition in a list comprehension filters the words.",
            ),
            output(
                "from collections import Counter\nc = Counter(\"x y x z x y\".split())\nprint(c.most_common()[-1])",
                "('z', 1)",
                "The last element of most_common() is the rarest word.",
            ),
        ),
        lesson(
            "u68l4", "Step 4: average word length",
            output(
                "words = [\"cat\", \"is\", \"cute\"]\nlengths = [len(w) for w in words]\nprint(lengths, sum(lengths))",
                "[3, 2, 4] 9",
                "First we collect the word lengths, then we add them up.",
            ),
            output(
                "words = [\"cat\", \"is\", \"cute\", \"now\"]\ntotal = sum(len(w) for w in words)\nprint(total / len(words))",
                "3.0",
                "The average is the sum of the lengths divided by the number of words: 12 / 4.",
            ),
            fill(
                "Round the average to two decimal places.",
                "average = 10 / 3\nprint(round(average, ____))",
                listOf("2", "0", "20"),
                "2",
                "The second argument of round() is the number of decimal places.",
            ),
            output(
                "words = [\"cat\", \"is\", \"happy\"]\nprint(max(words, key=len))\nprint(min(words, key=len))",
                "happy\nis",
                "key=len tells Python to compare the words by length.",
            ),
            choice(
                "What happens if we compute the average for an empty text without checking?",
                listOf("ZeroDivisionError", "The result is 0.0", "The result is None", "IndexError"),
                0,
                "For an empty list we divide by len([]), which is 0, so we need to check for that first.",
            ),
            output(
                "from statistics import mean\nprint(mean([3, 2, 4, 3]))",
                "3",
                "statistics.mean() computes the average for us.",
            ),
            tiles(
                "Compute the average length of the words in the list words",
                listOf("avg", "=", "sum(map(len, words))", "/", "len(words)"),
                listOf("*", "max(words)"),
                "map(len, words) gives the lengths, and we divide by the number of words.",
            ),
            output(
                "words = \"a b a c\".split()\nprint(len(words), len(set(words)))",
                "4 3",
                "set() removes duplicates, so it gives the number of different words.",
            ),
        ),
        lesson(
            "u68l5", "Project: analysis report",
            output(
                "avg = 3.14159\nprint(f\"Average: {avg:.2f}\")",
                "Average: 3.14",
                ":.2f prints the number with two decimal places.",
            ),
            output(
                "from collections import Counter\ndef report(text):\n    words = text.lower().split()\n    c = Counter(words)\n    print(\"Words:\", len(words))\n    print(\"Unique:\", len(c))\n    print(\"Top:\", c.most_common(1)[0][0])\n\nreport(\"Cat and dog and cat CAT\")",
                "Words: 6\nUnique: 3\nTop: cat",
                "The report combines all the previous steps: cleaning, counting and picking the most common word.",
            ),
            output(
                "from collections import Counter\nc = Counter(\"a b a c a b\".split())\nfor w, n in c.most_common(2):\n    print(f\"{w}: {'#' * n}\")",
                "a: ###\nb: ##",
                "Multiplying a string by a number draws a simple bar chart.",
            ),
            fill(
                "Print the words from the most common to the rarest.",
                "from collections import Counter\nc = Counter(\"b a a\".split())\nfor w, n in c.____():\n    print(w, n)",
                listOf("most_common", "items", "values"),
                "most_common",
                "items() keeps the insertion order, while most_common() sorts by count.",
            ),
            choice(
                "What is a good order for the analyzer's steps?",
                listOf("cleaning → splitting into words → counting → report", "counting → cleaning → report → splitting into words", "report → counting → cleaning → splitting into words", "splitting into words → report → cleaning → counting"),
                0,
                "First we prepare the data, then we count, and at the end we present the result.",
            ),
            output(
                "from collections import Counter\nt = \"cat dog cat fish cat dog\"\nc = Counter(t.split())\ntop = [w for w, _ in c.most_common(3)]\nprint(\", \".join(top))",
                "cat, dog, fish",
                "join() glues the words into one readable string.",
            ),
            tiles(
                "Write the header of a loop over the three most common words in the counter c",
                listOf("for", "word, count", "in", "c.most_common(3):"),
                listOf("c.items(3):", "while"),
                "most_common(3) returns three pairs, which we unpack into word and count.",
            ),
            output(
                "from string import punctuation as P\nfrom collections import Counter\nt = \"You hear me. I hear you!\"\nremove = str.maketrans(\"\", \"\", P)\nwords = t.translate(remove).lower().split()\nc = Counter(words)\nprint(len(words), c[\"hear\"])\navg = sum(map(len, words)) / len(words)\nprint(round(avg, 2))",
                "6 2\n2.83",
                "The whole analyzer in a few lines: cleaning, counting and average length.",
            ),
        ),
    ),
)
