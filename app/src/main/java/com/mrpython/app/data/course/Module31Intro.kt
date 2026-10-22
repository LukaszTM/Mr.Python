package com.mrpython.app.data.course

internal val module31Intro = lesson(
    "u31l0", "Wprowadzenie: atrybuty i metody klasy",
    explain(
        "Atrybuty klasy",
        "Atrybut zapisany w ciele klasy, poza metodami, jest wspólny dla wszystkich obiektów. " +
            "Zmieniamy go przez nazwę klasy, np. `Gracz.liczba += 1`. Uwaga: `self.x = ...` tworzy osobny atrybut obiektu.",
        code = "class Gracz:\n    liczba = 0\n    def __init__(self):\n        Gracz.liczba += 1\n\nGracz()\nGracz()\nprint(Gracz.liczba)",
        output = "2",
    ),
    explain(
        "@classmethod",
        "Metoda z dekoratorem `@classmethod` dostaje klasę w parametrze `cls` zamiast obiektu. " +
            "Często służy jako alternatywny konstruktor: tworzy obiekt w inny sposób, np. z napisu.",
        code = "class Punkt:\n    def __init__(self, x, y):\n        self.x, self.y = x, y\n    @classmethod\n    def zero(cls):\n        return cls(0, 0)\n\nprint(Punkt.zero().x)",
        output = "0",
    ),
    explain(
        "@staticmethod",
        "Metoda statyczna nie dostaje ani `self`, ani `cls` – to zwykła funkcja schowana w klasie, " +
            "bo do niej pasuje. Wywołujemy ją przez nazwę klasy.",
        code = "class Mat:\n    @staticmethod\n    def dodaj(a, b):\n        return a + b\n\nprint(Mat.dodaj(2, 3))",
        output = "5",
    ),
    explain(
        "@property",
        "`@property` zamienia metodę we właściwość, którą czytamy jak atrybut – bez nawiasów. " +
            "Wartość jest liczona przy każdym odczycie. Podkreślnik, jak w `_saldo`, to umowa: atrybut wewnętrzny.",
        code = "class Prostokat:\n    def __init__(self, a, b):\n        self.a, self.b = a, b\n    @property\n    def pole(self):\n        return self.a * self.b\n\nprint(Prostokat(3, 4).pole)",
        output = "12",
    ),
    explain(
        "Setter z walidacją",
        "Sama `@property` daje tylko odczyt. Dekorator `@nazwa.setter` dodaje metodę wywoływaną przy " +
            "przypisaniu – może sprawdzić lub poprawić wartość. Getter i setter używają ukrytego `self._wiek`.",
        code = "class Osoba:\n    @property\n    def wiek(self):\n        return self._wiek\n    @wiek.setter\n    def wiek(self, w):\n        self._wiek = max(0, w)\n\no = Osoba()\no.wiek = -5\nprint(o.wiek)",
        output = "0",
    ),
    choice(
        "Który dekorator przekazuje klasę jako pierwszy argument cls?",
        listOf("@classmethod", "@staticmethod", "@property", "@setter"),
        0,
        "@classmethod daje metodzie dostęp do klasy przez cls.",
    ),
    output(
        "class Pies:\n    gatunek = \"pies\"\n\na = Pies()\nb = Pies()\nprint(a.gatunek, b.gatunek)",
        "pies pies",
        "Atrybut klasy widzą wszystkie jej obiekty.",
    ),
    fill(
        "Uzupełnij, aby obwod odczytywać bez nawiasów (wypisze 8).",
        "class Kwadrat:\n    def __init__(self, a):\n        self.a = a\n    ____\n    def obwod(self):\n        return 4 * self.a\n\nprint(Kwadrat(2).obwod)",
        listOf("@property", "@staticmethod", "@classmethod"),
        "@property",
        "Właściwość czytamy jak atrybut, a jej wartość liczy metoda.",
    ),
)
