package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*
import com.mrpython.app.domain.CourseUnit

internal val module3 = CourseUnit(
    id = "u3",
    title = "Operators and conditions",
    description = "Calculate, compare, and make decisions",
    lessons = listOf(
        lesson(
            "u3l1", "Math",
            output("print(7 // 2)", "3", "// is floor division: 7 / 2 = 3.5, and // rounds down to 3."),
            output("print(7 % 2)", "1", "% returns the remainder of a division."),
            output("print(2 ** 3)", "8", "** is exponentiation: 2 · 2 · 2."),
            choice(
                "What does this code print?",
                listOf("2", "2.5", "2.0", "3"),
                1,
                "Regular division with / always gives a float.",
                code = "print(10 / 4)",
            ),
            fill(
                "Calculate the remainder of dividing 10 by 3.",
                "print(10 ____ 3)",
                listOf("%", "//", "/"),
                "%",
                "The remainder operator is %.",
            ),
            output("print(2 + 3 * 4)", "14", "Multiplication comes before addition."),
            output("print((2 + 3) * 4)", "20", "Parentheses change the order of operations."),
            output("print(-7 // 2)", "-4", "// rounds down, so -3.5 gives -4."),
        ),
        lesson(
            "u3l2", "True and false",
            output("print(3 > 2)", "True", "A comparison returns a logical value: True or False."),
            choice(
                "Which operator checks whether two values are equal?",
                listOf("==", "=", "!=", "<="),
                0,
                "== compares, while a single = assigns.",
            ),
            output(
                "print(5 == 5 and 3 > 4)",
                "False",
                "and needs both conditions to be true – and 3 > 4 is false.",
            ),
            output("print(not False)", "True", "not flips a logical value."),
            tiles(
                "Write the condition: x is not equal to 0 (x on the left)",
                listOf("x", "!=", "0"),
                listOf("=", "=="),
                "The \"not equal to\" operator is !=.",
            ),
            output("print(10 != 10)", "False", "10 is equal to 10, so \"not equal\" is false."),
            output("print(3 < 5 or 2 > 9)", "True", "With or, it's enough for one condition to be true."),
            output("x = 4\nprint(1 < x < 5)", "True", "Python lets you chain comparisons: 1 < x and x < 5."),
        ),
        lesson(
            "u3l3", "The if statement",
            output(
                "x = 10\nif x > 5:\n    print(\"big\")\nelse:\n    print(\"small\")",
                "big",
                "The condition x > 5 is true, so the first block runs.",
            ),
            fill(
                "Fill in the missing character.",
                "x = 1\nif x > 0____\n    print(\"positive\")",
                listOf(":", ";", ","),
                ":",
                "A line with if ends with a colon.",
            ),
            choice(
                "How many spaces are usually used to indent a block in Python?",
                listOf("2", "4", "8", "Indentation doesn't matter"),
                1,
                "The PEP 8 standard recommends 4 spaces. Indentation is required in Python!",
            ),
            output(
                "t = 15\nif t > 25:\n    print(\"hot\")\nelif t > 10:\n    print(\"warm\")\nelse:\n    print(\"cold\")",
                "warm",
                "The first condition is false, the second (15 > 10) is true.",
            ),
            choice(
                "Which keyword means \"otherwise, if\"?",
                listOf("else if", "elif", "elseif", "otherwise"),
                1,
                "In Python we write elif.",
            ),
            output(
                "x = 0\nif x:\n    print(\"yes\")\nelse:\n    print(\"no\")",
                "no",
                "In a condition, 0 works like False.",
            ),
            output(
                "age = 18\nif age >= 18:\n    print(\"adult\")\nprint(\"end\")",
                "adult\nend",
                "The last line is not indented, so it always runs.",
            ),
        ),
        lesson(
            "u3l4", "Compound conditions",
            output("x = 7\nif x > 5 and x < 10:\n    print(\"middle\")", "middle", "Both conditions are true."),
            output(
                "day = \"Saturday\"\nif day == \"Saturday\" or day == \"Sunday\":\n    print(\"weekend\")\nelse:\n    print(\"work\")",
                "weekend",
                "It's enough for one of the or conditions to be met.",
            ),
            output(
                "x = 5\nif x > 0:\n    if x % 2 == 0:\n        print(\"even\")\n    else:\n        print(\"odd\")",
                "odd",
                "The inner if is checked only when the outer condition is true.",
            ),
            choice(
                "What does this code print?",
                listOf("B", "A", "C", "B and C"),
                0,
                "Only the first condition that is met runs.",
                code = "points = 75\nif points >= 90:\n    print(\"A\")\nelif points >= 70:\n    print(\"B\")\nelif points >= 50:\n    print(\"C\")",
            ),
            fill(
                "Fill in the blank to print \"negative\" for numbers less than zero.",
                "x = -3\nif x ____ 0:\n    print(\"negative\")",
                listOf("<", ">", "="),
                "<",
                "x < 0 means a negative number.",
            ),
            tiles(
                "Write the condition: age at least 13 and less than 18 (start with the lower limit)",
                listOf("age", ">=", "13", "and", "age", "<", "18"),
                listOf("or", "=>"),
                "and joins two conditions that both have to be met at the same time.",
            ),
            output("print(not (3 > 2))", "False", "3 > 2 is True, and not flips it to False."),
            output(
                "password = \"abc\"\nif len(password) < 8:\n    print(\"too short\")",
                "too short",
                "len() gives the length of the string: 3 < 8.",
            ),
        ),
        lesson(
            "u3l5", "Review: conditions",
            output("print(17 % 5)", "2", "17 = 3 · 5 + 2."),
            output("print(10 // 3 + 10 % 3)", "4", "10 // 3 = 3, and 10 % 3 = 1."),
            choice(
                "How do you check whether the number x is even?",
                listOf("x % 2 == 0", "x / 2 == 0", "x // 2 == 1", "x % 2 == 1"),
                0,
                "An even number divides by 2 with no remainder.",
            ),
            output("a = 3\nb = 8\nif a > b:\n    print(a)\nelse:\n    print(b)", "8", "This code prints the larger of two numbers."),
            output("print(True and not False)", "True", "not False is True, and True and True gives True."),
            output(
                "x = 12\nif x % 3 == 0 and x % 4 == 0:\n    print(\"divisible by 12\")\nelse:\n    print(\"no\")",
                "divisible by 12",
                "12 is divisible by both 3 and 4.",
            ),
            fill(
                "Fill in the missing keyword.",
                "t = 5\nif t > 20:\n    print(\"warm\")\n____:\n    print(\"cold\")",
                listOf("else", "elif", "otherwise"),
                "else",
                "else has no condition and ends with a colon.",
            ),
            output(
                "x = 15\nif x > 10:\n    print(\"A\")\nif x > 5:\n    print(\"B\")",
                "A\nB",
                "These are two separate ifs, so both are checked.",
            ),
        ),
    ),
)
