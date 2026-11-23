package com.mrpython.app.data.course

import com.mrpython.app.domain.CourseUnit

internal val module49 = CourseUnit(
    id = "u49",
    title = "Liczby w praktyce",
    description = "Precyzja float, zaokrąglanie, Decimal, Fraction i systemy liczbowe",
    lessons = listOf(
        lesson(
            "u49l1", "Precyzja liczb float",
            output("print(0.1 + 0.2)", "0.30000000000000004", "0.1 i 0.2 nie mają dokładnego zapisu binarnego, więc pojawia się mały błąd."),
            output("print(0.1 + 0.2 == 0.3)", "False", "Przez błąd zaokrągleń wynik nie jest dokładnie równy 0.3."),
            output(
                "import math\nprint(math.isclose(0.1 + 0.2, 0.3))",
                "True",
                "math.isclose() sprawdza, czy liczby są prawie równe.",
            ),
            output(
                "s = 0\nfor _ in range(10):\n    s += 0.1\nprint(s)",
                "0.9999999999999999",
                "Małe błędy sumują się przy wielu dodawaniach.",
            ),
            output(
                "import math\nprint(math.fsum([0.1] * 10))",
                "1.0",
                "math.fsum() sumuje liczby float dokładnie, bez narastania błędów.",
            ),
            choice(
                "Jak bezpiecznie porównać dwie liczby float?",
                listOf("math.isclose(a, b)", "a == b", "a is b", "str(a) == str(b)"),
                0,
                "Ze względu na błędy zaokrągleń porównujemy z tolerancją.",
            ),
            fill(
                "Uzupełnij, aby porównanie zwróciło True.",
                "import math\nprint(math.____(0.1 * 3, 0.3))",
                listOf("isclose", "floor", "fsum"),
                "isclose",
                "isclose() porównuje z tolerancją; floor() i fsum() nie przyjmują dwóch takich argumentów.",
            ),
            choice(
                "Dlaczego 0.1 + 0.2 nie daje dokładnie 0.3?",
                listOf(
                    "Komputer zapisuje float binarnie i 0.1 nie ma dokładnej reprezentacji",
                    "To błąd w Pythonie",
                    "Python zaokrągla w górę każde dodawanie",
                    "0.1 jest za małe dla typu float",
                ),
                0,
                "Ułamki dziesiętne jak 0.1 w systemie dwójkowym są nieskończone.",
            ),
        ),
        lesson(
            "u49l2", "Zaokrąglanie",
            output("print(round(2.5))", "2", "round() przy remisie wybiera liczbę parzystą (zaokrąglanie bankierskie)."),
            output("print(round(3.5))", "4", "4 jest parzyste, więc 3.5 idzie w górę."),
            output("print(round(0.5), round(1.5))", "0 2", "Remisy zawsze idą do najbliższej parzystej."),
            output("print(round(3.14159, 2))", "3.14", "Drugi argument to liczba miejsc po przecinku."),
            choice(
                "Co zwróci round(1234, -2)?",
                listOf("1200", "1234.0", "12.34", "Błąd"),
                0,
                "Ujemna liczba miejsc zaokrągla do dziesiątek, setek itd.",
            ),
            output("print(type(round(2.7)).__name__)", "int", "round() z jednym argumentem zwraca int."),
            choice(
                "Co wypisze ten kod?",
                listOf("2.67", "2.68", "2.7", "2.675"),
                0,
                "2.675 jako float to w rzeczywistości trochę mniej niż 2.675.",
                code = "print(round(2.675, 2))",
            ),
            fill(
                "Uzupełnij, aby wypisać liczbę z dwoma miejscami po przecinku.",
                "x = 3.14159\nprint(f\"{x:.____f}\")",
                listOf("2", "3", "0"),
                "2",
                ".2f oznacza dwa miejsca po przecinku: 3.14.",
            ),
        ),
        lesson(
            "u49l3", "Decimal i Fraction",
            output(
                "from decimal import Decimal\nprint(Decimal(\"0.1\") + Decimal(\"0.2\"))",
                "0.3",
                "Decimal liczy dokładnie w systemie dziesiętnym.",
            ),
            output(
                "from decimal import Decimal\nprint(Decimal(\"1.10\") + Decimal(\"2.20\"))",
                "3.30",
                "Decimal zachowuje liczbę miejsc po przecinku – wygodne przy pieniądzach.",
            ),
            choice(
                "Dlaczego Decimal tworzymy z napisu, np. Decimal(\"0.1\"), a nie Decimal(0.1)?",
                listOf(
                    "float 0.1 już ma błąd, który Decimal przepisze dokładnie",
                    "Decimal nie przyjmuje liczb",
                    "Napis jest szybszy",
                    "Nie ma różnicy",
                ),
                0,
                "Decimal(0.1) da długą liczbę 0.1000000000000000055511…",
            ),
            output(
                "from decimal import Decimal, ROUND_HALF_UP\nx = Decimal(\"2.675\")\nprint(x.quantize(Decimal(\"0.01\"), rounding=ROUND_HALF_UP))",
                "2.68",
                "quantize() z ROUND_HALF_UP zaokrągla „szkolnie”.",
            ),
            output(
                "from fractions import Fraction\nprint(Fraction(1, 3) + Fraction(1, 6))",
                "1/2",
                "Fraction liczy na ułamkach zwykłych i sam je skraca.",
            ),
            output(
                "from fractions import Fraction\nprint(Fraction(3, 6))",
                "1/2",
                "Ułamek jest od razu skracany.",
            ),
            output(
                "from fractions import Fraction\nprint(float(Fraction(1, 4)))",
                "0.25",
                "float() zamienia ułamek na liczbę zmiennoprzecinkową.",
            ),
            fill(
                "Uzupełnij, aby obliczenia były dokładne.",
                "from decimal import Decimal\na = Decimal(\"0.7\")\nb = ____(\"0.1\")\nprint(a + b)",
                listOf("Decimal", "float", "str"),
                "Decimal",
                "float + Decimal zgłasza TypeError, a str + Decimal też jest błędem.",
            ),
        ),
        lesson(
            "u49l4", "Systemy liczbowe",
            output("print(bin(10))", "0b1010", "bin() zwraca zapis dwójkowy z przedrostkiem 0b."),
            output("print(hex(255))", "0xff", "hex() zwraca zapis szesnastkowy z przedrostkiem 0x."),
            output("print(int(\"ff\", 16))", "255", "Drugi argument int() to podstawa systemu."),
            output("print(int(\"1010\", 2))", "10", "Napis dwójkowy zamieniamy na liczbę z podstawą 2."),
            tiles(
                "Zapisz w zmiennej b zapis dwójkowy liczby n",
                listOf("b", "=", "bin(n)"),
                listOf("hex(n)", "int(n, 2)"),
                "bin() zwraca napis z zapisem dwójkowym.",
            ),
            output("print(f\"{10:b}\", f\"{255:x}\")", "1010 ff", "W f-stringu b to system dwójkowy, x szesnastkowy."),
            choice(
                "Co oznacza przedrostek 0o, np. 0o17?",
                listOf("Liczbę ósemkową", "Liczbę szesnastkową", "Liczbę dwójkową", "Zero"),
                0,
                "0o to system ósemkowy (oct), więc 0o17 to 15.",
            ),
            fill(
                "Uzupełnij, aby zamienić napis szesnastkowy na liczbę.",
                "print(int(\"1A\", ____))",
                listOf("16", "2", "10"),
                "16",
                "Litera A istnieje tylko w systemie szesnastkowym; dla 2 i 10 będzie ValueError.",
            ),
        ),
        lesson(
            "u49l5", "Powtórka: liczby",
            output("print(round(4.5), round(5.5))", "4 6", "Remisy zaokrąglamy do liczby parzystej."),
            output(
                "import math\nprint(0.3 - 0.1 == 0.2, math.isclose(0.3 - 0.1, 0.2))",
                "False True",
                "== zawodzi przez błąd float, isclose() nie.",
            ),
            output(
                "from fractions import Fraction\nprint(Fraction(2, 3) * 3)",
                "2",
                "Ułamek o mianowniku 1 wypisuje się jak liczba całkowita.",
            ),
            output(
                "from decimal import Decimal\nprint(Decimal(\"10\") / Decimal(\"4\"))",
                "2.5",
                "Dzielenie Decimal daje dokładny wynik dziesiętny.",
            ),
            output("print(int(\"777\", 8))", "511", "7·64 + 7·8 + 7 = 511."),
            choice(
                "Który typ wybrać do kwot pieniężnych, by uniknąć błędów zaokrągleń?",
                listOf("Decimal", "float", "complex", "bool"),
                0,
                "Decimal liczy dokładnie w systemie dziesiętnym.",
            ),
            fill(
                "Uzupełnij, aby wypisać zapis dwójkowy liczby 5.",
                "print(____(5))",
                listOf("bin", "hex", "oct"),
                "bin",
                "bin(5) to 0b101; hex i oct dają inne systemy.",
            ),
            tiles(
                "Zamień napis s zapisany szesnastkowo na liczbę i zapisz ją w zmiennej n",
                listOf("n", "=", "int(s,", "16)"),
                listOf("hex(s)", "2)"),
                "int(napis, 16) czyta liczbę szesnastkową.",
            ),
        ),
    ),
)
