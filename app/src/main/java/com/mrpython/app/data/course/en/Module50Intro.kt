package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

internal val module50Intro = lesson(
    "u50l0", "Introduction: bitwise operations",
    explain(
        "Binary notation",
        "A computer stores numbers as bits – zeros and ones. `bin()` shows the binary form " +
            "with the prefix `0b`, the `b` format in an f-string shows it without one, and `int(string, 2)` " +
            "converts such a form back to a number.",
        code = "print(bin(5))\nprint(f\"{5:04b}\")\nprint(int(\"101\", 2))",
        output = "0b101\n0101\n5",
    ),
    explain(
        "The operators & | ^",
        "They work on each bit separately. `&` keeps a bit when it's in both numbers, `|` when it's " +
            "in either one, and `^` (XOR) when it's in only one. Don't confuse `&` with `and`!",
        code = "# 6 is 110, and 3 is 011\nprint(6 & 3, 6 | 3, 6 ^ 3)",
        output = "2 7 5",
    ),
    explain(
        "Negation ~",
        "`~x` flips all the bits of a number. In Python the result is always `-x - 1`. " +
            "It comes in handy for turning off chosen bits.",
        code = "print(~5, ~0)",
        output = "-6 -1",
    ),
    explain(
        "The shifts << and >>",
        "`x << n` shifts the bits to the left, which multiplies by 2 to the power of n. `x >> n` shifts them " +
            "to the right, which floor-divides by 2 to the power of n.",
        code = "print(1 << 3)\nprint(20 >> 2)",
        output = "8\n5",
    ),
    explain(
        "Flags and masks",
        "Each bit can stand for one option (a flag). `|` turns a flag on, `&` checks " +
            "whether it's on, and `&= ~flag` turns it off.",
        code = "READ, WRITE = 1, 2\np = READ | WRITE\nprint(p, bool(p & WRITE))\np &= ~WRITE\nprint(p)",
        output = "3 True\n1",
    ),
    output(
        "print(5 & 1, 5 | 2)",
        "1 7",
        "101 & 001 = 001, and 101 | 010 = 111.",
    ),
    choice(
        "Which operation does x << 1 correspond to?",
        listOf("x * 2", "x // 2", "x + 1", "x ** 2"),
        0,
        "Shifting left by 1 multiplies the number by 2.",
    ),
    fill(
        "Fill in the blank to print 6 in binary with the prefix 0b.",
        "print(____(6))",
        listOf("bin", "hex", "int"),
        "bin",
        "bin(6) is 0b110; hex gives 0x6, and int simply 6.",
    ),
)
