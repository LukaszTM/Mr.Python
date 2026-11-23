package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*
import com.mrpython.app.domain.CourseUnit

internal val module50 = CourseUnit(
    id = "u50",
    title = "Bitwise operations",
    description = "Binary notation, bitwise operators, shifts and flags",
    lessons = listOf(
        lesson(
            "u50l1", "Binary notation",
            output("print(bin(5))", "0b101", "5 = 4 + 1, which is the bits 101."),
            output("print(f\"{5:04b}\")", "0101", "04b pads the binary form with zeros to 4 digits."),
            choice(
                "What is the value of the literal 0b1000?",
                listOf("8", "1000", "16", "4"),
                0,
                "The one sits in the 2³ position, so it's 8.",
            ),
            output("print((6).bit_length())", "3", "6 is 110 – it needs 3 bits."),
            output("print(bin(13).count(\"1\"))", "3", "13 is 1101 – it has three ones."),
            choice(
                "What is the number written in binary as 1011?",
                listOf("11", "13", "9", "1011"),
                0,
                "8 + 0 + 2 + 1 = 11.",
            ),
            fill(
                "Fill in the blank to print the number 10 in binary without the prefix.",
                "print(f\"{10:____}\")",
                listOf("b", "x", "d"),
                "b",
                "The b format gives 1010; x gives a (hexadecimal), and d gives 10.",
            ),
            tiles(
                "Convert the binary string s to a number and store it in the variable n",
                listOf("n", "=", "int(s,", "2)"),
                listOf("bin(s)", "16)"),
                "int(string, 2) reads the binary form.",
            ),
        ),
        lesson(
            "u50l2", "The operators & | ^ ~",
            output("print(6 & 3)", "2", "110 & 011 = 010 – a bit stays when it's in both numbers."),
            output("print(6 | 3)", "7", "110 | 011 = 111 – a bit stays when it's in either one."),
            output("print(6 ^ 3)", "5", "110 ^ 011 = 101 – a bit stays when it's in only one."),
            output("print(~5)", "-6", "~x is always -x - 1."),
            output("print(bin(0b1100 & 0b1010))", "0b1000", "Only the highest bit is shared."),
            choice(
                "What is x ^ x for any integer x?",
                listOf("0", "x", "2 * x", "-1"),
                0,
                "XOR of identical bits always gives 0.",
            ),
            choice(
                "How is & different from and?",
                listOf(
                    "& works on bits, and on whole values",
                    "There is no difference between them",
                    "& works only on strings and lists",
                    "and works on bits, & on whole values",
                ),
                0,
                "& works bit by bit, while and looks at the truthiness of whole values: 6 & 3 is 2, while 6 and 3 is 3.",
            ),
            fill(
                "Fill in the blank to combine the bits of both numbers (result 7).",
                "print(6 ____ 3)",
                listOf("|", "&", "^"),
                "|",
                "110 | 011 = 111 = 7; & gives 2, and ^ gives 5.",
            ),
        ),
        lesson(
            "u50l3", "Shifts and masks",
            output("print(1 << 3)", "8", "Shifting left by 3 multiplies by 2³."),
            output("print(20 >> 2)", "5", "Shifting right by 2 floor-divides by 4."),
            choice(
                "Which operation does x >> 1 correspond to for a non-negative number x?",
                listOf("x // 2", "x * 2", "x - 1", "x / 2"),
                0,
                "Shifting right by 1 is floor division by 2.",
            ),
            output(
                "READ, WRITE, EXEC = 1, 2, 4\np = READ | WRITE\nprint(p)",
                "3",
                "We combine flags with the | operator.",
            ),
            output(
                "READ, WRITE, EXEC = 1, 2, 4\np = READ | WRITE\nprint(bool(p & WRITE), bool(p & EXEC))",
                "True False",
                "& with a flag checks whether that bit is set.",
            ),
            output(
                "WRITE, EXEC = 2, 4\np = 7\np &= ~WRITE\nprint(p)",
                "5",
                "& ~flag turns off the chosen bit: 111 → 101.",
            ),
            output(
                "n = 0b10110\nprint((n >> 2) & 1)",
                "1",
                "We shift bit number 2 to the end and read it with the mask 1.",
            ),
            fill(
                "Fill in the blank so the EXEC flag is turned on (even if it already is).",
                "EXEC = 4\np = 5\np ____ EXEC\nprint(p)",
                listOf("|=", "&=", "^="),
                "|=",
                "|= always turns the bit on (result 5); ^= would turn it off here, and &= would turn off the other bits.",
            ),
        ),
        lesson(
            "u50l4", "Review: bitwise operations",
            output("print(bin(10))", "0b1010", "10 = 8 + 2."),
            output("print(12 & 10, 12 | 10)", "8 14", "1100 & 1010 = 1000, 1100 | 1010 = 1110."),
            output("print(3 << 2)", "12", "3 · 2² = 12."),
            output("print(~0)", "-1", "~x is -x - 1."),
            choice(
                "How do you check whether the flag F is set in the number p?",
                listOf("p & F", "p | F", "p ^ F", "p << F"),
                0,
                "p & F is non-zero only when the F bit is turned on.",
            ),
            output(
                "n = 6\nprint(n & 1 == 0)",
                "True",
                "The lowest bit of an even number is 0.",
            ),
            fill(
                "Fill in the blank to divide 40 by 8 with a bit shift.",
                "print(40 ____ 3)",
                listOf(">>", "<<", "&"),
                ">>",
                "40 >> 3 is 5; << 3 would give 320, and & 3 would give 0.",
            ),
            tiles(
                "Turn off the flag F in the variable p",
                listOf("p", "&=", "~F"),
                listOf("|=", "F"),
                "p &= ~F clears the F bit and leaves the others alone.",
            ),
        ),
    ),
)
