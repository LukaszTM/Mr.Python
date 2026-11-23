package com.mrpython.app.data.course

import com.mrpython.app.domain.CourseUnit

internal val module73 = CourseUnit(
    id = "u73",
    title = "Wielki finał",
    description = "Łamigłówki łączące cały kurs i świętowanie mistrzostwa",
    lessons = listOf(
        lesson(
            "u73l1", "Łamigłówki: napisy i liczby",
            output(
                "def pal(s):\n    s = \"\".join(c for c in s.lower()\n                if c.isalnum())\n    return s == s[::-1]\nprint(pal(\"Kobyła ma mały bok\"))\nprint(pal(\"Python\"))",
                "True\nFalse",
                "Po usunięciu spacji i wielkich liter sprawdzamy, czy napis czyta się tak samo od końca.",
            ),
            output(
                "def szyfr(t, k):\n    return \"\".join(\n        chr((ord(c) - 97 + k) % 26 + 97)\n        for c in t)\nprint(szyfr(\"xyz\", 3))\nprint(szyfr(\"abc\", 1))",
                "abc\nbcd",
                "Szyfr Cezara: reszta z dzielenia przez 26 zawija alfabet.",
            ),
            output(
                "n = 2 ** 10\nprint(n, sum(map(int, str(n))))",
                "1024 7",
                "1024 → cyfry 1, 0, 2, 4, które sumują się do 7.",
            ),
            fill(
                "Sprawdź, czy słowa są anagramami.",
                "a, b = \"kot\", \"tok\"\nprint(sorted(a) == ____(b))",
                listOf("sorted", "list", "set"),
                "sorted",
                "Anagramy po posortowaniu liter dają identyczne listy.",
            ),
            output(
                "wynik = []\nfor i in range(10, 16):\n    s = \"Fizz\" * (i % 3 == 0)\n    s += \"Buzz\" * (i % 5 == 0)\n    wynik.append(s or str(i))\nprint(\" \".join(wynik))",
                "Buzz 11 Fizz 13 14 FizzBuzz",
                "Mnożenie napisu przez True/False to sprytny zapis FizzBuzz.",
            ),
            choice(
                "Które wyrażenie policzy samogłoski w napisie t?",
                listOf("sum(c in \"aeiouy\" for c in t)", "len(\"aeiouy\" in t)", "t.count(\"aeiouy\")", "max(c in \"aeiouy\" for c in t)"),
                0,
                "True liczy się jak 1, więc suma wartości logicznych to liczba samogłosek.",
            ),
            output(
                "from itertools import groupby\nt = \"aaabcc\"\nkod = [k + str(len(list(g)))\n       for k, g in groupby(t)]\nprint(\"\".join(kod))",
                "a3b1c2",
                "groupby grupuje kolejne takie same znaki – to kodowanie RLE.",
            ),
            tiles(
                "Odwróć każde słowo w zdaniu, zachowując kolejność słów",
                listOf("\" \".join(", "s[::-1]", "for s in", "zdanie.split())"),
                listOf("s[::1]", "zdanie.join())"),
                "Wyrażenie generatorowe odwraca każde słowo osobno.",
            ),
        ),
        lesson(
            "u73l2", "Łamigłówki: struktury danych",
            output(
                "m = [[1, 2, 3], [4, 5, 6]]\nprint([list(r) for r in zip(*m)])",
                "[[1, 4], [2, 5], [3, 6]]",
                "zip(*m) zamienia wiersze z kolumnami – to transpozycja.",
            ),
            output(
                "zagn = [[1], [2, 3], [], [4]]\nprint([x for w in zagn for x in w])",
                "[1, 2, 3, 4]",
                "Podwójna pętla w wyrażeniu spłaszcza listę list.",
            ),
            output(
                "from collections import defaultdict\ng = defaultdict(list)\nfor s in [\"kot\", \"tok\", \"pies\", \"okt\"]:\n    g[\"\".join(sorted(s))].append(s)\nprint(list(g.values()))",
                "[['kot', 'tok', 'okt'], ['pies']]",
                "Anagramy mają ten sam klucz: posortowane litery.",
            ),
            output(
                "def dwie(l, cel):\n    widziane = {}\n    for i, x in enumerate(l):\n        if cel - x in widziane:\n            return widziane[cel - x], i\n        widziane[x] = i\nprint(dwie([2, 7, 11, 15], 9))\nprint(dwie([3, 2, 4], 6))",
                "(0, 1)\n(1, 2)",
                "Słownik pamięta, gdzie widzieliśmy każdą liczbę – jedno przejście wystarczy.",
            ),
            fill(
                "Usuń duplikaty, zachowując kolejność elementów.",
                "dane = [\"b\", \"a\", \"b\", \"c\"]\nprint(list(dict.____(dane)))",
                listOf("fromkeys", "keys", "values"),
                "fromkeys",
                "dict.fromkeys tworzy klucze w kolejności pierwszego wystąpienia.",
            ),
            choice(
                "Dlaczego x in zbior jest zwykle szybsze niż x in lista?",
                listOf("Zbiór używa haszowania – sprawdzenie trwa średnio O(1)", "Zbiór jest zawsze posortowany", "Lista nie obsługuje operatora in", "Zbiory przechowują tylko liczby"),
                0,
                "Lista musi być przeszukana element po elemencie, czyli O(n).",
            ),
            output(
                "import heapq\nprint(heapq.nlargest(3, [5, 1, 9, 3, 7]))\nprint(heapq.nsmallest(2, [5, 1, 9, 3, 7]))",
                "[9, 7, 5]\n[1, 3]",
                "heapq szybko wybiera kilka największych lub najmniejszych elementów.",
            ),
            tiles(
                "Posortuj słowa od najdłuższego",
                listOf("sorted(", "slowa,", "key=len,", "reverse=True)"),
                listOf("key=len()", "reverse=False)"),
                "key=len porównuje długości, a reverse=True odwraca kolejność.",
            ),
        ),
        lesson(
            "u73l3", "Łamigłówki: obiekty i funkcje",
            output(
                "class Odliczanie:\n    def __init__(self, n):\n        self.n = n\n    def __iter__(self):\n        for i in range(self.n, 0, -1):\n            yield i\nprint(list(Odliczanie(3)))",
                "[3, 2, 1]",
                "__iter__ jako generator sprawia, że obiekt da się przeglądać pętlą.",
            ),
            output(
                "from dataclasses import dataclass\n@dataclass(order=True)\nclass Wynik:\n    pkt: int\n    imie: str\nw = [Wynik(5, \"Ola\"), Wynik(9, \"Ala\"),\n     Wynik(5, \"Ewa\")]\nprint([x.imie for x in sorted(w)])",
                "['Ewa', 'Ola', 'Ala']",
                "order=True porównuje pola po kolei: najpierw pkt, potem imie.",
            ),
            output(
                "from functools import reduce\nprint(reduce(lambda a, b: a * b, range(1, 6)))",
                "120",
                "reduce składa listę w jedną wartość: 1·2·3·4·5.",
            ),
            output(
                "kroki = [str.strip, str.lower, str.title]\nt = \"  mR pYTHON \"\nfor f in kroki:\n    t = f(t)\nprint(t)",
                "Mr Python",
                "Funkcje to obiekty – możemy je trzymać na liście i wywoływać po kolei.",
            ),
            choice(
                "Jakie metody musi mieć klasa, by jej obiekt działał w instrukcji with?",
                listOf("__enter__ i __exit__", "__init__ i __del__", "__iter__ i __next__", "__open__ i __close__"),
                0,
                "with wywołuje __enter__ na początku i __exit__ na końcu bloku.",
            ),
            output(
                "class Ramka:\n    def __enter__(self):\n        print(\"[\")\n        return self\n    def __exit__(self, *a):\n        print(\"]\")\nwith Ramka():\n    print(\"Python\")",
                "[\nPython\n]",
                "Menedżer kontekstu otacza blok with kodem przed i po.",
            ),
            fill(
                "Spraw, aby obiekt dało się wywołać jak funkcję.",
                "class Razy:\n    def __init__(self, n):\n        self.n = n\n    def ____(self, x):\n        return x * self.n\nprint(Razy(3)(5))",
                listOf("__call__", "__init__", "__str__"),
                "__call__",
                "__call__ obsługuje wywołanie obiekt(...).",
            ),
            tiles(
                "Utwórz generator kwadratów liczb parzystych mniejszych niż 10",
                listOf("kw", "=", "(x * x", "for x in range(10)", "if x % 2 == 0)"),
                listOf("[x * x", "if x % 2)"),
                "Nawiasy okrągłe tworzą wyrażenie generatorowe.",
            ),
        ),
        lesson(
            "u73l4", "Łamigłówki: wszystko naraz",
            output(
                "def sito(n):\n    p = [True] * (n + 1)\n    p[0] = p[1] = False\n    for i in range(2, int(n ** 0.5) + 1):\n        if p[i]:\n            for j in range(i * i, n + 1, i):\n                p[j] = False\n    return [i for i, b in enumerate(p) if b]\nprint(sito(20))",
                "[2, 3, 5, 7, 11, 13, 17, 19]",
                "Sito Eratostenesa wykreśla wielokrotności kolejnych liczb pierwszych.",
            ),
            output(
                "def hanoi(n):\n    if n == 0:\n        return 0\n    return 2 * hanoi(n - 1) + 1\nprint([hanoi(n) for n in range(1, 6)])",
                "[1, 3, 7, 15, 31]",
                "Wieże Hanoi wymagają 2ⁿ - 1 ruchów.",
            ),
            output(
                "def ok(s):\n    stos, pary = [], {\")\": \"(\", \"]\": \"[\"}\n    for c in s:\n        if c in \"([\":\n            stos.append(c)\n        elif not stos or stos.pop() != pary[c]:\n            return False\n    return not stos\nprint(ok(\"([])\"), ok(\"(]\"), ok(\"((\"))",
                "True False False",
                "Stos pilnuje, by każdy nawias zamykał ostatni otwarty.",
            ),
            choice(
                "Jaka jest złożoność sprawdzania nawiasów stosem dla napisu długości n?",
                listOf("O(n)", "O(n²)", "O(log n)", "O(1)"),
                0,
                "Każdy znak odwiedzamy raz, a operacje na stosie są O(1).",
            ),
            fill(
                "Dodaj dekorator zapamiętujący wyniki, aby fib(80) liczył się błyskawicznie.",
                "from functools import cache\n@____\ndef fib(n):\n    if n < 2:\n        return n\n    return fib(n - 1) + fib(n - 2)\nprint(fib(80))",
                listOf("cache", "property", "print"),
                "cache",
                "@cache zapamiętuje wyniki, więc każde fib(n) liczy się raz.",
            ),
            output(
                "from collections import Counter\na = Counter(\"aab\")\nb = Counter(\"abc\")\nprint(a - b)\nprint(a & b)",
                "Counter({'a': 1})\nCounter({'a': 1, 'b': 1})",
                "- odejmuje liczności, a & bierze minimum z obu liczników.",
            ),
            output(
                "from collections import Counter\ntekst = \"to be or not to be\"\nc = Counter(tekst.split())\ntop = sorted(c, key=lambda s: (-c[s], s))\nprint(top[:2], len(c))",
                "['be', 'to'] 4",
                "Sortujemy po liczbie malejąco, a przy remisie alfabetycznie.",
            ),
            tiles(
                "Wypisz, czy wszystkie liczby na liście są dodatnie",
                listOf("print(", "all(", "x > 0", "for x in liczby", "))"),
                listOf("any(", "x >= 0"),
                "all() zwraca True, gdy warunek jest spełniony dla każdego elementu.",
            ),
        ),
        lesson(
            "u73l5", "Dzień 365: Mistrz Pythona",
            output(
                "dni = 365\nprint(f\"Ukończone dni: {dni}\")\nprint(dni // 7, dni % 7)",
                "Ukończone dni: 365\n52 1",
                "Rok nauki to 52 pełne tygodnie i jeden dzień – gratulacje!",
            ),
            output(
                "tytul = \"Mistrz\"\nramka = \"*\" * (len(tytul) + 4)\nprint(ramka)\nprint(f\"* {tytul} *\")\nprint(ramka)",
                "**********\n* Mistrz *\n**********",
                "Twój certyfikat w trzech linijkach: ramka ma długość tytułu plus 4.",
            ),
            output(
                "moduly = {\"podstawy\": 11, \"dalej\": 56,\n          \"finał\": 6}\nprint(sum(moduly.values()))\nprint(max(moduly, key=moduly.get))",
                "73\ndalej",
                "Za Tobą 73 moduły – najwięcej było w środkowej części kursu.",
            ),
            choice(
                "Które zdanie pochodzi z Zen of Python (import this)?",
                listOf("Simple is better than complex.", "Fast is better than slow.", "More is better than less.", "Clever is better than clear."),
                0,
                "Prostota to jedna z głównych zasad Pythona.",
            ),
            fill(
                "Wypisz zdobyte poziomy, numerując je od 1.",
                "poziomy = [\"uczeń\", \"czeladnik\", \"mistrz\"]\nfor nr, p in ____(poziomy, 1):\n    print(nr, p)",
                listOf("enumerate", "zip", "range"),
                "enumerate",
                "enumerate(lista, 1) numeruje elementy od jedynki.",
            ),
            output(
                "def droga():\n    yield from [\"zmienne\", \"pętle\", \"klasy\"]\n    yield \"MISTRZ\"\nprint(\" > \".join(droga()))",
                "zmienne > pętle > klasy > MISTRZ",
                "yield from oddaje wszystkie elementy listy, a potem dokładamy finał.",
            ),
            output(
                "from collections import Counter\numiejetnosci = [\"pętle\", \"klasy\", \"pętle\",\n                \"algorytmy\", \"pętle\"]\nc = Counter(umiejetnosci)\nulubiona, ile = c.most_common(1)[0]\nprint(f\"{ulubiona} x{ile}\")\nprint(f\"Opanowane: {len(c)}\")",
                "pętle x3\nOpanowane: 3",
                "Counter, rozpakowanie i f-string – wszystko, czego się nauczyłeś, w jednym miejscu.",
            ),
            tiles(
                "Wypisz swój tytuł za pomocą f-stringu",
                listOf("print(", "f\"Dzień {dzien}:", "Mistrz Pythona!\"", ")"),
                listOf("echo(", "\"Uczeń\""),
                "Gratulacje – f-string wstawia numer dnia, a Ty jesteś Mistrzem Pythona!",
            ),
        ),
    ),
)
