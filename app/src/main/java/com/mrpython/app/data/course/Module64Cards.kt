package com.mrpython.app.data.course

internal val module64Cards = listOf(
    cards(
        "u64l4",
        explain(
            "__call__ – obiekt jak funkcja",
            "Metoda `__call__` pozwala wywołać obiekt z nawiasami, jak funkcję: `obiekt(x)` uruchamia " +
                "`obiekt.__call__(x)`. Obiekt przy tym pamięta swój stan w atrybutach.",
            code = "class Razy:\n    def __init__(self, k):\n        self.k = k\n    def __call__(self, x):\n        return x * self.k\nprint(Razy(3)(5))",
            output = "15",
        ),
        explain(
            "__iter__ – obiekt w pętli",
            "Pętla `for` i `list()` wołają `__iter__`, który zwraca iterator – najprościej `iter()` z listy " +
                "w środku. Bez `__iter__` Python próbuje `__getitem__` z indeksami 0, 1, 2… aż do `IndexError`.",
            code = "class Kolejka:\n    def __init__(self):\n        self.osoby = [\"Ola\", \"Jan\"]\n    def __iter__(self):\n        return iter(self.osoby)\nprint(list(Kolejka()))",
            output = "['Ola', 'Jan']",
        ),
    ),
)
