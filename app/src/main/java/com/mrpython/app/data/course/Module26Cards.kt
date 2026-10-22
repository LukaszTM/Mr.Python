package com.mrpython.app.data.course

internal val module26Cards = listOf(
    cards(
        "u26l1",
        explain(
            "Zamiana miejscami",
            "Zapis `x, y = y, x` zamienia wartości dwóch zmiennych w jednym kroku, bez zmiennej pomocniczej. " +
                "Tak samo zamienisz dwa elementy listy: `a[i], a[i + 1] = a[i + 1], a[i]`.",
            code = "x, y = 4, 9\nx, y = y, x\nprint(x, y)\na = [3, 1]\na[0], a[1] = a[1], a[0]\nprint(a)",
            output = "9 4\n[1, 3]",
        ),
        explain(
            "Pełne sortowanie",
            "Jedno przejście ustawia na końcu tylko jeden element, więc powtarzamy je n - 1 razy " +
                "(pętla w pętli). Ostatnie k elementów jest już na miejscu – stąd `range(n - 1 - k)`. " +
                "Warunek `<` zamiast `>` sortuje malejąco.",
            code = "a = [5, 2, 4, 1]\nn = len(a)\nfor k in range(n - 1):\n    for i in range(n - 1 - k):\n        if a[i] > a[i + 1]:\n            a[i], a[i + 1] = a[i + 1], a[i]",
        ),
    ),
    cards(
        "u26l2",
        explain(
            "Pełny algorytm",
            "Jeden krok: dla pozycji `i` szukamy indeksu `m` najmniejszego elementu od `i` do końca " +
                "i zamieniamy `a[i]` z `a[m]`. Pełny algorytm powtarza ten krok w pętli `for i in range(len(a))`.",
            code = "a = [3, 1, 2]\ni, m = 0, 0\nfor j in range(i + 1, len(a)):\n    if a[j] < a[m]:\n        m = j\na[i], a[m] = a[m], a[i]",
        ),
        explain(
            "Pętla while lista:",
            "Niepusta lista w warunku jest prawdziwa, a pusta – fałszywa. `while a:` działa więc, " +
                "dopóki w liście coś zostało. Tak można wybierać i usuwać kolejne minima.",
            code = "a = [7, 3, 5]\nwynik = []\nwhile a:\n    m = min(a)\n    wynik.append(m)\n    a.remove(m)",
        ),
    ),
    cards(
        "u26l3",
        explain(
            "Przesuwanie w prawo",
            "Wstawiając `x = a[i]`, idziemy w lewo od `j = i - 1`. Każdy element większy od `x` " +
                "przesuwamy o jedno miejsce w prawo (`a[j + 1] = a[j]`), a `x` wpisujemy w lukę: `a[j + 1] = x`.",
            code = "a = [1, 4, 2]\nx, j = a[2], 1\nwhile j >= 0 and a[j] > x:\n    a[j + 1] = a[j]\n    j -= 1\na[j + 1] = x",
        ),
        explain(
            "Bezpieczny warunek and",
            "`and` sprawdza warunki od lewej i przerywa przy pierwszym fałszu. W `j >= 0 and a[j] > x` " +
                "drugi warunek nie jest liczony, gdy `j` spadło poniżej zera – dzięki temu nie wyjdziemy poza listę.",
            code = "a = [5]\nj = -1\nprint(j >= 0 and a[j] > 3)",
            output = "False",
        ),
    ),
    cards(
        "u26l4",
        explain(
            "Wielkie litery najpierw",
            "Napisy sortują się według kodów znaków, a wielkie litery mają mniejsze kody niż małe. " +
                "`key=str.lower` porównuje wersje pisane małymi literami, nie zmieniając samych napisów.",
            code = "imiona = [\"ola\", \"Ewa\", \"adam\"]\nprint(sorted(imiona))\nprint(sorted(imiona, key=str.lower))",
            output = "['Ewa', 'adam', 'ola']\n['adam', 'Ewa', 'ola']",
        ),
    ),
    cards(
        "u26l5",
        explain(
            "Minus odwraca kolejność",
            "W kluczu-krotce każde kryterium sortuje się rosnąco. Żeby jedno z nich – liczbę – posortować " +
                "malejąco, dajemy przed nią minus: `(-wiek, imie)`.",
            code = "osoby = [(\"Ola\", 20), (\"Jan\", 18), (\"Ewa\", 20)]\nw = sorted(osoby, key=lambda o: (-o[1], o[0]))\nprint([o[0] for o in w])",
            output = "['Ewa', 'Ola', 'Jan']",
        ),
        explain(
            "Klucz: slownik.get",
            "Metoda `get` słownika zwraca wartość dla klucza, więc `key=d.get` sortuje klucze według " +
                "ich wartości. Podajemy ją bez nawiasów, jak każdą funkcję w `key`.",
            code = "glosy = {\"A\": 3, \"B\": 8, \"C\": 5}\nprint(sorted(glosy, key=glosy.get))",
            output = "['A', 'C', 'B']",
        ),
    ),
    cards(
        "u26l6",
        explain(
            "Liczby zapisane napisami",
            "Napisy porównuje się znak po znaku, więc \"10\" jest przed \"9\" (bo 1 < 9). " +
                "`key=int` każe porównywać je jak liczby.",
            code = "a = [\"9\", \"100\", \"10\"]\nprint(sorted(a))\nprint(sorted(a, key=int))",
            output = "['10', '100', '9']\n['9', '10', '100']",
        ),
    ),
)
