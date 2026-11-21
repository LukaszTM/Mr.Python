package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*
import com.mrpython.app.domain.CourseUnit

internal val module23 = CourseUnit(
    id = "u23",
    title = "Iterators and generators",
    description = "iter, next, yield and lazy evaluation",
    lessons = listOf(
        lesson(
            "u23l1", "iter, next and StopIteration",
            output(
                "it = iter([10, 20, 30])\nprint(next(it))\nprint(next(it))",
                "10\n20",
                "Each next() returns the next item.",
            ),
            choice(
                "What does next(it) do?",
                listOf(
                    "Returns the next item of the iterator",
                    "Returns the first item of the list",
                    "Rewinds the iterator to the start",
                    "Returns the number of items",
                ),
                0,
                "An iterator remembers where it stopped and hands you the following item.",
            ),
            fill(
                "Fill in the blank to create an iterator from a list.",
                "it = ____([1, 2, 3])\nprint(next(it))",
                listOf("iter", "next", "list"),
                "iter",
                "iter() creates an iterator from a sequence.",
            ),
            output(
                "it = iter([1, 2, 3])\nnext(it)\nprint(list(it))",
                "[2, 3]",
                "The first item has already been taken – 2 and 3 are left.",
            ),
            output(
                "it = iter([1])\nnext(it)\ntry:\n    next(it)\nexcept StopIteration:\n    print(\"the end\")",
                "the end",
                "When the items run out, next() raises StopIteration.",
            ),
            choice(
                "Which exception does next() raise when the iterator runs out?",
                listOf("StopIteration", "IndexError", "EndError", "ValueError"),
                0,
                "StopIteration means there are no more items – a for loop handles it on its own.",
            ),
            output(
                "it = iter([1, 2, 3])\nprint(sum(it))\nprint(sum(it))",
                "6\n0",
                "You can go through an iterator only once – the second time it is empty.",
            ),
            tiles(
                "Get the next item from the iterator it into the variable x.",
                listOf("x", "=", "next(", "it", ")"),
                listOf("iter(", "it.next("),
                "next(it) returns the next item.",
            ),
        ),
        lesson(
            "u23l2", "Functions with yield",
            output(
                "def count():\n    yield 1\n    yield 2\n\nfor x in count():\n    print(x)",
                "1\n2",
                "A function with yield is a generator – it hands out values one by one.",
            ),
            output(
                "def gen():\n    yield \"a\"\n    yield \"b\"\n\ng = gen()\nprint(next(g))",
                "a",
                "next() runs the generator up to the first yield.",
            ),
            choice(
                "How is yield different from return?",
                listOf(
                    "yield hands out a value and pauses the function – it can be resumed later",
                    "yield ends the function for good",
                    "yield prints the value on the screen",
                    "There is no difference",
                ),
                0,
                "A generator remembers its state between one value and the next.",
            ),
            output(
                "def squares(n):\n    for i in range(n):\n        yield i * i\n\nprint(list(squares(4)))",
                "[0, 1, 4, 9]",
                "list() takes all the values from the generator.",
            ),
            fill(
                "Fill in the blank to make the function a generator.",
                "def countdown(n):\n    while n > 0:\n        ____ n\n        n -= 1\n\nprint(list(countdown(3)))",
                listOf("yield", "return", "print"),
                "yield",
                "yield turns a function into a generator.",
            ),
            output(
                "def gen():\n    print(\"start\")\n    yield 1\n\ng = gen()\nprint(\"created\")\nprint(next(g))",
                "created\nstart\n1",
                "The generator's code starts running only at the first next().",
            ),
            output(
                "def gen():\n    yield 1\n\nprint(type(gen()))",
                "<class 'generator'>",
                "Calling a function with yield returns a generator object.",
            ),
            tiles(
                "Turn all the values of the generator gen() into a list.",
                listOf("result", "=", "list(", "gen()", ")"),
                listOf("yield", "next("),
                "list() collects all the values of the generator.",
            ),
        ),
        lesson(
            "u23l3", "Generator expressions",
            output("print(sum(x * x for x in range(4)))", "14", "0 + 1 + 4 + 9 = 14."),
            output(
                "g = (x * 2 for x in [1, 2, 3])\nprint(next(g))\nprint(list(g))",
                "2\n[4, 6]",
                "An expression in round brackets creates a generator.",
            ),
            choice(
                "How is (x for x in a) different from [x for x in a]?",
                listOf(
                    "A generator doesn't build the whole list at once – it computes on demand",
                    "Round brackets create a tuple",
                    "There is no difference",
                    "A generator works only on numbers",
                ),
                0,
                "A generator saves memory because it doesn't store all the values.",
            ),
            output(
                "words = [\"cat\", \"giraffe\", \"dog\"]\nprint(max(len(w) for w in words))",
                "7",
                "The longest word, giraffe, has 7 letters.",
            ),
            fill(
                "Fill in the blank to add up only the even numbers.",
                "print(sum(x for x in range(7) ____ x % 2 == 0))",
                listOf("if", "and", "where"),
                "if",
                "The filtering condition goes after if – just like in a list comprehension.",
            ),
            output("print(any(x > 5 for x in [1, 7, 3]))", "True", "7 is greater than 5."),
            tiles(
                "Compute the sum of the squares of the numbers in the list a.",
                listOf("sum(", "x * x", "for x in a", ")"),
                listOf("yield", "x ** x"),
                "A generator expression can be passed straight to sum().",
            ),
            output(
                "g = (c.upper() for c in \"ab\")\nprint(\"\".join(g))",
                "AB",
                "join takes the letters from the generator one by one.",
            ),
        ),
        lesson(
            "u23l4", "Lazy and infinite generators",
            output(
                "def naturals():\n    n = 1\n    while True:\n        yield n\n        n += 1\n\nfor x in naturals():\n    if x > 3:\n        break\n    print(x)",
                "1\n2\n3",
                "The generator is infinite, but break ends the loop.",
            ),
            choice(
                "Why doesn't an infinite generator freeze the program right away?",
                listOf(
                    "Values are computed only when we ask for them",
                    "Python limits it to 100 values",
                    "while True doesn't work in a generator",
                    "The generator runs in the background",
                ),
                0,
                "Generators are lazy – they compute the next value only at next().",
            ),
            output(
                "def powers():\n    p = 1\n    while True:\n        yield p\n        p *= 2\n\ng = powers()\nprint([next(g) for _ in range(5)])",
                "[1, 2, 4, 8, 16]",
                "We take only the first 5 powers of two.",
            ),
            choice(
                "What happens after list(g) when g is an infinite generator?",
                listOf(
                    "The program never finishes (or runs out of memory)",
                    "A list of 10 items is created",
                    "An empty list is created",
                    "StopIteration is raised",
                ),
                0,
                "list() tries to take all the values, and they never end.",
            ),
            fill(
                "Complete the stop condition to print only 1, 2, 3.",
                "def counter():\n    n = 1\n    while True:\n        yield n\n        n += 1\n\nfor x in counter():\n    if x == 4:\n        ____\n    print(x)",
                listOf("break", "stop", "return"),
                "break",
                "break stops a loop over an infinite generator.",
            ),
            output(
                "def fib():\n    a, b = 0, 1\n    while True:\n        yield a\n        a, b = b, a + b\n\ng = fib()\nprint([next(g) for _ in range(6)])",
                "[0, 1, 1, 2, 3, 5]",
                "The generator computes the Fibonacci numbers on demand.",
            ),
            output(
                "def gen():\n    for i in range(3):\n        print(\"computing\", i)\n        yield i\n\nfor x in gen():\n    if x == 1:\n        break",
                "computing 0\ncomputing 1",
                "The value 2 was never computed – the generator is lazy.",
            ),
            tiles(
                "Write the header of a loop over the generator counter().",
                listOf("for", "x", "in", "counter():"),
                listOf("while", "yield"),
                "We iterate over a generator with an ordinary for loop.",
            ),
        ),
        lesson(
            "u23l5", "Review: generators",
            output("it = iter([4, 5, 6])\nnext(it)\nprint(next(it))", "5", "The second next() returns the second item."),
            output(
                "def evens(n):\n    for i in range(0, n, 2):\n        yield i\n\nprint(list(evens(7)))",
                "[0, 2, 4, 6]",
                "The generator hands out the even numbers smaller than 7.",
            ),
            choice(
                "Which keyword turns a function into a generator?",
                listOf("yield", "return", "next", "iter"),
                0,
                "A single yield in the function body is enough.",
            ),
            output("print(sum(len(s) for s in [\"ab\", \"cde\"]))", "5", "2 + 3 = 5."),
            fill(
                "Fill in the blank to get the first item from g.",
                "g = (x * 10 for x in range(3))\nprint(____(g))",
                listOf("next", "iter", "len"),
                "next",
                "next(g) returns the generator's next value – here 0.",
            ),
            output(
                "g = (x for x in [1, 2])\nprint(list(g))\nprint(list(g))",
                "[1, 2]\n[]",
                "A generator is used up after one pass.",
            ),
            choice(
                "When is a generator better than a list?",
                listOf(
                    "When there is a huge amount of data or it never ends",
                    "When we want to read the same data many times",
                    "When we need indexes, e.g. g[3]",
                    "Never",
                ),
                0,
                "A generator doesn't keep everything in memory at once.",
            ),
            tiles(
                "Create a generator of the squares of the numbers from 0 to 9.",
                listOf("g =", "(x * x", "for x in", "range(10))"),
                listOf("[x * x", "range(10)]"),
                "Round brackets create a generator, square brackets – a list.",
            ),
        ),
    ),
)
