package com.mrpython.app.data.course

internal val module17Cards = listOf(
    cards(
        "u17l1",
        explain(
            "Kod po wywołaniu",
            "Instrukcje po wywołaniu rekurencyjnym wykonują się dopiero, gdy to wywołanie się skończy – " +
                "w drodze powrotnej. Dlatego `print` po wywołaniu wypisuje liczby od najmniejszej.",
            code = "def f(n):\n    if n == 0:\n        return\n    f(n - 1)\n    print(n)\nf(2)",
            output = "1\n2",
        ),
        explain(
            "Samo return",
            "`return` bez wartości po prostu kończy funkcję. Tak często wygląda warunek stopu. " +
                "Każde wywołanie musi zbliżać się do tego warunku – inaczej pojawi się `RecursionError`.",
            code = "def f(n):\n    if n > 2:\n        return\n    print(n)\n    f(n + 1)\nf(1)",
            output = "1\n2",
        ),
    ),
    cards(
        "u17l2",
        explain(
            "Cyfry liczby",
            "`n % 10` to ostatnia cyfra liczby, a `n // 10` – liczba bez ostatniej cyfry. Rekurencja " +
                "może tak odcinać cyfry, aż zostanie jedna (`n < 10`).",
            code = "n = 507\nprint(n % 10, n // 10)",
            output = "7 50",
        ),
    ),
    cards(
        "u17l3",
        explain(
            "Pusta lista jest fałszywa",
            "Pusta lista `[]`, tak jak pusty napis, jest „fałszywa”. Dlatego warunek stopu często " +
                "zapisujemy krótko: `if not lista:`.",
            code = "print(not [], not [1])\nprint(not \"\")",
            output = "True False\nTrue",
        ),
        explain(
            "Środek i łączenie list",
            "`s[1:-1]` to napis bez pierwszego i ostatniego znaku – przydaje się do palindromów. " +
                "Listy łączymy `+`, więc pojedynczy element bierzemy w nawiasy: `[l[0]] + reszta`.",
            code = "print(\"kajak\"[1:-1])\nprint([1] + [2, 3])",
            output = "aja\n[1, 2, 3]",
        ),
    ),
    cards(
        "u17l4",
        explain(
            "Fibonacci w pętli",
            "Zapis `a, b = b, a + b` najpierw liczy obie wartości po prawej, a potem przypisuje je naraz. " +
                "Tak pętla przesuwa się po ciągu Fibonacciego bez powtarzania obliczeń.",
            code = "a, b = 0, 1\nfor _ in range(5):\n    a, b = b, a + b\nprint(a)",
            output = "5",
        ),
        explain(
            "Limit w module sys",
            "Limit głębokości rekurencji podaje funkcja `getrecursionlimit()` z modułu `sys`. " +
                "Przekroczenie go zgłasza `RecursionError`, który można złapać w `try` i `except`.",
            code = "import sys\nprint(sys.getrecursionlimit())",
            output = "1000",
        ),
    ),
)
