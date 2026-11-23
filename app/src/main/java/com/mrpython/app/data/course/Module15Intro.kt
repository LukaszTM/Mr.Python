package com.mrpython.app.data.course

internal val module15Intro = lesson(
    "u15l0", "Wprowadzenie: parametry funkcji",
    explain(
        "Wartości domyślne",
        "Parametr może mieć wartość domyślną: `imie=\"gość\"`. Jeśli nie podasz argumentu, Python " +
            "użyje tej wartości. Uwaga: jako domyślną wartość zamiast `[]` daj `None` – lista powstaje tylko raz.",
        code = "def witaj(imie=\"gość\"):\n    print(\"Cześć,\", imie)\n\nwitaj()\nwitaj(\"Ola\")",
        output = "Cześć, gość\nCześć, Ola",
    ),
    explain(
        "Dowolnie wiele: *args",
        "Gwiazdka przed parametrem (`*liczby`) zbiera wszystkie podane argumenty w krotkę. " +
            "Dzięki temu funkcję można wywołać z dowolną liczbą wartości – nawet z zerową.",
        code = "def suma(*liczby):\n    print(liczby)\n    return sum(liczby)\n\nprint(suma(1, 2, 3))",
        output = "(1, 2, 3)\n6",
    ),
    explain(
        "Argumenty nazwane: **kwargs",
        "Dwie gwiazdki (`**dane`) zbierają argumenty podane z nazwą, np. `kolor=\"red\"`, w słownik. " +
            "Klucze to nazwy argumentów, a wartości – to, co do nich przypisano.",
        code = "def profil(**dane):\n    print(dane)\n\nprofil(imie=\"Ala\", wiek=7)",
        output = "{'imie': 'Ala', 'wiek': 7}",
    ),
    explain(
        "Tylko z nazwą",
        "Parametry zapisane po samej gwiazdce `*` trzeba podawać z nazwą, np. `b=2`. " +
            "To chroni przed pomyleniem kolejności argumentów.",
        code = "def f(a, *, b):\n    print(a + b)\n\nf(1, b=2)",
        output = "3",
    ),
    explain(
        "Rozpakowywanie",
        "Przy wywołaniu działa to odwrotnie: `*lista` rozkłada listę na osobne argumenty, " +
            "a `**slownik` – na argumenty nazwane.",
        code = "def f(x, y):\n    print(x - y)\n\nf(*[5, 1])\nf(**{\"y\": 2, \"x\": 9})",
        output = "4\n7",
    ),
    output(
        "def potega(x, n=2):\n    return x ** n\n\nprint(potega(3))",
        "9",
        "Bez drugiego argumentu n wynosi 2, więc 3 ** 2 = 9.",
    ),
    choice(
        "Jakiego typu jest args w funkcji def f(*args)?",
        listOf("Krotka", "Lista", "Słownik", "Napis"),
        0,
        "*args zbiera argumenty w krotkę.",
    ),
    fill(
        "Uzupełnij, aby funkcja zbierała argumenty nazwane w słownik.",
        "def ustaw(____opcje):\n    print(opcje)\n\nustaw(kolor=\"red\")",
        listOf("**", "*", "&"),
        "**",
        "Dwie gwiazdki zbierają argumenty nazwane w słownik.",
    ),
)
