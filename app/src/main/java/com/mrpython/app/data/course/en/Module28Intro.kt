package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

internal val module28Intro = lesson(
    "u28l0", "Introduction: stacks and queues",
    explain(
        "Stack (LIFO)",
        "A stack works like a pile of plates: you put one on top and take one off the top. Last in, " +
            "first out (LIFO). In Python a stack is a regular list: `append()` puts on, `pop()` takes off.",
        code = "stack = []\nstack.append(1)\nstack.append(2)\nprint(stack.pop())",
        output = "2",
    ),
    explain(
        "Top of the stack",
        "`stack[-1]` lets you peek at the top without removing it. Careful: `pop()` on an empty list " +
            "raises an `IndexError`, so before removing it's worth checking that the stack isn't empty.",
        code = "stack = [\"a\", \"b\"]\nprint(stack[-1])\nprint(len(stack))",
        output = "b\n2",
    ),
    explain(
        "Queue (FIFO) with deque",
        "A queue works like a checkout line: first come, first out (FIFO). We use `deque` from the " +
            "`collections` module: `append()` adds to the end, `popleft()` takes from the front in `O(1)`.",
        code = "from collections import deque\nq = deque([\"Amy\", \"Jon\"])\nq.append(\"Eve\")\nprint(q.popleft())",
        output = "Amy",
    ),
    explain(
        "Checking brackets",
        "A stack is great for checking brackets: we push an opening bracket onto the stack, and a closing one " +
            "must match the top. The string is valid when nothing was missing and the stack is empty at the end.",
        code = "stack = []\nfor c in \"(()\":\n    if c == \"(\":\n        stack.append(c)\n    else:\n        stack.pop()\nprint(len(stack))",
        output = "1",
    ),
    explain(
        "Undo and order",
        "An \"undo\" history is a stack – we undo the newest change. A queue processes things in the order " +
            "they were added, while a stack goes deep into the newest ones first. `extend()` adds many elements at once.",
        code = "history = [\"a\", \"ab\", \"abc\"]\nhistory.pop()\nprint(history[-1])",
        output = "ab",
    ),
    output(
        "stack = [1, 2, 3]\nstack.pop()\nstack.append(7)\nprint(stack)",
        "[1, 2, 7]",
        "pop() removed 3, and append() put 7 on top.",
    ),
    choice(
        "Which deque method takes an element from the front of the queue?",
        listOf("popleft()", "pop()", "append()", "extend()"),
        0,
        "popleft() removes the element that has waited the longest.",
    ),
    choice(
        "What does LIFO mean?",
        listOf("Last in, first out", "First in, first out", "The smallest goes out first", "Random order"),
        0,
        "Last In, First Out – that's how a stack works.",
    ),
)
