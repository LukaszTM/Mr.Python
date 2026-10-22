package com.mrpython.app.data.course

internal val module33Cards = listOf(
    cards(
        "u33l1",
        explain(
            "Zapomniany super().__init__()",
            "Klasa bez własnego `__init__` dziedziczy konstruktor rodzica. Ale gdy napiszesz własny `__init__` " +
                "i nie wywołasz `super().__init__()`, atrybuty rodzica nie powstaną (`AttributeError`).",
            code = "class A:\n    def __init__(self, x):\n        self.x = x\n\nclass B(A):\n    pass\n\nprint(B(7).x)",
            output = "7",
        ),
        explain(
            "self wybiera wersję dziecka",
            "Gdy metoda rodzica wywołuje `self.opis()`, Python szuka `opis` od klasy obiektu. Jeśli klasa " +
                "pochodna ją nadpisała, użyta zostanie jej wersja.",
            code = "class Baza:\n    def opis(self):\n        return \"baza\"\n    def pokaz(self):\n        return \"[\" + self.opis() + \"]\"\nclass Pod(Baza):\n    def opis(self):\n        return \"pod\"\nprint(Pod().pokaz())",
            output = "[pod]",
        ),
    ),
    cards(
        "u33l2",
        explain(
            "isinstance dla typów",
            "`isinstance` działa też z typami wbudowanymi: `int`, `str`, `list`… Zamiast jednej klasy możesz " +
                "podać krotkę klas – wynik to True, gdy obiekt pasuje do którejkolwiek.",
            code = "print(isinstance(\"abc\", str), isinstance(3.5, int))\nprint(isinstance(7, (int, float)))",
            output = "True False\nTrue",
        ),
        explain(
            "type() a isinstance()",
            "`type(obiekt)` zwraca dokładną klasę, a `isinstance` uwzględnia dziedziczenie. Ciekawostka: " +
                "`bool` dziedziczy po `int`, więc `True` jest też liczbą całkowitą.",
            code = "class Zw:\n    pass\nclass Pies(Zw):\n    pass\np = Pies()\nprint(type(p) == Zw, isinstance(p, Zw))\nprint(isinstance(True, int))",
            output = "False True\nTrue",
        ),
    ),
    cards(
        "u33l3",
        explain(
            "Podgląd MRO",
            "`Klasa.__mro__` to krotka klas w kolejności szukania metod. Pierwsza jest sama klasa, " +
                "a na końcu zawsze `object` – po nim dziedziczy każda klasa.",
            code = "class A:\n    pass\nclass B(A):\n    pass\nprint([k.__name__ for k in B.__mro__])",
            output = "['B', 'A', 'object']",
        ),
        explain(
            "Romb w dziedziczeniu",
            "Gdy B i C dziedziczą po A, a `D(B, C)` po obu, kolejność to D, B, C, A. Wspólny rodzic A " +
                "jest sprawdzany dopiero na końcu, po wszystkich swoich dzieciach.",
            code = "class A:\n    pass\nclass B(A):\n    pass\nclass C(A):\n    pass\nclass D(B, C):\n    pass\nprint([k.__name__ for k in D.__mro__])",
            output = "['D', 'B', 'C', 'A', 'object']",
        ),
    ),
    cards(
        "u33l4",
        explain(
            "Zwykłe metody w szablonie",
            "Klasa abstrakcyjna może mieć też zwykłe metody, które korzystają z metod abstrakcyjnych. " +
                "Wspólną część piszemy raz, a klasy pochodne uzupełniają tylko brakujący fragment.",
            code = "from abc import ABC, abstractmethod\nclass Zw(ABC):\n    @abstractmethod\n    def glos(self):\n        pass\n    def przedstaw(self):\n        return \"Ja: \" + self.glos()\nclass Kot(Zw):\n    def glos(self):\n        return \"miau\"\nprint(Kot().przedstaw())",
            output = "Ja: miau",
        ),
        explain(
            "Brak metody to dalej szablon",
            "Klasa pochodna, która nie zaimplementuje wszystkich metod abstrakcyjnych, też jest abstrakcyjna – " +
                "jej obiekt zgłosi `TypeError`. Klasa po `ABC` bez metod abstrakcyjnych da się utworzyć normalnie.",
            code = "from abc import ABC, abstractmethod\nclass Baza(ABC):\n    @abstractmethod\n    def run(self):\n        pass\nclass Zla(Baza):\n    pass\ntry:\n    Zla()\nexcept TypeError:\n    print(\"brak run\")",
            output = "brak run",
        ),
    ),
)
