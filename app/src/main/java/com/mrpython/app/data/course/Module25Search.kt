package com.mrpython.app.data.course

import com.mrpython.app.domain.CourseUnit

internal val module25 = CourseUnit(
    id = "u25",
    title = "Wyszukiwanie",
    description = "Szukanie po kolei, minimum, maksimum i wyszukiwanie binarne",
    lessons = listOf(
        lesson(
            "u25l1", "Przeszukiwanie po kolei",
            output(
                "liczby = [4, 8, 15, 16]\nznaleziono = False\nfor x in liczby:\n    if x == 15:\n        znaleziono = True\nprint(znaleziono)",
                "True",
                "Pętla sprawdza elementy po kolei i trafia na 15.",
            ),
            output(
                "imiona = [\"Ola\", \"Jan\", \"Ewa\"]\nfor i in range(len(imiona)):\n    if imiona[i] == \"Ewa\":\n        print(i)",
                "2",
                "Ewa stoi pod indeksem 2.",
            ),
            output(
                "oceny = [5, 3, 5, 4, 5]\nile = 0\nfor o in oceny:\n    if o == 5:\n        ile += 1\nprint(ile)",
                "3",
                "Licznik rośnie przy każdym trafieniu – piątki są trzy.",
            ),
            choice(
                "Lista ma 10 elementów, a szukanej wartości na niej nie ma. Ile porównań wykona przeszukiwanie po kolei?",
                listOf("10", "1", "5", "0"),
                0,
                "Żeby stwierdzić brak elementu, trzeba sprawdzić wszystkie elementy.",
            ),
            fill(
                "Uzupełnij, aby policzyć wszystkie wystąpienia słowa „kot”.",
                "slowa = [\"kot\", \"pies\", \"kot\"]\nile = 0\nfor s in slowa:\n    if s == \"kot\":\n        ile ____ 1\nprint(ile)",
                listOf("+=", "=", "-="),
                "+=",
                "ile += 1 zwiększa licznik przy każdym trafieniu.",
            ),
            output(
                "temp = [12, -3, 5, -1, 0]\nujemne = 0\nfor t in temp:\n    if t < 0:\n        ujemne += 1\nprint(ujemne)",
                "2",
                "Ujemne są tylko -3 i -1, bo 0 nie jest mniejsze od 0.",
            ),
            tiles(
                "Napisz warunek: x jest równe szukanej wartości cel",
                listOf("if", "x == cel", ":"),
                listOf("x = cel", "else"),
                "Porównanie to ==, a pojedyncze = to przypisanie.",
            ),
            output(
                "litery = [\"a\", \"b\", \"a\", \"c\"]\npoz = -1\nfor i in range(len(litery)):\n    if litery[i] == \"a\":\n        poz = i\nprint(poz)",
                "2",
                "Pętla nie przerywa się, więc zapamiętuje ostatnie wystąpienie.",
            ),
        ),
        lesson(
            "u25l2", "Wczesny return",
            output(
                "def szukaj(lista, cel):\n    for i in range(len(lista)):\n        if lista[i] == cel:\n            return i\n    return -1\n\nprint(szukaj([3, 7, 7], 7))",
                "1",
                "return kończy funkcję przy pierwszym trafieniu.",
            ),
            output(
                "def szukaj(lista, cel):\n    for i in range(len(lista)):\n        if lista[i] == cel:\n            return i\n    return -1\n\nprint(szukaj([3, 7], 5))",
                "-1",
                "Pętla nic nie znalazła, więc wykonuje się return -1.",
            ),
            choice(
                "Co jest nie tak z tą funkcją?",
                listOf("Sprawdza tylko pierwszy element", "Nigdy nie zwraca True", "Zawsze zgłasza błąd", "Działa poprawnie"),
                0,
                "return False w else kończy funkcję już przy pierwszym elemencie.",
                code = "def jest(lista, cel):\n    for x in lista:\n        if x == cel:\n            return True\n        else:\n            return False",
            ),
            output(
                "liczby = [2, 9, 4, 9]\nkroki = 0\nfor x in liczby:\n    kroki += 1\n    if x == 9:\n        break\nprint(kroki)",
                "2",
                "break przerywa pętlę po drugim elemencie.",
            ),
            fill(
                "Uzupełnij, aby funkcja zakończyła się od razu po znalezieniu.",
                "def jest(lista, cel):\n    for x in lista:\n        if x == cel:\n            ____ True\n    return False\nprint(jest([1, 2], 2))",
                listOf("return", "print", "break"),
                "return",
                "return od razu oddaje wynik i kończy funkcję.",
            ),
            output(
                "def pierwsza_ujemna(liczby):\n    for x in liczby:\n        if x < 0:\n            return x\n    return None\n\nprint(pierwsza_ujemna([3, -2, -8]))",
                "-2",
                "Funkcja zwraca pierwszą znalezioną liczbę ujemną.",
            ),
            output(
                "lista = [1, 7, 3]\nprint(7 in lista)\nprint(lista.index(7))",
                "True\n1",
                "in i index() też przeszukują listę po kolei.",
            ),
            tiles(
                "Gdy lista[i] jest równe cel, zapisz indeks i w zmiennej poz",
                listOf("if", "lista[i] == cel", ":", "poz = i"),
                listOf("lista[i] = cel", "poz = cel"),
                "Zapamiętujemy indeks i, a nie samą wartość.",
            ),
        ),
        lesson(
            "u25l3", "Minimum, maksimum i pozycja",
            output(
                "liczby = [3, 9, 2, 7]\nnaj = liczby[0]\nfor x in liczby:\n    if x > naj:\n        naj = x\nprint(naj)",
                "9",
                "naj podmieniamy za każdym razem, gdy trafimy na większą liczbę.",
            ),
            output(
                "liczby = [5, 1, 8, 1]\npoz = 0\nfor i in range(len(liczby)):\n    if liczby[i] < liczby[poz]:\n        poz = i\nprint(poz)",
                "1",
                "Przy ostrym < zostaje pierwsze wystąpienie minimum.",
            ),
            choice(
                "Dlaczego maksimum zaczynamy od liczby[0], a nie od 0?",
                listOf(
                    "Dla samych liczb ujemnych 0 byłoby błędnym wynikiem",
                    "Bo 0 nie jest liczbą",
                    "Bo tak jest szybciej",
                    "Bo lista nie może zawierać zera",
                ),
                0,
                "Dla [-5, -2] maksimum to -2, a start od 0 dałby 0.",
            ),
            output(
                "liczby = [5, 1, 8, 1]\npoz = 0\nfor i in range(len(liczby)):\n    if liczby[i] <= liczby[poz]:\n        poz = i\nprint(poz)",
                "3",
                "Przy <= każde kolejne równe minimum nadpisuje pozycję – zostaje ostatnie.",
            ),
            fill(
                "Uzupełnij, aby znaleźć najmniejszą liczbę.",
                "liczby = [4, 2, 6]\nmn = liczby[0]\nfor x in liczby:\n    if x ____ mn:\n        mn = x\nprint(mn)",
                listOf("<", ">", "=="),
                "<",
                "Podmieniamy mn, gdy x jest mniejsze.",
            ),
            output(
                "slowa = [\"kot\", \"żyrafa\", \"pies\"]\nnaj = slowa[0]\nfor s in slowa:\n    if len(s) > len(naj):\n        naj = s\nprint(naj)",
                "żyrafa",
                "Porównujemy długości słów – najdłuższe jest „żyrafa”.",
            ),
            output(
                "liczby = [3, 9, 2, 9]\nprint(max(liczby), liczby.index(max(liczby)))",
                "9 1",
                "index() zwraca pozycję pierwszego wystąpienia.",
            ),
            tiles(
                "Zaktualizuj maksimum naj, gdy x jest większe",
                listOf("if", "x > naj", ":", "naj = x"),
                listOf("x < naj", "x = naj"),
                "Gdy x jest większe, zapamiętujemy je jako nowe maksimum.",
            ),
        ),
        lesson(
            "u25l4", "Wyszukiwanie binarne",
            choice(
                "Na jakiej liście można użyć wyszukiwania binarnego?",
                listOf("Na posortowanej", "Na dowolnej", "Tylko na liście napisów", "Tylko na liście o parzystej długości"),
                0,
                "Wyszukiwanie binarne odrzuca połowę listy, co działa tylko przy uporządkowanych danych.",
            ),
            output(
                "lista = [1, 3, 5, 7, 9, 11, 13]\nlewo, prawo = 0, len(lista) - 1\nsrodek = (lewo + prawo) // 2\nprint(srodek, lista[srodek])",
                "3 7",
                "(0 + 6) // 2 = 3, a pod indeksem 3 jest 7.",
            ),
            choice(
                "Szukamy 11 w [1, 3, 5, 7, 9, 11, 13]. Środkowy element to 7. Co dalej?",
                listOf("Szukamy w prawej połowie", "Szukamy w lewej połowie", "Kończymy – brak elementu", "Zaczynamy od początku listy"),
                0,
                "11 > 7, więc szukana liczba może być tylko na prawo od środka.",
            ),
            output(
                "def szukaj(lista, cel):\n    lewo, prawo = 0, len(lista) - 1\n    while lewo <= prawo:\n        s = (lewo + prawo) // 2\n        if lista[s] == cel:\n            return s\n        elif lista[s] < cel:\n            lewo = s + 1\n        else:\n            prawo = s - 1\n    return -1\nprint(szukaj([2, 4, 6, 8, 10], 8))",
                "3",
                "Środek to 6 (za mało), potem zakres [8, 10] i środek 8 pod indeksem 3.",
            ),
            output(
                "n = 16\nkroki = 0\nwhile n > 1:\n    n = n // 2\n    kroki += 1\nprint(kroki)",
                "4",
                "Każdy krok połowi zakres: 16, 8, 4, 2, 1.",
            ),
            fill(
                "Uzupełnij, aby środek był liczbą całkowitą (indeksem).",
                "lewo, prawo = 0, 8\nsrodek = (lewo + prawo) ____ 2\nprint(srodek)",
                listOf("//", "/", "%"),
                "//",
                "// dzieli całkowicie, więc wynik nadaje się na indeks.",
            ),
            fill(
                "Środkowy element jest za mały. Uzupełnij, jak przesunąć lewą granicę.",
                "lista = [1, 3, 5, 7, 9]\nlewo, prawo = 0, 4\ns = (lewo + prawo) // 2\nif lista[s] < 9:\n    lewo = ____\nprint(lewo)",
                listOf("s + 1", "s - 1", "0"),
                "s + 1",
                "Środek już sprawdziliśmy, więc szukamy od następnego indeksu.",
            ),
            tiles(
                "Napisz nagłówek pętli wyszukiwania binarnego",
                listOf("while", "lewo <= prawo", ":"),
                listOf("for", "lewo > prawo"),
                "Szukamy, dopóki zakres między lewo i prawo nie jest pusty.",
            ),
        ),
        lesson(
            "u25l5", "Powtórka: wyszukiwanie",
            output(
                "tekst = \"abrakadabra\"\nile = 0\nfor z in tekst:\n    if z == \"a\":\n        ile += 1\nprint(ile)",
                "5",
                "Litera a występuje w „abrakadabra” pięć razy.",
            ),
            output(
                "liczby = [3, 8, 1, 9]\nprint(sum(1 for x in liczby if x > 2))",
                "3",
                "Każde trafienie dodaje 1 – większe od 2 są 3, 8 i 9.",
            ),
            choice(
                "Ile najwyżej kroków potrzebuje wyszukiwanie binarne dla 1000 posortowanych elementów?",
                listOf("Około 10", "Około 500", "1000", "Około 100"),
                0,
                "1000 można połowić około 10 razy, bo 2 do potęgi 10 to 1024.",
            ),
            output(
                "def pierwszy_parzysty(liczby):\n    for i, x in enumerate(liczby):\n        if x % 2 == 0:\n            return i\n    return -1\n\nprint(pierwszy_parzysty([5, 7, 4, 6]))",
                "2",
                "Pierwsza parzysta liczba to 4 pod indeksem 2.",
            ),
            fill(
                "Uzupełnij, aby wypisać indeks najmniejszego elementu.",
                "liczby = [7, 9, 3]\nprint(liczby.____(min(liczby)))",
                listOf("index", "count", "find"),
                "index",
                "index() zwraca pozycję podanej wartości.",
            ),
            output(
                "lista = [1, 3, 5, 7, 9, 11, 13]\nlewo, prawo = 0, 6\nwhile lewo <= prawo:\n    s = (lewo + prawo) // 2\n    print(lista[s])\n    if lista[s] == 3:\n        break\n    elif lista[s] < 3:\n        lewo = s + 1\n    else:\n        prawo = s - 1",
                "7\n3",
                "Najpierw środek 7, potem lewa połowa [1, 3, 5] i jej środek 3.",
            ),
            choice(
                "Które wyszukiwanie jest szybsze dla dużej posortowanej listy?",
                listOf("Binarne", "Liniowe", "Oba tak samo", "Liniowe od końca"),
                0,
                "Binarne za każdym razem odrzuca połowę elementów.",
            ),
            tiles(
                "Zwiększ licznik ile o 1",
                listOf("ile", "+=", "1"),
                listOf("==", "-="),
                "+= dodaje wartość do zmiennej.",
            ),
        ),
    ),
)
