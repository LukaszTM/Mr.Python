package com.mrpython.app.data.course

import com.mrpython.app.domain.CourseUnit

internal val module34 = CourseUnit(
    id = "u34",
    title = "dataclasses",
    description = "Klasy danych bez pisania __init__",
    lessons = listOf(
        lesson(
            "u34l1", "@dataclass – podstawy",
            output(
                "from dataclasses import dataclass\n\n@dataclass\nclass Punkt:\n    x: int\n    y: int\n\nprint(Punkt(1, 2))",
                "Punkt(x=1, y=2)",
                "@dataclass sam tworzy __init__ i czytelne __repr__.",
            ),
            output(
                "from dataclasses import dataclass\n\n@dataclass\nclass Punkt:\n    x: int\n    y: int\n\nprint(Punkt(1, 2) == Punkt(1, 2))",
                "True",
                "Dataclass dostaje też __eq__, które porównuje pola.",
            ),
            choice(
                "Co @dataclass tworzy automatycznie?",
                listOf("__init__, __repr__ i __eq__", "Tylko __init__", "__lt__ i __gt__", "Nic – to tylko komentarz"),
                0,
                "Na podstawie listy pól powstają __init__, __repr__ i __eq__.",
            ),
            output(
                "from dataclasses import dataclass\n\n@dataclass\nclass Osoba:\n    imie: str\n    wiek: int\n\no = Osoba(\"Ala\", 30)\no.wiek += 1\nprint(o.wiek)",
                "31",
                "Pola dataclassy to zwykłe atrybuty, które można zmieniać.",
            ),
            fill(
                "Uzupełnij import.",
                "from dataclasses import ____\n\n@dataclass\nclass Kot:\n    imie: str\n\nprint(Kot(\"Mruczek\"))",
                listOf("dataclass", "dataclasses", "DataClass"),
                "dataclass",
                "Z modułu dataclasses importujemy dekorator dataclass.",
            ),
            choice(
                "Co wypisze ten kod?",
                listOf("P(x='abc')", "TypeError", "P(x=0)", "ValueError"),
                0,
                "Adnotacja int to tylko podpowiedź – Python nie sprawdza typu.",
                code = "from dataclasses import dataclass\n\n@dataclass\nclass P:\n    x: int\n\nprint(P(\"abc\"))",
            ),
            tiles(
                "Zadeklaruj pole wiek typu int w dataclassie",
                listOf("wiek", ":", "int"),
                listOf("==", "int()"),
                "Pole dataclassy to nazwa, dwukropek i typ.",
            ),
            output(
                "from dataclasses import dataclass\n\n@dataclass\nclass Ksiazka:\n    tytul: str\n    strony: int\n\nk = Ksiazka(strony=100, tytul=\"Lalka\")\nprint(k)",
                "Ksiazka(tytul='Lalka', strony=100)",
                "Kolejność w __repr__ wynika z kolejności pól w klasie.",
            ),
        ),
        lesson(
            "u34l2", "Wartości domyślne i field",
            output(
                "from dataclasses import dataclass\n\n@dataclass\nclass Gracz:\n    imie: str\n    punkty: int = 0\n\nprint(Gracz(\"Ola\"))",
                "Gracz(imie='Ola', punkty=0)",
                "Pole z wartością domyślną można pominąć przy tworzeniu.",
            ),
            output(
                "from dataclasses import dataclass, field\n\n@dataclass\nclass Koszyk:\n    rzeczy: list = field(default_factory=list)\n\na = Koszyk()\nb = Koszyk()\na.rzeczy.append(\"ser\")\nprint(len(a.rzeczy), len(b.rzeczy))",
                "1 0",
                "default_factory tworzy osobną, nową listę dla każdego obiektu.",
            ),
            choice(
                "Co się stanie, gdy w dataclassie napiszesz rzeczy: list = []?",
                listOf("ValueError – dla listy trzeba użyć field(default_factory=list)", "Każdy obiekt dostanie osobną listę", "Lista będzie pusta i niezmienna", "SyntaxError"),
                0,
                "Dataclass zabrania zmiennych wartości domyślnych, żeby uniknąć wspólnej listy.",
            ),
            choice(
                "Co się stanie po uruchomieniu tego kodu?",
                listOf("TypeError – pole bez wartości domyślnej po polu z domyślną", "y dostanie wartość 0", "y dostanie None", "Kod zadziała bez błędu"),
                0,
                "Pola z wartościami domyślnymi muszą być na końcu, tak jak parametry funkcji.",
                code = "from dataclasses import dataclass\n\n@dataclass\nclass A:\n    x: int = 0\n    y: int",
            ),
            fill(
                "Uzupełnij, aby każdy obiekt miał własną pustą listę.",
                "from dataclasses import dataclass, field\n\n@dataclass\nclass Klasa:\n    uczniowie: list = field(default_factory=____)\n\nk = Klasa()\nk.uczniowie.append(\"Ala\")\nprint(k.uczniowie)",
                listOf("list", "[]", "list()"),
                "list",
                "default_factory dostaje funkcję (list), którą wywoła przy tworzeniu obiektu.",
            ),
            output(
                "from dataclasses import dataclass, field\n\n@dataclass\nclass Magazyn:\n    stan: dict = field(default_factory=dict)\n\nm = Magazyn()\nm.stan[\"jabłka\"] = 5\nprint(m)",
                "Magazyn(stan={'jabłka': 5})",
                "default_factory=dict tworzy nowy pusty słownik.",
            ),
            output(
                "from dataclasses import dataclass\n\n@dataclass\nclass Prost:\n    a: int\n    b: int = 1\n    def pole(self):\n        return self.a * self.b\n\nprint(Prost(3).pole(), Prost(3, 4).pole())",
                "3 12",
                "Dataclass może mieć zwykłe metody.",
            ),
            tiles(
                "Zadeklaruj pole tagi z pustą listą jako wartością domyślną",
                listOf("tagi:", "list", "=", "field(", "default_factory=list", ")"),
                listOf("[]", "list()"),
                "Domyślną listę tworzymy przez field(default_factory=list).",
            ),
        ),
        lesson(
            "u34l3", "frozen i order",
            output(
                "from dataclasses import dataclass\n\n@dataclass(frozen=True)\nclass Kolor:\n    r: int\n\nk = Kolor(255)\ntry:\n    k.r = 0\nexcept AttributeError:\n    print(\"nie można zmienić\")",
                "nie można zmienić",
                "Obiektu zamrożonej dataclassy nie da się zmienić.",
            ),
            choice(
                "Co daje parametr frozen=True?",
                listOf("Obiektu nie można zmieniać po utworzeniu", "Obiekty można sortować", "Pola stają się prywatne", "Obiekt tworzy się szybciej"),
                0,
                "frozen=True blokuje przypisywanie do pól.",
            ),
            output(
                "from dataclasses import dataclass\n\n@dataclass(order=True)\nclass Wersja:\n    major: int\n    minor: int\n\nw = sorted([Wersja(1, 5), Wersja(1, 2), Wersja(0, 9)])\nprint(w[0])",
                "Wersja(major=0, minor=9)",
                "order=True porównuje pola po kolei – najpierw major.",
            ),
            output(
                "from dataclasses import dataclass\n\n@dataclass(order=True)\nclass W:\n    a: int\n    b: int\n\nprint(W(1, 9) < W(2, 0))",
                "True",
                "Porównanie działa jak dla krotek: decyduje pierwsze różne pole.",
            ),
            choice(
                "Co się stanie po uruchomieniu tego kodu?",
                listOf("TypeError – brak porównania <", "Wypisze True", "Wypisze False", "SyntaxError"),
                0,
                "Bez order=True dataclass nie ma metod porównujących < i >.",
                code = "from dataclasses import dataclass\n\n@dataclass\nclass W:\n    a: int\n\nprint(W(1) < W(2))",
            ),
            fill(
                "Uzupełnij, aby zadania dało się posortować (wypisze 1).",
                "from dataclasses import dataclass\n\n@dataclass(____=True)\nclass Zadanie:\n    priorytet: int\n\nz = sorted([Zadanie(3), Zadanie(1)])\nprint(z[0].priorytet)",
                listOf("order", "frozen", "sort"),
                "order",
                "order=True dodaje metody __lt__, __le__, __gt__ i __ge__.",
            ),
            output(
                "from dataclasses import dataclass\n\n@dataclass(frozen=True)\nclass Pole:\n    x: int\n    y: int\n\nodwiedzone = {Pole(0, 0), Pole(0, 0)}\nprint(len(odwiedzone))",
                "1",
                "Zamrożone obiekty można wkładać do zbioru; równe obiekty liczą się raz.",
            ),
            tiles(
                "Posortuj listę zadania (dataclass z order=True) i zapisz wynik w z",
                listOf("z", "=", "sorted(", "zadania", ")"),
                listOf("zadania.sorted(", "order="),
                "Dzięki order=True obiekty da się posortować funkcją sorted.",
            ),
        ),
        lesson(
            "u34l4", "Powtórka: dataclasses",
            output(
                "from dataclasses import dataclass\n\n@dataclass\nclass Film:\n    tytul: str\n    ocena: float = 5.0\n\nprint(Film(\"Miś\"))",
                "Film(tytul='Miś', ocena=5.0)",
                "Pominięte pole dostaje wartość domyślną.",
            ),
            output(
                "from dataclasses import dataclass\n\n@dataclass\nclass Film:\n    tytul: str\n    ocena: float = 5.0\n\nprint(Film(\"A\") == Film(\"A\", 4.0))",
                "False",
                "__eq__ porównuje wszystkie pola, a oceny są różne.",
            ),
            choice(
                "Którego parametru użyjesz, aby obiekty dataclassy dało się sortować?",
                listOf("order=True", "frozen=True", "sort=True", "eq=False"),
                0,
                "order=True dodaje operatory porównania.",
            ),
            output(
                "from dataclasses import dataclass\n\n@dataclass(order=True)\nclass Gracz:\n    punkty: int\n    imie: str\n\ng = max([Gracz(5, \"Ola\"), Gracz(7, \"Ala\")])\nprint(g.imie)",
                "Ala",
                "Pierwszym polem są punkty, więc wygrywa gracz z 7 punktami.",
            ),
            fill(
                "Uzupełnij import.",
                "from dataclasses import dataclass, ____\n\n@dataclass\nclass Lista:\n    elementy: list = field(default_factory=list)\n\nprint(Lista())",
                listOf("field", "Field", "default_factory"),
                "field",
                "Funkcję field importujemy z modułu dataclasses.",
            ),
            choice(
                "Jaki błąd pojawi się przy próbie zmiany pola w obiekcie z frozen=True?",
                listOf("FrozenInstanceError (rodzaj AttributeError)", "ValueError", "KeyError", "Żaden – pole się zmieni"),
                0,
                "FrozenInstanceError dziedziczy po AttributeError.",
            ),
            output(
                "from dataclasses import dataclass, field\n\n@dataclass\nclass Druzyna:\n    nazwa: str\n    gracze: list = field(default_factory=list)\n\nd = Druzyna(\"Orły\")\nd.gracze.append(\"Jan\")\nprint(d)",
                "Druzyna(nazwa='Orły', gracze=['Jan'])",
                "Lista graczy jest polem i pokazuje się w __repr__.",
            ),
            tiles(
                "Utwórz obiekt Punkt z x=3 i y=4, używając argumentów nazwanych",
                listOf("p", "=", "Punkt(", "x=3,", "y=4", ")"),
                listOf("new", "x:3,"),
                "Dataclass przyjmuje argumenty nazwane jak zwykła funkcja.",
            ),
        ),
    ),
)
