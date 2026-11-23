package com.mrpython.app.data.course

internal val module73Cards = listOf(
    cards(
        "u73l2",
        explain(
            "Klucze z listy: fromkeys",
            "`dict.fromkeys(lista, wartość)` tworzy słownik z podanymi kluczami. Klucze się nie powtarzają " +
                "i zachowują kolejność, więc `list(dict.fromkeys(t))` usuwa duplikaty bez psucia porządku.",
            code = "print(dict.fromkeys([\"b\", \"a\"], 0))\nprint(list(dict.fromkeys(\"abca\")))",
            output = "{'b': 0, 'a': 0}\n['a', 'b', 'c']",
        ),
    ),
    cards(
        "u73l3",
        explain(
            "Własny iterator",
            "Pętla `for` woła `__iter__` obiektu, a potem `__next__`, aż ten zgłosi `StopIteration`. " +
                "Najprościej napisać `__iter__` jako generator z `yield`.",
            code = "class Odliczanie:\n    def __init__(self, n): self.n = n\n    def __iter__(self):\n        for i in range(self.n, 0, -1):\n            yield i\nprint(list(Odliczanie(4)))",
            output = "[4, 3, 2, 1]",
        ),
        explain(
            "Obiekt jak funkcja",
            "Metoda `__call__` sprawia, że obiekt można wywołać jak funkcję: `obiekt(x)` " +
                "uruchamia `obiekt.__call__(x)`.",
            code = "class Razy:\n    def __init__(self, n): self.n = n\n    def __call__(self, x): return x * self.n\npodwoj = Razy(2)\nprint(podwoj(7))",
            output = "14",
        ),
        explain(
            "yield from",
            "`yield from kolekcja` oddaje po kolei wszystkie jej elementy – to skrót od pętli " +
                "`for x in kolekcja: yield x`.",
            code = "def g():\n    yield from [1, 2]\n    yield 3\nprint(list(g()))",
            output = "[1, 2, 3]",
        ),
    ),
    cards(
        "u73l5",
        explain(
            "Zen Pythona",
            "Polecenie `import this` wypisuje „Zen of Python” – krótkie zasady dobrego kodu, np. " +
                "„Simple is better than complex.” (proste lepsze niż złożone) i „Readability counts.” (czytelność się liczy).",
        ),
    ),
)
