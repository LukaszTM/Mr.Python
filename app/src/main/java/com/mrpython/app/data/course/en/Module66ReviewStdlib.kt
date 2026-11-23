package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

import com.mrpython.app.domain.CourseUnit

internal val module66 = CourseUnit(
    id = "u66",
    title = "Review week: the standard library",
    description = "math, datetime, collections, itertools, functools, re and json",
    lessons = listOf(
        lesson(
            "u66l1", "Day 1: math",
            output(
                "import math\nprint(math.floor(-2.5), math.ceil(-2.5))",
                "-3 -2",
                "floor rounds down, ceil rounds up – for negative numbers too.",
            ),
            output(
                "import math\nprint(math.sqrt(16), math.isqrt(17))",
                "4.0 4",
                "sqrt returns a float, and isqrt the integer part of the square root.",
            ),
            output(
                "print(round(2.5), round(3.5), round(2.675, 2))",
                "2 4 2.67",
                "round rounds halves to the even number, and 2.675 is stored as slightly less.",
            ),
            choice(
                "How do you safely compare 0.1 + 0.2 with 0.3?",
                listOf("math.isclose(0.1 + 0.2, 0.3)", "0.1 + 0.2 == 0.3", "round(0.1 + 0.2) == 0.3", "int(0.1 + 0.2) == 0.3"),
                0,
                "Floating-point numbers are compared with a tolerance – math.isclose.",
            ),
            fill(
                "Fill in the blank to compute 5! (the program should print 120).",
                "import math\nprint(math.____(5))",
                listOf("factorial", "pow", "fact"),
                "factorial",
                "math.factorial(n) computes the factorial.",
            ),
            output(
                "from math import hypot, dist\nprint(hypot(3, 4), dist((0, 0), (6, 8)))",
                "5.0 10.0",
                "Both functions compute a distance using the Pythagorean theorem.",
            ),
            output(
                "import math\nprint(math.comb(5, 2), math.perm(5, 2))",
                "10 20",
                "comb counts combinations (order ignored), perm counts arrangements (order matters).",
            ),
            tiles(
                "Import only the sqrt function and the pi constant from the math module",
                listOf("from", "math", "import", "sqrt,", "pi"),
                listOf("import math", "as"),
                "from module import names – imports the selected names.",
            ),
        ),
        lesson(
            "u66l2", "Day 2: datetime",
            output(
                "from datetime import date\nd = date(2026, 3, 1)\nprint(d - date(2026, 2, 1))",
                "28 days, 0:00:00",
                "The difference of two dates is a timedelta; February 2026 has 28 days.",
            ),
            output(
                "from datetime import date, timedelta\nd = date(2024, 2, 28) + timedelta(days=2)\nprint(d)",
                "2024-03-01",
                "2024 is a leap year, so February 28 is followed by February 29.",
            ),
            output(
                "from datetime import datetime\nt = datetime(2026, 7, 4, 9, 5)\nprint(t.strftime(\"%d.%m.%Y %H:%M\"))",
                "04.07.2026 09:05",
                "strftime formats a date; %d, %m, %H and %M add leading zeros.",
            ),
            output(
                "from datetime import datetime\nt = datetime.strptime(\"15/08/2025\", \"%d/%m/%Y\")\nprint(t.month, t.year)",
                "8 2025",
                "strptime turns a string into a date according to the given pattern.",
            ),
            choice(
                "October 22, 2026 is a Thursday. What does date(2026, 10, 22).weekday() return?",
                listOf("3", "4", "5", "0"),
                0,
                "weekday() counts from Monday = 0, so Thursday is 3.",
            ),
            fill(
                "Fill in the blank to print the day of the month (24).",
                "from datetime import date\nd = date(2026, 12, 24)\nprint(d.____)",
                listOf("day", "month", "weekday"),
                "day",
                "The day attribute is the day of the month.",
            ),
            output(
                "from datetime import timedelta\nt = timedelta(hours=1, minutes=30)\nprint(t.total_seconds(), t * 2)",
                "5400.0 3:00:00",
                "An hour and a half is 5400 seconds; a timedelta can be multiplied.",
            ),
            tiles(
                "Create the date January 1, 2027 and store it in the variable d",
                listOf("d", "=", "date(", "2027,", "1,", "1", ")"),
                listOf("\"2027-01-01\"", "12,"),
                "date takes the year, month and day.",
            ),
        ),
        lesson(
            "u66l3", "Day 3: collections",
            output(
                "from collections import Counter\nc = Counter(\"mississippi\")\nprint(c.most_common(2))",
                "[('i', 4), ('s', 4)]",
                "most_common returns the most frequent items; ties are broken by order of first appearance.",
            ),
            output(
                "from collections import defaultdict\ngroups = defaultdict(list)\nfor s in [\"cat\", \"cow\", \"dog\"]:\n    groups[s[0]].append(s)\nprint(dict(groups))",
                "{'c': ['cat', 'cow'], 'd': ['dog']}",
                "defaultdict(list) creates an empty list for a new key by itself.",
            ),
            output(
                "from collections import namedtuple\nPoint = namedtuple(\"Point\", \"x y\")\np = Point(3, 4)\nprint(p.x * p.y, p)",
                "12 Point(x=3, y=4)",
                "A namedtuple is a tuple with named fields.",
            ),
            output(
                "from collections import deque\nrecent = deque(maxlen=3)\nfor i in range(6):\n    recent.append(i)\nprint(list(recent))",
                "[3, 4, 5]",
                "A deque with maxlen forgets the oldest items.",
            ),
            fill(
                "Fill in the blank to count the letters (the program should print 5).",
                "import collections\nc = collections.____(\"abracadabra\")\nprint(c[\"a\"])",
                listOf("Counter", "defaultdict", "deque"),
                "Counter",
                "Counter counts how many times each item occurs.",
            ),
            choice(
                "What does a defaultdict(int) object return for a missing key?",
                listOf("0", "None", "KeyError", "An empty string"),
                0,
                "int() returns 0, so that's the default value.",
            ),
            output(
                "from collections import Counter\na = Counter(apples=3, pears=1)\nb = Counter(apples=1, pears=2)\nprint(a - b)",
                "Counter({'apples': 2})",
                "Subtracting Counters drops zero and negative results.",
            ),
            tiles(
                "Create a dictionary counter that starts new keys at 0",
                listOf("counter", "=", "defaultdict(", "int", ")"),
                listOf("0", "list"),
                "defaultdict needs a function that creates the default value – int() gives 0.",
            ),
        ),
        lesson(
            "u66l4", "Day 4: itertools",
            output(
                "from itertools import chain\nprint(list(chain([1, 2], (3,), \"ab\")))",
                "[1, 2, 3, 'a', 'b']",
                "chain joins several sequences into one.",
            ),
            output(
                "from itertools import combinations\nprint(list(combinations(\"ABC\", 2)))",
                "[('A', 'B'), ('A', 'C'), ('B', 'C')]",
                "combinations picks pairs without repetition and without regard to order.",
            ),
            output(
                "from itertools import product\nresults = list(product([0, 1], repeat=3))\nprint(len(results), results[-1])",
                "8 (1, 1, 1)",
                "product with repeat=3 creates all 2³ = 8 arrangements.",
            ),
            output(
                "from itertools import accumulate\nprint(list(accumulate([1, 2, 3, 4])))",
                "[1, 3, 6, 10]",
                "accumulate gives running totals.",
            ),
            output(
                "from itertools import groupby\ns = \"aaabbc\"\nprint([(k, len(list(g))) for k, g in groupby(s)])",
                "[('a', 3), ('b', 2), ('c', 1)]",
                "groupby groups consecutive identical items.",
            ),
            choice(
                "How many tuples does list(permutations([1, 2, 3])) give?",
                listOf("6", "3", "9", "27"),
                0,
                "The number of permutations of 3 items is 3! = 6.",
            ),
            fill(
                "Fill in the blank to take the first 3 values (the program should print [10, 15, 20]).",
                "from itertools import count, islice\nprint(list(islice(count(10, 5), ____)))",
                listOf("3", "None", "count"),
                "3",
                "islice cuts off the infinite count iterator after 3 items.",
            ),
            tiles(
                "Pair up the items of lists a and b",
                listOf("pairs", "=", "list(", "zip(a, b)", ")"),
                listOf("chain(a, b)", "product(a, b)"),
                "zip pairs items with the same indexes.",
            ),
        ),
        lesson(
            "u66l5", "Day 5: functools",
            output(
                "from functools import reduce\nprint(reduce(lambda a, b: a * b, [1, 2, 3, 4]))",
                "24",
                "reduce folds the list pair by pair: ((1 * 2) * 3) * 4.",
            ),
            output(
                "from functools import partial\ndef power(x, n):\n    return x ** n\nsquare = partial(power, n=2)\nprint(square(7))",
                "49",
                "partial sets some of the arguments in advance.",
            ),
            output(
                "from functools import lru_cache\ncalls = 0\n@lru_cache\ndef sq(x):\n    global calls\n    calls += 1\n    return x * x\nsq(3); sq(3); sq(4)\nprint(calls)",
                "2",
                "The second sq(3) takes the result from the cache.",
            ),
            output(
                "from functools import reduce\nwords = [\"a\", \"bb\", \"ccc\"]\nprint(reduce(lambda s, w: s + len(w), words, 0))",
                "6",
                "The third argument (0) is the initial value of the accumulator.",
            ),
            choice(
                "What does functools.wraps do in a decorator?",
                listOf("Copies the name and docstring of the original function", "Makes the original function run faster", "Remembers the results of the original function", "Turns the original function into a method"),
                0,
                "Thanks to wraps the decorated function keeps its __name__ and __doc__.",
            ),
            fill(
                "Fill in the blank so the class gets the missing comparisons (<=, >, >=).",
                "from functools import total_ordering\n@____\nclass Score:\n    def __init__(self, p): self.p = p\n    def __eq__(self, o): return self.p == o.p\n    def __lt__(self, o): return self.p < o.p\nprint(Score(3) >= Score(2))",
                listOf("total_ordering", "partial", "reduce"),
                "total_ordering",
                "total_ordering adds the rest of the comparisons based on __eq__ and __lt__.",
            ),
            output(
                "from functools import partial\nshow = partial(print, sep=\"-\")\nshow(1, 2, 3)",
                "1-2-3",
                "partial fixed sep=\"-\" for good.",
            ),
            tiles(
                "Sum the list numbers using reduce",
                listOf("reduce(", "lambda a, b:", "a + b,", "numbers", ")"),
                listOf("a * b,", "map("),
                "reduce adds the items pair by pair from the left.",
            ),
        ),
        lesson(
            "u66l6", "Day 6: Regular expressions",
            output(
                "import re\nprint(re.findall(r\"\\d+\", \"3 cats and 12 dogs\"))",
                "['3', '12']",
                "\\d+ matches runs of digits; findall returns strings.",
            ),
            output(
                "import re\nprint(re.sub(r\"\\s+\", \" \", \"a   b    c\"))",
                "a b c",
                "sub replaces every run of whitespace with a single space.",
            ),
            output(
                "import re\nm = re.search(r\"(\\d{2})-(\\d{3})\", \"code: 31-042\")\nprint(m.group(1), m.group(2))",
                "31 042",
                "Parentheses create groups, which you read with group().",
            ),
            choice(
                "What does \\d mean in a regular expression pattern?",
                listOf("Any digit", "Any letter", "The letter d", "The end of the string"),
                0,
                "\\d is a digit, \\w – a word character, \\s – a whitespace character.",
            ),
            fill(
                "Fill in the blank to check whether the whole string matches the pattern (the program should print False).",
                "import re\ncode = \"12-345x\"\nprint(bool(re.____(r\"\\d{2}-\\d{3}\", code)))",
                listOf("fullmatch", "search", "match"),
                "fullmatch",
                "fullmatch requires the whole string to match; match and search would find a fragment.",
            ),
            output(
                "import re\nprint(re.split(r\"[,;]\\s*\", \"a, b;c; d\"))",
                "['a', 'b', 'c', 'd']",
                "split cuts at each comma or semicolon, along with any spaces after it.",
            ),
            output(
                "import re\nm = re.match(r\"(?P<n>\\w+) (?P<a>\\d+)\", \"Amy 25\")\nprint(m[\"n\"], int(m[\"a\"]) + 1)",
                "Amy 26",
                "Named groups are read by name.",
            ),
            tiles(
                "Find all words that start with a capital letter in the string text",
                listOf("re.findall(", "r\"[A-Z]\\w*\",", "text", ")"),
                listOf("re.sub(", "r\"[a-z]\\w*\","),
                "[A-Z] is a capital letter, and \\w* – the rest of the word.",
            ),
        ),
        lesson(
            "u66l7", "Day 7: JSON",
            output(
                "import json\nd = {\"name\": \"Amy\", \"ok\": True, \"pts\": None}\nprint(json.dumps(d))",
                "{\"name\": \"Amy\", \"ok\": true, \"pts\": null}",
                "In JSON True is true, None is null, and strings use double quotes.",
            ),
            output(
                "import json\ndata = json.loads('{\"a\": [1, 2], \"b\": 3.5}')\nprint(data[\"a\"][1] + data[\"b\"])",
                "5.5",
                "loads turns JSON text into a dictionary with a list and a number.",
            ),
            output(
                "import json\nx = json.loads(json.dumps({\"p\": (1, 2)}))\nprint(x)",
                "{'p': [1, 2]}",
                "JSON has no tuples – they come back as lists.",
            ),
            output(
                "import json\nx = json.loads(json.dumps({1: \"a\"}))\nprint(x, 1 in x)",
                "{'1': 'a'} False",
                "Keys in JSON are always strings.",
            ),
            choice(
                "Which type can't be written directly with json.dumps?",
                listOf("set", "list", "dict", "bool"),
                0,
                "A set has to be converted first, e.g. to a list.",
            ),
            fill(
                "Fill in the blank so the keys are sorted (the program should print {\"a\": 2, \"b\": 1}).",
                "import json\nprint(json.dumps({\"b\": 1, \"a\": 2}, ____=True))",
                listOf("sort_keys", "indent", "reverse"),
                "sort_keys",
                "sort_keys=True sorts the keys in the result.",
            ),
            output(
                "import json\ntry:\n    json.loads(\"{'a': 1}\")\nexcept json.JSONDecodeError:\n    print(\"bad JSON\")",
                "bad JSON",
                "JSON requires double quotes, so single quotes cause an error.",
            ),
            tiles(
                "Write the dictionary data to the open file f as JSON",
                listOf("json.dump(", "data,", "f", ")"),
                listOf("json.dumps(", "f.write("),
                "dump writes to a file, and dumps returns a string.",
            ),
        ),
    ),
)
