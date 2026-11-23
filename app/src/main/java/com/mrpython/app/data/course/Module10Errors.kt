package com.mrpython.app.data.course

import com.mrpython.app.domain.CourseUnit

internal val module10 = CourseUnit(
    id = "u10",
    title = "Obsługa błędów",
    description = "try, except i rodzaje wyjątków",
    lessons = listOf(
        lesson(
            "u10l1", "Rodzaje błędów",
            choice(
                "Jaki błąd wywoła int(\"abc\")?",
                listOf("ValueError", "TypeError", "NameError", "KeyError"),
                0,
                "Napisu „abc” nie da się zamienić na liczbę – to ValueError.",
            ),
            choice(
                "Jaki błąd wywoła 1 / 0?",
                listOf("ZeroDivisionError", "ValueError", "MathError", "Żaden – wynik to 0"),
                0,
                "Dzielenie przez zero to ZeroDivisionError.",
            ),
            choice(
                "Jaki błąd wywoła użycie zmiennej, której nie utworzono?",
                listOf("NameError", "ValueError", "IndexError", "SyntaxError"),
                0,
                "Nieznana nazwa to NameError.",
            ),
            choice(
                "Jaki błąd wywoła \"a\" + 1?",
                listOf("TypeError", "ValueError", "NameError", "Żaden"),
                0,
                "Nie można dodać napisu i liczby – to błąd typu.",
            ),
            choice(
                "Jaki błąd wywoła [1, 2][5]?",
                listOf("IndexError", "KeyError", "ValueError", "Żaden"),
                0,
                "Indeks poza zakresem listy to IndexError.",
            ),
            choice(
                "Jaki błąd wywoła {\"a\": 1}[\"b\"]?",
                listOf("KeyError", "IndexError", "NameError", "ValueError"),
                0,
                "Brakujący klucz słownika to KeyError.",
            ),
            choice(
                "Co jest nie tak z tym kodem?",
                listOf("Brakuje dwukropka – SyntaxError", "Brakuje nawiasu", "Nic", "Zła nazwa funkcji"),
                0,
                "Błąd składni (SyntaxError) Python wykrywa, zanim uruchomi program.",
                code = "if True\n    print(\"tak\")",
            ),
        ),
        lesson(
            "u10l2", "try i except",
            output(
                "try:\n    x = 1 / 0\nexcept ZeroDivisionError:\n    print(\"nie dziel przez zero\")",
                "nie dziel przez zero",
                "except przechwytuje błąd i program działa dalej.",
            ),
            output(
                "try:\n    print(\"A\")\n    int(\"x\")\n    print(\"B\")\nexcept ValueError:\n    print(\"C\")",
                "A\nC",
                "Po błędzie reszta bloku try jest pomijana.",
            ),
            output("try:\n    print(\"OK\")\nexcept:\n    print(\"błąd\")", "OK", "Gdy nie ma błędu, except się nie wykonuje."),
            output(
                "liczby = [1, 2]\ntry:\n    print(liczby[5])\nexcept IndexError:\n    print(\"brak elementu\")",
                "brak elementu",
                "IndexError został przechwycony.",
            ),
            fill(
                "Uzupełnij brakujące słowo kluczowe.",
                "try:\n    x = int(\"abc\")\n____ ValueError:\n    print(\"to nie liczba\")",
                listOf("except", "catch", "error"),
                "except",
                "W Pythonie piszemy try / except.",
            ),
            output(
                "def dziel(a, b):\n    try:\n        return a / b\n    except ZeroDivisionError:\n        return None\n\nprint(dziel(6, 3))\nprint(dziel(1, 0))",
                "2.0\nNone",
                "Funkcja zwraca None, zamiast przerywać program.",
            ),
            output(
                "try:\n    print(int(\"5\") + 1)\nexcept ValueError:\n    print(\"błąd\")",
                "6",
                "\"5\" da się zamienić na liczbę, więc błędu nie ma.",
            ),
        ),
        lesson(
            "u10l3", "else, finally i raise",
            output(
                "try:\n    x = 5\nexcept:\n    print(\"błąd\")\nelse:\n    print(\"bez błędów\")",
                "bez błędów",
                "else wykonuje się, gdy w try nie było błędu.",
            ),
            output(
                "try:\n    1 / 0\nexcept ZeroDivisionError:\n    print(\"błąd\")\nfinally:\n    print(\"koniec\")",
                "błąd\nkoniec",
                "finally wykonuje się zawsze.",
            ),
            output("try:\n    print(\"start\")\nfinally:\n    print(\"sprzątanie\")", "start\nsprzątanie", "finally działa także bez błędu."),
            output(
                "def sprawdz(wiek):\n    if wiek < 0:\n        raise ValueError(\"ujemny wiek\")\n    return wiek\n\ntry:\n    sprawdz(-1)\nexcept ValueError as e:\n    print(e)",
                "ujemny wiek",
                "raise zgłasza błąd, a as e pozwala odczytać jego komunikat.",
            ),
            tiles(
                "Zgłoś błąd ValueError z komunikatem \"zła wartość\"",
                listOf("raise", "ValueError(", "\"zła wartość\"", ")"),
                listOf("except", "return"),
                "raise zgłasza wyjątek.",
            ),
            choice(
                "Kiedy wykona się blok finally?",
                listOf("Zawsze", "Tylko przy błędzie", "Tylko bez błędu", "Nigdy"),
                0,
                "finally służy do sprzątania i wykonuje się zawsze.",
            ),
            output(
                "try:\n    int(\"x\")\nexcept (ValueError, TypeError):\n    print(\"zły typ lub wartość\")",
                "zły typ lub wartość",
                "W nawiasie można podać kilka rodzajów błędów.",
            ),
            fill(
                "Uzupełnij, aby zapisać błąd w zmiennej e.",
                "try:\n    int(\"abc\")\nexcept ValueError ____ e:\n    print(\"Błąd!\")",
                listOf("as", "in", "is"),
                "as",
                "except Błąd as e: zapisuje błąd w zmiennej e.",
            ),
        ),
        lesson(
            "u10l4", "Powtórka: błędy",
            output(
                "try:\n    d = {}\n    print(d[\"x\"])\nexcept KeyError:\n    print(\"brak klucza\")",
                "brak klucza",
                "Brakujący klucz to KeyError.",
            ),
            output(
                "wyniki = []\nfor t in [\"1\", \"a\", \"3\"]:\n    try:\n        wyniki.append(int(t))\n    except ValueError:\n        pass\nprint(wyniki)",
                "[1, 3]",
                "Niepoprawne wartości są pomijane.",
            ),
            choice(
                "Który blok wykona się tylko wtedy, gdy NIE było błędu?",
                listOf("else", "finally", "except", "try"),
                0,
                "else po except działa tylko przy braku błędu.",
            ),
            output(
                "def bezpieczne_int(s):\n    try:\n        return int(s)\n    except ValueError:\n        return 0\n\nprint(bezpieczne_int(\"7\") + bezpieczne_int(\"x\"))",
                "7",
                "7 + 0 = 7.",
            ),
            output(
                "try:\n    x = [1, 2, 3]\n    print(x[1])\nexcept IndexError:\n    print(\"błąd\")\nelse:\n    print(\"OK\")",
                "2\nOK",
                "Nie było błędu, więc wykonuje się też else.",
            ),
            fill(
                "Uzupełnij, aby przechwycić dzielenie przez zero.",
                "try:\n    print(10 / 0)\nexcept ____:\n    print(\"nie można\")",
                listOf("ZeroDivisionError", "ValueError", "IndexError"),
                "ZeroDivisionError",
                "Dzielenie przez zero zgłasza ZeroDivisionError.",
            ),
            choice(
                "Co wypisze ten kod?",
                listOf("a i c", "a, b i c", "tylko a", "b i c"),
                0,
                "Nie było błędu, więc wykonują się try i finally.",
                code = "try:\n    print(\"a\")\nexcept:\n    print(\"b\")\nfinally:\n    print(\"c\")",
            ),
            output(
                "licznik = 0\nfor x in [2, 0, 5]:\n    try:\n        print(10 // x)\n    except ZeroDivisionError:\n        licznik += 1\nprint(licznik)",
                "5\n2\n1",
                "Dla 0 błąd jest liczony, a pozostałe wyniki są wypisywane.",
            ),
        ),
    ),
)
