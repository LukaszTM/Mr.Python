package com.mrpython.app.data.course

import com.mrpython.app.domain.CourseUnit

internal val module55 = CourseUnit(
    id = "u55",
    title = "Projekt: kalkulator",
    description = "Budujemy kalkulator krok po kroku",
    lessons = listOf(
        lesson(
            "u55l1", "Funkcje działań",
            output(
                "def dodaj(a, b):\n    return a + b\n\ndef odejmij(a, b):\n    return a - b\n\nprint(dodaj(2, 3), odejmij(2, 3))",
                "5 -1",
                "Każde działanie to osobna, mała funkcja.",
            ),
            fill(
                "Uzupełnij operator, aby funkcja mnożyła liczby.",
                "def pomnoz(a, b):\n    return a ____ b\n\nprint(pomnoz(4, 5))",
                listOf("*", "x", "**"),
                "*",
                "Mnożenie w Pythonie to *, a ** to potęgowanie.",
            ),
            output(
                "def podziel(a, b):\n    return a / b\n\nprint(podziel(7, 2))",
                "3.5",
                "Operator / zawsze daje liczbę zmiennoprzecinkową.",
            ),
            choice(
                "Dlaczego każde działanie kalkulatora piszemy jako osobną funkcję?",
                listOf("Łatwo je testować, poprawiać i wywoływać z różnych miejsc", "Bo Python nie pozwala na operatory w print", "Żeby kod był dłuższy", "Bo funkcje działają szybciej niż operatory"),
                0,
                "Małe funkcje to małe, niezależne klocki programu.",
            ),
            tiles(
                "Napisz funkcję odejmij w jednej linii.",
                listOf("def odejmij(a, b):", "return", "a - b"),
                listOf("b - a", "print("),
                "Funkcja zwraca a pomniejszone o b.",
            ),
            output(
                "def dodaj(a, b):\n    return a + b\n\ndef pomnoz(a, b):\n    return a * b\n\nprint(dodaj(pomnoz(2, 3), 4))",
                "10",
                "Najpierw 2 * 3 = 6, potem 6 + 4 = 10.",
            ),
            output(
                "def potega(a, b):\n    return a ** b\n\nprint(potega(2, 10))",
                "1024",
                "2 do potęgi 10 to 1024.",
            ),
            choice(
                "Co się stanie po wywołaniu podziel(1, 0)?",
                listOf("ZeroDivisionError", "Zwróci 0", "Zwróci None", "Zwróci inf"),
                0,
                "Dzielenie przez zero zgłasza wyjątek – zajmiemy się nim w lekcji 4.",
                code = "def podziel(a, b):\n    return a / b\n\nprint(podziel(1, 0))",
            ),
        ),
        lesson(
            "u55l2", "Słownik funkcji",
            output(
                "def dodaj(a, b):\n    return a + b\n\ndzialania = {\"+\": dodaj}\nprint(dzialania[\"+\"](2, 3))",
                "5",
                "Ze słownika wyjmujemy funkcję i od razu ją wywołujemy.",
            ),
            choice(
                "Co jest wartością w słowniku {\"+\": dodaj}?",
                listOf("Sama funkcja dodaj, bez wywołania", "Wynik dodawania", "Napis \"dodaj\"", "Liczba"),
                0,
                "Funkcje to obiekty – można je przechowywać w słowniku.",
            ),
            fill(
                "Uzupełnij słownik, aby znak * wskazywał na funkcję razy.",
                "def razy(a, b):\n    return a * b\n\ndzialania = {\"*\": ____}\nprint(dzialania[\"*\"](3, 4))",
                listOf("razy", "razy()", "\"razy\""),
                "razy",
                "Wstawiamy samą funkcję, bez nawiasów i bez cudzysłowów.",
            ),
            output(
                "dzialania = {\n    \"+\": lambda a, b: a + b,\n    \"-\": lambda a, b: a - b,\n}\nfor znak in dzialania:\n    print(znak, dzialania[znak](8, 2))",
                "+ 10\n- 6",
                "Krótkie działania wygodnie zapisać jako lambdy.",
            ),
            output(
                "dzialania = {\"+\": lambda a, b: a + b}\nf = dzialania.get(\"%\")\nprint(f)",
                "None",
                "get zwraca None, gdy działania nie ma w słowniku.",
            ),
            tiles(
                "Wywołaj działanie dla podanego znaku i zapisz wynik.",
                listOf("wynik =", "dzialania[znak]", "(a, b)"),
                listOf("dzialania(znak)", "[a, b]"),
                "Najpierw wybieramy funkcję ze słownika, potem ją wywołujemy.",
            ),
            output(
                "import operator\n\ndzialania = {\"+\": operator.add, \"*\": operator.mul}\nprint(dzialania[\"*\"](6, 7))",
                "42",
                "Moduł operator ma gotowe funkcje dla operatorów, np. mul to mnożenie.",
            ),
            choice(
                "Dlaczego słownik funkcji jest lepszy od długiego if/elif?",
                listOf("Nowe działanie to jeden nowy wpis w słowniku", "Słownik nie wymaga funkcji", "if/elif nie działa ze znakami", "Słownik sam sprawdza błędy"),
                0,
                "Kod wybierający działanie nie zmienia się po dodaniu nowego znaku.",
            ),
        ),
        lesson(
            "u55l3", "Parsowanie wyrażenia",
            output(
                "tekst = \"2 + 3\"\nprint(tekst.split())",
                "['2', '+', '3']",
                "split() dzieli napis po spacjach.",
            ),
            output(
                "a, znak, b = \"10 * 4\".split()\nprint(int(a) * int(b))",
                "40",
                "Rozpakowujemy trzy części, a liczby zamieniamy przez int.",
            ),
            fill(
                "Uzupełnij metodę, która rozdzieli wyrażenie na części.",
                "a, znak, b = \"7 - 2\".____()\nprint(znak)",
                listOf("split", "strip", "join"),
                "split",
                "split() zwraca listę części napisu.",
            ),
            output(
                "a, znak, b = \"1.5 + 2\".split()\nprint(float(a) + float(b))",
                "3.5",
                "float pozwala obsłużyć liczby z kropką.",
            ),
            choice(
                "Co zwróci \"2+3\".split()?",
                listOf("['2+3']", "['2', '+', '3']", "['2', '3']", "Błąd"),
                0,
                "Bez spacji nie ma po czym dzielić – powstaje jednoelementowa lista.",
            ),
            output(
                "dz = {\"+\": lambda a, b: a + b,\n      \"*\": lambda a, b: a * b}\n\ndef oblicz(tekst):\n    a, znak, b = tekst.split()\n    return dz[znak](int(a), int(b))\n\nprint(oblicz(\"6 * 7\"))\nprint(oblicz(\"6 + 7\"))",
                "42\n13",
                "Parsowanie i słownik funkcji tworzą razem działający kalkulator.",
            ),
            tiles(
                "Rozdziel tekst na dwie liczby i znak.",
                listOf("a, znak, b", "=", "tekst.split()"),
                listOf("tekst.split", "=="),
                "split() trzeba wywołać nawiasami, a wynik rozpakować do trzech zmiennych.",
            ),
            choice(
                "Co się stanie po uruchomieniu tego kodu?",
                listOf("ValueError – za dużo wartości do rozpakowania", "a = 2, znak = +, b = 3", "TypeError", "Nic"),
                0,
                "Bez split napis \"2 + 3\" ma 5 znaków, a zmienne są tylko 3.",
                code = "a, znak, b = \"2 + 3\"",
            ),
        ),
        lesson(
            "u55l4", "Obsługa błędów",
            output(
                "def podziel(a, b):\n    if b == 0:\n        return \"Błąd: dzielenie przez 0\"\n    return a / b\n\nprint(podziel(8, 0))",
                "Błąd: dzielenie przez 0",
                "Sprawdzamy zero, zanim spróbujemy dzielić.",
            ),
            output(
                "def oblicz(tekst):\n    try:\n        a, znak, b = tekst.split()\n        return int(a) + int(b)\n    except ValueError:\n        return \"Złe dane\"\n\nprint(oblicz(\"2 +\"))\nprint(oblicz(\"x + 1\"))\nprint(oblicz(\"2 + 2\"))",
                "Złe dane\nZłe dane\n4",
                "Zła liczba części i zła liczba to w obu przypadkach ValueError.",
            ),
            fill(
                "Uzupełnij nazwę wyjątku dla dzielenia przez zero.",
                "try:\n    print(5 / 0)\nexcept ____:\n    print(\"Nie dziel przez 0!\")",
                listOf("ZeroDivisionError", "ValueError", "KeyError"),
                "ZeroDivisionError",
                "Dzielenie przez zero zgłasza ZeroDivisionError.",
            ),
            output(
                "dz = {\"+\": lambda a, b: a + b}\ntry:\n    print(dz[\"^\"](2, 3))\nexcept KeyError:\n    print(\"Nieznane działanie\")",
                "Nieznane działanie",
                "Brak znaku w słowniku daje KeyError.",
            ),
            choice(
                "Co się stanie po uruchomieniu tego kodu?",
                listOf("Program przerwie ZeroDivisionError – nie jest przechwycony", "Wypisze \"Złe dane\"", "Wypisze 0", "Wypisze inf"),
                0,
                "except ValueError nie łapie dzielenia przez zero.",
                code = "try:\n    a, znak, b = \"3 / 0\".split()\n    print(int(a) / int(b))\nexcept ValueError:\n    print(\"Złe dane\")",
            ),
            tiles(
                "Zgłoś błąd ValueError z komunikatem \"Nieznane działanie\".",
                listOf("raise", "ValueError(", "\"Nieznane działanie\"", ")"),
                listOf("return", "except"),
                "raise zgłasza wyjątek z komunikatem.",
            ),
            output(
                "def oblicz(a, znak, b):\n    if znak not in \"+-\":\n        raise ValueError(\"zły znak\")\n    return a + b if znak == \"+\" else a - b\n\ntry:\n    oblicz(1, \"?\", 2)\nexcept ValueError as e:\n    print(e)",
                "zły znak",
                "Funkcja zgłasza błąd, a wywołujący go przechwytuje.",
            ),
            output(
                "for t in [\"12\", \"1a\", \"\"]:\n    print(t.isdigit())",
                "True\nFalse\nFalse",
                "isdigit() pomaga sprawdzić dane przed zamianą na liczbę.",
            ),
        ),
        lesson(
            "u55l5", "Historia i podsumowanie projektu",
            output(
                "historia = []\nfor w in [3 + 4, 10 / 4]:\n    historia.append(w)\nprint(historia)",
                "[7, 2.5]",
                "Każdy wynik dopisujemy na koniec listy historii.",
            ),
            fill(
                "Uzupełnij metodę, która dopisze wynik do historii.",
                "historia = []\nwynik = 5\nhistoria.____(wynik)\nprint(historia)",
                listOf("append", "add", "push"),
                "append",
                "Listy mają metodę append; add jest dla zbiorów.",
            ),
            output(
                "class Kalkulator:\n    def __init__(self):\n        self.historia = []\n    def dodaj(self, a, b):\n        w = a + b\n        self.historia.append(w)\n        return w\n\nk = Kalkulator()\nk.dodaj(1, 2)\nk.dodaj(5, 5)\nprint(k.historia)",
                "[3, 10]",
                "Obiekt pamięta historię w swoim atrybucie.",
            ),
            output(
                "historia = [5, 12, 7]\nprint(\"Ostatni:\", historia[-1])\nprint(\"Suma:\", sum(historia))",
                "Ostatni: 7\nSuma: 24",
                "historia[-1] to ostatni wynik.",
            ),
            output(
                "historia = [(\"2 + 3\", 5), (\"4 * 2\", 8)]\nfor wyr, w in historia:\n    print(f\"{wyr} = {w}\")",
                "2 + 3 = 5\n4 * 2 = 8",
                "Krotka przechowuje wyrażenie razem z wynikiem.",
            ),
            choice(
                "W jakiej kolejności działa nasz kalkulator dla tekstu \"6 * 7\"?",
                listOf("split → wybór funkcji ze słownika → wywołanie → zapis do historii", "zapis do historii → split → wywołanie", "wywołanie → split → słownik", "słownik → historia → split"),
                0,
                "Najpierw rozbijamy tekst, potem liczymy, na końcu zapamiętujemy wynik.",
            ),
            tiles(
                "Dopisz do historii krotkę z tekstem i wynikiem.",
                listOf("historia.append(", "(tekst, wynik)", ")"),
                listOf("historia.add(", "[tekst]"),
                "append dodaje jeden element – tu krotkę.",
            ),
            output(
                "dz = {\"+\": lambda a, b: a + b,\n      \"/\": lambda a, b: a / b}\nhistoria = []\nfor t in [\"1 + 2\", \"9 / 3\"]:\n    a, z, b = t.split()\n    historia.append(dz[z](int(a), int(b)))\nprint(historia)",
                "[3, 3.0]",
                "Dzielenie / daje float, dlatego 3.0.",
            ),
        ),
    ),
)
