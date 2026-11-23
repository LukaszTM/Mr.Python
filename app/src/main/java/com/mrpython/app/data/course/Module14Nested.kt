package com.mrpython.app.data.course

import com.mrpython.app.domain.CourseUnit

internal val module14 = CourseUnit(
    id = "u14",
    title = "Struktury zagnieżdżone",
    description = "Listy list, listy słowników i kopiowanie danych",
    lessons = listOf(
        lesson(
            "u14l1", "Listy list",
            output("m = [[1, 2], [3, 4]]\nprint(m[1][0])", "3", "m[1] to drugi wiersz [3, 4], a [0] to jego pierwszy element."),
            output("m = [[1, 2, 3], [4, 5, 6]]\nprint(m[0])", "[1, 2, 3]", "Jeden indeks zwraca cały wiersz."),
            output(
                "m = [[1, 2, 3], [4, 5, 6]]\nprint(len(m), len(m[0]))",
                "2 3",
                "len(m) to liczba wierszy, len(m[0]) – liczba kolumn.",
            ),
            output("m = [[1, 2], [3, 4]]\nm[0][1] = 9\nprint(m)", "[[1, 9], [3, 4]]", "Dwa indeksy pozwalają zmienić jeden element."),
            output(
                "m = [[1, 2], [3, 4], [5, 6]]\nprint([w[1] for w in m])",
                "[2, 4, 6]",
                "Biorąc w[1] z każdego wiersza, dostajemy drugą kolumnę.",
            ),
            choice(
                "Co wypisze ten kod?",
                listOf("4", "1", "[3, 4]", "Błąd"),
                0,
                "m[-1] to ostatni wiersz, a [-1] to jego ostatni element.",
                code = "m = [[1, 2], [3, 4]]\nprint(m[-1][-1])",
            ),
            fill(
                "Uzupełnij, aby wypisać 6 (2. wiersz, 3. kolumna).",
                "m = [[1, 2, 3], [4, 5, 6]]\nprint(m____)",
                listOf("[1][2]", "[2][3]", "[2][1]"),
                "[1][2]",
                "Indeksy liczymy od 0, więc 2. wiersz to [1], a 3. kolumna to [2].",
            ),
            tiles(
                "Wypisz pierwszy element drugiego wiersza macierzy m",
                listOf("print(", "m[1]", "[0]", ")"),
                listOf("m[2]", "[1]"),
                "Najpierw wybieramy wiersz m[1], potem element [0].",
            ),
        ),
        lesson(
            "u14l2", "Listy słowników",
            output(
                "osoby = [\n    {\"imie\": \"Ala\", \"wiek\": 20},\n    {\"imie\": \"Bob\", \"wiek\": 30},\n]\nprint(osoby[1][\"imie\"])",
                "Bob",
                "osoby[1] to słownik Boba, a [\"imie\"] wyciąga z niego imię.",
            ),
            output(
                "osoby = [\n    {\"imie\": \"Ala\", \"wiek\": 20},\n    {\"imie\": \"Bob\", \"wiek\": 30},\n]\nfor o in osoby:\n    print(o[\"imie\"], o[\"wiek\"])",
                "Ala 20\nBob 30",
                "Pętla przechodzi po kolejnych słownikach (rekordach).",
            ),
            output(
                "osoby = [{\"wiek\": 20}, {\"wiek\": 30}]\nsuma = 0\nfor o in osoby:\n    suma += o[\"wiek\"]\nprint(suma)",
                "50",
                "Sumujemy wiek z każdego rekordu: 20 + 30.",
            ),
            choice(
                "Czym jest osoby[0] w tym kodzie?",
                listOf("Słownikiem", "Listą", "Napisem", "Liczbą"),
                0,
                "Każdy element listy osoby to słownik opisujący jedną osobę.",
                code = "osoby = [{\"imie\": \"Ala\"}, {\"imie\": \"Ewa\"}]",
            ),
            fill(
                "Uzupełnij, aby wypisać wiek pierwszej osoby.",
                "osoby = [{\"wiek\": 20}, {\"wiek\": 30}]\nprint(osoby[0][____])",
                listOf("\"wiek\"", "0", "wiek"),
                "\"wiek\"",
                "Do wartości w słowniku dostajemy się przez klucz – napis \"wiek\".",
            ),
            output(
                "osoby = [\n    {\"imie\": \"Ala\", \"wiek\": 20},\n    {\"imie\": \"Bob\", \"wiek\": 30},\n]\nprint([o[\"imie\"] for o in osoby\n       if o[\"wiek\"] > 25])",
                "['Bob']",
                "Tylko Bob ma więcej niż 25 lat.",
            ),
            choice(
                "Co wypisze ten kod?",
                listOf("1 Lalka", "0 Lalka", "1 tytul", "Błąd"),
                0,
                "Lista ma jeden słownik, a jego tytuł to „Lalka”.",
                code = "ksiazki = []\nksiazki.append({\"tytul\": \"Lalka\"})\nprint(len(ksiazki), ksiazki[0][\"tytul\"])",
            ),
            tiles(
                "Dodaj do listy osoby nowy słownik z imieniem Ewa",
                listOf("osoby.append(", "{\"imie\":", "\"Ewa\"}", ")"),
                listOf("osoby.add(", "[\"imie\":"),
                "append() dodaje na koniec listy cały słownik.",
            ),
        ),
        lesson(
            "u14l3", "Słowniki list i pętle",
            output(
                "oceny = {\"Ala\": [5, 4], \"Bob\": [3]}\nprint(oceny[\"Ala\"][1])",
                "4",
                "oceny[\"Ala\"] to lista [5, 4], a [1] to jej drugi element.",
            ),
            output(
                "oceny = {\"Ala\": [5, 4]}\noceny[\"Ala\"].append(3)\nprint(oceny)",
                "{'Ala': [5, 4, 3]}",
                "Listę w słowniku można zmieniać metodami listy.",
            ),
            output(
                "oceny = {\"Ala\": [5, 4], \"Bob\": [3]}\nfor imie, lista in oceny.items():\n    print(imie, len(lista))",
                "Ala 2\nBob 1",
                "items() daje imię i listę ocen danej osoby.",
            ),
            output(
                "m = [[1, 2], [3, 4]]\nsuma = 0\nfor w in m:\n    for x in w:\n        suma += x\nprint(suma)",
                "10",
                "Pętla zewnętrzna idzie po wierszach, wewnętrzna po liczbach.",
            ),
            output(
                "grupy = {}\nfor s in [\"kot\", \"koń\", \"pies\"]:\n    k = s[0]\n    if k not in grupy:\n        grupy[k] = []\n    grupy[k].append(s)\nprint(grupy)",
                "{'k': ['kot', 'koń'], 'p': ['pies']}",
                "Słowa grupujemy w listach według pierwszej litery.",
            ),
            choice(
                "Jak odczytać drugą ocenę Boba?",
                listOf("d[\"Bob\"][1]", "d[1][\"Bob\"]", "d[\"Bob\"](1)", "d.Bob[1]"),
                0,
                "Najpierw klucz słownika, potem indeks listy.",
                code = "d = {\"Bob\": [3, 5]}",
            ),
            fill(
                "Uzupełnij, aby dopisać ocenę 5 do listy Ali.",
                "oceny = {\"Ala\": [4]}\noceny[\"Ala\"].____(5)\nprint(oceny)",
                listOf("append", "add", "insert"),
                "append",
                "oceny[\"Ala\"] to lista, a do listy dopisujemy przez append().",
            ),
            tiles(
                "Przejdź pętlą po wierszach macierzy m",
                listOf("for", "wiersz", "in", "m:"),
                listOf("m[0]:", "of"),
                "Pętla for po liście list daje kolejne wiersze.",
            ),
        ),
        lesson(
            "u14l4", "Kopia płytka i głęboka",
            output("a = [1, 2]\nb = a\nb.append(3)\nprint(a)", "[1, 2, 3]", "b = a nie kopiuje listy – obie nazwy wskazują tę samą listę."),
            output("a = [1, 2]\nb = a.copy()\nb.append(3)\nprint(a)", "[1, 2]", "copy() tworzy nową listę, więc a się nie zmienia."),
            output(
                "a = [[1], [2]]\nb = a.copy()\nb[0].append(9)\nprint(a)",
                "[[1, 9], [2]]",
                "Kopia płytka kopiuje tylko listę zewnętrzną – wewnętrzne listy są wspólne.",
            ),
            output(
                "import copy\na = [[1], [2]]\nb = copy.deepcopy(a)\nb[0].append(9)\nprint(a)",
                "[[1], [2]]",
                "deepcopy() kopiuje też wszystkie listy w środku.",
            ),
            choice(
                "Co wypisze ten kod?",
                listOf("[[1, 0], [1, 0]]", "[[1, 0], [0, 0]]", "[[1, 1], [0, 0]]", "Błąd"),
                0,
                "* 2 powiela tę samą listę wewnętrzną, więc oba wiersze to jeden obiekt.",
                code = "m = [[0] * 2] * 2\nm[0][0] = 1\nprint(m)",
            ),
            choice(
                "Co robi instrukcja b = a, gdy a jest listą?",
                listOf("Daje drugą nazwę tej samej liście", "Tworzy kopię płytką", "Tworzy kopię głęboką", "Czyści listę a"),
                0,
                "Przypisanie nigdy nie kopiuje – obie zmienne wskazują ten sam obiekt.",
            ),
            fill(
                "Uzupełnij, aby zmiana b[0] nie zmieniła listy a.",
                "import copy\na = [[1, 2]]\nb = copy.____(a)\nb[0][0] = 5\nprint(a)",
                listOf("deepcopy", "copy", "list"),
                "deepcopy",
                "Tylko deepcopy() kopiuje listy w środku – wtedy a zostaje [[1, 2]].",
            ),
            output("a = [1, 2]\nb = list(a)\nb[0] = 7\nprint(a, b)", "[1, 2] [7, 2]", "list(a) tworzy nową listę z tymi samymi elementami."),
        ),
        lesson(
            "u14l5", "Powtórka: struktury zagnieżdżone",
            output("m = [[1, 2], [3, 4]]\nprint(m[0][0] + m[1][1])", "5", "Elementy na przekątnej to 1 i 4."),
            output("dane = {\"x\": [1, 2, 3]}\nprint(sum(dane[\"x\"]))", "6", "dane[\"x\"] to lista, a sum() ją sumuje."),
            output(
                "p = [{\"c\": 2}, {\"c\": 3}]\nprint([d[\"c\"] * 2 for d in p])",
                "[4, 6]",
                "Z każdego słownika bierzemy wartość pod kluczem \"c\".",
            ),
            output("m = [[1, 2], [3, 4]]\nfor w in m:\n    print(w[0] * w[1])", "2\n12", "Dla każdego wiersza mnożymy jego dwa elementy."),
            choice(
                "Która operacja skopiuje także listy wewnętrzne?",
                listOf("copy.deepcopy(a)", "a.copy()", "a[:]", "b = a"),
                0,
                "a.copy() i a[:] to kopie płytkie, a b = a w ogóle nie kopiuje.",
            ),
            choice(
                "Co wypisze ten kod?",
                listOf("[[0, 7]]", "[[0, 0]]", "[[7, 0]]", "Błąd"),
                0,
                "a[:] to kopia płytka, więc wewnętrzna lista jest wspólna.",
                code = "a = [[0, 0]]\nb = a[:]\nb[0][1] = 7\nprint(a)",
            ),
            fill(
                "Uzupełnij, aby wypisać ostatni wiersz macierzy.",
                "m = [[1, 2], [3, 4]]\nprint(m[____])",
                listOf("-1", "2", "0"),
                "-1",
                "Indeks -1 wskazuje ostatni element, tu ostatni wiersz.",
            ),
            tiles(
                "Wypisz imię pierwszej osoby z listy osoby",
                listOf("print(", "osoby[0]", "[\"imie\"]", ")"),
                listOf("osoby[\"imie\"]", "[1]"),
                "Najpierw indeks listy [0], potem klucz słownika [\"imie\"].",
            ),
        ),
    ),
)
