package com.mrpython.app.data.course

import com.mrpython.app.domain.CourseUnit

internal val module16 = CourseUnit(
    id = "u16",
    title = "Lambda i funkcje wyższego rzędu",
    description = "Funkcje anonimowe, key, map, filter i funkcje jako wartości",
    lessons = listOf(
        lesson(
            "u16l1", "Wyrażenie lambda",
            output("podwoj = lambda x: x * 2\nprint(podwoj(4))", "8", "lambda x: x * 2 to mała funkcja, która podwaja argument."),
            output("dodaj = lambda a, b: a + b\nprint(dodaj(2, 3))", "5", "Lambda może mieć kilka parametrów rozdzielonych przecinkami."),
            choice(
                "Która funkcja działa tak samo jak lambda x: x + 1?",
                listOf("def f(x): return x + 1", "def f(x): print(x + 1)", "def f(): return x + 1", "def f(x): x + 1"),
                0,
                "Lambda automatycznie zwraca wartość swojego wyrażenia.",
            ),
            output("print((lambda s: s.upper())(\"hej\"))", "HEJ", "Lambdę można wywołać od razu, podając argument w nawiasach."),
            choice(
                "Co może znaleźć się w ciele lambdy?",
                listOf("Jedno wyrażenie", "Dowolnie wiele instrukcji", "Pętla for z wcięciem", "Instrukcja return"),
                0,
                "Lambda to jedno wyrażenie, którego wynik jest zwracany.",
            ),
            fill(
                "Uzupełnij, aby utworzyć funkcję anonimową.",
                "kw = ____ x: x * x\nprint(kw(5))",
                listOf("lambda", "def", "func"),
                "lambda",
                "Funkcję anonimową tworzy słowo lambda.",
            ),
            output("parz = lambda n: n % 2 == 0\nprint(parz(3), parz(4))", "False True", "Lambda zwraca wynik porównania."),
            tiles(
                "Zapisz w zmiennej trzy lambdę, która mnoży x przez 3",
                listOf("trzy", "=", "lambda x:", "x * 3"),
                listOf("def x:", "return"),
                "Po dwukropku lambdy piszemy tylko wyrażenie, bez return.",
            ),
        ),
        lesson(
            "u16l2", "sorted, min i max z key",
            output(
                "slowa = [\"kiwi\", \"jabłko\", \"fig\"]\nprint(sorted(slowa, key=len))",
                "['fig', 'kiwi', 'jabłko']",
                "key=len sortuje według długości słów.",
            ),
            output("print(max([\"ala\", \"bartek\", \"ola\"], key=len))", "bartek", "max() z key=len zwraca najdłuższe słowo."),
            output("print(sorted([3, -5, 1], key=abs))", "[1, 3, -5]", "Porównywane są wartości bezwzględne: 1, 3, 5."),
            output(
                "pary = [(\"a\", 3), (\"b\", 1)]\nprint(sorted(pary, key=lambda p: p[1]))",
                "[('b', 1), ('a', 3)]",
                "Lambda wybiera drugi element pary jako klucz sortowania.",
            ),
            choice(
                "Co wypisze ten kod?",
                listOf("Bob", "Ala", "20", "{'n': 'Bob', 'w': 20}"),
                0,
                "min() wybiera słownik z najmniejszym w, a potem wypisujemy jego imię.",
                code = "osoby = [{\"n\": \"Ala\", \"w\": 30},\n         {\"n\": \"Bob\", \"w\": 20}]\nm = min(osoby, key=lambda o: o[\"w\"])\nprint(m[\"n\"])",
            ),
            choice(
                "Do czego służy parametr key w sorted()?",
                listOf(
                    "Podaje funkcję, której wynik służy do porównywania",
                    "Określa, ile elementów posortować",
                    "Podaje klucz słownika do usunięcia",
                    "Odwraca kolejność",
                ),
                0,
                "Elementy są porównywane według wyniku funkcji key.",
            ),
            fill(
                "Uzupełnij, aby posortować od najdłuższego słowa.",
                "s = [\"aa\", \"b\", \"ccc\"]\nprint(sorted(s, key=len, reverse=____))",
                listOf("True", "False", "None"),
                "True",
                "reverse=True odwraca kolejność, więc najdłuższe słowo jest pierwsze.",
            ),
            tiles(
                "Posortuj listę slowa według ostatniej litery",
                listOf("sorted(", "slowa,", "key=lambda s:", "s[-1]", ")"),
                listOf("s[0]", "key=s[-1]"),
                "s[-1] to ostatnia litera słowa.",
            ),
        ),
        lesson(
            "u16l3", "map i filter",
            output("print(list(map(str, [1, 2, 3])))", "['1', '2', '3']", "map() wywołuje str() dla każdego elementu."),
            output("print(list(map(lambda x: x * 10, [1, 2])))", "[10, 20]", "Lambda jest stosowana do każdego elementu."),
            output(
                "print(list(filter(lambda x: x > 2, [1, 5, 2, 7])))",
                "[5, 7]",
                "filter() zostawia elementy, dla których funkcja zwraca True.",
            ),
            output(
                "liczby = list(map(int, \"3 4 5\".split()))\nprint(sum(liczby))",
                "12",
                "split() daje napisy, a map(int, …) zamienia je na liczby.",
            ),
            choice(
                "Po co piszemy list(map(...))?",
                listOf(
                    "map() zwraca obiekt map, a list() zamienia go na listę",
                    "Bez list() map() nie zadziała",
                    "list() sortuje wyniki",
                    "list() usuwa duplikaty",
                ),
                0,
                "map() i filter() zwracają obiekty, które dopiero list() zamienia na listę.",
            ),
            choice(
                "Które wyrażenie listowe daje to samo co filter(lambda x: x > 0, l)?",
                listOf("[x for x in l if x > 0]", "[x > 0 for x in l]", "[x for x in l]", "[x if x > 0 for x in l]"),
                0,
                "Filtrowanie w wyrażeniu listowym to if na końcu.",
            ),
            fill(
                "Uzupełnij, aby zostawić tylko niepuste napisy.",
                "s = [\"a\", \"\", \"b\"]\nprint(list(____(lambda x: x != \"\", s)))",
                listOf("filter", "map", "sorted"),
                "filter",
                "filter() zostawia elementy spełniające warunek.",
            ),
            output("print(list(map(len, [\"ab\", \"c\"])))", "[2, 1]", "map(len, …) daje długości kolejnych napisów."),
        ),
        lesson(
            "u16l4", "Funkcje jako wartości",
            output(
                "def kwadrat(x):\n    return x * x\n\nf = kwadrat\nprint(f(3))",
                "9",
                "Funkcję można przypisać do zmiennej i wywołać pod nową nazwą.",
            ),
            output(
                "def zastosuj(f, x):\n    return f(x)\n\nprint(zastosuj(abs, -7))",
                "7",
                "Funkcję abs przekazujemy jako argument, a zastosuj ją wywołuje.",
            ),
            output(
                "def dwa_razy(f, x):\n    return f(f(x))\n\nprint(dwa_razy(lambda n: n + 3, 1))",
                "7",
                "Lambda jest wywołana dwa razy: 1 → 4 → 7.",
            ),
            output(
                "def mnoznik(n):\n    return lambda x: x * n\n\nrazy3 = mnoznik(3)\nprint(razy3(5))",
                "15",
                "mnoznik(3) zwraca nową funkcję, która mnoży przez 3.",
            ),
            choice(
                "Czym różni się f od f()?",
                listOf("f to sama funkcja, a f() ją wywołuje", "Niczym", "f() to funkcja, a f to jej wynik", "f działa tylko dla lambd"),
                0,
                "Bez nawiasów przekazujemy funkcję, z nawiasami – jej wynik.",
            ),
            choice(
                "Co wypisze ten kod?",
                listOf("20", "9", "45", "Błąd"),
                0,
                "ops[\"*\"] to lambda mnożąca, więc 4 * 5 = 20.",
                code = "ops = {\"+\": lambda a, b: a + b,\n       \"*\": lambda a, b: a * b}\nprint(ops[\"*\"](4, 5))",
            ),
            fill(
                "Uzupełnij, aby przekazać funkcję bez jej wywoływania.",
                "def zastosuj(f, x):\n    return f(x)\n\nprint(zastosuj(____, \"abc\"))",
                listOf("len", "len()", "len(x)"),
                "len",
                "Przekazujemy samą nazwę funkcji, bez nawiasów.",
            ),
            tiles(
                "Wywołaj zastosuj z funkcją len i napisem slowo, a wynik zapisz w wynik",
                listOf("wynik", "=", "zastosuj(", "len,", "slowo)"),
                listOf("len(),", "len(slowo),"),
                "Funkcję przekazujemy bez nawiasów – wywoła ją zastosuj.",
            ),
        ),
        lesson(
            "u16l5", "Powtórka: lambda i funkcje",
            output("f = lambda a, b=2: a * b\nprint(f(5))", "10", "Lambda też może mieć wartości domyślne."),
            output("print(sorted([\"b\", \"A\", \"c\"], key=str.lower))", "['A', 'b', 'c']", "key=str.lower porównuje słowa bez względu na wielkość liter."),
            output(
                "s = [\"ab\", \"abc\", \"abcd\"]\nd = filter(lambda x: len(x) > 2, s)\nprint(list(d))",
                "['abc', 'abcd']",
                "Zostają napisy dłuższe niż 2 znaki.",
            ),
            output("print(max([3, -9, 4], key=abs))", "-9", "Największą wartość bezwzględną ma -9."),
            choice(
                "Co zwraca map(f, lista)?",
                listOf("Obiekt map, który można zamienić na listę", "Zawsze listę", "Krotkę", "Liczbę elementów"),
                0,
                "map() zwraca obiekt, który oddaje wyniki po kolei – list() zbiera je w listę.",
            ),
            output(
                "def zrob(f):\n    return f(10)\n\nprint(zrob(lambda x: x // 3))",
                "3",
                "zrob wywołuje przekazaną lambdę z argumentem 10.",
            ),
            fill(
                "Uzupełnij, aby posortować pary według drugiego elementu.",
                "p = [(1, \"b\"), (2, \"a\")]\nprint(sorted(p, key=lambda t: t[____]))",
                listOf("1", "0", "2"),
                "1",
                "t[1] to drugi element krotki.",
            ),
            tiles(
                "Zamień każdy element listy liczby na napis",
                listOf("list(", "map(", "str,", "liczby", "))"),
                listOf("filter(", "int,"),
                "map(str, liczby) stosuje str() do każdego elementu.",
            ),
        ),
    ),
)
