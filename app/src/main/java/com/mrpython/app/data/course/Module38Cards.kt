package com.mrpython.app.data.course

internal val module38Cards = listOf(
    cards(
        "u38l1",
        explain(
            "Counter to słownik",
            "Counter działa jak słownik: element to klucz, a liczba wystąpień to wartość. Można go " +
                "zmieniać (`c[\"b\"] += 2`), a `len(c)` mówi, ile jest różnych elementów. " +
                "`print(c)` pokazuje pary od najczęstszej, opakowane nazwą `Counter`.",
            code = "from collections import Counter\nc = Counter(\"aab\")\nc[\"b\"] += 2\nprint(c)\nprint(len(c), dict(c))",
            output = "Counter({'b': 3, 'a': 2})\n2 {'a': 2, 'b': 3}",
        ),
        explain(
            "most_common() bez liczby",
            "`most_common()` bez argumentu zwraca wszystkie pary (element, liczba) od najczęstszej " +
                "do najrzadszej. Przy remisie pierwszy jest element, który pojawił się wcześniej.",
            code = "from collections import Counter\nprint(Counter(\"banan\").most_common())",
            output = "[('a', 2), ('n', 2), ('b', 1)]",
        ),
        explain(
            "Liczenie słów",
            "Counter liczy elementy tego, co dostanie. Z napisu liczy litery, ale z listy słów " +
                "(np. po `split()`) liczy całe słowa.",
            code = "from collections import Counter\nc = Counter(\"to jest to\".split())\nprint(c[\"to\"], c[\"jest\"])",
            output = "2 1",
        ),
    ),
    cards(
        "u38l2",
        explain(
            "Odczyt tworzy klucz",
            "W `defaultdict` już samo odczytanie brakującego klucza dodaje go do słownika z wartością " +
                "domyślną. Sprawdzenie `in` niczego nie tworzy. `dict(d)` zamienia go na zwykły słownik.",
            code = "from collections import defaultdict\nd = defaultdict(int)\nprint(\"x\" in d)\nprint(d[\"x\"], len(d))\nprint(dict(d))",
            output = "False\n0 1\n{'x': 0}",
        ),
        explain(
            "Inne wartości domyślne",
            "Można podać dowolną funkcję bez argumentów: `str` daje pusty napis, `set` pusty zbiór, " +
                "a `lambda: \"brak\"` – własną wartość.",
            code = "from collections import defaultdict\nd = defaultdict(lambda: \"brak\")\nz = defaultdict(set)\nz[\"a\"].add(1)\nprint(d[\"y\"], z[\"a\"])",
            output = "brak {1}",
        ),
    ),
    cards(
        "u38l3",
        explain(
            "Tworzenie i rozpakowanie",
            "Pola można podać po nazwie, w dowolnej kolejności. namedtuple to krotka, więc da się ją " +
                "rozpakować, porównać ze zwykłą krotką i użyć `len` czy `in`.",
            code = "from collections import namedtuple\nP = namedtuple(\"P\", [\"x\", \"y\"])\np = P(y=2, x=7)\nx, y = p\nprint(p, x)\nprint(p == (7, 2), len(p))",
            output = "P(x=7, y=2) 7\nTrue 2",
        ),
        explain(
            "_replace – zmieniona kopia",
            "namedtuple jest niezmienna, więc `p.x = 5` daje błąd. Metoda `_replace(pole=wartość)` " +
                "tworzy nową krotkę ze zmienionym polem, a oryginał zostaje bez zmian.",
            code = "from collections import namedtuple\nP = namedtuple(\"P\", [\"x\", \"y\"])\np = P(1, 2)\nq = p._replace(y=9)\nprint(p, q)",
            output = "P(x=1, y=2) P(x=1, y=9)",
        ),
    ),
    cards(
        "u38l4",
        explain(
            "Kierunek rotate",
            "`rotate(n)` z dodatnim n przesuwa elementy w prawo: ostatnie trafiają na początek. " +
                "Ujemne n obraca w lewo: pierwsze trafiają na koniec.",
            code = "from collections import deque\nd = deque([1, 2, 3, 4])\nd.rotate(1)\nprint(list(d))\nd.rotate(-2)\nprint(list(d))",
            output = "[4, 1, 2, 3]\n[2, 3, 4, 1]",
        ),
        explain(
            "deque jak lista",
            "deque tworzymy z listy, napisu czy `range`, a `maxlen` zostawia tylko ostatnie elementy. " +
                "Działa `len`, indeksy `d[0]` i `d[-1]`, a `print` pokazuje ją z nazwą `deque`.",
            code = "from collections import deque\nd = deque(\"abcd\", maxlen=3)\nprint(d)\nprint(len(d), d[0], d.maxlen)",
            output = "deque(['b', 'c', 'd'], maxlen=3)\n3 b 3",
        ),
        explain(
            "Usunięty klucz wraca na koniec",
            "Słownik pamięta kolejność wstawiania. Gdy usuniesz klucz przez `del` i wstawisz go " +
                "ponownie, trafi na koniec kolejności.",
            code = "d = {\"a\": 1, \"b\": 2}\ndel d[\"a\"]\nd[\"a\"] = 9\nprint(list(d))",
            output = "['b', 'a']",
        ),
    ),
)
