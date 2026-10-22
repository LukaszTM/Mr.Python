package com.mrpython.app.data.course

internal val module44Cards = listOf(
    cards(
        "u44l1",
        explain(
            "Krotki i zbiory",
            "`tuple[str, int]` opisuje każdą pozycję krotki po kolei: tu napis, a potem liczba. " +
                "`set[int]` to zbiór liczb całkowitych.",
            code = "para: tuple[str, int] = (\"x\", 7)\ntagi: set[int] = {3, 1}\nprint(para[1] + 1, sorted(tagi))",
            output = "8 [1, 3]",
        ),
        explain(
            "Funkcja bez wyniku: -> None",
            "`-> None` oznacza, że funkcja niczego nie zwraca – tylko coś robi, np. wypisuje. " +
                "Wynik jej wywołania to `None`.",
            code = "def info() -> None:\n    print(\"hej\")\nx = info()\nprint(x)",
            output = "hej\nNone",
        ),
    ),
    cards(
        "u44l2",
        explain(
            "Kilka typów naraz",
            "Kreska `|` w adnotacji znaczy „albo”: `int | str` to liczba albo napis. `X | None` " +
                "to tylko szczególny przypadek tego zapisu.",
            code = "def tekst(x: int | str) -> str:\n    return str(x) * 2\nprint(tekst(4), tekst(\"a\"))",
            output = "44 aa",
        ),
        explain(
            "Sprawdzanie None",
            "Gdy wartość może być `None`, sprawdzamy to przez `is None` przed jej użyciem. Parametr " +
                "opcjonalny często ma domyślnie `None`.",
            code = "def wiek(x: int | None = None) -> str:\n    if x is None:\n        return \"nieznany\"\n    return str(x)\nprint(wiek(), wiek(30))",
            output = "nieznany 30",
        ),
    ),
    cards(
        "u44l3",
        explain(
            "Słownik __annotations__",
            "Kluczami są nazwy parametrów i `\"return\"`, a wartościami same typy. `.__name__` daje " +
                "nazwę typu jako napis. Parametrów bez adnotacji w słowniku nie ma.",
            code = "def f(a, b: int) -> str:\n    pass\nprint(list(f.__annotations__))\nprint(f.__annotations__[\"return\"].__name__)",
            output = "['b', 'return']\nstr",
        ),
    ),
    cards(
        "u44l4",
        explain(
            "Adnotacja z wartością domyślną",
            "Adnotację i wartość domyślną łączymy tak: najpierw typ po dwukropku, potem `=` i wartość.",
            code = "def powtorz(s: str, n: int = 2) -> str:\n    return s * n\nprint(powtorz(\"ha\"))",
            output = "haha",
        ),
        explain(
            "Typy zagnieżdżone",
            "Typy można zagnieżdżać: `dict[str, list[int]]` to słownik, którego wartościami są listy " +
                "liczb, a `list[tuple[str, int]]` to lista krotek.",
            code = "m: dict[str, list[int]] = {\"a\": [1, 2]}\np: list[tuple[str, int]] = [(\"x\", 1)]\nprint(sum(m[\"a\"]), p[0][0])",
            output = "3 x",
        ),
    ),
)
