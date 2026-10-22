package com.mrpython.app.data.course

internal val module30Cards = listOf(
    cards(
        "u30l1",
        explain(
            "Odwracanie kolejności słów",
            "`[::-1]` działa też na listach. Żeby odwrócić kolejność słów, rozbij zdanie przez `split()`, " +
                "odwróć listę i sklej ją z powrotem przez `\" \".join()`.",
            code = "slowa = \"Ala ma kota\".split()\nprint(slowa[::-1])\nprint(\" \".join(slowa[::-1]))",
            output = "['kota', 'ma', 'Ala']\nkota ma Ala",
        ),
        explain(
            "Palindrom ze spacjami",
            "W zdaniu przeszkadzają spacje i wielkie litery. `replace(\" \", \"\")` usuwa wszystkie spacje, " +
                "a `lower()` zmienia litery na małe – dopiero potem porównujemy z odwróceniem.",
            code = "s = \"Kobyła ma mały bok\"\nt = s.replace(\" \", \"\").lower()\nprint(t)\nprint(t == t[::-1])",
            output = "kobyłamamałybok\nTrue",
        ),
        explain(
            "Wielka pierwsza litera",
            "`s[0].upper() + s[1:]` zamienia na wielką tylko pierwszą literę słowa. Metoda `title()` " +
                "robi to od razu dla każdego słowa w napisie.",
            code = "s = \"ala\"\nprint(s[0].upper() + s[1:])\nprint(\"jan nowak\".title())",
            output = "Ala\nJan Nowak",
        ),
    ),
    cards(
        "u30l2",
        explain(
            "Posortowane litery jako napis",
            "`sorted(s)` zwraca listę liter. `\"\".join(sorted(s))` skleja ją w napis – wszystkie anagramy " +
                "dają ten sam napis, więc może on służyć jako klucz w słowniku grupującym.",
            code = "print(\"\".join(sorted(\"szok\")))\nprint(\"\".join(sorted(\"kosz\")))",
            output = "kosz\nkosz",
        ),
        explain(
            "Dlaczego nie set()?",
            "Zbiór pamięta tylko, jakie litery wystąpiły, a nie ile razy. Dlatego `set()` uzna „lasa” i „las” " +
                "za równe, a `sorted()` poprawnie wykryje różnicę.",
            code = "print(set(\"lasa\") == set(\"las\"))\nprint(sorted(\"lasa\") == sorted(\"las\"))",
            output = "True\nFalse",
        ),
        explain(
            "Porównanie liczników",
            "Anagramy można też sprawdzić, licząc litery w słownikach. Dwa słowniki są równe, gdy mają te same " +
                "klucze i wartości – kolejność kluczy nie ma znaczenia.",
            code = "print({\"a\": 2, \"t\": 1} == {\"t\": 1, \"a\": 2})",
            output = "True",
        ),
    ),
    cards(
        "u30l3",
        explain(
            "Najczęstszy znak",
            "`max(d, key=d.get)` przechodzi po kluczach słownika, ale porównuje ich wartości – zwraca klucz " +
                "z największym licznikiem. Tak samo `sorted(d, key=d.get)` układa klucze od najmniejszej wartości.",
            code = "d = {\"a\": 2, \"b\": 5, \"c\": 1}\nprint(max(d, key=d.get))\nprint(sorted(d, key=d.get))",
            output = "b\n['c', 'a', 'b']",
        ),
        explain(
            "Pary od największej",
            "`d.items()` daje pary (znak, liczba). Sortując z `key=lambda p: -p[1]`, porównujemy liczby " +
                "ze znakiem minus, więc największe trafiają na początek.",
            code = "d = {\"x\": 1, \"y\": 3}\nprint(sorted(d.items(), key=lambda p: -p[1]))",
            output = "[('y', 3), ('x', 1)]",
        ),
    ),
    cards(
        "u30l4",
        explain(
            "Odszyfrowanie",
            "Żeby odszyfrować, przesuwamy litery o klucz wstecz, czyli o `-k`. `% 26` działa też dla liczb " +
                "ujemnych: `-1 % 26` daje 25, więc przed „a” wracamy do „z”.",
            code = "print(-1 % 26)\nn = (ord(\"a\") - 97 - 1) % 26\nprint(chr(97 + n))",
            output = "25\nz",
        ),
        explain(
            "Wielkie litery i spacje",
            "Wielkie litery mają inne kody niż małe: „A” to 65, a „a” to 97. Szyfrując, spacje i inne znaki " +
                "zwykle przepisujemy bez zmian, sprawdzając je warunkiem `if`.",
            code = "print(ord(\"A\"), ord(\"a\"))\nprint(chr(65 + 25))",
            output = "65 97\nZ",
        ),
        explain(
            "Szyfrowanie w jednej linii",
            "Zamiast dopisywać litery w pętli, możemy podać wyrażenie generatorowe prosto do `\"\".join()` – " +
                "skleja ono wszystkie przesunięte znaki w napis.",
            code = "s = \"abc\"\nprint(\"\".join(chr(ord(z) + 1) for z in s))",
            output = "bcd",
        ),
    ),
)
