package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*
import com.mrpython.app.domain.CourseUnit

internal val module38 = CourseUnit(
    id = "u38",
    title = "The collections module",
    description = "Counter, defaultdict, namedtuple, deque and OrderedDict",
    lessons = listOf(
        lesson(
            "u38l1", "Counter",
            output(
                "from collections import Counter\nc = Counter(\"abracadabra\")\nprint(c[\"a\"])",
                "5",
                "Counter counts occurrences – the letter \"a\" appears 5 times.",
            ),
            choice(
                "What does c[7] return for this Counter?",
                listOf("0", "KeyError", "None", "7"),
                0,
                "For a missing element, Counter returns 0 instead of raising KeyError.",
                code = "from collections import Counter\nc = Counter([1, 2, 2, 3, 3, 3])",
            ),
            output(
                "from collections import Counter\nc = Counter(\"cat\")\nprint(c)",
                "Counter({'c': 1, 'a': 1, 't': 1})",
                "A Counter prints like a dictionary wrapped in the class name.",
            ),
            output(
                "from collections import Counter\nc = Counter(\"mommy\")\nprint(c.most_common(1))",
                "[('m', 3)]",
                "most_common(1) returns a list with one pair: the most common element and its count.",
            ),
            fill(
                "Fill in the blank to print the two most common words.",
                "from collections import Counter\nwords = [\"a\", \"b\", \"a\", \"c\", \"a\", \"b\"]\nc = Counter(words)\nprint(c.____(2))",
                listOf("most_common", "top", "max", "count"),
                "most_common",
                "The most_common(n) method returns the n most common elements.",
            ),
            choice(
                "Where do we import Counter from?",
                listOf("from collections import Counter", "import Counter", "from itertools import Counter", "from math import Counter"),
                0,
                "Counter lives in the collections module.",
            ),
            output(
                "from collections import Counter\nc = Counter(\"aab\")\nc[\"b\"] += 2\nprint(c.most_common())",
                "[('b', 3), ('a', 2)]",
                "You can modify a Counter like a dictionary; most_common() with no argument sorts everything in descending order.",
            ),
            tiles(
                "Count the letters in the word \"llama\"",
                listOf("c", "=", "Counter(", "\"llama\"", ")"),
                listOf("Counter[", "]"),
                "Counter accepts any object you can iterate over, such as a string.",
            ),
        ),
        lesson(
            "u38l2", "defaultdict",
            output(
                "from collections import defaultdict\nd = defaultdict(int)\nd[\"x\"] += 1\nd[\"x\"] += 1\nprint(d[\"x\"])",
                "2",
                "defaultdict(int) creates a missing key with the value 0.",
            ),
            choice(
                "What will this code print?",
                listOf("0", "KeyError", "None", "missing"),
                0,
                "Reading a missing key doesn't raise KeyError – the default value int() is created, which is 0.",
                code = "from collections import defaultdict\nd = defaultdict(int)\nprint(d[\"missing\"])",
            ),
            output(
                "from collections import defaultdict\nd = defaultdict(list)\nd[\"a\"].append(1)\nd[\"a\"].append(2)\nprint(d[\"a\"])",
                "[1, 2]",
                "defaultdict(list) creates an empty list for a new key.",
            ),
            output(
                "from collections import defaultdict\ngroups = defaultdict(list)\nfor s in [\"amy\", \"bob\", \"eve\", \"adam\"]:\n    groups[s[0]].append(s)\nprint(groups[\"a\"])",
                "['amy', 'adam']",
                "The words were grouped by their first letter.",
            ),
            fill(
                "Fill in the blank so that missing keys get an empty list.",
                "from collections import defaultdict\nd = defaultdict(____)\nd[\"k\"].append(5)\nprint(d[\"k\"])",
                listOf("list", "int", "[]", "None"),
                "list",
                "We pass the list function itself (no parentheses), which creates an empty list.",
            ),
            choice(
                "What do we pass to defaultdict?",
                listOf("A function, e.g. int", "A value, e.g. 0", "A key, e.g. \"a\"", "A length, e.g. 10"),
                0,
                "defaultdict calls the given function when a key is missing (int() gives 0). It won't accept a ready-made value such as 0.",
            ),
            output(
                "from collections import defaultdict\nd = defaultdict(int)\nfor ch in \"kayak\":\n    d[ch] += 1\nprint(dict(d))",
                "{'k': 2, 'a': 2, 'y': 1}",
                "This is counting letters by hand – the keys are in order of first appearance.",
            ),
            choice(
                "What happens in a regular dictionary with d[\"x\"] += 1 when the key \"x\" doesn't exist?",
                listOf("KeyError", "The key gets the value 1", "The key gets the value 0", "Nothing"),
                0,
                "A regular dict has no default value, so it raises KeyError.",
            ),
        ),
        lesson(
            "u38l3", "namedtuple",
            output(
                "from collections import namedtuple\nPoint = namedtuple(\"Point\", [\"x\", \"y\"])\np = Point(3, 4)\nprint(p.x + p.y)",
                "7",
                "We access namedtuple fields by name.",
            ),
            output(
                "from collections import namedtuple\nPoint = namedtuple(\"Point\", [\"x\", \"y\"])\np = Point(1, 2)\nprint(p)",
                "Point(x=1, y=2)",
                "A namedtuple prints in a readable form with field names.",
            ),
            output(
                "from collections import namedtuple\nPoint = namedtuple(\"Point\", [\"x\", \"y\"])\np = Point(5, 6)\nprint(p[0])",
                "5",
                "A namedtuple is still a tuple – indexing works too.",
            ),
            output(
                "from collections import namedtuple\nPerson = namedtuple(\"Person\", [\"name\", \"age\"])\nname, age = Person(\"Amy\", 30)\nprint(name)",
                "Amy",
                "You can unpack a namedtuple like a regular tuple.",
            ),
            choice(
                "What happens after p.x = 10 when p is a namedtuple?",
                listOf("AttributeError", "x changes to 10", "A new field x is created", "SyntaxError"),
                0,
                "Like every tuple, a namedtuple is immutable, so assigning to a field raises AttributeError.",
                code = "from collections import namedtuple\nP = namedtuple(\"P\", [\"x\"])\np = P(1)\np.x = 10",
            ),
            fill(
                "Fill in the blank to create a Color type with the fields r, g, b.",
                "from collections import namedtuple\nColor = ____(\"Color\", [\"r\", \"g\", \"b\"])\nprint(Color(1, 2, 3).g)",
                listOf("namedtuple", "tuple", "dict", "Counter"),
                "namedtuple",
                "namedtuple creates a new tuple type with named fields.",
            ),
            output(
                "from collections import namedtuple\nP = namedtuple(\"P\", [\"x\", \"y\"])\np = P(1, 2)\nq = p._replace(y=9)\nprint(p.y, q.y)",
                "2 9",
                "_replace creates a new tuple; the original doesn't change.",
            ),
            tiles(
                "Create a point p with the coordinates 2 and 5",
                listOf("p", "=", "Point(", "2,", "5", ")"),
                listOf("Point[", "]"),
                "We call a namedtuple type like a class.",
            ),
        ),
        lesson(
            "u38l4", "deque and dict order",
            output(
                "from collections import deque\nd = deque([1, 2, 3])\nd.appendleft(0)\nd.append(4)\nprint(list(d))",
                "[0, 1, 2, 3, 4]",
                "A deque lets you add quickly at both ends.",
            ),
            output(
                "from collections import deque\nd = deque([1, 2, 3])\nprint(d.popleft(), d.pop())",
                "1 3",
                "popleft removes from the left, pop from the right.",
            ),
            output(
                "from collections import deque\nd = deque([1, 2, 3, 4])\nd.rotate(1)\nprint(list(d))",
                "[4, 1, 2, 3]",
                "rotate(1) shifts the elements one position to the right.",
            ),
            choice(
                "What will the deque look like after d.rotate(-1)?",
                listOf("[2, 3, 4, 1]", "[4, 1, 2, 3]", "[1, 2, 3]", "[1, 2, 3, 4]"),
                0,
                "A negative argument rotates to the left.",
                code = "from collections import deque\nd = deque([1, 2, 3, 4])\nd.rotate(-1)",
            ),
            output(
                "from collections import deque\nd = deque(maxlen=3)\nfor i in range(5):\n    d.append(i)\nprint(list(d))",
                "[2, 3, 4]",
                "With maxlen, the oldest elements drop off the other end.",
            ),
            fill(
                "Fill in the blank so the deque remembers only the last 2 elements.",
                "from collections import deque\nd = deque(____=2)\nfor x in \"abc\":\n    d.append(x)\nprint(list(d))",
                listOf("maxlen", "size", "limit", "len"),
                "maxlen",
                "The maxlen parameter limits the length of the queue.",
            ),
            output(
                "d = {}\nd[\"b\"] = 1\nd[\"a\"] = 2\nd[\"c\"] = 3\nprint(list(d))",
                "['b', 'a', 'c']",
                "Since Python 3.7, a regular dict remembers insertion order.",
            ),
            output(
                "from collections import OrderedDict\nd = OrderedDict(a=1, b=2, c=3)\nd.move_to_end(\"a\")\nprint(list(d))",
                "['b', 'c', 'a']",
                "OrderedDict has extra methods, such as move_to_end.",
            ),
        ),
        lesson(
            "u38l5", "Review: collections",
            choice(
                "Which tool would you use to count how many times each word appears?",
                listOf("Counter", "deque", "namedtuple", "OrderedDict"),
                0,
                "Counter is made for counting.",
            ),
            choice(
                "Which tool works best as a queue with fast removal from the front?",
                listOf("deque", "list", "Counter", "namedtuple"),
                0,
                "deque.popleft() is fast, while list.pop(0) has to shift the elements.",
            ),
            output(
                "from collections import Counter\nc = Counter([\"x\", \"y\", \"x\"])\nprint(c.most_common(1)[0][0])",
                "x",
                "We take the first pair and then just the element from it.",
            ),
            output(
                "from collections import defaultdict\nd = defaultdict(int)\nfor n in [1, 2, 1, 1]:\n    d[n] += 1\nprint(d[1], d[2], d[3])",
                "3 1 0",
                "The missing key 3 gets the value 0.",
            ),
            output(
                "from collections import deque\nd = deque(\"abc\", maxlen=3)\nd.append(\"d\")\nprint(\"\".join(d))",
                "bcd",
                "Adding \"d\" pushed \"a\" out on the left side.",
            ),
            fill(
                "Fill in the blank to shift the elements 2 positions to the right.",
                "from collections import deque\nd = deque([1, 2, 3, 4])\nd.____(2)\nprint(list(d))",
                listOf("rotate", "shift", "move", "roll"),
                "rotate",
                "Rotating a deque is done with the rotate method.",
            ),
            output(
                "from collections import namedtuple\nCard = namedtuple(\"Card\", [\"suit\", \"value\"])\nc = Card(\"spades\", 10)\nprint(c.value * 2)",
                "20",
                "The value field holds 10.",
            ),
            tiles(
                "Create a dictionary in which missing keys get an empty list",
                listOf("d", "=", "defaultdict(", "list", ")"),
                listOf("list()", "Counter("),
                "defaultdict(list) creates an empty list for a new key.",
            ),
        ),
    ),
)
