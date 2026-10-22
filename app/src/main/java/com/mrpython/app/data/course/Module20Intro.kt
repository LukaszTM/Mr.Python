package com.mrpython.app.data.course

internal val module20Intro = lesson(
    "u20l0", "Wprowadzenie: data i czas",
    explain(
        "Data: date",
        "Moduł `datetime` ma typ `date` do zapisywania dat. Podajesz rok, miesiąc i dzień – w tej " +
            "kolejności. Z daty odczytasz części przez `.year`, `.month` i `.day`.",
        code = "from datetime import date\nd = date(2024, 12, 24)\nprint(d)\nprint(d.month)",
        output = "2024-12-24\n12",
    ),
    explain(
        "Odstęp: timedelta",
        "`timedelta` to odstęp czasu, np. `timedelta(days=5)`. Dodany do daty przesuwa ją – Python sam " +
            "pilnuje końca miesiąca i lat przestępnych.",
        code = "from datetime import date, timedelta\nd = date(2024, 1, 30)\nprint(d + timedelta(days=5))",
        output = "2024-02-04",
    ),
    explain(
        "Ile dni minęło?",
        "Odjęcie dwóch dat daje `timedelta`. Jego pole `.days` mówi, ile dni dzieli te daty – " +
            "idealne do odliczania np. do urodzin.",
        code = "from datetime import date\na = date(2024, 3, 10)\nb = date(2024, 3, 1)\nprint((a - b).days)",
        output = "9",
    ),
    explain(
        "Porównywanie dat",
        "Daty porównujesz jak liczby: wcześniejsza data jest „mniejsza”. Dlatego działają `<`, `==`, " +
            "`min()` i sortowanie.",
        code = "from datetime import date\na = date(2024, 5, 1)\nb = date(2023, 7, 9)\nprint(a > b)\nprint(min(a, b))",
        output = "True\n2023-07-09",
    ),
    explain(
        "strftime i weekday",
        "`strftime()` zamienia datę na napis w wybranym formacie: `%d` – dzień, `%m` – miesiąc, " +
            "`%Y` – rok. `weekday()` zwraca dzień tygodnia: 0 to poniedziałek, 6 – niedziela.",
        code = "from datetime import date\nd = date(2024, 1, 1)\nprint(d.strftime(\"%d.%m.%Y\"))\nprint(d.weekday())",
        output = "01.01.2024\n0",
    ),
    output(
        "from datetime import date\nd = date(2025, 5, 9)\nprint(d.year)",
        "2025",
        "Pole year przechowuje rok daty.",
    ),
    choice(
        "Jaki typ ma wynik odejmowania dwóch dat?",
        listOf("timedelta", "date", "int", "str"),
        0,
        "Różnica dat to odstęp czasu – timedelta.",
    ),
    fill(
        "Uzupełnij, aby przesunąć datę o tydzień.",
        "from datetime import date, timedelta\nd = date(2025, 6, 1)\nprint(d + timedelta(____=7))",
        listOf("days", "day", "months"),
        "days",
        "timedelta przyjmuje argument days.",
    ),
)
