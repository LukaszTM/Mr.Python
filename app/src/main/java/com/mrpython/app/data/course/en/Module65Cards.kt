package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

internal val module65Cards = listOf(
    cards(
        "u65l1",
        explain(
            "bisect: where to insert?",
            "The `bisect` module uses binary search to find the place for a value in a sorted list. " +
                "`bisect_left` gives the index before equal elements, and `bisect` (the same as `bisect_right`) – after them.",
            code = "import bisect\nt = [10, 20, 20, 30]\nprint(bisect.bisect_left(t, 20))\nprint(bisect.bisect(t, 20))",
            output = "1\n3",
        ),
        explain(
            "Inserting: insort",
            "`bisect.insort(a_list, x)` inserts `x` straight into the right place, " +
                "so the list stays sorted without sorting it again.",
            code = "import bisect\nt = [1, 3, 5]\nbisect.insort(t, 4)\nprint(t)",
            output = "[1, 3, 4, 5]",
        ),
    ),
    cards(
        "u65l3",
        explain(
            "Logarithm: math.log2",
            "`math.log2(n)` tells you how many times you have to multiply 2 to get `n` – that is, how many times " +
                "you can halve it. That's the number of steps of an O(log n) algorithm, e.g. binary search.",
            code = "import math\nprint(math.log2(16))\nprint(math.ceil(math.log2(1000)))",
            output = "4.0\n10",
        ),
    ),
    cards(
        "u65l4",
        explain(
            "Heap: heapq",
            "The `heapq` module turns a regular list into a heap – a priority queue. `heapify` arranges the list, " +
                "`heappush` adds an element, and `heappop` always removes the smallest one.",
            code = "import heapq\nh = [5, 1, 8, 3]\nheapq.heapify(h)\nheapq.heappush(h, 2)\nprint(heapq.heappop(h), heapq.heappop(h))",
            output = "1 2",
        ),
        explain(
            "Priorities and the smallest items",
            "A heap often holds tuples (priority, task) – the priority is compared first. " +
                "`nsmallest(n, t)` and `nlargest(n, t)` return the n smallest or largest elements.",
            code = "import heapq\nh = []\nheapq.heappush(h, (2, \"laundry\"))\nheapq.heappush(h, (1, \"dinner\"))\nprint(heapq.heappop(h)[1])\nprint(heapq.nsmallest(2, [7, 2, 9]), heapq.nlargest(1, [7, 2, 9]))",
            output = "dinner\n[2, 7] [9]",
        ),
    ),
    cards(
        "u65l5",
        explain(
            "Factorial: math.factorial",
            "The factorial n! is the product of the numbers from 1 to n, e.g. 5! = 1·2·3·4·5. Instead of writing a loop, " +
                "use `math.factorial(n)`.",
            code = "import math\nprint(math.factorial(5))\nprint(math.factorial(5) // math.factorial(3))",
            output = "120\n20",
        ),
    ),
)
