package com.mrpython.app.data.course

import com.mrpython.app.domain.CourseUnit

internal val module22 = CourseUnit(
    id = "u22",
    title = "enumerate, zip i iteracja",
    description = "Wygodne pętle: numerowanie, łączenie i kolejność",
    lessons = listOf(
        lesson(
            "u22l1", "enumerate",
            output(
                "for i, x in enumerate([\"a\", \"b\"]):\n    print(i, x)",
                "0 a\n1 b",
                "enumerate daje indeks i element, licząc od 0.",
            ),
            output(
                "for i, x in enumerate([\"a\", \"b\"], start=1):\n    print(i, x)",
                "1 a\n2 b",
                "start=1 zaczyna numerowanie od 1.",
            ),
            choice(
                "Co daje enumerate dla każdego elementu?",
                listOf("Parę (indeks, element)", "Sam indeks", "Sam element", "Długość listy"),
                0,
                "Dlatego w pętli piszemy dwie zmienne: i, x.",
            ),
            fill(
                "Uzupełnij, aby numerować od 1.",
                "for nr, imie in enumerate([\"Ala\", \"Ola\"], ____=1):\n    print(nr, imie)",
                listOf("start", "begin", "od"),
                "start",
                "Parametr nazywa się start.",
            ),
            output("print(list(enumerate(\"ab\")))", "[(0, 'a'), (1, 'b')]", "enumerate tworzy krotki (indeks, element)."),
            tiles(
                "Przejdź po liście owoce razem z indeksami.",
                listOf("for", "i, owoc", "in", "enumerate(owoce):"),
                listOf("range(owoce):", "zip(owoce):"),
                "for i, owoc in enumerate(owoce): daje indeks i element.",
            ),
            output(
                "liczby = [5, 8, 3]\nfor i, x in enumerate(liczby):\n    if x == 8:\n        print(i)",
                "1",
                "8 stoi na indeksie 1.",
            ),
            choice(
                "Który zapis jest wygodniejszy niż for i in range(len(lista))?",
                listOf(
                    "for i, x in enumerate(lista):",
                    "for i in lista.index():",
                    "for x, i in lista:",
                    "for i in len(lista):",
                ),
                0,
                "enumerate daje od razu indeks i element.",
            ),
        ),
        lesson(
            "u22l2", "zip",
            output(
                "for a, b in zip([1, 2], [\"x\", \"y\"]):\n    print(a, b)",
                "1 x\n2 y",
                "zip łączy elementy z tych samych pozycji w pary.",
            ),
            output(
                "print(list(zip([1, 2, 3], [4, 5])))",
                "[(1, 4), (2, 5)]",
                "zip kończy się na najkrótszej liście – 3 nie ma pary.",
            ),
            choice(
                "Co robi zip, gdy listy mają różne długości?",
                listOf(
                    "Kończy na najkrótszej liście",
                    "Zgłasza błąd",
                    "Uzupełnia braki wartością None",
                    "Powtarza krótszą listę",
                ),
                0,
                "Nadmiarowe elementy dłuższej listy są pomijane.",
            ),
            output(
                "imiona = [\"Ala\", \"Ola\"]\nwiek = [7, 9]\nprint(dict(zip(imiona, wiek)))",
                "{'Ala': 7, 'Ola': 9}",
                "Pary z zip łatwo zamienić na słownik.",
            ),
            fill(
                "Uzupełnij, aby połączyć elementy dwóch list w pary.",
                "for x, y in ____([1, 2], [3, 4]):\n    print(x + y)",
                listOf("zip", "enumerate", "range"),
                "zip",
                "zip łączy kilka sekwencji w pary.",
            ),
            output(
                "a = [1, 2, 3]\nb = [10, 20, 30]\nprint([x + y for x, y in zip(a, b)])",
                "[11, 22, 33]",
                "Dodajemy elementy z tych samych pozycji.",
            ),
            tiles(
                "Utwórz słownik d z list klucze i wartosci.",
                listOf("d =", "dict(", "zip(klucze, wartosci)", ")"),
                listOf("list(", "zip(wartosci, klucze)"),
                "dict(zip(klucze, wartosci)) – najpierw klucze.",
            ),
            output(
                "for a, b, c in zip(\"ab\", \"cd\", \"ef\"):\n    print(a + b + c)",
                "ace\nbdf",
                "zip może łączyć więcej niż dwie sekwencje.",
            ),
        ),
        lesson(
            "u22l3", "reversed, sorted i sort",
            output("for x in reversed([1, 2, 3]):\n    print(x)", "3\n2\n1", "reversed przechodzi od końca."),
            output("print(list(reversed(\"abc\")))", "['c', 'b', 'a']", "reversed działa też na napisach."),
            output(
                "a = [3, 1, 2]\nb = sorted(a)\nprint(a)\nprint(b)",
                "[3, 1, 2]\n[1, 2, 3]",
                "sorted zwraca nową listę, oryginał zostaje bez zmian.",
            ),
            output(
                "a = [3, 1, 2]\nwynik = a.sort()\nprint(wynik)\nprint(a)",
                "None\n[1, 2, 3]",
                "sort() zmienia listę w miejscu i zwraca None.",
            ),
            choice(
                "Czym różni się sorted(lista) od lista.sort()?",
                listOf(
                    "sorted zwraca nową listę, sort zmienia listę w miejscu",
                    "sort zwraca nową listę, sorted zmienia listę",
                    "sorted sortuje malejąco",
                    "Niczym",
                ),
                0,
                "sorted działa na każdej sekwencji i niczego nie zmienia.",
            ),
            fill(
                "Uzupełnij, aby posortować malejąco.",
                "print(sorted([2, 9, 4], reverse=____))",
                listOf("True", "False", "0"),
                "True",
                "reverse=True odwraca kolejność sortowania.",
            ),
            output("print(sorted(\"kot\"))", "['k', 'o', 't']", "sorted na napisie zwraca listę posortowanych liter."),
            tiles(
                "Utwórz nową listę słów posortowaną według długości.",
                listOf("wynik =", "sorted(", "slowa,", "key=len", ")"),
                listOf("slowa.sort(", "reverse=len"),
                "key=len sortuje według długości.",
            ),
        ),
        lesson(
            "u22l4", "any i all",
            output(
                "print(any([False, True, False]))\nprint(all([True, False]))",
                "True\nFalse",
                "any – choć jeden prawdziwy, all – wszystkie prawdziwe.",
            ),
            output(
                "liczby = [2, 4, 6]\nprint(all([x % 2 == 0 for x in liczby]))",
                "True",
                "Wszystkie liczby są parzyste.",
            ),
            choice(
                "Co zwraca any([])?",
                listOf("False", "True", "None", "Błąd"),
                0,
                "W pustej liście nie ma ani jednej prawdy.",
            ),
            choice(
                "Co zwraca all([])?",
                listOf("True", "False", "None", "Błąd"),
                0,
                "W pustej liście nie ma żadnego fałszu, więc all daje True.",
            ),
            output(
                "slowa = [\"kot\", \"\", \"pies\"]\nprint(all(slowa))\nprint(any(slowa))",
                "False\nTrue",
                "Pusty napis jest fałszywy, niepusty – prawdziwy.",
            ),
            fill(
                "Uzupełnij, aby sprawdzić, czy jest JAKAŚ liczba ujemna.",
                "liczby = [3, -1, 5]\nprint(____([x < 0 for x in liczby]))",
                listOf("any", "all", "len"),
                "any",
                "any sprawdza, czy choć jeden warunek jest spełniony.",
            ),
            output(
                "hasla = [\"abc\", \"abcdefgh\"]\nprint(any([len(h) >= 8 for h in hasla]))",
                "True",
                "Drugie hasło ma 8 znaków.",
            ),
            tiles(
                "Sprawdź, czy wszystkie oceny są większe od 2.",
                listOf("all(", "[o > 2", "for o in oceny]", ")"),
                listOf("any(", "[o < 2"),
                "all zwraca True tylko wtedy, gdy każdy warunek jest prawdziwy.",
            ),
        ),
        lesson(
            "u22l5", "Powtórka: iteracja",
            output(
                "for i, (a, b) in enumerate(zip(\"xy\", [1, 2])):\n    print(i, a, b)",
                "0 x 1\n1 y 2",
                "enumerate numeruje pary z zip.",
            ),
            output(
                "print(list(zip(range(3), reversed(range(3)))))",
                "[(0, 2), (1, 1), (2, 0)]",
                "Łączymy liczby rosnące z malejącymi.",
            ),
            choice(
                "Która operacja NIE zmienia listy, tylko zwraca nowy wynik?",
                listOf("sorted(lista)", "lista.sort()", "lista.reverse()", "lista.append(1)"),
                0,
                "sorted tworzy nową listę.",
            ),
            output(
                "punkty = [10, 30, 20]\nnaj = max(punkty)\nfor nr, p in enumerate(punkty, start=1):\n    if p == naj:\n        print(nr)",
                "2",
                "Najlepszy wynik ma zawodnik numer 2.",
            ),
            fill(
                "Uzupełnij, aby przejść po liście od końca.",
                "for x in ____([1, 2, 3]):\n    print(x)",
                listOf("reversed", "sorted", "reverse"),
                "reversed",
                "reversed zwraca elementy w odwrotnej kolejności.",
            ),
            output("print(all([1, 2, 3]), any([0, 0]))", "True False", "Niezerowe liczby są prawdziwe, zera fałszywe."),
            tiles(
                "Przejdź jednocześnie po listach imiona i oceny.",
                listOf("for", "imie, ocena", "in", "zip(imiona, oceny):"),
                listOf("enumerate(imiona, oceny):", "range(imiona):"),
                "zip łączy dwie listy w pary.",
            ),
            output(
                "a = [1, 2, 3, 4]\nb = [\"a\", \"b\"]\nprint(len(list(zip(a, b))))",
                "2",
                "zip kończy się na krótszej liście.",
            ),
        ),
    ),
)
