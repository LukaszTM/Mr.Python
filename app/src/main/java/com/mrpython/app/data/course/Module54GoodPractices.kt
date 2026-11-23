package com.mrpython.app.data.course

import com.mrpython.app.domain.CourseUnit

internal val module54 = CourseUnit(
    id = "u54",
    title = "Dobre praktyki",
    description = "PEP 8, docstringi, małe funkcje i czytelny kod",
    lessons = listOf(
        lesson(
            "u54l1", "Nazewnictwo według PEP 8",
            choice(
                "Jak według PEP 8 nazwać zmienną przechowującą liczbę uczniów?",
                listOf("liczba_uczniow", "LiczbaUczniow", "liczbaUczniow", "LICZBA-UCZNIOW"),
                0,
                "Zmienne i funkcje piszemy w stylu snake_case.",
            ),
            choice(
                "Jak według PEP 8 nazwać klasę konta bankowego?",
                listOf("KontoBankowe", "konto_bankowe", "kontoBankowe", "KONTO_BANKOWE"),
                0,
                "Klasy piszemy w stylu CapWords – każde słowo wielką literą.",
            ),
            choice(
                "Jak według PEP 8 nazwać stałą z maksymalną liczbą prób?",
                listOf("MAX_PROB", "max_prob", "MaxProb", "maxProb"),
                0,
                "Stałe zapisujemy wielkimi literami z podkreślnikami.",
            ),
            choice(
                "Która nazwa w tym kodzie łamie zasady PEP 8?",
                listOf("ObliczPole – funkcja powinna być w snake_case", "a – za krótka nazwa argumentu", "wynik – zła nazwa zmiennej", "Żadna"),
                0,
                "Funkcje nazywamy małymi literami z podkreślnikami, np. oblicz_pole.",
                code = "def ObliczPole(a, b):\n    wynik = a * b\n    return wynik",
            ),
            fill(
                "Uzupełnij nazwę funkcji zgodną z PEP 8 i z wywołaniem.",
                "def ____(a, b):\n    return a + b\n\nprint(dodaj_liczby(2, 3))",
                listOf("dodaj_liczby", "DodajLiczby", "dodajLiczby"),
                "dodaj_liczby",
                "Funkcje w Pythonie nazywamy w stylu snake_case.",
            ),
            tiles(
                "Napisz nagłówek klasy samochodu osobowego zgodnie z PEP 8.",
                listOf("class", "SamochodOsobowy:"),
                listOf("samochod_osobowy:", "def"),
                "Nazwy klas zapisujemy w stylu CapWords.",
            ),
            output(
                "MAX_PROB = 3\nproby = 0\nwhile proby < MAX_PROB:\n    proby += 1\nprint(\"Próby:\", proby)",
                "Próby: 3",
                "Stała MAX_PROB od razu mówi, co oznacza liczba 3.",
            ),
            output(
                "class KotDomowy:\n    def __init__(self, imie):\n        self.imie = imie\n\nkot_ali = KotDomowy(\"Mruczek\")\nprint(kot_ali.imie)",
                "Mruczek",
                "Klasa w CapWords, obiekt i atrybut w snake_case.",
            ),
        ),
        lesson(
            "u54l2", "Docstringi i __doc__",
            output(
                "def dodaj(a, b):\n    \"\"\"Zwraca sumę a i b.\"\"\"\n    return a + b\n\nprint(dodaj.__doc__)",
                "Zwraca sumę a i b.",
                "Docstring trafia do atrybutu __doc__.",
            ),
            choice(
                "Gdzie umieszcza się docstring funkcji?",
                listOf("Jako pierwszy napis w ciele funkcji", "Nad linią def", "Na końcu funkcji", "W komentarzu z #"),
                0,
                "Tylko napis zaraz pod nagłówkiem def staje się docstringiem.",
            ),
            output(
                "def f():\n    return 1\n\nprint(f.__doc__)",
                "None",
                "Funkcja bez docstringa ma __doc__ równe None.",
            ),
            output(
                "def f():\n    # to tylko komentarz\n    return 1\n\nprint(f.__doc__)",
                "None",
                "Komentarz z # nie jest docstringiem.",
            ),
            fill(
                "Uzupełnij, aby wypisać docstring funkcji.",
                "def kwadrat(x):\n    \"\"\"Zwraca x do kwadratu.\"\"\"\n    return x * x\n\nprint(kwadrat.____)",
                listOf("__doc__", "doc", "__name__"),
                "__doc__",
                "Docstring jest dostępny jako __doc__.",
            ),
            output(
                "class Punkt:\n    \"\"\"Punkt na płaszczyźnie.\"\"\"\n\nprint(Punkt.__doc__)",
                "Punkt na płaszczyźnie.",
                "Klasy także mogą mieć docstring.",
            ),
            choice(
                "Co powinien opisywać docstring funkcji?",
                listOf("Co robi funkcja, co przyjmuje i co zwraca", "Kto napisał funkcję i kiedy", "Każdą linię kodu po kolei", "Wyniki testów"),
                0,
                "Docstring wyjaśnia, jak używać funkcji, bez czytania jej kodu.",
            ),
            output(
                "def f():\n    \"\"\"Pierwsza linia.\n\n    Szczegóły.\"\"\"\n\nprint(f.__doc__.splitlines()[0])",
                "Pierwsza linia.",
                "Pierwsza linia docstringa to krótkie podsumowanie.",
            ),
        ),
        lesson(
            "u54l3", "Małe funkcje i DRY",
            choice(
                "Co oznacza zasada DRY?",
                listOf("Nie powtarzaj się (Don't Repeat Yourself)", "Pisz krótkie nazwy", "Unikaj klas", "Nie używaj pętli"),
                0,
                "Powtarzający się kod warto wydzielić w jedno miejsce.",
            ),
            choice(
                "Jak najlepiej poprawić ten kod?",
                listOf("Wydzielić funkcję brutto(netto)", "Dopisać czwarty print", "Zmienić 1.23 na 1.2", "Usunąć round"),
                0,
                "Ten sam wzór w kilku miejscach to sygnał, by stworzyć funkcję.",
                code = "print(round(10 * 1.23, 2))\nprint(round(20 * 1.23, 2))\nprint(round(35 * 1.23, 2))",
            ),
            output(
                "def brutto(netto):\n    return round(netto * 1.23, 2)\n\nfor cena in [10, 20]:\n    print(brutto(cena))",
                "12.3\n24.6",
                "Wzór jest w jednym miejscu, a funkcję wywołujemy wiele razy.",
            ),
            fill(
                "Uzupełnij wywołanie funkcji.",
                "def powitanie(imie):\n    return \"Cześć, \" + imie + \"!\"\n\nprint(____(\"Ola\"))",
                listOf("powitanie", "powitaj", "Powitanie"),
                "powitanie",
                "Wywołujemy funkcję dokładnie po jej nazwie.",
            ),
            output(
                "def czy_parzysta(n):\n    return n % 2 == 0\n\ndef parzyste(lista):\n    return [x for x in lista if czy_parzysta(x)]\n\nprint(parzyste([1, 2, 3, 4]))",
                "[2, 4]",
                "Mała funkcja pomocnicza czyni drugą funkcję czytelniejszą.",
            ),
            choice(
                "Ile zadań powinna mieć dobrze napisana funkcja?",
                listOf("Jedno, dobrze określone", "Jak najwięcej", "Co najmniej trzy", "To nie ma znaczenia"),
                0,
                "Funkcja robiąca jedną rzecz jest łatwa do nazwania i przetestowania.",
            ),
            tiles(
                "Napisz nagłówek funkcji liczącej pole prostokąta zgodnie z PEP 8.",
                listOf("def", "pole_prostokata(", "a, b", "):"),
                listOf("class", "PoleProstokata("),
                "Funkcje nazywamy w stylu snake_case.",
            ),
            output(
                "def linia(n):\n    return \"-\" * n\n\nprint(linia(3) + \"x\" + linia(3))",
                "---x---",
                "Ta sama funkcja użyta dwa razy zamiast powtarzania kodu.",
            ),
        ),
        lesson(
            "u54l4", "Stałe i czytelne warunki",
            choice(
                "Co to jest magiczna liczba?",
                listOf("Liczba w kodzie bez wyjaśnienia, skąd się wzięła", "Liczba losowa", "Bardzo duża liczba", "Liczba pierwsza"),
                0,
                "Liczbę taką jak 0.23 lepiej nazwać, np. VAT = 0.23.",
            ),
            output(
                "VAT = 0.23\nnetto = 100\nprint(netto * (1 + VAT))",
                "123.0",
                "Stała VAT mówi, co oznacza 0.23.",
            ),
            fill(
                "Uzupełnij, używając stałej zamiast magicznej liczby.",
                "SEKUNDY_W_MINUCIE = 60\nminuty = 5\nprint(minuty * ____)",
                listOf("SEKUNDY_W_MINUCIE", "sekundy_w_minucie", "MINUTA"),
                "SEKUNDY_W_MINUCIE",
                "Nazwa stałej musi być zapisana dokładnie tak, jak ją zdefiniowano.",
            ),
            output(
                "DNI_W_TYGODNIU = 7\ndni = 23\nprint(dni // DNI_W_TYGODNIU, dni % DNI_W_TYGODNIU)",
                "3 2",
                "23 dni to 3 pełne tygodnie i 2 dni.",
            ),
            output(
                "wiek = 20\nma_bilet = True\nmoze_wejsc = wiek >= 18 and ma_bilet\nprint(moze_wejsc)",
                "True",
                "Nazwany warunek czyta się jak zdanie.",
            ),
            choice(
                "Jak prościej zapisać warunek if gotowe == True:?",
                listOf("if gotowe:", "if gotowe is True == True:", "if True == gotowe == True:", "if not not not gotowe:"),
                0,
                "Wartość logiczną można sprawdzić bezpośrednio.",
            ),
            output(
                "x = 5\nprint(1 < x < 10)",
                "True",
                "Python pozwala łączyć porównania jak w matematyce.",
            ),
            choice(
                "Który zapis jest czytelniejszą wersją tego warunku?",
                listOf("if 0 <= x <= 10:", "if x < 0 and x > 10:", "if 0 < x < 10:", "if x <= 0 or x >= 10:"),
                0,
                "x nie jest poza zakresem, czyli leży między 0 a 10 włącznie.",
                code = "x = 4\nif not (x < 0 or x > 10):\n    print(\"w zakresie\")",
            ),
        ),
        lesson(
            "u54l5", "Powtórka: wczesny return i styl",
            output(
                "def dziel(a, b):\n    if b == 0:\n        return \"błąd\"\n    return a / b\n\nprint(dziel(6, 3), dziel(1, 0))",
                "2.0 błąd",
                "Przypadek specjalny obsługujemy na początku i od razu wychodzimy.",
            ),
            choice(
                "Jaka jest główna zaleta wczesnego return?",
                listOf("Mniej zagnieżdżeń – przypadki specjalne obsłużone na początku", "Funkcja działa szybciej", "Nie trzeba pisać testów", "Można pominąć docstring"),
                0,
                "Główna logika nie jest schowana w głębokich if-ach.",
            ),
            fill(
                "Uzupełnij, aby funkcja od razu zakończyła się dla pustego napisu.",
                "def pierwsza_litera(s):\n    if not s:\n        ____ \"\"\n    return s[0]\n\nprint(pierwsza_litera(\"\") == \"\")",
                listOf("return", "print", "pass"),
                "return",
                "return kończy funkcję, zanim dojdzie do s[0].",
            ),
            output(
                "def ocena(pkt):\n    if pkt < 0:\n        return \"błąd\"\n    if pkt >= 50:\n        return \"zdane\"\n    return \"niezdane\"\n\nprint(ocena(-1), ocena(80), ocena(10))",
                "błąd zdane niezdane",
                "Każdy przypadek kończy funkcję własnym return.",
            ),
            choice(
                "Który zestaw nazw jest w pełni zgodny z PEP 8?",
                listOf("licz_srednia, Uczen, MAX_OCENA", "LiczSrednia, uczen, max_ocena", "liczSrednia, UCZEN, MaxOcena", "licz-srednia, Uczen, maxOcena"),
                0,
                "Funkcja w snake_case, klasa w CapWords, stała wielkimi literami.",
            ),
            tiles(
                "Napisz nagłówek wczesnego wyjścia: czy lista jest pusta.",
                listOf("if", "not", "lista:"),
                listOf("else:", "== []"),
                "not lista jest prawdziwe dla pustej listy.",
            ),
            output(
                "def f():\n    \"\"\"Nic nie robi.\"\"\"\n\nprint(f.__doc__, f())",
                "Nic nie robi. None",
                "Docstring to __doc__, a funkcja bez return zwraca None.",
            ),
            choice(
                "Co warto zmienić w tym kodzie?",
                listOf("Zamienić 0.77 na nazwaną stałą, np. PO_RABACIE", "Zmienić nazwę cena na Cena", "Usunąć print", "Dopisać pętlę"),
                0,
                "0.77 to magiczna liczba – nazwa wyjaśnia jej znaczenie.",
                code = "cena = 100 * 0.77\nprint(cena)",
            ),
        ),
    ),
)
