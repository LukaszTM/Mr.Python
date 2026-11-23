package com.mrpython.app.data.course

internal val module10Intro = lesson(
    "u10l0", "Wprowadzenie: obsługa błędów",
    explain(
        "Rodzaje błędów",
        "Gdy coś pójdzie nie tak, Python zgłasza błąd (wyjątek) i zatrzymuje program. Nazwa mówi, " +
            "co się stało: `ValueError` – zła wartość, np. `int(\"abc\")`; `ZeroDivisionError` – dzielenie " +
            "przez zero; `TypeError` – zły typ, np. `\"a\" + 1`; `IndexError`, `KeyError`, `NameError`.",
    ),
    explain(
        "try i except",
        "Ryzykowny kod umieszczamy w bloku `try`. Jeśli wystąpi błąd, Python przerywa `try`, skacze " +
            "do pasującego `except` i program działa dalej zamiast się zatrzymać.",
        code = "try:\n    x = int(\"abc\")\n    print(\"to się nie wypisze\")\nexcept ValueError:\n    print(\"to nie liczba\")",
        output = "to nie liczba",
    ),
    explain(
        "Gdy wszystko się uda: else",
        "Blok `else` po `except` wykona się tylko wtedy, gdy w `try` nie było żadnego błędu.",
        code = "try:\n    x = 10 / 2\nexcept ZeroDivisionError:\n    print(\"błąd\")\nelse:\n    print(x)",
        output = "5.0",
    ),
    explain(
        "Zawsze: finally",
        "Blok `finally` wykona się zawsze – i gdy był błąd, i gdy go nie było. Przydaje się do sprzątania " +
            "na koniec.",
        code = "try:\n    print(1 / 0)\nexcept ZeroDivisionError:\n    print(\"błąd\")\nfinally:\n    print(\"koniec\")",
        output = "błąd\nkoniec",
    ),
    explain(
        "raise i as e",
        "Słowem `raise` sam zgłaszasz błąd, np. gdy dane są niepoprawne. Zapis `except ValueError as e` " +
            "zapisuje błąd w zmiennej `e`, więc możesz wypisać jego opis.",
        code = "try:\n    raise ValueError(\"ujemny wiek\")\nexcept ValueError as e:\n    print(\"Błąd:\", e)",
        output = "Błąd: ujemny wiek",
    ),
    choice(
        "Jaki błąd wywoła 1 / 0?",
        listOf("ZeroDivisionError", "ValueError", "TypeError", "KeyError"),
        0,
        "Dzielenie przez zero to ZeroDivisionError.",
    ),
    output(
        "try:\n    print(int(\"5\") + 1)\nexcept ValueError:\n    print(\"błąd\")",
        "6",
        "\"5\" da się zamienić na liczbę, więc błędu nie ma.",
    ),
    fill(
        "Uzupełnij brakujące słowo kluczowe.",
        "try:\n    x = [1, 2][5]\n____ IndexError:\n    print(\"brak\")",
        listOf("except", "else", "catch"),
        "except",
        "Błąd przechwytuje blok except.",
    ),
)
