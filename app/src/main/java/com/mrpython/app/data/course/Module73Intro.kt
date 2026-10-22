package com.mrpython.app.data.course

internal val module73Intro = lesson(
    "u73l0", "Wprowadzenie: wielki finał",
    explain(
        "Ostatnia prosta",
        "To ostatni moduł kursu! Czekają łamigłówki łączące wszystko, czego się nauczyłeś, " +
            "a na koniec świętowanie tytułu Mistrza Pythona.",
        code = "dni = 365\nprint(f\"Ukończone dni: {dni}\")\nprint(dni // 7, dni % 7)",
        output = "Ukończone dni: 365\n52 1",
    ),
    explain(
        "Napisy i liczby",
        "Wiele łamigłówek to zabawa napisami: `join` skleja znaki, `isalnum()` odrzuca znaki " +
            "interpunkcyjne, a `[::-1]` odwraca napis – i mamy test palindromu.",
        code = "def pal(s):\n    s = \"\".join(c for c in s.lower() if c.isalnum())\n    return s == s[::-1]\nprint(pal(\"Kajak!\"), pal(\"kot\"))",
        output = "True False",
    ),
    explain(
        "Struktury danych",
        "`zip(*m)` zamienia wiersze z kolumnami, a podwójne wyrażenie listowe spłaszcza listę list.",
        code = "m = [[1, 2], [3, 4]]\nprint([list(r) for r in zip(*m)])\nprint([x for w in m for x in w])",
        output = "[[1, 3], [2, 4]]\n[1, 2, 3, 4]",
    ),
    explain(
        "Funkcje jako wartości",
        "Funkcje można trzymać na liście i wywoływać po kolei – tak powstaje prosty potok przetwarzania tekstu.",
        code = "kroki = [str.strip, str.lower, str.title]\nt = \"  mR pYTHON \"\nfor f in kroki:\n    t = f(t)\nprint(t)",
        output = "Mr Python",
    ),
    explain(
        "Wszystko naraz",
        "Najtrudniejsze zadania łączą kilka narzędzi, np. `Counter` i sortowanie z kluczem. " +
            "Rozbij zadanie na kroki i sprawdzaj wynik każdego z nich.",
        code = "from collections import Counter\nc = Counter(\"to be or not to be\".split())\nprint(sorted(c, key=lambda s: (-c[s], s))[:2])",
        output = "['be', 'to']",
    ),
    output(
        "print(\"kajak\" == \"kajak\"[::-1])",
        "True",
        "Odwrócony \"kajak\" to nadal \"kajak\", więc to palindrom.",
    ),
    output(
        "m = [[1], [2, 3]]\nprint([x for w in m for x in w])",
        "[1, 2, 3]",
        "Podwójne wyrażenie listowe spłaszcza listę list.",
    ),
)
