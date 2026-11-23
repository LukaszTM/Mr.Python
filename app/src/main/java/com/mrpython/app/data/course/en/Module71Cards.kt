package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

internal val module71Cards = listOf(
    cards(
        "u71l1",
        explain(
            "getattr and hasattr",
            "`getattr(obj, \"name\", default)` reads an attribute by name and returns the default value " +
                "when it is missing (EAFP). `hasattr` only checks whether the attribute exists (LBYL).",
            code = "class Cat:\n    name = \"Whiskers\"\nprint(getattr(Cat, \"name\", \"?\"))\nprint(getattr(Cat, \"age\", \"?\"))\nprint(hasattr(Cat, \"age\"))",
            output = "Whiskers\n?\nFalse",
        ),
    ),
)
