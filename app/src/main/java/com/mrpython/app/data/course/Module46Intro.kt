package com.mrpython.app.data.course

internal val module46Intro = lesson(
    "u46l0", "Wprowadzenie: JSON",
    explain(
        "Czym jest JSON?",
        "JSON to popularny tekstowy format wymiany danych – używają go strony WWW, aplikacje i " +
            "pliki konfiguracyjne. Wygląda jak słowniki i listy Pythona, ale jest zwykłym napisem. " +
            "Obsługuje go wbudowany moduł `json`.",
        code = "import json\nt = '{\"imie\": \"Ola\", \"wiek\": 30}'\nprint(type(t).__name__)",
        output = "str",
    ),
    explain(
        "json.dumps – Python na tekst",
        "`json.dumps()` zamienia dane Pythona na napis JSON. `True` staje się `true`, `None` – " +
            "`null`, a krotka – tablicą. Zbioru nie da się zapisać (TypeError).",
        code = "import json\nprint(json.dumps({\"ok\": True, \"x\": None}))\nprint(json.dumps((1, 2)))",
        output = "{\"ok\": true, \"x\": null}\n[1, 2]",
    ),
    explain(
        "json.loads – tekst na Pythona",
        "`json.loads()` działa odwrotnie: czyta napis JSON i zwraca słownik lub listę. JSON wymaga " +
            "podwójnych cudzysłowów, a klucze obiektów są zawsze napisami. Literka s w nazwie " +
            "oznacza string.",
        code = "import json\nd = json.loads('{\"x\": [1, 2]}')\nprint(d[\"x\"][1])\nprint(json.loads(json.dumps({1: \"a\"})))",
        output = "2\n{'1': 'a'}",
    ),
    explain(
        "Dane zagnieżdżone",
        "JSON często zawiera słowniki w słownikach i listy słowników. Schodzimy do nich kolejnymi " +
            "indeksami i iterujemy jak po zwykłych danych.",
        code = "import json\nt = '{\"user\": {\"tagi\": [\"a\", \"b\"]}}'\nd = json.loads(t)\nprint(d[\"user\"][\"tagi\"][0])",
        output = "a",
    ),
    explain(
        "Formatowanie",
        "`indent=2` rozkłada JSON na wiele linii z wcięciami, `sort_keys=True` sortuje klucze, a " +
            "`ensure_ascii=False` zostawia polskie litery zamiast kodów `\\u`.",
        code = "import json\nd = {\"b\": \"żółw\", \"a\": 1}\nprint(json.dumps(d, sort_keys=True, ensure_ascii=False))",
        output = "{\"a\": 1, \"b\": \"żółw\"}",
    ),
    choice(
        "Co robi json.loads()?",
        listOf("Zamienia tekst JSON na obiekty Pythona", "Zamienia obiekty Pythona na tekst JSON", "Zapisuje plik", "Sortuje klucze"),
        0,
        "loads czyta napis (string) z JSON-em.",
    ),
    output(
        "import json\nprint(json.dumps([1, False, None]))",
        "[1, false, null]",
        "False to false, a None to null.",
    ),
    fill(
        "Uzupełnij, aby zamienić słownik na tekst JSON.",
        "import json\ndane = {\"a\": 1}\nprint(json.____(dane))",
        listOf("dumps", "loads", "dump"),
        "dumps",
        "dumps() zwraca napis; loads() działa odwrotnie, a dump() wymaga pliku.",
    ),
)
