package com.mrpython.app.data.course

internal val module10Cards = listOf(
    cards(
        "u10l1",
        explain(
            "SyntaxError – błąd zapisu",
            "Błąd składni to źle zapisany kod, np. brak dwukropka po `if` albo niezamknięty nawias. " +
                "Python wykrywa go, zanim uruchomi program, więc nie wykona się ani jedna linia.",
        ),
        explain(
            "NameError – nieznana nazwa",
            "`NameError` pojawia się, gdy używasz nazwy, której Python nie zna: zmiennej, której nie " +
                "utworzono, albo funkcji z literówką, np. `pirnt(\"hej\")`.",
        ),
        explain(
            "TypeError czy ValueError?",
            "`TypeError` to zły typ, np. `\"a\" + 1`, `len(5)` (liczba nie ma długości) albo napis jako indeks " +
                "listy. `ValueError` to dobry typ, ale zła wartość: `int(\"3.5\")` czy `int(\"\")` – `int()` " +
                "zamieni tylko napis z liczbą całkowitą.",
        ),
    ),
    cards(
        "u10l2",
        explain(
            "Samo except:",
            "`except:` bez nazwy błędu przechwytuje każdy błąd. Gdy podasz nazwę, np. `except ValueError:`, " +
                "inne rodzaje błędów nie zostaną złapane i zatrzymają program.",
            code = "try:\n    print(1 / 0)\nexcept:\n    print(\"jakiś błąd\")",
            output = "jakiś błąd",
        ),
        explain(
            "Kilka bloków except",
            "Po jednym `try` może stać kilka `except`. Python wybiera ten, który pasuje do rodzaju błędu, " +
                "i wykonuje tylko jego.",
            code = "try:\n    \"a\" + 1\nexcept ValueError:\n    print(\"V\")\nexcept TypeError:\n    print(\"T\")",
            output = "T",
        ),
    ),
    cards(
        "u10l3",
        explain(
            "Kilka błędów w jednym except",
            "W nawiasie po `except` możesz wymienić kilka rodzajów błędów, np. `except (ValueError, TypeError):` " +
                "– taki blok złapie każdy z nich.",
            code = "try:\n    [1][5]\nexcept (IndexError, KeyError):\n    print(\"brak\")",
            output = "brak",
        ),
        explain(
            "finally bez except",
            "`try` może mieć samo `finally`, bez `except`. `finally` wykona się nawet wtedy, gdy funkcja " +
                "kończy się przez `return` – tuż przed wyjściem z niej.",
            code = "def f():\n    try:\n        return 1\n    finally:\n        print(\"sprzątam\")\nprint(f())",
            output = "sprzątam\n1",
        ),
        explain(
            "raise w funkcji",
            "Błąd zgłoszony przez `raise` w funkcji „wylatuje” do miejsca, gdzie ją wywołano. Tam można " +
                "go przechwycić, otaczając wywołanie blokiem `try`.",
            code = "def f(x):\n    if x < 0: raise ValueError(\"ujemna\")\ntry:\n    f(-1)\nexcept ValueError as e:\n    print(e)",
            output = "ujemna",
        ),
    ),
    cards(
        "u10l4",
        explain(
            "Kolejność bloków",
            "Bloki zapisujemy zawsze w tej kolejności: `try`, `except`, `else`, a na końcu `finally`. " +
                "Gdy nie ma błędu, wykonają się `try`, `else` i `finally`.",
            code = "try: x = 1\nexcept: print(\"błąd\")\nelse: print(\"ok\")\nfinally: print(\"koniec\")",
            output = "ok\nkoniec",
        ),
    ),
)
