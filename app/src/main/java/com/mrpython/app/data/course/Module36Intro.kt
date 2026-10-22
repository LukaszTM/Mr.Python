package com.mrpython.app.data.course

internal val module36Intro = lesson(
    "u36l0", "Wprowadzenie: projekt konto bankowe",
    explain(
        "O czym jest ten projekt",
        "W tym module krok po kroku zbudujesz klasę `Konto`: wpłaty, wypłaty z walidacją, historię " +
            "operacji, przelewy i ładny opis konta. Wykorzystasz wszystko, czego nauczyłeś się o klasach.",
        code = "class Konto:\n    def __init__(self, wlasciciel):\n        self.wlasciciel = wlasciciel\n        self.saldo = 0\n\nk = Konto(\"Ala\")\nprint(k.wlasciciel, k.saldo)",
        output = "Ala 0",
    ),
    explain(
        "Stan i metody",
        "Stan konta (saldo) ustawiamy w `__init__`, a zmieniamy metodami, np. `wplac()`. " +
            "Każdy obiekt ma własny stan, więc dwa konta nie mieszają sobie pieniędzy.",
        code = "class Konto:\n    def __init__(self):\n        self.saldo = 0\n    def wplac(self, kwota):\n        self.saldo += kwota\n\nk = Konto()\nk.wplac(100)\nk.wplac(50)\nprint(k.saldo)",
        output = "150",
    ),
    explain(
        "Walidacja wyjątkami",
        "Metoda powinna odrzucać złe dane: ujemną wpłatę albo wypłatę większą niż saldo. " +
            "Zamiast samego `print` zgłoś wyjątek – kod wywołujący sam zdecyduje, co z nim zrobić.",
        code = "class Konto:\n    def __init__(self, saldo):\n        self.saldo = saldo\n    def wyplac(self, kwota):\n        if kwota > self.saldo:\n            raise ValueError(\"za mało\")\n        self.saldo -= kwota\n\ntry:\n    Konto(10).wyplac(50)\nexcept ValueError as e:\n    print(e)",
        output = "za mało",
    ),
    explain(
        "Historia i przelewy",
        "Listę historii tworzymy w `__init__`, żeby każde konto miało własną, i dopisujemy do niej " +
            "krotki przez `append()`. Przelew to metoda, która dostaje drugi obiekt `Konto` i zmienia oba salda.",
        code = "class Konto:\n    def __init__(self, saldo):\n        self.saldo = saldo\n    def przelej(self, cel, kwota):\n        self.saldo -= kwota\n        cel.saldo += kwota\n\na, b = Konto(100), Konto(0)\na.przelej(b, 30)\nprint(a.saldo, b.saldo)",
        output = "70 30",
    ),
    explain(
        "Wskazówka: __str__",
        "Na koniec dodamy `__str__`, żeby `print(konto)` pokazywał czytelny opis. Format `:.2f` " +
            "wypisuje kwotę z dwoma miejscami po przecinku.",
        code = "class Konto:\n    def __init__(self, saldo):\n        self.saldo = saldo\n    def __str__(self):\n        return f\"Saldo: {self.saldo:.2f} zł\"\n\nprint(Konto(99.5))",
        output = "Saldo: 99.50 zł",
    ),
    fill(
        "Uzupełnij, aby wypłata zmniejszała saldo (wypisze 60).",
        "class Konto:\n    def __init__(self):\n        self.saldo = 100\n    def wyplac(self, kwota):\n        self.saldo ____ kwota\n\nk = Konto()\nk.wyplac(40)\nprint(k.saldo)",
        listOf("-=", "+=", "="),
        "-=",
        "-= odejmuje kwotę od dotychczasowego salda.",
    ),
    choice(
        "Gdzie najlepiej utworzyć listę historii operacji konta?",
        listOf("W __init__, przez self.historia = []", "Jako atrybut klasy", "W metodzie __str__", "Jako zmienną globalną"),
        0,
        "Wtedy każde konto ma własną historię.",
    ),
)
