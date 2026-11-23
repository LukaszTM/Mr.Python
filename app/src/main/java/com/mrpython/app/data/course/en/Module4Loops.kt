package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*
import com.mrpython.app.domain.CourseUnit

internal val module4 = CourseUnit(
    id = "u4",
    title = "Loops",
    description = "Repeat code without copying it",
    lessons = listOf(
        lesson(
            "u4l1", "The for loop",
            output(
                "for i in range(3):\n    print(i)",
                "0\n1\n2",
                "range(3) gives the numbers 0, 1, 2 – without the three!",
            ),
            choice(
                "Which numbers does range(1, 4) generate?",
                listOf("1, 2, 3", "1, 2, 3, 4", "0, 1, 2, 3", "4"),
                0,
                "The end of the range is not included.",
            ),
            tiles(
                "Arrange the header of a loop that goes through the numbers 0 to 4",
                listOf("for", "i", "in", "range(5)", ":"),
                listOf("while", "range(4)"),
                "for variable in sequence: – and don't forget the colon.",
            ),
            output(
                "for letter in \"abc\":\n    print(letter)",
                "a\nb\nc",
                "A for loop can also go through the characters of a string one by one.",
            ),
            output(
                "total = 0\nfor i in range(4):\n    total += i\nprint(total)",
                "6",
                "0 + 1 + 2 + 3 = 6.",
            ),
            output("for i in range(2, 5):\n    print(i)", "2\n3\n4", "range(2, 5) starts at 2 and ends before 5."),
            output(
                "for i in range(3):\n    print(\"Hey\")",
                "Hey\nHey\nHey",
                "The variable i doesn't have to be used – the loop simply repeats the block.",
            ),
        ),
        lesson(
            "u4l2", "while, break, and continue",
            output(
                "n = 3\nwhile n > 0:\n    print(n)\n    n -= 1",
                "3\n2\n1",
                "The loop runs as long as n > 0; each time we decrease n by 1.",
            ),
            choice(
                "What stops a loop immediately?",
                listOf("break", "continue", "stop", "exit loop"),
                0,
                "break ends the loop, while continue moves on to the next iteration.",
            ),
            output(
                "for i in range(5):\n    if i == 3:\n        break\n    print(i)",
                "0\n1\n2",
                "When i reaches 3, break ends the loop before anything is printed.",
            ),
            output(
                "for i in range(4):\n    if i % 2 == 0:\n        continue\n    print(i)",
                "1\n3",
                "continue skips the even numbers.",
            ),
            fill(
                "Complete the loop that runs as long as x is less than 10.",
                "x = 0\n____ x < 10:\n    x += 1",
                listOf("while", "for", "loop"),
                "while",
                "while repeats the block as long as the condition is true.",
            ),
            output(
                "x = 1\nwhile x < 20:\n    x *= 2\nprint(x)",
                "32",
                "1 → 2 → 4 → 8 → 16 → 32. At 32 the condition x < 20 is no longer true.",
            ),
            choice(
                "What is wrong with this loop?",
                listOf(
                    "It never ends – n doesn't change",
                    "It doesn't run even once",
                    "The colon is missing",
                    "Nothing, it's correct",
                ),
                0,
                "Without decreasing n, the condition n > 0 will always be true.",
                code = "n = 5\nwhile n > 0:\n    print(n)",
            ),
        ),
        lesson(
            "u4l3", "range() and counters",
            output("for i in range(0, 10, 3):\n    print(i)", "0\n3\n6\n9", "The third argument of range is the step."),
            output("for i in range(5, 0, -1):\n    print(i)", "5\n4\n3\n2\n1", "A negative step counts down."),
            choice(
                "Which numbers does range(1, 10, 2) give?",
                listOf("1, 3, 5, 7, 9", "1, 2, 3, …, 10", "2, 4, 6, 8", "1, 3, 5, 7, 9, 11"),
                0,
                "From 1 in steps of 2, and the end (10) is not included.",
            ),
            output(
                "counter = 0\nfor letter in \"panda\":\n    if letter == \"a\":\n        counter += 1\nprint(counter)",
                "2",
                "The loop counts the letters a in the word panda.",
            ),
            output("product = 1\nfor i in range(1, 5):\n    product *= i\nprint(product)", "24", "1 · 2 · 3 · 4 = 24."),
            fill(
                "Fill in the blank to print the even numbers from 0 to 8.",
                "for i in range(0, 10, ____):\n    print(i)",
                listOf("2", "1", "0"),
                "2",
                "A step of 2 jumps to every second number.",
            ),
            tiles(
                "Arrange the header of a loop that counts from 10 down to 1",
                listOf("for", "i", "in", "range(10, 0, -1)", ":"),
                listOf("range(10, 1)", "while"),
                "The end of the range (0) is not included, so the loop stops at 1.",
            ),
        ),
        lesson(
            "u4l4", "Loops inside loops",
            output(
                "for i in range(2):\n    for j in range(2):\n        print(i, j)",
                "0 0\n0 1\n1 0\n1 1",
                "The inner loop runs completely on every iteration of the outer one.",
            ),
            choice(
                "How many times is the star printed?",
                listOf("12", "7", "3", "4"),
                0,
                "3 iterations · 4 iterations = 12.",
                code = "for i in range(3):\n    for j in range(4):\n        print(\"*\")",
            ),
            output("for i in range(1, 4):\n    print(\"*\" * i)", "*\n**\n***", "The star is repeated as many times as the value of i."),
            output("while True:\n    print(\"once\")\n    break", "once", "while True runs forever – until a break."),
            output(
                "n = 0\nwhile True:\n    n += 1\n    if n == 4:\n        break\nprint(n)",
                "4",
                "The loop ends when n reaches 4.",
            ),
            output(
                "for i in range(3):\n    for j in range(3):\n        if j == 1:\n            break\n        print(i, j)",
                "0 0\n1 0\n2 0",
                "break stops only the inner loop.",
            ),
            fill(
                "Fill in the blank so the loop runs until it hits break.",
                "while ____:\n    answer = \"yes\"\n    if answer == \"yes\":\n        break",
                listOf("True", "False", "0"),
                "True",
                "while True is an \"endless\" loop that you leave with break.",
            ),
        ),
        lesson(
            "u4l5", "Review: loops",
            output("for i in range(1, 6):\n    if i % 2 == 0:\n        print(i)", "2\n4", "Only the even numbers are printed."),
            output("s = 0\ni = 1\nwhile i <= 3:\n    s += i\n    i += 1\nprint(s)", "6", "1 + 2 + 3 = 6."),
            choice(
                "Which loop prints the numbers 1, 2, 3?",
                listOf(
                    "for i in range(1, 4): print(i)",
                    "for i in range(3): print(i)",
                    "for i in range(1, 3): print(i)",
                    "for i in range(4): print(i)",
                ),
                0,
                "range(1, 4) gives 1, 2, 3.",
            ),
            output("word = \"cat\"\nfor c in word:\n    print(c * 2)", "cc\naa\ntt", "Each letter is repeated twice."),
            output(
                "for i in range(10):\n    if i == 2:\n        continue\n    if i == 4:\n        break\n    print(i)",
                "0\n1\n3",
                "2 is skipped (continue), and at 4 the loop ends (break).",
            ),
            tiles(
                "Arrange the loop header: as long as x is greater than zero",
                listOf("while", "x", ">", "0", ":"),
                listOf("for", "in"),
                "while condition: – with a colon at the end.",
            ),
            output(
                "n = 10\nsteps = 0\nwhile n > 1:\n    n //= 2\n    steps += 1\nprint(steps)",
                "3",
                "10 → 5 → 2 → 1: three divisions.",
            ),
            fill(
                "Fill in the blank to skip the number 3.",
                "for i in range(5):\n    if i == 3:\n        ____\n    print(i)",
                listOf("continue", "break", "stop"),
                "continue",
                "continue jumps to the next iteration of the loop.",
            ),
        ),
    ),
)
