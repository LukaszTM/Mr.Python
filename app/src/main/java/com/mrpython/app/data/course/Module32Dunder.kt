package com.mrpython.app.data.course

import com.mrpython.app.domain.CourseUnit

internal val module32 = CourseUnit(
    id = "u32",
    title = "Metody specjalne",
    description = "__repr__, porównania, operatory i własne kolekcje",
    lessons = listOf(
        lesson(
            "u32l1", "__repr__ i __str__",
            output(
                "class Pies:\n    def __init__(self, imie):\n        self.imie = imie\n    def __repr__(self):\n        return f\"Pies('{self.imie}')\"\n\nprint(Pies(\"Reks\"))",
                "Pies('Reks')",
                "Bez __str__ funkcja print używa __repr__.",
            ),
            output(
                "class P:\n    def __init__(self, x):\n        self.x = x\n    def __repr__(self):\n        return f\"P({self.x})\"\n\nprint([P(1), P(2)])",
                "[P(1), P(2)]",
                "Lista pokazuje swoje elementy za pomocą __repr__.",
            ),
            output(
                "class Lek:\n    def __str__(self):\n        return \"lek\"\n    def __repr__(self):\n        return \"Lek()\"\n\nl = Lek()\nprint(l)\nprint([l])",
                "lek\n[Lek()]",
                "print(obiekt) używa __str__, a lista w środku używa __repr__.",
            ),
            choice(
                "Do czego służy __repr__?",
                listOf("Jednoznaczny opis obiektu dla programisty", "Ładny tekst dla użytkownika", "Porównywanie obiektów", "Tworzenie obiektu"),
                0,
                "__repr__ to techniczny opis, często wyglądający jak kod tworzący obiekt.",
            ),
            output(
                "class A:\n    def __str__(self):\n        return \"ładny\"\n    def __repr__(self):\n        return \"techniczny\"\n\na = A()\nprint(str(a), repr(a))",
                "ładny techniczny",
                "str() wywołuje __str__, a repr() wywołuje __repr__.",
            ),
            fill(
                "Uzupełnij, aby program wypisał [Punkt(1, 2)].",
                "class Punkt:\n    def ____(self):\n        return \"Punkt(1, 2)\"\n\nprint([Punkt()])",
                listOf("__repr__", "__str__", "__init__"),
                "__repr__",
                "Elementy listy są pokazywane przez __repr__, a nie __str__.",
            ),
            choice(
                "Co wypisze print(obiekt), gdy klasa nie ma ani __str__, ani __repr__?",
                listOf("Coś w rodzaju <__main__.Klasa object at 0x...>", "Nic", "Błąd TypeError", "Listę atrybutów"),
                0,
                "Domyślny opis zawiera tylko nazwę klasy i adres w pamięci.",
            ),
            tiles(
                "Napisz nagłówek metody __repr__",
                listOf("def", "__repr__(", "self", "):"),
                listOf("return", "__print__("),
                "__repr__ przyjmuje tylko self i zwraca napis.",
            ),
        ),
        lesson(
            "u32l2", "__eq__ i __lt__",
            output(
                "class P:\n    def __init__(self, x):\n        self.x = x\n\nprint(P(1) == P(1))",
                "False",
                "Bez __eq__ operator == sprawdza, czy to ten sam obiekt.",
            ),
            output(
                "class P:\n    def __init__(self, x):\n        self.x = x\n    def __eq__(self, other):\n        return self.x == other.x\n\nprint(P(1) == P(1))\nprint(P(1) != P(2))",
                "True\nTrue",
                "__eq__ porównuje atrybuty, a != Python wylicza z __eq__.",
            ),
            choice(
                "Co domyślnie sprawdza == dla obiektów własnej klasy?",
                listOf("Czy to ten sam obiekt", "Czy wszystkie atrybuty są równe", "Czy mają tę samą klasę", "Zawsze zwraca True"),
                0,
                "Bez __eq__ dwa różne obiekty nigdy nie są równe.",
            ),
            output(
                "class Zad:\n    def __init__(self, p):\n        self.p = p\n    def __lt__(self, other):\n        return self.p < other.p\n    def __repr__(self):\n        return f\"Zad({self.p})\"\n\nprint(sorted([Zad(3), Zad(1), Zad(2)]))",
                "[Zad(1), Zad(2), Zad(3)]",
                "sorted porównuje obiekty operatorem <, czyli metodą __lt__.",
            ),
            fill(
                "Uzupełnij, aby sorted ułożył osoby rosnąco wg wieku (wypisze 20).",
                "class Osoba:\n    def __init__(self, wiek):\n        self.wiek = wiek\n    def ____(self, other):\n        return self.wiek < other.wiek\n\nludzie = sorted([Osoba(30), Osoba(20)])\nprint(ludzie[0].wiek)",
                listOf("__lt__", "__eq__", "__gt__"),
                "__lt__",
                "__lt__ (less than) obsługuje operator <, którego używa sorted.",
            ),
            output(
                "class Karta:\n    def __init__(self, w):\n        self.w = w\n    def __lt__(self, o):\n        return self.w < o.w\n\nk = max([Karta(5), Karta(9), Karta(2)])\nprint(k.w)",
                "9",
                "max też umie porównywać obiekty, gdy mają __lt__.",
            ),
            choice(
                "Co się stanie po uruchomieniu tego kodu?",
                listOf("TypeError – brak porównania <", "Wypisze True", "Wypisze False", "SyntaxError"),
                0,
                "Bez __lt__ Python nie wie, jak porównać dwa obiekty operatorem <.",
                code = "class P:\n    def __init__(self, x):\n        self.x = x\n\nprint(P(1) < P(2))",
            ),
            tiles(
                "Porównaj obiekty a i b operatorem równości i wypisz wynik",
                listOf("print(", "a", "==", "b", ")"),
                listOf("=", "equals("),
                "Operator == wywołuje metodę __eq__.",
            ),
        ),
        lesson(
            "u32l3", "__len__, __contains__, __getitem__",
            output(
                "class Playlista:\n    def __init__(self, utwory):\n        self.utwory = utwory\n    def __len__(self):\n        return len(self.utwory)\n\np = Playlista([\"a\", \"b\", \"c\"])\nprint(len(p))",
                "3",
                "len(obiekt) wywołuje metodę __len__.",
            ),
            output(
                "class Klub:\n    def __init__(self):\n        self.czlonkowie = [\"Ala\", \"Ola\"]\n    def __contains__(self, imie):\n        return imie in self.czlonkowie\n\nk = Klub()\nprint(\"Ala\" in k, \"Ewa\" in k)",
                "True False",
                "Operator in wywołuje metodę __contains__.",
            ),
            output(
                "class Tydzien:\n    dni = [\"pon\", \"wt\", \"śr\"]\n    def __getitem__(self, i):\n        return self.dni[i]\n\nt = Tydzien()\nprint(t[0], t[-1])",
                "pon śr",
                "Nawiasy kwadratowe obiekt[i] wywołują __getitem__.",
            ),
            output(
                "class Trzy:\n    def __getitem__(self, i):\n        if i >= 3:\n            raise IndexError\n        return i * 10\n\nfor x in Trzy():\n    print(x)",
                "0\n10\n20",
                "Pętla for pyta o kolejne indeksy, aż dostanie IndexError.",
            ),
            fill(
                "Uzupełnij, aby len(z) zadziałało.",
                "class Zbior:\n    def __init__(self):\n        self.dane = [1, 2]\n    def ____(self):\n        return len(self.dane)\n\nz = Zbior()\nprint(len(z))",
                listOf("__len__", "len", "__size__"),
                "__len__",
                "Funkcja len() szuka metody __len__.",
            ),
            choice(
                "Która metoda specjalna obsługuje operator in?",
                listOf("__contains__", "__in__", "__has__", "__include__"),
                0,
                "x in obiekt wywołuje obiekt.__contains__(x).",
            ),
            choice(
                "Która metoda pozwala pisać obiekt[0]?",
                listOf("__getitem__", "__get__", "__item__", "__at__"),
                0,
                "Odczyt przez nawiasy kwadratowe obsługuje __getitem__.",
            ),
            tiles(
                "Sprawdź, czy \"Ala\" należy do obiektu klub, i wypisz wynik",
                listOf("print(", "\"Ala\"", "in", "klub", ")"),
                listOf("klub.has(", "=="),
                "Operator in korzysta z __contains__.",
            ),
        ),
        lesson(
            "u32l4", "__add__ i inne operatory",
            output(
                "class Wektor:\n    def __init__(self, x, y):\n        self.x = x\n        self.y = y\n    def __add__(self, o):\n        return Wektor(self.x + o.x, self.y + o.y)\n\nw = Wektor(1, 2) + Wektor(3, 4)\nprint(w.x, w.y)",
                "4 6",
                "Operator + wywołuje __add__, który zwraca nowy wektor.",
            ),
            output(
                "class Kwota:\n    def __init__(self, zl):\n        self.zl = zl\n    def __mul__(self, n):\n        return Kwota(self.zl * n)\n\nprint((Kwota(5) * 3).zl)",
                "15",
                "Operator * wywołuje __mul__.",
            ),
            choice(
                "Która metoda obsługuje odejmowanie a - b?",
                listOf("__sub__", "__minus__", "__neg__", "__del__"),
                0,
                "__sub__ to odejmowanie; __neg__ obsługuje jednoargumentowy minus (-a).",
            ),
            fill(
                "Uzupełnij, aby program wypisał 15.",
                "class Czas:\n    def __init__(self, m):\n        self.m = m\n    def ____(self, o):\n        return Czas(self.m + o.m)\n\nprint((Czas(10) + Czas(5)).m)",
                listOf("__add__", "__plus__", "__sum__"),
                "__add__",
                "Operator + szuka metody __add__.",
            ),
            choice(
                "Co się stanie po uruchomieniu tego kodu?",
                listOf("TypeError – liczba nie umie pomnożyć się przez Kwota", "k będzie Kwota z zl = 15", "k będzie liczbą 15", "SyntaxError"),
                0,
                "3 * obiekt wymaga metody __rmul__; samo __mul__ działa tylko dla obiekt * 3.",
                code = "class Kwota:\n    def __init__(self, zl):\n        self.zl = zl\n    def __mul__(self, n):\n        return Kwota(self.zl * n)\n\nk = 3 * Kwota(5)",
            ),
            output(
                "class Koszyk:\n    def __init__(self, rzeczy):\n        self.rzeczy = rzeczy\n    def __add__(self, o):\n        return Koszyk(self.rzeczy + o.rzeczy)\n\nk = Koszyk([\"chleb\"]) + Koszyk([\"mleko\"])\nprint(k.rzeczy)",
                "['chleb', 'mleko']",
                "__add__ łączy listy z obu koszyków.",
            ),
            output(
                "class Licznik:\n    def __init__(self, n):\n        self.n = n\n    def __add__(self, k):\n        return Licznik(self.n + k)\n\nc = Licznik(1)\nc += 5\nprint(c.n)",
                "6",
                "Bez __iadd__ zapis c += 5 korzysta z __add__.",
            ),
            tiles(
                "Napisz nagłówek metody obsługującej operator +",
                listOf("def", "__add__(", "self,", "other):"),
                listOf("__plus__(", "+"),
                "Dodawanie obsługuje __add__(self, other).",
            ),
        ),
        lesson(
            "u32l5", "Powtórka: metody specjalne",
            output(
                "class Ocena:\n    def __init__(self, v):\n        self.v = v\n    def __lt__(self, o):\n        return self.v < o.v\n    def __repr__(self):\n        return str(self.v)\n\nprint(sorted([Ocena(4), Ocena(2)]))",
                "[2, 4]",
                "__lt__ pozwala sortować, a __repr__ decyduje o wyglądzie w liście.",
            ),
            choice(
                "Którą metodę wywołuje len(obiekt)?",
                listOf("__len__", "__size__", "__count__", "__getitem__"),
                0,
                "len() korzysta z __len__.",
            ),
            output(
                "class Kolor:\n    def __init__(self, n):\n        self.n = n\n    def __eq__(self, o):\n        return self.n.lower() == o.n.lower()\n\nprint(Kolor(\"RED\") == Kolor(\"red\"))",
                "True",
                "Nasze __eq__ porównuje nazwy bez względu na wielkość liter.",
            ),
            output(
                "class Slowo:\n    def __init__(self, s):\n        self.s = s\n    def __len__(self):\n        return len(self.s)\n    def __getitem__(self, i):\n        return self.s[i]\n\nw = Slowo(\"kot\")\nprint(len(w), w[1])",
                "3 o",
                "len() używa __len__, a w[1] używa __getitem__.",
            ),
            fill(
                "Uzupełnij, aby program wypisał 7.",
                "class Punkty:\n    def __init__(self, n):\n        self.n = n\n    def ____(self, o):\n        return Punkty(self.n - o.n)\n\nprint((Punkty(10) - Punkty(3)).n)",
                listOf("__sub__", "__add__", "__minus__"),
                "__sub__",
                "Operator - wywołuje __sub__.",
            ),
            choice(
                "Z której metody korzysta print(x), gdy klasa ma tylko __repr__?",
                listOf("__repr__", "__len__", "__init__", "__eq__"),
                0,
                "Gdy brak __str__, Python używa __repr__.",
            ),
            output(
                "class Zakres:\n    def __init__(self, a, b):\n        self.a = a\n        self.b = b\n    def __contains__(self, x):\n        return self.a <= x <= self.b\n\nz = Zakres(1, 10)\nprint(5 in z, 11 in z)",
                "True False",
                "__contains__ sprawdza, czy liczba mieści się w zakresie.",
            ),
            tiles(
                "Dodaj wektory a i b i zapisz wynik w w",
                listOf("w", "=", "a", "+", "b"),
                listOf("a.add(", "=="),
                "Dzięki __add__ obiekty dodajemy zwykłym plusem.",
            ),
        ),
    ),
)
