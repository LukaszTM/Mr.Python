package com.mrpython.app.data.course

internal val module19Intro = lesson(
    "u19l0", "Wprowadzenie: losowość",
    explain(
        "Moduł random",
        "Gry, quizy i symulacje potrzebują losowości. Daje ją moduł `random`. " +
            "Za każdym uruchomieniem wynik może być inny – dlatego w przykładach sprawdzamy, czy mieści się w zakresie.",
        code = "import random\nx = random.randint(1, 6)\nprint(1 <= x <= 6)",
        output = "True",
    ),
    explain(
        "randint i random",
        "`random.randint(a, b)` losuje liczbę całkowitą od `a` do `b` – obie granice włącznie, jak rzut kostką. " +
            "`random.random()` daje liczbę float od 0 (włącznie) do 1 (bez 1).",
        code = "import random\nx = random.random()\nprint(0 <= x < 1)",
        output = "True",
    ),
    explain(
        "choice – wybierz jeden",
        "`random.choice(lista)` losuje jeden element listy lub napisu. Z pustej listy nie da się nic " +
            "wylosować – wtedy pojawia się błąd.",
        code = "import random\nkolory = [\"red\", \"blue\"]\nk = random.choice(kolory)\nprint(k in kolory)",
        output = "True",
    ),
    explain(
        "shuffle i sample",
        "`random.shuffle(lista)` miesza listę w miejscu i zwraca `None`. `random.sample(lista, k)` " +
            "zwraca nową listę `k` różnych elementów – bez powtórzeń.",
        code = "import random\nkarty = [1, 2, 3, 4]\nrandom.shuffle(karty)\nprint(sorted(karty))\nprint(len(random.sample(karty, 2)))",
        output = "[1, 2, 3, 4]\n2",
    ),
    explain(
        "Ziarno: seed",
        "`random.seed(42)` ustawia ziarno losowania. Po tym samym ziarnie wylosowane liczby są " +
            "zawsze takie same – to przydaje się przy testowaniu programów.",
        code = "import random\nrandom.seed(42)\na = random.randint(1, 100)\nrandom.seed(42)\nb = random.randint(1, 100)\nprint(a == b)",
        output = "True",
    ),
    choice(
        "Co zwraca random.randint(1, 6)?",
        listOf("Liczbę całkowitą od 1 do 6 (włącznie)", "Liczbę całkowitą od 1 do 5", "Liczbę float od 1 do 6", "Zawsze 6"),
        0,
        "randint obejmuje obie granice przedziału.",
    ),
    output(
        "import random\nlista = [1, 2]\nprint(random.shuffle(lista))",
        "None",
        "shuffle miesza listę w miejscu i zwraca None.",
    ),
    fill(
        "Uzupełnij, aby wylosować jedno imię z listy.",
        "import random\nimiona = [\"Ala\", \"Ola\"]\nprint(random.____(imiona))",
        listOf("choice", "shuffle", "randint"),
        "choice",
        "choice zwraca jeden losowy element listy.",
    ),
)
