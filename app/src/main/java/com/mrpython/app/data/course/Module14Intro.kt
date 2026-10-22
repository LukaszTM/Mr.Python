package com.mrpython.app.data.course

internal val module14Intro = lesson(
    "u14l0", "Wprowadzenie: struktury zagnieżdżone",
    explain(
        "Lista w liście",
        "Element listy może być… kolejną listą. Taka lista list działa jak tabela: każda wewnętrzna " +
            "lista to wiersz. Pierwszy indeks wybiera wiersz, drugi – element w tym wierszu.",
        code = "m = [[1, 2, 3], [4, 5, 6]]\nprint(m[0])\nprint(m[1][2])",
        output = "[1, 2, 3]\n6",
    ),
    explain(
        "Lista słowników",
        "Gdy opisujemy wiele podobnych rzeczy, np. osoby, każdą zapisujemy jako słownik, a wszystkie " +
            "trzymamy w liście. `osoby[0]` to słownik, a `osoby[0][\"imie\"]` – wartość z niego.",
        code = "osoby = [{\"imie\": \"Ala\"}, {\"imie\": \"Bob\"}]\nprint(osoby[1][\"imie\"])",
        output = "Bob",
    ),
    explain(
        "Słownik list",
        "Wartością w słowniku może być lista, np. lista ocen ucznia. Najpierw podajesz klucz, potem " +
            "indeks – i możesz używać metod listy, takich jak `append()`.",
        code = "oceny = {\"Ala\": [5, 4]}\noceny[\"Ala\"].append(3)\nprint(oceny[\"Ala\"][0], oceny)",
        output = "5 {'Ala': [5, 4, 3]}",
    ),
    explain(
        "Pętla w pętli",
        "Żeby przejść po każdym elemencie listy list, używamy dwóch pętli: zewnętrzna daje wiersze, " +
            "a wewnętrzna – liczby w danym wierszu.",
        code = "m = [[1, 2], [3, 4]]\nfor wiersz in m:\n    for x in wiersz:\n        print(x, end=\" \")",
        output = "1 2 3 4 ",
    ),
    explain(
        "Kopia płytka i głęboka",
        "`b = a` nie kopiuje listy – to druga nazwa tego samego obiektu. `a.copy()` kopiuje tylko listę " +
            "zewnętrzną (kopia płytka), a `copy.deepcopy(a)` kopiuje też wszystko w środku.",
        code = "import copy\na = [[1], [2]]\nb = copy.deepcopy(a)\nb[0].append(9)\nprint(a)",
        output = "[[1], [2]]",
    ),
    output(
        "m = [[7, 8], [9, 10]]\nprint(m[1][0])",
        "9",
        "m[1] to wiersz [9, 10], a [0] to jego pierwszy element.",
    ),
    choice(
        "Jak odczytać wiek pierwszej osoby?",
        listOf("osoby[0][\"wiek\"]", "osoby[\"wiek\"][0]", "osoby.wiek[0]", "osoby[0].wiek"),
        0,
        "Najpierw indeks listy, potem klucz słownika.",
        code = "osoby = [{\"wiek\": 20}, {\"wiek\": 30}]",
    ),
    choice(
        "Co robi b = a, gdy a jest listą?",
        listOf("Daje drugą nazwę tej samej liście", "Tworzy kopię głęboką", "Tworzy pustą listę", "Usuwa listę a"),
        0,
        "Przypisanie nie kopiuje – obie nazwy wskazują ten sam obiekt.",
    ),
)
