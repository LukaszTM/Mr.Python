package com.mrpython.app.data.course

internal val module2Cards = listOf(
    cards(
        "u2l1",
        explain(
            "Zasady nazw zmiennych",
            "Nazwa zmiennej może mieć litery, cyfry i podkreślnik `_`, ale nie może zaczynać się od cyfry " +
                "ani zawierać spacji czy myślnika. Wielkość liter ma znaczenie: `imie` i `Imie` to dwie różne zmienne.",
            code = "liczba_punktow = 5\nwiek2 = 9\nprint(liczba_punktow, wiek2)",
            output = "5 9",
        ),
        explain(
            "Skróty -= i *=",
            "Tak jak `+=`, działają też `-=` (odejmij) i `*=` (pomnóż): `x -= 2` znaczy `x = x - 2`. " +
                "`+=` działa również na napisach – dokleja tekst na końcu.",
            code = "x = 10\nx -= 4\nx *= 2\ns = \"Py\"\ns += \"thon\"\nprint(x, s)",
            output = "12 Python",
        ),
        explain(
            "Przypisanie kopiuje wartość",
            "`b = a` zapisuje w `b` obecną wartość `a`. Gdy później zmienisz `a`, `b` zostaje takie, jakie było. " +
                "`print(b)` wypisuje wartość zmiennej, a nie jej nazwę.",
            code = "a = 1\nb = a\na = 7\nprint(a, b)",
            output = "7 1",
        ),
    ),
    cards(
        "u2l2",
        explain(
            "int() obcina, nie zaokrągla",
            "`int()` z liczby z kropką po prostu odcina część po przecinku: `int(3.9)` to 3. Napis zamieni " +
                "na liczbę tylko wtedy, gdy wygląda jak liczba całkowita – `int(\"abc\")` kończy się błędem.",
            code = "print(int(3.9))\nprint(int(\"12\") + 1)",
            output = "3\n13",
        ),
        explain(
            "float() i dzielenie",
            "`float()` zamienia wartość na liczbę z kropką. Dzielenie `/` zawsze daje `float`, nawet gdy " +
                "dzieli się bez reszty. Działanie, w którym bierze udział `float`, też daje `float`.",
            code = "print(float(3))\nprint(10 / 2)\nprint(type(2 * 1.0))",
            output = "3.0\n5.0\n<class 'float'>",
        ),
    ),
    cards(
        "u2l3",
        explain(
            "Obliczenia w klamrach",
            "W klamrach f-stringa możesz wpisać dowolne wyrażenie, np. działanie – Python je obliczy. " +
                "Bez litery `f` klamry są zwykłym tekstem i wypiszą się tak, jak stoją.",
            code = "x = 3\nprint(f\"{x} * 2 = {x * 2}\")\nprint(\"{x}\")",
            output = "3 * 2 = 6\n{x}",
        ),
        explain(
            "Podpowiedź w input()",
            "Tekst w nawiasach `input(\"Imię: \")` to podpowiedź, którą zobaczy użytkownik. To, co wpisze, " +
                "zapisujemy w zmiennej znakiem `=`.",
            code = "imie = input(\"Imię: \")\nprint(f\"Hej, {imie}!\")",
        ),
        explain(
            "Liczba z input()",
            "`input()` zawsze daje napis, więc `input() + 1` kończy się błędem – nie można dodać napisu " +
                "i liczby. Najpierw zamień tekst na liczbę: `int(input())`.",
            code = "x = int(input(\"Liczba: \"))\nprint(x + 1)",
        ),
    ),
    cards(
        "u2l4",
        explain(
            "Zaokrąglanie: round()",
            "`round(x)` zaokrągla liczbę do całkowitej, a `round(x, 2)` – do 2 miejsc po przecinku. " +
                "Drugi argument mówi, ile cyfr zostawić po kropce.",
            code = "print(round(2.7))\nprint(round(3.14159, 2))\nprint(round(4.567, 1))",
            output = "3\n3.14\n4.6",
        ),
        explain(
            "Co jest fałszywe?",
            "Fałszywe są: `0`, `0.0`, pusty napis `\"\"` i `None`. Wszystko inne jest prawdziwe – także " +
                "napis `\"0\"`, napis ze spacją i napis `\"False\"`, bo nie są puste.",
            code = "print(bool(None))\nprint(bool(\"0\"))\nprint(bool(-3))",
            output = "False\nTrue\nTrue",
        ),
        explain(
            "Typ wartości None",
            "`None` ma własny typ – `NoneType`. Piszemy je bez cudzysłowu: `\"None\"` w cudzysłowie " +
                "to zwykły napis.",
            code = "x = None\nprint(type(x))",
            output = "<class 'NoneType'>",
        ),
    ),
    cards(
        "u2l5",
        explain(
            "Zamiana miejscami",
            "Możesz przypisać kilka wartości naraz: `a, b = 1, 2`. Zapis `a, b = b, a` zamienia wartości " +
                "zmiennych miejscami – bez dodatkowej zmiennej.",
            code = "a, b = 1, 2\na, b = b, a\nprint(a, b)",
            output = "2 1",
        ),
    ),
)
