package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*
import com.mrpython.app.domain.CourseUnit

internal val module53 = CourseUnit(
    id = "u53",
    title = "Debugging",
    description = "Finding and fixing common bugs",
    lessons = listOf(
        lesson(
            "u53l1", "Off-by-one errors",
            choice(
                "The program was supposed to print the numbers from 1 to 5. Where is the bug?",
                listOf("range(1, 5) ends at 4", "print doesn't accept end", "The loop should start at 0", "A return is missing"),
                0,
                "The end of a range is not included.",
                code = "for i in range(1, 5):\n    print(i, end=\" \")",
            ),
            output(
                "for i in range(1, 5):\n    print(i, end=\" \")",
                "1 2 3 4",
                "range(1, 5) stops before 5 – a classic off-by-one error.",
            ),
            fill(
                "Fix the range to print the numbers from 1 to 5.",
                "for i in range(1, ____):\n    print(i, end=\" \")",
                listOf("6", "5", "4"),
                "6",
                "To include 5, the end of the range must be 6.",
            ),
            output(
                "items = [10, 20, 30]\ntry:\n    print(items[len(items)])\nexcept IndexError:\n    print(\"IndexError\")",
                "IndexError",
                "The last index is len(items) - 1, which is 2.",
            ),
            choice(
                "Which expression correctly returns the last element of the list?",
                listOf("items[len(items) - 1]", "items[len(items)]", "items[len(items) + 1]", "items[1:]"),
                0,
                "Indexes start at 0, so the last one is len(items) - 1.",
            ),
            output(
                "i = 0\ncount = 0\nwhile i <= 3:\n    count += 1\n    i += 1\nprint(count)",
                "4",
                "The condition <= 3 covers the values 0, 1, 2 and 3 – that's four iterations.",
            ),
            choice(
                "The function was supposed to return 1 + 2 + 3 = 6. Where is the bug?",
                listOf("range(n) skips n – it needs range(n + 1)", "total should start at 1", "A print is missing in the loop", "return is indented wrong"),
                0,
                "range(3) gives 0, 1, 2, so the sum is only 3.",
                code = "def sum_to(n):\n    total = 0\n    for i in range(n):\n        total += i\n    return total\n\nprint(sum_to(3))",
            ),
            output(
                "def sum_to(n):\n    total = 0\n    for i in range(n):\n        total += i\n    return total\n\nprint(sum_to(3))",
                "3",
                "Only 0, 1 and 2 are added up.",
            ),
        ),
        lesson(
            "u53l2", "= vs. == and indentation",
            choice(
                "What's wrong with this code?",
                listOf("= is assignment – the condition needs ==", "Parentheses are missing around the condition", "x must be a string", "Nothing, the code is correct"),
                0,
                "Using = in an if is a SyntaxError; a comparison is written as ==.",
                code = "x = 5\nif x = 5:\n    print(\"five\")",
            ),
            output(
                "x = 3\nresult = x == 5\nprint(result)",
                "False",
                "x == 5 is a comparison, and we store its result in a variable.",
            ),
            fill(
                "Fill in the comparison operator.",
                "age = 18\nif age ____ 18:\n    print(\"exactly 18\")",
                listOf("==", "=", "=>"),
                "==",
                "We check equality with the == operator.",
            ),
            output(
                "total = 0\nfor x in [1, 2, 3]:\n    total += x\n    print(total)",
                "1\n3\n6",
                "print is indented inside the loop, so it runs on every iteration.",
                instruction = "The programmer wanted to print only the final total. What does this program print?",
            ),
            choice(
                "How do you fix the code from the previous exercise so it prints only 6?",
                listOf("Unindent print", "Change += to =", "Add a return", "Turn the list into a tuple"),
                0,
                "An unindented print is outside the loop, so it runs once, after the loop finishes.",
            ),
            output(
                "def has_even(items):\n    for x in items:\n        if x % 2 == 0:\n            return True\n        return False\n\nprint(has_even([1, 2]))",
                "False",
                "return False is inside the loop, so the function ends right after the first element.",
            ),
            choice(
                "Where should return False go in the has_even function?",
                listOf("After the loop, at the same level as for", "Inside the if", "Before the loop", "Nowhere – return True is enough"),
                0,
                "We return False only once the loop has checked every element.",
            ),
            tiles(
                "Write a condition: is result equal to 10?",
                listOf("if", "result", "==", "10:"),
                listOf("=", "=>"),
                "A comparison in an if requires ==.",
            ),
        ),
        lesson(
            "u53l3", "List pitfalls",
            output(
                "def add(x, items=[]):\n    items.append(x)\n    return items\n\nprint(add(1))\nprint(add(2))",
                "[1]\n[1, 2]",
                "The default list is shared by all calls.",
            ),
            choice(
                "Why does the second call to add remember the previous element?",
                listOf("The default list is created once", "append copies the list", "Python saves function results", "Because x is global"),
                0,
                "A default value is created only once, when the function is defined, and then shared.",
            ),
            fill(
                "Fix the function so that every call starts with an empty list.",
                "def add(x, items=____):\n    if items is None:\n        items = []\n    items.append(x)\n    return items\n\nprint(add(1))\nprint(add(2))",
                listOf("None", "{}", "0"),
                "None",
                "None as the default value plus a new list inside the function is the safe pattern.",
            ),
            output(
                "def add(x, items=None):\n    if items is None:\n        items = []\n    items.append(x)\n    return items\n\nprint(add(1))\nprint(add(2))",
                "[1]\n[2]",
                "Every call now creates a new list.",
            ),
            output(
                "numbers = [2, 4, 5, 6]\nfor x in numbers:\n    if x % 2 == 0:\n        numbers.remove(x)\nprint(numbers)",
                "[4, 5]",
                "Removing an element shifts the rest, so the loop skips the number 4.",
            ),
            choice(
                "Why did the number 4 stay in the list in the previous exercise?",
                listOf("The loop skipped over 4", "remove only removes odd numbers", "4 % 2 is not equal to 0", "The for loop doesn't see changes"),
                0,
                "After 2 was removed, the elements shifted and the loop skipped over 4. Don't modify a list while you're iterating over it.",
            ),
            fill(
                "Fill in the blank so the loop goes over a copy of the list and removes all even numbers.",
                "numbers = [2, 4, 5, 6]\nfor x in numbers____:\n    if x % 2 == 0:\n        numbers.remove(x)\nprint(numbers)",
                listOf("[:]", "[0]", "[-1]"),
                "[:]",
                "numbers[:] is a copy, so removing from the original doesn't break the loop.",
            ),
            output(
                "def count(word, result={}):\n    result[word] = result.get(word, 0) + 1\n    return result\n\ncount(\"a\")\nprint(count(\"b\"))",
                "{'a': 1, 'b': 1}",
                "A default dictionary is shared between calls too.",
            ),
        ),
        lesson(
            "u53l4", "Shadowing built-in names",
            output(
                "list = [3, 1, 2]\ntry:\n    print(list(\"abc\"))\nexcept TypeError:\n    print(\"TypeError\")",
                "TypeError",
                "The name list now refers to a list, and a list can't be called.",
            ),
            choice(
                "Why didn't list(\"abc\") work in the previous exercise?",
                listOf("A variable shadowed list", "list doesn't accept strings", "An import is missing", "The string is too short"),
                0,
                "Your own variable with the name of a built-in function hides it.",
            ),
            output(
                "sum = 0\nfor x in [1, 2, 3]:\n    sum += x\nprint(sum)",
                "6",
                "It works for now, but the name sum no longer means the built-in function.",
            ),
            choice(
                "What happens when you run this code?",
                listOf("TypeError", "It prints 9", "It prints 15", "NameError"),
                0,
                "sum is now the number 6, so it can't be called like a function: 'int' object is not callable.",
                code = "sum = 0\nfor x in [1, 2, 3]:\n    sum += x\nprint(sum([4, 5]))",
            ),
            fill(
                "Choose a variable name that won't break the rest of the code.",
                "____ = [5, 2, 8]\nprint(max([1, 9]))",
                listOf("numbers", "max", "print"),
                "numbers",
                "The names max and print would shadow built-in functions.",
            ),
            output(
                "dict = {\"a\": 1}\ntry:\n    d = dict(b=2)\nexcept TypeError:\n    print(\"dict is broken\")",
                "dict is broken",
                "The variable dict shadowed the dict type.",
            ),
            choice(
                "Which names are best avoided for your own variables?",
                listOf("list, str, sum, max", "items, text, total, largest", "results, data, x, y", "name, age, price, quantity"),
                0,
                "These are the names of built-in functions and types.",
            ),
            output(
                "str = \"text\"\ndel str\nprint(str(42) + \"!\")",
                "42!",
                "del removes our variable, so str means the built-in function again.",
            ),
        ),
        lesson(
            "u53l5", "Division and the missing return",
            output(
                "print(7 / 2, 7 // 2)",
                "3.5 3",
                "/ gives a float, while // rounds down to a whole number.",
            ),
            choice(
                "The average of the grades 4 and 5 should be 4.5. Where is the bug?",
                listOf("It needs / instead of //", "sum doesn't work on lists", "len returns the wrong number", "round is missing"),
                0,
                "// rounds the result down (9 // 2 is 4), but an average needs ordinary division with /.",
                code = "grades = [4, 5]\naverage = sum(grades) // len(grades)\nprint(average)",
            ),
            output(
                "grades = [4, 5]\naverage = sum(grades) // len(grades)\nprint(average)",
                "4",
                "9 // 2 is 4, not 4.5.",
            ),
            output(
                "print(-7 // 2)",
                "-4",
                "// rounds down, toward negative infinity.",
            ),
            output(
                "def double(x):\n    result = x * 2\n\nprint(double(5))",
                "None",
                "The function computes the result but doesn't return it.",
            ),
            choice(
                "Why does the function from the previous exercise return None?",
                listOf("return result is missing", "x * 2 is an error", "print can't print a number", "The variable result is global"),
                0,
                "A function without a return returns None.",
            ),
            fill(
                "Fill in the blank so the function gives back the area of a rectangle.",
                "def area(a, b):\n    ____ a * b\n\nprint(area(3, 4))",
                listOf("return", "print", "="),
                "return",
                "Only return passes the result back to the caller.",
            ),
            output(
                "def grade(p):\n    if p >= 50:\n        return \"passed\"\n\nprint(grade(70), grade(30))",
                "passed None",
                "For 30 no return runs, so the result is None.",
            ),
        ),
        lesson(
            "u53l6", "Review: debugging",
            choice(
                "Which error does this code raise?",
                listOf("IndexError", "KeyError", "TypeError", "No error"),
                0,
                "The range is one too large: the last index is 2, but range(4) goes up to 3.",
                code = "items = [1, 2, 3]\nfor i in range(len(items) + 1):\n    print(items[i])",
            ),
            output(
                "def half(n):\n    return n // 2\n\nprint(half(5))",
                "2",
                "// rounds down, so 5 // 2 is 2 – half of 5 needs /.",
            ),
            output(
                "def larger(a, b):\n    if a > b:\n        return a\n    elif b > a:\n        return b\n\nprint(larger(3, 3))",
                "None",
                "The case a == b has no return of its own.",
            ),
            choice(
                "Which line shadows a built-in function?",
                listOf("max = 10", "maximum = 10", "result = 10", "largest = 10"),
                0,
                "max is the name of a built-in function.",
            ),
            output(
                "def record(x, log=[]):\n    log.append(x)\n    return len(log)\n\nrecord(\"a\")\nrecord(\"b\")\nprint(record(\"c\"))",
                "3",
                "The default list is shared, so it grows with every call.",
            ),
            fill(
                "Fill in the operator to check the password.",
                "password = \"secret\"\nif password ____ \"secret\":\n    print(\"OK\")",
                listOf("==", "=", "!="),
                "==",
                "Equality is checked with ==; = is assignment (a SyntaxError in an if), and != checks whether the values differ.",
            ),
            tiles(
                "Write the header of a loop that goes over a copy of the list numbers.",
                listOf("for", "x", "in", "numbers[:]:"),
                listOf("numbers:", "range"),
                "The [:] copy lets you safely remove elements from the original.",
            ),
            choice(
                "What's the best thing to do first when a program gives a wrong result?",
                listOf("Print the variables' values", "Rewrite the whole program", "Add more loops", "Ignore the bug"),
                0,
                "Reproduce the bug on a small example and print the variables' values (or use a debugger) – you'll see where they go off track.",
            ),
        ),
    ),
)
