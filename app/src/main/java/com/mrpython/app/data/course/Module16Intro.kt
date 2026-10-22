package com.mrpython.app.data.course

internal val module16Intro = lesson(
    "u16l0", "Wprowadzenie: lambda",
    explain(
        "Wyrażenie lambda",
        "`lambda` tworzy małą funkcję w jednej linii, bez `def` i bez nazwy. Po dwukropku jest jedno " +
            "wyrażenie – jego wynik zostaje zwrócony automatycznie, bez `return`.",
        code = "podwoj = lambda x: x * 2\nprint(podwoj(4))",
        output = "8",
    ),
    explain(
        "Parametr key",
        "`sorted()`, `min()` i `max()` przyjmują `key` – funkcję, której wynik służy do porównywania. " +
            "Np. `key=len` porównuje długości, a lambda może wybrać dowolną część elementu.",
        code = "slowa = [\"kiwi\", \"jabłko\", \"fig\"]\nprint(sorted(slowa, key=len))\nprint(max(slowa, key=len))",
        output = "['fig', 'kiwi', 'jabłko']\njabłko",
    ),
    explain(
        "map – zamień każdy",
        "`map(f, lista)` wywołuje funkcję `f` dla każdego elementu. Zwraca obiekt map, więc " +
            "zwykle zamieniamy go na listę przez `list()`.",
        code = "print(list(map(str, [1, 2])))\nprint(list(map(lambda x: x * 10, [1, 2])))",
        output = "['1', '2']\n[10, 20]",
    ),
    explain(
        "filter – zostaw pasujące",
        "`filter(f, lista)` zostawia tylko te elementy, dla których funkcja zwraca `True`. " +
            "To jak wyrażenie listowe z warunkiem `if`.",
        code = "print(list(filter(lambda x: x > 2, [1, 5, 2, 7])))",
        output = "[5, 7]",
    ),
    explain(
        "Funkcja jako wartość",
        "Funkcję można zapisać w zmiennej albo przekazać innej funkcji – bez nawiasów, bo `f` to " +
            "sama funkcja, a `f()` to jej wywołanie i wynik.",
        code = "def zastosuj(f, x):\n    return f(x)\n\nprint(zastosuj(abs, -7))",
        output = "7",
    ),
    output(
        "dodaj = lambda a, b: a + b\nprint(dodaj(2, 3))",
        "5",
        "Lambda zwraca sumę swoich dwóch argumentów.",
    ),
    choice(
        "Do czego służy parametr key w sorted()?",
        listOf(
            "Podaje funkcję, której wynik służy do porównywania",
            "Określa, ile elementów posortować",
            "Odwraca kolejność",
            "Usuwa duplikaty",
        ),
        0,
        "sorted porównuje wyniki funkcji key, a nie same elementy.",
    ),
    fill(
        "Uzupełnij, aby zostawić tylko niepuste napisy.",
        "s = [\"a\", \"\", \"b\"]\nprint(list(____(lambda x: x != \"\", s)))",
        listOf("filter", "map", "sorted"),
        "filter",
        "filter zostawia elementy, dla których lambda zwraca True.",
    ),
)
