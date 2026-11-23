package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*
import com.mrpython.app.domain.CourseUnit

internal val module26 = CourseUnit(
    id = "u26",
    title = "Sorting",
    description = "Sorting algorithms, keys, and sorting dictionaries",
    lessons = listOf(
        lesson(
            "u26l1", "Bubble sort",
            output(
                "a = [3, 1]\nif a[0] > a[1]:\n    a[0], a[1] = a[1], a[0]\nprint(a)",
                "[1, 3]",
                "The elements were in the wrong order, so they swapped places.",
            ),
            output(
                "a = [4, 3, 1, 2]\nfor i in range(len(a) - 1):\n    if a[i] > a[i + 1]:\n        a[i], a[i + 1] = a[i + 1], a[i]\nprint(a)",
                "[3, 1, 2, 4]",
                "One pass pushes 4 all the way to the end of the list.",
            ),
            choice(
                "What is definitely true after one pass of bubble sort (ascending)?",
                listOf("The largest element is at the end", "The smallest element is at the start", "The whole list is sorted", "The list is reversed"),
                0,
                "The largest element “floats up” to the end of the list like a bubble.",
            ),
            output(
                "a = [5, 2, 4, 1]\nn = len(a)\nfor k in range(n - 1):\n    for i in range(n - 1 - k):\n        if a[i] > a[i + 1]:\n            a[i], a[i + 1] = a[i + 1], a[i]\nprint(a)",
                "[1, 2, 4, 5]",
                "After n - 1 passes the list is sorted.",
            ),
            fill(
                "Fill in the blank to swap a[i] and a[i + 1].",
                "a = [2, 1]\ni = 0\na[i], a[i + 1] = ____\nprint(a)",
                listOf("a[i + 1], a[i]", "a[i], a[i + 1]", "a[i + 1]"),
                "a[i + 1], a[i]",
                "On the right side we give the values in reverse order.",
            ),
            output(
                "a = [3, 2, 1]\nswaps = 0\nfor k in range(2):\n    for i in range(2):\n        if a[i] > a[i + 1]:\n            a[i], a[i + 1] = a[i + 1], a[i]\n            swaps += 1\nprint(swaps)",
                "3",
                "A reversed list of 3 elements needs three swaps of neighbors.",
            ),
            fill(
                "Fill in the blank to sort in descending order.",
                "a = [1, 3, 2]\nfor k in range(2):\n    for i in range(2):\n        if a[i] ____ a[i + 1]:\n            a[i], a[i + 1] = a[i + 1], a[i]\nprint(a)",
                listOf("<", ">", "=="),
                "<",
                "We swap when the left element is smaller – the bigger ones move to the front.",
            ),
            tiles(
                "Write the swap condition in bubble sort (ascending)",
                listOf("if", "a[i] > a[i + 1]", ":"),
                listOf("a[i] < a[i + 1]", "for"),
                "We swap neighbors when the left one is greater than the right one.",
            ),
        ),
        lesson(
            "u26l2", "Selection sort",
            choice(
                "How does selection sort work?",
                listOf(
                    "We select the smallest element and put it in the next position",
                    "We swap neighbors until the list is sorted",
                    "We split the list in half and look for the middle",
                    "We shuffle the order until it comes out right",
                ),
                0,
                "In every pass we select the minimum of the unsorted part.",
            ),
            output(
                "a = [4, 2, 7, 1]\nm = a.index(min(a))\na[0], a[m] = a[m], a[0]\nprint(a)",
                "[1, 2, 7, 4]",
                "The minimum, 1, swaps places with the first element.",
            ),
            output(
                "a = [3, 1, 2]\nfor i in range(len(a)):\n    m = i\n    for j in range(i + 1, len(a)):\n        if a[j] < a[m]:\n            m = j\n    a[i], a[m] = a[m], a[i]\nprint(a)",
                "[1, 2, 3]",
                "Every pass puts the next minimum at position i.",
            ),
            output(
                "a = [2, 5, 1, 3]\nfor i in range(2):\n    m = i\n    for j in range(i + 1, len(a)):\n        if a[j] < a[m]:\n            m = j\n    a[i], a[m] = a[m], a[i]\n    print(a)",
                "[1, 5, 2, 3]\n[1, 2, 5, 3]",
                "First 1 goes to the front, then 2 goes to the second position.",
            ),
            fill(
                "Fill in the blank so that m points to the smallest element.",
                "a = [6, 2, 9]\nm = 0\nfor j in range(1, len(a)):\n    if a[j] ____ a[m]:\n        m = j\nprint(m)",
                listOf("<", ">", "!="),
                "<",
                "We change m when we find a smaller element.",
            ),
            choice(
                "Which part of the list is already sorted after i passes of selection sort?",
                listOf("The first i elements", "The last i elements", "None of it", "The whole list"),
                0,
                "The minimums go to the front of the list one after another.",
            ),
            output(
                "a = [2, 9, 4]\nresult = []\nwhile a:\n    m = max(a)\n    result.append(m)\n    a.remove(m)\nprint(result)",
                "[9, 4, 2]",
                "Selecting the largest element gives descending order.",
            ),
            tiles(
                "Remember j as the index of the new minimum when a[j] is less than a[m]",
                listOf("if", "a[j] < a[m]", ":", "m = j"),
                listOf("j = m", "a[j] > a[m]"),
                "m should point to the smallest element so far.",
            ),
        ),
        lesson(
            "u26l3", "Insertion sort",
            choice(
                "How does insertion sort work?",
                listOf(
                    "It slides the next element into the sorted part",
                    "It moves the largest element to the end",
                    "It swaps random pairs of elements",
                    "It sorts both halves of the list separately",
                ),
                0,
                "Just like arranging cards in your hand – you slide each new one into its place.",
            ),
            output(
                "ordered = [2, 5, 8]\nx = 6\ni = 0\nwhile i < len(ordered) and ordered[i] < x:\n    i += 1\nordered.insert(i, x)\nprint(ordered)",
                "[2, 5, 6, 8]",
                "6 goes before the first bigger element, which is 8.",
            ),
            output(
                "a = [4, 2, 3, 1]\nfor i in range(1, len(a)):\n    x = a[i]\n    j = i - 1\n    while j >= 0 and a[j] > x:\n        a[j + 1] = a[j]\n        j -= 1\n    a[j + 1] = x\nprint(a)",
                "[1, 2, 3, 4]",
                "Bigger elements shift to the right, and x drops into the gap.",
            ),
            output(
                "a = [3, 1, 2]\nfor i in range(1, len(a)):\n    x = a[i]\n    j = i - 1\n    while j >= 0 and a[j] > x:\n        a[j + 1] = a[j]\n        j -= 1\n    a[j + 1] = x\n    print(a)",
                "[1, 3, 2]\n[1, 2, 3]",
                "First we insert 1 before 3, then 2 between 1 and 3.",
            ),
            fill(
                "Fill in the condition to shift the bigger elements to the right.",
                "a = [1, 4, 2]\nx = a[2]\nj = 1\nwhile j >= 0 and a[j] ____ x:\n    a[j + 1] = a[j]\n    j -= 1\na[j + 1] = x\nprint(a)",
                listOf(">", "<", "=="),
                ">",
                "We shift the elements that are greater than x, the one being inserted.",
            ),
            choice(
                "For which list does insertion sort run the fastest?",
                listOf("One that is already sorted", "One sorted in descending order", "A random one", "It always runs the same"),
                0,
                "When the list is sorted, nothing has to be shifted.",
            ),
            output(
                "a = [3, 2, 1]\nmoves = 0\nfor i in range(1, len(a)):\n    x = a[i]\n    j = i - 1\n    while j >= 0 and a[j] > x:\n        a[j + 1] = a[j]\n        j -= 1\n        moves += 1\n    a[j + 1] = x\nprint(moves)",
                "3",
                "Inserting 2 takes 1 shift, and inserting 1 takes two.",
            ),
            tiles(
                "Shift the element a[j] one place to the right",
                listOf("a[j + 1]", "=", "a[j]"),
                listOf("a[j - 1]", "=="),
                "We copy a[j] to position j + 1.",
            ),
        ),
        lesson(
            "u26l4", "sorted() with key and reverse",
            output("print(sorted([3, 1, 2], reverse=True))", "[3, 2, 1]", "reverse=True sorts in descending order."),
            output(
                "a = [3, 1, 2]\nb = sorted(a)\nprint(a)\nprint(b)",
                "[3, 1, 2]\n[1, 2, 3]",
                "sorted() creates a new list, and the original stays unchanged.",
            ),
            output(
                "words = [\"peach\", \"kiwi\", \"banana\"]\nprint(sorted(words, key=len))",
                "['kiwi', 'peach', 'banana']",
                "key=len orders the words by length.",
            ),
            output("print(sorted([-3, 2, -1], key=abs))", "[-1, 2, -3]", "We sort by absolute values: 1, 2, 3."),
            fill(
                "Fill in the blank to sort the list in descending order.",
                "a = [2, 5, 1]\na.sort(____=True)\nprint(a)",
                listOf("reverse", "key", "desc"),
                "reverse",
                "The parameter reverse=True flips the sort order.",
            ),
            choice(
                "What does a.sort() return?",
                listOf("None", "A new sorted list", "A sorted tuple", "The number of elements"),
                0,
                "sort() sorts the list a in place and returns None.",
            ),
            output(
                "names = [\"tom\", \"Eve\", \"adam\"]\nprint(sorted(names))\nprint(sorted(names, key=str.lower))",
                "['Eve', 'adam', 'tom']\n['adam', 'Eve', 'tom']",
                "Uppercase letters come before lowercase ones, unless we compare the lower() versions.",
            ),
            tiles(
                "Sort the words by length in descending order",
                listOf("result", "=", "sorted(words,", "key=len,", "reverse=True)"),
                listOf("key=len(),", "reverse=False)"),
                "key=len picks the length, and reverse=True flips the order.",
            ),
        ),
        lesson(
            "u26l5", "Multiple keys and dictionaries",
            choice(
                "What does it mean that sorting in Python is stable?",
                listOf(
                    "Equal elements keep their order",
                    "Sorting never raises an error",
                    "The list doesn't change after sorting",
                    "Sorting always takes the same amount of time",
                ),
                0,
                "Ties stay in the order they had in the input.",
            ),
            output(
                "people = [(\"Zoe\", 20), (\"Tom\", 18), (\"Eve\", 20)]\nfor name, age in sorted(people, key=lambda p: p[1]):\n    print(name)",
                "Tom\nZoe\nEve",
                "Zoe and Eve are both 20, so they stay in their original order.",
            ),
            output(
                "print(sorted([(2, \"b\"), (1, \"z\"), (2, \"a\")]))",
                "[(1, 'z'), (2, 'a'), (2, 'b')]",
                "Tuples are compared by the first element, and on a tie by the second.",
            ),
            output(
                "people = [(\"Zoe\", 20), (\"Tom\", 18), (\"Eve\", 20)]\nresult = sorted(people, key=lambda p: (-p[1], p[0]))\nprint([p[0] for p in result])",
                "['Eve', 'Zoe', 'Tom']",
                "First age in descending order (the minus), and on a tie the name alphabetically.",
            ),
            output(
                "points = {\"Zoe\": 7, \"Tom\": 9, \"Eve\": 5}\nfor name, p in sorted(points.items(), key=lambda x: x[1]):\n    print(name, p)",
                "Eve 5\nZoe 7\nTom 9",
                "items() gives pairs, and x[1] is the value – we sort by points.",
            ),
            fill(
                "Fill in the blank to sort the dictionary's pairs by value.",
                "prices = {\"bread\": 4, \"milk\": 3}\nprint(sorted(prices.items(), key=lambda x: x[____]))",
                listOf("1", "0", "2"),
                "1",
                "In a (key, value) pair, the value has index 1.",
            ),
            output(
                "votes = {\"A\": 3, \"B\": 8, \"C\": 5}\nranking = sorted(votes, key=votes.get, reverse=True)\nprint(ranking[0])",
                "B",
                "key=votes.get sorts the keys by their values.",
            ),
            tiles(
                "Sort the pairs of the dictionary d by value",
                listOf("sorted(d.items(),", "key=lambda x:", "x[1])"),
                listOf("x[0])", "d.values()"),
                "x[1] is the value in a (key, value) pair.",
            ),
        ),
        lesson(
            "u26l6", "Review: sorting",
            output("print(sorted(\"python\"))", "['h', 'n', 'o', 'p', 't', 'y']", "sorted() on a string gives a sorted list of letters."),
            output("print(\"\".join(sorted(\"time\")))", "eimt", "After sorting, we join the letters back into a string."),
            choice(
                "Which algorithm swaps neighboring elements in every pass?",
                listOf("Bubble sort", "Selection sort", "Insertion sort", "Binary search"),
                0,
                "Bubble sort compares and swaps pairs of neighbors.",
            ),
            output(
                "words = [\"frog\", \"cat\", \"bird\", \"ox\"]\nprint(sorted(words, key=lambda s: (len(s), s)))",
                "['ox', 'cat', 'bird', 'frog']",
                "First by length, and for equal lengths alphabetically.",
            ),
            fill(
                "Fill in the blank so the best score comes first.",
                "scores = {\"Zoe\": 80, \"Tom\": 95}\nr = sorted(scores.items(), key=lambda x: x[1], ____=True)\nprint(r[0][0])",
                listOf("reverse", "key", "desc"),
                "reverse",
                "reverse=True sorts starting from the largest value.",
            ),
            output(
                "a = [2, 1, 3, 0]\nfor i in range(len(a) - 1):\n    if a[i] > a[i + 1]:\n        a[i], a[i + 1] = a[i + 1], a[i]\nprint(a)",
                "[1, 2, 0, 3]",
                "One bubble pass: 2 swaps with 1, then 3 swaps with 0.",
            ),
            choice(
                "What does this code print?",
                listOf("None", "[1, 2, 3]", "[3, 1, 2]", "Error"),
                0,
                "sort() returns None, so a = a.sort() loses the list.",
                code = "a = [3, 1, 2]\na = a.sort()\nprint(a)",
            ),
            output(
                "players = [(\"Amy\", 3), (\"Bob\", 5), (\"Cal\", 3)]\nplayers.sort(key=lambda g: g[1], reverse=True)\nprint(players[1][0], players[2][0])",
                "Amy Cal",
                "With reverse=True, equal elements keep their order too.",
            ),
        ),
    ),
)
