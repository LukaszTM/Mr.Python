package com.mrpython.app.data.course

internal val module68Intro = lesson(
    "u68l0", "Wprowadzenie: projekt analizy tekstu",
    explain(
        "Plan projektu",
        "W tym module krok po kroku budujesz analizator tekstu: czyszczenie, liczenie słów, " +
            "najczęstsze słowa, średnia długość i na końcu raport. Zaczynamy od porządków w tekście.",
        code = "tekst = \"  Ala MA Kota!  \"\nprint(tekst.strip().lower().replace(\"!\", \"\"))",
        output = "ala ma kota",
    ),
    explain(
        "Słowa z tekstu",
        "`split()` bez argumentu dzieli tekst po dowolnych białych znakach i daje listę słów. " +
            "Słowa liczymy w słowniku z `get(s, 0) + 1`.",
        code = "licznik = {}\nfor s in \"kot pies kot\".split():\n    licznik[s] = licznik.get(s, 0) + 1\nprint(licznik)",
        output = "{'kot': 2, 'pies': 1}",
    ),
    explain(
        "Najczęstsze słowa",
        "`Counter` robi to samo krócej, a `most_common(n)` zwraca n par (słowo, liczba) od najczęstszego. " +
            "Słowa typu „i”, „w” warto odfiltrować zbiorem.",
        code = "from collections import Counter\nc = Counter(\"a b a c a b\".split())\nprint(c.most_common(2))",
        output = "[('a', 3), ('b', 2)]",
    ),
    explain(
        "Średnia długość słowa",
        "Średnia to suma długości podzielona przez liczbę słów. `max(slowa, key=len)` znajdzie najdłuższe słowo.",
        code = "slowa = [\"ala\", \"ma\", \"kota\"]\nprint(sum(len(s) for s in slowa) / len(slowa))\nprint(max(slowa, key=len))",
        output = "3.0\nkota",
    ),
    explain(
        "Raport",
        "Na koniec ładnie wypisujemy wyniki: `:.2f` zaokrągla do dwóch miejsc, a `\"#\" * n` " +
            "rysuje prosty wykres słupkowy.",
        code = "sr = 3.14159\nprint(f\"Średnia: {sr:.2f}\")\nprint(\"kot:\", \"#\" * 3)",
        output = "Średnia: 3.14\nkot: ###",
    ),
    output(
        "from collections import Counter\nc = Counter(\"x y x\".split())\nprint(c[\"x\"], c[\"z\"])",
        "2 0",
        "Counter zwraca 0 dla słowa, którego nie było.",
    ),
    choice(
        "Co zwraca \"Ala  ma\\nkota\".split()?",
        listOf("['Ala', 'ma', 'kota']", "['Ala', '', 'ma', 'kota']", "['Ala  ma', 'kota']", "'Ala ma kota'"),
        0,
        "split() bez argumentu dzieli po dowolnych białych znakach i pomija puste kawałki.",
    ),
)
