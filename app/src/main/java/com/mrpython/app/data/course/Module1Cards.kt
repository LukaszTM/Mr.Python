package com.mrpython.app.data.course

internal val module1Cards = listOf(
    cards(
        "u1l1",
        explain(
            "Działania matematyczne",
            "Python liczy jak kalkulator: `+` dodaje, `-` odejmuje, `*` mnoży, a `/` dzieli. " +
                "Wynik działania wpisanego w `print()` pojawi się na ekranie. Kolejność jak w matematyce: najpierw `*` i `/`, " +
                "potem `+` i `-`. Uwaga: działanie w cudzysłowie to już tekst – Python go nie liczy, tylko wypisuje.",
            code = "print(10 - 3)\nprint(3 * 5)\nprint(\"3 * 5\")",
            output = "7\n15\n3 * 5",
        ),
        explain(
            "Wielkość liter ma znaczenie",
            "Python rozróżnia małe i wielkie litery. Działa tylko `print` pisane małymi literami – " +
                "`Print` albo `PRINT` to dla niego zupełnie inne, nieznane słowa.",
            code = "print(\"Dobrze\")",
            output = "Dobrze",
        ),
    ),
    cards(
        "u1l2",
        explain(
            "Cudzysłów czy apostrof?",
            "Napis możesz otoczyć cudzysłowami \" \" albo apostrofami ' ' – oba działają tak samo. " +
                "Przydaje się to, gdy w środku napisu jest apostrof: wtedy otaczamy go cudzysłowami.",
            code = "print('Ala')\nprint(\"It's OK\")",
            output = "Ala\nIt's OK",
        ),
        explain(
            "Sklejanie i powtarzanie napisów",
            "Znak `+` skleja dwa napisy w jeden (bez dodatkowej spacji!). Napis pomnożony " +
                "(znakiem `*`) przez liczbę powtarza się tyle razy.",
            code = "print(\"Py\" + \"thon\")\nprint(\"ha\" * 3)",
            output = "Python\nhahaha",
        ),
        explain(
            "Kilka wartości w print()",
            "Do `print()` możesz podać kilka wartości oddzielonych przecinkami. Python wypisze je " +
                "w jednej linii i sam wstawi między nimi spację.",
            code = "print(\"Ala\", \"ma\", 2, \"koty\")",
            output = "Ala ma 2 koty",
        ),
    ),
    cards(
        "u1l3",
        explain(
            "Nowa linia: \\n",
            "Wewnątrz napisu `\\n` oznacza przejście do nowej linii. Zapisujemy go dwoma znakami " +
                "(ukośnik i n), ale Python traktuje go jak jeden specjalny znak.",
            code = "print(\"Ala\\nma kota\")",
            output = "Ala\nma kota",
        ),
        explain(
            "Tabulator: \\t",
            "`\\t` to tabulator – szeroki odstęp, przydatny do wyrównywania tekstu w kolumnach. " +
                "Takie znaki z ukośnikiem nazywamy znakami specjalnymi.",
        ),
        explain(
            "Parametry end i sep",
            "Po każdym `print()` Python przechodzi do nowej linii. Parametr `end` zmienia to, co " +
                "zostanie dopisane na końcu – `end=\"\"` oznacza: nic. `sep` ustala, czym oddzielić kilka wartości (domyślnie spacją).",
            code = "print(\"A\", end=\"\")\nprint(\"B\")\nprint(\"x\", \"y\", sep=\"-\")",
            output = "AB\nx-y",
        ),
    ),
)
