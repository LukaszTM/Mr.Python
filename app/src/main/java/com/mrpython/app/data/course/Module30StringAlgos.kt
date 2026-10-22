package com.mrpython.app.data.course

import com.mrpython.app.domain.CourseUnit

internal val module30 = CourseUnit(
    id = "u30",
    title = "Algorytmy na napisach",
    description = "Palindromy, anagramy, liczenie znaków i szyfr Cezara",
    lessons = listOf(
        lesson(
            "u30l1", "Odwracanie i palindromy",
            output("print(\"python\"[::-1])", "nohtyp", "[::-1] czyta napis od końca."),
            output(
                "zdanie = \"Ala ma kota\"\nprint(\" \".join(zdanie.split()[::-1]))",
                "kota ma Ala",
                "Odwracamy listę słów, a nie litery.",
            ),
            output(
                "slowa = \"ala ma kota\".split()\nduze = [s[0].upper() + s[1:] for s in slowa]\nprint(\" \".join(duze))",
                "Ala Ma Kota",
                "Pierwsza litera każdego słowa jest wielka, reszta bez zmian.",
            ),
            output(
                "def palindrom(s):\n    return s == s[::-1]\n\nprint(palindrom(\"kajak\"), palindrom(\"kotek\"))",
                "True False",
                "„kajak” czytany od tyłu się nie zmienia, „kotek” – tak.",
            ),
            output(
                "s = \"Kobyła ma mały bok\"\nt = s.replace(\" \", \"\").lower()\nprint(t == t[::-1])",
                "True",
                "Po usunięciu spacji i zmianie na małe litery napis jest palindromem.",
            ),
            fill(
                "Uzupełnij, aby porównanie ignorowało wielkość liter.",
                "s = \"Anna\"\nt = s.____()\nprint(t == t[::-1])",
                listOf("lower", "strip", "title"),
                "lower",
                "Po lower() mamy „anna”, czyli palindrom.",
            ),
            choice(
                "Dlaczego \"Kajak\" == \"Kajak\"[::-1] daje False?",
                listOf(
                    "Wielkie K na początku to inny znak niż małe k na końcu",
                    "Bo [::-1] nie działa na napisach",
                    "Bo słowo kajak nie jest palindromem",
                    "Bo napisów nie można porównywać",
                ),
                0,
                "Porównanie rozróżnia wielkość liter – trzeba użyć lower().",
            ),
            tiles(
                "Zapisz w zmiennej odwr słowa z listy slowa w odwrotnej kolejności",
                listOf("odwr", "=", "slowa[::-1]"),
                listOf("slowa[::1]", "slowa[-1]"),
                "Wycinek z krokiem -1 odwraca listę.",
            ),
        ),
        lesson(
            "u30l2", "Anagramy",
            choice(
                "Kiedy dwa słowa są anagramami?",
                listOf(
                    "Gdy składają się z tych samych liter w tej samej liczbie",
                    "Gdy mają tę samą długość",
                    "Gdy zaczynają się na tę samą literę",
                    "Gdy jedno jest odwróceniem drugiego",
                ),
                0,
                "Anagram to przestawienie liter, np. „kosz” i „szok”.",
            ),
            output("print(sorted(\"kosz\") == sorted(\"szok\"))", "True", "Po posortowaniu liter oba słowa dają tę samą listę."),
            output(
                "def anagram(a, b):\n    return sorted(a) == sorted(b)\n\nprint(anagram(\"lis\", \"sil\"), anagram(\"las\", \"sala\"))",
                "True False",
                "„sala” ma o jedno „a” więcej niż „las”.",
            ),
            output(
                "def norm(s):\n    return sorted(s.replace(\" \", \"\").lower())\n\nprint(norm(\"Ala\") == norm(\"la a\"))",
                "True",
                "Po usunięciu spacji i zmianie na małe litery oba mają litery a, a, l.",
            ),
            output(
                "d = {}\nfor z in \"abba\":\n    d[z] = d.get(z, 0) + 1\nprint(d)",
                "{'a': 2, 'b': 2}",
                "Słownik zlicza, ile razy wystąpiła każda litera.",
            ),
            output(
                "def licz(s):\n    d = {}\n    for z in s:\n        d[z] = d.get(z, 0) + 1\n    return d\n\nprint(licz(\"lata\") == licz(\"tala\"))",
                "True",
                "Słowniki są równe, gdy mają te same klucze i wartości – kolejność nie ma znaczenia.",
            ),
            fill(
                "Uzupełnij, aby sprawdzić, czy słowa są anagramami.",
                "a, b = \"marka\", \"karma\"\nprint(sorted(a) == ____(b))",
                listOf("sorted", "list", "set"),
                "sorted",
                "Obie strony muszą być posortowanymi listami liter.",
            ),
            tiles(
                "Wypisz, czy napisy a i b są anagramami",
                listOf("print(sorted(a)", "==", "sorted(b))"),
                listOf("sorted(b)", "="),
                "Porównujemy posortowane litery obu napisów.",
            ),
        ),
        lesson(
            "u30l3", "Liczenie znaków",
            output(
                "licznik = {}\nfor z in \"banan\":\n    licznik[z] = licznik.get(z, 0) + 1\nprint(licznik)",
                "{'b': 1, 'a': 2, 'n': 2}",
                "get(z, 0) zwraca 0 dla litery, której jeszcze nie ma w słowniku.",
            ),
            output(
                "licznik = {\"a\": 3, \"k\": 1, \"t\": 2}\nprint(max(licznik, key=licznik.get))",
                "a",
                "key=licznik.get porównuje klucze według ich wartości.",
            ),
            fill(
                "Uzupełnij, aby zwiększyć licznik litery z, także gdy jej jeszcze nie ma w słowniku.",
                "d = {}\nfor z in \"ala\":\n    d[z] = d.____(z, 0) + 1\nprint(d)",
                listOf("get", "keys", "values"),
                "get",
                "d.get(z, 0) daje 0, gdy klucza z brakuje.",
            ),
            output(
                "tekst = \"programowanie\"\nsam = {s: tekst.count(s) for s in \"aeo\"}\nprint(sam)",
                "{'a': 2, 'e': 1, 'o': 2}",
                "W słowie „programowanie” są dwa a, jedno e i dwa o.",
            ),
            choice(
                "Dlaczego do liczenia wszystkich liter lepiej użyć słownika niż wołać tekst.count(z) dla każdej litery?",
                listOf(
                    "count() za każdym razem przechodzi cały napis, a słownik liczy w jednym przejściu",
                    "count() nie działa na napisach",
                    "Słownik sam sortuje litery",
                    "Nie ma żadnej różnicy",
                ),
                0,
                "Jedno przejście to O(n), a count() dla każdej litery może dać O(n²).",
            ),
            output(
                "d = {}\nfor z in \"kotlet\":\n    d[z] = d.get(z, 0) + 1\nprint([z for z in d if d[z] == 1])",
                "['k', 'o', 'l', 'e']",
                "Tylko t występuje dwa razy, pozostałe litery – raz.",
            ),
            output(
                "d = {\"x\": 1, \"y\": 3, \"z\": 2}\npary = sorted(d.items(), key=lambda p: -p[1])\nfor znak, n in pary:\n    print(znak, n)",
                "y 3\nz 2\nx 1",
                "Minus przy wartości sortuje od najczęstszego znaku.",
            ),
            tiles(
                "Zwiększ licznik znaku z w słowniku d",
                listOf("d[z]", "=", "d.get(z, 0)", "+ 1"),
                listOf("d[z, 0]", "=="),
                "Bierzemy dotychczasową liczbę (lub 0) i dodajemy 1.",
            ),
        ),
        lesson(
            "u30l4", "Szyfr Cezara",
            output("print(ord(\"a\"), chr(98))", "97 b", "ord() daje kod znaku, a chr() zamienia kod z powrotem na znak."),
            output("z = \"c\"\nprint(chr(ord(z) + 3))", "f", "Kod litery c powiększony o 3 to kod litery f."),
            output(
                "z = \"y\"\nk = (ord(z) - ord(\"a\") + 3) % 26\nprint(chr(ord(\"a\") + k))",
                "b",
                "y to pozycja 24, 24 + 3 = 27, a 27 % 26 = 1, czyli b.",
            ),
            choice(
                "Po co w szyfrze Cezara jest % 26?",
                listOf(
                    "Żeby po „z” wrócić na początek alfabetu",
                    "Żeby zamienić litery na wielkie",
                    "Żeby usunąć spacje",
                    "Żeby policzyć samogłoski",
                ),
                0,
                "Alfabet ma 26 liter, więc reszta z dzielenia zawija przesunięcie.",
            ),
            output(
                "def szyfruj(s, k):\n    wynik = \"\"\n    for z in s:\n        n = (ord(z) - ord(\"a\") + k) % 26\n        wynik += chr(ord(\"a\") + n)\n    return wynik\n\nprint(szyfruj(\"xyz\", 2))",
                "zab",
                "x przesuwa się na z, a y i z zawijają się na a i b.",
            ),
            fill(
                "Uzupełnij, aby odszyfrować literę (przesunąć ją wstecz o 3).",
                "z = \"d\"\nn = (ord(z) - ord(\"a\") ____ 3) % 26\nprint(chr(ord(\"a\") + n))",
                listOf("-", "+", "*"),
                "-",
                "Odszyfrowanie to przesunięcie w przeciwną stronę – z d wracamy do a.",
            ),
            output(
                "wynik = \"\"\nfor z in \"ab c\":\n    if z == \" \":\n        wynik += z\n    else:\n        wynik += chr(ord(z) + 1)\nprint(wynik)",
                "bc d",
                "Spacja zostaje bez zmian, a litery przesuwają się o 1.",
            ),
            tiles(
                "Przesuń literę z o 1 w alfabecie (bez zawijania) i zapisz w zmiennej nowa",
                listOf("nowa", "=", "chr(", "ord(z)", "+ 1", ")"),
                listOf("ord(", "chr(z)"),
                "Najpierw kod litery, potem +1, a na końcu chr() z powrotem na znak.",
            ),
        ),
        lesson(
            "u30l5", "Powtórka: napisy",
            output(
                "s = \"Ile Roman ładny dyndał na moreli\"\nt = s.replace(\" \", \"\").lower()\nprint(t == t[::-1])",
                "True",
                "Bez spacji i wielkich liter zdanie czyta się tak samo od tyłu.",
            ),
            output("print(sorted(\"rak\") == sorted(\"kar\"))", "True", "„rak” i „kar” to anagramy."),
            output(
                "d = {}\nfor z in \"kajak\":\n    d[z] = d.get(z, 0) + 1\nprint(d)",
                "{'k': 2, 'a': 2, 'j': 1}",
                "Klucze są w kolejności pierwszego wystąpienia liter.",
            ),
            output(
                "s = \"abc\"\nprint(\"\".join(chr(ord(z) + 1) for z in s))",
                "bcd",
                "Każda litera przesuwa się o jedną pozycję dalej.",
            ),
            choice(
                "Co zwróci chr(ord(\"A\") + 2)?",
                listOf("C", "B", "67", "A2"),
                0,
                "Dwa kody dalej po A jest C.",
            ),
            output(
                "zdanie = \"ala ma kota\"\nprint(\" \".join(s[::-1] for s in zdanie.split()))",
                "ala am atok",
                "Odwracamy każde słowo osobno, ale ich kolejność zostaje.",
            ),
            fill(
                "Uzupełnij, aby każde słowo zaczynało się wielką literą.",
                "print(\"jan nowak\".____())",
                listOf("title", "upper", "capitalize"),
                "title",
                "title() daje wielką literę na początku każdego słowa.",
            ),
            tiles(
                "Wypisz, czy napis t jest palindromem",
                listOf("print(t", "==", "t[::-1])"),
                listOf("t[::1])", "="),
                "Palindrom jest równy swojemu odwróceniu.",
            ),
        ),
    ),
)
