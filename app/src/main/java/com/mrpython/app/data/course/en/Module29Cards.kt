package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

internal val module29Cards = listOf(
    cards(
        "u29l1",
        explain(
            "Reversing a number",
            "You can reverse the digits of a number in a loop: `rev * 10` makes room for a new digit, and " +
                "`+ n % 10` appends the last digit of n. Then `n //= 10` cuts it off.",
            code = "n = 123\nrev = 0\nwhile n > 0:\n    rev = rev * 10 + n % 10\n    n //= 10\nprint(rev)",
            output = "321",
        ),
        explain(
            "Counting digits",
            "Each `n //= 10` removes one digit, so by counting the loop's iterations down to zero, we learn the " +
                "number of digits. Watch the zeros: 100 has 3 digits too.",
            code = "n = 100\ncount = 0\nwhile n > 0:\n    n //= 10\n    count += 1\nprint(count)",
            output = "3",
        ),
        explain(
            "A number as a string",
            "Converting the number to a string is shorter: `len(str(n))` is the number of digits, and " +
                "`sum(int(c) for c in str(n))` adds up the digits – we convert each character `c` back to a number.",
            code = "n = 905\nprint(len(str(n)))\nprint(sum(int(c) for c in str(n)))",
            output = "3\n14",
        ),
    ),
    cards(
        "u29l2",
        explain(
            "A list of True/False flags",
            "`[True] * (n + 1)` creates a list of n + 1 True values – one for each number from 0 to n. " +
                "Writing `a[0] = a[1] = False` sets two places at once, and `sum()` counts True as 1.",
            code = "prime = [True] * 4\nprime[0] = prime[1] = False\nprint(prime)\nprint(sum(prime))",
            output = "[False, False, True, True]\n2",
        ),
        explain(
            "The sieve step by step",
            "The sieve walks through the numbers i that aren't crossed out and crosses out their multiples with " +
                "`range(i * i, n + 1, i)` – the step i jumps i at a time. Smaller multiples were already crossed out by earlier numbers.",
            code = "print(list(range(9, 31, 3)))",
            output = "[9, 12, 15, 18, 21, 24, 27, 30]",
        ),
        explain(
            "Prime factorization",
            "We divide n by d as long as we can and record d. When d no longer divides n, we increase d by 1. " +
                "We stop when n drops to 1 – the list holds the prime factors.",
            code = "n, d = 12, 2\nfactors = []\nwhile n > 1:\n    if n % d == 0:\n        factors.append(d)\n        n //= d\n    else:\n        d += 1\nprint(factors)",
            output = "[2, 2, 3]",
        ),
    ),
    cards(
        "u29l3",
        explain(
            "Reducing fractions",
            "Dividing the numerator and the denominator by their GCD gives a fraction in lowest terms. " +
                "Note: the GCD of a number and zero is the number itself, e.g. `math.gcd(9, 0)` gives 9.",
            code = "import math\nd = math.gcd(12, 16)\nprint(12 // d, 16 // d)",
            output = "3 4",
        ),
    ),
    cards(
        "u29l4",
        explain(
            "Fibonacci in a list",
            "You can keep the sequence in a list: `fib[-1]` is the last term, and `fib[-2]` is the one before it. " +
                "Their sum is the next term, which we add with `append()`.",
            code = "fib = [0, 1]\nwhile len(fib) < 6:\n    fib.append(fib[-1] + fib[-2])\nprint(fib)",
            output = "[0, 1, 1, 2, 3, 5]",
        ),
        explain(
            "Powers of two",
            "Any number to the power of 0 gives 1. You can recognize a power of two by the fact that it can be " +
                "divided by 2 all the way down to 1 – any other number gets stuck on an odd value.",
            code = "n = 12\nwhile n % 2 == 0 and n > 1:\n    n //= 2\nprint(n, n == 1)\nprint(2 ** 0)",
            output = "3 False\n1",
        ),
        explain(
            "Is it a square?",
            "`math.isqrt(n)` gives the integer part of the square root. If squaring it " +
                "brings us back to n, then n is the square of an integer.",
            code = "import math\nfor n in [49, 50]:\n    print(math.isqrt(n) ** 2 == n)",
            output = "True\nFalse",
        ),
    ),
    cards(
        "u29l5",
        explain(
            "Number palindrome",
            "A number is easy to reverse through a string: `str(n)[::-1]`, and `int()` converts the result back to a " +
                "number (leading zeros disappear). If the reversed string is the same, the number is a palindrome.",
            code = "n = 1221\nprint(str(n) == str(n)[::-1])\nprint(int(str(540)[::-1]))",
            output = "True\n45",
        ),
        explain(
            "The first digit",
            "`% 10` gives the last digit, and integer division by the right power of 10 gives the first one: " +
                "for a three-digit number, `n // 100`. Python calculates even very large numbers exactly.",
            code = "n = 123\nprint(n // 100, n % 10)\nprint(len(str(2 ** 100)))",
            output = "1 3\n31",
        ),
    ),
)
