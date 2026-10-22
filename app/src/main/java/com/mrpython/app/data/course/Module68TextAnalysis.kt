package com.mrpython.app.data.course

import com.mrpython.app.domain.CourseUnit

internal val module68 = CourseUnit(
    id = "u68",
    title = "Projekt: analiza tekstu",
    description = "Krok po kroku budujemy analizator tekstu",
    lessons = listOf(
        lesson(
            "u68l1", "Krok 1: czyszczenie tekstu",
            output(
                "tekst = \"  Ala MA Kota!  \"\nprint(tekst.strip().lower())",
                "ala ma kota!",
                "strip() usuwa spacje z brzegów, a lower() zamienia litery na małe.",
            ),
            output(
                "tekst = \"Hej, ty! Co?\"\nfor znak in \",!?\":\n    tekst = tekst.replace(znak, \"\")\nprint(tekst)",
                "Hej ty Co",
                "Każdy znak interpunkcyjny zastępujemy pustym napisem.",
            ),
            fill(
                "Usuń z tekstu wszystkie znaki interpunkcyjne.",
                "import string\ntekst = \"Tak, to ja!\"\ntabela = str.maketrans(\"\", \"\", ____)\nprint(tekst.translate(tabela))",
                listOf("string.punctuation", "string.digits", "string.ascii_letters"),
                "string.punctuation",
                "string.punctuation zawiera wszystkie typowe znaki interpunkcyjne.",
            ),
            output(
                "from string import punctuation\nt = \"Kot, pies; ryba.\"\nusun = str.maketrans(\"\", \"\", punctuation)\nt = t.translate(usun)\nprint(t.lower().split())",
                "['kot', 'pies', 'ryba']",
                "Po usunięciu interpunkcji split() dzieli tekst na czyste słowa.",
            ),
            choice(
                "Co zwróci ten kod?",
                listOf("['a', 'b', 'c']", "['a', '', 'b', 'c']", "['a  b', 'c']", "['a', 'b', '\\n', 'c']"),
                0,
                "split() bez argumentu dzieli po dowolnych białych znakach i pomija puste kawałki.",
                code = "print(\"a  b\\n c\".split())",
            ),
            tiles(
                "Zapisz w slowa wszystkie słowa tekstu bez kropek i przecinków na brzegach",
                listOf("slowa", "=", "[s.strip(\".,\")", "for", "s", "in", "tekst.split()]"),
                listOf("while", "tekst.join()]"),
                "Wyrażenie listowe czyści każde słowo metodą strip(\".,\").",
            ),
            output(
                "def oczysc(tekst):\n    for znak in \".,!?\":\n        tekst = tekst.replace(znak, \" \")\n    return tekst.lower().split()\n\nprint(oczysc(\"Ala, ma KOTA!\"))",
                "['ala', 'ma', 'kota']",
                "Funkcja oczysc() to pierwszy klocek naszego analizatora.",
            ),
            choice(
                "Dlaczego przed liczeniem słów zamieniamy tekst na małe litery?",
                listOf("Żeby „Kot” i „kot” liczyły się jako to samo słowo", "Bo Counter nie obsługuje wielkich liter", "Żeby tekst zajmował mniej pamięci", "Bo split() działa tylko na małych literach"),
                0,
                "Bez lower() to samo słowo zapisane różnie liczyłoby się osobno.",
            ),
        ),
        lesson(
            "u68l2", "Krok 2: liczenie słów",
            output(
                "slowa = [\"kot\", \"pies\", \"kot\"]\nlicznik = {}\nfor s in slowa:\n    licznik[s] = licznik.get(s, 0) + 1\nprint(licznik)",
                "{'kot': 2, 'pies': 1}",
                "get(s, 0) zwraca 0 dla nowego słowa, więc możemy od razu dodać 1.",
            ),
            fill(
                "Policz, ile razy występuje każde słowo.",
                "slowa = [\"a\", \"b\", \"a\"]\nlicznik = {}\nfor s in slowa:\n    licznik[s] = licznik.get(s, ____) + 1\nprint(licznik)",
                listOf("0", "1", "None"),
                "0",
                "Nowe słowo zaczyna od 0 wystąpień, a potem dodajemy 1.",
            ),
            output(
                "from collections import Counter\nc = Counter(\"a b a c a\".split())\nprint(c[\"a\"], c[\"z\"])",
                "3 0",
                "Counter zwraca 0 dla brakującego klucza, zamiast zgłaszać KeyError.",
            ),
            output(
                "from collections import Counter\nprint(Counter([\"kot\", \"pies\", \"kot\"]))",
                "Counter({'kot': 2, 'pies': 1})",
                "Counter wypisuje się od najczęstszego elementu.",
            ),
            choice(
                "Co zwróci Counter dla klucza, którego nie ma?",
                listOf("0", "None", "KeyError", "-1"),
                0,
                "Counter traktuje brakujący element jak zero wystąpień.",
            ),
            output(
                "from collections import Counter\nc = Counter(\"ala ma kota ala\".split())\nprint(len(c))\nprint(sum(c.values()))",
                "3\n4",
                "len() to liczba różnych słów, a suma wartości to liczba wszystkich słów.",
            ),
            tiles(
                "Policz słowa z listy slowa za pomocą Counter",
                listOf("licznik", "=", "Counter(", "slowa", ")"),
                listOf("slowa.count(", "len("),
                "Counter(lista) od razu zlicza wszystkie elementy.",
            ),
            output(
                "from collections import Counter\nc = Counter(\"abba\")\nc.update(\"ab\")\nprint(c[\"a\"], c[\"b\"])",
                "3 3",
                "update() dolicza nowe wystąpienia do istniejącego licznika.",
            ),
        ),
        lesson(
            "u68l3", "Krok 3: najczęstsze słowa",
            output(
                "from collections import Counter\nc = Counter(\"a b a c a b\".split())\nprint(c.most_common(2))",
                "[('a', 3), ('b', 2)]",
                "most_common(2) zwraca dwie pary (słowo, liczba) od największej liczby.",
            ),
            output(
                "from collections import Counter\nc = Counter(\"to jest to i to\".split())\nfor slowo, ile in c.most_common(2):\n    print(slowo, ile)",
                "to 3\njest 1",
                "Pary z most_common() łatwo rozpakować w pętli.",
            ),
            fill(
                "Wypisz tylko jedno, najczęstsze słowo i jego liczbę.",
                "from collections import Counter\nc = Counter(\"x y x\".split())\nprint(c.most_common(____))",
                listOf("1", "0", "3"),
                "1",
                "most_common(1) zwraca listę z jedną, najczęstszą parą.",
            ),
            choice(
                "Co zwraca most_common() bez argumentu?",
                listOf("Wszystkie pary posortowane od najczęstszej", "Tylko najczęstszą parę", "Słownik bez zmian", "Pustą listę"),
                0,
                "Bez argumentu dostajemy pełną, posortowaną listę par.",
            ),
            output(
                "STOP = {\"i\", \"w\", \"a\"}\nslowa = \"kot i pies w domu\".split()\nwazne = [s for s in slowa if s not in STOP]\nprint(wazne)",
                "['kot', 'pies', 'domu']",
                "Słowa nieistotne (stop words) odrzucamy przed liczeniem.",
            ),
            output(
                "from collections import Counter\nc = Counter(\"b a b a c\".split())\nklucz = lambda p: (-p[1], p[0])\npary = sorted(c.items(), key=klucz)\nprint(pary[0])",
                "('a', 2)",
                "Sortujemy malejąco po liczbie, a przy remisie alfabetycznie.",
            ),
            tiles(
                "Zostaw tylko słowa mające co najmniej 3 litery",
                listOf("dlugie", "=", "[s for s in slowa", "if", "len(s) >= 3]"),
                listOf("while", "len(s) < 3]"),
                "Warunek if w wyrażeniu listowym filtruje słowa.",
            ),
            output(
                "from collections import Counter\nc = Counter(\"x y x z x y\".split())\nprint(c.most_common()[-1])",
                "('z', 1)",
                "Ostatni element most_common() to słowo najrzadsze.",
            ),
        ),
        lesson(
            "u68l4", "Krok 4: średnia długość słowa",
            output(
                "slowa = [\"ala\", \"ma\", \"kota\"]\ndl = [len(s) for s in slowa]\nprint(dl, sum(dl))",
                "[3, 2, 4] 9",
                "Najpierw zbieramy długości słów, potem je sumujemy.",
            ),
            output(
                "slowa = [\"ala\", \"ma\", \"kota\", \"psa\"]\nsuma = sum(len(s) for s in slowa)\nprint(suma / len(slowa))",
                "3.0",
                "Średnia to suma długości podzielona przez liczbę słów: 12 / 4.",
            ),
            fill(
                "Zaokrąglij średnią do dwóch miejsc po przecinku.",
                "srednia = 10 / 3\nprint(round(srednia, ____))",
                listOf("2", "0", "20"),
                "2",
                "Drugi argument round() to liczba miejsc po przecinku.",
            ),
            output(
                "slowa = [\"ala\", \"ma\", \"kotka\"]\nprint(max(slowa, key=len))\nprint(min(slowa, key=len))",
                "kotka\nma",
                "key=len każe porównywać słowa po długości.",
            ),
            choice(
                "Co się stanie, gdy policzymy średnią dla pustego tekstu bez sprawdzenia?",
                listOf("ZeroDivisionError – dzielimy przez len([]) = 0", "Wynik 0.0", "Wynik None", "IndexError"),
                0,
                "Dla pustej listy dzielimy przez zero, więc trzeba to sprawdzić wcześniej.",
            ),
            output(
                "from statistics import mean\nprint(mean([3, 2, 4, 3]))",
                "3",
                "statistics.mean() liczy średnią za nas.",
            ),
            tiles(
                "Oblicz średnią długość słów z listy slowa",
                listOf("sr", "=", "sum(map(len, slowa))", "/", "len(slowa)"),
                listOf("*", "max(slowa)"),
                "map(len, slowa) daje długości, a dzielimy przez liczbę słów.",
            ),
            output(
                "slowa = \"a b a c\".split()\nprint(len(slowa), len(set(slowa)))",
                "4 3",
                "set() usuwa powtórzenia, więc daje liczbę różnych słów.",
            ),
        ),
        lesson(
            "u68l5", "Projekt: raport z analizy",
            output(
                "sr = 3.14159\nprint(f\"Średnia: {sr:.2f}\")",
                "Średnia: 3.14",
                ":.2f wypisuje liczbę z dwoma miejscami po przecinku.",
            ),
            output(
                "from collections import Counter\ndef raport(tekst):\n    slowa = tekst.lower().split()\n    c = Counter(slowa)\n    print(\"Słów:\", len(slowa))\n    print(\"Różnych:\", len(c))\n    print(\"Top:\", c.most_common(1)[0][0])\n\nraport(\"Kot i pies i kot KOT\")",
                "Słów: 6\nRóżnych: 3\nTop: kot",
                "Raport łączy wszystkie poprzednie kroki: czyszczenie, liczenie i wybór najczęstszego.",
            ),
            output(
                "from collections import Counter\nc = Counter(\"a b a c a b\".split())\nfor s, n in c.most_common(2):\n    print(f\"{s}: {'#' * n}\")",
                "a: ###\nb: ##",
                "Mnożenie napisu przez liczbę rysuje prosty wykres słupkowy.",
            ),
            fill(
                "Wypisz słowa od najczęstszego do najrzadszego.",
                "from collections import Counter\nc = Counter(\"b a a\".split())\nfor s, n in c.____():\n    print(s, n)",
                listOf("most_common", "items", "values"),
                "most_common",
                "items() zachowuje kolejność dodania, a most_common() sortuje po liczbie.",
            ),
            choice(
                "Jaka jest dobra kolejność kroków analizatora?",
                listOf("czyszczenie → podział na słowa → liczenie → raport", "liczenie → czyszczenie → raport → podział na słowa", "raport → liczenie → czyszczenie → podział na słowa", "podział na słowa → raport → czyszczenie → liczenie"),
                0,
                "Najpierw przygotowujemy dane, potem liczymy, a na końcu prezentujemy wynik.",
            ),
            output(
                "from collections import Counter\nt = \"kot pies kot ryba kot pies\"\nc = Counter(t.split())\ntop = [s for s, _ in c.most_common(3)]\nprint(\", \".join(top))",
                "kot, pies, ryba",
                "join() skleja słowa w jeden czytelny napis.",
            ),
            tiles(
                "Napisz nagłówek pętli po trzech najczęstszych słowach z licznika c",
                listOf("for", "slowo, ile", "in", "c.most_common(3):"),
                listOf("c.items(3):", "while"),
                "most_common(3) zwraca trzy pary, które rozpakowujemy na slowo i ile.",
            ),
            output(
                "from string import punctuation as P\nfrom collections import Counter\nt = \"Ala ma kota. Kot ma Alę!\"\nusun = str.maketrans(\"\", \"\", P)\nslowa = t.translate(usun).lower().split()\nc = Counter(slowa)\nprint(len(slowa), c[\"ma\"])\nsr = sum(map(len, slowa)) / len(slowa)\nprint(round(sr, 2))",
                "6 2\n2.83",
                "Cały analizator w kilku linijkach: czyszczenie, liczenie i średnia długość.",
            ),
        ),
    ),
)
