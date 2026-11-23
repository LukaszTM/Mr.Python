package com.mrpython.app.data.course

import com.mrpython.app.domain.CourseUnit

internal val module36 = CourseUnit(
    id = "u36",
    title = "Projekt OOP: konto bankowe",
    description = "Budujemy krok po kroku klasę Konto",
    lessons = listOf(
        lesson(
            "u36l1", "Klasa Konto i wpłaty",
            output(
                "class Konto:\n    def __init__(self, wlasciciel):\n        self.wlasciciel = wlasciciel\n        self.saldo = 0\n\nk = Konto(\"Ala\")\nprint(k.wlasciciel, k.saldo)",
                "Ala 0",
                "Nowe konto ma właściciela i zerowe saldo.",
            ),
            output(
                "class Konto:\n    def __init__(self, wlasciciel):\n        self.wlasciciel = wlasciciel\n        self.saldo = 0\n    def wplac(self, kwota):\n        self.saldo += kwota\n\nk = Konto(\"Ala\")\nk.wplac(100)\nk.wplac(50)\nprint(k.saldo)",
                "150",
                "Każda wpłata zwiększa saldo.",
            ),
            fill(
                "Uzupełnij, aby wpłata zwiększała saldo (wypisze 150).",
                "class Konto:\n    def __init__(self):\n        self.saldo = 100\n    def wplac(self, kwota):\n        self.saldo ____ kwota\n\nk = Konto()\nk.wplac(50)\nprint(k.saldo)",
                listOf("+=", "=", "-="),
                "+=",
                "+= dodaje kwotę do dotychczasowego salda.",
            ),
            choice(
                "Gdzie najlepiej ustawić początkowe saldo konta?",
                listOf("W __init__, przez self.saldo", "W metodzie wplac", "Jako zmienną globalną", "W __str__"),
                0,
                "__init__ przygotowuje stan każdego nowego obiektu.",
            ),
            output(
                "class Konto:\n    def __init__(self, saldo=0):\n        self.saldo = saldo\n\nprint(Konto().saldo, Konto(200).saldo)",
                "0 200",
                "Parametr z wartością domyślną pozwala otworzyć konto z saldem albo bez.",
            ),
            output(
                "class Konto:\n    def __init__(self):\n        self.saldo = 0\n    def wplac(self, kwota):\n        self.saldo += kwota\n        return self.saldo\n\nk = Konto()\nprint(k.wplac(30), k.wplac(20))",
                "30 50",
                "Metoda zwraca saldo po każdej wpłacie.",
            ),
            tiles(
                "Wpłać 100 na konto k",
                listOf("k.wplac(", "100", ")"),
                listOf("k.saldo(", "wplac(k,"),
                "Metodę wywołujemy na obiekcie: k.wplac(100).",
            ),
            choice(
                "Jaki jest problem z metodą wplac bez żadnego sprawdzania?",
                listOf("Można wpłacić ujemną kwotę i w ten sposób zmniejszyć saldo", "Nie da się wpłacić dwa razy", "Saldo zawsze zostaje 0", "Nie ma problemu"),
                0,
                "Dlatego w następnej lekcji dodamy walidację.",
            ),
        ),
        lesson(
            "u36l2", "Wypłaty i walidacja",
            output(
                "class Konto:\n    def __init__(self, saldo):\n        self.saldo = saldo\n    def wyplac(self, kwota):\n        if kwota > self.saldo:\n            print(\"Brak środków\")\n            return\n        self.saldo -= kwota\n\nk = Konto(100)\nk.wyplac(150)\nk.wyplac(30)\nprint(k.saldo)",
                "Brak środków\n70",
                "Za duża wypłata jest odrzucana, a poprawna zmniejsza saldo.",
            ),
            fill(
                "Uzupełnij, aby nie dało się wypłacić więcej niż saldo (wypisze 60).",
                "class Konto:\n    def __init__(self, saldo):\n        self.saldo = saldo\n    def wyplac(self, kwota):\n        if kwota ____ self.saldo:\n            raise ValueError(\"za mało\")\n        self.saldo -= kwota\n\nk = Konto(100)\nk.wyplac(40)\nprint(k.saldo)",
                listOf(">", "<", "<="),
                ">",
                "Błąd zgłaszamy tylko wtedy, gdy kwota jest większa niż saldo.",
            ),
            output(
                "class BrakSrodkow(Exception): pass\n\nclass Konto:\n    def __init__(self, saldo):\n        self.saldo = saldo\n    def wyplac(self, kwota):\n        if kwota > self.saldo:\n            raise BrakSrodkow(\"za mało\")\n        self.saldo -= kwota\n\ntry:\n    Konto(10).wyplac(50)\nexcept BrakSrodkow as e:\n    print(e)",
                "za mało",
                "Konto zgłasza własny wyjątek BrakSrodkow.",
            ),
            choice(
                "Który wbudowany wyjątek pasuje do wpłaty ujemnej kwoty?",
                listOf("ValueError", "KeyError", "IndexError", "NameError"),
                0,
                "Poprawny typ, ale niewłaściwa wartość – to ValueError.",
            ),
            output(
                "class Konto:\n    def __init__(self):\n        self.saldo = 0\n    def wplac(self, kwota):\n        if kwota <= 0:\n            raise ValueError(\"zła kwota\")\n        self.saldo += kwota\n\nk = Konto()\nk.wplac(20)\nprint(k.saldo)",
                "20",
                "Dodatnia kwota przechodzi walidację.",
            ),
            choice(
                "Co się stanie po uruchomieniu tego kodu?",
                listOf("ValueError: zła kwota", "Saldo wyniesie 0, bez błędu", "Saldo wyniesie -1", "SyntaxError"),
                0,
                "Dla kwoty 0 warunek kwota <= 0 jest spełniony, więc wplac zgłasza błąd.",
                code = "class Konto:\n    def __init__(self):\n        self.saldo = 0\n    def wplac(self, kwota):\n        if kwota <= 0:\n            raise ValueError(\"zła kwota\")\n        self.saldo += kwota\n\nKonto().wplac(0)",
            ),
            tiles(
                "Odejmij kwotę od salda wewnątrz metody wyplac",
                listOf("self.saldo", "-=", "kwota"),
                listOf("+=", "self.kwota"),
                "Wypłata zmniejsza self.saldo o kwotę.",
            ),
            choice(
                "Dlaczego lepiej zgłosić wyjątek niż tylko wypisać „Brak środków”?",
                listOf("Kod wywołujący może sam zdecydować, jak obsłużyć błąd", "Wyjątki są szybsze niż print", "print nie działa w metodach", "Bo wtedy saldo samo się poprawi"),
                0,
                "Wyjątek informuje kod wywołujący, że operacja się nie udała.",
            ),
        ),
        lesson(
            "u36l3", "Historia operacji",
            output(
                "class Konto:\n    def __init__(self):\n        self.saldo = 0\n        self.historia = []\n    def wplac(self, kwota):\n        self.saldo += kwota\n        self.historia.append((\"wpłata\", kwota))\n\nk = Konto()\nk.wplac(100)\nprint(k.historia)",
                "[('wpłata', 100)]",
                "Każda operacja zapisuje krotkę w liście historii.",
            ),
            choice(
                "Dlaczego historia = [] tworzymy w __init__, a nie jako atrybut klasy?",
                listOf("Atrybut klasy byłby jedną wspólną listą dla wszystkich kont", "Atrybuty klasy nie mogą być listami", "W __init__ lista działa szybciej", "Bez różnicy"),
                0,
                "Każde konto potrzebuje własnej historii.",
            ),
            fill(
                "Uzupełnij, aby zapisać operację w historii.",
                "class Konto:\n    def __init__(self):\n        self.historia = []\n    def wplac(self, kwota):\n        self.historia.____(kwota)\n\nk = Konto()\nk.wplac(10)\nk.wplac(5)\nprint(k.historia)",
                listOf("append", "add", "push"),
                "append",
                "Do listy dodajemy elementy metodą append.",
            ),
            output(
                "class Konto:\n    def __init__(self):\n        self.historia = []\n    def zmien(self, k):\n        self.historia.append(k)\n    @property\n    def saldo(self):\n        return sum(self.historia)\n\nk = Konto()\nk.zmien(100)\nk.zmien(-30)\nprint(k.saldo, k.historia)",
                "70 [100, -30]",
                "Saldo można wyliczać z historii za pomocą właściwości.",
            ),
            output(
                "class Konto:\n    def __init__(self):\n        self.historia = [(\"wpłata\", 100),\n                         (\"wypłata\", 40)]\n    def wyciag(self):\n        for typ, kwota in self.historia:\n            print(f\"{typ}: {kwota}\")\n\nKonto().wyciag()",
                "wpłata: 100\nwypłata: 40",
                "Metoda wyciag rozpakowuje krotki z historii.",
            ),
            output(
                "historia = [100, -30, 50, -20]\nwyplaty = [x for x in historia if x < 0]\nprint(len(wyplaty), sum(wyplaty))",
                "2 -50",
                "Wyrażenie listowe wybiera z historii tylko wypłaty.",
            ),
            tiles(
                "Dodaj do historii krotkę (\"wpłata\", kwota)",
                listOf("self.historia.append(", "(\"wpłata\", kwota)", ")"),
                listOf("add(", "push("),
                "append dodaje jedną krotkę na koniec listy.",
            ),
            choice(
                "Konto ma pustą historię. Ile elementów będzie w niej po dwóch wpłatach i jednej wypłacie?",
                listOf("3", "2", "1", "0"),
                0,
                "Każda operacja dodaje jeden wpis.",
            ),
        ),
        lesson(
            "u36l4", "Przelewy między kontami",
            output(
                "class Konto:\n    def __init__(self, saldo):\n        self.saldo = saldo\n    def przelej(self, cel, kwota):\n        self.saldo -= kwota\n        cel.saldo += kwota\n\na = Konto(100)\nb = Konto(0)\na.przelej(b, 30)\nprint(a.saldo, b.saldo)",
                "70 30",
                "Przelew zmniejsza saldo jednego konta i zwiększa drugiego.",
            ),
            choice(
                "Co przekazujemy do metody przelej jako cel?",
                listOf("Drugi obiekt klasy Konto", "Numer konta jako napis", "Kwotę", "Klasę Konto"),
                0,
                "Metoda może przyjmować inne obiekty i zmieniać ich atrybuty.",
            ),
            choice(
                "Co się stanie po uruchomieniu tego kodu?",
                listOf("ValueError, a salda się nie zmienią", "b dostanie 80, a a będzie mieć -30", "b dostanie 50", "Nic – przelew zostanie pominięty"),
                0,
                "wyplac zgłasza błąd, zanim cokolwiek zmieni, więc przelew się nie wykona.",
                code = "class Konto:\n    def __init__(self, saldo):\n        self.saldo = saldo\n    def wyplac(self, k):\n        if k > self.saldo:\n            raise ValueError(\"brak środków\")\n        self.saldo -= k\n    def przelej(self, cel, k):\n        self.wyplac(k)\n        cel.saldo += k\n\nKonto(50).przelej(Konto(0), 80)",
            ),
            fill(
                "Uzupełnij, aby przelew użył metody wpłaty konta docelowego (wypisze 5 15).",
                "class Konto:\n    def __init__(self, saldo):\n        self.saldo = saldo\n    def wplac(self, k):\n        self.saldo += k\n    def przelej(self, cel, k):\n        self.saldo -= k\n        cel.____(k)\n\na, b = Konto(10), Konto(10)\na.przelej(b, 5)\nprint(a.saldo, b.saldo)",
                listOf("wplac", "saldo", "przelej"),
                "wplac",
                "Przelew korzysta z gotowej metody wplac drugiego konta.",
            ),
            output(
                "class Konto:\n    def __init__(self, saldo):\n        self.saldo = saldo\n    def przelej(self, cel, k):\n        self.saldo -= k\n        cel.saldo += k\n\na, b, c = Konto(100), Konto(0), Konto(0)\na.przelej(b, 60)\nb.przelej(c, 20)\nprint(a.saldo, b.saldo, c.saldo)",
                "40 40 20",
                "Pieniądze przechodzą z a do b, a potem część z b do c.",
            ),
            choice(
                "Dlaczego przelej najpierw wywołuje self.wyplac(k)?",
                listOf("Żeby skorzystać z tej samej walidacji salda", "Bo inaczej Python zgłosi SyntaxError", "Żeby wypłacić pieniądze dwa razy", "Bez powodu"),
                0,
                "Ponowne użycie metody wyplac sprawia, że zasady są w jednym miejscu.",
            ),
            tiles(
                "Przelej 50 z konta a na konto b",
                listOf("a.przelej(", "b,", "50", ")"),
                listOf("b.przelej(", "a,"),
                "Metodę wywołujemy na koncie źródłowym, a cel podajemy jako argument.",
            ),
            output(
                "class Konto:\n    def __init__(self, saldo):\n        self.saldo = saldo\n    def przelej(self, cel, k):\n        if k <= self.saldo:\n            self.saldo -= k\n            cel.saldo += k\n\na, b = Konto(20), Konto(0)\na.przelej(b, 50)\nprint(a.saldo, b.saldo)",
                "20 0",
                "Kwota jest większa niż saldo, więc przelew się nie wykonał.",
            ),
        ),
        lesson(
            "u36l5", "Projekt: podsumowanie",
            output(
                "class Konto:\n    def __init__(self, wl, saldo):\n        self.wl = wl\n        self.saldo = saldo\n    def __str__(self):\n        return f\"{self.wl}: {self.saldo} zł\"\n\nprint(Konto(\"Ala\", 120))",
                "Ala: 120 zł",
                "__str__ daje czytelny opis konta dla print.",
            ),
            output(
                "class Konto:\n    def __init__(self):\n        self.historia = [100, -40, 25]\n    def podsumowanie(self):\n        wp = sum(x for x in self.historia if x > 0)\n        wy = -sum(x for x in self.historia if x < 0)\n        return f\"wpłaty {wp}, wypłaty {wy}\"\n\nprint(Konto().podsumowanie())",
                "wpłaty 125, wypłaty 40",
                "Podsumowanie osobno sumuje wpłaty i wypłaty z historii.",
            ),
            fill(
                "Uzupełnij, aby print(k) wypisał „Konto Ala”.",
                "class Konto:\n    def __init__(self, wl):\n        self.wl = wl\n    def ____(self):\n        return f\"Konto {self.wl}\"\n\nk = Konto(\"Ala\")\nprint(k)",
                listOf("__str__", "__len__", "__eq__"),
                "__str__",
                "print korzysta z __str__.",
            ),
            output(
                "class Konto:\n    def __init__(self, saldo):\n        self.saldo = saldo\n    def __str__(self):\n        return f\"Saldo: {self.saldo:.2f} zł\"\n\nprint(Konto(99.5))",
                "Saldo: 99.50 zł",
                "Format .2f pokazuje kwotę z dwoma miejscami po przecinku.",
            ),
            output(
                "class Konto:\n    def __init__(self, wl, saldo):\n        self.wl = wl\n        self.saldo = saldo\n\nkonta = [Konto(\"Ola\", 50), Konto(\"Jan\", 200)]\nnaj = max(konta, key=lambda k: k.saldo)\nprint(naj.wl)",
                "Jan",
                "max z key wybiera konto z największym saldem.",
            ),
            choice(
                "Którą metodę dodać, aby konta dało się porównywać przez < według salda?",
                listOf("__lt__", "__str__", "__len__", "__add__"),
                0,
                "Operator < wywołuje __lt__.",
            ),
            output(
                "class Konto:\n    def __init__(self, saldo):\n        self.saldo = saldo\n\nkonta = [Konto(50), Konto(200), Konto(30)]\nprint(sum(k.saldo for k in konta))",
                "280",
                "Suma sald wszystkich kont w banku.",
            ),
            tiles(
                "Napisz nagłówek metody, z której korzysta print(konto)",
                listOf("def", "__str__(", "self", "):"),
                listOf("print(", "return"),
                "print wywołuje __str__, która przyjmuje tylko self.",
            ),
        ),
    ),
)
