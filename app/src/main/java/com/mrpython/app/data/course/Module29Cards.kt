package com.mrpython.app.data.course

internal val module29Cards = listOf(
    cards(
        "u29l1",
        explain(
            "Odwracanie liczby",
            "Cyfry liczby można odwrócić w pętli: `odw * 10` robi miejsce na nową cyfrę, a `+ n % 10` " +
                "dopisuje ostatnią cyfrę n. Potem `n //= 10` ją odcina.",
            code = "n = 123\nodw = 0\nwhile n > 0:\n    odw = odw * 10 + n % 10\n    n //= 10\nprint(odw)",
            output = "321",
        ),
        explain(
            "Liczenie cyfr",
            "Każde `n //= 10` usuwa jedną cyfrę, więc licząc obroty pętli aż do zera, poznamy liczbę cyfr. " +
                "Zwróć uwagę na zera: 100 też ma 3 cyfry.",
            code = "n = 100\nile = 0\nwhile n > 0:\n    n //= 10\n    ile += 1\nprint(ile)",
            output = "3",
        ),
        explain(
            "Liczba jako napis",
            "Krócej działa zamiana liczby na napis: `len(str(n))` to liczba cyfr, a " +
                "`sum(int(c) for c in str(n))` sumuje cyfry – każdy znak `c` zamieniamy z powrotem na liczbę.",
            code = "n = 905\nprint(len(str(n)))\nprint(sum(int(c) for c in str(n)))",
            output = "3\n14",
        ),
    ),
    cards(
        "u29l2",
        explain(
            "Lista flag True/False",
            "`[True] * (n + 1)` tworzy listę n + 1 wartości True – po jednej dla każdej liczby od 0 do n. " +
                "Zapis `a[0] = a[1] = False` ustawia dwa miejsca naraz, a `sum()` liczy True jako 1.",
            code = "jest = [True] * 4\njest[0] = jest[1] = False\nprint(jest)\nprint(sum(jest))",
            output = "[False, False, True, True]\n2",
        ),
        explain(
            "Sito krok po kroku",
            "Sito idzie po liczbach i, które nie są wykreślone, i wykreśla ich wielokrotności przez " +
                "`range(i * i, n + 1, i)` – krok i skacze co i. Mniejsze wielokrotności wykreśliły już wcześniejsze liczby.",
            code = "print(list(range(9, 31, 3)))",
            output = "[9, 12, 15, 18, 21, 24, 27, 30]",
        ),
        explain(
            "Rozkład na czynniki",
            "Dzielimy n przez d, dopóki się da, i zapisujemy d. Gdy d już nie dzieli n, zwiększamy d o 1. " +
                "Kończymy, gdy n spadnie do 1 – w liście zostają czynniki pierwsze.",
            code = "n, d = 12, 2\nczynniki = []\nwhile n > 1:\n    if n % d == 0:\n        czynniki.append(d)\n        n //= d\n    else:\n        d += 1\nprint(czynniki)",
            output = "[2, 2, 3]",
        ),
    ),
    cards(
        "u29l3",
        explain(
            "Skracanie ułamków",
            "Dzieląc licznik i mianownik przez ich NWD, dostajemy ułamek nieskracalny. " +
                "Uwaga: NWD liczby i zera to sama liczba, np. `math.gcd(9, 0)` daje 9.",
            code = "import math\nd = math.gcd(12, 16)\nprint(12 // d, 16 // d)",
            output = "3 4",
        ),
    ),
    cards(
        "u29l4",
        explain(
            "Fibonacci w liście",
            "Ciąg można trzymać w liście: `fib[-1]` to ostatni wyraz, a `fib[-2]` przedostatni. " +
                "Ich suma to następny wyraz, który dopisujemy przez `append()`.",
            code = "fib = [0, 1]\nwhile len(fib) < 6:\n    fib.append(fib[-1] + fib[-2])\nprint(fib)",
            output = "[0, 1, 1, 2, 3, 5]",
        ),
        explain(
            "Potęgi dwójki",
            "Każda liczba do potęgi 0 daje 1. Potęgę dwójki poznasz po tym, że da się ją dzielić " +
                "przez 2 aż do 1 – inna liczba utknie na reszcie nieparzystej.",
            code = "n = 12\nwhile n % 2 == 0 and n > 1:\n    n //= 2\nprint(n, n == 1)\nprint(2 ** 0)",
            output = "3 False\n1",
        ),
        explain(
            "Czy to kwadrat?",
            "`math.isqrt(n)` daje część całkowitą pierwiastka. Jeśli po podniesieniu jej do kwadratu " +
                "wrócimy do n, to n jest kwadratem liczby całkowitej.",
            code = "import math\nfor n in [49, 50]:\n    print(math.isqrt(n) ** 2 == n)",
            output = "True\nFalse",
        ),
    ),
    cards(
        "u29l5",
        explain(
            "Palindrom liczbowy",
            "Liczbę łatwo odwrócić przez napis: `str(n)[::-1]`, a `int()` zamienia wynik z powrotem na liczbę " +
                "(zera z przodu znikają). Jeśli odwrócony napis jest taki sam, liczba jest palindromem.",
            code = "n = 1221\nprint(str(n) == str(n)[::-1])\nprint(int(str(540)[::-1]))",
            output = "True\n45",
        ),
        explain(
            "Pierwsza cyfra",
            "Ostatnią cyfrę daje `% 10`, a pierwszą – dzielenie całkowite przez odpowiednią potęgę 10: " +
                "dla liczby trzycyfrowej `n // 100`. Python liczy dokładnie nawet bardzo duże liczby.",
            code = "n = 123\nprint(n // 100, n % 10)\nprint(len(str(2 ** 100)))",
            output = "1 3\n31",
        ),
    ),
)
