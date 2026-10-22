package com.mrpython.app.data.course

internal val module62Intro = lesson(
    "u62l0", "Wprowadzenie: tydzień powtórek – struktury danych",
    explain(
        "Listy i krotki",
        "Ten tydzień to codzienne powtórki struktur danych. Zaczynamy od list: można je zmieniać " +
            "(`append`, `insert`, `remove`). Krotka `( )` wygląda podobnie, ale po utworzeniu jest niezmienna.",
        code = "a = [3, 1, 2]\na.append(4)\nt = (7, 8)\nprint(a, t[0])",
        output = "[3, 1, 2, 4] 7",
    ),
    explain(
        "Zbiory",
        "Zbiór `{ }` przechowuje elementy bez powtórzeń i bez kolejności. Świetnie nadaje się do " +
            "części wspólnej `&`, sumy `|` i różnicy `-`.",
        code = "a = {1, 2, 3}\nb = {2, 3, 4}\nprint(a & b, a | b)",
        output = "{2, 3} {1, 2, 3, 4}",
    ),
    explain(
        "Słowniki",
        "Słownik łączy klucze z wartościami. `d[k]` rzuca `KeyError`, gdy klucza brak, a `d.get(k, 0)` " +
            "zwraca wtedy wartość domyślną.",
        code = "d = {\"a\": 1}\nd[\"b\"] = 2\nprint(d.get(\"c\", 0), len(d))",
        output = "0 2",
    ),
    explain(
        "Zagnieżdżanie i wyrażenia listowe",
        "Struktury można zagnieżdżać: lista list to tabela, `m[1][0]` to wiersz 1, kolumna 0. " +
            "Wyrażenie listowe `[... for x in ...]` buduje nową listę w jednej linijce.",
        code = "m = [[1, 2], [3, 4]]\nprint(m[1][0])\nprint([x * 2 for x in m[0]])",
        output = "3\n[2, 4]",
    ),
    explain(
        "Moduł collections",
        "`Counter` liczy wystąpienia, `defaultdict` sam tworzy brakujące wartości, a `deque` to szybka " +
            "kolejka z obu stron. Dzień 7 jest właśnie o nich.",
        code = "from collections import Counter\nc = Counter(\"abaca\")\nprint(c[\"a\"], c.most_common(1))",
        output = "3 [('a', 3)]",
    ),
    choice(
        "Która struktura automatycznie usuwa powtórzenia?",
        listOf("zbiór", "lista", "krotka", "słownik z listą"),
        0,
        "Zbiór przechowuje każdy element tylko raz.",
    ),
    output(
        "d = {\"x\": 5}\nprint(d.get(\"y\", 1) + d[\"x\"])",
        "6",
        "Brak klucza \"y\", więc get zwraca 1, a 1 + 5 = 6.",
    ),
)
