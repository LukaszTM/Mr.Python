package com.mrpython.app.data.course

internal val module6Intro = lesson(
    "u6l0", "Wprowadzenie: funkcje",
    explain(
        "Własne polecenie",
        "Funkcja to nazwany kawałek kodu, który możesz uruchamiać wiele razy. Definiujesz ją słowem " +
            "`def`, nazwą, nawiasami i dwukropkiem. Wywołujesz ją, pisząc nazwę z nawiasami.",
        code = "def przywitaj():\n    print(\"Cześć!\")\n\nprzywitaj()\nprzywitaj()",
        output = "Cześć!\nCześć!",
    ),
    explain(
        "Parametry",
        "W nawiasach możesz podać parametry – dane, które funkcja dostaje przy wywołaniu. " +
            "Wartość przekazana przy wywołaniu to argument.",
        code = "def hej(imie):\n    print(\"Hej, \" + imie)\n\nhej(\"Ala\")\nhej(\"Ola\")",
        output = "Hej, Ala\nHej, Ola",
    ),
    explain(
        "Zwracanie wyniku",
        "`return` oddaje wynik do miejsca wywołania, więc można go zapisać w zmiennej albo dalej liczyć. " +
            "Kod po `return` już się nie wykona.",
        code = "def podwoj(x):\n    return x * 2\n\nwynik = podwoj(4)\nprint(wynik + 1)",
        output = "9",
    ),
    explain(
        "Wartości domyślne",
        "Parametr może mieć wartość domyślną, używaną, gdy nie podasz argumentu. Argumenty można też " +
            "podawać po nazwie, w dowolnej kolejności.",
        code = "def powitaj(imie=\"gościu\"):\n    return \"Hej, \" + imie\n\nprint(powitaj())\nprint(powitaj(imie=\"Kuba\"))",
        output = "Hej, gościu\nHej, Kuba",
    ),
    explain(
        "Zasięg i kilka wyników",
        "Zmienne utworzone w funkcji istnieją tylko w niej. Funkcja może zwrócić kilka wartości " +
            "po przecinku – rozpakujesz je do kilku zmiennych.",
        code = "def min_max(lista):\n    return min(lista), max(lista)\n\na, b = min_max([4, 9, 1])\nprint(a, b)",
        output = "1 9",
    ),
    choice(
        "Które słowo kluczowe zaczyna definicję funkcji?",
        listOf("def", "func", "return", "function"),
        0,
        "Funkcje w Pythonie definiujemy słowem def.",
    ),
    output(
        "def dodaj(a, b):\n    return a + b\n\nprint(dodaj(2, 5))",
        "7",
        "Funkcja zwraca sumę 2 + 5.",
    ),
    fill(
        "Uzupełnij, aby funkcja oddawała wynik.",
        "def kwadrat(x):\n    ____ x * x\n\nprint(kwadrat(3))",
        listOf("return", "print", "def"),
        "return",
        "return oddaje wynik funkcji.",
    ),
)
