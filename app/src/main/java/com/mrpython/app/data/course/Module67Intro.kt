package com.mrpython.app.data.course

internal val module67Intro = lesson(
    "u67l0", "Wprowadzenie: tydzień powtórek – wszystko naraz",
    explain(
        "Łączymy klocki",
        "W tym tygodniu każdy dzień to mały, prawdziwy program: analiza tekstu, dziennik ocen, sklep. " +
            "Łączysz w nich napisy, słowniki, funkcje i moduły. Czytaj kod krok po kroku.",
        code = "from collections import Counter\nc = Counter(\"to jest to\".split())\nprint(c.most_common(1))",
        output = "[('to', 2)]",
    ),
    explain(
        "Słownik z listami",
        "Słownik, którego wartościami są listy, to dobry model dziennika ocen. `items()` daje pary " +
            "klucz–wartość, a `:.1f` w f-stringu formatuje średnią.",
        code = "oceny = {\"Ola\": [5, 4], \"Jan\": [3]}\nfor imie, o in oceny.items():\n    print(f\"{imie}: {sum(o) / len(o):.1f}\")",
        output = "Ola: 4.5\nJan: 3.0",
    ),
    explain(
        "Pieniądze i Decimal",
        "Liczby `float` bywają niedokładne, więc przy pieniądzach używaj `Decimal` z napisu albo " +
            "zaokrąglaj wynik przez `round`.",
        code = "from decimal import Decimal\nprint(0.1 + 0.2)\nprint(Decimal(\"0.1\") + Decimal(\"0.2\"))",
        output = "0.30000000000000004\n0.3",
    ),
    explain(
        "Generatory",
        "Funkcja z `yield` to generator – oddaje wartości po jednej, na żądanie. `next(gen, None)` " +
            "pobiera następną albo zwraca `None`, gdy się skończą.",
        code = "def parzyste(n):\n    for i in range(n):\n        if i % 2 == 0:\n            yield i\nprint(list(parzyste(7)))",
        output = "[0, 2, 4, 6]",
    ),
    explain(
        "Narzędzia programisty",
        "Dekoratory, menedżery kontekstu `with` i proste testy czynią kod pewniejszym. " +
            "Na przykład `suppress` po cichu ignoruje wskazany wyjątek.",
        code = "from contextlib import suppress\nwith suppress(KeyError):\n    print({}[\"x\"])\nprint(\"dalej\")",
        output = "dalej",
    ),
    output(
        "g = (x * 2 for x in range(4))\nprint(sum(g))",
        "12",
        "Generator daje 0, 2, 4, 6, a ich suma to 12.",
    ),
    choice(
        "Czego najlepiej użyć do dokładnych obliczeń na kwotach?",
        listOf("Decimal", "float", "str", "bool"),
        0,
        "Decimal liczy na liczbach dziesiętnych bez błędów zaokrągleń float.",
    ),
)
