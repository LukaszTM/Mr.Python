package com.mrpython.app.data.course

internal val module40Cards = listOf(
    cards(
        "u40l1",
        explain(
            "reduce krok po kroku",
            "reduce idzie od lewej: `reduce(f, [a, b, c])` liczy `f(f(a, b), c)`. Wynik poprzedniego " +
                "kroku jest zawsze pierwszym argumentem. Wartość początkowa staje się pierwszym `a`.",
            code = "from functools import reduce\nprint(reduce(lambda a, b: a - b, [10, 3, 2]))\nprint(reduce(lambda a, b: a + b, [1, 2], 10))",
            output = "5\n13",
        ),
        explain(
            "Pusta lista i jeden element",
            "Dla jednego elementu reduce zwraca go bez wywoływania funkcji. Pusta lista bez wartości " +
                "początkowej daje `TypeError`, bo nie ma od czego zacząć.",
            code = "from functools import reduce\nprint(reduce(lambda a, b: a * b, [5]))\ntry:\n    reduce(lambda a, b: a + b, [])\nexcept TypeError:\n    print(\"TypeError\")",
            output = "5\nTypeError",
        ),
    ),
    cards(
        "u40l2",
        explain(
            "Argumenty w partial",
            "Argumenty pozycyjne w `partial` trafiają do pierwszych parametrów, po kolei. Ustalony " +
                "argument nazwany można przy wywołaniu nadpisać.",
            code = "from functools import partial\ndef odejmij(a, b=0):\n    return a - b\nf = partial(odejmij, 10, b=1)\nprint(f(), f(b=3))",
            output = "9 7",
        ),
        explain(
            "int z podstawą",
            "`int(napis, base=n)` czyta napis jako liczbę w systemie o podstawie n: 2 to system " +
                "dwójkowy, 16 – szesnastkowy. Z `partial` zrobisz z tego wygodną funkcję.",
            code = "print(int(\"101\", base=2))\nprint(int(\"ff\", base=16))",
            output = "5\n255",
        ),
    ),
    cards(
        "u40l3",
        explain(
            "maxsize i LRU",
            "`@lru_cache(maxsize=n)` pamięta najwyżej n wyników. Gdy pamięć jest pełna, wypada wynik " +
                "najdawniej używany (Least Recently Used). Bez nawiasów pamięta 128 wyników.",
            code = "from functools import lru_cache\n@lru_cache(maxsize=1)\ndef f(x):\n    print(\"licze\", x)\n    return x\nf(1); f(2); f(1)",
            output = "licze 1\nlicze 2\nlicze 1",
        ),
        explain(
            "cache_clear i currsize",
            "`cache_info().currsize` mówi, ile wyników jest teraz w pamięci. `cache_clear()` " +
                "czyści pamięć, więc kolejne wywołania liczą się od nowa.",
            code = "from functools import lru_cache\n@lru_cache\ndef f(x): return x\nf(1); f(2); f(1)\nprint(f.cache_info().currsize)\nf.cache_clear(); print(f.cache_info().currsize)",
            output = "2\n0",
        ),
    ),
    cards(
        "u40l4",
        explain(
            "Dekorator w skrócie",
            "Dekorator to funkcja, która dostaje funkcję i zwraca nową. `@ozdob` nad `def hej` to " +
                "skrót od `hej = ozdob(hej)`. Dlatego bez `wraps` nazwa to nazwa funkcji wewnętrznej.",
            code = "def ozdob(f):\n    def wrapper(): return f()\n    return wrapper\n@ozdob\ndef hej(): pass\nprint(hej.__name__)",
            output = "wrapper",
        ),
        explain(
            "Opis funkcji: __doc__",
            "Napis w pierwszej linii ciała funkcji to jej opis (docstring), dostępny jako `__doc__`. " +
                "`@wraps(f)` kopiuje go razem z nazwą.",
            code = "def hej():\n    \"Mówi hej.\"\n    return \"hej\"\nprint(hej.__doc__)",
            output = "Mówi hej.",
        ),
    ),
)
