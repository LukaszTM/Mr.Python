package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*
import com.mrpython.app.domain.CourseUnit

internal val module63 = CourseUnit(
    id = "u63",
    title = "Review week: functions",
    description = "Parameters, lambdas, recursion, closures and decorators",
    lessons = listOf(
        lesson(
            "u63l1", "Day 1: Function parameters",
            output(
                "def describe(name, age=18):\n    return f\"{name}:{age}\"\nprint(describe(\"Amy\"))\nprint(describe(\"Jack\", age=30))",
                "Amy:18\nJack:30",
                "When we don't pass an age, the default value 18 is used.",
            ),
            choice(
                "Which call of the function def f(a, b=2, c=3) is invalid?",
                listOf("f(a=1, 2)", "f(1, c=5)", "f(1, 2, 3)", "f(c=1, a=2)"),
                0,
                "A positional argument can't come after a keyword argument – that's a SyntaxError.",
            ),
            output(
                "def add(x, items=[]):\n    items.append(x)\n    return items\nadd(1)\nprint(add(2))",
                "[1, 2]",
                "The default list is created once and shared by all calls.",
            ),
            fill(
                "Fill in the blank so the parameter b can only be passed by name.",
                "def f(a, ____, b):\n    return a + b\nprint(f(1, b=2))",
                listOf("*", "**", "&"),
                "*",
                "Parameters after a bare star are keyword-only.",
            ),
            output(
                "def power(base, exponent=2):\n    return base ** exponent\nprint(power(exponent=3, base=2))",
                "8",
                "Keyword arguments can be passed in any order: 2 ** 3 = 8.",
            ),
            tiles(
                "Define a function greet with a parameter name whose default value is \"Guest\"",
                listOf("def", "greet(", "name=\"Guest\"", "):"),
                listOf("name==\"Guest\"", "return"),
                "A default value is written with a single = sign in the function header.",
            ),
            choice(
                "What does this program print?",
                listOf("[2]", "[1, 2]", "None", "Error"),
                0,
                "Each call without a list creates a new, empty list.",
                code = "def add(x, items=None):\n    if items is None:\n        items = []\n    items.append(x)\n    return items\nadd(1)\nprint(add(2))",
            ),
            output(
                "def info(name, *, price):\n    print(name, price)\ntry:\n    info(\"bread\", 5)\nexcept TypeError:\n    print(\"pass the price by name\")",
                "pass the price by name",
                "price comes after *, so it has to be passed as price=5.",
            ),
        ),
        lesson(
            "u63l2", "Day 2: Return values",
            output(
                "def min_max(numbers):\n    return min(numbers), max(numbers)\na, b = min_max([4, 1, 9])\nprint(a, b)",
                "1 9",
                "The function returns a tuple that we unpack right away into two variables.",
            ),
            output(
                "def show(x):\n    print(x * 2)\nresult = show(3)\nprint(result)",
                "6\nNone",
                "show() only prints and returns nothing – result is None.",
            ),
            choice(
                "What does a function with no return statement return?",
                listOf("None", "0", "An empty string", "False"),
                0,
                "Without return, a function returns None.",
            ),
            output(
                "def sign(n):\n    if n > 0:\n        return \"+\"\n    if n < 0:\n        return \"-\"\n    return \"0\"\nprint(sign(-3) + sign(0) + sign(7))",
                "-0+",
                "return ends the function immediately, so only the first matching condition is used.",
            ),
            fill(
                "Fill in the blank so the function returns the sum and the product.",
                "def compute(a, b):\n    ____ a + b, a * b\ns, p = compute(2, 5)\nprint(s, p)",
                listOf("return", "print", "yield"),
                "return",
                "return a + b, a * b returns a tuple of two values.",
            ),
            output(
                "def first_even(numbers):\n    for n in numbers:\n        if n % 2 == 0:\n            return n\nprint(first_even([3, 5, 8, 10]))\nprint(first_even([1, 3]))",
                "8\nNone",
                "return breaks out of the loop; when nothing is found, the function returns None.",
            ),
            choice(
                "What does this program print?",
                listOf("1", "done, then 1", "Nothing", "Error"),
                0,
                "Code after return never runs.",
                code = "def f():\n    return 1\n    print(\"done\")\nprint(f())",
            ),
            tiles(
                "Store in the variable result a list of the squares of the numbers in the list data",
                listOf("result", "=", "[x ** 2", "for x", "in data]"),
                listOf("print(", "(x ** 2"),
                "A list comprehension in square brackets creates a new list.",
            ),
        ),
        lesson(
            "u63l3", "Day 3: *args and **kwargs",
            output(
                "def total(*numbers):\n    return sum(numbers)\nprint(total(1, 2, 3))\nprint(total())",
                "6\n0",
                "*numbers collects all the positional arguments – even zero arguments.",
            ),
            choice(
                "What type is args inside the function def f(*args)?",
                listOf("tuple", "list", "dict", "set"),
                0,
                "*args collects the positional arguments into a tuple.",
            ),
            output(
                "def profile(**data):\n    for k, v in data.items():\n        print(f\"{k}={v}\")\nprofile(name=\"Amy\", age=20)",
                "name=Amy\nage=20",
                "**data collects the keyword arguments into a dictionary.",
            ),
            output(
                "def three(a, b, c):\n    return a * 100 + b * 10 + c\nnumbers = [1, 2, 3]\nprint(three(*numbers))",
                "123",
                "*numbers unpacks the list into three separate arguments.",
            ),
            fill(
                "Fill in the blank to pass the values from the dictionary as keyword arguments.",
                "def address(city, street):\n    return f\"{street}, {city}\"\nd = {\"city\": \"Boston\", \"street\": \"Main St\"}\nprint(address(____d))",
                listOf("**", "*", "&"),
                "**",
                "**d turns the key–value pairs into keyword arguments; *d would give just the keys.",
            ),
            choice(
                "Which parameter order is correct?",
                listOf("def f(a, *args, b=1, **kwargs)", "def f(**kwargs, *args, a)", "def f(*args, **kwargs, a)", "def f(a, **kwargs, *args)"),
                0,
                "**kwargs must be last, and *args comes before keyword-only parameters.",
            ),
            output(
                "def f(a, *args, **kwargs):\n    print(a, args, kwargs)\nf(1, 2, 3, x=4)",
                "1 (2, 3) {'x': 4}",
                "The first argument goes to a, the other positional ones to args, and keyword ones to kwargs.",
            ),
            tiles(
                "Define a function log that accepts any positional and keyword arguments",
                listOf("def", "log(", "*args,", "**kwargs", "):"),
                listOf("**args", "&kwargs"),
                "First *args, then **kwargs.",
            ),
        ),
        lesson(
            "u63l4", "Day 4: Lambda",
            choice(
                "Which lambda works the same as def f(x, y): return x * y?",
                listOf("lambda x, y: x * y", "lambda (x, y): x * y", "lambda x, y: return x * y", "lambda: x * y"),
                0,
                "In a lambda we don't write return or parentheses around the parameters.",
            ),
            output(
                "people = [(\"Amy\", 25), (\"Jack\", 19), (\"Eve\", 31)]\npeople.sort(key=lambda p: p[1])\nprint(people[0][0])",
                "Jack",
                "We sort by age, so the youngest, Jack, comes first.",
            ),
            output(
                "numbers = [1, 2, 3, 4, 5, 6]\nevens = filter(lambda x: x % 2 == 0, numbers)\nprint(list(map(lambda x: x * 10, evens)))",
                "[20, 40, 60]",
                "filter keeps the even numbers, and map multiplies them by 10.",
            ),
            choice(
                "What can't you put in a lambda?",
                listOf("Several statements in the body", "Several parameters", "Default parameter values", "A conditional expression x if c else y"),
                0,
                "The body of a lambda is a single expression.",
            ),
            fill(
                "Fill in the blank to find the longest word.",
                "words = [\"cat\", \"giraffe\", \"dog\"]\nprint(max(words, ____=lambda s: len(s)))",
                listOf("key", "by", "len"),
                "key",
                "The key parameter says what to compare the elements by.",
            ),
            output(
                "grade = lambda p: \"pass\" if p >= 50 else \"fail\"\nprint(grade(70), grade(30))",
                "pass fail",
                "You can use a conditional expression in a lambda.",
            ),
            output(
                "words = [\"bb\", \"a\", \"ccc\", \"dd\"]\nprint(sorted(words, key=lambda s: (-len(s), s)))",
                "['ccc', 'bb', 'dd', 'a']",
                "First by length in descending order (the minus), and alphabetically on a tie.",
            ),
            tiles(
                "Sort the list of words by their last letter",
                listOf("words.sort(", "key=lambda s:", "s[-1]", ")"),
                listOf("s[0]", "reverse="),
                "s[-1] is the last character of the word.",
            ),
        ),
        lesson(
            "u63l5", "Day 5: Recursion",
            output(
                "def factorial(n):\n    if n <= 1:\n        return 1\n    return n * factorial(n - 1)\nprint(factorial(5))",
                "120",
                "5 * 4 * 3 * 2 * 1 = 120.",
            ),
            output(
                "def digit_sum(n):\n    if n < 10:\n        return n\n    return n % 10 + digit_sum(n // 10)\nprint(digit_sum(4096))",
                "19",
                "4 + 0 + 9 + 6 = 19.",
            ),
            choice(
                "What is this function missing?",
                listOf("A base case", "A return statement at the end", "A default parameter", "Nothing – it works correctly"),
                0,
                "Without a base case the function calls itself forever (RecursionError).",
                code = "def countdown(n):\n    print(n)\n    countdown(n - 1)",
            ),
            output(
                "def reverse(s):\n    if s == \"\":\n        return \"\"\n    return reverse(s[1:]) + s[0]\nprint(reverse(\"abc\"))",
                "cba",
                "The first letter goes to the end of the reversed rest.",
            ),
            fill(
                "Fill in the stopping condition so fib(7) gives 13.",
                "def fib(n):\n    if n < ____:\n        return n\n    return fib(n - 1) + fib(n - 2)\nprint(fib(7))",
                listOf("2", "0", "1"),
                "2",
                "fib(0) = 0 and fib(1) = 1 are the base cases, which means n < 2.",
            ),
            output(
                "def flatten(x):\n    if not isinstance(x, list):\n        return [x]\n    result = []\n    for e in x:\n        result += flatten(e)\n    return result\nprint(flatten([1, [2, [3, 4]], 5]))",
                "[1, 2, 3, 4, 5]",
                "Each sublist is flattened recursively.",
            ),
            output(
                "def f(n):\n    if n == 0:\n        return\n    f(n - 1)\n    print(n)\nf(3)",
                "1\n2\n3",
                "print runs only after returning from the deeper calls.",
            ),
            tiles(
                "Build the recursive step: result is a times power(a, n - 1)",
                listOf("result", "=", "a *", "power(a,", "n - 1)"),
                listOf("n + 1)", "print("),
                "a to the n is a times a to the (n - 1).",
            ),
        ),
        lesson(
            "u63l6", "Day 6: Closures and scope",
            output(
                "def multiplier(k):\n    def f(x):\n        return x * k\n    return f\ntimes3 = multiplier(3)\nprint(times3(5))",
                "15",
                "The inner function remembers k from the function that created it.",
            ),
            output(
                "def counter():\n    n = 0\n    def step():\n        nonlocal n\n        n += 1\n        return n\n    return step\nc = counter()\nc(); c()\nprint(c())",
                "3",
                "nonlocal lets you change n from the enclosing function.",
            ),
            choice(
                "What happens when you run this?",
                listOf("UnboundLocalError", "It returns 1", "It returns 0", "Nothing – n is skipped"),
                0,
                "The assignment n += 1 makes n a local variable, and it has no value yet.",
                code = "def counter():\n    n = 0\n    def step():\n        n += 1\n        return n\n    return step\ncounter()()",
            ),
            output(
                "def counter():\n    n = 0\n    def step():\n        nonlocal n\n        n += 1\n        return n\n    return step\na, b = counter(), counter()\na(); a()\nprint(a(), b())",
                "3 1",
                "Each call to counter() creates a separate closure with its own n.",
            ),
            fill(
                "Fill in the blank so the function changes the module-level variable x (the program should print 20).",
                "x = 10\ndef change():\n    ____ x\n    x = 20\nchange()\nprint(x)",
                listOf("global", "nonlocal", "local"),
                "global",
                "global refers to a module-level variable.",
            ),
            output(
                "funcs = [lambda: i for i in range(3)]\nprint([f() for f in funcs])",
                "[2, 2, 2]",
                "The lambdas read i only when called, when i already equals 2.",
            ),
            output(
                "funcs = [lambda i=i: i * 10 for i in range(3)]\nprint([f() for f in funcs])",
                "[0, 10, 20]",
                "The default value i=i remembers i at the moment the lambda is created.",
            ),
            choice(
                "Where does Python look for a name first (the LEGB rule)?",
                listOf("In the local scope", "In the global scope", "Among the built-in names", "In the enclosing function"),
                0,
                "The order is: Local, Enclosing, Global, Built-in.",
            ),
        ),
        lesson(
            "u63l7", "Day 7: Decorators",
            output(
                "def loud(f):\n    def w(*args):\n        return f(*args).upper()\n    return w\n@loud\ndef greet(name):\n    return \"hello \" + name\nprint(greet(\"amy\"))",
                "HELLO AMY",
                "The decorator turns the function's result into uppercase.",
            ),
            output(
                "def log(f):\n    def w():\n        print(\"before\")\n        f()\n        print(\"after\")\n    return w\n@log\ndef work():\n    print(\"working\")\nwork()",
                "before\nworking\nafter",
                "The wrapper function runs code before and after the original function.",
            ),
            choice(
                "What is writing @decor above def f equivalent to?",
                listOf("f = decor(f)", "f = f(decor)", "decor = f(decor)", "f = decor()"),
                0,
                "@decor is shorthand for the assignment f = decor(f).",
            ),
            output(
                "def add_a(f):\n    return lambda: f() + \"a\"\ndef add_b(f):\n    return lambda: f() + \"b\"\n@add_a\n@add_b\ndef text():\n    return \"x\"\nprint(text())",
                "xba",
                "The decorator closest to def (add_b) runs first, then add_a.",
            ),
            fill(
                "Fill in the blank so the decorated function keeps its name (the program should print compute).",
                "import functools\ndef decor(f):\n    @functools.____(f)\n    def w(*a):\n        return f(*a)\n    return w\n@decor\ndef compute():\n    pass\nprint(compute.__name__)",
                listOf("wraps", "cache", "partial"),
                "wraps",
                "functools.wraps copies the name and description of the original function.",
            ),
            output(
                "def repeat(n):\n    def decor(f):\n        def w():\n            for _ in range(n):\n                f()\n        return w\n    return decor\n@repeat(2)\ndef hey():\n    print(\"hey\")\nhey()",
                "hey\nhey",
                "repeat(2) returns a decorator that calls the function 2 times.",
            ),
            output(
                "def count(f):\n    def w(*a):\n        w.calls += 1\n        return f(*a)\n    w.calls = 0\n    return w\n@count\ndef sq(x):\n    return x * x\nsq(2); sq(3)\nprint(sq.calls)",
                "2",
                "The wrapper function counts its calls in the calls attribute.",
            ),
            tiles(
                "Wrap the function start with the decorator measure without using @",
                listOf("start", "=", "measure(", "start", ")"),
                listOf("start()", "@measure"),
                "@measure is the same as start = measure(start).",
            ),
        ),
    ),
)
