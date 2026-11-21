package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*
import com.mrpython.app.domain.CourseUnit

internal val module28 = CourseUnit(
    id = "u28",
    title = "Stacks and Queues",
    description = "A stack on a list, a queue with deque, and what they're used for",
    lessons = listOf(
        lesson(
            "u28l1", "A stack on a list",
            output(
                "stack = []\nstack.append(1)\nstack.append(2)\nstack.append(3)\nprint(stack.pop())",
                "3",
                "pop() removes the element that was added last.",
            ),
            output(
                "stack = [1, 2, 3]\nstack.pop()\nstack.append(9)\nprint(stack)",
                "[1, 2, 9]",
                "We take 3 off the top and put 9 there.",
            ),
            choice(
                "What does the acronym LIFO, which describes a stack, mean?",
                listOf("Last in, first out", "First in, first out", "The smallest goes out first", "Random order"),
                0,
                "Last In, First Out – like a stack of plates.",
            ),
            output(
                "stack = [\"a\", \"b\"]\nprint(stack[-1])\nprint(len(stack))",
                "b\n2",
                "stack[-1] peeks at the top but doesn't remove anything.",
            ),
            output(
                "stack = []\nfor c in \"cat\":\n    stack.append(c)\nresult = \"\"\nwhile stack:\n    result += stack.pop()\nprint(result)",
                "tac",
                "The stack gives the letters back in reverse order.",
            ),
            fill(
                "Fill in the blank to remove the element from the top of the stack.",
                "stack = [4, 5, 6]\nx = stack.____()\nprint(x, stack)",
                listOf("pop", "append", "clear"),
                "pop",
                "pop() removes and returns the last element.",
            ),
            choice(
                "What will happen?",
                listOf("IndexError – the stack is empty", "It returns None", "It returns 0", "Nothing"),
                0,
                "You can't remove anything from an empty list.",
                code = "stack = []\nstack.pop()",
            ),
            tiles(
                "Remove the element from the top of the stack and store it in the variable x",
                listOf("x", "=", "stack.pop()"),
                listOf("stack.append()", "stack[0]"),
                "pop() returns the removed element.",
            ),
        ),
        lesson(
            "u28l2", "A queue with deque",
            output(
                "from collections import deque\nq = deque()\nq.append(\"A\")\nq.append(\"B\")\nprint(q.popleft())",
                "A",
                "popleft() removes the element from the front of the queue.",
            ),
            choice(
                "What does the acronym FIFO, which describes a queue, mean?",
                listOf("First in, first out", "Last in, first out", "The largest goes out first", "Random order"),
                0,
                "First In, First Out – like a checkout line.",
            ),
            output(
                "from collections import deque\nq = deque([1, 2, 3])\nq.popleft()\nq.append(4)\nprint(list(q))",
                "[2, 3, 4]",
                "1 leaves from the front, and 4 joins at the end.",
            ),
            choice(
                "Why is deque a better choice for a queue than a list with pop(0)?",
                listOf(
                    "popleft() is O(1), while pop(0) on a list is O(n)",
                    "A list has no pop method",
                    "deque sorts the elements",
                    "deque doesn't let you add elements",
                ),
                0,
                "pop(0) shifts all the other elements of the list.",
            ),
            output(
                "from collections import deque\nqueue = deque([\"Amy\", \"Jon\", \"Eve\"])\nwhile queue:\n    person = queue.popleft()\n    print(person)",
                "Amy\nJon\nEve",
                "The queue serves people in the order they arrived.",
            ),
            fill(
                "Fill in the blank to serve the first person in the queue.",
                "from collections import deque\nq = deque([\"Amy\", \"Jon\"])\nprint(q.____())",
                listOf("popleft", "pop", "append"),
                "popleft",
                "popleft() takes the element from the front of the queue.",
            ),
            output(
                "from collections import deque\nq = deque([1, 2, 3])\nx = q.popleft()\nq.append(x)\nprint(q[0], q[-1])",
                "2 1",
                "The first element moves to the end of the queue.",
            ),
            tiles(
                "Import deque from the collections module",
                listOf("from", "collections", "import", "deque"),
                listOf("deque.collections", "include"),
                "from module import name.",
            ),
        ),
        lesson(
            "u28l3", "Checking brackets",
            output(
                "count = 0\nfor c in \"(()())\":\n    if c == \"(\":\n        count += 1\n    else:\n        count -= 1\nprint(count)",
                "0",
                "There are as many opening brackets as closing ones.",
            ),
            choice(
                "Why isn't a counter alone enough for the string \")(\"?",
                listOf("The counter gives 0, but the brackets are in the wrong order", "The counter raises an error", "The counter gives 2", "Because the string \")(\" is valid"),
                0,
                "The count matches, but a bracket closes before it was opened.",
            ),
            output(
                "def ok(s):\n    stack = []\n    for c in s:\n        if c == \"(\":\n            stack.append(c)\n        elif not stack:\n            return False\n        else:\n            stack.pop()\n    return not stack\nprint(ok(\"(())\"), ok(\"())(\"))",
                "True False",
                "In \"())(\" the second \")\" has no match, because the stack is already empty.",
            ),
            output(
                "pairs = {\")\": \"(\", \"]\": \"[\"}\nstack = []\nfor c in \"([)]\":\n    if c in \"([\":\n        stack.append(c)\n    elif stack and stack[-1] == pairs[c]:\n        stack.pop()\n    else:\n        print(\"error at\", c)\n        break",
                "error at )",
                "\"[\" is on top, but \")\" arrived – the brackets cross each other.",
            ),
            fill(
                "Fill in the blank to check whether the closing bracket matches the most recently opened one.",
                "pairs = {\")\": \"(\", \"]\": \"[\"}\nstack = [\"(\", \"[\"]\nc = \"]\"\nprint(stack____ == pairs[c])",
                listOf("[-1]", "[0]", ".pop(0)"),
                "[-1]",
                "The most recently opened bracket is on top of the stack, at [-1].",
            ),
            output(
                "stack = []\nfor c in \"(()\":\n    if c == \"(\":\n        stack.append(c)\n    else:\n        stack.pop()\nprint(len(stack))",
                "1",
                "One bracket was opened and never closed.",
            ),
            choice(
                "When is a string of brackets valid?",
                listOf(
                    "When every closing bracket matches the most recently opened one and the stack is empty at the end",
                    "When it has an even number of characters",
                    "When it starts with \"(\"",
                    "When the number of \"(\" equals the number of \")\"",
                ),
                0,
                "You have to check both the order and that nothing is left open.",
            ),
            tiles(
                "Store in the variable valid whether the stack is empty",
                listOf("valid", "=", "len(stack) == 0"),
                listOf("len(stack) = 0", "stack.pop()"),
                "An empty stack means every bracket was closed.",
            ),
        ),
        lesson(
            "u28l4", "Undo and processing order",
            output(
                "history = [\"a\", \"ab\", \"abc\"]\nhistory.pop()\nprint(history[-1])",
                "ab",
                "Undo removes the last state and goes back to the previous one.",
            ),
            output(
                "state = \"Ann\"\nhistory = [state]\nstate = state + \" has\"\nhistory.append(state)\nstate = state + \" a cat\"\nstate = history.pop()\nprint(state)",
                "Ann has",
                "The most recently saved state is \"Ann has\", so that's what we go back to.",
            ),
            choice(
                "Which structure should you use for an \"undo\" history (Ctrl+Z)?",
                listOf("A stack – we undo the latest change", "A queue – we undo the oldest change", "A set", "A tuple"),
                0,
                "We always undo the newest change – that's LIFO.",
            ),
            output(
                "undo = [\"a\", \"b\", \"c\"]\nredo = []\nredo.append(undo.pop())\nredo.append(undo.pop())\nundo.append(redo.pop())\nprint(undo, redo)",
                "['a', 'b'] ['c']",
                "Two undos move c and b, and the redo gives b back.",
            ),
            output(
                "from collections import deque\nchildren = {\"A\": [\"B\", \"C\"], \"B\": [\"D\"],\n            \"C\": [\"E\"], \"D\": [], \"E\": []}\nq = deque([\"A\"])\nresult = \"\"\nwhile q:\n    node = q.popleft()\n    result += node\n    q.extend(children[node])\nprint(result)",
                "ABCDE",
                "A queue processes level by level: first A, then B and C, then D and E.",
            ),
            output(
                "children = {\"A\": [\"B\", \"C\"], \"B\": [\"D\"],\n            \"C\": [\"E\"], \"D\": [], \"E\": []}\nstack = [\"A\"]\nresult = \"\"\nwhile stack:\n    node = stack.pop()\n    result += node\n    stack.extend(children[node])\nprint(result)",
                "ACEBD",
                "A stack takes the most recently added element, so it first goes deep into the C branch.",
            ),
            fill(
                "Fill in the blank to process the elements in the order they were added (breadth-first).",
                "from collections import deque\nchildren = {\"A\": [\"B\", \"C\"], \"B\": [], \"C\": []}\nq = deque([\"A\"])\nresult = \"\"\nwhile q:\n    node = q.____()\n    result += node\n    q.extend(children[node])\nprint(result)",
                listOf("popleft", "pop", "clear"),
                "popleft",
                "popleft() takes the oldest element, so we get ABC.",
            ),
            tiles(
                "Add all the children of the element node to the end of the queue q",
                listOf("q.extend(", "children[node]", ")"),
                listOf("q.popleft(", "children(node)"),
                "extend() adds all the elements of a list to the end.",
            ),
        ),
        lesson(
            "u28l5", "Review: stacks and queues",
            output(
                "s = []\ns.append(1)\ns.append(2)\ns.pop()\ns.append(3)\nprint(s)",
                "[1, 3]",
                "2 was removed before we put 3 on.",
            ),
            output(
                "from collections import deque\nq = deque()\nfor x in [5, 6, 7]:\n    q.append(x)\nq.popleft()\nprint(q[0])",
                "6",
                "5 left the queue, so 6 is at the front.",
            ),
            choice(
                "Customers wait at a checkout and are served in the order they arrived. What structure is this?",
                listOf("A queue (FIFO)", "A stack (LIFO)", "A set", "A tuple"),
                0,
                "First come, first served.",
            ),
            choice(
                "Which code removes the element from the top of a stack stored in the list stack?",
                listOf("stack.pop()", "stack.pop(0)", "stack.popleft()", "stack.remove()"),
                0,
                "The top of the stack is the end of the list, and pop() with no argument removes the last element.",
            ),
            output(
                "def ok(s):\n    stack = []\n    for c in s:\n        if c == \"(\":\n            stack.append(c)\n        elif stack:\n            stack.pop()\n        else:\n            return False\n    return len(stack) == 0\nprint(ok(\"()()\"), ok(\"(()\"))",
                "True False",
                "In \"(()\" one bracket is left on the stack.",
            ),
            fill(
                "Fill in the blank to add an element to the end of the queue.",
                "from collections import deque\nq = deque([1, 2])\nq.____(3)\nprint(list(q))",
                listOf("append", "appendleft", "popleft"),
                "append",
                "append() adds to the end of the queue.",
            ),
            output(
                "stack = [1, 2, 3]\nrev = []\nwhile stack:\n    rev.append(stack.pop())\nprint(rev)",
                "[3, 2, 1]",
                "Moving items off a stack reverses their order.",
            ),
            tiles(
                "Create an empty queue q",
                listOf("q", "=", "deque()"),
                listOf("deque[]", "=="),
                "deque() creates an empty queue.",
            ),
        ),
    ),
)
