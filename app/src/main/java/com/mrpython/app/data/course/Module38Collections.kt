package com.mrpython.app.data.course

import com.mrpython.app.domain.CourseUnit

internal val module38 = CourseUnit(
    id = "u38",
    title = "Moduł collections",
    description = "Counter, defaultdict, namedtuple, deque i OrderedDict",
    lessons = listOf(
        lesson(
            "u38l1", "Counter",
            output(
                "from collections import Counter\nc = Counter(\"abrakadabra\")\nprint(c[\"a\"])",
                "5",
                "Counter liczy wystąpienia – litera „a” występuje 5 razy.",
            ),
            choice(
                "Co zwróci c[7] dla tego Countera?",
                listOf("0", "KeyError", "None", "7"),
                0,
                "Dla brakującego elementu Counter zwraca 0 zamiast KeyError.",
                code = "from collections import Counter\nc = Counter([1, 2, 2, 3, 3, 3])",
            ),
            output(
                "from collections import Counter\nc = Counter(\"kot\")\nprint(c)",
                "Counter({'k': 1, 'o': 1, 't': 1})",
                "Counter wypisuje się jak słownik opakowany nazwą klasy.",
            ),
            output(
                "from collections import Counter\nc = Counter(\"mama ma\")\nprint(c.most_common(1))",
                "[('m', 3)]",
                "most_common(1) zwraca listę z jedną parą: najczęstszy element i jego liczba.",
            ),
            fill(
                "Uzupełnij, aby wypisać dwa najczęstsze słowa.",
                "from collections import Counter\nslowa = [\"a\", \"b\", \"a\", \"c\", \"a\", \"b\"]\nc = Counter(slowa)\nprint(c.____(2))",
                listOf("most_common", "top", "max", "count"),
                "most_common",
                "Metoda most_common(n) zwraca n najczęstszych elementów.",
            ),
            choice(
                "Skąd importujemy Counter?",
                listOf("from collections import Counter", "import Counter", "from itertools import Counter", "from math import Counter"),
                0,
                "Counter jest w module collections.",
            ),
            output(
                "from collections import Counter\nc = Counter(\"aab\")\nc[\"b\"] += 2\nprint(c.most_common())",
                "[('b', 3), ('a', 2)]",
                "Counter można zmieniać jak słownik; most_common() bez argumentu sortuje wszystko malejąco.",
            ),
            tiles(
                "Policz litery w słowie \"lalka\"",
                listOf("c", "=", "Counter(", "\"lalka\"", ")"),
                listOf("Counter[", "]"),
                "Counter przyjmuje dowolny obiekt, po którym da się iterować, np. napis.",
            ),
        ),
        lesson(
            "u38l2", "defaultdict",
            output(
                "from collections import defaultdict\nd = defaultdict(int)\nd[\"x\"] += 1\nd[\"x\"] += 1\nprint(d[\"x\"])",
                "2",
                "defaultdict(int) tworzy brakujący klucz z wartością 0.",
            ),
            choice(
                "Co wypisze ten kod?",
                listOf("0", "KeyError", "None", "brak"),
                0,
                "Odczyt brakującego klucza nie daje KeyError – powstaje wartość domyślna int(), czyli 0.",
                code = "from collections import defaultdict\nd = defaultdict(int)\nprint(d[\"brak\"])",
            ),
            output(
                "from collections import defaultdict\nd = defaultdict(list)\nd[\"a\"].append(1)\nd[\"a\"].append(2)\nprint(d[\"a\"])",
                "[1, 2]",
                "defaultdict(list) tworzy pustą listę dla nowego klucza.",
            ),
            output(
                "from collections import defaultdict\ngrupy = defaultdict(list)\nfor s in [\"ala\", \"ola\", \"ewa\", \"adam\"]:\n    grupy[s[0]].append(s)\nprint(grupy[\"a\"])",
                "['ala', 'adam']",
                "Słowa zostały pogrupowane po pierwszej literze.",
            ),
            fill(
                "Uzupełnij, aby brakujące klucze dostawały pustą listę.",
                "from collections import defaultdict\nd = defaultdict(____)\nd[\"k\"].append(5)\nprint(d[\"k\"])",
                listOf("list", "int", "[]", "None"),
                "list",
                "Przekazujemy samą funkcję list (bez nawiasów), która tworzy pustą listę.",
            ),
            choice(
                "Co przekazujemy do defaultdict?",
                listOf("Funkcję tworzącą wartość domyślną, np. int", "Gotową wartość, np. 0", "Nazwę klucza", "Liczbę elementów"),
                0,
                "defaultdict wywołuje podaną funkcję, gdy brakuje klucza.",
            ),
            output(
                "from collections import defaultdict\nd = defaultdict(int)\nfor z in \"kajak\":\n    d[z] += 1\nprint(dict(d))",
                "{'k': 2, 'a': 2, 'j': 1}",
                "To ręczne liczenie liter – klucze są w kolejności pierwszego pojawienia się.",
            ),
            choice(
                "Co się stanie w zwykłym słowniku przy d[\"x\"] += 1, gdy klucza \"x\" nie ma?",
                listOf("KeyError", "Klucz dostanie wartość 1", "Klucz dostanie wartość 0", "Nic"),
                0,
                "Zwykły dict nie zna wartości domyślnej, więc zgłasza KeyError.",
            ),
        ),
        lesson(
            "u38l3", "namedtuple",
            output(
                "from collections import namedtuple\nPunkt = namedtuple(\"Punkt\", [\"x\", \"y\"])\np = Punkt(3, 4)\nprint(p.x + p.y)",
                "7",
                "Do pól namedtuple odwołujemy się po nazwie.",
            ),
            output(
                "from collections import namedtuple\nPunkt = namedtuple(\"Punkt\", [\"x\", \"y\"])\np = Punkt(1, 2)\nprint(p)",
                "Punkt(x=1, y=2)",
                "namedtuple ma czytelny zapis z nazwami pól.",
            ),
            output(
                "from collections import namedtuple\nPunkt = namedtuple(\"Punkt\", [\"x\", \"y\"])\np = Punkt(5, 6)\nprint(p[0])",
                "5",
                "namedtuple to nadal krotka – działa też indeksowanie.",
            ),
            output(
                "from collections import namedtuple\nOsoba = namedtuple(\"Osoba\", [\"imie\", \"wiek\"])\nimie, wiek = Osoba(\"Ola\", 30)\nprint(imie)",
                "Ola",
                "namedtuple można rozpakować jak zwykłą krotkę.",
            ),
            choice(
                "Co się stanie po p.x = 10, gdy p jest namedtuple?",
                listOf("AttributeError – namedtuple jest niezmienna", "x zmieni się na 10", "Powstanie nowe pole", "SyntaxError"),
                0,
                "Jak każda krotka, namedtuple jest niemutowalna.",
                code = "from collections import namedtuple\nP = namedtuple(\"P\", [\"x\"])\np = P(1)\np.x = 10",
            ),
            fill(
                "Uzupełnij, aby utworzyć typ Kolor z polami r, g, b.",
                "from collections import namedtuple\nKolor = ____(\"Kolor\", [\"r\", \"g\", \"b\"])\nprint(Kolor(1, 2, 3).g)",
                listOf("namedtuple", "tuple", "dict", "Counter"),
                "namedtuple",
                "namedtuple tworzy nowy typ krotki z nazwanymi polami.",
            ),
            output(
                "from collections import namedtuple\nP = namedtuple(\"P\", [\"x\", \"y\"])\np = P(1, 2)\nq = p._replace(y=9)\nprint(p.y, q.y)",
                "2 9",
                "_replace tworzy nową krotkę, oryginał się nie zmienia.",
            ),
            tiles(
                "Utwórz punkt p o współrzędnych 2 i 5",
                listOf("p", "=", "Punkt(", "2,", "5", ")"),
                listOf("Punkt[", "]"),
                "Typ z namedtuple wywołujemy jak klasę.",
            ),
        ),
        lesson(
            "u38l4", "deque i kolejność w dict",
            output(
                "from collections import deque\nd = deque([1, 2, 3])\nd.appendleft(0)\nd.append(4)\nprint(list(d))",
                "[0, 1, 2, 3, 4]",
                "deque pozwala szybko dodawać z obu stron.",
            ),
            output(
                "from collections import deque\nd = deque([1, 2, 3])\nprint(d.popleft(), d.pop())",
                "1 3",
                "popleft zdejmuje z lewej, pop z prawej.",
            ),
            output(
                "from collections import deque\nd = deque([1, 2, 3, 4])\nd.rotate(1)\nprint(list(d))",
                "[4, 1, 2, 3]",
                "rotate(1) przesuwa elementy o jedno miejsce w prawo.",
            ),
            choice(
                "Jak będzie wyglądać deque po d.rotate(-1)?",
                listOf("[2, 3, 4, 1]", "[4, 1, 2, 3]", "[1, 2, 3]", "[1, 2, 3, 4]"),
                0,
                "Ujemny argument obraca w lewo.",
                code = "from collections import deque\nd = deque([1, 2, 3, 4])\nd.rotate(-1)",
            ),
            output(
                "from collections import deque\nd = deque(maxlen=3)\nfor i in range(5):\n    d.append(i)\nprint(list(d))",
                "[2, 3, 4]",
                "Przy maxlen najstarsze elementy wypadają z drugiej strony.",
            ),
            fill(
                "Uzupełnij, aby deque pamiętała tylko 2 ostatnie elementy.",
                "from collections import deque\nd = deque(____=2)\nfor x in \"abc\":\n    d.append(x)\nprint(list(d))",
                listOf("maxlen", "size", "limit", "len"),
                "maxlen",
                "Parametr maxlen ogranicza długość kolejki.",
            ),
            output(
                "d = {}\nd[\"b\"] = 1\nd[\"a\"] = 2\nd[\"c\"] = 3\nprint(list(d))",
                "['b', 'a', 'c']",
                "Od Pythona 3.7 zwykły dict pamięta kolejność wstawiania.",
            ),
            output(
                "from collections import OrderedDict\nd = OrderedDict(a=1, b=2, c=3)\nd.move_to_end(\"a\")\nprint(list(d))",
                "['b', 'c', 'a']",
                "OrderedDict ma dodatkowe metody, np. move_to_end.",
            ),
        ),
        lesson(
            "u38l5", "Powtórka: collections",
            choice(
                "Którego narzędzia użyjesz do policzenia, ile razy występuje każde słowo?",
                listOf("Counter", "deque", "namedtuple", "OrderedDict"),
                0,
                "Counter służy do zliczania.",
            ),
            choice(
                "Które narzędzie najlepiej sprawdzi się jako kolejka z szybkim usuwaniem z początku?",
                listOf("deque", "list", "Counter", "namedtuple"),
                0,
                "deque.popleft() działa szybko, a list.pop(0) musi przesuwać elementy.",
            ),
            output(
                "from collections import Counter\nc = Counter([\"x\", \"y\", \"x\"])\nprint(c.most_common(1)[0][0])",
                "x",
                "Bierzemy pierwszą parę i z niej sam element.",
            ),
            output(
                "from collections import defaultdict\nd = defaultdict(int)\nfor n in [1, 2, 1, 1]:\n    d[n] += 1\nprint(d[1], d[2], d[3])",
                "3 1 0",
                "Brakujący klucz 3 dostaje wartość 0.",
            ),
            output(
                "from collections import deque\nd = deque(\"abc\", maxlen=3)\nd.append(\"d\")\nprint(\"\".join(d))",
                "bcd",
                "Dodanie „d” wypchnęło „a” z lewej strony.",
            ),
            fill(
                "Uzupełnij, aby przesunąć elementy o 2 miejsca w prawo.",
                "from collections import deque\nd = deque([1, 2, 3, 4])\nd.____(2)\nprint(list(d))",
                listOf("rotate", "shift", "move", "roll"),
                "rotate",
                "Obracanie deque to metoda rotate.",
            ),
            output(
                "from collections import namedtuple\nKarta = namedtuple(\"Karta\", [\"kolor\", \"wartosc\"])\nk = Karta(\"pik\", 10)\nprint(k.wartosc * 2)",
                "20",
                "Pole wartosc ma wartość 10.",
            ),
            tiles(
                "Utwórz słownik, w którym brakujące klucze mają pustą listę",
                listOf("d", "=", "defaultdict(", "list", ")"),
                listOf("list()", "Counter("),
                "defaultdict(list) tworzy pustą listę dla nowego klucza.",
            ),
        ),
    ),
)
