package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

internal val module38Intro = lesson(
    "u38l0", "Introduction: the collections module",
    explain(
        "Counter – counting",
        "The `collections` module has improved versions of lists and dictionaries. `Counter` " +
            "counts how many times each element appears. A missing element has a count of 0, and " +
            "`most_common(n)` returns the n most common pairs.",
        code = "from collections import Counter\nc = Counter(\"banana\")\nprint(c[\"n\"], c[\"x\"])\nprint(c.most_common(1))",
        output = "2 0\n[('a', 3)]",
    ),
    explain(
        "defaultdict – a default value",
        "A `defaultdict` is a dictionary that creates a missing key by itself. You give it a " +
            "function (without parentheses): `int` gives 0, and `list` gives an empty list. " +
            "No more KeyError with `+= 1`.",
        code = "from collections import defaultdict\nd = defaultdict(list)\nd[\"fruits\"].append(\"apple\")\nprint(d[\"fruits\"])",
        output = "['apple']",
    ),
    explain(
        "namedtuple – a tuple with names",
        "`namedtuple` creates a new tuple type whose fields have names. Instead of `p[0]` you " +
            "write `p.x` – the code is easier to read. It's still a tuple: indexing works and " +
            "you can't change it.",
        code = "from collections import namedtuple\nPoint = namedtuple(\"Point\", [\"x\", \"y\"])\np = Point(3, 4)\nprint(p.x, p[1])\nprint(p)",
        output = "3 4\nPoint(x=3, y=4)",
    ),
    explain(
        "deque – a double-ended queue",
        "A `deque` lets you quickly add and remove elements at both ends: `append`, " +
            "`appendleft`, `pop`, `popleft`. `rotate(n)` rotates the elements, and `maxlen` limits " +
            "the length – old elements drop off.",
        code = "from collections import deque\nd = deque([1, 2, 3])\nd.appendleft(0)\nprint(d.popleft(), d.pop())\nd.rotate(1)\nprint(list(d))",
        output = "0 3\n[2, 1]",
    ),
    explain(
        "Order in a dictionary",
        "Since Python 3.7, a regular `dict` remembers the order in which keys were inserted. " +
            "`OrderedDict` adds extra methods, such as `move_to_end`, which moves a key to the end.",
        code = "from collections import OrderedDict\nd = OrderedDict(a=1, b=2, c=3)\nd.move_to_end(\"a\")\nprint(list(d))",
        output = "['b', 'c', 'a']",
    ),
    choice(
        "What does a Counter return for an element that isn't there?",
        listOf("0", "KeyError", "None", "-1"),
        0,
        "For a missing element, Counter returns 0.",
    ),
    output(
        "from collections import defaultdict\nd = defaultdict(int)\nfor ch in \"aba\":\n    d[ch] += 1\nprint(d[\"a\"], d[\"c\"])",
        "2 0",
        "defaultdict(int) gives 0 for a missing key.",
    ),
    fill(
        "Fill in the blank to remove an element from the left side of the queue.",
        "from collections import deque\nd = deque([5, 6, 7])\nprint(d.____())",
        listOf("popleft", "pop", "left", "shift"),
        "popleft",
        "popleft removes an element from the left end of a deque.",
    ),
)
