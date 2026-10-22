package com.mrpython.app.data.course

internal val module59Intro = lesson(
    "u59l0", "Wprowadzenie: średnie wyzwania",
    explain(
        "O czym są te wyzwania?",
        "Czekają cię łamigłówki z wyrażeń listowych, słowników, sortowania, rekurencji, generatorów " +
            "i klas. Zanim odpowiesz, przewiduj wynik w głowie krok po kroku – to najlepszy trening.",
    ),
    explain(
        "Wyrażenia listowe i słowniki",
        "`[w for w in dane if warunek]` buduje listę w jednej linii. W słowniku `d.get(k, 0)` zwraca " +
            "wartość domyślną, gdy klucza brak – idealne do liczenia wystąpień.",
        code = "d = {}\nfor z in \"abca\":\n    d[z] = d.get(z, 0) + 1\nprint(d)\nprint([x * x for x in range(4) if x % 2])",
        output = "{'a': 2, 'b': 1, 'c': 1}\n[1, 9]",
    ),
    explain(
        "Sortowanie z key",
        "`sorted(dane, key=funkcja)` porządkuje elementy według wyniku funkcji, np. `len`. " +
            "Sortowanie jest stabilne: elementy o równym kluczu zachowują swoją kolejność.",
        code = "slowa = [\"kot\", \"a\", \"pies\", \"ul\"]\nprint(sorted(slowa, key=len))",
        output = "['a', 'ul', 'kot', 'pies']",
    ),
    explain(
        "Rekurencja",
        "Funkcja rekurencyjna wywołuje samą siebie dla mniejszego problemu. Musi mieć warunek " +
            "stopu, inaczej nigdy się nie skończy.",
        code = "def silnia(n):\n    if n <= 1:\n        return 1\n    return n * silnia(n - 1)\n\nprint(silnia(4))",
        output = "24",
    ),
    explain(
        "Generatory i klasy",
        "`yield` oddaje kolejne wartości jedna po drugiej. W klasach metody specjalne, np. `__str__` " +
            "czy `__len__`, decydują, jak obiekt zachowa się w `print()` i `len()`.",
        code = "def g():\n    for i in range(3):\n        yield i * 10\n\nprint(list(g()))",
        output = "[0, 10, 20]",
    ),
    output(
        "print([c.upper() for c in \"ab\"])",
        "['A', 'B']",
        "Wyrażenie listowe zamienia każdą literę na wielką.",
    ),
    output(
        "def f(n):\n    if n == 0:\n        return 0\n    return n + f(n - 1)\n\nprint(f(3))",
        "6",
        "3 + 2 + 1 + 0 = 6.",
    ),
    choice(
        "Czego potrzebuje każda funkcja rekurencyjna?",
        listOf("Warunku stopu", "Pętli while", "Zmiennej globalnej", "Instrukcji yield"),
        0,
        "Bez warunku stopu funkcja wywoływałaby się bez końca.",
    ),
)
