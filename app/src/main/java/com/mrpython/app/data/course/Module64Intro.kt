package com.mrpython.app.data.course

internal val module64Intro = lesson(
    "u64l0", "Wprowadzenie: tydzień powtórek – obiekty",
    explain(
        "Klasy i obiekty",
        "Ten tydzień powtarza programowanie obiektowe. Klasa to przepis, obiekt to egzemplarz. " +
            "`__init__` ustawia atrybuty, a `self` oznacza bieżący obiekt.",
        code = "class Pies:\n    def __init__(self, imie):\n        self.imie = imie\n    def glos(self):\n        return self.imie + \": hau\"\nprint(Pies(\"Burek\").glos())",
        output = "Burek: hau",
    ),
    explain(
        "Właściwości i metody klasowe",
        "`@property` zamienia metodę w atrybut liczony w locie – piszemy bez nawiasów. " +
            "`@classmethod` dostaje klasę (`cls`), a `@staticmethod` nie dostaje ani `self`, ani `cls`.",
        code = "class Kolo:\n    def __init__(self, r): self.r = r\n    @property\n    def srednica(self): return 2 * self.r\nprint(Kolo(3).srednica)",
        output = "6",
    ),
    explain(
        "Metody specjalne",
        "Metody z podwójnym podkreśleniem uczą obiekt współpracy z Pythonem: `__str__` dla `print`, " +
            "`__len__` dla `len()`, `__add__` dla `+`, `__lt__` dla `<`.",
        code = "class Talia:\n    def __init__(self):\n        self.karty = [\"A\", \"K\"]\n    def __len__(self):\n        return len(self.karty)\nprint(len(Talia()))",
        output = "2",
    ),
    explain(
        "Dziedziczenie i własne wyjątki",
        "Klasa `B(A)` dziedziczy metody `A`, może je nadpisać i wołać oryginał przez `super()`. " +
            "Własny wyjątek to po prostu klasa dziedzicząca po `Exception`.",
        code = "class BladWieku(Exception):\n    pass\ntry:\n    raise BladWieku(\"za młody\")\nexcept Exception as e:\n    print(\"Błąd:\", e)",
        output = "Błąd: za młody",
    ),
    explain(
        "dataclasses",
        "`@dataclass` sam tworzy `__init__`, czytelny `__repr__` i porównanie `==` na podstawie pól. " +
            "Wystarczy wypisać pola z typami.",
        code = "from dataclasses import dataclass\n@dataclass\nclass Punkt:\n    x: int\n    y: int\nprint(Punkt(1, 2))",
        output = "Punkt(x=1, y=2)",
    ),
    choice(
        "Który dekorator pozwala czytać metodę jak atrybut, bez nawiasów?",
        listOf("@property", "@staticmethod", "@classmethod", "@dataclass"),
        0,
        "@property zamienia metodę w atrybut liczony w locie.",
    ),
    output(
        "from dataclasses import dataclass\n@dataclass\nclass Kolor:\n    nazwa: str\nprint(Kolor(\"red\") == Kolor(\"red\"))",
        "True",
        "dataclass porównuje obiekty po wartościach pól.",
    ),
)
