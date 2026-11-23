package com.mrpython.app.data.course

import com.mrpython.app.domain.CourseUnit

internal val module31 = CourseUnit(
    id = "u31",
    title = "Atrybuty i metody klasy",
    description = "Atrybuty klasy, @classmethod, @staticmethod i @property",
    lessons = listOf(
        lesson(
            "u31l1", "Atrybuty klasy",
            output(
                "class Kot:\n    gatunek = \"kot\"\n\na = Kot()\nb = Kot()\nprint(a.gatunek, b.gatunek)",
                "kot kot",
                "Atrybut klasy jest wspólny dla wszystkich obiektów tej klasy.",
            ),
            output(
                "class Gracz:\n    liczba = 0\n    def __init__(self):\n        Gracz.liczba += 1\n\nGracz()\nGracz()\nprint(Gracz.liczba)",
                "2",
                "Każde utworzenie obiektu zwiększa wspólny licznik w klasie.",
            ),
            choice(
                "Gdzie definiujemy atrybut klasy?",
                listOf("W ciele klasy, poza metodami", "W __init__ przez self", "Tylko w osobnej funkcji", "W pętli for"),
                0,
                "Atrybut klasy zapisujemy bezpośrednio w ciele klasy, a nie przez self.",
            ),
            output(
                "class A:\n    x = 1\n\na = A()\na.x = 5\nprint(a.x, A.x)",
                "5 1",
                "Przypisanie a.x tworzy atrybut obiektu, który przesłania atrybut klasy.",
            ),
            fill(
                "Uzupełnij, aby licznik w klasie wynosił 2.",
                "class Pies:\n    ile = 0\n    def __init__(self):\n        ____.ile += 1\n\nPies()\nPies()\nprint(Pies.ile)",
                listOf("Pies", "self", "ile"),
                "Pies",
                "Zmieniamy atrybut klasy przez jej nazwę; self.ile += 1 utworzyłoby atrybut obiektu.",
            ),
            output(
                "class Koszyk:\n    rzeczy = []\n\na = Koszyk()\nb = Koszyk()\na.rzeczy.append(\"jabłko\")\nprint(b.rzeczy)",
                "['jabłko']",
                "Lista w atrybucie klasy jest jedna, wspólna dla wszystkich obiektów.",
            ),
            tiles(
                "Zwiększ atrybut klasy licznik w klasie Auto o 1",
                listOf("Auto.licznik", "+=", "1"),
                listOf("==", "self"),
                "Do atrybutu klasy odwołujemy się przez nazwę klasy.",
            ),
            choice(
                "Co wypisze ten kod?",
                listOf("0", "1", "AttributeError", "None"),
                0,
                "a.n += 1 tworzy nowy atrybut w obiekcie a, a A.n zostaje równe 0.",
                code = "class A:\n    n = 0\n\na = A()\na.n += 1\nprint(A.n)",
            ),
        ),
        lesson(
            "u31l2", "@classmethod i @staticmethod",
            output(
                "class Punkt:\n    def __init__(self, x, y):\n        self.x = x\n        self.y = y\n    @classmethod\n    def zero(cls):\n        return cls(0, 0)\n\np = Punkt.zero()\nprint(p.x, p.y)",
                "0 0",
                "Metoda klasy może tworzyć nowe obiekty – to tzw. alternatywny konstruktor.",
            ),
            choice(
                "Co trafia do parametru cls w metodzie z @classmethod?",
                listOf("Klasa, na której wywołano metodę", "Konkretny obiekt (instancja)", "Nazwa metody jako napis", "Nic – parametr jest pusty"),
                0,
                "cls to sama klasa, tak jak self to obiekt.",
            ),
            output(
                "class Data:\n    def __init__(self, d, m):\n        self.d = d\n        self.m = m\n    @classmethod\n    def z_napisu(cls, s):\n        d, m = s.split(\".\")\n        return cls(int(d), int(m))\n\nprint(Data.z_napisu(\"24.12\").m)",
                "12",
                "z_napisu rozbija napis i wywołuje zwykły konstruktor cls(...).",
            ),
            fill(
                "Uzupełnij dekorator, aby zero() działała jak alternatywny konstruktor.",
                "class Punkt:\n    def __init__(self, x, y):\n        self.x = x\n        self.y = y\n    ____\n    def zero(cls):\n        return cls(0, 0)\n\nprint(Punkt.zero().x)",
                listOf("@classmethod", "@staticmethod", "@property"),
                "@classmethod",
                "Tylko @classmethod przekazuje klasę jako pierwszy argument cls.",
            ),
            output(
                "class Mat:\n    @staticmethod\n    def dodaj(a, b):\n        return a + b\n\nprint(Mat.dodaj(2, 3))",
                "5",
                "Metoda statyczna nie dostaje ani self, ani cls – to zwykła funkcja w klasie.",
            ),
            fill(
                "Uzupełnij, aby program wypisał 212.0.",
                "class Temp:\n    ____\n    def na_f(c):\n        return c * 9 / 5 + 32\n\nprint(Temp.na_f(100))",
                listOf("@staticmethod", "@classmethod", "@property"),
                "@staticmethod",
                "na_f nie potrzebuje ani obiektu, ani klasy, więc jest metodą statyczną.",
            ),
            choice(
                "Metoda nie korzysta ani z obiektu, ani z klasy. Jakiego dekoratora użyć?",
                listOf("@staticmethod", "@classmethod", "@property", "Żadnego – musi mieć self"),
                0,
                "@staticmethod służy do funkcji pomocniczych związanych z klasą.",
            ),
            tiles(
                "Wywołaj metodę statyczną dodaj klasy Mat z argumentami 1, 2 i wypisz wynik",
                listOf("print(", "Mat.dodaj(", "1, 2", "))"),
                listOf("self.", "cls."),
                "Metodę statyczną wywołujemy przez nazwę klasy.",
            ),
        ),
        lesson(
            "u31l3", "@property",
            output(
                "class Prostokat:\n    def __init__(self, a, b):\n        self.a = a\n        self.b = b\n    @property\n    def pole(self):\n        return self.a * self.b\n\nprint(Prostokat(3, 4).pole)",
                "12",
                "Właściwość odczytujemy jak atrybut, bez nawiasów.",
            ),
            choice(
                "Jak odczytać właściwość pole obiektu p?",
                listOf("p.pole", "p.pole()", "pole(p)", "p[\"pole\"]"),
                0,
                "@property sprawia, że metodę czytamy jak zwykły atrybut.",
            ),
            output(
                "class Osoba:\n    def __init__(self, imie, nazwisko):\n        self.imie = imie\n        self.nazwisko = nazwisko\n    @property\n    def pelne(self):\n        return self.imie + \" \" + self.nazwisko\n\no = Osoba(\"Jan\", \"Nowak\")\no.imie = \"Anna\"\nprint(o.pelne)",
                "Anna Nowak",
                "Właściwość jest liczona przy każdym odczycie, więc widzi nowe imię.",
            ),
            choice(
                "Co się stanie po uruchomieniu tego kodu?",
                listOf("AttributeError – właściwość nie ma settera", "x zmieni się na 10", "SyntaxError", "x zostanie 5, bez błędu"),
                0,
                "Sama @property daje tylko odczyt; przypisanie wymaga settera.",
                code = "class K:\n    @property\n    def x(self):\n        return 5\n\nk = K()\nk.x = 10",
            ),
            fill(
                "Uzupełnij, aby program wypisał 20.",
                "class Kwadrat:\n    def __init__(self, a):\n        self.a = a\n    ____\n    def obwod(self):\n        return 4 * self.a\n\nprint(Kwadrat(5).obwod)",
                listOf("@property", "@staticmethod", "@classmethod"),
                "@property",
                "Dzięki @property obwod odczytujemy bez nawiasów i dostajemy liczbę.",
            ),
            output(
                "class Konto:\n    def __init__(self):\n        self._saldo = 100\n    @property\n    def saldo(self):\n        return self._saldo\n\nprint(Konto().saldo)",
                "100",
                "Właściwość saldo zwraca wartość ukrytą w atrybucie _saldo.",
            ),
            choice(
                "Co oznacza podkreślnik na początku nazwy self._saldo?",
                listOf("Umowę: to atrybut wewnętrzny, nie zmieniaj go z zewnątrz", "Atrybut jest całkowicie niedostępny", "Atrybut jest stałą", "Błąd składni"),
                0,
                "Python nie blokuje dostępu – podkreślnik to tylko umowa między programistami.",
            ),
            tiles(
                "Wypisz właściwość pole obiektu p",
                listOf("print(", "p.pole", ")"),
                listOf("()", "self"),
                "Właściwość czytamy bez nawiasów wywołania.",
            ),
        ),
        lesson(
            "u31l4", "Setter z walidacją",
            output(
                "class Osoba:\n    def __init__(self, wiek):\n        self._wiek = wiek\n    @property\n    def wiek(self):\n        return self._wiek\n    @wiek.setter\n    def wiek(self, w):\n        self._wiek = max(0, w)\n\no = Osoba(20)\no.wiek = -5\nprint(o.wiek)",
                "0",
                "Setter poprawia ujemny wiek na 0.",
            ),
            fill(
                "Uzupełnij dekorator settera.",
                "class Gracz:\n    def __init__(self):\n        self._hp = 10\n    @property\n    def hp(self):\n        return self._hp\n    @hp.____\n    def hp(self, v):\n        self._hp = v\n\ng = Gracz()\ng.hp = 3\nprint(g.hp)",
                listOf("setter", "property", "set"),
                "setter",
                "Setter tworzymy dekoratorem @nazwa.setter.",
            ),
            output(
                "class Produkt:\n    _cena = 0\n    @property\n    def cena(self):\n        return self._cena\n    @cena.setter\n    def cena(self, c):\n        if c >= 0:\n            self._cena = c\n\np = Produkt()\np.cena = 50\np.cena = -1\nprint(p.cena)",
                "50",
                "Setter ignoruje ujemną cenę, więc zostaje 50.",
            ),
            choice(
                "Jak wygląda dekorator settera dla właściwości wiek?",
                listOf("@wiek.setter", "@setter", "@property.setter", "@set_wiek"),
                0,
                "Setter łączymy z właściwością przez jej nazwę: @wiek.setter.",
            ),
            output(
                "class Temp:\n    def __init__(self, c):\n        self.c = c\n    @property\n    def c(self):\n        return self._c\n    @c.setter\n    def c(self, v):\n        self._c = round(v)\n\nprint(Temp(21.7).c)",
                "22",
                "Przypisanie self.c w __init__ też przechodzi przez setter, który zaokrągla.",
            ),
            choice(
                "Dlaczego getter wiek zwraca self._wiek, a nie self.wiek?",
                listOf("self.wiek wywołałby getter w nieskończoność (RecursionError)", "self.wiek jest wolniejsze", "Tak wymaga składnia dekoratora", "Bez różnicy"),
                0,
                "Odczyt self.wiek w getterze wywołałby ten sam getter – to nieskończona rekurencja.",
            ),
            tiles(
                "Ustaw właściwość wiek obiektu o na 30 (zadziała setter)",
                listOf("o.wiek", "=", "30"),
                listOf("==", "o.wiek("),
                "Setter wywołuje się przy zwykłym przypisaniu.",
            ),
        ),
        lesson(
            "u31l5", "Powtórka: atrybuty i metody klasy",
            output(
                "class Bilet:\n    sprzedane = 0\n    def __init__(self):\n        Bilet.sprzedane += 1\n    @classmethod\n    def ile(cls):\n        return cls.sprzedane\n\nfor _ in range(3):\n    Bilet()\nprint(Bilet.ile())",
                "3",
                "Trzy obiekty zwiększyły wspólny licznik, a metoda klasy go zwraca.",
            ),
            choice(
                "Która metoda dostaje klasę jako pierwszy argument?",
                listOf("Z dekoratorem @classmethod", "Z dekoratorem @staticmethod", "Zwykła metoda", "Z dekoratorem @property"),
                0,
                "@classmethod przekazuje klasę w parametrze cls.",
            ),
            output(
                "class Kolo:\n    def __init__(self, r):\n        self.r = r\n    @staticmethod\n    def kwadrat(x):\n        return x * x\n    def pole(self):\n        return 3 * self.kwadrat(self.r)\n\nprint(Kolo(2).pole())",
                "12",
                "Metodę statyczną można wywołać też przez self.",
            ),
            output(
                "class Haslo:\n    @staticmethod\n    def dobre(h):\n        return len(h) >= 8\n\nprint(Haslo.dobre(\"abc\"))\nprint(Haslo.dobre(\"tajne1234\"))",
                "False\nTrue",
                "Metoda statyczna sprawdza tylko długość podanego napisu.",
            ),
            fill(
                "Uzupełnij, aby program wypisał 8.",
                "class Kolo:\n    def __init__(self, r):\n        self.r = r\n    @property\n    def srednica(self):\n        return 2 * self.r\n\nk = Kolo(4)\nprint(k.____)",
                listOf("srednica", "srednica()", "r()"),
                "srednica",
                "Właściwość odczytujemy bez nawiasów.",
            ),
            output(
                "class Temp:\n    def __init__(self, c):\n        self.c = c\n    @property\n    def c(self):\n        return self._c\n    @c.setter\n    def c(self, v):\n        self._c = max(-273, v)\n\nprint(Temp(-300).c)",
                "-273",
                "Setter nie pozwala zejść poniżej -273.",
            ),
            choice(
                "Co wypisze ten kod?",
                listOf("1", "2", "None", "AttributeError"),
                0,
                "a.x = 2 zmienia tylko obiekt a; b nadal widzi atrybut klasy.",
                code = "class A:\n    x = 1\n\na = A()\nb = A()\na.x = 2\nprint(b.x)",
            ),
            tiles(
                "Utwórz obiekt d metodą klasy z_napisu klasy Data z napisem \"1.5\"",
                listOf("d", "=", "Data.z_napisu(", "\"1.5\"", ")"),
                listOf("new", "self."),
                "Alternatywny konstruktor wywołujemy przez nazwę klasy.",
            ),
        ),
    ),
)
