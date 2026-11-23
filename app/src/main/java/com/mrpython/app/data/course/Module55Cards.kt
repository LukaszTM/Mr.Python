package com.mrpython.app.data.course

internal val module55Cards = listOf(
    cards(
        "u55l2",
        explain(
            "Moduł operator",
            "Moduł `operator` ma gotowe funkcje dla działań: `add` (+), `sub` (-), `mul` (*) i " +
                "`truediv` (/). Można je od razu wstawić do słownika działań zamiast pisać `lambda`.",
            code = "import operator\ndz = {\"+\": operator.add, \"*\": operator.mul}\nprint(dz[\"*\"](6, 7), operator.sub(9, 4))",
            output = "42 5",
        ),
        explain(
            "get dla nieznanego znaku",
            "`dz[znak]` dla brakującego klucza zgłasza `KeyError`, a `dz.get(znak)` zwraca `None`. " +
                "Drugim argumentem `get` podasz wartość zastępczą – może nią być nawet funkcja.",
            code = "dz = {\"+\": lambda a, b: a + b}\nf = dz.get(\"?\", lambda a, b: \"nieznane\")\nprint(dz.get(\"%\"), f(1, 2))",
            output = "None nieznane",
        ),
    ),
    cards(
        "u55l3",
        explain(
            "split bez argumentu",
            "`split()` bez argumentu tnie po dowolnej liczbie spacji i pomija je na brzegach. Gdy w tekście " +
                "nie ma spacji, dostaniesz jeden element – wtedy pomoże `split(\"+\")`.",
            code = "print(\"  7   *  6 \".split())\nprint(\"2+3\".split(), \"2+3\".split(\"+\"))",
            output = "['7', '*', '6']\n['2+3'] ['2', '3']",
        ),
        explain(
            "Za mało lub za dużo części",
            "Rozpakowanie `a, znak, b = ...` wymaga dokładnie trzech elementów. Gdy jest ich mniej lub " +
                "więcej, Python zgłasza `ValueError`.",
            code = "try:\n    a, z, b = \"4 +\".split()\nexcept ValueError:\n    print(\"złe dane\")",
            output = "złe dane",
        ),
    ),
    cards(
        "u55l4",
        explain(
            "except łapie tylko swój typ",
            "`except ValueError` przechwyci tylko `ValueError`. Inny błąd, np. `ZeroDivisionError`, " +
                "przejdzie dalej i przerwie program. Kilka typów złapiesz krotką: `except (ValueError, ZeroDivisionError)`.",
            code = "try:\n    10 / 0\nexcept (ValueError, ZeroDivisionError) as e:\n    print(type(e).__name__)",
            output = "ZeroDivisionError",
        ),
        explain(
            "finally także przy return",
            "Blok `finally` wykona się zawsze – nawet gdy w `try` lub `except` jest `return`. " +
                "Dzieje się to tuż przed wyjściem z funkcji.",
            code = "def f():\n    try:\n        return \"wynik\"\n    finally:\n        print(\"koniec\")\nprint(f())",
            output = "koniec\nwynik",
        ),
        explain(
            "Wybór w jednej linii",
            "Wyrażenie `a if warunek else b` działa też poza wyrażeniem listowym, np. w `return` albo " +
                "przypisaniu: daje `a`, gdy warunek jest prawdziwy, a w przeciwnym razie `b`.",
            code = "t = \"1a\"\nn = int(t) if t.isdigit() else 0\nprint(n)",
            output = "0",
        ),
    ),
)
