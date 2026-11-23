package com.mrpython.app.data.course

internal val module70Cards = listOf(
    cards(
        "u70l2",
        explain(
            "Opróżnianie: clear()",
            "`clear()` usuwa wszystkie pozycje naraz – słownik (albo lista) zostaje pusty, " +
                "ale to wciąż ten sam obiekt.",
            code = "koszyk = {\"kubek\": 2, \"mapa\": 1}\nkoszyk.clear()\nprint(koszyk, len(koszyk))",
            output = "{} 0",
        ),
    ),
)
