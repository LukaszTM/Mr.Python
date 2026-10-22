package com.mrpython.app.data.course

internal val module15Cards = listOf(
    cards(
        "u15l1",
        explain(
            "Kolejność parametrów",
            "Parametry z wartością domyślną muszą stać po tych bez niej: `def f(a, b=1)` jest dobrze, " +
                "a `def f(a=1, b)` to błąd. Podając argument po nazwie, zmienisz tylko wybrany parametr.",
            code = "def f(a, b=2, c=3):\n    print(a, b, c)\n\nf(1, c=9)",
            output = "1 2 9",
        ),
        explain(
            "Pułapka z listą: is None",
            "Domyślna lista powstaje raz, gdy Python wykonuje `def`, więc pamięta poprzednie wywołania. " +
                "Dlatego dajemy `None` i w środku sprawdzamy `if l is None:` – `is` sprawdza, czy to właśnie `None`.",
            code = "def dodaj(x, l=None):\n    if l is None:\n        l = []\n    l.append(x)\n    return l\nprint(dodaj(1), dodaj(2))",
            output = "[1] [2]",
        ),
    ),
    cards(
        "u15l2",
        explain(
            "Zwykłe parametry i *reszta",
            "Przed `*args` mogą stać zwykłe parametry. Najpierw one dostają argumenty, a reszta trafia " +
                "do krotki – czasem pustej. Nazwa `args` to tylko zwyczaj, ważna jest gwiazdka.",
            code = "def f(a, *reszta):\n    print(a, reszta)\n\nf(1, 2, 3)\nf(4)",
            output = "1 (2, 3)\n4 ()",
        ),
    ),
    cards(
        "u15l3",
        explain(
            "*args i **kwargs razem",
            "Funkcja może mieć oba naraz: argumenty bez nazwy trafią do krotki, a nazwane – do słownika. " +
                "`**kwargs` stoi zawsze na końcu i nie przyjmie argumentu bez nazwy (to `TypeError`).",
            code = "def f(a, *args, **kw):\n    print(a, args, kw)\n\nf(1, 2, x=3)",
            output = "1 (2,) {'x': 3}",
        ),
        explain(
            "kwargs to zwykły słownik",
            "Na `kwargs` działa wszystko, co znasz ze słowników: `get()`, `items()`, `len()`. " +
                "`list(slownik)` daje listę jego kluczy.",
            code = "def f(**k):\n    print(list(k), k.get(\"tryb\", \"brak\"))\n\nf(a=1, b=2)",
            output = "['a', 'b'] brak",
        ),
    ),
    cards(
        "u15l4",
        explain(
            "Rozpakowanie w print()",
            "`print(*lista)` działa tak, jakbyś podał elementy osobno, więc wypisze je bez nawiasów. " +
                "Gwiazdka działa też dla napisu i krotki, a `sep` ustala separator.",
            code = "print(*[1, 2, 3])\nprint(*\"ab\", sep=\"-\")",
            output = "1 2 3\na-b",
        ),
        explain(
            "Argumenty muszą pasować",
            "Rozpakowanie można łączyć ze zwykłymi argumentami: `f(1, *[2, 3])`. Elementów musi być " +
                "tyle, ile parametrów – inaczej `TypeError`. Ten sam błąd daje parametr po samotnej `*` podany bez nazwy.",
            code = "def f(a, b, c):\n    print(a + b + c)\n\nf(1, *[2, 3])",
            output = "6",
        ),
    ),
    cards(
        "u15l5",
        explain(
            "Pełna kolejność parametrów",
            "Gdy łączysz wszystkie rodzaje parametrów, kolejność jest stała: zwykłe, z wartością " +
                "domyślną, `*args`, a na samym końcu `**kwargs`.",
            code = "def f(a, b=1, *args, **kw):\n    print(a, b, args, kw)\n\nf(5)",
            output = "5 1 () {}",
        ),
    ),
)
