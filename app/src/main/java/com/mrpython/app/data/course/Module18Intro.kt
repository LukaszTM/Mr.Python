package com.mrpython.app.data.course

internal val module18Intro = lesson(
    "u18l0", "Wprowadzenie: moduł math",
    explain(
        "Instrukcja import",
        "Python ma wiele gotowych modułów z dodatkowymi funkcjami. `import math` wczytuje moduł " +
            "matematyczny – jego funkcje wywołujemy z przedrostkiem, np. `math.sqrt()`.",
        code = "import math\nprint(math.sqrt(16))",
        output = "4.0",
    ),
    explain(
        "from … import i as",
        "`from math import sqrt` pozwala pisać samo `sqrt()`, bez przedrostka. " +
            "`import math as m` nadaje modułowi krótszą nazwę – wtedy piszemy `m.floor()`.",
        code = "from math import sqrt\nimport math as m\nprint(sqrt(49))\nprint(m.floor(3.9))",
        output = "7.0\n3",
    ),
    explain(
        "Zaokrąglanie",
        "`math.floor()` zaokrągla w dół, a `math.ceil()` w górę – oba zwracają liczbę całkowitą. " +
            "Przydaje się np. do liczenia, ile autobusów potrzeba dla grupy.",
        code = "import math\nprint(math.floor(2.7))\nprint(math.ceil(2.1))",
        output = "2\n3",
    ),
    explain(
        "Inne przydatne funkcje",
        "`math.pi` to liczba π, `math.gcd(a, b)` – największy wspólny dzielnik, a `math.isclose()` " +
            "bezpiecznie porównuje liczby float, które często mają drobne błędy zaokrągleń.",
        code = "import math\nprint(math.gcd(12, 18))\nprint(0.1 + 0.2 == 0.3)\nprint(math.isclose(0.1 + 0.2, 0.3))",
        output = "6\nFalse\nTrue",
    ),
    explain(
        "Czym jest moduł",
        "Moduł to po prostu plik `.py` z kodem. Twój plik `pomocnik.py` też jest modułem – " +
            "z pliku obok zaimportujesz z niego funkcję przez `from pomocnik import witaj`.",
        code = "import math\nprint(type(math.pi))",
        output = "<class 'float'>",
    ),
    output(
        "import math\nprint(math.ceil(4.2))",
        "5",
        "ceil zaokrągla w górę.",
    ),
    choice(
        "Jak wywołasz funkcję po from math import floor?",
        listOf("floor(2.5)", "math.floor(2.5)", "math(floor(2.5))", "import floor(2.5)"),
        0,
        "Po from … import nazwę funkcji piszemy bez przedrostka.",
    ),
    fill(
        "Uzupełnij, aby nadać modułowi krótszą nazwę m.",
        "import math ____ m\nprint(m.floor(1.5))",
        listOf("as", "from", "is"),
        "as",
        "Słowo as nadaje modułowi inną nazwę.",
    ),
)
