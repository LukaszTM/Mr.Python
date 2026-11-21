package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

internal val module34Cards = listOf(
    cards(
        "u34l1",
        explain(
            "Arguments by name",
            "We create a dataclass object like a function call – arguments can be passed by name, in any " +
                "order. `__repr__` still shows the fields in class order. A missing required field is a `TypeError`.",
            code = "from dataclasses import dataclass\n\n@dataclass\nclass Pt:\n    x: int\n    y: int\n\nprint(Pt(y=1, x=2))",
            output = "Pt(x=2, y=1)",
        ),
    ),
    cards(
        "u34l2",
        explain(
            "Default fields go last",
            "Just like function parameters, fields with a default value must come after fields without one. " +
                "A field without a value after a field with a default ends in a `TypeError`.",
            code = "from dataclasses import dataclass\n\n@dataclass\nclass A:\n    x: int\n    y: int = 2\n\nprint(A(5))",
            output = "A(x=5, y=2)",
        ),
        explain(
            "A list as a default value",
            "Writing `tags: list = []` is forbidden (`ValueError`), because all objects would share one list. " +
                "`default_factory` gets a function without parentheses, e.g. `list` or `dict`, and calls it for each object.",
            code = "from dataclasses import dataclass, field\n\n@dataclass\nclass C:\n    items: list = field(default_factory=list)\n\na, b = C(), C()\na.items.append(1)\nprint(a.items, b.items)",
            output = "[1] []",
        ),
        explain(
            "field(default=...) and lambda",
            "`field(default=5)` works like a plain `= 5`. When the default list should already contain items, pass " +
                "`default_factory` a lambda function that builds it.",
            code = "from dataclasses import dataclass, field\n\n@dataclass\nclass P:\n    x: int = field(default=5)\n    cells: list = field(default_factory=lambda: [0, 0])\n\nprint(P())",
            output = "P(x=5, cells=[0, 0])",
        ),
    ),
    cards(
        "u34l3",
        explain(
            "Sets only with frozen",
            "An ordinary dataclass can't be put in a set or used as a dictionary key – you'll get " +
                "`TypeError: unhashable type`. With `frozen=True` it works, and equal objects count once.",
            code = "from dataclasses import dataclass\n\n@dataclass(frozen=True)\nclass P:\n    x: int\n\nprint(len({P(1), P(1), P(2)}))",
            output = "2",
        ),
        explain(
            "FrozenInstanceError",
            "Every attempt to change a field of a frozen object – including `p.x += 1` – raises `FrozenInstanceError`. " +
                "It's a kind of `AttributeError`, so `except AttributeError` catches it.",
            code = "from dataclasses import dataclass\n@dataclass(frozen=True)\nclass K:\n    r: int\ntry:\n    K(1).r = 2\nexcept AttributeError as e:\n    print(type(e).__name__)",
            output = "FrozenInstanceError",
        ),
    ),
)
