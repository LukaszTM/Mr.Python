package com.mrpython.app.data.course

internal val module34Intro = lesson(
    "u34l0", "Wprowadzenie: dataclasses",
    explain(
        "Klasa danych",
        "Wiele klas tylko przechowuje dane, a pisanie `__init__` za każdym razem jest nudne. " +
            "Dekorator `@dataclass` z modułu `dataclasses` robi to za nas: wystarczy wypisać pola w postaci `nazwa: typ`.",
        code = "from dataclasses import dataclass\n\n@dataclass\nclass Punkt:\n    x: int\n    y: int\n\nprint(Punkt(1, 2))",
        output = "Punkt(x=1, y=2)",
    ),
    explain(
        "Co dostajemy za darmo",
        "`@dataclass` tworzy `__init__`, czytelne `__repr__` i `__eq__`, które porównuje pola. " +
            "Typy przy polach to tylko podpowiedzi – Python ich nie sprawdza. Pola to zwykłe atrybuty.",
        code = "from dataclasses import dataclass\n\n@dataclass\nclass Punkt:\n    x: int\n    y: int\n\nprint(Punkt(1, 2) == Punkt(1, 2))",
        output = "True",
    ),
    explain(
        "Wartości domyślne i field",
        "Pole może mieć wartość domyślną, np. `punkty: int = 0` – takie pola piszemy na końcu. " +
            "Dla listy lub słownika użyj `field(default_factory=list)`, by każdy obiekt dostał własną, nową listę.",
        code = "from dataclasses import dataclass, field\n\n@dataclass\nclass Gracz:\n    imie: str\n    punkty: int = 0\n    tagi: list = field(default_factory=list)\n\nprint(Gracz(\"Ola\"))",
        output = "Gracz(imie='Ola', punkty=0, tagi=[])",
    ),
    explain(
        "frozen i order",
        "`@dataclass(frozen=True)` blokuje zmiany pól po utworzeniu – takie obiekty można też wkładać " +
            "do zbioru. `@dataclass(order=True)` dodaje porównania `<` i `>`, więc obiekty da się sortować (pole po polu).",
        code = "from dataclasses import dataclass\n\n@dataclass(order=True)\nclass W:\n    a: int\n    b: int\n\nprint(W(1, 9) < W(2, 0))",
        output = "True",
    ),
    choice(
        "Których metod NIE tworzy samo @dataclass (bez parametrów)?",
        listOf("__lt__ do sortowania", "__init__", "__repr__", "__eq__"),
        0,
        "Porównania < i > pojawiają się dopiero z order=True.",
    ),
    output(
        "from dataclasses import dataclass\n\n@dataclass\nclass Kot:\n    imie: str\n    wiek: int = 1\n\nprint(Kot(\"Mruczek\"))",
        "Kot(imie='Mruczek', wiek=1)",
        "Pominięte pole wiek dostało wartość domyślną 1.",
    ),
    fill(
        "Uzupełnij, aby obiektu nie dało się zmieniać.",
        "from dataclasses import dataclass\n\n@dataclass(____=True)\nclass Kolor:\n    r: int\n\nk = Kolor(255)\ntry:\n    k.r = 0\nexcept AttributeError:\n    print(\"zablokowane\")",
        listOf("frozen", "order", "eq"),
        "frozen",
        "frozen=True zamraża obiekt, więc przypisanie zgłasza błąd.",
    ),
)
