package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

internal val module52Cards = listOf(
    cards(
        "u52l1",
        explain(
            "assert and truthiness",
            "`assert` accepts any value, not just a comparison. An empty list, 0 and an empty string are " +
                "falsy, so `assert items` fails for an empty list. Without a message, the exception's text is empty.",
            code = "try:\n    assert [], \"empty list\"\nexcept AssertionError as e:\n    print(e)",
            output = "empty list",
        ),
        explain(
            "The parentheses trap",
            "`assert(x > 0, \"text\")` is an assert on a two-element tuple. A non-empty tuple is always " +
                "truthy, so a test like this can never fail. Write it without parentheses: `assert x > 0, \"text\"`.",
            code = "x = -5\nprint(bool((x > 0, \"negative\")))",
            output = "True",
        ),
    ),
    cards(
        "u52l2",
        explain(
            "A table of cases",
            "Instead of writing many similar assertions, store the cases as a list of tuples (input, expected " +
                "result) and check them in a loop. Adding a new test is just one new entry.",
            code = "cases = [(2, 4), (3, 9), (0, 0)]\nfor n, ok in cases:\n    assert n * n == ok\nprint(\"all OK\")",
            output = "all OK",
        ),
        explain(
            "Counting passed tests",
            "`True` counts as 1 and `False` as 0. That's why `sum()` of a list of comparison results tells you " +
                "how many tests passed, and `all()` tells you whether all of them did.",
            code = "tests = [1 + 1 == 2, 2 * 2 == 5, 9 // 3 == 3]\nprint(sum(tests), all(tests))",
            output = "2 False",
        ),
    ),
    cards(
        "u52l3",
        explain(
            "Test the boundaries",
            "Bugs often sit right at the boundary of a condition: `>` instead of `>=`. If the passing score is " +
                "50 points, check exactly 50, not just 30 and 80.",
            code = "def passed(p):\n    return p > 50\n\nprint(passed(80), passed(50))",
            output = "True False",
        ),
        explain(
            "The forgotten case",
            "When no `if` branch runs and there's no `return` at the end of the function, it returns `None`. " +
                "A test with the value 0 or an empty list will catch this quickly.",
            code = "def sign(n):\n    if n > 0:\n        return \"+\"\n    elif n < 0:\n        return \"-\"\nprint(sign(0))",
            output = "None",
        ),
    ),
    cards(
        "u52l4",
        explain(
            "assertRaises with with",
            "`with self.assertRaises(SomeError):` checks whether the code in the block raises that exception. " +
                "If the exception appears, the test passes; if not, the test fails with an `AssertionError`.",
            code = "import unittest\nt = unittest.TestCase()\nwith t.assertRaises(ZeroDivisionError):\n    1 / 0\nprint(\"error caught\")",
            output = "error caught",
        ),
        explain(
            "Two more assertions",
            "`assertFalse(x)` checks whether a value is falsy, and `assertNotEqual(a, b)` checks whether " +
                "the values are different. Every test method in a class has `self` as its first parameter.",
            code = "import unittest\nt = unittest.TestCase()\nt.assertFalse(2 > 5)\nt.assertNotEqual(2 + 2, 5)\nprint(\"OK\")",
            output = "OK",
        ),
        explain(
            "Running tests from code",
            "`TestLoader` collects the class's methods whose names start with `test`, and `run(r)` stores " +
                "the results in a `TestResult`: `testsRun` is the number of tests, `failures` is the list of " +
                "failures, and `wasSuccessful()` tells you whether everything passed.",
            code = "import unittest\nclass T(unittest.TestCase):\n    def test_a(self): self.assertEqual(1, 2)\nr = unittest.TestResult()\nunittest.TestLoader().loadTestsFromTestCase(T).run(r)\nprint(r.testsRun, len(r.failures), r.wasSuccessful())",
            output = "1 1 False",
        ),
    ),
    cards(
        "u52l5",
        explain(
            "TDD: test first",
            "In TDD (test-driven development) you first write a test that fails (red), then the simplest " +
                "code that makes it pass (green), and finally you clean up the code (refactor), " +
                "making sure the tests keep passing.",
            code = "def reverse(s):\n    return s[::-1]\n\nassert reverse(\"abc\") == \"cba\"\nprint(\"green\")",
            output = "green",
        ),
    ),
)
