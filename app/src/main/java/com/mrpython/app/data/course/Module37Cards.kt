package com.mrpython.app.data.course

internal val module37Cards = listOf(
    cards(
        "u37l2",
        explain(
            "Pętla po obiekcie: __iter__",
            "Żeby obiekt dało się przejść pętlą `for`, dodaj metodę `__iter__`. Najprościej delegować: " +
                "zwrócić `iter(self.lista)`, czyli iterator wewnętrznej listy.",
            code = "class Playlista:\n    def __init__(self, utwory):\n        self.utwory = utwory\n    def __iter__(self):\n        return iter(self.utwory)\n\nfor u in Playlista([\"A\", \"B\"]):\n    print(u)",
            output = "A\nB",
        ),
    ),
    cards(
        "u37l3",
        explain(
            "Wymienne części",
            "Część obiektu można podać w konstruktorze. Auto nie musi wiedzieć, jaki ma napęd – wystarczy, " +
                "że napęd ma metodę `napedz()`. Podmiana części nie wymaga zmian w klasie Auto.",
            code = "class Prad:\n    def napedz(self):\n        return \"ładuję\"\nclass Auto:\n    def __init__(self, naped):\n        self.naped = naped\nprint(Auto(Prad()).naped.napedz())",
            output = "ładuję",
        ),
        explain(
            "Stos nie jest listą",
            "`class Stos(list)` dziedziczy wszystkie metody listy, np. `insert()`, które łamią zasady stosu. " +
                "Lepiej, żeby stos miał listę w atrybucie i udostępniał tylko swoje operacje.",
            code = "class Stos:\n    def __init__(self):\n        self.dane = []\n    def poloz(self, x):\n        self.dane.append(x)\n    def zdejmij(self):\n        return self.dane.pop()\ns = Stos()\ns.poloz(1)\nprint(s.zdejmij())",
            output = "1",
        ),
    ),
)
