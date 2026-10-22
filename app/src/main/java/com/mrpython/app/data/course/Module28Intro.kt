package com.mrpython.app.data.course

internal val module28Intro = lesson(
    "u28l0", "Wprowadzenie: stosy i kolejki",
    explain(
        "Stos (LIFO)",
        "Stos działa jak sterta talerzy: kładziesz na górę i zdejmujesz z góry. Ostatni wszedł, " +
            "pierwszy wychodzi (LIFO). W Pythonie stos to zwykła lista: `append()` kładzie, `pop()` zdejmuje.",
        code = "stos = []\nstos.append(1)\nstos.append(2)\nprint(stos.pop())",
        output = "2",
    ),
    explain(
        "Szczyt stosu",
        "`stos[-1]` pozwala podejrzeć szczyt bez zdejmowania. Uwaga: `pop()` na pustej liście " +
            "zgłasza `IndexError`, więc przed zdjęciem warto sprawdzić, czy stos nie jest pusty.",
        code = "stos = [\"a\", \"b\"]\nprint(stos[-1])\nprint(len(stos))",
        output = "b\n2",
    ),
    explain(
        "Kolejka (FIFO) z deque",
        "Kolejka działa jak kolejka do kasy: kto pierwszy przyszedł, ten pierwszy wychodzi (FIFO). " +
            "Używamy `deque` z modułu `collections`: `append()` dodaje na koniec, `popleft()` bierze z początku w `O(1)`.",
        code = "from collections import deque\nq = deque([\"Ola\", \"Jan\"])\nq.append(\"Ewa\")\nprint(q.popleft())",
        output = "Ola",
    ),
    explain(
        "Sprawdzanie nawiasów",
        "Stos świetnie sprawdza nawiasy: otwierający kładziemy na stos, a zamykający musi pasować " +
            "do szczytu. Napis jest poprawny, gdy nic nie zabrakło i na końcu stos jest pusty.",
        code = "stos = []\nfor z in \"(()\":\n    if z == \"(\":\n        stos.append(z)\n    else:\n        stos.pop()\nprint(len(stos))",
        output = "1",
    ),
    explain(
        "Cofanie i kolejność",
        "Historia „cofnij” to stos – cofamy najnowszą zmianę. Kolejka przetwarza rzeczy w kolejności " +
            "dodania, a stos najpierw idzie w głąb najnowszych. `extend()` dodaje wiele elementów naraz.",
        code = "historia = [\"a\", \"ab\", \"abc\"]\nhistoria.pop()\nprint(historia[-1])",
        output = "ab",
    ),
    output(
        "stos = [1, 2, 3]\nstos.pop()\nstos.append(7)\nprint(stos)",
        "[1, 2, 7]",
        "pop() zdjęło 3, a append() położyło 7 na szczycie.",
    ),
    choice(
        "Która metoda deque bierze element z początku kolejki?",
        listOf("popleft()", "pop()", "append()", "extend()"),
        0,
        "popleft() zdejmuje element, który czekał najdłużej.",
    ),
    choice(
        "Co oznacza LIFO?",
        listOf("Ostatni wszedł, pierwszy wychodzi", "Pierwszy wszedł, pierwszy wychodzi", "Najmniejszy wychodzi pierwszy", "Losowa kolejność"),
        0,
        "Last In, First Out – tak działa stos.",
    ),
)
