package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

import com.mrpython.app.domain.CourseUnit

internal val module58 = CourseUnit(
    id = "u58",
    title = "Challenges: easy",
    description = "Short puzzles on Python basics",
    lessons = listOf(
        lesson(
            "u58l1", "Challenge 1: strings",
            output(
                "s = \"abracadabra\"\nprint(s.count(\"abra\"))",
                "2",
                "“abra” appears at the beginning and at the end of the string.",
            ),
            output(
                "print(\"ha\" * 2 + \"!\" * 3)",
                "haha!!!",
                "Multiplying a string repeats it, and + joins the results.",
            ),
            output(
                "s = \"Python\"\nprint(s[1:-1])",
                "ytho",
                "The slice [1:-1] skips the first and the last character.",
            ),
            output(
                "print(\"cat\"[::-1].upper())",
                "TAC",
                "First we reverse the string, then we convert it to uppercase.",
            ),
            choice(
                "What does this code print?",
                listOf("1", "0", "2", "Error"),
                0,
                "An empty string has length 0, and a string with one space has length 1.",
                code = "print(len(\"\") + len(\" \"))",
            ),
            fill(
                "Fill in the blank to print “amy”.",
                "print(\"Amy\".____())",
                listOf("lower", "upper", "title"),
                "lower",
                "lower() converts all letters to lowercase.",
            ),
            tiles(
                "Print the string text backwards",
                listOf("print(", "text[::-1]", ")"),
                listOf("text[-1]", "reverse("),
                "The slice [::-1] reverses a string.",
            ),
            choice(
                "What does this code print?",
                listOf("['a', 'b-c']", "['a', 'b', 'c']", "['a-b', 'c']", "['a', '-b-c']"),
                0,
                "The second argument of split() limits the number of splits to one.",
                code = "print(\"a-b-c\".split(\"-\", 1))",
            ),
        ),
        lesson(
            "u58l2", "Challenge 2: numbers",
            output(
                "print(7 // 2, 7 % 2)",
                "3 1",
                "// is floor division, and % is the remainder.",
            ),
            choice(
                "What does this code print?",
                listOf("-4", "-3", "-3.5", "-4.0"),
                0,
                "// always rounds down, so -3.5 becomes -4.",
                code = "print(-7 // 2)",
            ),
            output(
                "print(2 ** 3 ** 2)",
                "512",
                "Exponentiation is evaluated from the right: 3 ** 2 = 9, and 2 ** 9 = 512.",
            ),
            output(
                "print(10 / 5)",
                "2.0",
                "The / operator always gives a floating-point number.",
            ),
            choice(
                "What does this code print?",
                listOf("2", "3", "2.5", "2.0"),
                0,
                "round() rounds halves to the nearest even number.",
                code = "print(round(2.5))",
            ),
            fill(
                "Fill in the blank to check whether n is even (it should print True).",
                "n = 10\nprint(n ____ 2 == 0)",
                listOf("%", "//", "/"),
                "%",
                "A number is even when the remainder of dividing it by 2 is 0.",
            ),
            output(
                "x = 5\nx += x * 2\nprint(x)",
                "15",
                "First we compute x * 2 = 10, then x = 5 + 10.",
            ),
            tiles(
                "Print the remainder of dividing 17 by 5",
                listOf("print(", "17", "%", "5", ")"),
                listOf("//", "/"),
                "The % operator gives the remainder.",
            ),
        ),
        lesson(
            "u58l3", "Challenge 3: lists",
            output(
                "a = [1, 2, 3]\na.append([4])\nprint(len(a))",
                "4",
                "append() adds the whole list [4] as a single element.",
            ),
            output(
                "a = [1, 2, 3]\na.extend(\"ab\")\nprint(a)",
                "[1, 2, 3, 'a', 'b']",
                "extend() adds each character of the string one by one.",
            ),
            choice(
                "What does this code print?",
                listOf("None", "[1, 2, 3]", "[3, 1, 2]", "Error"),
                0,
                "sort() sorts the list in place and returns None.",
                code = "a = [3, 1, 2]\nprint(a.sort())",
            ),
            output(
                "a = [1, 2, 3, 4, 5]\nprint(a[::-2])",
                "[5, 3, 1]",
                "A step of -2 goes from the end, taking every second element.",
            ),
            choice(
                "What does this code print?",
                listOf("[0, 5, 0]", "[5, 5, 5]", "[0, 0, 0]", "[5, 0, 0]"),
                0,
                "Numbers are immutable, so changing a[1] affects only that one spot.",
                code = "a = [0] * 3\na[1] = 5\nprint(a)",
            ),
            fill(
                "Fill in the blank to remove and print the last element (3).",
                "a = [1, 2, 3]\nx = a.____()\nprint(x)",
                listOf("pop", "remove", "clear"),
                "pop",
                "pop() without an argument removes and returns the last element.",
            ),
            output(
                "a = [1, 2, 3]\nb = a\nb.append(4)\nprint(len(a))",
                "4",
                "a and b are the same list, so a change made through b shows up in a too.",
            ),
            tiles(
                "Sort the list numbers in descending order (in place)",
                listOf("numbers.sort(", "reverse=True", ")"),
                listOf("reverse=False", "sorted("),
                "sort(reverse=True) sorts the list starting from the largest element.",
            ),
        ),
        lesson(
            "u58l4", "Challenge 4: loops",
            output(
                "print(list(range(10, 0, -3)))",
                "[10, 7, 4, 1]",
                "range with a negative step counts down and never reaches 0.",
            ),
            output(
                "s = 0\nfor i in range(5):\n    if i == 3:\n        break\n    s += i\nprint(s)",
                "3",
                "The loop adds 0, 1 and 2, and stops at 3.",
            ),
            output(
                "s = 0\nfor i in range(5):\n    if i % 2:\n        continue\n    s += i\nprint(s)",
                "6",
                "continue skips the odd numbers, so we add up 0, 2 and 4.",
            ),
            output(
                "for i in range(3):\n    if i == 5:\n        break\nelse:\n    print(\"nothing\")",
                "nothing",
                "A loop's else block runs when the loop wasn't stopped by break.",
            ),
            choice(
                "What does this code print?",
                listOf("12", "9", "10", "3"),
                0,
                "At 9 the condition is still true, so i grows to 12.",
                code = "i = 0\nwhile i < 10:\n    i += 3\nprint(i)",
            ),
            choice(
                "How many times does the body of this loop run?",
                listOf("5", "4", "6", "10"),
                0,
                "range(2, 11, 2) gives 2, 4, 6, 8 and 10.",
                code = "for i in range(2, 11, 2):\n    print(i)",
            ),
            fill(
                "Fill in the blank to print the numbers from 1 to 5.",
                "for i in range(____):\n    print(i)",
                listOf("1, 6", "1, 5", "6"),
                "1, 6",
                "The end of a range isn't included, so we need 6.",
            ),
            tiles(
                "Write the header of a loop that goes through the characters of the string “abc”",
                listOf("for", "c", "in", "\"abc\":"),
                listOf("range(", "while"),
                "A for loop can iterate directly over the characters of a string.",
            ),
        ),
        lesson(
            "u58l5", "Challenge 5: conditions",
            output(
                "x = 0\nif x:\n    print(\"A\")\nelse:\n    print(\"B\")",
                "B",
                "0 is falsy, so the else branch runs.",
            ),
            output(
                "print(bool(\"False\"))",
                "True",
                "Every non-empty string is truthy – even “False”.",
            ),
            output(
                "print(bool([]) or \"empty\")",
                "empty",
                "An empty list gives False, so or returns the second value.",
            ),
            choice(
                "What does this code print?",
                listOf("5", "True", "False", "0"),
                0,
                "not 0 is True, and True and 5 returns 5.",
                code = "print(not 0 and 5)",
            ),
            output(
                "x = 15\nif x > 10:\n    print(\"a\")\nelif x > 5:\n    print(\"b\")",
                "a",
                "Only the first true branch runs.",
            ),
            choice(
                "In which option are all the values falsy?",
                listOf("0, \"\", [], None", "0, \"0\", []", "\" \", [0], None", "False, \"False\""),
                0,
                "Falsy values include zero, an empty string, an empty list and None.",
            ),
            fill(
                "Fill in the blank to print “adult” for age 18.",
                "age = 18\nif age ____ 18:\n    print(\"adult\")\nelse:\n    print(\"child\")",
                listOf(">=", ">", "<"),
                ">=",
                "18 >= 18 is true, but 18 > 18 is not.",
            ),
            tiles(
                "Store “even” or “odd” in a variable in a single line",
                listOf("result =", "\"even\"", "if", "n % 2 == 0", "else", "\"odd\""),
                listOf("elif", "then"),
                "A conditional expression has the form: A if condition else B.",
            ),
        ),
        lesson(
            "u58l6", "Challenge 6: functions",
            choice(
                "What does this code print?",
                listOf("3", "6", "None", "Error"),
                0,
                "Assigning to x inside the function doesn't change the variable a.",
                code = "def f(x):\n    x = x * 2\n\na = 3\nf(a)\nprint(a)",
            ),
            output(
                "def f():\n    print(\"hi\")\n\nprint(f())",
                "hi\nNone",
                "The function prints “hi”, and without return it returns None.",
            ),
            output(
                "def f(a, b=2):\n    return a * b\n\nprint(f(3), f(3, 3))",
                "6 9",
                "When we don't pass b, it has the default value 2.",
            ),
            output(
                "def f(n):\n    if n > 0:\n        return \"plus\"\n    return \"no\"\n\nprint(f(0))",
                "no",
                "0 is not greater than 0, so the second return runs.",
            ),
            choice(
                "What does this code print?",
                listOf("1", "2", "1 and 2", "None"),
                0,
                "The first return ends the function – the code after it never runs.",
                code = "def f():\n    return 1\n    return 2\n\nprint(f())",
            ),
            fill(
                "Fill in the blank so the function returns the sum (it should print 5).",
                "def add(a, b):\n    ____ a + b\n\nprint(add(2, 3))",
                listOf("return", "print", "yield"),
                "return",
                "A function hands back its result with the return statement.",
            ),
            output(
                "def add_one(items):\n    items.append(1)\n\nx = []\nadd_one(x)\nadd_one(x)\nprint(x)",
                "[1, 1]",
                "The function gets the very same list, so append changes x.",
            ),
            tiles(
                "Define, in one line, a function square that returns x squared",
                listOf("def", "square(x):", "return", "x ** 2"),
                listOf("print", "x ** x"),
                "A short function can be written on one line after the colon.",
            ),
        ),
        lesson(
            "u58l7", "Challenge 7: a bit of everything",
            output(
                "print(len(str(2 ** 10)))",
                "4",
                "2 ** 10 = 1024, and that string has 4 characters.",
            ),
            output(
                "print(sum(range(1, 11)))",
                "55",
                "The sum of the numbers from 1 to 10 is 55.",
            ),
            choice(
                "What does this code print?",
                listOf("n", "a", "b", "banana"),
                0,
                "max() on a string returns the character that comes last in the alphabet.",
                code = "print(max(\"banana\"))",
            ),
            output(
                "print(\"-\".join(\"abc\"))",
                "a-b-c",
                "join() treats a string as a sequence of characters.",
            ),
            output(
                "print(int(\"7\") + int(3.9))",
                "10",
                "int() cuts off the fractional part: int(3.9) is 3.",
            ),
            choice(
                "What type is the result?",
                listOf("float", "int", "str", "bool"),
                0,
                "Division with / always gives a float, even 3 / 1.",
                code = "x = 3 / 1\nprint(type(x).__name__)",
            ),
            fill(
                "Fill in the blank to print the number of words (3).",
                "sentence = \"Python is fun\"\nprint(len(sentence.____()))",
                listOf("split", "strip", "upper"),
                "split",
                "split() breaks the sentence into a list of words.",
            ),
            tiles(
                "Print the smallest element of the list numbers",
                listOf("print(", "min(numbers)", ")"),
                listOf("max(numbers)", "len("),
                "min() returns the smallest element.",
            ),
        ),
    ),
)
