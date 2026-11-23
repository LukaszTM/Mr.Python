package com.mrpython.app.data.course

import com.mrpython.app.domain.CourseUnit

internal val module40 = CourseUnit(
    id = "u40",
    title = "Moduł functools",
    description = "reduce, partial, lru_cache i wraps",
    lessons = listOf(
        lesson(
            "u40l1", "reduce",
            output(
                "from functools import reduce\nprint(reduce(lambda a, b: a + b, [1, 2, 3, 4]))",
                "10",
                "reduce składa listę w jedną wartość: ((1 + 2) + 3) + 4.",
            ),
            output(
                "from functools import reduce\nprint(reduce(lambda a, b: a * b, [2, 3, 4]))",
                "24",
                "Kolejne mnożenia: 2 · 3 = 6, 6 · 4 = 24.",
            ),
            output(
                "from functools import reduce\nprint(reduce(lambda a, b: a + b, [], 100))",
                "100",
                "Trzeci argument to wartość początkowa – przy pustej liście zostaje zwrócona.",
            ),
            choice(
                "Co się stanie przy reduce na pustej liście bez wartości początkowej?",
                listOf("TypeError", "Wynik 0", "Wynik None", "Pusta lista"),
                0,
                "reduce nie ma od czego zacząć, więc zgłasza TypeError.",
                code = "from functools import reduce\nreduce(lambda a, b: a + b, [])",
            ),
            output(
                "from functools import reduce\nprint(reduce(lambda a, b: a if a > b else b, [3, 8, 2]))",
                "8",
                "Ta lambda zostawia większą liczbę – to szukanie maksimum.",
            ),
            fill(
                "Uzupełnij, aby skleić litery w napis \"abc\".",
                "from functools import reduce\nprint(reduce(____, [\"a\", \"b\", \"c\"]))",
                listOf("lambda a, b: a + b", "lambda a, b: b + a", "lambda a, b: a", "max"),
                "lambda a, b: a + b",
                "Doklejanie b na koniec a daje „abc”.",
            ),
            tiles(
                "Zaimportuj reduce z functools",
                listOf("from", "functools", "import", "reduce"),
                listOf("itertools", "include"),
                "reduce w Pythonie 3 trzeba zaimportować z functools.",
            ),
        ),
        lesson(
            "u40l2", "partial",
            output(
                "from functools import partial\ndef potega(x, n):\n    return x ** n\nkwadrat = partial(potega, n=2)\nprint(kwadrat(5))",
                "25",
                "partial ustala argument n=2 na stałe.",
            ),
            output(
                "from functools import partial\ndef dodaj(a, b):\n    return a + b\nplus10 = partial(dodaj, 10)\nprint(plus10(5))",
                "15",
                "Argument pozycyjny 10 trafia do a.",
            ),
            output(
                "from functools import partial\nhex2 = partial(int, base=16)\nprint(hex2(\"ff\"))",
                "255",
                "partial działa też z funkcjami wbudowanymi.",
            ),
            choice(
                "Co zwraca partial(f, 1)?",
                listOf("Nową funkcję z ustalonym pierwszym argumentem", "Wynik f(1)", "Listę argumentów", "Kopię f bez zmian"),
                0,
                "partial tworzy nowy obiekt wywoływalny, nie wywołuje f.",
            ),
            output(
                "from functools import partial\nnapis = partial(print, end=\"!\\n\")\nnapis(\"Hej\")",
                "Hej!",
                "Ustawiliśmy na stałe parametr end funkcji print.",
            ),
            fill(
                "Uzupełnij, aby szescian(2) zwracało 8.",
                "from functools import partial\ndef potega(x, n):\n    return x ** n\nszescian = partial(potega, ____)\nprint(szescian(2))",
                listOf("n=3", "x=3", "3", "n=2"),
                "n=3",
                "Ustawiamy wykładnik n, a x podajemy przy wywołaniu.",
            ),
            choice(
                "Który zapis daje to samo co partial(dodaj, 10)?",
                listOf("lambda b: dodaj(10, b)", "lambda b: dodaj(b)", "dodaj(10)", "lambda: dodaj(10, 10)"),
                0,
                "partial to wygodny zamiennik prostej lambdy.",
            ),
        ),
        lesson(
            "u40l3", "lru_cache",
            output(
                "from functools import lru_cache\n@lru_cache\ndef fib(n):\n    if n < 2:\n        return n\n    return fib(n - 1) + fib(n - 2)\nprint(fib(30))",
                "832040",
                "Dzięki pamięci podręcznej każde fib(n) liczy się tylko raz.",
            ),
            output(
                "from functools import lru_cache\n@lru_cache\ndef kw(x):\n    print(\"licze\")\n    return x * x\nprint(kw(3))\nprint(kw(3))",
                "licze\n9\n9",
                "Drugie wywołanie z tym samym argumentem bierze wynik z pamięci – funkcja się nie wykonuje.",
            ),
            output(
                "from functools import lru_cache\n@lru_cache\ndef f(x):\n    return x + 1\nf(1)\nf(1)\nf(2)\nprint(f.cache_info().hits)",
                "1",
                "Trafienie w pamięć było tylko raz – przy drugim f(1).",
            ),
            output(
                "from functools import lru_cache\n@lru_cache\ndef f(x):\n    return x\nfor i in [1, 2, 1, 1]:\n    f(i)\nprint(f.cache_info().misses)",
                "2",
                "Pudła (misses) to pierwsze wywołania dla 1 i dla 2.",
            ),
            choice(
                "Dlaczego fib z lru_cache jest dużo szybsza od zwykłej rekurencji?",
                listOf("Nie liczy ponownie tych samych wartości", "Używa pętli zamiast rekurencji", "Działa na wielu rdzeniach", "Pomija co drugie wywołanie"),
                0,
                "Wyniki są zapamiętywane, więc liczba wywołań spada z wykładniczej do liniowej.",
            ),
            fill(
                "Uzupełnij dekorator zapamiętujący wyniki.",
                "from functools import lru_cache\n@____\ndef silnia(n):\n    return 1 if n == 0 else n * silnia(n - 1)\nprint(silnia(5))",
                listOf("lru_cache", "cache_info", "reduce", "partial"),
                "lru_cache",
                "@lru_cache dodaje pamięć podręczną do funkcji.",
            ),
            choice(
                "Co oznacza maxsize=128 w @lru_cache(maxsize=128)?",
                listOf("Pamięć trzyma najwyżej 128 ostatnich wyników", "Funkcja przyjmie najwyżej 128 argumentów", "Wynik nie przekroczy 128", "Funkcja wykona się najwyżej 128 razy"),
                0,
                "Gdy pamięć jest pełna, usuwany jest najdawniej używany wynik (LRU).",
            ),
            tiles(
                "Wypisz liczbę trafień w pamięć funkcji fib",
                listOf("print(", "fib.cache_info()", ".hits", ")"),
                listOf("fib(", ".misses"),
                "cache_info() zwraca statystyki pamięci, a hits to liczba trafień.",
            ),
        ),
        lesson(
            "u40l4", "Powtórka: functools i wraps",
            output(
                "def ozdob(f):\n    def wrapper():\n        return f()\n    return wrapper\n@ozdob\ndef hej():\n    pass\nprint(hej.__name__)",
                "wrapper",
                "Bez wraps funkcja traci swoją nazwę – widać nazwę funkcji wewnętrznej.",
            ),
            output(
                "from functools import wraps\ndef ozdob(f):\n    @wraps(f)\n    def wrapper():\n        return f()\n    return wrapper\n@ozdob\ndef hej():\n    pass\nprint(hej.__name__)",
                "hej",
                "@wraps(f) kopiuje nazwę i opis oryginalnej funkcji.",
            ),
            fill(
                "Uzupełnij, aby udekorowana funkcja zachowała swoją nazwę.",
                "from functools import wraps\ndef log(f):\n    @____(f)\n    def w(*a):\n        return f(*a)\n    return w\n@log\ndef suma(x, y):\n    return x + y\nprint(suma.__name__)",
                listOf("wraps", "partial", "lru_cache", "reduce"),
                "wraps",
                "wraps przenosi metadane z f na funkcję wewnętrzną.",
            ),
            output(
                "from functools import reduce\nprint(reduce(lambda a, b: a * 10 + b, [1, 2, 3]))",
                "123",
                "(1 · 10 + 2) · 10 + 3 = 123.",
            ),
            output(
                "from functools import partial\ndef powitaj(imie, znak):\n    return \"Cześć \" + imie + znak\nkrzyk = partial(powitaj, znak=\"!\")\nprint(krzyk(\"Ola\"))",
                "Cześć Ola!",
                "partial ustalił znak na „!”.",
            ),
            choice(
                "Które narzędzie z functools składa listę w jedną wartość?",
                listOf("reduce", "partial", "wraps", "lru_cache"),
                0,
                "reduce stosuje funkcję dwuargumentową po kolei do elementów.",
            ),
            choice(
                "Kiedy lru_cache NIE pomoże?",
                listOf("Gdy funkcja za każdym razem dostaje inne argumenty", "Przy rekurencyjnym fib", "Gdy funkcja jest wolna", "Gdy wywołujemy ją wiele razy z tymi samymi danymi"),
                0,
                "Pamięć działa tylko przy powtarzających się argumentach.",
            ),
            tiles(
                "Utwórz funkcję podwoj z ustalonym a=2",
                listOf("podwoj", "=", "partial(", "mnoz,", "a=2", ")"),
                listOf("reduce(", "lambda"),
                "partial(funkcja, argumenty) zwraca nową funkcję.",
            ),
        ),
    ),
)
