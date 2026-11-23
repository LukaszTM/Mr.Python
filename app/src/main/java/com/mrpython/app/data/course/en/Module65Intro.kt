package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

internal val module65Intro = lesson(
    "u65l0", "Introduction: review week – algorithms",
    explain(
        "Searching",
        "This week reviews algorithms. Linear search checks element after element. " +
            "Binary search works on a sorted list and halves the range every time – it comes ready-made in `bisect`.",
        code = "import bisect\nt = [10, 20, 30, 40]\nprint(bisect.bisect_left(t, 30))",
        output = "2",
    ),
    explain(
        "Sorting with a key",
        "`sort()` and `sorted()` accept `key=`. A tuple in the key sorts by several criteria, " +
            "and a minus sign reverses the order of numbers – here: points descending, names ascending.",
        code = "d = [(\"Mia\", 5), (\"Tom\", 4), (\"Amy\", 5)]\nd.sort(key=lambda u: (-u[1], u[0]))\nprint([u[0] for u in d])",
        output = "['Amy', 'Mia', 'Tom']",
    ),
    explain(
        "Complexity",
        "Complexity tells you how running time grows with the size of the data: one loop is O(n), a loop in a loop " +
            "is O(n²), and halving is O(log n). For 16 elements that's just 4 steps.",
        code = "n, steps = 16, 0\nwhile n > 1:\n    n //= 2\n    steps += 1\nprint(steps)",
        output = "4",
    ),
    explain(
        "Stack and queue",
        "A stack (LIFO) removes the most recently added element – a list and `pop()` are enough. A queue (FIFO) " +
            "serves the oldest one first – use `deque` and `popleft()`.",
        code = "from collections import deque\nstack = [1, 2, 3]\nq = deque([1, 2, 3])\nprint(stack.pop(), q.popleft())",
        output = "3 1",
    ),
    explain(
        "Math and recursion",
        "The classics are back: Euclid's algorithm computes the GCD, the sieve finds prime numbers, and recursion " +
            "splits a problem into smaller ones (e.g. merge sort).",
        code = "def gcd(a, b):\n    while b:\n        a, b = b, a % b\n    return a\nprint(gcd(48, 18))",
        output = "6",
    ),
    choice(
        "Which structure returns the most recently added element first?",
        listOf("stack", "queue", "set", "dictionary"),
        0,
        "A stack follows the LIFO rule – last in, first out.",
    ),
    output(
        "t = [3, 1, 2]\nprint(sorted(t, key=lambda x: -x))",
        "[3, 2, 1]",
        "A key with a minus sign sorts numbers in descending order.",
    ),
)
