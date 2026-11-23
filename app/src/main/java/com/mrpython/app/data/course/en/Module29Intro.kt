package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

internal val module29Intro = lesson(
    "u29l0", "Introduction: math in code",
    explain(
        "Remainder and digits",
        "The `%` operator gives the remainder of a division: a remainder of 0 means \"divisible\". `n % 10` is " +
            "the last digit, and `n // 10` cuts it off. That's how we take a number apart into digits in a loop.",
        code = "n = 472\ntotal = 0\nwhile n > 0:\n    total += n % 10\n    n //= 10\nprint(total)",
        output = "13",
    ),
    explain(
        "Prime numbers",
        "A prime number (2 and up) is divisible only by 1 and itself. We check divisors – going up to the " +
            "square root of n (`n ** 0.5`) is enough, because if n = a · b, one of the factors is no greater than the square root. The Sieve of Eratosthenes crosses out multiples to find many primes at once.",
        code = "def is_prime(n):\n    if n < 2:\n        return False\n    for d in range(2, int(n ** 0.5) + 1):\n        if n % d == 0:\n            return False\n    return True\nprint(is_prime(7), is_prime(9))",
        output = "True False",
    ),
    explain(
        "GCD and LCM",
        "The GCD is the greatest common divisor. Euclid's algorithm repeats `a, b = b, a % b` until b " +
            "is 0. We calculate the LCM, the least common multiple, with the formula `a * b // gcd`. " +
            "`math.gcd()` and `math.lcm()` are also ready to use.",
        code = "a, b = 48, 18\nwhile b:\n    a, b = b, a % b\nprint(a)",
        output = "6",
    ),
    explain(
        "The Fibonacci sequence",
        "In the Fibonacci sequence each term is the sum of the two before it: 0, 1, 1, 2, 3, 5, 8… " +
            "The loop version calculates each term only once, so it's fast.",
        code = "a, b = 0, 1\nfor _ in range(6):\n    a, b = b, a + b\nprint(a)",
        output = "8",
    ),
    explain(
        "Powers",
        "`**` raises to a power, and `pow(a, b, m)` gives the remainder of dividing the result by m right away. " +
            "`n ** 0.5` is the square root, and `math.isqrt()` gives the integer square root.",
        code = "print(2 ** 10)\nprint(pow(2, 10, 1000))",
        output = "1024\n24",
    ),
    output(
        "print(25 % 7, 25 // 7)",
        "4 3",
        "25 = 3 · 7 + 4.",
    ),
    fill(
        "Fill in the blank to print the last digit of the number n.",
        "n = 538\nprint(n ____ 10)",
        listOf("%", "//", "*"),
        "%",
        "The remainder from dividing by 10 is the ones digit.",
    ),
    choice(
        "Which number is prime?",
        listOf("11", "9", "15", "1"),
        0,
        "11 is divisible only by 1 and 11.",
    ),
)
