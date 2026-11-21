package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

internal val module50Cards = listOf(
    cards(
        "u50l1",
        explain(
            "How to read binary",
            "Each digit of a binary number has its own weight: from the right 1, 2, 4, 8, 16… We add up the weights " +
                "wherever there is a 1. For example, 1011 is 8 + 2 + 1 = 11. The literal `0b1011` typed in code is 11 too.",
            code = "print(0b1011, 8 + 2 + 1)\nprint(int(\"1011\", 2))",
            output = "11 11\n11",
        ),
        explain(
            "Counting bits and ones",
            "`n.bit_length()` tells you how many bits are needed to write the number (without the prefix or leading zeros). " +
                "You can count the ones with `bin(n).count(\"1\")`. With a literal we use parentheses: `(6).bit_length()`.",
            code = "print((6).bit_length(), bin(6))\nprint(bin(13).count(\"1\"))",
            output = "3 0b110\n3",
        ),
    ),
    cards(
        "u50l2",
        explain(
            "XOR tricks",
            "`x ^ x` always gives 0, and `x ^ 0` gives x. Applying the same XOR twice takes you back where you started – " +
                "which lets you, for example, swap two variables without a third one.",
            code = "print(12 ^ 12, 7 ^ 0)\nprint(5 ^ 3 ^ 3)",
            output = "0 7\n5",
        ),
        explain(
            "Even or odd: n & 1",
            "`n & 1` keeps only the last bit of the number: 1 for odd numbers, 0 for even ones. " +
                "It's a fast equivalent of `n % 2`.",
            code = "print(9 & 1, 8 & 1)",
            output = "1 0",
        ),
        explain(
            "& is not and",
            "`and` looks at the truthiness of whole values: when the first one is truthy, it returns the second. " +
                "`&` works bit by bit. That's why `6 and 1` gives 1, while `6 & 1` gives 0 (110 and 001 share no bits).",
            code = "print(6 and 1, 6 & 1)",
            output = "1 0",
        ),
    ),
    cards(
        "u50l3",
        explain(
            "Reading bit number k",
            "Bits are numbered from the right, starting at 0. `(n >> k) & 1` shifts bit number k to the end " +
                "and cuts off the rest – the result is 0 or 1. `1 << k` creates a mask with just bit number k.",
            code = "n = 0b10110\nprint((n >> 2) & 1, (n >> 0) & 1)\nprint(1 << 3)",
            output = "1 0\n8",
        ),
        explain(
            "A mask for the low bits",
            "The operation `n & mask` keeps only the bits that are in the mask. `n & 0b11` gives the last two " +
                "bits, and `n & 0b1111` the last four.",
            code = "print(0b1011 & 0b11)\nprint(0b110110 & 0b1111)",
            output = "3\n6",
        ),
        explain(
            "The shortcuts |=, &=, ^=",
            "Just like `+=`, there are also `|=`, `&=` and `^=`. `p |= F` turns a flag on, and `p ^= F` toggles it: " +
                "it turns it off if it was on, and on if it was off.",
            code = "p = 6\np ^= 2\nprint(p)\np ^= 2\nprint(p)",
            output = "4\n6",
        ),
    ),
    cards(
        "u50l4",
        explain(
            "& before ==",
            "The bitwise operators `&`, `|` and `^` are evaluated before the comparison `==`. That's why `n & 1 == 0` " +
                "means `(n & 1) == 0` – it checks whether n is even.",
            code = "n = 6\nprint(n & 1 == 0)",
            output = "True",
        ),
    ),
)
