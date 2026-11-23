package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*
import com.mrpython.app.domain.CourseUnit

internal val module5 = CourseUnit(
    id = "u5",
    title = "Lists",
    description = "Store many values at once",
    lessons = listOf(
        lesson(
            "u5l1", "Creating lists",
            choice(
                "How do you create a list with the numbers 1, 2, 3?",
                listOf("[1, 2, 3]", "[1 2 3]", "(1, 2, 3)", "\"1, 2, 3\""),
                0,
                "Lists are written in square brackets, with the elements separated by commas. \"1, 2, 3\" in quotes is a string, not a list.",
            ),
            output(
                "fruits = [\"apple\", \"banana\", \"kiwi\"]\nprint(fruits[0])",
                "apple",
                "Indexes start at 0.",
            ),
            output(
                "fruits = [\"apple\", \"banana\", \"kiwi\"]\nprint(fruits[-1])",
                "kiwi",
                "Index -1 means the last element.",
            ),
            output("print(len([4, 8, 15, 16]))", "4", "len() returns the number of elements."),
            fill(
                "Add 3 to the end of the list.",
                "numbers = [1, 2]\nnumbers.____(3)\nprint(numbers)",
                listOf("append", "add", "pop"),
                "append",
                "The append() method adds an element to the end of a list.",
            ),
            output("x = [10, 20, 30]\nx[1] = 99\nprint(x)", "[10, 99, 30]", "You can replace a list element using its index."),
            choice(
                "What will happen?",
                listOf("An IndexError", "It prints 3", "It prints None", "It prints [1, 2, 3]"),
                0,
                "The indexes of this list are 0, 1 and 2 – index 3 doesn't exist.",
                code = "x = [1, 2, 3]\nprint(x[3])",
            ),
        ),
        lesson(
            "u5l2", "List operations",
            output(
                "x = [1, 2, 3, 4, 5]\nprint(x[1:3])",
                "[2, 3]",
                "The slice [1:3] takes the elements at indexes 1 and 2.",
            ),
            output(
                "x = [3, 1, 2]\nx.sort()\nprint(x)",
                "[1, 2, 3]",
                "sort() puts the list in ascending order.",
            ),
            choice(
                "What will this code print?",
                listOf("True", "False", "cat", "1"),
                0,
                "The in operator checks whether an element is in the list.",
                code = "animals = [\"dog\", \"cat\"]\nprint(\"cat\" in animals)",
            ),
            output(
                "names = [\"Ann\", \"Tom\"]\nfor name in names:\n    print(\"Hi \" + name)",
                "Hi Ann\nHi Tom",
                "A for loop goes through the list's elements one by one.",
            ),
            tiles(
                "Store the sum of the numbers in the list grades in the variable total",
                listOf("total", "=", "sum(grades)"),
                listOf("len(grades)", "+="),
                "The built-in sum() function adds up all the elements.",
            ),
            output("x = [5, 1, 4]\nprint(max(x), min(x), sum(x))", "5 1 10", "max, min and sum work on lists of numbers."),
            output(
                "x = [1, 2, 3, 4, 5]\nprint(x[:2])\nprint(x[3:])",
                "[1, 2]\n[4, 5]",
                "Leaving out the start or end of a slice means \"from the beginning\" or \"to the end\".",
            ),
        ),
        lesson(
            "u5l3", "Changing lists",
            output("x = [1, 2, 3]\nx.remove(2)\nprint(x)", "[1, 3]", "remove() deletes the first element with the given value."),
            output(
                "x = [\"a\", \"b\", \"c\"]\nlast = x.pop()\nprint(last)\nprint(x)",
                "c\n['a', 'b']",
                "pop() removes and returns the last element. Strings inside a list are printed in single quotes.",
            ),
            output("x = [1, 3]\nx.insert(1, 2)\nprint(x)", "[1, 2, 3]", "insert(index, value) puts an element at the given position."),
            output("x = [\"a\", \"b\", \"c\"]\nprint(x.index(\"c\"))", "2", "index() returns the position of an element."),
            choice(
                "Which method removes the element at a given index and returns it?",
                listOf("pop", "remove", "delete", "index"),
                0,
                "pop(i) removes the element at index i and returns it. remove() looks for a value, and index() only gives the position.",
            ),
            output("a = [1, 2]\nb = [3]\nprint(a + b)", "[1, 2, 3]", "+ joins two lists into a new one."),
            fill(
                "Fill in the blank to sort the list in descending order.",
                "x = [2, 9, 4]\nx.sort(reverse=____)\nprint(x)",
                listOf("True", "False", "None"),
                "True",
                "reverse=True reverses the sort order.",
            ),
            output(
                "x = [3, 1, 2]\nprint(sorted(x))\nprint(x)",
                "[1, 2, 3]\n[3, 1, 2]",
                "sorted() returns a new list and leaves the original unchanged.",
            ),
        ),
        lesson(
            "u5l4", "Lists and loops",
            output("numbers = [2, 4, 6]\nfor n in numbers:\n    print(n * 10)", "20\n40\n60", "The loop goes through every element of the list."),
            output(
                "x = [\"a\", \"b\", \"c\"]\nfor i in range(len(x)):\n    print(i, x[i])",
                "0 a\n1 b\n2 c",
                "range(len(x)) gives the list's indexes one after another.",
            ),
            output(
                "results = []\nfor i in range(4):\n    results.append(i * i)\nprint(results)",
                "[0, 1, 4, 9]",
                "The list is built step by step with append().",
            ),
            output(
                "grades = [4, 5, 3, 5]\ncount = 0\nfor g in grades:\n    if g == 5:\n        count += 1\nprint(count)",
                "2",
                "The loop counts the fives.",
            ),
            output(
                "x = [3, 8, 1]\nbiggest = x[0]\nfor n in x:\n    if n > biggest:\n        biggest = n\nprint(biggest)",
                "8",
                "This is how max() works \"under the hood\".",
            ),
            fill(
                "Fill in the blank to print all the elements of the list.",
                "names = [\"Ann\", \"Tom\"]\nfor name ____ names:\n    print(name)",
                listOf("in", "range", "="),
                "in",
                "Looping over a list: for element in list:",
            ),
            tiles(
                "Build the header of a loop over the indexes of the list data",
                listOf("for", "i", "in", "range(len(data))", ":"),
                listOf("range(data)", "len(data)"),
                "range(len(list)) gives the indexes 0, 1, 2, …",
            ),
            output("words = [\"cat\", \"frog\"]\nfor w in words:\n    print(len(w))", "3\n4", "len() works on strings too."),
        ),
        lesson(
            "u5l5", "Review: lists",
            output("x = [1, 2, 3]\nx.append(4)\nprint(len(x))", "4", "After append the list has 4 elements."),
            output("x = [\"p\", \"y\", \"t\"]\nprint(x[-2])", "y", "-2 is the second-to-last element."),
            choice(
                "What will this code print?",
                listOf("[1, 2, 3, 4]", "[1, 2, 3]", "[4]", "An error"),
                0,
                "y = x doesn't copy the list – both names point to the same list.",
                code = "x = [1, 2, 3]\ny = x\ny.append(4)\nprint(x)",
            ),
            output("x = [5, 3, 8]\nx.sort()\nprint(x[0])", "3", "After sorting, the smallest element comes first."),
            output("print(sum([1, 2, 3]) / len([1, 2, 3]))", "2.0", "The average is the sum divided by the number of elements."),
            fill(
                "Fill in the blank to remove the last element of the list.",
                "x = [1, 2, 3]\nx.____()\nprint(x)",
                listOf("pop", "remove", "append"),
                "pop",
                "pop() with no argument removes the last element.",
            ),
            output("x = [0, 1, 2, 3, 4, 5]\nprint(x[1:5:2])", "[1, 3]", "The third number in a slice is the step."),
            output("x = []\nprint(len(x))\nprint(bool(x))", "0\nFalse", "An empty list has length 0 and is \"falsy\"."),
        ),
    ),
)
