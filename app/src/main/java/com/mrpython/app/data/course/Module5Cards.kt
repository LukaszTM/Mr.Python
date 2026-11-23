package com.mrpython.app.data.course

internal val module5Cards = listOf(
    cards(
        "u5l1",
        explain(
            "Indeksy od końca",
            "-1 to ostatni element, -2 przedostatni, -3 jeszcze wcześniejszy itd. Indeks spoza listy " +
                "(np. 3 w liście 3-elementowej) kończy się błędem `IndexError`.",
            code = "x = [7, 8, 9]\nprint(x[-2])\nprint(x[-3])",
            output = "8\n7",
        ),
        explain(
            "Jak wypisuje się lista?",
            "`print()` pokazuje listę razem z nawiasami kwadratowymi i przecinkami. Napisy w liście " +
                "są otoczone apostrofami.",
            code = "print([1, 2])\nprint([\"Ola\", \"Ala\"])",
            output = "[1, 2]\n['Ola', 'Ala']",
        ),
    ),
    cards(
        "u5l2",
        explain(
            "Czy element jest na liście?",
            "Operator `in` sprawdza, czy wartość jest na liście, i daje `True` albo `False`.",
            code = "x = [\"kot\", \"pies\"]\nprint(\"kot\" in x)\nprint(3 in [1, 2])",
            output = "True\nFalse",
        ),
        explain(
            "Wycinek bez początku lub końca",
            "W wycinku możesz pominąć jedną liczbę: `x[:2]` to elementy od początku do indeksu 2 (bez niego), " +
                "a `x[2:]` – od indeksu 2 do końca.",
            code = "x = [1, 2, 3, 4]\nprint(x[:2])\nprint(x[2:])",
            output = "[1, 2]\n[3, 4]",
        ),
        explain(
            "Sortowanie napisów",
            "`sort()` układa liczby od najmniejszej, a napisy – alfabetycznie.",
            code = "x = [\"ul\", \"ala\", \"ola\"]\nx.sort()\nprint(x)",
            output = "['ala', 'ola', 'ul']",
        ),
    ),
    cards(
        "u5l3",
        explain(
            "pop(i) i index()",
            "`pop(i)` usuwa i zwraca element o indeksie `i` (np. `pop(0)` – pierwszy). `index(w)` podaje " +
                "indeks pierwszego `w`. Gdy wartości nie ma na liście, `index()` i `remove()` zgłaszają błąd `ValueError`.",
            code = "x = [\"a\", \"b\", \"c\"]\nprint(x.pop(0))\nprint(x.index(\"c\"))",
            output = "a\n1",
        ),
        explain(
            "sort() czy sorted()?",
            "`x.sort()` zmienia samą listę. `sorted(x)` zwraca nową, posortowaną listę, a `x` zostaje " +
                "bez zmian. `reverse=True` sortuje malejąco.",
            code = "x = [3, 1, 2]\nprint(sorted(x))\nprint(x)\nx.sort(reverse=True)\nprint(x)",
            output = "[1, 2, 3]\n[3, 1, 2]\n[3, 2, 1]",
        ),
        explain(
            "Łączenie list: +",
            "Znak `+` łączy dwie listy w nową listę – najpierw elementy pierwszej, potem drugiej.",
            code = "a = [1, 2]\nb = [3]\nprint(a + b)",
            output = "[1, 2, 3]",
        ),
    ),
    cards(
        "u5l4",
        explain(
            "Pętla po indeksach",
            "`range(len(x))` daje kolejne indeksy listy: 0, 1, 2… Dzięki temu w pętli masz numer `i` " +
                "i element `x[i]` – możesz go też podmienić.",
            code = "x = [5, 6]\nfor i in range(len(x)):\n    x[i] = x[i] * 2\nprint(x)",
            output = "[10, 12]",
        ),
        explain(
            "Szukanie największego",
            "Zaczynamy od pierwszego elementu, a potem w pętli podmieniamy go na każdy większy. " +
                "Po pętli zostaje największy – tak działa `max()` od środka.",
            code = "x = [4, 2, 9, 5]\nnajw = x[0]\nfor n in x:\n    if n > najw:\n        najw = n\nprint(najw)",
            output = "9",
        ),
    ),
    cards(
        "u5l5",
        explain(
            "Dwie nazwy, jedna lista",
            "`y = x` nie kopiuje listy – obie nazwy wskazują tę samą listę. Zmiana przez `y` " +
                "(np. `append`) jest więc widoczna także w `x`.",
            code = "x = [1]\ny = x\ny.append(2)\nprint(x)",
            output = "[1, 2]",
        ),
        explain(
            "Wycinek z krokiem",
            "Trzecia liczba wycinka to krok: `x[::2]` bierze co drugi element od początku, a `x[1:4:2]` – " +
                "co drugi od indeksu 1 do 4 (bez 4).",
            code = "x = [\"a\", \"b\", \"c\", \"d\", \"e\"]\nprint(x[::2])\nprint(x[1:4:2])",
            output = "['a', 'c', 'e']\n['b', 'd']",
        ),
        explain(
            "Pusta lista i średnia",
            "`[]` to pusta lista: ma długość 0, a w warunku działa jak `False`. Średnią liczb policzysz " +
                "jako `sum(x) / len(x)`.",
            code = "x = []\nprint(len(x))\nprint(bool(x))\nprint(sum([2, 4]) / len([2, 4]))",
            output = "0\nFalse\n3.0",
        ),
    ),
)
