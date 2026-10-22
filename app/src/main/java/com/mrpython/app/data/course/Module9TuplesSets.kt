package com.mrpython.app.data.course

import com.mrpython.app.domain.CourseUnit

internal val module9 = CourseUnit(
    id = "u9",
    title = "Krotki i zbiory",
    description = "tuple, set i rozpakowywanie",
    lessons = listOf(
        lesson(
            "u9l1", "Krotki",
            choice(
                "Czym różni się krotka (tuple) od listy?",
                listOf("Krotki nie można zmieniać", "Krotka może mieć tylko liczby", "Krotka nie ma indeksów", "Niczym"),
                0,
                "Krotka jest niezmienna – po utworzeniu nie da się jej zmienić.",
            ),
            output("t = (1, 2, 3)\nprint(t[1])", "2", "Krotki indeksujemy tak jak listy."),
            output("t = (\"a\", \"b\")\nprint(len(t))", "2", "len() działa też na krotkach."),
            choice(
                "Co się stanie?",
                listOf("Błąd TypeError – krotki nie można zmieniać", "t zmieni się na (5, 2)", "t zmieni się na (5,)", "Nic"),
                0,
                "Krotka jest niezmienna.",
                code = "t = (1, 2)\nt[0] = 5",
            ),
            output("punkt = (3, 4)\nx, y = punkt\nprint(x + y)", "7", "Rozpakowanie przypisuje kolejne elementy do zmiennych."),
            output("t = (5,)\nprint(type(t))", "<class 'tuple'>", "Krotka z jednym elementem wymaga przecinka."),
            output("print((1, 2) + (3,))", "(1, 2, 3)", "+ łączy krotki w nową."),
            output("a, b, c = \"xyz\"\nprint(b)", "y", "Rozpakować można też napis."),
        ),
        lesson(
            "u9l2", "Zbiory",
            output("s = {1, 2, 2, 3}\nprint(s)", "{1, 2, 3}", "Zbiór przechowuje tylko unikalne elementy."),
            output("print(len(set([1, 1, 1, 2])))", "2", "set() usuwa powtórzenia."),
            output("s = {1, 2}\ns.add(3)\ns.add(2)\nprint(s)", "{1, 2, 3}", "add() dodaje element, a duplikat jest ignorowany."),
            output("print(3 in {1, 2, 3})", "True", "in sprawdza, czy element należy do zbioru."),
            choice(
                "Co się stanie?",
                listOf("Błąd – zbiory nie mają indeksów", "Wypisze 1", "Wypisze {1}", "Wypisze None"),
                0,
                "Zbiór nie ma ustalonej kolejności, więc nie ma indeksów.",
                code = "s = {1, 2, 3}\nprint(s[0])",
            ),
            output("print(sorted({3, 1, 2}))", "[1, 2, 3]", "sorted() zwraca posortowaną listę."),
            fill(
                "Uzupełnij, aby policzyć różne elementy listy.",
                "x = [1, 2, 2, 3]\nprint(len(____(x)))",
                listOf("set", "list", "tuple"),
                "set",
                "set() zostawia tylko unikalne elementy: 1, 2 i 3.",
            ),
        ),
        lesson(
            "u9l3", "Działania na zbiorach",
            output("a = {1, 2, 3}\nb = {2, 3, 4}\nprint(a & b)", "{2, 3}", "& to część wspólna zbiorów."),
            output("a = {1, 2}\nb = {2, 3}\nprint(a | b)", "{1, 2, 3}", "| to suma zbiorów."),
            output("a = {1, 2, 3}\nb = {2}\nprint(a - b)", "{1, 3}", "- to różnica: elementy a, których nie ma w b."),
            output("a = {1, 2}\nb = {1, 2, 3}\nprint(a <= b)", "True", "<= sprawdza, czy a jest podzbiorem b."),
            choice(
                "Który operator daje elementy wspólne dwóch zbiorów?",
                listOf("&", "|", "-", "+"),
                0,
                "& to część wspólna (przecięcie).",
            ),
            output(
                "lubi_ala = {\"pizza\", \"lody\"}\nlubi_ola = {\"lody\", \"sushi\"}\nprint(lubi_ala & lubi_ola)",
                "{'lody'}",
                "Obie lubią lody.",
            ),
            tiles(
                "Zapisz w zmiennej wspolne część wspólną zbiorów a i b",
                listOf("wspolne", "=", "a", "&", "b"),
                listOf("|", "+"),
                "& daje elementy obecne w obu zbiorach.",
            ),
        ),
        lesson(
            "u9l4", "Powtórka: krotki i zbiory",
            output(
                "def podziel(a, b):\n    return a // b, a % b\n\nwynik = podziel(9, 4)\nprint(wynik)",
                "(2, 1)",
                "Kilka wartości po return tworzy krotkę.",
            ),
            output("x, y = 1, 2\nprint((x, y)[::-1])", "(2, 1)", "Wycinki działają też na krotkach."),
            output("slowa = [\"a\", \"b\", \"a\", \"c\", \"b\"]\nprint(len(set(slowa)))", "3", "Różne są tylko a, b i c."),
            choice(
                "Która struktura NIE pozwala na powtórzenia?",
                listOf("set (zbiór)", "list (lista)", "tuple (krotka)", "str (napis)"),
                0,
                "Zbiór przechowuje każdy element tylko raz.",
            ),
            output("t = (3, 1, 2)\nprint(max(t), min(t))", "3 1", "max i min działają na krotkach."),
            output("a = {1, 2, 3}\na.remove(2)\nprint(a)", "{1, 3}", "remove() usuwa element ze zbioru."),
            fill(
                "Uzupełnij, aby utworzyć krotkę.",
                "t = ____1, 2, 3)\nprint(type(t))",
                listOf("(", "[", "{"),
                "(",
                "Krotkę zapisujemy w nawiasach okrągłych.",
            ),
            output("for x, y in [(1, 2), (3, 4)]:\n    print(x * y)", "2\n12", "Pętla rozpakowuje każdą krotkę do x i y."),
        ),
    ),
)
