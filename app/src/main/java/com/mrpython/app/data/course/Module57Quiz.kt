package com.mrpython.app.data.course

import com.mrpython.app.domain.CourseUnit

internal val module57 = CourseUnit(
    id = "u57",
    title = "Projekt: quiz",
    description = "Budujemy quiz: pytania, punkty, tasowanie i raport",
    lessons = listOf(
        lesson(
            "u57l1", "Pytania jako słowniki",
            output(
                "pytanie = {\"tresc\": \"2 + 2 = ?\", \"odp\": \"4\"}\nprint(pytanie[\"tresc\"])",
                "2 + 2 = ?",
                "Pytanie to słownik z treścią i poprawną odpowiedzią.",
            ),
            output(
                "pytania = [\n    {\"tresc\": \"Stolica Polski?\", \"odp\": \"Warszawa\"},\n    {\"tresc\": \"5 * 3 = ?\", \"odp\": \"15\"},\n]\nfor p in pytania:\n    print(p[\"tresc\"])",
                "Stolica Polski?\n5 * 3 = ?",
                "Lista słowników przechowuje cały zestaw pytań.",
            ),
            choice(
                "Dlaczego odpowiedź \"15\" zapisujemy jako napis, a nie liczbę?",
                listOf("Odpowiedź gracza też jest napisem, więc łatwo je porównać", "Liczb nie można trzymać w słowniku", "Napis zajmuje mniej miejsca", "Bo 15 to liczba nieparzysta"),
                0,
                "Porównujemy napis z napisem – bez zamiany typów.",
            ),
            fill(
                "Uzupełnij, aby wypisać poprawne odpowiedzi.",
                "pytania = [{\"tresc\": \"2 + 2?\", \"odp\": \"4\"},\n           {\"tresc\": \"3 + 3?\", \"odp\": \"6\"}]\nfor p in pytania:\n    print(p[____])",
                listOf("\"odp\"", "odp", "\"tresc\""),
                "\"odp\"",
                "Odpowiedź jest pod kluczem \"odp\".",
            ),
            output(
                "p = {\"tresc\": \"Kolor nieba?\",\n     \"opcje\": [\"zielony\", \"niebieski\"],\n     \"poprawna\": 1}\nprint(p[\"opcje\"][p[\"poprawna\"]])",
                "niebieski",
                "Pytanie wielokrotnego wyboru trzyma listę opcji i indeks poprawnej.",
            ),
            output(
                "opcje = [\"Kraków\", \"Gdańsk\", \"Poznań\"]\nfor i, o in enumerate(opcje, 1):\n    print(f\"{i}) {o}\")",
                "1) Kraków\n2) Gdańsk\n3) Poznań",
                "enumerate numeruje opcje od 1.",
            ),
            tiles(
                "Dodaj do listy pytanie o treści t i odpowiedzi o.",
                listOf("pytania.append(", "{\"tresc\": t,", "\"odp\": o}", ")"),
                listOf("pytania.add(", "[\"tresc\": t,"),
                "append dopisuje nowy słownik na koniec listy.",
            ),
            choice(
                "Jak sprawdzić, ile pytań ma quiz?",
                listOf("len(pytania)", "pytania.count()", "size(pytania)", "pytania.len"),
                0,
                "len zwraca liczbę elementów listy.",
            ),
        ),
        lesson(
            "u57l2", "Sprawdzanie odpowiedzi",
            output(
                "def sprawdz(pytanie, odp):\n    return odp == pytanie[\"odp\"]\n\np = {\"tresc\": \"3 + 4?\", \"odp\": \"7\"}\nprint(sprawdz(p, \"7\"), sprawdz(p, \"8\"))",
                "True False",
                "Funkcja porównuje odpowiedź gracza z poprawną.",
            ),
            output(
                "poprawna = \"Warszawa\"\nodp = \"  warszawa \"\nprint(odp == poprawna)\nprint(odp.strip().lower() == poprawna.lower())",
                "False\nTrue",
                "Usuwamy spacje i ujednolicamy wielkość liter przed porównaniem.",
            ),
            fill(
                "Uzupełnij, aby usunąć spacje z początku i końca odpowiedzi.",
                "odp = \" TAK \"\nprint(odp.____().lower() == \"tak\")",
                listOf("strip", "split", "trim"),
                "strip",
                "strip() usuwa białe znaki z obu końców napisu.",
            ),
            output(
                "pytania = [{\"odp\": \"4\"}, {\"odp\": \"Paryż\"}]\nodpowiedzi = [\"4\", \"Rzym\"]\nfor p, o in zip(pytania, odpowiedzi):\n    print(\"dobrze\" if o == p[\"odp\"] else \"źle\")",
                "dobrze\nźle",
                "zip łączy każde pytanie z odpowiedzią gracza.",
            ),
            choice(
                "Dlaczego ten warunek nigdy nie jest spełniony?",
                listOf("Porównuje napis \"15\" z liczbą 15", "Brakuje dwukropka", "== nie działa dla napisów", "odp jest pusty"),
                0,
                "Napis i liczba nigdy nie są sobie równe.",
                code = "odp = \"15\"\nif odp == 15:\n    print(\"dobrze\")",
            ),
            output(
                "p = {\"opcje\": [\"A\", \"B\", \"C\"], \"poprawna\": 2}\nwybor = 2\nprint(p[\"opcje\"][wybor], wybor == p[\"poprawna\"])",
                "C True",
                "Gracz wybrał indeks 2, czyli poprawną opcję C.",
            ),
            tiles(
                "Zapisz w ok wynik porównania odpowiedzi bez względu na wielkość liter.",
                listOf("ok =", "odp.lower()", "==", "poprawna.lower()"),
                listOf("=", "print("),
                "lower() po obu stronach sprawia, że \"Tak\" i \"tak\" są równe.",
            ),
            output(
                "def ocen(ok, poprawna):\n    if ok:\n        return \"Brawo!\"\n    return f\"Źle, poprawna: {poprawna}\"\n\nprint(ocen(False, \"Wisła\"))",
                "Źle, poprawna: Wisła",
                "Przy złej odpowiedzi pokazujemy poprawną.",
            ),
        ),
        lesson(
            "u57l3", "Punkty i procenty",
            output(
                "wyniki = [True, False, True, True]\npunkty = sum(wyniki)\nprint(punkty)",
                "3",
                "Każde True to jeden punkt.",
            ),
            output(
                "punkty, wszystkie = 3, 4\nprocent = punkty / wszystkie * 100\nprint(procent)",
                "75.0",
                "3 / 4 = 0.75, a razy 100 daje 75.0.",
            ),
            output(
                "print(round(2 / 3 * 100))\nprint(f\"{2 / 3:.1%}\")",
                "67\n66.7%",
                "round zaokrągla do całości, a :.1% pokazuje jedną cyfrę po przecinku.",
            ),
            fill(
                "Uzupełnij operator, aby 85% dało ocenę „bardzo dobry”.",
                "procent = 85\nif procent ____ 80:\n    print(\"bardzo dobry\")",
                listOf(">=", "<", "=="),
                ">=",
                "85 jest większe lub równe 80.",
            ),
            output(
                "def ocena(p):\n    if p >= 90:\n        return \"5\"\n    if p >= 70:\n        return \"4\"\n    if p >= 50:\n        return \"3\"\n    return \"2\"\n\nprint(ocena(95), ocena(70), ocena(49))",
                "5 4 2",
                "Progi sprawdzamy od najwyższego.",
            ),
            choice(
                "Co się stanie, gdy quiz nie ma pytań, a liczymy punkty / len(pytania)?",
                listOf("ZeroDivisionError", "Wynik 0", "Wynik None", "Wynik 100"),
                0,
                "len pustej listy to 0 – trzeba to sprawdzić wcześniej.",
            ),
            tiles(
                "Oblicz procent zdobytych punktów.",
                listOf("procent =", "punkty", "/", "wszystkie", "* 100"),
                listOf("//", "% 100"),
                "Dzielimy punkty przez liczbę pytań i mnożymy przez 100.",
            ),
            output(
                "poprawne = [\"a\", \"c\", \"b\"]\nodpowiedzi = [\"a\", \"b\", \"b\"]\npunkty = 0\nfor p, o in zip(poprawne, odpowiedzi):\n    if p == o:\n        punkty += 1\nprint(f\"{punkty}/{len(poprawne)}\")",
                "2/3",
                "Zgadzają się pierwsza i trzecia odpowiedź.",
            ),
        ),
        lesson(
            "u57l4", "Tasowanie pytań",
            choice(
                "Która funkcja miesza kolejność elementów listy w miejscu?",
                listOf("random.shuffle(lista)", "random.choice(lista)", "lista.sort()", "random.randint(lista)"),
                0,
                "shuffle zmienia kolejność elementów w tej samej liście.",
            ),
            choice(
                "Co zwraca random.shuffle(lista)?",
                listOf("None – zmienia listę w miejscu", "Nową, potasowaną listę", "Pierwszy element", "Liczbę elementów"),
                0,
                "Dlatego nie piszemy lista = random.shuffle(lista).",
            ),
            output(
                "import random\n\nlista = [1, 2, 3, 4]\nrandom.shuffle(lista)\nprint(sorted(lista))",
                "[1, 2, 3, 4]",
                "Kolejność jest losowa, ale elementy są te same – po posortowaniu wynik jest pewny.",
            ),
            output(
                "import random\n\nlista = [1, 2, 3, 4]\nrandom.shuffle(lista)\nprint(len(lista), sum(lista))",
                "4 10",
                "Tasowanie nie zmienia liczby ani wartości elementów.",
            ),
            output(
                "import random\n\npytania = [\"P1\", \"P2\", \"P3\"]\nkolejka = pytania[:]\nrandom.shuffle(kolejka)\nprint(pytania)",
                "['P1', 'P2', 'P3']",
                "Tasujemy kopię, więc oryginalna lista zostaje bez zmian.",
            ),
            fill(
                "Uzupełnij nazwę funkcji, która potasuje listę.",
                "import random\n\nlista = [3, 1, 2]\nrandom.____(lista)\nprint(len(lista))",
                listOf("shuffle", "mix", "sort"),
                "shuffle",
                "Moduł random ma funkcję shuffle; mix i sort nie istnieją w random.",
            ),
            output(
                "import random\n\np = [\"A\", \"B\", \"C\"]\nnowa = random.sample(p, len(p))\nprint(len(nowa), sorted(nowa) == p)",
                "3 True",
                "sample zwraca nową listę w losowej kolejności i nie zmienia oryginału.",
            ),
            tiles(
                "Potasuj listę pytania.",
                listOf("random.shuffle(", "pytania", ")"),
                listOf("random.sort(", "pytania ="),
                "shuffle działa w miejscu, więc nie przypisujemy wyniku.",
            ),
        ),
        lesson(
            "u57l5", "Klasa Pytanie i podsumowanie projektu",
            output(
                "class Pytanie:\n    def __init__(self, tresc, odp):\n        self.tresc = tresc\n        self.odp = odp\n    def sprawdz(self, odp):\n        return odp.strip().lower() == self.odp.lower()\n\np = Pytanie(\"Stolica Francji?\", \"Paryż\")\nprint(p.sprawdz(\" paryż\"))",
                "True",
                "Obiekt pytania sam umie sprawdzić odpowiedź.",
            ),
            fill(
                "Uzupełnij nazwę metody, która ustawia atrybuty nowego obiektu.",
                "class Pytanie:\n    def ____(self, tresc, odp):\n        self.tresc = tresc\n        self.odp = odp\n\np = Pytanie(\"2 + 2?\", \"4\")\nprint(p.odp)",
                listOf("__init__", "init", "__str__"),
                "__init__",
                "__init__ wywołuje się przy tworzeniu obiektu.",
            ),
            output(
                "class Quiz:\n    def __init__(self, pytania):\n        self.pytania = pytania\n        self.punkty = 0\n    def odpowiedz(self, i, odp):\n        if self.pytania[i][\"odp\"] == odp:\n            self.punkty += 1\n\nq = Quiz([{\"odp\": \"4\"}, {\"odp\": \"9\"}])\nq.odpowiedz(0, \"4\")\nq.odpowiedz(1, \"8\")\nprint(q.punkty)",
                "1",
                "Tylko pierwsza odpowiedź jest poprawna.",
            ),
            output(
                "punkty, wszystkie = 4, 5\nprocent = punkty / wszystkie * 100\nprint(f\"Wynik: {punkty}/{wszystkie}\")\nprint(f\"Procent: {procent:.0f}%\")",
                "Wynik: 4/5\nProcent: 80%",
                "Raport pokazuje punkty i procent.",
            ),
            output(
                "pytania = [\"2+2\", \"3*3\", \"10-7\"]\npoprawne = [\"4\", \"9\", \"3\"]\nodp = [\"4\", \"6\", \"3\"]\nbledy = [p for p, a, b\n         in zip(pytania, poprawne, odp)\n         if a != b]\nprint(bledy)",
                "['3*3']",
                "Raport może wypisać pytania z błędną odpowiedzią.",
            ),
            choice(
                "Jak w tym projekcie przechowujemy zestaw pytań?",
                listOf("Jako listę słowników albo listę obiektów Pytanie", "Jako jeden długi napis", "Jako zbiór liczb", "W osobnej zmiennej na każde pytanie"),
                0,
                "Lista pozwala łatwo dodawać, tasować i przechodzić po pytaniach.",
            ),
            tiles(
                "Dodaj punkt do atrybutu punkty w metodzie quizu.",
                listOf("self.punkty", "+=", "1"),
                listOf("==", "self.wynik"),
                "+= 1 zwiększa licznik punktów o jeden.",
            ),
            output(
                "class Wynik:\n    def __init__(self, ok, n):\n        self.ok, self.n = ok, n\n    def __str__(self):\n        return f\"{self.ok}/{self.n} ({self.ok / self.n:.0%})\"\n\nprint(Wynik(3, 4))",
                "3/4 (75%)",
                "__str__ zwraca gotowe podsumowanie quizu.",
            ),
        ),
    ),
)
