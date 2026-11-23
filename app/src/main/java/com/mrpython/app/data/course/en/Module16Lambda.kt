package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*
import com.mrpython.app.domain.CourseUnit

internal val module16 = CourseUnit(
    id = "u16",
    title = "Lambda and higher-order functions",
    description = "Anonymous functions, key, map, filter and functions as values",
    lessons = listOf(
        lesson(
            "u16l1", "The lambda expression",
            output("double = lambda x: x * 2\nprint(double(4))", "8", "lambda x: x * 2 is a small function that doubles its argument."),
            output("add = lambda a, b: a + b\nprint(add(2, 3))", "5", "A lambda can have several parameters separated by commas."),
            choice(
                "Which function works the same as lambda x: x + 1?",
                listOf("def f(x): return x + 1", "def f(x): print(x + 1)", "def f(): return x + 1", "def f(x): x + 1"),
                0,
                "A lambda automatically returns the value of its expression.",
            ),
            output("print((lambda s: s.upper())(\"hi\"))", "HI", "You can call a lambda right away by passing the argument in parentheses."),
            choice(
                "What can go in the body of a lambda?",
                listOf("A single expression", "Any number of statements", "An indented for loop", "A return statement"),
                0,
                "A lambda is a single expression whose result is returned.",
            ),
            fill(
                "Fill in the blank to create an anonymous function.",
                "sq = ____ x: x * x\nprint(sq(5))",
                listOf("lambda", "def", "func"),
                "lambda",
                "An anonymous function is created with the word lambda.",
            ),
            output("is_even = lambda n: n % 2 == 0\nprint(is_even(3), is_even(4))", "False True", "The lambda returns the result of the comparison."),
            tiles(
                "Store in the variable triple a lambda that multiplies x by 3",
                listOf("triple", "=", "lambda x:", "x * 3"),
                listOf("def x:", "return"),
                "After the lambda's colon we write only the expression, without return.",
            ),
        ),
        lesson(
            "u16l2", "sorted, min and max with key",
            output(
                "words = [\"kiwi\", \"banana\", \"fig\"]\nprint(sorted(words, key=len))",
                "['fig', 'kiwi', 'banana']",
                "key=len sorts by word length.",
            ),
            output("print(max([\"amy\", \"robert\", \"eve\"], key=len))", "robert", "max() with key=len returns the longest word."),
            output("print(sorted([3, -5, 1], key=abs))", "[1, 3, -5]", "The absolute values are compared: 1, 3, 5."),
            output(
                "pairs = [(\"a\", 3), (\"b\", 1)]\nprint(sorted(pairs, key=lambda p: p[1]))",
                "[('b', 1), ('a', 3)]",
                "The lambda picks the second element of the pair as the sort key.",
            ),
            choice(
                "What will this code print?",
                listOf("Bob", "Amy", "20", "{'n': 'Bob', 'a': 20}"),
                0,
                "min() picks the dictionary with the smallest a, and then we print its name.",
                code = "people = [{\"n\": \"Amy\", \"a\": 30},\n          {\"n\": \"Bob\", \"a\": 20}]\nm = min(people, key=lambda p: p[\"a\"])\nprint(m[\"n\"])",
            ),
            choice(
                "What is the key parameter of sorted() for?",
                listOf(
                    "It gives a function to compare by",
                    "It sets how many elements to sort",
                    "It gives a dictionary key to remove",
                    "It reverses the order",
                ),
                0,
                "Elements are compared by the result of the key function.",
            ),
            fill(
                "Fill in the blank to sort starting from the longest word.",
                "s = [\"aa\", \"b\", \"ccc\"]\nprint(sorted(s, key=len, reverse=____))",
                listOf("True", "False", "None"),
                "True",
                "reverse=True reverses the order, so the longest word comes first.",
            ),
            tiles(
                "Sort the list words by the last letter",
                listOf("sorted(", "words,", "key=lambda s:", "s[-1]", ")"),
                listOf("s[0]", "key=s[-1]"),
                "s[-1] is the last letter of the word.",
            ),
        ),
        lesson(
            "u16l3", "map and filter",
            output("print(list(map(str, [1, 2, 3])))", "['1', '2', '3']", "map() calls str() for every element."),
            output("print(list(map(lambda x: x * 10, [1, 2])))", "[10, 20]", "The lambda is applied to every element."),
            output(
                "print(list(filter(lambda x: x > 2, [1, 5, 2, 7])))",
                "[5, 7]",
                "filter() keeps the elements for which the function returns True.",
            ),
            output(
                "numbers = list(map(int, \"3 4 5\".split()))\nprint(sum(numbers))",
                "12",
                "split() gives strings, and map(int, …) turns them into numbers.",
            ),
            choice(
                "Why do we write list(map(...))?",
                listOf(
                    "To turn the map object into a list",
                    "Without list(), map() won't work",
                    "list() sorts the results",
                    "list() removes duplicates",
                ),
                0,
                "map() and filter() return objects that only list() turns into a list.",
            ),
            choice(
                "Which list comprehension gives the same result as filter(lambda x: x > 0, l)?",
                listOf("[x for x in l if x > 0]", "[x > 0 for x in l]", "[x for x in l]", "[x if x > 0 for x in l]"),
                0,
                "Filtering in a list comprehension is an if at the end.",
            ),
            fill(
                "Fill in the blank to keep only the non-empty strings.",
                "s = [\"a\", \"\", \"b\"]\nprint(list(____(lambda x: x != \"\", s)))",
                listOf("filter", "map", "sorted"),
                "filter",
                "filter() keeps the elements that meet the condition.",
            ),
            output("print(list(map(len, [\"ab\", \"c\"])))", "[2, 1]", "map(len, …) gives the lengths of the strings in turn."),
        ),
        lesson(
            "u16l4", "Functions as values",
            output(
                "def square(x):\n    return x * x\n\nf = square\nprint(f(3))",
                "9",
                "A function can be assigned to a variable and called under the new name.",
            ),
            output(
                "def apply(f, x):\n    return f(x)\n\nprint(apply(abs, -7))",
                "7",
                "We pass the function abs as an argument, and apply calls it.",
            ),
            output(
                "def twice(f, x):\n    return f(f(x))\n\nprint(twice(lambda n: n + 3, 1))",
                "7",
                "The lambda is called twice: 1 → 4 → 7.",
            ),
            output(
                "def multiplier(n):\n    return lambda x: x * n\n\ntimes3 = multiplier(3)\nprint(times3(5))",
                "15",
                "multiplier(3) returns a new function that multiplies by 3.",
            ),
            choice(
                "What is the difference between f and f()?",
                listOf("f is the function itself, and f() calls it", "There is no difference", "f() is the function, and f is its result", "f only works for lambdas"),
                0,
                "Without parentheses we pass the function, with parentheses – its result.",
            ),
            choice(
                "What will this code print?",
                listOf("20", "9", "45", "Error"),
                0,
                "ops[\"*\"] is the multiplying lambda, so 4 * 5 = 20.",
                code = "ops = {\"+\": lambda a, b: a + b,\n       \"*\": lambda a, b: a * b}\nprint(ops[\"*\"](4, 5))",
            ),
            fill(
                "Fill in the blank to pass a function without calling it.",
                "def apply(f, x):\n    return f(x)\n\nprint(apply(____, \"abc\"))",
                listOf("len", "len()", "len(x)"),
                "len",
                "We pass just the function's name, without parentheses.",
            ),
            tiles(
                "Call apply with the function len and the string word, and store the result in result",
                listOf("result", "=", "apply(", "len,", "word)"),
                listOf("len(),", "len(word),"),
                "We pass the function without parentheses – apply will call it.",
            ),
        ),
        lesson(
            "u16l5", "Review: lambda and functions",
            output("f = lambda a, b=2: a * b\nprint(f(5))", "10", "A lambda can have default values too."),
            output("print(sorted([\"b\", \"A\", \"c\"], key=str.lower))", "['A', 'b', 'c']", "key=str.lower compares words regardless of letter case."),
            output(
                "s = [\"ab\", \"abc\", \"abcd\"]\nd = filter(lambda x: len(x) > 2, s)\nprint(list(d))",
                "['abc', 'abcd']",
                "The strings longer than 2 characters stay.",
            ),
            output("print(max([3, -9, 4], key=abs))", "-9", "-9 has the largest absolute value."),
            choice(
                "What does map(f, lst) return?",
                listOf("A map object", "A list", "A tuple", "The number of elements"),
                0,
                "map() returns an object that gives out results one by one – list() collects them into a list.",
            ),
            output(
                "def run(f):\n    return f(10)\n\nprint(run(lambda x: x // 3))",
                "3",
                "run calls the lambda it was given with the argument 10.",
            ),
            fill(
                "Fill in the blank to sort the pairs by the second element.",
                "p = [(1, \"b\"), (2, \"a\")]\nprint(sorted(p, key=lambda t: t[____]))",
                listOf("1", "0", "2"),
                "1",
                "t[1] is the second element of the tuple.",
            ),
            tiles(
                "Turn every element of the list numbers into a string",
                listOf("list(", "map(", "str,", "numbers", "))"),
                listOf("filter(", "int,"),
                "map(str, numbers) applies str() to every element.",
            ),
        ),
    ),
)
