package com.mrpython.app.data.course

internal val module69Cards = listOf(
    cards(
        "u69l2",
        explain(
            "Podział na dwie części",
            "`split(maxsplit=1)` tnie napis tylko przy pierwszej spacji, więc reszta zostaje w całości – " +
                "idealne dla komend typu „weź stary klucz”.",
            code = "print(\"weź stary klucz\".split(maxsplit=1))",
            output = "['weź', 'stary klucz']",
        ),
        explain(
            "partition",
            "`partition(sep)` zawsze zwraca trzy części: przed separatorem, sam separator i resztę. " +
                "Gdy separatora brak, dwie ostatnie są puste – więc rozpakowanie nie da błędu.",
            code = "print(\"idź stary las\".partition(\" \"))\nprint(\"patrz\".partition(\" \"))",
            output = "('idź', ' ', 'stary las')\n('patrz', '', '')",
        ),
    ),
)
