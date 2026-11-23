package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

internal val module30Cards = listOf(
    cards(
        "u30l1",
        explain(
            "Reversing the word order",
            "`[::-1]` works on lists too. To reverse the order of words, break the sentence up with `split()`, " +
                "reverse the list and glue it back together with `\" \".join()`.",
            code = "words = \"Anna has cats\".split()\nprint(words[::-1])\nprint(\" \".join(words[::-1]))",
            output = "['cats', 'has', 'Anna']\ncats has Anna",
        ),
        explain(
            "A palindrome with spaces",
            "In a sentence, spaces and uppercase letters get in the way. `replace(\" \", \"\")` removes all the spaces, " +
                "and `lower()` changes the letters to lowercase – only then do we compare with the reverse.",
            code = "s = \"Never odd or even\"\nt = s.replace(\" \", \"\").lower()\nprint(t)\nprint(t == t[::-1])",
            output = "neveroddoreven\nTrue",
        ),
        explain(
            "Uppercase first letter",
            "`s[0].upper() + s[1:]` changes only the first letter of a word to uppercase. The `title()` method " +
                "does it right away for every word in the string.",
            code = "s = \"anna\"\nprint(s[0].upper() + s[1:])\nprint(\"john smith\".title())",
            output = "Anna\nJohn Smith",
        ),
    ),
    cards(
        "u30l2",
        explain(
            "Sorted letters as a string",
            "`sorted(s)` returns a list of letters. `\"\".join(sorted(s))` glues it into a string – all anagrams " +
                "give the same string, so it can serve as a key in a dictionary that groups them.",
            code = "print(\"\".join(sorted(\"bets\")))\nprint(\"\".join(sorted(\"best\")))",
            output = "best\nbest",
        ),
        explain(
            "Why not set()?",
            "A set only remembers which letters appeared, not how many times. That's why `set()` treats “teen” and “ten” " +
                "as equal, while `sorted()` correctly spots the difference.",
            code = "print(set(\"teen\") == set(\"ten\"))\nprint(sorted(\"teen\") == sorted(\"ten\"))",
            output = "True\nFalse",
        ),
        explain(
            "Comparing counters",
            "You can also check anagrams by counting the letters in dictionaries. Two dictionaries are equal when they have " +
                "the same keys and values – the order of the keys doesn't matter.",
            code = "print({\"a\": 2, \"t\": 1} == {\"t\": 1, \"a\": 2})",
            output = "True",
        ),
    ),
    cards(
        "u30l3",
        explain(
            "The most frequent character",
            "`max(d, key=d.get)` goes through the dictionary's keys but compares their values – it returns the key " +
                "with the highest count. In the same way, `sorted(d, key=d.get)` orders the keys from the smallest value.",
            code = "d = {\"a\": 2, \"b\": 5, \"c\": 1}\nprint(max(d, key=d.get))\nprint(sorted(d, key=d.get))",
            output = "b\n['c', 'a', 'b']",
        ),
        explain(
            "Pairs from the largest",
            "`d.items()` gives (character, count) pairs. When sorting with `key=lambda p: -p[1]`, we compare the counts " +
                "with a minus sign, so the largest ones end up first.",
            code = "d = {\"x\": 1, \"y\": 3}\nprint(sorted(d.items(), key=lambda p: -p[1]))",
            output = "[('y', 3), ('x', 1)]",
        ),
    ),
    cards(
        "u30l4",
        explain(
            "Decrypting",
            "To decrypt, we shift the letters back by the key, that is by `-k`. `% 26` works for negative numbers " +
                "too: `-1 % 26` gives 25, so before “a” we go back to “z”.",
            code = "print(-1 % 26)\nn = (ord(\"a\") - 97 - 1) % 26\nprint(chr(97 + n))",
            output = "25\nz",
        ),
        explain(
            "Uppercase letters and spaces",
            "Uppercase letters have different codes than lowercase ones: “A” is 65 and “a” is 97. When encrypting, spaces " +
                "and other characters are usually copied unchanged, after checking for them with an `if` condition.",
            code = "print(ord(\"A\"), ord(\"a\"))\nprint(chr(65 + 25))",
            output = "65 97\nZ",
        ),
        explain(
            "Encrypting in one line",
            "Instead of adding letters in a loop, we can pass a generator expression straight to `\"\".join()` – " +
                "it glues all the shifted characters into a string.",
            code = "s = \"abc\"\nprint(\"\".join(chr(ord(ch) + 1) for ch in s))",
            output = "bcd",
        ),
    ),
)
