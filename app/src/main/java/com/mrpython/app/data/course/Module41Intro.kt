package com.mrpython.app.data.course

internal val module41Intro = lesson(
    "u41l0", "Wprowadzenie: dekoratory",
    explain(
        "Funkcja to obiekt",
        "W Pythonie funkcję można przypisać do zmiennej, przekazać jako argument albo zwrócić " +
            "z innej funkcji. `hej` to sama funkcja, a `hej()` to jej wywołanie.",
        code = "def hej():\n    return \"hej!\"\nf = hej\nprint(f())",
        output = "hej!",
    ),
    explain(
        "Funkcja w funkcji",
        "Funkcja może zdefiniować w środku inną funkcję i zwrócić ją (bez nawiasów). " +
            "Wewnętrzna funkcja działa dopiero wtedy, gdy ją wywołamy.",
        code = "def zrob():\n    def wew():\n        return \"środek\"\n    return wew\ng = zrob()\nprint(g())",
        output = "środek",
    ),
    explain(
        "Czym jest dekorator?",
        "Dekorator to funkcja, która przyjmuje funkcję i zwraca nową – zwykle `wrapper`, który " +
            "dodaje coś przed lub po oryginale. Dzięki temu zmieniasz zachowanie funkcji bez " +
            "zmiany jej kodu.",
        code = "def ozdob(f):\n    def wrapper():\n        print(\"przed\")\n        f()\n    return wrapper",
    ),
    explain(
        "Składnia @",
        "`@ozdob` nad `def` to skrót od `hej = ozdob(hej)`. Gdy wrapper ma zwracać wynik, piszemy " +
            "`return f()`, a `*args` pozwala przyjąć dowolne argumenty.",
        code = "def nawias(f):\n    def w(): return \"[\" + f() + \"]\"\n    return w\n@nawias\ndef imie(): return \"Ola\"\nprint(imie())",
        output = "[Ola]",
    ),
    explain(
        "Argumenty i łączenie",
        "Dekorator z argumentem, np. `@powtorz(3)`, to fabryka: `powtorz(3)` zwraca dekorator. " +
            "Kilka dekoratorów nad jedną funkcją działa od dołu: `@a` nad `@b` to `x = a(b(x))`.",
        code = "def a(f): return lambda: \"a\" + f()\ndef b(f): return lambda: \"b\" + f()\n@a\n@b\ndef x(): return \"x\"\nprint(x())",
        output = "abx",
    ),
    choice(
        "Któremu zapisowi odpowiada @log nad def hej()?",
        listOf("hej = log(hej)", "log = hej(log)", "hej = log()", "log(hej())"),
        0,
        "Składnia @ to skrót tego przypisania.",
    ),
    output(
        "def podwoj(f):\n    def w():\n        return f() * 2\n    return w\n@podwoj\ndef liczba():\n    return 5\nprint(liczba())",
        "10",
        "wrapper podwaja wynik oryginalnej funkcji.",
    ),
    fill(
        "Uzupełnij, aby dekorator zwracał funkcję opakowującą.",
        "def ozdob(f):\n    def wrapper():\n        return f()\n    return ____\n@ozdob\ndef hej():\n    return 1\nprint(hej())",
        listOf("wrapper", "wrapper()", "f()", "None"),
        "wrapper",
        "Dekorator zwraca obiekt funkcji wrapper, bez nawiasów.",
    ),
)
