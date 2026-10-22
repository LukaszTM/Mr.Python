package com.mrpython.app.data.course

internal val module19Cards = listOf(
    cards(
        "u19l1",
        explain(
            "Porównanie łańcuchowe",
            "Zapis `1 <= x <= 6` sprawdza, czy x leży między 1 a 6 – to skrót od `1 <= x and x <= 6`. " +
                "Przydaje się, gdy wynik jest losowy, ale znamy jego zakres.",
            code = "x = 4\nprint(1 <= x <= 6, 5 <= x <= 9)",
            output = "True False",
        ),
        explain(
            "Granice randint",
            "Gdy obie granice są równe, `randint(5, 5)` zawsze zwróci 5. Pierwsza granica nie może " +
                "być większa od drugiej – `randint(5, 1)` to błąd `ValueError`.",
            code = "import random\nprint(random.randint(5, 5))",
            output = "5",
        ),
    ),
    cards(
        "u19l2",
        explain(
            "sample zwraca listę",
            "`random.choice()` działa też na napisie i zwraca jedną literę. `random.sample()` zawsze " +
                "zwraca nową listę – nawet gdy losuje z napisu albo z `range`. Oryginał się nie zmienia.",
            code = "import random\nx = random.sample(\"ab\", 2)\nprint(type(x), sorted(x))",
            output = "<class 'list'> ['a', 'b']",
        ),
        explain(
            "Nie przypisuj shuffle",
            "`shuffle` zwraca `None`, więc zapis `l = random.shuffle(l)` zgubi listę! Wywołuj " +
                "`shuffle` w osobnej linii i dalej używaj tej samej zmiennej.",
            code = "import random\nl = [1, 2, 3]\nrandom.shuffle(l)\nprint(len(l))",
            output = "3",
        ),
    ),
    cards(
        "u19l3",
        explain(
            "Błędy losowania",
            "Nie da się wylosować więcej różnych elementów, niż jest w liście – `sample` zgłosi wtedy " +
                "`ValueError`. `choice` na pustej liście daje `IndexError`.",
            code = "import random\ntry:\n    random.sample([1], 2)\nexcept ValueError:\n    print(\"za mało\")",
            output = "za mało",
        ),
        explain(
            "Podzbiór: <=",
            "Dla zbiorów `a <= b` sprawdza, czy każdy element `a` jest też w `b`. Tak łatwo sprawdzisz, " +
                "czy losowe wyniki pochodzą z dozwolonej puli.",
            code = "print({1, 2} <= {1, 2, 3})\nprint({1, 4} <= {1, 2, 3})",
            output = "True\nFalse",
        ),
    ),
)
