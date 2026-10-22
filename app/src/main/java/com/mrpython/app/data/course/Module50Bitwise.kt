package com.mrpython.app.data.course

import com.mrpython.app.domain.CourseUnit

internal val module50 = CourseUnit(
    id = "u50",
    title = "Operacje bitowe",
    description = "Zapis dwójkowy, operatory bitowe, przesunięcia i flagi",
    lessons = listOf(
        lesson(
            "u50l1", "Zapis dwójkowy",
            output("print(bin(5))", "0b101", "5 = 4 + 1, czyli bity 101."),
            output("print(f\"{5:04b}\")", "0101", "04b dopełnia zapis dwójkowy zerami do 4 cyfr."),
            choice(
                "Jaką wartość ma literał 0b1000?",
                listOf("8", "1000", "16", "4"),
                0,
                "Jedynka stoi na pozycji 2³, więc to 8.",
            ),
            output("print((6).bit_length())", "3", "6 to 110 – potrzeba 3 bitów."),
            output("print(bin(13).count(\"1\"))", "3", "13 to 1101 – ma trzy jedynki."),
            choice(
                "Ile wynosi liczba zapisana dwójkowo jako 1011?",
                listOf("11", "13", "9", "1011"),
                0,
                "8 + 0 + 2 + 1 = 11.",
            ),
            fill(
                "Uzupełnij, aby wypisać liczbę 10 w zapisie dwójkowym bez przedrostka.",
                "print(f\"{10:____}\")",
                listOf("b", "x", "d"),
                "b",
                "Format b daje 1010; x daje a (szesnastkowo), a d daje 10.",
            ),
            tiles(
                "Zamień napis dwójkowy s na liczbę i zapisz ją w zmiennej n",
                listOf("n", "=", "int(s,", "2)"),
                listOf("bin(s)", "16)"),
                "int(napis, 2) czyta zapis dwójkowy.",
            ),
        ),
        lesson(
            "u50l2", "Operatory & | ^ ~",
            output("print(6 & 3)", "2", "110 & 011 = 010 – bit zostaje, gdy jest w obu liczbach."),
            output("print(6 | 3)", "7", "110 | 011 = 111 – bit zostaje, gdy jest w którejkolwiek."),
            output("print(6 ^ 3)", "5", "110 ^ 011 = 101 – bit zostaje, gdy jest tylko w jednej."),
            output("print(~5)", "-6", "~x to zawsze -x - 1."),
            output("print(bin(0b1100 & 0b1010))", "0b1000", "Wspólny jest tylko najwyższy bit."),
            choice(
                "Ile wynosi x ^ x dla dowolnej liczby całkowitej x?",
                listOf("0", "x", "2 * x", "-1"),
                0,
                "XOR identycznych bitów zawsze daje 0.",
            ),
            choice(
                "Czym różni się & od and?",
                listOf(
                    "& działa na poszczególnych bitach, and na prawdziwości wartości",
                    "To to samo",
                    "& działa tylko na napisach",
                    "and działa na bitach, & na wartościach logicznych",
                ),
                0,
                "6 & 3 to 2, a 6 and 3 to 3.",
            ),
            fill(
                "Uzupełnij, aby połączyć bity obu liczb (wynik 7).",
                "print(6 ____ 3)",
                listOf("|", "&", "^"),
                "|",
                "110 | 011 = 111 = 7; & daje 2, a ^ daje 5.",
            ),
        ),
        lesson(
            "u50l3", "Przesunięcia i maski",
            output("print(1 << 3)", "8", "Przesunięcie w lewo o 3 mnoży przez 2³."),
            output("print(20 >> 2)", "5", "Przesunięcie w prawo o 2 dzieli całkowicie przez 4."),
            choice(
                "Któremu działaniu odpowiada x >> 1 dla liczby nieujemnej x?",
                listOf("x // 2", "x * 2", "x - 1", "x / 2"),
                0,
                "Przesunięcie w prawo o 1 to dzielenie całkowite przez 2.",
            ),
            output(
                "CZYT, PIS, WYK = 1, 2, 4\np = CZYT | PIS\nprint(p)",
                "3",
                "Flagi łączymy operatorem |.",
            ),
            output(
                "CZYT, PIS, WYK = 1, 2, 4\np = CZYT | PIS\nprint(bool(p & PIS), bool(p & WYK))",
                "True False",
                "& z flagą sprawdza, czy dany bit jest ustawiony.",
            ),
            output(
                "PIS, WYK = 2, 4\np = 7\np &= ~PIS\nprint(p)",
                "5",
                "& ~flaga gasi wybrany bit: 111 → 101.",
            ),
            output(
                "n = 0b10110\nprint((n >> 2) & 1)",
                "1",
                "Przesuwamy bit numer 2 na koniec i odczytujemy go maską 1.",
            ),
            fill(
                "Uzupełnij, aby flaga WYK była włączona (także gdy już jest).",
                "WYK = 4\np = 5\np ____ WYK\nprint(p)",
                listOf("|=", "&=", "^="),
                "|=",
                "|= zawsze włącza bit (wynik 5); ^= by go tu wyłączył, a &= zgasiłby inne bity.",
            ),
        ),
        lesson(
            "u50l4", "Powtórka: operacje bitowe",
            output("print(bin(10))", "0b1010", "10 = 8 + 2."),
            output("print(12 & 10, 12 | 10)", "8 14", "1100 & 1010 = 1000, 1100 | 1010 = 1110."),
            output("print(3 << 2)", "12", "3 · 2² = 12."),
            output("print(~0)", "-1", "~x to -x - 1."),
            choice(
                "Jak sprawdzić, czy w liczbie p ustawiona jest flaga F?",
                listOf("p & F", "p | F", "p ^ F", "p << F"),
                0,
                "p & F jest niezerowe tylko wtedy, gdy bit F jest włączony.",
            ),
            output(
                "n = 6\nprint(n & 1 == 0)",
                "True",
                "Najniższy bit liczby parzystej to 0.",
            ),
            fill(
                "Uzupełnij, aby podzielić 40 przez 8 przesunięciem bitowym.",
                "print(40 ____ 3)",
                listOf(">>", "<<", "&"),
                ">>",
                "40 >> 3 to 5; << 3 dałoby 320, a & 3 dałoby 0.",
            ),
            tiles(
                "Wyłącz flagę F w zmiennej p",
                listOf("p", "&=", "~F"),
                listOf("|=", "F"),
                "p &= ~F zeruje bit F, zostawiając pozostałe.",
            ),
        ),
    ),
)
