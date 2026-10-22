package com.mrpython.app.data.course

import com.mrpython.app.domain.CourseUnit

internal val module65 = CourseUnit(
    id = "u65",
    title = "Tydzień powtórek: algorytmy",
    description = "Wyszukiwanie, sortowanie, złożoność, stosy i rekurencja",
    lessons = listOf(
        lesson(
            "u65l1", "Dzień 1: Wyszukiwanie",
            output(
                "def szukaj(lista, x):\n    for i, v in enumerate(lista):\n        if v == x:\n            return i\n    return -1\nprint(szukaj([4, 8, 15], 15), szukaj([4, 8], 3))",
                "2 -1",
                "Wyszukiwanie liniowe zwraca indeks albo -1, gdy elementu nie ma.",
            ),
            output(
                "def binarne(t, x):\n    lo, hi, kroki = 0, len(t) - 1, 0\n    while lo <= hi:\n        kroki += 1\n        mid = (lo + hi) // 2\n        if t[mid] == x:\n            return kroki\n        if t[mid] < x: lo = mid + 1\n        else: hi = mid - 1\nprint(binarne([1, 3, 5, 7, 9, 11, 13], 13))",
                "3",
                "Sprawdzane są kolejno 7, 11 i 13 – za każdym razem połowa zakresu odpada.",
            ),
            choice(
                "Jaki warunek musi spełniać lista, by użyć wyszukiwania binarnego?",
                listOf("Musi być posortowana", "Musi mieć parzystą długość", "Nie może mieć duplikatów", "Musi zawierać tylko liczby"),
                0,
                "Wyszukiwanie binarne opiera się na porządku elementów.",
            ),
            choice(
                "Ile mniej więcej porównań wystarczy, by binarnie przeszukać 1000 posortowanych elementów?",
                listOf("Około 10", "Około 100", "Około 500", "1000"),
                0,
                "2 do potęgi 10 to 1024, więc wystarczy około 10 podziałów na pół.",
            ),
            output(
                "import bisect\nprogi = [50, 60, 75, 90]\nprint(bisect.bisect(progi, 80))",
                "3",
                "bisect zwraca miejsce, w które trzeba by wstawić 80, by zachować porządek.",
            ),
            fill(
                "Uzupełnij, aby wyszukiwanie binarne działało poprawnie.",
                "def binarne(t, x):\n    lo, hi = 0, len(t) - 1\n    while lo <= hi:\n        mid = (lo + hi) // 2\n        if t[mid] == x:\n            return mid\n        if t[mid] < x: lo = ____\n        else: hi = mid - 1\n    return -1\nprint(binarne([2, 4, 6, 8], 8))",
                listOf("mid + 1", "mid", "mid - 1"),
                "mid + 1",
                "Element mid już sprawdziliśmy, więc szukamy od mid + 1; inaczej pętla się zapętli.",
            ),
            tiles(
                "Wypisz, czy któraś liczba w liście liczby jest ujemna",
                listOf("print(", "any(", "x < 0", "for x in liczby", "))"),
                listOf("all(", "x > 0"),
                "any() zwraca True, gdy choć jeden element spełnia warunek.",
            ),
            output(
                "liczby = [3, 8, 1, 9, 4]\nnaj = liczby[0]\nfor n in liczby[1:]:\n    if n > naj:\n        naj = n\nprint(naj, liczby.index(naj))",
                "9 3",
                "Szukamy maksimum ręcznie, a index() podaje jego pozycję.",
            ),
        ),
        lesson(
            "u65l2", "Dzień 2: Sortowanie",
            output(
                "t = [5, 1, 4, 2]\nfor i in range(len(t) - 1):\n    if t[i] > t[i + 1]:\n        t[i], t[i + 1] = t[i + 1], t[i]\nprint(t)",
                "[1, 4, 2, 5]",
                "Jedno przejście sortowania bąbelkowego przesuwa największy element na koniec.",
            ),
            output(
                "dane = [(\"Ola\", 5), (\"Jan\", 4), (\"Ala\", 5)]\ndane.sort(key=lambda u: (-u[1], u[0]))\nprint([u[0] for u in dane])",
                "['Ala', 'Ola', 'Jan']",
                "Najpierw malejąco po ocenie, przy remisie alfabetycznie po imieniu.",
            ),
            choice(
                "Czym różni się lista.sort() od sorted(lista)?",
                listOf("sort() zmienia listę i zwraca None, sorted() zwraca nową listę", "Niczym", "sorted() zmienia listę w miejscu", "sort() działa tylko na liczbach"),
                0,
                "sorted() nie rusza oryginału.",
            ),
            output(
                "dane = [(\"b\", 1), (\"a\", 2), (\"c\", 1)]\ndane.sort(key=lambda p: p[1])\nprint(dane)",
                "[('b', 1), ('c', 1), ('a', 2)]",
                "Sortowanie w Pythonie jest stabilne: równe klucze zachowują kolejność.",
            ),
            fill(
                "Uzupełnij, aby posortować malejąco (program ma wypisać [10, 7, 3]).",
                "liczby = [3, 10, 7]\nprint(sorted(liczby, ____=True))",
                listOf("reverse", "desc", "key"),
                "reverse",
                "reverse=True odwraca kolejność sortowania.",
            ),
            output(
                "def wstawianie(t):\n    for i in range(1, len(t)):\n        x, j = t[i], i - 1\n        while j >= 0 and t[j] > x:\n            t[j + 1] = t[j]\n            j -= 1\n        t[j + 1] = x\n    return t\nprint(wstawianie([3, 1, 2]))",
                "[1, 2, 3]",
                "Sortowanie przez wstawianie wkłada każdy element na właściwe miejsce.",
            ),
            choice(
                "Jaka jest złożoność sortowania bąbelkowego w najgorszym przypadku?",
                listOf("O(n²)", "O(n log n)", "O(n)", "O(log n)"),
                0,
                "Dwie zagnieżdżone pętle po n elementach dają O(n²).",
            ),
            tiles(
                "Posortuj słowa bez rozróżniania wielkości liter",
                listOf("sorted(", "slowa,", "key=", "str.lower", ")"),
                listOf("str.lower()", "reverse="),
                "key dostaje funkcję (bez nawiasów), np. str.lower.",
            ),
        ),
        lesson(
            "u65l3", "Dzień 3: Złożoność obliczeniowa",
            choice(
                "Jaka jest złożoność tej funkcji?",
                listOf("O(n)", "O(1)", "O(n²)", "O(log n)"),
                0,
                "Jedna pętla po wszystkich elementach to O(n).",
                code = "def suma(t):\n    s = 0\n    for x in t:\n        s += x\n    return s",
            ),
            choice(
                "Jaka jest złożoność tej funkcji?",
                listOf("O(n²)", "O(n)", "O(2n)", "O(log n)"),
                0,
                "Dla każdego z n elementów wykonujemy n kroków.",
                code = "def pary(t):\n    for a in t:\n        for b in t:\n            print(a, b)",
            ),
            choice(
                "Która operacja jest średnio O(1)?",
                listOf("x in zbior", "x in lista", "lista.index(x)", "sorted(lista)"),
                0,
                "Zbiory (i słowniki) sprawdzają obecność dzięki haszowaniu.",
            ),
            output(
                "n, kroki = 16, 0\nwhile n > 1:\n    n //= 2\n    kroki += 1\nprint(kroki)",
                "4",
                "Dzielenie przez 2 aż do 1 to log₂(16) = 4 kroki – złożoność O(log n).",
            ),
            output(
                "licz = 0\nfor i in range(4):\n    for j in range(i):\n        licz += 1\nprint(licz)",
                "6",
                "0 + 1 + 2 + 3 = 6 – takie pętle to wciąż O(n²).",
            ),
            tiles(
                "Zamień listę lista na zbiór szybki, by szybko sprawdzać obecność elementów",
                listOf("szybki", "=", "set(", "lista", ")"),
                listOf("list(", "dict("),
                "Sprawdzanie x in zbior jest średnio O(1).",
            ),
            fill(
                "Uzupełnij, aby sprawdzanie obecności było szybkie (O(1)).",
                "zakazane = ____([\"spam\", \"reklama\", \"wirus\"])\nprint(\"wirus\" in zakazane)",
                listOf("set", "len", "int"),
                "set",
                "Zbiór sprawdza przynależność w czasie stałym.",
            ),
            output(
                "def ma_duplikaty(t):\n    return len(t) != len(set(t))\nprint(ma_duplikaty([1, 2, 1]))\nprint(ma_duplikaty([1, 2]))",
                "True\nFalse",
                "Zbiór usuwa powtórzenia – O(n) zamiast porównywania każdej pary.",
            ),
        ),
        lesson(
            "u65l4", "Dzień 4: Stosy i kolejki",
            output(
                "stos = []\nstos.append(1)\nstos.append(2)\nstos.append(3)\nprint(stos.pop(), stos.pop())",
                "3 2",
                "Stos to LIFO: pop() zdejmuje ostatnio dodany element.",
            ),
            output(
                "from collections import deque\nq = deque([\"Ola\", \"Jan\"])\nq.append(\"Ewa\")\nprint(q.popleft(), len(q))",
                "Ola 2",
                "Kolejka to FIFO: popleft() zabiera element z początku.",
            ),
            output(
                "def nawiasy(s):\n    stos = []\n    pary = {\")\": \"(\", \"]\": \"[\"}\n    for c in s:\n        if c in \"([\":\n            stos.append(c)\n        elif not stos or stos.pop() != pary[c]:\n            return False\n    return not stos\nprint(nawiasy(\"([])\"), nawiasy(\"(]\"))",
                "True False",
                "Każdy nawias zamykający musi pasować do ostatniego otwartego.",
            ),
            choice(
                "Która zasada opisuje kolejkę?",
                listOf("FIFO – pierwszy wszedł, pierwszy wychodzi", "LIFO – ostatni wszedł, pierwszy wychodzi", "Losowa kolejność", "Najmniejszy wychodzi pierwszy"),
                0,
                "Kolejka działa jak kolejka w sklepie.",
            ),
            fill(
                "Uzupełnij, aby pobrać element z początku kolejki (program ma wypisać 1).",
                "from collections import deque\nq = deque([1, 2, 3])\nprint(q.____())",
                listOf("popleft", "pop", "append"),
                "popleft",
                "popleft() zabiera element z lewej strony.",
            ),
            output(
                "import heapq\nh = [5, 1, 8, 3]\nheapq.heapify(h)\nprint(heapq.heappop(h), heapq.heappop(h))",
                "1 3",
                "Kopiec zawsze oddaje najmniejszy element – to kolejka priorytetowa.",
            ),
            output(
                "stos = []\nfor t in \"3 4 + 2 *\".split():\n    if t.isdigit():\n        stos.append(int(t))\n    else:\n        b, a = stos.pop(), stos.pop()\n        stos.append(a + b if t == \"+\" else a * b)\nprint(stos[0])",
                "14",
                "Odwrotna notacja polska: (3 + 4) * 2 = 14.",
            ),
            tiles(
                "Zdejmij element ze szczytu stosu stos i zapisz go w zmiennej x",
                listOf("x", "=", "stos", ".pop()"),
                listOf(".popleft()", ".pop(0)"),
                "Szczyt stosu to koniec listy, więc wystarczy pop().",
            ),
        ),
        lesson(
            "u65l5", "Dzień 5: Matematyka w algorytmach",
            output(
                "def nwd(a, b):\n    while b:\n        a, b = b, a % b\n    return a\nprint(nwd(48, 18))",
                "6",
                "Algorytm Euklidesa: (48, 18) → (18, 12) → (12, 6) → (6, 0).",
            ),
            output(
                "import math\na, b = 4, 6\nprint(a * b // math.gcd(a, b))",
                "12",
                "NWW = a * b / NWD, a NWD(4, 6) = 2.",
            ),
            output(
                "n = 20\nsito = [True] * (n + 1)\nfor i in range(2, n + 1):\n    if sito[i]:\n        for j in range(i * i, n + 1, i):\n            sito[j] = False\nprint([i for i in range(2, n + 1) if sito[i]])",
                "[2, 3, 5, 7, 11, 13, 17, 19]",
                "Sito Eratostenesa wykreśla wielokrotności kolejnych liczb pierwszych.",
            ),
            fill(
                "Uzupełnij, aby funkcja poprawnie sprawdzała liczby pierwsze (program ma wypisać False True).",
                "def pierwsza(n):\n    if n < 2:\n        return False\n    for d in range(2, int(n ** 0.5) + 1):\n        if n % d == 0:\n            return ____\n    return True\nprint(pierwsza(21), pierwsza(13))",
                listOf("False", "True", "d"),
                "False",
                "Znaleziony dzielnik oznacza, że liczba nie jest pierwsza.",
            ),
            output(
                "def na_binarny(n):\n    cyfry = \"\"\n    while n > 0:\n        cyfry = str(n % 2) + cyfry\n        n //= 2\n    return cyfry\nprint(na_binarny(13), bin(13))",
                "1101 0b1101",
                "Reszty z dzielenia przez 2 czytane od końca dają zapis binarny.",
            ),
            choice(
                "Ile wynoszą 17 % 5 oraz 17 // 5?",
                listOf("2 i 3", "3 i 2", "3.4 i 2", "2 i 3.4"),
                0,
                "17 = 3 * 5 + 2: reszta to 2, a część całkowita to 3.",
            ),
            output(
                "def potega(a, n):\n    if n == 0:\n        return 1\n    p = potega(a, n // 2)\n    return p * p * (a if n % 2 else 1)\nprint(potega(3, 5))",
                "243",
                "Szybkie potęgowanie: 3⁵ = 3² * 3² * 3 = 243 w O(log n) krokach.",
            ),
            tiles(
                "Oblicz sumę cyfr liczby n",
                listOf("suma", "=", "sum(", "int(c)", "for c in", "str(n)", ")"),
                listOf("len(", "int(n)"),
                "Zamieniamy liczbę na napis i sumujemy jej cyfry.",
            ),
        ),
        lesson(
            "u65l6", "Dzień 6: Algorytmy na napisach",
            output(
                "def palindrom(s):\n    s = s.lower().replace(\" \", \"\")\n    return s == s[::-1]\nprint(palindrom(\"Kobyła ma mały bok\"))",
                "True",
                "Po usunięciu spacji i zmianie na małe litery napis czyta się tak samo od tyłu.",
            ),
            output(
                "def ana(a, b):\n    return sorted(a) == sorted(b)\nprint(ana(\"mapa\", \"pama\"), ana(\"ab\", \"aa\"))",
                "True False",
                "Anagramy mają te same litery, więc po posortowaniu są równe.",
            ),
            output(
                "licz = {}\nfor c in \"banan\":\n    licz[c] = licz.get(c, 0) + 1\nprint(licz)",
                "{'b': 1, 'a': 2, 'n': 2}",
                "get(c, 0) zwraca 0 dla litery, której jeszcze nie liczyliśmy.",
            ),
            output(
                "def szyfr(s, k):\n    w = \"\"\n    for c in s:\n        w += chr((ord(c) - 97 + k) % 26 + 97)\n    return w\nprint(szyfr(\"xyz\", 2))",
                "zab",
                "Szyfr Cezara: reszta z dzielenia przez 26 zawija alfabet.",
            ),
            output(
                "s = \"aaabccdd\"\nwynik = \"\"\ni = 0\nwhile i < len(s):\n    j = i\n    while j < len(s) and s[j] == s[i]:\n        j += 1\n    wynik += s[i] + str(j - i)\n    i = j\nprint(wynik)",
                "a3b1c2d2",
                "Kodowanie RLE zapisuje znak i długość jego serii.",
            ),
            fill(
                "Uzupełnij, aby każde słowo zaczynało się wielką literą (Ala Ma Kota).",
                "zdanie = \"ala ma kota\"\nprint(\" \".join(s.____() for s in zdanie.split()))",
                listOf("capitalize", "upper", "lower"),
                "capitalize",
                "capitalize() zmienia pierwszą literę na wielką.",
            ),
            choice(
                "Co zwraca ord(\"a\")?",
                listOf("97", "\"a\"", "1", "65"),
                0,
                "ord() podaje kod znaku – dla „a” to 97, a dla „A” 65.",
            ),
            tiles(
                "Wypisz, czy słowo s jest palindromem",
                listOf("print(", "s", "==", "s[::-1]", ")"),
                listOf("s[::1]", "s[-1]"),
                "s[::-1] to odwrócony napis.",
            ),
        ),
        lesson(
            "u65l7", "Dzień 7: Rekurencja w algorytmach",
            output(
                "def scal_sort(t):\n    if len(t) <= 1:\n        return t\n    m = len(t) // 2\n    a, b = scal_sort(t[:m]), scal_sort(t[m:])\n    w = []\n    while a and b:\n        w.append((a if a[0] <= b[0] else b).pop(0))\n    return w + a + b\nprint(scal_sort([5, 2, 9, 1]))",
                "[1, 2, 5, 9]",
                "Sortowanie przez scalanie dzieli listę na pół i scala posortowane części.",
            ),
            output(
                "def szukaj(t, x, lo, hi):\n    if lo > hi:\n        return -1\n    m = (lo + hi) // 2\n    if t[m] == x:\n        return m\n    if t[m] < x:\n        return szukaj(t, x, m + 1, hi)\n    return szukaj(t, x, lo, m - 1)\nprint(szukaj([1, 4, 7, 9], 9, 0, 3))",
                "3",
                "Rekurencyjne wyszukiwanie binarne zawęża zakres w każdym wywołaniu.",
            ),
            output(
                "def perm(s):\n    if len(s) <= 1:\n        return [s]\n    w = []\n    for i, c in enumerate(s):\n        for p in perm(s[:i] + s[i + 1:]):\n            w.append(c + p)\n    return w\nprint(len(perm(\"abcd\")), perm(\"ab\"))",
                "24 ['ab', 'ba']",
                "Liczba permutacji 4 liter to 4! = 24.",
            ),
            output(
                "def hanoi(n):\n    if n == 0:\n        return 0\n    return 2 * hanoi(n - 1) + 1\nprint(hanoi(4))",
                "15",
                "Wieże Hanoi dla n krążków wymagają 2ⁿ - 1 ruchów.",
            ),
            choice(
                "Co się stanie przy bardzo głębokiej rekurencji (np. 10 000 poziomów)?",
                listOf("RecursionError", "Program zwolni, ale zadziała", "SyntaxError", "Funkcja zwróci None"),
                0,
                "Python ogranicza głębokość rekurencji (domyślnie około 1000).",
            ),
            fill(
                "Uzupełnij, aby fib(80) liczyło się błyskawicznie.",
                "from functools import lru_cache\n@____\ndef fib(n):\n    return n if n < 2 else fib(n - 1) + fib(n - 2)\nprint(fib(80))",
                listOf("lru_cache", "staticmethod", "property"),
                "lru_cache",
                "lru_cache zapamiętuje wyniki, więc każde fib(n) liczy się tylko raz.",
            ),
            output(
                "def gl(t):\n    if not isinstance(t, list):\n        return 0\n    return 1 + max((gl(x) for x in t), default=0)\nprint(gl([1, [2, [3]], []]))",
                "3",
                "Najgłębiej zagnieżdżona jest lista [3] – trzy poziomy.",
            ),
            tiles(
                "Ułóż warunek stopu: dla pustej listy t ustaw wynik na 0",
                listOf("if", "not t:", "wynik = 0"),
                listOf("while", "wynik = t"),
                "Pusta lista jest fałszywa, więc not t to True.",
            ),
        ),
    ),
)
