package com.mrpython.app.data.course

internal val module20Cards = listOf(
    cards(
        "u20l1",
        explain(
            "Dwa sposoby importu",
            "Po `import datetime` piszesz pełną nazwę `datetime.date(...)` – najpierw moduł, potem typ. " +
                "Po `from datetime import date` wystarczy samo `date(...)`.",
            code = "import datetime\nd = datetime.date(2024, 3, 15)\nprint(d)",
            output = "2024-03-15",
        ),
        explain(
            "Tylko prawdziwe daty",
            "Python sprawdza, czy taki dzień istnieje. `date(2025, 2, 30)` albo miesiąc 13 zgłaszają " +
                "`ValueError`. 29 lutego zadziała tylko w roku przestępnym, np. 2024.",
            code = "from datetime import date\ntry:\n    date(2025, 2, 30)\nexcept ValueError:\n    print(\"nie ma takiego dnia\")",
            output = "nie ma takiego dnia",
        ),
        explain(
            "Części daty to liczby",
            "`d.day`, `d.month` i `d.year` to zwykłe liczby `int` – bez zer na początku. Dodanie do nich " +
                "czegoś nie zmienia daty. `str(d)` daje napis RRRR-MM-DD (zawsze 10 znaków).",
            code = "from datetime import date\nd = date(2025, 1, 31)\nprint(d.day + 1)\nprint(\"Data: \" + str(d))",
            output = "32\nData: 2025-01-31",
        ),
    ),
    cards(
        "u20l2",
        explain(
            "Tygodnie i cofanie",
            "`timedelta` przyjmuje też `weeks=`: tydzień to 7 dni. Odstęp można odjąć od daty, " +
                "żeby cofnąć się w czasie, a dwa odstępy – dodać do siebie.",
            code = "from datetime import date, timedelta\nprint(timedelta(weeks=2).days)\nd = date(2024, 3, 1)\nprint(d - timedelta(days=1))",
            output = "14\n2024-02-29",
        ),
        explain(
            "Co z czym można liczyć?",
            "Data + odstęp = data. Data − data = odstęp (ujemny, gdy pierwsza data jest wcześniejsza). " +
                "Dwóch dat nie da się dodać – to `TypeError`.",
            code = "from datetime import date\na = date(2025, 1, 10)\nb = date(2025, 1, 20)\nprint((a - b).days)",
            output = "-10",
        ),
    ),
    cards(
        "u20l3",
        explain(
            "Data w przedziale",
            "Porównania można łączyć: `a <= d <= b` znaczy „d jest między a i b (włącznie)”. " +
                "Listę dat posortujesz przez `sort()` lub `sorted()` – od najwcześniejszej.",
            code = "from datetime import date\nd = date(2024, 6, 15)\nprint(date(2024, 1, 1) <= d <= date(2024, 12, 31))",
            output = "True",
        ),
        explain(
            "Data to nie napis",
            "Datę możesz porównać tylko z inną datą. Porównanie `<` z napisem, np. \"2026-01-01\", " +
                "zgłasza `TypeError`, a `==` z napisem daje po prostu `False`.",
            code = "from datetime import date\nprint(date(2025, 1, 1) == \"2025-01-01\")",
            output = "False",
        ),
    ),
    cards(
        "u20l4",
        explain(
            "Więcej o wzorze",
            "Zwykły tekst we wzorze `strftime` przepisuje się bez zmian. Wielkość liter ma znaczenie: " +
                "`%Y` to rok 2025, `%y` – tylko 25, a `%M` to minuty, nie miesiąc. Wynik to zawsze napis.",
            code = "from datetime import date\nd = date(2025, 5, 4)\nprint(d.strftime(\"Rok %Y, %y\"))\nprint(d.strftime(\"%Y%m%d\"))",
            output = "Rok 2025, 25\n20250504",
        ),
        explain(
            "Nazwa dnia tygodnia",
            "Liczba z `weekday()` świetnie nadaje się na indeks listy z nazwami dni. " +
                "Weekend to `weekday() >= 5`.",
            code = "from datetime import date\ndni = [\"pn\", \"wt\", \"śr\", \"cz\", \"pt\", \"sb\", \"nd\"]\nd = date(2025, 10, 22)\nprint(dni[d.weekday()])",
            output = "śr",
        ),
    ),
)
