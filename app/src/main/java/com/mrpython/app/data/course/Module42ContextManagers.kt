package com.mrpython.app.data.course

import com.mrpython.app.domain.CourseUnit

internal val module42 = CourseUnit(
    id = "u42",
    title = "Menedżery kontekstu",
    description = "with, __enter__, __exit__ i contextlib",
    lessons = listOf(
        lesson(
            "u42l1", "Instrukcja with",
            output(
                "with open(\"notatki.txt\", \"w\") as f:\n    f.write(\"ala\")\nprint(f.closed)",
                "True",
                "Po wyjściu z bloku with plik jest automatycznie zamknięty.",
            ),
            choice(
                "Co gwarantuje blok with open(...) as f?",
                listOf("Plik zostanie zamknięty nawet po błędzie", "Plik nigdy nie zostanie zamknięty", "Plik będzie pusty", "Plik otworzy się tylko do odczytu"),
                0,
                "Menedżer kontekstu sprząta zawsze – także gdy wystąpi wyjątek.",
            ),
            output(
                "with open(\"notatki.txt\", \"w\") as f:\n    f.write(\"raz\\ndwa\")\nwith open(\"notatki.txt\") as f:\n    print(len(f.readlines()))",
                "2",
                "Plik ma dwie linie, każdy blok with sam zamyka plik.",
            ),
            choice(
                "Który kod jest odpowiednikiem with open(\"a.txt\") as f: ...?",
                listOf("f = open(...), potem try i f.close() w finally", "f = open(...) bez zamykania", "import a.txt", "f = close(open(...))"),
                0,
                "with to krótszy zapis wzorca try / finally.",
            ),
            fill(
                "Uzupełnij słowo kluczowe nadające nazwę otwartemu plikowi.",
                "with open(\"notatki.txt\", \"w\") ____ plik:\n    plik.write(\"x\")\nprint(plik.closed)",
                listOf("as", "in", "is", "to"),
                "as",
                "Po as podajemy nazwę zmiennej w bloku with.",
            ),
            output(
                "with open(\"notatki.txt\", \"w\") as a, open(\"b.txt\", \"w\") as b:\n    a.write(\"1\")\n    b.write(\"2\")\nprint(a.closed and b.closed)",
                "True",
                "W jednym with można otworzyć kilka plików – wszystkie zostaną zamknięte.",
            ),
            tiles(
                "Otwórz plik \"notatki.txt\" do odczytu w bloku with",
                listOf("with", "open(\"notatki.txt\")", "as", "f:"),
                listOf("in", "for"),
                "Schemat: with wyrażenie as nazwa:",
            ),
        ),
        lesson(
            "u42l2", "__enter__ i __exit__",
            output(
                "class Blok:\n    def __enter__(self):\n        print(\"wejście\")\n    def __exit__(self, t, w, tb):\n        print(\"wyjście\")\nwith Blok():\n    print(\"środek\")",
                "wejście\nśrodek\nwyjście",
                "__enter__ działa na początku bloku, __exit__ na końcu.",
            ),
            output(
                "class Licznik:\n    def __enter__(self):\n        return 42\n    def __exit__(self, t, w, tb):\n        pass\nwith Licznik() as x:\n    print(x)",
                "42",
                "Do zmiennej po as trafia wartość zwrócona przez __enter__.",
            ),
            output(
                "class Blok:\n    def __enter__(self):\n        return self\n    def __exit__(self, t, w, tb):\n        print(\"sprzątam\")\ntry:\n    with Blok():\n        1 / 0\nexcept ZeroDivisionError:\n    print(\"błąd\")",
                "sprzątam\nbłąd",
                "__exit__ wykonuje się, zanim wyjątek trafi do except.",
            ),
            output(
                "class Cicho:\n    def __enter__(self):\n        return self\n    def __exit__(self, t, w, tb):\n        return True\nwith Cicho():\n    1 / 0\nprint(\"dalej\")",
                "dalej",
                "Gdy __exit__ zwraca True, wyjątek zostaje stłumiony.",
            ),
            choice(
                "Ile parametrów (oprócz self) ma metoda __exit__?",
                listOf("3: typ, wartość i ślad wyjątku", "0", "1: wyjątek", "2: wejście i wyjście"),
                0,
                "Gdy nie było błędu, wszystkie trzy mają wartość None.",
            ),
            fill(
                "Uzupełnij, aby x w bloku with był obiektem klasy Zasob.",
                "class Zasob:\n    def __enter__(self):\n        return ____\n    def __exit__(self, t, w, tb):\n        pass\nwith Zasob() as x:\n    print(type(x).__name__)",
                listOf("self", "None", "Zasob", "True"),
                "self",
                "__enter__ zwraca self, więc x to sam obiekt.",
            ),
            output(
                "class Blok:\n    def __enter__(self):\n        return self\n    def __exit__(self, t, w, tb):\n        print(t)\nwith Blok():\n    pass",
                "None",
                "Bez wyjątku typ błędu t to None.",
            ),
        ),
        lesson(
            "u42l3", "contextlib",
            output(
                "from contextlib import contextmanager\n@contextmanager\ndef blok():\n    print(\"start\")\n    yield\n    print(\"stop\")\nwith blok():\n    print(\"praca\")",
                "start\npraca\nstop",
                "Kod przed yield działa jak __enter__, a po yield jak __exit__.",
            ),
            output(
                "from contextlib import contextmanager\n@contextmanager\ndef liczba():\n    yield 7\nwith liczba() as n:\n    print(n * 2)",
                "14",
                "Wartość z yield trafia do zmiennej po as.",
            ),
            fill(
                "Uzupełnij, aby funkcja stała się menedżerem kontekstu.",
                "from contextlib import contextmanager\n@____\ndef tag():\n    print(\"<b>\")\n    yield\n    print(\"</b>\")\nwith tag():\n    print(\"tekst\")",
                listOf("contextmanager", "suppress", "wraps", "lru_cache"),
                "contextmanager",
                "@contextmanager zamienia funkcję z yield w menedżer kontekstu.",
            ),
            output(
                "from contextlib import suppress\nwith suppress(ZeroDivisionError):\n    print(\"A\")\n    1 / 0\n    print(\"B\")\nprint(\"C\")",
                "A\nC",
                "suppress tłumi podany wyjątek – reszta bloku jest pomijana.",
            ),
            choice(
                "Co zrobi ten kod?",
                listOf("Zgłosi KeyError – suppress tłumi tylko ValueError", "Nic nie wypisze", "Wypisze None", "Stłumi błąd"),
                0,
                "suppress tłumi tylko wymienione typy wyjątków.",
                code = "from contextlib import suppress\nd = {}\nwith suppress(ValueError):\n    print(d[\"x\"])",
            ),
            output(
                "from contextlib import suppress\nliczby = [1, 2]\nwith suppress(IndexError):\n    print(liczby[5])\nprint(\"koniec\")",
                "koniec",
                "IndexError został stłumiony, program działa dalej.",
            ),
            tiles(
                "Zignoruj błąd KeyError w bloku with",
                listOf("with", "suppress(", "KeyError", "):"),
                listOf("except", "as"),
                "suppress(Typ) tłumi wyjątki tego typu.",
            ),
            choice(
                "Któremu kodowi odpowiada with suppress(ValueError): ...?",
                listOf("try: ... except ValueError: pass", "try: ... finally: pass", "if ValueError: ...", "raise ValueError"),
                0,
                "suppress to skrót dla pustego except.",
            ),
        ),
        lesson(
            "u42l4", "Powtórka: menedżery kontekstu",
            output(
                "class A:\n    def __enter__(self):\n        print(1)\n        return self\n    def __exit__(self, t, w, tb):\n        print(3)\nwith A():\n    print(2)",
                "1\n2\n3",
                "Kolejność: __enter__, ciało bloku, __exit__.",
            ),
            output(
                "from contextlib import contextmanager\n@contextmanager\ndef nawias():\n    print(\"(\", end=\"\")\n    yield\n    print(\")\")\nwith nawias():\n    print(\"x\", end=\"\")",
                "(x)",
                "Kod przed yield i po yield otacza ciało bloku.",
            ),
            output(
                "from contextlib import suppress\nfor s in [\"1\", \"a\", \"3\"]:\n    with suppress(ValueError):\n        print(int(s))",
                "1\n3",
                "Błędny napis „a” został pominięty.",
            ),
            choice(
                "Kiedy wykona się __exit__?",
                listOf("Zawsze przy wyjściu z bloku with", "Tylko gdy nie było błędu", "Tylko gdy był błąd", "Nigdy, trzeba ją wywołać ręcznie"),
                0,
                "__exit__ działa zawsze – po to są menedżery kontekstu.",
            ),
            fill(
                "Uzupełnij, aby oddzielić część „wejścia” od części „wyjścia”.",
                "from contextlib import contextmanager\n@contextmanager\ndef czas():\n    print(\"start\")\n    ____\n    print(\"koniec\")\nwith czas():\n    print(\"zadanie\")",
                listOf("yield", "return", "pass", "break"),
                "yield",
                "W menedżerze z contextmanager musi być dokładnie jedno yield.",
            ),
            output(
                "class Wartosc:\n    def __enter__(self):\n        return [1, 2, 3]\n    def __exit__(self, t, w, tb):\n        pass\nwith Wartosc() as lista:\n    print(sum(lista))",
                "6",
                "lista to wynik __enter__.",
            ),
            tiles(
                "Zaimportuj contextmanager",
                listOf("from", "contextlib", "import", "contextmanager"),
                listOf("functools", "with"),
                "contextmanager jest w module contextlib.",
            ),
        ),
    ),
)
