package com.mrpython.app.data.course

internal val module35Intro = lesson(
    "u35l0", "Wprowadzenie: własne wyjątki",
    explain(
        "Własna klasa wyjątku",
        "Wyjątek to klasa. Własny tworzymy, dziedzicząc po `Exception` – często wystarczy `pass`. " +
            "Nazwa od razu mówi, co poszło nie tak, i taki błąd można złapać osobno.",
        code = "class ZaMaloError(Exception):\n    pass\n\ntry:\n    raise ZaMaloError(\"za mało środków\")\nexcept ZaMaloError as e:\n    print(e)",
        output = "za mało środków",
    ),
    explain(
        "Hierarchia wyjątków",
        "Wyjątki mogą dziedziczyć po sobie. `except` z klasą bazową łapie też wszystkie klasy pochodne. " +
            "Wykonuje się pierwszy pasujący blok, więc bardziej szczegółowe `except` piszemy wyżej.",
        code = "class BladApp(Exception):\n    pass\n\nclass BladLog(BladApp):\n    pass\n\ntry:\n    raise BladLog(\"złe hasło\")\nexcept BladApp as e:\n    print(\"Złapano:\", e)",
        output = "Złapano: złe hasło",
    ),
    explain(
        "Ponowne zgłaszanie: raise",
        "Czasem chcemy zareagować na błąd (np. zapisać log), ale i tak przekazać go dalej. " +
            "Samo `raise` w bloku `except` zgłasza ten sam wyjątek ponownie.",
        code = "try:\n    try:\n        1 / 0\n    except ZeroDivisionError:\n        print(\"loguję\")\n        raise\nexcept ZeroDivisionError:\n    print(\"obsłużone wyżej\")",
        output = "loguję\nobsłużone wyżej",
    ),
    explain(
        "raise ... from",
        "`raise NowyBlad(...) from e` zamienia techniczny błąd na nasz własny, ale zachowuje przyczynę. " +
            "Oryginalny wyjątek trafia do atrybutu `__cause__` nowego wyjątku.",
        code = "try:\n    try:\n        int(\"x\")\n    except ValueError as e:\n        raise RuntimeError(\"zła liczba\") from e\nexcept RuntimeError as e:\n    print(e, type(e.__cause__).__name__)",
        output = "zła liczba ValueError",
    ),
    choice(
        "Po jakiej klasie dziedziczy zwykle własny wyjątek?",
        listOf("Exception", "object", "Error", "str"),
        0,
        "Własne wyjątki dziedziczą po Exception.",
    ),
    tiles(
        "Zgłoś wyjątek ZlyWiek z komunikatem \"ujemny\"",
        listOf("raise", "ZlyWiek(", "\"ujemny\"", ")"),
        listOf("throw", "return"),
        "Wyjątki zgłaszamy słowem raise.",
    ),
    output(
        "class A(Exception):\n    pass\n\nclass B(A):\n    pass\n\ntry:\n    raise B(\"x\")\nexcept A:\n    print(\"złapane przez A\")",
        "złapane przez A",
        "B dziedziczy po A, więc except A łapie także B.",
    ),
)
