package com.mrpython.app.data.course

internal val module3Cards = listOf(
    cards(
        "u3l1",
        explain(
            "Kolejność działań",
            "Najpierw potęga `**`, potem `*`, `/`, `//` i `%`, a na końcu `+` i `-`. Nawiasy zmieniają " +
                "tę kolejność – to, co w nawiasie, liczy się najpierw.",
            code = "print(2 * 3 ** 2)\nprint((2 + 3) * 4)",
            output = "18\n20",
        ),
        explain(
            "Jak liczyć resztę?",
            "Żeby policzyć `17 % 5`, sprawdź, ile razy 5 mieści się w 17: 3 razy, czyli 15. Reszta to " +
                "17 - 15 = 2. Gdy liczba jest mniejsza od dzielnika, reszta to cała liczba: `3 % 10` to 3.",
            code = "print(17 // 5)\nprint(17 % 5)\nprint(3 % 10)",
            output = "3\n2\n3",
        ),
        explain(
            "// zaokrągla w dół",
            "`//` zawsze zaokrągla wynik w dół, do mniejszej liczby. Dla liczb ujemnych oznacza to " +
                "oddalenie od zera: -7 / 2 to -3.5, więc `-7 // 2` daje -4.",
            code = "print(7 // 2)\nprint(-7 // 2)",
            output = "3\n-4",
        ),
    ),
    cards(
        "u3l2",
        explain(
            "Porównywanie napisów",
            "`==` i `!=` działają też na napisach. Napisy są równe tylko wtedy, gdy mają dokładnie te same " +
                "znaki – wielka i mała litera to różne znaki.",
            code = "print(\"kot\" == \"kot\")\nprint(\"A\" == \"a\")",
            output = "True\nFalse",
        ),
        explain(
            "Łańcuch porównań",
            "Porównania można łączyć: `1 < x < 5` znaczy „x jest większe od 1 i mniejsze od 5”. " +
                "To krótszy zapis `1 < x and x < 5`.",
            code = "x = 4\nprint(1 < x < 5)\nprint(0 <= x <= 3)",
            output = "True\nFalse",
        ),
        explain(
            "not przed porównaniem",
            "Python najpierw liczy porównanie, a dopiero potem `not` je odwraca: `not 3 > 1` to `not True`, " +
                "czyli `False`. `not (...)` z nawiasem odwraca wynik całego wyrażenia w środku.",
            code = "print(not 3 > 1)\nprint(not (2 > 5 and 1 > 0))",
            output = "False\nTrue",
        ),
    ),
    cards(
        "u3l3",
        explain(
            "Gdzie kończy się blok?",
            "Do bloku `if` należą wszystkie wcięte linie pod nim. Pierwsza linia bez wcięcia jest już poza " +
                "blokiem – wykona się zawsze, niezależnie od warunku.",
            code = "x = 1\nif x > 5:\n    print(\"duże\")\n    print(\"bardzo\")\nprint(\"koniec\")",
            output = "koniec",
        ),
        explain(
            "Wartość jako warunek",
            "W `if` możesz wpisać samą wartość. `0` i pusty napis `\"\"` działają jak `False`, a inne liczby " +
                "i niepuste napisy – jak `True`. `if not s:` sprawdza więc, czy napis jest pusty.",
            code = "s = \"\"\nif not s:\n    print(\"pusty\")\nif 5:\n    print(\"tak\")",
            output = "pusty\ntak",
        ),
        explain(
            "Parzysta czy nieparzysta?",
            "Liczba jest parzysta, gdy dzieli się przez 2 bez reszty: `n % 2 == 0`. Python najpierw liczy " +
                "`n % 2`, a potem porównuje wynik z 0. Reszta 1 oznacza liczbę nieparzystą.",
            code = "n = 7\nprint(n % 2)\nprint(n % 2 == 0)",
            output = "1\nFalse",
        ),
    ),
    cards(
        "u3l4",
        explain(
            "Długość napisu: len()",
            "Funkcja `len()` zwraca liczbę znaków w napisie – spacje też się liczą. Wynik to zwykła liczba, " +
                "więc można go porównać.",
            code = "print(len(\"kot\"))\nprint(len(\"a b\") > 2)",
            output = "3\nTrue",
        ),
        explain(
            "if w środku if",
            "Blok `if` może zawierać kolejny `if` – wtedy wcinamy go jeszcze bardziej (8 spacji). Wewnętrzny " +
                "warunek sprawdza się tylko wtedy, gdy zewnętrzny jest prawdziwy.",
            code = "x = 4\nif x > 0:\n    if x > 10:\n        print(\"duża\")\n    else:\n        print(\"mała\")",
            output = "mała",
        ),
    ),
    cards(
        "u3l5",
        explain(
            "Dwa if-y czy elif?",
            "Przy `if` / `elif` wykona się najwyżej jeden blok. Dwa osobne `if`-y są niezależne – Python " +
                "sprawdza każdy z nich, więc może wykonać oba.",
            code = "x = 8\nif x > 5:\n    print(\"A\")\nif x > 2:\n    print(\"B\")",
            output = "A\nB",
        ),
    ),
)
