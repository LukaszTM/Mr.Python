package com.mrpython.app.data.course

import com.mrpython.app.domain.CourseUnit

internal val module37 = CourseUnit(
    id = "u37",
    title = "Kompozycja obiektów",
    description = "Obiekty złożone z innych obiektów i delegowanie",
    lessons = listOf(
        lesson(
            "u37l1", "Obiekty w obiektach",
            output(
                "class Ksiazka:\n    def __init__(self, tytul):\n        self.tytul = tytul\n\nclass Biblioteka:\n    def __init__(self):\n        self.ksiazki = []\n\nb = Biblioteka()\nb.ksiazki.append(Ksiazka(\"Lalka\"))\nb.ksiazki.append(Ksiazka(\"Potop\"))\nprint(b.ksiazki[1].tytul)",
                "Potop",
                "Biblioteka przechowuje listę obiektów Ksiazka.",
            ),
            output(
                "class Gracz:\n    def __init__(self, imie, gole):\n        self.imie = imie\n        self.gole = gole\n\nclass Druzyna:\n    def __init__(self, gracze):\n        self.gracze = gracze\n    def gole(self):\n        return sum(g.gole for g in self.gracze)\n\nd = Druzyna([Gracz(\"Ala\", 2), Gracz(\"Ola\", 3)])\nprint(d.gole())",
                "5",
                "Drużyna sumuje gole swoich graczy.",
            ),
            choice(
                "Czym jest kompozycja?",
                listOf("Obiekt zawiera inne obiekty jako swoje atrybuty", "Klasa dziedziczy po kilku klasach", "Łączenie dwóch list", "Tworzenie klasy wewnątrz funkcji"),
                0,
                "Kompozycja to budowanie obiektu z innych obiektów.",
            ),
            output(
                "class Silnik:\n    def __init__(self, moc):\n        self.moc = moc\n\nclass Auto:\n    def __init__(self, moc):\n        self.silnik = Silnik(moc)\n\na = Auto(150)\nprint(a.silnik.moc)",
                "150",
                "Przez a.silnik dostajemy się do obiektu Silnik, a potem do jego mocy.",
            ),
            fill(
                "Uzupełnij, aby wypisać moc silnika auta (150).",
                "class Silnik:\n    def __init__(self, moc):\n        self.moc = moc\n\nclass Auto:\n    def __init__(self, moc):\n        self.silnik = Silnik(moc)\n\na = Auto(150)\nprint(a.____.moc)",
                listOf("silnik", "Silnik", "moc"),
                "silnik",
                "Atrybut auta nazywa się silnik (mała litera), a Silnik to nazwa klasy.",
            ),
            output(
                "class Ksiazka:\n    def __init__(self, t):\n        self.t = t\n\nclass Polka:\n    def __init__(self):\n        self.ksiazki = [Ksiazka(\"A\"), Ksiazka(\"B\")]\n    def tytuly(self):\n        return [k.t for k in self.ksiazki]\n\nprint(Polka().tytuly())",
                "['A', 'B']",
                "Metoda półki zbiera tytuły ze wszystkich książek.",
            ),
            tiles(
                "W __init__ utwórz atrybut silnik jako nowy obiekt Silnik(100)",
                listOf("self.silnik", "=", "Silnik(", "100", ")"),
                listOf("Auto(", "=="),
                "Atrybut może przechowywać obiekt innej klasy.",
            ),
            choice(
                "Auto ma silnik. Jaka to relacja?",
                listOf("Kompozycja („ma”)", "Dziedziczenie („jest”)", "Polimorfizm", "Żadna"),
                0,
                "Relację „ma” modelujemy kompozycją.",
            ),
        ),
        lesson(
            "u37l2", "Delegowanie",
            output(
                "class Silnik:\n    def start(self):\n        return \"brum\"\n\nclass Auto:\n    def __init__(self):\n        self.silnik = Silnik()\n    def jedz(self):\n        return self.silnik.start()\n\nprint(Auto().jedz())",
                "brum",
                "Auto deleguje uruchomienie do swojego silnika.",
            ),
            choice(
                "Czym jest delegowanie?",
                listOf("Przekazaniem zadania obiektowi, który jest częścią naszego obiektu", "Kopiowaniem metod z klasy bazowej", "Usuwaniem obiektu", "Wywołaniem super()"),
                0,
                "Obiekt zleca pracę swojemu składnikowi.",
            ),
            output(
                "class Biblioteka:\n    def __init__(self):\n        self.ksiazki = [\"Lalka\", \"Potop\"]\n    def __len__(self):\n        return len(self.ksiazki)\n    def __contains__(self, t):\n        return t in self.ksiazki\n\nb = Biblioteka()\nprint(len(b), \"Lalka\" in b)",
                "2 True",
                "Metody specjalne delegują pracę do wewnętrznej listy.",
            ),
            fill(
                "Uzupełnij, aby auto delegowało start do silnika (wypisze brum).",
                "class Silnik:\n    def start(self):\n        return \"brum\"\n\nclass Auto:\n    def __init__(self):\n        self.silnik = Silnik()\n    def jedz(self):\n        return self.____.start()\n\nprint(Auto().jedz())",
                listOf("silnik", "Silnik", "start"),
                "silnik",
                "Metodę wywołujemy na atrybucie self.silnik.",
            ),
            output(
                "class Gracz:\n    def __init__(self, imie, pkt):\n        self.imie = imie\n        self.pkt = pkt\n\nclass Druzyna:\n    def __init__(self, gracze):\n        self.gracze = gracze\n    def najlepszy(self):\n        g = max(self.gracze, key=lambda g: g.pkt)\n        return g.imie\n\nd = Druzyna([Gracz(\"Jan\", 7), Gracz(\"Ewa\", 9)])\nprint(d.najlepszy())",
                "Ewa",
                "Drużyna przeszukuje swoich graczy i zwraca imię najlepszego.",
            ),
            choice(
                "Dlaczego Auto.jedz() wywołuje self.silnik.start(), a nie robi wszystkiego samo?",
                listOf("Każda klasa odpowiada za swoje zadanie – Auto zleca pracę silnikowi", "Bo Auto nie może mieć metod", "Bo tak wymaga dziedziczenie", "Żeby program działał wolniej"),
                0,
                "Delegowanie dzieli odpowiedzialność między klasy.",
            ),
            tiles(
                "Uruchom silnik auta a i zapisz wynik w zmiennej w",
                listOf("w", "=", "a.silnik", ".start()"),
                listOf("Silnik", "super()"),
                "Metodę start ma silnik, więc wywołujemy ją przez a.silnik.",
            ),
            output(
                "class Druzyna:\n    def __init__(self, gracze):\n        self.gracze = gracze\n    def __getitem__(self, i):\n        return self.gracze[i]\n\nd = Druzyna([\"Ala\", \"Ola\", \"Ela\"])\nprint(d[0], d[-1])",
                "Ala Ela",
                "__getitem__ deleguje indeksowanie do listy graczy.",
            ),
        ),
        lesson(
            "u37l3", "Kompozycja czy dziedziczenie?",
            choice(
                "Pies i Zwierzę – jak je połączyć?",
                listOf("Dziedziczenie: pies jest zwierzęciem", "Kompozycja: pies ma zwierzę", "Żadna relacja", "Zwierzę dziedziczy po Psie"),
                0,
                "Relacja „jest” to dziedziczenie.",
            ),
            tiles(
                "Kwadrat jest figurą. Napisz nagłówek klasy Kwadrat",
                listOf("class", "Kwadrat(", "Figura", "):"),
                listOf("def", "self.figura"),
                "„Jest” oznacza dziedziczenie, więc Figura trafia do nawiasu.",
            ),
            fill(
                "Uzupełnij, aby rower miał dwa koła (wypisze 2).",
                "class Kolo:\n    pass\n\nclass Rower:\n    def __init__(self):\n        self.kola = [Kolo(), ____()]\n\nprint(len(Rower().kola))",
                listOf("Kolo", "Rower", "kolo"),
                "Kolo",
                "Rower ma koła – zawiera obiekty klasy Kolo.",
            ),
            choice(
                "Samochód i Koło – jak je połączyć?",
                listOf("Kompozycja: samochód ma koła", "Dziedziczenie: samochód jest kołem", "Dziedziczenie: koło jest samochodem", "Wielodziedziczenie"),
                0,
                "Samochód składa się z kół – to relacja „ma”.",
            ),
            output(
                "class Benzyna:\n    def napedz(self):\n        return \"spalam\"\n\nclass Prad:\n    def napedz(self):\n        return \"ładuję\"\n\nclass Auto:\n    def __init__(self, naped):\n        self.naped = naped\n\nfor n in [Benzyna(), Prad()]:\n    print(Auto(n).naped.napedz())",
                "spalam\nładuję",
                "Dzięki kompozycji łatwo podmienić część obiektu.",
            ),
            choice(
                "Co oznacza zasada „kompozycja ponad dziedziczenie”?",
                listOf("Gdy nie ma relacji „jest”, lepiej złożyć obiekt z części", "Nigdy nie używaj dziedziczenia", "Każda klasa musi mieć atrybut z obiektem", "Kompozycja jest szybsza"),
                0,
                "Dziedziczenie stosujemy tylko wtedy, gdy klasa naprawdę jest rodzajem innej.",
            ),
            output(
                "class Stos:\n    def __init__(self):\n        self.dane = []\n    def poloz(self, x):\n        self.dane.append(x)\n    def zdejmij(self):\n        return self.dane.pop()\n\ns = Stos()\ns.poloz(1)\ns.poloz(2)\nprint(s.zdejmij())",
                "2",
                "Stos używa listy w środku i udostępnia tylko swoje operacje.",
            ),
            choice(
                "Jaki problem ma ta wersja stosu?",
                listOf("Dziedziczy wszystkie metody listy, np. insert, które łamią zasady stosu", "Nie da się utworzyć obiektu", "Metoda poloz nie działa", "SyntaxError"),
                0,
                "Stos nie jest listą – lepiej, żeby listę miał (kompozycja).",
                code = "class Stos(list):\n    def poloz(self, x):\n        self.append(x)\n\ns = Stos()\ns.poloz(1)\ns.insert(0, 5)",
            ),
        ),
        lesson(
            "u37l4", "Powtórka: kompozycja",
            output(
                "class Ks:\n    def __init__(self, t, autor):\n        self.t = t\n        self.autor = autor\n\nclass Biblioteka:\n    def __init__(self, ksiazki):\n        self.ksiazki = ksiazki\n    def autora(self, a):\n        return [k.t for k in self.ksiazki if k.autor == a]\n\nb = Biblioteka([Ks(\"A\", \"X\"), Ks(\"B\", \"Y\"), Ks(\"C\", \"X\")])\nprint(b.autora(\"X\"))",
                "['A', 'C']",
                "Biblioteka filtruje swoje książki po autorze.",
            ),
            choice(
                "Która relacja to kompozycja?",
                listOf("Drużyna ma graczy", "Kot jest zwierzęciem", "Kwadrat jest figurą", "ValueError jest wyjątkiem"),
                0,
                "„Ma” to kompozycja, „jest” to dziedziczenie.",
            ),
            output(
                "class Playlista:\n    def __init__(self):\n        self.utwory = []\n    def dodaj(self, u):\n        self.utwory.append(u)\n    def __len__(self):\n        return len(self.utwory)\n\np = Playlista()\np.dodaj(\"A\")\np.dodaj(\"B\")\nprint(len(p))",
                "2",
                "Playlista deleguje dodawanie i liczenie do listy utworów.",
            ),
            fill(
                "Uzupełnij, aby dodać gracza do drużyny (wypisze ['Ala']).",
                "class Druzyna:\n    def __init__(self):\n        self.gracze = []\n    def dodaj(self, g):\n        self.____.append(g)\n\nd = Druzyna()\nd.dodaj(\"Ala\")\nprint(d.gracze)",
                listOf("gracze", "Druzyna", "dodaj"),
                "gracze",
                "Drużyna deleguje dodawanie do swojej listy graczy.",
            ),
            output(
                "from dataclasses import dataclass, field\n\n@dataclass\nclass Gracz:\n    imie: str\n\n@dataclass\nclass Druzyna:\n    gracze: list = field(default_factory=list)\n\nd = Druzyna()\nd.gracze.append(Gracz(\"Ola\"))\nprint(d)",
                "Druzyna(gracze=[Gracz(imie='Ola')])",
                "Dataclassy też można składać z innych dataclass.",
            ),
            output(
                "class Silnik:\n    def __init__(self):\n        self.moc = 100\n\nclass Auto:\n    def __init__(self):\n        self.silnik = Silnik()\n\na = Auto()\na.silnik.moc += 50\nprint(a.silnik.moc)",
                "150",
                "Zmieniamy atrybut obiektu, który jest częścią auta.",
            ),
            tiles(
                "Dodaj obiekt Gracz(\"Ola\") do listy gracze drużyny d",
                listOf("d.gracze", ".append(", "Gracz(\"Ola\")", ")"),
                listOf("d.append(", "Druzyna("),
                "Gracz trafia do listy, która jest atrybutem drużyny.",
            ),
            choice(
                "Kiedy wybrać dziedziczenie zamiast kompozycji?",
                listOf("Gdy nowa klasa naprawdę jest rodzajem klasy bazowej", "Zawsze, gdy klasa ma atrybuty", "Gdy obiekt zawiera listę innych obiektów", "Nigdy"),
                0,
                "Dziedziczenie pasuje do relacji „jest”, kompozycja do relacji „ma”.",
            ),
        ),
    ),
)
