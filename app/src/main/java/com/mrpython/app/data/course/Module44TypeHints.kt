package com.mrpython.app.data.course

import com.mrpython.app.domain.CourseUnit

internal val module44 = CourseUnit(
    id = "u44",
    title = "Adnotacje typów",
    description = "Podpowiedzi typów dla zmiennych i funkcji",
    lessons = listOf(
        lesson(
            "u44l1", "Podstawowe adnotacje",
            output(
                "wiek: int = 30\nimie: str = \"Ola\"\nprint(imie, wiek)",
                "Ola 30",
                "Adnotacja po dwukropku opisuje typ zmiennej, nie zmienia jej wartości.",
            ),
            output(
                "def dodaj(a: int, b: int) -> int:\n    return a + b\nprint(dodaj(2, 3))",
                "5",
                "-> int opisuje typ wyniku funkcji.",
            ),
            choice(
                "Co oznacza zapis def f(x: str) -> bool?",
                listOf("f przyjmuje napis i zwraca wartość logiczną", "f przyjmuje wartość logiczną i zwraca napis", "f zamienia str na bool", "To błąd składni"),
                0,
                "Adnotacja parametru jest po dwukropku, a typ wyniku po strzałce.",
            ),
            output(
                "liczby: list[int] = [1, 2, 3]\nprint(sum(liczby))",
                "6",
                "list[int] oznacza listę liczb całkowitych.",
            ),
            fill(
                "Uzupełnij adnotację: słownik z kluczami-napisami i wartościami-liczbami.",
                "oceny: dict[str, ____] = {\"Ola\": 5}\nprint(oceny[\"Ola\"])",
                listOf("int", "str", "list", "bool"),
                "int",
                "dict[str, int] – klucz to str, wartość to int.",
            ),
            choice(
                "Która adnotacja pasuje do [\"a\", \"b\"]?",
                listOf("list[str]", "list[int]", "dict[str]", "str[list]"),
                0,
                "To lista napisów.",
            ),
            tiles(
                "Zapisz nagłówek funkcji pole przyjmującej float i zwracającej float",
                listOf("def", "pole(r:", "float)", "->", "float:"),
                listOf("=>", "int:"),
                "Typ wyniku podajemy po strzałce ->.",
            ),
        ),
        lesson(
            "u44l2", "Optional i X | None",
            output(
                "def znajdz(s: str) -> int | None:\n    if \"a\" in s:\n        return s.index(\"a\")\n    return None\nprint(znajdz(\"kot\"), znajdz(\"mama\"))",
                "None 1",
                "int | None oznacza: liczba albo None.",
            ),
            choice(
                "Co oznacza adnotacja int | None?",
                listOf("Wartość może być liczbą całkowitą albo None", "Liczba całkowita różna od zera", "Bitowe OR liczby i None", "Pusta liczba"),
                0,
                "Pionowa kreska w adnotacji oznacza „jeden z tych typów”.",
            ),
            output(
                "from typing import Optional\ndef imie(x: Optional[str] = None) -> str:\n    return x or \"gość\"\nprint(imie(), imie(\"Ala\"))",
                "gość Ala",
                "Optional[str] to to samo co str | None.",
            ),
            fill(
                "Uzupełnij, aby adnotacja znaczyła „napis albo None”.",
                "def opis(x: str | ____ = None) -> str:\n    return \"brak\" if x is None else x\nprint(opis())",
                listOf("None", "Null", "nil", "empty"),
                "None",
                "W Pythonie brak wartości to None.",
            ),
            choice(
                "Który zapis jest równoważny Optional[int]?",
                listOf("int | None", "int | 0", "list[int]", "int or None"),
                0,
                "Optional[X] to skrót od X | None.",
            ),
            output(
                "def dziel(a: int, b: int) -> float | None:\n    if b == 0:\n        return None\n    return a / b\nprint(dziel(6, 4), dziel(1, 0))",
                "1.5 None",
                "Przy dzieleniu przez zero funkcja zwraca None.",
            ),
            tiles(
                "Zadeklaruj zmienną wynik typu int albo None z wartością None",
                listOf("wynik:", "int", "|", "None", "=", "None"),
                listOf("or", "->"),
                "Typ opcjonalny zapisujemy przez pionową kreskę.",
            ),
        ),
        lesson(
            "u44l3", "Adnotacje w czasie działania",
            output(
                "def dodaj(a: int, b: int) -> int:\n    return a + b\nprint(dodaj(\"ab\", \"c\"))",
                "abc",
                "Python nie sprawdza adnotacji – napisy po prostu się skleją.",
            ),
            output(
                "x: int = \"tekst\"\nprint(x)",
                "tekst",
                "Adnotacja nie blokuje przypisania innego typu.",
            ),
            choice(
                "Co się stanie, gdy do funkcji z adnotacją int przekażemy napis?",
                listOf("Python wykona kod normalnie – adnotacje nie są sprawdzane", "TypeError od razu przy wywołaniu", "Napis zostanie zamieniony na int", "SyntaxError"),
                0,
                "Adnotacje to podpowiedzi dla ludzi i narzędzi (np. mypy), nie reguły.",
            ),
            output(
                "def f(x: int) -> str:\n    return str(x)\nprint(f.__annotations__[\"return\"].__name__)",
                "str",
                "Typ wyniku jest zapisany pod kluczem \"return\".",
            ),
            output(
                "def f(a: int, b: str):\n    pass\nprint(list(f.__annotations__))",
                "['a', 'b']",
                "__annotations__ to słownik: nazwa parametru → typ.",
            ),
            fill(
                "Uzupełnij, aby odczytać adnotacje funkcji f.",
                "def f(x: int) -> int:\n    return x\nprint(len(f.____))",
                listOf("__annotations__", "__types__", "annotations", "types"),
                "__annotations__",
                "Adnotacje są w atrybucie __annotations__.",
            ),
            choice(
                "Do czego służą narzędzia takie jak mypy?",
                listOf("Sprawdzają zgodność typów bez uruchamiania programu", "Uruchamiają program szybciej", "Formatują kod", "Instalują biblioteki"),
                0,
                "mypy analizuje adnotacje i wykrywa błędy typów przed uruchomieniem.",
            ),
        ),
        lesson(
            "u44l4", "Powtórka: adnotacje typów",
            output(
                "def powtorz(s: str, n: int = 2) -> str:\n    return s * n\nprint(powtorz(\"ha\"))",
                "haha",
                "Adnotacja i wartość domyślna mogą występować razem.",
            ),
            output(
                "def srednia(dane: list[float]) -> float:\n    return sum(dane) / len(dane)\nprint(srednia([2.0, 4.0]))",
                "3.0",
                "list[float] to lista liczb zmiennoprzecinkowych.",
            ),
            output(
                "def f(x: int) -> int:\n    return x * 2\nprint(f(\"ab\"))",
                "abab",
                "Adnotacji nikt nie sprawdza – \"ab\" * 2 to „abab”.",
            ),
            choice(
                "Która adnotacja pasuje do {\"a\": [1, 2]}?",
                listOf("dict[str, list[int]]", "dict[list, int]", "list[dict]", "dict[str, int]"),
                0,
                "Klucz to napis, wartość to lista liczb.",
            ),
            fill(
                "Uzupełnij typ wyniku: funkcja zwraca True albo False.",
                "def parzysta(n: int) -> ____:\n    return n % 2 == 0\nprint(parzysta.__annotations__[\"return\"].__name__)",
                listOf("bool", "int", "str", "None"),
                "bool",
                "Wynik porównania to bool.",
            ),
            output(
                "def f(a: int, b: float) -> None:\n    pass\nprint(len(f.__annotations__))",
                "3",
                "Słownik zawiera a, b oraz return.",
            ),
            tiles(
                "Zapisz nagłówek funkcji suma przyjmującej listę liczb całkowitych i zwracającej int",
                listOf("def", "suma(x:", "list[int])", "->", "int:"),
                listOf("list<int>)", "=>"),
                "Typ elementów listy podajemy w nawiasach kwadratowych.",
            ),
        ),
    ),
)
