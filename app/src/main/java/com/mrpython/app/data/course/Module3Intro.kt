package com.mrpython.app.data.course

internal val module3Intro = lesson(
    "u3l0", "Wprowadzenie: operatory i warunki",
    explain(
        "Działania matematyczne",
        "Oprócz `+`, `-`, `*` i `/` Python ma `//` (dzielenie całkowite), `%` (reszta z dzielenia) " +
            "i `**` (potęga). Mnożenie wykonuje się przed dodawaniem, chyba że użyjesz nawiasów.",
        code = "print(7 // 2)\nprint(7 % 2)\nprint(2 ** 3)\nprint(2 + 3 * 4)",
        output = "3\n1\n8\n14",
    ),
    explain(
        "Porównania",
        "Porównanie daje `True` albo `False`. `==` sprawdza równość (pojedyncze `=` to przypisanie!), " +
            "`!=` – różność, a `<`, `>`, `<=`, `>=` porównują wielkość.",
        code = "print(3 > 2)\nprint(5 == 4)\nprint(5 != 4)",
        output = "True\nFalse\nTrue",
    ),
    explain(
        "and, or i not",
        "Warunki łączymy słowami: `and` – oba muszą być prawdziwe, `or` – wystarczy jeden, " +
            "a `not` odwraca wynik.",
        code = "print(5 > 1 and 2 > 3)\nprint(5 > 1 or 2 > 3)\nprint(not True)",
        output = "False\nTrue\nFalse",
    ),
    explain(
        "Instrukcja if",
        "`if` wykonuje kod tylko wtedy, gdy warunek jest prawdziwy, a `else` – w przeciwnym razie. " +
            "Po warunku stawiamy dwukropek, a kod w środku wcinamy 4 spacjami.",
        code = "wiek = 12\nif wiek >= 18:\n    print(\"dorosły\")\nelse:\n    print(\"dziecko\")",
        output = "dziecko",
    ),
    explain(
        "Wiele możliwości: elif",
        "`elif` znaczy „w przeciwnym razie, jeśli”. Python sprawdza warunki od góry " +
            "i wykonuje tylko pierwszy pasujący blok.",
        code = "t = 15\nif t > 25:\n    print(\"gorąco\")\nelif t > 10:\n    print(\"ciepło\")",
        output = "ciepło",
    ),
    output(
        "print(10 % 3)",
        "1",
        "10 = 3 · 3 + 1, więc reszta to 1.",
    ),
    choice(
        "Który operator sprawdza, czy dwie wartości są równe?",
        listOf("==", "=", "!=", "=>"),
        0,
        "== porównuje, a pojedyncze = przypisuje wartość.",
    ),
    output(
        "x = 3\nif x > 5:\n    print(\"duże\")\nelse:\n    print(\"małe\")",
        "małe",
        "3 nie jest większe od 5, więc wykona się blok else.",
    ),
)
