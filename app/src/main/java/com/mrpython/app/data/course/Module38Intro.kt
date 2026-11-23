package com.mrpython.app.data.course

internal val module38Intro = lesson(
    "u38l0", "Wprowadzenie: moduł collections",
    explain(
        "Counter – liczenie",
        "Moduł `collections` ma ulepszone wersje list i słowników. `Counter` liczy, ile razy " +
            "występuje każdy element. Brakujący element ma licznik 0, a `most_common(n)` zwraca " +
            "n najczęstszych par.",
        code = "from collections import Counter\nc = Counter(\"banan\")\nprint(c[\"n\"], c[\"x\"])\nprint(c.most_common(1))",
        output = "2 0\n[('a', 2)]",
    ),
    explain(
        "defaultdict – wartość domyślna",
        "`defaultdict` to słownik, który sam tworzy brakujący klucz. Podajemy mu funkcję " +
            "(bez nawiasów), np. `int` daje 0, a `list` pustą listę. Koniec z KeyError przy `+= 1`.",
        code = "from collections import defaultdict\nd = defaultdict(list)\nd[\"owoce\"].append(\"jabłko\")\nprint(d[\"owoce\"])",
        output = "['jabłko']",
    ),
    explain(
        "namedtuple – krotka z nazwami",
        "`namedtuple` tworzy nowy typ krotki, której pola mają nazwy. Zamiast `p[0]` piszesz " +
            "`p.x` – kod jest czytelniejszy. To nadal krotka: działa indeksowanie i nie da się " +
            "jej zmienić.",
        code = "from collections import namedtuple\nPunkt = namedtuple(\"Punkt\", [\"x\", \"y\"])\np = Punkt(3, 4)\nprint(p.x, p[1])\nprint(p)",
        output = "3 4\nPunkt(x=3, y=4)",
    ),
    explain(
        "deque – kolejka z dwóch stron",
        "`deque` pozwala szybko dodawać i zdejmować elementy z obu końców: `append`, " +
            "`appendleft`, `pop`, `popleft`. `rotate(n)` obraca elementy, a `maxlen` ogranicza " +
            "długość – stare elementy wypadają.",
        code = "from collections import deque\nd = deque([1, 2, 3])\nd.appendleft(0)\nprint(d.popleft(), d.pop())\nd.rotate(1)\nprint(list(d))",
        output = "0 3\n[2, 1]",
    ),
    explain(
        "Kolejność w słowniku",
        "Od Pythona 3.7 zwykły `dict` pamięta kolejność wstawiania kluczy. `OrderedDict` " +
            "dodaje jeszcze metody, np. `move_to_end`, która przenosi klucz na koniec.",
        code = "from collections import OrderedDict\nd = OrderedDict(a=1, b=2, c=3)\nd.move_to_end(\"a\")\nprint(list(d))",
        output = "['b', 'c', 'a']",
    ),
    choice(
        "Co zwraca Counter dla elementu, którego nie ma?",
        listOf("0", "KeyError", "None", "-1"),
        0,
        "Counter dla brakującego elementu zwraca 0.",
    ),
    output(
        "from collections import defaultdict\nd = defaultdict(int)\nfor z in \"aba\":\n    d[z] += 1\nprint(d[\"a\"], d[\"c\"])",
        "2 0",
        "defaultdict(int) daje 0 dla brakującego klucza.",
    ),
    fill(
        "Uzupełnij, aby zdjąć element z lewej strony kolejki.",
        "from collections import deque\nd = deque([5, 6, 7])\nprint(d.____())",
        listOf("popleft", "pop", "left", "shift"),
        "popleft",
        "popleft zdejmuje element z lewego końca deque.",
    ),
)
