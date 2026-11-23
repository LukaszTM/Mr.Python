package com.mrpython.app.data.course

internal val module58Cards = listOf(
    cards(
        "u58l1",
        explain(
            "Podział z limitem",
            "`split(sep, n)` dzieli napis najwyżej `n` razy, licząc od lewej. Reszta napisu zostaje " +
                "w całości w ostatnim kawałku.",
            code = "print(\"2026-10-22\".split(\"-\", 1))",
            output = "['2026', '10-22']",
        ),
        explain(
            "Porównywanie napisów",
            "Napisy porównuje się znak po znaku, jak słowa w słowniku: decyduje pierwsza różna litera. " +
                "Uwaga: wielkie litery są „mniejsze” od małych, więc `\"Z\" < \"a\"` to `True`.",
            code = "print(\"kot\" < \"koza\")\nprint(\"Zebra\" < \"ala\")",
            output = "True\nTrue",
        ),
    ),
    cards(
        "u58l2",
        explain(
            "Potęgowanie od prawej",
            "Większość działań liczy się od lewej, ale `**` – od prawej. `2 ** 2 ** 3` to " +
                "`2 ** (2 ** 3)`, czyli `2 ** 8`. Nawias zmienia kolejność.",
            code = "print(2 ** 2 ** 3)\nprint((2 ** 2) ** 3)",
            output = "256\n64",
        ),
        explain(
            "Zapis 1e3 i ujemne potęgi",
            "`1e3` to skrót od 1 · 10³, czyli 1000 – taki zapis zawsze daje `float`, więc widać `.0`. " +
                "Ujemny wykładnik oznacza ułamek: `2 ** -1` to 1/2.",
            code = "print(1e3)\nprint(2.5e2)\nprint(2 ** -1)",
            output = "1000.0\n250.0\n0.5",
        ),
    ),
)
