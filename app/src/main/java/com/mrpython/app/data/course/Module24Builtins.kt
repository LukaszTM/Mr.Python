package com.mrpython.app.data.course

import com.mrpython.app.domain.CourseUnit

internal val module24 = CourseUnit(
    id = "u24",
    title = "Funkcje wbudowane",
    description = "min, max, sum, round, isinstance i inne przydatne funkcje",
    lessons = listOf(
        lesson(
            "u24l1", "min i max",
            output("print(min(4, 2, 8))\nprint(max([4, 2, 8]))", "2\n8", "min i max przyjmują kilka argumentów albo jedną listę."),
            output(
                "slowa = [\"kot\", \"hipopotam\", \"pies\"]\nprint(max(slowa, key=len))",
                "hipopotam",
                "key=len porównuje słowa według długości.",
            ),
            output("print(max([], default=0))", "0", "default to wynik dla pustej listy."),
            choice(
                "Co się stanie po max([])?",
                listOf("ValueError", "Zwróci 0", "Zwróci None", "Zwróci []"),
                0,
                "Pusta lista nie ma największego elementu – bez default jest błąd.",
            ),
            fill(
                "Uzupełnij, aby znaleźć najkrótsze słowo.",
                "slowa = [\"ala\", \"ma\", \"kota\"]\nprint(min(slowa, ____=len))",
                listOf("key", "by", "sort"),
                "key",
                "Parametr key mówi, według czego porównywać.",
            ),
            output("print(min(\"banan\"))", "a", "Litery porównuje się alfabetycznie – a jest najmniejsza."),
            output(
                "ludzie = [(\"Ala\", 30), (\"Bob\", 25)]\nprint(min(ludzie, key=lambda p: p[1]))",
                "('Bob', 25)",
                "Porównujemy wiek, czyli drugi element krotki.",
            ),
            tiles(
                "Znajdź największą ocenę lub 0, gdy lista oceny jest pusta.",
                listOf("max(", "oceny,", "default=0", ")"),
                listOf("key=0", "min("),
                "default=0 zabezpiecza przed pustą listą.",
            ),
        ),
        lesson(
            "u24l2", "sum, abs, round, divmod i pow",
            output(
                "print(sum([1, 2, 3]))\nprint(sum([1, 2, 3], 10))",
                "6\n16",
                "Drugi argument sum to wartość startowa.",
            ),
            output("print(abs(-7))\nprint(abs(3.5))", "7\n3.5", "abs zwraca wartość bezwzględną."),
            output("print(divmod(17, 5))", "(3, 2)", "divmod zwraca iloraz całkowity i resztę: 17 = 3·5 + 2."),
            output(
                "print(round(3.14159, 2))\nprint(round(2.5))",
                "3.14\n2",
                "round przy równej połowie wybiera liczbę parzystą – stąd 2.",
            ),
            choice(
                "Co zwraca pow(2, 3, 5)?",
                listOf("3", "8", "1", "40"),
                0,
                "Trzeci argument to modulo: 2³ = 8, a 8 % 5 = 3.",
            ),
            fill(
                "Uzupełnij, aby dostać iloraz i resztę naraz.",
                "q, r = ____(20, 6)\nprint(q, r)",
                listOf("divmod", "pow", "round"),
                "divmod",
                "divmod(a, b) zwraca parę (a // b, a % b).",
            ),
            choice(
                "Co wypisze print(round(7.5))?",
                listOf("8", "7", "7.5", "7.0"),
                0,
                "Przy równej połowie round wybiera liczbę parzystą, czyli 8.",
            ),
            output(
                "liczby = [-3, 1, -2]\nprint(sum(abs(x) for x in liczby))",
                "6",
                "Sumujemy wartości bezwzględne: 3 + 1 + 2.",
            ),
        ),
        lesson(
            "u24l3", "isinstance i type",
            output(
                "print(isinstance(5, int))\nprint(isinstance(\"5\", int))",
                "True\nFalse",
                "\"5\" to napis, a nie liczba.",
            ),
            output("print(type(3.0) == float)", "True", "3.0 jest liczbą float."),
            output("print(isinstance(True, int))", "True", "bool to szczególny rodzaj int."),
            choice(
                "Co sprawdza isinstance(x, (int, float))?",
                listOf(
                    "Czy x jest typu int lub float",
                    "Czy x jest krotką",
                    "Czy x jest jednocześnie int i float",
                    "Zamienia x na liczbę",
                ),
                0,
                "Krotka typów oznacza „którykolwiek z nich”.",
            ),
            fill(
                "Uzupełnij, aby sprawdzić, czy x jest napisem.",
                "x = \"abc\"\nprint(isinstance(x, ____))",
                listOf("str", "string", "text"),
                "str",
                "Typ napisu w Pythonie to str.",
            ),
            output(
                "dane = [1, \"a\", 2.5, \"b\"]\nnapisy = [d for d in dane if isinstance(d, str)]\nprint(len(napisy))",
                "2",
                "Napisami są tylko \"a\" i \"b\".",
            ),
            output(
                "def opisz(x):\n    if isinstance(x, list):\n        return \"lista\"\n    return \"coś innego\"\n\nprint(opisz([1]))\nprint(opisz((1,)))",
                "lista\ncoś innego",
                "(1,) to krotka, nie lista.",
            ),
            tiles(
                "Sprawdź, czy wartosc jest liczbą całkowitą.",
                listOf("isinstance(", "wartosc,", "int", ")"),
                listOf("type(", "str"),
                "isinstance(obiekt, typ) zwraca True lub False.",
            ),
        ),
        lesson(
            "u24l4", "chr, ord, len i konwersje",
            output("print(ord(\"A\"))\nprint(chr(66))", "65\nB", "ord daje kod znaku, chr – znak o danym kodzie."),
            output("print(chr(ord(\"a\") + 1))", "b", "Kod kolejnej litery jest o 1 większy."),
            output(
                "print(len(\"kot\"), len([1, 2]), len({\"a\": 1}))",
                "3 2 1",
                "len działa na napisach, listach i słownikach.",
            ),
            choice(
                "Co się stanie po len(5)?",
                listOf("TypeError", "Zwróci 1", "Zwróci 5", "Zwróci 0"),
                0,
                "Liczba nie ma długości – to TypeError.",
            ),
            output(
                "print(int(\"42\") + 1)\nprint(str(42) + \"1\")",
                "43\n421",
                "int dodaje liczby, a str skleja napisy.",
            ),
            output("print(int(3.9))\nprint(float(\"2.5\") * 2)", "3\n5.0", "int obcina część ułamkową, nie zaokrągla."),
            fill(
                "Uzupełnij, aby zamienić napis \"7\" na liczbę całkowitą.",
                "x = ____(\"7\")\nprint(x * 2)",
                listOf("int", "str", "len"),
                "int",
                "int(\"7\") daje liczbę 7, więc wynik to 14.",
            ),
            output(
                "print(list(\"ab\"), tuple([1, 2]))",
                "['a', 'b'] (1, 2)",
                "list i tuple zamieniają jedną sekwencję na inną.",
            ),
        ),
        lesson(
            "u24l5", "Powtórka: funkcje wbudowane",
            output("print(max([3, -7, 5], key=abs))", "-7", "Porównujemy wartości bezwzględne – największa to 7."),
            output("print(divmod(9, 4)[1])", "1", "divmod(9, 4) to (2, 1), a [1] to reszta."),
            choice(
                "Co zwraca min([], default=None)?",
                listOf("None", "0", "ValueError", "[]"),
                0,
                "Dla pustej listy zwracana jest wartość default.",
            ),
            output("print(sum([0.5, 0.5], 1))", "2.0", "1 + 0.5 + 0.5 = 2.0."),
            fill(
                "Uzupełnij, aby wypisać kod znaku \"a\".",
                "print(____(\"a\"))",
                listOf("ord", "chr", "int"),
                "ord",
                "ord zwraca kod znaku – dla „a” to 97.",
            ),
            output("print(bool(0), bool(\"0\"))", "False True", "Zero jest fałszywe, ale niepusty napis \"0\" – prawdziwy."),
            tiles(
                "Wypisz literę o kodzie 67.",
                listOf("print(", "chr(", "67", "))"),
                listOf("ord(", "str("),
                "chr zamienia kod na znak – 67 to C.",
            ),
            output(
                "wartosci = [\"3\", 4, \"x\"]\nsuma = 0\nfor w in wartosci:\n    if isinstance(w, int):\n        suma += w\n    elif w.isdigit():\n        suma += int(w)\nprint(suma)",
                "7",
                "Liczymy 4 oraz napis \"3\"; \"x\" pomijamy.",
            ),
        ),
    ),
)
