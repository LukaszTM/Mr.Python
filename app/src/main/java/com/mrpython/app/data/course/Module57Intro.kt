package com.mrpython.app.data.course

internal val module57Intro = lesson(
    "u57l0", "Wprowadzenie: projekt quiz",
    explain(
        "Cel projektu",
        "Zbudujesz quiz: pytania zapisane jako dane, sprawdzanie odpowiedzi, liczenie punktów " +
            "i procentów, losową kolejność pytań, a na koniec klasę `Pytanie`. " +
            "Każda lekcja dokłada jeden element.",
    ),
    explain(
        "Pytania jako słowniki",
        "Pytanie to słownik z treścią i odpowiedzią, a cały quiz to lista takich słowników. " +
            "Pętla `for` przechodzi po kolejnych pytaniach.",
        code = "pytania = [\n    {\"tresc\": \"2 + 2?\", \"odp\": \"4\"},\n    {\"tresc\": \"3 * 3?\", \"odp\": \"9\"},\n]\nfor p in pytania:\n    print(p[\"tresc\"])",
        output = "2 + 2?\n3 * 3?",
    ),
    explain(
        "Sprawdzanie odpowiedzi",
        "Gracz może wpisać spacje albo wielkie litery. Dlatego przed porównaniem czyścimy odpowiedź: " +
            "`strip()` usuwa spacje z brzegów, a `lower()` zamienia litery na małe.",
        code = "poprawna = \"Paryż\"\nodp = \" PARYŻ \"\nprint(odp == poprawna)\nprint(odp.strip().lower() == poprawna.lower())",
        output = "False\nTrue",
    ),
    explain(
        "Punkty i procenty",
        "`True` liczy się jak 1, więc `sum()` z listy wyników daje liczbę punktów. Procent to " +
            "`punkty / wszystkie * 100` albo format `:.0%` w f-stringu.",
        code = "wyniki = [True, False, True, True]\npunkty = sum(wyniki)\nprint(punkty, f\"{punkty / len(wyniki):.0%}\")",
        output = "3 75%",
    ),
    explain(
        "Tasowanie pytań",
        "`random.shuffle(lista)` miesza listę w miejscu, więc kolejność za każdym razem jest inna. " +
            "Żeby nie zepsuć oryginału, tasuj kopię `pytania[:]`.",
        code = "import random\n\npytania = [\"P1\", \"P2\", \"P3\"]\nkolejka = pytania[:]\nrandom.shuffle(kolejka)\nprint(sorted(kolejka) == pytania)",
        output = "True",
    ),
    output(
        "print(sum([True, True, False]))",
        "2",
        "Każde True liczy się jako 1.",
    ),
    choice(
        "Co robi random.shuffle(lista)?",
        listOf("Miesza elementy listy w miejscu", "Zwraca posortowaną listę", "Losuje jeden element", "Usuwa losowy element"),
        0,
        "shuffle zmienia kolejność elementów samej listy.",
    ),
    fill(
        "Uzupełnij, aby odpowiedź \" TAK \" została uznana za poprawną.",
        "odp = \" TAK \"\nprint(odp.strip().____() == \"tak\")",
        listOf("lower", "upper", "title"),
        "lower",
        "Po lower() mamy \"tak\"; upper() da \"TAK\", a title() – \"Tak\".",
    ),
)
