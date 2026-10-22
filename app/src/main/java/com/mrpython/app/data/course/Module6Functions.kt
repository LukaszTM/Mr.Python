package com.mrpython.app.data.course

import com.mrpython.app.domain.CourseUnit

internal val module6 = CourseUnit(
    id = "u6",
    title = "Funkcje",
    description = "Twórz własne polecenia",
    lessons = listOf(
        lesson(
            "u6l1", "Definiowanie funkcji",
            choice(
                "Które słowo kluczowe definiuje funkcję?",
                listOf("def", "function", "fun", "func"),
                0,
                "Funkcje w Pythonie definiujemy słowem def.",
            ),
            output(
                "def przywitaj():\n    print(\"Cześć!\")\n\nprzywitaj()\nprzywitaj()",
                "Cześć!\nCześć!",
                "Funkcję wywołano dwa razy, więc tekst pojawi się dwukrotnie.",
            ),
            tiles(
                "Ułóż nagłówek funkcji dodaj z parametrami a i b",
                listOf("def", "dodaj(a, b)", ":"),
                listOf("function", "dodaj[a, b]"),
                "def nazwa(parametry): – z dwukropkiem na końcu.",
            ),
            output(
                "def podwoj(x):\n    return x * 2\n\nprint(podwoj(4))",
                "8",
                "return oddaje wynik funkcji.",
            ),
            fill(
                "Uzupełnij, aby funkcja zwracała kwadrat liczby.",
                "def kwadrat(x):\n    ____ x * x",
                listOf("return", "print", "give"),
                "return",
                "Wynik funkcji zwracamy słowem return.",
            ),
            output(
                "def hej(imie):\n    print(\"Hej, \" + imie)\n\nhej(\"Ala\")\nhej(\"Ola\")",
                "Hej, Ala\nHej, Ola",
                "Parametr imie przyjmuje przy każdym wywołaniu inną wartość.",
            ),
            choice(
                "Co wypisze ten kod?",
                listOf("B", "A B", "A", "Nic"),
                0,
                "Funkcja f nie została wywołana, więc „A” się nie wypisze.",
                code = "def f():\n    print(\"A\")\n\nprint(\"B\")",
            ),
        ),
        lesson(
            "u6l2", "Parametry i wynik",
            output(
                "def powitaj(imie=\"gościu\"):\n    return \"Hej, \" + imie\n\nprint(powitaj())\nprint(powitaj(\"Kuba\"))",
                "Hej, gościu\nHej, Kuba",
                "Parametr z wartością domyślną można pominąć przy wywołaniu.",
            ),
            choice(
                "Co wypisze ten kod?",
                listOf("None", "1", "0", "Błąd"),
                0,
                "Funkcja bez return zwraca None.",
                code = "def f():\n    x = 1\n\nprint(f())",
            ),
            output(
                "def maks(a, b):\n    if a > b:\n        return a\n    return b\n\nprint(maks(3, 9))",
                "9",
                "3 > 9 to fałsz, więc funkcja zwraca b.",
            ),
            output(
                "def suma_listy(lista):\n    s = 0\n    for e in lista:\n        s += e\n    return s\n\nprint(suma_listy([2, 4, 6]))",
                "12",
                "Funkcja dodaje kolejne elementy: 2 + 4 + 6.",
            ),
            choice(
                "Czym jest argument funkcji?",
                listOf(
                    "Wartością przekazaną do funkcji przy wywołaniu",
                    "Nazwą funkcji",
                    "Komentarzem w funkcji",
                    "Błędem w funkcji",
                ),
                0,
                "W podwoj(4) liczba 4 jest argumentem.",
            ),
            output("def pole(a, b):\n    return a * b\n\nprint(pole(3, 4) + 1)", "13", "Wynik funkcji można dalej używać w obliczeniach."),
            output(
                "def opis(imie, wiek):\n    return f\"{imie}: {wiek}\"\n\nprint(opis(wiek=7, imie=\"Ela\"))",
                "Ela: 7",
                "Argumenty nazwane można podać w dowolnej kolejności.",
            ),
        ),
        lesson(
            "u6l3", "Zasięg i kilka wyników",
            output(
                "def f():\n    x = 5\n    return x\n\nx = 1\nf()\nprint(x)",
                "1",
                "x wewnątrz funkcji to inna, lokalna zmienna.",
            ),
            choice(
                "Co się stanie?",
                listOf("Błąd NameError – y istnieje tylko w funkcji", "Wypisze 10", "Wypisze None", "Wypisze 0"),
                0,
                "Zmienne utworzone w funkcji nie są widoczne poza nią.",
                code = "def f():\n    y = 10\n\nf()\nprint(y)",
            ),
            output(
                "def min_max(lista):\n    return min(lista), max(lista)\n\na, b = min_max([4, 9, 1])\nprint(a, b)",
                "1 9",
                "Funkcja może zwrócić kilka wartości naraz.",
            ),
            output(
                "def kwadrat(x):\n    return x * x\n\ndef suma_kwadratow(a, b):\n    return kwadrat(a) + kwadrat(b)\n\nprint(suma_kwadratow(2, 3))",
                "13",
                "Funkcje mogą wywoływać inne funkcje: 4 + 9 = 13.",
            ),
            output(
                "def f(x):\n    if x > 0:\n        return \"plus\"\n    return \"minus\"\n\nprint(f(5))\nprint(f(-2))",
                "plus\nminus",
                "return od razu kończy funkcję.",
            ),
            output("def f():\n    print(\"A\")\n    return\n    print(\"B\")\n\nf()", "A", "Kod po return już się nie wykona."),
            fill(
                "Uzupełnij, aby funkcja zwracała dwie wartości.",
                "def dzielenie(a, b):\n    return a // b____ a % b\n\nprint(dzielenie(7, 2))",
                listOf(",", ":", "+"),
                ",",
                "Wartości oddzielone przecinkiem zostaną zwrócone razem: (3, 1).",
            ),
            tiles(
                "Zapisz wynik funkcji suma(2, 3) w zmiennej w",
                listOf("w", "=", "suma(2, 3)"),
                listOf("return", "def"),
                "Wynik funkcji przypisujemy do zmiennej znakiem =.",
            ),
        ),
        lesson(
            "u6l4", "Powtórka: funkcje",
            output("def f(n):\n    return n + 1\n\nprint(f(f(1)))", "3", "Najpierw f(1) = 2, potem f(2) = 3."),
            output(
                "def czy_parzysta(n):\n    return n % 2 == 0\n\nprint(czy_parzysta(4))\nprint(czy_parzysta(7))",
                "True\nFalse",
                "Funkcja może zwracać wartość logiczną.",
            ),
            choice(
                "Ile parametrów ma ta funkcja?",
                listOf("3", "2", "1", "0"),
                0,
                "imie, nazwisko i wiek – ostatni ma wartość domyślną, ale nadal jest parametrem.",
                code = "def przedstaw(imie, nazwisko, wiek=18):\n    pass",
            ),
            output(
                "def licz(lista, szukany):\n    ile = 0\n    for e in lista:\n        if e == szukany:\n            ile += 1\n    return ile\n\nprint(licz([1, 2, 1, 1], 1))",
                "3",
                "Funkcja liczy, ile razy element występuje na liście.",
            ),
            fill(
                "Uzupełnij definicję funkcji.",
                "____ powitanie():\n    return \"Cześć\"\n\nprint(powitanie())",
                listOf("def", "fun", "function"),
                "def",
                "Każda funkcja zaczyna się od słowa def.",
            ),
            output(
                "def odwroc(s):\n    wynik = \"\"\n    for z in s:\n        wynik = z + wynik\n    return wynik\n\nprint(odwroc(\"abc\"))",
                "cba",
                "Każda kolejna litera trafia na początek wyniku.",
            ),
            output("def f(a, b=2):\n    return a ** b\n\nprint(f(3))\nprint(f(2, 3))", "9\n8", "3² = 9, a 2³ = 8."),
            output(
                "def silnia(n):\n    wynik = 1\n    for i in range(2, n + 1):\n        wynik *= i\n    return wynik\n\nprint(silnia(5))",
                "120",
                "5! = 1 · 2 · 3 · 4 · 5 = 120.",
            ),
        ),
    ),
)
