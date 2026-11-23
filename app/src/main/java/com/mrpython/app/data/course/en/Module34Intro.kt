package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

internal val module34Intro = lesson(
    "u34l0", "Introduction: dataclasses",
    explain(
        "A data class",
        "Many classes only store data, and writing `__init__` every time is boring. " +
            "The `@dataclass` decorator from the `dataclasses` module does it for us: just list the fields as `name: type`.",
        code = "from dataclasses import dataclass\n\n@dataclass\nclass Point:\n    x: int\n    y: int\n\nprint(Point(1, 2))",
        output = "Point(x=1, y=2)",
    ),
    explain(
        "What we get for free",
        "`@dataclass` creates `__init__`, a readable `__repr__` and an `__eq__` that compares the fields. " +
            "The types next to the fields are only hints – Python doesn't check them. Fields are ordinary attributes.",
        code = "from dataclasses import dataclass\n\n@dataclass\nclass Point:\n    x: int\n    y: int\n\nprint(Point(1, 2) == Point(1, 2))",
        output = "True",
    ),
    explain(
        "Default values and field",
        "A field can have a default value, e.g. `points: int = 0` – such fields go at the end. " +
            "For a list or dictionary use `field(default_factory=list)` so that each object gets its own new list.",
        code = "from dataclasses import dataclass, field\n\n@dataclass\nclass Player:\n    name: str\n    points: int = 0\n    tags: list = field(default_factory=list)\n\nprint(Player(\"Olivia\"))",
        output = "Player(name='Olivia', points=0, tags=[])",
    ),
    explain(
        "frozen and order",
        "`@dataclass(frozen=True)` blocks changes to fields after creation – such objects can also be put " +
            "in a set. `@dataclass(order=True)` adds the `<` and `>` comparisons, so objects can be sorted (field by field).",
        code = "from dataclasses import dataclass\n\n@dataclass(order=True)\nclass W:\n    a: int\n    b: int\n\nprint(W(1, 9) < W(2, 0))",
        output = "True",
    ),
    choice(
        "Which method does @dataclass NOT create on its own (without parameters)?",
        listOf("__lt__", "__init__", "__repr__", "__eq__"),
        0,
        "__lt__ is the < comparison needed for sorting; it only appears with order=True.",
    ),
    output(
        "from dataclasses import dataclass\n\n@dataclass\nclass Cat:\n    name: str\n    age: int = 1\n\nprint(Cat(\"Whiskers\"))",
        "Cat(name='Whiskers', age=1)",
        "The skipped field age got the default value 1.",
    ),
    fill(
        "Complete the code so the object cannot be changed.",
        "from dataclasses import dataclass\n\n@dataclass(____=True)\nclass Color:\n    r: int\n\nc = Color(255)\ntry:\n    c.r = 0\nexcept AttributeError:\n    print(\"locked\")",
        listOf("frozen", "order", "eq"),
        "frozen",
        "frozen=True freezes the object, so the assignment raises an error.",
    ),
)
