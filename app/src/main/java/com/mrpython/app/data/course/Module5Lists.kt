package com.mrpython.app.data.course

import com.mrpython.app.domain.CourseUnit

internal val module5 = CourseUnit(
    id = "u5",
    title = "Listy",
    description = "Przechowuj wiele wartości naraz",
    lessons = listOf(
        lesson(
            "u5l1", "Tworzenie list",
            choice(
                "Jak utworzyć listę z liczbami 1, 2, 3?",
                listOf("[1, 2, 3]", "<1, 2, 3>", "{1 2 3}", "list 1 2 3"),
                0,
                "Listy zapisujemy w nawiasach kwadratowych.",
            ),
            output(
                "owoce = [\"jabłko\", \"banan\", \"kiwi\"]\nprint(owoce[0])",
                "jabłko",
                "Indeksy zaczynają się od 0.",
            ),
            output(
                "owoce = [\"jabłko\", \"banan\", \"kiwi\"]\nprint(owoce[-1])",
                "kiwi",
                "Indeks -1 oznacza ostatni element.",
            ),
            output("print(len([4, 8, 15, 16]))", "4", "len() zwraca liczbę elementów."),
            fill(
                "Dodaj 3 na koniec listy.",
                "liczby = [1, 2]\nliczby.____(3)\nprint(liczby)",
                listOf("append", "add", "push"),
                "append",
                "Metoda append() dodaje element na koniec listy.",
            ),
            output("x = [10, 20, 30]\nx[1] = 99\nprint(x)", "[10, 99, 30]", "Element listy można podmienić przez indeks."),
            choice(
                "Co się stanie?",
                listOf("Błąd IndexError – nie ma indeksu 3", "Wypisze 3", "Wypisze None", "Wypisze [1, 2, 3]"),
                0,
                "Indeksy tej listy to 0, 1 i 2 – indeks 3 nie istnieje.",
                code = "x = [1, 2, 3]\nprint(x[3])",
            ),
        ),
        lesson(
            "u5l2", "Operacje na listach",
            output(
                "x = [1, 2, 3, 4, 5]\nprint(x[1:3])",
                "[2, 3]",
                "Wycinek [1:3] bierze elementy o indeksach 1 i 2.",
            ),
            output(
                "x = [3, 1, 2]\nx.sort()\nprint(x)",
                "[1, 2, 3]",
                "sort() porządkuje listę rosnąco.",
            ),
            choice(
                "Co wypisze ten kod?",
                listOf("True", "False", "kot", "1"),
                0,
                "Operator in sprawdza, czy element jest na liście.",
                code = "zwierzeta = [\"pies\", \"kot\"]\nprint(\"kot\" in zwierzeta)",
            ),
            output(
                "imiona = [\"Ala\", \"Ola\"]\nfor imie in imiona:\n    print(\"Hej \" + imie)",
                "Hej Ala\nHej Ola",
                "Pętla for przechodzi po kolejnych elementach listy.",
            ),
            tiles(
                "Zapisz w zmiennej suma sumę liczb z listy oceny",
                listOf("suma", "=", "sum(oceny)"),
                listOf("len(oceny)", "+="),
                "Wbudowana funkcja sum() dodaje wszystkie elementy.",
            ),
            output("x = [5, 1, 4]\nprint(max(x), min(x), sum(x))", "5 1 10", "max, min i sum działają na listach liczb."),
            output(
                "x = [1, 2, 3, 4, 5]\nprint(x[:2])\nprint(x[3:])",
                "[1, 2]\n[4, 5]",
                "Pominięty początek lub koniec wycinka oznacza „od początku” lub „do końca”.",
            ),
        ),
        lesson(
            "u5l3", "Zmienianie list",
            output("x = [1, 2, 3]\nx.remove(2)\nprint(x)", "[1, 3]", "remove() usuwa pierwszy element o podanej wartości."),
            output(
                "x = [\"a\", \"b\", \"c\"]\nostatni = x.pop()\nprint(ostatni)\nprint(x)",
                "c\n['a', 'b']",
                "pop() usuwa i zwraca ostatni element. Napisy w liście wypisują się w apostrofach.",
            ),
            output("x = [1, 3]\nx.insert(1, 2)\nprint(x)", "[1, 2, 3]", "insert(indeks, wartość) wstawia element w podane miejsce."),
            output("x = [\"a\", \"b\", \"c\"]\nprint(x.index(\"c\"))", "2", "index() zwraca pozycję elementu."),
            choice(
                "Która metoda usuwa element o podanym indeksie i go zwraca?",
                listOf("pop", "remove", "delete", "cut"),
                0,
                "pop(i) usuwa element o indeksie i i go zwraca.",
            ),
            output("a = [1, 2]\nb = [3]\nprint(a + b)", "[1, 2, 3]", "+ łączy dwie listy w nową."),
            fill(
                "Uzupełnij, aby posortować listę malejąco.",
                "x = [2, 9, 4]\nx.sort(reverse=____)\nprint(x)",
                listOf("True", "False", "None"),
                "True",
                "reverse=True odwraca kolejność sortowania.",
            ),
            output(
                "x = [3, 1, 2]\nprint(sorted(x))\nprint(x)",
                "[1, 2, 3]\n[3, 1, 2]",
                "sorted() zwraca nową listę, a oryginał zostaje bez zmian.",
            ),
        ),
        lesson(
            "u5l4", "Listy i pętle",
            output("liczby = [2, 4, 6]\nfor n in liczby:\n    print(n * 10)", "20\n40\n60", "Pętla przechodzi po każdym elemencie listy."),
            output(
                "x = [\"a\", \"b\", \"c\"]\nfor i in range(len(x)):\n    print(i, x[i])",
                "0 a\n1 b\n2 c",
                "range(len(x)) daje kolejne indeksy listy.",
            ),
            output(
                "wyniki = []\nfor i in range(4):\n    wyniki.append(i * i)\nprint(wyniki)",
                "[0, 1, 4, 9]",
                "Lista budowana krok po kroku przez append().",
            ),
            output(
                "oceny = [4, 5, 3, 5]\nlicznik = 0\nfor o in oceny:\n    if o == 5:\n        licznik += 1\nprint(licznik)",
                "2",
                "Pętla liczy piątki.",
            ),
            output(
                "x = [3, 8, 1]\nnajw = x[0]\nfor n in x:\n    if n > najw:\n        najw = n\nprint(najw)",
                "8",
                "Tak działa max() „od środka”.",
            ),
            fill(
                "Uzupełnij, aby wypisać wszystkie elementy listy.",
                "imiona = [\"Ala\", \"Ola\"]\nfor imie ____ imiona:\n    print(imie)",
                listOf("in", "of", "="),
                "in",
                "Pętla po liście: for element in lista:",
            ),
            tiles(
                "Ułóż nagłówek pętli po indeksach listy dane",
                listOf("for", "i", "in", "range(len(dane))", ":"),
                listOf("range(dane)", "len(dane)"),
                "range(len(lista)) daje indeksy 0, 1, 2, …",
            ),
            output("slowa = [\"kot\", \"pies\"]\nfor s in slowa:\n    print(len(s))", "3\n4", "len() działa też na napisach."),
        ),
        lesson(
            "u5l5", "Powtórka: listy",
            output("x = [1, 2, 3]\nx.append(4)\nprint(len(x))", "4", "Po append lista ma 4 elementy."),
            output("x = [\"p\", \"y\", \"t\"]\nprint(x[-2])", "y", "-2 to przedostatni element."),
            choice(
                "Co wypisze ten kod?",
                listOf("[1, 2, 3, 4]", "[1, 2, 3]", "[4]", "Błąd"),
                0,
                "y = x nie kopiuje listy – obie nazwy wskazują tę samą listę.",
                code = "x = [1, 2, 3]\ny = x\ny.append(4)\nprint(x)",
            ),
            output("x = [5, 3, 8]\nx.sort()\nprint(x[0])", "3", "Po sortowaniu najmniejszy element jest na początku."),
            output("print(sum([1, 2, 3]) / len([1, 2, 3]))", "2.0", "Średnia to suma podzielona przez liczbę elementów."),
            fill(
                "Uzupełnij, aby usunąć ostatni element listy.",
                "x = [1, 2, 3]\nx.____()\nprint(x)",
                listOf("pop", "remove", "append"),
                "pop",
                "pop() bez argumentu usuwa ostatni element.",
            ),
            output("x = [0, 1, 2, 3, 4, 5]\nprint(x[1:5:2])", "[1, 3]", "Trzecia liczba wycinka to krok."),
            output("x = []\nprint(len(x))\nprint(bool(x))", "0\nFalse", "Pusta lista ma długość 0 i jest „fałszywa”."),
        ),
    ),
)
