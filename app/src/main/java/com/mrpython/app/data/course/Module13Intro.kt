package com.mrpython.app.data.course

internal val module13Intro = lesson(
    "u13l0", "Wprowadzenie: wyrażenia listowe",
    explain(
        "Lista w jednej linii",
        "Wyrażenie listowe to skrót pętli, która buduje listę. Zapis `[x * 2 for x in liczby]` znaczy: " +
            "„dla każdego x z liczby weź x * 2”. Wynik jest taki sam jak przy pętli z `append()`.",
        code = "wynik = []\nfor x in range(4):\n    wynik.append(x * 2)\nprint(wynik)\nprint([x * 2 for x in range(4)])",
        output = "[0, 2, 4, 6]\n[0, 2, 4, 6]",
    ),
    explain(
        "Filtrowanie: if na końcu",
        "`if` dopisany na końcu przepuszcza do listy tylko elementy spełniające warunek.",
        code = "print([x for x in range(10) if x % 3 == 0])\nzw = [\"kot\", \"pies\", \"mysz\"]\nprint([s for s in zw if len(s) > 3])",
        output = "[0, 3, 6, 9]\n['pies', 'mysz']",
    ),
    explain(
        "Wybór: if-else na początku",
        "Gdy każdy element ma trafić do listy, ale w różnej postaci, użyj `a if warunek else b` " +
            "przed słowem `for`.",
        code = "print([0 if x < 0 else x for x in [4, -2, 3]])",
        output = "[4, 0, 3]",
    ),
    explain(
        "Wyrażenia zagnieżdżone",
        "Można użyć dwóch `for` – pierwszy jest pętlą zewnętrzną. Tak spłaszczysz listę list. " +
            "Wyrażenie w wyrażeniu tworzy z kolei listę list, np. macierz.",
        code = "m = [[1, 2], [3, 4]]\nprint([x for w in m for x in w])\nprint([[0] * 3 for _ in range(2)])",
        output = "[1, 2, 3, 4]\n[[0, 0, 0], [0, 0, 0]]",
    ),
    explain(
        "Słowniki i zbiory",
        "W klamrach z dwukropkiem `{klucz: wartość for ...}` powstaje słownik, a w klamrach " +
            "bez dwukropka – zbiór, w którym powtórzenia znikają.",
        code = "print({x: x * x for x in range(3)})\nprint({x % 3 for x in range(10)})",
        output = "{0: 0, 1: 1, 2: 4}\n{0, 1, 2}",
    ),
    output(
        "print([x + 10 for x in range(3)])",
        "[10, 11, 12]",
        "Każda liczba z range(3) zwiększona o 10.",
    ),
    fill(
        "Uzupełnij, aby zostawić tylko liczby większe od 2.",
        "print([x for x in range(5) ____ x > 2])",
        listOf("if", "for", "else"),
        "if",
        "if na końcu filtruje elementy.",
    ),
    choice(
        "Co tworzy wyrażenie {s: len(s) for s in slowa}?",
        listOf("Słownik", "Listę", "Zbiór", "Krotkę"),
        0,
        "Klamry z dwukropkiem tworzą słownik.",
    ),
)
