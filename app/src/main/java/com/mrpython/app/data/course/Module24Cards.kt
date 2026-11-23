package com.mrpython.app.data.course

internal val module24Cards = listOf(
    cards(
        "u24l1",
        explain(
            "min i max na napisach",
            "Napisy porównuje się alfabetycznie, litera po literze. `min(\"banan\")` daje najmniejszą literę, " +
                "a `max()` listy słów – ostatnie w alfabecie. Przy remisie wygrywa element, który był pierwszy.",
            code = "print(min(\"banan\"))\nprint(max([\"ala\", \"kot\", \"ser\"]))\nprint(min([\"dom\", \"kot\"], key=len))",
            output = "a\nser\ndom",
        ),
    ),
    cards(
        "u24l2",
        explain(
            "Start w sum()",
            "Drugi argument `sum()` to wartość startowa: `sum(lista, 10)` to 10 plus suma elementów. " +
                "Dla pustej listy wynikiem jest sama wartość startowa.",
            code = "print(sum([1, 2, 3], 10))\nprint(sum([], 7))",
            output = "16\n7",
        ),
        explain(
            "round i równa połowa",
            "`round(x)` bez drugiego argumentu daje liczbę całkowitą. Przy równej połowie (2.5, 3.5) " +
                "wybiera liczbę parzystą – dlatego `round(2.5)` to 2, a `round(3.5)` to 4.",
            code = "print(round(9.99))\nprint(round(2.5), round(3.5))",
            output = "10\n2 4",
        ),
        explain(
            "Potęga: pow",
            "`pow(a, b)` to to samo co `a ** b`. Z trzecim argumentem `pow(a, b, m)` od razu liczy resztę " +
                "z dzielenia potęgi przez m, czyli `a ** b % m`.",
            code = "print(pow(2, 5))\nprint(pow(2, 5, 7))",
            output = "32\n4",
        ),
    ),
    cards(
        "u24l3",
        explain(
            "type() czy isinstance()?",
            "`type(x) == float` sprawdza dokładnie jeden typ. `isinstance()` jest wygodniejsze: przyjmuje " +
                "krotkę typów i uznaje też typy „pochodne”.",
            code = "print(type(3.0) == float)\nprint(type(7) == float)",
            output = "True\nFalse",
        ),
        explain(
            "bool to też int",
            "W Pythonie `True` i `False` są szczególnym rodzajem liczb całkowitych (1 i 0). Dlatego " +
                "`isinstance(True, int)` daje `True`. Odwrotnie nie działa: 1 nie jest typu `bool`.",
            code = "print(isinstance(True, int))\nprint(isinstance(1, bool))",
            output = "True\nFalse",
        ),
    ),
    cards(
        "u24l4",
        explain(
            "Co ma długość?",
            "`len()` działa na napisach, listach, krotkach, zbiorach i słownikach (liczy pary). " +
                "Liczba nie ma długości – `len(5)` zgłasza `TypeError`.",
            code = "print(len(\"kot\"), len([1, 2]), len({\"a\": 1}))",
            output = "3 2 1",
        ),
        explain(
            "Pułapki konwersji",
            "`int()` nie przyjmie napisu z kropką: `int(\"3.5\")` to `ValueError` – użyj `float()`. " +
                "`float(4)` daje 4.0, a `int(-2.7)` obcina w stronę zera do -2.",
            code = "print(float(\"2.5\") * 2)\nprint(float(4), int(-2.7))",
            output = "5.0\n4.0 -2",
        ),
    ),
    cards(
        "u24l5",
        explain(
            "Funkcja bool()",
            "`bool()` mówi, czy wartość jest „prawdziwa”. Fałszywe są: 0, pusty napis i pusta lista. " +
                "Uwaga: napis \"0\" nie jest pusty, więc jest prawdziwy, tak jak lista `[0]`.",
            code = "print(bool(0), bool(\"0\"))\nprint(bool([]), bool([0]))",
            output = "False True\nFalse True",
        ),
        explain(
            "Czy to same cyfry?",
            "Metoda `isdigit()` zwraca `True`, gdy napis składa się tylko z cyfr. Dzięki temu przed " +
                "`int()` sprawdzisz, czy zamiana się uda.",
            code = "print(\"42\".isdigit())\nprint(\"4a\".isdigit())",
            output = "True\nFalse",
        ),
    ),
)
