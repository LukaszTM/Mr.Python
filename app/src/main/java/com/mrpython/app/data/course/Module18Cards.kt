package com.mrpython.app.data.course

internal val module18Cards = listOf(
    cards(
        "u18l1",
        explain(
            "Najpierw import",
            "Nazwa modułu istnieje dopiero po wykonaniu `import`, dlatego importy piszemy na początku " +
                "pliku. Po `import math` funkcje wołamy z przedrostkiem – samo `sqrt(9)` da `NameError`.",
            code = "import math\nprint(math.sqrt(9))\nprint(math.floor(7.9))",
            output = "3.0\n7",
        ),
        explain(
            "Pierwiastek to float",
            "`math.sqrt()` zawsze zwraca float, nawet gdy wynik jest całkowity. Gdy potrzebujesz int, " +
                "użyj `int()`, a `round(x, 3)` zaokrągli do trzech miejsc po przecinku.",
            code = "import math\nx = math.sqrt(36)\nprint(x, int(x))\nprint(round(math.pi, 3))",
            output = "6.0 6\n3.142",
        ),
    ),
    cards(
        "u18l2",
        explain(
            "Kilka nazw i aliasy",
            "Po `from math import` możesz wymienić kilka nazw po przecinku. Alias `as` nadasz też " +
                "pojedynczej nazwie, np. `from math import floor as f`.",
            code = "from math import pi, floor as f\nprint(f(pi))",
            output = "3",
        ),
        explain(
            "Która nazwa istnieje?",
            "Dostępne są tylko nazwy utworzone przez import. Po `import math as m` działa `m`, ale nie " +
                "`math`, a po `from math import sqrt` jest `sqrt`, ale nie `math`. Inaczej – `NameError`.",
            code = "import math as m\ntry:\n    print(math.pi)\nexcept NameError:\n    print(\"tylko m\")",
            output = "tylko m",
        ),
    ),
    cards(
        "u18l3",
        explain(
            "Potęga: math.pow",
            "`math.pow(a, b)` podnosi `a` do potęgi `b` i zawsze zwraca float. Potęga 0.5 to pierwiastek.",
            code = "import math\nprint(math.pow(2, 3), math.pow(9, 0.5))",
            output = "8.0 3.0",
        ),
        explain(
            "Liczby ujemne",
            "`floor` zawsze idzie w dół, do mniejszej liczby, a `ceil` w górę. Dlatego `floor(-2.5)` " +
                "to -3, a `ceil(-2.5)` to -2. Liczba już całkowita się nie zmienia.",
            code = "import math\nprint(math.floor(-2.5), math.ceil(-2.5))\nprint(math.ceil(5.0))",
            output = "-3 -2\n5",
        ),
    ),
    cards(
        "u18l4",
        explain(
            "Import wszystkiego: *",
            "`from math import *` wczytuje naraz wszystkie publiczne nazwy modułu. Łatwo wtedy " +
                "o konflikt nazw: późniejsze przypisanie albo własna funkcja o tej samej nazwie zasłoni zaimportowaną.",
            code = "from math import *\nprint(floor(2.9))\npi = 3\nprint(pi)",
            output = "2\n3",
        ),
        explain(
            "Biblioteka standardowa",
            "Moduły takie jak `math` czy `random` są dostępne od razu po instalacji Pythona. Moduł " +
                "wczytuje się tylko raz, nawet przy kilku importach. Gdy go nie ma, pojawia się `ModuleNotFoundError`.",
            code = "try:\n    import matematyka\nexcept ModuleNotFoundError:\n    print(\"brak\")",
            output = "brak",
        ),
    ),
)
