package com.mrpython.app.data.course

internal val module50Intro = lesson(
    "u50l0", "Wprowadzenie: operacje bitowe",
    explain(
        "Zapis dwójkowy",
        "Komputer zapisuje liczby jako bity – zera i jedynki. `bin()` pokazuje zapis dwójkowy " +
            "z przedrostkiem `0b`, format `b` w f-stringu – bez niego, a `int(napis, 2)` zamienia " +
            "taki zapis z powrotem na liczbę.",
        code = "print(bin(5))\nprint(f\"{5:04b}\")\nprint(int(\"101\", 2))",
        output = "0b101\n0101\n5",
    ),
    explain(
        "Operatory & | ^",
        "Działają na każdym bicie osobno. `&` zostawia bit, gdy jest w obu liczbach, `|` – gdy jest " +
            "w którejkolwiek, a `^` (XOR) – gdy jest tylko w jednej. Nie myl `&` z `and`!",
        code = "# 6 to 110, a 3 to 011\nprint(6 & 3, 6 | 3, 6 ^ 3)",
        output = "2 7 5",
    ),
    explain(
        "Negacja ~",
        "`~x` odwraca wszystkie bity liczby. W Pythonie wynik to zawsze `-x - 1`. " +
            "Przyda się do wyłączania wybranych bitów.",
        code = "print(~5, ~0)",
        output = "-6 -1",
    ),
    explain(
        "Przesunięcia << i >>",
        "`x << n` przesuwa bity w lewo, czyli mnoży przez 2 do potęgi n. `x >> n` przesuwa je " +
            "w prawo, czyli dzieli całkowicie przez 2 do potęgi n.",
        code = "print(1 << 3)\nprint(20 >> 2)",
        output = "8\n5",
    ),
    explain(
        "Flagi i maski",
        "Każdy bit może oznaczać jedną opcję (flagę). `|` włącza flagę, `&` sprawdza, " +
            "czy jest włączona, a `&= ~flaga` ją wyłącza.",
        code = "CZYT, PIS = 1, 2\np = CZYT | PIS\nprint(p, bool(p & PIS))\np &= ~PIS\nprint(p)",
        output = "3 True\n1",
    ),
    output(
        "print(5 & 1, 5 | 2)",
        "1 7",
        "101 & 001 = 001, a 101 | 010 = 111.",
    ),
    choice(
        "Któremu działaniu odpowiada x << 1?",
        listOf("x * 2", "x // 2", "x + 1", "x ** 2"),
        0,
        "Przesunięcie w lewo o 1 mnoży liczbę przez 2.",
    ),
    fill(
        "Uzupełnij, aby wypisać 6 w zapisie dwójkowym z przedrostkiem 0b.",
        "print(____(6))",
        listOf("bin", "hex", "int"),
        "bin",
        "bin(6) to 0b110; hex daje 0x6, a int po prostu 6.",
    ),
)
