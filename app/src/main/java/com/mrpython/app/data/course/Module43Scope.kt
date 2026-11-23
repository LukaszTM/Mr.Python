package com.mrpython.app.data.course

import com.mrpython.app.domain.CourseUnit

internal val module43 = CourseUnit(
    id = "u43",
    title = "Zasięg i domknięcia",
    description = "Reguła LEGB, global, nonlocal i domknięcia",
    lessons = listOf(
        lesson(
            "u43l1", "Reguła LEGB",
            output(
                "x = \"globalne\"\ndef f():\n    x = \"lokalne\"\n    print(x)\nf()\nprint(x)",
                "lokalne\nglobalne",
                "Zmienna lokalna przesłania globalną tylko wewnątrz funkcji.",
            ),
            output(
                "x = 5\ndef f():\n    print(x)\nf()",
                "5",
                "Brak lokalnego x, więc Python szuka w zasięgu globalnym.",
            ),
            choice(
                "Co oznacza skrót LEGB?",
                listOf("Local, Enclosing, Global, Built-in", "List, Enum, Generator, Bool", "Local, External, General, Base", "Loop, Else, Global, Break"),
                0,
                "W tej kolejności Python szuka nazw.",
            ),
            output(
                "x = 1\ndef zewn():\n    x = 2\n    def wew():\n        print(x)\n    wew()\nzewn()",
                "2",
                "wew znajduje x w funkcji otaczającej (Enclosing), zanim dojdzie do globalnego.",
            ),
            output(
                "def f():\n    print(len(\"abc\"))\nf()",
                "3",
                "len pochodzi z zasięgu wbudowanego (Built-in).",
            ),
            choice(
                "Co się stanie po uruchomieniu tego kodu?",
                listOf("UnboundLocalError", "Wypisze 1", "Wypisze 2", "Wypisze None"),
                0,
                "Przypisanie w funkcji czyni x lokalnym, a print próbuje go odczytać przed przypisaniem.",
                code = "x = 1\ndef f():\n    print(x)\n    x = 2\nf()",
            ),
            output(
                "def f():\n    y = 10\nf()\ntry:\n    print(y)\nexcept NameError:\n    print(\"brak y\")",
                "brak y",
                "Zmienne lokalne znikają po zakończeniu funkcji.",
            ),
        ),
        lesson(
            "u43l2", "global i nonlocal",
            output(
                "licznik = 0\ndef dodaj():\n    global licznik\n    licznik += 1\ndodaj()\ndodaj()\nprint(licznik)",
                "2",
                "global pozwala zmienić zmienną globalną wewnątrz funkcji.",
            ),
            choice(
                "Co się stanie bez linii global licznik?",
                listOf("UnboundLocalError", "Wypisze 2", "Wypisze 0", "NameError przy definicji"),
                0,
                "licznik += 1 traktuje licznik jako lokalny, a on nie ma jeszcze wartości.",
                code = "licznik = 0\ndef dodaj():\n    licznik += 1\ndodaj()",
            ),
            output(
                "def zewn():\n    n = 0\n    def wew():\n        nonlocal n\n        n += 5\n    wew()\n    print(n)\nzewn()",
                "5",
                "nonlocal pozwala zmienić zmienną funkcji otaczającej.",
            ),
            output(
                "def zewn():\n    n = 0\n    def wew():\n        n = 5\n    wew()\n    print(n)\nzewn()",
                "0",
                "Bez nonlocal w wew powstaje nowa, lokalna zmienna n.",
            ),
            fill(
                "Uzupełnij, aby funkcja wew zmieniała zmienną s z funkcji zewn.",
                "def zewn():\n    s = \"a\"\n    def wew():\n        ____ s\n        s += \"b\"\n    wew()\n    print(s)\nzewn()",
                listOf("nonlocal", "global", "local", "def"),
                "nonlocal",
                "s należy do funkcji otaczającej, więc używamy nonlocal.",
            ),
            choice(
                "Czym różni się global od nonlocal?",
                listOf("global – zasięg modułu, nonlocal – najbliższa funkcja otaczająca", "Niczym", "nonlocal działa tylko w klasach", "global tworzy nową zmienną lokalną"),
                0,
                "nonlocal sięga do funkcji zewnętrznej, global do poziomu pliku.",
            ),
            tiles(
                "Zadeklaruj, że wynik to zmienna globalna",
                listOf("global", "wynik"),
                listOf("nonlocal", "def"),
                "Deklaracja global musi być przed użyciem zmiennej.",
            ),
        ),
        lesson(
            "u43l3", "Domknięcia",
            output(
                "def mnoznik(n):\n    def f(x):\n        return x * n\n    return f\nrazy3 = mnoznik(3)\nprint(razy3(5))",
                "15",
                "Funkcja f pamięta n z momentu utworzenia – to domknięcie.",
            ),
            output(
                "def licznik():\n    n = 0\n    def kolejny():\n        nonlocal n\n        n += 1\n        return n\n    return kolejny\nc = licznik()\nc()\nprint(c(), c())",
                "2 3",
                "Każde wywołanie zwiększa zapamiętane n.",
            ),
            output(
                "def licznik():\n    n = 0\n    def kolejny():\n        nonlocal n\n        n += 1\n        return n\n    return kolejny\na = licznik()\nb = licznik()\na()\na()\nprint(b())",
                "1",
                "Każde wywołanie licznik() tworzy osobne n.",
            ),
            choice(
                "Czym jest domknięcie (closure)?",
                listOf("Funkcją, która pamięta zmienne z zasięgu, w którym powstała", "Funkcją bez argumentów", "Zamkniętym plikiem", "Klasą bez metod"),
                0,
                "Domknięcie przechowuje zmienne funkcji otaczającej nawet po jej zakończeniu.",
            ),
            fill(
                "Uzupełnij, aby dodaj5(10) zwracało 15.",
                "def dodawacz(n):\n    def f(x):\n        return x + n\n    return ____\ndodaj5 = dodawacz(5)\nprint(dodaj5(10))",
                listOf("f", "f(x)", "n", "x + n"),
                "f",
                "Fabryka zwraca funkcję wewnętrzną, nie jej wynik.",
            ),
            output(
                "def powitanie(slowo):\n    def f(imie):\n        return slowo + \", \" + imie\n    return f\nhej = powitanie(\"Hej\")\nprint(hej(\"Ola\"))",
                "Hej, Ola",
                "hej pamięta słowo „Hej”.",
            ),
            tiles(
                "Utwórz funkcję razy2 z fabryki mnoznik",
                listOf("razy2", "=", "mnoznik(", "2", ")"),
                listOf("mnoznik", "()"),
                "Wywołanie fabryki zwraca nową funkcję.",
            ),
        ),
        lesson(
            "u43l4", "Powtórka i pułapka pętli",
            output(
                "funkcje = []\nfor i in range(3):\n    funkcje.append(lambda: i)\nprint([f() for f in funkcje])",
                "[2, 2, 2]",
                "Lambdy pamiętają zmienną i, a nie jej wartość – po pętli i wynosi 2.",
            ),
            output(
                "funkcje = []\nfor i in range(3):\n    funkcje.append(lambda i=i: i)\nprint([f() for f in funkcje])",
                "[0, 1, 2]",
                "Domyślny argument zapisuje bieżącą wartość i w chwili tworzenia lambdy.",
            ),
            choice(
                "Jak naprawić pułapkę lambda: i w pętli?",
                listOf("Użyć domyślnego argumentu: lambda i=i: i", "Dodać global i", "Użyć while zamiast for", "Nie da się"),
                0,
                "Wartość domyślna jest obliczana raz, przy tworzeniu funkcji.",
            ),
            output(
                "x = \"G\"\ndef a():\n    x = \"E\"\n    def b():\n        return x\n    return b()\nprint(a(), x)",
                "E G",
                "b widzi x z funkcji otaczającej; globalne x się nie zmienia.",
            ),
            output(
                "suma = 0\ndef dodaj(n):\n    global suma\n    suma += n\nfor k in [1, 2, 3]:\n    dodaj(k)\nprint(suma)",
                "6",
                "global pozwala sumować w zmiennej modułu.",
            ),
            fill(
                "Uzupełnij, aby każda funkcja zwracała swoją liczbę: [0, 1, 2].",
                "fs = [lambda ____: k for k in range(3)]\nprint([f() for f in fs])",
                listOf("k=k", "k", "k=0", "x=k"),
                "k=k",
                "k=k zapisuje bieżącą wartość k w każdej lambdzie.",
            ),
            choice(
                "Gdzie Python najpierw szuka nazwy użytej w funkcji?",
                listOf("W zasięgu lokalnym funkcji", "W modułach wbudowanych", "W zasięgu globalnym", "W ostatnio zaimportowanym module"),
                0,
                "L w LEGB to Local – szukanie zaczyna się lokalnie.",
            ),
        ),
    ),
)
