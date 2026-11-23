package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*
import com.mrpython.app.domain.CourseUnit

internal val module17 = CourseUnit(
    id = "u17",
    title = "Recursion",
    description = "Functions that call themselves",
    lessons = listOf(
        lesson(
            "u17l1", "The idea of recursion",
            output(
                "def countdown(n):\n    if n == 0:\n        print(\"Go!\")\n        return\n    print(n)\n    countdown(n - 1)\n\ncountdown(2)",
                "2\n1\nGo!",
                "The function calls itself with a smaller n until it reaches 0.",
            ),
            choice(
                "What is the base case in recursion?",
                listOf(
                    "The case where the function ends without calling itself",
                    "A break statement in a loop",
                    "The first call of the function",
                    "An error that stops the program",
                ),
                0,
                "Without a base case the function would call itself forever.",
            ),
            choice(
                "What happens when you run this?",
                listOf("A RecursionError", "It prints 0", "The program returns 3", "Nothing, the function ends"),
                0,
                "There is no base case – there are too many calls and Python stops the program.",
                code = "def f(n):\n    return f(n - 1)\n\nf(3)",
            ),
            output(
                "def factorial(n):\n    if n <= 1:\n        return 1\n    return n * factorial(n - 1)\n\nprint(factorial(4))",
                "24",
                "factorial(4) = 4 * 3 * 2 * 1 = 24.",
            ),
            output(
                "def f(n):\n    if n == 0:\n        return\n    f(n - 1)\n    print(n)\n\nf(3)",
                "1\n2\n3",
                "print runs after the call returns, so the numbers come out in ascending order.",
            ),
            fill(
                "Fill in the base case so factorial(3) gives 6.",
                "def factorial(n):\n    if n ____ 1:\n        return 1\n    return n * factorial(n - 1)\n\nprint(factorial(3))",
                listOf("<=", ">=", "!="),
                "<=",
                "The recursion ends when n drops to 1.",
            ),
            output(
                "def total(n):\n    if n == 0:\n        return 0\n    return n + total(n - 1)\n\nprint(total(4))",
                "10",
                "total(4) = 4 + 3 + 2 + 1 + 0 = 10.",
            ),
            tiles(
                "Store in result the product of n and the factorial of n - 1",
                listOf("result", "=", "n *", "factorial(n - 1)"),
                listOf("factorial(n)", "+"),
                "The recursive step of the factorial is n * factorial(n - 1).",
            ),
        ),
        lesson(
            "u17l2", "Powers, digits and Fibonacci",
            output(
                "def fib(n):\n    if n < 2:\n        return n\n    return fib(n - 1) + fib(n - 2)\n\nprint(fib(6))",
                "8",
                "The Fibonacci sequence: 0, 1, 1, 2, 3, 5, 8.",
            ),
            output(
                "def fib(n):\n    if n < 2:\n        return n\n    return fib(n - 1) + fib(n - 2)\n\nprint([fib(i) for i in range(6)])",
                "[0, 1, 1, 2, 3, 5]",
                "Every term is the sum of the two before it.",
            ),
            choice(
                "Why is the recursive fib(35) very slow to compute?",
                listOf(
                    "The same values are computed many times",
                    "Python can't add large numbers",
                    "The base case is missing",
                    "Recursion is always slow",
                ),
                0,
                "fib(n) calls fib(n - 1) and fib(n - 2), which repeat the same calculations.",
            ),
            output(
                "def power(a, n):\n    if n == 0:\n        return 1\n    return a * power(a, n - 1)\n\nprint(power(2, 5))",
                "32",
                "2 multiplied 5 times gives 32.",
            ),
            choice(
                "What will this code print?",
                listOf("10", "1234", "4", "24"),
                0,
                "The function adds up the digits: 4 + 3 + 2 + 1 = 10.",
                code = "def digits(n):\n    if n < 10:\n        return n\n    return n % 10 + digits(n // 10)\n\nprint(digits(1234))",
            ),
            fill(
                "Fill in the blank so the function computes the sum 1 + 2 + … + n.",
                "def total(n):\n    if n == 0:\n        return 0\n    return n + total(____)\n\nprint(total(3))",
                listOf("n - 1", "n", "n + 1"),
                "n - 1",
                "Every call has to get closer to the base case n == 0.",
            ),
            output(
                "def f(n):\n    print(n)\n    if n > 1:\n        f(n // 2)\n\nf(8)",
                "8\n4\n2\n1",
                "Every call divides n by 2 until n reaches 1.",
            ),
            tiles(
                "Store in result the recursive step of the Fibonacci sequence",
                listOf("result", "=", "fib(n - 1)", "+", "fib(n - 2)"),
                listOf("*", "fib(n)"),
                "A term of the sequence is the sum of the two previous terms.",
            ),
        ),
        lesson(
            "u17l3", "Recursion on strings and lists",
            output(
                "def reverse(s):\n    if s == \"\":\n        return \"\"\n    return reverse(s[1:]) + s[0]\n\nprint(reverse(\"cat\"))",
                "tac",
                "The first character goes to the end of the reversed rest.",
            ),
            output(
                "def total(items):\n    if not items:\n        return 0\n    return items[0] + total(items[1:])\n\nprint(total([2, 4, 6]))",
                "12",
                "The first element plus the sum of the rest of the list.",
            ),
            output(
                "def pal(s):\n    if len(s) < 2:\n        return True\n    if s[0] != s[-1]:\n        return False\n    return pal(s[1:-1])\n\nprint(pal(\"kayak\"), pal(\"cat\"))",
                "True False",
                "We compare the outer characters and check the middle of the string.",
            ),
            choice(
                "What will this code print?",
                listOf("3", "0", "24", "Error"),
                0,
                "Every call adds 1 and shortens the list by one element.",
                code = "def length(items):\n    if items == []:\n        return 0\n    return 1 + length(items[1:])\n\nprint(length([7, 8, 9]))",
            ),
            choice(
                "Why do we use s[1:] in recursion on strings?",
                listOf(
                    "To make the problem smaller – we take the string without its first character",
                    "To reverse the string",
                    "To copy the whole string",
                    "To remove the last character",
                ),
                0,
                "Every call gets a shorter string until it reaches the empty one.",
            ),
            fill(
                "Fill in the blank so the function counts the letters \"a\".",
                "def count_a(s):\n    if s == \"\":\n        return 0\n    found = 1 if s[0] == \"a\" else 0\n    return found + count_a(____)\n\nprint(count_a(\"banana\"))",
                listOf("s[1:]", "s", "s[0]"),
                "s[1:]",
                "We call the function for the rest of the string, without the first character.",
            ),
            output(
                "def biggest(l):\n    if len(l) == 1:\n        return l[0]\n    m = biggest(l[1:])\n    return l[0] if l[0] > m else m\n\nprint(biggest([3, 8, 2]))",
                "8",
                "We compare the first element with the largest element of the rest.",
            ),
            tiles(
                "Store in result the reversed rest of the string with the first character appended",
                listOf("result", "=", "reverse(s[1:])", "+", "s[0]"),
                listOf("s[1:]", "reverse(s)"),
                "We reverse the rest of the string and add the first character at the end.",
            ),
        ),
        lesson(
            "u17l4", "Recursion depth and loops",
            choice(
                "When does Python raise a RecursionError?",
                listOf(
                    "When there are too many nested calls",
                    "When a function returns nothing",
                    "When a function has too many parameters",
                    "When a loop runs for too long",
                ),
                0,
                "Python has a recursion depth limit that protects the program from hanging.",
            ),
            choice(
                "What is the default recursion depth limit in Python?",
                listOf("About 1000", "10", "There is no limit", "About a million"),
                0,
                "By default Python allows about 1000 nested calls.",
            ),
            output(
                "def f(n):\n    return f(n + 1)\n\ntry:\n    f(0)\nexcept RecursionError:\n    print(\"too deep\")",
                "too deep",
                "A RecursionError can be caught like any other exception.",
            ),
            output("result = 1\nfor i in range(1, 5):\n    result *= i\nprint(result)", "24", "A factorial can also be computed with a regular loop."),
            choice(
                "When is it better to use a loop instead of recursion?",
                listOf(
                    "When the number of steps can be very large, e.g. 100,000",
                    "When the data is a short string",
                    "Never – recursion is always better",
                    "When the function has a base case",
                ),
                0,
                "Deep recursion will exceed the limit, while a loop has no such restriction.",
            ),
            output(
                "a, b = 0, 1\nfor _ in range(6):\n    a, b = b, a + b\nprint(a)",
                "8",
                "The loop computes fib(6) quickly, without repeating calculations.",
            ),
            fill(
                "Fill in the blank so the loop computes 1 + 2 + 3 + 4.",
                "result = 0\nfor i in range(____):\n    result += i\nprint(result)",
                listOf("5", "4", "1, 4"),
                "5",
                "range(5) gives 0–4, and their sum is 10.",
            ),
            output(
                "def depth(n):\n    if n == 0:\n        return 1\n    return 1 + depth(n - 1)\n\nprint(depth(5))",
                "6",
                "Calls for n = 5, 4, 3, 2, 1, 0 – 6 in total.",
            ),
        ),
        lesson(
            "u17l5", "Review: recursion",
            output(
                "def f(n):\n    if n <= 0:\n        return 0\n    return 2 + f(n - 1)\n\nprint(f(3))",
                "6",
                "Three calls add 2 each.",
            ),
            output(
                "def p(s):\n    if not s:\n        return\n    print(s)\n    p(s[1:])\n\np(\"abc\")",
                "abc\nbc\nc",
                "Every call prints the string and cuts off its first character.",
            ),
            choice(
                "What is missing in this function?",
                listOf("A base case", "A parameter", "A for loop", "Nothing, it's correct"),
                0,
                "Without a base case factorial calls itself forever.",
                code = "def factorial(n):\n    return n * factorial(n - 1)",
            ),
            output(
                "def count(n):\n    if n < 10:\n        return 1\n    return 1 + count(n // 10)\n\nprint(count(12345))",
                "5",
                "The function counts digits: every call cuts one off.",
            ),
            choice(
                "What will this code print?",
                listOf("24", "9", "0", "Error"),
                0,
                "2 * 3 * 4 * 1 = 24 – for an empty list we return 1.",
                code = "def product(items):\n    if not items:\n        return 1\n    return items[0] * product(items[1:])\n\nprint(product([2, 3, 4]))",
            ),
            fill(
                "Fill in the base case so the program prints 2 and 1.",
                "def count(n):\n    if n ____ 0:\n        return\n    print(n)\n    count(n - 1)\n\ncount(2)",
                listOf("==", "!=", ">"),
                "==",
                "The function should stop only when n reaches 0.",
            ),
            choice(
                "What usually computes the 30th term of the Fibonacci sequence faster?",
                listOf("A loop", "Simple recursion", "Both are equally fast", "Neither can do it"),
                0,
                "Simple recursion computes the same values many times.",
            ),
            tiles(
                "Store in result the sum of the first element and the total of the rest of the list",
                listOf("result", "=", "items[0]", "+", "total(items[1:])"),
                listOf("total(items)", "items[1:]"),
                "The recursive step: the first element plus the sum of the rest.",
            ),
        ),
    ),
)
