package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

internal val module25Cards = listOf(
    cards(
        "u25l1",
        explain(
            "The found flag",
            "A flag is a `True`/`False` variable that remembers whether something happened. We start with `False` " +
                "and set it to `True` inside the loop on a match.",
            code = "found = False\nfor x in [4, 8, 15]:\n    if x == 8:\n        found = True\nprint(found)",
            output = "True",
        ),
        explain(
            "Position and -1",
            "To remember the index, we loop over `range(len(items))`. Starting with `pos = -1` means “not found”. " +
                "A loop that never stops early overwrites `pos`, so the last occurrence stays.",
            code = "letters = [\"a\", \"b\", \"a\"]\npos = -1\nfor i in range(len(letters)):\n    if letters[i] == \"a\":\n        pos = i\nprint(pos)",
            output = "2",
        ),
    ),
    cards(
        "u25l2",
        explain(
            "return or break?",
            "`break` ends only the loop – the code after it still runs. `return` ends the whole function. " +
                "Careful: `return False` in an `else` inside the loop ends the function at the very first element!",
            code = "for x in [3, 0, 7]:\n    if x == 0:\n        break\n    print(x)\nprint(\"done\")",
            output = "3\ndone",
        ),
        explain(
            "in and index()",
            "`x in items` tells you whether an element is in the list, and `items.index(x)` tells you the index of " +
                "its first occurrence. When the element is missing, `index()` raises a `ValueError`. " +
                "It works the same on strings: `\"cat\".index(\"a\")` gives 1.",
            code = "items = [1, 7, 3, 7]\nprint(7 in items)\nprint(items.index(7))",
            output = "True\n1",
        ),
    ),
    cards(
        "u25l3",
        explain(
            "First or last?",
            "When looking for the position of the minimum, we compare with `numbers[pos]`. A strict `<` keeps the " +
                "first occurrence, while `<=` overwrites the position on every tie – the last one stays.",
            code = "numbers = [5, 1, 8, 1]\npos = 0\nfor i in range(len(numbers)):\n    if numbers[i] <= numbers[pos]:\n        pos = i\nprint(pos)",
            output = "3",
        ),
    ),
    cards(
        "u25l4",
        explain(
            "Moving the boundaries",
            "When the middle is too small, we search to the right: `left = mid + 1`. When it's too big – to the " +
                "left: `right = mid - 1`. We've already checked the middle, so we skip it.",
            code = "items = [2, 4, 6, 8, 10]\nleft, right = 0, 4\nmid = (left + right) // 2\nif items[mid] < 8:\n    left = mid + 1\nprint(left, right)",
            output = "3 4",
        ),
        explain(
            "The loop and the empty range",
            "The whole search is a `while left <= right:` loop: compute the middle, compare, and move a boundary. " +
                "When `left` passes `right`, the range is empty – the element isn't there and we return -1.",
            code = "left, right = 0, 2\nwhile left <= right:\n    mid = (left + right) // 2\n    left = mid + 1\nprint(left, right)",
            output = "3 2",
        ),
    ),
)
