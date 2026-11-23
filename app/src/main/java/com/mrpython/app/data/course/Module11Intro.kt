package com.mrpython.app.data.course

internal val module11Intro = lesson(
    "u11l0", "Wprowadzenie: klasy i obiekty",
    explain(
        "Klasa i obiekt",
        "Klasa to przepis na nowy rodzaj danych, np. „Pies”. Obiekt to konkretna rzecz utworzona " +
            "według tego przepisu, np. Burek. Klasę tworzysz słowem `class`, a obiekt – wywołując ją jak funkcję.",
        code = "class Pies:\n    pass\n\nburek = Pies()\nprint(type(burek).__name__)",
        output = "Pies",
    ),
    explain(
        "__init__ i self",
        "Metoda `__init__` uruchamia się przy tworzeniu obiektu i zapisuje jego dane. " +
            "`self` to ten konkretny obiekt, a `self.imie` – jego atrybut.",
        code = "class Pies:\n    def __init__(self, imie):\n        self.imie = imie\n\np = Pies(\"Burek\")\nprint(p.imie)",
        output = "Burek",
    ),
    explain(
        "Metody",
        "Metoda to funkcja zdefiniowana w klasie. Pierwszym parametrem jest zawsze `self`, " +
            "dzięki czemu metoda ma dostęp do danych obiektu. Wywołujesz ją po kropce.",
        code = "class Prostokat:\n    def __init__(self, a, b):\n        self.a, self.b = a, b\n    def pole(self):\n        return self.a * self.b\nprint(Prostokat(2, 3).pole())",
        output = "6",
    ),
    explain(
        "Czytelny opis: __str__",
        "Metoda `__str__` zwraca napis, który pokaże `print()` dla obiektu. Bez niej zobaczysz " +
            "mało czytelny techniczny opis.",
        code = "class Kot:\n    def __init__(self, imie):\n        self.imie = imie\n    def __str__(self):\n        return \"Kot \" + self.imie\nprint(Kot(\"Mruczek\"))",
        output = "Kot Mruczek",
    ),
    explain(
        "Dziedziczenie",
        "`class Kot(Zwierze)` oznacza, że Kot dziedziczy wszystko po klasie Zwierze. " +
            "Może też nadpisać metodę własną wersją.",
        code = "class Zwierze:\n    def dzwiek(self):\n        return \"...\"\nclass Kot(Zwierze):\n    pass\nprint(Kot().dzwiek())",
        output = "...",
    ),
    choice(
        "Które słowo kluczowe tworzy klasę?",
        listOf("class", "def", "object", "new"),
        0,
        "Klasy definiujemy słowem class.",
    ),
    output(
        "class Punkt:\n    def __init__(self, x):\n        self.x = x\n\np = Punkt(4)\nprint(p.x * 2)",
        "8",
        "Atrybut p.x ma wartość 4.",
    ),
    fill(
        "Uzupełnij, aby zapisać imię w obiekcie.",
        "class Osoba:\n    def __init__(self, imie):\n        ____.imie = imie\n\no = Osoba(\"Ala\")\nprint(o.imie)",
        listOf("self", "this", "imie"),
        "self",
        "Dane obiektu zapisujemy przez self.",
    ),
)
