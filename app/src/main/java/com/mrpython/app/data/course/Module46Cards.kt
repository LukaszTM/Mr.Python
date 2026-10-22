package com.mrpython.app.data.course

internal val module46Cards = listOf(
    cards(
        "u46l1",
        explain(
            "Pojedyncze wartości",
            "`dumps()` zamienia na JSON nie tylko słowniki i listy. Napis dostaje podwójne cudzysłowy, " +
                "a liczba staje się tekstem – wynik zawsze jest typu `str`.",
            code = "import json\nprint(json.dumps(\"tak\"))\nprint(json.dumps(42) + \"!\")",
            output = "\"tak\"\n42!",
        ),
        explain(
            "dump i load – pliki",
            "Funkcje bez literki s pracują na plikach: `json.dump(dane, plik)` zapisuje JSON do " +
                "otwartego pliku, a `json.load(plik)` go wczytuje.",
            code = "import json\nwith open(\"dane.json\", \"w\") as f:\n    json.dump({\"a\": 1}, f)\nwith open(\"dane.json\") as f:\n    print(json.load(f))",
            output = "{'a': 1}",
        ),
    ),
    cards(
        "u46l2",
        explain(
            "Proste wartości z JSON-a",
            "`loads()` czyta też pojedyncze wartości: `false` daje `False`, `null` – `None`, liczba z " +
                "kropką to `float`, a napis w cudzysłowach to zwykły `str`.",
            code = "import json\nprint(json.loads(\"false\"), json.loads(\"null\"))\nprint(json.loads(\"3.5\") + 1, json.loads('\"ala\"'))",
            output = "False None\n4.5 ala",
        ),
        explain(
            "Błędny JSON",
            "Tekst niezgodny z JSON-em, np. z apostrofami albo `True` z wielkiej litery, daje błąd " +
                "`json.JSONDecodeError`.",
            code = "import json\ntry:\n    json.loads(\"[True]\")\nexcept json.JSONDecodeError:\n    print(\"to nie JSON\")",
            output = "to nie JSON",
        ),
    ),
    cards(
        "u46l3",
        explain(
            "Jak wygląda indent",
            "Z `indent` każdy element trafia do osobnej linii, wcięty o podaną liczbę spacji, a " +
                "nawiasy zamykające stoją w osobnych liniach.",
            code = "import json\nprint(json.dumps([1, 2], indent=2))",
            output = "[\n  1,\n  2\n]",
        ),
    ),
)
