package com.mrpython.app.data.course

internal val module49Cards = listOf(
    cards(
        "u49l1",
        explain(
            "Które ułamki są dokładne?",
            "Dokładnie zapiszą się tylko ułamki złożone z połówek, ćwiartek, ósemek itd., np. 0.5, " +
                "0.25 czy 0.75. Ich sumy porównasz przez `==` bez problemu. 0.1, 0.2 i 0.3 mają już " +
                "drobny błąd, który rośnie przy dodawaniu.",
            code = "print(0.5 + 0.25 == 0.75)\nprint(sum([0.1] * 3))",
            output = "True\n0.30000000000000004",
        ),
        explain(
            "Porównanie z tolerancją",
            "Zamiast `==` możesz sprawdzić, czy różnica jest bardzo mała: `abs(a - b) < 1e-9`. " +
                "Zapis `1e-9` to 0.000000001 (1 razy 10 do potęgi -9). Tak samo działa `math.isclose()`.",
            code = "x = 0.1 + 0.2\nprint(abs(x - 0.3) < 1e-9)\nprint(1e-3)",
            output = "True\n0.001",
        ),
    ),
    cards(
        "u49l2",
        explain(
            "Ujemne miejsca w round",
            "Ujemna liczba miejsc zaokrągla przed przecinkiem: `-1` do dziesiątek, `-2` do setek. " +
                "`round(x, n)` z podanym `n` zwraca float, a dla liczby całkowitej – int.",
            code = "print(round(1567, -1), round(1234, -2))\nprint(round(2.567, 1))",
            output = "1570 1200\n2.6",
        ),
        explain(
            "Pułapka: round(2.675, 2)",
            "Liczba 2.675 jest w pamięci zapisana jako odrobinę mniej niż 2.675, więc `round` daje 2.67. " +
                "To nie błąd Pythona, tylko skutek zapisu dwójkowego float.",
            code = "print(round(2.675, 2))\nprint(round(1.005, 2))",
            output = "2.67\n1.0",
        ),
    ),
    cards(
        "u49l3",
        explain(
            "Zaokrąglanie Decimal",
            "`x.quantize(Decimal(\"0.01\"), rounding=ROUND_HALF_UP)` zaokrągla do 2 miejsc „po szkolnemu” " +
                "– piątka zawsze w górę. Wzór `Decimal(\"0.01\")` mówi, ile miejsc zostawić.",
            code = "from decimal import Decimal, ROUND_HALF_UP\nx = Decimal(\"2.675\")\nwzor = Decimal(\"0.01\")\nprint(x.quantize(wzor, rounding=ROUND_HALF_UP))",
            output = "2.68",
        ),
        explain(
            "Decimal w działaniach",
            "`Decimal` pamięta liczbę miejsc po przecinku, więc `Decimal(\"2.50\") * 2` daje 5.00. " +
                "Można go łączyć z int, ale dodanie float zgłosi `TypeError`.",
            code = "from decimal import Decimal\nprint(Decimal(\"2.50\") * 2)\nprint(Decimal(\"1.5\") + Decimal(\"1.5\"))",
            output = "5.00\n3.0",
        ),
        explain(
            "Licznik i mianownik",
            "`numerator` to licznik, a `denominator` mianownik ułamka `Fraction`. Ułamek utworzysz też " +
                "z napisu, np. `Fraction(\"0.75\")`, i porównasz ze zwykłą liczbą.",
            code = "from fractions import Fraction\nf = Fraction(\"0.75\")\nprint(f, f.numerator, f.denominator)\nprint(Fraction(1, 2) == 0.5)",
            output = "3/4 3 4\nTrue",
        ),
    ),
    cards(
        "u49l4",
        explain(
            "Liczby z przedrostkiem w kodzie",
            "Liczbę możesz wpisać w kodzie od razu w innym systemie: `0b` dwójkowo, `0o` ósemkowo, `0x` " +
                "szesnastkowo. Python i tak wypisze ją dziesiętnie. W systemie szesnastkowym A to 10, a F to 15.",
            code = "print(0b111, 0o17, 0x1F)",
            output = "7 15 31",
        ),
        explain(
            "Formaty b, o, x",
            "W f-stringu `:b`, `:o` i `:x` zamieniają liczbę na zapis dwójkowy, ósemkowy i szesnastkowy – " +
                "bez przedrostka. `:08b` dopełnia zerami do 8 cyfr. A `int(\"12\", 2)` zgłosi `ValueError`, " +
                "bo w dwójkowym nie ma cyfry 2.",
            code = "print(f\"{10:b}\", f\"{10:o}\", f\"{255:x}\")\nprint(f\"{3:08b}\")",
            output = "1010 12 ff\n00000011",
        ),
    ),
)
