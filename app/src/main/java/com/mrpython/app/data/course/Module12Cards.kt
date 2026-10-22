package com.mrpython.app.data.course

internal val module12Cards = listOf(
    cards(
        "u12l1",
        explain(
            "Procenty: %",
            "Format `%` mnoży liczbę przez 100 i dopisuje znak procentu. Liczba przed nim ustala " +
                "miejsca po przecinku: `.1%` to jedno miejsce, a `.0%` – żadne.",
            code = "p = 0.256\nprint(f\"{p:.1%}\")\nprint(f\"{0.5:.0%}\")",
            output = "25.6%\n50%",
        ),
        explain(
            "Łączenie formatów",
            "Litera `d` oznacza liczbę całkowitą, a `f` – liczbę z przecinkiem. Formaty można łączyć: " +
                "`:,.2f` daje separator tysięcy i dwa miejsca po przecinku. W klamrach może stać całe wyrażenie.",
            code = "print(f\"{1234.5:,.2f}\")\nprint(f\"{10 / 4:.1f}\")",
            output = "1,234.50\n2.5",
        ),
    ),
    cards(
        "u12l2",
        explain(
            "Szerokość to minimum",
            "Szerokość pola to najmniejsza liczba znaków – za długi tekst nie zostanie obcięty. " +
                "Gdy przy `^` wolnych miejsc jest nieparzyście, dodatkowa spacja trafia na prawo.",
            code = "print(f\"[{'python':>3}]\")\nprint(f\"[{'ab':^5}]\")",
            output = "[python]\n[ ab  ]",
        ),
        explain(
            "Wyrównanie i precyzja",
            "Wyrównanie i liczbę miejsc po przecinku zapisujesz razem: najpierw znak wyrównania " +
                "i szerokość, potem precyzja, np. `>8.2f`.",
            code = "x = 3.14159\nprint(f\"[{x:>8.2f}]\")",
            output = "[    3.14]",
        ),
    ),
    cards(
        "u12l3",
        explain(
            "Numery w klamrach",
            "W `format()` możesz wpisać w klamry numer argumentu: `{0}` to pierwszy, a `{1}` – drugi. " +
                "Ten sam numer wolno użyć kilka razy.",
            code = "print(\"{1}-{0}-{1}\".format(\"a\", \"b\"))",
            output = "b-a-b",
        ),
        explain(
            "Nazwy i formaty w format()",
            "Klamry mogą zawierać nazwę, np. `{imie}`, a wartość podajesz potem jako `imie=...`. " +
                "Po dwukropku działają te same formaty co w f-stringach, np. `{:.1f}` albo `{:>4}`.",
            code = "print(\"{imie}: {pkt:.1f}\".format(imie=\"Ola\", pkt=4.56))",
            output = "Ola: 4.6",
        ),
        explain(
            "Dłuższy napis zostaje",
            "`zfill()`, `ljust()`, `rjust()` i `center()` tylko dopełniają napis – gdy jest już dłuższy, " +
                "nic nie zmieniają. Drugi argument `rjust()` to znak wypełnienia, np. zero.",
            code = "print(\"12345\".zfill(3))\nprint(\"7\".rjust(3, \"0\"))",
            output = "12345\n007",
        ),
    ),
    cards(
        "u12l4",
        explain(
            "Znak specjalny to jeden znak",
            "`\\n`, `\\t` czy `\\\"` zapisujesz dwoma znakami, ale w napisie to jeden znak – widać to " +
                "w `len()`. W surowym napisie `r\"...\"` ukośnik i litera to dwa osobne znaki.",
            code = "print(len(\"a\\nb\"))\nprint(len(\"\\t\"))",
            output = "3\n1",
        ),
        explain(
            "Potrójne cudzysłowy",
            "Napis w potrójnych cudzysłowach `\"\"\"...\"\"\"` może ciągnąć się przez kilka linii. " +
                "W środku wolno też użyć zwykłego cudzysłowu bez ukośnika.",
            code = "t = \"\"\"Ala \"ma\"\nkota\"\"\"\nprint(t)",
            output = "Ala \"ma\"\nkota",
        ),
        explain(
            "Pułapka w ścieżkach",
            "W zwykłym napisie `\"C:\\temp\"` fragment `\\t` zamieni się w tabulator! Ścieżki zapisuj " +
                "jako surowy napis `r\"C:\\temp\"` albo podwajaj ukośniki: `\\\\`.",
            code = "print(r\"C:\\temp\")\nprint(\"C:\\\\temp\")",
            output = "C:\\temp\nC:\\temp",
        ),
    ),
)
