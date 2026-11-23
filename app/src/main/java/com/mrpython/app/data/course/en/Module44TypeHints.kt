package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*
import com.mrpython.app.domain.CourseUnit

internal val module44 = CourseUnit(
    id = "u44",
    title = "Type hints",
    description = "Type hints for variables and functions",
    lessons = listOf(
        lesson(
            "u44l1", "Basic type hints",
            output(
                "age: int = 30\nname: str = \"Amy\"\nprint(name, age)",
                "Amy 30",
                "The hint after the colon describes the variable's type; it doesn't change its value.",
            ),
            output(
                "def add(a: int, b: int) -> int:\n    return a + b\nprint(add(2, 3))",
                "5",
                "-> int describes the type of the function's result.",
            ),
            choice(
                "What does def f(x: str) -> bool mean?",
                listOf("f takes a string and returns a boolean", "f takes a boolean and returns a string", "f converts str to bool", "It's a syntax error"),
                0,
                "A parameter's hint goes after the colon, and the return type after the arrow.",
            ),
            output(
                "numbers: list[int] = [1, 2, 3]\nprint(sum(numbers))",
                "6",
                "list[int] means a list of integers.",
            ),
            fill(
                "Complete the hint: a dictionary with string keys and integer values.",
                "grades: dict[str, ____] = {\"Amy\": 5}\nprint(grades[\"Amy\"])",
                listOf("int", "str", "list", "bool"),
                "int",
                "dict[str, int] – the key is a str, the value is an int.",
            ),
            choice(
                "Which hint fits [\"a\", \"b\"]?",
                listOf("list[str]", "list[int]", "dict[str]", "str[list]"),
                0,
                "It's a list of strings.",
            ),
            tiles(
                "Write the header of a function area that takes a float and returns a float",
                listOf("def", "area(r:", "float)", "->", "float:"),
                listOf("=>", "int:"),
                "The return type goes after the arrow ->.",
            ),
        ),
        lesson(
            "u44l2", "Optional and X | None",
            output(
                "def find(s: str) -> int | None:\n    if \"a\" in s:\n        return s.index(\"a\")\n    return None\nprint(find(\"dog\"), find(\"mama\"))",
                "None 1",
                "int | None means: an integer or None.",
            ),
            choice(
                "What does the hint int | None mean?",
                listOf("The value can be an integer or None", "A nonzero integer", "Bitwise OR of a number and None", "An empty number"),
                0,
                "A vertical bar in a hint means \"one of these types\".",
            ),
            output(
                "from typing import Optional\ndef name(x: Optional[str] = None) -> str:\n    return x or \"guest\"\nprint(name(), name(\"Ann\"))",
                "guest Ann",
                "Optional[str] is the same as str | None.",
            ),
            fill(
                "Complete the hint so it means \"a string or None\".",
                "def describe(x: str | ____ = None) -> str:\n    return \"none\" if x is None else x\nprint(describe())",
                listOf("None", "Null", "nil", "empty"),
                "None",
                "In Python, a missing value is None.",
            ),
            choice(
                "Which notation is equivalent to Optional[int]?",
                listOf("int | None", "int | 0", "list[int]", "int or None"),
                0,
                "Optional[X] is short for X | None.",
            ),
            output(
                "def divide(a: int, b: int) -> float | None:\n    if b == 0:\n        return None\n    return a / b\nprint(divide(6, 4), divide(1, 0))",
                "1.5 None",
                "When dividing by zero, the function returns None.",
            ),
            tiles(
                "Declare a variable result of type int or None with the value None",
                listOf("result:", "int", "|", "None", "=", "None"),
                listOf("or", "->"),
                "An optional type is written with a vertical bar.",
            ),
        ),
        lesson(
            "u44l3", "Type hints at runtime",
            output(
                "def add(a: int, b: int) -> int:\n    return a + b\nprint(add(\"ab\", \"c\"))",
                "abc",
                "Python doesn't check type hints – the strings are simply joined.",
            ),
            output(
                "x: int = \"text\"\nprint(x)",
                "text",
                "A type hint doesn't prevent assigning a different type.",
            ),
            choice(
                "What happens when we pass a string to a function with an int hint?",
                listOf("Python runs the code normally – hints aren't checked", "TypeError right at the call", "The string gets converted to int", "SyntaxError"),
                0,
                "Type hints are hints for people and tools (e.g. mypy), not rules.",
            ),
            output(
                "def f(x: int) -> str:\n    return str(x)\nprint(f.__annotations__[\"return\"].__name__)",
                "str",
                "The return type is stored under the key \"return\".",
            ),
            output(
                "def f(a: int, b: str):\n    pass\nprint(list(f.__annotations__))",
                "['a', 'b']",
                "__annotations__ is a dictionary: parameter name → type.",
            ),
            fill(
                "Complete the code to read the type hints of function f.",
                "def f(x: int) -> int:\n    return x\nprint(len(f.____))",
                listOf("__annotations__", "__types__", "annotations", "types"),
                "__annotations__",
                "Type hints are stored in the __annotations__ attribute.",
            ),
            choice(
                "What are tools like mypy for?",
                listOf("They check types without running the program", "They make the program run faster", "They format code", "They install libraries"),
                0,
                "mypy analyzes type hints and finds type errors before the program runs.",
            ),
        ),
        lesson(
            "u44l4", "Review: type hints",
            output(
                "def repeat(s: str, n: int = 2) -> str:\n    return s * n\nprint(repeat(\"ha\"))",
                "haha",
                "A type hint and a default value can appear together.",
            ),
            output(
                "def average(data: list[float]) -> float:\n    return sum(data) / len(data)\nprint(average([2.0, 4.0]))",
                "3.0",
                "list[float] is a list of floating-point numbers.",
            ),
            output(
                "def f(x: int) -> int:\n    return x * 2\nprint(f(\"ab\"))",
                "abab",
                "Nobody checks the hints – \"ab\" * 2 is \"abab\".",
            ),
            choice(
                "Which hint fits {\"a\": [1, 2]}?",
                listOf("dict[str, list[int]]", "dict[list, int]", "list[dict]", "dict[str, int]"),
                0,
                "The key is a string, the value is a list of integers.",
            ),
            fill(
                "Complete the return type: the function returns True or False.",
                "def is_even(n: int) -> ____:\n    return n % 2 == 0\nprint(is_even.__annotations__[\"return\"].__name__)",
                listOf("bool", "int", "str", "None"),
                "bool",
                "The result of a comparison is a bool.",
            ),
            output(
                "def f(a: int, b: float) -> None:\n    pass\nprint(len(f.__annotations__))",
                "3",
                "The dictionary contains a, b and return.",
            ),
            tiles(
                "Write the header of a function total that takes a list of integers and returns an int",
                listOf("def", "total(x:", "list[int])", "->", "int:"),
                listOf("list<int>)", "=>"),
                "The type of the list's elements goes in square brackets.",
            ),
        ),
    ),
)
