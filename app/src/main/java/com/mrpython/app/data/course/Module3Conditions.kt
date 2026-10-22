package com.mrpython.app.data.course

import com.mrpython.app.domain.CourseUnit

internal val module3 = CourseUnit(
    id = "u3",
    title = "Operatory i warunki",
    description = "Licz, porównuj i podejmuj decyzje",
    lessons = listOf(
        lesson(
            "u3l1", "Matematyka",
            output("print(7 // 2)", "3", "// to dzielenie całkowite – odcina część ułamkową."),
            output("print(7 % 2)", "1", "% zwraca resztę z dzielenia."),
            output("print(2 ** 3)", "8", "** to potęgowanie: 2 · 2 · 2."),
            choice(
                "Co wypisze ten kod?",
                listOf("2", "2.5", "2.0", "3"),
                1,
                "Zwykłe dzielenie / zawsze daje float.",
                code = "print(10 / 4)",
            ),
            fill(
                "Oblicz resztę z dzielenia 10 przez 3.",
                "print(10 ____ 3)",
                listOf("%", "//", "/"),
                "%",
                "Reszta z dzielenia to operator %.",
            ),
            output("print(2 + 3 * 4)", "14", "Mnożenie ma pierwszeństwo przed dodawaniem."),
            output("print((2 + 3) * 4)", "20", "Nawiasy zmieniają kolejność działań."),
            output("print(-7 // 2)", "-4", "// zaokrągla w dół, czyli -3.5 daje -4."),
        ),
        lesson(
            "u3l2", "Prawda i fałsz",
            output("print(3 > 2)", "True", "Porównanie zwraca wartość logiczną True lub False."),
            choice(
                "Który operator sprawdza, czy dwie wartości są równe?",
                listOf("==", "=", "===", "equals"),
                0,
                "== porównuje, a pojedyncze = przypisuje.",
            ),
            output(
                "print(5 == 5 and 3 > 4)",
                "False",
                "and wymaga, by oba warunki były prawdziwe – a 3 > 4 jest fałszem.",
            ),
            output("print(not False)", "True", "not odwraca wartość logiczną."),
            tiles(
                "Zapisz warunek: x jest różne od 0",
                listOf("x", "!=", "0"),
                listOf("=", "<>"),
                "Operator „różne od” to !=.",
            ),
            output("print(10 != 10)", "False", "10 jest równe 10, więc „różne” to fałsz."),
            output("print(3 < 5 or 2 > 9)", "True", "Przy or wystarczy, że jeden warunek jest prawdziwy."),
            output("x = 4\nprint(1 < x < 5)", "True", "Python pozwala łączyć porównania: 1 < x oraz x < 5."),
        ),
        lesson(
            "u3l3", "Instrukcja if",
            output(
                "x = 10\nif x > 5:\n    print(\"duże\")\nelse:\n    print(\"małe\")",
                "duże",
                "Warunek x > 5 jest prawdziwy, więc wykona się pierwszy blok.",
            ),
            fill(
                "Uzupełnij brakujący znak.",
                "x = 1\nif x > 0____\n    print(\"dodatnia\")",
                listOf(":", ";", "{"),
                ":",
                "Linia z if kończy się dwukropkiem.",
            ),
            choice(
                "Ile spacji zwykle stosuje się do wcięcia bloku w Pythonie?",
                listOf("2", "4", "8", "Wcięcia nie mają znaczenia"),
                1,
                "Standard PEP 8 zaleca 4 spacje. Wcięcia w Pythonie są obowiązkowe!",
            ),
            output(
                "t = 15\nif t > 25:\n    print(\"gorąco\")\nelif t > 10:\n    print(\"ciepło\")\nelse:\n    print(\"zimno\")",
                "ciepło",
                "Pierwszy warunek jest fałszywy, drugi (15 > 10) – prawdziwy.",
            ),
            choice(
                "Które słowo kluczowe znaczy „w przeciwnym razie, jeśli”?",
                listOf("else if", "elif", "elseif", "otherwise"),
                1,
                "W Pythonie piszemy elif.",
            ),
            output(
                "x = 0\nif x:\n    print(\"tak\")\nelse:\n    print(\"nie\")",
                "nie",
                "W warunku 0 działa jak False.",
            ),
            output(
                "wiek = 18\nif wiek >= 18:\n    print(\"dorosły\")\nprint(\"koniec\")",
                "dorosły\nkoniec",
                "Ostatnia linia nie jest wcięta, więc wykona się zawsze.",
            ),
        ),
        lesson(
            "u3l4", "Złożone warunki",
            output("x = 7\nif x > 5 and x < 10:\n    print(\"środek\")", "środek", "Oba warunki są prawdziwe."),
            output(
                "dzien = \"sobota\"\nif dzien == \"sobota\" or dzien == \"niedziela\":\n    print(\"weekend\")\nelse:\n    print(\"praca\")",
                "weekend",
                "Wystarczy, że jeden warunek z or jest spełniony.",
            ),
            output(
                "x = 5\nif x > 0:\n    if x % 2 == 0:\n        print(\"parzysta\")\n    else:\n        print(\"nieparzysta\")",
                "nieparzysta",
                "Wewnętrzny if sprawdza się tylko wtedy, gdy zewnętrzny warunek jest prawdziwy.",
            ),
            choice(
                "Co wypisze ten kod?",
                listOf("B", "A", "C", "B i C"),
                0,
                "Wykonuje się tylko pierwszy spełniony warunek.",
                code = "punkty = 75\nif punkty >= 90:\n    print(\"A\")\nelif punkty >= 70:\n    print(\"B\")\nelif punkty >= 50:\n    print(\"C\")",
            ),
            fill(
                "Uzupełnij, aby wypisać „ujemna” dla liczb mniejszych od zera.",
                "x = -3\nif x ____ 0:\n    print(\"ujemna\")",
                listOf("<", ">", "="),
                "<",
                "x < 0 oznacza liczbę ujemną.",
            ),
            tiles(
                "Zapisz warunek: wiek co najmniej 13 i mniej niż 18",
                listOf("wiek", ">=", "13", "and", "wiek", "<", "18"),
                listOf("or", "=>"),
                "and łączy dwa warunki, które muszą być spełnione jednocześnie.",
            ),
            output("print(not (3 > 2))", "False", "3 > 2 to True, a not odwraca to na False."),
            output(
                "haslo = \"abc\"\nif len(haslo) < 8:\n    print(\"za krótkie\")",
                "za krótkie",
                "len() podaje długość napisu: 3 < 8.",
            ),
        ),
        lesson(
            "u3l5", "Powtórka: warunki",
            output("print(17 % 5)", "2", "17 = 3 · 5 + 2."),
            output("print(10 // 3 + 10 % 3)", "4", "10 // 3 = 3, a 10 % 3 = 1."),
            choice(
                "Jak sprawdzić, czy liczba x jest parzysta?",
                listOf("x % 2 == 0", "x / 2 == 0", "x // 2 == 1", "x % 2 == 1"),
                0,
                "Liczba parzysta dzieli się przez 2 bez reszty.",
            ),
            output("a = 3\nb = 8\nif a > b:\n    print(a)\nelse:\n    print(b)", "8", "Ten kod wypisuje większą z dwóch liczb."),
            output("print(True and not False)", "True", "not False to True, a True and True daje True."),
            output(
                "x = 12\nif x % 3 == 0 and x % 4 == 0:\n    print(\"dzieli się przez 12\")\nelse:\n    print(\"nie\")",
                "dzieli się przez 12",
                "12 dzieli się i przez 3, i przez 4.",
            ),
            fill(
                "Uzupełnij brakujące słowo kluczowe.",
                "t = 5\nif t > 20:\n    print(\"ciepło\")\n____:\n    print(\"zimno\")",
                listOf("else", "elif", "otherwise"),
                "else",
                "else nie ma warunku i kończy się dwukropkiem.",
            ),
            output(
                "x = 15\nif x > 10:\n    print(\"A\")\nif x > 5:\n    print(\"B\")",
                "A\nB",
                "To dwa osobne if-y, więc sprawdzane są oba.",
            ),
        ),
    ),
)
