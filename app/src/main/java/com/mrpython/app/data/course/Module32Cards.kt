package com.mrpython.app.data.course

internal val module32Cards = listOf(
    cards(
        "u32l1",
        explain(
            "Funkcje str() i repr()",
            "`str(obiekt)` wywołuje `__str__`, a `repr(obiekt)` wywołuje `__repr__`. Obie metody muszą " +
                "zwrócić napis – zwrócenie np. liczby kończy się błędem `TypeError`.",
            code = "class A:\n    def __str__(self):\n        return \"ładny\"\n    def __repr__(self):\n        return \"A()\"\n\nprint(str(A()), repr(A()))",
            output = "ładny A()",
        ),
        explain(
            "Opis domyślny",
            "Gdy klasa nie ma ani `__str__`, ani `__repr__`, `print()` pokaże tylko nazwę klasy i adres w pamięci, " +
                "np. `<__main__.Kot object at 0x7f…>`. Dobry `__repr__` wygląda zwykle jak kod tworzący obiekt, np. `Punkt(1, 2)`.",
        ),
    ),
    cards(
        "u32l2",
        explain(
            "!= i > za darmo",
            "Gdy klasa ma `__eq__`, Python sam wylicza `!=` jako jego zaprzeczenie. Gdy ma tylko `__lt__`, " +
                "zapis `a > b` zamienia na `b < a`.",
            code = "class W:\n    def __init__(self, w):\n        self.w = w\n    def __lt__(self, o):\n        return self.w < o.w\n\nprint(W(5) > W(2))",
            output = "True",
        ),
        explain(
            "Brak porównania",
            "Bez `__lt__` Python nie wie, jak porównać obiekty operatorem `<`, więc zgłasza `TypeError` – " +
                "dlatego bez tej metody `sorted()` nie posortuje obiektów (chyba że podasz `key`).",
        ),
    ),
    cards(
        "u32l3",
        explain(
            "Indeksy i wycinki",
            "`__getitem__` dostaje dokładnie to, co jest w nawiasach: liczbę, indeks ujemny, a nawet wycinek " +
                "`1:3`. Gdy przekażemy to liście, zadziała tak samo jak na liście.",
            code = "class T:\n    dni = [\"pon\", \"wt\", \"śr\"]\n    def __getitem__(self, i):\n        return self.dni[i]\n\nt = T()\nprint(t[-1], t[0:2])",
            output = "śr ['pon', 'wt']",
        ),
        explain(
            "Pętla dzięki __getitem__",
            "Jeśli klasa ma `__getitem__`, pętla `for` pyta o indeksy 0, 1, 2… aż metoda zgłosi `IndexError`. " +
                "`__len__` musi zwracać nieujemną liczbę całkowitą – bez niej `len()` daje `TypeError`.",
            code = "class Trzy:\n    def __getitem__(self, i):\n        if i >= 3:\n            raise IndexError\n        return i * 10\n\nfor x in Trzy():\n    print(x)",
            output = "0\n10\n20",
        ),
    ),
    cards(
        "u32l4",
        explain(
            "Mnożenie przez liczbę",
            "`__mul__` obsługuje zapis `obiekt * 3`. Odwrotny zapis `3 * obiekt` wywołuje `__rmul__` obiektu – " +
                "bez tej metody kończy się `TypeError`.",
            code = "class Kwota:\n    def __init__(self, zl):\n        self.zl = zl\n    def __mul__(self, n):\n        return Kwota(self.zl * n)\n    def __rmul__(self, n):\n        return self * n\nprint((Kwota(5) * 3).zl, (2 * Kwota(7)).zl)",
            output = "15 14",
        ),
        explain(
            "+= i jednoargumentowy minus",
            "Gdy klasa ma `__add__`, zapis `c += 5` działa jak `c = c + 5` i tworzy nowy obiekt. " +
                "Minus przed obiektem, `-w`, wywołuje metodę `__neg__`.",
            code = "class W:\n    def __init__(self, x):\n        self.x = x\n    def __neg__(self):\n        return W(-self.x)\n\nprint((-W(4)).x)",
            output = "-4",
        ),
    ),
)
