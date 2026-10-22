package com.mrpython.app.data.course

internal val module47Cards = listOf(
    cards(
        "u47l1",
        explain(
            "Tekst na wiersze: splitlines",
            "`splitlines()` dzieli cały tekst na listę wierszy – tnie w miejscach znaku nowej linii `\\n`. " +
                "Wiersz wczytany z pliku często kończy się `\\n`, który zostaje w ostatnim polu; " +
                "usuwa go `strip()`.",
            code = "tekst = \"a,1\\nb,2\"\nprint(tekst.splitlines())\nprint(\"x,y\\n\".strip().split(\",\"))",
            output = "['a,1', 'b,2']\n['x', 'y']",
        ),
        explain(
            "Puste pola i join",
            "Dwa przecinki obok siebie oznaczają puste pole – `split` zwraca wtedy pusty napis `''`. " +
                "W drugą stronę `\",\".join(lista)` skleja pola z powrotem w jeden wiersz CSV.",
            code = "print(\"a,,c\".split(\",\"))\nprint(\",\".join([\"Ola\", \"25\"]))",
            output = "['a', '', 'c']\nOla,25",
        ),
    ),
    cards(
        "u47l2",
        explain(
            "Wiersz po wierszu: next",
            "`csv.reader` oddaje wiersze po kolei, jak iterator. `next(r)` pobiera następny wiersz " +
                "(np. nagłówek, który chcemy pominąć), a `list(r)` zbiera wszystkie pozostałe.",
            code = "import csv, io\nr = csv.reader(io.StringIO(\"a,b\\n1,2\\n3,4\"))\nnext(r)\nprint(list(r))",
            output = "[['1', '2'], ['3', '4']]",
        ),
        explain(
            "writerows i getvalue",
            "`writerow(lista)` zapisuje jeden wiersz, a `writerows(lista_list)` – wiele naraz. " +
                "Każdy wiersz kończy się znakiem nowej linii. `getvalue()` zwraca cały tekst " +
                "zapisany do `io.StringIO`.",
            code = "import csv, io\nf = io.StringIO()\ncsv.writer(f).writerows([[1, 2], [3, 4]])\nprint(f.getvalue().splitlines())",
            output = "['1,2', '3,4']",
        ),
    ),
    cards(
        "u47l3",
        explain(
            "Nazwy kolumn: fieldnames",
            "Atrybut `fieldnames` obiektu `DictReader` to lista nazw kolumn wziętych z nagłówka. " +
                "Przydaje się, gdy chcesz sprawdzić, jakie kolumny ma plik.",
            code = "import csv, io\nr = csv.DictReader(io.StringIO(\"imie,wiek\\nOla,25\"))\nprint(r.fieldnames)",
            output = "['imie', 'wiek']",
        ),
    ),
)
