package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

internal val module69Cards = listOf(
    cards(
        "u69l2",
        explain(
            "Splitting into two parts",
            "`split(maxsplit=1)` cuts the string only at the first space, so the rest stays in one piece – " +
                "perfect for commands like “take old key”.",
            code = "print(\"take old key\".split(maxsplit=1))",
            output = "['take', 'old key']",
        ),
        explain(
            "partition",
            "`partition(sep)` always returns three parts: before the separator, the separator itself and the rest. " +
                "When there is no separator, the last two are empty – so unpacking won't cause an error.",
            code = "print(\"go old forest\".partition(\" \"))\nprint(\"look\".partition(\" \"))",
            output = "('go', ' ', 'old forest')\n('look', '', '')",
        ),
    ),
)
