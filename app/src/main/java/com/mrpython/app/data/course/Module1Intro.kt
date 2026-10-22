package com.mrpython.app.data.course

internal val module1Intro = lesson(
    "u1l0", "Wprowadzenie: pierwszy program",
    explain(
        "Czym jest program?",
        "Program to lista poleceń dla komputera. Python wykonuje je po kolei, od góry do dołu – " +
            "linijka po linijce. W tej aplikacji każdy przykład możesz potraktować jak plik `main.py`.",
    ),
    explain(
        "Funkcja print()",
        "Żeby coś wypisać na ekranie, używamy funkcji `print()`. To, co chcesz wypisać, " +
            "wpisujesz w nawiasach.",
        code = "print(\"Cześć!\")",
        output = "Cześć!",
    ),
    explain(
        "Napisy w cudzysłowie",
        "Tekst w Pythonie to napis (ang. string). Zawsze otaczamy go cudzysłowami \" \" albo " +
            "apostrofami ' '. Na ekranie cudzysłowy się nie pojawiają.",
        code = "print(\"Python\")\nprint('jest fajny')",
        output = "Python\njest fajny",
    ),
    explain(
        "Liczby i działania",
        "Liczb nie bierzemy w cudzysłów. Wtedy Python może na nich liczyć – `print()` wypisze wynik.",
        code = "print(2 + 3)\nprint(\"2 + 3\")",
        output = "5\n2 + 3",
    ),
    explain(
        "Komentarze",
        "Linia zaczynająca się od `#` to komentarz – notatka dla ludzi. Python ją pomija.",
        code = "# to jest komentarz\nprint(\"Działa!\")",
        output = "Działa!",
    ),
    choice(
        "Co pojawi się na ekranie jako pierwsze?",
        listOf("Start", "Ukryte", "Koniec", "Nic"),
        0,
        "Python wykonuje linie od góry, a linię z # pomija – więc najpierw wypisze Start.",
        code = "print(\"Start\")\n# print(\"Ukryte\")\nprint(\"Koniec\")",
    ),
    output(
        "print(\"Witaj\")\nprint(10 + 5)",
        "Witaj\n15",
        "Napis wypisuje się bez cudzysłowów, a działanie zostaje obliczone.",
    ),
)
