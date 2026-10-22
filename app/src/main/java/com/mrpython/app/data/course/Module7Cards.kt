package com.mrpython.app.data.course

internal val module7Cards = listOf(
    cards(
        "u7l1",
        explain(
            "Liczenie od końca w wycinkach",
            "W wycinkach też możesz liczyć od końca: `s[-3:]` to trzy ostatnie znaki, a `s[1:-1]` " +
                "to napis bez pierwszego i ostatniego znaku.",
            code = "s = \"Kraków\"\nprint(s[-3:])\nprint(s[1:-1])",
            output = "ków\nrakó",
        ),
        explain(
            "Start i krok razem",
            "W `s[od::krok]` podajesz, od którego indeksu zacząć i co który znak brać. `s[1::2]` zaczyna " +
                "od indeksu 1 i bierze co drugi znak aż do końca.",
            code = "print(\"abcdefg\"[1::2])",
            output = "bdf",
        ),
        explain(
            "Zmiana litery w napisie",
            "Napisu nie zmienisz przez indeks – `s[0] = \"m\"` kończy się błędem. Zamiast tego sklej nowy " +
                "napis z kawałków. Indeks spoza napisu, tak jak w liście, daje `IndexError`.",
            code = "s = \"las\"\ns = \"w\" + s[1:]\nprint(s)",
            output = "was",
        ),
    ),
    cards(
        "u7l2",
        explain(
            "title() i capitalize()",
            "`title()` zmienia na wielką pierwszą literę każdego słowa, a `capitalize()` – tylko " +
                "pierwszą literę całego napisu.",
            code = "print(\"ala ma kota\".title())\nprint(\"ala ma kota\".capitalize())",
            output = "Ala Ma Kota\nAla ma kota",
        ),
        explain(
            "Brzegi napisu i find()",
            "`startswith()` i `endswith()` sprawdzają, czym napis się zaczyna lub kończy (dają `True` albo " +
                "`False`). `strip(\"*\")` usuwa z brzegów podany znak zamiast spacji, a `find()` daje -1, gdy fragmentu nie ma.",
            code = "print(\"foto.jpg\".endswith(\".jpg\"))\nprint(\"**ok**\".strip(\"*\"))\nprint(\"kot\".find(\"x\"))",
            output = "True\nok\n-1",
        ),
        explain(
            "Metody dają nowy napis",
            "Metody nie zmieniają napisu – zwracają nowy, więc wynik trzeba zapisać, np. `s = s.upper()`. " +
                "Metody można łączyć kropkami; wykonują się od lewej do prawej.",
            code = "s = \"hej\"\ns.upper()\nprint(s)\nprint(\" ewa \".strip().title())",
            output = "hej\nEwa",
        ),
    ),
    cards(
        "u7l3",
        explain(
            "split() z separatorem",
            "Bez argumentu `split()` dzieli po spacjach (nawet kilku naraz). Gdy podasz separator, " +
                "np. `split(\",\")`, napis dzieli się w miejscach tego znaku, a sam separator znika.",
            code = "print(\"1;2;3\".split(\";\"))\nprint(\"a   b\".split())",
            output = "['1', '2', '3']\n['a', 'b']",
        ),
        explain(
            "Czego nie ma: not in",
            "`not in` to odwrotność `in` – daje `True`, gdy fragmentu nie ma w napisie " +
                "(albo elementu na liście).",
            code = "print(\"x\" not in \"kot\")\nprint(\"o\" not in \"kot\")",
            output = "True\nFalse",
        ),
        explain(
            "Kawałki to napisy",
            "`split()` zawsze daje listę napisów – żeby liczyć, zamień je przez `int()`. `join()` skleja " +
                "tylko napisy, więc liczby trzeba najpierw zamienić przez `str()`.",
            code = "czesci = \"2 5\".split()\nprint(int(czesci[0]) + int(czesci[1]))\nprint(\"-\".join([\"a\", str(1)]))",
            output = "7\na-1",
        ),
    ),
)
