package com.mrpython.app.data.course

internal val module17Intro = lesson(
    "u17l0", "Wprowadzenie: rekurencja",
    explain(
        "Funkcja woła samą siebie",
        "Rekurencja to sytuacja, w której funkcja wywołuje samą siebie dla mniejszego problemu. " +
            "Zamiast pętli: „zrób jeden krok i poproś siebie o resztę”.",
        code = "def odliczaj(n):\n    if n == 0:\n        print(\"Start!\")\n        return\n    print(n)\n    odliczaj(n - 1)\n\nodliczaj(2)",
        output = "2\n1\nStart!",
    ),
    explain(
        "Warunek stopu",
        "Każda rekurencja potrzebuje warunku stopu – przypadku, w którym funkcja kończy się bez " +
            "wywołania samej siebie. Bez niego wywołania nigdy by się nie skończyły.",
        code = "def silnia(n):\n    if n <= 1:\n        return 1\n    return n * silnia(n - 1)\n\nprint(silnia(4))",
        output = "24",
    ),
    explain(
        "Fibonacci",
        "Każdy wyraz ciągu Fibonacciego to suma dwóch poprzednich – to naturalnie zapisuje się " +
            "rekurencją. Ale te same wartości liczone są wiele razy, więc dla dużych n jest wolno.",
        code = "def fib(n):\n    if n < 2:\n        return n\n    return fib(n - 1) + fib(n - 2)\n\nprint(fib(6))",
        output = "8",
    ),
    explain(
        "Napisy i listy",
        "Na napisach i listach często bierzemy pierwszy element i resztę: `s[1:]`. Każde wywołanie " +
            "dostaje krótszy napis, aż zostanie pusty.",
        code = "def odwroc(s):\n    if s == \"\":\n        return \"\"\n    return odwroc(s[1:]) + s[0]\n\nprint(odwroc(\"kot\"))",
        output = "tok",
    ),
    explain(
        "Limit głębokości",
        "Python pozwala na około 1000 zagnieżdżonych wywołań – potem zgłasza `RecursionError`. " +
            "Gdy kroków może być bardzo dużo, lepiej użyć zwykłej pętli.",
        code = "wynik = 1\nfor i in range(1, 5):\n    wynik *= i\nprint(wynik)",
        output = "24",
    ),
    output(
        "def suma(n):\n    if n == 0:\n        return 0\n    return n + suma(n - 1)\n\nprint(suma(3))",
        "6",
        "suma(3) = 3 + 2 + 1 + 0 = 6.",
    ),
    choice(
        "Czym jest warunek stopu w rekurencji?",
        listOf(
            "Przypadkiem, w którym funkcja kończy się bez wywołania samej siebie",
            "Instrukcją break w pętli",
            "Pierwszym wywołaniem funkcji",
            "Błędem, który zatrzymuje program",
        ),
        0,
        "Warunek stopu kończy łańcuch wywołań.",
    ),
)
