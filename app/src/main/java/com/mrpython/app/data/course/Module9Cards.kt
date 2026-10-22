package com.mrpython.app.data.course

internal val module9Cards = listOf(
    cards(
        "u9l1",
        explain(
            "Łączenie i wycinki krotek",
            "Krotki łączysz znakiem `+`, a `*` powtarza ich elementy – zawsze powstaje nowa krotka. " +
                "Wycinek krotki też jest krotką, a `in` sprawdza, czy element jest w krotce.",
            code = "t = (1, 2) + (3,)\nprint(t)\nprint(t[1:])\nprint(3 in t)",
            output = "(1, 2, 3)\n(2, 3)\nTrue",
        ),
        explain(
            "Ile zmiennych?",
            "Przy rozpakowaniu liczba zmiennych musi się zgadzać z liczbą elementów – inaczej będzie błąd. " +
                "Rozpakować można też napis: każda zmienna dostaje jeden znak.",
            code = "a, b = \"ok\"\nprint(b)\nx, y, z = (1, 2, 3)\nprint(z)",
            output = "k\n3",
        ),
        explain(
            "Nawias to nie krotka",
            "Sam nawias nie tworzy krotki: `(5)` to zwykła liczba 5. Krotkę tworzy przecinek: `(5,)`. " +
                "Funkcja `tuple()` zamienia listę na krotkę.",
            code = "print((5) + 1)\nprint(tuple([1, 2]))",
            output = "6\n(1, 2)",
        ),
    ),
    cards(
        "u9l2",
        explain(
            "Tworzenie zbioru: set()",
            "Puste `{}` to słownik, więc pusty zbiór tworzymy przez `set()`. `set()` z listy albo napisu " +
                "zostawia tylko różne elementy.",
            code = "s = set()\ns.add(4)\nprint(s)\nprint(len(set(\"abba\")))",
            output = "{4}\n2",
        ),
        explain(
            "Zbiór nie ma kolejności",
            "Elementy zbioru nie mają pozycji, więc `s[0]` kończy się błędem. Po zbiorze można przejść " +
                "pętlą, a `sorted(s)` zwraca posortowaną listę.",
            code = "s = {3, 1, 2}\nprint(sorted(s))",
            output = "[1, 2, 3]",
        ),
        explain(
            "Usuwanie ze zbioru",
            "`remove(x)` usuwa element `x` ze zbioru.",
            code = "s = {1, 2, 3}\ns.remove(2)\nprint(s)",
            output = "{1, 3}",
        ),
    ),
    cards(
        "u9l3",
        explain(
            "Podzbiór: <=",
            "`a <= b` sprawdza, czy każdy element zbioru `a` jest też w `b`, czyli czy `a` jest podzbiorem `b`.",
            code = "a = {1, 2}\nb = {1, 2, 3}\nprint(a <= b)\nprint(b <= a)",
            output = "True\nFalse",
        ),
        explain(
            "Pusty wynik: set()",
            "Gdy działanie nie zostawi żadnego elementu, Python wypisze pusty zbiór jako `set()`. " +
                "Zbiorów nie łączy się znakiem `+` – do tego służy `|`, także kilka razy z rzędu.",
            code = "print({1, 2} & {3})\nprint({1} | {2} | {3})",
            output = "set()\n{1, 2, 3}",
        ),
    ),
    cards(
        "u9l4",
        explain(
            "Krotka zmieniona w listę",
            "Krotki nie zmienisz, ale `list(t)` zrobi z niej listę, którą już można zmieniać. Krotki mają " +
                "metodę `count()`, a `==` porównuje je element po elemencie.",
            code = "t = (1, 2, 1)\nprint(t.count(1))\nx = list(t)\nx.append(5)\nprint(x)\nprint((1, 2) == (1, 2))",
            output = "2\n[1, 2, 1, 5]\nTrue",
        ),
    ),
)
