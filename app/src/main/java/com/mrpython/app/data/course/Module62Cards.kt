package com.mrpython.app.data.course

internal val module62Cards = listOf(
    cards(
        "u62l3",
        explain(
            "Różnica symetryczna ^",
            "`a ^ b` daje elementy, które są tylko w jednym z dwóch zbiorów – bez części wspólnej. " +
                "To to samo co `(a | b) - (a & b)`.",
            code = "a = {1, 2, 3}\nb = {3, 4}\nprint(sorted(a ^ b))",
            output = "[1, 2, 4]",
        ),
    ),
    cards(
        "u62l4",
        explain(
            "update – scalanie słowników",
            "`d.update(inny)` dopisuje do `d` pary z drugiego słownika. Istniejące klucze dostają nowe " +
                "wartości, a brakujące są dodawane na końcu.",
            code = "d = {\"a\": 1, \"b\": 2}\nd.update({\"b\": 9, \"c\": 3})\nprint(d)",
            output = "{'a': 1, 'b': 9, 'c': 3}",
        ),
        explain(
            "pop z wartością domyślną",
            "`d.pop(k)` przy braku klucza zgłasza `KeyError`. Z drugim argumentem `d.pop(k, domyslna)` " +
                "zwraca go zamiast błędu i niczego nie usuwa.",
            code = "d = {\"a\": 1}\nprint(d.pop(\"x\", 0), d)",
            output = "0 {'a': 1}",
        ),
        explain(
            "Krotka jako klucz",
            "Kluczem może być krotka, bo jest niezmienna (lista nie może). Przecinek tworzy krotkę nawet " +
                "bez nawiasów, więc `d[1, 2]` to to samo co `d[(1, 2)]`.",
            code = "d = {(0, 0): \"start\"}\nprint(d[0, 0])",
            output = "start",
        ),
    ),
    cards(
        "u62l7",
        explain(
            "Dodawanie Counterów",
            "Dwa `Counter`y można dodać przez `+` – liczniki przy tych samych kluczach się sumują. " +
                "Odejmowanie `-` odejmuje liczniki i usuwa klucze, którym zostało 0 lub mniej.",
            code = "from collections import Counter\na = Counter(\"aab\")\nb = Counter(\"abc\")\nprint(dict(a + b))\nprint(dict(a - b))",
            output = "{'a': 3, 'b': 2, 'c': 1}\n{'a': 1}",
        ),
    ),
)
