package com.mrpython.app.data.course

internal val module39Cards = listOf(
    cards(
        "u39l1",
        explain(
            "islice jak wycinek",
            "`islice(x, start, stop, krok)` działa jak wycinek `[start:stop:krok]` – koniec nie jest " +
                "wliczany. Z jedną liczbą bierze n pierwszych elementów. Zwraca iterator, więc wynik " +
                "oglądamy przez `list()`.",
            code = "from itertools import islice\nprint(list(islice(\"python\", 2, 5)))\nprint(list(islice(range(10), 0, 10, 3)))",
            output = "['t', 'h', 'o']\n[0, 3, 6, 9]",
        ),
        explain(
            "count to iterator",
            "`count` jest iteratorem: każde `next()` daje kolejną liczbę. Krok może być ujemny – " +
                "wtedy liczy w dół. W `zip` z listą zatrzyma się razem z krótszą listą.",
            code = "from itertools import count\nc = count(10, -3)\nprint(next(c), next(c))\nfor nr, s in zip(count(1), [\"a\", \"b\"]):\n    print(nr, s)",
            output = "10 7\n1 a\n2 b",
        ),
    ),
    cards(
        "u39l2",
        explain(
            "product z repeat",
            "`product(x, repeat=2)` tworzy wszystkie pary z tego samego zbioru – jak `product(x, x)`. " +
                "Wyników jest tyle, ile iloczyn długości, np. 2 · 2 = 4.",
            code = "from itertools import product\nfor p in product(\"01\", repeat=2):\n    print(\"\".join(p))",
            output = "00\n01\n10\n11",
        ),
        explain(
            "chain.from_iterable",
            "`chain(a, b)` dostaje kilka osobnych ciągów. Gdy masz je zebrane w jednej liście, użyj " +
                "`chain.from_iterable(lista)` – spłaszczy listę list.",
            code = "from itertools import chain\ndane = [[1, 2], [3], [4]]\nprint(list(chain(dane)))\nprint(list(chain.from_iterable(dane)))",
            output = "[[1, 2], [3], [4]]\n[1, 2, 3, 4]",
        ),
    ),
    cards(
        "u39l3",
        explain(
            "Permutacje długości r",
            "`permutations(x, r)` daje uporządkowane układy r elementów. Bez r bierze wszystkie " +
                "elementy. Z 3 liter par jest 3 · 2 = 6.",
            code = "from itertools import permutations\nprint([\"\".join(p) for p in permutations(\"abc\", 2)])",
            output = "['ab', 'ac', 'ba', 'bc', 'ca', 'cb']",
        ),
        explain(
            "Kolejność i powtórki",
            "Kombinacje zachowują kolejność z wejścia, więc jest (1, 2), ale nie (2, 1). Funkcje " +
                "patrzą na pozycje, nie wartości: w \"aab\" dwie litery a to różne elementy, więc " +
                "permutacje się powtarzają.",
            code = "from itertools import combinations, permutations\nprint((2, 1) in combinations([1, 2, 3], 2))\np = list(permutations(\"aab\"))\nprint(len(p), len(set(p)))",
            output = "False\n6 3",
        ),
    ),
    cards(
        "u39l4",
        explain(
            "groupby z kluczem",
            "Parametr `key` to funkcja, według której grupujemy, np. `len` albo `lambda s: s[0]`. " +
                "Kluczem grupy jest wynik tej funkcji, a dane sortujemy po tym samym kluczu.",
            code = "from itertools import groupby\nslowa = sorted([\"ab\", \"c\", \"de\"], key=len)\nfor k, g in groupby(slowa, key=len):\n    print(k, list(g))",
            output = "1 ['c']\n2 ['ab', 'de']",
        ),
        explain(
            "accumulate z lambdą",
            "Do `accumulate` można podać lambdę dwóch argumentów: wynik dotąd i kolejny element. " +
                "Na napisach domyślne „dodawanie” skleja je narastająco.",
            code = "from itertools import accumulate\nprint(list(accumulate([1, 2, 3, 4], lambda a, b: a * b)))\nprint(list(accumulate(\"abc\")))",
            output = "[1, 2, 6, 24]\n['a', 'ab', 'abc']",
        ),
    ),
)
