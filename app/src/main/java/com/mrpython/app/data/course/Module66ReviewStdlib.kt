package com.mrpython.app.data.course

import com.mrpython.app.domain.CourseUnit

internal val module66 = CourseUnit(
    id = "u66",
    title = "Tydzień powtórek: biblioteka standardowa",
    description = "math, datetime, collections, itertools, functools, re i json",
    lessons = listOf(
        lesson(
            "u66l1", "Dzień 1: math",
            output(
                "import math\nprint(math.floor(-2.5), math.ceil(-2.5))",
                "-3 -2",
                "floor zaokrągla w dół, ceil w górę – także dla liczb ujemnych.",
            ),
            output(
                "import math\nprint(math.sqrt(16), math.isqrt(17))",
                "4.0 4",
                "sqrt zwraca float, a isqrt całkowitą część pierwiastka.",
            ),
            output(
                "print(round(2.5), round(3.5), round(2.675, 2))",
                "2 4 2.67",
                "round zaokrągla połówki do parzystej, a 2.675 w pamięci jest odrobinę mniejsze.",
            ),
            choice(
                "Jak bezpiecznie porównać 0.1 + 0.2 z 0.3?",
                listOf("math.isclose(0.1 + 0.2, 0.3)", "0.1 + 0.2 == 0.3", "round(0.1 + 0.2) == 0.3", "int(0.1 + 0.2) == 0.3"),
                0,
                "Liczby zmiennoprzecinkowe porównujemy z tolerancją – math.isclose.",
            ),
            fill(
                "Uzupełnij, aby obliczyć 5! (program ma wypisać 120).",
                "import math\nprint(math.____(5))",
                listOf("factorial", "pow", "fact"),
                "factorial",
                "math.factorial(n) liczy silnię.",
            ),
            output(
                "from math import hypot, dist\nprint(hypot(3, 4), dist((0, 0), (6, 8)))",
                "5.0 10.0",
                "Obie funkcje liczą odległość z twierdzenia Pitagorasa.",
            ),
            output(
                "import math\nprint(math.comb(5, 2), math.perm(5, 2))",
                "10 20",
                "comb liczy kombinacje (bez kolejności), perm – wariacje (z kolejnością).",
            ),
            tiles(
                "Zaimportuj z modułu math tylko funkcję sqrt i stałą pi",
                listOf("from", "math", "import", "sqrt,", "pi"),
                listOf("import math", "as"),
                "from moduł import nazwy – importuje wybrane nazwy.",
            ),
        ),
        lesson(
            "u66l2", "Dzień 2: datetime",
            output(
                "from datetime import date\nd = date(2026, 3, 1)\nprint(d - date(2026, 2, 1))",
                "28 days, 0:00:00",
                "Różnica dat to timedelta; luty 2026 ma 28 dni.",
            ),
            output(
                "from datetime import date, timedelta\nd = date(2024, 2, 28) + timedelta(days=2)\nprint(d)",
                "2024-03-01",
                "Rok 2024 jest przestępny, więc po 28 lutego jest 29 lutego.",
            ),
            output(
                "from datetime import datetime\nt = datetime(2026, 7, 4, 9, 5)\nprint(t.strftime(\"%d.%m.%Y %H:%M\"))",
                "04.07.2026 09:05",
                "strftime formatuje datę; %d, %m, %H i %M dopisują zera wiodące.",
            ),
            output(
                "from datetime import datetime\nt = datetime.strptime(\"15/08/2025\", \"%d/%m/%Y\")\nprint(t.month, t.year)",
                "8 2025",
                "strptime zamienia napis na datę według podanego wzoru.",
            ),
            choice(
                "22 października 2026 to czwartek. Co zwróci date(2026, 10, 22).weekday()?",
                listOf("3", "4", "5", "0"),
                0,
                "weekday() liczy od poniedziałku = 0, więc czwartek to 3.",
            ),
            fill(
                "Uzupełnij, aby wypisać numer dnia miesiąca (24).",
                "from datetime import date\nd = date(2026, 12, 24)\nprint(d.____)",
                listOf("day", "month", "weekday"),
                "day",
                "Atrybut day to dzień miesiąca.",
            ),
            output(
                "from datetime import timedelta\nt = timedelta(hours=1, minutes=30)\nprint(t.total_seconds(), t * 2)",
                "5400.0 3:00:00",
                "Półtorej godziny to 5400 sekund; timedelta można mnożyć.",
            ),
            tiles(
                "Utwórz datę 1 stycznia 2027 i zapisz ją w zmiennej d",
                listOf("d", "=", "date(", "2027,", "1,", "1", ")"),
                listOf("\"2027-01-01\"", "datetime."),
                "date przyjmuje rok, miesiąc i dzień.",
            ),
        ),
        lesson(
            "u66l3", "Dzień 3: collections",
            output(
                "from collections import Counter\nc = Counter(\"mississippi\")\nprint(c.most_common(2))",
                "[('i', 4), ('s', 4)]",
                "most_common zwraca najczęstsze elementy; przy remisie decyduje kolejność pojawienia się.",
            ),
            output(
                "from collections import defaultdict\ngrupy = defaultdict(list)\nfor s in [\"kot\", \"koza\", \"pies\"]:\n    grupy[s[0]].append(s)\nprint(dict(grupy))",
                "{'k': ['kot', 'koza'], 'p': ['pies']}",
                "defaultdict(list) sam tworzy pustą listę dla nowego klucza.",
            ),
            output(
                "from collections import namedtuple\nPunkt = namedtuple(\"Punkt\", \"x y\")\np = Punkt(3, 4)\nprint(p.x * p.y, p)",
                "12 Punkt(x=3, y=4)",
                "namedtuple to krotka z nazwanymi polami.",
            ),
            output(
                "from collections import deque\nostatnie = deque(maxlen=3)\nfor i in range(6):\n    ostatnie.append(i)\nprint(list(ostatnie))",
                "[3, 4, 5]",
                "deque z maxlen zapomina najstarsze elementy.",
            ),
            fill(
                "Uzupełnij, aby policzyć wystąpienia liter (program ma wypisać 5).",
                "import collections\nc = collections.____(\"abracadabra\")\nprint(c[\"a\"])",
                listOf("Counter", "defaultdict", "deque"),
                "Counter",
                "Counter liczy wystąpienia elementów.",
            ),
            choice(
                "Co zwróci obiekt defaultdict(int) dla brakującego klucza?",
                listOf("0", "None", "KeyError", "Pusty napis"),
                0,
                "int() zwraca 0, więc to wartość domyślna.",
            ),
            output(
                "from collections import Counter\na = Counter(jablka=3, gruszki=1)\nb = Counter(jablka=1, gruszki=2)\nprint(a - b)",
                "Counter({'jablka': 2})",
                "Odejmowanie Counterów pomija wyniki zerowe i ujemne.",
            ),
            tiles(
                "Utwórz słownik licznik, który dla nowych kluczy zaczyna od 0",
                listOf("licznik", "=", "defaultdict(", "int", ")"),
                listOf("0", "list"),
                "defaultdict potrzebuje funkcji tworzącej wartość domyślną – int() daje 0.",
            ),
        ),
        lesson(
            "u66l4", "Dzień 4: itertools",
            output(
                "from itertools import chain\nprint(list(chain([1, 2], (3,), \"ab\")))",
                "[1, 2, 3, 'a', 'b']",
                "chain łączy kilka sekwencji w jedną.",
            ),
            output(
                "from itertools import combinations\nprint(list(combinations(\"ABC\", 2)))",
                "[('A', 'B'), ('A', 'C'), ('B', 'C')]",
                "combinations wybiera pary bez powtórzeń i bez kolejności.",
            ),
            output(
                "from itertools import product\nwyniki = list(product([0, 1], repeat=3))\nprint(len(wyniki), wyniki[-1])",
                "8 (1, 1, 1)",
                "product z repeat=3 tworzy wszystkie 2³ = 8 układów.",
            ),
            output(
                "from itertools import accumulate\nprint(list(accumulate([1, 2, 3, 4])))",
                "[1, 3, 6, 10]",
                "accumulate podaje sumy narastające.",
            ),
            output(
                "from itertools import groupby\ns = \"aaabbc\"\nprint([(k, len(list(g))) for k, g in groupby(s)])",
                "[('a', 3), ('b', 2), ('c', 1)]",
                "groupby grupuje kolejne takie same elementy.",
            ),
            choice(
                "Ile krotek da list(permutations([1, 2, 3]))?",
                listOf("6", "3", "9", "27"),
                0,
                "Liczba permutacji 3 elementów to 3! = 6.",
            ),
            fill(
                "Uzupełnij, aby wziąć 3 pierwsze wartości (program ma wypisać [10, 15, 20]).",
                "from itertools import count, islice\nprint(list(islice(count(10, 5), ____)))",
                listOf("3", "None", "count"),
                "3",
                "islice ucina nieskończony iterator count po 3 elementach.",
            ),
            tiles(
                "Połącz w pary elementy list a i b",
                listOf("pary", "=", "list(", "zip(a, b)", ")"),
                listOf("chain(a, b)", "product(a, b)"),
                "zip łączy elementy o tych samych indeksach.",
            ),
        ),
        lesson(
            "u66l5", "Dzień 5: functools",
            output(
                "from functools import reduce\nprint(reduce(lambda a, b: a * b, [1, 2, 3, 4]))",
                "24",
                "reduce składa listę parami: ((1 * 2) * 3) * 4.",
            ),
            output(
                "from functools import partial\ndef potega(x, n):\n    return x ** n\nkwadrat = partial(potega, n=2)\nprint(kwadrat(7))",
                "49",
                "partial ustala część argumentów z góry.",
            ),
            output(
                "from functools import lru_cache\nwywolania = 0\n@lru_cache\ndef kw(x):\n    global wywolania\n    wywolania += 1\n    return x * x\nkw(3); kw(3); kw(4)\nprint(wywolania)",
                "2",
                "Drugie kw(3) bierze wynik z pamięci podręcznej.",
            ),
            output(
                "from functools import reduce\nslowa = [\"a\", \"bb\", \"ccc\"]\nprint(reduce(lambda s, w: s + len(w), slowa, 0))",
                "6",
                "Trzeci argument (0) to wartość początkowa akumulatora.",
            ),
            choice(
                "Co robi functools.wraps w dekoratorze?",
                listOf("Kopiuje nazwę i opis oryginalnej funkcji", "Przyspiesza funkcję", "Zapamiętuje wyniki", "Zamienia funkcję w metodę"),
                0,
                "Dzięki wraps udekorowana funkcja zachowuje __name__ i __doc__.",
            ),
            fill(
                "Uzupełnij, aby klasa dostała brakujące porównania (<=, >, >=).",
                "from functools import total_ordering\n@____\nclass Wynik:\n    def __init__(self, p): self.p = p\n    def __eq__(self, o): return self.p == o.p\n    def __lt__(self, o): return self.p < o.p\nprint(Wynik(3) >= Wynik(2))",
                listOf("total_ordering", "partial", "reduce"),
                "total_ordering",
                "total_ordering dopisuje resztę porównań na podstawie __eq__ i __lt__.",
            ),
            output(
                "from functools import partial\nwypisz = partial(print, sep=\"-\")\nwypisz(1, 2, 3)",
                "1-2-3",
                "partial ustawił sep=\"-\" na stałe.",
            ),
            tiles(
                "Zsumuj listę liczby za pomocą reduce",
                listOf("reduce(", "lambda a, b:", "a + b,", "liczby", ")"),
                listOf("a * b,", "map("),
                "reduce dodaje elementy parami od lewej.",
            ),
        ),
        lesson(
            "u66l6", "Dzień 6: Wyrażenia regularne",
            output(
                "import re\nprint(re.findall(r\"\\d+\", \"3 koty i 12 psów\"))",
                "['3', '12']",
                "\\d+ dopasowuje ciągi cyfr; findall zwraca napisy.",
            ),
            output(
                "import re\nprint(re.sub(r\"\\s+\", \" \", \"a   b    c\"))",
                "a b c",
                "sub zamienia każdy ciąg białych znaków na jedną spację.",
            ),
            output(
                "import re\nm = re.search(r\"(\\d{2})-(\\d{3})\", \"kod: 31-042\")\nprint(m.group(1), m.group(2))",
                "31 042",
                "Nawiasy tworzą grupy, które odczytujemy przez group().",
            ),
            choice(
                "Co oznacza \\d we wzorcu wyrażenia regularnego?",
                listOf("Dowolną cyfrę", "Dowolną literę", "Literę d", "Koniec napisu"),
                0,
                "\\d to cyfra, \\w – znak słowa, \\s – biały znak.",
            ),
            fill(
                "Uzupełnij, aby sprawdzić, czy cały napis pasuje do wzorca (program ma wypisać False).",
                "import re\nkod = \"12-345x\"\nprint(bool(re.____(r\"\\d{2}-\\d{3}\", kod)))",
                listOf("fullmatch", "search", "match"),
                "fullmatch",
                "fullmatch wymaga dopasowania całego napisu; match i search znalazłyby fragment.",
            ),
            output(
                "import re\nprint(re.split(r\"[,;]\\s*\", \"a, b;c; d\"))",
                "['a', 'b', 'c', 'd']",
                "split dzieli w miejscach przecinka lub średnika z ewentualnymi spacjami.",
            ),
            output(
                "import re\nm = re.match(r\"(?P<n>\\w+) (?P<w>\\d+)\", \"Ola 25\")\nprint(m[\"n\"], int(m[\"w\"]) + 1)",
                "Ola 26",
                "Grupy nazwane odczytujemy po nazwie.",
            ),
            tiles(
                "Znajdź wszystkie słowa zaczynające się wielką literą w napisie tekst",
                listOf("re.findall(", "r\"[A-Z]\\w*\",", "tekst", ")"),
                listOf("re.sub(", "r\"[a-z]\\w*\","),
                "[A-Z] to wielka litera, a \\w* – dalsza część słowa.",
            ),
        ),
        lesson(
            "u66l7", "Dzień 7: JSON",
            output(
                "import json\nd = {\"imie\": \"Ola\", \"ok\": True, \"pkt\": None}\nprint(json.dumps(d))",
                "{\"imie\": \"Ola\", \"ok\": true, \"pkt\": null}",
                "W JSON-ie True to true, None to null, a napisy mają podwójne cudzysłowy.",
            ),
            output(
                "import json\ndane = json.loads('{\"a\": [1, 2], \"b\": 3.5}')\nprint(dane[\"a\"][1] + dane[\"b\"])",
                "5.5",
                "loads zamienia tekst JSON na słownik z listą i liczbą.",
            ),
            output(
                "import json\nx = json.loads(json.dumps({\"p\": (1, 2)}))\nprint(x)",
                "{'p': [1, 2]}",
                "JSON nie zna krotek – wracają jako listy.",
            ),
            output(
                "import json\nx = json.loads(json.dumps({1: \"a\"}))\nprint(x, 1 in x)",
                "{'1': 'a'} False",
                "Klucze w JSON-ie są zawsze napisami.",
            ),
            choice(
                "Którego typu nie da się bezpośrednio zapisać przez json.dumps?",
                listOf("set", "list", "dict", "bool"),
                0,
                "Zbiór trzeba najpierw zamienić, np. na listę.",
            ),
            fill(
                "Uzupełnij, aby klucze zostały posortowane (program ma wypisać {\"a\": 2, \"b\": 1}).",
                "import json\nprint(json.dumps({\"b\": 1, \"a\": 2}, ____=True))",
                listOf("sort_keys", "indent", "reverse"),
                "sort_keys",
                "sort_keys=True sortuje klucze w wyniku.",
            ),
            output(
                "import json\ntry:\n    json.loads(\"{'a': 1}\")\nexcept json.JSONDecodeError:\n    print(\"zły JSON\")",
                "zły JSON",
                "JSON wymaga podwójnych cudzysłowów, więc apostrofy powodują błąd.",
            ),
            tiles(
                "Zapisz słownik dane do otwartego pliku f jako JSON",
                listOf("json.dump(", "dane,", "f", ")"),
                listOf("json.dumps(", "f.write("),
                "dump zapisuje do pliku, a dumps zwraca napis.",
            ),
        ),
    ),
)
