package com.mrpython.app.data.course

internal val module24Intro = lesson(
    "u24l0", "Wprowadzenie: funkcje wbudowane",
    explain(
        "min i max",
        "`min()` i `max()` przyjmują kilka argumentów albo jedną listę. Z `key` porównują wynik funkcji, " +
            "a `default` podaje wynik dla pustej listy (bez niego pusta lista to błąd).",
        code = "print(max([4, 2, 8]))\nprint(min([\"ala\", \"ma\"], key=len))\nprint(max([], default=0))",
        output = "8\nma\n0",
    ),
    explain(
        "Funkcje liczbowe",
        "`sum()` sumuje, `abs()` daje wartość bezwzględną, `round(x, 2)` zaokrągla do 2 miejsc, " +
            "a `divmod(a, b)` zwraca naraz iloraz całkowity i resztę.",
        code = "print(sum([1, 2, 3]))\nprint(abs(-7))\nprint(round(3.14159, 2))\nprint(divmod(17, 5))",
        output = "6\n7\n3.14\n(3, 2)",
    ),
    explain(
        "isinstance – jaki to typ?",
        "`isinstance(x, int)` sprawdza, czy wartość jest danego typu. Można podać kilka typów naraz " +
            "w krotce: `(int, float)`. Przydaje się, gdy dane są pomieszane.",
        code = "print(isinstance(5, int))\nprint(isinstance(\"5\", int))\nprint(isinstance(2.5, (int, float)))",
        output = "True\nFalse\nTrue",
    ),
    explain(
        "chr i ord",
        "Każdy znak ma swój numer (kod). `ord(\"A\")` zwraca kod znaku, a `chr(66)` – znak o danym kodzie. " +
            "Kolejne litery mają kolejne kody.",
        code = "print(ord(\"A\"))\nprint(chr(66))\nprint(chr(ord(\"a\") + 1))",
        output = "65\nB\nb",
    ),
    explain(
        "Konwersje typów",
        "`int()`, `float()`, `str()`, `list()` i `tuple()` zamieniają wartości na inny typ. " +
            "Uwaga: `int(3.9)` obcina część ułamkową, a nie zaokrągla.",
        code = "print(int(\"42\") + 1)\nprint(str(42) + \"1\")\nprint(int(3.9))",
        output = "43\n421\n3",
    ),
    output(
        "print(min(4, 2, 8))\nprint(abs(-3))",
        "2\n3",
        "min wybiera najmniejszą liczbę, abs usuwa minus.",
    ),
    choice(
        "Co sprawdza isinstance(x, str)?",
        listOf("Czy x jest napisem", "Zamienia x na napis", "Czy x jest pusty", "Długość x"),
        0,
        "isinstance sprawdza typ wartości.",
    ),
    fill(
        "Uzupełnij, aby wypisać kod znaku \"a\".",
        "print(____(\"a\"))",
        listOf("ord", "chr", "int"),
        "ord",
        "ord zamienia znak na jego kod.",
    ),
)
