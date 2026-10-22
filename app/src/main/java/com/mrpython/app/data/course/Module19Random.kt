package com.mrpython.app.data.course

import com.mrpython.app.domain.CourseUnit

internal val module19 = CourseUnit(
    id = "u19",
    title = "Losowość",
    description = "Moduł random: losowe liczby, wybór i mieszanie",
    lessons = listOf(
        lesson(
            "u19l1", "randint i random",
            choice(
                "Co zwraca random.randint(1, 6)?",
                listOf(
                    "Liczbę całkowitą od 1 do 6 (włącznie)",
                    "Liczbę całkowitą od 1 do 5",
                    "Liczbę float od 1 do 6",
                    "Zawsze 6",
                ),
                0,
                "randint obejmuje oba końce przedziału – jak rzut kostką.",
            ),
            output(
                "import random\nx = random.randint(1, 6)\nprint(1 <= x <= 6)",
                "True",
                "Wynik jest losowy, ale zawsze mieści się w przedziale 1–6.",
            ),
            choice(
                "Co zwraca random.random()?",
                listOf(
                    "Liczbę float z przedziału [0, 1)",
                    "Liczbę całkowitą 0 lub 1",
                    "Liczbę od 1 do 100",
                    "Losowy napis",
                ),
                0,
                "random() daje ułamek od 0 (włącznie) do 1 (bez 1).",
            ),
            output(
                "import random\nx = random.random()\nprint(0 <= x < 1)",
                "True",
                "random() nigdy nie zwraca 1 ani liczby ujemnej.",
            ),
            fill(
                "Uzupełnij, aby wylosować liczbę całkowitą od 1 do 10.",
                "import random\nprint(random.____(1, 10))",
                listOf("randint", "random", "choice"),
                "randint",
                "randint(a, b) losuje liczbę całkowitą z przedziału a–b.",
            ),
            output("import random\nx = random.randint(5, 5)\nprint(x)", "5", "Przedział 5–5 ma tylko jedną liczbę."),
            output(
                "import random\nx = random.randint(1, 3)\nprint(type(x))",
                "<class 'int'>",
                "randint zawsze zwraca liczbę całkowitą.",
            ),
            tiles(
                "Wylosuj liczbę od 1 do 100 i zapisz ją w zmiennej x.",
                listOf("x =", "random.randint(", "1, 100", ")"),
                listOf("random.random(", "1, 101"),
                "randint(1, 100) obejmuje oba końce.",
            ),
        ),
        lesson(
            "u19l2", "choice, shuffle i sample",
            output("import random\nprint(random.choice([\"a\"]))", "a", "Z listy z jednym elementem można wylosować tylko ten element."),
            output(
                "import random\nkolory = [\"red\", \"blue\"]\nk = random.choice(kolory)\nprint(k in kolory)",
                "True",
                "choice zawsze zwraca któryś element listy.",
            ),
            choice(
                "Co robi random.shuffle(lista)?",
                listOf(
                    "Miesza elementy listy w miejscu i zwraca None",
                    "Zwraca nową, posortowaną listę",
                    "Usuwa losowy element",
                    "Zwraca jeden losowy element",
                ),
                0,
                "shuffle zmienia kolejność w samej liście, niczego nie zwraca.",
            ),
            output(
                "import random\nliczby = [1, 2, 3, 4]\nrandom.shuffle(liczby)\nprint(sorted(liczby))",
                "[1, 2, 3, 4]",
                "Mieszanie zmienia kolejność, ale nie elementy – po sortowaniu wracamy do początku.",
            ),
            output(
                "import random\nx = random.sample(range(10), 3)\nprint(len(x))",
                "3",
                "sample(dane, k) zwraca listę k losowych elementów.",
            ),
            choice(
                "Czym różni się random.sample(lista, 2) od dwóch wywołań random.choice?",
                listOf(
                    "sample nie powtarza elementów",
                    "sample zawsze zwraca dwa pierwsze elementy",
                    "choice zwraca listę",
                    "Niczym się nie różni",
                ),
                0,
                "sample losuje bez powtórzeń, a dwa choice mogą trafić ten sam element.",
            ),
            fill(
                "Uzupełnij, aby wybrać jeden losowy element listy.",
                "import random\nimiona = [\"Ala\", \"Ola\"]\nprint(random.____(imiona))",
                listOf("choice", "shuffle", "sample"),
                "choice",
                "choice wybiera jeden element z sekwencji.",
            ),
            output(
                "import random\nlista = [1, 2, 3]\nwynik = random.shuffle(lista)\nprint(wynik)",
                "None",
                "shuffle miesza listę w miejscu i zwraca None.",
            ),
        ),
        lesson(
            "u19l3", "Losowość w praktyce",
            output(
                "import random\nkostka = random.randint(1, 6)\nif kostka > 6:\n    print(\"błąd\")\nelse:\n    print(\"ok\")",
                "ok",
                "Kostka nigdy nie da więcej niż 6.",
            ),
            output(
                "import random\nx = random.sample([5, 6, 7], 3)\nprint(sorted(x))",
                "[5, 6, 7]",
                "Próbka wielkości całej listy zawiera wszystkie elementy.",
            ),
            choice(
                "Co się stanie po random.sample([1, 2], 5)?",
                listOf(
                    "ValueError – próbka większa niż lista",
                    "Zwróci [1, 2]",
                    "Zwróci 5 elementów z powtórzeniami",
                    "Zwróci None",
                ),
                0,
                "Bez powtórzeń nie da się wybrać 5 elementów z 2.",
            ),
            choice(
                "Co się stanie po random.choice([])?",
                listOf("IndexError", "Zwróci None", "Zwróci []", "Wypisze 0"),
                0,
                "Z pustej listy nie da się nic wybrać – to IndexError.",
            ),
            output(
                "import random\nrzuty = [random.randint(1, 6) for _ in range(5)]\nprint(len(rzuty))",
                "5",
                "Wyrażenie listowe wykonało 5 rzutów.",
            ),
            tiles(
                "Pomieszaj listę talia w miejscu.",
                listOf("random.shuffle(", "talia", ")"),
                listOf("talia =", "random.sample("),
                "shuffle zmienia listę w miejscu – nie przypisujemy wyniku.",
            ),
            choice(
                "Do czego służy random.seed(42)?",
                listOf(
                    "Ustawia ziarno, by losowania dało się powtórzyć",
                    "Losuje liczbę 42",
                    "Losuje 42 liczby",
                    "Wyłącza losowość na zawsze",
                ),
                0,
                "To samo ziarno daje ten sam ciąg „losowych” liczb – przydatne w testach.",
            ),
            output(
                "import random\nm = [random.choice(\"OR\") for _ in range(4)]\nok = set(m) <= {\"O\", \"R\"}\nprint(len(m), ok)",
                "4 True",
                "Każdy rzut to O lub R, więc zbiór wyników zawiera się w {O, R}.",
            ),
        ),
        lesson(
            "u19l4", "Powtórka: losowość",
            output(
                "import random\nx = random.randint(10, 20)\nprint(10 <= x <= 20)",
                "True",
                "randint mieści się w podanym przedziale.",
            ),
            choice(
                "Która funkcja zwróci kilka różnych elementów listy?",
                listOf("random.sample", "random.choice", "random.shuffle", "random.randint"),
                0,
                "sample zwraca listę elementów bez powtórzeń.",
            ),
            fill(
                "Uzupełnij, aby pomieszać listę karty.",
                "import random\nkarty = [1, 2, 3]\nrandom.____(karty)\nprint(len(karty))",
                listOf("shuffle", "shuffled", "mix"),
                "shuffle",
                "Funkcja mieszająca listę to shuffle.",
            ),
            output("from random import choice\nprint(choice(\"x\"))", "x", "choice działa też na napisach – tu jest tylko jedna litera."),
            output(
                "import random as r\nx = r.sample([1, 2, 3, 4], 2)\nprint(len(set(x)))",
                "2",
                "sample nie powtarza elementów, więc oba są różne.",
            ),
            choice(
                "Ile różnych wyników może dać random.randint(0, 3)?",
                listOf("4", "3", "2", "Nieskończenie wiele"),
                0,
                "Możliwe są 0, 1, 2 i 3 – oba końce się liczą.",
            ),
            output(
                "import random\nlitery = list(\"abc\")\nrandom.shuffle(litery)\nprint(\"\".join(sorted(litery)))",
                "abc",
                "Po posortowaniu kolejność mieszania nie ma znaczenia.",
            ),
            tiles(
                "Wylosuj 2 różne elementy z listy gracze.",
                listOf("random.sample(", "gracze,", "2", ")"),
                listOf("random.choice(", "random.randint("),
                "sample(lista, k) losuje k różnych elementów.",
            ),
        ),
    ),
)
