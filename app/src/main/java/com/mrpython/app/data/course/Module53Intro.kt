package com.mrpython.app.data.course

internal val module53Intro = lesson(
    "u53l0", "Wprowadzenie: debugowanie",
    explain(
        "Błąd o jeden",
        "`range(1, 5)` kończy się na 4, a ostatni indeks listy to `len(lista) - 1`. Pomyłka o jeden " +
            "to najczęstszy błąd w pętlach – zawsze sprawdź pierwszą i ostatnią wartość.",
        code = "print(list(range(1, 5)))\nlista = [10, 20, 30]\nprint(lista[len(lista) - 1])",
        output = "[1, 2, 3, 4]\n30",
    ),
    explain(
        "= czy ==?",
        "`=` przypisuje wartość, a `==` porównuje – w warunku `if` potrzebujesz `==`. Uważaj też na " +
            "wcięcia: `print` wcięty w pętli wykona się przy każdym obrocie, a bez wcięcia – raz, po pętli.",
        code = "suma = 0\nfor x in [1, 2, 3]:\n    suma += x\nprint(suma == 6)",
        output = "True",
    ),
    explain(
        "Pułapki z listami",
        "Domyślna lista w parametrze (`lista=[]`) powstaje raz i jest wspólna dla wszystkich wywołań – " +
            "bezpieczniej dać `None`. Nie usuwaj też elementów z listy, po której iterujesz; idź po kopii `[:]`.",
        code = "def dodaj(x, lista=[]):\n    lista.append(x)\n    return lista\n\ndodaj(1)\nprint(dodaj(2))",
        output = "[1, 2]",
    ),
    explain(
        "Nie zasłaniaj nazw wbudowanych",
        "Zmienna o nazwie `list`, `sum` czy `max` zasłania funkcję wbudowaną – jej wywołanie kończy się " +
            "potem `TypeError`. Używaj własnych nazw, np. `suma` albo `lista`.",
        code = "sum = 10\ntry:\n    print(sum([1, 2]))\nexcept TypeError:\n    print(\"sum jest zasłonięte\")",
        output = "sum jest zasłonięte",
    ),
    explain(
        "Dzielenie i brakujący return",
        "`/` daje wynik z ułamkiem, a `//` go obcina – do średniej używaj `/`. A gdy funkcja " +
            "zwraca `None`, sprawdź, czy nie brakuje w niej `return`.",
        code = "def podwoj(x):\n    wynik = x * 2\n\nprint(7 / 2, 7 // 2)\nprint(podwoj(5))",
        output = "3.5 3\nNone",
    ),
    output(
        "print(list(range(2, 5)))",
        "[2, 3, 4]",
        "Koniec zakresu, czyli 5, nie wchodzi do wyniku.",
    ),
    choice(
        "Który zapis poprawnie sprawdza, czy x jest równe 5?",
        listOf("if x == 5:", "if x = 5:", "if x === 5:"),
        0,
        "Porównanie to ==; = jest przypisaniem, a === nie istnieje w Pythonie.",
    ),
    fill(
        "Uzupełnij, aby funkcja oddawała wynik do miejsca wywołania.",
        "def kw(x):\n    ____ x * x\n\nprint(kw(3))",
        listOf("return", "print", "pass"),
        "return",
        "Tylko return oddaje wynik; z print funkcja i tak zwróciłaby None.",
    ),
)
