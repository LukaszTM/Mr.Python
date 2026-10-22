package com.mrpython.app.data.course

internal val module27Intro = lesson(
    "u27l0", "Wprowadzenie: złożoność",
    explain(
        "Liczenie kroków",
        "Szybkość programu oceniamy, licząc, ile kroków wykona. Pętla po `range(n)` to n kroków, " +
            "a dwie pętle zagnieżdżone mnożą się: n · m kroków.",
        code = "kroki = 0\nfor i in range(3):\n    for j in range(4):\n        kroki += 1\nprint(kroki)",
        output = "12",
    ),
    explain(
        "Notacja O",
        "Notacja O mówi, jak rośnie liczba kroków, gdy dane rosną. `O(1)` – stała (np. `a[5]`), " +
            "`O(n)` – jedna pętla, `O(n²)` – pętla w pętli. Podwojenie n w `O(n²)` daje cztery razy więcej pracy.",
        code = "for n in [2, 4, 8]:\n    print(n * n)",
        output = "4\n16\n64",
    ),
    explain(
        "Połowienie: O(log n)",
        "Gdy w każdym kroku dzielimy problem na pół, kroków jest bardzo mało – to `O(log n)`. " +
            "Tak działa wyszukiwanie binarne: 1000 elementów to tylko około 10 kroków.",
        code = "n = 32\nkroki = 0\nwhile n > 1:\n    n //= 2\n    kroki += 1\nprint(kroki)",
        output = "5",
    ),
    explain(
        "Lista czy zbiór?",
        "`x in lista` przegląda elementy po kolei – to `O(n)`. `x in zbior` dzięki haszowaniu " +
            "działa średnio w `O(1)`. Gdy często sprawdzasz przynależność, zamień listę raz na `set()`.",
        code = "zakazane = set([\"spam\", \"reklama\"])\nprint(\"spam\" in zakazane)",
        output = "True",
    ),
    explain(
        "Sprytniejszy sposób",
        "Czasem zamiast pętli wystarczy wzór. Sumę liczb od 1 do n daje `n * (n + 1) // 2` " +
            "w jednym kroku, a `sum(range(n + 1))` potrzebuje n kroków.",
        code = "n = 100\nprint(n * (n + 1) // 2)\nprint(sum(range(n + 1)))",
        output = "5050\n5050",
    ),
    choice(
        "Jaką złożoność ma pętla w pętli, obie po n elementach?",
        listOf("O(n²)", "O(n)", "O(1)", "O(log n)"),
        0,
        "Dla każdego z n obiegów wykonujemy n kolejnych – razem n · n.",
    ),
    output(
        "kroki = 0\nfor i in range(5):\n    kroki += 1\nfor j in range(5):\n    kroki += 1\nprint(kroki)",
        "10",
        "Pętle jedna po drugiej dodają się: 5 + 5.",
    ),
    choice(
        "Gdzie sprawdzanie x in ... jest średnio najszybsze?",
        listOf("W zbiorze", "W liście", "W napisie", "W krotce"),
        0,
        "Zbiór używa haszowania, więc in działa w O(1).",
    ),
)
