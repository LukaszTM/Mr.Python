package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*
import com.mrpython.app.domain.CourseUnit

internal val module27 = CourseUnit(
    id = "u27",
    title = "Computational Complexity",
    description = "Counting steps, Big O notation, and choosing faster solutions",
    lessons = listOf(
        lesson(
            "u27l1", "Counting operations",
            output(
                "steps = 0\nfor i in range(5):\n    steps += 1\nprint(steps)",
                "5",
                "The loop runs 5 times, so we get 5 steps.",
            ),
            output(
                "steps = 0\nfor i in range(3):\n    for j in range(4):\n        steps += 1\nprint(steps)",
                "12",
                "Nested loops multiply: 3 · 4 = 12.",
            ),
            output(
                "steps = 0\nfor i in range(4):\n    for j in range(i):\n        steps += 1\nprint(steps)",
                "6",
                "The inner loop runs 0, 1, 2, and 3 times – 6 in total.",
            ),
            choice(
                "What is the value of steps at the end?",
                listOf("20", "100", "10", "11"),
                0,
                "Two loops one after the other add up: 10 + 10 = 20.",
                code = "n = 10\nsteps = 0\nfor i in range(n):\n    steps += 1\nfor j in range(n):\n    steps += 1",
            ),
            output(
                "n = 32\nsteps = 0\nwhile n > 1:\n    n //= 2\n    steps += 1\nprint(steps)",
                "5",
                "Halving: 32, 16, 8, 4, 2, 1 – that's 5 steps.",
            ),
            fill(
                "Fill in the blank so the inner loop gives exactly n · n steps in total.",
                "n = 3\nsteps = 0\nfor i in range(n):\n    for j in range(____):\n        steps += 1\nprint(steps)",
                listOf("n", "i", "1"),
                "n",
                "Both loops run n times, giving n · n = 9 steps.",
            ),
            output(
                "steps = 0\nfor i in range(0, 20, 5):\n    steps += 1\nprint(steps)",
                "4",
                "range(0, 20, 5) is 0, 5, 10, and 15 – four iterations.",
            ),
            tiles(
                "Write a loop that runs exactly n times",
                listOf("for", "i", "in", "range(n)", ":"),
                listOf("range(n * n)", "while"),
                "range(n) gives n consecutive numbers.",
            ),
        ),
        lesson(
            "u27l2", "Big O notation",
            choice(
                "What is the complexity of reading a list element by index, e.g. a[5]?",
                listOf("O(1)", "O(n)", "O(n²)", "O(log n)"),
                0,
                "Access by index takes the same time no matter how long the list is.",
            ),
            choice(
                "What is the complexity of this code relative to the length of the list?",
                listOf("O(n)", "O(1)", "O(n²)", "O(log n)"),
                0,
                "One loop over all the elements is O(n).",
                code = "numbers = [1, 2, 3]\ntotal = 0\nfor x in numbers:\n    total += x",
            ),
            choice(
                "What is the complexity of this code relative to the length of the list?",
                listOf("O(n²)", "O(n)", "O(1)", "O(log n)"),
                0,
                "For each element we go through the whole list again – n · n.",
                code = "numbers = [1, 2, 3]\nfor a in numbers:\n    for b in numbers:\n        print(a, b)",
            ),
            choice(
                "What is the complexity of this loop relative to n?",
                listOf("O(log n)", "O(n)", "O(n²)", "O(1)"),
                0,
                "Halving n at every step gives a logarithmic number of steps.",
                code = "n = 1000\nwhile n > 1:\n    n = n // 2",
            ),
            output(
                "for n in [2, 4, 8]:\n    steps = 0\n    for i in range(n):\n        for j in range(n):\n            steps += 1\n    print(steps)",
                "4\n16\n64",
                "In O(n²), doubling n gives four times as many steps.",
            ),
            output(
                "for n in [8, 64, 1024]:\n    steps = 0\n    while n > 1:\n        n //= 2\n        steps += 1\n    print(steps)",
                "3\n6\n10",
                "In O(log n), even a large n gives few steps.",
            ),
            fill(
                "Fill in the blank so the function returns the first element in O(1) time.",
                "def first(items):\n    return items____\nprint(first([7, 8, 9]))",
                listOf("[0]", "[-1]", ".pop()"),
                "[0]",
                "Reading index 0 doesn't depend on the length of the list.",
            ),
            tiles(
                "Arrange the complexities from fastest to slowest",
                listOf("orders = [", "\"O(1)\",", "\"O(log n)\",", "\"O(n)\",", "\"O(n²)\"]"),
                listOf("\"O(0)\",", "\"O(n!)\","),
                "Constant, logarithmic, linear, and finally quadratic.",
            ),
        ),
        lesson(
            "u27l3", "List or set?",
            choice(
                "How much does checking x in a_list cost?",
                listOf("O(n) – the elements have to be checked one by one", "O(1)", "O(log n)", "O(n²)"),
                0,
                "A list doesn't know where x is, so it searches one by one.",
            ),
            choice(
                "How much does checking x in a_set cost on average?",
                listOf("O(1) – a set uses hashing", "O(n)", "O(n²)", "O(log n)"),
                0,
                "A set calculates right away where to look for the element.",
            ),
            output(
                "items = [5, 3, 8, 1, 9]\ncomparisons = 0\nfor x in items:\n    comparisons += 1\n    if x == 1:\n        break\nprint(comparisons)",
                "4",
                "To find 1, you have to compare 4 elements.",
            ),
            output(
                "numbers = [3, 1, 4, 1, 5]\nprint(len(numbers) != len(set(numbers)))",
                "True",
                "A set removes repeats, so it's shorter – the list had duplicates.",
            ),
            output(
                "a = [1, 2, 3, 4]\nb = {3, 4, 5}\ncommon = [x for x in a if x in b]\nprint(common)",
                "[3, 4]",
                "Checking in on the set b is fast.",
            ),
            choice(
                "You have a list of a million numbers and a thousand questions: \"is this number on the list?\" What should you do?",
                listOf(
                    "Convert the list to a set once and then use in",
                    "Sort the list before every question",
                    "Use list.count() for every question",
                    "Convert the list into one long string",
                ),
                0,
                "A one-time set() costs O(n), and after that every question is O(1).",
            ),
            fill(
                "Fill in the blank so the not in check inside the loop is fast (O(1)).",
                "banned = ____([\"spam\", \"ad\"])\nwords = [\"hi\", \"spam\"]\nprint([w for w in words if w not in banned])",
                listOf("set", "len", "sum"),
                "set",
                "Membership checks in a set are O(1) on average.",
            ),
            output(
                "seen = set()\nfor x in [4, 2, 4, 7, 2]:\n    if x in seen:\n        print(x)\n    seen.add(x)",
                "4\n2",
                "The set remembers what it has already seen and quickly detects repeats.",
            ),
        ),
        lesson(
            "u27l4", "Review: complexity",
            choice(
                "What is the complexity of this code relative to n?",
                listOf("O(n)", "O(n²)", "O(1)", "O(log n)"),
                0,
                "The inner loop always runs 10 times, so the total grows linearly.",
                code = "n = 100\nfor i in range(n):\n    for j in range(10):\n        pass",
            ),
            output(
                "n = 4\nsteps = 0\nfor i in range(n):\n    steps += 1\nfor i in range(n):\n    for j in range(n):\n        steps += 1\nprint(steps)",
                "20",
                "4 steps from the first loop and 16 from the nested ones.",
            ),
            choice(
                "A sorted list has 1000 elements. At most how many steps will linear search take, and how many will binary search take?",
                listOf("1000 and about 10", "10 and about 1000", "500 and 500", "1000 and 1000"),
                0,
                "Linear search is O(n), and binary search is O(log n).",
            ),
            choice(
                "Which list operation has O(n) complexity?",
                listOf("a.insert(0, x)", "a.append(x)", "a[3]", "len(a)"),
                0,
                "Inserting at the beginning shifts all the other elements.",
            ),
            output(
                "n = 100\nprint(n * (n + 1) // 2)\nprint(sum(range(n + 1)))",
                "5050\n5050",
                "Same result: the formula runs in O(1), and the summing in O(n).",
            ),
            fill(
                "Fill in the blank to calculate the sum of the numbers from 1 to n in O(1) time.",
                "n = 10\nprint(n * (n + 1) ____ 2)",
                listOf("//", "*", "-"),
                "//",
                "The formula n · (n + 1) / 2 gives 55 without any loop.",
            ),
            choice(
                "Code with two nested loops over n takes 1 s for n = 1000. About how long will it take for n = 2000?",
                listOf("4 s", "2 s", "1 s", "8 s"),
                0,
                "In O(n²), doubling n means four times as much work.",
            ),
            tiles(
                "Convert the list to a set to check membership quickly",
                listOf("fast", "=", "set(items)"),
                listOf("list(items)", "=="),
                "set() creates a set, where in runs in O(1).",
            ),
        ),
    ),
)
