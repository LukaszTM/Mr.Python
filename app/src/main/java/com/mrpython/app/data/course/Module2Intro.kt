package com.mrpython.app.data.course

internal val module2Intro = lesson(
    "u2l0", "Wprowadzenie: zmienne i typy",
    explain(
        "Czym jest zmienna?",
        "Zmienna to pudełko z nazwą, w którym program przechowuje wartość. Tworzysz ją znakiem `=`: " +
            "po lewej nazwa, po prawej wartość. Później możesz ją nadpisać, np. skrótem `+=`.",
        code = "punkty = 3\npunkty = punkty + 2\npunkty += 1\nprint(punkty)",
        output = "6",
    ),
    explain(
        "Typy danych",
        "Każda wartość ma typ. `int` to liczba całkowita, `float` – liczba z kropką, `str` – napis, " +
            "a `bool` – prawda lub fałsz. Typ sprawdzisz funkcją `type()`.",
        code = "print(type(7))\nprint(type(3.5))\nprint(type(\"7\"))",
        output = "<class 'int'>\n<class 'float'>\n<class 'str'>",
    ),
    explain(
        "Zamiana typów",
        "Napis \"4\" to nie liczba – plus go skleja. Funkcja `int()` zamienia napis na liczbę, " +
            "a `str()` liczbę na napis.",
        code = "print(\"4\" + \"1\")\nprint(int(\"4\") + 1)\nprint(str(5) + \"0\")",
        output = "41\n5\n50",
    ),
    explain(
        "f-stringi i input()",
        "Napis z literą `f` przed cudzysłowem może zawierać zmienne w klamrach `{}`. " +
            "Funkcja `input()` pyta użytkownika o tekst i zawsze zwraca napis.",
        code = "imie = \"Ewa\"\nwiek = 9\nprint(f\"{imie} ma {wiek} lat\")",
        output = "Ewa ma 9 lat",
    ),
    explain(
        "True, False i None",
        "`True` i `False` to wartości logiczne (typ `bool`). Liczba 0 i pusty napis są „fałszywe”. " +
            "`None` oznacza brak wartości.",
        code = "print(bool(0))\nprint(bool(\"a\"))\nprint(None)",
        output = "False\nTrue\nNone",
    ),
    output(
        "x = 4\nx += 6\nprint(x)",
        "10",
        "x += 6 to skrót od x = x + 6.",
    ),
    choice(
        "Jaki typ ma wartość \"12\"?",
        listOf("str", "int", "float", "bool"),
        0,
        "Wszystko w cudzysłowie jest napisem.",
    ),
    fill(
        "Uzupełnij, aby zmienna została wstawiona do napisu.",
        "imie = \"Ola\"\nprint(____\"Hej, {imie}!\")",
        listOf("f", "s", "#"),
        "f",
        "Litera f przed cudzysłowem tworzy f-string.",
    ),
)
