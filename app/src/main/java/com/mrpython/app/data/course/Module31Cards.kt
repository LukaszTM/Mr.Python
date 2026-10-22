package com.mrpython.app.data.course

internal val module31Cards = listOf(
    cards(
        "u31l1",
        explain(
            "Obiekt najpierw, potem klasa",
            "Odczyt `a.x` szuka x najpierw w obiekcie, a gdy go tam nie ma – w klasie. Przypisanie " +
                "`a.x = 5` (albo `a.x += 1`) tworzy atrybut w samym obiekcie, a `A.x` się nie zmienia.",
            code = "class A:\n    x = 1\n\na = A()\na.x = 5\nprint(a.x, A.x)",
            output = "5 1",
        ),
        explain(
            "Wspólna lista w klasie",
            "Uwaga na listy w atrybutach klasy: `append()` nie tworzy nowego atrybutu, tylko zmienia " +
                "jedną wspólną listę. Zmiana przez jeden obiekt jest widoczna we wszystkich.",
            code = "class Koszyk:\n    rzeczy = []\n\na = Koszyk()\nb = Koszyk()\na.rzeczy.append(\"ser\")\nprint(b.rzeczy)",
            output = "['ser']",
        ),
    ),
    cards(
        "u31l2",
        explain(
            "Obiekt z napisu",
            "Metoda klasy może przygotować dane, a potem wywołać zwykły konstruktor `cls(...)`. Tu rozbija " +
                "napis „24.12” na dwie części i zamienia je na liczby.",
            code = "class Data:\n    def __init__(self, d, m):\n        self.d, self.m = d, m\n    @classmethod\n    def z_napisu(cls, s):\n        d, m = s.split(\".\")\n        return cls(int(d), int(m))\nprint(Data.z_napisu(\"24.12\").m)",
            output = "12",
        ),
        explain(
            "cls zmienia klasę",
            "Przez `cls` metoda klasy czyta i zmienia atrybuty klasy, np. `cls.ile += 1`. " +
                "`cls.__name__` to nazwa klasy jako napis.",
            code = "class Licznik:\n    ile = 0\n    @classmethod\n    def zwieksz(cls):\n        cls.ile += 1\n\nLicznik.zwieksz()\nprint(Licznik.ile, Licznik.__name__)",
            output = "1 Licznik",
        ),
        explain(
            "Wywołanie przez obiekt",
            "Metody statyczne i metody klasy można wołać przez klasę, ale też przez obiekt – także wewnątrz " +
                "klasy, np. `self.kwadrat(x)`.",
            code = "class Mat:\n    @staticmethod\n    def kw(x):\n        return x * x\n\nprint(Mat.kw(3), Mat().kw(4))",
            output = "9 16",
        ),
    ),
    cards(
        "u31l3",
        explain(
            "Bez nawiasów!",
            "Odczyt właściwości od razu daje wynik, np. liczbę. Gdy dopiszesz nawiasy `obiekt.x()`, Python " +
                "spróbuje wywołać tę liczbę i zgłosi `TypeError`.",
            code = "class A:\n    @property\n    def x(self):\n        return 7\n\nprint(A().x)",
            output = "7",
        ),
    ),
    cards(
        "u31l4",
        explain(
            "Setter działa też w __init__",
            "Gdy w `__init__` napiszesz `self.c = c`, a `c` jest właściwością z setterem, to przypisanie " +
                "przejdzie przez setter. Dzięki temu walidacja działa już przy tworzeniu obiektu.",
            code = "class Temp:\n    def __init__(self, c):\n        self.c = c\n    @property\n    def c(self):\n        return self._c\n    @c.setter\n    def c(self, v):\n        self._c = round(v)\nprint(Temp(21.7).c)",
            output = "22",
        ),
        explain(
            "Dlaczego self._wiek?",
            "Wewnątrz gettera i settera używamy ukrytego `self._wiek`. Odczyt `self.wiek` w getterze " +
                "wywołałby ten sam getter w nieskończoność (`RecursionError`). Zapis prosto do `_wiek` omija setter.",
            code = "class T:\n    @property\n    def x(self):\n        return self._x\n    @x.setter\n    def x(self, v):\n        self._x = max(0, v)\nt = T()\nt._x = -5\nprint(t.x)",
            output = "-5",
        ),
        explain(
            "Odrzucanie złej wartości",
            "To, co setter zwraca, jest ignorowane. Żeby odrzucić złą wartość, setter zgłasza wyjątek, " +
                "np. `if v < 0: raise ValueError(\"ujemne\")` – wtedy przypisanie się nie wykona.",
        ),
    ),
    cards(
        "u31l5",
        explain(
            "Domyślna wartość przez or",
            "`x or y` zwraca x, gdy x jest „prawdziwe”, a w przeciwnym razie y. Gdy parametr ma wartość " +
                "`None` (albo pusty napis), `n or domyslny` podstawi wartość domyślną.",
            code = "print(None or \"czarny\")\nprint(\"zielony\" or \"czarny\")",
            output = "czarny\nzielony",
        ),
    ),
)
