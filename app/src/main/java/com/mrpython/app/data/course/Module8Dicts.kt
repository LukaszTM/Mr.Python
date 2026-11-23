package com.mrpython.app.data.course

import com.mrpython.app.domain.CourseUnit

internal val module8 = CourseUnit(
    id = "u8",
    title = "Słowniki",
    description = "Pary klucz–wartość",
    lessons = listOf(
        lesson(
            "u8l1", "Tworzenie słowników",
            choice(
                "Jak utworzyć słownik z imieniem i wiekiem?",
                listOf(
                    "{\"imie\": \"Ala\", \"wiek\": 10}",
                    "[\"imie\": \"Ala\", \"wiek\": 10]",
                    "(\"imie\" = \"Ala\", \"wiek\" = 10)",
                    "{\"imie\", \"Ala\", \"wiek\", 10}",
                ),
                0,
                "Słownik to pary klucz: wartość w nawiasach klamrowych.",
            ),
            output("osoba = {\"imie\": \"Ala\", \"wiek\": 10}\nprint(osoba[\"imie\"])", "Ala", "Wartość odczytujemy po kluczu w nawiasach kwadratowych."),
            output("ceny = {\"chleb\": 5, \"mleko\": 4}\nprint(ceny[\"chleb\"] + ceny[\"mleko\"])", "9", "5 + 4 = 9."),
            output("d = {\"a\": 1}\nd[\"b\"] = 2\nprint(d)", "{'a': 1, 'b': 2}", "Nowy klucz dodajemy zwykłym przypisaniem."),
            output("d = {\"a\": 1}\nd[\"a\"] = 5\nprint(d)", "{'a': 5}", "Przypisanie do istniejącego klucza nadpisuje wartość."),
            output("print(len({\"x\": 1, \"y\": 2, \"z\": 3}))", "3", "len() zwraca liczbę par w słowniku."),
            choice(
                "Co się stanie?",
                listOf("Błąd KeyError – nie ma klucza b", "Wypisze None", "Wypisze 0", "Wypisze b"),
                0,
                "Odczyt nieistniejącego klucza przez [] powoduje KeyError.",
                code = "d = {\"a\": 1}\nprint(d[\"b\"])",
            ),
            tiles(
                "Dodaj do słownika oceny klucz \"Ola\" z wartością 5",
                listOf("oceny[", "\"Ola\"", "]", "=", "5"),
                listOf("(", ")"),
                "słownik[klucz] = wartość",
            ),
        ),
        lesson(
            "u8l2", "Metody słowników",
            output("d = {\"a\": 1}\nprint(d.get(\"b\", 0))", "0", "get() zwraca wartość domyślną, gdy klucza nie ma."),
            output("d = {\"a\": 1, \"b\": 2}\nprint(\"a\" in d)", "True", "in sprawdza, czy klucz jest w słowniku."),
            output("d = {\"a\": 1, \"b\": 2}\nprint(list(d.keys()))", "['a', 'b']", "keys() zwraca klucze."),
            output("d = {\"a\": 1, \"b\": 2}\nprint(list(d.values()))", "[1, 2]", "values() zwraca wartości."),
            output("d = {\"a\": 1, \"b\": 2}\ndel d[\"a\"]\nprint(d)", "{'b': 2}", "del usuwa parę o podanym kluczu."),
            output("d = {\"x\": 10}\nwartosc = d.pop(\"x\")\nprint(wartosc, d)", "10 {}", "pop() usuwa klucz i zwraca jego wartość."),
            fill(
                "Uzupełnij, aby odczytać wartość bez ryzyka błędu.",
                "d = {\"a\": 1}\nprint(d.____(\"z\"))",
                listOf("get", "pop", "keys"),
                "get",
                "get() zwraca None, gdy klucza nie ma, zamiast zgłaszać błąd.",
            ),
        ),
        lesson(
            "u8l3", "Słowniki i pętle",
            output("d = {\"a\": 1, \"b\": 2}\nfor k in d:\n    print(k)", "a\nb", "Pętla po słowniku przechodzi po kluczach."),
            output(
                "d = {\"Ala\": 5, \"Ola\": 4}\nfor imie, ocena in d.items():\n    print(imie, ocena)",
                "Ala 5\nOla 4",
                "items() daje pary (klucz, wartość).",
            ),
            output(
                "licznik = {}\nfor z in \"abca\":\n    licznik[z] = licznik.get(z, 0) + 1\nprint(licznik)",
                "{'a': 2, 'b': 1, 'c': 1}",
                "Tak najczęściej liczy się wystąpienia elementów.",
            ),
            output(
                "ceny = {\"a\": 3, \"b\": 7}\nsuma = 0\nfor c in ceny.values():\n    suma += c\nprint(suma)",
                "10",
                "Sumujemy wszystkie wartości słownika.",
            ),
            output(
                "oceny = {\"Ala\": 5, \"Ola\": 3}\nfor imie in oceny:\n    if oceny[imie] >= 4:\n        print(imie)",
                "Ala",
                "Wypisujemy tylko osoby z oceną co najmniej 4.",
            ),
            tiles(
                "Ułóż nagłówek pętli po parach klucz–wartość słownika d",
                listOf("for", "k,", "v", "in", "d.items()", ":"),
                listOf("d.keys()", "d"),
                "items() zwraca pary, które rozpakowujemy do k i v.",
            ),
            choice(
                "Co zwraca d.items()?",
                listOf("Pary (klucz, wartość)", "Same klucze", "Same wartości", "Liczbę elementów"),
                0,
                "items() zwraca pary klucz–wartość.",
            ),
        ),
        lesson(
            "u8l4", "Powtórka: słowniki",
            output("d = {1: \"jeden\", 2: \"dwa\"}\nprint(d[2])", "dwa", "Kluczem może być też liczba."),
            output("d = {\"a\": [1, 2]}\nd[\"a\"].append(3)\nprint(d[\"a\"])", "[1, 2, 3]", "Wartością w słowniku może być lista."),
            output(
                "kraje = {\"PL\": \"Warszawa\", \"DE\": \"Berlin\"}\nprint(kraje.get(\"FR\", \"brak\"))",
                "brak",
                "Klucza FR nie ma, więc get() zwraca wartość domyślną.",
            ),
            choice(
                "Które zdanie jest prawdziwe?",
                listOf(
                    "Klucze w słowniku są unikalne",
                    "Klucze mogą się powtarzać",
                    "Słownik ma stałą długość",
                    "Wartości muszą być napisami",
                ),
                0,
                "Każdy klucz występuje tylko raz – ponowne przypisanie nadpisuje wartość.",
            ),
            output("d = {\"a\": 1, \"a\": 2}\nprint(d)", "{'a': 2}", "Przy powtórzonym kluczu zostaje ostatnia wartość."),
            output(
                "d = {}\nd[\"x\"] = d.get(\"x\", 0) + 1\nd[\"x\"] = d.get(\"x\", 0) + 1\nprint(d[\"x\"])",
                "2",
                "Za każdym razem wartość rośnie o 1.",
            ),
            fill(
                "Uzupełnij, aby przejść po wartościach słownika.",
                "d = {\"a\": 1, \"b\": 2}\nfor v in d.____():\n    print(v)",
                listOf("values", "keys", "items"),
                "values",
                "values() zwraca same wartości.",
            ),
            output(
                "osoba = {\"imie\": \"Ewa\", \"wiek\": 30}\nprint(f\"{osoba['imie']} ma {osoba['wiek']} lat\")",
                "Ewa ma 30 lat",
                "W f-stringu klucz zapisujemy w innym rodzaju cudzysłowu niż cały napis.",
            ),
        ),
    ),
)
