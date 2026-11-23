package com.mrpython.app.data.course

import com.mrpython.app.domain.CourseUnit

internal val module39 = CourseUnit(
    id = "u39",
    title = "Moduł itertools",
    description = "count, chain, product, permutacje, groupby i accumulate",
    lessons = listOf(
        lesson(
            "u39l1", "count i islice",
            output(
                "from itertools import count, islice\nprint(list(islice(count(1), 4)))",
                "[1, 2, 3, 4]",
                "count(1) liczy bez końca, a islice bierze tylko 4 pierwsze wartości.",
            ),
            output(
                "from itertools import count, islice\nprint(list(islice(count(0, 5), 3)))",
                "[0, 5, 10]",
                "Drugi argument count to krok.",
            ),
            choice(
                "Co się stanie po wywołaniu list(count())?",
                listOf("Program nigdy się nie skończy", "Powstanie pusta lista", "Powstanie lista [0]", "ValueError"),
                0,
                "count() jest nieskończony, więc list() nigdy nie skończy zbierać elementów.",
            ),
            output(
                "from itertools import islice\nprint(list(islice(\"python\", 2, 5)))",
                "['t', 'h', 'o']",
                "islice działa jak wycinek [2:5], ale na dowolnym iteratorze.",
            ),
            fill(
                "Uzupełnij, aby wziąć 3 pierwsze elementy z nieskończonego licznika.",
                "from itertools import count, islice\nprint(list(____(count(10), 3)))",
                listOf("islice", "slice", "range", "count"),
                "islice",
                "islice wycina fragment z iteratora.",
            ),
            output(
                "from itertools import count\nfor i in count(3):\n    if i > 5:\n        break\n    print(i)",
                "3\n4\n5",
                "Pętlę po count trzeba przerwać breakiem.",
            ),
            tiles(
                "Weź 5 pierwszych liczb z count()",
                listOf("list(", "islice(", "count(),", "5", "))"),
                listOf("count[", "slice("),
                "islice(iterator, n) bierze n pierwszych elementów.",
            ),
        ),
        lesson(
            "u39l2", "chain i product",
            output(
                "from itertools import chain\nprint(list(chain([1, 2], [3], [4, 5])))",
                "[1, 2, 3, 4, 5]",
                "chain łączy kolejne iteratory w jeden ciąg.",
            ),
            output(
                "from itertools import chain\nprint(\"\".join(chain(\"ab\", \"cd\")))",
                "abcd",
                "chain działa też na napisach.",
            ),
            output(
                "from itertools import product\nfor a, b in product([1, 2], \"xy\"):\n    print(a, b)",
                "1 x\n1 y\n2 x\n2 y",
                "product tworzy wszystkie pary – jak zagnieżdżone pętle.",
            ),
            output(
                "from itertools import product\nprint(len(list(product(\"abc\", repeat=2))))",
                "9",
                "repeat=2 to pary z tego samego zbioru: 3 · 3 = 9.",
            ),
            choice(
                "Któremu kodowi odpowiada product(A, B)?",
                listOf("Dwie zagnieżdżone pętle for", "Jedna pętla po A + B", "zip(A, B)", "A * B"),
                0,
                "product to iloczyn kartezjański – każdy element A z każdym elementem B.",
            ),
            fill(
                "Uzupełnij, aby połączyć dwie listy w jeden ciąg.",
                "from itertools import chain\nprint(list(____([1], [2])))",
                listOf("chain", "product", "zip", "count"),
                "chain",
                "chain łączy iteratory jeden po drugim.",
            ),
            output(
                "from itertools import chain\nlisty = [[1, 2], [3], [4]]\nprint(list(chain.from_iterable(listy)))",
                "[1, 2, 3, 4]",
                "chain.from_iterable spłaszcza listę list.",
            ),
            tiles(
                "Wypisz wszystkie pary z \"ab\" i \"cd\"",
                listOf("print(", "list(", "product(", "\"ab\",", "\"cd\"", ")))"),
                listOf("zip(", "chain("),
                "product zwraca iterator par, który zamieniamy na listę.",
            ),
        ),
        lesson(
            "u39l3", "permutations i combinations",
            output(
                "from itertools import permutations\nprint(list(permutations([1, 2])))",
                "[(1, 2), (2, 1)]",
                "Permutacje to wszystkie uporządkowania elementów.",
            ),
            output(
                "from itertools import permutations\nprint(len(list(permutations(\"abc\"))))",
                "6",
                "3 elementy można ustawić na 3! = 6 sposobów.",
            ),
            output(
                "from itertools import combinations\nprint(list(combinations([1, 2, 3], 2)))",
                "[(1, 2), (1, 3), (2, 3)]",
                "Kombinacje nie zwracają uwagi na kolejność, więc (2, 1) się nie pojawia.",
            ),
            output(
                "from itertools import combinations\nprint(len(list(combinations(range(5), 2))))",
                "10",
                "Par z 5 elementów bez kolejności jest 10.",
            ),
            choice(
                "Czym różnią się permutations(x, 2) i combinations(x, 2)?",
                listOf("W permutacjach (a, b) i (b, a) to różne wyniki", "Niczym", "combinations zwraca więcej wyników", "permutations nie przyjmuje drugiego argumentu"),
                0,
                "Permutacje uwzględniają kolejność, kombinacje nie.",
            ),
            output(
                "from itertools import permutations\nprint(len(list(permutations(\"abcd\", 2))))",
                "12",
                "Uporządkowanych par z 4 elementów jest 4 · 3 = 12.",
            ),
            fill(
                "Uzupełnij, aby dostać pary bez powtórzeń i bez zwracania uwagi na kolejność.",
                "from itertools import combinations\nfor p in ____(\"xyz\", 2):\n    print(p)",
                listOf("combinations", "permutations", "product", "chain"),
                "combinations",
                "Kombinacje ignorują kolejność, więc (\"y\", \"x\") się nie pojawi.",
            ),
            tiles(
                "Policz permutacje napisu \"kot\"",
                listOf("len(", "list(", "permutations(", "\"kot\"", ")))"),
                listOf("combinations(", "count("),
                "permutations zwraca iterator, więc najpierw zamieniamy go na listę.",
            ),
        ),
        lesson(
            "u39l4", "groupby i accumulate",
            output(
                "from itertools import groupby\nfor k, g in groupby(\"aaabbc\"):\n    print(k, len(list(g)))",
                "a 3\nb 2\nc 1",
                "groupby grupuje kolejne jednakowe elementy.",
            ),
            output(
                "from itertools import groupby\nfor k, g in groupby(\"abab\"):\n    print(k, end=\"\")",
                "abab",
                "groupby łączy tylko sąsiadujące elementy – dlatego dane zwykle się najpierw sortuje.",
            ),
            output(
                "from itertools import groupby\nslowa = sorted([\"ewa\", \"ala\", \"ela\", \"adam\"])\nfor k, g in groupby(slowa, key=lambda s: s[0]):\n    print(k, list(g))",
                "a ['adam', 'ala']\ne ['ela', 'ewa']",
                "Po posortowaniu słowa o tej samej pierwszej literze leżą obok siebie.",
            ),
            choice(
                "Dlaczego przed groupby zwykle sortujemy dane?",
                listOf("groupby łączy tylko sąsiednie elementy", "groupby nie działa na listach", "Bez sortowania zgłasza błąd", "Sortowanie przyspiesza program"),
                0,
                "Te same wartości muszą leżeć obok siebie, by trafić do jednej grupy.",
            ),
            output(
                "from itertools import accumulate\nprint(list(accumulate([1, 2, 3, 4])))",
                "[1, 3, 6, 10]",
                "accumulate zwraca sumy częściowe.",
            ),
            output(
                "from itertools import accumulate\nprint(list(accumulate([3, 1, 5, 2], max)))",
                "[3, 3, 5, 5]",
                "Z funkcją max dostajemy bieżące maksimum.",
            ),
            fill(
                "Uzupełnij, aby dostać iloczyny częściowe [1, 2, 6, 24].",
                "from itertools import accumulate\nprint(list(accumulate([1, 2, 3, 4], ____)))",
                listOf("lambda a, b: a * b", "lambda a, b: a + b", "max", "min"),
                "lambda a, b: a * b",
                "Funkcja mnożąca daje iloczyny częściowe.",
            ),
            tiles(
                "Wypisz sumy częściowe listy dane",
                listOf("print(", "list(", "accumulate(", "dane", ")))"),
                listOf("sum(", "groupby("),
                "accumulate domyślnie dodaje kolejne elementy.",
            ),
        ),
        lesson(
            "u39l5", "Powtórka: itertools",
            choice(
                "Która funkcja da wszystkie uporządkowania listy?",
                listOf("permutations", "combinations", "chain", "groupby"),
                0,
                "Uporządkowania to permutacje.",
            ),
            output(
                "from itertools import chain\nprint(list(chain(\"ab\", [1])))",
                "['a', 'b', 1]",
                "chain łączy iteratory różnych typów.",
            ),
            output(
                "from itertools import count, islice\nprint(list(islice(count(2, 2), 3)))",
                "[2, 4, 6]",
                "Start 2, krok 2, trzy elementy.",
            ),
            output(
                "from itertools import combinations\nprint(len(list(combinations(\"abcd\", 3))))",
                "4",
                "Trójek z 4 elementów (bez kolejności) są 4.",
            ),
            output(
                "from itertools import groupby\nfor k, g in groupby(sorted([2, 1, 2, 1, 1])):\n    print(k, len(list(g)))",
                "1 3\n2 2",
                "Po posortowaniu jedynki i dwójki tworzą po jednej grupie.",
            ),
            fill(
                "Uzupełnij, aby dostać sumy częściowe [5, 7, 8].",
                "from itertools import accumulate\nprint(list(____([5, 2, 1])))",
                listOf("accumulate", "chain", "count", "product"),
                "accumulate",
                "accumulate liczy sumy narastająco.",
            ),
            choice(
                "Ile elementów da product(\"ab\", \"xyz\")?",
                listOf("6", "5", "3", "2"),
                0,
                "Każda z 2 liter z każdą z 3 liter: 2 · 3 = 6.",
            ),
            tiles(
                "Zaimportuj funkcje chain i product",
                listOf("from", "itertools", "import", "chain,", "product"),
                listOf("collections", "include"),
                "Kilka nazw importujemy po przecinku.",
            ),
        ),
    ),
)
