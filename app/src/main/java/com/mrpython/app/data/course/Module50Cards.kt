package com.mrpython.app.data.course

internal val module50Cards = listOf(
    cards(
        "u50l1",
        explain(
            "Jak czytać zapis dwójkowy",
            "Każda cyfra zapisu dwójkowego ma swoją wagę: od prawej 1, 2, 4, 8, 16… Sumujemy wagi tam, " +
                "gdzie stoi 1. Na przykład 1011 to 8 + 2 + 1 = 11. Literał `0b1011` wpisany w kodzie to też 11.",
            code = "print(0b1011, 8 + 2 + 1)\nprint(int(\"1011\", 2))",
            output = "11 11\n11",
        ),
        explain(
            "Liczba bitów i jedynek",
            "`n.bit_length()` mówi, ile bitów potrzeba do zapisania liczby (bez przedrostka i zer z przodu). " +
                "Liczbę jedynek policzysz przez `bin(n).count(\"1\")`. Przy literale piszemy nawias: `(6).bit_length()`.",
            code = "print((6).bit_length(), bin(6))\nprint(bin(13).count(\"1\"))",
            output = "3 0b110\n3",
        ),
    ),
    cards(
        "u50l2",
        explain(
            "Sztuczki z XOR",
            "`x ^ x` zawsze daje 0, a `x ^ 0` daje x. Dwa razy ten sam XOR wraca do punktu wyjścia – " +
                "dzięki temu można np. zamienić dwie zmienne bez trzeciej.",
            code = "print(12 ^ 12, 7 ^ 0)\nprint(5 ^ 3 ^ 3)",
            output = "0 7\n5",
        ),
        explain(
            "Parzystość: n & 1",
            "`n & 1` zostawia tylko ostatni bit liczby: 1 dla nieparzystych, 0 dla parzystych. " +
                "To szybki odpowiednik `n % 2`.",
            code = "print(9 & 1, 8 & 1)",
            output = "1 0",
        ),
        explain(
            "& to nie and",
            "`and` patrzy na prawdziwość całych wartości: gdy pierwsza jest prawdziwa, zwraca drugą. " +
                "`&` liczy bit po bicie. Stąd `6 and 1` daje 1, a `6 & 1` daje 0 (110 i 001 nie mają wspólnych bitów).",
            code = "print(6 and 1, 6 & 1)",
            output = "1 0",
        ),
    ),
    cards(
        "u50l3",
        explain(
            "Odczyt bitu numer k",
            "Bity numerujemy od prawej, zaczynając od 0. `(n >> k) & 1` przesuwa bit numer k na koniec " +
                "i odcina resztę – wynik to 0 albo 1. Maskę z jednym bitem numer k tworzy `1 << k`.",
            code = "n = 0b10110\nprint((n >> 2) & 1, (n >> 0) & 1)\nprint(1 << 3)",
            output = "1 0\n8",
        ),
        explain(
            "Maska niskich bitów",
            "Działanie `n & maska` zostawia tylko te bity, które są w masce. `n & 0b11` daje dwa ostatnie " +
                "bity, a `n & 0b1111` – cztery ostatnie.",
            code = "print(0b1011 & 0b11)\nprint(0b110110 & 0b1111)",
            output = "3\n6",
        ),
        explain(
            "Skróty |=, &=, ^=",
            "Jak `+=`, działają też `|=`, `&=` i `^=`. `p |= F` włącza flagę, a `p ^= F` ją przełącza: " +
                "włączoną wyłącza, wyłączoną włącza.",
            code = "p = 6\np ^= 2\nprint(p)\np ^= 2\nprint(p)",
            output = "4\n6",
        ),
    ),
    cards(
        "u50l4",
        explain(
            "& przed ==",
            "Operatory bitowe `&`, `|` i `^` wykonują się przed porównaniem `==`. Dlatego `n & 1 == 0` " +
                "znaczy `(n & 1) == 0` – sprawdza, czy n jest parzyste.",
            code = "n = 6\nprint(n & 1 == 0)",
            output = "True",
        ),
    ),
)
