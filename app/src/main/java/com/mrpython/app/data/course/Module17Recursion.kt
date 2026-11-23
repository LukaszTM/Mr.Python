package com.mrpython.app.data.course

import com.mrpython.app.domain.CourseUnit

internal val module17 = CourseUnit(
    id = "u17",
    title = "Rekurencja",
    description = "Funkcje, które wywołują same siebie",
    lessons = listOf(
        lesson(
            "u17l1", "Idea rekurencji",
            output(
                "def odliczaj(n):\n    if n == 0:\n        print(\"Start!\")\n        return\n    print(n)\n    odliczaj(n - 1)\n\nodliczaj(2)",
                "2\n1\nStart!",
                "Funkcja wywołuje samą siebie z mniejszym n, aż dojdzie do 0.",
            ),
            choice(
                "Czym jest warunek stopu w rekurencji?",
                listOf(
                    "Przypadkiem, w którym funkcja kończy się bez wywołania samej siebie",
                    "Instrukcją break w pętli",
                    "Pierwszym wywołaniem funkcji",
                    "Błędem, który zatrzymuje program",
                ),
                0,
                "Bez warunku stopu funkcja wywoływałaby się w nieskończoność.",
            ),
            choice(
                "Co się stanie po uruchomieniu?",
                listOf("Błąd RecursionError", "Wypisze 0", "Program zwróci 3", "Nic, funkcja się zakończy"),
                0,
                "Brak warunku stopu – wywołań jest za dużo i Python przerywa program.",
                code = "def f(n):\n    return f(n - 1)\n\nf(3)",
            ),
            output(
                "def silnia(n):\n    if n <= 1:\n        return 1\n    return n * silnia(n - 1)\n\nprint(silnia(4))",
                "24",
                "silnia(4) = 4 * 3 * 2 * 1 = 24.",
            ),
            output(
                "def f(n):\n    if n == 0:\n        return\n    f(n - 1)\n    print(n)\n\nf(3)",
                "1\n2\n3",
                "print wykonuje się po powrocie z wywołania, więc liczby idą rosnąco.",
            ),
            fill(
                "Uzupełnij warunek stopu, aby silnia(3) dała 6.",
                "def silnia(n):\n    if n ____ 1:\n        return 1\n    return n * silnia(n - 1)\n\nprint(silnia(3))",
                listOf("<=", ">=", "!="),
                "<=",
                "Rekurencja kończy się, gdy n spadnie do 1.",
            ),
            output(
                "def suma(n):\n    if n == 0:\n        return 0\n    return n + suma(n - 1)\n\nprint(suma(4))",
                "10",
                "suma(4) = 4 + 3 + 2 + 1 + 0 = 10.",
            ),
            tiles(
                "Zapisz w wynik iloczyn n i silni z n - 1",
                listOf("wynik", "=", "n *", "silnia(n - 1)"),
                listOf("silnia(n)", "+"),
                "Krok rekurencyjny silni to n * silnia(n - 1).",
            ),
        ),
        lesson(
            "u17l2", "Potęgi, cyfry i Fibonacci",
            output(
                "def fib(n):\n    if n < 2:\n        return n\n    return fib(n - 1) + fib(n - 2)\n\nprint(fib(6))",
                "8",
                "Ciąg Fibonacciego: 0, 1, 1, 2, 3, 5, 8.",
            ),
            output(
                "def fib(n):\n    if n < 2:\n        return n\n    return fib(n - 1) + fib(n - 2)\n\nprint([fib(i) for i in range(6)])",
                "[0, 1, 1, 2, 3, 5]",
                "Każdy wyraz to suma dwóch poprzednich.",
            ),
            choice(
                "Dlaczego rekurencyjne fib(35) liczy się bardzo wolno?",
                listOf(
                    "Te same wartości są liczone wiele razy",
                    "Python nie umie dodawać dużych liczb",
                    "Brakuje warunku stopu",
                    "Rekurencja zawsze jest wolna",
                ),
                0,
                "fib(n) woła fib(n - 1) i fib(n - 2), które powtarzają te same obliczenia.",
            ),
            output(
                "def potega(a, n):\n    if n == 0:\n        return 1\n    return a * potega(a, n - 1)\n\nprint(potega(2, 5))",
                "32",
                "2 mnożone 5 razy daje 32.",
            ),
            choice(
                "Co wypisze ten kod?",
                listOf("10", "1234", "4", "24"),
                0,
                "Funkcja sumuje cyfry: 4 + 3 + 2 + 1 = 10.",
                code = "def cyfry(n):\n    if n < 10:\n        return n\n    return n % 10 + cyfry(n // 10)\n\nprint(cyfry(1234))",
            ),
            fill(
                "Uzupełnij, aby funkcja liczyła sumę 1 + 2 + … + n.",
                "def suma(n):\n    if n == 0:\n        return 0\n    return n + suma(____)\n\nprint(suma(3))",
                listOf("n - 1", "n", "n + 1"),
                "n - 1",
                "Każde wywołanie musi zbliżać się do warunku stopu n == 0.",
            ),
            output(
                "def f(n):\n    print(n)\n    if n > 1:\n        f(n // 2)\n\nf(8)",
                "8\n4\n2\n1",
                "Każde wywołanie dzieli n przez 2, aż n dojdzie do 1.",
            ),
            tiles(
                "Zapisz w wynik krok rekurencyjny ciągu Fibonacciego",
                listOf("wynik", "=", "fib(n - 1)", "+", "fib(n - 2)"),
                listOf("*", "fib(n)"),
                "Wyraz ciągu to suma dwóch poprzednich wyrazów.",
            ),
        ),
        lesson(
            "u17l3", "Rekurencja na napisach i listach",
            output(
                "def odwroc(s):\n    if s == \"\":\n        return \"\"\n    return odwroc(s[1:]) + s[0]\n\nprint(odwroc(\"kot\"))",
                "tok",
                "Pierwszy znak trafia na koniec odwróconej reszty.",
            ),
            output(
                "def suma(lista):\n    if not lista:\n        return 0\n    return lista[0] + suma(lista[1:])\n\nprint(suma([2, 4, 6]))",
                "12",
                "Pierwszy element plus suma reszty listy.",
            ),
            output(
                "def pal(s):\n    if len(s) < 2:\n        return True\n    if s[0] != s[-1]:\n        return False\n    return pal(s[1:-1])\n\nprint(pal(\"kajak\"), pal(\"kot\"))",
                "True False",
                "Porównujemy skrajne znaki i sprawdzamy środek napisu.",
            ),
            choice(
                "Co wypisze ten kod?",
                listOf("3", "0", "24", "Błąd"),
                0,
                "Każde wywołanie dodaje 1 i skraca listę o jeden element.",
                code = "def dl(lista):\n    if lista == []:\n        return 0\n    return 1 + dl(lista[1:])\n\nprint(dl([7, 8, 9]))",
            ),
            choice(
                "Po co w rekurencji na napisach używamy s[1:]?",
                listOf(
                    "Aby zmniejszyć problem – bierzemy napis bez pierwszego znaku",
                    "Aby odwrócić napis",
                    "Aby skopiować cały napis",
                    "Aby usunąć ostatni znak",
                ),
                0,
                "Każde wywołanie dostaje krótszy napis, aż dojdzie do pustego.",
            ),
            fill(
                "Uzupełnij, aby funkcja zliczała litery „a”.",
                "def ile_a(s):\n    if s == \"\":\n        return 0\n    jest = 1 if s[0] == \"a\" else 0\n    return jest + ile_a(____)\n\nprint(ile_a(\"banan\"))",
                listOf("s[1:]", "s", "s[0]"),
                "s[1:]",
                "Wywołujemy funkcję dla reszty napisu, bez pierwszego znaku.",
            ),
            output(
                "def maks(l):\n    if len(l) == 1:\n        return l[0]\n    m = maks(l[1:])\n    return l[0] if l[0] > m else m\n\nprint(maks([3, 8, 2]))",
                "8",
                "Porównujemy pierwszy element z największym elementem reszty.",
            ),
            tiles(
                "Zapisz w wynik odwróconą resztę napisu z doklejonym pierwszym znakiem",
                listOf("wynik", "=", "odwroc(s[1:])", "+", "s[0]"),
                listOf("s[1:]", "odwroc(s)"),
                "Odwracamy resztę napisu i dopisujemy na końcu pierwszy znak.",
            ),
        ),
        lesson(
            "u17l4", "Głębokość rekurencji i pętle",
            choice(
                "Kiedy Python zgłasza RecursionError?",
                listOf(
                    "Gdy zagnieżdżonych wywołań jest za dużo",
                    "Gdy funkcja nic nie zwraca",
                    "Gdy funkcja ma za dużo parametrów",
                    "Gdy pętla trwa zbyt długo",
                ),
                0,
                "Python ma limit głębokości rekurencji, który chroni przed zawieszeniem.",
            ),
            choice(
                "Jaki jest domyślny limit głębokości rekurencji w Pythonie?",
                listOf("Około 1000", "10", "Nie ma limitu", "Około miliona"),
                0,
                "Domyślnie Python pozwala na około 1000 zagnieżdżonych wywołań.",
            ),
            output(
                "def f(n):\n    return f(n + 1)\n\ntry:\n    f(0)\nexcept RecursionError:\n    print(\"za głęboko\")",
                "za głęboko",
                "RecursionError można przechwycić jak każdy inny wyjątek.",
            ),
            output("wynik = 1\nfor i in range(1, 5):\n    wynik *= i\nprint(wynik)", "24", "Silnię można też policzyć zwykłą pętlą."),
            choice(
                "Kiedy lepiej użyć pętli zamiast rekurencji?",
                listOf(
                    "Gdy liczba kroków może być bardzo duża, np. 100 000",
                    "Gdy dane są krótkim napisem",
                    "Nigdy – rekurencja jest zawsze lepsza",
                    "Gdy funkcja ma warunek stopu",
                ),
                0,
                "Głęboka rekurencja przekroczy limit, a pętla nie ma takiego ograniczenia.",
            ),
            output(
                "a, b = 0, 1\nfor _ in range(6):\n    a, b = b, a + b\nprint(a)",
                "8",
                "Pętla liczy fib(6) szybko, bez powtarzania obliczeń.",
            ),
            fill(
                "Uzupełnij, aby pętla obliczyła 1 + 2 + 3 + 4.",
                "wynik = 0\nfor i in range(____):\n    wynik += i\nprint(wynik)",
                listOf("5", "4", "1, 4"),
                "5",
                "range(5) daje 0–4, a ich suma to 10.",
            ),
            output(
                "def gleb(n):\n    if n == 0:\n        return 1\n    return 1 + gleb(n - 1)\n\nprint(gleb(5))",
                "6",
                "Wywołania dla n = 5, 4, 3, 2, 1, 0 – razem 6.",
            ),
        ),
        lesson(
            "u17l5", "Powtórka: rekurencja",
            output(
                "def f(n):\n    if n <= 0:\n        return 0\n    return 2 + f(n - 1)\n\nprint(f(3))",
                "6",
                "Trzy wywołania dodają po 2.",
            ),
            output(
                "def p(s):\n    if not s:\n        return\n    print(s)\n    p(s[1:])\n\np(\"abc\")",
                "abc\nbc\nc",
                "Każde wywołanie wypisuje napis i skraca go o pierwszy znak.",
            ),
            choice(
                "Czego brakuje w tej funkcji?",
                listOf("Warunku stopu", "Parametru", "Pętli for", "Nic, jest poprawna"),
                0,
                "Bez warunku stopu silnia wywołuje się w nieskończoność.",
                code = "def silnia(n):\n    return n * silnia(n - 1)",
            ),
            output(
                "def ile(n):\n    if n < 10:\n        return 1\n    return 1 + ile(n // 10)\n\nprint(ile(12345))",
                "5",
                "Funkcja liczy cyfry: każde wywołanie odcina jedną.",
            ),
            choice(
                "Co wypisze ten kod?",
                listOf("24", "9", "0", "Błąd"),
                0,
                "2 * 3 * 4 * 1 = 24 – dla pustej listy zwracamy 1.",
                code = "def mnoz(lista):\n    if not lista:\n        return 1\n    return lista[0] * mnoz(lista[1:])\n\nprint(mnoz([2, 3, 4]))",
            ),
            fill(
                "Uzupełnij warunek stopu, aby program wypisał 2 i 1.",
                "def odlicz(n):\n    if n ____ 0:\n        return\n    print(n)\n    odlicz(n - 1)\n\nodlicz(2)",
                listOf("==", "!=", ">"),
                "==",
                "Funkcja ma się zatrzymać dopiero, gdy n dojdzie do 0.",
            ),
            choice(
                "Co zwykle szybciej obliczy 30. wyraz ciągu Fibonacciego?",
                listOf("Pętla", "Prosta rekurencja", "Obie są równie szybkie", "Żadna nie da rady"),
                0,
                "Prosta rekurencja wiele razy liczy te same wartości.",
            ),
            tiles(
                "Zapisz w wynik sumę pierwszego elementu i sumy reszty listy",
                listOf("wynik", "=", "lista[0]", "+", "suma(lista[1:])"),
                listOf("suma(lista)", "lista[1:]"),
                "Krok rekurencyjny: pierwszy element plus suma reszty.",
            ),
        ),
    ),
)
