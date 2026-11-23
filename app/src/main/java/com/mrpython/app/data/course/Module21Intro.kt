package com.mrpython.app.data.course

internal val module21Intro = lesson(
    "u21l0", "Wprowadzenie: pliki",
    explain(
        "Po co pliki?",
        "Zmienne znikają, gdy program się kończy. Plik zostaje na dysku – możesz w nim zapisać notatki " +
            "albo wyniki i wczytać je później. Plik otwierasz funkcją `open(nazwa, tryb)`, " +
            "a po pracy zamykasz przez `close()`.",
    ),
    explain(
        "Zapis i odczyt",
        "Tryb `\"w\"` służy do zapisu: tworzy plik lub czyści starą zawartość. Bez trybu plik otwiera się " +
            "do odczytu, a `read()` zwraca całą treść jako napis. `write()` przyjmuje tylko napisy.",
        code = "f = open(\"notatki.txt\", \"w\")\nf.write(\"Hej\")\nf.close()\nf = open(\"notatki.txt\")\nprint(f.read())\nf.close()",
        output = "Hej",
    ),
    explain(
        "Instrukcja with",
        "`with open(...) as f:` sam zamyka plik po wyjściu z bloku – nawet gdy wystąpi błąd. " +
            "Dzięki temu nie trzeba pamiętać o `close()`.",
        code = "with open(\"a.txt\", \"w\") as f:\n    f.write(\"OK\")\nwith open(\"a.txt\") as f:\n    print(f.read())",
        output = "OK",
    ),
    explain(
        "Czytanie linii",
        "Po pliku można iść pętlą `for` – linia po linii. Każda linia kończy się znakiem `\\n`, " +
            "dlatego zwykle obcinamy go przez `strip()`.",
        code = "with open(\"a.txt\", \"w\") as f:\n    f.write(\"x\\ny\\n\")\nwith open(\"a.txt\") as f:\n    for linia in f:\n        print(linia.strip())",
        output = "x\ny",
    ),
    explain(
        "Dopisywanie i brak pliku",
        "Tryb `\"a\"` dopisuje na końcu pliku, zamiast go czyścić. Otwarcie do odczytu pliku, którego " +
            "nie ma, zgłasza `FileNotFoundError` – można go złapać w `try`.",
        code = "try:\n    open(\"brak.txt\")\nexcept FileNotFoundError:\n    print(\"nie ma pliku\")",
        output = "nie ma pliku",
    ),
    choice(
        "Czym różni się tryb \"a\" od \"w\"?",
        listOf("\"a\" dopisuje na końcu, \"w\" czyści plik", "\"a\" czyta plik, \"w\" go zapisuje", "\"a\" usuwa plik", "Niczym"),
        0,
        "\"a\" (append) zachowuje starą zawartość.",
    ),
    output(
        "with open(\"log.txt\", \"w\") as f:\n    f.write(\"A\")\nwith open(\"log.txt\", \"a\") as f:\n    f.write(\"B\")\nprint(open(\"log.txt\").read())",
        "AB",
        "Tryb \"a\" dopisał B za A.",
    ),
    fill(
        "Uzupełnij, aby otworzyć plik w bloku with.",
        "with open(\"a.txt\", \"w\") ____ f:\n    f.write(\"hej\")",
        listOf("as", "in", "is"),
        "as",
        "Składnia to with open(...) as nazwa:.",
    ),
)
