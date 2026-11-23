package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

internal val module70Cards = listOf(
    cards(
        "u70l2",
        explain(
            "Emptying: clear()",
            "`clear()` removes all items at once – the dictionary (or list) ends up empty, " +
                "but it is still the same object.",
            code = "cart = {\"mug\": 2, \"map\": 1}\ncart.clear()\nprint(cart, len(cart))",
            output = "{} 0",
        ),
    ),
)
