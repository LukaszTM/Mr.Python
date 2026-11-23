package com.mrpython.app.data.course

import com.mrpython.app.domain.CourseUnit

internal val module46 = CourseUnit(
    id = "u46",
    title = "JSON",
    description = "Zamiana danych Pythona na tekst JSON i z powrotem",
    lessons = listOf(
        lesson(
            "u46l1", "json.dumps",
            output(
                "import json\nprint(json.dumps({\"a\": 1}))",
                "{\"a\": 1}",
                "json.dumps() zamienia słownik na tekst w formacie JSON.",
            ),
            output(
                "import json\nprint(json.dumps([1, True, None]))",
                "[1, true, null]",
                "W JSON-ie True to true, a None to null.",
            ),
            output(
                "import json\nt = json.dumps({\"x\": 2})\nprint(type(t).__name__)",
                "str",
                "Wynik dumps() to zwykły napis.",
            ),
            output(
                "import json\nprint(json.dumps((1, 2)))",
                "[1, 2]",
                "JSON nie ma krotek, więc krotka staje się tablicą.",
            ),
            choice(
                "Na co json.dumps() zamienia słownik Pythona?",
                listOf("Na obiekt JSON w nawiasach {}", "Na tablicę JSON w nawiasach []", "Na listę krotek", "Na plik"),
                0,
                "Słownik to w JSON-ie obiekt z parami klucz: wartość.",
            ),
            choice(
                "Co się stanie?",
                listOf("TypeError – zbioru nie da się zapisać w JSON", "Wypisze [1, 2]", "Wypisze {1, 2}", "Wypisze null"),
                0,
                "JSON nie ma typu zbiór; najpierw trzeba go zamienić np. na listę.",
                code = "import json\nprint(json.dumps({1, 2}))",
            ),
            fill(
                "Uzupełnij, aby zamienić słownik dane na tekst JSON.",
                "import json\ndane = {\"ok\": True}\ntekst = json.____(dane)\nprint(tekst)",
                listOf("dumps", "loads", "dump"),
                "dumps",
                "dumps() (dump string) zwraca napis; loads() działa w drugą stronę, a dump() wymaga pliku.",
            ),
            tiles(
                "Zamień listę wyniki na tekst JSON i zapisz go w zmiennej tekst",
                listOf("tekst", "=", "json.dumps(", "wyniki)"),
                listOf("json.loads(", "wyniki.dumps("),
                "json.dumps(obiekt) zwraca tekst JSON.",
            ),
        ),
        lesson(
            "u46l2", "json.loads",
            output(
                "import json\nd = json.loads('{\"x\": 5}')\nprint(d[\"x\"])",
                "5",
                "json.loads() zamienia tekst JSON na słownik Pythona.",
            ),
            output(
                "import json\nprint(json.loads(\"[1, 2, 3]\")[1])",
                "2",
                "Tablica JSON staje się listą.",
            ),
            output(
                "import json\nprint(json.loads(\"[true, null]\"))",
                "[True, None]",
                "true to True, a null to None.",
            ),
            output(
                "import json\nd = json.loads('{\"a\": 1}')\nprint(type(d).__name__)",
                "dict",
                "Obiekt JSON wczytuje się jako dict.",
            ),
            choice(
                "Co się stanie?",
                listOf("Błąd – JSON wymaga podwójnych cudzysłowów", "Wypisze {'a': 1}", "Wypisze 1", "Wypisze None"),
                0,
                "Apostrofy nie są poprawnym JSON-em, więc loads() zgłasza JSONDecodeError.",
                code = "import json\nprint(json.loads(\"{'a': 1}\"))",
            ),
            output(
                "import json\nd = {1: \"a\"}\nprint(json.loads(json.dumps(d)))",
                "{'1': 'a'}",
                "Klucze w JSON-ie są zawsze napisami, więc liczba 1 wraca jako „1”.",
            ),
            fill(
                "Uzupełnij, aby zamienić tekst JSON na słownik.",
                "import json\nt = '{\"imie\": \"Ola\"}'\nd = json.____(t)\nprint(d[\"imie\"])",
                listOf("loads", "dumps", "load"),
                "loads",
                "loads() (load string) czyta JSON z napisu; load() oczekuje pliku.",
            ),
            choice(
                "Jak zapamiętać różnicę między dumps i loads?",
                listOf(
                    "dumps: Python → tekst, loads: tekst → Python",
                    "dumps: tekst → Python, loads: Python → tekst",
                    "Obie robią to samo",
                    "dumps zapisuje plik, loads go usuwa",
                ),
                0,
                "Litera s na końcu oznacza napis (string): dumps tworzy napis, loads go czyta.",
            ),
        ),
        lesson(
            "u46l3", "Zagnieżdżenia i formatowanie",
            output(
                "import json\nt = '{\"user\": {\"tagi\": [\"a\", \"b\"]}}'\nd = json.loads(t)\nprint(d[\"user\"][\"tagi\"][1])",
                "b",
                "Do zagnieżdżonych danych schodzimy kolejnymi indeksami.",
            ),
            output(
                "import json\nd = {\"lista\": [{\"x\": 1}, {\"x\": 2}]}\nprint(sum(e[\"x\"] for e in d[\"lista\"]))",
                "3",
                "JSON często zawiera listy słowników – iterujemy po nich jak zwykle.",
            ),
            output(
                "import json\nprint(json.dumps({\"a\": 1, \"b\": 2}, indent=2))",
                "{\n  \"a\": 1,\n  \"b\": 2\n}",
                "indent=2 rozkłada JSON na wiele linii z wcięciem 2 spacji.",
            ),
            output(
                "import json\nd = {\"b\": 1, \"a\": 2}\nprint(json.dumps(d, sort_keys=True))",
                "{\"a\": 2, \"b\": 1}",
                "sort_keys=True sortuje klucze alfabetycznie.",
            ),
            output(
                "import json\nprint(json.dumps(\"żółw\"))",
                "\"\\u017c\\u00f3\\u0142w\"",
                "Domyślnie znaki spoza ASCII są zamieniane na kody \\u.",
            ),
            output(
                "import json\nprint(json.dumps(\"żółw\", ensure_ascii=False))",
                "\"żółw\"",
                "ensure_ascii=False zostawia polskie litery bez zmian.",
            ),
            fill(
                "Uzupełnij, aby polskie litery zostały czytelne w wyniku.",
                "import json\nd = {\"miasto\": \"Łódź\"}\nprint(json.dumps(d, ____=False))",
                listOf("ensure_ascii", "sort_keys", "indent"),
                "ensure_ascii",
                "sort_keys=False nic nie zmienia, a indent=False nie wyłącza kodów \\u.",
            ),
            choice(
                "Co robi parametr indent w json.dumps()?",
                listOf("Formatuje JSON w wielu liniach z wcięciami", "Sortuje klucze", "Usuwa spacje", "Kompresuje dane"),
                0,
                "indent ustala liczbę spacji wcięcia, dzięki czemu JSON jest czytelny.",
            ),
        ),
        lesson(
            "u46l4", "Powtórka: JSON",
            output(
                "import json\nprint(json.dumps({\"ok\": False, \"x\": None}))",
                "{\"ok\": false, \"x\": null}",
                "False to false, None to null.",
            ),
            output(
                "import json\nd = json.loads('{\"n\": [3, 4]}')\nprint(d[\"n\"][0] * 2)",
                "6",
                "loads() daje słownik z listą, której pierwszy element to 3.",
            ),
            choice(
                "Który typ Pythona po json.loads() odpowiada tablicy JSON [ ]?",
                listOf("list", "tuple", "set", "dict"),
                0,
                "Tablica JSON zawsze staje się listą.",
            ),
            output(
                "import json\nd = {\"c\": 3, \"a\": 1}\nprint(json.dumps(d, sort_keys=True))",
                "{\"a\": 1, \"c\": 3}",
                "Klucze zostały posortowane.",
            ),
            output(
                "import json\nprint(json.dumps([\"ą\"], ensure_ascii=False))",
                "[\"ą\"]",
                "Z ensure_ascii=False litera ą zostaje bez zmian.",
            ),
            output(
                "import json\nt = json.dumps({\"k\": (1, 2)})\nprint(json.loads(t))",
                "{'k': [1, 2]}",
                "Krotka po drodze przez JSON wraca jako lista.",
            ),
            fill(
                "Uzupełnij, aby wypisać JSON z wcięciem 4 spacji.",
                "import json\nprint(json.dumps({\"a\": 1}, ____=4))",
                listOf("indent", "sort_keys", "ensure_ascii"),
                "indent",
                "indent=4 ustawia wcięcie na 4 spacje; pozostałe parametry nie dodają wcięć.",
            ),
            tiles(
                "Wczytaj tekst JSON z napisu t do zmiennej dane",
                listOf("dane", "=", "json.loads(", "t)"),
                listOf("json.dumps(", "t.loads("),
                "json.loads(napis) zamienia JSON na obiekty Pythona.",
            ),
        ),
    ),
)
