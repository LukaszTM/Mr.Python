package com.mrpython.app.data.course

import com.mrpython.app.domain.CourseUnit

internal val module63 = CourseUnit(
    id = "u63",
    title = "Tydzień powtórek: funkcje",
    description = "Parametry, lambdy, rekurencja, domknięcia i dekoratory",
    lessons = listOf(
        lesson(
            "u63l1", "Dzień 1: Parametry funkcji",
            output(
                "def opis(imie, wiek=18):\n    return f\"{imie}:{wiek}\"\nprint(opis(\"Ola\"))\nprint(opis(\"Jan\", wiek=30))",
                "Ola:18\nJan:30",
                "Gdy nie podamy wieku, użyta zostaje wartość domyślna 18.",
            ),
            choice(
                "Które wywołanie funkcji def f(a, b=2, c=3) jest błędne?",
                listOf("f(a=1, 2)", "f(1, c=5)", "f(1, 2, 3)", "f(c=1, a=2)"),
                0,
                "Argument pozycyjny nie może stać po argumencie nazwanym – to SyntaxError.",
            ),
            output(
                "def dodaj(x, lista=[]):\n    lista.append(x)\n    return lista\ndodaj(1)\nprint(dodaj(2))",
                "[1, 2]",
                "Domyślna lista powstaje raz i jest wspólna dla wszystkich wywołań.",
            ),
            fill(
                "Uzupełnij, aby parametr b dało się podać tylko po nazwie.",
                "def f(a, ____, b):\n    return a + b\nprint(f(1, b=2))",
                listOf("*", "**", "&"),
                "*",
                "Parametry po samej gwiazdce są tylko nazwane (keyword-only).",
            ),
            output(
                "def potega(podstawa, wykladnik=2):\n    return podstawa ** wykladnik\nprint(potega(wykladnik=3, podstawa=2))",
                "8",
                "Argumenty nazwane można podać w dowolnej kolejności: 2 ** 3 = 8.",
            ),
            tiles(
                "Zdefiniuj funkcję powitaj z parametrem imie o domyślnej wartości \"Gość\"",
                listOf("def", "powitaj(", "imie=\"Gość\"", "):"),
                listOf("imie==\"Gość\"", "return"),
                "Wartość domyślną zapisujemy jednym znakiem = w nagłówku funkcji.",
            ),
            choice(
                "Co wypisze ten program?",
                listOf("[2]", "[1, 2]", "None", "Błąd"),
                0,
                "Przy każdym wywołaniu bez listy powstaje nowa, pusta lista.",
                code = "def dodaj(x, lista=None):\n    if lista is None:\n        lista = []\n    lista.append(x)\n    return lista\ndodaj(1)\nprint(dodaj(2))",
            ),
            output(
                "def info(nazwa, *, cena):\n    print(nazwa, cena)\ntry:\n    info(\"chleb\", 5)\nexcept TypeError:\n    print(\"podaj cenę po nazwie\")",
                "podaj cenę po nazwie",
                "cena stoi po *, więc trzeba ją podać jako cena=5.",
            ),
        ),
        lesson(
            "u63l2", "Dzień 2: Wartości zwracane",
            output(
                "def min_max(liczby):\n    return min(liczby), max(liczby)\na, b = min_max([4, 1, 9])\nprint(a, b)",
                "1 9",
                "Funkcja zwraca krotkę, którą od razu rozpakowujemy do dwóch zmiennych.",
            ),
            output(
                "def pokaz(x):\n    print(x * 2)\nwynik = pokaz(3)\nprint(wynik)",
                "6\nNone",
                "pokaz() tylko wypisuje, a nic nie zwraca – wynik to None.",
            ),
            choice(
                "Co zwraca funkcja, która nie ma instrukcji return?",
                listOf("None", "0", "Pusty napis", "False"),
                0,
                "Bez return funkcja zwraca None.",
            ),
            output(
                "def znak(n):\n    if n > 0:\n        return \"+\"\n    if n < 0:\n        return \"-\"\n    return \"0\"\nprint(znak(-3) + znak(0) + znak(7))",
                "-0+",
                "return od razu kończy funkcję, więc sprawdzany jest tylko pierwszy pasujący warunek.",
            ),
            fill(
                "Uzupełnij, aby funkcja zwracała sumę i iloczyn.",
                "def oblicz(a, b):\n    ____ a + b, a * b\ns, i = oblicz(2, 5)\nprint(s, i)",
                listOf("return", "print", "yield"),
                "return",
                "return a + b, a * b zwraca krotkę dwóch wartości.",
            ),
            output(
                "def pierwsza_parzysta(liczby):\n    for n in liczby:\n        if n % 2 == 0:\n            return n\nprint(pierwsza_parzysta([3, 5, 8, 10]))\nprint(pierwsza_parzysta([1, 3]))",
                "8\nNone",
                "return przerywa pętlę; gdy nic nie znaleziono, funkcja zwraca None.",
            ),
            choice(
                "Co wypisze ten program?",
                listOf("1", "koniec, potem 1", "Nic", "Błąd"),
                0,
                "Kod po return nigdy się nie wykona.",
                code = "def f():\n    return 1\n    print(\"koniec\")\nprint(f())",
            ),
            tiles(
                "Zapisz w zmiennej wynik listę kwadratów liczb z listy dane",
                listOf("wynik", "=", "[x ** 2", "for x", "in dane]"),
                listOf("print(", "(x ** 2"),
                "Wyrażenie listowe w nawiasach kwadratowych tworzy nową listę.",
            ),
        ),
        lesson(
            "u63l3", "Dzień 3: *args i **kwargs",
            output(
                "def suma(*liczby):\n    return sum(liczby)\nprint(suma(1, 2, 3))\nprint(suma())",
                "6\n0",
                "*liczby zbiera wszystkie argumenty pozycyjne – także zero argumentów.",
            ),
            choice(
                "Jakiego typu jest args wewnątrz funkcji def f(*args)?",
                listOf("tuple (krotka)", "list (lista)", "dict (słownik)", "set (zbiór)"),
                0,
                "*args zbiera argumenty pozycyjne w krotkę.",
            ),
            output(
                "def profil(**dane):\n    for k, v in dane.items():\n        print(f\"{k}={v}\")\nprofil(imie=\"Ola\", wiek=20)",
                "imie=Ola\nwiek=20",
                "**dane zbiera argumenty nazwane w słownik.",
            ),
            output(
                "def trzy(a, b, c):\n    return a * 100 + b * 10 + c\nliczby = [1, 2, 3]\nprint(trzy(*liczby))",
                "123",
                "*liczby rozpakowuje listę na trzy osobne argumenty.",
            ),
            fill(
                "Uzupełnij, aby przekazać wartości ze słownika jako argumenty nazwane.",
                "def adres(miasto, ulica):\n    return f\"{ulica}, {miasto}\"\nd = {\"miasto\": \"Kraków\", \"ulica\": \"Długa\"}\nprint(adres(____d))",
                listOf("**", "*", "&"),
                "**",
                "**d zamienia pary klucz–wartość na argumenty nazwane; *d dałoby same klucze.",
            ),
            choice(
                "Która kolejność parametrów jest poprawna?",
                listOf("def f(a, *args, b=1, **kwargs)", "def f(**kwargs, *args, a)", "def f(*args, **kwargs, a)", "def f(a, **kwargs, *args)"),
                0,
                "**kwargs musi być ostatni, a *args stoi przed parametrami tylko nazwanymi.",
            ),
            output(
                "def f(a, *args, **kwargs):\n    print(a, args, kwargs)\nf(1, 2, 3, x=4)",
                "1 (2, 3) {'x': 4}",
                "Pierwszy argument trafia do a, reszta pozycyjnych do args, nazwane do kwargs.",
            ),
            tiles(
                "Zdefiniuj funkcję log przyjmującą dowolne argumenty pozycyjne i nazwane",
                listOf("def", "log(", "*args,", "**kwargs", "):"),
                listOf("**args", "&kwargs"),
                "Najpierw *args, potem **kwargs.",
            ),
        ),
        lesson(
            "u63l4", "Dzień 4: Lambda",
            choice(
                "Która lambda działa tak samo jak def f(x, y): return x * y?",
                listOf("lambda x, y: x * y", "lambda (x, y): x * y", "lambda x, y: return x * y", "lambda: x * y"),
                0,
                "W lambdzie nie piszemy return ani nawiasów wokół parametrów.",
            ),
            output(
                "osoby = [(\"Ola\", 25), (\"Jan\", 19), (\"Ewa\", 31)]\nosoby.sort(key=lambda o: o[1])\nprint(osoby[0][0])",
                "Jan",
                "Sortujemy po wieku, więc pierwszy jest najmłodszy Jan.",
            ),
            output(
                "liczby = [1, 2, 3, 4, 5, 6]\nparz = filter(lambda x: x % 2 == 0, liczby)\nprint(list(map(lambda x: x * 10, parz)))",
                "[20, 40, 60]",
                "filter zostawia parzyste, a map mnoży je przez 10.",
            ),
            choice(
                "Czego nie można umieścić w lambdzie?",
                listOf("Kilku instrukcji w ciele", "Kilku parametrów", "Wartości domyślnych parametrów", "Wyrażenia warunkowego x if c else y"),
                0,
                "Ciało lambdy to jedno wyrażenie.",
            ),
            fill(
                "Uzupełnij, aby znaleźć najdłuższe słowo.",
                "slowa = [\"kot\", \"żyrafa\", \"pies\"]\nprint(max(slowa, ____=lambda s: len(s)))",
                listOf("key", "by", "len"),
                "key",
                "Parametr key mówi, według czego porównywać elementy.",
            ),
            output(
                "ocena = lambda p: \"zal\" if p >= 50 else \"niezal\"\nprint(ocena(70), ocena(30))",
                "zal niezal",
                "W lambdzie można użyć wyrażenia warunkowego.",
            ),
            output(
                "slowa = [\"bb\", \"a\", \"ccc\", \"dd\"]\nprint(sorted(slowa, key=lambda s: (-len(s), s)))",
                "['ccc', 'bb', 'dd', 'a']",
                "Najpierw malejąco po długości (minus), a przy remisie alfabetycznie.",
            ),
            tiles(
                "Posortuj listę słów według ostatniej litery",
                listOf("slowa.sort(", "key=lambda s:", "s[-1]", ")"),
                listOf("s[0]", "reverse="),
                "s[-1] to ostatni znak słowa.",
            ),
        ),
        lesson(
            "u63l5", "Dzień 5: Rekurencja",
            output(
                "def silnia(n):\n    if n <= 1:\n        return 1\n    return n * silnia(n - 1)\nprint(silnia(5))",
                "120",
                "5 * 4 * 3 * 2 * 1 = 120.",
            ),
            output(
                "def suma_cyfr(n):\n    if n < 10:\n        return n\n    return n % 10 + suma_cyfr(n // 10)\nprint(suma_cyfr(4096))",
                "19",
                "4 + 0 + 9 + 6 = 19.",
            ),
            choice(
                "Czego brakuje tej funkcji?",
                listOf("Warunku stopu (przypadku bazowego)", "Instrukcji return na końcu", "Parametru domyślnego", "Niczego – działa poprawnie"),
                0,
                "Bez przypadku bazowego funkcja woła samą siebie bez końca (RecursionError).",
                code = "def odliczaj(n):\n    print(n)\n    odliczaj(n - 1)",
            ),
            output(
                "def odwroc(s):\n    if s == \"\":\n        return \"\"\n    return odwroc(s[1:]) + s[0]\nprint(odwroc(\"abc\"))",
                "cba",
                "Pierwsza litera trafia na koniec odwróconej reszty.",
            ),
            fill(
                "Uzupełnij warunek stopu, aby fib(7) dało 13.",
                "def fib(n):\n    if n < ____:\n        return n\n    return fib(n - 1) + fib(n - 2)\nprint(fib(7))",
                listOf("2", "0", "1"),
                "2",
                "fib(0) = 0 i fib(1) = 1 to przypadki bazowe, czyli n < 2.",
            ),
            output(
                "def splaszcz(x):\n    if not isinstance(x, list):\n        return [x]\n    wynik = []\n    for e in x:\n        wynik += splaszcz(e)\n    return wynik\nprint(splaszcz([1, [2, [3, 4]], 5]))",
                "[1, 2, 3, 4, 5]",
                "Każda podlista jest spłaszczana rekurencyjnie.",
            ),
            output(
                "def f(n):\n    if n == 0:\n        return\n    f(n - 1)\n    print(n)\nf(3)",
                "1\n2\n3",
                "print wykonuje się dopiero po powrocie z głębszych wywołań.",
            ),
            tiles(
                "Ułóż krok rekurencyjny: wynik to a razy potega(a, n - 1)",
                listOf("wynik", "=", "a *", "potega(a,", "n - 1)"),
                listOf("n + 1)", "print("),
                "a do n to a razy a do (n - 1).",
            ),
        ),
        lesson(
            "u63l6", "Dzień 6: Domknięcia i zasięg",
            output(
                "def mnoznik(k):\n    def f(x):\n        return x * k\n    return f\nrazy3 = mnoznik(3)\nprint(razy3(5))",
                "15",
                "Funkcja wewnętrzna pamięta k z funkcji, która ją utworzyła.",
            ),
            output(
                "def licznik():\n    n = 0\n    def dalej():\n        nonlocal n\n        n += 1\n        return n\n    return dalej\nc = licznik()\nc(); c()\nprint(c())",
                "3",
                "nonlocal pozwala zmieniać n z funkcji otaczającej.",
            ),
            choice(
                "Co się stanie po uruchomieniu?",
                listOf("UnboundLocalError", "Zwróci 1", "Zwróci 0", "Nic – n zostanie pominięte"),
                0,
                "Przypisanie n += 1 robi z n zmienną lokalną, a ona nie ma jeszcze wartości.",
                code = "def licznik():\n    n = 0\n    def dalej():\n        n += 1\n        return n\n    return dalej\nlicznik()()",
            ),
            output(
                "def licznik():\n    n = 0\n    def dalej():\n        nonlocal n\n        n += 1\n        return n\n    return dalej\na, b = licznik(), licznik()\na(); a()\nprint(a(), b())",
                "3 1",
                "Każde wywołanie licznik() tworzy osobne domknięcie z własnym n.",
            ),
            fill(
                "Uzupełnij, aby funkcja zmieniła zmienną x z poziomu modułu (program ma wypisać 20).",
                "x = 10\ndef zmien():\n    ____ x\n    x = 20\nzmien()\nprint(x)",
                listOf("global", "nonlocal", "local"),
                "global",
                "global odnosi się do zmiennej z poziomu modułu.",
            ),
            output(
                "funkcje = [lambda: i for i in range(3)]\nprint([f() for f in funkcje])",
                "[2, 2, 2]",
                "Lambdy odczytują i dopiero przy wywołaniu, gdy i ma już wartość 2.",
            ),
            output(
                "funkcje = [lambda i=i: i * 10 for i in range(3)]\nprint([f() for f in funkcje])",
                "[0, 10, 20]",
                "Wartość domyślna i=i zapamiętuje i w chwili tworzenia lambdy.",
            ),
            choice(
                "Gdzie Python szuka nazwy najpierw (reguła LEGB)?",
                listOf("W zasięgu lokalnym", "W zasięgu globalnym", "Wśród nazw wbudowanych", "W funkcji otaczającej"),
                0,
                "Kolejność: Local, Enclosing, Global, Built-in.",
            ),
        ),
        lesson(
            "u63l7", "Dzień 7: Dekoratory",
            output(
                "def glosno(f):\n    def w(*args):\n        return f(*args).upper()\n    return w\n@glosno\ndef witaj(imie):\n    return \"cześć \" + imie\nprint(witaj(\"ola\"))",
                "CZEŚĆ OLA",
                "Dekorator zamienia wynik funkcji na wielkie litery.",
            ),
            output(
                "def loguj(f):\n    def w():\n        print(\"przed\")\n        f()\n        print(\"po\")\n    return w\n@loguj\ndef praca():\n    print(\"pracuję\")\npraca()",
                "przed\npracuję\npo",
                "Funkcja opakowująca wykonuje kod przed i po oryginalnej funkcji.",
            ),
            choice(
                "Czemu odpowiada zapis @dekor nad def f?",
                listOf("f = dekor(f)", "f = f(dekor)", "dekor = f(dekor)", "f = dekor()"),
                0,
                "@dekor to skrót od przypisania f = dekor(f).",
            ),
            output(
                "def dodaj_a(f):\n    return lambda: f() + \"a\"\ndef dodaj_b(f):\n    return lambda: f() + \"b\"\n@dodaj_a\n@dodaj_b\ndef napis():\n    return \"x\"\nprint(napis())",
                "xba",
                "Najpierw działa dekorator najbliżej def (dodaj_b), potem dodaj_a.",
            ),
            fill(
                "Uzupełnij, aby udekorowana funkcja zachowała swoją nazwę (program ma wypisać oblicz).",
                "import functools\ndef dekor(f):\n    @functools.____(f)\n    def w(*a):\n        return f(*a)\n    return w\n@dekor\ndef oblicz():\n    pass\nprint(oblicz.__name__)",
                listOf("wraps", "cache", "partial"),
                "wraps",
                "functools.wraps kopiuje nazwę i opis oryginalnej funkcji.",
            ),
            output(
                "def powtorz(n):\n    def dekor(f):\n        def w():\n            for _ in range(n):\n                f()\n        return w\n    return dekor\n@powtorz(2)\ndef hej():\n    print(\"hej\")\nhej()",
                "hej\nhej",
                "powtorz(2) zwraca dekorator, który wywołuje funkcję 2 razy.",
            ),
            output(
                "def licz(f):\n    def w(*a):\n        w.ile += 1\n        return f(*a)\n    w.ile = 0\n    return w\n@licz\ndef kw(x):\n    return x * x\nkw(2); kw(3)\nprint(kw.ile)",
                "2",
                "Funkcja opakowująca liczy swoje wywołania w atrybucie ile.",
            ),
            tiles(
                "Owiń funkcję start dekoratorem zmierz bez użycia @",
                listOf("start", "=", "zmierz(", "start", ")"),
                listOf("start()", "@zmierz"),
                "@zmierz to to samo co start = zmierz(start).",
            ),
        ),
    ),
)
