package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*
import com.mrpython.app.domain.CourseUnit

internal val module52 = CourseUnit(
    id = "u52",
    title = "Testing",
    description = "assert, test functions, edge cases, and unittest",
    lessons = listOf(
        lesson(
            "u52l1", "assert and AssertionError",
            output(
                "assert 2 + 2 == 4\nprint(\"OK\")",
                "OK",
                "The condition is true, so assert does nothing and the program moves on.",
            ),
            choice(
                "What happens when the condition in an assert is false?",
                listOf("An AssertionError", "It prints False", "Nothing happens", "The function returns None"),
                0,
                "A false condition in an assert raises an AssertionError exception.",
            ),
            output(
                "try:\n    assert 1 > 2, \"error!\"\nexcept AssertionError as e:\n    print(e)",
                "error!",
                "The text after the comma becomes the exception's message.",
            ),
            fill(
                "Fill in the keyword that checks a condition.",
                "____ len(\"abc\") == 3\nprint(\"length OK\")",
                listOf("assert", "check", "test"),
                "assert",
                "assert is used to check conditions in code.",
            ),
            output(
                "items = []\ntry:\n    assert items, \"empty list\"\nexcept AssertionError as e:\n    print(e)",
                "empty list",
                "An empty list is falsy, so assert raises an error.",
            ),
            tiles(
                "Check that result is 10, with the message \"wrong result\".",
                listOf("assert", "result == 10", ",", "\"wrong result\""),
                listOf("if", ":"),
                "The syntax is: assert condition, message.",
            ),
            choice(
                "Why will this assert never raise an error?",
                listOf("Because the parentheses make a tuple", "Because x is negative", "Because the message is a string", "Because assert only works inside functions"),
                0,
                "assert (condition, text) checks a tuple, and a non-empty tuple is always truthy – don't put parentheses after assert.",
                code = "x = -5\nassert(x > 0, \"negative\")\nprint(\"passed\")",
            ),
            output(
                "def double(x):\n    return x * 2\n\nassert double(3) == 6\nassert double(0) == 0\nprint(\"tests OK\")",
                "tests OK",
                "Both conditions are true, so the program reaches print.",
            ),
        ),
        lesson(
            "u52l2", "Test functions",
            output(
                "def add(a, b):\n    return a + b\n\ndef test_add():\n    assert add(2, 3) == 5\n    print(\"test_add OK\")\n\ntest_add()",
                "test_add OK",
                "A test function calls the code and checks the result with assert.",
            ),
            choice(
                "How are test functions usually named?",
                listOf("They start with test_", "They end with _ok", "They start with check", "Any way you like, in capital letters"),
                0,
                "Testing tools look for functions whose names start with test.",
            ),
            output(
                "def square(x):\n    return x * 2\n\ntry:\n    assert square(2) == 4\n    assert square(3) == 9\n    print(\"OK\")\nexcept AssertionError:\n    print(\"FAIL\")",
                "FAIL",
                "For 2 the result happens to match, but square(3) gives 6 – the second test catches the bug.",
            ),
            fill(
                "Complete the test so that it raises an error when the result is wrong.",
                "def test_max():\n    ____ max([3, 7, 1]) == 7\n\ntest_max()\nprint(\"OK\")",
                listOf("assert", "assume", "verify"),
                "assert",
                "assert raises an AssertionError when the condition is false.",
            ),
            output(
                "def is_even(n):\n    return n % 2 == 0\n\ncases = [(2, True), (3, False), (0, True)]\nfor n, ok in cases:\n    assert is_even(n) == ok\nprint(\"all OK\")",
                "all OK",
                "A list of (input, expected result) pairs lets you check many cases in a loop.",
            ),
            tiles(
                "Check that the length of the string \"cat\" is 3 (the checked result first, then the expected value).",
                listOf("assert", "len(\"cat\")", "==", "3"),
                listOf("=", "return"),
                "assert with an == comparison checks the expected result.",
            ),
            output(
                "tests = [1 + 1 == 2, 3 * 3 == 6, 10 // 3 == 3]\nprint(sum(tests), \"/\", len(tests))",
                "2 / 3",
                "True counts as 1 – two of the three tests passed.",
            ),
            choice(
                "What should a good test contain?",
                listOf("Input and the expected result", "Random data with no checks", "Just a function call", "Printing the result to the screen"),
                0,
                "A test calls the code with specific input and compares the result with a value we know in advance.",
            ),
        ),
        lesson(
            "u52l3", "Edge cases",
            choice(
                "Which one is an edge case for a function that computes the average of a list?",
                listOf("An empty list", "The list [1, 2, 3]", "The list [5, 5]", "The list [10, 20]"),
                0,
                "Edge cases are extreme inputs, such as an empty list, zero, or negative numbers.",
            ),
            output(
                "def average(numbers):\n    return sum(numbers) / len(numbers)\n\ntry:\n    print(average([]))\nexcept ZeroDivisionError:\n    print(\"empty list!\")",
                "empty list!",
                "len([]) is 0, so we divide by zero.",
            ),
            fill(
                "Fill in the condition so that the function handles an empty list.",
                "def average(numbers):\n    if ____:\n        return 0\n    return sum(numbers) / len(numbers)\n\nprint(average([]))",
                listOf("not numbers", "numbers", "len(numbers) > 0"),
                "not numbers",
                "not numbers is true for an empty list.",
            ),
            output(
                "def largest(items):\n    result = 0\n    for x in items:\n        if x > result:\n            result = x\n    return result\n\nprint(largest([3, 5]))\nprint(largest([-3, -5]))",
                "5\n0",
                "Starting from 0 breaks the result when all numbers are negative – a test with negatives catches it.",
            ),
            choice(
                "How do you fix the largest function from the previous exercise?",
                listOf("Start with result = items[0]", "Start with result = 1", "Change > to <", "Remove the return"),
                0,
                "The first element of the list is a good starting point (an empty list then has to be handled separately).",
            ),
            output(
                "def sign(n):\n    if n > 0:\n        return \"+\"\n    elif n < 0:\n        return \"-\"\n\nprint(sign(5), sign(-2), sign(0))",
                "+ - None",
                "Zero was forgotten – the function returns nothing, so the result is None.",
            ),
            tiles(
                "Write a test: the factorial of zero should be 1 (the checked result first, then the expected value).",
                listOf("assert", "factorial(0)", "==", "1"),
                listOf("=", "return"),
                "Zero is a classic edge case for factorial.",
            ),
            choice(
                "Which inputs are best to test for the function divide(a, b)?",
                listOf("Various, including b = 0", "Only 10 and 2", "Only large numbers", "Any single example"),
                0,
                "Good tests cover both ordinary cases and edge cases: b = 0, negative numbers, and ordinary numbers.",
            ),
        ),
        lesson(
            "u52l4", "unittest – the basics",
            choice(
                "Which class does a test class inherit from in the unittest module?",
                listOf("unittest.TestCase", "unittest.Test", "object.Test", "unittest.Assert"),
                0,
                "Tests in unittest are methods of a class that inherits from TestCase.",
            ),
            fill(
                "Fill in the name of the base class.",
                "import unittest\n\nclass TestMath(unittest.____):\n    def test_addition(self):\n        self.assertEqual(2 + 2, 4)\n\nprint(\"defined\")",
                listOf("TestCase", "Tests", "Case"),
                "TestCase",
                "A test class inherits from unittest.TestCase.",
            ),
            choice(
                "How must a method's name start for unittest to treat it as a test?",
                listOf("test", "check", "self", "run"),
                0,
                "unittest runs the methods whose names start with test.",
            ),
            tiles(
                "Inside a test method, check that add(2, 2) gives 4 (the checked result first, then the expected value).",
                listOf("self.assertEqual(", "add(2, 2)", ",", "4", ")"),
                listOf("assertTrue(", "="),
                "assertEqual(a, b) checks whether a == b.",
            ),
            output(
                "import unittest\n\nt = unittest.TestCase()\ntry:\n    t.assertEqual(1 + 1, 3)\nexcept AssertionError as e:\n    print(e)",
                "2 != 3",
                "When the values don't match, assertEqual raises an AssertionError with a clear description.",
            ),
            output(
                "import unittest\n\nt = unittest.TestCase()\nt.assertTrue(5 > 3)\nt.assertIn(\"o\", \"cat and dog\")\nprint(\"passed\")",
                "passed",
                "Both checks pass, so there is no exception.",
            ),
            choice(
                "Which TestCase method checks whether code raises an exception?",
                listOf("assertRaises", "assertError", "assertFalse", "assertException"),
                0,
                "with self.assertRaises(SomeError): checks that the error occurs.",
            ),
            output(
                "import unittest\n\nclass T(unittest.TestCase):\n    def test_ok(self):\n        self.assertEqual(len(\"ab\"), 2)\n    def test_bad(self):\n        self.assertIn(\"x\", \"abc\")\n\nr = unittest.TestResult()\nunittest.TestLoader().loadTestsFromTestCase(T).run(r)\nprint(r.testsRun, len(r.failures))",
                "2 1",
                "2 tests were run, and one failed (there is no \"x\" in \"abc\").",
            ),
        ),
        lesson(
            "u52l5", "Review: thinking in tests",
            choice(
                "What do you start with when working with TDD (test-driven development)?",
                listOf("Writing a test", "Writing the function", "Printing the results", "Deleting tests"),
                0,
                "In TDD the test comes first (it doesn't pass yet), and only then the code that satisfies it.",
            ),
            choice(
                "What is the order of steps in TDD?",
                listOf("Red → green → refactor", "Green → red → refactor", "Refactor → red → green", "Code → deploy → test"),
                0,
                "The test fails (red), you write the code (green), then you clean it up.",
            ),
            output(
                "def reverse(s):\n    return s[::-1]\n\nassert reverse(\"abc\") == \"cba\"\nassert reverse(\"\") == \"\"\nprint(\"green\")",
                "green",
                "The function passes both tests, including the one for an empty string.",
            ),
            fill(
                "Fill in the name of the method that compares two values.",
                "import unittest\n\nt = unittest.TestCase()\nt.____(2 * 2, 4)\nprint(\"OK\")",
                listOf("assertEqual", "assertEquals", "assertSame"),
                "assertEqual",
                "assertEqual is used to compare values.",
            ),
            output(
                "age = -3\ntry:\n    assert age >= 0, \"age < 0\"\nexcept AssertionError as e:\n    print(\"Test:\", e)",
                "Test: age < 0",
                "The condition is false, so we catch the AssertionError with its message.",
            ),
            tiles(
                "Write a test: the total of an empty list should be 0 (the checked result first, then the expected value).",
                listOf("assert", "total([])", "==", "0"),
                listOf("return", "!="),
                "An empty list is an important edge case.",
            ),
            output(
                "def first(items):\n    if not items:\n        return None\n    return items[0]\n\nprint(first([7, 8]), first([]))",
                "7 None",
                "The function handles an empty list instead of raising an IndexError.",
            ),
            choice(
                "Which assert raises an error?",
                listOf("The second", "The first", "Neither", "Both"),
                0,
                "\"abc\".upper() is \"ABC\", but the length of an empty list is 0, not 1.",
                code = "assert \"abc\".upper() == \"ABC\"\nassert len([]) == 1\nprint(\"done\")",
            ),
        ),
    ),
)
