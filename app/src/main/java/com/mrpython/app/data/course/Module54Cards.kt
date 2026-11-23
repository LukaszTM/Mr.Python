package com.mrpython.app.data.course

internal val module54Cards = listOf(
    cards(
        "u54l1",
        explain(
            "Metody i atrybuty",
            "Metody w klasie to też funkcje, więc ich nazwy piszemy w `snake_case`, podobnie atrybuty " +
                "obiektu. Stała w klasie, np. `MAX_ZYC`, zostaje wielkimi literami.",
            code = "class Gra:\n    MAX_ZYC = 3\n    def stracone_zycie(self):\n        return Gra.MAX_ZYC - 1\n\nprint(Gra().stracone_zycie())",
            output = "2",
        ),
        explain(
            "Długie linie w nawiasach",
            "PEP 8 zaleca krótkie linie. Wewnątrz nawiasów `( )`, `[ ]` lub `{ }` możesz przejść do nowej " +
                "linii, a Python potraktuje całość jak jedno wyrażenie.",
            code = "suma = sum(x for x in [1, 2, 3]\n           if x > 1)\nprint(suma)",
            output = "5",
        ),
    ),
    cards(
        "u54l2",
        explain(
            "Docstring musi być pierwszy",
            "Docstringiem jest tylko napis stojący jako pierwsza instrukcja w ciele funkcji. Napis po " +
                "innym kodzie albo komentarz `#` się nie liczą – wtedy `__doc__` ma wartość `None`.",
            code = "def f():\n    x = 1\n    \"\"\"Opis.\"\"\"\n    return x\n\nprint(f.__doc__)",
            output = "None",
        ),
        explain(
            "Docstring klasy i metody",
            "Docstring może mieć też klasa i każda jej metoda – piszemy go zaraz pod `class` lub `def`. " +
                "Odczytasz go przez `Klasa.__doc__` albo `Klasa.metoda.__doc__`.",
            code = "class Konto:\n    \"\"\"Konto w banku.\"\"\"\n    def wplac(self):\n        \"\"\"Dodaje kwotę.\"\"\"\n\nprint(Konto.__doc__, Konto.wplac.__doc__)",
            output = "Konto w banku. Dodaje kwotę.",
        ),
        explain(
            "Dłuższy docstring",
            "Potrójny cudzysłów pozwala pisać w kilku liniach. Zwyczaj: pierwsza linia to krótkie " +
                "podsumowanie, potem pusta linia i szczegóły. Pierwszą linię wyciągniesz przez `splitlines()[0]`.",
            code = "def f():\n    \"\"\"Krótko.\n\n    Dłużej.\"\"\"\n\nprint(f.__doc__.splitlines()[0])",
            output = "Krótko.",
        ),
    ),
    cards(
        "u54l4",
        explain(
            "in zamiast wielu or",
            "Zamiast `x == \"a\" or x == \"b\"` napisz `x in (\"a\", \"b\")`. Uwaga: `x == \"a\" or \"b\"` " +
                "jest zawsze prawdziwe, bo samo `\"b\"` to niepusty, czyli prawdziwy napis.",
            code = "kolor = \"green\"\nprint(kolor in (\"red\", \"green\"))",
            output = "True",
        ),
        explain(
            "Pusta lista jest fałszywa",
            "Pusta lista, pusty napis i 0 są fałszywe, więc zamiast `if len(lista) == 0:` wystarczy " +
                "`if not lista:`. A `not (x < 0 or x > 10)` to czytelniej `0 <= x <= 10`.",
            code = "lista = []\nif not lista:\n    print(\"pusta\")",
            output = "pusta",
        ),
    ),
    cards(
        "u54l5",
        explain(
            "Kod po return",
            "Po wykonaniu `return` funkcja od razu się kończy – instrukcje zapisane za nim w tym samym " +
                "bloku nigdy się nie wykonają.",
            code = "def f():\n    return \"zero\"\n    print(\"koniec\")\n\nprint(f())",
            output = "zero",
        ),
    ),
)
