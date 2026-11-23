package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

internal val module38Cards = listOf(
    cards(
        "u38l1",
        explain(
            "A Counter is a dictionary",
            "A Counter works like a dictionary: the element is the key and the number of occurrences " +
                "is the value. You can modify it (`c[\"b\"] += 2`), and `len(c)` tells you how many " +
                "different elements there are. `print(c)` shows the pairs starting with the most " +
                "common one, wrapped in the name `Counter`.",
            code = "from collections import Counter\nc = Counter(\"aab\")\nc[\"b\"] += 2\nprint(c)\nprint(len(c), dict(c))",
            output = "Counter({'b': 3, 'a': 2})\n2 {'a': 2, 'b': 3}",
        ),
        explain(
            "most_common() without a number",
            "`most_common()` with no argument returns all (element, count) pairs from the most " +
                "common to the least common. In a tie, the element that appeared earlier comes first.",
            code = "from collections import Counter\nprint(Counter(\"salsa\").most_common())",
            output = "[('s', 2), ('a', 2), ('l', 1)]",
        ),
        explain(
            "Counting words",
            "A Counter counts the elements of whatever it gets. From a string it counts letters, but " +
                "from a list of words (e.g. after `split()`) it counts whole words.",
            code = "from collections import Counter\nc = Counter(\"to be or not to be\".split())\nprint(c[\"to\"], c[\"or\"])",
            output = "2 1",
        ),
    ),
    cards(
        "u38l2",
        explain(
            "Reading creates the key",
            "In a `defaultdict`, just reading a missing key adds it to the dictionary with the " +
                "default value. An `in` check creates nothing. `dict(d)` turns it into a regular " +
                "dictionary.",
            code = "from collections import defaultdict\nd = defaultdict(int)\nprint(\"x\" in d)\nprint(d[\"x\"], len(d))\nprint(dict(d))",
            output = "False\n0 1\n{'x': 0}",
        ),
        explain(
            "Other default values",
            "You can pass any function that takes no arguments: `str` gives an empty string, `set` " +
                "an empty set, and `lambda: \"missing\"` – your own value.",
            code = "from collections import defaultdict\nd = defaultdict(lambda: \"missing\")\nz = defaultdict(set)\nz[\"a\"].add(1)\nprint(d[\"y\"], z[\"a\"])",
            output = "missing {1}",
        ),
    ),
    cards(
        "u38l3",
        explain(
            "Creating and unpacking",
            "You can pass the fields by name, in any order. A namedtuple is a tuple, so you can " +
                "unpack it, compare it with a regular tuple and use `len` or `in`.",
            code = "from collections import namedtuple\nP = namedtuple(\"P\", [\"x\", \"y\"])\np = P(y=2, x=7)\nx, y = p\nprint(p, x)\nprint(p == (7, 2), len(p))",
            output = "P(x=7, y=2) 7\nTrue 2",
        ),
        explain(
            "_replace – a modified copy",
            "A namedtuple is immutable, so `p.x = 5` raises an `AttributeError`. The `_replace(field=value)` " +
                "method creates a new tuple with the field changed, and the original stays the same.",
            code = "from collections import namedtuple\nP = namedtuple(\"P\", [\"x\", \"y\"])\np = P(1, 2)\nq = p._replace(y=9)\nprint(p, q)",
            output = "P(x=1, y=2) P(x=1, y=9)",
        ),
    ),
    cards(
        "u38l4",
        explain(
            "The direction of rotate",
            "`rotate(n)` with a positive n shifts the elements to the right: the last ones move to " +
                "the front. A negative n rotates to the left: the first ones move to the end.",
            code = "from collections import deque\nd = deque([1, 2, 3, 4])\nd.rotate(1)\nprint(list(d))\nd.rotate(-2)\nprint(list(d))",
            output = "[4, 1, 2, 3]\n[2, 3, 4, 1]",
        ),
        explain(
            "A deque is like a list",
            "You create a deque from a list, a string or a `range`, and `maxlen` keeps only the " +
                "last elements. `len` works, so do the indexes `d[0]` and `d[-1]`, and `print` " +
                "shows it with the name `deque`. A list also has `pop(0)`, but then it has to shift all " +
                "the remaining elements, so it is slow for a long list – a deque removes from the " +
                "front quickly.",
            code = "from collections import deque\nd = deque(\"abcd\", maxlen=3)\nprint(d)\nprint(len(d), d[0], d.maxlen)",
            output = "deque(['b', 'c', 'd'], maxlen=3)\n3 b 3",
        ),
        explain(
            "A deleted key comes back at the end",
            "A dictionary remembers insertion order. When you remove a key with `del` and insert " +
                "it again, it goes to the end of the order.",
            code = "d = {\"a\": 1, \"b\": 2}\ndel d[\"a\"]\nd[\"a\"] = 9\nprint(list(d))",
            output = "['b', 'a']",
        ),
    ),
)
