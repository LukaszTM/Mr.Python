package com.mrpython.app.data.course

import com.mrpython.app.domain.CourseUnit

internal val module28 = CourseUnit(
    id = "u28",
    title = "Stosy i kolejki",
    description = "Stos na liście, kolejka z deque i ich zastosowania",
    lessons = listOf(
        lesson(
            "u28l1", "Stos na liście",
            output(
                "stos = []\nstos.append(1)\nstos.append(2)\nstos.append(3)\nprint(stos.pop())",
                "3",
                "pop() zdejmuje element dodany jako ostatni.",
            ),
            output(
                "stos = [1, 2, 3]\nstos.pop()\nstos.append(9)\nprint(stos)",
                "[1, 2, 9]",
                "Zdejmujemy 3 ze szczytu i kładziemy tam 9.",
            ),
            choice(
                "Co oznacza skrót LIFO opisujący stos?",
                listOf("Ostatni wszedł, pierwszy wychodzi", "Pierwszy wszedł, pierwszy wychodzi", "Najmniejszy wychodzi pierwszy", "Losowa kolejność"),
                0,
                "Last In, First Out – jak stos talerzy.",
            ),
            output(
                "stos = [\"a\", \"b\"]\nprint(stos[-1])\nprint(len(stos))",
                "b\n2",
                "stos[-1] podgląda szczyt, ale niczego nie zdejmuje.",
            ),
            output(
                "stos = []\nfor z in \"kot\":\n    stos.append(z)\nwynik = \"\"\nwhile stos:\n    wynik += stos.pop()\nprint(wynik)",
                "tok",
                "Stos oddaje litery w odwrotnej kolejności.",
            ),
            fill(
                "Uzupełnij, aby zdjąć element ze szczytu stosu.",
                "stos = [4, 5, 6]\nx = stos.____()\nprint(x, stos)",
                listOf("pop", "append", "clear"),
                "pop",
                "pop() usuwa i zwraca ostatni element.",
            ),
            choice(
                "Co się stanie?",
                listOf("IndexError – stos jest pusty", "Zwróci None", "Zwróci 0", "Nic"),
                0,
                "Z pustej listy nie da się nic zdjąć.",
                code = "stos = []\nstos.pop()",
            ),
            tiles(
                "Zdejmij element ze szczytu stosu i zapisz go w zmiennej x",
                listOf("x", "=", "stos.pop()"),
                listOf("stos.append()", "stos[0]"),
                "pop() zwraca zdjęty element.",
            ),
        ),
        lesson(
            "u28l2", "Kolejka z deque",
            output(
                "from collections import deque\nq = deque()\nq.append(\"A\")\nq.append(\"B\")\nprint(q.popleft())",
                "A",
                "popleft() zdejmuje element z początku kolejki.",
            ),
            choice(
                "Co oznacza skrót FIFO opisujący kolejkę?",
                listOf("Pierwszy wszedł, pierwszy wychodzi", "Ostatni wszedł, pierwszy wychodzi", "Największy wychodzi pierwszy", "Losowa kolejność"),
                0,
                "First In, First Out – jak kolejka do kasy.",
            ),
            output(
                "from collections import deque\nq = deque([1, 2, 3])\nq.popleft()\nq.append(4)\nprint(list(q))",
                "[2, 3, 4]",
                "1 wychodzi z przodu, a 4 dołącza na końcu.",
            ),
            choice(
                "Dlaczego do kolejki lepiej użyć deque niż listy z pop(0)?",
                listOf(
                    "popleft() jest O(1), a pop(0) na liście jest O(n)",
                    "Lista nie ma metody pop",
                    "deque sortuje elementy",
                    "deque nie pozwala dodawać elementów",
                ),
                0,
                "pop(0) przesuwa wszystkie pozostałe elementy listy.",
            ),
            output(
                "from collections import deque\nkolejka = deque([\"Ola\", \"Jan\", \"Ewa\"])\nwhile kolejka:\n    osoba = kolejka.popleft()\n    print(osoba)",
                "Ola\nJan\nEwa",
                "Kolejka obsługuje osoby w kolejności przyjścia.",
            ),
            fill(
                "Uzupełnij, aby obsłużyć pierwszą osobę z kolejki.",
                "from collections import deque\nq = deque([\"Ola\", \"Jan\"])\nprint(q.____())",
                listOf("popleft", "pop", "append"),
                "popleft",
                "popleft() bierze element z początku kolejki.",
            ),
            output(
                "from collections import deque\nq = deque([1, 2, 3])\nx = q.popleft()\nq.append(x)\nprint(q[0], q[-1])",
                "2 1",
                "Pierwszy element przechodzi na koniec kolejki.",
            ),
            tiles(
                "Zaimportuj deque z modułu collections",
                listOf("from", "collections", "import", "deque"),
                listOf("deque.collections", "include"),
                "from moduł import nazwa.",
            ),
        ),
        lesson(
            "u28l3", "Sprawdzanie nawiasów",
            output(
                "licznik = 0\nfor z in \"(()())\":\n    if z == \"(\":\n        licznik += 1\n    else:\n        licznik -= 1\nprint(licznik)",
                "0",
                "Tyle samo nawiasów otwierających, co zamykających.",
            ),
            choice(
                "Dlaczego sam licznik nie wystarczy dla napisu „)(”?",
                listOf("Licznik da 0, a nawiasy są źle ułożone", "Licznik zgłosi błąd", "Licznik da 2", "Bo napis „)(” jest poprawny"),
                0,
                "Liczba się zgadza, ale nawias zamyka się, zanim został otwarty.",
            ),
            output(
                "def ok(s):\n    stos = []\n    for z in s:\n        if z == \"(\":\n            stos.append(z)\n        elif not stos:\n            return False\n        else:\n            stos.pop()\n    return not stos\nprint(ok(\"(())\"), ok(\"())(\"))",
                "True False",
                "W „())(” drugi „)” nie ma pary, bo stos jest już pusty.",
            ),
            output(
                "pary = {\")\": \"(\", \"]\": \"[\"}\nstos = []\nfor z in \"([)]\":\n    if z in \"([\":\n        stos.append(z)\n    elif stos and stos[-1] == pary[z]:\n        stos.pop()\n    else:\n        print(\"błąd przy\", z)\n        break",
                "błąd przy )",
                "Na szczycie leży „[”, a przyszedł „)” – nawiasy się krzyżują.",
            ),
            fill(
                "Uzupełnij, aby sprawdzić, czy nawias zamykający pasuje do ostatnio otwartego.",
                "pary = {\")\": \"(\", \"]\": \"[\"}\nstos = [\"(\", \"[\"]\nz = \"]\"\nprint(stos____ == pary[z])",
                listOf("[-1]", "[0]", ".pop(0)"),
                "[-1]",
                "Ostatnio otwarty nawias leży na szczycie stosu, czyli pod [-1].",
            ),
            output(
                "stos = []\nfor z in \"(()\":\n    if z == \"(\":\n        stos.append(z)\n    else:\n        stos.pop()\nprint(len(stos))",
                "1",
                "Jeden nawias został otwarty i nie zamknięty.",
            ),
            choice(
                "Kiedy napis z nawiasami jest poprawny?",
                listOf(
                    "Gdy każdy zamykający pasuje do ostatnio otwartego, a na końcu stos jest pusty",
                    "Gdy ma parzystą liczbę znaków",
                    "Gdy zaczyna się od „(”",
                    "Gdy liczba „(” jest równa liczbie „)”",
                ),
                0,
                "Trzeba sprawdzić i kolejność, i to, czy nic nie zostało otwarte.",
            ),
            tiles(
                "Zapisz w zmiennej poprawny, czy stos jest pusty",
                listOf("poprawny", "=", "len(stos) == 0"),
                listOf("len(stos) = 0", "stos.pop()"),
                "Pusty stos oznacza, że każdy nawias został zamknięty.",
            ),
        ),
        lesson(
            "u28l4", "Cofanie i kolejność przetwarzania",
            output(
                "historia = [\"a\", \"ab\", \"abc\"]\nhistoria.pop()\nprint(historia[-1])",
                "ab",
                "Cofnięcie zdejmuje ostatni stan i wraca do poprzedniego.",
            ),
            output(
                "stan = \"Ala\"\nhistoria = [stan]\nstan = stan + \" ma\"\nhistoria.append(stan)\nstan = stan + \" kota\"\nstan = historia.pop()\nprint(stan)",
                "Ala ma",
                "Ostatnio zapisany stan to „Ala ma”, więc do niego wracamy.",
            ),
            choice(
                "Jakiej struktury użyć do historii „cofnij” (Ctrl+Z)?",
                listOf("Stosu – cofamy ostatnią zmianę", "Kolejki – cofamy najstarszą zmianę", "Zbioru", "Krotki"),
                0,
                "Cofamy zawsze najnowszą zmianę – to LIFO.",
            ),
            output(
                "cofnij = [\"a\", \"b\", \"c\"]\nponow = []\nponow.append(cofnij.pop())\nponow.append(cofnij.pop())\ncofnij.append(ponow.pop())\nprint(cofnij, ponow)",
                "['a', 'b'] ['c']",
                "Dwa cofnięcia przenoszą c i b, a ponowienie oddaje b.",
            ),
            output(
                "from collections import deque\ndzieci = {\"A\": [\"B\", \"C\"], \"B\": [\"D\"],\n          \"C\": [\"E\"], \"D\": [], \"E\": []}\nq = deque([\"A\"])\nwynik = \"\"\nwhile q:\n    w = q.popleft()\n    wynik += w\n    q.extend(dzieci[w])\nprint(wynik)",
                "ABCDE",
                "Kolejka przetwarza poziomami: najpierw A, potem B i C, potem D i E.",
            ),
            output(
                "dzieci = {\"A\": [\"B\", \"C\"], \"B\": [\"D\"],\n          \"C\": [\"E\"], \"D\": [], \"E\": []}\nstos = [\"A\"]\nwynik = \"\"\nwhile stos:\n    w = stos.pop()\n    wynik += w\n    stos.extend(dzieci[w])\nprint(wynik)",
                "ACEBD",
                "Stos bierze ostatnio dodany element, więc idzie najpierw w głąb gałęzi C.",
            ),
            fill(
                "Uzupełnij, aby przetwarzać elementy w kolejności dodawania (wszerz).",
                "from collections import deque\ndzieci = {\"A\": [\"B\", \"C\"], \"B\": [], \"C\": []}\nq = deque([\"A\"])\nwynik = \"\"\nwhile q:\n    w = q.____()\n    wynik += w\n    q.extend(dzieci[w])\nprint(wynik)",
                listOf("popleft", "pop", "clear"),
                "popleft",
                "popleft() bierze najstarszy element, więc dostajemy ABC.",
            ),
            tiles(
                "Dodaj wszystkie dzieci elementu w na koniec kolejki q",
                listOf("q.extend(", "dzieci[w]", ")"),
                listOf("q.popleft(", "dzieci(w)"),
                "extend() dopisuje na koniec wszystkie elementy listy.",
            ),
        ),
        lesson(
            "u28l5", "Powtórka: stosy i kolejki",
            output(
                "s = []\ns.append(1)\ns.append(2)\ns.pop()\ns.append(3)\nprint(s)",
                "[1, 3]",
                "2 zostało zdjęte, zanim położyliśmy 3.",
            ),
            output(
                "from collections import deque\nq = deque()\nfor x in [5, 6, 7]:\n    q.append(x)\nq.popleft()\nprint(q[0])",
                "6",
                "5 wyszło z kolejki, więc na początku jest 6.",
            ),
            choice(
                "Klienci czekają przy kasie i są obsługiwani w kolejności przyjścia. Jaka to struktura?",
                listOf("Kolejka (FIFO)", "Stos (LIFO)", "Zbiór", "Krotka"),
                0,
                "Kto pierwszy przyszedł, ten pierwszy jest obsłużony.",
            ),
            choice(
                "Który kod zdejmuje element ze szczytu stosu zapisanego w liście stos?",
                listOf("stos.pop()", "stos.pop(0)", "stos.popleft()", "stos.remove()"),
                0,
                "Szczyt stosu to koniec listy, a pop() bez argumentu zdejmuje ostatni element.",
            ),
            output(
                "def ok(s):\n    stos = []\n    for z in s:\n        if z == \"(\":\n            stos.append(z)\n        elif stos:\n            stos.pop()\n        else:\n            return False\n    return len(stos) == 0\nprint(ok(\"()()\"), ok(\"(()\"))",
                "True False",
                "W „(()” jeden nawias zostaje na stosie.",
            ),
            fill(
                "Uzupełnij, aby dodać element na koniec kolejki.",
                "from collections import deque\nq = deque([1, 2])\nq.____(3)\nprint(list(q))",
                listOf("append", "appendleft", "popleft"),
                "append",
                "append() dodaje na koniec kolejki.",
            ),
            output(
                "stos = [1, 2, 3]\nodwr = []\nwhile stos:\n    odwr.append(stos.pop())\nprint(odwr)",
                "[3, 2, 1]",
                "Przekładanie ze stosu odwraca kolejność.",
            ),
            tiles(
                "Utwórz pustą kolejkę q",
                listOf("q", "=", "deque()"),
                listOf("deque[]", "=="),
                "deque() tworzy pustą kolejkę.",
            ),
        ),
    ),
)
