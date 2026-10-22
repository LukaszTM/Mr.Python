package com.mrpython.app.data.course

internal val module59Cards = listOf(
    cards(
        "u59l2",
        explain(
            "setdefault – wstaw, gdy brak",
            "`d.setdefault(k, domyslna)` zwraca wartość klucza `k`, a gdy klucza nie ma, najpierw go " +
                "wstawia z wartością domyślną. Dlatego `d.setdefault(k, []).append(x)` grupuje elementy w listach.",
            code = "d = {}\nd.setdefault(\"a\", []).append(1)\nd.setdefault(\"a\", []).append(2)\nprint(d)",
            output = "{'a': [1, 2]}",
        ),
        explain(
            "True to 1 jako klucz",
            "`True == 1` i `False == 0`, więc w słowniku to ten sam klucz: drugi wpis nadpisze wartość, " +
                "ale zostanie pierwszy zapis klucza. W zbiorze `{0, False}` jest tylko jeden element.",
            code = "d = {0: \"zero\", False: \"fałsz\"}\nprint(d)\nprint(len({0, False}))",
            output = "{0: 'fałsz'}\n1",
        ),
    ),
    cards(
        "u59l6",
        explain(
            "__bool__ i prawdziwość",
            "Metoda `__bool__` decyduje, czy obiekt jest prawdziwy w `if` i `bool()`. Gdy jej brak, " +
                "Python sprawdza `__len__` – długość 0 to fałsz. Bez obu metod obiekt jest zawsze prawdziwy.",
            code = "class Skrzynka:\n    def __init__(self, n):\n        self.n = n\n    def __bool__(self):\n        return self.n > 0\nprint(bool(Skrzynka(0)), bool(Skrzynka(2)))",
            output = "False True",
        ),
    ),
    cards(
        "u59l7",
        explain(
            "filter z None",
            "`filter(None, dane)` zamiast funkcji sprawdza samą prawdziwość elementów: zostają tylko " +
                "prawdziwe. Odpadają `0`, `\"\"`, `None` i puste listy.",
            code = "print(list(filter(None, [3, 0, \"\", \"x\", None])))",
            output = "[3, 'x']",
        ),
        explain(
            "Odwracanie zip(*...)",
            "Gwiazdka `*` rozkłada listę na osobne argumenty, więc `zip(*pary)` to `zip(pary[0], pary[1], ...)`. " +
                "Tak z listy par dostajesz osobno pierwsze i drugie elementy.",
            code = "pary = [(1, \"a\"), (2, \"b\"), (3, \"c\")]\nprint(list(zip(*pary)))",
            output = "[(1, 2, 3), ('a', 'b', 'c')]",
        ),
        explain(
            "sum z wartością startową",
            "`sum(dane, start)` zaczyna liczyć od `start`, a nie od 0. Gdy start to `[]`, `sum` skleja " +
                "listy, bo `+` łączy listy.",
            code = "print(sum([1, 2], 10))\nprint(sum([[1, 2], [3]], []))",
            output = "13\n[1, 2, 3]",
        ),
    ),
)
