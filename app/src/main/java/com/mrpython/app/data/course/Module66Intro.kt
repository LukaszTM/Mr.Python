package com.mrpython.app.data.course

internal val module66Intro = lesson(
    "u66l0", "Wprowadzenie: tydzień powtórek – biblioteka standardowa",
    explain(
        "math i datetime",
        "Ten tydzień to przegląd gotowych modułów. `math` ma pierwiastki i zaokrąglenia, a `datetime` " +
            "liczy na datach – różnica dwóch dat to `timedelta`.",
        code = "import math\nfrom datetime import date\nprint(math.sqrt(16), math.ceil(2.1))\nprint((date(2026, 3, 1) - date(2026, 2, 1)).days)",
        output = "4.0 3\n28",
    ),
    explain(
        "collections",
        "`Counter` liczy, `deque` to kolejka, `namedtuple` to krotka z nazwami pól, a `defaultdict` " +
            "sam tworzy brakującą wartość – idealny do grupowania.",
        code = "from collections import defaultdict\ng = defaultdict(list)\nfor s in [\"kot\", \"koza\", \"pies\"]:\n    g[s[0]].append(s)\nprint(dict(g))",
        output = "{'k': ['kot', 'koza'], 'p': ['pies']}",
    ),
    explain(
        "itertools",
        "`itertools` daje gotowe iteratory: `chain` łączy, `combinations` wybiera pary, " +
            "`accumulate` liczy sumy narastające, a `groupby` grupuje sąsiednie elementy.",
        code = "from itertools import accumulate, combinations\nprint(list(accumulate([1, 2, 3])))\nprint(list(combinations(\"ABC\", 2)))",
        output = "[1, 3, 6]\n[('A', 'B'), ('A', 'C'), ('B', 'C')]",
    ),
    explain(
        "functools",
        "`reduce` składa listę w jedną wartość, `partial` tworzy funkcję z częścią argumentów " +
            "ustawioną z góry, a `lru_cache` zapamiętuje wyniki wywołań.",
        code = "from functools import reduce, partial\nprint(reduce(lambda a, b: a * b, [1, 2, 3, 4]))\nz_binarnego = partial(int, base=2)\nprint(z_binarnego(\"101\"))",
        output = "24\n5",
    ),
    explain(
        "re i json",
        "`re` szuka wzorców w tekście, np. `\\d+` to ciąg cyfr. `json.dumps` zamienia dane na tekst " +
            "JSON, a `json.loads` – tekst z powrotem na dane.",
        code = "import re, json\nprint(re.findall(r\"\\d+\", \"3 koty i 12 psów\"))\nprint(json.dumps({\"ok\": True}))",
        output = "['3', '12']\n{\"ok\": true}",
    ),
    output(
        "from itertools import accumulate\nprint(list(accumulate([2, 2, 2])))",
        "[2, 4, 6]",
        "accumulate zwraca sumy narastające: 2, 2+2, 2+2+2.",
    ),
    choice(
        "Która funkcja zamienia słownik na tekst w formacie JSON?",
        listOf("json.dumps", "json.loads", "re.findall", "str.split"),
        0,
        "dumps zapisuje dane jako tekst, loads robi odwrotnie.",
    ),
)
