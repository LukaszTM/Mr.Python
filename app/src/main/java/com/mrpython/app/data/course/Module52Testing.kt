package com.mrpython.app.data.course

import com.mrpython.app.domain.CourseUnit

internal val module52 = CourseUnit(
    id = "u52",
    title = "Testowanie",
    description = "assert, funkcje testujące, przypadki brzegowe i unittest",
    lessons = listOf(
        lesson(
            "u52l1", "assert i AssertionError",
            output(
                "assert 2 + 2 == 4\nprint(\"OK\")",
                "OK",
                "Warunek jest prawdziwy, więc assert nic nie robi i program idzie dalej.",
            ),
            choice(
                "Co się stanie, gdy warunek w assert jest fałszywy?",
                listOf("Zostanie zgłoszony AssertionError", "Wypisze się False", "Nic, program działa dalej", "Funkcja zwróci None"),
                0,
                "Fałszywy warunek w assert zgłasza wyjątek AssertionError.",
            ),
            output(
                "try:\n    assert 1 > 2, \"błąd!\"\nexcept AssertionError as e:\n    print(e)",
                "błąd!",
                "Tekst po przecinku staje się komunikatem wyjątku.",
            ),
            fill(
                "Uzupełnij słowo kluczowe, które sprawdza warunek.",
                "____ len(\"abc\") == 3\nprint(\"długość OK\")",
                listOf("assert", "check", "test"),
                "assert",
                "Do sprawdzania warunków w kodzie służy assert.",
            ),
            output(
                "lista = []\ntry:\n    assert lista, \"pusta lista\"\nexcept AssertionError as e:\n    print(e)",
                "pusta lista",
                "Pusta lista jest fałszywa, więc assert zgłasza błąd.",
            ),
            tiles(
                "Sprawdź, że wynik to 10, z komunikatem \"zły wynik\".",
                listOf("assert", "wynik == 10", ",", "\"zły wynik\""),
                listOf("if", ":"),
                "Składnia to: assert warunek, komunikat.",
            ),
            choice(
                "Dlaczego ten assert nigdy nie zgłosi błędu?",
                listOf("Nawiasy tworzą krotkę, a niepusta krotka jest zawsze prawdziwa", "Bo x jest ujemne", "Bo komunikat jest napisem", "Bo assert działa tylko w funkcjach"),
                0,
                "assert (warunek, tekst) sprawdza krotkę – nie stawiaj nawiasów po assert.",
                code = "x = -5\nassert(x > 0, \"ujemne\")\nprint(\"przeszło\")",
            ),
            output(
                "def podwoj(x):\n    return x * 2\n\nassert podwoj(3) == 6\nassert podwoj(0) == 0\nprint(\"testy OK\")",
                "testy OK",
                "Oba warunki są prawdziwe, więc program dochodzi do print.",
            ),
        ),
        lesson(
            "u52l2", "Funkcje testujące",
            output(
                "def dodaj(a, b):\n    return a + b\n\ndef test_dodaj():\n    assert dodaj(2, 3) == 5\n    print(\"test_dodaj OK\")\n\ntest_dodaj()",
                "test_dodaj OK",
                "Funkcja testująca wywołuje kod i sprawdza wynik przez assert.",
            ),
            choice(
                "Jak zwyczajowo nazywa się funkcje testujące?",
                listOf("Zaczynają się od test_", "Kończą się na _ok", "Zaczynają się od check", "Dowolnie, wielkimi literami"),
                0,
                "Narzędzia do testów szukają funkcji o nazwach zaczynających się od test.",
            ),
            output(
                "def kwadrat(x):\n    return x * 2\n\ntry:\n    assert kwadrat(2) == 4\n    assert kwadrat(3) == 9\n    print(\"OK\")\nexcept AssertionError:\n    print(\"BŁĄD\")",
                "BŁĄD",
                "Dla 2 wynik przypadkiem się zgadza, ale kwadrat(3) daje 6 – drugi test wykrywa błąd.",
            ),
            fill(
                "Uzupełnij test, aby zgłaszał błąd, gdy wynik jest zły.",
                "def test_maks():\n    ____ max([3, 7, 1]) == 7\n\ntest_maks()\nprint(\"OK\")",
                listOf("assert", "assume", "verify"),
                "assert",
                "assert zgłasza AssertionError, gdy warunek jest fałszywy.",
            ),
            output(
                "def parzysta(n):\n    return n % 2 == 0\n\nprzypadki = [(2, True), (3, False), (0, True)]\nfor n, ok in przypadki:\n    assert parzysta(n) == ok\nprint(\"wszystkie OK\")",
                "wszystkie OK",
                "Lista par (dane, oczekiwany wynik) pozwala sprawdzić wiele przypadków w pętli.",
            ),
            tiles(
                "Sprawdź, że długość napisu \"kot\" to 3.",
                listOf("assert", "len(\"kot\")", "==", "3"),
                listOf("=", "return"),
                "assert z porównaniem == sprawdza oczekiwany wynik.",
            ),
            output(
                "testy = [1 + 1 == 2, 3 * 3 == 6, 10 // 3 == 3]\nprint(sum(testy), \"/\", len(testy))",
                "2 / 3",
                "True liczy się jako 1 – przeszły dwa z trzech testów.",
            ),
            choice(
                "Co powinien zawierać dobry test?",
                listOf("Konkretne dane i znany oczekiwany wynik", "Losowe dane bez sprawdzania", "Tylko wywołanie funkcji", "Wypisanie wyniku na ekran"),
                0,
                "Test porównuje wynik z wartością, którą znamy z góry.",
            ),
        ),
        lesson(
            "u52l3", "Przypadki brzegowe",
            choice(
                "Który przypadek jest brzegowy dla funkcji liczącej średnią z listy?",
                listOf("Pusta lista", "Lista [1, 2, 3]", "Lista [5, 5]", "Lista [10, 20]"),
                0,
                "Przypadki brzegowe to skrajne dane, np. pusta lista, zero czy liczby ujemne.",
            ),
            output(
                "def srednia(liczby):\n    return sum(liczby) / len(liczby)\n\ntry:\n    print(srednia([]))\nexcept ZeroDivisionError:\n    print(\"pusta lista!\")",
                "pusta lista!",
                "len([]) to 0, więc dzielimy przez zero.",
            ),
            fill(
                "Uzupełnij warunek, aby funkcja obsłużyła pustą listę.",
                "def srednia(liczby):\n    if ____:\n        return 0\n    return sum(liczby) / len(liczby)\n\nprint(srednia([]))",
                listOf("not liczby", "liczby", "len(liczby) > 0"),
                "not liczby",
                "not liczby jest prawdziwe dla pustej listy.",
            ),
            output(
                "def maks(lista):\n    wynik = 0\n    for x in lista:\n        if x > wynik:\n            wynik = x\n    return wynik\n\nprint(maks([3, 5]))\nprint(maks([-3, -5]))",
                "5\n0",
                "Start od 0 psuje wynik dla samych liczb ujemnych – test z ujemnymi to wykrywa.",
            ),
            choice(
                "Jak poprawić funkcję maks z poprzedniego zadania?",
                listOf("Zacząć od wynik = lista[0]", "Zacząć od wynik = 1", "Zamienić > na <", "Usunąć return"),
                0,
                "Pierwszy element listy jest dobrym punktem startowym.",
            ),
            output(
                "def znak(n):\n    if n > 0:\n        return \"+\"\n    elif n < 0:\n        return \"-\"\n\nprint(znak(5), znak(-2), znak(0))",
                "+ - None",
                "Zapomniano o zerze – funkcja nic nie zwraca, więc wynik to None.",
            ),
            tiles(
                "Napisz test: silnia z zera ma wynosić 1.",
                listOf("assert", "silnia(0)", "==", "1"),
                listOf("=", "return"),
                "Zero to klasyczny przypadek brzegowy dla silni.",
            ),
            choice(
                "Które dane najlepiej przetestować dla funkcji dziel(a, b)?",
                listOf("b = 0, liczby ujemne i zwykłe liczby", "Tylko 10 i 2", "Tylko duże liczby", "Wystarczy jeden dowolny przykład"),
                0,
                "Dobre testy obejmują zwykłe przypadki i brzegowe.",
            ),
        ),
        lesson(
            "u52l4", "unittest – podstawy",
            choice(
                "Z jakiej klasy dziedziczy klasa testów w module unittest?",
                listOf("unittest.TestCase", "unittest.Test", "object.Test", "unittest.Assert"),
                0,
                "Testy w unittest to metody klasy dziedziczącej po TestCase.",
            ),
            fill(
                "Uzupełnij nazwę klasy bazowej.",
                "import unittest\n\nclass TestMatma(unittest.____):\n    def test_dodawanie(self):\n        self.assertEqual(2 + 2, 4)\n\nprint(\"zdefiniowano\")",
                listOf("TestCase", "Testy", "Case"),
                "TestCase",
                "Klasa testowa dziedziczy po unittest.TestCase.",
            ),
            choice(
                "Jak musi zaczynać się nazwa metody, którą unittest uzna za test?",
                listOf("test", "check", "self", "run"),
                0,
                "unittest uruchamia metody, których nazwa zaczyna się od test.",
            ),
            tiles(
                "Sprawdź w metodzie testu, że dodaj(2, 2) daje 4.",
                listOf("self.assertEqual(", "dodaj(2, 2)", ",", "4", ")"),
                listOf("assertTrue(", "="),
                "assertEqual(a, b) sprawdza, czy a == b.",
            ),
            output(
                "import unittest\n\nt = unittest.TestCase()\ntry:\n    t.assertEqual(1 + 1, 3)\nexcept AssertionError as e:\n    print(e)",
                "2 != 3",
                "assertEqual przy niezgodności zgłasza AssertionError z czytelnym opisem.",
            ),
            output(
                "import unittest\n\nt = unittest.TestCase()\nt.assertTrue(5 > 3)\nt.assertIn(\"o\", \"kot i pies\")\nprint(\"przeszło\")",
                "przeszło",
                "Oba sprawdzenia są spełnione, więc nie ma wyjątku.",
            ),
            choice(
                "Która metoda TestCase sprawdza, czy kod zgłasza wyjątek?",
                listOf("assertRaises", "assertError", "assertFalse", "assertException"),
                0,
                "with self.assertRaises(Błąd): sprawdza, czy błąd wystąpi.",
            ),
            output(
                "import unittest\n\nclass T(unittest.TestCase):\n    def test_ok(self):\n        self.assertEqual(len(\"ab\"), 2)\n    def test_zle(self):\n        self.assertIn(\"x\", \"abc\")\n\nw = unittest.TestResult()\nunittest.TestLoader().loadTestsFromTestCase(T).run(w)\nprint(w.testsRun, len(w.failures))",
                "2 1",
                "Uruchomiono 2 testy, a jeden nie przeszedł (w \"abc\" nie ma \"x\").",
            ),
        ),
        lesson(
            "u52l5", "Powtórka: myślenie testami",
            choice(
                "Od czego zaczynasz, pracując metodą TDD (test-driven development)?",
                listOf("Od napisania testu, który na razie nie przechodzi", "Od napisania całej funkcji", "Od wypisania wyników", "Od usunięcia starych testów"),
                0,
                "W TDD najpierw powstaje test, a dopiero potem kod, który go spełnia.",
            ),
            choice(
                "Jaka jest kolejność kroków w TDD?",
                listOf("Czerwony → zielony → refaktoryzacja", "Zielony → czerwony → refaktoryzacja", "Refaktoryzacja → czerwony → zielony", "Kod → wdrożenie → test"),
                0,
                "Test nie przechodzi (czerwony), piszesz kod (zielony), potem go porządkujesz.",
            ),
            output(
                "def odwroc(s):\n    return s[::-1]\n\nassert odwroc(\"abc\") == \"cba\"\nassert odwroc(\"\") == \"\"\nprint(\"zielono\")",
                "zielono",
                "Funkcja spełnia oba testy, także dla pustego napisu.",
            ),
            fill(
                "Uzupełnij nazwę metody, która porównuje dwie wartości.",
                "import unittest\n\nt = unittest.TestCase()\nt.____(2 * 2, 4)\nprint(\"OK\")",
                listOf("assertEqual", "assertEquals", "assertSame"),
                "assertEqual",
                "Do porównania wartości służy assertEqual.",
            ),
            output(
                "wiek = -3\ntry:\n    assert wiek >= 0, \"wiek < 0\"\nexcept AssertionError as e:\n    print(\"Test:\", e)",
                "Test: wiek < 0",
                "Warunek jest fałszywy, więc łapiemy AssertionError z komunikatem.",
            ),
            tiles(
                "Napisz test: suma pustej listy ma wynosić 0.",
                listOf("assert", "suma([])", "==", "0"),
                listOf("return", "!="),
                "Pusta lista to ważny przypadek brzegowy.",
            ),
            output(
                "def pierwsza(lista):\n    if not lista:\n        return None\n    return lista[0]\n\nprint(pierwsza([7, 8]), pierwsza([]))",
                "7 None",
                "Funkcja obsługuje pustą listę zamiast zgłaszać IndexError.",
            ),
            choice(
                "Który assert zgłosi błąd?",
                listOf("Drugi: len([]) == 1", "Pierwszy: upper()", "Żaden", "Oba"),
                0,
                "\"abc\".upper() to \"ABC\", ale długość pustej listy to 0, nie 1.",
                code = "assert \"abc\".upper() == \"ABC\"\nassert len([]) == 1\nprint(\"koniec\")",
            ),
        ),
    ),
)
