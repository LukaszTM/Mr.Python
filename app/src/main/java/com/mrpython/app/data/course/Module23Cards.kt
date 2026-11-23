package com.mrpython.app.data.course

internal val module23Cards = listOf(
    cards(
        "u23l1",
        explain(
            "Iterator pamięta miejsce",
            "Iterator pamięta, ile już oddał. Po kilku `next()` funkcje `list()` czy `sum()` dostaną tylko " +
                "pozostałe elementy, a przy kolejnym użyciu iterator jest pusty.",
            code = "it = iter([10, 20, 30])\nnext(it)\nprint(sum(it))\nprint(sum(it))",
            output = "50\n0",
        ),
        explain(
            "Napisy, słowniki i for",
            "`iter()` działa na każdej kolekcji: napis daje litery, a słownik – klucze. Pętla `for` sama " +
                "woła `next()` i sama obsługuje `StopIteration`, dlatego go nie widzisz.",
            code = "it = iter(\"abc\")\nprint(next(it))\nprint(next(iter({\"x\": 1, \"y\": 2})))",
            output = "a\nx",
        ),
    ),
    cards(
        "u23l2",
        explain(
            "Start dopiero przy next()",
            "Wywołanie funkcji z `yield` nie uruchamia jej kodu – zwraca obiekt generatora. " +
                "Kod rusza dopiero przy pierwszym `next()` i zatrzymuje się na `yield`.",
            code = "def gen():\n    print(\"start\")\n    yield 1\ng = gen()\nprint(type(g))\nprint(next(g))",
            output = "<class 'generator'>\nstart\n1",
        ),
        explain(
            "Koniec generatora",
            "Generator kończy się, gdy dojdzie do końca funkcji albo do `return`. Wtedy kolejne `next()` " +
                "zgłasza `StopIteration`. `yield` może wystąpić w funkcji wiele razy.",
            code = "def gen():\n    yield 1\n    return\n    yield 2\n\nprint(list(gen()))",
            output = "[1]",
        ),
    ),
    cards(
        "u23l3",
        explain(
            "Filtr i join",
            "W wyrażeniu generatorowym, tak jak w listowym, możesz dopisać `if` na końcu. Generator podasz " +
                "też do `\"\".join()`, `any()` czy `all()` – bez dodatkowych nawiasów.",
            code = "print(sum(x for x in range(7) if x % 2 == 0))\nprint(\"-\".join(str(x) for x in [1, 2, 3]))",
            output = "12\n1-2-3",
        ),
        explain(
            "Liczenie przez sum",
            "Sztuczka: `sum(1 for x in a if warunek)` dodaje 1 za każdy pasujący element, czyli liczy je.",
            code = "a = [3, -1, 5, -2]\nprint(sum(1 for x in a if x < 0))",
            output = "2",
        ),
        explain(
            "Generator bez indeksów",
            "Generator nie przechowuje wartości, więc nie ma `g[0]` ani `len(g)` – to `TypeError`. " +
                "Gdy potrzebujesz indeksów, zamień go na listę: `list(g)`.",
            code = "g = (x * 2 for x in [1, 2, 3])\nprint(list(g)[0])",
            output = "2",
        ),
    ),
    cards(
        "u23l4",
        explain(
            "Zmienna _",
            "Gdy numer obrotu pętli nie jest potrzebny, nazywamy zmienną `_`. Zapis " +
                "`[next(g) for _ in range(3)]` znaczy po prostu: „pobierz 3 razy kolejną wartość”.",
            code = "g = (x * 10 for x in range(100))\nprint([next(g) for _ in range(3)])",
            output = "[0, 10, 20]",
        ),
        explain(
            "Nie bierz wszystkiego",
            "Z nieskończonego generatora nigdy nie rób `list(g)` ani `sum(g)` – program by się nie skończył. " +
                "Pobieraj tyle, ile trzeba: przez `next()` albo pętlę z `break`.",
        ),
    ),
)
