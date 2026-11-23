package com.mrpython.app.data.course

import com.mrpython.app.domain.CourseUnit

internal val module4 = CourseUnit(
    id = "u4",
    title = "Pętle",
    description = "Powtarzaj kod bez kopiowania",
    lessons = listOf(
        lesson(
            "u4l1", "Pętla for",
            output(
                "for i in range(3):\n    print(i)",
                "0\n1\n2",
                "range(3) daje liczby 0, 1, 2 – bez trójki!",
            ),
            choice(
                "Jakie liczby wygeneruje range(1, 4)?",
                listOf("1, 2, 3", "1, 2, 3, 4", "0, 1, 2, 3", "4"),
                0,
                "Koniec zakresu nie jest wliczany.",
            ),
            tiles(
                "Ułóż nagłówek pętli przechodzącej przez liczby od 0 do 4",
                listOf("for", "i", "in", "range(5)", ":"),
                listOf("while", "range(4)"),
                "for zmienna in sekwencja: – i nie zapomnij o dwukropku.",
            ),
            output(
                "for litera in \"abc\":\n    print(litera)",
                "a\nb\nc",
                "Pętla for przechodzi też po kolejnych znakach napisu.",
            ),
            output(
                "suma = 0\nfor i in range(4):\n    suma += i\nprint(suma)",
                "6",
                "0 + 1 + 2 + 3 = 6.",
            ),
            output("for i in range(2, 5):\n    print(i)", "2\n3\n4", "range(2, 5) zaczyna od 2 i kończy przed 5."),
            output(
                "for i in range(3):\n    print(\"Hej\")",
                "Hej\nHej\nHej",
                "Zmienna i nie musi być używana – pętla po prostu powtarza blok.",
            ),
        ),
        lesson(
            "u4l2", "while, break i continue",
            output(
                "n = 3\nwhile n > 0:\n    print(n)\n    n -= 1",
                "3\n2\n1",
                "Pętla działa, dopóki n > 0; za każdym razem zmniejszamy n o 1.",
            ),
            choice(
                "Co natychmiast przerywa pętlę?",
                listOf("break", "continue", "stop", "exit loop"),
                0,
                "break kończy pętlę, a continue przechodzi do następnego obrotu.",
            ),
            output(
                "for i in range(5):\n    if i == 3:\n        break\n    print(i)",
                "0\n1\n2",
                "Gdy i osiąga 3, break kończy pętlę przed wypisaniem.",
            ),
            output(
                "for i in range(4):\n    if i % 2 == 0:\n        continue\n    print(i)",
                "1\n3",
                "continue pomija liczby parzyste.",
            ),
            fill(
                "Dokończ pętlę, która działa, dopóki x jest mniejsze od 10.",
                "x = 0\n____ x < 10:\n    x += 1",
                listOf("while", "for", "loop"),
                "while",
                "while powtarza blok, dopóki warunek jest prawdziwy.",
            ),
            output(
                "x = 1\nwhile x < 20:\n    x *= 2\nprint(x)",
                "32",
                "1 → 2 → 4 → 8 → 16 → 32. Przy 32 warunek x < 20 jest już fałszywy.",
            ),
            choice(
                "Co jest nie tak z tą pętlą?",
                listOf(
                    "Nigdy się nie skończy – n się nie zmienia",
                    "Nie wykona się ani razu",
                    "Brakuje dwukropka",
                    "Nic, jest poprawna",
                ),
                0,
                "Bez zmniejszania n warunek n > 0 zawsze będzie prawdziwy.",
                code = "n = 5\nwhile n > 0:\n    print(n)",
            ),
        ),
        lesson(
            "u4l3", "range() i liczniki",
            output("for i in range(0, 10, 3):\n    print(i)", "0\n3\n6\n9", "Trzeci argument range to krok."),
            output("for i in range(5, 0, -1):\n    print(i)", "5\n4\n3\n2\n1", "Ujemny krok liczy w dół."),
            choice(
                "Jakie liczby da range(1, 10, 2)?",
                listOf("1, 3, 5, 7, 9", "1, 2, 3, …, 10", "2, 4, 6, 8", "1, 3, 5, 7, 9, 11"),
                0,
                "Od 1 co 2, a koniec (10) nie jest wliczany.",
            ),
            output(
                "licznik = 0\nfor litera in \"banan\":\n    if litera == \"a\":\n        licznik += 1\nprint(licznik)",
                "2",
                "Pętla liczy litery a w słowie banan.",
            ),
            output("iloczyn = 1\nfor i in range(1, 5):\n    iloczyn *= i\nprint(iloczyn)", "24", "1 · 2 · 3 · 4 = 24."),
            fill(
                "Uzupełnij, aby wypisać liczby parzyste od 0 do 8.",
                "for i in range(0, 10, ____):\n    print(i)",
                listOf("2", "1", "0"),
                "2",
                "Krok 2 przeskakuje co drugą liczbę.",
            ),
            tiles(
                "Ułóż nagłówek pętli liczącej od 10 w dół do 1",
                listOf("for", "i", "in", "range(10, 0, -1)", ":"),
                listOf("range(10, 1)", "while"),
                "Koniec zakresu (0) nie jest wliczany, więc pętla kończy na 1.",
            ),
        ),
        lesson(
            "u4l4", "Pętle w pętlach",
            output(
                "for i in range(2):\n    for j in range(2):\n        print(i, j)",
                "0 0\n0 1\n1 0\n1 1",
                "Wewnętrzna pętla wykonuje się w całości przy każdym obrocie zewnętrznej.",
            ),
            choice(
                "Ile razy wypisze się gwiazdka?",
                listOf("12", "7", "3", "4"),
                0,
                "3 obroty · 4 obroty = 12.",
                code = "for i in range(3):\n    for j in range(4):\n        print(\"*\")",
            ),
            output("for i in range(1, 4):\n    print(\"*\" * i)", "*\n**\n***", "Gwiazdka powtarza się tyle razy, ile wynosi i."),
            output("while True:\n    print(\"raz\")\n    break", "raz", "while True działa bez końca – aż do break."),
            output(
                "n = 0\nwhile True:\n    n += 1\n    if n == 4:\n        break\nprint(n)",
                "4",
                "Pętla kończy się, gdy n osiągnie 4.",
            ),
            output(
                "for i in range(3):\n    for j in range(3):\n        if j == 1:\n            break\n        print(i, j)",
                "0 0\n1 0\n2 0",
                "break przerywa tylko wewnętrzną pętlę.",
            ),
            fill(
                "Uzupełnij, aby pętla działała, dopóki nie trafi na break.",
                "while ____:\n    odp = \"tak\"\n    if odp == \"tak\":\n        break",
                listOf("True", "False", "0"),
                "True",
                "while True to pętla „bez końca”, z której wychodzi się przez break.",
            ),
        ),
        lesson(
            "u4l5", "Powtórka: pętle",
            output("for i in range(1, 6):\n    if i % 2 == 0:\n        print(i)", "2\n4", "Wypisywane są tylko liczby parzyste."),
            output("s = 0\ni = 1\nwhile i <= 3:\n    s += i\n    i += 1\nprint(s)", "6", "1 + 2 + 3 = 6."),
            choice(
                "Która pętla wypisze liczby 1, 2, 3?",
                listOf(
                    "for i in range(1, 4): print(i)",
                    "for i in range(3): print(i)",
                    "for i in range(1, 3): print(i)",
                    "for i in range(4): print(i)",
                ),
                0,
                "range(1, 4) daje 1, 2, 3.",
            ),
            output("slowo = \"kot\"\nfor z in slowo:\n    print(z * 2)", "kk\noo\ntt", "Każda litera jest powtarzana dwa razy."),
            output(
                "for i in range(10):\n    if i == 2:\n        continue\n    if i == 4:\n        break\n    print(i)",
                "0\n1\n3",
                "2 jest pomijane (continue), a przy 4 pętla się kończy (break).",
            ),
            tiles(
                "Ułóż nagłówek pętli: dopóki x jest większe od zera",
                listOf("while", "x", ">", "0", ":"),
                listOf("for", "in"),
                "while warunek: – z dwukropkiem na końcu.",
            ),
            output(
                "n = 10\nkroki = 0\nwhile n > 1:\n    n //= 2\n    kroki += 1\nprint(kroki)",
                "3",
                "10 → 5 → 2 → 1: trzy dzielenia.",
            ),
            fill(
                "Uzupełnij, aby pominąć liczbę 3.",
                "for i in range(5):\n    if i == 3:\n        ____\n    print(i)",
                listOf("continue", "break", "stop"),
                "continue",
                "continue przeskakuje do następnego obrotu pętli.",
            ),
        ),
    ),
)
