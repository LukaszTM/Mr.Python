package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*
import com.mrpython.app.domain.CourseUnit

internal val module22 = CourseUnit(
    id = "u22",
    title = "enumerate, zip and iteration",
    description = "Handy loops: numbering, pairing and ordering",
    lessons = listOf(
        lesson(
            "u22l1", "enumerate",
            output(
                "for i, x in enumerate([\"a\", \"b\"]):\n    print(i, x)",
                "0 a\n1 b",
                "enumerate gives you the index and the item, counting from 0.",
            ),
            output(
                "for i, x in enumerate([\"a\", \"b\"], start=1):\n    print(i, x)",
                "1 a\n2 b",
                "start=1 starts the numbering at 1.",
            ),
            choice(
                "What does enumerate give you for each item?",
                listOf("A pair (index, item)", "Just the index", "Just the item", "The length of the list"),
                0,
                "That's why we write two variables in the loop: i, x.",
            ),
            fill(
                "Fill in the blank to number from 1.",
                "for num, name in enumerate([\"Anna\", \"Emma\"], ____=1):\n    print(num, name)",
                listOf("start", "begin", "from"),
                "start",
                "The parameter is called start.",
            ),
            output("print(list(enumerate(\"ab\")))", "[(0, 'a'), (1, 'b')]", "enumerate creates tuples (index, item)."),
            tiles(
                "Loop over the list fruits together with the indexes.",
                listOf("for", "i, fruit", "in", "enumerate(fruits):"),
                listOf("range(fruits):", "zip(fruits):"),
                "for i, fruit in enumerate(fruits): gives you the index and the item.",
            ),
            output(
                "numbers = [5, 8, 3]\nfor i, x in enumerate(numbers):\n    if x == 8:\n        print(i)",
                "1",
                "8 sits at index 1.",
            ),
            choice(
                "Which form is handier than for i in range(len(items))?",
                listOf(
                    "for i, x in enumerate(items):",
                    "for i in items.index():",
                    "for x, i in items:",
                    "for i in len(items):",
                ),
                0,
                "enumerate gives you the index and the item right away.",
            ),
        ),
        lesson(
            "u22l2", "zip",
            output(
                "for a, b in zip([1, 2], [\"x\", \"y\"]):\n    print(a, b)",
                "1 x\n2 y",
                "zip joins items from the same positions into pairs.",
            ),
            output(
                "print(list(zip([1, 2, 3], [4, 5])))",
                "[(1, 4), (2, 5)]",
                "zip stops at the shortest list – 3 has no partner.",
            ),
            choice(
                "What does zip do when the lists have different lengths?",
                listOf(
                    "It stops at the shortest list",
                    "It raises an error",
                    "It fills the gaps with None",
                    "It repeats the shorter list",
                ),
                0,
                "The extra items of the longer list are skipped.",
            ),
            output(
                "names = [\"Anna\", \"Emma\"]\nages = [7, 9]\nprint(dict(zip(names, ages)))",
                "{'Anna': 7, 'Emma': 9}",
                "Pairs from zip are easy to turn into a dictionary.",
            ),
            fill(
                "Fill in the blank to join the items of two lists into pairs.",
                "for x, y in ____([1, 2], [3, 4]):\n    print(x + y)",
                listOf("zip", "enumerate", "range"),
                "zip",
                "zip joins several sequences into pairs.",
            ),
            output(
                "a = [1, 2, 3]\nb = [10, 20, 30]\nprint([x + y for x, y in zip(a, b)])",
                "[11, 22, 33]",
                "We add the items from the same positions.",
            ),
            tiles(
                "Create a dictionary d from the lists keys and values.",
                listOf("d =", "dict(", "zip(keys, values)", ")"),
                listOf("list(", "zip(values, keys)"),
                "dict(zip(keys, values)) – keys go first.",
            ),
            output(
                "for a, b, c in zip(\"ab\", \"cd\", \"ef\"):\n    print(a + b + c)",
                "ace\nbdf",
                "zip can join more than two sequences.",
            ),
        ),
        lesson(
            "u22l3", "reversed, sorted and sort",
            output("for x in reversed([1, 2, 3]):\n    print(x)", "3\n2\n1", "reversed goes from the end."),
            output("print(list(reversed(\"abc\")))", "['c', 'b', 'a']", "reversed works on strings too."),
            output(
                "a = [3, 1, 2]\nb = sorted(a)\nprint(a)\nprint(b)",
                "[3, 1, 2]\n[1, 2, 3]",
                "sorted returns a new list, the original stays unchanged.",
            ),
            output(
                "a = [3, 1, 2]\nresult = a.sort()\nprint(result)\nprint(a)",
                "None\n[1, 2, 3]",
                "sort() changes the list in place and returns None.",
            ),
            choice(
                "How is sorted(items) different from items.sort()?",
                listOf(
                    "sorted returns a new list, sort changes the list in place",
                    "sort returns a new list, sorted changes the list",
                    "sorted sorts in descending order",
                    "There is no difference",
                ),
                0,
                "sorted works on any sequence and doesn't change anything.",
            ),
            fill(
                "Fill in the blank to sort in descending order.",
                "print(sorted([2, 9, 4], reverse=____))",
                listOf("True", "False", "0"),
                "True",
                "reverse=True reverses the sort order.",
            ),
            output("print(sorted(\"cat\"))", "['a', 'c', 't']", "sorted on a string returns a list of sorted letters."),
            tiles(
                "Create a new list of words sorted by length.",
                listOf("result =", "sorted(", "words,", "key=len", ")"),
                listOf("words.sort(", "reverse=len"),
                "key=len sorts by length.",
            ),
        ),
        lesson(
            "u22l4", "any and all",
            output(
                "print(any([False, True, False]))\nprint(all([True, False]))",
                "True\nFalse",
                "any – at least one is true, all – every one is true.",
            ),
            output(
                "numbers = [2, 4, 6]\nprint(all([x % 2 == 0 for x in numbers]))",
                "True",
                "All the numbers are even.",
            ),
            choice(
                "What does any([]) return?",
                listOf("False", "True", "None", "An error"),
                0,
                "An empty list doesn't contain a single true value.",
            ),
            choice(
                "What does all([]) return?",
                listOf("True", "False", "None", "An error"),
                0,
                "An empty list contains no false value, so all gives True.",
            ),
            output(
                "words = [\"cat\", \"\", \"dog\"]\nprint(all(words))\nprint(any(words))",
                "False\nTrue",
                "An empty string is falsy, a non-empty one is truthy.",
            ),
            fill(
                "Fill in the blank to check whether there is ANY negative number.",
                "numbers = [3, -1, 5]\nprint(____([x < 0 for x in numbers]))",
                listOf("any", "all", "len"),
                "any",
                "any checks whether at least one condition is met.",
            ),
            output(
                "passwords = [\"abc\", \"abcdefgh\"]\nprint(any([len(p) >= 8 for p in passwords]))",
                "True",
                "The second password has 8 characters.",
            ),
            tiles(
                "Check whether all the grades are greater than 2.",
                listOf("all(", "[g > 2", "for g in grades]", ")"),
                listOf("any(", "[g < 2"),
                "all returns True only when every condition is true.",
            ),
        ),
        lesson(
            "u22l5", "Review: iteration",
            output(
                "for i, (a, b) in enumerate(zip(\"xy\", [1, 2])):\n    print(i, a, b)",
                "0 x 1\n1 y 2",
                "enumerate numbers the pairs from zip.",
            ),
            output(
                "print(list(zip(range(3), reversed(range(3)))))",
                "[(0, 2), (1, 1), (2, 0)]",
                "We pair increasing numbers with decreasing ones.",
            ),
            choice(
                "Which operation does NOT change the list and only returns a new result?",
                listOf("sorted(items)", "items.sort()", "items.reverse()", "items.append(1)"),
                0,
                "sorted creates a new list.",
            ),
            output(
                "points = [10, 30, 20]\nbest = max(points)\nfor num, p in enumerate(points, start=1):\n    if p == best:\n        print(num)",
                "2",
                "Player number 2 has the best score.",
            ),
            fill(
                "Fill in the blank to loop over the list from the end.",
                "for x in ____([1, 2, 3]):\n    print(x)",
                listOf("reversed", "sorted", "reverse"),
                "reversed",
                "reversed returns the items in reverse order.",
            ),
            output("print(all([1, 2, 3]), any([0, 0]))", "True False", "Non-zero numbers are truthy, zeros are falsy."),
            tiles(
                "Loop over the lists names and grades at the same time.",
                listOf("for", "name, grade", "in", "zip(names, grades):"),
                listOf("enumerate(names, grades):", "range(names):"),
                "zip joins two lists into pairs.",
            ),
            output(
                "a = [1, 2, 3, 4]\nb = [\"a\", \"b\"]\nprint(len(list(zip(a, b))))",
                "2",
                "zip stops at the shorter list.",
            ),
        ),
    ),
)
