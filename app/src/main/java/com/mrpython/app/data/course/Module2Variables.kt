package com.mrpython.app.data.course

import com.mrpython.app.domain.CourseUnit

internal val module2 = CourseUnit(
    id = "u2",
    title = "Zmienne i typy",
    description = "Przechowuj dane i poznaj ich typy",
    lessons = listOf(
        lesson(
            "u2l1", "Zmienne",
            choice(
                "Jak zapisać liczbę 5 w zmiennej x?",
                listOf("x = 5", "x == 5", "5 = x", "let x = 5"),
                0,
                "Pojedynczy znak = przypisuje wartość do zmiennej.",
            ),
            output(
                "x = 3\nx = x + 2\nprint(x)",
                "5",
                "Najpierw x to 3, potem nadpisujemy go wartością 3 + 2.",
            ),
            tiles(
                "Utwórz zmienną imie z wartością \"Ola\"",
                listOf("imie", "=", "\"Ola\""),
                listOf("==", "Ola"),
                "Nazwa zmiennej, znak = i wartość – w tej kolejności.",
            ),
            choice(
                "Która nazwa zmiennej jest niepoprawna?",
                listOf("moja_zmienna", "wiek2", "2wiek", "_ukryta"),
                2,
                "Nazwa zmiennej nie może zaczynać się od cyfry.",
            ),
            output(
                "a = \"kot\"\nb = a\nprint(b)",
                "kot",
                "b dostaje tę samą wartość co a.",
            ),
            output(
                "a = 5\nb = a\na = 10\nprint(b)",
                "5",
                "b dostało wartość 5; późniejsza zmiana a jej nie dotyczy.",
            ),
            output(
                "x = 2\nx += 3\nx *= 2\nprint(x)",
                "10",
                "x += 3 to skrót od x = x + 3, a x *= 2 od x = x * 2.",
            ),
            choice(
                "Ile różnych zmiennych tworzy ten kod?",
                listOf("3", "1", "2", "Błąd"),
                0,
                "Python rozróżnia wielkość liter: imie, Imie i IMIE to trzy różne nazwy.",
                code = "imie = \"Ola\"\nImie = \"Ala\"\nIMIE = \"Ela\"",
            ),
        ),
        lesson(
            "u2l2", "Typy danych",
            choice(
                "Jaki typ ma wartość 3.14?",
                listOf("int", "float", "str", "bool"),
                1,
                "Liczby z kropką dziesiętną to float (liczby zmiennoprzecinkowe).",
            ),
            output(
                "print(type(7))",
                "<class 'int'>",
                "7 to liczba całkowita, czyli int.",
            ),
            output(
                "print(int(\"4\") + 1)",
                "5",
                "int() zamienia napis \"4\" na liczbę 4.",
            ),
            choice(
                "Co wypisze ten kod?",
                listOf("5", "41", "Błąd", "4 1"),
                1,
                "\"4\" i \"1\" to napisy, więc + je skleja.",
                code = "print(\"4\" + \"1\")",
            ),
            fill(
                "Zamień napis na liczbę całkowitą.",
                "wiek = ____(\"18\")",
                listOf("int", "str", "text"),
                "int",
                "int() tworzy liczbę całkowitą.",
            ),
            output(
                "print(str(10) + \"0\")",
                "100",
                "str(10) to napis \"10\", a doklejenie \"0\" daje \"100\".",
            ),
            output("print(type(\"7\"))", "<class 'str'>", "Wszystko w cudzysłowie jest napisem."),
            output("print(int(3.9))", "3", "int() odcina część ułamkową – nie zaokrągla."),
        ),
        lesson(
            "u2l3", "f-stringi i input()",
            choice(
                "Co zwraca funkcja input()?",
                listOf("Zawsze napis (str)", "Zawsze liczbę", "True lub False", "Nic"),
                0,
                "input() zwraca to, co wpisał użytkownik, jako napis.",
            ),
            output(
                "imie = \"Ewa\"\nprint(f\"Cześć, {imie}!\")",
                "Cześć, Ewa!",
                "W f-stringu {imie} zostaje zastąpione wartością zmiennej.",
            ),
            fill(
                "Uzupełnij, aby wyrażenie w klamrach zostało obliczone.",
                "print(____\"Wynik: {2 + 2}\")",
                listOf("f", "$", "#"),
                "f",
                "Litera f przed cudzysłowem tworzy f-string.",
            ),
            output(
                "x = 7\nprint(f\"{x} * 2 = {x * 2}\")",
                "7 * 2 = 14",
                "W klamrach można umieścić dowolne wyrażenie.",
            ),
            tiles(
                "Wczytaj imię od użytkownika do zmiennej imie",
                listOf("imie", "=", "input(", "\"Imię: \"", ")"),
                listOf("print("),
                "input() pokazuje podpowiedź i zwraca wpisany tekst.",
            ),
            output(
                "cena = 4.5\nprint(f\"Do zapłaty: {cena * 2} zł\")",
                "Do zapłaty: 9.0 zł",
                "4.5 * 2 to float, więc wynik to 9.0.",
            ),
            choice(
                "Użytkownik wpisuje 5. Co się stanie?",
                listOf("Błąd – nie można dodać str i int", "Wypisze 6", "Wypisze 51", "Wypisze 5 1"),
                0,
                "input() zwraca napis \"5\". Trzeba go zamienić: int(x) + 1.",
                code = "x = input(\"Liczba: \")\nprint(x + 1)",
            ),
        ),
        lesson(
            "u2l4", "Prawda, fałsz i None",
            choice(
                "Jakiego typu jest wartość True?",
                listOf("bool", "str", "int", "None"),
                0,
                "True i False to wartości logiczne – typ bool.",
            ),
            output("print(type(False))", "<class 'bool'>", "False to wartość typu bool."),
            output("print(bool(0))\nprint(bool(7))", "False\nTrue", "0 jest „fałszywe”, każda inna liczba – „prawdziwa”."),
            output("print(bool(\"\"))\nprint(bool(\"a\"))", "False\nTrue", "Pusty napis jest fałszywy, niepusty – prawdziwy."),
            choice(
                "Co oznacza None?",
                listOf("Brak wartości", "Zero", "Pusty napis", "Fałsz"),
                0,
                "None to specjalna wartość oznaczająca „nic”.",
            ),
            output("x = None\nprint(x)", "None", "print wypisuje None jako słowo None."),
            output("print(round(3.14159, 2))", "3.14", "round(liczba, 2) zaokrągla do 2 miejsc po przecinku."),
            output("print(round(2.7))", "3", "round() bez drugiego argumentu zaokrągla do liczby całkowitej."),
        ),
        lesson(
            "u2l5", "Powtórka: zmienne i typy",
            output("a = \"3\"\nb = 3\nprint(a * b)", "333", "Napis razy liczba to powtórzenie napisu."),
            output("x = 10\ny = 3\nx, y = y, x\nprint(x, y)", "3 10", "x, y = y, x zamienia wartości miejscami."),
            choice(
                "Jaki typ ma wynik 7 / 7?",
                listOf("float", "int", "str", "bool"),
                0,
                "Operator / zawsze zwraca float – tutaj 1.0.",
            ),
            output("print(int(\"12\") + int(\"8\"))", "20", "Po zamianie na int napisy dodają się jak liczby."),
            fill(
                "Uzupełnij, aby dokleić liczbę do napisu.",
                "wiek = 20\nprint(\"Mam \" + ____(wiek) + \" lat\")",
                listOf("str", "int", "float"),
                "str",
                "Liczbę trzeba zamienić na napis, żeby ją dokleić.",
            ),
            output(
                "imie = \"Kuba\"\nwiek = 9\nprint(f\"{imie} ma {wiek + 1} lat\")",
                "Kuba ma 10 lat",
                "W klamrach f-stringa można liczyć.",
            ),
            tiles(
                "Zwiększ wartość zmiennej punkty o 10",
                listOf("punkty", "+=", "10"),
                listOf("-=", "++"),
                "+= dodaje wartość do zmiennej.",
            ),
            output("x = 5\nx = x * 2 - 1\nprint(x)", "9", "5 * 2 - 1 = 9."),
        ),
    ),
)
