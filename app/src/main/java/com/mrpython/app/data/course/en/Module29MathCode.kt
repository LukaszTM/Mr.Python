package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*
import com.mrpython.app.domain.CourseUnit

internal val module29 = CourseUnit(
    id = "u29",
    title = "Math in Code",
    description = "Digits, prime numbers, GCD, Fibonacci, and powers",
    lessons = listOf(
        lesson(
            "u29l1", "Divisibility and digits",
            output("print(17 % 5, 18 % 3)", "2 0", "A remainder of 0 means 18 is divisible by 3."),
            output(
                "n = 4721\ntotal = 0\nwhile n > 0:\n    total += n % 10\n    n //= 10\nprint(total)",
                "14",
                "We cut off digits from the end: 1 + 2 + 7 + 4 = 14.",
            ),
            output(
                "n = 1230\nrev = 0\nwhile n > 0:\n    rev = rev * 10 + n % 10\n    n //= 10\nprint(rev)",
                "321",
                "We append the digits in reverse order, and the leading zero disappears.",
            ),
            choice(
                "What does the expression n % 10 give for a positive integer n?",
                listOf("The last digit of n", "The first digit of n", "The number of digits", "n without its last digit"),
                0,
                "The remainder from dividing by 10 is the ones digit.",
            ),
            fill(
                "Fill in the blank to remove the last digit of the number.",
                "n = 987\nn = n ____ 10\nprint(n)",
                listOf("//", "%", "/"),
                "//",
                "Integer division by 10 cuts off the ones digit.",
            ),
            output("print(sum(int(c) for c in str(905)))", "14", "You can also convert the number to a string and add up the digits: 9 + 0 + 5."),
            output(
                "n = 50400\ncount = 0\nwhile n > 0:\n    n //= 10\n    count += 1\nprint(count)",
                "5",
                "Each division by 10 removes one digit – there are 5 of them.",
            ),
            tiles(
                "Check whether n is divisible by 3",
                listOf("if", "n % 3 == 0", ":"),
                listOf("n // 3 == 0", "n % 3 = 0"),
                "A number is divisible when the remainder of the division is 0.",
            ),
        ),
        lesson(
            "u29l2", "Prime numbers",
            choice(
                "Which number is prime?",
                listOf("13", "15", "21", "1"),
                0,
                "13 is divisible only by 1 and itself, and 1 is not a prime number.",
            ),
            output(
                "def is_prime(n):\n    if n < 2:\n        return False\n    for d in range(2, n):\n        if n % d == 0:\n            return False\n    return True\nprint(is_prime(7), is_prime(9))",
                "True False",
                "9 is divisible by 3, so it isn't prime.",
            ),
            choice(
                "Why is it enough to look for divisors up to the square root of n?",
                listOf(
                    "If n = a · b, one of the factors is at most the square root of n",
                    "n has no divisors greater than the square root of n",
                    "The square root of n is always a prime number",
                    "A range() loop can't go beyond the square root of n",
                ),
                0,
                "If both factors were greater than the square root, their product would exceed n.",
            ),
            output(
                "def is_prime(n):\n    if n < 2:\n        return False\n    for d in range(2, int(n ** 0.5) + 1):\n        if n % d == 0:\n            return False\n    return True\nprint([n for n in range(10, 20) if is_prime(n)])",
                "[11, 13, 17, 19]",
                "Between 10 and 19, the primes are 11, 13, 17, and 19.",
            ),
            fill(
                "Fill in the blank to check whether d is a divisor of n.",
                "n, d = 12, 4\nprint(n ____ d == 0)",
                listOf("%", "//", "-"),
                "%",
                "d is a divisor when the remainder of n divided by d is 0.",
            ),
            output(
                "n = 15\nprime = [True] * (n + 1)\nprime[0] = prime[1] = False\nfor i in range(2, n + 1):\n    if prime[i]:\n        for k in range(i * i, n + 1, i):\n            prime[k] = False\nprint([i for i in range(n + 1) if prime[i]])",
                "[2, 3, 5, 7, 11, 13]",
                "The sieve crosses out the multiples of 2 and 3, and the rest are prime numbers.",
            ),
            choice(
                "What does the Sieve of Eratosthenes do?",
                listOf(
                    "It crosses out the multiples of successive prime numbers",
                    "It checks each number by dividing it by all smaller ones",
                    "It crosses out the numbers that leave a remainder when divided by 2",
                    "It prints the successive numbers that divide n evenly",
                ),
                0,
                "Whatever is left uncrossed is a prime number.",
            ),
            output(
                "n = 12\ndivs = [d for d in range(1, n + 1)\n        if n % d == 0]\nprint(len(divs))",
                "6",
                "The divisors of 12 are 1, 2, 3, 4, 6, and 12.",
            ),
        ),
        lesson(
            "u29l3", "GCD and LCM",
            output(
                "a, b = 48, 18\nwhile b:\n    a, b = b, a % b\nprint(a)",
                "6",
                "Euclid's algorithm: (48, 18) → (18, 12) → (12, 6) → (6, 0).",
            ),
            output(
                "a, b = 20, 8\nwhile b:\n    print(a, b)\n    a, b = b, a % b",
                "20 8\n8 4",
                "After the second step b = 0, so the loop ends, and the GCD is 4.",
            ),
            output(
                "def gcd(a, b):\n    while b:\n        a, b = b, a % b\n    return a\n\ndef lcm(a, b):\n    return a * b // gcd(a, b)\n\nprint(lcm(4, 6))",
                "12",
                "LCM = 4 · 6 // GCD(4, 6) = 24 // 2 = 12.",
            ),
            choice(
                "What does GCD(12, 18) = 6 mean?",
                listOf(
                    "6 is the largest number that divides both 12 and 18",
                    "6 is the least common multiple of 12 and 18",
                    "6 is the difference between 18 and 12",
                    "6 is the remainder of 18 divided by 12",
                ),
                0,
                "GCD stands for greatest common divisor.",
            ),
            fill(
                "Complete the step of Euclid's algorithm.",
                "a, b = 36, 24\nwhile b:\n    a, b = ____, a % b\nprint(a)",
                listOf("b", "a", "0"),
                "b",
                "The new a is the old b, and the new b is the remainder of a divided by b.",
            ),
            output(
                "import math\nprint(math.gcd(84, 36))\nprint(math.lcm(4, 10))",
                "12\n20",
                "The math module has ready-made gcd (GCD) and lcm (LCM) functions.",
            ),
            choice(
                "How do you calculate the LCM if you know the GCD?",
                listOf("a * b // gcd(a, b)", "a + b - gcd(a, b)", "gcd(a, b) * 2", "a // b * gcd(a, b)"),
                0,
                "The product of the numbers equals the product of their GCD and LCM.",
            ),
            tiles(
                "Write Euclid's step: the new a is b, and the new b is the remainder of a divided by b",
                listOf("a, b", "=", "b,", "a % b"),
                listOf("a // b", "b % a"),
                "a, b = b, a % b does both assignments at once.",
            ),
        ),
        lesson(
            "u29l4", "Fibonacci and powers",
            output(
                "fib = [0, 1]\nwhile len(fib) < 7:\n    fib.append(fib[-1] + fib[-2])\nprint(fib)",
                "[0, 1, 1, 2, 3, 5, 8]",
                "Each term is the sum of the two before it.",
            ),
            output(
                "def fib(n):\n    a, b = 0, 1\n    for _ in range(n):\n        a, b = b, a + b\n    return a\n\nprint(fib(10))",
                "55",
                "The tenth term of the Fibonacci sequence (counting from zero) is 55.",
            ),
            choice(
                "Why is the iterative version of Fibonacci faster than simple recursion?",
                listOf(
                    "It calculates each number only once",
                    "Loops are always faster than functions",
                    "It doesn't use addition",
                    "It isn't faster",
                ),
                0,
                "Simple recursion calculates the same terms from scratch many times.",
            ),
            fill(
                "Fill in the blank to calculate the next pair of Fibonacci numbers.",
                "a, b = 0, 1\nfor _ in range(6):\n    a, b = b, ____\nprint(a)",
                listOf("a + b", "a * b", "b + 1"),
                "a + b",
                "The next term is the sum of the previous two – after 6 steps a = 8.",
            ),
            output(
                "print(2 ** 10)\nprint(pow(3, 4))\nprint(pow(2, 10, 1000))",
                "1024\n81\n24",
                "pow(a, b, m) calculates the remainder of dividing a ** b by m: 1024 % 1000 = 24.",
            ),
            output(
                "def power_of_two(n):\n    while n % 2 == 0 and n > 1:\n        n //= 2\n    return n == 1\n\nprint(power_of_two(16), power_of_two(12))",
                "True False",
                "16 can be halved all the way down to 1, while 12 ends at 3.",
            ),
            choice(
                "What is the simplest way to check whether a number n is even?",
                listOf("n % 2 == 0", "n / 2 == 0", "n // 2 == 1", "str(n).endswith(\"0\")"),
                0,
                "An even number gives a remainder of 0 when divided by 2.",
            ),
            output(
                "import math\nfor n in [49, 50]:\n    r = math.isqrt(n)\n    print(r * r == n)",
                "True\nFalse",
                "math.isqrt() gives the integer square root – 49 is 7 · 7, and 50 is not a square.",
            ),
        ),
        lesson(
            "u29l5", "Review: math",
            output("print(sum(int(c) for c in str(2026)))", "10", "2 + 0 + 2 + 6 = 10."),
            output("n = 12321\nprint(str(n) == str(n)[::-1])", "True", "12321 read backward gives the same number."),
            choice(
                "Which number is NOT prime?",
                listOf("91", "97", "89", "83"),
                0,
                "91 = 7 · 13.",
            ),
            output(
                "def gcd(a, b):\n    while b:\n        a, b = b, a % b\n    return a\n\nprint(gcd(27, 45), gcd(7, 5))",
                "9 1",
                "The GCD of 27 and 45 is 9, and 7 and 5 have no common divisors other than 1.",
            ),
            fill(
                "Fill in the blank to calculate the square root of n.",
                "n = 49\nprint(n ** ____)",
                listOf("0.5", "2", "-1"),
                "0.5",
                "The power 0.5 is the square root: 7.0.",
            ),
            output(
                "a, b = 1, 1\nwhile b < 50:\n    a, b = b, a + b\nprint(b)",
                "55",
                "The first term of the Fibonacci sequence that is not less than 50 is 55.",
            ),
            output("print(len(str(2 ** 100)))", "31", "2 to the power of 100 has 31 digits – Python calculates it exactly."),
            tiles(
                "Add the last digit of n to the variable total",
                listOf("total", "+=", "n % 10"),
                listOf("n // 10", "=="),
                "n % 10 is the last digit.",
            ),
        ),
    ),
)
