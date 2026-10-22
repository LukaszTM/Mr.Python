package com.mrpython.app.data.course

internal val module5Intro = lesson(
    "u5l0", "Wprowadzenie: listy",
    explain(
        "Czym jest lista?",
        "Lista przechowuje wiele wartości w jednej zmiennej. Elementy wpisujemy w nawiasy kwadratowe " +
            "`[]`, oddzielając przecinkami. Każdy element ma numer (indeks) liczony od 0, a -1 to ostatni.",
        code = "owoce = [\"jabłko\", \"banan\", \"kiwi\"]\nprint(owoce[0])\nprint(owoce[-1])",
        output = "jabłko\nkiwi",
    ),
    explain(
        "Dodawanie i długość",
        "`append()` dopisuje element na koniec listy, a `len()` mówi, ile elementów zawiera. " +
            "Element możesz też podmienić przez indeks.",
        code = "x = [1, 2]\nx.append(3)\nx[0] = 9\nprint(x)\nprint(len(x))",
        output = "[9, 2, 3]\n3",
    ),
    explain(
        "Wycinki i sortowanie",
        "Zapis `x[1:3]` wycina elementy od indeksu 1 do 3 (bez 3). Metoda `sort()` sortuje listę " +
            "na miejscu, a `sum()`, `min()` i `max()` liczą od razu na całej liście.",
        code = "x = [5, 1, 4, 2]\nprint(x[1:3])\nx.sort()\nprint(x)\nprint(sum(x))",
        output = "[1, 4]\n[1, 2, 4, 5]\n12",
    ),
    explain(
        "Usuwanie i wstawianie",
        "`pop()` usuwa ostatni element i go zwraca, `remove(w)` usuwa pierwszy element o wartości `w`, " +
            "a `insert(i, w)` wstawia `w` na pozycję `i`.",
        code = "x = [\"a\", \"b\", \"c\"]\nprint(x.pop())\nx.insert(0, \"z\")\nprint(x)",
        output = "c\n['z', 'a', 'b']",
    ),
    explain(
        "Listy i pętle",
        "Pętla `for` przechodzi po kolei po elementach listy. Pustą listę `[]` można wypełniać " +
            "w pętli za pomocą `append()`.",
        code = "wyniki = []\nfor n in [1, 2, 3]:\n    wyniki.append(n * 10)\nprint(wyniki)",
        output = "[10, 20, 30]",
    ),
    output(
        "x = [\"p\", \"y\", \"t\"]\nprint(x[1])",
        "y",
        "Indeksy liczymy od 0, więc x[1] to drugi element.",
    ),
    fill(
        "Dodaj 4 na koniec listy.",
        "x = [1, 2, 3]\nx.____(4)\nprint(x)",
        listOf("append", "pop", "sort"),
        "append",
        "append() dopisuje element na koniec listy.",
    ),
    choice(
        "Co wypisze ten kod?",
        listOf("3", "2", "4", "[1, 2, 3]"),
        0,
        "len() zwraca liczbę elementów listy.",
        code = "print(len([7, 8, 9]))",
    ),
)
