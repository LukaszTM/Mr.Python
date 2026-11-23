package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

internal val module52Intro = lesson(
    "u52l0", "Introduction: testing",
    explain(
        "The assert statement",
        "`assert condition` checks whether the condition is true. If it is, nothing happens; " +
            "if not, Python raises an `AssertionError`. You can add a message after a comma. " +
            "Don't wrap the whole thing in parentheses!",
        code = "assert 2 + 2 == 4\ntry:\n    assert 1 > 2, \"error!\"\nexcept AssertionError as e:\n    print(e)",
        output = "error!",
    ),
    explain(
        "Test functions",
        "A test is code that checks other code. We put tests in functions whose names start " +
            "with `test_`: they call the code with specific input and compare the result with the expected one.",
        code = "def test_max():\n    assert max([3, 7]) == 7\n    assert max([-5, -2]) == -2\n    print(\"test OK\")\n\ntest_max()",
        output = "test OK",
    ),
    explain(
        "Edge cases",
        "Most bugs hide in extreme inputs: an empty list, zero, negative numbers. " +
            "A good test checks not only an ordinary example but also cases like these.",
        code = "def average(x):\n    if not x:\n        return 0\n    return sum(x) / len(x)\n\nprint(average([2, 4]), average([]))",
        output = "3.0 0",
    ),
    explain(
        "The unittest module",
        "Larger projects use the `unittest` module. Tests are methods of a class that inherits from " +
            "`unittest.TestCase`, their names start with `test`, and the result is checked with, for example, " +
            "`self.assertEqual(a, b)`.",
        code = "import unittest\n\nclass TestMath(unittest.TestCase):\n    def test_addition(self):\n        self.assertEqual(2 + 2, 4)",
    ),
    explain(
        "More assertions",
        "`TestCase` also has `assertTrue`, `assertIn` and `assertRaises` (checks whether code raises an error). " +
            "When something doesn't match, you get a clear description of the difference.",
        code = "import unittest\n\nt = unittest.TestCase()\ntry:\n    t.assertEqual(2 * 3, 5)\nexcept AssertionError as e:\n    print(e)",
        output = "6 != 5",
    ),
    output(
        "assert 3 * 3 == 9\nprint(\"onward\")",
        "onward",
        "The condition is true, so the program keeps running.",
    ),
    choice(
        "Which edge case is worth testing for a function that returns the first element of a list?",
        listOf("An empty list", "The list [1, 2, 3]", "The list [4, 5, 6]"),
        0,
        "An empty list has no first element – it's an extreme case.",
    ),
    tiles(
        "Check that the length of the string \"abc\" is 3 (the checked result first, then the expected value).",
        listOf("assert", "len(\"abc\")", "==", "3"),
        listOf("=", "if"),
        "assert with an == comparison checks the expected result.",
    ),
)
