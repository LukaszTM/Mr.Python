package com.mrpython.app.data.course

internal val module63Cards = listOf(
    cards(
        "u63l3",
        explain(
            "** wewnątrz słownika",
            "W klamrach `{ }` zapis `**d` wkleja wszystkie pary ze słownika `d`. Tak zbudujesz nowy " +
                "słownik z dodatkowymi kluczami; klucz podany później nadpisuje wcześniejszy.",
            code = "d = {\"a\": 1, \"b\": 2}\nprint({**d, \"c\": 3})\nprint({**d, \"a\": 0})",
            output = "{'a': 1, 'b': 2, 'c': 3}\n{'a': 0, 'b': 2}",
        ),
    ),
    cards(
        "u63l4",
        explain(
            "map z dwiema listami",
            "Gdy funkcja ma dwa parametry, podaj `map` dwie listy: dostanie po jednym elemencie z każdej, " +
                "para po parze. Jak `zip`, kończy na najkrótszej liście.",
            code = "suma = lambda a, b: a + b\nprint(list(map(suma, [1, 2], [10, 20])))",
            output = "[11, 22]",
        ),
    ),
    cards(
        "u63l6",
        explain(
            "Średnik w jednej linii",
            "Średnik `;` pozwala zapisać kilka krótkich instrukcji w jednej linii – `c(); c()` to dwa " +
                "wywołania po kolei. Działa, ale zwykle czytelniej jest pisać każdą instrukcję osobno.",
            code = "x = 1; y = 2\nprint(x + y); print(\"koniec\")",
            output = "3\nkoniec",
        ),
    ),
)
