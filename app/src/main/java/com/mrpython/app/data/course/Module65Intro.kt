package com.mrpython.app.data.course

internal val module65Intro = lesson(
    "u65l0", "Wprowadzenie: tydzień powtórek – algorytmy",
    explain(
        "Wyszukiwanie",
        "Ten tydzień powtarza algorytmy. Wyszukiwanie liniowe sprawdza element po elemencie. " +
            "Binarne działa na posortowanej liście i za każdym razem dzieli zakres na pół – gotowe jest w `bisect`.",
        code = "import bisect\nt = [10, 20, 30, 40]\nprint(bisect.bisect_left(t, 30))",
        output = "2",
    ),
    explain(
        "Sortowanie z kluczem",
        "`sort()` i `sorted()` przyjmują `key=`. Krotka w kluczu sortuje po kilku kryteriach, " +
            "a minus odwraca kolejność liczb – tu: punkty malejąco, imiona rosnąco.",
        code = "d = [(\"Ola\", 5), (\"Jan\", 4), (\"Ala\", 5)]\nd.sort(key=lambda u: (-u[1], u[0]))\nprint([u[0] for u in d])",
        output = "['Ala', 'Ola', 'Jan']",
    ),
    explain(
        "Złożoność",
        "Złożoność mówi, jak rośnie czas pracy z rozmiarem danych: jedna pętla to O(n), pętla w pętli " +
            "O(n²), a dzielenie na pół – O(log n). Dla 16 elementów to tylko 4 kroki.",
        code = "n, kroki = 16, 0\nwhile n > 1:\n    n //= 2\n    kroki += 1\nprint(kroki)",
        output = "4",
    ),
    explain(
        "Stos i kolejka",
        "Stos (LIFO) zdejmuje ostatnio dodany element – wystarczy lista i `pop()`. Kolejka (FIFO) " +
            "obsługuje najpierw najstarszy – użyj `deque` i `popleft()`.",
        code = "from collections import deque\nstos = [1, 2, 3]\nq = deque([1, 2, 3])\nprint(stos.pop(), q.popleft())",
        output = "3 1",
    ),
    explain(
        "Matematyka i rekurencja",
        "Klasyki wracają: algorytm Euklidesa liczy NWD, sito znajduje liczby pierwsze, a rekurencja " +
            "dzieli problem na mniejsze (np. sortowanie przez scalanie).",
        code = "def nwd(a, b):\n    while b:\n        a, b = b, a % b\n    return a\nprint(nwd(48, 18))",
        output = "6",
    ),
    choice(
        "Która struktura zwraca najpierw element dodany jako ostatni?",
        listOf("stos", "kolejka", "zbiór", "słownik"),
        0,
        "Stos działa według zasady LIFO – ostatni wchodzi, pierwszy wychodzi.",
    ),
    output(
        "t = [3, 1, 2]\nprint(sorted(t, key=lambda x: -x))",
        "[3, 2, 1]",
        "Klucz z minusem sortuje liczby malejąco.",
    ),
)
