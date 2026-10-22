package com.mrpython.app.data.course

internal val module68Cards = listOf(
    cards(
        "u68l1",
        explain(
            "Moduł string",
            "Moduł `string` ma gotowe zestawy znaków: `string.punctuation` to znaki interpunkcyjne, " +
                "`string.digits` – cyfry, a `string.ascii_letters` – litery a–z i A–Z.",
            code = "import string\nprint(string.digits)\nprint(\"?\" in string.punctuation)",
            output = "0123456789\nTrue",
        ),
        explain(
            "maketrans i translate",
            "`str.maketrans(\"ąę\", \"ae\")` tworzy tabelę zamian znak na znak, a `translate` ją stosuje. " +
                "Trzeci argument `maketrans` to znaki do usunięcia.",
            code = "tab = str.maketrans(\"ąę\", \"ae\")\nprint(\"gęś\".translate(tab))\nusun = str.maketrans(\"\", \"\", \",!\")\nprint(\"Tak, ja!\".translate(usun))",
            output = "geś\nTak ja",
        ),
        explain(
            "strip z argumentem",
            "`strip(\".!\")` usuwa podane znaki z obu końców napisu, a nie tylko spacje. " +
                "`lstrip` czyści tylko lewą stronę, a `rstrip` – prawą.",
            code = "print(\"...Hej!!!\".strip(\".!\"))\nprint(\"!!tak!!\".lstrip(\"!\"))",
            output = "Hej\ntak!!",
        ),
    ),
    cards(
        "u68l2",
        explain(
            "Dopisywanie: update",
            "`update` dolicza do `Counter` nowe elementy – zwiększa liczniki, zamiast je nadpisywać " +
                "(w zwykłym słowniku `update` by nadpisało wartości).",
            code = "from collections import Counter\nc = Counter([\"kot\"])\nc.update([\"kot\", \"pies\"])\nprint(c)",
            output = "Counter({'kot': 2, 'pies': 1})",
        ),
    ),
    cards(
        "u68l4",
        explain(
            "Moduł statistics",
            "Moduł `statistics` liczy statystyki za nas: `mean` to średnia, `median` – mediana " +
                "(środkowa wartość), a `mode` – wartość występująca najczęściej.",
            code = "from statistics import mean, median, mode\nd = [3, 2, 4, 3]\nprint(mean(d), median(d), mode(d))",
            output = "3 3.0 3",
        ),
    ),
)
