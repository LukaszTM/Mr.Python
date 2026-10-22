package com.mrpython.app.data.course

internal val module32Intro = lesson(
    "u32l0", "Wprowadzenie: metody specjalne",
    explain(
        "__repr__ i __str__",
        "Metody z podwójnymi podkreślnikami Python wywołuje sam. `__str__` daje ładny tekst dla " +
            "`print()`, a `__repr__` techniczny opis – używany np. w liście i wtedy, gdy brak `__str__`.",
        code = "class Pies:\n    def __init__(self, imie):\n        self.imie = imie\n    def __repr__(self):\n        return f\"Pies('{self.imie}')\"\n\nprint([Pies(\"Reks\")])",
        output = "[Pies('Reks')]",
    ),
    explain(
        "Porównania: __eq__ i __lt__",
        "Domyślnie `==` sprawdza, czy to ten sam obiekt. `__eq__` uczy klasę porównywać atrybuty, " +
            "a `__lt__` obsługuje `<` – dzięki niemu działają `sorted()`, `min()` i `max()`.",
        code = "class P:\n    def __init__(self, x):\n        self.x = x\n    def __eq__(self, other):\n        return self.x == other.x\n\nprint(P(1) == P(1))",
        output = "True",
    ),
    explain(
        "Własne kolekcje",
        "Klasa może zachowywać się jak lista: `__len__` obsługuje `len()`, `__contains__` operator " +
            "`in`, a `__getitem__` nawiasy `obiekt[i]`.",
        code = "class Klub:\n    def __init__(self):\n        self.osoby = [\"Ala\", \"Ola\"]\n    def __len__(self):\n        return len(self.osoby)\n\nprint(len(Klub()))",
        output = "2",
    ),
    explain(
        "Operatory: __add__ i inne",
        "Operator `+` wywołuje `__add__`, `-` wywołuje `__sub__`, a `*` – `__mul__`. Metoda zwykle " +
            "zwraca nowy obiekt z wynikiem, np. sumę dwóch wektorów.",
        code = "class Wektor:\n    def __init__(self, x, y):\n        self.x, self.y = x, y\n    def __add__(self, o):\n        return Wektor(self.x + o.x, self.y + o.y)\n\nw = Wektor(1, 2) + Wektor(3, 4)\nprint(w.x, w.y)",
        output = "4 6",
    ),
    choice(
        "Którą metodę wywołuje operator in?",
        listOf("__contains__", "__in__", "__getitem__", "__eq__"),
        0,
        "x in obiekt wywołuje __contains__.",
    ),
    fill(
        "Uzupełnij, aby operator + zadziałał (wypisze 15).",
        "class Czas:\n    def __init__(self, m):\n        self.m = m\n    def ____(self, o):\n        return Czas(self.m + o.m)\n\nprint((Czas(10) + Czas(5)).m)",
        listOf("__add__", "__plus__", "__sum__"),
        "__add__",
        "Dodawanie obsługuje metoda __add__.",
    ),
    output(
        "class A:\n    def __str__(self):\n        return \"ładny\"\n    def __repr__(self):\n        return \"A()\"\n\nprint(A())\nprint([A()])",
        "ładny\n[A()]",
        "print() używa __str__, a lista pokazuje elementy przez __repr__.",
    ),
)
