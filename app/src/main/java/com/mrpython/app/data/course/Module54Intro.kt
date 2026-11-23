package com.mrpython.app.data.course

internal val module54Intro = lesson(
    "u54l0", "Wprowadzenie: dobre praktyki",
    explain(
        "Nazwy według PEP 8",
        "PEP 8 to oficjalny przewodnik stylu Pythona. Zmienne i funkcje piszemy w stylu `snake_case`, " +
            "klasy w stylu `CapWords`, a stałe `WIELKIMI_LITERAMI`.",
        code = "MAX_PROB = 3\nliczba_uczniow = 25\n\nclass KontoBankowe:\n    pass",
    ),
    explain(
        "Docstringi",
        "Docstring to napis w potrójnym cudzysłowie zaraz pod `def`. Opisuje, co robi funkcja, " +
            "i trafia do atrybutu `__doc__`. Zwykły komentarz `#` docstringiem nie jest.",
        code = "def dodaj(a, b):\n    \"\"\"Zwraca sumę a i b.\"\"\"\n    return a + b\n\nprint(dodaj.__doc__)",
        output = "Zwraca sumę a i b.",
    ),
    explain(
        "Małe funkcje i DRY",
        "DRY (Don't Repeat Yourself) znaczy: nie powtarzaj się. Gdy ten sam wzór pojawia się kilka razy, " +
            "wydziel go w funkcję. Najlepiej, gdy każda funkcja robi jedną rzecz.",
        code = "def brutto(netto):\n    return round(netto * 1.23, 2)\n\nprint(brutto(10), brutto(20))",
        output = "12.3 24.6",
    ),
    explain(
        "Stałe i czytelne warunki",
        "Liczba bez wyjaśnienia, np. `0.23`, to „magiczna liczba” – nadaj jej nazwę stałej. Warunki też " +
            "upraszczaj: `if gotowe:` zamiast `if gotowe == True:`, a `1 < x < 10` zamiast dwóch porównań.",
        code = "VAT = 0.23\nnetto = 100\nprint(netto * (1 + VAT))\nprint(1 < 5 < 10)",
        output = "123.0\nTrue",
    ),
    explain(
        "Wczesny return",
        "Przypadki specjalne obsłuż na początku funkcji i od razu wyjdź przez `return`. " +
            "Główna logika nie chowa się wtedy w głębokich `if`-ach.",
        code = "def dziel(a, b):\n    if b == 0:\n        return \"błąd\"\n    return a / b\n\nprint(dziel(6, 3), dziel(1, 0))",
        output = "2.0 błąd",
    ),
    choice(
        "Jak według PEP 8 nazwać funkcję liczącą średnią?",
        listOf("licz_srednia", "LiczSrednia", "liczSrednia", "LICZ_SREDNIA"),
        0,
        "Funkcje piszemy w stylu snake_case.",
    ),
    output(
        "def f():\n    \"\"\"Wita.\"\"\"\n    return 1\n\nprint(f.__doc__)",
        "Wita.",
        "__doc__ przechowuje docstring funkcji.",
    ),
    tiles(
        "Zdefiniuj zgodną z PEP 8 stałą z liczbą dni w tygodniu.",
        listOf("DNI_W_TYGODNIU", "=", "7"),
        listOf("dni_w_tygodniu", "=="),
        "Stałe zapisujemy wielkimi literami z podkreślnikami.",
    ),
)
