package com.mrpython.app.data.course

internal val module22Cards = listOf(
    cards(
        "u22l1",
        explain(
            "Co daje enumerate?",
            "`enumerate()` tworzy krotki (indeks, element) – zobaczysz je po zamianie przez `list()`. " +
                "Gdy w pętli podasz jedną zmienną, dostanie całą krotkę. Działa też na napisach.",
            code = "print(list(enumerate(\"ab\")))\nfor x in enumerate([\"a\"]):\n    print(x)",
            output = "[(0, 'a'), (1, 'b')]\n(0, 'a')",
        ),
    ),
    cards(
        "u22l2",
        explain(
            "Podgląd i trzy listy",
            "`zip()` – podobnie jak `map()` – zwraca specjalny obiekt, więc pary podejrzysz przez `list()`. " +
                "Możesz połączyć też trzy listy albo napisy: powstaną trójki.",
            code = "print(list(zip([1, 2], [3, 4], [5, 6])))\nprint(list(zip(\"ab\", \"cd\")))",
            output = "[(1, 3, 5), (2, 4, 6)]\n[('a', 'c'), ('b', 'd')]",
        ),
    ),
    cards(
        "u22l3",
        explain(
            "Zawsze wychodzi lista",
            "`sorted()` przyjmuje napis, krotkę czy słownik i zawsze zwraca listę. Dla napisu – listę liter, " +
                "dla słownika – posortowane klucze. Litery skleisz z powrotem przez `\"\".join()`.",
            code = "print(sorted(\"kot\"))\nprint(sorted({\"b\": 2, \"a\": 1}))\nprint(\"\".join(sorted(\"lato\")))",
            output = "['k', 'o', 't']\n['a', 'b']\nalot",
        ),
        explain(
            "reversed i list()",
            "`reversed()` też zwraca specjalny obiekt, a nie listę. Żeby zobaczyć wynik, użyj `list()`, " +
                "a dla napisu – `\"\".join()`.",
            code = "print(list(reversed(\"abc\")))\nprint(\"\".join(reversed(\"kot\")))",
            output = "['c', 'b', 'a']\ntok",
        ),
    ),
    cards(
        "u22l4",
        explain(
            "Bez warunku",
            "`any()` i `all()` działają na dowolnych wartościach, nie tylko na `True` i `False`. " +
                "Zero, pusty napis i `None` liczą się jako fałsz, a reszta – jako prawda.",
            code = "print(all([\"kot\", \"\", \"pies\"]))\nprint(any([0, 0, 3]))",
            output = "False\nTrue",
        ),
        explain(
            "Pusta lista",
            "Dla pustej listy `any([])` daje `False` – nie ma żadnego prawdziwego elementu. " +
                "Za to `all([])` daje `True`, bo nie ma ani jednego fałszywego.",
            code = "print(any([]), all([]))",
            output = "False True",
        ),
    ),
    cards(
        "u22l5",
        explain(
            "Rozpakowanie w nawiasie",
            "`enumerate(zip(...))` daje pary (numer, krotka). Żeby od razu rozpakować środek, " +
                "w pętli piszemy nawias: `for i, (a, b) in ...`.",
            code = "for i, (a, b) in enumerate(zip(\"xy\", [1, 2])):\n    print(i, a, b)",
            output = "0 x 1\n1 y 2",
        ),
        explain(
            "Sortowanie krotek",
            "Krotki porównuje się element po elemencie: najpierw pierwszy, a przy remisie drugi. " +
                "Dlatego `sorted()` listy par układa je według pierwszych elementów.",
            code = "print(sorted([(2, \"b\"), (1, \"z\"), (2, \"a\")]))",
            output = "[(1, 'z'), (2, 'a'), (2, 'b')]",
        ),
    ),
)
