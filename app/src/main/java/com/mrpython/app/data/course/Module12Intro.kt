package com.mrpython.app.data.course

internal val module12Intro = lesson(
    "u12l0", "Wprowadzenie: formatowanie tekstu",
    explain(
        "Liczby w f-stringach",
        "Po dwukropku w klamrach f-stringa podajesz format. `:.2f` pokazuje dwa miejsca po przecinku " +
            "(np. przy cenach), `:,` oddziela tysiące, a `:05d` dopełnia liczbę zerami do 5 cyfr.",
        code = "x = 3.14159\nprint(f\"{x:.2f}\")\nprint(f\"{1234567:,}\")\nprint(f\"{42:05d}\")",
        output = "3.14\n1,234,567\n00042",
    ),
    explain(
        "Wyrównywanie",
        "Liczba w formacie to szerokość pola. `<` wyrównuje do lewej, `>` do prawej, a `^` środkuje. " +
            "Wolne miejsce wypełniają spacje albo znak podany przed strzałką. Tak robi się równe tabelki.",
        code = "print(f\"[{'ok':>5}]\")\nprint(f\"[{'ok':<5}]\")\nprint(f\"{'a':*^5}\")",
        output = "[   ok]\n[ok   ]\n**a**",
    ),
    explain(
        "format() i metody napisów",
        "Metoda `format()` wstawia argumenty po kolei w miejsca `{}`. Napisy mają też gotowe metody: " +
            "`zfill()` dopełnia zerami, `ljust()`, `rjust()` i `center()` wyrównują.",
        code = "print(\"{} + {} = {}\".format(2, 3, 5))\nprint(\"7\".zfill(3))\nprint(\"ab\".ljust(4, \".\") + \"|\")",
        output = "2 + 3 = 5\n007\nab..|",
    ),
    explain(
        "Znaki specjalne",
        "Ukośnik wsteczny tworzy znaki specjalne: `\\n` to nowa linia, `\\\"` – cudzysłów w napisie, " +
            "a `\\\\` – jeden ukośnik. Potrójne cudzysłowy pozwalają pisać napis w kilku liniach.",
        code = "print(\"raz\\ndwa\")\nprint(\"a\\\\b\")",
        output = "raz\ndwa\na\\b",
    ),
    explain(
        "Surowe napisy",
        "Litera `r` przed cudzysłowem tworzy surowy napis: ukośniki są w nim zwykłymi znakami. " +
            "Przydaje się do ścieżek w Windows.",
        code = "print(r\"C:\\nowy\")\nprint(len(r\"a\\nb\"))",
        output = "C:\\nowy\n4",
    ),
    output(
        "print(f\"{7:.2f}\")",
        "7.00",
        "Format .2f zawsze pokazuje dwa miejsca po przecinku.",
    ),
    choice(
        "Który znak w formacie wyrównuje tekst do prawej?",
        listOf(">", "<", "^", "|"),
        0,
        "> wyrównuje do prawej, < do lewej, a ^ środkuje.",
    ),
    fill(
        "Uzupełnij, aby wypisać: 05",
        "print(\"5\".____(2))",
        listOf("zfill", "ljust", "upper"),
        "zfill",
        "zfill() dopełnia napis zerami z lewej.",
    ),
)
