package com.mrpython.app.data.course

internal val module41Cards = listOf(
    cards(
        "u41l1",
        explain(
            "Funkcje w liście i słowniku",
            "Funkcje można trzymać w liście albo słowniku jak inne wartości. `ops[\"-\"]` pobiera " +
                "funkcję, a dopiero nawiasy `(9, 4)` ją wywołują.",
            code = "def plus(a, b):\n    return a + b\ndef minus(a, b):\n    return a - b\nops = {\"+\": plus, \"-\": minus}\nprint(ops[\"-\"](9, 4))",
            output = "5",
        ),
        explain(
            "Nazwa i wydruk funkcji",
            "Każda funkcja zna swoją nazwę w `__name__`. `print(f)` bez nawiasów nie wywołuje " +
                "funkcji, tylko pokazuje opis w rodzaju `<function f at 0x...>`. Metoda też jest " +
                "funkcją, np. `str.upper`.",
            code = "f = len\nprint(f(\"abc\"), f.__name__)\nprint(str.upper(\"a\"))",
            output = "3 len\nA",
        ),
        explain(
            "Funkcja z fabryki",
            "Funkcja wewnętrzna pamięta argumenty funkcji, która ją utworzyła. Każde wywołanie " +
                "fabryki daje nową funkcję z własną wartością.",
            code = "def mnoznik(n):\n    def razy(x):\n        return x * n\n    return razy\npotroj = mnoznik(3)\nprint(potroj(5), mnoznik(2)(8))",
            output = "15 16",
        ),
    ),
    cards(
        "u41l2",
        explain(
            "Kiedy działa dekorator?",
            "Kod samego dekoratora wykonuje się raz – w chwili dekorowania. Wrapper działa przy " +
                "każdym wywołaniu funkcji. Bez wywołania nic się nie wypisze.",
            code = "def ozdob(f):\n    print(\"dekoruję\")\n    def w(): print(\"wywołanie\")\n    return w\ndef a(): pass\na = ozdob(a); a(); a()",
            output = "dekoruję\nwywołanie\nwywołanie",
        ),
    ),
    cards(
        "u41l3",
        explain(
            "Przekazywanie argumentów",
            "Wrapper zastępuje oryginał, więc musi przyjąć te same argumenty – inaczej będzie " +
                "`TypeError`. `*args, **kwargs` zbiera wszystkie, a `f(*args, **kwargs)` przekazuje je dalej.",
            code = "def log(f):\n    def w(*args, **kwargs):\n        print(args, kwargs)\n        return f(*args, **kwargs)\n    return w\nprint(log(round)(3.14159, ndigits=2))",
            output = "(3.14159,) {'ndigits': 2}\n3.14",
        ),
        explain(
            "Atrybuty funkcji",
            "Funkcja to obiekt, więc można jej dopisać własny atrybut, np. licznik wywołań. " +
                "Ustawiamy go raz, a wrapper zwiększa go przy każdym wywołaniu.",
            code = "def f():\n    f.ile += 1\nf.ile = 0\nf()\nf()\nprint(f.ile)",
            output = "2",
        ),
    ),
    cards(
        "u41l4",
        explain(
            "Kolejność działania",
            "Przy `@fabryka(1)` najpierw działa fabryka, potem zwrócony dekorator, a sama funkcja " +
                "dopiero przy wywołaniu. Przy kilku dekoratorach pierwszy działa ten najbliżej `def`.",
            code = "def a(f): print(\"a\"); return f\ndef b(f): print(\"b\"); return f\n@a\n@b\ndef x(): pass",
            output = "b\na",
        ),
    ),
)
