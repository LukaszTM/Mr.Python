package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

import com.mrpython.app.domain.CourseUnit

internal val module59 = CourseUnit(
    id = "u59",
    title = "Challenges: medium",
    description = "Puzzles: list comprehensions, dictionaries, sorting, recursion, generators and classes",
    lessons = listOf(
        lesson(
            "u59l1", "Challenge 1: list comprehensions",
            output(
                "print([x * x for x in range(5) if x % 2])",
                "[1, 9]",
                "The condition x % 2 lets through only the odd numbers: 1 and 3.",
            ),
            output(
                "print([c for c in \"banana\" if c != \"a\"])",
                "['b', 'n', 'n']",
                "We drop all the letters “a”.",
            ),
            output(
                "print([(x, y) for x in range(2) for y in \"ab\"])",
                "[(0, 'a'), (0, 'b'), (1, 'a'), (1, 'b')]",
                "The first for loop is the outer one, the second is the inner one.",
            ),
            choice(
                "What does this code print?",
                listOf("['N', 'Y', 'Y']", "['Y', 'Y']", "['N', 'N', 'Y']", "Syntax error"),
                0,
                "if … else before for picks a value for each element.",
                code = "print([\"Y\" if x > 2 else \"N\" for x in [1, 3, 5]])",
            ),
            output(
                "m = [[1, 2], [3, 4]]\nprint([y for row in m for y in row])",
                "[1, 2, 3, 4]",
                "Two for loops flatten a list of lists.",
            ),
            choice(
                "Which version picks the even numbers from the list a?",
                listOf("[x for x in a if x % 2 == 0]", "[x if x % 2 == 0 for x in a]", "[for x in a if x % 2 == 0]", "[x for x in a while x % 2 == 0]"),
                0,
                "A filtering if goes at the end, after for.",
            ),
            fill(
                "Fill in the blank to print [3, 2, 4].",
                "words = [\"dog\", \"is\", \"here\"]\nprint([____ for w in words])",
                listOf("len(w)", "w", "len(words)"),
                "len(w)",
                "len(w) counts the length of each word separately.",
            ),
            tiles(
                "Create a list of the squares of the numbers from 0 to 3",
                listOf("squares =", "[x ** 2", "for x", "in range(4)]"),
                listOf("if x", "while x"),
                "A list comprehension: [expression for variable in sequence].",
            ),
        ),
        lesson(
            "u59l2", "Challenge 2: dictionaries",
            output(
                "d = {\"a\": 1}\nd[\"a\"] += 1\nd[\"b\"] = d.get(\"b\", 0) + 5\nprint(d)",
                "{'a': 2, 'b': 5}",
                "get() returns 0 for the missing key “b”.",
            ),
            output(
                "d = {\"x\": 1, \"y\": 2}\nprint({v: k for k, v in d.items()})",
                "{1: 'x', 2: 'y'}",
                "The dictionary comprehension swaps keys and values.",
            ),
            output(
                "d = {}\nfor c in \"abca\":\n    d[c] = d.get(c, 0) + 1\nprint(d)",
                "{'a': 2, 'b': 1, 'c': 1}",
                "Keys appear in the order they were first added.",
            ),
            choice(
                "What does this code print?",
                listOf("['a', 'b']", "[1, 2]", "[('a', 1), ('b', 2)]", "['a', 1, 'b', 2]"),
                0,
                "Iterating over a dictionary gives its keys.",
                code = "d = {\"a\": 1, \"b\": 2}\nprint(list(d))",
            ),
            output(
                "d = dict(zip(\"abc\", range(3)))\nprint(d[\"c\"])",
                "2",
                "zip pairs “c” with the number 2.",
            ),
            choice(
                "What does this code print?",
                listOf("None", "KeyError", "0", "b"),
                0,
                "For a missing key, get() returns None instead of raising an error.",
                code = "d = {\"a\": 1}\nprint(d.get(\"b\"))",
            ),
            fill(
                "Fill in the blank to print {'k': [1]}.",
                "d = {}\nd.____(\"k\", []).append(1)\nprint(d)",
                listOf("setdefault", "get", "pop"),
                "setdefault",
                "setdefault() inserts the default list into the dictionary and returns it.",
            ),
            tiles(
                "Write the header of a loop over the key–value pairs of the dictionary d",
                listOf("for", "k, v", "in", "d.items():"),
                listOf("d.keys():", "d.values():"),
                "items() returns (key, value) pairs.",
            ),
        ),
        lesson(
            "u59l3", "Challenge 3: sorting with key",
            output(
                "print(sorted([\"bb\", \"a\", \"ccc\"], key=len))",
                "['a', 'bb', 'ccc']",
                "key=len sorts by the length of the strings.",
            ),
            choice(
                "What does this code print?",
                listOf("[-1, 2, 3, -4]", "[-4, -1, 2, 3]", "[1, 2, 3, 4]", "[3, 2, -1, -4]"),
                0,
                "The absolute values are compared: 1, 2, 3, 4.",
                code = "print(sorted([3, -1, -4, 2], key=abs))",
            ),
            output(
                "print(sorted(\"Bac\"))",
                "['B', 'a', 'c']",
                "In Unicode, uppercase letters come before lowercase ones.",
            ),
            output(
                "print(sorted(\"Bac\", key=str.lower))",
                "['a', 'B', 'c']",
                "key=str.lower compares letters regardless of case.",
            ),
            output(
                "pairs = [(\"a\", 2), (\"b\", 1), (\"c\", 2)]\np = sorted(pairs, key=lambda p: p[1])\nprint([x[0] for x in p])",
                "['b', 'a', 'c']",
                "Sorting is stable: “a” and “c” keep their order.",
            ),
            choice(
                "What does this code print?",
                listOf("bear", "wolf", "cat", "Error"),
                0,
                "On a tie, max() returns the first of the largest elements.",
                code = "print(max([\"cat\", \"bear\", \"wolf\"], key=len))",
            ),
            fill(
                "Fill in the blank to sort in descending order.",
                "print(sorted([2, 3, 1], ____=True))",
                listOf("reverse", "key", "desc"),
                "reverse",
                "reverse=True reverses the sort order.",
            ),
            tiles(
                "Sort the list words by the last letter",
                listOf("result = sorted(words,", "key=lambda s:", "s[-1])"),
                listOf("s[0])", "reverse=lambda s:"),
                "key gets a function that returns the last letter of a word.",
            ),
        ),
        lesson(
            "u59l4", "Challenge 4: recursion",
            output(
                "def f(n):\n    return 1 if n == 0 else n * f(n - 1)\n\nprint(f(4))",
                "24",
                "It's a factorial: 4 * 3 * 2 * 1.",
            ),
            choice(
                "What does this code print?",
                listOf("10", "1234", "4", "24"),
                0,
                "The function adds up the digits: 1 + 2 + 3 + 4.",
                code = "def s(n):\n    if n < 10:\n        return n\n    return s(n // 10) + n % 10\n\nprint(s(1234))",
            ),
            output(
                "def f(s):\n    if not s:\n        return \"\"\n    return f(s[1:]) + s[0]\n\nprint(f(\"abc\"))",
                "cba",
                "The first letter goes to the end of the result – the string gets reversed.",
            ),
            output(
                "def f(n):\n    if n == 0:\n        return\n    print(n)\n    f(n - 1)\n\nf(3)",
                "3\n2\n1",
                "print comes before the recursive call, so the numbers go down.",
            ),
            output(
                "def f(n):\n    if n <= 1:\n        return n\n    return f(n - 1) + f(n - 2)\n\nprint(f(7))",
                "13",
                "It's the Fibonacci sequence: 0, 1, 1, 2, 3, 5, 8, 13.",
            ),
            choice(
                "What happens?",
                listOf("RecursionError", "It prints 0", "An infinite loop with no error", "SyntaxError"),
                0,
                "There's no stopping condition – Python stops it once the recursion limit is exceeded.",
                code = "def f(n):\n    return f(n - 1)\n\nf(3)",
            ),
            fill(
                "Fill in the stopping condition to print 120.",
                "def factorial(n):\n    if n ____ 1:\n        return 1\n    return n * factorial(n - 1)\n\nprint(factorial(5))",
                listOf("<=", ">", ">="),
                "<=",
                "The recursion should stop only when n is 1 (or less).",
            ),
            tiles(
                "Define a recursive function total(n) that computes 0 + 1 + … + n",
                listOf("def total(n):", "return 0", "if n == 0", "else", "n + total(n - 1)"),
                listOf("elif", "n * total(n)"),
                "The base case is n == 0; otherwise we add n to the total for n - 1.",
            ),
        ),
        lesson(
            "u59l5", "Challenge 5: generators",
            output(
                "def g():\n    yield 1\n    yield 2\n\nprint(list(g()))",
                "[1, 2]",
                "list() takes all the values from the generator.",
            ),
            choice(
                "What does this code print?",
                listOf("0 2", "0 0", "2 4", "0 1"),
                0,
                "Each next() gives the next value.",
                code = "g = (x * 2 for x in range(3))\nprint(next(g), next(g))",
            ),
            output(
                "def g():\n    for i in range(3):\n        yield i * i\n\nprint(sum(g()))",
                "5",
                "0 + 1 + 4 = 5.",
            ),
            output(
                "def countdown(n):\n    while n > 0:\n        yield n\n        n -= 1\n\nprint(list(countdown(3)))",
                "[3, 2, 1]",
                "After each yield the generator resumes from where it stopped.",
            ),
            output(
                "g = (c.upper() for c in \"ab\")\nprint(\"\".join(g))",
                "AB",
                "join() accepts any iterable, including a generator.",
            ),
            choice(
                "What does this code print?",
                listOf("generator", "list", "tuple", "function"),
                0,
                "Parentheses around the expression create a generator, not a tuple.",
                code = "g = (x for x in [1, 2])\nprint(type(g).__name__)",
            ),
            fill(
                "Fill in the blank to make the function a generator (it should print [0, 1, 2]).",
                "def g():\n    for i in range(3):\n        ____ i\n\nprint(list(g()))",
                listOf("yield", "return", "print"),
                "yield",
                "yield turns a function into a generator.",
            ),
            tiles(
                "Create a generator g of the numbers divisible by 3 in the range 0–9",
                listOf("g =", "(x for x", "in range(10)", "if x % 3 == 0)"),
                listOf("[x for x", "while"),
                "A generator expression is written in parentheses.",
            ),
        ),
        lesson(
            "u59l6", "Challenge 6: classes",
            choice(
                "What does this code print?",
                listOf("1 5", "5 5", "1 1", "Error"),
                0,
                "a.x = 5 creates an instance attribute; the class attribute doesn't change.",
                code = "class A:\n    x = 1\n\na = A()\na.x = 5\nprint(A.x, a.x)",
            ),
            output(
                "class P:\n    def __init__(self, n):\n        self.n = n\n    def __str__(self):\n        return f\"P({self.n})\"\n\nprint(P(3))",
                "P(3)",
                "print() uses the __str__ method.",
            ),
            output(
                "class L:\n    def __init__(self):\n        self.n = 0\n    def add(self):\n        self.n += 1\n        return self\n\nprint(L().add().add().n)",
                "2",
                "add() returns self, so the calls can be chained.",
            ),
            output(
                "class A:\n    def hi(self):\n        return \"A\"\n\nclass B(A):\n    def hi(self):\n        return \"B\" + super().hi()\n\nprint(B().hi())",
                "BA",
                "super().hi() calls the version from class A.",
            ),
            output(
                "class W:\n    def __len__(self):\n        return 3\n\nprint(len(W()))",
                "3",
                "len() calls the __len__ method.",
            ),
            choice(
                "What does this code print?",
                listOf("2", "0", "1", "Error"),
                0,
                "The class attribute count is shared and grows with every object.",
                code = "class K:\n    count = 0\n    def __init__(self):\n        K.count += 1\n\nK()\nK()\nprint(K.count)",
            ),
            fill(
                "Fill in the blank to print True.",
                "class P:\n    def __init__(self, x):\n        self.x = x\n    def ____(self, o):\n        return self.x == o.x\n\nprint(P(1) == P(1))",
                listOf("__eq__", "__lt__", "__str__"),
                "__eq__",
                "The == operator calls the __eq__ method.",
            ),
            tiles(
                "Define an empty class Cat that inherits from the class Animal",
                listOf("class", "Cat(Animal):", "pass"),
                listOf("def", "Animal(Cat):"),
                "The base class goes in parentheses after the new class's name.",
            ),
        ),
        lesson(
            "u59l7", "Challenge 7: a mix",
            output(
                "print(list(map(lambda x: x % 3, [3, 4, 5])))",
                "[0, 1, 2]",
                "map() applies the function to every element.",
            ),
            choice(
                "What does this code print?",
                listOf("[1, 'a']", "[0, 1, '', 'a']", "[0, '']", "[1]"),
                0,
                "filter(None, …) keeps only the truthy values.",
                code = "print(list(filter(None, [0, 1, \"\", \"a\"])))",
            ),
            output(
                "print(list(zip(\"abc\", [1, 2])))",
                "[('a', 1), ('b', 2)]",
                "zip() stops at the shortest sequence.",
            ),
            output(
                "print(dict(enumerate(\"xy\", 1)))",
                "{1: 'x', 2: 'y'}",
                "enumerate with a second argument starts numbering from 1.",
            ),
            output(
                "from collections import Counter\nprint(Counter(\"abracadabra\").most_common(1))",
                "[('a', 5)]",
                "The letter “a” appears 5 times.",
            ),
            choice(
                "What does this code print?",
                listOf("False True", "True True", "False False", "True False"),
                0,
                "any() of an empty list is False, and all() of an empty list is True.",
                code = "print(any([]), all([]))",
            ),
            fill(
                "Fill in the blank to print the total length of the words (3).",
                "print(sum(____(len, [\"ab\", \"c\"])))",
                listOf("map", "filter", "zip"),
                "map",
                "map(len, …) gives the lengths 2 and 1.",
            ),
            tiles(
                "Find the longest word in the list words",
                listOf("longest =", "max(words,", "key=len)"),
                listOf("min(words,", "key=len())"),
                "max() with key=len compares the lengths of the words.",
            ),
        ),
    ),
)
