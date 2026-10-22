package com.mrpython.app.data.course

internal val module61Intro = lesson(
    "u61l0", "Wprowadzenie: tydzień powtórek",
    explain(
        "Tydzień powtórek",
        "Przez siedem „dni” powtórzysz podstawy: `print` i zmienne, typy, warunki, pętle, napisy " +
            "i formatowanie. Jedna krótka lekcja dziennie wystarczy, by wiedza została na dłużej.",
    ),
    explain(
        "print i zmienne",
        "`end=` zmienia to, co `print` dopisuje na końcu (domyślnie nową linię). Kilka zmiennych " +
            "przypiszesz naraz, np. `a, b = b, a + b` – prawa strona liczy się najpierw.",
        code = "print(\"x\", end=\"-\")\nprint(\"y\")\na, b = 1, 2\na, b = b, a + b\nprint(a, b)",
        output = "x-y\n2 3",
    ),
    explain(
        "Typy i konwersje",
        "`int()`, `float()` i `str()` zamieniają typy. `\"2\" + \"3\"` skleja napisy, a " +
            "`int(\"2\") + 3` dodaje liczby. `type()` pokazuje typ wartości.",
        code = "print(\"2\" + \"3\", int(\"2\") + 3)\nprint(type(3.5))",
        output = "23 5\n<class 'float'>",
    ),
    explain(
        "Warunki i pętle",
        "`if/elif/else` wybiera pierwszą prawdziwą gałąź, a `a if warunek else b` mieści wybór " +
            "w jednej linii. W pętlach `continue` pomija obrót, a `break` kończy pętlę.",
        code = "t = 25\nprint(\"ciepło\" if t > 20 else \"zimno\")\nfor i in range(1, 4):\n    print(i * \"*\")",
        output = "ciepło\n*\n**\n***",
    ),
    explain(
        "Napisy i formatowanie",
        "Wycinek `s[a:b]` bierze znaki od `a` do `b - 1`, a `s[::-1]` odwraca napis. W f-stringach " +
            "`:.2f` daje dwa miejsca po przecinku, a `:.0%` zapisuje liczbę jako procent.",
        code = "s = \"programowanie\"\nprint(s[3:7], s[::-1][:3])\nx = 3.14159\nprint(f\"{x:.2f} {0.5:.0%}\")",
        output = "gram ein\n3.14 50%",
    ),
    output(
        "a, b = 3, 4\na, b = b, a\nprint(a, b)",
        "4 3",
        "Przypisanie wielokrotne zamienia wartości miejscami.",
    ),
    output(
        "print(f\"{2 / 3:.2f}\")",
        "0.67",
        ":.2f zaokrągla do dwóch miejsc po przecinku.",
    ),
    choice(
        "Co wypisze print(\"5\" + \"5\")?",
        listOf("55", "10", "5 5", "TypeError"),
        0,
        "+ na napisach skleja je ze sobą.",
    ),
)
