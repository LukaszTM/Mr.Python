package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*
import com.mrpython.app.domain.CourseUnit

internal val module73 = CourseUnit(
    id = "u73",
    title = "Grand finale",
    description = "Puzzles that combine the whole course, and a celebration of your mastery",
    lessons = listOf(
        lesson(
            "u73l1", "Puzzles: strings and numbers",
            output(
                "def pal(s):\n    s = \"\".join(c for c in s.lower()\n                if c.isalnum())\n    return s == s[::-1]\nprint(pal(\"Never odd or even\"))\nprint(pal(\"Python\"))",
                "True\nFalse",
                "After dropping the spaces and uppercase letters, we check whether the string reads the same backward.",
            ),
            output(
                "def cipher(t, k):\n    return \"\".join(\n        chr((ord(c) - 97 + k) % 26 + 97)\n        for c in t)\nprint(cipher(\"xyz\", 3))\nprint(cipher(\"abc\", 1))",
                "abc\nbcd",
                "Caesar cipher: the remainder from dividing by 26 wraps the alphabet around.",
            ),
            output(
                "n = 2 ** 10\nprint(n, sum(map(int, str(n))))",
                "1024 7",
                "1024 → the digits 1, 0, 2, 4, which add up to 7.",
            ),
            fill(
                "Check whether the words are anagrams.",
                "a, b = \"act\", \"cat\"\nprint(sorted(a) == ____(b))",
                listOf("sorted", "list", "set"),
                "sorted",
                "Once their letters are sorted, anagrams give identical lists.",
            ),
            output(
                "result = []\nfor i in range(10, 16):\n    s = \"Fizz\" * (i % 3 == 0)\n    s += \"Buzz\" * (i % 5 == 0)\n    result.append(s or str(i))\nprint(\" \".join(result))",
                "Buzz 11 Fizz 13 14 FizzBuzz",
                "Multiplying a string by True/False is a clever way to write FizzBuzz.",
            ),
            choice(
                "Which expression counts the vowels in the string t?",
                listOf("sum(c in \"aeiou\" for c in t)", "len(\"aeiou\" in t)", "t.count(\"aeiou\")", "max(c in \"aeiou\" for c in t)"),
                0,
                "True counts as 1, so the sum of the boolean values is the number of vowels.",
            ),
            output(
                "from itertools import groupby\nt = \"aaabcc\"\ncode = [k + str(len(list(g)))\n        for k, g in groupby(t)]\nprint(\"\".join(code))",
                "a3b1c2",
                "groupby groups consecutive identical characters – this is run-length encoding (RLE).",
            ),
            tiles(
                "Reverse every word in a sentence, keeping the order of the words",
                listOf("\" \".join(", "s[::-1]", "for s in", "sentence.split())"),
                listOf("s[::1]", "sentence.join())"),
                "The generator expression reverses each word separately.",
            ),
        ),
        lesson(
            "u73l2", "Puzzles: data structures",
            output(
                "m = [[1, 2, 3], [4, 5, 6]]\nprint([list(r) for r in zip(*m)])",
                "[[1, 4], [2, 5], [3, 6]]",
                "zip(*m) swaps rows with columns – that's a transpose.",
            ),
            output(
                "nested = [[1], [2, 3], [], [4]]\nprint([x for w in nested for x in w])",
                "[1, 2, 3, 4]",
                "A double loop in the comprehension flattens a list of lists.",
            ),
            output(
                "from collections import defaultdict\ng = defaultdict(list)\nfor s in [\"act\", \"cat\", \"dogs\", \"tac\"]:\n    g[\"\".join(sorted(s))].append(s)\nprint(list(g.values()))",
                "[['act', 'cat', 'tac'], ['dogs']]",
                "Anagrams share the same key: their sorted letters.",
            ),
            output(
                "def two_sum(l, target):\n    seen = {}\n    for i, x in enumerate(l):\n        if target - x in seen:\n            return seen[target - x], i\n        seen[x] = i\nprint(two_sum([2, 7, 11, 15], 9))\nprint(two_sum([3, 2, 4], 6))",
                "(0, 1)\n(1, 2)",
                "The dictionary remembers where we saw each number – a single pass is enough.",
            ),
            fill(
                "Remove the duplicates while keeping the order of the elements.",
                "data = [\"b\", \"a\", \"b\", \"c\"]\nprint(list(dict.____(data)))",
                listOf("fromkeys", "keys", "values"),
                "fromkeys",
                "dict.fromkeys creates the keys in order of first appearance.",
            ),
            choice(
                "Why is x in my_set usually faster than x in my_list?",
                listOf("A set uses hashing – a lookup takes O(1) on average", "A set is always sorted", "A list doesn't support the in operator", "Sets can only store numbers"),
                0,
                "A list has to be searched element by element, which is O(n).",
            ),
            output(
                "import heapq\nprint(heapq.nlargest(3, [5, 1, 9, 3, 7]))\nprint(heapq.nsmallest(2, [5, 1, 9, 3, 7]))",
                "[9, 7, 5]\n[1, 3]",
                "heapq quickly picks out a few of the largest or smallest elements.",
            ),
            tiles(
                "Sort the words starting with the longest",
                listOf("sorted(", "words,", "key=len,", "reverse=True)"),
                listOf("key=len()", "reverse=False)"),
                "key=len compares lengths, and reverse=True reverses the order.",
            ),
        ),
        lesson(
            "u73l3", "Puzzles: objects and functions",
            output(
                "class Countdown:\n    def __init__(self, n):\n        self.n = n\n    def __iter__(self):\n        for i in range(self.n, 0, -1):\n            yield i\nprint(list(Countdown(3)))",
                "[3, 2, 1]",
                "Writing __iter__ as a generator makes the object usable in a loop.",
            ),
            output(
                "from dataclasses import dataclass\n@dataclass(order=True)\nclass Score:\n    pts: int\n    name: str\nw = [Score(5, \"Olivia\"), Score(9, \"Amy\"),\n     Score(5, \"Emma\")]\nprint([x.name for x in sorted(w)])",
                "['Emma', 'Olivia', 'Amy']",
                "order=True compares the fields in order: first pts, then name.",
            ),
            output(
                "from functools import reduce\nprint(reduce(lambda a, b: a * b, range(1, 6)))",
                "120",
                "reduce folds a sequence into a single value: 1·2·3·4·5.",
            ),
            output(
                "steps = [str.strip, str.lower, str.title]\nt = \"  mR pYTHON \"\nfor f in steps:\n    t = f(t)\nprint(t)",
                "Mr Python",
                "Functions are objects – we can keep them in a list and call them one after another.",
            ),
            choice(
                "Which methods does a class need for its object to work in a with statement?",
                listOf("__enter__ and __exit__", "__init__ and __del__", "__iter__ and __next__", "__open__ and __close__"),
                0,
                "with calls __enter__ at the start of the block and __exit__ at the end.",
            ),
            output(
                "class Frame:\n    def __enter__(self):\n        print(\"[\")\n        return self\n    def __exit__(self, *a):\n        print(\"]\")\nwith Frame():\n    print(\"Python\")",
                "[\nPython\n]",
                "A context manager surrounds the with block with code before and after it.",
            ),
            fill(
                "Make the object callable like a function.",
                "class Times:\n    def __init__(self, n):\n        self.n = n\n    def ____(self, x):\n        return x * self.n\nprint(Times(3)(5))",
                listOf("__call__", "__init__", "__str__"),
                "__call__",
                "__call__ handles the call obj(...).",
            ),
            tiles(
                "Create a generator of the squares of the even numbers below 10",
                listOf("sq", "=", "(x * x", "for x in range(10)", "if x % 2 == 0)"),
                listOf("[x * x", "if x % 2)"),
                "Parentheses create a generator expression.",
            ),
        ),
        lesson(
            "u73l4", "Puzzles: everything at once",
            output(
                "def sieve(n):\n    p = [True] * (n + 1)\n    p[0] = p[1] = False\n    for i in range(2, int(n ** 0.5) + 1):\n        if p[i]:\n            for j in range(i * i, n + 1, i):\n                p[j] = False\n    return [i for i, b in enumerate(p) if b]\nprint(sieve(20))",
                "[2, 3, 5, 7, 11, 13, 17, 19]",
                "The Sieve of Eratosthenes crosses out the multiples of successive primes.",
            ),
            output(
                "def hanoi(n):\n    if n == 0:\n        return 0\n    return 2 * hanoi(n - 1) + 1\nprint([hanoi(n) for n in range(1, 6)])",
                "[1, 3, 7, 15, 31]",
                "The Tower of Hanoi takes 2ⁿ - 1 moves.",
            ),
            output(
                "def ok(s):\n    stack, pairs = [], {\")\": \"(\", \"]\": \"[\"}\n    for c in s:\n        if c in \"([\":\n            stack.append(c)\n        elif not stack or stack.pop() != pairs[c]:\n            return False\n    return not stack\nprint(ok(\"([])\"), ok(\"(]\"), ok(\"((\"))",
                "True False False",
                "The stack makes sure every bracket closes the most recently opened one.",
            ),
            choice(
                "What is the time complexity of checking brackets with a stack for a string of length n?",
                listOf("O(n)", "O(n²)", "O(log n)", "O(1)"),
                0,
                "We visit each character once, and the stack operations are O(1).",
            ),
            fill(
                "Add a decorator that remembers results so that fib(80) is computed in a flash.",
                "from functools import cache\n@____\ndef fib(n):\n    if n < 2:\n        return n\n    return fib(n - 1) + fib(n - 2)\nprint(fib(80))",
                listOf("cache", "property", "print"),
                "cache",
                "@cache remembers results, so each fib(n) is computed once.",
            ),
            output(
                "from collections import Counter\na = Counter(\"aab\")\nb = Counter(\"abc\")\nprint(a - b)\nprint(a & b)",
                "Counter({'a': 1})\nCounter({'a': 1, 'b': 1})",
                "- subtracts the counts, and & takes the minimum from both counters.",
            ),
            output(
                "from collections import Counter\ntext = \"to be or not to be\"\nc = Counter(text.split())\ntop = sorted(c, key=lambda s: (-c[s], s))\nprint(top[:2], len(c))",
                "['be', 'to'] 4",
                "We sort by count in descending order, and alphabetically on a tie.",
            ),
            tiles(
                "Print whether all the numbers in the list are positive",
                listOf("print(", "all(", "x > 0", "for x in numbers", "))"),
                listOf("any(", "x >= 0"),
                "all() returns True when the condition holds for every element.",
            ),
        ),
        lesson(
            "u73l5", "Day 365: Python Master",
            output(
                "days = 365\nprint(f\"Days completed: {days}\")\nprint(days // 7, days % 7)",
                "Days completed: 365\n52 1",
                "A year of learning is 52 full weeks and one day – congratulations!",
            ),
            output(
                "title = \"Master\"\nframe = \"*\" * (len(title) + 4)\nprint(frame)\nprint(f\"* {title} *\")\nprint(frame)",
                "**********\n* Master *\n**********",
                "Your certificate in three lines: the frame is as long as the title plus 4.",
            ),
            output(
                "modules = {\"basics\": 11, \"beyond\": 56,\n           \"finale\": 6}\nprint(sum(modules.values()))\nprint(max(modules, key=modules.get))",
                "73\nbeyond",
                "You have 73 modules behind you – most of them were in the middle part of the course.",
            ),
            choice(
                "Which sentence comes from the Zen of Python (import this)?",
                listOf("Simple is better than complex.", "Fast is better than slow.", "More is better than less.", "Clever is better than clear."),
                0,
                "Simplicity is one of Python's main principles.",
            ),
            fill(
                "Print the levels you've earned, numbering them from 1.",
                "levels = [\"student\", \"apprentice\", \"master\"]\nfor num, p in ____(levels, 1):\n    print(num, p)",
                listOf("enumerate", "zip", "range"),
                "enumerate",
                "enumerate(items, 1) numbers the elements starting from one.",
            ),
            output(
                "def path():\n    yield from [\"variables\", \"loops\", \"classes\"]\n    yield \"MASTER\"\nprint(\" > \".join(path()))",
                "variables > loops > classes > MASTER",
                "yield from hands back all the elements of the list, and then we add the finale.",
            ),
            output(
                "from collections import Counter\nskills = [\"loops\", \"classes\", \"loops\",\n          \"algorithms\", \"loops\"]\nc = Counter(skills)\nfavorite, count = c.most_common(1)[0]\nprint(f\"{favorite} x{count}\")\nprint(f\"Mastered: {len(c)}\")",
                "loops x3\nMastered: 3",
                "Counter, unpacking, and an f-string – everything you've learned, all in one place.",
            ),
            tiles(
                "Print your title using an f-string",
                listOf("print(", "f\"Day {day}:", "Python Master!\"", ")"),
                listOf("echo(", "\"Student\""),
                "Congratulations – the f-string inserts the day number, and you are a Python Master!",
            ),
        ),
    ),
)
