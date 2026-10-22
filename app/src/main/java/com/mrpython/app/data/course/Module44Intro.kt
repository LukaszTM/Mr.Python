package com.mrpython.app.data.course

internal val module44Intro = lesson(
    "u44l0", "Wprowadzenie: adnotacje typów",
    explain(
        "Czym są adnotacje?",
        "Adnotacja typu to podpowiedź, jakiego typu ma być zmienna. Piszemy ją po dwukropku: " +
            "`wiek: int = 30`. Nie zmienia wartości – pomaga ludziom i edytorom zrozumieć kod.",
        code = "wiek: int = 30\nimie: str = \"Ola\"\nprint(imie, wiek)",
        output = "Ola 30",
    ),
    explain(
        "Adnotacje w funkcjach",
        "W funkcji typ parametru piszemy po dwukropku, a typ wyniku po strzałce `->`. Od razu " +
            "widać, co funkcja przyjmuje i co zwraca.",
        code = "def dodaj(a: int, b: int) -> int:\n    return a + b\nprint(dodaj(2, 3))",
        output = "5",
    ),
    explain(
        "Typy kolekcji",
        "Dla kolekcji podajemy typ elementów w nawiasach kwadratowych: `list[int]` to lista liczb, " +
            "a `dict[str, int]` to słownik z kluczami-napisami i wartościami-liczbami.",
        code = "liczby: list[int] = [1, 2, 3]\noceny: dict[str, int] = {\"Ola\": 5}\nprint(sum(liczby), oceny[\"Ola\"])",
        output = "6 5",
    ),
    explain(
        "Optional i X | None",
        "Gdy wartość może być typu X albo `None`, piszemy `X | None`. Starszy, równoważny zapis " +
            "to `Optional[X]` z modułu `typing`.",
        code = "def znajdz(s: str) -> int | None:\n    if \"a\" in s:\n        return s.index(\"a\")\n    return None\nprint(znajdz(\"kot\"), znajdz(\"mama\"))",
        output = "None 1",
    ),
    explain(
        "Python ich nie sprawdza",
        "Podczas działania Python ignoruje adnotacje – zły typ nie da błędu. Błędy typów wykrywają " +
            "narzędzia takie jak mypy, bez uruchamiania programu. Adnotacje są dostępne w " +
            "słowniku `__annotations__`.",
        code = "def f(x: int) -> int:\n    return x * 2\nprint(f(\"ab\"))\nprint(list(f.__annotations__))",
        output = "abab\n['x', 'return']",
    ),
    choice(
        "Co oznacza zapis def f(x: str) -> bool?",
        listOf("f przyjmuje napis i zwraca wartość logiczną", "f przyjmuje bool i zwraca napis", "f zamienia str na bool", "To błąd składni"),
        0,
        "Typ parametru jest po dwukropku, a typ wyniku po strzałce.",
    ),
    output(
        "x: int = \"tekst\"\nprint(x)",
        "tekst",
        "Adnotacja nie blokuje przypisania innego typu.",
    ),
    tiles(
        "Zapisz nagłówek funkcji pole przyjmującej float i zwracającej float",
        listOf("def", "pole(r:", "float)", "->", "float:"),
        listOf("=>", "int:"),
        "Typ wyniku podajemy po strzałce ->.",
    ),
)
