package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

internal val module30Intro = lesson(
    "u30l0", "Introduction: string algorithms",
    explain(
        "Reversing and palindromes",
        "The slice `[::-1]` reads a string from the end. A palindrome is a word that looks the same backwards, " +
            "e.g. “kayak”. Before comparing, it's a good idea to remove spaces and change the letters to lowercase with `lower()`.",
        code = "s = \"Kayak\".lower()\nprint(s[::-1])\nprint(s == s[::-1])",
        output = "kayak\nTrue",
    ),
    explain(
        "Anagrams",
        "Anagrams are words made of the same letters in a different order, e.g. “stop” and “pots”. " +
            "The easiest way to check is to compare the sorted letters: `sorted()` on a string gives a list of letters.",
        code = "print(sorted(\"stop\"))\nprint(sorted(\"stop\") == sorted(\"pots\"))",
        output = "['o', 'p', 's', 't']\nTrue",
    ),
    explain(
        "Counting characters",
        "How many times does each letter appear? Use a dictionary: `d.get(ch, 0)` gives the count so far, " +
            "or 0 if the letter hasn't appeared yet. A single pass through the string is enough.",
        code = "d = {}\nfor ch in \"banana\":\n    d[ch] = d.get(ch, 0) + 1\nprint(d)",
        output = "{'b': 1, 'a': 3, 'n': 2}",
    ),
    explain(
        "Character codes",
        "Every character has its own number. `ord()` turns a character into its code, and `chr()` turns a code back " +
            "into a character. By adding a number to the code, we shift the letter in the alphabet.",
        code = "print(ord(\"a\"), chr(98))\nprint(chr(ord(\"c\") + 3))",
        output = "97 b\nf",
    ),
    explain(
        "Caesar cipher",
        "The Caesar cipher shifts every letter by a fixed number of places. To go back to the start of the alphabet " +
            "after “z”, we compute the letter's position and take the remainder `% 26`. Decrypting is a shift backwards.",
        code = "ch = \"y\"\nk = (ord(ch) - ord(\"a\") + 3) % 26\nprint(chr(ord(\"a\") + k))",
        output = "b",
    ),
    output(
        "print(\"star\"[::-1])",
        "rats",
        "[::-1] reverses the order of the letters.",
    ),
    choice(
        "How do you check whether the strings a and b are anagrams?",
        listOf("sorted(a) == sorted(b)", "a == b[::-1]", "len(a) == len(b)", "a.lower() == b"),
        0,
        "Anagrams have the same letters, so after sorting they are equal.",
    ),
    fill(
        "Fill in the blank to print the code of the character “a”.",
        "print(____(\"a\"))",
        listOf("ord", "chr", "len"),
        "ord",
        "ord() turns a character into its numeric code.",
    ),
)
