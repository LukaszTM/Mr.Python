package com.mrpython.app.data.course

import com.mrpython.app.domain.CourseUnit

internal val module1 = CourseUnit(
    id = "u1",
    title = "Pierwsze kroki",
    description = "print(), napisy i komentarze",
    lessons = listOf(
        lesson(
            "u1l1", "Witaj, świecie!",
            choice(
                "Która instrukcja wypisze tekst na ekranie?",
                listOf("print(\"Cześć\")", "echo \"Cześć\"", "console.log(\"Cześć\")", "printf Cześć"),
                0,
                "W Pythonie tekst wypisujemy funkcją print().",
            ),
            output(
                "print(\"Witaj, świecie!\")",
                "Witaj, świecie!",
                "print() wypisuje napis bez cudzysłowów.",
            ),
            tiles(
                "Ułóż kod, który wypisze: Hej",
                listOf("print(", "\"Hej\"", ")"),
                listOf("echo", "Hej"),
                "Napis musi być w cudzysłowie i w nawiasach funkcji print.",
            ),
            fill(
                "Uzupełnij, aby wypisać słowo Python.",
                "____(\"Python\")",
                listOf("print", "write", "say"),
                "print",
                "Funkcja wypisująca tekst to print.",
            ),
            output(
                "print(\"Ala\")\nprint(\"ma kota\")",
                "Ala\nma kota",
                "Każde wywołanie print() kończy się nową linią.",
            ),
            choice(
                "Czego brakuje w tym kodzie?",
                listOf("Zamykającego nawiasu )", "Średnika na końcu", "Słowa def", "Niczego – kod jest poprawny"),
                0,
                "Każdy otwarty nawias trzeba zamknąć.",
                code = "print(\"Hej\"",
            ),
            output(
                "print(\"2 + 3\")\nprint(2 + 3)",
                "2 + 3\n5",
                "W cudzysłowie to tekst, bez cudzysłowu – działanie do obliczenia.",
            ),
        ),
        lesson(
            "u1l2", "Napisy i komentarze",
            choice(
                "Co oznacza znak # w Pythonie?",
                listOf(
                    "Początek komentarza – Python go pomija",
                    "Liczbę",
                    "Koniec programu",
                    "Mnożenie",
                ),
                0,
                "Wszystko od # do końca linii to komentarz dla ludzi, nie dla komputera.",
            ),
            output(
                "# print(\"A\")\nprint(\"B\")",
                "B",
                "Pierwsza linia jest komentarzem, więc się nie wykona.",
            ),
            choice(
                "Który zapis napisu jest poprawny?",
                listOf("\"tekst\" oraz 'tekst' – oba", "Tylko \"tekst\"", "Tylko 'tekst'", "«tekst»"),
                0,
                "Python akceptuje zarówno cudzysłowy, jak i apostrofy.",
            ),
            output(
                "print(\"Py\" + \"thon\")",
                "Python",
                "Operator + skleja (konkatenuje) napisy.",
            ),
            output(
                "print(\"ha\" * 3)",
                "hahaha",
                "Napis pomnożony przez liczbę powtarza się tyle razy.",
            ),
            output(
                "print(\"Ala\", \"ma\", \"kota\")",
                "Ala ma kota",
                "Kilka argumentów print() rozdziela spacjami.",
            ),
            output(
                "print(\"Ala\" + \" \" + \"Ola\")",
                "Ala Ola",
                "Spację trzeba dodać samemu – + jej nie wstawia.",
            ),
            choice(
                "Który zapis poprawnie wypisze: It's OK",
                listOf("print(\"It's OK\")", "print('It's OK')", "print(It's OK)", "print(\"It\"s OK\")"),
                0,
                "Apostrof w napisie otoczonym cudzysłowami \" \" niczemu nie przeszkadza.",
            ),
        ),
        lesson(
            "u1l3", "Znaki specjalne i print()",
            output("print(\"Ala\\nma kota\")", "Ala\nma kota", "\\n w napisie oznacza przejście do nowej linii."),
            choice(
                "Co oznacza \\t w napisie?",
                listOf("Tabulator (odstęp)", "Nową linię", "Literę t", "Koniec napisu"),
                0,
                "\\t wstawia znak tabulacji, czyli szeroki odstęp.",
            ),
            output("print(\"A\", end=\"\")\nprint(\"B\")", "AB", "end=\"\" sprawia, że print nie przechodzi do nowej linii."),
            output("print(\"A\", \"B\", \"C\", sep=\"-\")", "A-B-C", "sep ustala, czym są rozdzielane argumenty."),
            fill(
                "Uzupełnij, aby oba słowa pojawiły się w jednej linii.",
                "print(\"Raz\", ____=\" \")\nprint(\"dwa\")",
                listOf("end", "sep", "new"),
                "end",
                "Parametr end określa, co print dopisze na końcu zamiast nowej linii.",
            ),
            output("print(\"Cena:\", 5, \"zł\")", "Cena: 5 zł", "print() może wypisywać napisy i liczby razem."),
            choice(
                "Ile linii wypisze ten kod?",
                listOf("3", "1", "2", "0"),
                0,
                "Dwa znaki \\n dzielą tekst na trzy linie.",
                code = "print(\"a\\nb\\nc\")",
            ),
            tiles(
                "Ułóż kod, który wypisze: A,B",
                listOf("print(", "\"A\",", "\"B\",", "sep=\",\"", ")"),
                listOf("end=\",\"", "+"),
                "sep=\",\" rozdziela argumenty przecinkiem zamiast spacji.",
            ),
        ),
        lesson(
            "u1l4", "Powtórka: pierwsze kroki",
            output("print(\"Py\" * 2 + \"!\")", "PyPy!", "Najpierw mnożenie napisu, potem sklejanie."),
            choice(
                "Która linia NIE wypisze niczego?",
                listOf("# print(\"Hej\")", "print(\"Hej\")", "print('Hej')", "print(\"# Hej\")"),
                0,
                "Linia zaczynająca się od # to komentarz.",
            ),
            output("print(\"# to nie komentarz\")", "# to nie komentarz", "# wewnątrz napisu to zwykły znak."),
            output("print(\"Wynik:\", 10 * 3)", "Wynik: 30", "Python oblicza 10 * 3 i wypisuje wynik obok tekstu."),
            fill(
                "Uzupełnij, aby powtórzyć napis 3 razy.",
                "print(\"la\" ____ 3)",
                listOf("*", "+", "x"),
                "*",
                "Napis pomnożony przez liczbę powtarza się.",
            ),
            tiles(
                "Ułóż kod, który wypisze: Hej, Ola!",
                listOf("print(", "\"Hej, \"", "+", "\"Ola!\"", ")"),
                listOf("-", "echo"),
                "+ skleja dwa napisy w jeden.",
            ),
            output("print(\"1\" + \"2\")\nprint(1 + 2)", "12\n3", "Napisy się sklejają, a liczby dodają."),
            output(
                "print(\"A\", end=\" \")\nprint(\"B\", end=\" \")\nprint(\"C\")",
                "A B C",
                "end=\" \" zamienia przejście do nowej linii na spację.",
            ),
        ),
    ),
)
