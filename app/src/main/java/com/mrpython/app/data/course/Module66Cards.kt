package com.mrpython.app.data.course

internal val module66Cards = listOf(
    cards(
        "u66l1",
        explain(
            "Odległość: hypot i dist",
            "`math.hypot(a, b)` liczy przeciwprostokątną z twierdzenia Pitagorasa, " +
                "a `math.dist(p, q)` – odległość między dwoma punktami podanymi jako krotki.",
            code = "import math\nprint(math.hypot(3, 4))\nprint(math.dist((0, 0), (6, 8)))",
            output = "5.0\n10.0",
        ),
        explain(
            "Liczenie wyborów: comb i perm",
            "`math.comb(n, k)` mówi, na ile sposobów wybrać k rzeczy z n (kolejność bez znaczenia). " +
                "`math.perm(n, k)` liczy ustawienia, w których kolejność ma znaczenie; `perm(n)` to n!.",
            code = "import math\nprint(math.comb(4, 2), math.perm(4, 2), math.perm(4))",
            output = "6 12 24",
        ),
    ),
    cards(
        "u66l2",
        explain(
            "Data z godziną: datetime",
            "Klasa `datetime` to data razem z godziną i minutą. Pola `hour` i `minute` dają czas, " +
                "a w `strftime` kody `%H` i `%M` wypisują godzinę i minuty.",
            code = "from datetime import datetime\nt = datetime(2026, 7, 4, 9, 5)\nprint(t.hour, t.minute)\nprint(t.strftime(\"%d.%m %H:%M\"))",
            output = "9 5\n04.07 09:05",
        ),
        explain(
            "Napis na datę: strptime",
            "`datetime.strptime(napis, wzór)` działa odwrotnie niż `strftime`: czyta datę z napisu " +
                "według podanego wzoru (p – parse, f – format).",
            code = "from datetime import datetime\nt = datetime.strptime(\"15/08/2025\", \"%d/%m/%Y\")\nprint(t.day, t.month, t.year)",
            output = "15 8 2025",
        ),
        explain(
            "Godziny w timedelta",
            "`timedelta` przyjmuje też `hours=`, `minutes=` i `weeks=`. Wypisany pokazuje czas jako " +
                "`g:mm:ss`, a `total_seconds()` zamienia go na liczbę sekund.",
            code = "from datetime import timedelta\nt = timedelta(hours=1, minutes=30)\nprint(t)\nprint(t.total_seconds())",
            output = "1:30:00\n5400.0",
        ),
    ),
    cards(
        "u66l5",
        explain(
            "Komplet porównań: total_ordering",
            "Dekorator `@total_ordering` z `functools` dopisuje brakujące porównania (`<=`, `>`, `>=`). " +
                "Wystarczy, że zdefiniujesz `__lt__` (zwykle też `__eq__`).",
            code = "from functools import total_ordering\n@total_ordering\nclass W:\n    def __init__(self, p): self.p = p\n    def __lt__(self, o): return self.p < o.p\nprint(W(2) <= W(3), W(5) > W(3))",
            output = "True True",
        ),
    ),
    cards(
        "u66l7",
        explain(
            "JSON w pliku: dump i load",
            "Bez litery „s” funkcje pracują na plikach: `json.dump(dane, f)` zapisuje dane do otwartego pliku, " +
                "a `json.load(f)` je z niego wczytuje. Wersje z „s” (`dumps`, `loads`) działają na napisach.",
            code = "import json\nwith open(\"dane.json\", \"w\") as f:\n    json.dump({\"pkt\": 10}, f)\nwith open(\"dane.json\") as f:\n    print(json.load(f))",
            output = "{'pkt': 10}",
        ),
    ),
)
