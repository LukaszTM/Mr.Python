package com.mrpython.app.data.course

internal val module29Intro = lesson(
    "u29l0", "Wprowadzenie: matematyka w kodzie",
    explain(
        "Reszta i cyfry",
        "Operator `%` daje resztę z dzielenia: reszta 0 znaczy „dzieli się”. `n % 10` to ostatnia " +
            "cyfra, a `n // 10` odcina ją. Tak w pętli rozbierzemy liczbę na cyfry.",
        code = "n = 472\nsuma = 0\nwhile n > 0:\n    suma += n % 10\n    n //= 10\nprint(suma)",
        output = "13",
    ),
    explain(
        "Liczby pierwsze",
        "Liczba pierwsza (od 2 w górę) dzieli się tylko przez 1 i siebie. Sprawdzamy dzielniki – " +
            "wystarczy do pierwiastka z n. Sito Eratostenesa wykreśla wielokrotności, by znaleźć wiele pierwszych naraz.",
        code = "def pierwsza(n):\n    if n < 2:\n        return False\n    for d in range(2, int(n ** 0.5) + 1):\n        if n % d == 0:\n            return False\n    return True\nprint(pierwsza(7), pierwsza(9))",
        output = "True False",
    ),
    explain(
        "NWD i NWW",
        "NWD to największy wspólny dzielnik. Algorytm Euklidesa powtarza `a, b = b, a % b`, aż b " +
            "będzie 0. NWW liczymy wzorem `a * b // nwd`. Gotowe są też `math.gcd()` i `math.lcm()`.",
        code = "a, b = 48, 18\nwhile b:\n    a, b = b, a % b\nprint(a)",
        output = "6",
    ),
    explain(
        "Ciąg Fibonacciego",
        "W ciągu Fibonacciego każdy wyraz to suma dwóch poprzednich: 0, 1, 1, 2, 3, 5, 8… " +
            "Wersja z pętlą liczy każdy wyraz tylko raz, więc jest szybka.",
        code = "a, b = 0, 1\nfor _ in range(6):\n    a, b = b, a + b\nprint(a)",
        output = "8",
    ),
    explain(
        "Potęgi",
        "`**` podnosi do potęgi, a `pow(a, b, m)` od razu daje resztę z dzielenia wyniku przez m. " +
            "`n ** 0.5` to pierwiastek, a `math.isqrt()` daje pierwiastek całkowity.",
        code = "print(2 ** 10)\nprint(pow(2, 10, 1000))",
        output = "1024\n24",
    ),
    output(
        "print(25 % 7, 25 // 7)",
        "4 3",
        "25 = 3 · 7 + 4.",
    ),
    fill(
        "Uzupełnij, aby wypisać ostatnią cyfrę liczby n.",
        "n = 538\nprint(n ____ 10)",
        listOf("%", "//", "*"),
        "%",
        "Reszta z dzielenia przez 10 to cyfra jedności.",
    ),
    choice(
        "Która liczba jest pierwsza?",
        listOf("11", "9", "15", "1"),
        0,
        "11 dzieli się tylko przez 1 i 11.",
    ),
)
