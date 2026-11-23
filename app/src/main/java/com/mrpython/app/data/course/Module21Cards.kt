package com.mrpython.app.data.course

internal val module21Cards = listOf(
    cards(
        "u21l1",
        explain(
            "Tryb \"r\" i kolejne write()",
            "Bez trybu `open()` używa trybu `\"r\"` (read – odczyt). Kilka wywołań `write()` zapisuje " +
                "teksty jeden za drugim – `write()` sam nie dodaje ani spacji, ani nowej linii.",
            code = "f = open(\"a.txt\", \"w\")\nf.write(\"ab\")\nf.write(\"cd\")\nf.close()\nprint(open(\"a.txt\", \"r\").read())",
            output = "abcd",
        ),
        explain(
            "Liczby w pliku",
            "W pliku tekstowym są tylko napisy. Liczbę zapisujesz przez `str()`, a po odczycie " +
                "zamieniasz z powrotem przez `int()` albo `float()` – inaczej `\"7\" * 3` da \"777\".",
            code = "f = open(\"a.txt\", \"w\")\nf.write(str(20))\nf.close()\nx = open(\"a.txt\").read()\nprint(int(x) + 1, x * 2)",
            output = "21 2020",
        ),
        explain(
            "Zamknięty plik",
            "`close()` kończy pracę z plikiem i zapisuje zmiany na dysku. Po zamknięciu nie można już " +
                "pisać ani czytać – próba `write()` zgłasza `ValueError`.",
            code = "f = open(\"a.txt\", \"w\")\nf.close()\ntry:\n    f.write(\"x\")\nexcept ValueError:\n    print(\"plik zamknięty\")",
            output = "plik zamknięty",
        ),
    ),
    cards(
        "u21l2",
        explain(
            "Czy plik jest zamknięty?",
            "Atrybut `f.closed` mówi, czy plik jest już zamknięty. Wewnątrz bloku `with` to `False`, " +
                "a zaraz po nim – `True`. Dlatego pisanie do `f` po bloku kończy się błędem.",
            code = "with open(\"a.txt\", \"w\") as f:\n    print(f.closed)\nprint(f.closed)",
            output = "False\nTrue",
        ),
        explain(
            "Drugi read() jest pusty",
            "Plik pamięta, dokąd już przeczytałeś. Pierwszy `read()` zabiera całą treść, więc kolejny " +
                "zwraca pusty napis \"\". Pusty plik też daje \"\".",
            code = "with open(\"a.txt\", \"w\") as f:\n    f.write(\"abc\")\nwith open(\"a.txt\") as f:\n    a = f.read()\n    b = f.read()\nprint(len(a), len(b))",
            output = "3 0",
        ),
    ),
    cards(
        "u21l3",
        explain(
            "readline i readlines",
            "`readline()` czyta jedną, kolejną linię (razem ze znakiem `\\n`), a gdy linii brak – zwraca \"\". " +
                "`readlines()` zwraca listę wszystkich linii.",
            code = "with open(\"a.txt\", \"w\") as f:\n    f.write(\"raz\\ndwa\\n\")\nwith open(\"a.txt\") as f:\n    print(f.readline().strip())\n    print(f.readlines())",
            output = "raz\n['dwa\\n']",
        ),
        explain(
            "Liczby z linii",
            "Linia z pliku to napis zakończony `\\n` – dlatego `len(\"hej\\n\")` to 4. Funkcje `int()` " +
                "i `float()` same pomijają `\\n` i spacje na brzegach, więc `int(\"5\\n\")` to 5.",
            code = "with open(\"a.txt\", \"w\") as f:\n    f.write(\"5\\n\")\nwith open(\"a.txt\") as f:\n    linia = f.readline()\nprint(len(linia), int(linia) * 2)",
            output = "2 10",
        ),
    ),
    cards(
        "u21l4",
        explain(
            "Tryby tworzą plik",
            "Tryby `\"w\"` i `\"a\"` tworzą plik, gdy go nie ma – błąd `FileNotFoundError` zgłasza tylko " +
                "odczyt. Pusty plik zrobisz blokiem `with` z samym `pass` w środku.",
            code = "with open(\"nowy.txt\", \"w\") as f:\n    pass\nwith open(\"nowy.txt\") as f:\n    print(len(f.read()))",
            output = "0",
        ),
    ),
)
