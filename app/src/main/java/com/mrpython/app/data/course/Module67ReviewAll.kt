package com.mrpython.app.data.course

import com.mrpython.app.domain.CourseUnit

internal val module67 = CourseUnit(
    id = "u67",
    title = "Tydzień powtórek: wszystko naraz",
    description = "Małe programy łączące wszystko, czego się nauczyłeś",
    lessons = listOf(
        lesson(
            "u67l1", "Dzień 1: Analiza tekstu",
            output(
                "from collections import Counter\ntekst = \"to jest to co to jest\"\nc = Counter(tekst.split())\nfor slowo, n in c.most_common(2):\n    print(slowo, n)",
                "to 3\njest 2",
                "Counter liczy słowa, a most_common(2) daje dwa najczęstsze.",
            ),
            output(
                "zdanie = \"Python jest naprawdę świetny\"\nnajd = max(zdanie.split(), key=len)\nprint(najd, len(najd))",
                "naprawdę 8",
                "max z key=len wybiera najdłuższe słowo.",
            ),
            output(
                "tekst = \"ala ma kota. kot ma alę.\"\nzdania = []\nfor z in tekst.split(\".\"):\n    if z.strip():\n        zdania.append(z.strip().capitalize())\nprint(\". \".join(zdania) + \".\")",
                "Ala ma kota. Kot ma alę.",
                "Dzielimy na zdania, pomijamy puste i poprawiamy wielkie litery.",
            ),
            fill(
                "Uzupełnij, aby zostawić tylko litery (program ma wypisać AlaOlaiEla).",
                "tekst = \"Ala, Ola i Ela!\"\nczyste = \"\".join(c for c in tekst if c.____())\nprint(czyste)",
                listOf("isalpha", "isdigit", "isspace"),
                "isalpha",
                "isalpha() jest prawdziwe tylko dla liter.",
            ),
            output(
                "samogloski = \"aeiouyąęó\"\ntekst = \"Wróżka zębuszka\"\nprint(sum(c in samogloski for c in tekst.lower()))",
                "5",
                "Samogłoski to ó, a, ę, u, a.",
            ),
            choice(
                "Co wypisze ten program?",
                listOf("['Bob', 'Kot', 'ala']", "['ala', 'Bob', 'Kot']", "['Kot', 'ala', 'Bob']", "['Bob', 'ala', 'Kot']"),
                0,
                "Wielkie litery mają mniejsze kody niż małe, więc trafiają na początek.",
                code = "slowa = [\"Kot\", \"ala\", \"Bob\"]\nprint(sorted(slowa))",
            ),
            output(
                "nazwa = \"zakład ubezpieczeń społecznych\"\nprint(\"\".join(s[0].upper() for s in nazwa.split()))",
                "ZUS",
                "Bierzemy pierwszą literę każdego słowa i zmieniamy ją na wielką.",
            ),
            tiles(
                "Zbuduj słownik dl: słowo → jego długość dla listy slowa",
                listOf("dl", "=", "{s:", "len(s)", "for s in", "slowa}"),
                listOf("[s:", "len(slowa)"),
                "Wyrażenie słownikowe ma postać {klucz: wartość for ...}.",
            ),
        ),
        lesson(
            "u67l2", "Dzień 2: Dziennik ocen",
            output(
                "oceny = {\"Ola\": [5, 4, 5], \"Jan\": [3, 4]}\nfor imie, o in oceny.items():\n    print(f\"{imie}: {sum(o) / len(o):.2f}\")",
                "Ola: 4.67\nJan: 3.50",
                "Format :.2f pokazuje zawsze dwie cyfry po przecinku.",
            ),
            output(
                "oc = {\"Ola\": [5, 4], \"Jan\": [3, 5, 5], \"Ewa\": [4]}\nsr = {k: sum(v) / len(v) for k, v in oc.items()}\nnajlepszy = max(sr, key=sr.get)\nprint(najlepszy, sr[najlepszy])",
                "Ola 4.5",
                "max po kluczach słownika z key=sr.get szuka najwyższej średniej.",
            ),
            output(
                "def mediana(t):\n    t = sorted(t)\n    n = len(t)\n    if n % 2:\n        return t[n // 2]\n    return (t[n // 2 - 1] + t[n // 2]) / 2\nprint(mediana([7, 1, 3]), mediana([4, 1, 3, 2]))",
                "3 2.5",
                "Dla parzystej liczby elementów mediana to średnia dwóch środkowych.",
            ),
            output(
                "def ocena(pkt):\n    progi = [(90, 5), (75, 4), (50, 3)]\n    for prog, o in progi:\n        if pkt >= prog:\n            return o\n    return 2\nprint([ocena(p) for p in [95, 50, 49, 80]])",
                "[5, 3, 2, 4]",
                "Progi sprawdzamy od najwyższego; pierwszy spełniony decyduje.",
            ),
            fill(
                "Uzupełnij, aby na początku był najlepszy wynik (program ma wypisać Jan).",
                "wyniki = [(\"Ola\", 88), (\"Jan\", 95), (\"Ewa\", 70)]\ntop = sorted(wyniki, key=lambda w: w[1], ____=True)\nprint(top[0][0])",
                listOf("reverse", "key", "desc"),
                "reverse",
                "reverse=True sortuje malejąco.",
            ),
            choice(
                "Co jest nie tak, jeśli chcemy dokładną średnią?",
                listOf("// obcina część ułamkową – trzeba użyć /", "sum nie działa na listach", "len zwraca zły wynik", "Nic – to poprawne"),
                0,
                "14 // 3 to 4, a dokładna średnia to 4.67.",
                code = "oceny = [4, 5, 5]\nsrednia = sum(oceny) // len(oceny)",
            ),
            output(
                "from dataclasses import dataclass, field\n@dataclass\nclass Uczen:\n    imie: str\n    oceny: list = field(default_factory=list)\n    def srednia(self):\n        return sum(self.oceny) / len(self.oceny)\nu = Uczen(\"Ola\", [4, 5])\nprint(f\"{u.imie}: {u.srednia()}\")",
                "Ola: 4.5",
                "dataclass z metodą liczącą średnią ocen.",
            ),
            tiles(
                "Policz, ile średnich z listy srednie wynosi co najmniej 4",
                listOf("ile", "=", "sum(", "1 for s in srednie", "if s >= 4", ")"),
                listOf("if s > 4", "len("),
                "Sumujemy jedynki dla elementów spełniających warunek.",
            ),
        ),
        lesson(
            "u67l3", "Dzień 3: Sklep i koszyk",
            output(
                "class Koszyk:\n    def __init__(self):\n        self.pozycje = {}\n    def dodaj(self, nazwa, cena, ile=1):\n        self.pozycje[nazwa] = (cena, ile)\n    def suma(self):\n        return sum(c * i for c, i in self.pozycje.values())\nk = Koszyk()\nk.dodaj(\"chleb\", 4.5, 2)\nk.dodaj(\"masło\", 7)\nprint(k.suma())",
                "16.0",
                "4.5 * 2 + 7 * 1 = 16.0.",
            ),
            output(
                "class BrakTowaru(Exception):\n    pass\nmagazyn = {\"jabłko\": 3}\ndef kup(t, n):\n    if magazyn.get(t, 0) < n:\n        raise BrakTowaru(t)\n    magazyn[t] -= n\nfor n in [2, 2]:\n    try:\n        kup(\"jabłko\", n)\n        print(\"ok\", magazyn[\"jabłko\"])\n    except BrakTowaru as e:\n        print(\"brak:\", e)",
                "ok 1\nbrak: jabłko",
                "Za drugim razem zostało tylko 1 jabłko, więc zgłaszamy wyjątek.",
            ),
            output(
                "def rabat(p):\n    return lambda c: round(c * (100 - p) / 100, 2)\nrabat10 = rabat(10)\nprint([rabat10(c) for c in [100, 59.99]])",
                "[90.0, 53.99]",
                "rabat zwraca domknięcie, które pamięta procent.",
            ),
            output(
                "pozycje = [(\"Ser\", 12.5), (\"Mleko\", 3)]\nfor n, c in pozycje:\n    print(f\"{n}: {c:.2f} zł\")\nprint(f\"Razem: {sum(c for _, c in pozycje):.2f} zł\")",
                "Ser: 12.50 zł\nMleko: 3.00 zł\nRazem: 15.50 zł",
                "Format :.2f wypisuje kwoty z groszami.",
            ),
            choice(
                "Jaki typ najlepiej nadaje się do kwot pieniędzy bez błędów zaokrągleń?",
                listOf("Decimal z modułu decimal", "float", "str", "complex"),
                0,
                "Decimal liczy w systemie dziesiętnym, więc 0.1 + 0.2 to dokładnie 0.3.",
            ),
            output(
                "from decimal import Decimal\nprint(0.1 + 0.2, Decimal(\"0.1\") + Decimal(\"0.2\"))",
                "0.30000000000000004 0.3",
                "float ma błędy zaokrągleń, Decimal z napisów – nie.",
            ),
            fill(
                "Uzupełnij, aby print(produkt) wypisało Kawa (20 zł).",
                "class Produkt:\n    def __init__(self, n, c):\n        self.n, self.c = n, c\n    def ____(self):\n        return f\"{self.n} ({self.c} zł)\"\nprint(Produkt(\"Kawa\", 20))",
                listOf("__str__", "__init__", "__len__"),
                "__str__",
                "print używa metody __str__.",
            ),
            tiles(
                "Oblicz łączną wartość: suma c * i dla par (cena, ilość) w liście koszyk",
                listOf("razem", "=", "sum(", "c * i", "for c, i in", "koszyk", ")"),
                listOf("c + i", "len("),
                "Rozpakowujemy każdą parę i sumujemy iloczyny.",
            ),
        ),
        lesson(
            "u67l4", "Dzień 4: Przetwarzanie danych",
            output(
                "import json\ndane = '[{\"n\":\"Ola\",\"w\":30},{\"n\":\"Jan\",\"w\":17}]'\nosoby = json.loads(dane)\nprint([o[\"n\"] for o in osoby if o[\"w\"] >= 18])",
                "['Ola']",
                "Wczytujemy JSON i filtrujemy pełnoletnich.",
            ),
            output(
                "import csv, io\nplik = io.StringIO(\"imie,pkt\\nOla,7\\nJan,9\\n\")\nwiersze = csv.DictReader(plik)\nprint(sum(int(w[\"pkt\"]) for w in wiersze))",
                "16",
                "DictReader daje słowniki z napisami – trzeba je zamienić na liczby.",
            ),
            output(
                "from collections import defaultdict\nwydatki = [(\"obiad\", 20), (\"bilet\", 5), (\"obiad\", 15)]\nsuma = defaultdict(int)\nfor kat, kw in wydatki:\n    suma[kat] += kw\nprint(dict(suma))",
                "{'obiad': 35, 'bilet': 5}",
                "defaultdict(int) sumuje wydatki w kategoriach.",
            ),
            output(
                "config = {\"db\": {\"host\": \"localhost\"}}\nport = config.get(\"db\", {}).get(\"port\", 5432)\nprint(port, config[\"db\"][\"host\"])",
                "5432 localhost",
                "get z wartością domyślną chroni przed KeyError w zagnieżdżonych danych.",
            ),
            choice(
                "Co wypisze ten program?",
                listOf("str", "dict", "bytes", "json"),
                0,
                "dumps zamienia obiekt na napis w formacie JSON.",
                code = "import json\ns = json.dumps({\"a\": 1})\nprint(type(s).__name__)",
            ),
            fill(
                "Uzupełnij, aby zbudować słownik z dwóch list ({'imie': 'Ola', 'wiek': 30}).",
                "klucze = [\"imie\", \"wiek\"]\nwartosci = [\"Ola\", 30]\nprint(dict(____(klucze, wartosci)))",
                listOf("zip", "enumerate", "map"),
                "zip",
                "zip tworzy pary (klucz, wartość), z których dict buduje słownik.",
            ),
            output(
                "produkty = [\n    {\"n\": \"ser\", \"c\": 12},\n    {\"n\": \"chleb\", \"c\": 5},\n    {\"n\": \"kawa\", \"c\": 12},\n]\nprodukty.sort(key=lambda p: (-p[\"c\"], p[\"n\"]))\nprint(\", \".join(p[\"n\"] for p in produkty))",
                "kawa, ser, chleb",
                "Najpierw malejąco po cenie, przy remisie alfabetycznie.",
            ),
            tiles(
                "Wczytaj JSON z napisu tekst do zmiennej dane",
                listOf("dane", "=", "json.loads(", "tekst", ")"),
                listOf("json.load(", "json.dumps("),
                "loads czyta z napisu, a load – z pliku.",
            ),
        ),
        lesson(
            "u67l5", "Dzień 5: Generatory w praktyce",
            output(
                "def parzyste(n):\n    for i in range(n):\n        if i % 2 == 0:\n            yield i\nprint(list(parzyste(7)))",
                "[0, 2, 4, 6]",
                "yield oddaje kolejne wartości na żądanie.",
            ),
            output(
                "g = (x * x for x in range(3))\nprint(sum(g), sum(g))",
                "5 0",
                "Generator można przejść tylko raz – za drugim razem jest pusty.",
            ),
            output(
                "linie = [\"# komentarz\", \"a=1\", \"\", \"b=2\"]\nczyste = (l for l in linie if l and l[0] != \"#\")\nprint(dict(l.split(\"=\") for l in czyste))",
                "{'a': '1', 'b': '2'}",
                "Pomijamy puste linie i komentarze, a resztę dzielimy na pary.",
            ),
            output(
                "liczby = [3, 7, 10, 13]\np = next((x for x in liczby if x % 5 == 0), None)\nq = next((x for x in liczby if x > 20), None)\nprint(p, q)",
                "10 None",
                "next z wartością domyślną zwraca pierwszy pasujący element albo None.",
            ),
            choice(
                "Dlaczego (x for x in range(10**9)) nie zużywa dużo pamięci?",
                listOf("Generator tworzy elementy na żądanie, jeden po drugim", "Python kompresuje listy", "range ma limit elementów", "Tworzy listę w tle i szybko ją usuwa"),
                0,
                "Generator nie przechowuje wszystkich elementów naraz.",
            ),
            fill(
                "Uzupełnij, aby funkcja była generatorem (program ma wypisać [3, 2, 1]).",
                "def odliczanie(n):\n    while n > 0:\n        ____ n\n        n -= 1\nprint(list(odliczanie(3)))",
                listOf("yield", "return", "print"),
                "yield",
                "yield zamienia funkcję w generator.",
            ),
            output(
                "imiona = [\"Ola\", \"Jan\"]\npunkty = [7, 9]\nfor i, (n, p) in enumerate(zip(imiona, punkty), 1):\n    print(f\"{i}. {n} - {p}\")",
                "1. Ola - 7\n2. Jan - 9",
                "zip łączy listy, a enumerate(…, 1) numeruje od 1.",
            ),
            tiles(
                "Utwórz generator kw kwadratów liczb od 0 do 9",
                listOf("kw", "=", "(x ** 2", "for x in", "range(10))"),
                listOf("[x ** 2", "range(9))"),
                "Wyrażenie generatorowe zapisujemy w nawiasach okrągłych.",
            ),
        ),
        lesson(
            "u67l6", "Dzień 6: Narzędzia programisty",
            output(
                "def dodatnie(f):\n    def w(*args):\n        if any(a <= 0 for a in args):\n            return \"błąd\"\n        return f(*args)\n    return w\n@dodatnie\ndef pole(a, b):\n    return a * b\nprint(pole(3, 4), pole(-1, 2))",
                "12 błąd",
                "Dekorator sprawdza argumenty, zanim wywoła funkcję.",
            ),
            output(
                "class Sekcja:\n    def __enter__(self):\n        print(\"start\")\n        return self\n    def __exit__(self, *exc):\n        print(\"stop\")\nwith Sekcja():\n    print(\"praca\")",
                "start\npraca\nstop",
                "with wywołuje __enter__ na początku i __exit__ na końcu bloku.",
            ),
            output(
                "from contextlib import suppress\nwith suppress(KeyError):\n    print({}[\"x\"])\nprint(\"dalej\")",
                "dalej",
                "suppress wycisza wskazany wyjątek.",
            ),
            output(
                "def zapamietaj(f):\n    pamiec = {}\n    def w(n):\n        if n not in pamiec:\n            pamiec[n] = f(n)\n        return pamiec[n]\n    return w\n@zapamietaj\ndef drogie(n):\n    print(\"liczę\", n)\n    return n * 2\nprint(drogie(5) + drogie(5))",
                "liczę 5\n20",
                "Drugi raz wynik pochodzi z pamięci, więc „liczę” pojawia się raz.",
            ),
            choice(
                "Co gwarantuje instrukcja with open(\"a.txt\") as f:?",
                listOf("Plik zostanie zamknięty, nawet gdy wystąpi błąd", "Plik zostanie utworzony", "Cały plik trafi od razu do pamięci", "Wszystkie błędy zostaną zignorowane"),
                0,
                "Menedżer kontekstu sprząta po sobie – zamyka plik.",
            ),
            fill(
                "Uzupełnij adnotację typu zwracanego.",
                "def srednia(liczby: list[float]) ____ float:\n    return sum(liczby) / len(liczby)\nprint(srednia([2.0, 4.0]))",
                listOf("->", "=>", ":"),
                "->",
                "Typ zwracany zapisujemy po strzałce ->.",
            ),
            output(
                "def odwroc(s):\n    return s[::-1]\ntesty = [(\"abc\", \"cba\"), (\"\", \"\"), (\"ab\", \"ab\")]\nfor wej, ocz in testy:\n    print(\"OK\" if odwroc(wej) == ocz else \"FAIL\")",
                "OK\nOK\nFAIL",
                "Trzeci test ma złą oczekiwaną wartość – \"ab\" odwrócone to \"ba\".",
            ),
            tiles(
                "Otwórz plik dane.txt do odczytu za pomocą with",
                listOf("with", "open(", "\"dane.txt\")", "as", "f:"),
                listOf("for", "f ="),
                "with open(...) as f: zamknie plik automatycznie.",
            ),
        ),
        lesson(
            "u67l7", "Dzień 7: Małe projekty",
            output(
                "class Konto:\n    def __init__(self):\n        self.saldo, self.historia = 0, []\n    def wplac(self, kw):\n        if self.saldo + kw < 0:\n            raise ValueError(\"za mało\")\n        self.saldo += kw\n        self.historia.append(kw)\nk = Konto()\nfor kw in [100, -30, -100]:\n    try: k.wplac(kw)\n    except ValueError as e: print(e)\nprint(k.saldo, k.historia)",
                "za mało\n70 [100, -30]",
                "Operacja -100 zostaje odrzucona, więc nie trafia do historii.",
            ),
            output(
                "import heapq\nzadania = []\nheapq.heappush(zadania, (2, \"zakupy\"))\nheapq.heappush(zadania, (1, \"rachunki\"))\nheapq.heappush(zadania, (3, \"film\"))\nwhile zadania:\n    print(heapq.heappop(zadania)[1])",
                "rachunki\nzakupy\nfilm",
                "Kopiec oddaje zadania od najniższego priorytetu.",
            ),
            output(
                "pytania = {\"2+2\": \"4\", \"stolica\": \"Warszawa\"}\nodp = {\"2+2\": \"4\", \"stolica\": \"kraków\"}\npkt = sum(odp[p].lower() == o.lower()\n          for p, o in pytania.items())\nprint(f\"{pkt}/{len(pytania)}\")",
                "1/2",
                "True liczy się jako 1, więc sum zlicza poprawne odpowiedzi.",
            ),
            output(
                "from datetime import date\ntermin = date(2026, 11, 11)\ndzis = date(2026, 10, 22)\nprint((termin - dzis).days, termin.strftime(\"%d.%m\"))",
                "20 11.11",
                "Do końca października zostaje 9 dni, plus 11 dni listopada.",
            ),
            output(
                "import re\nfrom collections import Counter\nlog = \"ERROR x; INFO y; ERROR z; WARN q\"\npoziomy = re.findall(r\"[A-Z]{4,5}\", log)\nprint(Counter(poziomy)[\"ERROR\"], len(poziomy))",
                "2 4",
                "Wzorzec łapie słowa z 4–5 wielkich liter: dwa ERROR, INFO i WARN.",
            ),
            choice(
                "Która struktura najlepiej nada się do funkcji „cofnij” w edytorze?",
                listOf("Stos (lista z append i pop)", "Kolejka FIFO", "Zbiór", "Słownik"),
                0,
                "Cofamy najpierw ostatnią zmianę – to zasada LIFO.",
            ),
            fill(
                "Uzupełnij, aby transponować macierz (program ma wypisać [[1, 4], [2, 5], [3, 6]]).",
                "macierz = [[1, 2, 3], [4, 5, 6]]\nt = [list(w) for w in zip(____macierz)]\nprint(t)",
                listOf("*", "**", "-"),
                "*",
                "zip(*macierz) łączy elementy wierszy o tych samych indeksach.",
            ),
            tiles(
                "Zamień w liście liczby wielokrotności 3 na \"Fizz\" i zapisz wynik w zmiennej wynik",
                listOf("wynik", "=", "[\"Fizz\" if n % 3 == 0", "else n", "for n in liczby]"),
                listOf("if n % 3", "else \"Fizz\""),
                "Wyrażenie warunkowe x if warunek else y stoi na początku wyrażenia listowego.",
            ),
        ),
    ),
)
