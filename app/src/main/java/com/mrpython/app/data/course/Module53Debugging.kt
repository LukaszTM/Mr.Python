package com.mrpython.app.data.course

import com.mrpython.app.domain.CourseUnit

internal val module53 = CourseUnit(
    id = "u53",
    title = "Debugowanie",
    description = "Znajdowanie i poprawianie typowych błędów",
    lessons = listOf(
        lesson(
            "u53l1", "Błąd o jeden",
            choice(
                "Program miał wypisać liczby od 1 do 5. Gdzie jest błąd?",
                listOf("range(1, 5) kończy się na 4", "print nie przyjmuje end", "Pętla powinna zaczynać się od 0", "Brakuje return"),
                0,
                "Koniec zakresu w range nie jest wliczany.",
                code = "for i in range(1, 5):\n    print(i, end=\" \")",
            ),
            output(
                "for i in range(1, 5):\n    print(i, end=\" \")",
                "1 2 3 4",
                "range(1, 5) kończy się przed 5 – to klasyczny błąd o jeden.",
            ),
            fill(
                "Popraw zakres, aby wypisać liczby od 1 do 5.",
                "for i in range(1, ____):\n    print(i, end=\" \")",
                listOf("6", "5", "4"),
                "6",
                "Aby objąć 5, koniec zakresu musi wynosić 6.",
            ),
            output(
                "lista = [10, 20, 30]\ntry:\n    print(lista[len(lista)])\nexcept IndexError:\n    print(\"IndexError\")",
                "IndexError",
                "Ostatni indeks to len(lista) - 1, czyli 2.",
            ),
            choice(
                "Które wyrażenie poprawnie zwraca ostatni element listy?",
                listOf("lista[len(lista) - 1]", "lista[len(lista)]", "lista[len(lista) + 1]", "lista[1:]"),
                0,
                "Indeksy liczymy od 0, więc ostatni to len(lista) - 1.",
            ),
            output(
                "i = 0\nlicznik = 0\nwhile i <= 3:\n    licznik += 1\n    i += 1\nprint(licznik)",
                "4",
                "Warunek <= 3 obejmuje wartości 0, 1, 2 i 3 – to cztery obroty.",
            ),
            choice(
                "Funkcja miała zwrócić 1 + 2 + 3 = 6. Gdzie jest błąd?",
                listOf("range(n) pomija n – potrzeba range(n + 1)", "total powinno startować od 1", "Brakuje print w pętli", "return jest źle wcięty"),
                0,
                "range(3) daje 0, 1, 2, więc suma wynosi tylko 3.",
                code = "def suma_do(n):\n    total = 0\n    for i in range(n):\n        total += i\n    return total\n\nprint(suma_do(3))",
            ),
            output(
                "def suma_do(n):\n    total = 0\n    for i in range(n):\n        total += i\n    return total\n\nprint(suma_do(3))",
                "3",
                "Sumowane są tylko 0, 1 i 2.",
            ),
        ),
        lesson(
            "u53l2", "= kontra == i wcięcia",
            choice(
                "Co jest nie tak z tym kodem?",
                listOf("= to przypisanie – w warunku potrzeba ==", "Brakuje nawiasów wokół warunku", "x musi być napisem", "Nic, kod jest poprawny"),
                0,
                "Użycie = w if to SyntaxError; porównanie zapisujemy jako ==.",
                code = "x = 5\nif x = 5:\n    print(\"pięć\")",
            ),
            output(
                "x = 3\nwynik = x == 5\nprint(wynik)",
                "False",
                "x == 5 to porównanie, a jego wynik zapisujemy w zmiennej.",
            ),
            fill(
                "Uzupełnij operator porównania.",
                "wiek = 18\nif wiek ____ 18:\n    print(\"dokładnie 18\")",
                listOf("==", "=", "=>"),
                "==",
                "Równość sprawdzamy operatorem ==.",
            ),
            output(
                "suma = 0\nfor x in [1, 2, 3]:\n    suma += x\n    print(suma)",
                "1\n3\n6",
                "print jest wcięty w pętli, więc wykonuje się przy każdym obrocie.",
                instruction = "Programista chciał wypisać tylko sumę końcową. Co wypisze ten program?",
            ),
            choice(
                "Jak naprawić kod z poprzedniego zadania, aby wypisał tylko 6?",
                listOf("Cofnąć wcięcie print, aby był poza pętlą", "Zmienić += na =", "Dodać return", "Zamienić listę na krotkę"),
                0,
                "Kod bez wcięcia wykona się raz, po zakończeniu pętli.",
            ),
            output(
                "def ma_parzysta(lista):\n    for x in lista:\n        if x % 2 == 0:\n            return True\n        return False\n\nprint(ma_parzysta([1, 2]))",
                "False",
                "return False jest wewnątrz pętli, więc funkcja kończy się już po pierwszym elemencie.",
            ),
            choice(
                "Gdzie powinno stać return False w funkcji ma_parzysta?",
                listOf("Po pętli, na poziomie for", "Wewnątrz if", "Przed pętlą", "Nigdzie – wystarczy return True"),
                0,
                "False zwracamy dopiero, gdy pętla sprawdzi wszystkie elementy.",
            ),
            tiles(
                "Napisz warunek: czy wynik jest równy 10.",
                listOf("if", "wynik", "==", "10:"),
                listOf("=", "=>"),
                "Porównanie w if wymaga ==.",
            ),
        ),
        lesson(
            "u53l3", "Pułapki z listami",
            output(
                "def dodaj(x, lista=[]):\n    lista.append(x)\n    return lista\n\nprint(dodaj(1))\nprint(dodaj(2))",
                "[1]\n[1, 2]",
                "Domyślna lista jest wspólna dla wszystkich wywołań.",
            ),
            choice(
                "Dlaczego drugie wywołanie dodaj pamięta poprzedni element?",
                listOf("Domyślna lista powstaje raz, przy definicji funkcji", "append kopiuje listę", "Python zapisuje wyniki funkcji", "Bo x jest globalny"),
                0,
                "Wartość domyślna jest tworzona tylko raz i potem współdzielona.",
            ),
            fill(
                "Popraw funkcję, aby każde wywołanie zaczynało od pustej listy.",
                "def dodaj(x, lista=____):\n    if lista is None:\n        lista = []\n    lista.append(x)\n    return lista\n\nprint(dodaj(1))\nprint(dodaj(2))",
                listOf("None", "{}", "0"),
                "None",
                "None jako wartość domyślna i nowa lista w środku funkcji to bezpieczny wzorzec.",
            ),
            output(
                "def dodaj(x, lista=None):\n    if lista is None:\n        lista = []\n    lista.append(x)\n    return lista\n\nprint(dodaj(1))\nprint(dodaj(2))",
                "[1]\n[2]",
                "Każde wywołanie tworzy teraz nową listę.",
            ),
            output(
                "liczby = [2, 4, 5, 6]\nfor x in liczby:\n    if x % 2 == 0:\n        liczby.remove(x)\nprint(liczby)",
                "[4, 5]",
                "Usunięcie elementu przesuwa resztę, więc pętla pomija liczbę 4.",
            ),
            choice(
                "Dlaczego w poprzednim zadaniu liczba 4 została na liście?",
                listOf("Usuwanie w trakcie pętli przesuwa elementy i pętla pomija następny", "remove usuwa tylko liczby nieparzyste", "4 % 2 nie jest równe 0", "Pętla for nie widzi zmian"),
                0,
                "Nie zmieniaj listy, po której właśnie iterujesz.",
            ),
            fill(
                "Uzupełnij, aby pętla szła po kopii listy i usunęła wszystkie parzyste.",
                "liczby = [2, 4, 5, 6]\nfor x in liczby____:\n    if x % 2 == 0:\n        liczby.remove(x)\nprint(liczby)",
                listOf("[:]", "[0]", "[-1]"),
                "[:]",
                "liczby[:] to kopia, więc usuwanie z oryginału nie psuje pętli.",
            ),
            output(
                "def licz(slowo, wynik={}):\n    wynik[slowo] = wynik.get(slowo, 0) + 1\n    return wynik\n\nlicz(\"a\")\nprint(licz(\"b\"))",
                "{'a': 1, 'b': 1}",
                "Domyślny słownik też jest współdzielony między wywołaniami.",
            ),
        ),
        lesson(
            "u53l4", "Przesłanianie nazw wbudowanych",
            output(
                "list = [3, 1, 2]\ntry:\n    print(list(\"abc\"))\nexcept TypeError:\n    print(\"TypeError\")",
                "TypeError",
                "Nazwa list wskazuje teraz na listę, a listy nie da się wywołać.",
            ),
            choice(
                "Dlaczego list(\"abc\") w poprzednim zadaniu nie zadziałało?",
                listOf("Zmienna list przesłoniła wbudowany typ list", "list nie przyjmuje napisów", "Brakuje importu", "Napis jest za krótki"),
                0,
                "Własna zmienna o nazwie wbudowanej funkcji ją zasłania.",
            ),
            output(
                "sum = 0\nfor x in [1, 2, 3]:\n    sum += x\nprint(sum)",
                "6",
                "Na razie działa, ale nazwa sum przestała oznaczać funkcję wbudowaną.",
            ),
            choice(
                "Co się stanie po uruchomieniu tego kodu?",
                listOf("TypeError: 'int' object is not callable", "Wypisze 9", "Wypisze 15", "NameError"),
                0,
                "sum to teraz liczba 6, więc nie można jej wywołać jak funkcji.",
                code = "sum = 0\nfor x in [1, 2, 3]:\n    sum += x\nprint(sum([4, 5]))",
            ),
            fill(
                "Wybierz nazwę zmiennej, która nie zepsuje dalszego kodu.",
                "____ = [5, 2, 8]\nprint(max([1, 9]))",
                listOf("liczby", "max", "print"),
                "liczby",
                "Nazwy max i print zasłoniłyby funkcje wbudowane.",
            ),
            output(
                "dict = {\"a\": 1}\ntry:\n    d = dict(b=2)\nexcept TypeError:\n    print(\"dict jest zepsuty\")",
                "dict jest zepsuty",
                "Zmienna dict zasłoniła typ dict.",
            ),
            choice(
                "Których nazw nie warto używać dla własnych zmiennych?",
                listOf("list, str, sum, max", "lista, tekst, suma, maks", "wyniki, dane, x, y", "imie, wiek, cena, ilosc"),
                0,
                "To nazwy funkcji i typów wbudowanych.",
            ),
            output(
                "str = \"tekst\"\ndel str\nprint(str(42) + \"!\")",
                "42!",
                "del usuwa naszą zmienną, więc str znów oznacza funkcję wbudowaną.",
            ),
        ),
        lesson(
            "u53l5", "Dzielenie i brakujący return",
            output(
                "print(7 / 2, 7 // 2)",
                "3.5 3",
                "/ daje float, a // obcina część ułamkową.",
            ),
            choice(
                "Średnia ocen 4 i 5 powinna wynosić 4.5. Gdzie jest błąd?",
                listOf("// obcina wynik – trzeba użyć /", "sum nie działa dla list", "len zwraca złą liczbę", "Brakuje round"),
                0,
                "Do średniej potrzebne jest zwykłe dzielenie /.",
                code = "oceny = [4, 5]\nsrednia = sum(oceny) // len(oceny)\nprint(srednia)",
            ),
            output(
                "oceny = [4, 5]\nsrednia = sum(oceny) // len(oceny)\nprint(srednia)",
                "4",
                "9 // 2 to 4, a nie 4.5.",
            ),
            output(
                "print(-7 // 2)",
                "-4",
                "// zaokrągla w dół, czyli w stronę minus nieskończoności.",
            ),
            output(
                "def podwoj(x):\n    wynik = x * 2\n\nprint(podwoj(5))",
                "None",
                "Funkcja liczy wynik, ale go nie zwraca.",
            ),
            choice(
                "Dlaczego funkcja z poprzedniego zadania zwraca None?",
                listOf("Brakuje return wynik", "x * 2 to błąd", "print nie umie wypisać liczby", "Zmienna wynik jest globalna"),
                0,
                "Funkcja bez return zwraca None.",
            ),
            fill(
                "Uzupełnij, aby funkcja oddawała pole prostokąta.",
                "def pole(a, b):\n    ____ a * b\n\nprint(pole(3, 4))",
                listOf("return", "print", "="),
                "return",
                "Tylko return przekazuje wynik do miejsca wywołania.",
            ),
            output(
                "def ocena(p):\n    if p >= 50:\n        return \"zdane\"\n\nprint(ocena(70), ocena(30))",
                "zdane None",
                "Dla 30 żaden return się nie wykonuje, więc wynik to None.",
            ),
        ),
        lesson(
            "u53l6", "Powtórka: debugowanie",
            choice(
                "Jaki błąd zgłosi ten kod?",
                listOf("IndexError – zakres jest o jeden za duży", "KeyError", "TypeError", "Żaden"),
                0,
                "Ostatni indeks to 2, a range(4) dochodzi do 3.",
                code = "lista = [1, 2, 3]\nfor i in range(len(lista) + 1):\n    print(lista[i])",
            ),
            output(
                "def polowa(n):\n    return n // 2\n\nprint(polowa(5))",
                "2",
                "// obcina część ułamkową – do połowy 5 potrzebne jest /.",
            ),
            output(
                "def maks(a, b):\n    if a > b:\n        return a\n    elif b > a:\n        return b\n\nprint(maks(3, 3))",
                "None",
                "Przypadek a == b nie ma swojego return.",
            ),
            choice(
                "Który wiersz przesłania funkcję wbudowaną?",
                listOf("max = 10", "maks = 10", "wynik = 10", "najwiekszy = 10"),
                0,
                "max to nazwa funkcji wbudowanej.",
            ),
            output(
                "def zapisz(x, log=[]):\n    log.append(x)\n    return len(log)\n\nzapisz(\"a\")\nzapisz(\"b\")\nprint(zapisz(\"c\"))",
                "3",
                "Domyślna lista jest współdzielona, więc rośnie przy każdym wywołaniu.",
            ),
            fill(
                "Uzupełnij operator, aby sprawdzić hasło.",
                "haslo = \"tajne\"\nif haslo ____ \"tajne\":\n    print(\"OK\")",
                listOf("==", "=", "==="),
                "==",
                "W Pythonie porównanie to ==; nie ma operatora ===.",
            ),
            tiles(
                "Napisz nagłówek pętli, która idzie po kopii listy liczby.",
                listOf("for", "x", "in", "liczby[:]:"),
                listOf("liczby:", "range"),
                "Kopia [:] pozwala bezpiecznie usuwać elementy z oryginału.",
            ),
            choice(
                "Co najlepiej zrobić najpierw, gdy program daje zły wynik?",
                listOf("Odtworzyć błąd na małym przykładzie i wypisać wartości zmiennych", "Przepisać cały program od nowa", "Dodać więcej pętli", "Zignorować błąd"),
                0,
                "Mały przykład i print (albo debugger) pokazują, gdzie wartości się rozjeżdżają.",
            ),
        ),
    ),
)
