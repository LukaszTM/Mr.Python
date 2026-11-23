package com.mrpython.app.data.course

import com.mrpython.app.domain.CourseUnit

internal val module41 = CourseUnit(
    id = "u41",
    title = "Dekoratory",
    description = "Funkcje jako obiekty, dekoratory i ich łączenie",
    lessons = listOf(
        lesson(
            "u41l1", "Funkcje jako obiekty",
            output(
                "def hej():\n    return \"hej!\"\nf = hej\nprint(f())",
                "hej!",
                "Funkcję można przypisać do zmiennej i wywołać przez nową nazwę.",
            ),
            output(
                "def podwoj(x):\n    return x * 2\ndef zastosuj(f, w):\n    return f(w)\nprint(zastosuj(podwoj, 7))",
                "14",
                "Funkcję można przekazać jako argument do innej funkcji.",
            ),
            choice(
                "Czym różni się hej od hej()?",
                listOf("hej to sama funkcja, hej() to jej wywołanie", "Niczym", "hej() to sama funkcja", "hej to błąd składni"),
                0,
                "Nawiasy wywołują funkcję; bez nich mamy obiekt funkcji.",
            ),
            output(
                "def a():\n    return 1\ndef b():\n    return 2\nfor f in [a, b]:\n    print(f())",
                "1\n2",
                "Funkcje można trzymać w liście jak inne obiekty.",
            ),
            output(
                "def zrob():\n    def wew():\n        return \"środek\"\n    return wew\ng = zrob()\nprint(g())",
                "środek",
                "Funkcja może zwrócić funkcję zdefiniowaną w swoim wnętrzu.",
            ),
            fill(
                "Uzupełnij, aby funkcja zwracała funkcję wew (nie jej wynik).",
                "def zrob():\n    def wew():\n        return 5\n    return ____\nprint(zrob()())",
                listOf("wew", "wew()", "zrob", "5"),
                "wew",
                "Zwracamy obiekt funkcji, bez nawiasów.",
            ),
            output(
                "def zewn():\n    def wew():\n        print(\"B\")\n    print(\"A\")\n    wew()\nzewn()",
                "A\nB",
                "Funkcja wewnętrzna działa dopiero, gdy ją wywołamy.",
            ),
            tiles(
                "Przypisz funkcję print do zmiennej p (bez wywoływania)",
                listOf("p", "=", "print"),
                listOf("print(", ")"),
                "Bez nawiasów przypisujemy samą funkcję.",
            ),
        ),
        lesson(
            "u41l2", "Pierwszy dekorator",
            output(
                "def ozdob(f):\n    def wrapper():\n        print(\"przed\")\n        f()\n        print(\"po\")\n    return wrapper\ndef hej():\n    print(\"hej\")\nhej = ozdob(hej)\nhej()",
                "przed\nhej\npo",
                "Dekorator opakowuje funkcję w nowe zachowanie.",
            ),
            choice(
                "Czym jest dekorator?",
                listOf("Funkcją, która przyjmuje funkcję i zwraca nową funkcję", "Specjalną klasą Pythona", "Komentarzem nad funkcją", "Sposobem na import modułu"),
                0,
                "Dekorator dostaje funkcję i zwraca jej ulepszoną wersję.",
            ),
            output(
                "def glosno(f):\n    def wrapper():\n        return f().upper()\n    return wrapper\ndef hej():\n    return \"hej\"\nhej = glosno(hej)\nprint(hej())",
                "HEJ",
                "wrapper zmienia wynik oryginalnej funkcji.",
            ),
            output(
                "def ozdob(f):\n    print(\"dekoruję\")\n    return f\ndef g():\n    print(\"g\")\ng = ozdob(g)\ng()",
                "dekoruję\ng",
                "Kod dekoratora wykonuje się w chwili dekorowania, a g później.",
            ),
            fill(
                "Uzupełnij, aby dekorator zwracał funkcję opakowującą.",
                "def ozdob(f):\n    def wrapper():\n        print(\"*\")\n        f()\n    return ____\ndef hej():\n    print(\"hej\")\nhej = ozdob(hej)\nhej()",
                listOf("wrapper", "wrapper()", "f()", "None"),
                "wrapper",
                "Dekorator zwraca funkcję wrapper, nie jej wynik.",
            ),
            output(
                "def dwa_razy(f):\n    def wrapper():\n        f()\n        f()\n    return wrapper\ndef hej():\n    print(\"hej\")\nhej = dwa_razy(hej)\nhej()",
                "hej\nhej",
                "wrapper wywołuje oryginał dwa razy.",
            ),
            choice(
                "Co trzeba zrobić, aby wrapper zwracał wynik f?",
                listOf("Napisać return f()", "Nic – zwraca go sam", "Napisać print(f())", "Napisać yield f"),
                0,
                "Bez return wrapper zwróciłby None.",
            ),
        ),
        lesson(
            "u41l3", "Składnia @",
            output(
                "def ozdob(f):\n    def wrapper():\n        return \"[\" + f() + \"]\"\n    return wrapper\n@ozdob\ndef imie():\n    return \"Ola\"\nprint(imie())",
                "[Ola]",
                "@ozdob nad def to skrót od imie = ozdob(imie).",
            ),
            choice(
                "Któremu zapisowi odpowiada @ozdob nad def hej()?",
                listOf("hej = ozdob(hej)", "ozdob = hej(ozdob)", "hej = ozdob()", "hej(ozdob)"),
                0,
                "Składnia @ to tylko wygodniejszy zapis tego przypisania.",
            ),
            output(
                "def log(f):\n    def wrapper(*args):\n        print(\"wywołanie\", args)\n        return f(*args)\n    return wrapper\n@log\ndef suma(a, b):\n    return a + b\nprint(suma(2, 3))",
                "wywołanie (2, 3)\n5",
                "*args przekazuje dowolne argumenty do oryginału.",
            ),
            fill(
                "Uzupełnij, aby wrapper przyjmował dowolne argumenty.",
                "def log(f):\n    def wrapper(____):\n        return f(*args)\n    return wrapper\n@log\ndef kw(x):\n    return x * x\nprint(kw(4))",
                listOf("*args", "args", "x, y", "args=0"),
                "*args",
                "*args zbiera wszystkie argumenty pozycyjne w krotkę.",
            ),
            output(
                "def licznik(f):\n    def wrapper():\n        wrapper.ile += 1\n        return f()\n    wrapper.ile = 0\n    return wrapper\n@licznik\ndef hej():\n    pass\nhej()\nhej()\nprint(hej.ile)",
                "2",
                "Funkcja to obiekt, więc może mieć własne atrybuty.",
            ),
            output(
                "def zero_gdy_ujemne(f):\n    def wrapper(x):\n        w = f(x)\n        return w if w > 0 else 0\n    return wrapper\n@zero_gdy_ujemne\ndef minus5(x):\n    return x - 5\nprint(minus5(3), minus5(9))",
                "0 4",
                "Dekorator poprawia wynik: -2 zamienia na 0.",
            ),
            tiles(
                "Udekoruj funkcję hej dekoratorem log bez użycia @",
                listOf("hej", "=", "log(", "hej", ")"),
                listOf("hej()", "@log"),
                "@log nad def to skrót od hej = log(hej).",
            ),
        ),
        lesson(
            "u41l4", "Dekorator z argumentami i łączenie",
            output(
                "def powtorz(n):\n    def dekorator(f):\n        def wrapper():\n            for _ in range(n):\n                f()\n        return wrapper\n    return dekorator\n@powtorz(3)\ndef hej():\n    print(\"hej\")\nhej()",
                "hej\nhej\nhej",
                "powtorz(3) zwraca dekorator, który dopiero opakowuje funkcję.",
            ),
            choice(
                "Ile poziomów funkcji ma dekorator z argumentami, np. @powtorz(3)?",
                listOf("Trzy: fabryka, dekorator, wrapper", "Jeden", "Dwa: dekorator i wrapper", "Cztery"),
                0,
                "Najpierw powtorz(3) tworzy dekorator, a on zwraca wrapper.",
            ),
            output(
                "def dodaj(znak):\n    def dek(f):\n        def w():\n            return f() + znak\n        return w\n    return dek\n@dodaj(\"?\")\ndef pytanie():\n    return \"Jak\"\nprint(pytanie())",
                "Jak?",
                "Argument dekoratora jest dostępny w funkcji wewnętrznej.",
            ),
            output(
                "def a(f):\n    def w():\n        return \"a\" + f()\n    return w\ndef b(f):\n    def w():\n        return \"b\" + f()\n    return w\n@a\n@b\ndef x():\n    return \"x\"\nprint(x())",
                "abx",
                "Najpierw działa dekorator najbliższy def (b), a a opakowuje wynik.",
            ),
            output(
                "def a(f):\n    def w():\n        return \"a\" + f()\n    return w\ndef b(f):\n    def w():\n        return \"b\" + f()\n    return w\n@b\n@a\ndef x():\n    return \"x\"\nprint(x())",
                "bax",
                "Zamiana kolejności dekoratorów zmienia wynik.",
            ),
            choice(
                "Któremu zapisowi odpowiada @a nad @b nad def x()?",
                listOf("x = a(b(x))", "x = b(a(x))", "x = a(x) + b(x)", "x = a(b)(x)"),
                0,
                "Dekorator najbliżej def jest stosowany jako pierwszy.",
            ),
            fill(
                "Uzupełnij, aby funkcja wykonała się 2 razy.",
                "def powtorz(n):\n    def dek(f):\n        def w():\n            for _ in range(n):\n                f()\n        return w\n    return dek\n@____\ndef hej():\n    print(\"hej\")\nhej()",
                listOf("powtorz(2)", "powtorz", "dek(2)", "powtorz(1)"),
                "powtorz(2)",
                "Dekorator z argumentem wywołujemy z nawiasami.",
            ),
        ),
        lesson(
            "u41l5", "Powtórka: dekoratory",
            output(
                "def ozdob(f):\n    def w():\n        return f() * 2\n    return w\n@ozdob\ndef liczba():\n    return 21\nprint(liczba())",
                "42",
                "Dekorator podwaja wynik funkcji.",
            ),
            output(
                "def ramka(f):\n    def w(s):\n        print(\"--\")\n        f(s)\n        print(\"--\")\n    return w\n@ramka\ndef pisz(s):\n    print(s)\npisz(\"Hi\")",
                "--\nHi\n--",
                "wrapper wypisuje ramkę przed i po wywołaniu.",
            ),
            choice(
                "Co wypisze ten kod?",
                listOf("A", "B", "AB", "Nic"),
                0,
                "Dekorator zwrócił inną funkcję niż oryginał, więc działa tylko ona.",
                code = "def zamien(f):\n    def w():\n        print(\"A\")\n    return w\n@zamien\ndef g():\n    print(\"B\")\ng()",
            ),
            output(
                "def plus(n):\n    def dek(f):\n        def w(x):\n            return f(x) + n\n        return w\n    return dek\n@plus(10)\ndef kw(x):\n    return x * x\nprint(kw(3))",
                "19",
                "kw(3) daje 9, a dekorator dodaje 10.",
            ),
            output(
                "def gwiazdka(f):\n    def w():\n        return \"*\" + f() + \"*\"\n    return w\n@gwiazdka\n@gwiazdka\ndef s():\n    return \"x\"\nprint(s())",
                "**x**",
                "Ten sam dekorator użyty dwa razy opakowuje wynik dwukrotnie.",
            ),
            fill(
                "Uzupełnij, aby wrapper zwracał wynik oryginalnej funkcji.",
                "def log(f):\n    def w():\n        print(\"start\")\n        ____ f()\n    return w\n@log\ndef dane():\n    return 7\nprint(dane())",
                listOf("return", "print", "yield", "raise"),
                "return",
                "Bez return udekorowana funkcja zwróciłaby None.",
            ),
            tiles(
                "Zastosuj do hej dekorator powtorz z argumentem 3 bez użycia @",
                listOf("hej", "=", "powtorz(3)(", "hej", ")"),
                listOf("powtorz(", "hej()"),
                "@powtorz(3) to skrót od hej = powtorz(3)(hej).",
            ),
            choice(
                "Po co w dekoratorach używa się functools.wraps?",
                listOf("Żeby zachować nazwę i opis oryginalnej funkcji", "Żeby przyspieszyć funkcję", "Żeby zapamiętywać wyniki", "Żeby dekorator przyjmował argumenty"),
                0,
                "wraps kopiuje metadane, np. __name__, z oryginału na wrapper.",
            ),
        ),
    ),
)
