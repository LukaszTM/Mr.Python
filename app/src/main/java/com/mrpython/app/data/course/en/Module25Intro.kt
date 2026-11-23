package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

internal val module25Intro = lesson(
    "u25l0", "Introduction: searching",
    explain(
        "Searching one by one",
        "The simplest way to search: check the elements one after another – this is called linear search. " +
            "It works on any list, but when the value isn't there, you have to look at every element.",
        code = "grades = [5, 3, 5, 4]\ncount = 0\nfor g in grades:\n    if g == 5:\n        count += 1\nprint(count)",
        output = "2",
    ),
    explain(
        "Early return",
        "Once you find what you're looking for, you can stop right away: `return` in a function or `break` in a loop. " +
            "`return -1` after the loop means “not found” – only after checking everything!",
        code = "def search(items, target):\n    for i in range(len(items)):\n        if items[i] == target:\n            return i\n    return -1\n\nprint(search([3, 7], 7), search([3, 7], 5))",
        output = "1 -1",
    ),
    explain(
        "Finding the maximum",
        "To find the largest element, we remember the “champion” so far and replace it when a bigger one " +
            "comes along. We start from `numbers[0]`, not from 0 – the list might contain only negative numbers.",
        code = "numbers = [-3, -9, -2]\nlargest = numbers[0]\nfor x in numbers:\n    if x > largest:\n        largest = x\nprint(largest)",
        output = "-2",
    ),
    explain(
        "Binary search",
        "On a sorted list you can search more cleverly: look at the middle and throw away the half " +
            "that can't contain the target. The middle is computed as `(left + right) // 2`.",
        code = "items = [1, 3, 5, 7, 9]\nleft, right = 0, len(items) - 1\nmiddle = (left + right) // 2\nprint(middle, items[middle])",
        output = "2 5",
    ),
    explain(
        "Why is it fast?",
        "Each step cuts the number of candidates in half. For 16 elements, 4 halvings are enough, " +
            "and for 1000 – about 10. Searching one by one could take 1000 comparisons.",
        code = "n = 16\nsteps = 0\nwhile n > 1:\n    n = n // 2\n    steps += 1\nprint(steps)",
        output = "4",
    ),
    output(
        "numbers = [4, 8, 15]\nprint(15 in numbers)\nprint(numbers.index(8))",
        "True\n1",
        "15 is in the list, and 8 is at index 1.",
    ),
    choice(
        "What kind of list can you use binary search on?",
        listOf("Only a sorted one", "Any list", "Only a list of strings", "Only a short one"),
        0,
        "Throwing away half only works when the elements are in order.",
    ),
    fill(
        "Fill in the blank to find the smallest number.",
        "numbers = [4, 2, 6]\nsmallest = numbers[0]\nfor x in numbers:\n    if x ____ smallest:\n        smallest = x\nprint(smallest)",
        listOf("<", ">", "=="),
        "<",
        "We replace smallest when a smaller number comes along.",
    ),
)
