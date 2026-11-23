package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*
import com.mrpython.app.domain.CourseUnit

internal val module30 = CourseUnit(
    id = "u30",
    title = "String algorithms",
    description = "Palindromes, anagrams, counting characters and the Caesar cipher",
    lessons = listOf(
        lesson(
            "u30l1", "Reversing and palindromes",
            output("print(\"python\"[::-1])", "nohtyp", "[::-1] reads the string from the end."),
            output(
                "sentence = \"Anna has cats\"\nprint(\" \".join(sentence.split()[::-1]))",
                "cats has Anna",
                "We reverse the list of words, not the letters.",
            ),
            output(
                "words = \"anna has cats\".split()\ncapital = [w[0].upper() + w[1:] for w in words]\nprint(\" \".join(capital))",
                "Anna Has Cats",
                "The first letter of each word becomes uppercase, the rest stays the same.",
            ),
            output(
                "def palindrome(s):\n    return s == s[::-1]\n\nprint(palindrome(\"kayak\"), palindrome(\"kitten\"))",
                "True False",
                "“kayak” read backwards doesn't change, “kitten” does.",
            ),
            output(
                "s = \"Never odd or even\"\nt = s.replace(\" \", \"\").lower()\nprint(t == t[::-1])",
                "True",
                "After removing the spaces and switching to lowercase, the string is a palindrome.",
            ),
            fill(
                "Fill in the blank so the comparison ignores letter case.",
                "s = \"Anna\"\nt = s.____()\nprint(t == t[::-1])",
                listOf("lower", "strip", "title"),
                "lower",
                "After lower() we get “anna”, which is a palindrome.",
            ),
            choice(
                "Why does \"Kayak\" == \"Kayak\"[::-1] give False?",
                listOf(
                    "The uppercase K at the start is a different character than the lowercase k at the end",
                    "Because [::-1] doesn't work on strings",
                    "Because the word kayak is not a palindrome",
                    "Because strings can't be compared",
                ),
                0,
                "The comparison is case-sensitive – you need to use lower().",
            ),
            tiles(
                "Store the words from the list words in reverse order in the variable rev",
                listOf("rev", "=", "words[::-1]"),
                listOf("words[::1]", "words[-1]"),
                "A slice with step -1 reverses the list.",
            ),
        ),
        lesson(
            "u30l2", "Anagrams",
            choice(
                "When are two words anagrams?",
                listOf(
                    "When they are made of the same letters, each used the same number of times",
                    "When they have the same length",
                    "When they start with the same letter",
                    "When one is the reverse of the other",
                ),
                0,
                "An anagram is a rearrangement of letters, e.g. “stop” and “pots”.",
            ),
            output("print(sorted(\"stop\") == sorted(\"pots\"))", "True", "After sorting the letters, both words give the same list."),
            output(
                "def anagram(a, b):\n    return sorted(a) == sorted(b)\n\nprint(anagram(\"tea\", \"eat\"), anagram(\"ten\", \"teen\"))",
                "True False",
                "“teen” has one more “e” than “ten”.",
            ),
            output(
                "def norm(s):\n    return sorted(s.replace(\" \", \"\").lower())\n\nprint(norm(\"Tea\") == norm(\"e at\"))",
                "True",
                "After removing the spaces and switching to lowercase, both have the letters a, e, t.",
            ),
            output(
                "d = {}\nfor ch in \"abba\":\n    d[ch] = d.get(ch, 0) + 1\nprint(d)",
                "{'a': 2, 'b': 2}",
                "The dictionary counts how many times each letter appeared.",
            ),
            output(
                "def count(s):\n    d = {}\n    for ch in s:\n        d[ch] = d.get(ch, 0) + 1\n    return d\n\nprint(count(\"care\") == count(\"race\"))",
                "True",
                "Dictionaries are equal when they have the same keys and values – the order doesn't matter.",
            ),
            fill(
                "Fill in the blank to check whether the words are anagrams.",
                "a, b = \"night\", \"thing\"\nprint(sorted(a) == ____(b))",
                listOf("sorted", "list", "set"),
                "sorted",
                "Both sides must be sorted lists of letters.",
            ),
            tiles(
                "Print whether the strings a and b are anagrams",
                listOf("print(sorted(a)", "==", "sorted(b))"),
                listOf("sorted(b)", "="),
                "We compare the sorted letters of both strings.",
            ),
        ),
        lesson(
            "u30l3", "Counting characters",
            output(
                "counter = {}\nfor ch in \"banana\":\n    counter[ch] = counter.get(ch, 0) + 1\nprint(counter)",
                "{'b': 1, 'a': 3, 'n': 2}",
                "get(ch, 0) returns 0 for a letter that isn't in the dictionary yet.",
            ),
            output(
                "counter = {\"a\": 3, \"k\": 1, \"t\": 2}\nprint(max(counter, key=counter.get))",
                "a",
                "key=counter.get compares the keys by their values.",
            ),
            fill(
                "Fill in the blank to increase the counter of the letter ch, even when it isn't in the dictionary yet.",
                "d = {}\nfor ch in \"eve\":\n    d[ch] = d.____(ch, 0) + 1\nprint(d)",
                listOf("get", "keys", "values"),
                "get",
                "d.get(ch, 0) gives 0 when the key ch is missing.",
            ),
            output(
                "text = \"watermelon\"\nvowels = {v: text.count(v) for v in \"aeo\"}\nprint(vowels)",
                "{'a': 1, 'e': 2, 'o': 1}",
                "The word “watermelon” has one a, two e's and one o.",
            ),
            choice(
                "Why is a dictionary better for counting all the letters than calling text.count(ch) for every letter?",
                listOf(
                    "count() walks through the whole string every time, while a dictionary counts in a single pass",
                    "count() doesn't work on strings",
                    "A dictionary sorts the letters by itself",
                    "There is no difference",
                ),
                0,
                "A single pass is O(n), while count() for every letter can give O(n²).",
            ),
            output(
                "d = {}\nfor ch in \"kitten\":\n    d[ch] = d.get(ch, 0) + 1\nprint([ch for ch in d if d[ch] == 1])",
                "['k', 'i', 'e', 'n']",
                "Only t appears twice, the other letters appear once.",
            ),
            output(
                "d = {\"x\": 1, \"y\": 3, \"z\": 2}\npairs = sorted(d.items(), key=lambda p: -p[1])\nfor char, n in pairs:\n    print(char, n)",
                "y 3\nz 2\nx 1",
                "The minus in front of the value sorts from the most frequent character.",
            ),
            tiles(
                "Increase the counter of the character ch in the dictionary d",
                listOf("d[ch]", "=", "d.get(ch, 0)", "+ 1"),
                listOf("d[ch, 0]", "=="),
                "We take the count so far (or 0) and add 1.",
            ),
        ),
        lesson(
            "u30l4", "Caesar cipher",
            output("print(ord(\"a\"), chr(98))", "97 b", "ord() gives the code of a character, and chr() turns a code back into a character."),
            output("ch = \"c\"\nprint(chr(ord(ch) + 3))", "f", "The code of the letter c increased by 3 is the code of the letter f."),
            output(
                "ch = \"y\"\nk = (ord(ch) - ord(\"a\") + 3) % 26\nprint(chr(ord(\"a\") + k))",
                "b",
                "y is position 24, 24 + 3 = 27, and 27 % 26 = 1, which is b.",
            ),
            choice(
                "What is % 26 for in the Caesar cipher?",
                listOf(
                    "To go back to the start of the alphabet after “z”",
                    "To change the letters to uppercase",
                    "To remove spaces",
                    "To count the vowels",
                ),
                0,
                "The alphabet has 26 letters, so the remainder wraps the shift around.",
            ),
            output(
                "def encrypt(s, k):\n    result = \"\"\n    for ch in s:\n        n = (ord(ch) - ord(\"a\") + k) % 26\n        result += chr(ord(\"a\") + n)\n    return result\n\nprint(encrypt(\"xyz\", 2))",
                "zab",
                "x moves to z, while y and z wrap around to a and b.",
            ),
            fill(
                "Fill in the blank to decrypt the letter (shift it back by 3).",
                "ch = \"d\"\nn = (ord(ch) - ord(\"a\") ____ 3) % 26\nprint(chr(ord(\"a\") + n))",
                listOf("-", "+", "*"),
                "-",
                "Decrypting is a shift in the opposite direction – from d we go back to a.",
            ),
            output(
                "result = \"\"\nfor ch in \"ab c\":\n    if ch == \" \":\n        result += ch\n    else:\n        result += chr(ord(ch) + 1)\nprint(result)",
                "bc d",
                "The space stays unchanged, and the letters shift by 1.",
            ),
            tiles(
                "Shift the letter ch by 1 in the alphabet (no wrapping) and store it in the variable new",
                listOf("new", "=", "chr(", "ord(ch)", "+ 1", ")"),
                listOf("ord(", "chr(ch)"),
                "First the letter's code, then +1, and finally chr() back to a character.",
            ),
        ),
        lesson(
            "u30l5", "Review: strings",
            output(
                "s = \"Was it a car or a cat I saw\"\nt = s.replace(\" \", \"\").lower()\nprint(t == t[::-1])",
                "True",
                "Without spaces and uppercase letters, the sentence reads the same backwards.",
            ),
            output("print(sorted(\"arc\") == sorted(\"car\"))", "True", "“arc” and “car” are anagrams."),
            output(
                "d = {}\nfor ch in \"kayak\":\n    d[ch] = d.get(ch, 0) + 1\nprint(d)",
                "{'k': 2, 'a': 2, 'y': 1}",
                "The keys are in the order the letters first appeared.",
            ),
            output(
                "s = \"abc\"\nprint(\"\".join(chr(ord(ch) + 1) for ch in s))",
                "bcd",
                "Each letter moves one position forward.",
            ),
            choice(
                "What does chr(ord(\"A\") + 2) return?",
                listOf("C", "B", "67", "A2"),
                0,
                "Two codes after A is C.",
            ),
            output(
                "sentence = \"anna has cats\"\nprint(\" \".join(w[::-1] for w in sentence.split()))",
                "anna sah stac",
                "We reverse each word separately, but their order stays the same.",
            ),
            fill(
                "Fill in the blank so every word starts with an uppercase letter.",
                "print(\"john smith\".____())",
                listOf("title", "upper", "capitalize"),
                "title",
                "title() puts an uppercase letter at the start of every word.",
            ),
            tiles(
                "Print whether the string t is a palindrome",
                listOf("print(t", "==", "t[::-1])"),
                listOf("t[::1])", "="),
                "A palindrome is equal to its own reverse.",
            ),
        ),
    ),
)
