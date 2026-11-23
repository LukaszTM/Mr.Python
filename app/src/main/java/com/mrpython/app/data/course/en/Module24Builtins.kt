package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*
import com.mrpython.app.domain.CourseUnit

internal val module24 = CourseUnit(
    id = "u24",
    title = "Built-in functions",
    description = "min, max, sum, round, isinstance and other handy functions",
    lessons = listOf(
        lesson(
            "u24l1", "min and max",
            output("print(min(4, 2, 8))\nprint(max([4, 2, 8]))", "2\n8", "min and max accept several arguments or a single list."),
            output(
                "words = [\"cat\", \"hippopotamus\", \"dog\"]\nprint(max(words, key=len))",
                "hippopotamus",
                "key=len compares the words by length.",
            ),
            output("print(max([], default=0))", "0", "default is the result for an empty list."),
            choice(
                "What happens after max([])?",
                listOf("ValueError", "It returns 0", "It returns None", "It returns []"),
                0,
                "An empty list has no largest item – without default you get an error.",
            ),
            fill(
                "Fill in the blank to find the shortest word.",
                "words = [\"apple\", \"fig\", \"banana\"]\nprint(min(words, ____=len))",
                listOf("key", "by", "sort"),
                "key",
                "The key parameter says what to compare by.",
            ),
            output("print(min(\"banana\"))", "a", "Letters are compared alphabetically – a is the smallest."),
            output(
                "people = [(\"Anna\", 30), (\"Bob\", 25)]\nprint(min(people, key=lambda p: p[1]))",
                "('Bob', 25)",
                "We compare the age, which is the second item of the tuple.",
            ),
            tiles(
                "Find the highest grade, or 0 when the list grades is empty.",
                listOf("max(", "grades,", "default=0", ")"),
                listOf("key=0", "min("),
                "default=0 protects you from an empty list.",
            ),
        ),
        lesson(
            "u24l2", "sum, abs, round, divmod and pow",
            output(
                "print(sum([1, 2, 3]))\nprint(sum([1, 2, 3], 10))",
                "6\n16",
                "The second argument of sum is the starting value.",
            ),
            output("print(abs(-7))\nprint(abs(3.5))", "7\n3.5", "abs returns the absolute value."),
            output("print(divmod(17, 5))", "(3, 2)", "divmod returns the whole quotient and the remainder: 17 = 3·5 + 2."),
            output(
                "print(round(3.14159, 2))\nprint(round(2.5))",
                "3.14\n2",
                "At an exact half, round picks the even number – hence 2.",
            ),
            choice(
                "What does pow(2, 3, 5) return?",
                listOf("3", "8", "1", "40"),
                0,
                "The third argument is the modulo: 2³ = 8, and 8 % 5 = 3.",
            ),
            fill(
                "Fill in the blank to get the quotient and the remainder at once.",
                "q, r = ____(20, 6)\nprint(q, r)",
                listOf("divmod", "pow", "round"),
                "divmod",
                "divmod(a, b) returns the pair (a // b, a % b).",
            ),
            choice(
                "What will print(round(7.5)) print?",
                listOf("8", "7", "7.5", "7.0"),
                0,
                "At an exact half, round picks the even number, which is 8.",
            ),
            output(
                "numbers = [-3, 1, -2]\nprint(sum(abs(x) for x in numbers))",
                "6",
                "We add up the absolute values: 3 + 1 + 2.",
            ),
        ),
        lesson(
            "u24l3", "isinstance and type",
            output(
                "print(isinstance(5, int))\nprint(isinstance(\"5\", int))",
                "True\nFalse",
                "\"5\" is a string, not a number.",
            ),
            output("print(type(3.0) == float)", "True", "3.0 is a float."),
            output("print(isinstance(True, int))", "True", "bool is a special kind of int."),
            choice(
                "What does isinstance(x, (int, float)) check?",
                listOf(
                    "Whether x is of type int or float",
                    "Whether x is a tuple",
                    "Whether x is both int and float at once",
                    "It converts x to a number",
                ),
                0,
                "A tuple of types means \"any one of them\".",
            ),
            fill(
                "Fill in the blank to check whether x is a string.",
                "x = \"abc\"\nprint(isinstance(x, ____))",
                listOf("str", "string", "text"),
                "str",
                "The string type in Python is str.",
            ),
            output(
                "data = [1, \"a\", 2.5, \"b\"]\nstrings = [d for d in data if isinstance(d, str)]\nprint(len(strings))",
                "2",
                "Only \"a\" and \"b\" are strings.",
            ),
            output(
                "def describe(x):\n    if isinstance(x, list):\n        return \"list\"\n    return \"something else\"\n\nprint(describe([1]))\nprint(describe((1,)))",
                "list\nsomething else",
                "(1,) is a tuple, not a list.",
            ),
            tiles(
                "Check whether value is an integer.",
                listOf("isinstance(", "value,", "int", ")"),
                listOf("type(", "str"),
                "isinstance(object, type) returns True or False.",
            ),
        ),
        lesson(
            "u24l4", "chr, ord, len and conversions",
            output("print(ord(\"A\"))\nprint(chr(66))", "65\nB", "ord gives the code of a character, chr – the character with a given code."),
            output("print(chr(ord(\"a\") + 1))", "b", "The code of the next letter is greater by 1."),
            output(
                "print(len(\"cat\"), len([1, 2]), len({\"a\": 1}))",
                "3 2 1",
                "len works on strings, lists and dictionaries.",
            ),
            choice(
                "What happens after len(5)?",
                listOf("TypeError", "It returns 1", "It returns 5", "It returns 0"),
                0,
                "A number has no length – that's a TypeError.",
            ),
            output(
                "print(int(\"42\") + 1)\nprint(str(42) + \"1\")",
                "43\n421",
                "int adds numbers, while str glues strings together.",
            ),
            output("print(int(3.9))\nprint(float(\"2.5\") * 2)", "3\n5.0", "int cuts off the fractional part, it doesn't round."),
            fill(
                "Fill in the blank to convert the string \"7\" to an integer.",
                "x = ____(\"7\")\nprint(x * 2)",
                listOf("int", "str", "len"),
                "int",
                "int(\"7\") gives the number 7, so the result is 14.",
            ),
            output(
                "print(list(\"ab\"), tuple([1, 2]))",
                "['a', 'b'] (1, 2)",
                "list and tuple convert one sequence into another.",
            ),
        ),
        lesson(
            "u24l5", "Review: built-in functions",
            output("print(max([3, -7, 5], key=abs))", "-7", "We compare absolute values – the largest is 7."),
            output("print(divmod(9, 4)[1])", "1", "divmod(9, 4) is (2, 1), and [1] is the remainder."),
            choice(
                "What does min([], default=None) return?",
                listOf("None", "0", "ValueError", "[]"),
                0,
                "For an empty list the default value is returned.",
            ),
            output("print(sum([0.5, 0.5], 1))", "2.0", "1 + 0.5 + 0.5 = 2.0."),
            fill(
                "Fill in the blank to print the code of the character \"a\".",
                "print(____(\"a\"))",
                listOf("ord", "chr", "int"),
                "ord",
                "ord returns the code of a character – for \"a\" it is 97.",
            ),
            output("print(bool(0), bool(\"0\"))", "False True", "Zero is falsy, but the non-empty string \"0\" is truthy."),
            tiles(
                "Print the letter with code 67.",
                listOf("print(", "chr(", "67", "))"),
                listOf("ord(", "str("),
                "chr turns a code into a character – 67 is C.",
            ),
            output(
                "values = [\"3\", 4, \"x\"]\ntotal = 0\nfor v in values:\n    if isinstance(v, int):\n        total += v\n    elif v.isdigit():\n        total += int(v)\nprint(total)",
                "7",
                "We count 4 and the string \"3\"; we skip \"x\".",
            ),
        ),
    ),
)
