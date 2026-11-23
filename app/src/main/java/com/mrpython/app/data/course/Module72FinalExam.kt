package com.mrpython.app.data.course

import com.mrpython.app.domain.CourseUnit

internal val module72 = CourseUnit(
    id = "u72",
    title = "Egzamin końcowy",
    description = "Sprawdź się z całego kursu – trochę trudniej niż zwykle",
    lessons = listOf(
        lesson(
            "u72l1", "Egzamin, część 1: podstawy",
            output(
                "print(7 // 2, -7 // 2, 7 % -2)",
                "3 -4 -1",
                "// zaokrągla w dół (także dla ujemnych), a reszta ma znak dzielnika.",
            ),
            output(
                "print(2 ** 3 ** 2)",
                "512",
                "Potęgowanie wiąże od prawej: 3 ** 2 = 9, potem 2 ** 9.",
            ),
            output(
                "x = 5\nx += x * 2\nprint(x)",
                "15",
                "x += x * 2 to x = 5 + 10.",
            ),
            choice(
                "Co wypisze ten kod?",
                listOf("False", "True", "0.3", "Błąd"),
                0,
                "0.1 * 3 to w pamięci 0.30000000000000004, więc porównanie daje False.",
                code = "print(0.1 * 3 == 0.3)",
            ),
            output(
                "s = \"Python\"\nprint(s[::-2], s[1:-1:2])",
                "nhy yh",
                "Krok -2 idzie od końca co drugi znak; s[1:-1:2] bierze y i h.",
            ),
            fill(
                "Wypisz liczby od 10 do 1 włącznie, malejąco.",
                "for i in range(10, ____, -1):\n    print(i, end=\" \")",
                listOf("0", "1", "-1"),
                "0",
                "Koniec range jest wyłączny, więc żeby dojść do 1, kończymy na 0.",
            ),
            output(
                "for i in range(3):\n    if i == 5:\n        break\nelse:\n    print(\"bez break\")\nprint(i)",
                "bez break\n2",
                "else pętli wykonuje się, gdy pętla nie została przerwana przez break.",
            ),
            tiles(
                "Wypisz, czy x leży między 1 a 10 włącznie (porównanie łańcuchowe)",
                listOf("print(", "1 <= x", "<= 10", ")"),
                listOf("and", "=< 10"),
                "Python pozwala łączyć porównania: 1 <= x <= 10.",
            ),
        ),
        lesson(
            "u72l2", "Egzamin, część 2: struktury danych",
            output(
                "a = [1, 2]\nb = a\nb.append(3)\nprint(a, a is b)",
                "[1, 2, 3] True",
                "b = a nie kopiuje listy – obie nazwy wskazują ten sam obiekt.",
            ),
            output(
                "m = [[0] * 2] * 2\nm[0][0] = 1\nprint(m)",
                "[[1, 0], [1, 0]]",
                "* 2 powiela referencję do tej samej listy wewnętrznej.",
            ),
            output(
                "t = (1, [2])\nt[1].append(3)\nprint(t)",
                "(1, [2, 3])",
                "Krotki nie można zmienić, ale lista w środku nadal jest zmienna.",
            ),
            choice(
                "Który obiekt może być kluczem słownika?",
                listOf("(1, 2)", "[1, 2]", "{1: 2}", "{1, 2}"),
                0,
                "Kluczem może być tylko obiekt niezmienny (haszowalny), np. krotka.",
            ),
            output(
                "print({1, 2, 3} & {2, 3, 4})\nprint({1, 2} | {5})",
                "{2, 3}\n{1, 2, 5}",
                "& to część wspólna, | to suma zbiorów.",
            ),
            output(
                "d = {\"a\": 1, \"b\": 2}\nodwr = {v: k for k, v in d.items()}\nprint(odwr[2])",
                "b",
                "Wyrażenie słownikowe zamienia klucze z wartościami.",
            ),
            fill(
                "Posortuj słowa od najdłuższego do najkrótszego.",
                "slowa = [\"ab\", \"a\", \"abc\"]\nprint(sorted(slowa, key=len, reverse=____))",
                listOf("True", "False", "key"),
                "True",
                "reverse=True odwraca kolejność sortowania.",
            ),
            output(
                "from collections import deque\nq = deque([1, 2, 3])\nq.rotate(1)\nq.appendleft(0)\nprint(list(q))",
                "[0, 3, 1, 2]",
                "rotate(1) przesuwa ostatni element na początek, a potem dokładamy 0.",
            ),
        ),
        lesson(
            "u72l3", "Egzamin, część 3: funkcje",
            output(
                "def f(x, lista=[]):\n    lista.append(x)\n    return lista\nf(1)\nprint(f(2))",
                "[1, 2]",
                "Domyślna lista tworzy się raz i jest współdzielona między wywołaniami.",
            ),
            output(
                "def licznik():\n    n = 0\n    def inc():\n        nonlocal n\n        n += 1\n        return n\n    return inc\nc = licznik()\nc()\nprint(c(), c())",
                "2 3",
                "Domknięcie pamięta zmienną n między wywołaniami.",
            ),
            output(
                "def f(*a, **k):\n    return len(a), sorted(k)\nprint(f(1, 2, x=3, b=4))",
                "(2, ['b', 'x'])",
                "*a zbiera argumenty pozycyjne, **k nazwane (słownik).",
            ),
            output(
                "pary = [(1, \"b\"), (2, \"a\"), (3, \"b\")]\nprint(sorted(pary, key=lambda p: p[1])[0])",
                "(2, 'a')",
                "Sortujemy po drugim elemencie, więc pierwsza jest para z \"a\".",
            ),
            fill(
                "Uzupełnij, aby funkcja była generatorem.",
                "def gen():\n    for i in range(3):\n        ____ i * 2\nprint(list(gen()))",
                listOf("yield", "return", "print"),
                "yield",
                "yield zwraca kolejne wartości bez kończenia funkcji.",
            ),
            output(
                "def glosno(f):\n    def w(*a):\n        return f(*a).upper()\n    return w\n@glosno\ndef hej(imie):\n    return f\"hej {imie}\"\nprint(hej(\"ola\"))",
                "HEJ OLA",
                "Dekorator opakowuje funkcję i zmienia jej wynik.",
            ),
            choice(
                "Co zwróci f(4)?",
                listOf("24", "10", "4", "16"),
                0,
                "To silnia: 4 · 3 · 2 · 1 = 24.",
                code = "def f(n):\n    return 1 if n == 0 else n * f(n - 1)",
            ),
            tiles(
                "Zapisz w zmiennej dodaj funkcję anonimową sumującą dwie liczby",
                listOf("dodaj", "=", "lambda", "x, y:", "x + y"),
                listOf("def", "return"),
                "lambda x, y: x + y tworzy funkcję w jednym wyrażeniu.",
            ),
        ),
        lesson(
            "u72l4", "Egzamin, część 4: programowanie obiektowe",
            output(
                "class A:\n    def kto(self):\n        return \"A\"\nclass B(A):\n    def kto(self):\n        return \"B\" + super().kto()\nprint(B().kto())",
                "BA",
                "super() wywołuje wersję metody z klasy bazowej.",
            ),
            output(
                "class K:\n    n = 0\n    def __init__(self):\n        K.n += 1\nK(); K(); K()\nprint(K.n)",
                "3",
                "Atrybut klasy jest wspólny dla wszystkich obiektów.",
            ),
            output(
                "class P:\n    def __init__(self, x):\n        self.x = x\n    def __repr__(self):\n        return f\"P({self.x})\"\n    def __add__(self, o):\n        return P(self.x + o.x)\nprint(P(1) + P(2))",
                "P(3)",
                "__add__ definiuje działanie +, a __repr__ wygląd wyniku.",
            ),
            choice(
                "Jaka jest kolejność szukania metod (MRO) dla klasy D?",
                listOf("D, B, C, A, object", "D, B, A, C, object", "D, C, B, A, object", "D, A, B, C, object"),
                0,
                "Python przegląda klasy bazowe od lewej, a wspólnego przodka A dopiero na końcu.",
                code = "class A: pass\nclass B(A): pass\nclass C(A): pass\nclass D(B, C): pass",
            ),
            fill(
                "Uzupełnij dekorator, aby pole odczytywać bez nawiasów.",
                "class Kwadrat:\n    def __init__(self, a):\n        self.a = a\n    @____\n    def pole(self):\n        return self.a ** 2\nprint(Kwadrat(3).pole)",
                listOf("property", "staticmethod", "classmethod"),
                "property",
                "@property zamienia metodę w atrybut tylko do odczytu.",
            ),
            output(
                "class Torba:\n    def __init__(self):\n        self.r = [\"a\", \"b\"]\n    def __len__(self):\n        return len(self.r)\n    def __contains__(self, x):\n        return x in self.r\nt = Torba()\nprint(len(t), \"a\" in t, \"z\" in t)",
                "2 True False",
                "__len__ obsługuje len(), a __contains__ operator in.",
            ),
            output(
                "class Zwierze:\n    def glos(self):\n        return \"...\"\nclass Pies(Zwierze):\n    def glos(self):\n        return \"Hau\"\nclass Ryba(Zwierze):\n    pass\nprint([z.glos() for z in [Pies(), Ryba()]])",
                "['Hau', '...']",
                "Polimorfizm: Ryba nie nadpisuje glos(), więc używa wersji z Zwierze.",
            ),
            tiles(
                "Zdefiniuj klasę Kot dziedziczącą po Zwierze",
                listOf("class", "Kot", "(Zwierze)", ":"),
                listOf("extends", "def"),
                "Klasę bazową podajemy w nawiasie po nazwie klasy.",
            ),
        ),
        lesson(
            "u72l5", "Egzamin, część 5: biblioteka standardowa",
            output(
                "from collections import Counter\nprint(Counter(\"mississippi\").most_common(2))",
                "[('i', 4), ('s', 4)]",
                "i oraz s występują po 4 razy; przy remisie decyduje kolejność pojawienia się.",
            ),
            output(
                "from itertools import accumulate, permutations\nprint(list(accumulate([1, 2, 3, 4])))\nprint(len(list(permutations(range(4), 2))))",
                "[1, 3, 6, 10]\n12",
                "accumulate daje sumy narastające, a par uporządkowanych z 4 elementów jest 4 · 3.",
            ),
            output(
                "import math\nprint(math.gcd(12, 18), math.isqrt(17))\nprint(math.ceil(-1.5))",
                "6 4\n-1",
                "NWD to 6, całkowity pierwiastek z 17 to 4, a ceil(-1.5) to -1.",
            ),
            output(
                "from datetime import date, timedelta\nd = date(2024, 2, 28) + timedelta(days=2)\nprint(d)",
                "2024-03-01",
                "Rok 2024 jest przestępny, więc po 28 lutego jest jeszcze 29 lutego.",
            ),
            fill(
                "Zamień słownik na napis w formacie JSON.",
                "import json\nprint(json.____({\"a\": 1}))",
                listOf("dumps", "loads", "load"),
                "dumps",
                "dumps (dump string) zamienia obiekt na napis JSON.",
            ),
            choice(
                "Do czego służy functools.lru_cache?",
                listOf("Zapamiętuje wyniki funkcji dla tych samych argumentów", "Usuwa nieużywane zmienne", "Przyspiesza pętle for", "Zapisuje wyniki do pliku"),
                0,
                "Memoizacja sprawia, że ponowne wywołanie z tymi samymi argumentami jest natychmiastowe.",
            ),
            output(
                "import re\nprint(re.findall(r\"\\d+\", \"a1b22c333\"))",
                "['1', '22', '333']",
                "\\d+ dopasowuje ciągi cyfr.",
            ),
            tiles(
                "Posortuj listę słowników ludzie po kluczu \"wiek\"",
                listOf("sorted(", "ludzie,", "key=itemgetter(", "\"wiek\"))"),
                listOf("key=\"wiek\")", "reverse=itemgetter("),
                "operator.itemgetter(\"wiek\") działa jak lambda d: d[\"wiek\"].",
            ),
        ),
        lesson(
            "u72l6", "Egzamin, część 6: algorytmy",
            output(
                "def szukaj(l, x):\n    lo, hi = 0, len(l) - 1\n    while lo <= hi:\n        m = (lo + hi) // 2\n        if l[m] == x: return m\n        if l[m] < x: lo = m + 1\n        else: hi = m - 1\n    return -1\nprint(szukaj([1, 3, 5, 7, 9], 7))",
                "3",
                "Wyszukiwanie binarne znajduje 7 pod indeksem 3.",
            ),
            choice(
                "Jaka jest złożoność wyszukiwania binarnego?",
                listOf("O(log n)", "O(n)", "O(n log n)", "O(1)"),
                0,
                "W każdym kroku odrzucamy połowę danych.",
            ),
            output(
                "import bisect\nl = [1, 3, 5]\nbisect.insort(l, 4)\nprint(l, bisect.bisect_left(l, 5))",
                "[1, 3, 4, 5] 3",
                "insort wstawia z zachowaniem porządku, a 5 jest teraz pod indeksem 3.",
            ),
            output(
                "from functools import cache\n@cache\ndef fib(n):\n    if n < 2:\n        return n\n    return fib(n - 1) + fib(n - 2)\nprint(fib(30))",
                "832040",
                "Dzięki @cache każda wartość liczy się tylko raz.",
            ),
            choice(
                "Jaka jest pesymistyczna złożoność sortowania przez wstawianie?",
                listOf("O(n²)", "O(n log n)", "O(n)", "O(log n)"),
                0,
                "Dla odwrotnie posortowanych danych każdy element przesuwamy przez całą część posortowaną.",
            ),
            output(
                "from collections import deque\nG = {\"A\": [\"B\", \"C\"], \"B\": [\"D\"],\n     \"C\": [\"D\"], \"D\": []}\nkolejka, odw = deque([\"A\"]), [\"A\"]\nwhile kolejka:\n    for s in G[kolejka.popleft()]:\n        if s not in odw:\n            odw.append(s)\n            kolejka.append(s)\nprint(odw)",
                "['A', 'B', 'C', 'D']",
                "BFS odwiedza wierzchołki warstwami: A, potem B i C, potem D.",
            ),
            fill(
                "Uzupełnij warunek, aby scalić dwie posortowane listy rosnąco.",
                "def scal(a, b):\n    w, i, j = [], 0, 0\n    while i < len(a) and j < len(b):\n        if a[i] ____ b[j]:\n            w.append(a[i]); i += 1\n        else:\n            w.append(b[j]); j += 1\n    return w + a[i:] + b[j:]\nprint(scal([1, 4], [2, 3]))",
                listOf("<=", ">=", "=="),
                "<=",
                "Do wyniku bierzemy zawsze mniejszy z dwóch pierwszych elementów.",
            ),
            tiles(
                "Odwróć listę za pomocą wycinka",
                listOf("odwrocona", "=", "lista[", "::-1]"),
                listOf("::1]", "-1::]"),
                "Krok -1 przechodzi listę od końca.",
            ),
        ),
    ),
)
