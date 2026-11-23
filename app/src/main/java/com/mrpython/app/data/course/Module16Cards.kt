package com.mrpython.app.data.course

internal val module16Cards = listOf(
    cards(
        "u16l1",
        explain(
            "Parametry lambdy",
            "Lambda może mieć kilka parametrów po przecinku albo żadnego: `lambda: 0`. Po dwukropku " +
                "stoi jedno wyrażenie – nawet `a if warunek else b` – ale nigdy `return`.",
            code = "wiekszy = lambda a, b: a if a > b else b\nhej = lambda: \"hej\"\nprint(wiekszy(3, 8), hej())",
            output = "8 hej",
        ),
        explain(
            "Wywołanie od razu",
            "Lambdę można wywołać od razu, bez zapisywania w zmiennej: weź ją w nawias i dopisz " +
                "argumenty w drugim nawiasie.",
            code = "print((lambda x: x * 3)(5))",
            output = "15",
        ),
    ),
    cards(
        "u16l2",
        explain(
            "Własny klucz z lambdy",
            "Gdy elementy to pary albo słowniki, lambda wybiera, co porównywać, np. `key=lambda p: p[1]`. " +
                "`min()` i `max()` zwracają cały element, a nie sam klucz.",
            code = "pary = [(\"a\", 3), (\"b\", 1)]\nprint(max(pary, key=lambda p: p[1]))\nprint(min([-4, 2], key=abs))",
            output = "('a', 3)\n2",
        ),
        explain(
            "Odwrotna kolejność",
            "`reverse=True` sortuje od największego klucza. Liczby odwrócisz też kluczem z minusem: " +
                "`key=lambda x: -x`. Elementy z równym kluczem zostają w pierwotnej kolejności.",
            code = "print(sorted([\"bb\", \"a\", \"ccc\"], key=len, reverse=True))\nprint(sorted([5, 8, 2], key=lambda x: -x))",
            output = "['ccc', 'bb', 'a']\n[8, 5, 2]",
        ),
    ),
    cards(
        "u16l3",
        explain(
            "Napis na liczby",
            "Popularny trik: `split()` dzieli napis na kawałki, a `map(int, ...)` zamienia każdy na liczbę. " +
                "Na obiekcie map od razu działa `sum()`, bez `list()`.",
            code = "print(sum(map(int, \"3 4 5\".split())))",
            output = "12",
        ),
        explain(
            "map czy filter?",
            "`map()` zmienia każdy element – liczba elementów zostaje ta sama. `filter()` niczego " +
                "nie zmienia, tylko odrzuca elementy, dla których funkcja daje `False`.",
            code = "l = [1, 3]\nprint(list(map(lambda x: x > 2, l)))\nprint(list(filter(lambda x: x > 2, l)))",
            output = "[False, True]\n[3]",
        ),
    ),
    cards(
        "u16l4",
        explain(
            "Funkcja zwraca funkcję",
            "Funkcja może utworzyć i zwrócić nową funkcję, np. lambdę. Zwrócona funkcja pamięta " +
                "wartości, które miała przy tworzeniu – tu `n`.",
            code = "def dodawacz(n):\n    return lambda x: x + n\n\nplus2 = dodawacz(2)\nprint(plus2(5))",
            output = "7",
        ),
        explain(
            "Funkcje w słowniku",
            "Funkcje to zwykłe wartości, więc możesz trzymać je w liście albo słowniku. `ops[\"+\"]` " +
                "daje samą funkcję, a dopisane `(2, 3)` ją wywołuje.",
            code = "ops = {\"+\": lambda a, b: a + b, \"max\": max}\nprint(ops[\"+\"](2, 3), ops[\"max\"](2, 3))",
            output = "5 3",
        ),
    ),
    cards(
        "u16l5",
        explain(
            "Metoda jako klucz",
            "Jako `key` możesz podać metodę napisów, np. `str.lower`. Wtedy `sorted()` porównuje słowa " +
                "zapisane małymi literami, ale zwraca je w oryginalnej postaci.",
            code = "print(sorted([\"b\", \"C\", \"a\"]))\nprint(sorted([\"b\", \"C\", \"a\"], key=str.lower))",
            output = "['C', 'a', 'b']\n['a', 'b', 'C']",
        ),
        explain(
            "Lambda jak funkcja",
            "Parametry lambdy działają jak w `def`: mogą mieć wartości domyślne, a `*a` zbierze " +
                "dowolnie wiele argumentów w krotkę.",
            code = "f = lambda a, b=2: a * b\ng = lambda *a: sum(a)\nprint(f(5), g(1, 2, 3))",
            output = "10 6",
        ),
    ),
)
