package com.mrpython.app.data.course

internal val module35Cards = listOf(
    cards(
        "u35l1",
        explain(
            "Wyjątek z własnymi danymi",
            "Własny wyjątek może mieć `__init__` z dodatkowymi atrybutami. `super().__init__(komunikat)` " +
                "ustawia tekst, który pokaże `print(e)`.",
            code = "class KodError(Exception):\n    def __init__(self, kod):\n        super().__init__(f\"kod {kod}\")\n        self.kod = kod\n\ntry:\n    raise KodError(404)\nexcept KodError as e:\n    print(e, e.kod)",
            output = "kod 404 404",
        ),
        explain(
            "Co można zgłosić?",
            "`raise` przyjmuje tylko wyjątki – klasa musi dziedziczyć po `Exception`, inaczej będzie `TypeError`. " +
                "Można zgłosić obiekt `Blad(\"opis\")` albo samą klasę `Blad`. Nazwy kończymy zwykle na `Error`.",
            code = "class Stop(Exception):\n    pass\n\ntry:\n    raise Stop\nexcept Stop:\n    print(\"złapany\")",
            output = "złapany",
        ),
    ),
    cards(
        "u35l2",
        explain(
            "Rodzina wbudowanych wyjątków",
            "Wbudowane wyjątki też dziedziczą po sobie: `KeyError` i `IndexError` po `LookupError`, " +
                "a `ZeroDivisionError` po `ArithmeticError`. Wszystkie dziedziczą po `Exception`.",
            code = "print(issubclass(KeyError, LookupError))\ntry:\n    1 / 0\nexcept ArithmeticError as e:\n    print(type(e).__name__)",
            output = "True\nZeroDivisionError",
        ),
        explain(
            "Kilka wyjątków naraz",
            "W jednym `except` można podać krotkę klas wyjątków. Blok obsłuży każdy z nich, " +
                "a `type(e).__name__` powie, który wystąpił.",
            code = "for blad in [KeyError, ValueError]:\n    try:\n        raise blad\n    except (KeyError, ValueError) as e:\n        print(type(e).__name__)",
            output = "KeyError\nValueError",
        ),
    ),
)
