package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

internal val module44Intro = lesson(
    "u44l0", "Introduction: type hints",
    explain(
        "What are type hints?",
        "A type hint tells readers what type a variable should be. We write it after a colon: " +
            "`age: int = 30`. It doesn't change the value – it helps people and editors understand the code.",
        code = "age: int = 30\nname: str = \"Amy\"\nprint(name, age)",
        output = "Amy 30",
    ),
    explain(
        "Type hints in functions",
        "In a function, a parameter's type goes after a colon, and the return type after the arrow " +
            "`->`. You can see right away what the function takes and what it returns.",
        code = "def add(a: int, b: int) -> int:\n    return a + b\nprint(add(2, 3))",
        output = "5",
    ),
    explain(
        "Collection types",
        "For collections we give the element type in square brackets: `list[int]` is a list of " +
            "integers, and `dict[str, int]` is a dictionary with string keys and integer values.",
        code = "numbers: list[int] = [1, 2, 3]\ngrades: dict[str, int] = {\"Amy\": 5}\nprint(sum(numbers), grades[\"Amy\"])",
        output = "6 5",
    ),
    explain(
        "Optional and X | None",
        "When a value can be of type X or `None`, we write `X | None`. An older, equivalent notation " +
            "is `Optional[X]` from the `typing` module.",
        code = "def find(s: str) -> int | None:\n    if \"a\" in s:\n        return s.index(\"a\")\n    return None\nprint(find(\"dog\"), find(\"mama\"))",
        output = "None 1",
    ),
    explain(
        "Python doesn't check them",
        "At runtime Python ignores type hints – a wrong type won't cause an error. Type errors are " +
            "found by tools like mypy, without running the program. The hints are available in " +
            "the `__annotations__` dictionary.",
        code = "def f(x: int) -> int:\n    return x * 2\nprint(f(\"ab\"))\nprint(list(f.__annotations__))",
        output = "abab\n['x', 'return']",
    ),
    choice(
        "What does def f(x: str) -> bool mean?",
        listOf("f takes a string and returns a boolean", "f takes a bool and returns a string", "f converts str to bool", "It's a syntax error"),
        0,
        "The parameter's type goes after the colon, and the return type after the arrow.",
    ),
    output(
        "x: int = \"text\"\nprint(x)",
        "text",
        "A type hint doesn't prevent assigning a different type.",
    ),
    tiles(
        "Write the header of a function area that takes a float and returns a float",
        listOf("def", "area(r:", "float)", "->", "float:"),
        listOf("=>", "int:"),
        "The return type goes after the arrow ->.",
    ),
)
