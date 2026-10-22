package com.mrpython.app.data.course

internal val module71Cards = listOf(
    cards(
        "u71l1",
        explain(
            "getattr i hasattr",
            "`getattr(obiekt, \"nazwa\", domyślna)` czyta atrybut po nazwie i zwraca wartość domyślną, " +
                "gdy go brak (EAFP). `hasattr` tylko sprawdza, czy atrybut istnieje (LBYL).",
            code = "class Kot:\n    imie = \"Mruczek\"\nprint(getattr(Kot, \"imie\", \"?\"))\nprint(getattr(Kot, \"wiek\", \"?\"))\nprint(hasattr(Kot, \"wiek\"))",
            output = "Mruczek\n?\nFalse",
        ),
    ),
)
