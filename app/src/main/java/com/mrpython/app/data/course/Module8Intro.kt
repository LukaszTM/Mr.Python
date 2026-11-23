package com.mrpython.app.data.course

internal val module8Intro = lesson(
    "u8l0", "Wprowadzenie: słowniki",
    explain(
        "Klucz i wartość",
        "Słownik przechowuje pary klucz–wartość, jak prawdziwy słownik: słowo i jego znaczenie. " +
            "Zapisujemy go w klamrach `{}`, a wartość odczytujemy po kluczu w nawiasach kwadratowych.",
        code = "osoba = {\"imie\": \"Ala\", \"wiek\": 10}\nprint(osoba[\"imie\"])",
        output = "Ala",
    ),
    explain(
        "Dodawanie i zmiana",
        "Przypisanie do nowego klucza dodaje parę, a do istniejącego – nadpisuje wartość. " +
            "Klucze są unikalne. Odczyt nieistniejącego klucza kończy się błędem `KeyError`.",
        code = "d = {\"a\": 1}\nd[\"b\"] = 2\nd[\"a\"] = 5\nprint(d)",
        output = "{'a': 5, 'b': 2}",
    ),
    explain(
        "Bezpieczny odczyt",
        "`get(klucz, domyślna)` zwraca wartość albo wartość domyślną, gdy klucza nie ma – bez błędu. " +
            "`in` sprawdza, czy klucz jest w słowniku.",
        code = "d = {\"a\": 1}\nprint(d.get(\"b\", 0))\nprint(\"a\" in d)",
        output = "0\nTrue",
    ),
    explain(
        "Klucze, wartości, usuwanie",
        "`keys()` daje klucze, `values()` – wartości, a `items()` – pary. `del d[k]` usuwa parę, " +
            "a `pop(k)` usuwa ją i zwraca wartość.",
        code = "d = {\"a\": 1, \"b\": 2}\nprint(list(d.values()))\ndel d[\"a\"]\nprint(d)",
        output = "[1, 2]\n{'b': 2}",
    ),
    explain(
        "Słowniki w pętli",
        "Pętla po słowniku przechodzi po kluczach. Z `items()` dostajesz od razu klucz i wartość.",
        code = "oceny = {\"Ala\": 5, \"Ola\": 4}\nfor imie, ocena in oceny.items():\n    print(imie, ocena)",
        output = "Ala 5\nOla 4",
    ),
    output(
        "ceny = {\"chleb\": 5, \"mleko\": 4}\nprint(ceny[\"mleko\"])",
        "4",
        "Wartość odczytujemy po kluczu.",
    ),
    fill(
        "Uzupełnij, aby odczytać wartość bez ryzyka błędu.",
        "d = {\"x\": 1}\nprint(d.____(\"y\", 0))",
        listOf("get", "items", "keys"),
        "get",
        "get() zwraca wartość domyślną, gdy klucza nie ma.",
    ),
    choice(
        "Co zwraca d.items()?",
        listOf("Pary (klucz, wartość)", "Same klucze", "Same wartości", "Liczbę par"),
        0,
        "items() daje pary klucz–wartość.",
    ),
)
