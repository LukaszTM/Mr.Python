package com.mrpython.app.data.course

import com.mrpython.app.domain.CourseUnit

internal val module29 = CourseUnit(
    id = "u29",
    title = "Matematyka w kodzie",
    description = "Cyfry, liczby pierwsze, NWD, Fibonacci i potęgi",
    lessons = listOf(
        lesson(
            "u29l1", "Podzielność i cyfry",
            output("print(17 % 5, 18 % 3)", "2 0", "Reszta 0 oznacza, że 18 dzieli się przez 3."),
            output(
                "n = 4721\nsuma = 0\nwhile n > 0:\n    suma += n % 10\n    n //= 10\nprint(suma)",
                "14",
                "Odcinamy cyfry od końca: 1 + 2 + 7 + 4 = 14.",
            ),
            output(
                "n = 1230\nodw = 0\nwhile n > 0:\n    odw = odw * 10 + n % 10\n    n //= 10\nprint(odw)",
                "321",
                "Cyfry dopisujemy w odwrotnej kolejności, a zero z przodu znika.",
            ),
            choice(
                "Co daje wyrażenie n % 10 dla dodatniej liczby całkowitej n?",
                listOf("Ostatnią cyfrę liczby n", "Pierwszą cyfrę liczby n", "Liczbę cyfr", "n bez ostatniej cyfry"),
                0,
                "Reszta z dzielenia przez 10 to cyfra jedności.",
            ),
            fill(
                "Uzupełnij, aby usunąć ostatnią cyfrę liczby.",
                "n = 987\nn = n ____ 10\nprint(n)",
                listOf("//", "%", "/"),
                "//",
                "Dzielenie całkowite przez 10 odcina cyfrę jedności.",
            ),
            output("print(sum(int(c) for c in str(905)))", "14", "Można też zamienić liczbę na napis i zsumować cyfry: 9 + 0 + 5."),
            output(
                "n = 50400\nile = 0\nwhile n > 0:\n    n //= 10\n    ile += 1\nprint(ile)",
                "5",
                "Każde dzielenie przez 10 usuwa jedną cyfrę – jest ich 5.",
            ),
            tiles(
                "Sprawdź, czy n jest podzielne przez 3",
                listOf("if", "n % 3 == 0", ":"),
                listOf("n // 3 == 0", "n % 3 = 0"),
                "Liczba jest podzielna, gdy reszta z dzielenia wynosi 0.",
            ),
        ),
        lesson(
            "u29l2", "Liczby pierwsze",
            choice(
                "Która liczba jest pierwsza?",
                listOf("13", "15", "21", "1"),
                0,
                "13 dzieli się tylko przez 1 i samą siebie, a 1 nie jest liczbą pierwszą.",
            ),
            output(
                "def pierwsza(n):\n    if n < 2:\n        return False\n    for d in range(2, n):\n        if n % d == 0:\n            return False\n    return True\nprint(pierwsza(7), pierwsza(9))",
                "True False",
                "9 dzieli się przez 3, więc nie jest pierwsza.",
            ),
            choice(
                "Dlaczego dzielników wystarczy szukać do pierwiastka z n?",
                listOf(
                    "Jeśli n = a · b, to jeden z czynników jest nie większy niż pierwiastek z n",
                    "Bo większych dzielników nie ma",
                    "Bo liczby pierwsze są małe",
                    "Bo tak wymaga Python",
                ),
                0,
                "Gdyby oba czynniki były większe od pierwiastka, ich iloczyn przekroczyłby n.",
            ),
            output(
                "def pierwsza(n):\n    if n < 2:\n        return False\n    for d in range(2, int(n ** 0.5) + 1):\n        if n % d == 0:\n            return False\n    return True\nprint([n for n in range(10, 20) if pierwsza(n)])",
                "[11, 13, 17, 19]",
                "Między 10 a 19 pierwsze są 11, 13, 17 i 19.",
            ),
            fill(
                "Uzupełnij, aby sprawdzić, czy d jest dzielnikiem n.",
                "n, d = 12, 4\nprint(n ____ d == 0)",
                listOf("%", "//", "-"),
                "%",
                "d jest dzielnikiem, gdy reszta z dzielenia n przez d wynosi 0.",
            ),
            output(
                "n = 15\njest = [True] * (n + 1)\njest[0] = jest[1] = False\nfor i in range(2, n + 1):\n    if jest[i]:\n        for k in range(i * i, n + 1, i):\n            jest[k] = False\nprint([i for i in range(n + 1) if jest[i]])",
                "[2, 3, 5, 7, 11, 13]",
                "Sito wykreśla wielokrotności 2 i 3, a reszta to liczby pierwsze.",
            ),
            choice(
                "Co robi sito Eratostenesa?",
                listOf(
                    "Wykreśla wielokrotności kolejnych liczb pierwszych",
                    "Dzieli każdą liczbę przez 2",
                    "Losuje liczby pierwsze",
                    "Sortuje liczby rosnąco",
                ),
                0,
                "Co zostanie niewykreślone, jest liczbą pierwszą.",
            ),
            output(
                "n = 12\ndz = [d for d in range(1, n + 1)\n      if n % d == 0]\nprint(len(dz))",
                "6",
                "Dzielniki 12 to 1, 2, 3, 4, 6 i 12.",
            ),
        ),
        lesson(
            "u29l3", "NWD i NWW",
            output(
                "a, b = 48, 18\nwhile b:\n    a, b = b, a % b\nprint(a)",
                "6",
                "Algorytm Euklidesa: (48, 18) → (18, 12) → (12, 6) → (6, 0).",
            ),
            output(
                "a, b = 20, 8\nwhile b:\n    print(a, b)\n    a, b = b, a % b",
                "20 8\n8 4",
                "Po drugim kroku b = 0, więc pętla się kończy, a NWD to 4.",
            ),
            output(
                "def nwd(a, b):\n    while b:\n        a, b = b, a % b\n    return a\n\ndef nww(a, b):\n    return a * b // nwd(a, b)\n\nprint(nww(4, 6))",
                "12",
                "NWW = 4 · 6 // NWD(4, 6) = 24 // 2 = 12.",
            ),
            choice(
                "Co oznacza zapis NWD(12, 18) = 6?",
                listOf(
                    "6 to największa liczba, która dzieli 12 i 18",
                    "6 to najmniejsza wspólna wielokrotność 12 i 18",
                    "6 to różnica liczb 18 i 12",
                    "6 to reszta z dzielenia 18 przez 12",
                ),
                0,
                "NWD to największy wspólny dzielnik.",
            ),
            fill(
                "Uzupełnij krok algorytmu Euklidesa.",
                "a, b = 36, 24\nwhile b:\n    a, b = ____, a % b\nprint(a)",
                listOf("b", "a", "0"),
                "b",
                "Nowe a to stare b, a nowe b to reszta z dzielenia a przez b.",
            ),
            output(
                "import math\nprint(math.gcd(84, 36))\nprint(math.lcm(4, 10))",
                "12\n20",
                "Moduł math ma gotowe funkcje gcd (NWD) i lcm (NWW).",
            ),
            choice(
                "Jak policzyć NWW, znając NWD?",
                listOf("a * b // nwd(a, b)", "a + b - nwd(a, b)", "nwd(a, b) * 2", "a // b * nwd(a, b)"),
                0,
                "Iloczyn liczb równa się iloczynowi ich NWD i NWW.",
            ),
            tiles(
                "Zapisz krok Euklidesa: nowe a to b, a nowe b to reszta z dzielenia a przez b",
                listOf("a, b", "=", "b,", "a % b"),
                listOf("a // b", "b % a"),
                "a, b = b, a % b wykonuje oba przypisania naraz.",
            ),
        ),
        lesson(
            "u29l4", "Fibonacci i potęgi",
            output(
                "fib = [0, 1]\nwhile len(fib) < 7:\n    fib.append(fib[-1] + fib[-2])\nprint(fib)",
                "[0, 1, 1, 2, 3, 5, 8]",
                "Każdy wyraz to suma dwóch poprzednich.",
            ),
            output(
                "def fib(n):\n    a, b = 0, 1\n    for _ in range(n):\n        a, b = b, a + b\n    return a\n\nprint(fib(10))",
                "55",
                "Dziesiąty wyraz ciągu Fibonacciego (licząc od zera) to 55.",
            ),
            choice(
                "Dlaczego wersja iteracyjna Fibonacciego jest szybsza od prostej rekurencji?",
                listOf(
                    "Każdą liczbę liczy tylko raz",
                    "Bo pętle zawsze są szybsze od funkcji",
                    "Bo nie używa dodawania",
                    "Nie jest szybsza",
                ),
                0,
                "Prosta rekurencja wiele razy liczy te same wyrazy od nowa.",
            ),
            fill(
                "Uzupełnij, aby obliczyć kolejną parę liczb Fibonacciego.",
                "a, b = 0, 1\nfor _ in range(6):\n    a, b = b, ____\nprint(a)",
                listOf("a + b", "a * b", "b + 1"),
                "a + b",
                "Następny wyraz to suma dwóch poprzednich – po 6 krokach a = 8.",
            ),
            output(
                "print(2 ** 10)\nprint(pow(3, 4))\nprint(pow(2, 10, 1000))",
                "1024\n81\n24",
                "pow(a, b, m) liczy resztę z a do potęgi b przez m: 1024 % 1000 = 24.",
            ),
            output(
                "def potega_dwojki(n):\n    while n % 2 == 0 and n > 1:\n        n //= 2\n    return n == 1\n\nprint(potega_dwojki(16), potega_dwojki(12))",
                "True False",
                "16 da się połowić aż do 1, a 12 kończy na 3.",
            ),
            choice(
                "Jak najprościej sprawdzić, czy liczba n jest parzysta?",
                listOf("n % 2 == 0", "n / 2 == 0", "n // 2 == 1", "str(n).endswith(\"0\")"),
                0,
                "Parzysta liczba daje resztę 0 z dzielenia przez 2.",
            ),
            output(
                "import math\nfor n in [49, 50]:\n    r = math.isqrt(n)\n    print(r * r == n)",
                "True\nFalse",
                "math.isqrt() daje całkowity pierwiastek – 49 to 7 · 7, a 50 nie jest kwadratem.",
            ),
        ),
        lesson(
            "u29l5", "Powtórka: matematyka",
            output("print(sum(int(c) for c in str(2026)))", "10", "2 + 0 + 2 + 6 = 10."),
            output("n = 12321\nprint(str(n) == str(n)[::-1])", "True", "12321 czytane od tyłu daje tę samą liczbę."),
            choice(
                "Która liczba NIE jest pierwsza?",
                listOf("91", "97", "89", "83"),
                0,
                "91 = 7 · 13.",
            ),
            output(
                "def nwd(a, b):\n    while b:\n        a, b = b, a % b\n    return a\n\nprint(nwd(27, 45), nwd(7, 5))",
                "9 1",
                "NWD 27 i 45 to 9, a 7 i 5 nie mają wspólnych dzielników poza 1.",
            ),
            fill(
                "Uzupełnij, aby obliczyć pierwiastek kwadratowy z n.",
                "n = 49\nprint(n ** ____)",
                listOf("0.5", "2", "-1"),
                "0.5",
                "Potęga 0.5 to pierwiastek kwadratowy: 7.0.",
            ),
            output(
                "a, b = 1, 1\nwhile b < 50:\n    a, b = b, a + b\nprint(b)",
                "55",
                "Pierwszy wyraz ciągu Fibonacciego nie mniejszy niż 50 to 55.",
            ),
            output("print(len(str(2 ** 100)))", "31", "2 do potęgi 100 ma 31 cyfr – Python liczy to dokładnie."),
            tiles(
                "Dodaj ostatnią cyfrę liczby n do zmiennej suma",
                listOf("suma", "+=", "n % 10"),
                listOf("n // 10", "=="),
                "n % 10 to ostatnia cyfra.",
            ),
        ),
    ),
)
