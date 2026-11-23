package com.mrpython.app.data.course

internal val module42Intro = lesson(
    "u42l0", "Wprowadzenie: menedżery kontekstu",
    explain(
        "Instrukcja with",
        "Instrukcja `with` otwiera zasób, np. plik, i sama go „sprząta”, gdy blok się kończy. " +
            "Nazwę zasobu podajemy po `as`. Po wyjściu z bloku plik jest już zamknięty.",
        code = "with open(\"notatki.txt\", \"w\") as f:\n    f.write(\"ala\")\nprint(f.closed)",
        output = "True",
    ),
    explain(
        "Sprzątanie nawet po błędzie",
        "`with` to krótszy zapis wzorca `try` / `finally`: plik zostanie zamknięty nawet wtedy, " +
            "gdy w bloku wystąpi wyjątek. W jednym `with` możesz otworzyć kilka plików, " +
            "oddzielając je przecinkiem.",
        code = "f = open(\"notatki.txt\", \"w\")\ntry:\n    f.write(\"ala\")\nfinally:\n    f.close()\nprint(f.closed)",
        output = "True",
    ),
    explain(
        "__enter__ i __exit__",
        "Własny menedżer kontekstu to klasa z dwiema metodami. `__enter__` działa na początku " +
            "bloku, a to, co zwróci, trafia do zmiennej po `as`. `__exit__` działa zawsze na końcu " +
            "i dostaje 3 parametry opisujące ewentualny wyjątek.",
        code = "class Blok:\n    def __enter__(self):\n        return \"dane\"\n    def __exit__(self, t, w, tb):\n        print(\"koniec\")\nwith Blok() as x:\n    print(x)",
        output = "dane\nkoniec",
    ),
    explain(
        "Tłumienie wyjątków",
        "Gdy `__exit__` zwróci `True`, wyjątek z bloku zostaje stłumiony. Prościej zrobisz to " +
            "przez `suppress(Typ)` z modułu `contextlib` – działa jak `except Typ: pass`, a reszta " +
            "bloku jest pomijana.",
        code = "from contextlib import suppress\nwith suppress(ZeroDivisionError):\n    print(\"A\")\n    1 / 0\n    print(\"B\")\nprint(\"C\")",
        output = "A\nC",
    ),
    explain(
        "@contextmanager",
        "Dekorator `@contextmanager` z `contextlib` zamienia funkcję z jednym `yield` w menedżer " +
            "kontekstu. Kod przed `yield` działa jak `__enter__`, a kod po nim jak `__exit__`.",
        code = "from contextlib import contextmanager\n@contextmanager\ndef blok():\n    print(\"start\")\n    yield\n    print(\"stop\")",
    ),
    choice(
        "Kiedy wykonuje się metoda __exit__?",
        listOf("Zawsze przy wyjściu z bloku with", "Tylko gdy nie było błędu", "Tylko gdy był błąd", "Nigdy sama z siebie"),
        0,
        "Menedżer kontekstu sprząta zawsze, także po wyjątku.",
    ),
    output(
        "from contextlib import suppress\nwith suppress(ValueError):\n    print(int(\"x\"))\nprint(\"dalej\")",
        "dalej",
        "suppress stłumił ValueError, program działa dalej.",
    ),
    fill(
        "Uzupełnij słowo, po którym podajemy nazwę otwartego pliku.",
        "with open(\"notatki.txt\", \"w\") ____ plik:\n    plik.write(\"x\")",
        listOf("as", "in", "is", "to"),
        "as",
        "Schemat to: with wyrażenie as nazwa:",
    ),
)
