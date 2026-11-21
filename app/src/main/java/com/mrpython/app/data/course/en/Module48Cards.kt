package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

internal val module48Cards = listOf(
    cards(
        "u48l1",
        explain(
            "ASCII codes",
            "The first 128 characters are ASCII. Uppercase letters A–Z have codes 65–90, lowercase a–z 97–122, " +
                "and the digits as characters '0'–'9' are 48–57. A lowercase letter's code is 32 greater than " +
                "its uppercase one, and the space is 32.",
            code = "print(ord(\"A\"), ord(\"a\"), ord(\"0\"))\nprint(chr(ord(\"k\") - 32))",
            output = "65 97 48\nK",
        ),
        explain(
            "ord takes just one character",
            "`ord()` accepts exactly one character – for a longer string it raises a `TypeError`. " +
                "You can collect the codes of a whole word with a loop or a list comprehension.",
            code = "print([ord(ch) for ch in \"abc\"])",
            output = "[97, 98, 99]",
        ),
    ),
    cards(
        "u48l2",
        explain(
            "Comparing strings",
            "Strings are compared character by character according to their codes. That's why \"ą\" (261) is greater than " +
                "\"z\" (122), and uppercase letters are \"smaller\" than lowercase ones – they end up first when sorting.",
            code = "print(\"ą\" > \"z\", \"B\" < \"a\")\nprint(sorted([\"zebra\", \"żaba\", \"Amy\"]))",
            output = "True True\n['Amy', 'zebra', 'żaba']",
        ),
    ),
    cards(
        "u48l3",
        explain(
            "What bytes look like",
            "Bytes are printed with the letter `b` before the quote. ASCII characters show up normally, and other " +
                "bytes as `\\x` and two hexadecimal digits. The type of the result of `encode()` is `bytes`.",
            code = "print(\"ał\".encode())\nprint(type(b\"a\").__name__)",
            output = "b'a\\xc5\\x82'\nbytes",
        ),
        explain(
            "The ascii encoding",
            "`encode(\"ascii\")` works only for ASCII characters – a Polish letter gives a `UnicodeEncodeError`. " +
                "Also remember that bytes are not a string: `b\"abc\" == \"abc\"` gives `False`.",
            code = "print(\"Amy\".encode(\"ascii\"))\nprint(b\"abc\" == \"abc\")",
            output = "b'Amy'\nFalse",
        ),
    ),
    cards(
        "u48l4",
        explain(
            "islower and the empty string",
            "`islower()` checks whether all the letters are lowercase. `isupper()` and `islower()` look only " +
                "at letters – digits don't bother them. An empty string gives `False` in all the `is…` methods.",
            code = "print(\"łąka\".islower(), \"X1\".isupper())\nprint(\"\".isdigit())",
            output = "True True\nFalse",
        ),
    ),
)
