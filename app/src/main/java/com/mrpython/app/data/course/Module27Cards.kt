package com.mrpython.app.data.course

internal val module27Cards = listOf(
    cards(
        "u27l1",
        explain(
            "Pętla zależna od i",
            "Gdy wewnętrzna pętla idzie po `range(i)`, za każdym razem ma inną długość: 0, 1, 2, 3… " +
                "Kroki trzeba wtedy dodać: dla `range(4)` to 0 + 1 + 2 + 3 = 6.",
            code = "kroki = 0\nfor i in range(4):\n    for j in range(i):\n        kroki += 1\nprint(kroki)",
            output = "6",
        ),
    ),
    cards(
        "u27l2",
        explain(
            "Stałe pomijamy",
            "Notacja O patrzy tylko na to, jak wynik rośnie z n. Dwie pętle po kolei (2n kroków) to wciąż " +
                "`O(n)`, a pętla w pętli ze stałymi 10 obiegami w środku (10n) – też `O(n)`.",
            code = "n = 5\nkroki = 0\nfor i in range(n):\n    for j in range(10):\n        kroki += 1\nprint(kroki)",
            output = "50",
        ),
        explain(
            "Od najszybszej",
            "Kolejność od najszybszej: `O(1)` < `O(log n)` < `O(n)` < `O(n²)`. Odczyt `a[i]` i `len(a)` " +
                "to `O(1)` – lista zna swoją długość i od razu trafia pod indeks.",
            code = "a = list(range(1000))\nprint(a[-1], len(a))",
            output = "999 1000",
        ),
    ),
    cards(
        "u27l3",
        explain(
            "Pusty zbiór: set()",
            "Pusty zbiór tworzymy przez `set()`, bo `{}` to pusty słownik. Elementy dodajemy metodą `add()` " +
                "(zbiór nie ma `append()`). Taki zbiór „widzianych” szybko wykrywa powtórki.",
            code = "widziane = set()\nfor x in [4, 2, 4]:\n    if x in widziane:\n        print(\"powtórka:\", x)\n    widziane.add(x)",
            output = "powtórka: 4",
        ),
        explain(
            "Czy są duplikaty?",
            "Zbiór usuwa powtórzenia, więc jeśli `set(lista)` jest krótszy od listy, to coś się powtarzało. " +
                "Pamiętaj: zbiór nie ma kolejności ani indeksów.",
            code = "liczby = [3, 1, 4, 1]\nprint(len(liczby) != len(set(liczby)))",
            output = "True",
        ),
    ),
    cards(
        "u27l4",
        explain(
            "Koniec czy początek listy?",
            "`append()` dodaje na koniec w `O(1)`. `insert(0, x)` wstawia na początek, więc musi przesunąć " +
                "wszystkie pozostałe elementy – to `O(n)`. Tak samo `pop(0)`.",
            code = "a = [2, 3]\na.append(4)\na.insert(0, 1)\nprint(a)",
            output = "[1, 2, 3, 4]",
        ),
    ),
)
