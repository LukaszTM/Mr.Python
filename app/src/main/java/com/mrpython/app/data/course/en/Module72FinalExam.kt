package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*
import com.mrpython.app.domain.CourseUnit

internal val module72 = CourseUnit(
    id = "u72",
    title = "Final exam",
    description = "Test yourself on the whole course – a bit harder than usual",
    lessons = listOf(
        lesson(
            "u72l1", "Exam, part 1: basics",
            output(
                "print(7 // 2, -7 // 2, 7 % -2)",
                "3 -4 -1",
                "// rounds down (for negatives too), and the remainder takes the sign of the divisor.",
            ),
            output(
                "print(2 ** 3 ** 2)",
                "512",
                "Exponentiation groups from the right: 3 ** 2 = 9, then 2 ** 9.",
            ),
            output(
                "x = 5\nx += x * 2\nprint(x)",
                "15",
                "x += x * 2 means x = 5 + 10.",
            ),
            choice(
                "What does this code print?",
                listOf("False", "True", "0.3", "Error"),
                0,
                "In memory 0.1 * 3 is 0.30000000000000004, so the comparison gives False.",
                code = "print(0.1 * 3 == 0.3)",
            ),
            output(
                "s = \"Python\"\nprint(s[::-2], s[1:-1:2])",
                "nhy yh",
                "A step of -2 takes every second character from the end; s[1:-1:2] takes y and h.",
            ),
            fill(
                "Print the numbers from 10 down to 1, inclusive.",
                "for i in range(10, ____, -1):\n    print(i, end=\" \")",
                listOf("0", "1", "-1"),
                "0",
                "The end of range is exclusive, so to reach 1 we stop at 0.",
            ),
            output(
                "for i in range(3):\n    if i == 5:\n        break\nelse:\n    print(\"no break\")\nprint(i)",
                "no break\n2",
                "A loop's else runs when the loop wasn't interrupted by break.",
            ),
            tiles(
                "Print whether x is between 1 and 10, inclusive (chained comparison)",
                listOf("print(", "1 <= x", "<= 10", ")"),
                listOf("and", "=< 10"),
                "Python lets you chain comparisons: 1 <= x <= 10.",
            ),
        ),
        lesson(
            "u72l2", "Exam, part 2: data structures",
            output(
                "a = [1, 2]\nb = a\nb.append(3)\nprint(a, a is b)",
                "[1, 2, 3] True",
                "b = a doesn't copy the list – both names point to the same object.",
            ),
            output(
                "m = [[0] * 2] * 2\nm[0][0] = 1\nprint(m)",
                "[[1, 0], [1, 0]]",
                "* 2 duplicates the reference to the same inner list.",
            ),
            output(
                "t = (1, [2])\nt[1].append(3)\nprint(t)",
                "(1, [2, 3])",
                "A tuple can't be changed, but the list inside it is still mutable.",
            ),
            choice(
                "Which object can be a dictionary key?",
                listOf("(1, 2)", "[1, 2]", "{1: 2}", "{1, 2}"),
                0,
                "Only an immutable (hashable) object can be a key, e.g. a tuple.",
            ),
            output(
                "print({1, 2, 3} & {2, 3, 4})\nprint({1, 2} | {5})",
                "{2, 3}\n{1, 2, 5}",
                "& is the intersection, | is the union of sets.",
            ),
            output(
                "d = {\"a\": 1, \"b\": 2}\ninv = {v: k for k, v in d.items()}\nprint(inv[2])",
                "b",
                "The dictionary comprehension swaps keys with values.",
            ),
            fill(
                "Sort the words from longest to shortest.",
                "words = [\"ab\", \"a\", \"abc\"]\nprint(sorted(words, key=len, reverse=____))",
                listOf("True", "False", "key"),
                "True",
                "reverse=True reverses the sort order.",
            ),
            output(
                "from collections import deque\nq = deque([1, 2, 3])\nq.rotate(1)\nq.appendleft(0)\nprint(list(q))",
                "[0, 3, 1, 2]",
                "rotate(1) moves the last element to the front, and then we add 0.",
            ),
        ),
        lesson(
            "u72l3", "Exam, part 3: functions",
            output(
                "def f(x, items=[]):\n    items.append(x)\n    return items\nf(1)\nprint(f(2))",
                "[1, 2]",
                "The default list is created once and shared between calls.",
            ),
            output(
                "def counter():\n    n = 0\n    def inc():\n        nonlocal n\n        n += 1\n        return n\n    return inc\nc = counter()\nc()\nprint(c(), c())",
                "2 3",
                "The closure remembers the variable n between calls.",
            ),
            output(
                "def f(*a, **k):\n    return len(a), sorted(k)\nprint(f(1, 2, x=3, b=4))",
                "(2, ['b', 'x'])",
                "*a collects positional arguments, **k keyword arguments (a dictionary).",
            ),
            output(
                "pairs = [(1, \"b\"), (2, \"a\"), (3, \"b\")]\nprint(sorted(pairs, key=lambda p: p[1])[0])",
                "(2, 'a')",
                "We sort by the second element, so the pair with \"a\" comes first.",
            ),
            fill(
                "Fill in the blank to make the function a generator.",
                "def gen():\n    for i in range(3):\n        ____ i * 2\nprint(list(gen()))",
                listOf("yield", "return", "print"),
                "yield",
                "yield hands back successive values without ending the function.",
            ),
            output(
                "def loud(f):\n    def w(*a):\n        return f(*a).upper()\n    return w\n@loud\ndef hi(name):\n    return f\"hi {name}\"\nprint(hi(\"amy\"))",
                "HI AMY",
                "A decorator wraps a function and changes its result.",
            ),
            choice(
                "What does f(4) return?",
                listOf("24", "10", "4", "16"),
                0,
                "It's a factorial: 4 · 3 · 2 · 1 = 24.",
                code = "def f(n):\n    return 1 if n == 0 else n * f(n - 1)",
            ),
            tiles(
                "Store an anonymous function that adds two numbers in the variable add",
                listOf("add", "=", "lambda", "x, y:", "x + y"),
                listOf("def", "return"),
                "lambda x, y: x + y creates a function in a single expression.",
            ),
        ),
        lesson(
            "u72l4", "Exam, part 4: object-oriented programming",
            output(
                "class A:\n    def who(self):\n        return \"A\"\nclass B(A):\n    def who(self):\n        return \"B\" + super().who()\nprint(B().who())",
                "BA",
                "super() calls the base class's version of the method.",
            ),
            output(
                "class K:\n    n = 0\n    def __init__(self):\n        K.n += 1\nK(); K(); K()\nprint(K.n)",
                "3",
                "A class attribute is shared by all objects.",
            ),
            output(
                "class P:\n    def __init__(self, x):\n        self.x = x\n    def __repr__(self):\n        return f\"P({self.x})\"\n    def __add__(self, o):\n        return P(self.x + o.x)\nprint(P(1) + P(2))",
                "P(3)",
                "__add__ defines what + does, and __repr__ how the result looks.",
            ),
            choice(
                "What is the method resolution order (MRO) for class D?",
                listOf("D, B, C, A, object", "D, B, A, C, object", "D, C, B, A, object", "D, A, B, C, object"),
                0,
                "Python goes through the base classes from the left, and the shared ancestor A comes only at the end.",
                code = "class A: pass\nclass B(A): pass\nclass C(A): pass\nclass D(B, C): pass",
            ),
            fill(
                "Fill in the decorator so the area can be read without parentheses.",
                "class Square:\n    def __init__(self, a):\n        self.a = a\n    @____\n    def area(self):\n        return self.a ** 2\nprint(Square(3).area)",
                listOf("property", "staticmethod", "classmethod"),
                "property",
                "@property turns a method into a read-only attribute.",
            ),
            output(
                "class Bag:\n    def __init__(self):\n        self.r = [\"a\", \"b\"]\n    def __len__(self):\n        return len(self.r)\n    def __contains__(self, x):\n        return x in self.r\nt = Bag()\nprint(len(t), \"a\" in t, \"z\" in t)",
                "2 True False",
                "__len__ handles len(), and __contains__ the in operator.",
            ),
            output(
                "class Animal:\n    def sound(self):\n        return \"...\"\nclass Dog(Animal):\n    def sound(self):\n        return \"Woof\"\nclass Fish(Animal):\n    pass\nprint([z.sound() for z in [Dog(), Fish()]])",
                "['Woof', '...']",
                "Polymorphism: Fish doesn't override sound(), so it uses the version from Animal.",
            ),
            tiles(
                "Define a class Cat that inherits from Animal",
                listOf("class", "Cat", "(Animal)", ":"),
                listOf("[Animal]", "def"),
                "The base class goes in parentheses after the class name.",
            ),
        ),
        lesson(
            "u72l5", "Exam, part 5: the standard library",
            output(
                "from collections import Counter\nprint(Counter(\"mississippi\").most_common(2))",
                "[('i', 4), ('s', 4)]",
                "i and s each appear 4 times; on a tie, the order of first appearance decides.",
            ),
            output(
                "from itertools import accumulate, permutations\nprint(list(accumulate([1, 2, 3, 4])))\nprint(len(list(permutations(range(4), 2))))",
                "[1, 3, 6, 10]\n12",
                "accumulate gives running totals, and there are 4 · 3 ordered pairs from 4 elements.",
            ),
            output(
                "import math\nprint(math.gcd(12, 18), math.isqrt(17))\nprint(math.ceil(-1.5))",
                "6 4\n-1",
                "The GCD is 6, the integer square root of 17 is 4, and ceil(-1.5) is -1.",
            ),
            output(
                "from datetime import date, timedelta\nd = date(2024, 2, 28) + timedelta(days=2)\nprint(d)",
                "2024-03-01",
                "2024 is a leap year, so February 28 is followed by February 29.",
            ),
            fill(
                "Convert the dictionary to a JSON string.",
                "import json\nprint(json.____({\"a\": 1}))",
                listOf("dumps", "loads", "load"),
                "dumps",
                "dumps (dump string) converts an object to a JSON string.",
            ),
            choice(
                "What is functools.lru_cache for?",
                listOf("It remembers a function's results", "It deletes unused variables", "It speeds up every for loop", "It saves results to a file"),
                0,
                "lru_cache keeps the result for each set of arguments in memory, so a repeated call with the same arguments computes nothing.",
            ),
            output(
                "import re\nprint(re.findall(r\"\\d+\", \"a1b22c333\"))",
                "['1', '22', '333']",
                "\\d+ matches runs of digits.",
            ),
            tiles(
                "Sort the list of dictionaries people by the key \"age\"",
                listOf("sorted(", "people,", "key=itemgetter(", "\"age\"))"),
                listOf("key=\"age\")", "reverse=itemgetter("),
                "operator.itemgetter(\"age\") works like lambda d: d[\"age\"].",
            ),
        ),
        lesson(
            "u72l6", "Exam, part 6: algorithms",
            output(
                "def search(l, x):\n    lo, hi = 0, len(l) - 1\n    while lo <= hi:\n        m = (lo + hi) // 2\n        if l[m] == x: return m\n        if l[m] < x: lo = m + 1\n        else: hi = m - 1\n    return -1\nprint(search([1, 3, 5, 7, 9], 7))",
                "3",
                "Binary search finds 7 at index 3.",
            ),
            choice(
                "What is the time complexity of binary search?",
                listOf("O(log n)", "O(n)", "O(n log n)", "O(1)"),
                0,
                "At every step we discard half of the data.",
            ),
            output(
                "import bisect\nl = [1, 3, 5]\nbisect.insort(l, 4)\nprint(l, bisect.bisect_left(l, 5))",
                "[1, 3, 4, 5] 3",
                "insort inserts while keeping the order, and 5 is now at index 3.",
            ),
            output(
                "from functools import cache\n@cache\ndef fib(n):\n    if n < 2:\n        return n\n    return fib(n - 1) + fib(n - 2)\nprint(fib(30))",
                "832040",
                "Thanks to @cache every value is computed only once.",
            ),
            choice(
                "What is the worst-case time complexity of insertion sort?",
                listOf("O(n²)", "O(n log n)", "O(n)", "O(log n)"),
                0,
                "For data sorted in reverse, every element gets moved across the whole sorted part.",
            ),
            output(
                "from collections import deque\nG = {\"A\": [\"B\", \"C\"], \"B\": [\"D\"],\n     \"C\": [\"D\"], \"D\": []}\nqueue, seen = deque([\"A\"]), [\"A\"]\nwhile queue:\n    for s in G[queue.popleft()]:\n        if s not in seen:\n            seen.append(s)\n            queue.append(s)\nprint(seen)",
                "['A', 'B', 'C', 'D']",
                "BFS visits vertices layer by layer: A, then B and C, then D.",
            ),
            fill(
                "Fill in the condition to merge two sorted lists in ascending order.",
                "def merge(a, b):\n    w, i, j = [], 0, 0\n    while i < len(a) and j < len(b):\n        if a[i] ____ b[j]:\n            w.append(a[i]); i += 1\n        else:\n            w.append(b[j]); j += 1\n    return w + a[i:] + b[j:]\nprint(merge([1, 4], [2, 3]))",
                listOf("<=", ">=", "=="),
                "<=",
                "We always take the smaller of the two front elements into the result.",
            ),
            tiles(
                "Reverse a list using a slice",
                listOf("reversed_list", "=", "items[", "::-1]"),
                listOf("::1]", "-1::]"),
                "A step of -1 walks the list from the end.",
            ),
        ),
    ),
)
