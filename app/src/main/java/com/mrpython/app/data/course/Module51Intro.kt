package com.mrpython.app.data.course

internal val module51Intro = lesson(
    "u51l0", "Wprowadzenie: wycinki i kopiowanie",
    explain(
        "Wycinki z krokiem",
        "Wycinek `x[start:stop:krok]` pobiera fragment listy lub napisu. Ujemny krok idzie od końca: " +
            "`x[::-1]` odwraca listę, a `x[-3:]` daje trzy ostatnie elementy.",
        code = "x = [0, 1, 2, 3, 4, 5]\nprint(x[::-2])\nprint(x[-3:])",
        output = "[5, 3, 1]\n[3, 4, 5]",
    ),
    explain(
        "Start i koniec wstecz",
        "Przy ujemnym kroku start musi być większy od końca, a koniec nadal nie wchodzi do wyniku. " +
            "Jeśli jest odwrotnie, wycinek jest pusty.",
        code = "x = [0, 1, 2, 3, 4, 5]\nprint(x[4:1:-1])\nprint(x[1:4:-1])",
        output = "[4, 3, 2]\n[]",
    ),
    explain(
        "Przypisanie do wycinka",
        "Wycinek listy można podmienić inną listą – nawet innej długości. Pusty wycinek, np. `x[1:1]`, " +
            "wstawia elementy, a `del x[a:b]` je usuwa.",
        code = "x = [1, 2, 3, 4]\nx[1:3] = [9]\nprint(x)\ndel x[:1]\nprint(x)",
        output = "[1, 9, 4]\n[9, 4]",
    ),
    explain(
        "Obiekt slice",
        "`slice(start, stop, krok)` to wycinek zapisany w zmiennej – można go użyć wiele razy. " +
            "`None` oznacza „do końca”.",
        code = "s = slice(1, None)\nprint([10, 20, 30][s])",
        output = "[20, 30]",
    ),
    explain(
        "Alias czy kopia?",
        "`b = a` nie kopiuje listy – to druga nazwa tego samego obiektu. Kopię dają `a[:]`, `list(a)` " +
            "i `a.copy()`, ale są płytkie: listy wewnętrzne zostają wspólne. Pełną kopię robi " +
            "`copy.deepcopy()`.",
        code = "a = [1, 2]\nb = a\nc = a[:]\nb.append(3)\nprint(a, c)",
        output = "[1, 2, 3] [1, 2]",
    ),
    output(
        "print(\"abcde\"[::-1])",
        "edcba",
        "Krok -1 przechodzi napis od końca.",
    ),
    choice(
        "Która instrukcja tworzy kopię listy a?",
        listOf("b = a[:]", "b = a", "b = a[0]"),
        0,
        "a[:] to nowa lista; b = a to tylko druga nazwa tej samej listy.",
    ),
    tiles(
        "Zapisz w zmiennej y odwróconą listę x.",
        listOf("y", "=", "x[::-1]"),
        listOf("x[::1]", "=="),
        "Wycinek z krokiem -1 odwraca kolejność.",
    ),
)
