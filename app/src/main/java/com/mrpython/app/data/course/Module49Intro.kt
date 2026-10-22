package com.mrpython.app.data.course

internal val module49Intro = lesson(
    "u49l0", "Wprowadzenie: liczby w praktyce",
    explain(
        "Precyzja float",
        "Komputer zapisuje liczby `float` w systemie dwójkowym, a 0.1 nie ma tam dokładnego zapisu. " +
            "Stąd drobne błędy. Do porównań używaj `math.isclose()`, a do sumowania wielu " +
            "ułamków – `math.fsum()`.",
        code = "import math\nprint(0.1 + 0.2)\nprint(0.1 + 0.2 == 0.3)\nprint(math.isclose(0.1 + 0.2, 0.3))",
        output = "0.30000000000000004\nFalse\nTrue",
    ),
    explain(
        "Zaokrąglanie",
        "`round(x)` zwraca int, a `round(x, n)` zostawia n miejsc po przecinku. Przy remisie (np. 2.5) " +
            "Python wybiera liczbę parzystą. Do wypisywania wygodny jest f-string `{x:.2f}`.",
        code = "print(round(2.5), round(3.5))\nprint(round(3.14159, 2))\nprint(f\"{2/3:.2f}\")",
        output = "2 4\n3.14\n0.67",
    ),
    explain(
        "Decimal – dokładne ułamki dziesiętne",
        "`Decimal` z modułu `decimal` liczy dokładnie w systemie dziesiętnym – idealny do pieniędzy. " +
            "Tworzymy go z napisu, np. `Decimal(\"0.1\")`, bo float 0.1 już ma błąd.",
        code = "from decimal import Decimal\nprint(Decimal(\"0.1\") + Decimal(\"0.2\"))\nprint(Decimal(\"1.10\") + Decimal(\"2.20\"))",
        output = "0.3\n3.30",
    ),
    explain(
        "Fraction – ułamki zwykłe",
        "`Fraction(licznik, mianownik)` z modułu `fractions` przechowuje ułamek zwykły i sam go " +
            "skraca. `float()` zamienia go na liczbę dziesiętną.",
        code = "from fractions import Fraction\nprint(Fraction(1, 3) + Fraction(1, 6))\nprint(float(Fraction(1, 4)))",
        output = "1/2\n0.25",
    ),
    explain(
        "Systemy liczbowe",
        "`bin()` daje zapis dwójkowy (0b), `hex()` szesnastkowy (0x), a `oct()` ósemkowy (0o). " +
            "Napis w innym systemie zamienisz na liczbę przez `int(napis, podstawa)`.",
        code = "print(bin(10), hex(255))\nprint(int(\"ff\", 16), int(\"1010\", 2))",
        output = "0b1010 0xff\n255 10",
    ),
    output(
        "print(round(4.5), round(5.5))",
        "4 6",
        "Remisy idą do najbliższej liczby parzystej.",
    ),
    choice(
        "Który typ wybrać do kwot pieniężnych?",
        listOf("Decimal", "float", "bool", "complex"),
        0,
        "Decimal liczy dokładnie w systemie dziesiętnym.",
    ),
    fill(
        "Uzupełnij, aby zamienić napis dwójkowy na liczbę 5.",
        "print(int(\"101\", ____))",
        listOf("2", "10", "16"),
        "2",
        "Podstawa 2 to system dwójkowy; inne podstawy dadzą 101 lub 257.",
    ),
)
