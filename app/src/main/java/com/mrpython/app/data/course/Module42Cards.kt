package com.mrpython.app.data.course

internal val module42Cards = listOf(
    cards(
        "u42l1",
        explain(
            "Co zostaje po bloku with",
            "Zmienne utworzone w bloku zostają po nim, ale plik jest już zamknięty – czytanie z niego " +
                "da `ValueError`. `write()` zwraca liczbę zapisanych znaków, a `readlines()` listę linii.",
            code = "with open(\"notatki.txt\", \"w\") as f:\n    n = f.write(\"raz\\ndwa\")\nwith open(\"notatki.txt\") as f:\n    linie = f.readlines()\nprint(n, len(linie), f.closed)",
            output = "7 2 True",
        ),
        explain(
            "with nie łapie wyjątków",
            "Gdy w bloku wystąpi wyjątek, `with` zamknie plik, ale błąd poleci dalej. Złapać go " +
                "trzeba zwykłym `try` / `except`.",
            code = "try:\n    with open(\"notatki.txt\", \"w\") as f:\n        raise ValueError\nexcept ValueError:\n    print(\"błąd\", f.closed)",
            output = "błąd True",
        ),
    ),
    cards(
        "u42l2",
        explain(
            "Parametry __exit__",
            "`t` to typ wyjątku, `w` sam wyjątek (wypisany pokazuje komunikat), a `tb` ślad błędu. " +
                "Gdy blok skończył się bez błędu, wszystkie trzy to `None`.",
            code = "class Blok:\n    def __enter__(self): return self\n    def __exit__(self, t, w, tb):\n        print(t.__name__, w)\n        return True\nwith Blok(): raise ValueError(\"zły\")",
            output = "ValueError zły",
        ),
        explain(
            "Gdy __exit__ nie tłumi",
            "Jeśli `__exit__` zwróci `False` albo nic (`None`), wyjątek leci dalej – ale dopiero po " +
                "wykonaniu `__exit__`. Reszta bloku po błędzie jest pomijana.",
            code = "class Blok:\n    def __enter__(self): return self\n    def __exit__(self, t, w, tb): print(\"exit\")\ntry:\n    with Blok(): 1 / 0\nexcept ZeroDivisionError: print(\"złapany\")",
            output = "exit\nzłapany",
        ),
        explain(
            "__enter__ bez return",
            "Do zmiennej po `as` trafia to, co zwróci `__enter__`. Bez `return` będzie to `None`, " +
                "dlatego zwykle piszemy `return self`.",
            code = "class Brak:\n    def __enter__(self): pass\n    def __exit__(self, t, w, tb): pass\nwith Brak() as x:\n    print(x)",
            output = "None",
        ),
    ),
    cards(
        "u42l3",
        explain(
            "Wartość z yield",
            "Wartość podana przy `yield` trafia do zmiennej po `as`. Menedżer z `@contextmanager` " +
                "może też przyjmować argumenty jak zwykła funkcja.",
            code = "from contextlib import contextmanager\n@contextmanager\ndef blok(n):\n    yield n * 10\nwith blok(3) as x:\n    print(x)",
            output = "30",
        ),
        explain(
            "Błąd w miejscu yield",
            "Wyjątek z bloku pojawia się w funkcji w miejscu `yield`. Bez `try` kod po `yield` się " +
                "nie wykona – dlatego sprzątanie umieszczamy w `finally`.",
            code = "from contextlib import contextmanager\n@contextmanager\ndef blok():\n    try: yield\n    finally: print(\"sprzątam\")\nwith blok(): print(\"praca\")",
            output = "praca\nsprzątam",
        ),
        explain(
            "suppress kilku typów",
            "`suppress` może dostać kilka typów wyjątków naraz. Wyjątek innego typu nie zostanie " +
                "stłumiony i poleci dalej.",
            code = "from contextlib import suppress\nwith suppress(ValueError, TypeError):\n    print(1 + \"a\")\nprint(\"ok\")",
            output = "ok",
        ),
    ),
)
