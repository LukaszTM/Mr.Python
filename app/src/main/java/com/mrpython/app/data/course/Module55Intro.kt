package com.mrpython.app.data.course

internal val module55Intro = lesson(
    "u55l0", "Wprowadzenie: projekt kalkulator",
    explain(
        "Cel projektu",
        "W tym module krok po kroku zbudujesz kalkulator, który policzy wyrażenie zapisane tekstem, " +
            "np. `\"6 * 7\"`. Połączysz w nim funkcje, słowniki, napisy, wyjątki i listy – " +
            "wszystko, co już znasz.",
    ),
    explain(
        "Działania jako funkcje",
        "Każde działanie to mała funkcja z dwoma argumentami. Takie klocki łatwo testować i łączyć. " +
            "Pamiętaj: `/` zawsze daje float, a `**` to potęgowanie.",
        code = "def pomnoz(a, b):\n    return a * b\n\nprint(pomnoz(4, 5), 7 / 2)",
        output = "20 3.5",
    ),
    explain(
        "Słownik funkcji",
        "Funkcje to obiekty, więc można je trzymać w słowniku pod kluczem-znakiem. Krótkie działania " +
            "wygodnie zapisać jako `lambda`. Zamiast długiego `if/elif` wystarczy `dz[znak](a, b)`.",
        code = "dz = {\"+\": lambda a, b: a + b,\n      \"-\": lambda a, b: a - b}\nprint(dz[\"-\"](8, 2))",
        output = "6",
    ),
    explain(
        "Rozbijanie tekstu",
        "`split()` dzieli napis po spacjach. Wynik rozpakowujemy do trzech zmiennych, " +
            "a liczby zamieniamy przez `int()` albo `float()`.",
        code = "a, znak, b = \"10 * 4\".split()\nprint(a, znak, b)\nprint(int(a) * int(b))",
        output = "10 * 4\n40",
    ),
    explain(
        "Błędy i historia",
        "Złe dane dają `ValueError`, nieznany znak – `KeyError`, a dzielenie przez zero – " +
            "`ZeroDivisionError`. Łapiemy je w `try/except`. Udane wyniki dopisujemy do listy historii.",
        code = "historia = []\ntry:\n    historia.append(5 / 0)\nexcept ZeroDivisionError:\n    print(\"Nie dziel przez 0!\")\nprint(historia)",
        output = "Nie dziel przez 0!\n[]",
    ),
    output(
        "a, z, b = \"3 + 4\".split()\nprint(int(a) + int(b))",
        "7",
        "split() daje trzy części, a int() zamienia je na liczby.",
    ),
    choice(
        "Jaki wyjątek zgłosi int(\"x\")?",
        listOf("ValueError", "KeyError", "ZeroDivisionError", "IndexError"),
        0,
        "Napisu \"x\" nie da się zamienić na liczbę – to ValueError.",
    ),
    fill(
        "Uzupełnij, aby wywołać funkcję mnożenia ze słownika.",
        "dz = {\"*\": lambda a, b: a * b}\nprint(dz____(3, 4))",
        listOf("[\"*\"]", "(\"*\")", "[*]"),
        "[\"*\"]",
        "Funkcję wyjmujemy ze słownika po kluczu w nawiasach kwadratowych.",
    ),
)
