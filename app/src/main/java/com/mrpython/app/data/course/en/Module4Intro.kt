package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

internal val module4Intro = lesson(
    "u4l0", "Introduction: loops",
    explain(
        "Why loops?",
        "A loop repeats code many times, so you don't have to copy it. A `for` loop goes through " +
            "items one by one, for example the numbers from `range(3)`, which are 0, 1, and 2.",
        code = "for i in range(3):\n    print(i)",
        output = "0\n1\n2",
    ),
    explain(
        "range() and counters",
        "`range(start, stop, step)` counts from `start` and ends just before `stop`. A negative step counts down. " +
            "A counter variable lets you add things up in a loop.",
        code = "for i in range(1, 8, 3):\n    print(i)\ntotal = 0\nfor i in range(4):\n    total += i\nprint(total)",
        output = "1\n4\n7\n6",
    ),
    explain(
        "The while loop",
        "`while` repeats code as long as the condition is true. Remember that something inside has to change, " +
            "or the loop will never end.",
        code = "n = 3\nwhile n > 0:\n    print(n)\n    n -= 1",
        output = "3\n2\n1",
    ),
    explain(
        "break and continue",
        "`break` ends the whole loop immediately, while `continue` skips the rest of the current iteration " +
            "and moves on to the next one.",
        code = "for i in range(6):\n    if i == 1:\n        continue\n    if i == 4:\n        break\n    print(i)",
        output = "0\n2\n3",
    ),
    explain(
        "A loop inside a loop",
        "You can put a loop inside another loop. The inner one runs completely on every iteration " +
            "of the outer one.",
        code = "for i in range(2):\n    for j in range(2):\n        print(i, j)",
        output = "0 0\n0 1\n1 0\n1 1",
    ),
    output(
        "for i in range(2, 5):\n    print(i)",
        "2\n3\n4",
        "range(2, 5) starts at 2 and ends before 5.",
    ),
    choice(
        "What ends the whole loop immediately?",
        listOf("break", "continue", "else", "range"),
        0,
        "break stops the loop, while continue only skips the current iteration.",
    ),
    tiles(
        "Arrange the loop header: as long as n is less than 5",
        listOf("while", "n", "<", "5", ":"),
        listOf("for", "in"),
        "while, the condition, and a colon at the end.",
    ),
)
