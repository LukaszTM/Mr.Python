package com.mrpython.app.data.course

internal val module45Cards = listOf(
    cards(
        "u45l1",
        explain(
            "Gdzie jest dopasowanie?",
            "Obiekt dopasowania zna swoje miejsce: `start()` to indeks początku, `end()` indeks tuż " +
                "za końcem, a `span()` zwraca oba naraz jako krotkę.",
            code = "import re\nm = re.search(\"ma\", \"Ala ma kota\")\nprint(m.start(), m.end(), m.span())",
            output = "4 6 (4, 6)",
        ),
        explain(
            "Sprawdź, czy coś znaleziono",
            "Gdy nic nie pasuje, dostajemy `None`, a `None.group()` kończy się `AttributeError`. " +
                "Dlatego wynik sprawdzamy w `if` – `None` jest fałszywe, a dopasowanie prawdziwe.",
            code = "import re\nm = re.search(r\"\\d\", \"bez cyfr\")\nif m:\n    print(m.group())\nelse:\n    print(\"brak\")",
            output = "brak",
        ),
    ),
    cards(
        "u45l2",
        explain(
            "Dopasowania to napisy",
            "`findall()` zwraca listę napisów, nawet gdy znajduje liczby – przed liczeniem zamieniamy " +
                "je przez `int()`. `len()` tej listy mówi, ile było dopasowań.",
            code = "import re\nw = re.findall(r\"\\d+\", \"3 + 4 + 5\")\nprint(w, len(w))\nprint(sum(int(x) for x in w))",
            output = "['3', '4', '5'] 3\n12",
        ),
        explain(
            "Plus łapie jak najwięcej",
            "`\\d+` bierze najdłuższy możliwy ciąg cyfr. Każdy inny znak, np. spacja albo myślnik, " +
                "przerywa dopasowanie i zaczyna się następne.",
            code = "import re\nprint(re.findall(r\"\\d+\", \"12 3 600-700\"))",
            output = "['12', '3', '600', '700']",
        ),
    ),
    cards(
        "u45l3",
        explain(
            "Kwantyfikator i znak przed nim",
            "Kwantyfikator dotyczy tylko tego, co stoi tuż przed nim: w `ab*` gwiazdka działa na " +
                "`b`, nie na całe `ab`. Po klasie `[aeiou]+` łapie ciąg znaków z tej klasy.",
            code = "import re\nprint(re.findall(\"ab*\", \"a ab abb\"))\nprint(re.findall(\"[aeiouy]+\", \"kolejka\"))",
            output = "['a', 'ab', 'abb']\n['o', 'e', 'a']",
        ),
    ),
    cards(
        "u45l4",
        explain(
            "group(0) i groupdict()",
            "`group(0)` to całe dopasowanie (jak `group()`), a grupy liczymy od 1, od lewej. " +
                "`groupdict()` zwraca słownik grup nazwanych: nazwa → tekst.",
            code = "import re\nm = re.search(r\"(?P<h>\\d+):(?P<m>\\d+)\", \"o 9:45\")\nprint(m.group(0), m.group(1))\nprint(m.groupdict())",
            output = "9:45 9\n{'h': '9', 'm': '45'}",
        ),
        explain(
            "findall z grupami",
            "Gdy wzorzec ma grupy, `findall()` zwraca tylko ich zawartość: przy jednej grupie listę " +
                "napisów, przy kilku – listę krotek.",
            code = "import re\nprint(re.findall(r\"(\\d+)zł\", \"5zł 20zł 7gr\"))\nprint(re.findall(r\"(\\w)=(\\d)\", \"a=1 b=2\"))",
            output = "['5', '20']\n[('a', '1'), ('b', '2')]",
        ),
    ),
    cards(
        "u45l5",
        explain(
            "Grupy w zamianie",
            "W tekście zamiany `re.sub()` zapis `\\1`, `\\2` wstawia zawartość grup – tak można " +
                "zamieniać części miejscami. Zamiana na pusty napis `\"\"` usuwa dopasowania.",
            code = "import re\nprint(re.sub(r\"(\\w+) (\\w+)\", r\"\\2 \\1\", \"Jan Nowak\"))\nprint(re.sub(\"[aeiou]\", \"\", \"kalafior\"))",
            output = "Nowak Jan\nklfr",
        ),
        explain(
            "Kropka we wzorcu",
            "Kropka `.` we wzorcu oznacza dowolny znak. Żeby dopasować prawdziwą kropkę, piszemy " +
                "`\\.`. Wewnątrz nawiasów kwadratowych, np. `[\\w.]`, kropka jest zwykłym znakiem.",
            code = "import re\nprint(re.findall(\"k.t\", \"kot kit k.t\"))\nprint(re.findall(r\"k\\.t\", \"kot kit k.t\"))",
            output = "['kot', 'kit', 'k.t']\n['k.t']",
        ),
    ),
)
