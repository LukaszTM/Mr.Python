package com.mrpython.app.data.course

import com.mrpython.app.domain.CourseUnit

internal val module23 = CourseUnit(
    id = "u23",
    title = "Iteratory i generatory",
    description = "iter, next, yield i leniwe obliczenia",
    lessons = listOf(
        lesson(
            "u23l1", "iter, next i StopIteration",
            output(
                "it = iter([10, 20, 30])\nprint(next(it))\nprint(next(it))",
                "10\n20",
                "Każde next() zwraca kolejny element.",
            ),
            choice(
                "Co robi next(it)?",
                listOf(
                    "Zwraca kolejny element iteratora",
                    "Zwraca pierwszy element listy",
                    "Przewija iterator na początek",
                    "Zwraca liczbę elementów",
                ),
                0,
                "Iterator pamięta, gdzie skończył, i podaje następny element.",
            ),
            fill(
                "Uzupełnij, aby utworzyć iterator z listy.",
                "it = ____([1, 2, 3])\nprint(next(it))",
                listOf("iter", "next", "list"),
                "iter",
                "iter() tworzy iterator z sekwencji.",
            ),
            output(
                "it = iter([1, 2, 3])\nnext(it)\nprint(list(it))",
                "[2, 3]",
                "Pierwszy element został już pobrany – zostały 2 i 3.",
            ),
            output(
                "it = iter([1])\nnext(it)\ntry:\n    next(it)\nexcept StopIteration:\n    print(\"koniec\")",
                "koniec",
                "Gdy elementy się skończą, next() zgłasza StopIteration.",
            ),
            choice(
                "Jaki wyjątek zgłasza next(), gdy iterator się skończy?",
                listOf("StopIteration", "IndexError", "EndError", "ValueError"),
                0,
                "StopIteration oznacza koniec elementów – pętla for obsługuje go sama.",
            ),
            output(
                "it = iter([1, 2, 3])\nprint(sum(it))\nprint(sum(it))",
                "6\n0",
                "Iterator można przejść tylko raz – za drugim razem jest pusty.",
            ),
            tiles(
                "Pobierz następny element z iteratora it do zmiennej x.",
                listOf("x", "=", "next(", "it", ")"),
                listOf("iter(", "it.next("),
                "next(it) zwraca kolejny element.",
            ),
        ),
        lesson(
            "u23l2", "Funkcje z yield",
            output(
                "def licz():\n    yield 1\n    yield 2\n\nfor x in licz():\n    print(x)",
                "1\n2",
                "Funkcja z yield to generator – oddaje wartości po kolei.",
            ),
            output(
                "def gen():\n    yield \"a\"\n    yield \"b\"\n\ng = gen()\nprint(next(g))",
                "a",
                "next() uruchamia generator do pierwszego yield.",
            ),
            choice(
                "Czym różni się yield od return?",
                listOf(
                    "yield oddaje wartość i wstrzymuje funkcję – potem można ją wznowić",
                    "yield kończy funkcję na zawsze",
                    "yield wypisuje wartość na ekran",
                    "Niczym",
                ),
                0,
                "Generator pamięta swój stan między kolejnymi wartościami.",
            ),
            output(
                "def kwadraty(n):\n    for i in range(n):\n        yield i * i\n\nprint(list(kwadraty(4)))",
                "[0, 1, 4, 9]",
                "list() pobiera wszystkie wartości z generatora.",
            ),
            fill(
                "Uzupełnij, aby funkcja była generatorem.",
                "def odliczaj(n):\n    while n > 0:\n        ____ n\n        n -= 1\n\nprint(list(odliczaj(3)))",
                listOf("yield", "return", "print"),
                "yield",
                "yield zamienia funkcję w generator.",
            ),
            output(
                "def gen():\n    print(\"start\")\n    yield 1\n\ng = gen()\nprint(\"utworzono\")\nprint(next(g))",
                "utworzono\nstart\n1",
                "Kod generatora rusza dopiero przy pierwszym next().",
            ),
            output(
                "def gen():\n    yield 1\n\nprint(type(gen()))",
                "<class 'generator'>",
                "Wywołanie funkcji z yield zwraca obiekt generatora.",
            ),
            tiles(
                "Zamień wszystkie wartości generatora gen() na listę.",
                listOf("wynik", "=", "list(", "gen()", ")"),
                listOf("yield", "next("),
                "list() zbiera wszystkie wartości generatora.",
            ),
        ),
        lesson(
            "u23l3", "Wyrażenia generatorowe",
            output("print(sum(x * x for x in range(4)))", "14", "0 + 1 + 4 + 9 = 14."),
            output(
                "g = (x * 2 for x in [1, 2, 3])\nprint(next(g))\nprint(list(g))",
                "2\n[4, 6]",
                "Wyrażenie w nawiasach okrągłych tworzy generator.",
            ),
            choice(
                "Czym różni się (x for x in a) od [x for x in a]?",
                listOf(
                    "Generator nie tworzy od razu całej listy – liczy na żądanie",
                    "Nawiasy okrągłe tworzą krotkę",
                    "Nie ma różnicy",
                    "Generator działa tylko na liczbach",
                ),
                0,
                "Generator oszczędza pamięć, bo nie przechowuje wszystkich wartości.",
            ),
            output(
                "slowa = [\"kot\", \"żyrafa\", \"pies\"]\nprint(max(len(s) for s in slowa))",
                "6",
                "Najdłuższe słowo, żyrafa, ma 6 liter.",
            ),
            fill(
                "Uzupełnij, aby zsumować tylko liczby parzyste.",
                "print(sum(x for x in range(7) ____ x % 2 == 0))",
                listOf("if", "and", "where"),
                "if",
                "Warunek filtrujący zapisujemy po if – jak w wyrażeniu listowym.",
            ),
            output("print(any(x > 5 for x in [1, 7, 3]))", "True", "7 jest większe od 5."),
            tiles(
                "Policz sumę kwadratów liczb z listy a.",
                listOf("sum(", "x * x", "for x in a", ")"),
                listOf("yield", "x ** x"),
                "Wyrażenie generatorowe można podać prosto do sum().",
            ),
            output(
                "g = (c.upper() for c in \"ab\")\nprint(\"\".join(g))",
                "AB",
                "join pobiera kolejne litery z generatora.",
            ),
        ),
        lesson(
            "u23l4", "Leniwe i nieskończone generatory",
            output(
                "def naturalne():\n    n = 1\n    while True:\n        yield n\n        n += 1\n\nfor x in naturalne():\n    if x > 3:\n        break\n    print(x)",
                "1\n2\n3",
                "Generator jest nieskończony, ale break kończy pętlę.",
            ),
            choice(
                "Dlaczego nieskończony generator nie zawiesza programu od razu?",
                listOf(
                    "Wartości są liczone dopiero, gdy o nie poprosimy",
                    "Python ogranicza go do 100 wartości",
                    "while True w generatorze nie działa",
                    "Generator działa w tle",
                ),
                0,
                "Generatory są leniwe – liczą kolejną wartość dopiero przy next().",
            ),
            output(
                "def potegi():\n    p = 1\n    while True:\n        yield p\n        p *= 2\n\ng = potegi()\nprint([next(g) for _ in range(5)])",
                "[1, 2, 4, 8, 16]",
                "Pobieramy tylko 5 pierwszych potęg dwójki.",
            ),
            choice(
                "Co się stanie po list(g), gdy g jest nieskończonym generatorem?",
                listOf(
                    "Program nigdy nie skończy (albo zabraknie pamięci)",
                    "Powstanie lista 10 elementów",
                    "Powstanie pusta lista",
                    "Zostanie zgłoszony StopIteration",
                ),
                0,
                "list() próbuje pobrać wszystkie wartości, a tych nie ma końca.",
            ),
            fill(
                "Uzupełnij warunek stopu, aby wypisać tylko 1, 2, 3.",
                "def licznik():\n    n = 1\n    while True:\n        yield n\n        n += 1\n\nfor x in licznik():\n    if x == 4:\n        ____\n    print(x)",
                listOf("break", "stop", "return"),
                "break",
                "break przerywa pętlę po nieskończonym generatorze.",
            ),
            output(
                "def fib():\n    a, b = 0, 1\n    while True:\n        yield a\n        a, b = b, a + b\n\ng = fib()\nprint([next(g) for _ in range(6)])",
                "[0, 1, 1, 2, 3, 5]",
                "Generator liczy kolejne liczby Fibonacciego na żądanie.",
            ),
            output(
                "def gen():\n    for i in range(3):\n        print(\"liczę\", i)\n        yield i\n\nfor x in gen():\n    if x == 1:\n        break",
                "liczę 0\nliczę 1",
                "Wartość 2 nigdy nie została policzona – generator jest leniwy.",
            ),
            tiles(
                "Napisz nagłówek pętli po generatorze licznik().",
                listOf("for", "x", "in", "licznik():"),
                listOf("while", "yield"),
                "Po generatorze iterujemy zwykłą pętlą for.",
            ),
        ),
        lesson(
            "u23l5", "Powtórka: generatory",
            output("it = iter([4, 5, 6])\nnext(it)\nprint(next(it))", "5", "Drugie next() zwraca drugi element."),
            output(
                "def parzyste(n):\n    for i in range(0, n, 2):\n        yield i\n\nprint(list(parzyste(7)))",
                "[0, 2, 4, 6]",
                "Generator oddaje liczby parzyste mniejsze od 7.",
            ),
            choice(
                "Które słowo kluczowe zamienia funkcję w generator?",
                listOf("yield", "return", "next", "iter"),
                0,
                "Wystarczy jedno yield w ciele funkcji.",
            ),
            output("print(sum(len(s) for s in [\"ab\", \"cde\"]))", "5", "2 + 3 = 5."),
            fill(
                "Uzupełnij, aby pobrać pierwszy element z g.",
                "g = (x * 10 for x in range(3))\nprint(____(g))",
                listOf("next", "iter", "len"),
                "next",
                "next(g) zwraca kolejną wartość generatora – tutaj 0.",
            ),
            output(
                "g = (x for x in [1, 2])\nprint(list(g))\nprint(list(g))",
                "[1, 2]\n[]",
                "Generator wyczerpuje się po jednym przejściu.",
            ),
            choice(
                "Kiedy generator jest lepszy od listy?",
                listOf(
                    "Gdy danych jest bardzo dużo lub nie mają końca",
                    "Gdy chcemy wiele razy czytać te same dane",
                    "Gdy potrzebujemy indeksów, np. g[3]",
                    "Nigdy",
                ),
                0,
                "Generator nie trzyma wszystkiego w pamięci naraz.",
            ),
            tiles(
                "Utwórz generator kwadratów liczb od 0 do 9.",
                listOf("g =", "(x * x", "for x in", "range(10))"),
                listOf("[x * x", "range(10)]"),
                "Nawiasy okrągłe tworzą generator, kwadratowe – listę.",
            ),
        ),
    ),
)
