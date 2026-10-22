package com.mrpython.app.data.course

internal val module48Intro = lesson(
    "u48l0", "Wprowadzenie: napisy i Unicode",
    explain(
        "Znaki to numery",
        "Każdy znak ma swój numer w tablicy Unicode. `ord(znak)` zwraca numer, a `chr(numer)` " +
            "zamienia go z powrotem na znak. Kolejne litery mają kolejne numery.",
        code = "print(ord(\"A\"), ord(\"a\"))\nprint(chr(66))\nprint(chr(ord(\"a\") + 1))",
        output = "65 97\nB\nb",
    ),
    explain(
        "Polskie litery",
        "Polskie litery też są pojedynczymi znakami, tylko z dużymi numerami (np. ą to 261). " +
            "Dlatego `len` liczy je normalnie, `upper()` działa, ale `sorted()` stawia je za literą z.",
        code = "print(len(\"żółw\"), ord(\"ą\"))\nprint(\"zażółć\".upper())\nprint(sorted([\"łódź\", \"most\"]))",
        output = "4 261\nZAŻÓŁĆ\n['most', 'łódź']",
    ),
    explain(
        "Bajty: encode i decode",
        "Komputer zapisuje tekst jako bajty. `encode()` zamienia napis na `bytes` (domyślnie " +
            "UTF-8), a `decode()` – bajty na napis. W UTF-8 polska litera zajmuje 2 bajty.",
        code = "b = \"ą\".encode()\nprint(b, len(b))\nprint(b.decode())",
        output = "b'\\xc4\\x85' 2\ną",
    ),
    explain(
        "Sprawdzanie znaków",
        "Metody `isdigit()`, `isalpha()`, `isalnum()` i `isupper()` sprawdzają, czy napis składa " +
            "się tylko z cyfr, liter, liter lub cyfr albo wielkich liter. Spacja i kropka psują wynik.",
        code = "print(\"123\".isdigit(), \"12.5\".isdigit())\nprint(\"gęś\".isalpha(), \"Ala ma\".isalpha())",
        output = "True False\nTrue False",
    ),
    explain(
        "casefold",
        "`casefold()` to mocniejsza wersja `lower()`, stworzona do porównań bez względu na " +
            "wielkość liter – np. niemieckie ß zamienia na ss.",
        code = "print(\"Straße\".casefold())\nprint(\"Łódź\".casefold() == \"ŁÓDŹ\".casefold())",
        output = "strasse\nTrue",
    ),
    output(
        "print(chr(ord(\"c\") + 1))",
        "d",
        "Numer c + 1 to numer d.",
    ),
    choice(
        "Ile bajtów zajmuje litera ł w UTF-8?",
        listOf("2", "1", "3", "0"),
        0,
        "Polskie litery w UTF-8 zajmują po 2 bajty.",
    ),
    fill(
        "Uzupełnij, aby zamienić bajty z powrotem na napis.",
        "b = \"kot\".encode()\nprint(b.____())",
        listOf("decode", "encode", "upper"),
        "decode",
        "decode() zamienia bajty na napis.",
    ),
)
