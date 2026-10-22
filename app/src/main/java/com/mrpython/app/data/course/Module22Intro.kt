package com.mrpython.app.data.course

internal val module22Intro = lesson(
    "u22l0", "Wprowadzenie: enumerate i zip",
    explain(
        "enumerate – numer i element",
        "Często potrzebujesz w pętli i elementu, i jego numeru. `enumerate()` daje pary (indeks, element), " +
            "więc nie musisz pisać `range(len(lista))`. Argument `start=1` zaczyna liczenie od 1.",
        code = "for i, x in enumerate([\"a\", \"b\"], start=1):\n    print(i, x)",
        output = "1 a\n2 b",
    ),
    explain(
        "zip – idź równolegle",
        "`zip()` łączy kilka list element po elemencie w krotki. Kończy na najkrótszej liście. " +
            "Z dwóch list zrobisz też szybko słownik: `dict(zip(klucze, wartosci))`.",
        code = "imiona = [\"Ala\", \"Ola\"]\nwiek = [7, 9]\nfor a, b in zip(imiona, wiek):\n    print(a, b)\nprint(dict(zip(imiona, wiek)))",
        output = "Ala 7\nOla 9\n{'Ala': 7, 'Ola': 9}",
    ),
    explain(
        "reversed – od końca",
        "`reversed()` pozwala przejść po liście albo napisie od ostatniego elementu do pierwszego, " +
            "nie zmieniając oryginału.",
        code = "for x in reversed([1, 2, 3]):\n    print(x)",
        output = "3\n2\n1",
    ),
    explain(
        "sorted kontra sort",
        "`sorted(lista)` zwraca nową, posortowaną listę, a oryginał zostaje bez zmian. " +
            "`lista.sort()` sortuje listę w miejscu i zwraca `None`. Obie przyjmują `reverse=True`.",
        code = "a = [3, 1, 2]\nprint(sorted(a))\nprint(a)\na.sort()\nprint(a)",
        output = "[1, 2, 3]\n[3, 1, 2]\n[1, 2, 3]",
    ),
    explain(
        "any i all",
        "`any()` zwraca `True`, gdy choć jeden element jest prawdziwy. `all()` – gdy wszystkie są " +
            "prawdziwe. Świetnie łączą się z wyrażeniem listowym z warunkiem.",
        code = "liczby = [2, 4, 7]\nprint(any([x > 5 for x in liczby]))\nprint(all([x % 2 == 0 for x in liczby]))",
        output = "True\nFalse",
    ),
    output(
        "for i, x in enumerate([\"kot\", \"pies\"]):\n    print(i, x)",
        "0 kot\n1 pies",
        "Bez start= numeracja zaczyna się od 0.",
    ),
    choice(
        "Co robi zip, gdy listy mają różne długości?",
        listOf("Kończy na najkrótszej liście", "Zgłasza błąd", "Uzupełnia braki wartością None", "Powtarza krótszą listę"),
        0,
        "zip tworzy pary tylko dopóki starcza elementów we wszystkich listach.",
    ),
    fill(
        "Uzupełnij, aby sprawdzić, czy jakaś liczba jest ujemna.",
        "liczby = [3, -1, 5]\nprint(____([x < 0 for x in liczby]))",
        listOf("any", "all", "min"),
        "any",
        "any zwraca True, gdy choć jeden warunek jest spełniony.",
    ),
)
