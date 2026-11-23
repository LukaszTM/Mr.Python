package com.mrpython.app.data.course

internal val module47Intro = lesson(
    "u47l0", "Wprowadzenie: CSV i dane tabelaryczne",
    explain(
        "Czym jest CSV?",
        "CSV to prosty format tabeli: każdy wiersz to jedna linia tekstu, a kolumny oddziela " +
            "przecinek (czasem średnik). Tak eksportują dane arkusze kalkulacyjne. Wiersz " +
            "podzielisz metodą `split(\",\")` – pola są napisami.",
        code = "linia = \"Ola,25,Kraków\"\npola = linia.split(\",\")\nprint(pola[2])\nprint(int(pola[1]) + 1)",
        output = "Kraków\n26",
    ),
    explain(
        "Pułapka split",
        "Pole w cudzysłowie może zawierać przecinek, np. \"Kowalski, Jan\". `split` tnie w każdym " +
            "przecinku, a moduł `csv` rozumie cudzysłowy. `io.StringIO` udaje plik trzymany " +
            "w pamięci – przyda się w przykładach.",
        code = "import csv, io\nw = '\"Kowalski, Jan\",30'\nprint(len(w.split(\",\")))\nprint(next(csv.reader(io.StringIO(w))))",
        output = "3\n['Kowalski, Jan', '30']",
    ),
    explain(
        "csv.reader i csv.writer",
        "`csv.reader(plik)` zwraca każdy wiersz jako listę napisów, a `delimiter=\";\"` zmienia " +
            "separator. `csv.writer(plik).writerow(lista)` zapisuje jeden wiersz i sam dodaje " +
            "cudzysłowy, gdy trzeba.",
        code = "import csv, io\nf = io.StringIO()\ncsv.writer(f).writerow([\"x,y\", 2])\nprint(f.getvalue().strip())",
        output = "\"x,y\",2",
    ),
    explain(
        "DictReader",
        "`csv.DictReader` bierze pierwszy wiersz jako nagłówek i zwraca kolejne wiersze jako " +
            "słowniki: nazwa kolumny → wartość. Dzięki temu piszesz `r[\"imie\"]` zamiast `r[0]`.",
        code = "import csv, io\nf = io.StringIO(\"imie,wiek\\nOla,25\\nJan,30\")\nfor r in csv.DictReader(f):\n    print(r[\"imie\"], r[\"wiek\"])",
        output = "Ola 25\nJan 30",
    ),
    explain(
        "Proste statystyki",
        "Moduł `csv` niczego nie zamienia na liczby – wszystkie pola są napisami. Przed liczeniem " +
            "sumy, średniej czy maksimum używamy `int()` albo `float()`.",
        code = "import csv, io\nf = io.StringIO(\"cena\\n10\\n20\\n30\")\nc = [int(r[\"cena\"]) for r in csv.DictReader(f)]\nprint(sum(c), max(c))",
        output = "60 30",
    ),
    output(
        "print(\"Ewa,22,Gdańsk\".split(\",\")[0])",
        "Ewa",
        "Pierwsze pole wiersza ma indeks 0.",
    ),
    choice(
        "Jaki typ mają wartości odczytane przez csv.reader?",
        listOf("Napisy (str)", "Liczby (int)", "Zależy od zawartości", "Krotki"),
        0,
        "Moduł csv zwraca wszystkie pola jako napisy.",
    ),
    fill(
        "Uzupełnij, aby czytać wiersze jako słowniki.",
        "import csv, io\nf = io.StringIO(\"x\\n7\")\nfor r in csv.____(f):\n    print(r[\"x\"])",
        listOf("DictReader", "reader", "writer"),
        "DictReader",
        "Zwykły reader daje listy, więc r[\"x\"] zgłosi błąd.",
    ),
)
