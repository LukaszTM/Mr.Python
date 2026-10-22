package com.mrpython.app.data.course

internal val module33Intro = lesson(
    "u33l0", "Wprowadzenie: dziedziczenie",
    explain(
        "Nadpisywanie i super()",
        "Klasa pochodna może nadpisać metodę rodzica, pisząc własną o tej samej nazwie. `super()` " +
            "pozwala wywołać wersję rodzica – np. `super().__init__(imie)` w konstruktorze, a potem dodać swoje.",
        code = "class A:\n    def opis(self):\n        return \"A\"\n\nclass B(A):\n    def opis(self):\n        return super().opis() + \"B\"\n\nprint(B().opis())",
        output = "AB",
    ),
    explain(
        "Polimorfizm",
        "Różne klasy mogą mieć metodę o tej samej nazwie. Wtedy w pętli wywołujemy ją tak samo, " +
            "a każdy obiekt odpowiada po swojemu – to polimorfizm.",
        code = "class Kot:\n    def glos(self):\n        return \"miau\"\n\nclass Pies:\n    def glos(self):\n        return \"hau\"\n\nfor z in [Kot(), Pies()]:\n    print(z.glos())",
        output = "miau\nhau",
    ),
    explain(
        "isinstance i issubclass",
        "`isinstance(obiekt, Klasa)` sprawdza, czy obiekt należy do klasy – także przez dziedziczenie. " +
            "`issubclass(B, A)` porównuje dwie klasy: czy B dziedziczy po A.",
        code = "class Zwierze:\n    pass\n\nclass Pies(Zwierze):\n    pass\n\nprint(isinstance(Pies(), Zwierze))\nprint(issubclass(Zwierze, Pies))",
        output = "True\nFalse",
    ),
    explain(
        "Wielodziedziczenie i MRO",
        "Klasa może dziedziczyć po kilku klasach: `class C(A, B)`. Gdy obie mają tę samą metodę, " +
            "wygrywa wymieniona wcześniej. Kolejność szukania metod to MRO, widoczne w `C.__mro__`.",
        code = "class A:\n    def kto(self):\n        return \"A\"\n\nclass B:\n    def kto(self):\n        return \"B\"\n\nclass C(A, B):\n    pass\n\nprint(C().kto())",
        output = "A",
    ),
    explain(
        "Klasy abstrakcyjne",
        "Klasa abstrakcyjna to szablon: dziedziczy po `ABC`, a metody z `@abstractmethod` muszą " +
            "zaimplementować klasy pochodne. Obiektu samej klasy abstrakcyjnej nie da się utworzyć (`TypeError`).",
        code = "from abc import ABC, abstractmethod\nclass Figura(ABC):\n    @abstractmethod\n    def pole(self):\n        pass\nclass Kwadrat(Figura):\n    def pole(self):\n        return 4\nprint(Kwadrat().pole())",
        output = "4",
    ),
    fill(
        "Uzupełnij, aby wywołać konstruktor klasy bazowej (wypisze 4).",
        "class Pojazd:\n    def __init__(self, kola):\n        self.kola = kola\n\nclass Auto(Pojazd):\n    def __init__(self):\n        ____().__init__(4)\n\nprint(Auto().kola)",
        listOf("super", "self", "Auto"),
        "super",
        "super() daje dostęp do metod klasy bazowej.",
    ),
    choice(
        "Co wypisze ten kod?",
        listOf("True", "False", "TypeError", "None"),
        0,
        "Kot dziedziczy po Zwierze, więc jest też jego instancją.",
        code = "class Zwierze:\n    pass\n\nclass Kot(Zwierze):\n    pass\n\nprint(isinstance(Kot(), Zwierze))",
    ),
    tiles(
        "Napisz nagłówek klasy Kaczka dziedziczącej po Lata i Plywa",
        listOf("class", "Kaczka(", "Lata,", "Plywa", "):"),
        listOf("def", "extends"),
        "Klasy bazowe podajemy po przecinku w nawiasie.",
    ),
)
