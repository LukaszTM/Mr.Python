package com.mrpython.app.data.course

internal val module6Cards = listOf(
    cards(
        "u6l1",
        explain(
            "Definicja to nie wywołanie",
            "Sama definicja `def` nic nie robi – tylko zapamiętuje funkcję. Kod z jej wnętrza wykona się " +
                "dopiero przy wywołaniu, dokładnie w tym miejscu programu.",
            code = "def linia():\n    print(\"---\")\n\nprint(\"Start\")\nlinia()",
            output = "Start\n---",
        ),
        explain(
            "return czy print?",
            "`print()` tylko pokazuje coś na ekranie. `return` oddaje wynik do miejsca wywołania – można " +
                "go zapisać w zmiennej i dalej z nim liczyć.",
            code = "def razy3(x):\n    return x * 3\n\nw = razy3(2) + 1\nprint(w)",
            output = "7",
        ),
        explain(
            "Funkcja w jednej linii",
            "Gdy funkcja ma tylko jedno polecenie, można je zapisać po dwukropku w tej samej linii – " +
                "tak jak w pętli.",
            code = "def dodaj(a, b): return a + b\n\nprint(dodaj(2, 3))",
            output = "5",
        ),
    ),
    cards(
        "u6l2",
        explain(
            "Funkcja bez return",
            "Funkcja, która nie ma `return`, i tak coś zwraca – wartość `None`. Jeśli funkcja tylko " +
                "wypisuje tekst, jej wynikiem jest właśnie `None`.",
            code = "def hej():\n    print(\"Hej\")\n\nw = hej()\nprint(w)",
            output = "Hej\nNone",
        ),
        explain(
            "Brakujący argument",
            "Parametr bez wartości domyślnej trzeba podać przy wywołaniu – inaczej Python zgłosi błąd. " +
                "Parametr z wartością domyślną nadal jest parametrem, tylko można go pominąć.",
            code = "def pole(a, b=2):\n    return a * b\n\nprint(pole(5))\nprint(pole(5, 3))",
            output = "10\n15",
        ),
        explain(
            "return w if",
            "`return` od razu kończy funkcję. Dlatego po `if` z `return` można napisać drugi `return` " +
                "bez `else` – wykona się tylko wtedy, gdy warunek był fałszywy.",
            code = "def dodatnia(n):\n    if n < 0:\n        return -n\n    return n\n\nprint(dodatnia(-4))",
            output = "4",
        ),
    ),
    cards(
        "u6l3",
        explain(
            "Ta sama nazwa, dwie zmienne",
            "Zmienna utworzona w funkcji jest lokalna – nawet gdy nazywa się tak samo jak zmienna poza " +
                "funkcją, to inna zmienna i zewnętrzna się nie zmienia. Poza funkcją lokalnej nie ma (`NameError`).",
            code = "x = 1\ndef f():\n    x = 50\n    print(x)\nf()\nprint(x)",
            output = "50\n1",
        ),
        explain(
            "Funkcja wywołuje funkcję",
            "Funkcja może użyć innej funkcji, a wynik jednego wywołania może być argumentem drugiego. " +
                "W `f(f(1))` Python najpierw liczy wewnętrzne `f(1)`.",
            code = "def plus2(n):\n    return n + 2\n\nprint(plus2(plus2(1)))",
            output = "5",
        ),
        explain(
            "Kilka wyników w nawiasach",
            "Gdy funkcja zwraca kilka wartości, a nie rozpakujesz ich do zmiennych, dostaniesz je razem " +
                "w nawiasach okrągłych, np. `(3, 1)`.",
            code = "def dwie():\n    return 3, 1\n\nprint(dwie())",
            output = "(3, 1)",
        ),
    ),
    cards(
        "u6l4",
        explain(
            "Puste miejsce: pass",
            "`pass` oznacza „nic nie rób”. Wstawiamy je tam, gdzie Python wymaga bloku, a nie mamy " +
                "jeszcze kodu – np. w pustej funkcji.",
            code = "def pozniej():\n    pass\n\nprint(pozniej())",
            output = "None",
        ),
    ),
)
