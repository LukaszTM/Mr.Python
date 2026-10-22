package com.mrpython.app.data.course

internal val module13Cards = listOf(
    cards(
        "u13l1",
        explain(
            "Wartość bezwzględna: abs()",
            "`abs(x)` zwraca liczbę bez minusa – jej odległość od zera. Liczby dodatniej nie zmienia.",
            code = "print(abs(-3), abs(2))",
            output = "3 2",
        ),
        explain(
            "Napisy i funkcje",
            "Wyrażenie listowe działa na każdej kolekcji – także na napisie, znak po znaku. " +
                "Jako wyrażenie możesz wpisać metodę, funkcję wbudowaną albo własną funkcję.",
            code = "print([z.upper() for z in \"ok\"])\nprint([len(s) for s in [\"ab\", \"c\"]])",
            output = "['O', 'K']\n[2, 1]",
        ),
    ),
    cards(
        "u13l2",
        explain(
            "Filtr i zmiana naraz",
            "Możesz jednocześnie filtrować i zmieniać: najpierw `if` na końcu wybiera elementy, " +
                "a potem każdy wybrany zostaje przekształcony.",
            code = "print([x * 10 for x in range(6) if x % 2 == 1])",
            output = "[10, 30, 50]",
        ),
        explain(
            "Gdzie stoi if?",
            "`if` na końcu odrzuca elementy. `a if warunek else b` przed `for` niczego nie usuwa – " +
                "wybiera wartość dla każdego elementu. Gdy jest `else`, całość musi stać przed `for`.",
            code = "l = [3, -1]\nprint([x for x in l if x > 0])\nprint([x if x > 0 else 0 for x in l])",
            output = "[3]\n[3, 0]",
        ),
    ),
    cards(
        "u13l3",
        explain(
            "Dwie pętle: wszystkie pary",
            "Dwa `for` w jednym wyrażeniu tworzą wszystkie pary: dla każdego elementu pierwszej pętli " +
                "przechodzimy całą drugą. Dlatego druga zmienna zmienia się szybciej.",
            code = "print([a + b for a in \"xy\" for b in \"12\"])",
            output = "['x1', 'x2', 'y1', 'y2']",
        ),
        explain(
            "Zmienna _",
            "Gdy wartość zmiennej pętli nie jest potrzebna, nazywamy ją `_`. To zwykła nazwa, " +
                "która mówi: „po prostu powtórz to tyle razy”.",
            code = "print([\"hej\" for _ in range(3)])",
            output = "['hej', 'hej', 'hej']",
        ),
    ),
    cards(
        "u13l4",
        explain(
            "Słownik ze słownika",
            "`items()` daje klucz i wartość, więc łatwo zbudujesz nowy słownik: zmienisz wartości, " +
                "zamienisz klucze z wartościami albo dodasz filtr `if`.",
            code = "d = {\"a\": 1, \"b\": 5}\nprint({k: v * 2 for k, v in d.items() if v > 2})\nprint({v: k for k, v in d.items()})",
            output = "{'b': 10}\n{1: 'a', 5: 'b'}",
        ),
        explain(
            "Powtórzone klucze",
            "Klucze w słowniku się nie powtarzają. Gdy wyrażenie da ten sam klucz drugi raz, " +
                "nowa wartość nadpisze starą.",
            code = "print({s[0]: s for s in [\"ala\", \"ania\"]})",
            output = "{'a': 'ania'}",
        ),
    ),
)
