package com.mrpython.app.data.course

internal val module60Cards = listOf(
    cards(
        "u60l5",
        explain(
            "next z wartością domyślną",
            "`next(it)` na wyczerpanym iteratorze zgłasza `StopIteration`. Gdy podasz drugi argument, " +
                "`next(it, domyslna)` zwróci go zamiast błędu.",
            code = "it = iter([7])\nprint(next(it, None))\nprint(next(it, None))",
            output = "7\nNone",
        ),
    ),
    cards(
        "u60l7",
        explain(
            "Łańcuchy porównań",
            "Python łączy kolejne porównania: `a < b > c` znaczy `a < b and b > c`. Dotyczy to też `==` " +
                "i `in`. Nawias zmienia sens: `(4 > 2) == 2` porównuje `True` z liczbą 2.",
            code = "print(1 < 5 > 2)\nprint(4 > 2 == 2, (4 > 2) == 2)\nprint(1 == 1 in [1])",
            output = "True\nTrue False\nTrue",
        ),
        explain(
            "not działa na końcu",
            "`not` ma niższy priorytet niż działania i porównania, więc liczy się na samym końcu. " +
                "`not 3 - 2` to `not (3 - 2)`, a `not 1 == 2` to `not (1 == 2)`.",
            code = "print(not 3 - 2)\nprint(not 1 == 2)",
            output = "False\nTrue",
        ),
    ),
)
