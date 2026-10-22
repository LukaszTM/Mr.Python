package com.mrpython.app.data.course

import com.mrpython.app.domain.CourseUnit

internal val module21 = CourseUnit(
    id = "u21",
    title = "Pliki",
    description = "Zapis i odczyt plików tekstowych",
    lessons = listOf(
        lesson(
            "u21l1", "open, write i read",
            output(
                "f = open(\"notatki.txt\", \"w\")\nf.write(\"Hej\")\nf.close()\nf = open(\"notatki.txt\")\nprint(f.read())\nf.close()",
                "Hej",
                "Najpierw zapisujemy tekst do pliku, potem go odczytujemy.",
            ),
            choice(
                "Co oznacza tryb \"w\" w open()?",
                listOf(
                    "Zapis – plik jest tworzony lub czyszczony",
                    "Odczyt pliku",
                    "Dopisywanie na końcu",
                    "Usunięcie pliku",
                ),
                0,
                "\"w\" (write) otwiera plik do zapisu i kasuje starą zawartość.",
            ),
            choice(
                "Jaki tryb ma open(\"plik.txt\") bez drugiego argumentu?",
                listOf("\"r\" – odczyt", "\"w\" – zapis", "\"a\" – dopisywanie", "Żaden – to błąd"),
                0,
                "Domyślnie plik otwiera się do odczytu.",
            ),
            fill(
                "Uzupełnij tryb, aby zapisać tekst do pliku.",
                "f = open(\"notatki.txt\", \"____\")\nf.write(\"abc\")\nf.close()",
                listOf("w", "r", "read"),
                "w",
                "Do zapisu służy tryb \"w\".",
            ),
            output(
                "f = open(\"dane.txt\", \"w\")\nf.write(\"ab\")\nf.write(\"cd\")\nf.close()\nprint(open(\"dane.txt\").read())",
                "abcd",
                "write nie dodaje nowej linii – teksty sklejają się.",
            ),
            output(
                "f = open(\"liczby.txt\", \"w\")\nf.write(str(5 * 4))\nf.close()\nf = open(\"liczby.txt\")\nprint(int(f.read()) + 1)\nf.close()",
                "21",
                "Z pliku czytamy napis \"20\", który zamieniamy na liczbę.",
            ),
            choice(
                "Co się stanie po f.write(5) dla pliku otwartego w trybie \"w\"?",
                listOf(
                    "TypeError – write przyjmuje tylko napisy",
                    "Zapisze liczbę 5",
                    "Zapisze pięć spacji",
                    "Nic się nie stanie",
                ),
                0,
                "Do pliku tekstowego zapisujemy napisy – liczbę trzeba zamienić przez str().",
            ),
            tiles(
                "Otwórz plik notatki.txt do zapisu.",
                listOf("f =", "open(", "\"notatki.txt\",", "\"w\"", ")"),
                listOf("\"r\"", "read("),
                "open(nazwa, tryb) – tryb \"w\" oznacza zapis.",
            ),
        ),
        lesson(
            "u21l2", "Instrukcja with",
            output(
                "with open(\"a.txt\", \"w\") as f:\n    f.write(\"OK\")\nwith open(\"a.txt\") as f:\n    print(f.read())",
                "OK",
                "with otwiera plik i sam go zamyka po bloku.",
            ),
            choice(
                "Co daje zapis with open(...) as f?",
                listOf(
                    "Plik zostanie zamknięty automatycznie po bloku",
                    "Plik otworzy się szybciej",
                    "Plik będzie tylko do odczytu",
                    "Plik zostanie usunięty po bloku",
                ),
                0,
                "with dba o zamknięcie pliku za nas.",
            ),
            output(
                "with open(\"a.txt\", \"w\") as f:\n    f.write(\"x\")\nprint(f.closed)",
                "True",
                "Po wyjściu z bloku with plik jest już zamknięty.",
            ),
            fill(
                "Uzupełnij, aby nazwać otwarty plik f.",
                "with open(\"a.txt\", \"w\") ____ f:\n    f.write(\"hej\")",
                listOf("as", "in", "is"),
                "as",
                "with open(...) as nazwa:",
            ),
            output(
                "with open(\"a.txt\", \"w\") as f:\n    f.write(\"Ala\\nma kota\")\nwith open(\"a.txt\") as f:\n    print(f.read())",
                "Ala\nma kota",
                "Znak \\n w pliku to przejście do nowej linii.",
            ),
            tiles(
                "Otwórz plik dane.txt do odczytu w bloku with.",
                listOf("with", "open(\"dane.txt\")", "as", "f:"),
                listOf("in", "for"),
                "with open(nazwa) as f: – bez trybu oznacza odczyt.",
            ),
            output(
                "with open(\"a.txt\", \"w\") as f:\n    f.write(\"12345\")\nwith open(\"a.txt\") as f:\n    tekst = f.read()\nprint(len(tekst))",
                "5",
                "read() zwraca całą zawartość jako napis.",
            ),
            choice(
                "Dlaczego warto używać with przy plikach?",
                listOf(
                    "Nie trzeba pamiętać o close(), nawet gdy wystąpi błąd",
                    "Bez with nie da się czytać plików",
                    "with szyfruje plik",
                    "with działa tylko z plikami .txt",
                ),
                0,
                "with zamyka plik zawsze – także po wyjątku.",
            ),
        ),
        lesson(
            "u21l3", "Czytanie linii",
            output(
                "with open(\"a.txt\", \"w\") as f:\n    f.write(\"a\\nb\\nc\\n\")\nwith open(\"a.txt\") as f:\n    print(len(f.readlines()))",
                "3",
                "readlines() zwraca listę linii – tu są trzy.",
            ),
            output(
                "with open(\"a.txt\", \"w\") as f:\n    f.write(\"x\\ny\\n\")\nwith open(\"a.txt\") as f:\n    for linia in f:\n        print(linia.strip())",
                "x\ny",
                "Pętla for po pliku daje kolejne linie.",
            ),
            choice(
                "Dlaczego przy czytaniu linii często używamy strip()?",
                listOf(
                    "Linie kończą się znakiem nowej linii \\n",
                    "Bez strip() nie da się wypisać linii",
                    "strip() zamienia linię na liczbę",
                    "strip() zamyka plik",
                ),
                0,
                "strip() usuwa \\n i spacje z końców linii.",
            ),
            output(
                "with open(\"a.txt\", \"w\") as f:\n    f.write(\"raz\\ndwa\\n\")\nwith open(\"a.txt\") as f:\n    print(f.readline().strip())",
                "raz",
                "readline() czyta tylko jedną, kolejną linię.",
            ),
            fill(
                "Uzupełnij, aby przejść pętlą po liniach pliku.",
                "with open(\"a.txt\", \"w\") as f:\n    f.write(\"hej\\n\")\nwith open(\"a.txt\") as f:\n    for linia ____ f:\n        print(linia.strip())",
                listOf("in", "of", "as"),
                "in",
                "Po pliku iterujemy jak po liście: for linia in f.",
            ),
            output(
                "with open(\"a.txt\", \"w\") as f:\n    f.write(\"3\\n4\\n5\\n\")\nsuma = 0\nwith open(\"a.txt\") as f:\n    for linia in f:\n        suma += int(linia)\nprint(suma)",
                "12",
                "int() radzi sobie ze znakiem nowej linii na końcu.",
            ),
            output(
                "with open(\"a.txt\", \"w\") as f:\n    f.write(\"a\\nb\")\nwith open(\"a.txt\") as f:\n    linie = f.read().split(\"\\n\")\nprint(len(linie))",
                "2",
                "Podział po \\n daje dwie linie.",
            ),
            tiles(
                "Wczytaj wszystkie linie pliku f do listy linie.",
                listOf("linie", "=", "f.readlines()"),
                listOf("f.readline()", "f.write()"),
                "readlines() zwraca listę wszystkich linii.",
            ),
        ),
        lesson(
            "u21l4", "Dopisywanie i brak pliku",
            output(
                "with open(\"log.txt\", \"w\") as f:\n    f.write(\"A\")\nwith open(\"log.txt\", \"a\") as f:\n    f.write(\"B\")\nprint(open(\"log.txt\").read())",
                "AB",
                "Tryb \"a\" dopisuje na końcu pliku.",
            ),
            output(
                "with open(\"log.txt\", \"w\") as f:\n    f.write(\"A\")\nwith open(\"log.txt\", \"w\") as f:\n    f.write(\"B\")\nprint(open(\"log.txt\").read())",
                "B",
                "Drugie otwarcie w trybie \"w\" skasowało poprzednią zawartość.",
            ),
            choice(
                "Czym różni się tryb \"a\" od \"w\"?",
                listOf(
                    "\"a\" dopisuje na końcu, \"w\" czyści plik",
                    "\"a\" czyta plik, \"w\" go zapisuje",
                    "\"a\" usuwa plik",
                    "Niczym",
                ),
                0,
                "\"a\" (append) zachowuje starą zawartość.",
            ),
            fill(
                "Uzupełnij tryb, aby program wypisał 12.",
                "with open(\"log.txt\", \"w\") as f:\n    f.write(\"1\")\nwith open(\"log.txt\", \"____\") as f:\n    f.write(\"2\")\nprint(open(\"log.txt\").read())",
                listOf("a", "w", "r"),
                "a",
                "Tylko tryb \"a\" zachowa wcześniej zapisane 1.",
            ),
            output(
                "with open(\"log.txt\", \"w\") as f:\n    pass\nfor i in range(3):\n    with open(\"log.txt\", \"a\") as f:\n        f.write(str(i))\nprint(open(\"log.txt\").read())",
                "012",
                "Każde otwarcie w trybie \"a\" dopisuje kolejną cyfrę.",
            ),
            tiles(
                "Otwórz plik log.txt do dopisywania.",
                listOf("with", "open(\"log.txt\",", "\"a\")", "as f:"),
                listOf("\"w\")", "\"r\")"),
                "Tryb \"a\" służy do dopisywania.",
            ),
            output(
                "try:\n    open(\"brak.txt\")\nexcept FileNotFoundError:\n    print(\"nie ma pliku\")",
                "nie ma pliku",
                "Odczyt nieistniejącego pliku zgłasza FileNotFoundError.",
            ),
            choice(
                "Co zrobi open(\"nowy.txt\", \"a\"), jeśli plik nie istnieje?",
                listOf("Utworzy pusty plik", "Zgłosi FileNotFoundError", "Zwróci None", "Utworzy folder"),
                0,
                "Tryby \"a\" i \"w\" tworzą brakujący plik – błąd zgłasza tylko odczyt.",
            ),
        ),
        lesson(
            "u21l5", "Powtórka: pliki",
            output(
                "with open(\"p.txt\", \"w\") as f:\n    f.write(\"Ala\\n\")\n    f.write(\"Ola\\n\")\nwith open(\"p.txt\") as f:\n    imiona = [l.strip() for l in f]\nprint(imiona)",
                "['Ala', 'Ola']",
                "Wyrażenie listowe działa też na liniach pliku.",
            ),
            output(
                "def wczytaj(nazwa):\n    try:\n        with open(nazwa) as f:\n            return f.read()\n    except FileNotFoundError:\n        return \"brak\"\n\nprint(wczytaj(\"nieznany.txt\"))",
                "brak",
                "Brak pliku przechwytujemy i zwracamy wartość zastępczą.",
            ),
            choice(
                "Który tryb usuwa dotychczasową zawartość pliku?",
                listOf("\"w\"", "\"a\"", "\"r\"", "Żaden"),
                0,
                "Tryb \"w\" zaczyna plik od nowa.",
            ),
            fill(
                "Uzupełnij nazwę błędu.",
                "try:\n    open(\"brak.txt\")\nexcept ____:\n    print(\"brak pliku\")",
                listOf("FileNotFoundError", "KeyError", "FileError"),
                "FileNotFoundError",
                "Brak pliku to FileNotFoundError.",
            ),
            output(
                "with open(\"p.txt\", \"w\") as f:\n    f.write(\"a\")\nwith open(\"p.txt\", \"a\") as f:\n    f.write(\"a\")\nwith open(\"p.txt\") as f:\n    print(f.read() * 2)",
                "aaaa",
                "W pliku jest \"aa\", a napis razy 2 to \"aaaa\".",
            ),
            tiles(
                "Przejdź pętlą po liniach pliku f.",
                listOf("for", "linia", "in", "f:"),
                listOf("f.read():", "while"),
                "Pętla for po pliku zwraca kolejne linie.",
            ),
            output(
                "with open(\"p.txt\", \"w\") as f:\n    f.write(\"1 2 3\")\nwith open(\"p.txt\") as f:\n    liczby = f.read().split()\nprint(sum(map(int, liczby)))",
                "6",
                "split() dzieli tekst na napisy, a map(int, …) zamienia je na liczby.",
            ),
            choice(
                "Co zwróci f.read() dla pustego pliku?",
                listOf("Pusty napis \"\"", "None", "FileNotFoundError", "0"),
                0,
                "Pusty plik to pusty napis.",
            ),
        ),
    ),
)
