package com.mrpython.app.data.course

import com.mrpython.app.domain.CourseUnit

internal val module15 = CourseUnit(
    id = "u15",
    title = "Parametry funkcji",
    description = "Wartości domyślne, *args, **kwargs i rozpakowywanie",
    lessons = listOf(
        lesson(
            "u15l1", "Wartości domyślne",
            output(
                "def witaj(imie=\"gość\"):\n    print(\"Cześć,\", imie)\n\nwitaj()\nwitaj(\"Ola\")",
                "Cześć, gość\nCześć, Ola",
                "Gdy nie podamy argumentu, użyta zostaje wartość domyślna.",
            ),
            output(
                "def potega(x, n=2):\n    return x ** n\n\nprint(potega(3), potega(2, 3))",
                "9 8",
                "potega(3) używa n=2, a potega(2, 3) podaje n=3.",
            ),
            choice(
                "Która definicja jest błędna?",
                listOf("def f(a=1, b):", "def f(a, b=1):", "def f(a=1, b=2):", "def f(a, b):"),
                0,
                "Parametry z wartością domyślną muszą stać po parametrach bez niej.",
            ),
            output(
                "def dodaj(x, lista=[]):\n    lista.append(x)\n    return lista\n\nprint(dodaj(1))\nprint(dodaj(2))",
                "[1]\n[1, 2]",
                "Domyślna lista powstaje raz i jest wspólna dla wszystkich wywołań.",
            ),
            output(
                "def dodaj(x, lista=None):\n    if lista is None:\n        lista = []\n    lista.append(x)\n    return lista\n\nprint(dodaj(1))\nprint(dodaj(2))",
                "[1]\n[2]",
                "None jako wartość domyślna i nowa lista w środku funkcji rozwiązują problem.",
            ),
            choice(
                "Dlaczego lista=[] jako wartość domyślna jest niebezpieczna?",
                listOf(
                    "Lista powstaje raz i jest współdzielona przez wywołania",
                    "Pusta lista powoduje błąd składni",
                    "Listy nie mogą być parametrami",
                    "Lista jest kopiowana przy każdym wywołaniu",
                ),
                0,
                "Wartości domyślne są tworzone raz, przy definicji funkcji.",
            ),
            fill(
                "Uzupełnij, aby domyślnie dzielić przez 2.",
                "def podziel(x, d____):\n    return x / d\n\nprint(podziel(10))",
                listOf("=2", "==2", ":2"),
                "=2",
                "Wartość domyślną podajemy po znaku = w nagłówku funkcji.",
            ),
            tiles(
                "Zdefiniuj funkcję opis z parametrem wiek o domyślnej wartości 18",
                listOf("def", "opis(", "imie,", "wiek=18", "):"),
                listOf("wiek==18", "18=wiek"),
                "Wartość domyślną zapisujemy jako nazwa=wartość.",
            ),
        ),
        lesson(
            "u15l2", "Dowolnie wiele argumentów: *args",
            output(
                "def suma(*liczby):\n    return sum(liczby)\n\nprint(suma(1, 2, 3))",
                "6",
                "*liczby zbiera wszystkie argumenty w krotkę.",
            ),
            output("def f(*args):\n    print(args)\n\nf(1, \"a\")", "(1, 'a')", "args to krotka z przekazanymi argumentami."),
            output("def f(*args):\n    print(len(args))\n\nf()", "0", "Bez argumentów args to pusta krotka."),
            choice(
                "Jakiego typu jest args w funkcji def f(*args)?",
                listOf("Krotka", "Lista", "Słownik", "Zbiór"),
                0,
                "Argumenty zebrane przez * trafiają do krotki.",
            ),
            output(
                "def pierwszy(x, *reszta):\n    print(x, reszta)\n\npierwszy(1, 2, 3)",
                "1 (2, 3)",
                "Pierwszy argument trafia do x, pozostałe do reszta.",
            ),
            fill(
                "Uzupełnij, aby funkcja przyjmowała dowolną liczbę argumentów.",
                "def maks(____liczby):\n    return max(liczby)\n\nprint(maks(4, 9, 2))",
                listOf("*", "**", "&"),
                "*",
                "Jedna gwiazdka zbiera argumenty pozycyjne w krotkę.",
            ),
            choice(
                "Co wypisze ten kod?",
                listOf("a-b-c", "abc", "('a', 'b', 'c')", "Błąd"),
                0,
                "slowa to krotka napisów, a join() skleja je łącznikiem.",
                code = "def lacz(*slowa):\n    return \"-\".join(slowa)\n\nprint(lacz(\"a\", \"b\", \"c\"))",
            ),
            tiles(
                "Zdefiniuj funkcję srednia przyjmującą dowolnie wiele liczb",
                listOf("def", "srednia(", "*liczby", "):"),
                listOf("[liczby]", "def:"),
                "*liczby pozwala przekazać dowolną liczbę argumentów.",
            ),
        ),
        lesson(
            "u15l3", "Argumenty nazwane: **kwargs",
            output("def f(**kwargs):\n    print(kwargs)\n\nf(a=1, b=2)", "{'a': 1, 'b': 2}", "**kwargs zbiera argumenty nazwane w słownik."),
            output(
                "def profil(**dane):\n    for k, v in dane.items():\n        print(k, v)\n\nprofil(imie=\"Ala\", wiek=7)",
                "imie Ala\nwiek 7",
                "Nazwy argumentów stają się kluczami słownika.",
            ),
            choice(
                "Jakiego typu jest kwargs w funkcji def f(**kwargs)?",
                listOf("Słownik", "Krotka", "Lista", "Napis"),
                0,
                "Dwie gwiazdki zbierają pary nazwa=wartość w słownik.",
            ),
            output(
                "def f(a, **opcje):\n    print(a, len(opcje))\n\nf(1, x=2, y=3)",
                "1 2",
                "1 trafia do a, a x i y do słownika opcje.",
            ),
            choice(
                "Co się stanie?",
                listOf("Błąd TypeError", "Wypisze {1: 2}", "Wypisze (1, 2)", "Wypisze {}"),
                0,
                "**kw przyjmuje tylko argumenty nazwane, a 1 i 2 są pozycyjne.",
                code = "def f(**kw):\n    print(kw)\n\nf(1, 2)",
            ),
            fill(
                "Uzupełnij, aby funkcja przyjmowała dowolne argumenty nazwane.",
                "def ustaw(____opcje):\n    print(opcje)\n\nustaw(kolor=\"red\")",
                listOf("**", "*", "#"),
                "**",
                "Dwie gwiazdki zbierają argumenty nazwane.",
            ),
            output(
                "def f(*args, **kwargs):\n    print(args, kwargs)\n\nf(1, x=2)",
                "(1,) {'x': 2}",
                "Pozycyjne trafiają do args, nazwane do kwargs.",
            ),
            tiles(
                "Zdefiniuj funkcję zamowienie przyjmującą dowolne argumenty nazwane",
                listOf("def", "zamowienie(", "**dane", "):"),
                listOf("{dane}", "def:"),
                "**dane zbiera argumenty nazwane w słownik.",
            ),
        ),
        lesson(
            "u15l4", "Tylko nazwane i rozpakowywanie",
            output("def f(a, *, b):\n    print(a + b)\n\nf(1, b=2)", "3", "Parametr po * trzeba podać z nazwą: b=2."),
            choice(
                "Co się stanie?",
                listOf("Błąd TypeError", "Wypisze 3", "Wypisze 1 2", "Wypisze 1"),
                0,
                "b stoi po *, więc można go podać tylko jako b=…",
                code = "def f(a, *, b):\n    print(a + b)\n\nf(1, 2)",
            ),
            output(
                "def f(a, b, c):\n    print(a, b, c)\n\nlista = [1, 2, 3]\nf(*lista)",
                "1 2 3",
                "*lista rozpakowuje listę na osobne argumenty.",
            ),
            output(
                "def f(x, y):\n    print(x - y)\n\nd = {\"y\": 1, \"x\": 5}\nf(**d)",
                "4",
                "**d przekazuje x=5 i y=1 jako argumenty nazwane.",
            ),
            output("liczby = [3, 1, 2]\nprint(*liczby)", "3 1 2", "print(*liczby) to to samo co print(3, 1, 2)."),
            output("print(*\"abc\", sep=\"-\")", "a-b-c", "Napis też można rozpakować na pojedyncze znaki."),
            fill(
                "Uzupełnij, aby rozpakować słownik jako argumenty nazwane.",
                "def witaj(imie, wiek):\n    print(imie, wiek)\n\nd = {\"imie\": \"Ola\", \"wiek\": 9}\nwitaj(____d)",
                listOf("**", "*", "&"),
                "**",
                "** przekazuje pary klucz–wartość jako argumenty nazwane.",
            ),
            tiles(
                "Wywołaj f, przekazując elementy listy dane jako osobne argumenty",
                listOf("f(", "*dane", ")"),
                listOf("**dane", "dane[]"),
                "Jedna gwiazdka rozpakowuje listę na argumenty pozycyjne.",
            ),
        ),
        lesson(
            "u15l5", "Powtórka: parametry funkcji",
            output("def f(a, b=10):\n    return a + b\n\nprint(f(1), f(1, 1))", "11 2", "Bez drugiego argumentu b wynosi 10."),
            output("def f(*a):\n    return a[-1]\n\nprint(f(4, 5, 6))", "6", "a to krotka (4, 5, 6), a a[-1] to jej ostatni element."),
            output("def f(**k):\n    return list(k)\n\nprint(f(x=1, y=2))", "['x', 'y']", "list() ze słownika daje listę jego kluczy."),
            choice(
                "Która kolejność parametrów jest poprawna?",
                listOf("def f(a, b=1, *args, **kwargs):", "def f(**kwargs, *args, a):", "def f(*args, a=1, **kwargs, b):", "def f(b=1, a, **kwargs):"),
                0,
                "Kolejność: zwykłe, domyślne, *args, a na końcu **kwargs.",
            ),
            output(
                "def f(a, *, sep=\"/\"):\n    return sep.join(a)\n\nprint(f([\"a\", \"b\"], sep=\".\"))",
                "a.b",
                "sep jest tylko nazwany i tu wynosi \".\".",
            ),
            choice(
                "Co wypisze ten kod?",
                listOf("6", "(2, 3)", "5", "Błąd"),
                0,
                "*pkt rozpakowuje krotkę: pole(2, 3) = 6.",
                code = "def pole(a, b):\n    return a * b\n\npkt = (2, 3)\nprint(pole(*pkt))",
            ),
            fill(
                "Uzupełnij, aby uniknąć pułapki z domyślną listą.",
                "def f(x, lst=____):\n    if lst is None:\n        lst = []\n    lst.append(x)\n    return lst\n\nprint(f(1), f(2))",
                listOf("None", "[]", "0"),
                "None",
                "Z None każde wywołanie tworzy nową listę, więc wynik to [1] [2].",
            ),
            tiles(
                "Wywołaj funkcję f, przekazując słownik opcje jako argumenty nazwane",
                listOf("f(", "**opcje", ")"),
                listOf("*opcje", "opcje**"),
                "** rozpakowuje słownik na argumenty nazwane.",
            ),
        ),
    ),
)
