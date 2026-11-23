package com.mrpython.app.data.course

internal val module58Intro = lesson(
    "u58l0", "Wprowadzenie: łatwe wyzwania",
    explain(
        "Na czym polegają wyzwania?",
        "Ten moduł to krótkie łamigłówki z podstaw: napisy, liczby, listy, pętle, warunki i funkcje. " +
            "Nie ma nowej teorii – czytaj kod linijka po linijce i śledź, jak zmieniają się zmienne.",
        code = "x = 5\nx += x * 2\nprint(x)",
        output = "15",
    ),
    explain(
        "Napisy i listy",
        "Wycinek `s[1:-1]` pomija pierwszy i ostatni znak. `append` dodaje jeden element – nawet " +
            "całą listę – a `extend` dodaje każdy element osobno.",
        code = "a = [1]\na.append([2, 3])\nprint(len(a))\nprint(\"Python\"[1:-1])",
        output = "2\nytho",
    ),
    explain(
        "Pętle: break i continue",
        "`break` przerywa pętlę, a `continue` przeskakuje do następnego obrotu. Blok `else` " +
            "przy pętli wykona się tylko wtedy, gdy nie było `break`.",
        code = "for i in range(5):\n    if i == 1:\n        continue\n    if i == 3:\n        break\n    print(i)",
        output = "0\n2",
    ),
    explain(
        "Warunki i prawdziwość",
        "`0`, pusty napis i pusta lista są fałszywe, prawie wszystko inne – prawdziwe. " +
            "W `if/elif` wykonuje się tylko pierwsza pasująca gałąź.",
        code = "x = 8\nif x > 10:\n    print(\"a\")\nelif x > 5:\n    print(\"b\")\nprint(bool(0), bool([0]))",
        output = "b\nFalse True",
    ),
    explain(
        "Funkcje",
        "Argument domyślny (np. `b=2`) jest używany, gdy go nie podasz. Funkcja bez `return` " +
            "zwraca `None`, a lista przekazana do funkcji może zostać przez nią zmieniona.",
        code = "def f(a, b=2):\n    return a * b\n\nprint(f(3), f(3, 3))",
        output = "6 9",
    ),
    output(
        "print(\"kot\" * 2 + \"!\")",
        "kotkot!",
        "Mnożenie napisu powtarza go, a + dokleja wykrzyknik.",
    ),
    output(
        "s = 0\nfor i in range(4):\n    if i == 2:\n        break\n    s += i\nprint(s)",
        "1",
        "Pętla dodaje 0 i 1, a przy 2 się przerywa.",
    ),
    choice(
        "Co zwraca funkcja bez instrukcji return?",
        listOf("None", "0", "False", "Pusty napis"),
        0,
        "Bez return funkcja zawsze zwraca None.",
    ),
)
