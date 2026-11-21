package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*
import com.mrpython.app.domain.CourseUnit

internal val module43 = CourseUnit(
    id = "u43",
    title = "Scope and closures",
    description = "The LEGB rule, global, nonlocal, and closures",
    lessons = listOf(
        lesson(
            "u43l1", "The LEGB rule",
            output(
                "x = \"global\"\ndef f():\n    x = \"local\"\n    print(x)\nf()\nprint(x)",
                "local\nglobal",
                "A local variable shadows the global one only inside the function.",
            ),
            output(
                "x = 5\ndef f():\n    print(x)\nf()",
                "5",
                "There's no local x, so Python looks in the global scope.",
            ),
            choice(
                "What does LEGB stand for?",
                listOf("Local, Enclosing, Global, Built-in", "List, Enum, Generator, Bool", "Local, External, General, Base", "Loop, Else, Global, Break"),
                0,
                "This is the order in which Python looks up names.",
            ),
            output(
                "x = 1\ndef outer():\n    x = 2\n    def inner():\n        print(x)\n    inner()\nouter()",
                "2",
                "inner finds x in the enclosing function (Enclosing) before it gets to the global one.",
            ),
            output(
                "def f():\n    print(len(\"abc\"))\nf()",
                "3",
                "len comes from the built-in scope (Built-in).",
            ),
            choice(
                "What happens when you run this code?",
                listOf("UnboundLocalError", "It prints 1", "It prints 2", "It prints None"),
                0,
                "The assignment in the function makes x local, and print tries to read it before the assignment.",
                code = "x = 1\ndef f():\n    print(x)\n    x = 2\nf()",
            ),
            output(
                "def f():\n    y = 10\nf()\ntry:\n    print(y)\nexcept NameError:\n    print(\"no y\")",
                "no y",
                "Local variables disappear when the function finishes.",
            ),
        ),
        lesson(
            "u43l2", "global and nonlocal",
            output(
                "counter = 0\ndef add():\n    global counter\n    counter += 1\nadd()\nadd()\nprint(counter)",
                "2",
                "global lets you change a global variable inside a function.",
            ),
            choice(
                "What happens without the line global counter?",
                listOf("UnboundLocalError", "It prints 2", "It prints 0", "NameError at the definition"),
                0,
                "counter += 1 treats counter as local, and it doesn't have a value yet.",
                code = "counter = 0\ndef add():\n    counter += 1\nadd()",
            ),
            output(
                "def outer():\n    n = 0\n    def inner():\n        nonlocal n\n        n += 5\n    inner()\n    print(n)\nouter()",
                "5",
                "nonlocal lets you change a variable of the enclosing function.",
            ),
            output(
                "def outer():\n    n = 0\n    def inner():\n        n = 5\n    inner()\n    print(n)\nouter()",
                "0",
                "Without nonlocal, a new local variable n is created in inner.",
            ),
            fill(
                "Fill in the blank so the function inner changes the variable s from the function outer.",
                "def outer():\n    s = \"a\"\n    def inner():\n        ____ s\n        s += \"b\"\n    inner()\n    print(s)\nouter()",
                listOf("nonlocal", "global", "local", "def"),
                "nonlocal",
                "s belongs to the enclosing function, so we use nonlocal.",
            ),
            choice(
                "What's the difference between global and nonlocal?",
                listOf("global – module scope, nonlocal – the nearest enclosing function", "Nothing", "nonlocal works only in classes", "global creates a new local variable"),
                0,
                "nonlocal reaches into the outer function, global to the file level.",
            ),
            tiles(
                "Declare that result is a global variable",
                listOf("global", "result"),
                listOf("nonlocal", "def"),
                "The global declaration must come before the variable is used.",
            ),
        ),
        lesson(
            "u43l3", "Closures",
            output(
                "def multiplier(n):\n    def f(x):\n        return x * n\n    return f\ntimes3 = multiplier(3)\nprint(times3(5))",
                "15",
                "The function f remembers n from the moment it was created – that's a closure.",
            ),
            output(
                "def counter():\n    n = 0\n    def next_one():\n        nonlocal n\n        n += 1\n        return n\n    return next_one\nc = counter()\nc()\nprint(c(), c())",
                "2 3",
                "Every call increases the remembered n.",
            ),
            output(
                "def counter():\n    n = 0\n    def next_one():\n        nonlocal n\n        n += 1\n        return n\n    return next_one\na = counter()\nb = counter()\na()\na()\nprint(b())",
                "1",
                "Every call to counter() creates a separate n.",
            ),
            choice(
                "What is a closure?",
                listOf("A function that remembers variables from the scope where it was created", "A function with no arguments", "A closed file", "A class with no methods"),
                0,
                "A closure keeps the enclosing function's variables even after that function has finished.",
            ),
            fill(
                "Fill in the blank so add5(10) returns 15.",
                "def adder(n):\n    def f(x):\n        return x + n\n    return ____\nadd5 = adder(5)\nprint(add5(10))",
                listOf("f", "f(x)", "n", "x + n"),
                "f",
                "The factory returns the inner function, not its result.",
            ),
            output(
                "def greeting(word):\n    def f(name):\n        return word + \", \" + name\n    return f\nhi = greeting(\"Hi\")\nprint(hi(\"Amy\"))",
                "Hi, Amy",
                "hi remembers the word \"Hi\".",
            ),
            tiles(
                "Create the function times2 from the factory multiplier",
                listOf("times2", "=", "multiplier(", "2", ")"),
                listOf("multiplier", "()"),
                "Calling the factory returns a new function.",
            ),
        ),
        lesson(
            "u43l4", "Review and the loop trap",
            output(
                "functions = []\nfor i in range(3):\n    functions.append(lambda: i)\nprint([f() for f in functions])",
                "[2, 2, 2]",
                "The lambdas remember the variable i, not its value – after the loop i is 2.",
            ),
            output(
                "functions = []\nfor i in range(3):\n    functions.append(lambda i=i: i)\nprint([f() for f in functions])",
                "[0, 1, 2]",
                "The default argument stores the current value of i when the lambda is created.",
            ),
            choice(
                "How do you fix the lambda: i trap in a loop?",
                listOf("Use a default argument: lambda i=i: i", "Add global i", "Use while instead of for", "You can't"),
                0,
                "The default value is computed once, when the function is created.",
            ),
            output(
                "x = \"G\"\ndef a():\n    x = \"E\"\n    def b():\n        return x\n    return b()\nprint(a(), x)",
                "E G",
                "b sees x from the enclosing function; the global x doesn't change.",
            ),
            output(
                "total = 0\ndef add(n):\n    global total\n    total += n\nfor k in [1, 2, 3]:\n    add(k)\nprint(total)",
                "6",
                "global lets you add things up in a module variable.",
            ),
            fill(
                "Fill in the blank so each function returns its own number: [0, 1, 2].",
                "fs = [lambda ____: k for k in range(3)]\nprint([f() for f in fs])",
                listOf("k=k", "k", "k=0", "x=k"),
                "k=k",
                "k=k stores the current value of k in each lambda.",
            ),
            choice(
                "Where does Python first look for a name used in a function?",
                listOf("In the function's local scope", "In the built-in modules", "In the global scope", "In the most recently imported module"),
                0,
                "The L in LEGB is Local – the search starts locally.",
            ),
        ),
    ),
)
