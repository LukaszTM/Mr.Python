package com.mrpython.app.data.course

internal val module63Intro = lesson(
    "u63l0", "Wprowadzenie: tydzień powtórek – funkcje",
    explain(
        "Parametry i return",
        "W tym tygodniu powtarzamy funkcje. Parametr może mieć wartość domyślną, a `return` oddaje " +
            "wynik. Uwaga: nie używaj listy jako wartości domyślnej – lepiej `None`.",
        code = "def opis(imie, wiek=18):\n    return f\"{imie}:{wiek}\"\nprint(opis(\"Ola\"))\nprint(opis(\"Jan\", 30))",
        output = "Ola:18\nJan:30",
    ),
    explain(
        "*args i **kwargs",
        "`*args` zbiera dowolnie wiele argumentów pozycyjnych w krotkę, a `**kwargs` argumenty " +
            "nazwane w słownik. Dzięki temu funkcja przyjmie ich tyle, ile podasz.",
        code = "def f(*args, **kwargs):\n    print(args, kwargs)\nf(1, 2, x=3)",
        output = "(1, 2) {'x': 3}",
    ),
    explain(
        "Lambda",
        "`lambda` to krótka, anonimowa funkcja w jednej linijce. Najczęściej podajemy ją jako `key=` " +
            "do `sorted`, `max` czy `min`.",
        code = "slowa = [\"bbb\", \"a\", \"cc\"]\nprint(sorted(slowa, key=lambda s: len(s)))",
        output = "['a', 'cc', 'bbb']",
    ),
    explain(
        "Rekurencja",
        "Funkcja rekurencyjna wywołuje samą siebie dla mniejszego problemu. Zawsze potrzebuje " +
            "warunku bazowego, który kończy wywołania.",
        code = "def silnia(n):\n    if n <= 1:\n        return 1\n    return n * silnia(n - 1)\nprint(silnia(5))",
        output = "120",
    ),
    explain(
        "Domknięcia i dekoratory",
        "Domknięcie to funkcja wewnętrzna, która pamięta zmienne funkcji zewnętrznej (do zmiany służy " +
            "`nonlocal`). Dekorator `@` to funkcja, która opakowuje inną i zmienia jej działanie.",
        code = "def glosno(f):\n    return lambda x: f(x).upper()\n@glosno\ndef hej(x): return \"hej \" + x\nprint(hej(\"ola\"))",
        output = "HEJ OLA",
    ),
    output(
        "def suma(*liczby):\n    return sum(liczby)\nprint(suma(1, 2, 3))",
        "6",
        "*liczby zbiera argumenty w krotkę (1, 2, 3), a jej suma to 6.",
    ),
    choice(
        "Czego potrzebuje każda funkcja rekurencyjna, aby się zakończyć?",
        listOf("warunku bazowego", "pętli while", "dekoratora", "argumentu *args"),
        0,
        "Warunek bazowy zatrzymuje kolejne wywołania.",
    ),
)
