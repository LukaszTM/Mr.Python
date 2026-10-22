package com.mrpython.app.data.course

internal val module4Cards = listOf(
    cards(
        "u4l1",
        explain(
            "Pętla po napisie",
            "`for` może przejść po napisie – wtedy w każdym obrocie zmienna dostaje kolejny znak. " +
                "Nie potrzeba do tego `range()`.",
            code = "for z in \"kot\":\n    print(z)",
            output = "k\no\nt",
        ),
        explain(
            "Ile razy się powtórzy?",
            "`range(n)` daje n liczb, więc pętla wykona się n razy – zmiennej `i` nie trzeba używać. " +
                "Linia bez wcięcia pod pętlą wykona się raz, już po pętli.",
            code = "for i in range(2):\n    print(\"Hej\")\nprint(\"Koniec\")",
            output = "Hej\nHej\nKoniec",
        ),
        explain(
            "Pętla w jednej linii",
            "Gdy blok ma tylko jedno polecenie, można je napisać zaraz po dwukropku, w tej samej linii. " +
                "Tak samo działa to w `if` i `while`.",
            code = "for i in range(3): print(i)",
            output = "0\n1\n2",
        ),
    ),
    cards(
        "u4l2",
        explain(
            "Kiedy while sprawdza warunek?",
            "`while` sprawdza warunek przed każdym obrotem. Jeśli jest fałszywy już na starcie, pętla nie " +
                "wykona się ani razu. Po pętli zmienna ma pierwszą wartość, przy której warunek był fałszywy.",
            code = "x = 1\nwhile x < 10:\n    x *= 3\nprint(x)",
            output = "27",
        ),
    ),
    cards(
        "u4l3",
        explain(
            "Liczenie z warunkiem",
            "Licznik zaczyna od 0, a w pętli zwiększamy go o 1 tylko wtedy, gdy warunek jest spełniony. " +
                "Tak policzysz np. wybrane litery w słowie.",
            code = "ile = 0\nfor z in \"kajak\":\n    if z == \"k\":\n        ile += 1\nprint(ile)",
            output = "2",
        ),
        explain(
            "Mnożenie zaczyna od 1",
            "Gdy w pętli mnożymy (`*=`), wynik startuje od 1, a nie od 0 – bo 0 razy cokolwiek to zawsze 0.",
            code = "wynik = 1\nfor i in range(1, 4):\n    wynik *= i\nprint(wynik)",
            output = "6",
        ),
        explain(
            "Pusty zakres",
            "`range(5, 1)` jest pusty, bo bez ujemnego kroku `range` liczy tylko w górę. Przy liczeniu w dół " +
                "koniec też nie jest wliczany: `range(3, 0, -1)` daje 3, 2, 1.",
            code = "for i in range(5, 1):\n    print(i)\nfor i in range(3, 0, -1):\n    print(i)",
            output = "3\n2\n1",
        ),
    ),
    cards(
        "u4l4",
        explain(
            "Pętla while True",
            "`while True:` to pętla „bez końca”, bo warunek zawsze jest prawdziwy. Wychodzi się z niej " +
                "przez `break` – kod po `break` w tym obrocie już się nie wykona.",
            code = "n = 0\nwhile True:\n    n += 2\n    if n > 5:\n        break\nprint(n)",
            output = "6",
        ),
        explain(
            "break w pętli w pętli",
            "`break` kończy tylko tę pętlę, w której się znajduje. W pętli zagnieżdżonej przerywa " +
                "wewnętrzną, a zewnętrzna działa dalej.",
            code = "for i in range(2):\n    for j in range(5):\n        if j == 1:\n            break\n        print(i, j)",
            output = "0 0\n1 0",
        ),
    ),
    cards(
        "u4l5",
        explain(
            "Skróty //= i inne",
            "Każde działanie ma skrót z `=`: `n //= 2` znaczy `n = n // 2`. Tak samo działają `%=` i `**=`.",
            code = "n = 10\nn //= 3\nprint(n)\nn **= 2\nprint(n)",
            output = "3\n9",
        ),
    ),
)
