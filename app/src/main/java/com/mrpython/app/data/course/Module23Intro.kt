package com.mrpython.app.data.course

internal val module23Intro = lesson(
    "u23l0", "Wprowadzenie: generatory",
    explain(
        "iter i next",
        "Pętla `for` w środku korzysta z iteratora – obiektu, który podaje elementy jeden po drugim. " +
            "`iter(lista)` tworzy iterator, a `next(it)` pobiera z niego kolejny element.",
        code = "it = iter([10, 20, 30])\nprint(next(it))\nprint(next(it))",
        output = "10\n20",
    ),
    explain(
        "Koniec: StopIteration",
        "Gdy elementów zabraknie, `next()` zgłasza wyjątek `StopIteration`. Iterator da się przejść tylko " +
            "raz – zużyte elementy nie wracają.",
        code = "it = iter([1, 2])\nprint(list(it))\nprint(list(it))",
        output = "[1, 2]\n[]",
    ),
    explain(
        "Funkcja z yield",
        "Funkcja z `yield` to generator. `yield` oddaje wartość i wstrzymuje funkcję – przy kolejnym " +
            "`next()` funkcja rusza dalej od tego miejsca.",
        code = "def kwadraty(n):\n    for i in range(n):\n        yield i * i\n\nprint(list(kwadraty(4)))",
        output = "[0, 1, 4, 9]",
    ),
    explain(
        "Wyrażenie generatorowe",
        "Zapis jak wyrażenie listowe, ale w nawiasach okrągłych, tworzy generator. Nie buduje całej " +
            "listy w pamięci – liczy wartości na żądanie. Można go podać prosto do `sum()` czy `max()`.",
        code = "print(sum(x * x for x in range(4)))",
        output = "14",
    ),
    explain(
        "Leniwe i nieskończone",
        "Generator liczy kolejną wartość dopiero, gdy o nią poprosisz. Dlatego może nie mieć końca " +
            "(`while True`) – wystarczy w porę przerwać pętlę przez `break`.",
        code = "def naturalne():\n    n = 1\n    while True:\n        yield n\n        n += 1\n\ng = naturalne()\nprint([next(g) for _ in range(3)])",
        output = "[1, 2, 3]",
    ),
    output(
        "def gen():\n    yield \"a\"\n    yield \"b\"\n\nfor x in gen():\n    print(x)",
        "a\nb",
        "Pętla for pobiera kolejne wartości z yield.",
    ),
    choice(
        "Które słowo kluczowe zamienia funkcję w generator?",
        listOf("yield", "return", "lambda", "next"),
        0,
        "Funkcja z yield po wywołaniu zwraca generator.",
    ),
    fill(
        "Uzupełnij, aby pobrać pierwszy element generatora.",
        "g = (x * 10 for x in range(3))\nprint(____(g))",
        listOf("next", "iter", "len"),
        "next",
        "next() zwraca kolejny element – tu 0.",
    ),
)
