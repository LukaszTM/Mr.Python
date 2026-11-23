package com.mrpython.app.data.course

import com.mrpython.app.domain.CourseUnit

internal val module27 = CourseUnit(
    id = "u27",
    title = "Złożoność obliczeniowa",
    description = "Liczenie kroków, notacja O i wybór szybszych rozwiązań",
    lessons = listOf(
        lesson(
            "u27l1", "Liczenie operacji",
            output(
                "kroki = 0\nfor i in range(5):\n    kroki += 1\nprint(kroki)",
                "5",
                "Pętla wykonuje się 5 razy, więc mamy 5 kroków.",
            ),
            output(
                "kroki = 0\nfor i in range(3):\n    for j in range(4):\n        kroki += 1\nprint(kroki)",
                "12",
                "Pętle zagnieżdżone mnożą się: 3 · 4 = 12.",
            ),
            output(
                "kroki = 0\nfor i in range(4):\n    for j in range(i):\n        kroki += 1\nprint(kroki)",
                "6",
                "Wewnętrzna pętla wykonuje się 0, 1, 2 i 3 razy – razem 6.",
            ),
            choice(
                "Ile wynosi kroki na końcu?",
                listOf("20", "100", "10", "11"),
                0,
                "Dwie pętle jedna po drugiej dodają się: 10 + 10 = 20.",
                code = "n = 10\nkroki = 0\nfor i in range(n):\n    kroki += 1\nfor j in range(n):\n    kroki += 1",
            ),
            output(
                "n = 32\nkroki = 0\nwhile n > 1:\n    n //= 2\n    kroki += 1\nprint(kroki)",
                "5",
                "Połowienie: 32, 16, 8, 4, 2, 1 – to 5 kroków.",
            ),
            fill(
                "Uzupełnij, aby wewnętrzna pętla dała razem dokładnie n · n kroków.",
                "n = 3\nkroki = 0\nfor i in range(n):\n    for j in range(____):\n        kroki += 1\nprint(kroki)",
                listOf("n", "i", "1"),
                "n",
                "Obie pętle po n obiegów dają n · n = 9 kroków.",
            ),
            output(
                "kroki = 0\nfor i in range(0, 20, 5):\n    kroki += 1\nprint(kroki)",
                "4",
                "range(0, 20, 5) to 0, 5, 10 i 15 – cztery obiegi.",
            ),
            tiles(
                "Napisz pętlę, która wykona się dokładnie n razy",
                listOf("for", "i", "in", "range(n)", ":"),
                listOf("range(n * n)", "while"),
                "range(n) daje n kolejnych liczb.",
            ),
        ),
        lesson(
            "u27l2", "Notacja O",
            choice(
                "Jaką złożoność ma odczyt elementu listy po indeksie, np. a[5]?",
                listOf("O(1)", "O(n)", "O(n²)", "O(log n)"),
                0,
                "Dostęp po indeksie trwa tyle samo bez względu na długość listy.",
            ),
            choice(
                "Jaką złożoność ma ten kod względem długości listy?",
                listOf("O(n)", "O(1)", "O(n²)", "O(log n)"),
                0,
                "Jedna pętla po wszystkich elementach to O(n).",
                code = "liczby = [1, 2, 3]\nsuma = 0\nfor x in liczby:\n    suma += x",
            ),
            choice(
                "Jaką złożoność ma ten kod względem długości listy?",
                listOf("O(n²)", "O(n)", "O(1)", "O(log n)"),
                0,
                "Dla każdego elementu przechodzimy całą listę jeszcze raz – n · n.",
                code = "liczby = [1, 2, 3]\nfor a in liczby:\n    for b in liczby:\n        print(a, b)",
            ),
            choice(
                "Jaką złożoność ma ta pętla względem n?",
                listOf("O(log n)", "O(n)", "O(n²)", "O(1)"),
                0,
                "Połowienie n w każdym kroku daje logarytmiczną liczbę kroków.",
                code = "n = 1000\nwhile n > 1:\n    n = n // 2",
            ),
            output(
                "for n in [2, 4, 8]:\n    kroki = 0\n    for i in range(n):\n        for j in range(n):\n            kroki += 1\n    print(kroki)",
                "4\n16\n64",
                "W O(n²) dwa razy większe n daje cztery razy więcej kroków.",
            ),
            output(
                "for n in [8, 64, 1024]:\n    kroki = 0\n    while n > 1:\n        n //= 2\n        kroki += 1\n    print(kroki)",
                "3\n6\n10",
                "W O(log n) nawet duże n daje mało kroków.",
            ),
            fill(
                "Uzupełnij, aby funkcja w czasie O(1) zwracała pierwszy element.",
                "def pierwszy(lista):\n    return lista____\nprint(pierwszy([7, 8, 9]))",
                listOf("[0]", "[-1]", ".pop()"),
                "[0]",
                "Odczyt po indeksie 0 nie zależy od długości listy.",
            ),
            tiles(
                "Ułóż złożoności od najszybszej do najwolniejszej",
                listOf("rzedy = [", "\"O(1)\",", "\"O(log n)\",", "\"O(n)\",", "\"O(n²)\"]"),
                listOf("\"O(0)\",", "\"O(n!)\","),
                "Stała, logarytmiczna, liniowa, a na końcu kwadratowa.",
            ),
        ),
        lesson(
            "u27l3", "Lista czy zbiór?",
            choice(
                "Ile kosztuje sprawdzenie x in lista?",
                listOf("O(n) – trzeba przejrzeć elementy po kolei", "O(1)", "O(log n)", "O(n²)"),
                0,
                "Lista nie wie, gdzie jest x, więc szuka po kolei.",
            ),
            choice(
                "Ile średnio kosztuje sprawdzenie x in zbior?",
                listOf("O(1) – zbiór używa haszowania", "O(n)", "O(n²)", "O(log n)"),
                0,
                "Zbiór od razu wylicza, gdzie szukać elementu.",
            ),
            output(
                "lista = [5, 3, 8, 1, 9]\nporownania = 0\nfor x in lista:\n    porownania += 1\n    if x == 1:\n        break\nprint(porownania)",
                "4",
                "Żeby znaleźć 1, trzeba porównać 4 elementy.",
            ),
            output(
                "liczby = [3, 1, 4, 1, 5]\nprint(len(liczby) != len(set(liczby)))",
                "True",
                "Zbiór usuwa powtórki, więc jest krótszy – na liście były duplikaty.",
            ),
            output(
                "a = [1, 2, 3, 4]\nb = {3, 4, 5}\nwspolne = [x for x in a if x in b]\nprint(wspolne)",
                "[3, 4]",
                "Sprawdzanie in na zbiorze b jest szybkie.",
            ),
            choice(
                "Masz listę miliona numerów i tysiąc pytań „czy numer jest na liście?”. Co warto zrobić?",
                listOf(
                    "Raz zamienić listę na zbiór i potem używać in",
                    "Przed każdym pytaniem sortować listę",
                    "Używać list.count() przy każdym pytaniu",
                    "Zamienić listę na jeden długi napis",
                ),
                0,
                "Jednorazowe set() kosztuje O(n), a potem każde pytanie to O(1).",
            ),
            fill(
                "Uzupełnij, aby sprawdzanie not in w pętli było szybkie (O(1)).",
                "zakazane = ____([\"spam\", \"reklama\"])\nslowa = [\"hej\", \"spam\"]\nprint([s for s in slowa if s not in zakazane])",
                listOf("set", "len", "sum"),
                "set",
                "Sprawdzanie przynależności w zbiorze jest średnio O(1).",
            ),
            output(
                "widziane = set()\nfor x in [4, 2, 4, 7, 2]:\n    if x in widziane:\n        print(x)\n    widziane.add(x)",
                "4\n2",
                "Zbiór pamięta, co już było, i szybko wykrywa powtórki.",
            ),
        ),
        lesson(
            "u27l4", "Powtórka: złożoność",
            choice(
                "Jaką złożoność ma ten kod względem n?",
                listOf("O(n)", "O(n²)", "O(1)", "O(log n)"),
                0,
                "Wewnętrzna pętla ma stałe 10 obiegów, więc całość rośnie liniowo.",
                code = "n = 100\nfor i in range(n):\n    for j in range(10):\n        pass",
            ),
            output(
                "n = 4\nkroki = 0\nfor i in range(n):\n    kroki += 1\nfor i in range(n):\n    for j in range(n):\n        kroki += 1\nprint(kroki)",
                "20",
                "4 kroki z pierwszej pętli i 16 z zagnieżdżonych.",
            ),
            choice(
                "Posortowana lista ma 1000 elementów. Ile najwyżej kroków wykona wyszukiwanie liniowe, a ile binarne?",
                listOf("1000 i około 10", "10 i około 1000", "500 i 500", "1000 i 1000"),
                0,
                "Liniowe jest O(n), a binarne O(log n).",
            ),
            choice(
                "Która operacja na liście ma złożoność O(n)?",
                listOf("a.insert(0, x)", "a.append(x)", "a[3]", "len(a)"),
                0,
                "Wstawienie na początek przesuwa wszystkie pozostałe elementy.",
            ),
            output(
                "n = 100\nprint(n * (n + 1) // 2)\nprint(sum(range(n + 1)))",
                "5050\n5050",
                "Ten sam wynik: wzór działa w O(1), a sumowanie w O(n).",
            ),
            fill(
                "Uzupełnij, aby obliczyć sumę liczb od 1 do n w czasie O(1).",
                "n = 10\nprint(n * (n + 1) ____ 2)",
                listOf("//", "*", "-"),
                "//",
                "Wzór n · (n + 1) / 2 daje 55 bez żadnej pętli.",
            ),
            choice(
                "Kod z dwiema zagnieżdżonymi pętlami po n działa 1 s dla n = 1000. Ile mniej więcej potrwa dla n = 2000?",
                listOf("4 s", "2 s", "1 s", "8 s"),
                0,
                "W O(n²) podwojenie n daje czterokrotnie więcej pracy.",
            ),
            tiles(
                "Zamień listę na zbiór, aby szybko sprawdzać przynależność",
                listOf("szybkie", "=", "set(lista)"),
                listOf("list(lista)", "=="),
                "set() tworzy zbiór, w którym in działa w O(1).",
            ),
        ),
    ),
)
