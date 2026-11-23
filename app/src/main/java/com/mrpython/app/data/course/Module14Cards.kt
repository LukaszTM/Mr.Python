package com.mrpython.app.data.course

internal val module14Cards = listOf(
    cards(
        "u14l1",
        explain(
            "Zmiana w macierzy",
            "Dwa indeksy pozwalają zmienić jeden element: `m[0][1] = 9`. `len(m)` to liczba wierszy, " +
                "a `len(m[0])` – liczba elementów w wierszu, czyli kolumn.",
            code = "m = [[1, 2], [3, 4], [5, 6]]\nm[0][1] = 9\nprint(m[0])\nprint(len(m), len(m[0]))",
            output = "[1, 9]\n3 2",
        ),
        explain(
            "Kolumna i indeksy ujemne",
            "Aby wziąć kolumnę, wybierz ten sam indeks z każdego wiersza, np. wyrażeniem listowym. " +
                "Indeksy ujemne też działają: `m[-1][-1]` to ostatni element ostatniego wiersza.",
            code = "m = [[1, 2], [3, 4]]\nprint([w[0] for w in m])\nprint(m[-1][-1])",
            output = "[1, 3]\n4",
        ),
    ),
    cards(
        "u14l2",
        explain(
            "Wybieranie rekordów",
            "Na liście słowników działają pętle i wyrażenia listowe: z każdego rekordu bierzesz " +
                "potrzebną wartość, a `if` zostawia tylko pasujące rekordy.",
            code = "p = [{\"n\": \"Ala\", \"w\": 9}, {\"n\": \"Jan\", \"w\": 30}]\nprint([o[\"n\"] for o in p if o[\"w\"] > 18])",
            output = "['Jan']",
        ),
        explain(
            "Zmiana rekordów w pętli",
            "Zmienna pętli wskazuje ten sam słownik, który leży w liście, więc `o[\"pkt\"] += 1` zmienia " +
                "rekord w liście. Pamiętaj: najpierw indeks listy, potem klucz – `osoby[\"imie\"]` to błąd.",
            code = "p = [{\"pkt\": 1}, {\"pkt\": 5}]\nfor o in p:\n    o[\"pkt\"] += 1\nprint(p)",
            output = "[{'pkt': 2}, {'pkt': 6}]",
        ),
    ),
    cards(
        "u14l3",
        explain(
            "Grupowanie w słowniku list",
            "Częsty wzorzec: jeśli klucza jeszcze nie ma, tworzymy dla niego pustą listę, a potem " +
                "dopisujemy do niej element. Tak dzielimy dane na grupy.",
            code = "g = {}\nfor n in [1, 2, 3]:\n    if n % 2 not in g:\n        g[n % 2] = []\n    g[n % 2].append(n)\nprint(g)",
            output = "{1: [1, 3], 0: [2]}",
        ),
    ),
    cards(
        "u14l4",
        explain(
            "Inne kopie płytkie",
            "Kopię płytką listy zrobisz też wycinkiem `a[:]` albo funkcją `list(a)`. Słowniki również " +
                "mają metodę `copy()`. Wszystkie te sposoby kopiują tylko poziom zewnętrzny.",
            code = "a = [1, 2]\nb = a[:]\nc = list(a)\nb.append(3)\nprint(a, b, c)",
            output = "[1, 2] [1, 2, 3] [1, 2]",
        ),
        explain(
            "Pułapka: lista razy 2",
            "`[[0] * 2] * 2` nie tworzy dwóch wierszy, tylko dwa razy wskazuje tę samą listę – zmiana " +
                "jednego wiersza zmienia oba. Niezależne wiersze twórz wyrażeniem listowym.",
            code = "m = [[0] * 2] * 2\nm[0][0] = 1\nprint(m)\nok = [[0] * 2 for _ in range(2)]\nok[0][0] = 1\nprint(ok)",
            output = "[[1, 0], [1, 0]]\n[[1, 0], [0, 0]]",
        ),
        explain(
            "Moduł copy",
            "Funkcja `deepcopy` jest w module `copy`, więc najpierw piszemy `import copy`, a potem " +
                "`copy.deepcopy(...)`. Kopia głęboka działa też dla słowników z listami w środku.",
            code = "import copy\na = {\"x\": [1]}\nb = copy.deepcopy(a)\nb[\"x\"].append(2)\nprint(a)",
            output = "{'x': [1]}",
        ),
    ),
)
