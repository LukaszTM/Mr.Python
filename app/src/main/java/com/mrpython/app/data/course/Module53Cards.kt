package com.mrpython.app.data.course

internal val module53Cards = listOf(
    cards(
        "u53l1",
        explain(
            "Ile liczb daje range?",
            "`range(a, b)` daje dokładnie `b - a` liczb, bo `b` nie wchodzi do wyniku. Z krokiem liczymy " +
                "kolejne wartości: `range(10, 20, 2)` to 10, 12, 14, 16, 18 – pięć liczb.",
            code = "print(len(range(2, 10)))\nprint(list(range(10, 20, 2)))",
            output = "8\n[10, 12, 14, 16, 18]",
        ),
        explain(
            "Błąd płotu",
            "Płot długości 10 m ze słupkami co 1 m (także na obu końcach) ma 11 słupków, nie 10. " +
                "Gdy liczysz punkty od–do włącznie, dodaj 1 – stąd `range(0, 101, 10)`.",
            code = "print(len(range(0, 101, 10)))",
            output = "11",
        ),
    ),
    cards(
        "u53l2",
        explain(
            "return za wcześnie",
            "`return` od razu kończy funkcję. Jeśli `return False` stoi w pętli, funkcja sprawdzi tylko " +
                "pierwszy element. „Nie znaleziono” zwracamy dopiero po pętli, bez wcięcia pod `for`.",
            code = "def szukaj(lista, cel):\n    for x in lista:\n        if x == cel:\n            return \"jest\"\n    return \"brak\"\nprint(szukaj([1, 2, 3], 3))",
            output = "jest",
        ),
        explain(
            "Porównanie nic nie zmienia",
            "Samo `x == 20` w osobnej linii tylko liczy `True`/`False` i nic nie zmienia. Podobnie " +
                "`suma = x` w pętli nadpisuje sumę zamiast do niej dodawać – potrzebne jest `+=`.",
            code = "x = 10\nx == 20\nprint(x)",
            output = "10",
        ),
    ),
    cards(
        "u53l3",
        explain(
            "Metody zwracają None",
            "`append()`, `sort()` czy `clear()` zmieniają listę w miejscu i zwracają `None`. Zapis " +
                "`x = x.sort()` gubi więc listę. Posortowaną kopię daje `sorted(x)`.",
            code = "x = [3, 1, 2]\nwynik = x.sort()\nprint(wynik, x)",
            output = "None [1, 2, 3]",
        ),
        explain(
            "Bezpieczne usuwanie",
            "Najprościej usunąć elementy, budując nową listę wyrażeniem listowym z warunkiem. " +
                "Zostają tylko te elementy, które chcemy zachować.",
            code = "liczby = [1, 1, 2, 3]\nliczby = [x for x in liczby if x != 1]\nprint(liczby)",
            output = "[2, 3]",
        ),
        explain(
            "Ta sama lista dwa razy",
            "`[wiersz, wiersz]` wkłada do siatki dwa razy tę samą listę – zmiana w jednym wierszu widać " +
                "w obu. Osobne wiersze tworzy wyrażenie listowe: `[[0] * 2 for _ in range(2)]`.",
            code = "siatka = [[0] * 2 for _ in range(2)]\nsiatka[0][0] = 1\nprint(siatka)",
            output = "[[1, 0], [0, 0]]",
        ),
    ),
    cards(
        "u53l4",
        explain(
            "del przywraca nazwę",
            "Gdy zasłonisz funkcję wbudowaną zmienną, `del nazwa` usuwa tę zmienną i znów widać " +
                "oryginalną funkcję.",
            code = "max = 5\ndel max\nprint(max(1, 2))",
            output = "2",
        ),
        explain(
            "Zasłonięcie w funkcji",
            "Zmienna `sum` utworzona wewnątrz funkcji jest lokalna – zasłania wbudowane `sum` tylko " +
                "w tej funkcji. Poza nią `sum()` działa normalnie.",
            code = "def f():\n    sum = 10\n    return sum\n\nprint(f(), sum([1, 2]))",
            output = "10 3",
        ),
    ),
    cards(
        "u53l5",
        explain(
            "// zaokrągla w dół",
            "`//` zawsze zaokrągla w dół, w stronę mniejszej liczby. Dla liczb ujemnych daje więc " +
                "„o jeden więcej w minus”: `-7 // 2` to -4. Z kolei `int()` po prostu obcina część ułamkową.",
            code = "print(7 // 2, -7 // 2)\nprint(int(-3.5))",
            output = "3 -4\n-3",
        ),
        explain(
            "print to nie return",
            "`print` tylko pokazuje wartość na ekranie – funkcja bez `return` i tak zwraca `None`. " +
                "Dalsze liczenie na takim wyniku, np. `None * 2`, kończy się `TypeError`.",
            code = "def dodaj(a, b):\n    print(a + b)\n\nx = dodaj(2, 3)\nprint(x)",
            output = "5\nNone",
        ),
    ),
)
