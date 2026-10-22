package com.mrpython.app.data.course

internal val module9Intro = lesson(
    "u9l0", "Wprowadzenie: krotki i zbiory",
    explain(
        "Krotka (tuple)",
        "Krotka wygląda jak lista, ale w nawiasach okrągłych i nie można jej zmieniać. " +
            "Nadaje się do danych, które mają zostać stałe, np. współrzędnych punktu. Indeksy działają jak w liście.",
        code = "punkt = (3, 4)\nprint(punkt[0])\nprint(len(punkt))",
        output = "3\n2",
    ),
    explain(
        "Rozpakowywanie",
        "Elementy krotki możesz przypisać od razu do kilku zmiennych. Krotka z jednym elementem " +
            "wymaga przecinka: `(5,)`.",
        code = "x, y = (3, 4)\nprint(x + y)\nfor a, b in [(1, 2), (3, 4)]:\n    print(a * b)",
        output = "7\n2\n12",
    ),
    explain(
        "Zbiór (set)",
        "Zbiór w klamrach `{}` przechowuje tylko unikalne elementy – powtórzenia znikają. " +
            "Nie ma indeksów. `add()` dodaje element, a `in` szybko sprawdza, czy element w nim jest.",
        code = "s = {1, 2, 2, 3}\ns.add(4)\nprint(s)\nprint(2 in s)",
        output = "{1, 2, 3, 4}\nTrue",
    ),
    explain(
        "Usuwanie powtórzeń",
        "`set()` zamienia listę na zbiór, więc łatwo policzysz różne elementy.",
        code = "x = [1, 1, 2, 3, 3]\nprint(len(set(x)))",
        output = "3",
    ),
    explain(
        "Działania na zbiorach",
        "`&` daje część wspólną, `|` – sumę, a `-` – różnicę (elementy pierwszego zbioru, " +
            "których nie ma w drugim).",
        code = "a = {1, 2, 3}\nb = {2, 3, 4}\nprint(a & b)\nprint(a | b)\nprint(a - b)",
        output = "{2, 3}\n{1, 2, 3, 4}\n{1}",
    ),
    choice(
        "Czym krotka różni się od listy?",
        listOf("Krotki nie można zmieniać", "Krotka nie ma indeksów", "Krotka może mieć tylko liczby", "Niczym"),
        0,
        "Krotka jest niezmienna.",
    ),
    output(
        "print({5, 5, 6})",
        "{5, 6}",
        "Zbiór usuwa powtórzenia.",
    ),
    fill(
        "Uzupełnij, aby wypisać elementy wspólne.",
        "a = {1, 2}\nb = {2, 3}\nprint(a ____ b)",
        listOf("&", "|", "-"),
        "&",
        "& daje część wspólną zbiorów.",
    ),
)
