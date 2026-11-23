package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

internal val module28Cards = listOf(
    cards(
        "u28l1",
        explain(
            "Emptying a stack",
            "`while stack:` runs as long as the stack isn't empty. The removed elements come out in reverse " +
                "order, so a stack easily reverses a string or a list. `clear()` empties the stack all at once.",
            code = "stack = list(\"cat\")\nresult = \"\"\nwhile stack:\n    result += stack.pop()\nprint(result)",
            output = "tac",
        ),
    ),
    cards(
        "u28l2",
        explain(
            "Both ends of a deque",
            "A `deque` has operations for both ends: `append()` and `pop()` work at the end, while `appendleft()` " +
                "and `popleft()` work at the front. A regular list only has the slow `pop(0)`, which shifts the rest.",
            code = "from collections import deque\nq = deque([2, 3])\nq.appendleft(1)\nprint(q.pop(), q.popleft())",
            output = "3 1",
        ),
        explain(
            "A deque is like a list",
            "`q[0]` is the front of the queue, and `q[-1]` is its end. `len(q)`, a `while q:` loop, " +
                "and `list(q)`, which shows the contents as a regular list, work too.",
            code = "from collections import deque\nq = deque([1, 2, 3])\nq.append(q.popleft())\nprint(q[0], q[-1], len(q))\nprint(list(q))",
            output = "2 1 3\n[2, 3, 1]",
        ),
    ),
    cards(
        "u28l3",
        explain(
            "Empty stack: not stack",
            "`not stack` is true when the stack is empty. If a `)` arrives and the stack is empty, " +
                "the bracket has no match. At the end, `return not stack` returns `True` only if nothing is left.",
            code = "stack = []\nprint(not stack)\nstack.append(\"(\")\nprint(not stack)",
            output = "True\nFalse",
        ),
        explain(
            "Different brackets",
            "With several kinds of brackets, a dictionary gives the matching opening one: `pairs[\")\"]` is `\"(\"`. " +
                "A closing bracket is fine when its partner is on top, at `stack[-1]`.",
            code = "pairs = {\")\": \"(\", \"]\": \"[\"}\nstack = [\"(\", \"[\"]\nprint(stack[-1] == pairs[\"]\"])\nprint(\"[\" in \"([\")",
            output = "True\nTrue",
        ),
    ),
    cards(
        "u28l4",
        explain(
            "Undo and redo",
            "\"Redo\" needs a second stack. When undoing, we take the change off `undo` and put it " +
                "on `redo`. Redo does the same thing in the other direction.",
            code = "undo = [\"a\", \"b\", \"c\"]\nredo = []\nredo.append(undo.pop())\nprint(undo, redo)",
            output = "['a', 'b'] ['c']",
        ),
        explain(
            "Breadth-first or depth-first?",
            "A dictionary can describe what leads to what, e.g. `{\"A\": [\"B\", \"C\"]}`. When we take an element, we add " +
                "its \"children\" with `extend()`. A queue (`popleft()`) goes level by level, and a stack (`pop()`) goes deep.",
            code = "children = {\"A\": [\"B\", \"C\"], \"B\": [\"D\"], \"C\": [], \"D\": []}\nstack = [\"A\"]\nwhile stack:\n    node = stack.pop()\n    print(node, end=\"\")\n    stack.extend(children[node])",
            output = "ACBD",
        ),
    ),
)
