package com.mrpython.app.data.course

internal val module26Intro = lesson(
    "u26l0", "Wprowadzenie: sortowanie",
    explain(
        "Sortowanie bąbelkowe",
        "Sortowanie to układanie elementów w kolejności. Najprostszy sposób: porównuj sąsiadów " +
            "i zamieniaj ich, gdy są w złej kolejności. Po jednym przejściu największy element " +
            "„wypływa” na koniec jak bąbelek.",
        code = "a = [3, 1, 2]\nfor i in range(len(a) - 1):\n    if a[i] > a[i + 1]:\n        a[i], a[i + 1] = a[i + 1], a[i]\nprint(a)",
        output = "[1, 2, 3]",
    ),
    explain(
        "Przez wybieranie",
        "Sortowanie przez wybieranie szuka najmniejszego elementu i stawia go na pierwsze " +
            "miejsce, potem kolejne minimum na drugie i tak dalej. Pomaga w tym `min()` i `index()`.",
        code = "a = [4, 2, 7, 1]\nm = a.index(min(a))\na[0], a[m] = a[m], a[0]\nprint(a)",
        output = "[1, 2, 7, 4]",
    ),
    explain(
        "Przez wstawianie",
        "Sortowanie przez wstawianie działa jak układanie kart w ręce: bierzemy kolejny element " +
            "i wsuwamy go we właściwe miejsce już posortowanej części. Większe elementy przesuwają się w prawo.",
        code = "karty = [2, 5, 8]\nx = 6\ni = 0\nwhile karty[i] < x:\n    i += 1\nkarty.insert(i, x)\nprint(karty)",
        output = "[2, 5, 6, 8]",
    ),
    explain(
        "sorted() z key i reverse",
        "W praktyce używamy gotowego `sorted()` – zwraca nową listę, a oryginał zostawia. " +
            "`reverse=True` sortuje malejąco, a `key=` mówi, według czego porównywać, np. `key=len`. " +
            "Metoda `a.sort()` sortuje listę w miejscu i zwraca `None`.",
        code = "slowa = [\"banan\", \"kiwi\", \"jabłko\"]\nprint(sorted(slowa, key=len))\nprint(sorted([3, 1, 2], reverse=True))",
        output = "['kiwi', 'banan', 'jabłko']\n[3, 2, 1]",
    ),
    explain(
        "Kilka kluczy i słowniki",
        "Klucz może zwracać krotkę – wtedy przy remisie decyduje drugi element. Sortowanie jest " +
            "stabilne: równe elementy zachowują kolejność. Słownik sortujemy po wartościach przez " +
            "`items()` i `key=lambda x: x[1]`.",
        code = "punkty = {\"Ola\": 7, \"Jan\": 9, \"Ewa\": 5}\nfor imie, p in sorted(punkty.items(), key=lambda x: x[1]):\n    print(imie, p)",
        output = "Ewa 5\nOla 7\nJan 9",
    ),
    output(
        "print(sorted([5, 1, 4], reverse=True))",
        "[5, 4, 1]",
        "reverse=True ustawia elementy od największego.",
    ),
    choice(
        "Co zwraca metoda a.sort()?",
        listOf("None", "Nową posortowaną listę", "Najmniejszy element", "Długość listy"),
        0,
        "sort() zmienia samą listę i niczego nie zwraca.",
    ),
    fill(
        "Uzupełnij, aby posortować słowa według długości.",
        "slowa = [\"ala\", \"i\", \"kotek\"]\nprint(sorted(slowa, ____=len))",
        listOf("key", "by", "len"),
        "key",
        "Parametr key mówi, według czego porównywać elementy.",
    ),
)
