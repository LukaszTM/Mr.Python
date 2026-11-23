package com.mrpython.app.data.course

import com.mrpython.app.domain.CourseUnit

internal val module70 = CourseUnit(
    id = "u70",
    title = "Projekt: sklep internetowy",
    description = "Produkty, koszyk, rabaty i walidacja zamówień",
    lessons = listOf(
        lesson(
            "u70l1", "Krok 1: produkt jako dataclass",
            output(
                "from dataclasses import dataclass\n@dataclass\nclass Produkt:\n    nazwa: str\n    cena: float\np = Produkt(\"Kubek\", 19.99)\nprint(p)",
                "Produkt(nazwa='Kubek', cena=19.99)",
                "@dataclass sam tworzy __init__ i czytelne __repr__.",
            ),
            output(
                "from dataclasses import dataclass\n@dataclass\nclass Produkt:\n    nazwa: str\n    cena: float\np = Produkt(\"Talerz\", 12.5)\nprint(p.nazwa, p.cena)",
                "Talerz 12.5",
                "Pola dataclass to zwykłe atrybuty obiektu.",
            ),
            fill(
                "Dodaj pole ilosc z domyślną wartością 1.",
                "from dataclasses import dataclass\n@dataclass\nclass Produkt:\n    nazwa: str\n    ilosc: int ____ 1\nprint(Produkt(\"Kubek\"))",
                listOf("=", ":", "=="),
                "=",
                "Wartość domyślną pola podajemy po znaku =.",
            ),
            output(
                "from dataclasses import dataclass\n@dataclass\nclass Produkt:\n    nazwa: str\n    cena: float\na = Produkt(\"Kubek\", 5)\nb = Produkt(\"Kubek\", 5)\nprint(a == b, a is b)",
                "True False",
                "dataclass porównuje pola (==), ale to wciąż dwa różne obiekty.",
            ),
            choice(
                "Co @dataclass tworzy automatycznie?",
                listOf("__init__, __repr__ i __eq__", "Tylko __init__", "Bazę danych produktów", "Metody do zapisu w pliku"),
                0,
                "Dzięki temu klasa danych to kilka linijek kodu.",
            ),
            output(
                "from dataclasses import dataclass\n@dataclass(frozen=True)\nclass Produkt:\n    nazwa: str\np = Produkt(\"Kubek\")\ntry:\n    p.nazwa = \"Talerz\"\nexcept AttributeError:\n    print(\"Nie wolno zmieniać!\")",
                "Nie wolno zmieniać!",
                "frozen=True blokuje zmianę pól po utworzeniu obiektu.",
            ),
            tiles(
                "Dodaj pole cena typu float z domyślną wartością 0.0",
                listOf("cena", ":", "float", "=", "0.0"),
                listOf("==", "->"),
                "Pole dataclass: nazwa: typ = wartość domyślna.",
            ),
            output(
                "from dataclasses import dataclass\n@dataclass\nclass Produkt:\n    nazwa: str\n    cena: float\nlista = [Produkt(\"Mysz\", 50),\n         Produkt(\"Kabel\", 9)]\ntani = min(lista, key=lambda p: p.cena)\nprint(tani.nazwa)",
                "Kabel",
                "key=lambda p: p.cena porównuje produkty po cenie.",
            ),
        ),
        lesson(
            "u70l2", "Krok 2: koszyk",
            output(
                "class Koszyk:\n    def __init__(self):\n        self.poz = {}\n    def dodaj(self, nazwa, ile=1):\n        n = self.poz.get(nazwa, 0)\n        self.poz[nazwa] = n + ile\nk = Koszyk()\nk.dodaj(\"kubek\"); k.dodaj(\"kubek\", 2)\nprint(k.poz)",
                "{'kubek': 3}",
                "Ten sam produkt zwiększa ilość, zamiast tworzyć nową pozycję.",
            ),
            fill(
                "Usuń pozycję z koszyka.",
                "poz = {\"kubek\": 2, \"talerz\": 1}\npoz.____(\"talerz\", None)\nprint(poz)",
                listOf("pop", "get", "remove"),
                "pop",
                "pop() usuwa klucz ze słownika; get() tylko czyta.",
            ),
            output(
                "def usun(poz, nazwa, ile=1):\n    poz[nazwa] -= ile\n    if poz[nazwa] <= 0:\n        del poz[nazwa]\np = {\"kubek\": 2, \"talerz\": 1}\nusun(p, \"talerz\")\nusun(p, \"kubek\")\nprint(p)",
                "{'kubek': 1}",
                "Gdy ilość spadnie do zera, pozycja znika z koszyka.",
            ),
            choice(
                "Dlaczego koszyk to słownik nazwa → ilość, a nie lista produktów?",
                listOf("Łatwo zwiększyć ilość i szybko znaleźć pozycję po nazwie", "Bo listy nie mogą przechowywać napisów", "Bo słownik zawsze sortuje produkty po cenie", "Bo listy nie mają metody append()"),
                0,
                "Słownik daje szybki dostęp po kluczu i miejsce na ilość.",
            ),
            output(
                "poz = {\"kubek\": 3, \"talerz\": 1}\nprint(len(poz), sum(poz.values()))",
                "2 4",
                "len() to liczba pozycji, suma wartości to liczba sztuk.",
            ),
            tiles(
                "Dodaj 2 sztuki kubka do koszyka k",
                listOf("k.dodaj(", "\"kubek\",", "ile=2", ")"),
                listOf("k.add(", "ile==2"),
                "Argument nazwany ile=2 mówi, ile sztuk dodać.",
            ),
            output(
                "class Koszyk:\n    def __init__(self):\n        self.poz = {\"kubek\": 2, \"mapa\": 1}\n    def __len__(self):\n        return sum(self.poz.values())\nprint(len(Koszyk()))",
                "3",
                "__len__ pozwala używać len() na naszym koszyku.",
            ),
            output(
                "from collections import Counter\nk = Counter()\nk[\"kubek\"] += 2\nk[\"łyżka\"] += 1\nk[\"kubek\"] -= 1\nprint(k[\"kubek\"], sum(k.values()))",
                "1 2",
                "Counter też dobrze sprawdza się jako koszyk.",
            ),
        ),
        lesson(
            "u70l3", "Krok 3: sumy i rabaty",
            output(
                "print(0.1 + 0.2)\nprint(round(0.1 + 0.2, 2))",
                "0.30000000000000004\n0.3",
                "Liczby float bywają niedokładne, dlatego kwoty zaokrąglamy.",
            ),
            output(
                "from decimal import Decimal\nprint(Decimal(\"0.1\") + Decimal(\"0.2\"))",
                "0.3",
                "Decimal liczy dokładnie jak na kalkulatorze – idealny do pieniędzy.",
            ),
            choice(
                "Dlaczego piszemy Decimal(\"19.99\"), a nie Decimal(19.99)?",
                listOf("Float 19.99 już jest niedokładny, a napis zachowuje dokładną wartość", "Decimal nie przyjmuje liczb", "Napis jest szybszy", "Nie ma różnicy"),
                0,
                "Decimal(19.99) skopiowałby błąd zaokrąglenia floata.",
            ),
            output(
                "from decimal import Decimal\nCENY = {\"kubek\": Decimal(\"19.99\"),\n        \"talerz\": Decimal(\"12.50\")}\nkoszyk = {\"kubek\": 2, \"talerz\": 1}\nsuma = sum(CENY[n] * i\n           for n, i in koszyk.items())\nprint(suma)",
                "52.48",
                "2 × 19.99 + 12.50 = 52.48 – bez błędów zaokrągleń.",
            ),
            output(
                "from decimal import Decimal\nsuma = Decimal(\"52.48\")\nrabat = suma * Decimal(\"0.10\")\ngrosz = Decimal(\"0.01\")\nprint(rabat.quantize(grosz))\nprint((suma - rabat).quantize(grosz))",
                "5.25\n47.23",
                "quantize() zaokrągla kwotę do groszy.",
            ),
            fill(
                "Zaokrąglij kwotę do groszy.",
                "from decimal import Decimal\nkwota = Decimal(\"7.456\")\nprint(kwota.quantize(Decimal(____)))",
                listOf("\"0.01\"", "\"0.1\"", "\"1\""),
                "\"0.01\"",
                "Wzorzec 0.01 oznacza dwa miejsca po przecinku.",
            ),
            tiles(
                "Oblicz cenę po rabacie 20%",
                listOf("cena_po", "=", "cena", "*", "Decimal(\"0.8\")"),
                listOf("+", "Decimal(\"0.2\")"),
                "Po rabacie 20% płacimy 80% ceny, czyli mnożymy przez 0.8.",
            ),
            output(
                "def rabat(suma):\n    if suma >= 100:\n        return round(suma * 0.9, 2)\n    return suma\nprint(rabat(50))\nprint(rabat(120))",
                "50\n108.0",
                "Rabat 10% działa tylko od 100 zł.",
            ),
        ),
        lesson(
            "u70l4", "Krok 4: podsumowanie zamówienia",
            output(
                "cena = 19.9\nprint(f\"{cena:.2f} zł\")",
                "19.90 zł",
                ":.2f zawsze pokazuje dwa miejsca po przecinku.",
            ),
            output(
                "koszyk = [(\"Kubek\", 2, 10.0),\n          (\"Talerz\", 1, 7.5)]\nfor nazwa, ile, cena in koszyk:\n    print(f\"{nazwa} x{ile}: {ile*cena:.2f}\")",
                "Kubek x2: 20.00\nTalerz x1: 7.50",
                "Każda pozycja to krotka, którą rozpakowujemy w pętli.",
            ),
            output(
                "koszyk = [(\"Kubek\", 2, 10.0),\n          (\"Talerz\", 1, 7.5)]\nrazem = sum(i * c for _, i, c in koszyk)\nprint(f\"Razem: {razem:.2f} zł\")",
                "Razem: 27.50 zł",
                "Suma to ilość × cena dla każdej pozycji.",
            ),
            fill(
                "Wypisz cenę z dokładnie dwoma miejscami po przecinku.",
                "cena = 19.99\nprint(f\"{cena:____}\")",
                listOf(".2f", ".2", "2f"),
                ".2f",
                ".2f to format zmiennoprzecinkowy z dwoma miejscami.",
            ),
            choice(
                "Co oznacza :>8 w f\"{nazwa:>8}\"?",
                listOf("Wyrównanie do prawej na szerokości 8 znaków", "Pierwsze 8 liter nazwy", "Nazwa powtórzona 8 razy", "Liczba większa niż 8"),
                0,
                "> wyrównuje do prawej, a 8 to szerokość pola.",
            ),
            output(
                "print(f\"{1234567.5:,.2f}\")",
                "1,234,567.50",
                "Przecinek w formacie oddziela tysiące.",
            ),
            tiles(
                "Połącz linie paragonu i wypisz je, każdą w osobnym wierszu",
                listOf("print(", "\"\\n\".join(", "linie", "))"),
                listOf("linie.join(", "split("),
                "\"\\n\".join() skleja linie znakiem nowej linii.",
            ),
            output(
                "def paragon(poz):\n    linie = [f\"{n}: {c:.2f}\" for n, c in poz]\n    linie.append(\"-\" * 10)\n    suma = sum(c for _, c in poz)\n    linie.append(f\"Suma: {suma:.2f}\")\n    return \"\\n\".join(linie)\nprint(paragon([(\"A\", 2.5), (\"B\", 1)]))",
                "A: 2.50\nB: 1.00\n----------\nSuma: 3.50",
                "Funkcja buduje cały paragon jako jeden napis.",
            ),
        ),
        lesson(
            "u70l5", "Projekt: walidacja i cały sklep",
            output(
                "class BrakTowaru(Exception):\n    pass\ntry:\n    raise BrakTowaru(\"kubek\")\nexcept BrakTowaru as e:\n    print(\"Brak:\", e)",
                "Brak: kubek",
                "Własny wyjątek to klasa dziedzicząca po Exception.",
            ),
            output(
                "class ZlaIlosc(ValueError):\n    pass\ndef dodaj(koszyk, nazwa, ile):\n    if ile <= 0:\n        raise ZlaIlosc(f\"zła ilość: {ile}\")\n    koszyk[nazwa] = ile\nk = {}\ntry:\n    dodaj(k, \"kubek\", 2); dodaj(k, \"łyżka\", 0)\nexcept ValueError as e:\n    print(e, k)",
                "zła ilość: 0 {'kubek': 2}",
                "Błędna ilość zatrzymuje dodawanie, zanim zepsuje koszyk.",
            ),
            fill(
                "Utwórz własny wyjątek sklepu.",
                "class BladSklepu(____):\n    pass\ntry:\n    raise BladSklepu(\"pusty koszyk\")\nexcept BladSklepu as e:\n    print(e)",
                listOf("Exception", "object", "str"),
                "Exception",
                "Zgłaszać można tylko klasy dziedziczące po Exception.",
            ),
            choice(
                "Dlaczego except ValueError złapie wyjątek ZlaIlosc?",
                listOf("Bo ZlaIlosc dziedziczy po ValueError", "Bo except łapie wszystkie wyjątki", "Bo nazwy kończą się podobnie", "Nie złapie go"),
                0,
                "except łapie wskazaną klasę i wszystkie jej podklasy.",
            ),
            output(
                "MAGAZYN = {\"kubek\": 1}\nclass BrakTowaru(Exception): pass\ndef zamow(n):\n    if MAGAZYN.get(n, 0) < 1:\n        raise BrakTowaru(n)\n    MAGAZYN[n] -= 1\n    return \"OK\"\nfor n in [\"kubek\", \"kubek\"]:\n    try: print(zamow(n))\n    except BrakTowaru as e: print(\"Brak\", e)",
                "OK\nBrak kubek",
                "Drugie zamówienie nie przechodzi, bo magazyn jest pusty.",
            ),
            tiles(
                "Zgłoś własny wyjątek BrakTowaru z komunikatem \"kubek\"",
                listOf("raise", "BrakTowaru(", "\"kubek\"", ")"),
                listOf("throw", "except"),
                "W Pythonie wyjątek zgłaszamy słowem raise.",
            ),
            output(
                "from dataclasses import dataclass\n@dataclass\nclass Produkt:\n    nazwa: str\n    cena: float\nkubek = Produkt(\"Kubek\", 20)\nk = [kubek, kubek, Produkt(\"Mapa\", 5)]\nsuma = sum(p.cena for p in k)\nprint(f\"{len(k)} szt., {suma:.2f} zł\")",
                "3 szt., 45.00 zł",
                "Produkty jako dataclass, koszyk jako lista i podsumowanie w f-stringu.",
            ),
            choice(
                "Gdzie najlepiej sprawdzać, czy ilość jest poprawna?",
                listOf("W metodzie dodającej do koszyka, zanim zmieni jego stan", "Dopiero przy drukowaniu paragonu", "W klasie wyjątku", "Nigdzie – błędne dane same się poprawią"),
                0,
                "Walidacja na wejściu chroni koszyk przed złymi danymi.",
            ),
        ),
    ),
)
