package com.mrpython.app.data.course

internal val module25Intro = lesson(
    "u25l0", "Wprowadzenie: wyszukiwanie",
    explain(
        "Szukanie po kolei",
        "Najprostszy sposób szukania: sprawdzać elementy jeden po drugim. Działa na każdej liście, " +
            "ale gdy szukanej wartości nie ma, trzeba obejrzeć wszystkie elementy.",
        code = "oceny = [5, 3, 5, 4]\nile = 0\nfor o in oceny:\n    if o == 5:\n        ile += 1\nprint(ile)",
        output = "2",
    ),
    explain(
        "Wczesny return",
        "Gdy znajdziesz to, czego szukasz, możesz od razu przerwać: `return` w funkcji albo `break` w pętli. " +
            "`return -1` po pętli oznacza „nie znaleziono” – tylko po sprawdzeniu wszystkiego!",
        code = "def szukaj(lista, cel):\n    for i in range(len(lista)):\n        if lista[i] == cel:\n            return i\n    return -1\n\nprint(szukaj([3, 7], 7), szukaj([3, 7], 5))",
        output = "1 -1",
    ),
    explain(
        "Szukanie maksimum",
        "Żeby znaleźć największy element, pamiętamy dotychczasowego „mistrza” i podmieniamy go, gdy trafi " +
            "się większy. Zaczynamy od `liczby[0]`, a nie od 0 – lista może mieć same ujemne liczby.",
        code = "liczby = [-3, -9, -2]\nnaj = liczby[0]\nfor x in liczby:\n    if x > naj:\n        naj = x\nprint(naj)",
        output = "-2",
    ),
    explain(
        "Wyszukiwanie binarne",
        "Na posortowanej liście można szukać sprytniej: patrzymy na środek i odrzucamy połowę, " +
            "w której celu na pewno nie ma. Środek liczymy jako `(lewo + prawo) // 2`.",
        code = "lista = [1, 3, 5, 7, 9]\nlewo, prawo = 0, len(lista) - 1\nsrodek = (lewo + prawo) // 2\nprint(srodek, lista[srodek])",
        output = "2 5",
    ),
    explain(
        "Dlaczego to szybkie?",
        "Każdy krok dzieli liczbę kandydatów na pół. Dla 16 elementów wystarczą 4 podziały, " +
            "a dla 1000 – około 10. Szukanie po kolei mogłoby wymagać 1000 porównań.",
        code = "n = 16\nkroki = 0\nwhile n > 1:\n    n = n // 2\n    kroki += 1\nprint(kroki)",
        output = "4",
    ),
    output(
        "liczby = [4, 8, 15]\nprint(15 in liczby)\nprint(liczby.index(8))",
        "True\n1",
        "15 jest na liście, a 8 stoi pod indeksem 1.",
    ),
    choice(
        "Na jakiej liście można użyć wyszukiwania binarnego?",
        listOf("Tylko na posortowanej", "Na każdej", "Tylko na liście napisów", "Tylko na krótkiej"),
        0,
        "Odrzucanie połowy działa tylko, gdy elementy są uporządkowane.",
    ),
    fill(
        "Uzupełnij, aby znaleźć najmniejszą liczbę.",
        "liczby = [4, 2, 6]\nmn = liczby[0]\nfor x in liczby:\n    if x ____ mn:\n        mn = x\nprint(mn)",
        listOf("<", ">", "=="),
        "<",
        "Podmieniamy mn, gdy trafi się mniejsza liczba.",
    ),
)
