package com.mrpython.app.data.course

internal val module52Cards = listOf(
    cards(
        "u52l1",
        explain(
            "assert i prawdziwość",
            "`assert` przyjmuje dowolną wartość, nie tylko porównanie. Pusta lista, 0 i pusty napis są " +
                "fałszywe, więc `assert lista` zawiedzie dla pustej listy. Bez komunikatu wyjątek ma pusty opis.",
            code = "try:\n    assert [], \"pusta lista\"\nexcept AssertionError as e:\n    print(e)",
            output = "pusta lista",
        ),
        explain(
            "Pułapka z nawiasami",
            "`assert(x > 0, \"tekst\")` to assert na krotce z dwóch elementów. Niepusta krotka jest zawsze " +
                "prawdziwa, więc taki test nigdy nie zawiedzie. Pisz bez nawiasów: `assert x > 0, \"tekst\"`.",
            code = "x = -5\nprint(bool((x > 0, \"ujemne\")))",
            output = "True",
        ),
    ),
    cards(
        "u52l2",
        explain(
            "Tabela przypadków",
            "Zamiast pisać wiele podobnych asercji, zapisz przypadki jako listę krotek (dane, oczekiwany " +
                "wynik) i sprawdź je w pętli. Dodanie nowego testu to jeden nowy wpis.",
            code = "przypadki = [(2, 4), (3, 9), (0, 0)]\nfor n, ok in przypadki:\n    assert n * n == ok\nprint(\"wszystkie OK\")",
            output = "wszystkie OK",
        ),
        explain(
            "Liczenie udanych testów",
            "`True` liczy się jak 1, a `False` jak 0. Dlatego `sum()` z listy wyników porównań mówi, " +
                "ile testów przeszło, a `all()` – czy przeszły wszystkie.",
            code = "testy = [1 + 1 == 2, 2 * 2 == 5, 9 // 3 == 3]\nprint(sum(testy), all(testy))",
            output = "2 False",
        ),
    ),
    cards(
        "u52l3",
        explain(
            "Testuj granice",
            "Błędy często siedzą na granicy warunku: `>` zamiast `>=`. Jeśli próg zdania to 50 punktów, " +
                "sprawdź dokładnie 50, a nie tylko 30 i 80.",
            code = "def zdane(p):\n    return p > 50\n\nprint(zdane(80), zdane(50))",
            output = "True False",
        ),
        explain(
            "Zapomniany przypadek",
            "Gdy żadna gałąź `if` nie zadziała, a na końcu funkcji nie ma `return`, funkcja zwraca `None`. " +
                "Test z wartością 0 albo pustą listą szybko to wykryje.",
            code = "def znak(n):\n    if n > 0:\n        return \"+\"\n    elif n < 0:\n        return \"-\"\nprint(znak(0))",
            output = "None",
        ),
    ),
    cards(
        "u52l4",
        explain(
            "assertRaises z with",
            "`with self.assertRaises(Błąd):` sprawdza, czy kod w bloku zgłasza ten wyjątek. Jeśli wyjątek " +
                "się pojawi – test przechodzi; jeśli nie – test zawodzi z `AssertionError`.",
            code = "import unittest\nt = unittest.TestCase()\nwith t.assertRaises(ZeroDivisionError):\n    1 / 0\nprint(\"błąd złapany\")",
            output = "błąd złapany",
        ),
        explain(
            "Jeszcze dwie asercje",
            "`assertFalse(x)` sprawdza, czy wartość jest fałszywa, a `assertNotEqual(a, b)` – czy " +
                "wartości są różne. Każda metoda testu w klasie ma pierwszy parametr `self`.",
            code = "import unittest\nt = unittest.TestCase()\nt.assertFalse(2 > 5)\nt.assertNotEqual(2 + 2, 5)\nprint(\"OK\")",
            output = "OK",
        ),
        explain(
            "Uruchamianie testów z kodu",
            "`TestLoader` zbiera z klasy metody o nazwach zaczynających się od `test`, a `run(w)` zapisuje " +
                "wyniki w `TestResult`: `testsRun` to liczba testów, `failures` – lista porażek, " +
                "a `wasSuccessful()` mówi, czy wszystko przeszło.",
            code = "import unittest\nclass T(unittest.TestCase):\n    def test_a(self): self.assertEqual(1, 2)\nw =unittest.TestResult()\nunittest.TestLoader().loadTestsFromTestCase(T).run(w)\nprint(w.testsRun, len(w.failures), w.wasSuccessful())",
            output = "1 1 False",
        ),
    ),
    cards(
        "u52l5",
        explain(
            "TDD: najpierw test",
            "W TDD (test-driven development) najpierw piszesz test, który nie przechodzi (czerwony), potem " +
                "najprostszy kod, który go spełnia (zielony), a na końcu porządkujesz kod (refaktoryzacja), " +
                "pilnując, by testy dalej przechodziły.",
            code = "def odwroc(s):\n    return s[::-1]\n\nassert odwroc(\"abc\") == \"cba\"\nprint(\"zielono\")",
            output = "zielono",
        ),
    ),
)
