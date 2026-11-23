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
        "u65l2",
        explain(
            "How fast sorted() is",
            "Bubble sort compares elements in pairs with a loop inside a loop – that's O(n²). The built-in `sorted()` and `sort()` " +
                "use an algorithm called Timsort, which runs in O(n log n). For 1024 elements, n² is over a million steps, " +
                "while n log n (log₂ 1024 = 10) is about 10 thousand.",
            code = "n = 1024\nprint(n * n, n * 10)",
            output = "1048576 10240",
        ),
    ),
    cards(
        "u65l3",
        explain(
            "Logarithm: math.log2",
            "`math.log2(n)` tells you the power you have to raise 2 to in order to get `n` – that is, how many times " +
                "you can halve `n` before reaching 1. That's the number of steps of an O(log n) algorithm, e.g. binary search.",
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
    cards(
        "u65l7",
        explain(
            "Divide and conquer: merging",
            "Merge sort splits the list into two halves, sorts each half recursively and then merges them into one: " +
                "it keeps taking the smaller element from the fronts of the two sorted lists. That's the \"divide and conquer\" " +
                "approach: split the problem into smaller parts, solve them and combine the results. This sort runs in O(n log n).",
            code = "a, b = [1, 5], [2, 9]\nout = []\nwhile a and b:\n    out.append((a if a[0] <= b[0] else b).pop(0))\nprint(out + a + b)",
            output = "[1, 2, 5, 9]",
        ),
        explain(
            "Quicksort: the pivot",
            "Quicksort also divides and conquers: it picks a pivot (e.g. the first element), splits the rest into elements " +
                "smaller than it and not smaller, sorts both parts recursively and joins them: smaller + [pivot] + larger.",
            code = "t = [3, 6, 1, 8, 2]\np = t[0]\nprint([x for x in t[1:] if x < p], p, [x for x in t[1:] if x >= p])",
            output = "[1, 2] 3 [6, 8]",
        ),
    ),
)
