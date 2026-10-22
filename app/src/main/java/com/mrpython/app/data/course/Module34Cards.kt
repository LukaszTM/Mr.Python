package com.mrpython.app.data.course

internal val module34Cards = listOf(
    cards(
        "u34l1",
        explain(
            "Argumenty po nazwie",
            "Obiekt dataclassy tworzymy jak wywołanie funkcji – argumenty można podać po nazwie, w dowolnej " +
                "kolejności. `__repr__` i tak pokaże pola w kolejności z klasy. Brak wymaganego pola to `TypeError`.",
            code = "from dataclasses import dataclass\n\n@dataclass\nclass Pkt:\n    x: int\n    y: int\n\nprint(Pkt(y=1, x=2))",
            output = "Pkt(x=2, y=1)",
        ),
    ),
    cards(
        "u34l2",
        explain(
            "Domyślne pola na końcu",
            "Tak jak parametry funkcji, pola z wartością domyślną muszą stać za polami bez niej. " +
                "Pole bez wartości po polu z wartością domyślną kończy się błędem `TypeError`.",
            code = "from dataclasses import dataclass\n\n@dataclass\nclass A:\n    x: int\n    y: int = 2\n\nprint(A(5))",
            output = "A(x=5, y=2)",
        ),
        explain(
            "Lista jako wartość domyślna",
            "Zapis `tagi: list = []` jest zabroniony (`ValueError`), bo wszystkie obiekty dzieliłyby jedną listę. " +
                "`default_factory` dostaje funkcję bez nawiasów, np. `list` lub `dict`, i wywołuje ją dla każdego obiektu.",
            code = "from dataclasses import dataclass, field\n\n@dataclass\nclass K:\n    rzeczy: list = field(default_factory=list)\n\na, b = K(), K()\na.rzeczy.append(1)\nprint(a.rzeczy, b.rzeczy)",
            output = "[1] []",
        ),
        explain(
            "field(default=...) i lambda",
            "`field(default=5)` działa jak zwykłe `= 5`. Gdy domyślna lista ma mieć już elementy, podaj " +
                "do `default_factory` funkcję lambda, która ją zbuduje.",
            code = "from dataclasses import dataclass, field\n\n@dataclass\nclass P:\n    x: int = field(default=5)\n    pola: list = field(default_factory=lambda: [0, 0])\n\nprint(P())",
            output = "P(x=5, pola=[0, 0])",
        ),
    ),
    cards(
        "u34l3",
        explain(
            "Zbiory tylko z frozen",
            "Zwykłej dataclassy nie da się włożyć do zbioru ani użyć jako klucza słownika – dostaniesz " +
                "`TypeError: unhashable type`. Z `frozen=True` to działa, a równe obiekty liczą się raz.",
            code = "from dataclasses import dataclass\n\n@dataclass(frozen=True)\nclass P:\n    x: int\n\nprint(len({P(1), P(1), P(2)}))",
            output = "2",
        ),
        explain(
            "FrozenInstanceError",
            "Każda próba zmiany pola zamrożonego obiektu – także `p.x += 1` – zgłasza `FrozenInstanceError`. " +
                "To rodzaj `AttributeError`, więc łapie go `except AttributeError`.",
            code = "from dataclasses import dataclass\n@dataclass(frozen=True)\nclass K:\n    r: int\ntry:\n    K(1).r = 2\nexcept AttributeError as e:\n    print(type(e).__name__)",
            output = "FrozenInstanceError",
        ),
    ),
)
