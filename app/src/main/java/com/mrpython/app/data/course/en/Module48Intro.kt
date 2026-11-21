package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

internal val module48Intro = lesson(
    "u48l0", "Introduction: strings and Unicode",
    explain(
        "Characters are numbers",
        "Every character has its own number in the Unicode table. `ord(character)` returns the number, and " +
            "`chr(number)` turns it back into a character. Consecutive letters have consecutive numbers.",
        code = "print(ord(\"A\"), ord(\"a\"))\nprint(chr(66))\nprint(chr(ord(\"a\") + 1))",
        output = "65 97\nB\nb",
    ),
    explain(
        "Polish letters",
        "Letters outside the English alphabet, such as the Polish ones, are single characters too, just with " +
            "large numbers (e.g. ą is 261). So `len` counts them normally and `upper()` works, " +
            "but `sorted()` puts them after the letter z.",
        code = "print(len(\"żółw\"), ord(\"ą\"))\nprint(\"zażółć\".upper())\nprint(sorted([\"łódź\", \"most\"]))",
        output = "4 261\nZAŻÓŁĆ\n['most', 'łódź']",
    ),
    explain(
        "Bytes: encode and decode",
        "A computer stores text as bytes. `encode()` turns a string into `bytes` (UTF-8 by " +
            "default), and `decode()` turns bytes into a string. In UTF-8 a Polish letter takes 2 bytes.",
        code = "b = \"ą\".encode()\nprint(b, len(b))\nprint(b.decode())",
        output = "b'\\xc4\\x85' 2\ną",
    ),
    explain(
        "Checking characters",
        "The methods `isdigit()`, `isalpha()`, `isalnum()` and `isupper()` check whether a string consists " +
            "only of digits, of letters, of letters or digits, or of uppercase letters. A space or a period spoils the result.",
        code = "print(\"123\".isdigit(), \"12.5\".isdigit())\nprint(\"gęś\".isalpha(), \"Hi there\".isalpha())",
        output = "True False\nTrue False",
    ),
    explain(
        "casefold",
        "`casefold()` is a stronger version of `lower()`, made for comparisons regardless of " +
            "letter case – for example, it turns the German ß into ss.",
        code = "print(\"Straße\".casefold())\nprint(\"Łódź\".casefold() == \"ŁÓDŹ\".casefold())",
        output = "strasse\nTrue",
    ),
    output(
        "print(chr(ord(\"c\") + 1))",
        "d",
        "The number of c + 1 is the number of d.",
    ),
    choice(
        "How many bytes does the letter ł take in UTF-8?",
        listOf("2", "1", "3", "0"),
        0,
        "Polish letters take 2 bytes each in UTF-8.",
    ),
    fill(
        "Fill in the blank to turn the bytes back into a string.",
        "b = \"cat\".encode()\nprint(b.____())",
        listOf("decode", "encode", "upper"),
        "decode",
        "decode() turns bytes into a string.",
    ),
)
