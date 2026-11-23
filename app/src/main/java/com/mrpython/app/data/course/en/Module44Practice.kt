package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

internal val module44Practice = listOf(
    practice(
        "u44l1",
        output(
            "price: float = 9.5\nquantity: int = 2\nprint(price * quantity)",
            "19.0",
            "Type hints don't change calculations – it's ordinary multiplication.",
        ),
        output(
            "def greet(name: str) -> str:\n    return \"Hi, \" + name\nprint(greet(\"Kate\"))",
            "Hi, Kate",
            "name: str describes the parameter, and -> str the result.",
        ),
        output(
            "def is_adult(age: int) -> bool:\n    return age >= 18\nprint(is_adult(17), is_adult(20))",
            "False True",
            "A function with the hint -> bool returns a boolean.",
        ),
        output(
            "points: dict[str, int] = {\"Amy\": 3, \"John\": 5}\nprint(max(points.values()))",
            "5",
            "dict[str, int] is a dictionary with string keys and integer values.",
        ),
        output(
            "pair: tuple[str, int] = (\"x\", 7)\nprint(pair[1] + 1)",
            "8",
            "tuple[str, int] describes a tuple: a string and an integer.",
        ),
        output(
            "def lengths(words: list[str]) -> list[int]:\n    return [len(s) for s in words]\nprint(lengths([\"ab\", \"cat\"]))",
            "[2, 3]",
            "The function takes a list of strings and returns a list of integers.",
        ),
        output(
            "tags: set[int] = {3, 1, 2}\nprint(sorted(tags))",
            "[1, 2, 3]",
            "set[int] is a set of integers.",
        ),
        output(
            "def info() -> None:\n    print(\"no result\")\nx = info()\nprint(x)",
            "no result\nNone",
            "-> None means the function returns nothing.",
        ),
        choice(
            "Which hint fits (1.5, 2.5)?",
            listOf("tuple[float, float]", "list[float]", "tuple[int, int]", "dict[float]"),
            0,
            "It's a tuple of two floating-point numbers.",
        ),
        choice(
            "What does the hint -> None on a function mean?",
            listOf("The function doesn't return any value", "The function takes no arguments", "The function can't be called", "The function returns zero"),
            0,
            "A function without return returns None.",
        ),
        choice(
            "Where does the hint for a function's return type go?",
            listOf("After the arrow ->", "Before the word def", "In the return statement", "On the body's first line"),
            0,
            "E.g. def f(x: int) -> str:",
        ),
        fill(
            "Complete the hint: a list of floating-point numbers.",
            "temp: list[____] = [21.5, 19.0]\nprint(type(temp[0]).__name__)",
            listOf("float", "Float", "real"),
            "float",
            "The floating-point type is float; Float and real don't exist (NameError).",
        ),
        fill(
            "Fill in the symbol that separates the function's return type.",
            "def square(x: int) ____ int:\n    return x * x\nprint(square(6))",
            listOf("->", "=>", ":", "="),
            "->",
            "The return type is written after the arrow ->.",
        ),
        tiles(
            "Declare a variable names as a list of strings with the value [\"Amy\"]",
            listOf("names:", "list[str]", "=", "[\"Amy\"]"),
            listOf("->", "list(str)"),
            "The type of the list's elements goes in square brackets.",
        ),
        tiles(
            "Write the header of a function describe that takes an int and returns a str",
            listOf("def", "describe(n:", "int)", "->", "str:"),
            listOf("=>", "str)"),
            "Parameter: type after the colon; result: type after the arrow.",
        ),
    ),
    practice(
        "u44l2",
        output(
            "def first(data: list[int]) -> int | None:\n    if data:\n        return data[0]\n    return None\nprint(first([]), first([9]))",
            "None 9",
            "For an empty list the function returns None.",
        ),
        output(
            "from typing import Optional\ndef search(d: dict, k: str) -> Optional[int]:\n    return d.get(k)\nprint(search({\"a\": 1}, \"b\"))",
            "None",
            "get returns None when the key is missing – hence Optional[int].",
        ),
        output(
            "def age(x: int | None = None) -> str:\n    if x is None:\n        return \"unknown\"\n    return str(x)\nprint(age(), age(30))",
            "unknown 30",
            "An optional parameter often defaults to None.",
        ),
        output(
            "def parse(s: str) -> int | None:\n    if s.isdigit():\n        return int(s)\n    return None\nprint(parse(\"12\"), parse(\"ab\"))",
            "12 None",
            "When the string isn't a number, the result is None.",
        ),
        output(
            "def length(s: str | None) -> int:\n    return len(s) if s is not None else 0\nprint(length(\"cat\") + length(None))",
            "3",
            "Before using a value, we check that it isn't None.",
        ),
        output(
            "def text(x: int | str) -> str:\n    return str(x) * 2\nprint(text(4), text(\"a\"))",
            "44 aa",
            "int | str means: an integer or a string.",
        ),
        output(
            "from typing import Optional\ndef divide(a: int, b: int) -> Optional[int]:\n    return a // b if b else None\nprint(divide(7, 2), divide(7, 0))",
            "3 None",
            "When b is zero, the function returns None instead of dividing.",
        ),
        output(
            "def max_or_none(x: list[int]) -> int | None:\n    return max(x) if x else None\nw = max_or_none([])\nprint(w is None)",
            "True",
            "An empty list gives None.",
        ),
        choice(
            "Which hint should you choose for a function that returns a string or None?",
            listOf("str | None", "str", "None", "str & None"),
            0,
            "The vertical bar joins the possible types.",
        ),
        choice(
            "Where do we import Optional from?",
            listOf("From the typing module", "From the types module", "From the functools module", "No import is needed"),
            0,
            "from typing import Optional.",
        ),
        choice(
            "What does the hint int | str mean?",
            listOf("An integer or a string", "Both int and str at once", "A number written as a string", "A syntax error"),
            0,
            "The bar | in a hint means \"or\".",
        ),
        fill(
            "Complete the code to import Optional.",
            "from ____ import Optional\ndef f(x: Optional[int] = None) -> int:\n    return x or 0\nprint(f())",
            listOf("typing", "types", "functools"),
            "typing",
            "Optional comes from the typing module.",
        ),
        fill(
            "Complete the hint: the result is an integer or None.",
            "from typing import Optional\ndef index(s: str) -> ____[int]:\n    return s.find(\"x\") if \"x\" in s else None\nprint(index(\"abc\"))",
            listOf("Optional", "optional", "Option"),
            "Optional",
            "Optional[int] means int or None; the name must match the import exactly, so optional and Option give a NameError.",
        ),
        tiles(
            "Write the header of a function find that takes a str and returns an int or None",
            listOf("def", "find(s:", "str)", "->", "int", "|", "None:"),
            listOf("or", "&"),
            "An optional type is written as int | None.",
        ),
        tiles(
            "Declare a variable name of type Optional[str] with the value None",
            listOf("name:", "Optional[str]", "=", "None"),
            listOf("->", "Optional(str)"),
            "The type inside Optional goes in square brackets.",
        ),
    ),
    practice(
        "u44l3",
        output(
            "def times2(x: int) -> int:\n    return x * 2\nprint(times2([1]))",
            "[1, 1]",
            "Python doesn't check types – a list times 2 is the list doubled.",
        ),
        output(
            "number: int = 5\nnumber = \"five\"\nprint(number)",
            "five",
            "A type hint doesn't forbid assigning a different type.",
        ),
        output(
            "def f(x: float, y: float) -> float:\n    return x + y\nprint(f(1, 2))",
            "3",
            "Ints were passed in, so the result is an int too – the hint doesn't change that.",
        ),
        output(
            "def f(a: int, b: str = \"x\") -> bool:\n    return True\nprint(f.__annotations__[\"b\"].__name__)",
            "str",
            "The hint for parameter b is in the dictionary under the key \"b\".",
        ),
        output(
            "def f(x, y: int):\n    pass\nprint(list(f.__annotations__))",
            "['y']",
            "A parameter without a hint doesn't appear in __annotations__.",
        ),
        output(
            "def f(x: int) -> str:\n    pass\nprint(len(f.__annotations__))",
            "2",
            "The dictionary contains x and return.",
        ),
        output(
            "def f(n: int) -> int:\n    return n\nfor k, v in f.__annotations__.items():\n    print(k, v.__name__)",
            "n int\nreturn int",
            "__annotations__ is an ordinary dictionary you can iterate over.",
        ),
        output(
            "def add(a: int, b: int) -> int:\n    return a + b\nprint(add(1.5, 2))",
            "3.5",
            "The float passes without an error – type hints aren't checked.",
        ),
        choice(
            "What will Python do when calling f(\"a\") for def f(x: int)?",
            listOf("Run the function normally", "Raise a TypeError", "Convert \"a\" to a number", "Refuse to run the program"),
            0,
            "Python ignores type hints while the program runs.",
        ),
        choice(
            "Who uses type hints?",
            listOf("People, editors and mypy", "Only the Python interpreter", "Nobody – removed at startup", "Only the operating system"),
            0,
            "Type hints help people and tools catch errors.",
        ),
        choice(
            "What will this code print?",
            listOf("abab", "TypeError", "4", "None"),
            0,
            "Type hints aren't checked, and \"ab\" * 2 is \"abab\".",
            code = "def double(x: int) -> int:\n    return x * 2\nprint(double(\"ab\"))",
        ),
        fill(
            "Fill in the key to read the function's return type.",
            "def f(x: int) -> float:\n    return x / 2\nprint(f.__annotations__[\"____\"].__name__)",
            listOf("return", "output", "result"),
            "return",
            "The return type is under the key \"return\"; the other keys don't exist (KeyError).",
        ),
        fill(
            "Complete the code to print the number of the function's type hints (3).",
            "def f(a: int, b: int) -> int:\n    return a + b\nprint(len(f.____))",
            listOf("__annotations__", "__name__", "__types__"),
            "__annotations__",
            "__annotations__ has 3 entries; __name__ is \"f\" (length 1), and __types__ doesn't exist.",
        ),
        tiles(
            "Print the type hint dictionary of the function count",
            listOf("print(", "count.__annotations__", ")"),
            listOf("count()", "annotations("),
            "A function's type hints are in the __annotations__ attribute.",
        ),
        output(
            "def f(x: int) -> int:\n    return x\nprint(f(\"yes\"))",
            "yes",
            "The function returns a string despite the hint -> int.",
        ),
    ),
    practice(
        "u44l4",
        output(
            "def perimeter(a: float, b: float) -> float:\n    return 2 * (a + b)\nprint(perimeter(1.5, 2.5))",
            "8.0",
            "Type hints describe types; the result is an ordinary calculation.",
        ),
        output(
            "def count(s: str, char: str = \"a\") -> int:\n    return s.count(char)\nprint(count(\"banana\"), count(\"banana\", \"n\"))",
            "3 2",
            "A parameter with a type hint can have a default value.",
        ),
        output(
            "def first(s: str) -> str | None:\n    return s[0] if s else None\nprint(first(\"Amy\"), first(\"\"))",
            "A None",
            "An empty string gives None.",
        ),
        output(
            "stock: dict[str, list[int]] = {\"a\": [1, 2]}\nstock[\"a\"].append(3)\nprint(sum(stock[\"a\"]))",
            "6",
            "The dictionary's values are lists of integers.",
        ),
        output(
            "def f(x: str) -> int:\n    return len(x)\nprint(f([1, 2, 3]))",
            "3",
            "A list has len() too, and type hints aren't checked.",
        ),
        output(
            "def g(a: int, b: int = 2) -> int:\n    return a ** b\nprint(list(g.__annotations__))",
            "['a', 'b', 'return']",
            "The dictionary contains the parameters and the return type.",
        ),
        output(
            "from typing import Optional\ndef f(x: Optional[int] = None) -> int:\n    return 0 if x is None else x * 3\nprint(f(), f(2))",
            "0 6",
            "Optional[int] with a default of None is a common pattern.",
        ),
        choice(
            "Which hint fits [(\"a\", 1), (\"b\", 2)]?",
            listOf("list[tuple[str, int]]", "tuple[list[str]]", "dict[str, int]", "list[str, int]"),
            0,
            "It's a list of tuples: a string and an integer.",
        ),
        choice(
            "What is true about type hints in Python?",
            listOf("The interpreter doesn't enforce them", "They enforce types on assignment", "They speed up the program", "They're required in every function"),
            0,
            "Type hints are documentation for people and tools.",
        ),
        choice(
            "Which one is a correct variable type hint?",
            listOf("x: int = 5", "x = 5: int", "x -> int = 5", "x = int: 5"),
            0,
            "The type goes after the colon, before the = sign.",
        ),
        fill(
            "Complete the return type: the function returns a string.",
            "def label(n: int) -> ____:\n    return \"no. \" + str(n)\nprint(label.__annotations__[\"return\"].__name__)",
            listOf("str", "int", "bool"),
            "str",
            "The function returns a string, so the result is str.",
        ),
        fill(
            "Complete the hint: a string or None.",
            "def f(x: str | ____ = None) -> str:\n    return x or \"-\"\nprint(f())",
            listOf("None", "none", "0"),
            "None",
            "A missing value in Python is None, with a capital N; none is an unknown name, and 0 is a number.",
        ),
        tiles(
            "Declare a variable results as a dictionary with str keys and float values, empty",
            listOf("results:", "dict[str,", "float]", "=", "{}"),
            listOf("->", "dict(str,"),
            "The dictionary's key and value types go in square brackets.",
        ),
        tiles(
            "Write the header of a function average that takes a list of floats and returns a float",
            listOf("def", "average(x:", "list[float])", "->", "float:"),
            listOf("=>", "list(float))"),
            "The type of the list's elements goes in square brackets.",
        ),
        output(
            "def info(x: int) -> str:\n    return \"ok\"\nprint(info.__annotations__[\"x\"].__name__)",
            "int",
            "The type of parameter x is stored in __annotations__.",
        ),
    ),
)
