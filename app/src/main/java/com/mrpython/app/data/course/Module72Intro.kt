package com.mrpython.app.data.course

internal val module72Intro = lesson(
    "u72l0", "Wprowadzenie: egzamin końcowy",
    explain(
        "Jak wygląda egzamin",
        "Egzamin ma sześć części: podstawy, struktury danych, funkcje, obiekty, biblioteka standardowa " +
            "i algorytmy. Pytania są trochę trudniejsze – śledź kod linijka po linijce i zapisuj wartości zmiennych.",
        code = "x = 5\nx += x * 2\nprint(x)",
        output = "15",
    ),
    explain(
        "Pułapka: dwie nazwy, jedna lista",
        "`b = a` nie kopiuje listy – obie nazwy wskazują ten sam obiekt, więc zmiana przez `b` widać w `a`. " +
            "Kopię zrobisz przez `a.copy()` albo `a[:]`.",
        code = "a = [1, 2]\nb = a\nb.append(3)\nprint(a, a is b)",
        output = "[1, 2, 3] True",
    ),
    explain(
        "Pułapka: domyślna lista",
        "Wartość domyślna parametru powstaje raz, przy definicji funkcji. Lista jako domyślna " +
            "„pamięta” poprzednie wywołania – dlatego bezpieczniej użyć `None`.",
        code = "def f(x, lista=[]):\n    lista.append(x)\n    return lista\nf(1)\nprint(f(2))",
        output = "[1, 2]",
    ),
    explain(
        "Pułapka: float",
        "Liczby zmiennoprzecinkowe są przybliżone, więc `0.1 * 3` nie jest dokładnie `0.3`. " +
            "Porównuj po zaokrągleniu albo z tolerancją.",
        code = "print(0.1 * 3 == 0.3)\nprint(round(0.1 * 3, 2) == 0.3)",
        output = "False\nTrue",
    ),
    explain(
        "Pułapka: for z else",
        "Blok `else` przy pętli wykona się tylko wtedy, gdy pętla skończyła się bez `break`. " +
            "Zmienna pętli zostaje po niej z ostatnią wartością.",
        code = "for i in range(3):\n    if i == 5:\n        break\nelse:\n    print(\"bez break\")\nprint(i)",
        output = "bez break\n2",
    ),
    output(
        "a = [1]\nb = a\nb.append(2)\nprint(a)",
        "[1, 2]",
        "a i b to ta sama lista, więc dopisanie przez b zmienia też a.",
    ),
    choice(
        "Kiedy wykona się blok else przy pętli for?",
        listOf("gdy pętla zakończy się bez break", "zawsze po break", "gdy pętla nie wykona ani razu i tylko wtedy", "nigdy"),
        0,
        "else pętli działa tylko przy zakończeniu bez break.",
    ),
)
