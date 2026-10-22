package com.mrpython.app.data.course

internal val module28Cards = listOf(
    cards(
        "u28l1",
        explain(
            "Opróżnianie stosu",
            "`while stos:` działa, dopóki stos nie jest pusty. Zdejmowane elementy wychodzą w odwrotnej " +
                "kolejności, więc stos łatwo odwraca napis czy listę. `clear()` opróżnia stos naraz.",
            code = "stos = list(\"kot\")\nwynik = \"\"\nwhile stos:\n    wynik += stos.pop()\nprint(wynik)",
            output = "tok",
        ),
    ),
    cards(
        "u28l2",
        explain(
            "Oba końce deque",
            "`deque` ma operacje dla obu końców: `append()` i `pop()` działają na końcu, a `appendleft()` " +
                "i `popleft()` – na początku. Zwykła lista ma tylko wolne `pop(0)`, bo przesuwa resztę.",
            code = "from collections import deque\nq = deque([2, 3])\nq.appendleft(1)\nprint(q.pop(), q.popleft())",
            output = "3 1",
        ),
        explain(
            "deque jak lista",
            "`q[0]` to początek kolejki, a `q[-1]` – jej koniec. Działają też `len(q)`, pętla `while q:` " +
                "i `list(q)`, który pokazuje zawartość jako zwykłą listę.",
            code = "from collections import deque\nq = deque([1, 2, 3])\nq.append(q.popleft())\nprint(q[0], q[-1], len(q))\nprint(list(q))",
            output = "2 1 3\n[2, 3, 1]",
        ),
    ),
    cards(
        "u28l3",
        explain(
            "Pusty stos: not stos",
            "`not stos` jest prawdziwe, gdy stos jest pusty. Jeśli przychodzi `)`, a stos jest pusty, " +
                "nawias nie ma pary. Na końcu `return not stos` zwraca `True` tylko wtedy, gdy nic nie zostało.",
            code = "stos = []\nprint(not stos)\nstos.append(\"(\")\nprint(not stos)",
            output = "True\nFalse",
        ),
        explain(
            "Różne nawiasy",
            "Przy kilku rodzajach nawiasów słownik podaje pasujący otwierający: `pary[\")\"]` to `\"(\"`. " +
                "Nawias zamykający jest dobry, gdy na szczycie `stos[-1]` leży jego para.",
            code = "pary = {\")\": \"(\", \"]\": \"[\"}\nstos = [\"(\", \"[\"]\nprint(stos[-1] == pary[\"]\"])\nprint(\"[\" in \"([\")",
            output = "True\nTrue",
        ),
    ),
    cards(
        "u28l4",
        explain(
            "Cofnij i ponów",
            "Do „ponów” potrzebny jest drugi stos. Cofając, zdejmujemy zmianę z `cofnij` i kładziemy ją " +
                "na `ponow`. Ponowienie robi to w drugą stronę.",
            code = "cofnij = [\"a\", \"b\", \"c\"]\nponow = []\nponow.append(cofnij.pop())\nprint(cofnij, ponow)",
            output = "['a', 'b'] ['c']",
        ),
        explain(
            "Wszerz czy w głąb?",
            "Słownik może opisywać, co z czego wynika, np. `{\"A\": [\"B\", \"C\"]}`. Biorąc element, dokładamy " +
                "jego „dzieci” przez `extend()`. Kolejka (`popleft()`) idzie poziomami, a stos (`pop()`) – w głąb.",
            code = "dzieci = {\"A\": [\"B\", \"C\"], \"B\": [\"D\"], \"C\": [], \"D\": []}\nstos = [\"A\"]\nwhile stos:\n    w = stos.pop()\n    print(w, end=\"\")\n    stos.extend(dzieci[w])",
            output = "ACBD",
        ),
    ),
)
