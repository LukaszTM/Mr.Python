package com.mrpython.app.data.course

internal val module65Cards = listOf(
    cards(
        "u65l1",
        explain(
            "bisect: gdzie wstawić?",
            "Moduł `bisect` binarnie szuka w posortowanej liście miejsca dla wartości. " +
                "`bisect_left` daje indeks przed równymi elementami, a `bisect` (to samo co `bisect_right`) – za nimi.",
            code = "import bisect\nt = [10, 20, 20, 30]\nprint(bisect.bisect_left(t, 20))\nprint(bisect.bisect(t, 20))",
            output = "1\n3",
        ),
        explain(
            "Wstawianie: insort",
            "`bisect.insort(lista, x)` od razu wstawia `x` we właściwe miejsce, " +
                "więc lista pozostaje posortowana bez ponownego sortowania.",
            code = "import bisect\nt = [1, 3, 5]\nbisect.insort(t, 4)\nprint(t)",
            output = "[1, 3, 4, 5]",
        ),
    ),
    cards(
        "u65l3",
        explain(
            "Logarytm: math.log2",
            "`math.log2(n)` mówi, ile razy trzeba pomnożyć 2, by dostać `n` – czyli ile razy można " +
                "dzielić na pół. To liczba kroków algorytmu O(log n), np. wyszukiwania binarnego.",
            code = "import math\nprint(math.log2(16))\nprint(math.ceil(math.log2(1000)))",
            output = "4.0\n10",
        ),
    ),
    cards(
        "u65l4",
        explain(
            "Kopiec: heapq",
            "Moduł `heapq` zamienia zwykłą listę w kopiec – kolejkę priorytetową. `heapify` układa listę, " +
                "`heappush` dodaje element, a `heappop` zawsze zdejmuje najmniejszy.",
            code = "import heapq\nh = [5, 1, 8, 3]\nheapq.heapify(h)\nheapq.heappush(h, 2)\nprint(heapq.heappop(h), heapq.heappop(h))",
            output = "1 2",
        ),
        explain(
            "Priorytety i najmniejsze",
            "W kopcu często trzymamy krotki (priorytet, zadanie) – porównywany jest najpierw priorytet. " +
                "`nsmallest(n, t)` i `nlargest(n, t)` zwracają n najmniejszych lub największych elementów.",
            code = "import heapq\nh = []\nheapq.heappush(h, (2, \"pranie\"))\nheapq.heappush(h, (1, \"obiad\"))\nprint(heapq.heappop(h)[1])\nprint(heapq.nsmallest(2, [7, 2, 9]), heapq.nlargest(1, [7, 2, 9]))",
            output = "obiad\n[2, 7] [9]",
        ),
    ),
    cards(
        "u65l5",
        explain(
            "Silnia: math.factorial",
            "Silnia n! to iloczyn liczb od 1 do n, np. 5! = 1·2·3·4·5. Zamiast pisać pętlę, " +
                "użyj `math.factorial(n)`.",
            code = "import math\nprint(math.factorial(5))\nprint(math.factorial(5) // math.factorial(3))",
            output = "120\n20",
        ),
    ),
)
