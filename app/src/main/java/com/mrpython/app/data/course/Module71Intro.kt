package com.mrpython.app.data.course

internal val module71Intro = lesson(
    "u71l0", "Wprowadzenie: pythonowe idiomy",
    explain(
        "EAFP czy LBYL",
        "Idiomy to sprawdzone, „pythonowe” sposoby pisania kodu. LBYL to „sprawdź, zanim skoczysz” (`if`), " +
            "a EAFP – „łatwiej przeprosić” (`try/except`). W Pythonie często wybiera się EAFP.",
        code = "d = {\"a\": 1}\ntry:\n    print(d[\"b\"])\nexcept KeyError:\n    print(\"brak klucza\")",
        output = "brak klucza",
    ),
    explain(
        "Rozpakowywanie i zamiana",
        "Wartości można przypisać kilku zmiennym naraz, a dwie zmienne zamienić bez pomocniczej. " +
            "Gwiazdka `*` zbiera resztę elementów w listę.",
        code = "a, b = 1, 2\na, b = b, a\npierwszy, *reszta = [1, 2, 3]\nprint(a, b, pierwszy, reszta)",
        output = "2 1 1 [2, 3]",
    ),
    explain(
        "enumerate i zip",
        "Zamiast `range(len(...))` użyj `enumerate`, który daje numer i element, " +
            "oraz `zip`, który idzie równolegle po kilku listach.",
        code = "for i, z in enumerate(\"ab\", 1):\n    print(i, z)\nfor n, w in zip([\"Ala\"], [5]):\n    print(n, w)",
        output = "1 a\n2 b\nAla 5",
    ),
    explain(
        "get, setdefault i wyrażenia",
        "`get` daje wartość domyślną, `setdefault` wstawia ją, gdy klucza brak, a wyrażenia " +
            "listowe i słownikowe zastępują wiele pętli z `append`.",
        code = "g = {}\nfor s in [\"kot\", \"koń\", \"pies\"]:\n    g.setdefault(s[0], []).append(s)\nprint(g)\nprint({s: len(s) for s in [\"ala\", \"ma\"]})",
        output = "{'k': ['kot', 'koń'], 'p': ['pies']}\n{'ala': 3, 'ma': 2}",
    ),
    explain(
        "Prawdziwość, with i :=",
        "Pusta lista, `0` i `\"\"` są fałszywe, więc piszemy `if not lista:`. `with` sam zamyka plik, " +
            "a mors `:=` przypisuje wartość wewnątrz warunku.",
        code = "lista = [1, 5, 9]\nif not []:\n    print(\"pusta\")\nif (n := len(lista)) > 2:\n    print(\"długość\", n)",
        output = "pusta\ndługość 3",
    ),
    output(
        "x, y = 3, 7\nx, y = y, x\nprint(x, y)",
        "7 3",
        "Zapis x, y = y, x zamienia wartości miejscami.",
    ),
    choice(
        "Co daje enumerate(\"ab\") w pętli for?",
        listOf("pary (numer, element)", "same numery", "same elementy", "pary (element, długość)"),
        0,
        "enumerate dokłada numer do każdego elementu.",
    ),
)
