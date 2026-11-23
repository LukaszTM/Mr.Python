package com.mrpython.app.data.course

internal val module40Intro = lesson(
    "u40l0", "Wprowadzenie: moduł functools",
    explain(
        "reduce – składanie listy",
        "`reduce(f, lista)` z modułu `functools` składa listę w jedną wartość: stosuje funkcję " +
            "dwuargumentową do wyniku i kolejnego elementu. Trzeci argument to wartość początkowa.",
        code = "from functools import reduce\nprint(reduce(lambda a, b: a * b, [2, 3, 4]))\nprint(reduce(lambda a, b: a + b, [], 0))",
        output = "24\n0",
    ),
    explain(
        "partial – ustalone argumenty",
        "`partial(f, ...)` tworzy nową funkcję, w której część argumentów jest już ustalona. " +
            "Nie wywołuje f od razu – to wygodny zamiennik prostej lambdy.",
        code = "from functools import partial\ndef potega(x, n):\n    return x ** n\nkwadrat = partial(potega, n=2)\nprint(kwadrat(4))",
        output = "16",
    ),
    explain(
        "lru_cache – pamięć wyników",
        "Dekorator `@lru_cache` zapamiętuje wyniki funkcji. Gdy wywołasz ją znowu z tymi samymi " +
            "argumentami, wynik pochodzi z pamięci, a funkcja się nie wykonuje. Świetnie " +
            "przyspiesza rekurencję.",
        code = "from functools import lru_cache\n@lru_cache\ndef kw(x):\n    print(\"liczę\")\n    return x * x\nprint(kw(3), kw(3))",
        output = "liczę\n9 9",
    ),
    explain(
        "cache_info",
        "Funkcja z `lru_cache` ma metodę `cache_info()`. `hits` to trafienia w pamięć, a " +
            "`misses` to pudła, czyli wywołania, które trzeba było policzyć.",
        code = "from functools import lru_cache\n@lru_cache\ndef f(x):\n    return x + 1\nprint(f(1), f(1), f(2))\nprint(f.cache_info().hits)",
        output = "2 2 3\n1",
    ),
    explain(
        "wraps – zachowanie nazwy",
        "Funkcja opakowana w inną traci swoją nazwę `__name__`. `@wraps(f)` użyty na funkcji " +
            "wewnętrznej kopiuje nazwę i opis oryginału.",
        code = "from functools import wraps\ndef ozdob(f):\n    @wraps(f)\n    def w():\n        return f()\n    return w",
    ),
    choice(
        "Co zwraca partial(f, 1)?",
        listOf("Nową funkcję z ustalonym argumentem", "Wynik f(1)", "Liczbę 1", "Listę argumentów"),
        0,
        "partial tworzy nową funkcję i jej nie wywołuje.",
    ),
    output(
        "from functools import reduce\nprint(reduce(lambda a, b: a + b, [1, 2, 3]))",
        "6",
        "reduce dodaje po kolei: (1 + 2) + 3.",
    ),
    fill(
        "Uzupełnij dekorator, który zapamiętuje wyniki funkcji.",
        "from functools import lru_cache\n@____\ndef dwa(x):\n    return 2 * x\nprint(dwa(5))",
        listOf("lru_cache", "reduce", "partial", "cache_info"),
        "lru_cache",
        "@lru_cache dodaje funkcji pamięć podręczną.",
    ),
)
