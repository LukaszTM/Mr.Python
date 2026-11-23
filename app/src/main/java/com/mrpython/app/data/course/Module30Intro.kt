package com.mrpython.app.data.course

internal val module30Intro = lesson(
    "u30l0", "Wprowadzenie: algorytmy na napisach",
    explain(
        "Odwracanie i palindromy",
        "Wycinek `[::-1]` czyta napis od końca. Palindrom to słowo, które od tyłu wygląda tak samo, " +
            "np. „kajak”. Przed porównaniem warto usunąć spacje i zamienić litery na małe przez `lower()`.",
        code = "s = \"Kajak\".lower()\nprint(s[::-1])\nprint(s == s[::-1])",
        output = "kajak\nTrue",
    ),
    explain(
        "Anagramy",
        "Anagramy to słowa z tych samych liter w innej kolejności, np. „kosz” i „szok”. " +
            "Najprościej to sprawdzić, porównując posortowane litery: `sorted()` na napisie daje listę liter.",
        code = "print(sorted(\"kosz\"))\nprint(sorted(\"kosz\") == sorted(\"szok\"))",
        output = "['k', 'o', 's', 'z']\nTrue",
    ),
    explain(
        "Liczenie znaków",
        "Ile razy występuje każda litera? Użyj słownika: `d.get(z, 0)` daje dotychczasową liczbę " +
            "albo 0, jeśli litery jeszcze nie było. Wystarczy jedno przejście przez napis.",
        code = "d = {}\nfor z in \"banan\":\n    d[z] = d.get(z, 0) + 1\nprint(d)",
        output = "{'b': 1, 'a': 2, 'n': 2}",
    ),
    explain(
        "Kody znaków",
        "Każdy znak ma swój numer. `ord()` zamienia znak na kod, a `chr()` kod z powrotem na znak. " +
            "Dodając do kodu liczbę, przesuwamy literę w alfabecie.",
        code = "print(ord(\"a\"), chr(98))\nprint(chr(ord(\"c\") + 3))",
        output = "97 b\nf",
    ),
    explain(
        "Szyfr Cezara",
        "Szyfr Cezara przesuwa każdą literę o stałą liczbę miejsc. Żeby po „z” wrócić na początek " +
            "alfabetu, liczymy pozycję litery i bierzemy resztę `% 26`. Odszyfrowanie to przesunięcie wstecz.",
        code = "z = \"y\"\nk = (ord(z) - ord(\"a\") + 3) % 26\nprint(chr(ord(\"a\") + k))",
        output = "b",
    ),
    output(
        "print(\"lato\"[::-1])",
        "otal",
        "[::-1] odwraca kolejność liter.",
    ),
    choice(
        "Jak sprawdzić, czy napisy a i b są anagramami?",
        listOf("sorted(a) == sorted(b)", "a == b[::-1]", "len(a) == len(b)", "a.lower() == b"),
        0,
        "Anagramy mają te same litery, więc po posortowaniu są równe.",
    ),
    fill(
        "Uzupełnij, aby wypisać kod znaku „a”.",
        "print(____(\"a\"))",
        listOf("ord", "chr", "len"),
        "ord",
        "ord() zamienia znak na jego kod liczbowy.",
    ),
)
