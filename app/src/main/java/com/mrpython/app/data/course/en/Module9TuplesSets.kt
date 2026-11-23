package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*
import com.mrpython.app.domain.CourseUnit

internal val module9 = CourseUnit(
    id = "u9",
    title = "Tuples and sets",
    description = "tuple, set, and unpacking",
    lessons = listOf(
        lesson(
            "u9l1", "Tuples",
            choice(
                "How is a tuple different from a list?",
                listOf("A tuple can't be changed", "A tuple can only hold numbers", "A tuple has no indexes", "It isn't"),
                0,
                "A tuple is immutable – once created, it can't be changed.",
            ),
            output("t = (1, 2, 3)\nprint(t[1])", "2", "Tuples are indexed just like lists."),
            output("t = (\"a\", \"b\")\nprint(len(t))", "2", "len() works on tuples too."),
            choice(
                "What will happen?",
                listOf("An error", "t will become (5, 2)", "t will become (5,)", "Nothing"),
                0,
                "A tuple is immutable, so t[0] = 5 ends in an error (a TypeError).",
                code = "t = (1, 2)\nt[0] = 5",
            ),
            output("point = (3, 4)\nx, y = point\nprint(x + y)", "7", "Unpacking assigns the elements to the variables in order."),
            output("t = (5,)\nprint(type(t))", "<class 'tuple'>", "A tuple with one element needs a comma."),
            output("print((1, 2) + (3,))", "(1, 2, 3)", "+ joins tuples into a new one."),
            output("a, b, c = \"xyz\"\nprint(b)", "y", "You can unpack a string too."),
        ),
        lesson(
            "u9l2", "Sets",
            output("s = {1, 2, 2, 3}\nprint(s)", "{1, 2, 3}", "A set stores only unique elements."),
            output("print(len(set([1, 1, 1, 2])))", "2", "set() removes duplicates."),
            output("s = {1, 2}\ns.add(3)\ns.add(2)\nprint(s)", "{1, 2, 3}", "add() adds an element, and a duplicate is ignored."),
            output("print(3 in {1, 2, 3})", "True", "in checks whether an element belongs to the set."),
            choice(
                "What will happen?",
                listOf("An error", "It prints 1", "It prints {1}", "It prints None"),
                0,
                "A set has no fixed order and no indexes, so s[0] ends in an error.",
                code = "s = {1, 2, 3}\nprint(s[0])",
            ),
            output("print(sorted({3, 1, 2}))", "[1, 2, 3]", "sorted() returns a sorted list."),
            fill(
                "Fill in the blank to count the distinct elements of the list.",
                "x = [1, 2, 2, 3]\nprint(len(____(x)))",
                listOf("set", "list", "tuple"),
                "set",
                "set() keeps only the unique elements: 1, 2, and 3.",
            ),
        ),
        lesson(
            "u9l3", "Set operations",
            output("a = {1, 2, 3}\nb = {2, 3, 4}\nprint(a & b)", "{2, 3}", "& is the intersection of the sets."),
            output("a = {1, 2}\nb = {2, 3}\nprint(a | b)", "{1, 2, 3}", "| is the union of the sets."),
            output("a = {1, 2, 3}\nb = {2}\nprint(a - b)", "{1, 3}", "- is the difference: elements of a that aren't in b."),
            output("a = {1, 2}\nb = {1, 2, 3}\nprint(a <= b)", "True", "<= checks whether a is a subset of b."),
            choice(
                "Which operator gives the elements two sets have in common?",
                listOf("&", "|", "-", "+"),
                0,
                "& is the intersection (the common part).",
            ),
            output(
                "amy_likes = {\"pizza\", \"ice cream\"}\nkate_likes = {\"ice cream\", \"sushi\"}\nprint(amy_likes & kate_likes)",
                "{'ice cream'}",
                "They both like ice cream.",
            ),
            tiles(
                "Store the intersection of sets a and b (a first) in the variable common",
                listOf("common", "=", "a", "&", "b"),
                listOf("|", "+"),
                "& gives the elements present in both sets.",
            ),
        ),
        lesson(
            "u9l4", "Review: tuples and sets",
            output(
                "def divide(a, b):\n    return a // b, a % b\n\nresult = divide(9, 4)\nprint(result)",
                "(2, 1)",
                "Several values after return make a tuple.",
            ),
            output("x, y = 1, 2\nprint((x, y)[::-1])", "(2, 1)", "Slices work on tuples too."),
            output("words = [\"a\", \"b\", \"a\", \"c\", \"b\"]\nprint(len(set(words)))", "3", "Only a, b, and c are distinct."),
            choice(
                "Which structure does NOT allow duplicates?",
                listOf("set", "list", "tuple", "str (string)"),
                0,
                "A set stores each element only once.",
            ),
            output("t = (3, 1, 2)\nprint(max(t), min(t))", "3 1", "max and min work on tuples."),
            output("a = {1, 2, 3}\na.remove(2)\nprint(a)", "{1, 3}", "remove() removes an element from a set."),
            fill(
                "Fill in the blank to create a tuple.",
                "t = ____1, 2, 3)\nprint(type(t))",
                listOf("(", "[", "{"),
                "(",
                "A tuple is written in parentheses.",
            ),
            output("for x, y in [(1, 2), (3, 4)]:\n    print(x * y)", "2\n12", "The loop unpacks each tuple into x and y."),
        ),
    ),
)
