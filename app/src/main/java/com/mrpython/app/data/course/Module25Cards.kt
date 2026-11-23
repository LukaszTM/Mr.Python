package com.mrpython.app.data.course

internal val module25Cards = listOf(
    cards(
        "u25l1",
        explain(
            "Flaga znaleziono",
            "Flaga to zmienna `True`/`False`, która pamięta, czy coś się wydarzyło. Zaczynamy od `False`, " +
                "a w pętli ustawiamy `True` przy trafieniu.",
            code = "znaleziono = False\nfor x in [4, 8, 15]:\n    if x == 8:\n        znaleziono = True\nprint(znaleziono)",
            output = "True",
        ),
        explain(
            "Pozycja i -1",
            "Żeby zapamiętać indeks, idziemy po `range(len(lista))`. Start `poz = -1` oznacza „nie znaleziono”. " +
                "Pętla bez przerwania nadpisuje `poz`, więc zostaje ostatnie wystąpienie.",
            code = "litery = [\"a\", \"b\", \"a\"]\npoz = -1\nfor i in range(len(litery)):\n    if litery[i] == \"a\":\n        poz = i\nprint(poz)",
            output = "2",
        ),
    ),
    cards(
        "u25l2",
        explain(
            "return czy break?",
            "`break` kończy tylko pętlę – kod za nią dalej się wykona. `return` kończy całą funkcję. " +
                "Uwaga: `return False` w `else` wewnątrz pętli zakończy funkcję już przy pierwszym elemencie!",
            code = "for x in [3, 0, 7]:\n    if x == 0:\n        break\n    print(x)\nprint(\"koniec\")",
            output = "3\nkoniec",
        ),
        explain(
            "in i index()",
            "`x in lista` mówi, czy element jest na liście, a `lista.index(x)` – pod którym indeksem jest " +
                "jego pierwsze wystąpienie. Gdy elementu brak, `index()` zgłasza `ValueError`.",
            code = "lista = [1, 7, 3, 7]\nprint(7 in lista)\nprint(lista.index(7))",
            output = "True\n1",
        ),
    ),
    cards(
        "u25l3",
        explain(
            "Pierwsze czy ostatnie?",
            "Szukając pozycji minimum, porównujemy z `liczby[poz]`. Ostre `<` zostawia pierwsze " +
                "wystąpienie, a `<=` nadpisuje pozycję przy każdym remisie – zostaje ostatnie.",
            code = "liczby = [5, 1, 8, 1]\npoz = 0\nfor i in range(len(liczby)):\n    if liczby[i] <= liczby[poz]:\n        poz = i\nprint(poz)",
            output = "3",
        ),
    ),
    cards(
        "u25l4",
        explain(
            "Przesuwanie granic",
            "Gdy środek jest za mały, szukamy na prawo: `lewo = s + 1`. Gdy za duży – na lewo: " +
                "`prawo = s - 1`. Środek już sprawdziliśmy, więc go pomijamy.",
            code = "lista = [2, 4, 6, 8, 10]\nlewo, prawo = 0, 4\ns = (lewo + prawo) // 2\nif lista[s] < 8:\n    lewo = s + 1\nprint(lewo, prawo)",
            output = "3 4",
        ),
        explain(
            "Pętla i pusty zakres",
            "Całe szukanie to pętla `while lewo <= prawo:`: liczymy środek, porównujemy i przesuwamy granicę. " +
                "Gdy `lewo` przekroczy `prawo`, zakres jest pusty – elementu nie ma i zwracamy -1.",
            code = "lewo, prawo = 0, 2\nwhile lewo <= prawo:\n    s = (lewo + prawo) // 2\n    lewo = s + 1\nprint(lewo, prawo)",
            output = "3 2",
        ),
    ),
)
