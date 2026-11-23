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
        "u65l2",
        explain(
            "Jak szybko sortuje sorted()",
            "Sortowanie bąbelkowe porównuje elementy parami w pętli w pętli – to O(n²). Wbudowane `sorted()` i `sort()` " +
                "używają algorytmu Timsort, który działa w O(n log n). Dla 1024 elementów n² to ponad milion kroków, " +
                "a n log n (log₂ 1024 = 10) – około 10 tysięcy.",
            code = "n = 1024\nprint(n * n, n * 10)",
            output = "1048576 10240",
        ),
    ),
    cards(
        "u65l3",
        explain(
            "Logarytm: math.log2",
            "`math.log2(n)` mówi, do jakiej potęgi trzeba podnieść 2, by dostać `n` – czyli ile razy można " +
                "dzielić `n` na pół, zanim zostanie 1. To liczba kroków algorytmu O(log n), np. wyszukiwania binarnego.",
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
    cards(
        "u65l7",
        explain(
            "Dziel i zwyciężaj: scalanie",
            "Sortowanie przez scalanie dzieli listę na dwie połowy, każdą sortuje rekurencyjnie, a potem scala je w jedną: " +
                "z początków obu posortowanych list bierze mniejszy element. To zasada „dziel i zwyciężaj”: podziel problem " +
                "na mniejsze części, rozwiąż je i połącz wyniki. Takie sortowanie działa w O(n log n).",
            code = "a, b = [1, 5], [2, 9]\nw = []\nwhile a and b:\n    w.append((a if a[0] <= b[0] else b).pop(0))\nprint(w + a + b)",
            output = "[1, 2, 5, 9]",
        ),
        explain(
            "Quicksort: element osiowy",
            "Quicksort też dzieli i zwycięża: wybiera element osiowy (np. pierwszy), dzieli resztę na elementy mniejsze " +
                "i nie mniejsze od niego, sortuje obie części rekurencyjnie i skleja: mniejsze + [osiowy] + większe.",
            code = "t = [3, 6, 1, 8, 2]\np = t[0]\nprint([x for x in t[1:] if x < p], p, [x for x in t[1:] if x >= p])",
            output = "[1, 2] 3 [6, 8]",
        ),
    ),
)
