package com.mrpython.app.data.course

internal val module52Intro = lesson(
    "u52l0", "Wprowadzenie: testowanie",
    explain(
        "Instrukcja assert",
        "`assert warunek` sprawdza, czy warunek jest prawdziwy. Jeśli tak – nic się nie dzieje, " +
            "a jeśli nie – Python zgłasza `AssertionError`. Po przecinku można dodać komunikat. " +
            "Nie bierz całości w nawiasy!",
        code = "assert 2 + 2 == 4\ntry:\n    assert 1 > 2, \"błąd!\"\nexcept AssertionError as e:\n    print(e)",
        output = "błąd!",
    ),
    explain(
        "Funkcje testujące",
        "Test to kod, który sprawdza inny kod. Testy zamykamy w funkcjach o nazwach zaczynających się " +
            "od `test_`: wywołują one kod z konkretnymi danymi i porównują wynik z oczekiwanym.",
        code = "def test_maks():\n    assert max([3, 7]) == 7\n    assert max([-5, -2]) == -2\n    print(\"test OK\")\n\ntest_maks()",
        output = "test OK",
    ),
    explain(
        "Przypadki brzegowe",
        "Najwięcej błędów kryje się w skrajnych danych: pusta lista, zero, liczby ujemne. " +
            "Dobry test sprawdza nie tylko zwykły przykład, ale też takie przypadki.",
        code = "def srednia(x):\n    if not x:\n        return 0\n    return sum(x) / len(x)\n\nprint(srednia([2, 4]), srednia([]))",
        output = "3.0 0",
    ),
    explain(
        "Moduł unittest",
        "W większych projektach używa się modułu `unittest`. Testy to metody klasy dziedziczącej po " +
            "`unittest.TestCase`, ich nazwy zaczynają się od `test`, a wynik sprawdzamy np. przez " +
            "`self.assertEqual(a, b)`.",
        code = "import unittest\n\nclass TestMatma(unittest.TestCase):\n    def test_dodawanie(self):\n        self.assertEqual(2 + 2, 4)",
    ),
    explain(
        "Więcej asercji",
        "`TestCase` ma też `assertTrue`, `assertIn` i `assertRaises` (sprawdza, czy kod zgłasza błąd). " +
            "Gdy coś się nie zgadza, dostajesz czytelny opis różnicy.",
        code = "import unittest\n\nt = unittest.TestCase()\ntry:\n    t.assertEqual(2 * 3, 5)\nexcept AssertionError as e:\n    print(e)",
        output = "6 != 5",
    ),
    output(
        "assert 3 * 3 == 9\nprint(\"dalej\")",
        "dalej",
        "Warunek jest prawdziwy, więc program działa dalej.",
    ),
    choice(
        "Który przypadek brzegowy warto przetestować dla funkcji zwracającej pierwszy element listy?",
        listOf("Pusta lista", "Lista [1, 2, 3]", "Lista [4, 5, 6]"),
        0,
        "Pusta lista nie ma pierwszego elementu – to skrajny przypadek.",
    ),
    tiles(
        "Sprawdź, że długość napisu \"abc\" wynosi 3.",
        listOf("assert", "len(\"abc\")", "==", "3"),
        listOf("=", "if"),
        "assert z porównaniem == sprawdza oczekiwany wynik.",
    ),
)
