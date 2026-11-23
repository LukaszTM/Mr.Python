package com.mrpython.app.data.course

internal val module60Intro = lesson(
    "u60l0", "Wprowadzenie: trudne wyzwania",
    explain(
        "Mutowalne wartości domyślne",
        "Domyślne `[]` czy `{}` w parametrze powstaje raz, przy definicji funkcji, i jest wspólne " +
            "dla wszystkich wywołań. Bezpieczny wzorzec: `a=None`, a w środku nowa lista, gdy `a is None`.",
        code = "def f(x, a=[]):\n    a.append(x)\n    return a\n\nf(1)\nprint(f(2))",
        output = "[1, 2]",
    ),
    explain(
        "Domknięcia i późne wiązanie",
        "Funkcja wewnętrzna pamięta zmienne z otoczenia, ale odczytuje je dopiero przy wywołaniu – " +
            "dlatego lambdy z pętli widzą ostatnie `i`. Pomaga `lambda i=i: i`, a zmienić zmienną " +
            "z otoczenia pozwala `nonlocal`.",
        code = "fs = [lambda: i for i in range(3)]\nprint([f() for f in fs])\nfs = [lambda i=i: i for i in range(3)]\nprint([f() for f in fs])",
        output = "[2, 2, 2]\n[0, 1, 2]",
    ),
    explain(
        "is kontra ==",
        "`==` sprawdza, czy wartości są równe, a `is` – czy to ten sam obiekt. `+=` zmienia listę " +
            "w miejscu, a `b = b + [x]` tworzy nową. Z `None` porównuj przez `is`.",
        code = "a = [1, 2]\nb = [1, 2]\nprint(a == b, a is b)\nc = a\nc += [3]\nprint(a, a is c)",
        output = "True False\n[1, 2, 3] True",
    ),
    explain(
        "Kopie i iteratory",
        "`[[0] * 2] * 2` powiela tę samą listę wewnętrzną, a płytka kopia dzieli listy zagnieżdżone – " +
            "pełną kopię daje `copy.deepcopy`. Generator, `zip` czy `map` przejdziesz tylko raz.",
        code = "a = [[0] * 2] * 2\na[0][0] = 1\nprint(a)\ng = (x for x in range(3))\nprint(sum(g), sum(g))",
        output = "[[1, 0], [1, 0]]\n3 0",
    ),
    explain(
        "MRO, dekoratory i skróty",
        "Przy wielodziedziczeniu `super()` idzie według kolejności MRO (`Klasa.__mro__`). Dekoratory " +
            "działają od dołu do góry. `and` i `or` liczą tylko tyle, ile trzeba, i zwracają jedną z wartości.",
        code = "print(0 or 2 or 3)\nprint(False and 1 / 0)\nprint(\"\" or \"domyślny\")",
        output = "2\nFalse\ndomyślny",
    ),
    output(
        "a = [1]\nb = a\nb.append(2)\nprint(a is b, a)",
        "True [1, 2]",
        "b to tylko druga nazwa tej samej listy.",
    ),
    output(
        "g = (x for x in [1, 2])\nprint(list(g), list(g))",
        "[1, 2] []",
        "Generator wyczerpuje się po pierwszym przejściu.",
    ),
    choice(
        "Jak zalecane jest sprawdzanie, czy zmienna x to None?",
        listOf("x is None", "x = None", "x === None", "x in None"),
        0,
        "None to jeden obiekt, więc porównujemy go przez is.",
    ),
)
