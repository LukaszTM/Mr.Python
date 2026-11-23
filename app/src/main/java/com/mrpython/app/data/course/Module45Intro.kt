package com.mrpython.app.data.course

internal val module45Intro = lesson(
    "u45l0", "Wprowadzenie: wyrażenia regularne",
    explain(
        "Wzorce i re.search",
        "Wyrażenie regularne to wzorzec opisujący fragment tekstu, np. `\\d+` – „jedna lub więcej " +
            "cyfr”. `re.search()` znajduje pierwsze dopasowanie (albo zwraca None), a `group()` " +
            "daje dopasowany tekst. Literka `r` przed wzorcem zostawia ukośniki bez zmian.",
        code = "import re\nm = re.search(r\"\\d+\", \"mam 25 lat\")\nprint(m.group(), m.start())",
        output = "25 4",
    ),
    explain(
        "re.findall – wszystkie dopasowania",
        "`re.findall()` zwraca listę wszystkich dopasowanych fragmentów (pustą, gdy nic nie " +
            "pasuje). `re.match()` sprawdza tylko początek napisu.",
        code = "import re\nt = \"1 kot, 22 psy\"\nprint(re.findall(r\"\\d+\", t))\nprint(re.match(\"kot\", t))",
        output = "['1', '22']\nNone",
    ),
    explain(
        "Klasy znaków i kwantyfikatory",
        "`\\d` to cyfra, `\\w` litera, cyfra lub _, `\\s` biały znak, a `[aeo]` dowolny znak z listy. " +
            "Kwantyfikatory mówią „ile razy”: `+` co najmniej raz, `*` zero lub więcej, `?` opcjonalnie, " +
            "`{3}` dokładnie 3.",
        code = "import re\nprint(re.findall(r\"\\w+\", \"Ala ma kota\"))\nprint(re.findall(r\"\\d{2}\", \"12345\"))\nprint(re.findall(\"kolou?r\", \"kolor kolour\"))",
        output = "['Ala', 'ma', 'kota']\n['12', '34']\n['kolor', 'kolour']",
    ),
    explain(
        "Grupy",
        "Nawiasy tworzą grupę, którą odczytasz przez `group(1)` albo `groups()`. Grupa nazwana " +
            "`(?P<nazwa>...)` pozwala pisać `group(\"nazwa\")`.",
        code = "import re\nw = r\"(?P<rok>\\d{4})-(\\d{2})\"\nm = re.search(w, \"2026-10\")\nprint(m.group(\"rok\"), m.group(2))\nprint(m.groups())",
        output = "2026 10\n('2026', '10')",
    ),
    explain(
        "Zamiana, podział i walidacja",
        "`re.sub()` zamienia każde dopasowanie na inny tekst, a `re.split()` dzieli napis według " +
            "wzorca. `re.fullmatch()` sprawdza, czy cały napis pasuje – idealne do walidacji, " +
            "np. kodu pocztowego.",
        code = "import re\nprint(re.sub(r\"\\d\", \"#\", \"pin 123\"))\nprint(re.split(r\"[,;]\", \"a,b;c\"))\nprint(bool(re.fullmatch(r\"\\d{2}-\\d{3}\", \"00-950\")))",
        output = "pin ###\n['a', 'b', 'c']\nTrue",
    ),
    output(
        "import re\nprint(re.findall(r\"\\d+\", \"a1 b22 c333\"))",
        "['1', '22', '333']",
        "findall() zwraca listę wszystkich liczb jako napisy.",
    ),
    choice(
        "Co oznacza + we wzorcu \\d+?",
        listOf("Co najmniej jedno powtórzenie", "Dokładnie jedno powtórzenie", "Zero lub więcej", "Dodawanie liczb"),
        0,
        "+ to „jeden lub więcej razy”.",
    ),
    fill(
        "Uzupełnij, aby zamienić każdą cyfrę na gwiazdkę.",
        "import re\nprint(re.____(r\"\\d\", \"*\", \"kod 42\"))",
        listOf("sub", "split", "findall", "search"),
        "sub",
        "re.sub(wzorzec, zamiana, tekst) zwraca nowy napis.",
    ),
)
