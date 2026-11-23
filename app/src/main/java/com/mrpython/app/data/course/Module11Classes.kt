package com.mrpython.app.data.course

import com.mrpython.app.domain.CourseUnit

internal val module11 = CourseUnit(
    id = "u11",
    title = "Klasy i obiekty",
    description = "Twórz własne typy danych",
    lessons = listOf(
        lesson(
            "u11l1", "Pierwsza klasa",
            choice(
                "Które słowo kluczowe tworzy klasę?",
                listOf("class", "def", "object", "new"),
                0,
                "Klasę definiujemy słowem class.",
            ),
            output(
                "class Pies:\n    pass\n\nburek = Pies()\nprint(type(burek).__name__)",
                "Pies",
                "burek jest obiektem (instancją) klasy Pies.",
            ),
            output(
                "class Pies:\n    def __init__(self, imie):\n        self.imie = imie\n\np = Pies(\"Burek\")\nprint(p.imie)",
                "Burek",
                "__init__ ustawia atrybuty nowego obiektu.",
            ),
            choice(
                "Do czego służy __init__?",
                listOf("Ustawia początkowy stan obiektu", "Usuwa obiekt", "Wypisuje obiekt", "Tworzy nową klasę"),
                0,
                "__init__ wywołuje się automatycznie przy tworzeniu obiektu.",
            ),
            output(
                "class Kot:\n    def __init__(self, imie, wiek):\n        self.imie = imie\n        self.wiek = wiek\n\nk = Kot(\"Mruczek\", 3)\nprint(k.imie, k.wiek)",
                "Mruczek 3",
                "Każdy obiekt ma własne atrybuty.",
            ),
            output(
                "class Punkt:\n    def __init__(self, x, y):\n        self.x = x\n        self.y = y\n\np = Punkt(2, 5)\np.x = 10\nprint(p.x + p.y)",
                "15",
                "Atrybuty obiektu można zmieniać.",
            ),
            fill(
                "Uzupełnij, aby zapisać imię w obiekcie.",
                "class Uczen:\n    def __init__(self, imie):\n        ____.imie = imie\n\nu = Uczen(\"Ola\")\nprint(u.imie)",
                listOf("self", "this", "obiekt"),
                "self",
                "self oznacza tworzony obiekt.",
            ),
        ),
        lesson(
            "u11l2", "Metody",
            output("class Pies:\n    def szczekaj(self):\n        print(\"Hau!\")\n\nPies().szczekaj()", "Hau!", "Metoda to funkcja zdefiniowana w klasie."),
            output(
                "class Licznik:\n    def __init__(self):\n        self.n = 0\n    def dodaj(self):\n        self.n += 1\n\nc = Licznik()\nc.dodaj()\nc.dodaj()\nprint(c.n)",
                "2",
                "Metoda zmienia stan obiektu przez self.",
            ),
            output(
                "class Prostokat:\n    def __init__(self, a, b):\n        self.a = a\n        self.b = b\n    def pole(self):\n        return self.a * self.b\n\nprint(Prostokat(3, 4).pole())",
                "12",
                "Metoda może zwracać wynik.",
            ),
            choice(
                "Czym jest self w metodzie?",
                listOf(
                    "Obiektem, na którym wywołano metodę",
                    "Nazwą klasy",
                    "Słowem kluczowym jak if",
                    "Argumentem, który zawsze podajemy ręcznie",
                ),
                0,
                "Python sam przekazuje obiekt jako self.",
            ),
            output(
                "class Konto:\n    def __init__(self):\n        self.saldo = 100\n    def wyplac(self, kwota):\n        self.saldo -= kwota\n\nk = Konto()\nk.wyplac(30)\nprint(k.saldo)",
                "70",
                "100 - 30 = 70.",
            ),
            output(
                "class A:\n    def __init__(self, x):\n        self.x = x\n\na = A(1)\nb = A(2)\nprint(a.x, b.x)",
                "1 2",
                "Każdy obiekt ma własne wartości atrybutów.",
            ),
            tiles(
                "Wywołaj metodę pole() obiektu p i zapisz wynik w zmiennej w",
                listOf("w", "=", "p.pole()"),
                listOf("pole(p)", "p.pole"),
                "Metodę wywołujemy przez kropkę i nawiasy.",
            ),
            fill(
                "Uzupełnij definicję metody.",
                "class Kot:\n    def miaucz(____):\n        return \"Miau\"\n\nprint(Kot().miaucz())",
                listOf("self", "Kot()", "1"),
                "self",
                "Pierwszym parametrem metody jest self.",
            ),
        ),
        lesson(
            "u11l3", "__str__ i dziedziczenie",
            output(
                "class Pies:\n    def __init__(self, imie):\n        self.imie = imie\n    def __str__(self):\n        return \"Pies \" + self.imie\n\nprint(Pies(\"Reks\"))",
                "Pies Reks",
                "__str__ określa, jak obiekt wygląda w print().",
            ),
            output(
                "class Zwierze:\n    def dzwiek(self):\n        return \"...\"\n\nclass Kot(Zwierze):\n    pass\n\nprint(Kot().dzwiek())",
                "...",
                "Kot dziedziczy metodę dzwiek po klasie Zwierze.",
            ),
            output(
                "class Zwierze:\n    def dzwiek(self):\n        return \"...\"\n\nclass Kot(Zwierze):\n    def dzwiek(self):\n        return \"Miau\"\n\nprint(Kot().dzwiek())",
                "Miau",
                "Klasa potomna może nadpisać metodę.",
            ),
            choice(
                "Co oznacza zapis class Kot(Zwierze)?",
                listOf("Kot dziedziczy po Zwierze", "Zwierze dziedziczy po Kot", "Kot jest atrybutem", "Kot wywołuje Zwierze"),
                0,
                "W nawiasie podajemy klasę bazową.",
            ),
            output(
                "class A:\n    def __init__(self):\n        self.x = 1\n\nclass B(A):\n    def __init__(self):\n        super().__init__()\n        self.y = 2\n\nb = B()\nprint(b.x + b.y)",
                "3",
                "super().__init__() uruchamia __init__ klasy bazowej.",
            ),
            output(
                "class Zwierze:\n    pass\n\nclass Pies(Zwierze):\n    pass\n\nprint(isinstance(Pies(), Zwierze))",
                "True",
                "Pies jest też Zwierzęciem.",
            ),
            fill(
                "Uzupełnij, aby klasa Pies dziedziczyła po Zwierze.",
                "class Zwierze:\n    pass\n\nclass Pies(____):\n    pass\n\nprint(isinstance(Pies(), Zwierze))",
                listOf("Zwierze", "self", "object"),
                "Zwierze",
                "W nawiasie podajemy klasę, po której dziedziczymy.",
            ),
        ),
        lesson(
            "u11l4", "Powtórka: klasy",
            output(
                "class Licznik:\n    def __init__(self, start=0):\n        self.n = start\n\nprint(Licznik().n, Licznik(5).n)",
                "0 5",
                "Parametry __init__ też mogą mieć wartości domyślne.",
            ),
            output(
                "class Ksiazka:\n    def __init__(self, tytul, strony):\n        self.tytul = tytul\n        self.strony = strony\n    def czy_gruba(self):\n        return self.strony > 300\n\nprint(Ksiazka(\"Lalka\", 700).czy_gruba())",
                "True",
                "700 > 300.",
            ),
            choice(
                "Co wypisze ten kod?",
                listOf("[]", "[1]", "None", "Błąd"),
                0,
                "Każdy obiekt dostaje w __init__ własną, nową listę.",
                code = "class A:\n    def __init__(self):\n        self.lista = []\n\na = A()\nb = A()\na.lista.append(1)\nprint(b.lista)",
            ),
            output(
                "class Koszyk:\n    def __init__(self):\n        self.rzeczy = []\n    def dodaj(self, r):\n        self.rzeczy.append(r)\n    def ile(self):\n        return len(self.rzeczy)\n\nk = Koszyk()\nk.dodaj(\"jabłko\")\nk.dodaj(\"gruszka\")\nprint(k.ile())",
                "2",
                "Obiekt przechowuje listę i ma metody do jej obsługi.",
            ),
            output(
                "class Osoba:\n    def __init__(self, imie):\n        self.imie = imie\n    def przywitaj(self, inna):\n        return f\"{self.imie} wita {inna.imie}\"\n\na = Osoba(\"Ala\")\nb = Osoba(\"Ola\")\nprint(a.przywitaj(b))",
                "Ala wita Ola",
                "Metoda może przyjmować inne obiekty.",
            ),
            tiles(
                "Utwórz obiekt klasy Pies o imieniu \"Azor\" w zmiennej p",
                listOf("p", "=", "Pies(", "\"Azor\"", ")"),
                listOf("new", "class"),
                "Obiekt tworzymy, wywołując klasę jak funkcję.",
            ),
            output(
                "class Kwadrat:\n    def __init__(self, a):\n        self.a = a\n    def __str__(self):\n        return f\"Kwadrat {self.a}x{self.a}\"\n\nprint(Kwadrat(3))",
                "Kwadrat 3x3",
                "print() korzysta z metody __str__.",
            ),
            choice(
                "Jak nazywa się obiekt utworzony z klasy?",
                listOf("Instancja", "Metoda", "Atrybut", "Moduł"),
                0,
                "Obiekt utworzony z klasy to jej instancja.",
            ),
        ),
    ),
)
