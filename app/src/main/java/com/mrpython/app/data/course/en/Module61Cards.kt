package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

internal val module61Cards = listOf(
    cards(
        "u61l5",
        explain(
            "capitalize and title",
            "`capitalize()` makes the first letter of a string uppercase and all the others lowercase. " +
                "`title()` gives you a capital letter at the start of every word.",
            code = "print(\"anna HAS cats\".capitalize())\nprint(\"anna has cats\".title())",
            output = "Anna has cats\nAnna Has Cats",
        ),
    ),
)
