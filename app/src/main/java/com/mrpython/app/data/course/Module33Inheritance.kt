package com.mrpython.app.data.course

import com.mrpython.app.domain.CourseUnit

internal val module33 = CourseUnit(
    id = "u33",
    title = "Dziedziczenie w praktyce",
    description = "super(), polimorfizm, wielodziedziczenie i klasy abstrakcyjne",
    lessons = listOf(
        lesson(
            "u33l1", "Nadpisywanie i super()",
            output(
                "class Zwierze:\n    def glos(self):\n        return \"...\"\n\nclass Kot(Zwierze):\n    def glos(self):\n        return \"miau\"\n\nprint(Kot().glos(), Zwierze().glos())",
                "miau ...",
                "Kot nadpisuje metodę glos, a Zwierze zachowuje swoją wersję.",
            ),
            output(
                "class Osoba:\n    def __init__(self, imie):\n        self.imie = imie\n\nclass Uczen(Osoba):\n    def __init__(self, imie, klasa):\n        super().__init__(imie)\n        self.klasa = klasa\n\nu = Uczen(\"Ola\", 3)\nprint(u.imie, u.klasa)",
                "Ola 3",
                "super().__init__ ustawia imie, a Uczen dodaje klasę.",
            ),
            output(
                "class A:\n    def opis(self):\n        return \"A\"\n\nclass B(A):\n    def opis(self):\n        return super().opis() + \"B\"\n\nprint(B().opis())",
                "AB",
                "B rozszerza metodę rodzica zamiast pisać ją od nowa.",
            ),
            choice(
                "Do czego służy super()?",
                listOf("Do wywołania metody z klasy bazowej", "Do tworzenia nowej klasy", "Do usunięcia metody rodzica", "Do sprawdzenia typu obiektu"),
                0,
                "super() daje dostęp do metod klasy nadrzędnej.",
            ),
            fill(
                "Uzupełnij, aby program wypisał 2.",
                "class Pojazd:\n    def __init__(self, kola):\n        self.kola = kola\n\nclass Rower(Pojazd):\n    def __init__(self):\n        ____().__init__(2)\n\nprint(Rower().kola)",
                listOf("super", "self", "parent"),
                "super",
                "super().__init__(2) uruchamia konstruktor klasy Pojazd.",
            ),
            choice(
                "Co się stanie po uruchomieniu tego kodu?",
                listOf("AttributeError – brak x", "Wypisze 1", "Wypisze None", "Wypisze 2"),
                0,
                "B nadpisał __init__ i nie wywołał super().__init__(), więc x nie powstał.",
                code = "class A:\n    def __init__(self):\n        self.x = 1\n\nclass B(A):\n    def __init__(self):\n        self.y = 2\n\nprint(B().x)",
            ),
            output(
                "class Konto:\n    def __str__(self):\n        return \"Konto\"\n\nclass Lokata(Konto):\n    def __str__(self):\n        return super().__str__() + \" (lokata)\"\n\nprint(Lokata())",
                "Konto (lokata)",
                "Metoda specjalna też może korzystać z wersji rodzica przez super().",
            ),
            tiles(
                "Wywołaj __init__ klasy bazowej z argumentem imie",
                listOf("super()", ".__init__(", "imie", ")"),
                listOf("self,", "parent()"),
                "super().__init__(imie) – self przekazuje się automatycznie.",
            ),
        ),
        lesson(
            "u33l2", "Polimorfizm i isinstance",
            output(
                "class Kot:\n    def glos(self):\n        return \"miau\"\n\nclass Pies:\n    def glos(self):\n        return \"hau\"\n\nfor z in [Kot(), Pies(), Kot()]:\n    print(z.glos())",
                "miau\nhau\nmiau",
                "Każdy obiekt odpowiada na glos() po swojemu – to polimorfizm.",
            ),
            choice(
                "Czym jest polimorfizm?",
                listOf("Różne klasy mają metodę o tej samej nazwie i można ich używać tak samo", "Klasa ma wiele konstruktorów", "Obiekt zmienia klasę w trakcie działania", "Klasa dziedziczy po wielu klasach"),
                0,
                "Dzięki polimorfizmowi pętla wywołuje tę samą metodę na różnych obiektach.",
            ),
            output(
                "class Zwierze:\n    pass\n\nclass Pies(Zwierze):\n    pass\n\np = Pies()\nprint(isinstance(p, Pies), isinstance(p, Zwierze))",
                "True True",
                "Obiekt klasy pochodnej jest też instancją klasy bazowej.",
            ),
            output(
                "class A:\n    pass\n\nclass B(A):\n    pass\n\nprint(issubclass(B, A), issubclass(A, B))",
                "True False",
                "B dziedziczy po A, ale nie odwrotnie.",
            ),
            output(
                "class Pies:\n    pass\n\nclass Kot:\n    pass\n\nfor z in [Pies(), Kot(), Pies()]:\n    if isinstance(z, Pies):\n        print(\"hau\")",
                "hau\nhau",
                "Warunek przepuszcza tylko obiekty klasy Pies.",
            ),
            fill(
                "Sprawdź, czy 5 jest liczbą całkowitą (wypisze True).",
                "print(____(5, int))",
                listOf("isinstance", "issubclass", "type"),
                "isinstance",
                "isinstance(obiekt, klasa) sprawdza typ obiektu; issubclass porównuje klasy.",
            ),
            tiles(
                "Sprawdź, czy obiekt z jest instancją klasy Pies",
                listOf("isinstance(", "z,", "Pies", ")"),
                listOf("issubclass(", "type("),
                "isinstance przyjmuje obiekt i klasę.",
            ),
            choice(
                "Co wypisze ten kod?",
                listOf("True", "False", "TypeError", "None"),
                0,
                "bool dziedziczy po int, więc True jest też instancją int.",
                code = "print(isinstance(True, int))",
            ),
        ),
        lesson(
            "u33l3", "Wielodziedziczenie i MRO",
            output(
                "class Lata:\n    def lec(self):\n        return \"lecę\"\n\nclass Plywa:\n    def plyn(self):\n        return \"płynę\"\n\nclass Kaczka(Lata, Plywa):\n    pass\n\nk = Kaczka()\nprint(k.lec(), k.plyn())",
                "lecę płynę",
                "Kaczka dziedziczy metody po obu klasach.",
            ),
            output(
                "class A:\n    def kto(self):\n        return \"A\"\n\nclass B:\n    def kto(self):\n        return \"B\"\n\nclass C(A, B):\n    pass\n\nprint(C().kto())",
                "A",
                "Przy konflikcie wygrywa klasa wymieniona wcześniej w nawiasie.",
            ),
            choice(
                "Co wypisze ten kod?",
                listOf("B", "A", "AB", "TypeError"),
                0,
                "C(B, A) – najpierw przeszukiwana jest klasa B.",
                code = "class A:\n    def kto(self):\n        return \"A\"\n\nclass B:\n    def kto(self):\n        return \"B\"\n\nclass C(B, A):\n    pass\n\nprint(C().kto())",
            ),
            output(
                "class A:\n    pass\n\nclass B(A):\n    pass\n\nprint([k.__name__ for k in B.__mro__])",
                "['B', 'A', 'object']",
                "__mro__ pokazuje kolejność szukania metod; na końcu zawsze jest object.",
            ),
            choice(
                "Co oznacza skrót MRO?",
                listOf("Kolejność, w jakiej Python szuka metod w klasach", "Listę wszystkich obiektów klasy", "Metodę tworzącą obiekt", "Rodzaj błędu"),
                0,
                "MRO (Method Resolution Order) to kolejność przeszukiwania klas.",
            ),
            output(
                "class A:\n    def kto(self):\n        return \"A\"\nclass B(A):\n    pass\nclass C(A):\n    def kto(self):\n        return \"C\"\nclass D(B, C):\n    pass\nprint(D().kto())",
                "C",
                "Kolejność to D, B, C, A – C ma kto(), zanim Python dojdzie do A.",
            ),
            fill(
                "Uzupełnij, aby kaczka umiała pływać.",
                "class Lata:\n    def lec(self):\n        return \"lecę\"\n\nclass Plywa:\n    def plyn(self):\n        return \"płynę\"\n\nclass Kaczka(Lata, ____):\n    pass\n\nprint(Kaczka().plyn())",
                listOf("Plywa", "Lata", "object"),
                "Plywa",
                "Metoda plyn pochodzi z klasy Plywa, więc Kaczka musi po niej dziedziczyć.",
            ),
            tiles(
                "Napisz nagłówek klasy C dziedziczącej po A i B",
                listOf("class", "C(", "A,", "B", "):"),
                listOf("def", "extends"),
                "Klasy bazowe wymieniamy po przecinku w nawiasie.",
            ),
        ),
        lesson(
            "u33l4", "Klasy abstrakcyjne",
            output(
                "from abc import ABC, abstractmethod\n\nclass Figura(ABC):\n    @abstractmethod\n    def pole(self):\n        pass\n\nclass Kwadrat(Figura):\n    def pole(self):\n        return 4\n\nprint(Kwadrat().pole())",
                "4",
                "Kwadrat implementuje metodę abstrakcyjną, więc można go utworzyć.",
            ),
            choice(
                "Co się stanie po uruchomieniu tego kodu?",
                listOf("TypeError – nie można utworzyć klasy abstrakcyjnej", "Powstanie obiekt f", "NameError", "f.pole() zwróci None"),
                0,
                "Klasy z niezaimplementowaną metodą abstrakcyjną nie da się utworzyć.",
                code = "from abc import ABC, abstractmethod\n\nclass Figura(ABC):\n    @abstractmethod\n    def pole(self):\n        pass\n\nf = Figura()",
            ),
            output(
                "from abc import ABC, abstractmethod\nclass Baza(ABC):\n    @abstractmethod\n    def run(self):\n        pass\nclass Zla(Baza):\n    pass\ntry:\n    Zla()\nexcept TypeError:\n    print(\"brak metody run\")",
                "brak metody run",
                "Zla nie zaimplementowała run(), więc też jest abstrakcyjna.",
            ),
            fill(
                "Uzupełnij, aby nie dało się utworzyć obiektu Zwierze (wypisze „abstrakcyjna”).",
                "from abc import ABC, abstractmethod\n\nclass Zwierze(ABC):\n    @____\n    def glos(self):\n        pass\n\ntry:\n    Zwierze()\nexcept TypeError:\n    print(\"abstrakcyjna\")",
                listOf("abstractmethod", "staticmethod", "property"),
                "abstractmethod",
                "@abstractmethod oznacza metodę, którą klasy pochodne muszą zaimplementować.",
            ),
            choice(
                "Po czym dziedziczy klasa abstrakcyjna w Pythonie?",
                listOf("Po ABC z modułu abc", "Po Abstract", "Po Exception", "Po niczym – wystarczy słowo abstract"),
                0,
                "Klasa abstrakcyjna dziedziczy po abc.ABC.",
            ),
            output(
                "from abc import ABC, abstractmethod\nclass Zw(ABC):\n    @abstractmethod\n    def glos(self):\n        pass\n    def przedstaw(self):\n        return \"Ja: \" + self.glos()\nclass Kot(Zw):\n    def glos(self):\n        return \"miau\"\nprint(Kot().przedstaw())",
                "Ja: miau",
                "Klasa abstrakcyjna może mieć zwykłe metody, które korzystają z abstrakcyjnych.",
            ),
            tiles(
                "Zaimportuj ABC i abstractmethod",
                listOf("from", "abc", "import", "ABC,", "abstractmethod"),
                listOf("include", "abstract"),
                "Oba elementy pochodzą z modułu abc.",
            ),
            choice(
                "Po co stosuje się klasy abstrakcyjne?",
                listOf("Żeby wymusić, by klasy pochodne zaimplementowały określone metody", "Żeby program działał szybciej", "Żeby ukryć atrybuty", "Żeby klasa miała tylko jeden obiekt"),
                0,
                "Klasa abstrakcyjna to szablon – mówi, jakie metody muszą mieć klasy pochodne.",
            ),
        ),
        lesson(
            "u33l5", "Powtórka: dziedziczenie",
            output(
                "class A:\n    def __init__(self):\n        print(\"A\")\n\nclass B(A):\n    def __init__(self):\n        print(\"B\")\n        super().__init__()\n\nB()",
                "B\nA",
                "Najpierw wypisuje się B, potem super() wywołuje __init__ z A.",
            ),
            output(
                "class Plat:\n    def kwota(self):\n        return 10\n\nclass Karta(Plat):\n    def kwota(self):\n        return super().kwota() + 2\n\nfor p in [Plat(), Karta()]:\n    print(p.kwota())",
                "10\n12",
                "Karta rozszerza metodę rodzica o opłatę 2.",
            ),
            choice(
                "Co wypisze ten kod?",
                listOf("True", "False", "TypeError", "Kot"),
                0,
                "Kot dziedziczy po Zwierze, więc jego obiekt jest też Zwierzęciem.",
                code = "class Zwierze:\n    pass\n\nclass Kot(Zwierze):\n    pass\n\nprint(isinstance(Kot(), Zwierze))",
            ),
            output(
                "class X:\n    imie = \"X\"\n\nclass Y:\n    imie = \"Y\"\n\nclass Z(Y, X):\n    pass\n\nprint(Z.imie)",
                "Y",
                "MRO klasy Z to Z, Y, X – pierwszy znaleziony atrybut pochodzi z Y.",
            ),
            fill(
                "Uzupełnij, aby program sprawdził, czy B dziedziczy po A (wypisze True).",
                "class A:\n    pass\n\nclass B(A):\n    pass\n\nprint(____(B, A))",
                listOf("issubclass", "isinstance", "super"),
                "issubclass",
                "issubclass porównuje dwie klasy.",
            ),
            choice(
                "Który zapis wywołuje metodę opis z klasy bazowej?",
                listOf("super().opis()", "parent.opis()", "base().opis()", "self.super().opis()"),
                0,
                "Do metod rodzica odwołujemy się przez super().",
            ),
            output(
                "from abc import ABC, abstractmethod\nclass Figura(ABC):\n    @abstractmethod\n    def pole(self):\n        pass\nclass Kolo(Figura):\n    def pole(self):\n        return 3\nf = Kolo()\nprint(isinstance(f, Figura), f.pole())",
                "True 3",
                "Kolo implementuje pole() i jest instancją klasy abstrakcyjnej Figura.",
            ),
            tiles(
                "Napisz nagłówek klasy Kot dziedziczącej po Zwierze",
                listOf("class", "Kot(", "Zwierze", "):"),
                listOf("def", "extends"),
                "Klasę bazową podajemy w nawiasie.",
            ),
        ),
    ),
)
