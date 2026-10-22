package com.mrpython.app.data.course

internal val module51Cards = listOf(
    cards(
        "u51l1",
        explain(
            "Wycinek nie zgłasza błędu",
            "Indeks poza zakresem w wycinku nie daje błędu – Python po prostu przycina go do długości. " +
                "Wycinki można też łączyć: `x[:-1][::-1]` najpierw odcina ostatni element, potem odwraca resztę.",
            code = "print(\"abc\"[5:0:-1])\nx = [0, 1, 2, 3]\nprint(x[:-1][::-1])",
            output = "cb\n[2, 1, 0]",
        ),
    ),
    cards(
        "u51l2",
        explain(
            "Wycinek z krokiem",
            "Wycinek z krokiem, np. `x[::2]`, można podmienić tylko listą tej samej długości – inaczej " +
                "dostaniesz `ValueError`. `del x[::2]` usuwa co drugi element.",
            code = "x = [1, 2, 3, 4]\nx[::2] = [0, 0]\nprint(x)\ndel x[::2]\nprint(x)",
            output = "[0, 2, 0, 4]\n[2, 4]",
        ),
        explain(
            "slice z jednym argumentem",
            "`slice(3)` to samo `stop`, czyli `[:3]`. Pominięte części podajemy jako `None`: " +
                "`slice(None, None, -1)` działa jak `[::-1]`.",
            code = "print([5, 6, 7, 8][slice(2)])\nprint(\"abc\"[slice(None, None, -1)])",
            output = "[5, 6]\ncba",
        ),
    ),
    cards(
        "u51l3",
        explain(
            "Ten sam czy równy?",
            "`==` sprawdza, czy wartości są równe, a `is` – czy to dokładnie ten sam obiekt. " +
                "Dwie osobne listy `[1]` są równe, ale nie są tym samym obiektem.",
            code = "a = [1]\nb = [1]\nc = a\nprint(a == b, a is b, a is c)",
            output = "True False True",
        ),
        explain(
            "+= czy a = a + ...?",
            "`a += [2]` zmienia listę w miejscu, więc zmianę widzą wszystkie jej nazwy. `a = a + [2]` " +
                "tworzy nową listę i przypina do niej tylko nazwę `a`.",
            code = "a = [1]\nb = a\na += [2]\nprint(b)\na = a + [3]\nprint(b)",
            output = "[1, 2]\n[1, 2]",
        ),
        explain(
            "copy.copy i mnożenie list",
            "`copy.copy(a)` to płytka kopia, jak `a[:]`. Uwaga: `[[0] * 2] * 2` nie tworzy dwóch list, " +
                "tylko dwa odnośniki do jednej – zmiana w jednym wierszu widać w obu.",
            code = "m = [[0] * 2] * 2\nm[0][0] = 1\nprint(m)",
            output = "[[1, 0], [1, 0]]",
        ),
    ),
)
