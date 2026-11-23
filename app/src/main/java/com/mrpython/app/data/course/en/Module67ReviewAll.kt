package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

import com.mrpython.app.domain.CourseUnit

internal val module67 = CourseUnit(
    id = "u67",
    title = "Review week: everything at once",
    description = "Small programs that combine everything you've learned",
    lessons = listOf(
        lesson(
            "u67l1", "Day 1: Text analysis",
            output(
                "from collections import Counter\ntext = \"the cat and the dog and the bird\"\nc = Counter(text.split())\nfor word, n in c.most_common(2):\n    print(word, n)",
                "the 3\nand 2",
                "Counter counts the words, and most_common(2) gives the two most frequent ones.",
            ),
            output(
                "sentence = \"Python is really wonderful\"\nlongest = max(sentence.split(), key=len)\nprint(longest, len(longest))",
                "wonderful 9",
                "max with key=len picks the longest word.",
            ),
            output(
                "text = \"the sky is blue. the grass is green.\"\nsentences = []\nfor s in text.split(\".\"):\n    if s.strip():\n        sentences.append(s.strip().capitalize())\nprint(\". \".join(sentences) + \".\")",
                "The sky is blue. The grass is green.",
                "We split into sentences, skip the empty ones and fix the capital letters.",
            ),
            fill(
                "Fill in the blank to keep only the letters (the program should print AmyBobandEve).",
                "text = \"Amy, Bob and Eve!\"\nclean = \"\".join(c for c in text if c.____())\nprint(clean)",
                listOf("isalpha", "isdigit", "isspace"),
                "isalpha",
                "isalpha() is true only for letters.",
            ),
            output(
                "vowels = \"aeiou\"\ntext = \"Magic Unicorn\"\nprint(sum(c in vowels for c in text.lower()))",
                "5",
                "The vowels are a, i, u, i, o.",
            ),
            choice(
                "What will this program print?",
                listOf("['Bob', 'Cat', 'amy']", "['amy', 'Bob', 'Cat']", "['Cat', 'amy', 'Bob']", "['Bob', 'amy', 'Cat']"),
                0,
                "Uppercase letters have lower codes than lowercase ones, so they come first.",
                code = "words = [\"Cat\", \"amy\", \"Bob\"]\nprint(sorted(words))",
            ),
            output(
                "name = \"portable network graphics\"\nprint(\"\".join(w[0].upper() for w in name.split()))",
                "PNG",
                "We take the first letter of each word and make it uppercase.",
            ),
            tiles(
                "Build a dictionary lengths: word → its length for the list words",
                listOf("lengths", "=", "{w:", "len(w)", "for w in", "words}"),
                listOf("[w:", "len(words)"),
                "A dictionary comprehension has the form {key: value for ...}.",
            ),
        ),
        lesson(
            "u67l2", "Day 2: Gradebook",
            output(
                "grades = {\"Amy\": [5, 4, 5], \"Tom\": [3, 4]}\nfor name, g in grades.items():\n    print(f\"{name}: {sum(g) / len(g):.2f}\")",
                "Amy: 4.67\nTom: 3.50",
                "The :.2f format always shows two digits after the decimal point.",
            ),
            output(
                "gr = {\"Amy\": [5, 4], \"Tom\": [3, 5, 5], \"Eve\": [4]}\navg = {k: sum(v) / len(v) for k, v in gr.items()}\nbest = max(avg, key=avg.get)\nprint(best, avg[best])",
                "Amy 4.5",
                "max over the dictionary's keys with key=avg.get finds the highest average.",
            ),
            output(
                "def median(t):\n    t = sorted(t)\n    n = len(t)\n    if n % 2:\n        return t[n // 2]\n    return (t[n // 2 - 1] + t[n // 2]) / 2\nprint(median([7, 1, 3]), median([4, 1, 3, 2]))",
                "3 2.5",
                "For an even number of items the median is the average of the two middle ones.",
            ),
            output(
                "def grade(pts):\n    thresholds = [(90, 5), (75, 4), (50, 3)]\n    for limit, g in thresholds:\n        if pts >= limit:\n            return g\n    return 2\nprint([grade(p) for p in [95, 50, 49, 80]])",
                "[5, 3, 2, 4]",
                "We check the thresholds from the highest; the first one met decides.",
            ),
            fill(
                "Fill in the blank so the best score comes first (the program should print Tom).",
                "results = [(\"Amy\", 88), (\"Tom\", 95), (\"Eve\", 70)]\ntop = sorted(results, key=lambda r: r[1], ____=True)\nprint(top[0][0])",
                listOf("reverse", "key", "desc"),
                "reverse",
                "reverse=True sorts in descending order.",
            ),
            choice(
                "What's wrong here if we want the exact average?",
                listOf("// cuts off the fractional part – you need /", "sum doesn't work on lists", "len returns the wrong result", "Nothing – it's correct"),
                0,
                "14 // 3 is 4, and the exact average is 4.67.",
                code = "grades = [4, 5, 5]\naverage = sum(grades) // len(grades)",
            ),
            output(
                "from dataclasses import dataclass, field\n@dataclass\nclass Student:\n    name: str\n    grades: list = field(default_factory=list)\n    def average(self):\n        return sum(self.grades) / len(self.grades)\ns = Student(\"Amy\", [4, 5])\nprint(f\"{s.name}: {s.average()}\")",
                "Amy: 4.5",
                "A dataclass with a method that computes the grade average.",
            ),
            tiles(
                "Count how many averages in the list averages are at least 4",
                listOf("count", "=", "sum(", "1 for a in averages", "if a >= 4", ")"),
                listOf("if a > 4", "len("),
                "We add up ones for the items that meet the condition.",
            ),
        ),
        lesson(
            "u67l3", "Day 3: Store and cart",
            output(
                "class Cart:\n    def __init__(self):\n        self.items = {}\n    def add(self, name, price, qty=1):\n        self.items[name] = (price, qty)\n    def total(self):\n        return sum(p * q for p, q in self.items.values())\nc = Cart()\nc.add(\"bread\", 4.5, 2)\nc.add(\"butter\", 7)\nprint(c.total())",
                "16.0",
                "4.5 * 2 + 7 * 1 = 16.0.",
            ),
            output(
                "class OutOfStock(Exception):\n    pass\nstock = {\"apple\": 3}\ndef buy(item, n):\n    if stock.get(item, 0) < n:\n        raise OutOfStock(item)\n    stock[item] -= n\nfor n in [2, 2]:\n    try:\n        buy(\"apple\", n)\n        print(\"ok\", stock[\"apple\"])\n    except OutOfStock as e:\n        print(\"out of stock:\", e)",
                "ok 1\nout of stock: apple",
                "The second time only 1 apple is left, so we raise an exception.",
            ),
            output(
                "def discount(p):\n    return lambda c: round(c * (100 - p) / 100, 2)\ndiscount10 = discount(10)\nprint([discount10(c) for c in [100, 59.99]])",
                "[90.0, 53.99]",
                "discount returns a closure that remembers the percentage.",
            ),
            output(
                "items = [(\"Cheese\", 12.5), (\"Milk\", 3)]\nfor n, c in items:\n    print(f\"{n}: \${c:.2f}\")\nprint(f\"Total: \${sum(c for _, c in items):.2f}\")",
                "Cheese: \$12.50\nMilk: \$3.00\nTotal: \$15.50",
                "The :.2f format prints amounts with cents.",
            ),
            choice(
                "Which type is best for amounts of money without rounding errors?",
                listOf("Decimal from the decimal module", "float", "str", "complex"),
                0,
                "Decimal computes in base ten, so 0.1 + 0.2 is exactly 0.3.",
            ),
            output(
                "from decimal import Decimal\nprint(0.1 + 0.2, Decimal(\"0.1\") + Decimal(\"0.2\"))",
                "0.30000000000000004 0.3",
                "float has rounding errors, Decimal created from strings doesn't.",
            ),
            fill(
                "Fill in the blank so that printing the product shows Coffee (\$20).",
                "class Product:\n    def __init__(self, n, c):\n        self.n, self.c = n, c\n    def ____(self):\n        return f\"{self.n} (\${self.c})\"\nprint(Product(\"Coffee\", 20))",
                listOf("__str__", "__init__", "__len__"),
                "__str__",
                "print uses the __str__ method.",
            ),
            tiles(
                "Compute the total value: the sum of p * q for the (price, quantity) pairs in the list cart",
                listOf("total", "=", "sum(", "p * q", "for p, q in", "cart", ")"),
                listOf("p + q", "len("),
                "We unpack each pair and add up the products.",
            ),
        ),
        lesson(
            "u67l4", "Day 4: Data processing",
            output(
                "import json\ndata = '[{\"n\":\"Amy\",\"a\":30},{\"n\":\"Tom\",\"a\":17}]'\npeople = json.loads(data)\nprint([p[\"n\"] for p in people if p[\"a\"] >= 18])",
                "['Amy']",
                "We load the JSON and keep only the adults.",
            ),
            output(
                "import csv, io\nfile = io.StringIO(\"name,pts\\nAmy,7\\nTom,9\\n\")\nrows = csv.DictReader(file)\nprint(sum(int(r[\"pts\"]) for r in rows))",
                "16",
                "DictReader gives dictionaries of strings – you have to convert them to numbers.",
            ),
            output(
                "from collections import defaultdict\nexpenses = [(\"lunch\", 20), (\"ticket\", 5), (\"lunch\", 15)]\ntotal = defaultdict(int)\nfor cat, amt in expenses:\n    total[cat] += amt\nprint(dict(total))",
                "{'lunch': 35, 'ticket': 5}",
                "defaultdict(int) adds up the expenses by category.",
            ),
            output(
                "config = {\"db\": {\"host\": \"localhost\"}}\nport = config.get(\"db\", {}).get(\"port\", 5432)\nprint(port, config[\"db\"][\"host\"])",
                "5432 localhost",
                "get with a default value protects against KeyError in nested data.",
            ),
            choice(
                "What will this program print?",
                listOf("str", "dict", "bytes", "json"),
                0,
                "dumps turns an object into a string in JSON format.",
                code = "import json\ns = json.dumps({\"a\": 1})\nprint(type(s).__name__)",
            ),
            fill(
                "Fill in the blank to build a dictionary from two lists ({'name': 'Amy', 'age': 30}).",
                "keys = [\"name\", \"age\"]\nvalues = [\"Amy\", 30]\nprint(dict(____(keys, values)))",
                listOf("zip", "enumerate", "map"),
                "zip",
                "zip creates (key, value) pairs, from which dict builds a dictionary.",
            ),
            output(
                "products = [\n    {\"n\": \"tea\", \"c\": 12},\n    {\"n\": \"bread\", \"c\": 5},\n    {\"n\": \"coffee\", \"c\": 12},\n]\nproducts.sort(key=lambda p: (-p[\"c\"], p[\"n\"]))\nprint(\", \".join(p[\"n\"] for p in products))",
                "coffee, tea, bread",
                "First by price in descending order, and alphabetically in case of a tie.",
            ),
            tiles(
                "Load JSON from the string text into the variable data",
                listOf("data", "=", "json.loads(", "text", ")"),
                listOf("json.load(", "json.dumps("),
                "loads reads from a string, and load – from a file.",
            ),
        ),
        lesson(
            "u67l5", "Day 5: Generators in practice",
            output(
                "def evens(n):\n    for i in range(n):\n        if i % 2 == 0:\n            yield i\nprint(list(evens(7)))",
                "[0, 2, 4, 6]",
                "yield hands out successive values on demand.",
            ),
            output(
                "g = (x * x for x in range(3))\nprint(sum(g), sum(g))",
                "5 0",
                "A generator can be walked through only once – the second time it's empty.",
            ),
            output(
                "lines = [\"# comment\", \"a=1\", \"\", \"b=2\"]\nclean = (l for l in lines if l and l[0] != \"#\")\nprint(dict(l.split(\"=\") for l in clean))",
                "{'a': '1', 'b': '2'}",
                "We skip empty lines and comments, and split the rest into pairs.",
            ),
            output(
                "numbers = [3, 7, 10, 13]\np = next((x for x in numbers if x % 5 == 0), None)\nq = next((x for x in numbers if x > 20), None)\nprint(p, q)",
                "10 None",
                "next with a default value returns the first matching item or None.",
            ),
            choice(
                "Why doesn't (x for x in range(10**9)) use a lot of memory?",
                listOf("A generator creates items on demand, one after another", "Python compresses lists", "range has a limit on items", "It creates a list in the background and quickly deletes it"),
                0,
                "A generator doesn't store all the items at once.",
            ),
            fill(
                "Fill in the blank so the function is a generator (the program should print [3, 2, 1]).",
                "def countdown(n):\n    while n > 0:\n        ____ n\n        n -= 1\nprint(list(countdown(3)))",
                listOf("yield", "return", "print"),
                "yield",
                "yield turns a function into a generator.",
            ),
            output(
                "names = [\"Amy\", \"Tom\"]\npoints = [7, 9]\nfor i, (n, p) in enumerate(zip(names, points), 1):\n    print(f\"{i}. {n} - {p}\")",
                "1. Amy - 7\n2. Tom - 9",
                "zip pairs up the lists, and enumerate(…, 1) numbers from 1.",
            ),
            tiles(
                "Create a generator sq of the squares of the numbers from 0 to 9",
                listOf("sq", "=", "(x ** 2", "for x in", "range(10))"),
                listOf("[x ** 2", "range(9))"),
                "A generator expression is written in parentheses.",
            ),
        ),
        lesson(
            "u67l6", "Day 6: Programmer's tools",
            output(
                "def positive(f):\n    def w(*args):\n        if any(a <= 0 for a in args):\n            return \"error\"\n        return f(*args)\n    return w\n@positive\ndef area(a, b):\n    return a * b\nprint(area(3, 4), area(-1, 2))",
                "12 error",
                "The decorator checks the arguments before it calls the function.",
            ),
            output(
                "class Section:\n    def __enter__(self):\n        print(\"start\")\n        return self\n    def __exit__(self, *exc):\n        print(\"stop\")\nwith Section():\n    print(\"work\")",
                "start\nwork\nstop",
                "with calls __enter__ at the start and __exit__ at the end of the block.",
            ),
            output(
                "from contextlib import suppress\nwith suppress(KeyError):\n    print({}[\"x\"])\nprint(\"moving on\")",
                "moving on",
                "suppress silences the given exception.",
            ),
            output(
                "def memoize(f):\n    cache = {}\n    def w(n):\n        if n not in cache:\n            cache[n] = f(n)\n        return cache[n]\n    return w\n@memoize\ndef expensive(n):\n    print(\"computing\", n)\n    return n * 2\nprint(expensive(5) + expensive(5))",
                "computing 5\n20",
                "The second time the result comes from the cache, so \"computing\" appears once.",
            ),
            choice(
                "What does the statement with open(\"a.txt\") as f: guarantee?",
                listOf("The file will be closed, even if an error occurs", "The file will be created", "The whole file will be loaded into memory right away", "All errors will be ignored"),
                0,
                "A context manager cleans up after itself – it closes the file.",
            ),
            fill(
                "Fill in the return type annotation.",
                "def average(numbers: list[float]) ____ float:\n    return sum(numbers) / len(numbers)\nprint(average([2.0, 4.0]))",
                listOf("->", "=>", ":"),
                "->",
                "The return type is written after the arrow ->.",
            ),
            output(
                "def reverse(s):\n    return s[::-1]\ntests = [(\"abc\", \"cba\"), (\"\", \"\"), (\"ab\", \"ab\")]\nfor inp, exp in tests:\n    print(\"OK\" if reverse(inp) == exp else \"FAIL\")",
                "OK\nOK\nFAIL",
                "The third test has a wrong expected value – \"ab\" reversed is \"ba\".",
            ),
            tiles(
                "Open the file data.txt for reading using with",
                listOf("with", "open(", "\"data.txt\")", "as", "f:"),
                listOf("for", "f ="),
                "with open(...) as f: will close the file automatically.",
            ),
        ),
        lesson(
            "u67l7", "Day 7: Small projects",
            output(
                "class Account:\n    def __init__(self):\n        self.balance, self.history = 0, []\n    def deposit(self, amt):\n        if self.balance + amt < 0:\n            raise ValueError(\"not enough\")\n        self.balance += amt\n        self.history.append(amt)\na = Account()\nfor amt in [100, -30, -100]:\n    try: a.deposit(amt)\n    except ValueError as e: print(e)\nprint(a.balance, a.history)",
                "not enough\n70 [100, -30]",
                "The -100 operation is rejected, so it doesn't make it into the history.",
            ),
            output(
                "import heapq\ntasks = []\nheapq.heappush(tasks, (2, \"shopping\"))\nheapq.heappush(tasks, (1, \"bills\"))\nheapq.heappush(tasks, (3, \"movie\"))\nwhile tasks:\n    print(heapq.heappop(tasks)[1])",
                "bills\nshopping\nmovie",
                "The heap hands out tasks starting from the lowest priority number.",
            ),
            output(
                "questions = {\"2+2\": \"4\", \"capital\": \"Paris\"}\nanswers = {\"2+2\": \"4\", \"capital\": \"london\"}\nscore = sum(answers[q].lower() == a.lower()\n            for q, a in questions.items())\nprint(f\"{score}/{len(questions)}\")",
                "1/2",
                "True counts as 1, so sum counts the correct answers.",
            ),
            output(
                "from datetime import date\ndeadline = date(2026, 11, 11)\ntoday = date(2026, 10, 22)\nprint((deadline - today).days, deadline.strftime(\"%d.%m\"))",
                "20 11.11",
                "There are 9 days left in October, plus 11 days of November.",
            ),
            output(
                "import re\nfrom collections import Counter\nlog = \"ERROR x; INFO y; ERROR z; WARN q\"\nlevels = re.findall(r\"[A-Z]{4,5}\", log)\nprint(Counter(levels)[\"ERROR\"], len(levels))",
                "2 4",
                "The pattern catches words of 4–5 capital letters: two ERRORs, INFO and WARN.",
            ),
            choice(
                "Which structure is best for an \"undo\" feature in an editor?",
                listOf("A stack (a list with append and pop)", "A FIFO queue", "A set", "A dictionary"),
                0,
                "We undo the last change first – that's the LIFO rule.",
            ),
            fill(
                "Fill in the blank to transpose the matrix (the program should print [[1, 4], [2, 5], [3, 6]]).",
                "matrix = [[1, 2, 3], [4, 5, 6]]\nt = [list(r) for r in zip(____matrix)]\nprint(t)",
                listOf("*", "**", "-"),
                "*",
                "zip(*matrix) joins the items of the rows that have the same indexes.",
            ),
            tiles(
                "In the list numbers, replace multiples of 3 with \"Fizz\" and store the result in the variable result",
                listOf("result", "=", "[\"Fizz\" if n % 3 == 0", "else n", "for n in numbers]"),
                listOf("if n % 3", "else \"Fizz\""),
                "The conditional expression x if condition else y goes at the start of the list comprehension.",
            ),
        ),
    ),
)
