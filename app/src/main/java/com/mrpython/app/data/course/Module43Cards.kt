package com.mrpython.app.data.course

internal val module43Cards = listOf(
    cards(
        "u43l1",
        explain(
            "Przypisanie robi zmienną lokalną",
            "Jeśli funkcja gdziekolwiek przypisuje `x = ...`, to `x` jest lokalne w całej funkcji. " +
                "Odczyt przed tym przypisaniem daje `UnboundLocalError`, nawet gdy istnieje globalne `x`.",
            code = "x = 1\ndef f():\n    print(x)\n    x = 2\ntry: f()\nexcept UnboundLocalError: print(\"błąd\")",
            output = "błąd",
        ),
        explain(
            "Przesłanianie wbudowanych",
            "Zmienna lokalna o nazwie wbudowanej, np. `len`, zasłania ją tylko w tej funkcji. " +
                "Poza funkcją `len` działa normalnie.",
            code = "def f():\n    len = 99\n    return len\nprint(f(), len(\"ab\"))",
            output = "99 2",
        ),
    ),
    cards(
        "u43l2",
        explain(
            "Zmiana obiektu to nie przypisanie",
            "`global` i `nonlocal` są potrzebne tylko przy przypisaniu (`=`, `+=`). Metody takie jak " +
                "`append` zmieniają istniejący obiekt, więc działają bez deklaracji.",
            code = "lista = []\ndef dodaj(x):\n    lista.append(x)\ndodaj(1); dodaj(2)\nprint(lista)",
            output = "[1, 2]",
        ),
        explain(
            "Gdzie działa nonlocal",
            "`nonlocal` działa tylko w funkcji zagnieżdżonej, gdy zmienna istnieje w funkcji " +
                "otaczającej – inaczej jest `SyntaxError`. `global` może nawet utworzyć nową zmienną modułu.",
            code = "def f():\n    global nowa\n    nowa = \"jestem\"\nf()\nprint(nowa)",
            output = "jestem",
        ),
    ),
    cards(
        "u43l3",
        explain(
            "Domknięcie ze stanem",
            "Z `nonlocal` domknięcie może zmieniać zapamiętaną zmienną między wywołaniami. Każde " +
                "wywołanie fabryki tworzy osobny stan.",
            code = "def licznik():\n    n = 0\n    def f():\n        nonlocal n; n += 1; return n\n    return f\na = licznik(); a(); print(a(), licznik()())",
            output = "2 1",
        ),
    ),
    cards(
        "u43l4",
        explain(
            "Nazwa szukana przy wywołaniu",
            "Funkcja odczytuje wartość zmiennej dopiero, gdy ją wywołasz, a nie gdy ją tworzysz. " +
                "Dlatego `y` może powstać po `def`. Własną kopię wartości daje nowy zasięg, np. " +
                "osobne wywołanie fabryki.",
            code = "def f():\n    return y\ny = 5\nprint(f())",
            output = "5",
        ),
    ),
)
