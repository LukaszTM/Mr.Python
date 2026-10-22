package com.mrpython.app.data.course

internal val module4Intro = lesson(
    "u4l0", "Wprowadzenie: pętle",
    explain(
        "Po co pętle?",
        "Pętla powtarza kod wiele razy, żeby nie trzeba było go kopiować. Pętla `for` przechodzi " +
            "kolejno po elementach, np. po liczbach z `range(3)`, czyli 0, 1 i 2.",
        code = "for i in range(3):\n    print(i)",
        output = "0\n1\n2",
    ),
    explain(
        "range() i liczniki",
        "`range(start, stop, krok)` liczy od `start` i kończy tuż przed `stop`. Ujemny krok liczy w dół. " +
            "Zmienna-licznik pozwala coś sumować w pętli.",
        code = "for i in range(1, 8, 3):\n    print(i)\nsuma = 0\nfor i in range(4):\n    suma += i\nprint(suma)",
        output = "1\n4\n7\n6",
    ),
    explain(
        "Pętla while",
        "`while` powtarza kod, dopóki warunek jest prawdziwy. Pamiętaj, by coś w środku zmieniało się, " +
            "inaczej pętla nigdy się nie skończy.",
        code = "n = 3\nwhile n > 0:\n    print(n)\n    n -= 1",
        output = "3\n2\n1",
    ),
    explain(
        "break i continue",
        "`break` natychmiast kończy całą pętlę, a `continue` pomija resztę bieżącego obrotu " +
            "i przechodzi do następnego.",
        code = "for i in range(6):\n    if i == 1:\n        continue\n    if i == 4:\n        break\n    print(i)",
        output = "0\n2\n3",
    ),
    explain(
        "Pętla w pętli",
        "Pętlę można umieścić w innej pętli. Wewnętrzna wykonuje się w całości przy każdym obrocie " +
            "zewnętrznej.",
        code = "for i in range(2):\n    for j in range(2):\n        print(i, j)",
        output = "0 0\n0 1\n1 0\n1 1",
    ),
    output(
        "for i in range(2, 5):\n    print(i)",
        "2\n3\n4",
        "range(2, 5) zaczyna od 2 i kończy przed 5.",
    ),
    choice(
        "Co natychmiast kończy całą pętlę?",
        listOf("break", "continue", "else", "range"),
        0,
        "break przerywa pętlę, a continue tylko pomija bieżący obrót.",
    ),
    tiles(
        "Ułóż nagłówek pętli: dopóki n jest mniejsze od 5",
        listOf("while", "n", "<", "5", ":"),
        listOf("for", "in"),
        "while, warunek i dwukropek na końcu.",
    ),
)
