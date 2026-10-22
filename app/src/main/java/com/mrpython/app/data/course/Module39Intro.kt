package com.mrpython.app.data.course

internal val module39Intro = lesson(
    "u39l0", "Wprowadzenie: moduł itertools",
    explain(
        "count i islice",
        "Moduł `itertools` zawiera gotowe narzędzia do pracy z iteratorami. `count(start, krok)` " +
            "liczy bez końca, więc bierzemy z niego fragment przez `islice(iterator, n)` albo " +
            "przerywamy pętlę `break`.",
        code = "from itertools import count, islice\nprint(list(islice(count(5), 3)))\nprint(list(islice(count(0, 2), 3)))",
        output = "[5, 6, 7]\n[0, 2, 4]",
    ),
    explain(
        "chain i product",
        "`chain` łączy kilka iteratorów w jeden ciąg, jeden po drugim. `product` tworzy " +
            "wszystkie pary – działa jak dwie zagnieżdżone pętle `for`.",
        code = "from itertools import chain, product\nprint(list(chain([1, 2], [3])))\nprint(list(product(\"ab\", [1, 2])))",
        output = "[1, 2, 3]\n[('a', 1), ('a', 2), ('b', 1), ('b', 2)]",
    ),
    explain(
        "permutations i combinations",
        "`permutations` daje wszystkie uporządkowania – kolejność ma znaczenie, więc (1, 2) " +
            "i (2, 1) to różne wyniki. `combinations(x, k)` wybiera k elementów bez zwracania " +
            "uwagi na kolejność.",
        code = "from itertools import permutations, combinations\nprint(list(permutations([1, 2])))\nprint(list(combinations([1, 2, 3], 2)))",
        output = "[(1, 2), (2, 1)]\n[(1, 2), (1, 3), (2, 3)]",
    ),
    explain(
        "groupby",
        "`groupby` łączy w grupy kolejne jednakowe elementy i zwraca pary (klucz, grupa). " +
            "Grupuje tylko sąsiadów, dlatego dane zwykle najpierw sortujemy.",
        code = "from itertools import groupby\nfor k, g in groupby(\"aabccc\"):\n    print(k, len(list(g)))",
        output = "a 2\nb 1\nc 3",
    ),
    explain(
        "accumulate",
        "`accumulate` zwraca wyniki częściowe – domyślnie sumy narastająco. Można podać własną " +
            "funkcję dwuargumentową, np. `max`, aby dostać bieżące maksimum.",
        code = "from itertools import accumulate\nprint(list(accumulate([1, 2, 3])))\nprint(list(accumulate([2, 5, 1], max)))",
        output = "[1, 3, 6]\n[2, 5, 5]",
    ),
    choice(
        "Która funkcja da wszystkie pary bez zwracania uwagi na kolejność?",
        listOf("combinations", "permutations", "chain", "count"),
        0,
        "Kombinacje ignorują kolejność elementów.",
    ),
    output(
        "from itertools import chain\nprint(list(chain(\"ab\", \"c\")))",
        "['a', 'b', 'c']",
        "chain łączy iteratory jeden po drugim.",
    ),
    fill(
        "Uzupełnij, aby dostać sumy częściowe [1, 3, 6].",
        "from itertools import accumulate\nprint(list(____([1, 2, 3])))",
        listOf("accumulate", "groupby", "count", "islice"),
        "accumulate",
        "accumulate liczy sumy narastająco.",
    ),
)
