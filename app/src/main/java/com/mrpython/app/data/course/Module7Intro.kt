package com.mrpython.app.data.course

internal val module7Intro = lesson(
    "u7l0", "Wprowadzenie: napisy od środka",
    explain(
        "Napis to ciąg znaków",
        "Każdy znak napisu ma indeks, tak jak element listy – pierwszy ma 0, a ostatni -1. " +
            "`len()` mówi, ile znaków ma napis (spacje też się liczą).",
        code = "s = \"Python\"\nprint(s[0])\nprint(s[-1])\nprint(len(s))",
        output = "P\nn\n6",
    ),
    explain(
        "Wycinki",
        "`s[od:do]` wycina fragment napisu (bez znaku o indeksie `do`). Trzecia liczba to krok, " +
            "a `[::-1]` odwraca napis. Napisów nie można zmieniać – zawsze powstaje nowy.",
        code = "s = \"Python\"\nprint(s[0:2])\nprint(s[2:])\nprint(s[::-1])",
        output = "Py\nthon\nnohtyP",
    ),
    explain(
        "Metody napisów",
        "Metody wywołujemy po kropce. `upper()` i `lower()` zmieniają wielkość liter, `strip()` usuwa " +
            "spacje z brzegów, a `replace()` podmienia fragment.",
        code = "print(\"hej\".upper())\nprint(\"  ok  \".strip() + \"!\")\nprint(\"Ala ma kota\".replace(\"kota\", \"psa\"))",
        output = "HEJ\nok!\nAla ma psa",
    ),
    explain(
        "split() i join()",
        "`split()` dzieli napis na listę słów, a `join()` skleja listę napisów w jeden, " +
            "wstawiając między nie separator.",
        code = "slowa = \"Ala ma kota\".split()\nprint(slowa)\nprint(\"-\".join(slowa))",
        output = "['Ala', 'ma', 'kota']\nAla-ma-kota",
    ),
    explain(
        "Szukanie w napisie",
        "`in` sprawdza, czy fragment występuje w napisie, `count()` liczy wystąpienia, " +
            "a `find()` podaje indeks, od którego fragment się zaczyna.",
        code = "print(\"th\" in \"Python\")\nprint(\"banan\".count(\"a\"))\nprint(\"python\".find(\"th\"))",
        output = "True\n2\n2",
    ),
    output(
        "s = \"kotek\"\nprint(s[1:3])",
        "ot",
        "Wycinek [1:3] to znaki o indeksach 1 i 2.",
    ),
    choice(
        "Która metoda zamieni „ala” na „ALA”?",
        listOf("upper()", "lower()", "strip()", "split()"),
        0,
        "upper() zamienia litery na wielkie.",
    ),
    fill(
        "Uzupełnij, aby podzielić zdanie na słowa.",
        "zdanie = \"lubię Pythona\"\nprint(zdanie.____())",
        listOf("split", "upper", "strip"),
        "split",
        "split() dzieli napis na listę słów.",
    ),
)
