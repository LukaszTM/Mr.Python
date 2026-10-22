package com.mrpython.app.data.course

import com.mrpython.app.domain.CourseUnit

internal val module64 = CourseUnit(
    id = "u64",
    title = "Tydzień powtórek: programowanie obiektowe",
    description = "Klasy, właściwości, metody specjalne, dziedziczenie i wyjątki",
    lessons = listOf(
        lesson(
            "u64l1", "Dzień 1: Klasy i obiekty",
            output(
                "class Pies:\n    def __init__(self, imie):\n        self.imie = imie\n    def daj_glos(self):\n        return self.imie + \": hau\"\np = Pies(\"Burek\")\nprint(p.daj_glos())",
                "Burek: hau",
                "Metoda odczytuje atrybut obiektu przez self.",
            ),
            output(
                "class Kot:\n    nogi = 4\n    def __init__(self, imie):\n        self.imie = imie\na = Kot(\"Mruczek\")\nb = Kot(\"Filemon\")\na.nogi = 3\nprint(a.nogi, b.nogi, Kot.nogi)",
                "3 4 4",
                "a.nogi = 3 tworzy atrybut tylko w obiekcie a; atrybut klasy się nie zmienia.",
            ),
            choice(
                "Czym jest self w metodzie?",
                listOf("Obiektem, na którym wywołano metodę", "Klasą", "Słowem kluczowym Pythona", "Kopią obiektu"),
                0,
                "Przy wywołaniu p.metoda() Python przekazuje p jako self.",
            ),
            output(
                "class Koszyk:\n    rzeczy = []\n    def dodaj(self, r):\n        self.rzeczy.append(r)\na = Koszyk()\nb = Koszyk()\na.dodaj(\"jabłko\")\nprint(b.rzeczy)",
                "['jabłko']",
                "Lista będąca atrybutem klasy jest wspólna dla wszystkich obiektów.",
            ),
            fill(
                "Uzupełnij nazwę metody inicjującej.",
                "class Punkt:\n    def ____(self, x, y):\n        self.x = x\n        self.y = y\np = Punkt(2, 3)\nprint(p.x + p.y)",
                listOf("__init__", "init", "__new__"),
                "__init__",
                "__init__ ustawia atrybuty nowego obiektu.",
            ),
            output(
                "class Licznik:\n    def __init__(self):\n        self.n = 0\n    def klik(self):\n        self.n += 1\n        return self\nc = Licznik()\nc.klik().klik().klik()\nprint(c.n)",
                "3",
                "klik() zwraca self, więc wywołania można łączyć w łańcuch.",
            ),
            tiles(
                "Utwórz obiekt klasy Auto z marką \"Fiat\" i zapisz go w zmiennej a",
                listOf("a", "=", "Auto(", "\"Fiat\"", ")"),
                listOf("new", "Auto."),
                "Obiekt tworzymy, wywołując klasę jak funkcję – bez słowa new.",
            ),
            choice(
                "Co wypisze ten program?",
                listOf("True A", "False A", "True object", "Błąd"),
                0,
                "x jest obiektem klasy A, a type(x).__name__ to nazwa tej klasy.",
                code = "class A:\n    pass\nx = A()\nprint(isinstance(x, A), type(x).__name__)",
            ),
        ),
        lesson(
            "u64l2", "Dzień 2: Właściwości",
            output(
                "class Kolo:\n    def __init__(self, r):\n        self.r = r\n    @property\n    def srednica(self):\n        return 2 * self.r\nk = Kolo(5)\nprint(k.srednica)",
                "10",
                "Właściwość odczytujemy jak atrybut, bez nawiasów.",
            ),
            choice(
                "Jak odczytać właściwość srednica obiektu k?",
                listOf("k.srednica", "k.srednica()", "k.get_srednica()", "srednica(k)"),
                0,
                "@property sprawia, że metodę czyta się jak zwykły atrybut.",
            ),
            output(
                "class Konto:\n    _saldo = 0\n    @property\n    def saldo(self):\n        return self._saldo\n    @saldo.setter\n    def saldo(self, v):\n        self._saldo = max(0, v)\nk = Konto()\nk.saldo = -50\nprint(k.saldo)",
                "0",
                "Setter pilnuje, by saldo nie spadło poniżej zera.",
            ),
            output(
                "class Osoba:\n    def __init__(self, rok):\n        self.rok = rok\n    @property\n    def wiek(self):\n        return 2026 - self.rok\no = Osoba(2000)\ntry:\n    o.wiek = 5\nexcept AttributeError:\n    print(\"tylko do odczytu\")\nprint(o.wiek)",
                "tylko do odczytu\n26",
                "Właściwość bez settera można tylko czytać.",
            ),
            fill(
                "Uzupełnij, aby dało się ustawić wartość t.c.",
                "class Temp:\n    _c = 0\n    @property\n    def c(self):\n        return self._c\n    @c.____\n    def c(self, v):\n        self._c = v\nt = Temp()\nt.c = 21\nprint(t.c)",
                listOf("setter", "getter", "property"),
                "setter",
                "@nazwa.setter definiuje metodę wywoływaną przy przypisaniu.",
            ),
            output(
                "class Prostokat:\n    def __init__(self, a, b):\n        self.a, self.b = a, b\n    @property\n    def pole(self):\n        return self.a * self.b\np = Prostokat(2, 3)\np.a = 10\nprint(p.pole)",
                "30",
                "Właściwość liczy się przy każdym odczycie, więc widzi nowe a.",
            ),
            choice(
                "Co oznacza podkreślenie na początku nazwy self._saldo?",
                listOf("Umowną informację: to atrybut wewnętrzny", "Python blokuje do niego dostęp", "Atrybut staje się stałą", "Atrybut jest szybszy"),
                0,
                "Jedno podkreślenie to tylko konwencja – dostęp nadal jest możliwy.",
            ),
            tiles(
                "Napisz metodę pole (do użycia pod @property), która zwraca iloczyn a i b",
                listOf("def", "pole(self):", "return", "self.a * self.b"),
                listOf("pole():", "self.a + self.b"),
                "Właściwość to metoda z jednym parametrem self.",
            ),
        ),
        lesson(
            "u64l3", "Dzień 3: Metody klasowe i statyczne",
            output(
                "class Data:\n    def __init__(self, d, m):\n        self.d, self.m = d, m\n    @classmethod\n    def z_napisu(cls, s):\n        d, m = s.split(\".\")\n        return cls(int(d), int(m))\nx = Data.z_napisu(\"22.10\")\nprint(x.d + x.m)",
                "32",
                "Metoda klasowa to wygodny alternatywny konstruktor: 22 + 10 = 32.",
            ),
            output(
                "class Mat:\n    @staticmethod\n    def czy_parzysta(n):\n        return n % 2 == 0\nprint(Mat.czy_parzysta(4), Mat().czy_parzysta(7))",
                "True False",
                "Metodę statyczną wywołamy i na klasie, i na obiekcie.",
            ),
            choice(
                "Co dostaje jako pierwszy argument metoda z @classmethod?",
                listOf("Klasę (cls)", "Obiekt (self)", "Nic", "Moduł"),
                0,
                "Metoda klasowa dostaje klasę, na której ją wywołano.",
            ),
            output(
                "class Gracz:\n    liczba = 0\n    def __init__(self):\n        Gracz.liczba += 1\n    @classmethod\n    def ile(cls):\n        return cls.liczba\nGracz(); Gracz(); Gracz()\nprint(Gracz.ile())",
                "3",
                "Każdy nowy obiekt zwiększa licznik zapisany w klasie.",
            ),
            fill(
                "Uzupełnij, aby metodę dało się wywołać bez self i cls.",
                "class Konwerter:\n    @____\n    def km_na_m(km):\n        return km * 1000\nprint(Konwerter.km_na_m(3))",
                listOf("staticmethod", "classmethod", "property"),
                "staticmethod",
                "Metoda statyczna nie dostaje ani obiektu, ani klasy.",
            ),
            output(
                "class Zwierze:\n    @classmethod\n    def nowe(cls):\n        return cls()\nclass Kot(Zwierze):\n    pass\nprint(type(Kot.nowe()).__name__)",
                "Kot",
                "cls to klasa, na której wywołano metodę – tutaj Kot.",
            ),
            choice(
                "Kiedy najlepiej użyć @staticmethod?",
                listOf("Gdy metoda nie potrzebuje ani self, ani cls", "Gdy metoda zmienia atrybuty obiektu", "Gdy tworzymy alternatywny konstruktor", "Zawsze w klasach"),
                0,
                "Metoda statyczna to zwykła funkcja umieszczona w klasie dla porządku.",
            ),
            tiles(
                "Napisz nagłówek metody klasowej z_listy przyjmującej listę dane",
                listOf("def", "z_listy(", "cls,", "dane", "):"),
                listOf("cls.", "dane)"),
                "Pierwszym parametrem metody klasowej jest cls.",
            ),
        ),
        lesson(
            "u64l4", "Dzień 4: Metody specjalne",
            output(
                "class Ulamek:\n    def __init__(self, l, m):\n        self.l, self.m = l, m\n    def __str__(self):\n        return f\"{self.l}/{self.m}\"\nu = Ulamek(3, 4)\nprint(u)\nprint(f\"[{u}]\")",
                "3/4\n[3/4]",
                "print i f-napisy korzystają z __str__.",
            ),
            output(
                "class Wektor:\n    def __init__(self, x, y):\n        self.x, self.y = x, y\n    def __add__(self, o):\n        return Wektor(self.x + o.x, self.y + o.y)\nw = Wektor(1, 2) + Wektor(3, 4)\nprint(w.x, w.y)",
                "4 6",
                "Operator + wywołuje metodę __add__.",
            ),
            output(
                "class Talia:\n    def __init__(self):\n        self.karty = [\"A\", \"K\", \"Q\"]\n    def __len__(self):\n        return len(self.karty)\n    def __getitem__(self, i):\n        return self.karty[i]\nt = Talia()\nprint(len(t), t[-1])",
                "3 Q",
                "len() woła __len__, a indeksowanie – __getitem__.",
            ),
            choice(
                "Którą metodę trzeba zdefiniować, aby a == b porównywało obiekty po wartościach?",
                listOf("__eq__", "__cmp__", "__equal__", "__is__"),
                0,
                "Operator == wywołuje __eq__.",
            ),
            output(
                "class Wynik:\n    def __init__(self, p):\n        self.p = p\n    def __lt__(self, o):\n        return self.p < o.p\nw = sorted([Wynik(5), Wynik(2), Wynik(9)])\nprint([x.p for x in w])",
                "[2, 5, 9]",
                "sorted() porównuje obiekty operatorem <, czyli metodą __lt__.",
            ),
            fill(
                "Uzupełnij, aby działał operator in.",
                "class Zespol:\n    def __init__(self, *osoby):\n        self.osoby = osoby\n    def ____(self, x):\n        return x in self.osoby\nz = Zespol(\"Ola\", \"Jan\")\nprint(\"Ola\" in z)",
                listOf("__contains__", "__in__", "__has__"),
                "__contains__",
                "x in obiekt wywołuje __contains__.",
            ),
            output(
                "class Pudelko:\n    def __init__(self, rzeczy):\n        self.rzeczy = rzeczy\n    def __len__(self):\n        return len(self.rzeczy)\nprint(bool(Pudelko([])), bool(Pudelko([1])))",
                "False True",
                "Bez __bool__ Python sprawdza __len__: długość 0 to fałsz.",
            ),
            tiles(
                "Napisz nagłówek metody, dzięki której obiekt można wywołać jak funkcję: obj(x)",
                listOf("def", "__call__(", "self,", "x", "):"),
                listOf("__init__(", "__run__("),
                "Wywołanie obj(x) uruchamia metodę __call__.",
            ),
        ),
        lesson(
            "u64l5", "Dzień 5: Dziedziczenie",
            output(
                "class Zwierze:\n    def opis(self):\n        return \"zwierzę\"\nclass Pies(Zwierze):\n    def opis(self):\n        return \"pies, \" + super().opis()\nprint(Pies().opis())",
                "pies, zwierzę",
                "super().opis() wywołuje wersję metody z klasy bazowej.",
            ),
            output(
                "class Osoba:\n    def __init__(self, imie):\n        self.imie = imie\nclass Uczen(Osoba):\n    def __init__(self, imie, klasa):\n        super().__init__(imie)\n        self.klasa = klasa\nu = Uczen(\"Ola\", \"3b\")\nprint(u.imie, u.klasa)",
                "Ola 3b",
                "super().__init__ ustawia atrybuty z klasy bazowej.",
            ),
            choice(
                "Co się stanie?",
                listOf("AttributeError – __init__ klasy A się nie wykonał", "Wypisze 1", "Wypisze 2", "Wypisze None"),
                0,
                "B nadpisuje __init__ i nie woła super().__init__(), więc x nie istnieje.",
                code = "class A:\n    def __init__(self):\n        self.x = 1\nclass B(A):\n    def __init__(self):\n        self.y = 2\nprint(B().x)",
            ),
            output(
                "class Ksztalt:\n    def pole(self):\n        return 0\nclass Kwadrat(Ksztalt):\n    def __init__(self, a):\n        self.a = a\n    def pole(self):\n        return self.a ** 2\nfigury = [Ksztalt(), Kwadrat(3)]\nprint(sum(f.pole() for f in figury))",
                "9",
                "Każdy obiekt używa własnej wersji pole(): 0 + 9.",
            ),
            choice(
                "Co wypisze ten program?",
                listOf("True False", "True True", "False True", "False False"),
                0,
                "b jest też obiektem klasy A, ale A nie jest podklasą B.",
                code = "class A: pass\nclass B(A): pass\nb = B()\nprint(isinstance(b, A), issubclass(A, B))",
            ),
            fill(
                "Uzupełnij, aby Rower dziedziczył po Pojazd (program ma wypisać 2 True).",
                "class Pojazd:\n    kola = 4\nclass Rower(____):\n    kola = 2\nr = Rower()\nprint(r.kola, isinstance(r, Pojazd))",
                listOf("Pojazd", "self", "object"),
                "Pojazd",
                "Klasę bazową podajemy w nawiasie po nazwie klasy.",
            ),
            output(
                "class A:\n    def kto(self): return \"A\"\nclass B(A):\n    def kto(self): return \"B\"\nclass C(A):\n    def kto(self): return \"C\"\nclass D(B, C):\n    pass\nprint(D().kto())",
                "B",
                "Python szuka metody w klasach bazowych od lewej: najpierw B.",
            ),
            tiles(
                "Zapisz w zmiennej wynik wynik metody opis z klasy bazowej z dopisanym \"!\"",
                listOf("wynik", "=", "super().opis()", "+", "\"!\""),
                listOf("self.opis()", "super.opis()"),
                "super() daje dostęp do metod klasy bazowej.",
            ),
        ),
        lesson(
            "u64l6", "Dzień 6: dataclasses",
            output(
                "from dataclasses import dataclass\n@dataclass\nclass Punkt:\n    x: int\n    y: int\np = Punkt(1, 2)\nprint(p)",
                "Punkt(x=1, y=2)",
                "@dataclass sam tworzy __init__ i czytelny __repr__.",
            ),
            output(
                "from dataclasses import dataclass\n@dataclass\nclass Kolor:\n    nazwa: str\nprint(Kolor(\"red\") == Kolor(\"red\"))",
                "True",
                "dataclass dodaje __eq__ porównujące pola.",
            ),
            output(
                "from dataclasses import dataclass, field\n@dataclass\nclass Koszyk:\n    wlasciciel: str\n    rzeczy: list = field(default_factory=list)\na = Koszyk(\"Ola\")\na.rzeczy.append(\"ser\")\nprint(Koszyk(\"Jan\").rzeczy, len(a.rzeczy))",
                "[] 1",
                "default_factory tworzy nową listę dla każdego obiektu.",
            ),
            choice(
                "Dlaczego w dataclass nie piszemy rzeczy: list = []?",
                listOf("Zgłosi ValueError, bo lista byłaby wspólna dla obiektów", "To działa tak samo", "Listy nie mogą być polami", "Bo trzeba napisać list()"),
                0,
                "Zmienne wartości domyślne podajemy przez field(default_factory=list).",
            ),
            output(
                "from dataclasses import dataclass\n@dataclass(frozen=True)\nclass Para:\n    a: int\n    b: int\np = Para(1, 2)\ntry:\n    p.a = 5\nexcept Exception as e:\n    print(type(e).__name__)",
                "FrozenInstanceError",
                "frozen=True zabrania zmieniania pól.",
            ),
            fill(
                "Uzupełnij, aby obiekty dało się porównywać operatorem <.",
                "from dataclasses import dataclass\n@dataclass(____=True)\nclass Wersja:\n    glowna: int\n    poboczna: int\nprint(Wersja(1, 9) < Wersja(2, 0))",
                listOf("order", "frozen", "eq"),
                "order",
                "order=True dodaje <, <=, > i >= porównujące pola po kolei.",
            ),
            output(
                "from dataclasses import dataclass\n@dataclass\nclass Produkt:\n    cena: float\n    ilosc: int\n    def wartosc(self):\n        return self.cena * self.ilosc\nprint(Produkt(2.5, 4).wartosc())",
                "10.0",
                "W dataclass można pisać zwykłe metody.",
            ),
            tiles(
                "Zadeklaruj w dataclass pole wiek typu int z domyślną wartością 0",
                listOf("wiek", ":", "int", "=", "0"),
                listOf("==", "->"),
                "Pole to adnotacja typu z opcjonalną wartością domyślną.",
            ),
        ),
        lesson(
            "u64l7", "Dzień 7: Własne wyjątki",
            output(
                "class BladWieku(Exception):\n    pass\ntry:\n    raise BladWieku(\"za młody\")\nexcept BladWieku as e:\n    print(\"Błąd:\", e)",
                "Błąd: za młody",
                "Własny wyjątek działa jak wbudowane – ma komunikat.",
            ),
            output(
                "class BladAplikacji(Exception): pass\nclass BrakSrodkow(BladAplikacji): pass\ntry:\n    raise BrakSrodkow()\nexcept BladAplikacji:\n    print(\"złapany przez bazowy\")",
                "złapany przez bazowy",
                "except łapie też wyjątki klas pochodnych.",
            ),
            choice(
                "Po jakiej klasie zwykle dziedziczy własny wyjątek?",
                listOf("Exception", "object", "Error", "str"),
                0,
                "Własne wyjątki dziedziczą po Exception (lub jego podklasie).",
            ),
            output(
                "class BrakTowaru(Exception):\n    def __init__(self, nazwa):\n        super().__init__(f\"brak: {nazwa}\")\n        self.nazwa = nazwa\ntry:\n    raise BrakTowaru(\"mleko\")\nexcept BrakTowaru as e:\n    print(e.nazwa)\n    print(e)",
                "mleko\nbrak: mleko",
                "Wyjątek może mieć własne atrybuty i komunikat.",
            ),
            choice(
                "Co wypisze ten program?",
                listOf("A", "B", "A i B", "Nic"),
                0,
                "Wykonuje się pierwszy pasujący except, a B jest podklasą A.",
                code = "class A(Exception): pass\nclass B(A): pass\ntry:\n    raise B()\nexcept A:\n    print(\"A\")\nexcept B:\n    print(\"B\")",
            ),
            fill(
                "Uzupełnij, aby funkcja zgłosiła wyjątek dla złego kodu.",
                "class ZlyKod(Exception):\n    pass\ndef sprawdz(kod):\n    if len(kod) != 4:\n        ____ ZlyKod(kod)\ntry:\n    sprawdz(\"12\")\nexcept ZlyKod:\n    print(\"zły kod\")",
                listOf("raise", "return", "throw"),
                "raise",
                "Wyjątek zgłaszamy słowem raise.",
            ),
            output(
                "class BladDanych(Exception): pass\ndef wczytaj(s):\n    try:\n        return int(s)\n    except ValueError:\n        raise BladDanych(\"nie liczba\")\nfor s in [\"7\", \"x\"]:\n    try:\n        print(wczytaj(s))\n    except BladDanych as e:\n        print(e)",
                "7\nnie liczba",
                "ValueError zostaje zamieniony na nasz własny wyjątek.",
            ),
            tiles(
                "Zdefiniuj wyjątek BladLogowania dziedziczący po Exception",
                listOf("class", "BladLogowania(", "Exception", "):"),
                listOf("def", "Error"),
                "Wyjątek to klasa dziedzicząca po Exception.",
            ),
        ),
    ),
)
