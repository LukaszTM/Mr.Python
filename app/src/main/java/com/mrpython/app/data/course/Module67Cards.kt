package com.mrpython.app.data.course

internal val module67Cards = listOf(
    cards(
        "u67l7",
        explain(
            "Wiersze na kolumny: zip(*m)",
            "Gwiazdka rozpakowuje listę wierszy na osobne argumenty `zip`. Ten łączy pierwsze elementy, " +
                "potem drugie itd. – i tak wiersze zamieniają się w kolumny.",
            code = "m = [[1, 2, 3], [4, 5, 6]]\nprint(list(zip(*m)))",
            output = "[(1, 4), (2, 5), (3, 6)]",
        ),
    ),
)
