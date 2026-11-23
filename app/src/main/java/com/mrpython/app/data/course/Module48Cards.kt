package com.mrpython.app.data.course

internal val module48Cards = listOf(
    cards(
        "u48l1",
        explain(
            "Kody ASCII",
            "Pierwsze 128 znaków to ASCII. Wielkie litery A–Z mają kody 65–90, małe a–z 97–122, " +
                "a cyfry jako znaki '0'–'9' to 48–57. Mała litera ma kod o 32 większy od wielkiej, " +
                "a spacja to 32.",
            code = "print(ord(\"A\"), ord(\"a\"), ord(\"0\"))\nprint(chr(ord(\"k\") - 32))",
            output = "65 97 48\nK",
        ),
        explain(
            "ord tylko dla jednego znaku",
            "`ord()` przyjmuje dokładnie jeden znak – dla dłuższego napisu zgłosi `TypeError`. " +
                "Kody całego słowa zbierzesz pętlą albo wyrażeniem listowym.",
            code = "print([ord(z) for z in \"abc\"])",
            output = "[97, 98, 99]",
        ),
    ),
    cards(
        "u48l2",
        explain(
            "Porównywanie napisów",
            "Polskie litery mają duże kody, np. ą 261, ó 243, ę 281, ł 322, ż 380. Napisy porównujemy " +
                "znak po znaku według kodów. Dlatego \"ą\" (261) jest większe niż \"z\" (122), a wielkie " +
                "litery są „mniejsze” od małych – trafiają w sortowaniu na początek.",
            code = "print(ord(\"ę\"), ord(\"ł\"), ord(\"ż\"))\nprint(\"ą\" > \"z\", \"B\" < \"a\")\nprint(sorted([\"zebra\", \"żaba\", \"Ala\"]))",
            output = "281 322 380\nTrue True\n['Ala', 'zebra', 'żaba']",
        ),
    ),
    cards(
        "u48l3",
        explain(
            "Jak wyglądają bajty",
            "Bajty wypisują się z literą `b` przed cudzysłowem. Znaki ASCII widać normalnie, a inne " +
                "bajty jako `\\x` i dwie cyfry szesnastkowe. Typ wyniku `encode()` to `bytes`. Polska litera " +
                "zajmuje w UTF-8 2 bajty, ale niektóre znaki więcej – np. znak euro € aż 3.",
            code = "print(\"ał\".encode())\nprint(\"ę\".encode(), \"ó\".encode(), \"ż\".encode())\nprint(type(b\"a\").__name__)",
            output = "b'a\\xc5\\x82'\nb'\\xc4\\x99' b'\\xc3\\xb3' b'\\xc5\\xbc'\nbytes",
        ),
        explain(
            "Kodowanie ascii",
            "`encode(\"ascii\")` działa tylko dla znaków ASCII – polska litera da `UnicodeEncodeError`. " +
                "Pamiętaj też, że bajty to nie napis: `b\"abc\" == \"abc\"` daje `False`.",
            code = "print(\"Ala\".encode(\"ascii\"))\nprint(b\"abc\" == \"abc\")",
            output = "b'Ala'\nFalse",
        ),
    ),
    cards(
        "u48l4",
        explain(
            "islower i pusty napis",
            "`islower()` sprawdza, czy wszystkie litery są małe. `isupper()` i `islower()` patrzą tylko " +
                "na litery – cyfry im nie przeszkadzają. Dla pustego napisu `isdigit()`, `isalpha()`, `isalnum()`, " +
                "`isupper()` i `islower()` dają `False`.",
            code = "print(\"łąka\".islower(), \"X1\".isupper())\nprint(\"\".isdigit())",
            output = "True True\nFalse",
        ),
    ),
)
