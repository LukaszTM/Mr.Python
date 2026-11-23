package com.mrpython.app.data.course

internal val module43Intro = lesson(
    "u43l0", "Wprowadzenie: zasięg i domknięcia",
    explain(
        "Zasięg zmiennej",
        "Zasięg to miejsce, w którym nazwa jest widoczna. Zmienna utworzona w funkcji jest " +
            "lokalna: przesłania globalną tylko w środku funkcji i znika po jej zakończeniu.",
        code = "x = \"globalne\"\ndef f():\n    x = \"lokalne\"\n    print(x)\nf()\nprint(x)",
        output = "lokalne\nglobalne",
    ),
    explain(
        "Reguła LEGB",
        "Python szuka nazwy w kolejności: Local (funkcja), Enclosing (funkcja otaczająca), " +
            "Global (plik), Built-in (wbudowane, np. `len`). Bierze pierwszą znalezioną.",
        code = "x = 1\ndef zewn():\n    x = 2\n    def wew():\n        print(x)\n    wew()\nzewn()",
        output = "2",
    ),
    explain(
        "global i nonlocal",
        "Przypisanie w funkcji tworzy zmienną lokalną. Aby zmienić zmienną z pliku, piszemy " +
            "`global nazwa`, a aby zmienić zmienną funkcji otaczającej – `nonlocal nazwa`. Bez " +
            "tego `licznik += 1` da UnboundLocalError.",
        code = "licznik = 0\ndef dodaj():\n    global licznik\n    licznik += 1\ndodaj()\nprint(licznik)",
        output = "1",
    ),
    explain(
        "Domknięcia",
        "Domknięcie to funkcja wewnętrzna, która pamięta zmienne z miejsca, w którym powstała – " +
            "nawet po zakończeniu funkcji zewnętrznej. Tak budujemy „fabryki” funkcji.",
        code = "def mnoznik(n):\n    def f(x):\n        return x * n\n    return f\nrazy3 = mnoznik(3)\nprint(razy3(5))",
        output = "15",
    ),
    explain(
        "Pułapka pętli",
        "Lambdy tworzone w pętli pamiętają zmienną, a nie jej wartość – po pętli wszystkie widzą " +
            "ostatnią. Pomaga domyślny argument `i=i`, który zapisuje bieżącą wartość.",
        code = "fs = [lambda: i for i in range(3)]\nprint([f() for f in fs])\ngs = [lambda i=i: i for i in range(3)]\nprint([g() for g in gs])",
        output = "[2, 2, 2]\n[0, 1, 2]",
    ),
    choice(
        "Gdzie Python najpierw szuka nazwy użytej w funkcji?",
        listOf("W zasięgu lokalnym", "W zasięgu globalnym", "W nazwach wbudowanych", "W funkcji otaczającej"),
        0,
        "L w LEGB to Local – szukanie zaczyna się lokalnie.",
    ),
    output(
        "def dodawacz(n):\n    def f(x):\n        return x + n\n    return f\nplus2 = dodawacz(2)\nprint(plus2(10))",
        "12",
        "f pamięta n = 2 – to domknięcie.",
    ),
    fill(
        "Uzupełnij, aby wew zmieniała zmienną n funkcji zewn.",
        "def zewn():\n    n = 0\n    def wew():\n        ____ n\n        n += 1\n    wew()\n    print(n)\nzewn()",
        listOf("nonlocal", "global", "local", "def"),
        "nonlocal",
        "n należy do funkcji otaczającej, więc używamy nonlocal.",
    ),
)
