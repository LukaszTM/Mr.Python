package com.mrpython.app.data.course

import com.mrpython.app.domain.CourseUnit

internal val module26 = CourseUnit(
    id = "u26",
    title = "Sortowanie",
    description = "Algorytmy sortowania, klucze i sortowanie słowników",
    lessons = listOf(
        lesson(
            "u26l1", "Sortowanie bąbelkowe",
            output(
                "a = [3, 1]\nif a[0] > a[1]:\n    a[0], a[1] = a[1], a[0]\nprint(a)",
                "[1, 3]",
                "Elementy były w złej kolejności, więc zamieniły się miejscami.",
            ),
            output(
                "a = [4, 3, 1, 2]\nfor i in range(len(a) - 1):\n    if a[i] > a[i + 1]:\n        a[i], a[i + 1] = a[i + 1], a[i]\nprint(a)",
                "[3, 1, 2, 4]",
                "Jedno przejście przepycha 4 na sam koniec listy.",
            ),
            choice(
                "Co na pewno jest prawdą po jednym przejściu sortowania bąbelkowego (rosnąco)?",
                listOf("Największy element jest na końcu", "Najmniejszy element jest na początku", "Cała lista jest posortowana", "Lista jest odwrócona"),
                0,
                "Największy element „wypływa” jak bąbelek na koniec listy.",
            ),
            output(
                "a = [5, 2, 4, 1]\nn = len(a)\nfor k in range(n - 1):\n    for i in range(n - 1 - k):\n        if a[i] > a[i + 1]:\n            a[i], a[i + 1] = a[i + 1], a[i]\nprint(a)",
                "[1, 2, 4, 5]",
                "Po n - 1 przejściach lista jest posortowana.",
            ),
            fill(
                "Uzupełnij, aby zamienić miejscami a[i] i a[i + 1].",
                "a = [2, 1]\ni = 0\na[i], a[i + 1] = ____\nprint(a)",
                listOf("a[i + 1], a[i]", "a[i], a[i + 1]", "a[i + 1]"),
                "a[i + 1], a[i]",
                "Po prawej stronie podajemy wartości w odwrotnej kolejności.",
            ),
            output(
                "a = [3, 2, 1]\nzamiany = 0\nfor k in range(2):\n    for i in range(2):\n        if a[i] > a[i + 1]:\n            a[i], a[i + 1] = a[i + 1], a[i]\n            zamiany += 1\nprint(zamiany)",
                "3",
                "Odwrócona lista 3 elementów wymaga trzech zamian sąsiadów.",
            ),
            fill(
                "Uzupełnij, aby sortować malejąco.",
                "a = [1, 3, 2]\nfor k in range(2):\n    for i in range(2):\n        if a[i] ____ a[i + 1]:\n            a[i], a[i + 1] = a[i + 1], a[i]\nprint(a)",
                listOf("<", ">", "=="),
                "<",
                "Zamieniamy, gdy lewy element jest mniejszy – większe idą na początek.",
            ),
            tiles(
                "Napisz warunek zamiany w sortowaniu bąbelkowym (rosnąco)",
                listOf("if", "a[i] > a[i + 1]", ":"),
                listOf("a[i] < a[i + 1]", "for"),
                "Zamieniamy sąsiadów, gdy lewy jest większy od prawego.",
            ),
        ),
        lesson(
            "u26l2", "Sortowanie przez wybieranie",
            choice(
                "Na czym polega sortowanie przez wybieranie?",
                listOf(
                    "Wybieramy najmniejszy element i stawiamy go na kolejne miejsce",
                    "Zamieniamy sąsiadów, aż lista będzie posortowana",
                    "Dzielimy listę na pół i szukamy środka",
                    "Losujemy kolejność, aż wyjdzie dobra",
                ),
                0,
                "W każdym przejściu wybieramy minimum z nieposortowanej części.",
            ),
            output(
                "a = [4, 2, 7, 1]\nm = a.index(min(a))\na[0], a[m] = a[m], a[0]\nprint(a)",
                "[1, 2, 7, 4]",
                "Minimum 1 zamienia się miejscami z pierwszym elementem.",
            ),
            output(
                "a = [3, 1, 2]\nfor i in range(len(a)):\n    m = i\n    for j in range(i + 1, len(a)):\n        if a[j] < a[m]:\n            m = j\n    a[i], a[m] = a[m], a[i]\nprint(a)",
                "[1, 2, 3]",
                "Każde przejście stawia kolejne minimum na pozycji i.",
            ),
            output(
                "a = [2, 5, 1, 3]\nfor i in range(2):\n    m = i\n    for j in range(i + 1, len(a)):\n        if a[j] < a[m]:\n            m = j\n    a[i], a[m] = a[m], a[i]\n    print(a)",
                "[1, 5, 2, 3]\n[1, 2, 5, 3]",
                "Najpierw 1 trafia na początek, potem 2 na drugie miejsce.",
            ),
            fill(
                "Uzupełnij, aby m wskazywał najmniejszy element.",
                "a = [6, 2, 9]\nm = 0\nfor j in range(1, len(a)):\n    if a[j] ____ a[m]:\n        m = j\nprint(m)",
                listOf("<", ">", "!="),
                "<",
                "Zmieniamy m, gdy znajdziemy mniejszy element.",
            ),
            choice(
                "Która część listy jest już posortowana po i przejściach sortowania przez wybieranie?",
                listOf("Pierwsze i elementów", "Ostatnie i elementów", "Żadna", "Cała lista"),
                0,
                "Minima trafiają kolejno na początek listy.",
            ),
            output(
                "a = [2, 9, 4]\nwynik = []\nwhile a:\n    m = max(a)\n    wynik.append(m)\n    a.remove(m)\nprint(wynik)",
                "[9, 4, 2]",
                "Wybieranie największego elementu daje kolejność malejącą.",
            ),
            tiles(
                "Zapamiętaj j jako indeks nowego minimum, gdy a[j] jest mniejsze od a[m]",
                listOf("if", "a[j] < a[m]", ":", "m = j"),
                listOf("j = m", "a[j] > a[m]"),
                "m ma wskazywać najmniejszy dotąd element.",
            ),
        ),
        lesson(
            "u26l3", "Sortowanie przez wstawianie",
            choice(
                "Jak działa sortowanie przez wstawianie?",
                listOf(
                    "Bierze kolejny element i wstawia go we właściwe miejsce posortowanej części",
                    "Wybiera największy element i przenosi go na koniec",
                    "Zamienia losowe pary elementów",
                    "Sortuje osobno obie połowy listy",
                ),
                0,
                "Tak jak układamy karty w ręce – każdą nową wsuwamy na swoje miejsce.",
            ),
            output(
                "posortowane = [2, 5, 8]\nx = 6\ni = 0\nwhile i < len(posortowane) and posortowane[i] < x:\n    i += 1\nposortowane.insert(i, x)\nprint(posortowane)",
                "[2, 5, 6, 8]",
                "6 trafia przed pierwszy większy element, czyli przed 8.",
            ),
            output(
                "a = [4, 2, 3, 1]\nfor i in range(1, len(a)):\n    x = a[i]\n    j = i - 1\n    while j >= 0 and a[j] > x:\n        a[j + 1] = a[j]\n        j -= 1\n    a[j + 1] = x\nprint(a)",
                "[1, 2, 3, 4]",
                "Większe elementy przesuwają się w prawo, a x wskakuje w lukę.",
            ),
            output(
                "a = [3, 1, 2]\nfor i in range(1, len(a)):\n    x = a[i]\n    j = i - 1\n    while j >= 0 and a[j] > x:\n        a[j + 1] = a[j]\n        j -= 1\n    a[j + 1] = x\n    print(a)",
                "[1, 3, 2]\n[1, 2, 3]",
                "Najpierw wstawiamy 1 przed 3, potem 2 między 1 a 3.",
            ),
            fill(
                "Uzupełnij warunek, aby przesuwać większe elementy w prawo.",
                "a = [1, 4, 2]\nx = a[2]\nj = 1\nwhile j >= 0 and a[j] ____ x:\n    a[j + 1] = a[j]\n    j -= 1\na[j + 1] = x\nprint(a)",
                listOf(">", "<", "=="),
                ">",
                "Przesuwamy elementy większe od wstawianego x.",
            ),
            choice(
                "Dla jakiej listy sortowanie przez wstawianie działa najszybciej?",
                listOf("Już posortowanej", "Posortowanej malejąco", "Losowej", "Zawsze działa tak samo"),
                0,
                "Gdy lista jest posortowana, nic nie trzeba przesuwać.",
            ),
            output(
                "a = [3, 2, 1]\nruchy = 0\nfor i in range(1, len(a)):\n    x = a[i]\n    j = i - 1\n    while j >= 0 and a[j] > x:\n        a[j + 1] = a[j]\n        j -= 1\n        ruchy += 1\n    a[j + 1] = x\nprint(ruchy)",
                "3",
                "Wstawienie 2 wymaga 1 przesunięcia, a wstawienie 1 – dwóch.",
            ),
            tiles(
                "Przesuń element a[j] o jedno miejsce w prawo",
                listOf("a[j + 1]", "=", "a[j]"),
                listOf("a[j - 1]", "=="),
                "Kopiujemy a[j] na pozycję j + 1.",
            ),
        ),
        lesson(
            "u26l4", "sorted() z key i reverse",
            output("print(sorted([3, 1, 2], reverse=True))", "[3, 2, 1]", "reverse=True sortuje malejąco."),
            output(
                "a = [3, 1, 2]\nb = sorted(a)\nprint(a)\nprint(b)",
                "[3, 1, 2]\n[1, 2, 3]",
                "sorted() tworzy nową listę, a oryginał zostaje bez zmian.",
            ),
            output(
                "slowa = [\"banan\", \"kiwi\", \"jabłko\"]\nprint(sorted(slowa, key=len))",
                "['kiwi', 'banan', 'jabłko']",
                "key=len porządkuje słowa według długości.",
            ),
            output("print(sorted([-3, 2, -1], key=abs))", "[-1, 2, -3]", "Sortujemy według wartości bezwzględnych: 1, 2, 3."),
            fill(
                "Uzupełnij, aby posortować listę malejąco.",
                "a = [2, 5, 1]\na.sort(____=True)\nprint(a)",
                listOf("reverse", "key", "desc"),
                "reverse",
                "Parametr reverse=True odwraca kolejność sortowania.",
            ),
            choice(
                "Co zwraca a.sort()?",
                listOf("None – sortuje listę w miejscu", "Nową posortowaną listę", "Posortowaną krotkę", "Liczbę elementów"),
                0,
                "sort() zmienia listę a i nic nie zwraca.",
            ),
            output(
                "imiona = [\"ola\", \"Ewa\", \"adam\"]\nprint(sorted(imiona))\nprint(sorted(imiona, key=str.lower))",
                "['Ewa', 'adam', 'ola']\n['adam', 'Ewa', 'ola']",
                "Wielkie litery są przed małymi, chyba że porównujemy wersje lower().",
            ),
            tiles(
                "Posortuj słowa malejąco według długości",
                listOf("wynik", "=", "sorted(slowa,", "key=len,", "reverse=True)"),
                listOf("key=len(),", "reverse=False)"),
                "key=len wybiera długość, a reverse=True odwraca kolejność.",
            ),
        ),
        lesson(
            "u26l5", "Kilka kluczy i słowniki",
            choice(
                "Co znaczy, że sortowanie w Pythonie jest stabilne?",
                listOf(
                    "Elementy o równych kluczach zachowują swoją kolejność",
                    "Sortowanie nigdy nie zgłasza błędu",
                    "Lista po sortowaniu się nie zmienia",
                    "Sortowanie zawsze trwa tyle samo",
                ),
                0,
                "Remisy zostają w kolejności, w jakiej były na wejściu.",
            ),
            output(
                "osoby = [(\"Ola\", 20), (\"Jan\", 18), (\"Ewa\", 20)]\nfor imie, wiek in sorted(osoby, key=lambda o: o[1]):\n    print(imie)",
                "Jan\nOla\nEwa",
                "Ola i Ewa mają po 20 lat, więc zostają w pierwotnej kolejności.",
            ),
            output(
                "print(sorted([(2, \"b\"), (1, \"z\"), (2, \"a\")]))",
                "[(1, 'z'), (2, 'a'), (2, 'b')]",
                "Krotki porównujemy po pierwszym elemencie, a przy remisie po drugim.",
            ),
            output(
                "osoby = [(\"Ola\", 20), (\"Jan\", 18), (\"Ewa\", 20)]\nwynik = sorted(osoby, key=lambda o: (-o[1], o[0]))\nprint([o[0] for o in wynik])",
                "['Ewa', 'Ola', 'Jan']",
                "Najpierw wiek malejąco (minus), a przy remisie imię alfabetycznie.",
            ),
            output(
                "punkty = {\"Ola\": 7, \"Jan\": 9, \"Ewa\": 5}\nfor imie, p in sorted(punkty.items(), key=lambda x: x[1]):\n    print(imie, p)",
                "Ewa 5\nOla 7\nJan 9",
                "items() daje pary, a x[1] to wartość – sortujemy po punktach.",
            ),
            fill(
                "Uzupełnij, aby posortować pary słownika według wartości.",
                "ceny = {\"chleb\": 4, \"mleko\": 3}\nprint(sorted(ceny.items(), key=lambda x: x[____]))",
                listOf("1", "0", "2"),
                "1",
                "W parze (klucz, wartość) wartość ma indeks 1.",
            ),
            output(
                "glosy = {\"A\": 3, \"B\": 8, \"C\": 5}\nranking = sorted(glosy, key=glosy.get, reverse=True)\nprint(ranking[0])",
                "B",
                "key=glosy.get sortuje klucze według ich wartości.",
            ),
            tiles(
                "Posortuj pary słownika d według wartości",
                listOf("sorted(d.items(),", "key=lambda x:", "x[1])"),
                listOf("x[0])", "d.values()"),
                "x[1] to wartość w parze (klucz, wartość).",
            ),
        ),
        lesson(
            "u26l6", "Powtórka: sortowanie",
            output("print(sorted(\"python\"))", "['h', 'n', 'o', 'p', 't', 'y']", "sorted() na napisie daje posortowaną listę liter."),
            output("print(\"\".join(sorted(\"lato\")))", "alot", "Litery po posortowaniu sklejamy z powrotem w napis."),
            choice(
                "Który algorytm w każdym przejściu zamienia sąsiednie elementy?",
                listOf("Sortowanie bąbelkowe", "Sortowanie przez wybieranie", "Sortowanie przez wstawianie", "Wyszukiwanie binarne"),
                0,
                "Bąbelkowe porównuje i zamienia pary sąsiadów.",
            ),
            output(
                "slowa = [\"pies\", \"kot\", \"mysz\", \"as\"]\nprint(sorted(slowa, key=lambda s: (len(s), s)))",
                "['as', 'kot', 'mysz', 'pies']",
                "Najpierw długość, a przy równej długości alfabet.",
            ),
            fill(
                "Uzupełnij, aby najlepszy wynik był pierwszy.",
                "wyniki = {\"Ola\": 80, \"Jan\": 95}\nr = sorted(wyniki.items(), key=lambda x: x[1], ____=True)\nprint(r[0][0])",
                listOf("reverse", "key", "desc"),
                "reverse",
                "reverse=True sortuje od największej wartości.",
            ),
            output(
                "a = [2, 1, 3, 0]\nfor i in range(len(a) - 1):\n    if a[i] > a[i + 1]:\n        a[i], a[i + 1] = a[i + 1], a[i]\nprint(a)",
                "[1, 2, 0, 3]",
                "Jedno przejście bąbelkowe: zamiana 2 z 1, potem 3 z 0.",
            ),
            choice(
                "Co wypisze ten kod?",
                listOf("None", "[1, 2, 3]", "[3, 1, 2]", "Błąd"),
                0,
                "sort() zwraca None, więc a = a.sort() gubi listę.",
                code = "a = [3, 1, 2]\na = a.sort()\nprint(a)",
            ),
            output(
                "gracze = [(\"Ala\", 3), (\"Bob\", 5), (\"Cyp\", 3)]\ngracze.sort(key=lambda g: g[1], reverse=True)\nprint(gracze[1][0], gracze[2][0])",
                "Ala Cyp",
                "Przy reverse=True równe elementy też zachowują kolejność.",
            ),
        ),
    ),
)
