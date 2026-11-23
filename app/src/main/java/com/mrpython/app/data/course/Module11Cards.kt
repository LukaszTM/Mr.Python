package com.mrpython.app.data.course

internal val module11Cards = listOf(
    cards(
        "u11l1",
        explain(
            "Zmiana atrybutów",
            "Atrybut obiektu zmienisz zwykłym przypisaniem, np. `p.x = 10`. Nowy atrybut możesz też " +
                "dodać już po utworzeniu obiektu. Zmiana dotyczy tylko tego jednego obiektu.",
            code = "class Punkt:\n    pass\n\np = Punkt()\np.x = 10\nprint(p.x)",
            output = "10",
        ),
        explain(
            "Obiekt to instancja",
            "Obiekt utworzony z klasy nazywamy też jej instancją. `type(obiekt).__name__` podaje nazwę " +
                "jego klasy. Gdy `__init__` wymaga argumentów, a ich nie podasz, pojawi się błąd `TypeError`.",
            code = "class Kot:\n    pass\n\nk = Kot()\nprint(type(k).__name__)",
            output = "Kot",
        ),
    ),
    cards(
        "u11l2",
        explain(
            "Metody z parametrami",
            "Metoda może mieć więcej parametrów niż `self`. Przy wywołaniu podajesz tylko pozostałe – " +
                "obiekt przed kropką Python sam wstawia jako `self`.",
            code = "class Kot:\n    def glos(self, ile):\n        return \"mru\" * ile\n\nprint(Kot().glos(3))",
            output = "mrumrumru",
        ),
        explain(
            "Metoda woła metodę",
            "W klasie jedna metoda może wywołać inną przez `self.nazwa()`. Pamiętaj o nawiasach: " +
                "`obiekt.metoda` bez `()` nie uruchamia metody, tylko ją wskazuje.",
            code = "class A:\n    def a(self):\n        return 2\n    def b(self):\n        return self.a() * 5\nprint(A().b())",
            output = "10",
        ),
    ),
    cards(
        "u11l3",
        explain(
            "Sprawdzanie typu: isinstance",
            "`isinstance(obiekt, Klasa)` zwraca `True`, gdy obiekt jest tej klasy albo klasy, która po " +
                "niej dziedziczy. Każdy Kot jest Zwierzęciem, ale nie każde Zwierzę jest Kotem.",
            code = "class Zwierze:\n    pass\nclass Kot(Zwierze):\n    pass\nprint(isinstance(Kot(), Zwierze))\nprint(isinstance(Zwierze(), Kot))",
            output = "True\nFalse",
        ),
        explain(
            "super() – wersja rodzica",
            "W klasie potomnej `super()` daje dostęp do metod klasy bazowej. Najczęściej piszemy " +
                "`super().__init__(...)`, żeby rodzic ustawił swoje atrybuty, a potem dodajemy własne.",
            code = "class A:\n    def kto(self): return \"A\"\nclass B(A):\n    def kto(self):\n        return super().kto() + \"B\"\nprint(B().kto())",
            output = "AB",
        ),
    ),
    cards(
        "u11l4",
        explain(
            "Metoda zwraca self",
            "Gdy metoda kończy się `return self`, zwraca ten sam obiekt. Dzięki temu można wywoływać " +
                "metody jedna po drugiej, np. `c.klik().klik()`.",
            code = "class L:\n    def __init__(self): self.n = 0\n    def klik(self):\n        self.n += 1\n        return self\nprint(L().klik().klik().n)",
            output = "2",
        ),
        explain(
            "Brak atrybutu",
            "Odczyt atrybutu, którego obiekt nie ma, kończy się błędem `AttributeError`. Atrybuty " +
                "ustawiane w `__init__` każdy obiekt dostaje osobno – np. własną, nową listę.",
            code = "class Kot:\n    pass\ntry:\n    print(Kot().wiek)\nexcept AttributeError:\n    print(\"brak\")",
            output = "brak",
        ),
    ),
)
