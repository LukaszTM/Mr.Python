package com.mrpython.app.data.course

internal val module72Cards = listOf(
    cards(
        "u72l2",
        explain(
            "discard i ^ w zbiorach",
            "`discard(x)` usuwa element ze zbioru, a gdy go nie ma – nic się nie dzieje (`remove` dałby błąd). " +
                "`a ^ b` to różnica symetryczna: elementy tylko z jednego zbioru.",
            code = "s = {1, 2, 3}\ns.discard(7)\ns.discard(1)\nprint(s)\nprint({1, 2} ^ {2, 3})",
            output = "{2, 3}\n{1, 3}",
        ),
        explain(
            "Łączenie słowników: |",
            "`a | b` tworzy nowy słownik z kluczy obu. Przy powtórzonym kluczu wygrywa wartość " +
                "z prawego słownika.",
            code = "a = {\"x\": 1, \"y\": 2}\nb = {\"y\": 9}\nprint(a | b)",
            output = "{'x': 1, 'y': 9}",
        ),
    ),
    cards(
        "u72l5",
        explain(
            "Klucz z itemgetter",
            "`itemgetter(\"wiek\")` z modułu `operator` tworzy funkcję, która z każdego elementu bierze " +
                "pole `\"wiek\"` – działa jak `lambda d: d[\"wiek\"]` i świetnie pasuje do `key=`.",
            code = "from operator import itemgetter\nludzie = [{\"imie\": \"Ola\", \"wiek\": 30},\n          {\"imie\": \"Jan\", \"wiek\": 17}]\nfor o in sorted(ludzie, key=itemgetter(\"wiek\")):\n    print(o[\"imie\"])",
            output = "Jan\nOla",
        ),
    ),
    cards(
        "u72l6",
        explain(
            "Pamięć wyników: @cache",
            "`@cache` z `functools` to prostsza wersja `@lru_cache` bez limitu: zapamiętuje wynik " +
                "dla każdego argumentu, więc drugie wywołanie nic nie liczy.",
            code = "from functools import cache\n@cache\ndef kw(x):\n    print(\"liczę\", x)\n    return x * x\nprint(kw(3) + kw(3))",
            output = "liczę 3\n18",
        ),
    ),
)
