package com.mrpython.app.data.course

import com.mrpython.app.domain.CourseUnit

internal val module47 = CourseUnit(
    id = "u47",
    title = "CSV i dane tabelaryczne",
    description = "Wiersze, kolumny, moduł csv i proste statystyki",
    lessons = listOf(
        lesson(
            "u47l1", "Dzielenie linii",
            output(
                "linia = \"Ola,25,Kraków\"\npola = linia.split(\",\")\nprint(pola[2])",
                "Kraków",
                "split(\",\") dzieli wiersz CSV na pola.",
            ),
            output(
                "pola = \"Jan,30\".split(\",\")\nprint(int(pola[1]) + 1)",
                "31",
                "Pola są napisami – liczbę trzeba zamienić przez int().",
            ),
            output(
                "linia = \"a,b\\n\"\nprint(linia.strip().split(\",\"))",
                "['a', 'b']",
                "strip() usuwa znak nowej linii z końca wiersza.",
            ),
            output(
                "tekst = \"x,1\\ny,2\"\nfor w in tekst.splitlines():\n    print(w.split(\",\")[0])",
                "x\ny",
                "splitlines() dzieli tekst na wiersze.",
            ),
            choice(
                "Ile elementów da split(\",\") dla tego wiersza?",
                listOf("3", "2", "1", "Błąd"),
                0,
                "Przecinek wewnątrz cudzysłowu też tnie napis – dlatego do CSV lepszy jest moduł csv.",
                code = "w = '\"Kowalski, Jan\",30'\nprint(len(w.split(\",\")))",
            ),
            output(
                "dane = \"a;b;c\"\nprint(dane.split(\";\"))",
                "['a', 'b', 'c']",
                "Separatorem może być też średnik.",
            ),
            fill(
                "Uzupełnij, aby podzielić wiersz na pola.",
                "linia = \"jabłko,3,2.5\"\npola = linia.____(\",\")\nprint(pola[1])",
                listOf("split", "join", "strip"),
                "split",
                "split() dzieli napis; join() skleja, a strip() nie dzieli.",
            ),
            tiles(
                "Podziel wiersz linia po przecinkach i zapisz wynik w zmiennej pola",
                listOf("pola", "=", "linia.split(\",\")"),
                listOf("linia.join(\",\")", "split(linia)"),
                "split wywołujemy na napisie i podajemy separator.",
            ),
        ),
        lesson(
            "u47l2", "csv.reader i csv.writer",
            output(
                "import csv, io\nf = io.StringIO(\"a,b\\n1,2\\n\")\nfor w in csv.reader(f):\n    print(w)",
                "['a', 'b']\n['1', '2']",
                "csv.reader zwraca każdy wiersz jako listę napisów.",
            ),
            output(
                "import csv, io\nf = io.StringIO('\"Kowalski, Jan\",30')\nprint(next(csv.reader(f)))",
                "['Kowalski, Jan', '30']",
                "csv.reader rozumie cudzysłowy, więc przecinek w środku nie dzieli pola.",
            ),
            output(
                "import csv, io\nf = io.StringIO(\"x;y;z\")\nr = csv.reader(f, delimiter=\";\")\nprint(next(r))",
                "['x', 'y', 'z']",
                "delimiter ustala separator kolumn.",
            ),
            choice(
                "Do czego służy io.StringIO w tych przykładach?",
                listOf(
                    "Udaje plik, ale trzyma dane w pamięci",
                    "Zapisuje dane na dysku",
                    "Zamienia tekst na liczby",
                    "Pobiera plik z internetu",
                ),
                0,
                "StringIO zachowuje się jak otwarty plik tekstowy w pamięci.",
            ),
            output(
                "import csv, io\nf = io.StringIO()\nw = csv.writer(f)\nw.writerow([\"a\", 1])\nprint(f.getvalue().strip())",
                "a,1",
                "writerow() zapisuje listę jako jeden wiersz CSV.",
            ),
            output(
                "import csv, io\nf = io.StringIO()\ncsv.writer(f).writerow([\"x,y\", 2])\nprint(f.getvalue().strip())",
                "\"x,y\",2",
                "Pole z przecinkiem writer sam bierze w cudzysłów.",
            ),
            fill(
                "Uzupełnij, aby zapisać jeden wiersz.",
                "import csv, io\nf = io.StringIO()\nw = csv.writer(f)\nw.____([\"Ola\", 25])\nprint(f.getvalue().strip())",
                listOf("writerow", "write", "append"),
                "writerow",
                "Obiekt csv.writer ma metodę writerow(); write i append nie istnieją.",
            ),
            tiles(
                "Utwórz czytnik CSV dla pliku f i zapisz go w zmiennej r",
                listOf("r", "=", "csv.reader(", "f)"),
                listOf("csv.writer(", "f.reader("),
                "csv.reader(plik) zwraca obiekt, po którym iterujemy wierszami.",
            ),
        ),
        lesson(
            "u47l3", "DictReader i statystyki",
            output(
                "import csv, io\nf = io.StringIO(\"imie,wiek\\nOla,25\\nJan,30\")\nfor r in csv.DictReader(f):\n    print(r[\"imie\"])",
                "Ola\nJan",
                "DictReader bierze nagłówek jako klucze słownika.",
            ),
            output(
                "import csv, io\nf = io.StringIO(\"imie,wiek\\nOla,25\")\nprint(next(csv.DictReader(f)))",
                "{'imie': 'Ola', 'wiek': '25'}",
                "Każdy wiersz to słownik: kolumna → wartość (napis).",
            ),
            output(
                "import csv, io\nf = io.StringIO(\"a,b\\n1,2\")\nr = csv.DictReader(f)\nprint(r.fieldnames)",
                "['a', 'b']",
                "fieldnames to lista nazw kolumn z nagłówka.",
            ),
            output(
                "import csv, io\nf = io.StringIO(\"n,cena\\nA,10\\nB,20\")\nrazem = 0\nfor r in csv.DictReader(f):\n    razem += int(r[\"cena\"])\nprint(razem)",
                "30",
                "Sumujemy kolumnę, zamieniając każdą wartość na int.",
            ),
            output(
                "import csv, io\nf = io.StringIO(\"p\\n4\\n5\\n3\")\noceny = [int(r[\"p\"]) for r in csv.DictReader(f)]\nprint(sum(oceny) / len(oceny))",
                "4.0",
                "Średnia to suma podzielona przez liczbę wierszy.",
            ),
            choice(
                "Co się stanie bez int()?",
                listOf("TypeError – nie można dodać napisu do liczby", "Wypisze 30", "Wypisze 1020", "Wypisze 0"),
                0,
                "Wartości z CSV są napisami, a 0 + \"10\" to błąd.",
                code = "import csv, io\nf = io.StringIO(\"c\\n10\\n20\")\ns = 0\nfor r in csv.DictReader(f):\n    s += r[\"c\"]\nprint(s)",
            ),
            fill(
                "Uzupełnij, aby czytać wiersze jako słowniki.",
                "import csv, io\nf = io.StringIO(\"x\\n7\")\nfor r in csv.____(f):\n    print(r[\"x\"])",
                listOf("DictReader", "reader", "writer"),
                "DictReader",
                "Zwykły reader daje listy, więc r[\"x\"] zgłosi błąd.",
            ),
            choice(
                "Jaką wartość ma r[\"wiek\"] z DictReader dla wiersza „Ola,25”?",
                listOf("'25' (napis)", "25 (int)", "25.0 (float)", "None"),
                0,
                "Moduł csv niczego nie konwertuje – wszystkie pola to napisy.",
            ),
        ),
        lesson(
            "u47l4", "Powtórka: CSV",
            output(
                "print(\"Ewa,22,Gdańsk\".split(\",\")[1])",
                "22",
                "Drugie pole ma indeks 1.",
            ),
            output(
                "import csv, io\nf = io.StringIO('a,\"b,c\",d')\nprint(len(next(csv.reader(f))))",
                "3",
                "csv.reader traktuje „b,c” w cudzysłowie jako jedno pole.",
            ),
            output(
                "import csv, io\nf = io.StringIO(\"k,v\\nx,1\\ny,5\")\nd = {r[\"k\"]: int(r[\"v\"]) for r in csv.DictReader(f)}\nprint(d)",
                "{'x': 1, 'y': 5}",
                "Z wierszy DictReader łatwo zbudować słownik.",
            ),
            output(
                "import csv, io\nf = io.StringIO(\"t\\n3\\n9\\n6\")\nt = [int(r[\"t\"]) for r in csv.DictReader(f)]\nprint(max(t), min(t))",
                "9 3",
                "Po zamianie na int możemy liczyć max i min kolumny.",
            ),
            choice(
                "Dlaczego do CSV lepiej użyć modułu csv niż split(\",\")?",
                listOf(
                    "Poprawnie obsługuje pola w cudzysłowach z przecinkami",
                    "Jest jedynym sposobem na czytanie tekstu",
                    "Automatycznie zamienia pola na liczby",
                    "split nie działa na napisach z cyframi",
                ),
                0,
                "csv rozumie cudzysłowy, a split tnie w każdym przecinku.",
            ),
            fill(
                "Uzupełnij, aby czytać kolumny oddzielone średnikiem.",
                "import csv, io\nf = io.StringIO(\"a;b\")\nprint(next(csv.reader(f, ____=\";\")))",
                listOf("delimiter", "sep", "split"),
                "delimiter",
                "Parametr nazywa się delimiter; sep i split zgłoszą TypeError.",
            ),
            choice(
                "Co zwraca f.getvalue() dla obiektu io.StringIO?",
                listOf("Cały zapisany tekst jako napis", "Listę wierszy", "Liczbę znaków", "Nazwę pliku"),
                0,
                "getvalue() zwraca całą zawartość bufora.",
            ),
            tiles(
                "Zapisz listę wiersz jako jeden wiersz CSV przez writer w",
                listOf("w.writerow(", "wiersz)"),
                listOf("w.write(", "csv.writerow("),
                "Metoda writerow() obiektu writer zapisuje jedną listę.",
            ),
        ),
    ),
)
