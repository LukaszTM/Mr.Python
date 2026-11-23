package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*
import com.mrpython.app.domain.CourseUnit

internal val module13 = CourseUnit(
    id = "u13",
    title = "List comprehensions",
    description = "Building lists, dictionaries and sets quickly",
    lessons = listOf(
        lesson(
            "u13l1", "Your first list comprehensions",
            output("print([x * 2 for x in range(4)])", "[0, 2, 4, 6]", "For each x from range(4), x * 2 goes into the list."),
            output("print([c.upper() for c in \"abc\"])", "['A', 'B', 'C']", "You can loop over the characters of a string and call methods on them."),
            choice(
                "Which list comprehension gives the same result as the loop?",
                listOf("[x + 1 for x in range(3)]", "[for x in range(3): x + 1]", "[x + 1 in range(3)]", "[x + 1 if x in range(3)]"),
                0,
                "The pattern is [expression for variable in collection].",
                code = "result = []\nfor x in range(3):\n    result.append(x + 1)",
            ),
            fill(
                "Complete the list comprehension.",
                "print([x * 10 ____ x in range(3)])",
                listOf("for", "in", "if"),
                "for",
                "A list comprehension has a for loop inside the brackets.",
            ),
            output(
                "words = [\"cat\", \"is\", \"here\"]\nprint([len(s) for s in words])",
                "[3, 2, 4]",
                "We compute the length of each word.",
            ),
            output(
                "def double(n):\n    return n * 2\n\nprint([double(x) for x in [1, 5]])",
                "[2, 10]",
                "You can call your own functions in a list comprehension.",
            ),
            tiles(
                "Create a list sq with the squares of the numbers 0 to 4",
                listOf("sq", "=", "[x * x", "for x in", "range(5)]"),
                listOf("in x for", "(x * x"),
                "[x * x for x in range(5)] squares every number.",
            ),
            choice(
                "What will this code print?",
                listOf("[3, 2, 1]", "[-3, 2, -1]", "[3, -2, 1]", "6"),
                0,
                "abs() returns the absolute value, that is, the number without the minus sign.",
                code = "print([abs(x) for x in [-3, 2, -1]])",
            ),
        ),
        lesson(
            "u13l2", "Conditions in list comprehensions",
            output("print([x for x in range(10) if x % 3 == 0])", "[0, 3, 6, 9]", "The if at the end lets through only numbers divisible by 3."),
            output(
                "pets = [\"cat\", \"bird\", \"fish\"]\nprint([s for s in pets if len(s) > 3])",
                "['bird', 'fish']",
                "Only words longer than 3 letters stay.",
            ),
            output("print([x * 2 for x in range(5) if x > 2])", "[6, 8]", "First the filter (3 and 4), then multiplying by 2."),
            fill(
                "Complete the code to keep only even numbers.",
                "print([x for x in range(6) ____ x % 2 == 0])",
                listOf("if", "for", "else"),
                "if",
                "The filtering condition goes after if at the end of the comprehension.",
            ),
            output(
                "print([\"Y\" if x > 1 else \"N\" for x in range(3)])",
                "['N', 'N', 'Y']",
                "a if condition else b picks one of two values for each element.",
            ),
            output("print([0 if x < 0 else x for x in [4, -2, 3]])", "[4, 0, 3]", "Negative numbers become 0, the rest stay as they are."),
            choice(
                "What does this expression do?",
                listOf("Replaces non-positive numbers with 0", "Removes negative numbers from the list", "Returns only positive numbers", "Causes a syntax error"),
                0,
                "if–else before for changes the value but removes nothing.",
                code = "[x if x > 0 else 0 for x in numbers]",
            ),
            tiles(
                "Pick the elements greater than 10 from the list numbers",
                listOf("big", "=", "[x for x in numbers", "if x > 10]"),
                listOf("if x < 10]", "else x]"),
                "The if filter at the end keeps only the matching elements.",
            ),
        ),
        lesson(
            "u13l3", "Nested list comprehensions",
            output("print([x * y for x in [1, 2] for y in [10, 20]])", "[10, 20, 20, 40]", "For each x we go through all the y values."),
            output("m = [[1, 2], [3, 4]]\nprint([x for row in m for x in row])", "[1, 2, 3, 4]", "Two fors flatten a list of lists."),
            output("print([[0] * 3 for _ in range(2)])", "[[0, 0, 0], [0, 0, 0]]", "Each pass creates a new row of three zeros."),
            output(
                "print([[i * j for j in range(3)]\n       for i in range(1, 3)])",
                "[[0, 1, 2], [0, 2, 4]]",
                "The inner comprehension creates one row for each i.",
            ),
            choice(
                "Which loop is the outer one in [x for row in m for x in row]?",
                listOf("for row in m", "for x in row", "Both run at the same time", "Neither"),
                0,
                "Read the loops from the left – the first one is the outer loop, just like in regular code.",
            ),
            fill(
                "Complete the code to flatten the list of lists.",
                "m = [[1], [2, 3]]\nprint([x for row in m for x in ____])",
                listOf("row", "m", "x"),
                "row",
                "The inner loop goes through the elements of the current row.",
            ),
            choice(
                "What will this code print?",
                listOf("[1, 3]", "[1, 2]", "[[1], [3]]", "[2, 4]"),
                0,
                "row[0] is the first element of each row.",
                code = "m = [[1, 2], [3, 4]]\nprint([row[0] for row in m])",
            ),
            tiles(
                "Create a 3×3 matrix m filled with zeros",
                listOf("m", "=", "[[0] * 3", "for _ in", "range(3)]"),
                listOf("[0] * 9", "for _ in range(9)]"),
                "Each of the 3 passes creates a new row [0, 0, 0].",
            ),
        ),
        lesson(
            "u13l4", "Dictionary and set comprehensions",
            output("print({x: x * x for x in range(3)})", "{0: 0, 1: 1, 2: 4}", "key: value inside curly braces creates a dictionary."),
            output(
                "words = [\"cat\", \"bird\"]\nprint({s: len(s) for s in words})",
                "{'cat': 3, 'bird': 4}",
                "The key is the word, the value is its length.",
            ),
            output("print({x % 3 for x in range(10)})", "{0, 1, 2}", "Curly braces without a colon create a set – duplicates disappear."),
            output(
                "prices = {\"a\": 2, \"b\": 5}\nprint({k: v * 2 for k, v in prices.items()})",
                "{'a': 4, 'b': 10}",
                "items() gives key–value pairs, which we transform.",
            ),
            choice(
                "What does the expression {x for x in data} create?",
                listOf("A set", "A dictionary", "A list", "A tuple"),
                0,
                "Curly braces without a colon mean a set.",
            ),
            fill(
                "Complete the code to create a dictionary.",
                "print({x____x * 10 for x in range(2)})",
                listOf(":", ",", "="),
                ":",
                "In a dictionary, a colon separates the key from the value.",
            ),
            choice(
                "What will this code print?",
                listOf("3", "6", "2", "Error"),
                0,
                "The word “banana” has only 3 different letters: b, a, n.",
                code = "print(len({c for c in \"banana\"}))",
            ),
            tiles(
                "Create a dictionary sq: number → its square for the numbers 1–3",
                listOf("sq", "=", "{n: n * n", "for n in", "range(1, 4)}"),
                listOf("[n: n * n", "range(1, 3)}"),
                "range(1, 4) gives 1, 2 and 3, and {n: n * n ...} creates a dictionary.",
            ),
        ),
        lesson(
            "u13l5", "Review: list comprehensions",
            output("print([x + 1 for x in range(3)])", "[1, 2, 3]", "Each number from range(3) increased by 1."),
            output(
                "print([c for c in \"a1b2\" if c in \"0123456789\"])",
                "['1', '2']",
                "Only the characters that are digits stay.",
            ),
            output("print(sum([x for x in range(5) if x % 2 == 1]))", "4", "The odd numbers are 1 and 3, and their sum is 4."),
            output(
                "print({s[0]: s for s in [\"amy\", \"bob\"]})",
                "{'a': 'amy', 'b': 'bob'}",
                "The key is the first letter, the value is the whole word.",
            ),
            choice(
                "Which expression creates a set?",
                listOf("{x for x in data}", "[x for x in data]", "{x: x for x in data}", "[{x} for x in data]"),
                0,
                "Curly braces without a colon mean a set.",
            ),
            fill(
                "Complete the code to turn the numbers into strings.",
                "print([____(x) for x in [1, 2]])",
                listOf("str", "int", "len"),
                "str",
                "str() turns a number into a string, so the result is ['1', '2'].",
            ),
            choice(
                "What will this code print?",
                listOf("3", "2", "[1, 2, 3]", "Error"),
                0,
                "The flattened list is [1, 2, 3], and it has 3 elements.",
                code = "m = [[1, 2], [3]]\nprint(len([x for row in m for x in row]))",
            ),
            tiles(
                "From the list words, pick the ones that start with “a”",
                listOf("a_words", "=", "[s for s in words", "if s[0] == \"a\"]"),
                listOf("if s == \"a\"]", "for s]"),
                "s[0] is the first letter of the word.",
            ),
        ),
    ),
)
