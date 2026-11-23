package com.mrpython.app.data.course

import com.mrpython.app.domain.CourseUnit

internal val module7 = CourseUnit(
    id = "u7",
    title = "Napisy od środka",
    description = "Indeksy, wycinki i metody napisów",
    lessons = listOf(
        lesson(
            "u7l1", "Indeksy i wycinki",
            output("s = \"Python\"\nprint(s[0])", "P", "Indeksy napisu też zaczynają się od 0."),
            output("s = \"Python\"\nprint(s[-1])", "n", "-1 to ostatni znak."),
            output("s = \"Python\"\nprint(s[0:2])", "Py", "Wycinek [0:2] to znaki o indeksach 0 i 1."),
            output("s = \"Python\"\nprint(s[2:])", "thon", "Od indeksu 2 do końca."),
            output("print(\"abcdef\"[::2])", "ace", "Krok 2 bierze co drugi znak."),
            output("print(\"kotek\"[::-1])", "ketok", "[::-1] odwraca napis."),
            choice(
                "Co się stanie?",
                listOf("Błąd – napisów nie można zmieniać", "s zmieni się na „mot”", "s zmieni się na „m”", "Nic"),
                0,
                "Napisy są niezmienne. Trzeba utworzyć nowy: \"m\" + s[1:].",
                code = "s = \"kot\"\ns[0] = \"m\"",
            ),
            output("print(len(\"Ala ma kota\"))", "11", "Spacje też są znakami."),
        ),
        lesson(
            "u7l2", "Metody napisów",
            output("print(\"python\".upper())", "PYTHON", "upper() zamienia litery na wielkie."),
            output("print(\"PyThOn\".lower())", "python", "lower() zamienia litery na małe."),
            output("print(\"  hej  \".strip() + \"!\")", "hej!", "strip() usuwa spacje z początku i końca."),
            output("print(\"Ala ma kota\".replace(\"kota\", \"psa\"))", "Ala ma psa", "replace() podmienia fragment napisu."),
            output("print(\"banan\".count(\"a\"))", "2", "count() liczy wystąpienia fragmentu."),
            output("print(\"python\".find(\"th\"))", "2", "find() zwraca indeks, od którego zaczyna się fragment."),
            output("print(\"jan kowalski\".title())", "Jan Kowalski", "title() zaczyna każde słowo wielką literą."),
            fill(
                "Uzupełnij, aby sprawdzić, czy plik ma rozszerzenie .py.",
                "plik = \"main.py\"\nprint(plik.____(\".py\"))",
                listOf("endswith", "startswith", "find"),
                "endswith",
                "endswith() sprawdza, czym kończy się napis.",
            ),
        ),
        lesson(
            "u7l3", "split() i join()",
            output("print(\"a,b,c\".split(\",\"))", "['a', 'b', 'c']", "split() dzieli napis na listę w miejscach separatora."),
            output("slowa = \"Ala ma kota\".split()\nprint(len(slowa))", "3", "split() bez argumentu dzieli po spacjach."),
            output("print(\"-\".join([\"2026\", \"10\", \"22\"]))", "2026-10-22", "join() skleja listę napisów, wstawiając separator."),
            output("print(\"\".join([\"P\", \"y\"]))", "Py", "Pusty separator skleja elementy bez przerw."),
            output(
                "zdanie = \"lubię uczyć się pythona\"\nprint(zdanie.split()[-1])",
                "pythona",
                "split() daje listę, a [-1] bierze z niej ostatnie słowo.",
            ),
            output("print(\"Python\" in \"Uczę się Pythona\")", "True", "in sprawdza, czy fragment występuje w napisie."),
            fill(
                "Uzupełnij, aby połączyć słowa spacjami.",
                "slowa = [\"Hej\", \"Ola\"]\nprint(\" \".____(slowa))",
                listOf("join", "split", "append"),
                "join",
                "separator.join(lista) skleja elementy listy.",
            ),
            tiles(
                "Podziel napis tekst na słowa i zapisz je w zmiennej slowa",
                listOf("slowa", "=", "tekst.split()"),
                listOf("tekst.join()", "split(tekst)"),
                "split() wywołujemy na napisie: tekst.split().",
            ),
        ),
        lesson(
            "u7l4", "Powtórka: napisy",
            output("s = \"Mr.Python\"\nprint(s[3:])", "Python", "Od indeksu 3 do końca."),
            output("print(\"abc\".upper()[::-1])", "CBA", "Najpierw upper(), potem odwrócenie."),
            output("imie = \"ola\"\nprint(imie[0].upper() + imie[1:])", "Ola", "Pierwsza litera wielka, reszta bez zmian."),
            output("tekst = \"a b c\"\nprint(tekst.replace(\" \", \"\"))", "abc", "Zamiana spacji na pusty napis usuwa je."),
            choice(
                "Która metoda zamieni „hej” na „HEJ”?",
                listOf("upper()", "capitalize()", "big()", "title()"),
                0,
                "upper() zamienia wszystkie litery na wielkie.",
            ),
            output(
                "licz = 0\nfor z in \"Programowanie\":\n    if z in \"aeiou\":\n        licz += 1\nprint(licz)",
                "6",
                "Samogłoski w słowie to: o, a, o, a, i, e.",
            ),
            fill(
                "Uzupełnij, aby usunąć spacje z początku i końca.",
                "s = \"  tekst  \"\nprint(s.____())",
                listOf("strip", "split", "lower"),
                "strip",
                "strip() obcina białe znaki z brzegów napisu.",
            ),
            output("print(\"ab\" * 2 + \"c\".upper())", "ababC", "Najpierw powtórzenie napisu, potem dopisanie wielkiego C."),
        ),
    ),
)
