package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

internal val module67Cards = listOf(
    cards(
        "u67l7",
        explain(
            "Rows to columns: zip(*m)",
            "The star unpacks the list of rows into separate arguments for `zip`. It joins the first items, " +
                "then the second ones, and so on – and that's how rows turn into columns.",
            code = "m = [[1, 2, 3], [4, 5, 6]]\nprint(list(zip(*m)))",
            output = "[(1, 4), (2, 5), (3, 6)]",
        ),
    ),
)
