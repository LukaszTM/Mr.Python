package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*
import com.mrpython.app.domain.CourseUnit

internal val module65 = CourseUnit(
    id = "u65",
    title = "Review week: algorithms",
    description = "Searching, sorting, complexity, stacks and recursion",
    lessons = listOf(
        lesson(
            "u65l1", "Day 1: Searching",
            output(
                "def search(items, x):\n    for i, v in enumerate(items):\n        if v == x:\n            return i\n    return -1\nprint(search([4, 8, 15], 15), search([4, 8], 3))",
                "2 -1",
                "Linear search returns the index, or -1 when the element isn't there.",
            ),
            output(
                "def binary(t, x):\n    lo, hi, steps = 0, len(t) - 1, 0\n    while lo <= hi:\n        steps += 1\n        mid = (lo + hi) // 2\n        if t[mid] == x:\n            return steps\n        if t[mid] < x: lo = mid + 1\n        else: hi = mid - 1\nprint(binary([1, 3, 5, 7, 9, 11, 13], 13))",
                "3",
                "It checks 7, 11 and 13 in turn – each time half of the range is discarded.",
            ),
            choice(
                "What condition must a list meet for binary search to be used?",
                listOf("It must be sorted", "It must have an even length", "It can't have duplicates", "It must contain only numbers"),
                0,
                "Binary search relies on the order of the elements.",
            ),
            choice(
                "Roughly how many comparisons are enough to binary search 1000 sorted elements?",
                listOf("About 10", "About 100", "About 500", "1000"),
                0,
                "2 to the power of 10 is 1024, so about 10 halvings are enough.",
            ),
            output(
                "import bisect\nthresholds = [50, 60, 75, 90]\nprint(bisect.bisect(thresholds, 80))",
                "3",
                "bisect returns the place where 80 would have to be inserted to keep the order.",
            ),
            fill(
                "Fill in the blank so the binary search works correctly.",
                "def binary(t, x):\n    lo, hi = 0, len(t) - 1\n    while lo <= hi:\n        mid = (lo + hi) // 2\n        if t[mid] == x:\n            return mid\n        if t[mid] < x: lo = ____\n        else: hi = mid - 1\n    return -1\nprint(binary([2, 4, 6, 8], 8))",
                listOf("mid + 1", "mid", "mid - 1"),
                "mid + 1",
                "We've already checked element mid, so we search from mid + 1; otherwise the loop would never end.",
            ),
            tiles(
                "Print whether any number in the list numbers is negative",
                listOf("print(", "any(", "x < 0", "for x in numbers", "))"),
                listOf("all(", "x > 0"),
                "any() returns True when at least one element meets the condition.",
            ),
            output(
                "numbers = [3, 8, 1, 9, 4]\nbest = numbers[0]\nfor n in numbers[1:]:\n    if n > best:\n        best = n\nprint(best, numbers.index(best))",
                "9 3",
                "We find the maximum by hand, and index() gives its position.",
            ),
        ),
        lesson(
            "u65l2", "Day 2: Sorting",
            output(
                "t = [5, 1, 4, 2]\nfor i in range(len(t) - 1):\n    if t[i] > t[i + 1]:\n        t[i], t[i + 1] = t[i + 1], t[i]\nprint(t)",
                "[1, 4, 2, 5]",
                "One pass of bubble sort moves the largest element to the end.",
            ),
            output(
                "data = [(\"Mia\", 5), (\"Tom\", 4), (\"Amy\", 5)]\ndata.sort(key=lambda u: (-u[1], u[0]))\nprint([u[0] for u in data])",
                "['Amy', 'Mia', 'Tom']",
                "First descending by grade, and alphabetically by name in case of a tie.",
            ),
            choice(
                "How is my_list.sort() different from sorted(my_list)?",
                listOf("sort() changes the list, sorted() returns a new one", "sorted() changes the list, sort() returns a new one", "sort() only works on numbers, sorted() on anything", "It isn't – they're two names for one function"),
                0,
                "sort() sorts the list in place and returns None, while sorted() returns a new list and leaves the original alone.",
            ),
            output(
                "data = [(\"b\", 1), (\"a\", 2), (\"c\", 1)]\ndata.sort(key=lambda p: p[1])\nprint(data)",
                "[('b', 1), ('c', 1), ('a', 2)]",
                "Sorting in Python is stable: equal keys keep their order.",
            ),
            fill(
                "Fill in the blank to sort in descending order (the program should print [10, 7, 3]).",
                "numbers = [3, 10, 7]\nprint(sorted(numbers, ____=True))",
                listOf("reverse", "desc", "key"),
                "reverse",
                "reverse=True reverses the sort order.",
            ),
            output(
                "def insertion_sort(t):\n    for i in range(1, len(t)):\n        x, j = t[i], i - 1\n        while j >= 0 and t[j] > x:\n            t[j + 1] = t[j]\n            j -= 1\n        t[j + 1] = x\n    return t\nprint(insertion_sort([3, 1, 2]))",
                "[1, 2, 3]",
                "Insertion sort puts each element into its proper place.",
            ),
            choice(
                "What is the worst-case complexity of bubble sort?",
                listOf("O(n²)", "O(n log n)", "O(n)", "O(log n)"),
                0,
                "Two nested loops over n elements give O(n²).",
            ),
            tiles(
                "Sort the words ignoring upper and lower case",
                listOf("sorted(", "words,", "key=", "str.lower", ")"),
                listOf("str.lower()", "reverse="),
                "key takes a function (without parentheses), e.g. str.lower.",
            ),
        ),
        lesson(
            "u65l3", "Day 3: Computational complexity",
            choice(
                "What is the complexity of this function?",
                listOf("O(n)", "O(1)", "O(n²)", "O(log n)"),
                0,
                "One loop over all the elements is O(n).",
                code = "def total(t):\n    s = 0\n    for x in t:\n        s += x\n    return s",
            ),
            choice(
                "What is the complexity of this function?",
                listOf("O(n²)", "O(n)", "O(2n)", "O(log n)"),
                0,
                "For each of the n elements we do n steps.",
                code = "def pairs(t):\n    for a in t:\n        for b in t:\n            print(a, b)",
            ),
            choice(
                "Which operation is O(1) on average?",
                listOf("x in my_set", "x in my_list", "my_list.index(x)", "sorted(my_list)"),
                0,
                "Sets (and dictionaries) check membership using hashing.",
            ),
            output(
                "n, steps = 16, 0\nwhile n > 1:\n    n //= 2\n    steps += 1\nprint(steps)",
                "4",
                "Dividing by 2 down to 1 takes log₂(16) = 4 steps – O(log n) complexity.",
            ),
            output(
                "count = 0\nfor i in range(4):\n    for j in range(i):\n        count += 1\nprint(count)",
                "6",
                "0 + 1 + 2 + 3 = 6 – loops like these are still O(n²).",
            ),
            tiles(
                "Turn the list items into a set called fast, to check for elements quickly",
                listOf("fast", "=", "set(", "items", ")"),
                listOf("list(", "dict("),
                "Checking x in a set is O(1) on average.",
            ),
            fill(
                "Fill in the blank so the membership check is fast (O(1)).",
                "banned = ____([\"spam\", \"ad\", \"virus\"])\nprint(\"virus\" in banned)",
                listOf("set", "len", "int"),
                "set",
                "A set checks membership in constant time.",
            ),
            output(
                "def has_duplicates(t):\n    return len(t) != len(set(t))\nprint(has_duplicates([1, 2, 1]))\nprint(has_duplicates([1, 2]))",
                "True\nFalse",
                "A set removes repeats – O(n) instead of comparing every pair.",
            ),
        ),
        lesson(
            "u65l4", "Day 4: Stacks and queues",
            output(
                "stack = []\nstack.append(1)\nstack.append(2)\nstack.append(3)\nprint(stack.pop(), stack.pop())",
                "3 2",
                "A stack is LIFO: pop() removes the most recently added element.",
            ),
            output(
                "from collections import deque\nq = deque([\"Amy\", \"Tom\"])\nq.append(\"Eve\")\nprint(q.popleft(), len(q))",
                "Amy 2",
                "A queue is FIFO: popleft() takes the element from the front.",
            ),
            output(
                "def balanced(s):\n    stack = []\n    pairs = {\")\": \"(\", \"]\": \"[\"}\n    for c in s:\n        if c in \"([\":\n            stack.append(c)\n        elif not stack or stack.pop() != pairs[c]:\n            return False\n    return not stack\nprint(balanced(\"([])\"), balanced(\"(]\"))",
                "True False",
                "Every closing bracket must match the last one opened.",
            ),
            choice(
                "Which rule describes a queue?",
                listOf("FIFO – first in, first out", "LIFO – last in, first out", "Random order", "The smallest goes out first"),
                0,
                "A queue works like a line at a store.",
            ),
            fill(
                "Fill in the blank to take the element from the front of the queue (the program should print 1).",
                "from collections import deque\nq = deque([1, 2, 3])\nprint(q.____())",
                listOf("popleft", "pop", "append"),
                "popleft",
                "popleft() takes the element from the left side.",
            ),
            output(
                "import heapq\nh = [5, 1, 8, 3]\nheapq.heapify(h)\nprint(heapq.heappop(h), heapq.heappop(h))",
                "1 3",
                "A heap always gives back the smallest element – it's a priority queue.",
            ),
            output(
                "stack = []\nfor t in \"3 4 + 2 *\".split():\n    if t.isdigit():\n        stack.append(int(t))\n    else:\n        b, a = stack.pop(), stack.pop()\n        stack.append(a + b if t == \"+\" else a * b)\nprint(stack[0])",
                "14",
                "Reverse Polish notation: (3 + 4) * 2 = 14.",
            ),
            tiles(
                "Remove the element from the top of the stack called stack and store it in the variable x",
                listOf("x", "=", "stack", ".pop()"),
                listOf(".popleft()", ".pop(0)"),
                "The top of the stack is the end of the list, so pop() is all you need.",
            ),
        ),
        lesson(
            "u65l5", "Day 5: Math in algorithms",
            output(
                "def gcd(a, b):\n    while b:\n        a, b = b, a % b\n    return a\nprint(gcd(48, 18))",
                "6",
                "Euclid's algorithm: (48, 18) → (18, 12) → (12, 6) → (6, 0).",
            ),
            output(
                "import math\na, b = 4, 6\nprint(a * b // math.gcd(a, b))",
                "12",
                "LCM = a * b / GCD, and GCD(4, 6) = 2.",
            ),
            output(
                "n = 20\nsieve = [True] * (n + 1)\nfor i in range(2, n + 1):\n    if sieve[i]:\n        for j in range(i * i, n + 1, i):\n            sieve[j] = False\nprint([i for i in range(2, n + 1) if sieve[i]])",
                "[2, 3, 5, 7, 11, 13, 17, 19]",
                "The sieve of Eratosthenes crosses out the multiples of successive primes.",
            ),
            fill(
                "Fill in the blank so the function checks for primes correctly (the program should print False True).",
                "def is_prime(n):\n    if n < 2:\n        return False\n    for d in range(2, int(n ** 0.5) + 1):\n        if n % d == 0:\n            return ____\n    return True\nprint(is_prime(21), is_prime(13))",
                listOf("False", "True", "d"),
                "False",
                "Finding a divisor means the number is not prime.",
            ),
            output(
                "def to_binary(n):\n    digits = \"\"\n    while n > 0:\n        digits = str(n % 2) + digits\n        n //= 2\n    return digits\nprint(to_binary(13), bin(13))",
                "1101 0b1101",
                "The remainders from dividing by 2, read from the end, give the binary form.",
            ),
            choice(
                "What are 17 % 5 and 17 // 5?",
                listOf("2 and 3", "3 and 2", "3.4 and 2", "2 and 3.4"),
                0,
                "17 = 3 * 5 + 2: the remainder is 2, and the whole part is 3.",
            ),
            output(
                "def power(a, n):\n    if n == 0:\n        return 1\n    p = power(a, n // 2)\n    return p * p * (a if n % 2 else 1)\nprint(power(3, 5))",
                "243",
                "Fast exponentiation: 3⁵ = 3² * 3² * 3 = 243 in O(log n) steps.",
            ),
            tiles(
                "Compute the sum of the digits of the number n",
                listOf("total", "=", "sum(", "int(c)", "for c in", "str(n)", ")"),
                listOf("len(", "int(n)"),
                "We turn the number into a string and add up its digits.",
            ),
        ),
        lesson(
            "u65l6", "Day 6: String algorithms",
            output(
                "def palindrome(s):\n    s = s.lower().replace(\" \", \"\")\n    return s == s[::-1]\nprint(palindrome(\"Never odd or even\"))",
                "True",
                "With the spaces removed and everything in lowercase, the string reads the same backwards.",
            ),
            output(
                "def ana(a, b):\n    return sorted(a) == sorted(b)\nprint(ana(\"listen\", \"silent\"), ana(\"ab\", \"aa\"))",
                "True False",
                "Anagrams have the same letters, so they are equal once sorted.",
            ),
            output(
                "count = {}\nfor c in \"banana\":\n    count[c] = count.get(c, 0) + 1\nprint(count)",
                "{'b': 1, 'a': 3, 'n': 2}",
                "get(c, 0) returns 0 for a letter we haven't counted yet.",
            ),
            output(
                "def cipher(s, k):\n    out = \"\"\n    for c in s:\n        out += chr((ord(c) - 97 + k) % 26 + 97)\n    return out\nprint(cipher(\"xyz\", 2))",
                "zab",
                "Caesar cipher: the remainder from dividing by 26 wraps the alphabet around.",
            ),
            output(
                "s = \"aaabccdd\"\nresult = \"\"\ni = 0\nwhile i < len(s):\n    j = i\n    while j < len(s) and s[j] == s[i]:\n        j += 1\n    result += s[i] + str(j - i)\n    i = j\nprint(result)",
                "a3b1c2d2",
                "RLE encoding writes a character and the length of its run.",
            ),
            fill(
                "Fill in the blank so every word starts with a capital letter (Amy Has A Cat).",
                "sentence = \"amy has a cat\"\nprint(\" \".join(s.____() for s in sentence.split()))",
                listOf("capitalize", "upper", "lower"),
                "capitalize",
                "capitalize() changes the first letter to uppercase.",
            ),
            choice(
                "What does ord(\"a\") return?",
                listOf("97", "\"a\"", "1", "65"),
                0,
                "ord() gives the character's code – for \"a\" it's 97, and for \"A\" it's 65.",
            ),
            tiles(
                "Print whether the word s is a palindrome",
                listOf("print(", "s", "==", "s[::-1]", ")"),
                listOf("s[::1]", "s[-1]"),
                "s[::-1] is the reversed string.",
            ),
        ),
        lesson(
            "u65l7", "Day 7: Recursion in algorithms",
            output(
                "def merge_sort(t):\n    if len(t) <= 1:\n        return t\n    m = len(t) // 2\n    a, b = merge_sort(t[:m]), merge_sort(t[m:])\n    out = []\n    while a and b:\n        out.append((a if a[0] <= b[0] else b).pop(0))\n    return out + a + b\nprint(merge_sort([5, 2, 9, 1]))",
                "[1, 2, 5, 9]",
                "Merge sort splits the list in half and merges the sorted parts.",
            ),
            output(
                "def search(t, x, lo, hi):\n    if lo > hi:\n        return -1\n    m = (lo + hi) // 2\n    if t[m] == x:\n        return m\n    if t[m] < x:\n        return search(t, x, m + 1, hi)\n    return search(t, x, lo, m - 1)\nprint(search([1, 4, 7, 9], 9, 0, 3))",
                "3",
                "Recursive binary search narrows the range with every call.",
            ),
            output(
                "def perm(s):\n    if len(s) <= 1:\n        return [s]\n    out = []\n    for i, c in enumerate(s):\n        for p in perm(s[:i] + s[i + 1:]):\n            out.append(c + p)\n    return out\nprint(len(perm(\"abcd\")), perm(\"ab\"))",
                "24 ['ab', 'ba']",
                "The number of permutations of 4 letters is 4! = 24.",
            ),
            output(
                "def hanoi(n):\n    if n == 0:\n        return 0\n    return 2 * hanoi(n - 1) + 1\nprint(hanoi(4))",
                "15",
                "The Tower of Hanoi with n disks takes 2ⁿ - 1 moves.",
            ),
            choice(
                "What happens with very deep recursion (e.g. 10,000 levels)?",
                listOf("RecursionError", "The program slows down but works", "SyntaxError", "The function returns None"),
                0,
                "Python limits the recursion depth (about 1000 by default).",
            ),
            fill(
                "Fill in the blank so fib(80) is computed in an instant.",
                "from functools import lru_cache\n@____\ndef fib(n):\n    return n if n < 2 else fib(n - 1) + fib(n - 2)\nprint(fib(80))",
                listOf("lru_cache", "staticmethod", "property"),
                "lru_cache",
                "lru_cache remembers the results, so each fib(n) is computed only once.",
            ),
            output(
                "def depth(t):\n    if not isinstance(t, list):\n        return 0\n    return 1 + max((depth(x) for x in t), default=0)\nprint(depth([1, [2, [3]], []]))",
                "3",
                "The most deeply nested list is [3] – three levels.",
            ),
            tiles(
                "Build the base case: for an empty list t, set result to 0",
                listOf("if", "not t:", "result = 0"),
                listOf("while", "result = t"),
                "An empty list is falsy, so not t is True.",
            ),
        ),
    ),
)
