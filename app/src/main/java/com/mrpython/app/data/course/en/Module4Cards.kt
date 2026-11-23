package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

internal val module4Cards = listOf(
    cards(
        "u4l1",
        explain(
            "Looping over a string",
            "`for` can go through a string – then on each iteration the variable gets the next character. " +
                "You don't need `range()` for that.",
            code = "for c in \"cat\":\n    print(c)",
            output = "c\na\nt",
        ),
        explain(
            "How many times does it repeat?",
            "`range(n)` gives n numbers, so the loop runs n times – you don't have to use the variable `i`. " +
                "An unindented line below the loop runs once, after the loop is done.",
            code = "for i in range(2):\n    print(\"Hey\")\nprint(\"End\")",
            output = "Hey\nHey\nEnd",
        ),
        explain(
            "A loop on one line",
            "When the block has just one statement, you can write it right after the colon, on the same line. " +
                "The same works for `if` and `while`.",
            code = "for i in range(3): print(i)",
            output = "0\n1\n2",
        ),
    ),
    cards(
        "u4l2",
        explain(
            "When does while check the condition?",
            "`while` checks the condition before every iteration. If it is false right at the start, the loop " +
                "doesn't run even once. After the loop, the variable holds the first value that made the condition false.",
            code = "x = 1\nwhile x < 10:\n    x *= 3\nprint(x)",
            output = "27",
        ),
    ),
    cards(
        "u4l3",
        explain(
            "Counting with a condition",
            "A counter starts at 0, and inside the loop we increase it by 1 only when the condition is met. " +
                "This is how you can count, for example, chosen letters in a word.",
            code = "count = 0\nfor c in \"kayak\":\n    if c == \"k\":\n        count += 1\nprint(count)",
            output = "2",
        ),
        explain(
            "Multiplication starts at 1",
            "When we multiply in a loop (`*=`), the result starts at 1, not 0 – because 0 times anything is always 0.",
            code = "result = 1\nfor i in range(1, 4):\n    result *= i\nprint(result)",
            output = "6",
        ),
        explain(
            "An empty range",
            "`range(5, 1)` is empty, because without a negative step `range` only counts up. When counting down, " +
                "the end is not included either: `range(3, 0, -1)` gives 3, 2, 1.",
            code = "for i in range(5, 1):\n    print(i)\nfor i in range(3, 0, -1):\n    print(i)",
            output = "3\n2\n1",
        ),
    ),
    cards(
        "u4l4",
        explain(
            "The while True loop",
            "`while True:` is an \"endless\" loop, because the condition is always true. You leave it " +
                "with `break` – the code after `break` in that iteration no longer runs.",
            code = "n = 0\nwhile True:\n    n += 2\n    if n > 5:\n        break\nprint(n)",
            output = "6",
        ),
        explain(
            "break in a nested loop",
            "`break` ends only the loop it is in. In a nested loop it stops " +
                "the inner one, and the outer one keeps going.",
            code = "for i in range(2):\n    for j in range(5):\n        if j == 1:\n            break\n        print(i, j)",
            output = "0 0\n1 0",
        ),
    ),
    cards(
        "u4l5",
        explain(
            "The //= shortcut and others",
            "Every operation has a shortcut with `=`: `n //= 2` means `n = n // 2`. `%=` and `**=` work the same way.",
            code = "n = 10\nn //= 3\nprint(n)\nn **= 2\nprint(n)",
            output = "3\n9",
        ),
    ),
)
