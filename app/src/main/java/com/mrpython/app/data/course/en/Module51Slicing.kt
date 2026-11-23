package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*
import com.mrpython.app.domain.CourseUnit

internal val module51 = CourseUnit(
    id = "u51",
    title = "Slices and copying",
    description = "Advanced slices, slice assignment, and list copies",
    lessons = listOf(
        lesson(
            "u51l1", "Slices with a negative step",
            output("x = [0, 1, 2, 3, 4, 5]\nprint(x[::-2])", "[5, 3, 1]", "A step of -2 goes from the end, taking every second element."),
            output("x = [0, 1, 2, 3, 4, 5]\nprint(x[4:1:-1])", "[4, 3, 2]", "With a negative step, start is greater than stop; stop is not included."),
            choice(
                "Which slice returns the last three elements of list x?",
                listOf("x[-3:]", "x[:-3]", "x[3:]", "x[::-3]"),
                0,
                "x[-3:] starts at the third element from the end and goes to the end of the list.",
            ),
            output("x = [0, 1, 2, 3, 4, 5]\nprint(x[1:4:-1])", "[]", "The step is negative but start is less than stop, so the slice is empty."),
            output("print(\"Python\"[-1:-4:-1])", "noh", "From the last character backward, not including index -4."),
            output("x = [0, 1, 2, 3, 4, 5]\nprint(x[:-1][::-1])", "[4, 3, 2, 1, 0]", "First drop the last element, then reverse."),
            choice(
                "Which slice returns the list's elements from the end, skipping the last one?",
                listOf("x[-2::-1]", "x[::-1]", "x[:-1]", "x[-1::-2]"),
                0,
                "A start of -2 is the second-to-last element, and a step of -1 goes backward to the beginning.",
            ),
            fill(
                "Fill in the blank to print the string backward.",
                "s = \"kayak\" + \"!\"\nprint(s[::____])",
                listOf("-1", "1", "2"),
                "-1",
                "A step of -1 reverses the order: !kayak.",
            ),
        ),
        lesson(
            "u51l2", "Slice assignment and slice objects",
            output("x = [1, 2, 3, 4]\nx[1:3] = [9]\nprint(x)", "[1, 9, 4]", "A slice can be replaced with a list of a different length."),
            output("x = [1, 2, 3]\nx[1:1] = [7, 8]\nprint(x)", "[1, 7, 8, 2, 3]", "The empty slice [1:1] lets you insert elements."),
            output("x = [0, 1, 2, 3, 4]\ndel x[::2]\nprint(x)", "[1, 3]", "del removes every element in the slice."),
            output("x = [1, 2, 3]\nx[:] = []\nprint(x)", "[]", "x[:] = [] clears the list in place."),
            output("s = slice(1, 3)\nprint([10, 20, 30, 40][s])", "[20, 30]", "A slice object is a stored [1:3] slice."),
            choice(
                "What happens?",
                listOf("A ValueError", "x is [0, 2, 3]", "x is [0, 2]", "x is [0, 0, 3]"),
                0,
                "The slice x[::2] has two spots (indexes 0 and 2), but only one element was given – the lengths don't match, so you get a ValueError.",
                code = "x = [1, 2, 3]\nx[::2] = [0]",
            ),
            fill(
                "Fill in the blank to remove the first two elements of the list.",
                "x = [5, 6, 7, 8]\n____ x[:2]\nprint(x)",
                listOf("del", "pop", "remove"),
                "del",
                "del x[:2] removes the slice; pop and remove are methods, not statements.",
            ),
            tiles(
                "Create a slice object from 2 to the end with step 2 and store it in the variable w",
                listOf("w", "=", "slice(2,", "None,", "2)"),
                listOf("range(2,", "[2::2]"),
                "slice(start, stop, step); None means “to the end”.",
            ),
        ),
        lesson(
            "u51l3", "Copying vs. aliases",
            output("a = [1, 2]\nb = a\nb.append(3)\nprint(a)", "[1, 2, 3]", "b = a doesn't copy – both names refer to the same list."),
            output("a = [1, 2]\nb = a[:]\nb.append(3)\nprint(a)", "[1, 2]", "a[:] creates a new list (a copy)."),
            output("a = [1, 2]\nprint(a is a[:], a == a[:])", "False True", "The copy is equal, but it's a different object."),
            output("a = [1, 2]\nb = list(a)\nb[0] = 9\nprint(a, b)", "[1, 2] [9, 2]", "list(a) creates a copy too."),
            output(
                "a = [[1], [2]]\nb = a[:]\nb[0].append(9)\nprint(a)",
                "[[1, 9], [2]]",
                "A shallow copy copies only the outer list; the inner lists are shared.",
            ),
            output(
                "import copy\na = [[1], [2]]\nb = copy.deepcopy(a)\nb[0].append(9)\nprint(a)",
                "[[1], [2]]",
                "deepcopy() copies nested lists as well.",
            ),
            choice(
                "Which statement does NOT create a copy of list a?",
                listOf("b = a", "b = a[:]", "b = list(a)", "b = a.copy()"),
                0,
                "Assignment only creates a second name (an alias) for the same list.",
            ),
            fill(
                "Fill in the blank to copy the inner lists as well.",
                "import copy\na = [[1, 2]]\nb = copy.____(a)\nb[0][0] = 0\nprint(a)",
                listOf("deepcopy", "copy", "list"),
                "deepcopy",
                "copy.copy() is a shallow copy, so a would change too; copy.list doesn't exist.",
            ),
        ),
        lesson(
            "u51l4", "Review: slices and copies",
            output("x = list(range(6))\nprint(x[5:0:-2])", "[5, 3, 1]", "From 5 backward in steps of 2, not including index 0."),
            output("x = [1, 2, 3]\nx[len(x):] = [4]\nprint(x)", "[1, 2, 3, 4]", "Assigning to the empty slice at the end works like appending."),
            choice(
                "What does x contain after this code runs?",
                listOf("[1, 4]", "[1, 2, 4]", "[4]", "[1, 3, 4]"),
                0,
                "del x[1:3] removes the elements at indexes 1 and 2.",
                code = "x = [1, 2, 3, 4]\ndel x[1:3]",
            ),
            output("a = [1]\nb = a\na = a + [2]\nprint(b)", "[1]", "a + [2] creates a new list, so b still refers to the old one."),
            output("a = [1]\nb = a\na += [2]\nprint(b)", "[1, 2]", "+= changes the list in place, so the change is visible through b too."),
            choice(
                "What does this code print?",
                listOf("[2, 3]", "[1, 2]", "[1, 3]", "[3]"),
                0,
                "slice(1, None) is the slice [1:].",
                code = "s = slice(1, None)\nprint([1, 2, 3][s])",
            ),
            fill(
                "Fill in the blank to make a shallow copy of the list.",
                "a = [1, 2]\nb = a.____()\nb.append(3)\nprint(a)",
                listOf("copy", "clear", "pop"),
                "copy",
                "copy() returns a copy; clear() and pop() change the original and don't return a list.",
            ),
            tiles(
                "Replace the elements at indexes 1 and 2 of list x with the elements of the list new",
                listOf("x[1:3]", "=", "new"),
                listOf("x[1:2]", "=="),
                "Assigning to a slice replaces its contents.",
            ),
        ),
    ),
)
