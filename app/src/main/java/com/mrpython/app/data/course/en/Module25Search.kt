package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*
import com.mrpython.app.domain.CourseUnit

internal val module25 = CourseUnit(
    id = "u25",
    title = "Searching",
    description = "Linear search, minimum, maximum, and binary search",
    lessons = listOf(
        lesson(
            "u25l1", "Searching one by one",
            output(
                "numbers = [4, 8, 15, 16]\nfound = False\nfor x in numbers:\n    if x == 15:\n        found = True\nprint(found)",
                "True",
                "The loop checks the elements one by one and hits 15.",
            ),
            output(
                "names = [\"Amy\", \"Tom\", \"Eve\"]\nfor i in range(len(names)):\n    if names[i] == \"Eve\":\n        print(i)",
                "2",
                "Eve is at index 2.",
            ),
            output(
                "grades = [5, 3, 5, 4, 5]\ncount = 0\nfor g in grades:\n    if g == 5:\n        count += 1\nprint(count)",
                "3",
                "The counter goes up on every match – there are three fives.",
            ),
            choice(
                "A list has 10 elements and the value you're looking for isn't in it. How many comparisons does a linear search make?",
                listOf("10", "1", "5", "0"),
                0,
                "To be sure an element is missing, you have to check every element.",
            ),
            fill(
                "Fill in the blank to count every occurrence of the word “cat”.",
                "words = [\"cat\", \"dog\", \"cat\"]\ncount = 0\nfor w in words:\n    if w == \"cat\":\n        count ____ 1\nprint(count)",
                listOf("+=", "=", "-="),
                "+=",
                "count += 1 increases the counter on every match.",
            ),
            output(
                "temps = [12, -3, 5, -1, 0]\nnegative = 0\nfor t in temps:\n    if t < 0:\n        negative += 1\nprint(negative)",
                "2",
                "Only -3 and -1 are negative, because 0 is not less than 0.",
            ),
            tiles(
                "Write the condition: x is equal to the value target we're looking for",
                listOf("if", "x == target", ":"),
                listOf("x = target", "else"),
                "Comparison is ==, while a single = is assignment.",
            ),
            output(
                "letters = [\"a\", \"b\", \"a\", \"c\"]\npos = -1\nfor i in range(len(letters)):\n    if letters[i] == \"a\":\n        pos = i\nprint(pos)",
                "2",
                "The loop never stops early, so it remembers the last occurrence.",
            ),
        ),
        lesson(
            "u25l2", "Early return",
            output(
                "def search(items, target):\n    for i in range(len(items)):\n        if items[i] == target:\n            return i\n    return -1\n\nprint(search([3, 7, 7], 7))",
                "1",
                "return ends the function at the first match.",
            ),
            output(
                "def search(items, target):\n    for i in range(len(items)):\n        if items[i] == target:\n            return i\n    return -1\n\nprint(search([3, 7], 5))",
                "-1",
                "The loop found nothing, so return -1 runs.",
            ),
            choice(
                "What's wrong with this function?",
                listOf("It only checks the first element", "It never returns True", "It always raises an error", "It works correctly"),
                0,
                "return False in the else ends the function at the very first element.",
                code = "def contains(items, target):\n    for x in items:\n        if x == target:\n            return True\n        else:\n            return False",
            ),
            output(
                "numbers = [2, 9, 4, 9]\nsteps = 0\nfor x in numbers:\n    steps += 1\n    if x == 9:\n        break\nprint(steps)",
                "2",
                "break stops the loop after the second element.",
            ),
            fill(
                "Fill in the blank so the function ends as soon as it finds the target.",
                "def contains(items, target):\n    for x in items:\n        if x == target:\n            ____ True\n    return False\nprint(contains([1, 2], 2))",
                listOf("return", "print", "break"),
                "return",
                "return hands back the result right away and ends the function.",
            ),
            output(
                "def first_negative(numbers):\n    for x in numbers:\n        if x < 0:\n            return x\n    return None\n\nprint(first_negative([3, -2, -8]))",
                "-2",
                "The function returns the first negative number it finds.",
            ),
            output(
                "items = [1, 7, 3]\nprint(7 in items)\nprint(items.index(7))",
                "True\n1",
                "in and index() also search the list one element at a time.",
            ),
            tiles(
                "When items[i] equals target, store the index i in the variable pos",
                listOf("if", "items[i] == target", ":", "pos = i"),
                listOf("items[i] = target", "pos = target"),
                "We remember the index i, not the value itself.",
            ),
        ),
        lesson(
            "u25l3", "Minimum, maximum, and position",
            output(
                "numbers = [3, 9, 2, 7]\nlargest = numbers[0]\nfor x in numbers:\n    if x > largest:\n        largest = x\nprint(largest)",
                "9",
                "We replace largest every time we hit a bigger number.",
            ),
            output(
                "numbers = [5, 1, 8, 1]\npos = 0\nfor i in range(len(numbers)):\n    if numbers[i] < numbers[pos]:\n        pos = i\nprint(pos)",
                "1",
                "With a strict <, the first occurrence of the minimum stays.",
            ),
            choice(
                "Why do we start the maximum from numbers[0] and not from 0?",
                listOf(
                    "With only negative numbers, 0 would be a wrong result",
                    "Because 0 is not a number",
                    "Because it's faster",
                    "Because a list can't contain zero",
                ),
                0,
                "For [-5, -2] the maximum is -2, but starting from 0 would give 0.",
            ),
            output(
                "numbers = [5, 1, 8, 1]\npos = 0\nfor i in range(len(numbers)):\n    if numbers[i] <= numbers[pos]:\n        pos = i\nprint(pos)",
                "3",
                "With <=, every later equal minimum overwrites the position – the last one stays.",
            ),
            fill(
                "Fill in the blank to find the smallest number.",
                "numbers = [4, 2, 6]\nsmallest = numbers[0]\nfor x in numbers:\n    if x ____ smallest:\n        smallest = x\nprint(smallest)",
                listOf("<", ">", "=="),
                "<",
                "We replace smallest when x is smaller.",
            ),
            output(
                "words = [\"cat\", \"giraffe\", \"dog\"]\nlongest = words[0]\nfor w in words:\n    if len(w) > len(longest):\n        longest = w\nprint(longest)",
                "giraffe",
                "We compare word lengths – the longest one is “giraffe”.",
            ),
            output(
                "numbers = [3, 9, 2, 9]\nprint(max(numbers), numbers.index(max(numbers)))",
                "9 1",
                "index() returns the position of the first occurrence.",
            ),
            tiles(
                "Update the maximum largest when x is bigger",
                listOf("if", "x > largest", ":", "largest = x"),
                listOf("x < largest", "x = largest"),
                "When x is bigger, we remember it as the new maximum.",
            ),
        ),
        lesson(
            "u25l4", "Binary search",
            choice(
                "What kind of list can you use binary search on?",
                listOf("A sorted one", "Any list", "Only a list of strings", "Only a list of even length"),
                0,
                "Binary search throws away half of the list, which only works when the data is in order.",
            ),
            output(
                "items = [1, 3, 5, 7, 9, 11, 13]\nleft, right = 0, len(items) - 1\nmiddle = (left + right) // 2\nprint(middle, items[middle])",
                "3 7",
                "(0 + 6) // 2 = 3, and index 3 holds 7.",
            ),
            choice(
                "We're looking for 11 in [1, 3, 5, 7, 9, 11, 13]. The middle element is 7. What next?",
                listOf("Search the right half", "Search the left half", "Stop – the element is missing", "Start over from the beginning of the list"),
                0,
                "11 > 7, so the number we want can only be to the right of the middle.",
            ),
            output(
                "def search(items, target):\n    left, right = 0, len(items) - 1\n    while left <= right:\n        mid = (left + right) // 2\n        if items[mid] == target:\n            return mid\n        elif items[mid] < target:\n            left = mid + 1\n        else:\n            right = mid - 1\n    return -1\nprint(search([2, 4, 6, 8, 10], 8))",
                "3",
                "The middle is 6 (too small), then the range is [8, 10] and its middle is 8 at index 3.",
            ),
            output(
                "n = 16\nsteps = 0\nwhile n > 1:\n    n = n // 2\n    steps += 1\nprint(steps)",
                "4",
                "Each step halves the range: 16, 8, 4, 2, 1.",
            ),
            fill(
                "Fill in the blank so the middle is a whole number (an index).",
                "left, right = 0, 8\nmiddle = (left + right) ____ 2\nprint(middle)",
                listOf("//", "/", "%"),
                "//",
                "// does integer division, so the result works as an index.",
            ),
            fill(
                "The middle element is too small. Fill in how to move the left boundary.",
                "items = [1, 3, 5, 7, 9]\nleft, right = 0, 4\nmid = (left + right) // 2\nif items[mid] < 9:\n    left = ____\nprint(left)",
                listOf("mid + 1", "mid - 1", "0"),
                "mid + 1",
                "We've already checked the middle, so we search from the next index.",
            ),
            tiles(
                "Write the header of the binary search loop",
                listOf("while", "left <= right", ":"),
                listOf("for", "left > right"),
                "We keep searching as long as the range between left and right isn't empty.",
            ),
        ),
        lesson(
            "u25l5", "Review: searching",
            output(
                "text = \"abracadabra\"\ncount = 0\nfor ch in text:\n    if ch == \"a\":\n        count += 1\nprint(count)",
                "5",
                "The letter a appears five times in “abracadabra”.",
            ),
            output(
                "numbers = [3, 8, 1, 9]\nprint(sum(1 for x in numbers if x > 2))",
                "3",
                "Every match adds 1 – the numbers greater than 2 are 3, 8, and 9.",
            ),
            choice(
                "At most how many steps does binary search need for 1000 sorted elements?",
                listOf("About 10", "About 500", "1000", "About 100"),
                0,
                "You can halve 1000 about 10 times, because 2 to the power of 10 is 1024.",
            ),
            output(
                "def first_even(numbers):\n    for i, x in enumerate(numbers):\n        if x % 2 == 0:\n            return i\n    return -1\n\nprint(first_even([5, 7, 4, 6]))",
                "2",
                "The first even number is 4, at index 2.",
            ),
            fill(
                "Fill in the blank to print the index of the smallest element.",
                "numbers = [7, 9, 3]\nprint(numbers.____(min(numbers)))",
                listOf("index", "count", "find"),
                "index",
                "index() returns the position of the given value.",
            ),
            output(
                "items = [1, 3, 5, 7, 9, 11, 13]\nleft, right = 0, 6\nwhile left <= right:\n    mid = (left + right) // 2\n    print(items[mid])\n    if items[mid] == 3:\n        break\n    elif items[mid] < 3:\n        left = mid + 1\n    else:\n        right = mid - 1",
                "7\n3",
                "First the middle 7, then the left half [1, 3, 5] and its middle 3.",
            ),
            choice(
                "Which search is faster for a large sorted list?",
                listOf("Binary", "Linear", "Both are the same", "Linear from the end"),
                0,
                "Binary search throws away half of the elements every time.",
            ),
            tiles(
                "Increase the counter count by 1",
                listOf("count", "+=", "1"),
                listOf("==", "-="),
                "+= adds a value to a variable.",
            ),
        ),
    ),
)
