package com.mrpython.app.data.course

import com.mrpython.app.domain.CourseUnit

internal val module71 = CourseUnit(
    id = "u71",
    title = "Pythonowe idiomy",
    description = "Jak pisać kod, który wygląda naprawdę po pythonowemu",
    lessons = listOf(
        lesson(
            "u71l1", "EAFP czy LBYL",
            choice(
                "Co oznacza styl EAFP?",
                listOf("Najpierw próbuj, a ewentualny błąd złap w except", "Zawsze sprawdzaj warunki ifem przed działaniem", "Nigdy nie używaj wyjątków", "Pisz wszystko w jednej linii"),
                0,
                "EAFP: łatwiej prosić o wybaczenie niż o pozwolenie.",
            ),
            output(
                "d = {\"a\": 1}\nif \"b\" in d:\n    print(d[\"b\"])\nelse:\n    print(\"brak\")",
                "brak",
                "LBYL: najpierw sprawdzamy (if), dopiero potem działamy.",
            ),
            output(
                "d = {\"a\": 1}\ntry:\n    print(d[\"b\"])\nexcept KeyError:\n    print(\"brak klucza\")",
                "brak klucza",
                "EAFP: po prostu próbujemy i łapiemy KeyError.",
            ),
            fill(
                "Zamień tekst na liczbę w stylu EAFP.",
                "tekst = \"12a\"\ntry:\n    n = int(tekst)\nexcept ____:\n    n = 0\nprint(n)",
                listOf("ValueError", "KeyError", "IndexError"),
                "ValueError",
                "int() ze złego napisu zgłasza ValueError.",
            ),
            output(
                "def na_liczbe(t):\n    try:\n        return int(t)\n    except ValueError:\n        return 0\nprint([na_liczbe(x) for x in [\"3\", \"x\", \"7\"]])",
                "[3, 0, 7]",
                "Błędne napisy zamieniają się na 0 i program działa dalej.",
            ),
            choice(
                "Kiedy EAFP jest wyraźnie lepszy od LBYL?",
                listOf("Gdy stan może się zmienić między sprawdzeniem a użyciem, np. plik zniknie", "Gdy chcemy, żeby kod był wolniejszy", "Gdy nie znamy żadnych wyjątków", "Nigdy"),
                0,
                "Sprawdzenie ifem może się zdezaktualizować, a try działa w chwili użycia.",
            ),
            tiles(
                "Napisz wersję LBYL: zamień t na liczbę, gdy ma same cyfry, a w przeciwnym razie daj 0",
                listOf("n", "=", "int(t)", "if", "t.isdigit()", "else", "0"),
                listOf("except", "t.isalpha()"),
                "LBYL najpierw sprawdza warunek (isdigit), a dopiero potem działa.",
            ),
            output(
                "class Kot:\n    imie = \"Mruczek\"\nprint(getattr(Kot, \"imie\", \"?\"))\nprint(getattr(Kot, \"wiek\", \"?\"))",
                "Mruczek\n?",
                "getattr z wartością domyślną nie zgłasza AttributeError.",
            ),
        ),
        lesson(
            "u71l2", "Rozpakowywanie i zamiana",
            output(
                "a, b = 1, 2\na, b = b, a\nprint(a, b)",
                "2 1",
                "Zamiana wartości bez zmiennej pomocniczej to klasyczny idiom.",
            ),
            output(
                "pierwszy, *reszta = [1, 2, 3, 4]\nprint(pierwszy, reszta)",
                "1 [2, 3, 4]",
                "Gwiazdka zbiera wszystkie pozostałe elementy do listy.",
            ),
            output(
                "*poczatek, ost = \"abc\"\nprint(poczatek, ost)",
                "['a', 'b'] c",
                "Gwiazdka może stać też na początku.",
            ),
            fill(
                "Zamień miejscami wartości x i y.",
                "x, y = \"lewo\", \"prawo\"\nx, y = ____\nprint(x, y)",
                listOf("y, x", "x, y", "y"),
                "y, x",
                "Po prawej budujemy krotkę (y, x) i rozpakowujemy ją.",
            ),
            output(
                "osoby = [(\"Ala\", 7), (\"Ola\", 9)]\nfor imie, wiek in osoby:\n    print(imie, wiek)",
                "Ala 7\nOla 9",
                "Rozpakowanie w nagłówku pętli zastępuje indeksy [0] i [1].",
            ),
            output(
                "(a, b), c = (1, 2), 3\nprint(a + b + c)",
                "6",
                "Rozpakowywać można także zagnieżdżone struktury.",
            ),
            tiles(
                "Weź pierwszy i ostatni element listy liczby, a środek pomiń",
                listOf("pierwszy,", "*_,", "ostatni", "=", "liczby"),
                listOf("**_,", "liczby[0]"),
                "*_ zbiera niepotrzebny środek do zmiennej _.",
            ),
            choice(
                "Co się stanie po wykonaniu tego kodu?",
                listOf("ValueError – za dużo wartości do rozpakowania", "a = 1, b = [2, 3]", "a = 1, b = 2, a 3 zostanie pominięte", "a = [1, 2], b = 3"),
                0,
                "Bez gwiazdki liczba zmiennych musi się zgadzać z liczbą elementów.",
                code = "a, b = [1, 2, 3]",
            ),
        ),
        lesson(
            "u71l3", "enumerate i zip zamiast indeksów",
            output(
                "for i, z in enumerate(\"ab\", 1):\n    print(i, z)",
                "1 a\n2 b",
                "enumerate daje numer i element naraz; tu numerujemy od 1.",
            ),
            output(
                "imiona = [\"Ala\", \"Ola\"]\nwyniki = [5, 8]\nfor imie, w in zip(imiona, wyniki):\n    print(f\"{imie}: {w}\")",
                "Ala: 5\nOla: 8",
                "zip łączy listy element po elemencie.",
            ),
            choice(
                "Który zapis jest najbardziej pythonowy?",
                listOf("for i, x in enumerate(lista):", "for i in range(len(lista)): x = lista[i]", "i = 0, a potem while i < len(lista):", "for x in lista: i = lista.index(x)"),
                0,
                "enumerate jest czytelne i nie wymaga ręcznego indeksowania.",
            ),
            output(
                "print(list(zip([1, 2, 3], \"ab\")))",
                "[(1, 'a'), (2, 'b')]",
                "zip kończy na najkrótszym ciągu.",
            ),
            fill(
                "Zbuduj słownik z listy kluczy i listy wartości.",
                "klucze = [\"a\", \"b\"]\nwartosci = [1, 2]\nd = ____(zip(klucze, wartosci))\nprint(d[\"b\"])",
                listOf("dict", "list", "tuple"),
                "dict",
                "dict() przyjmuje pary (klucz, wartość) z zip.",
            ),
            output(
                "pary = [(\"a\", 1), (\"b\", 2)]\nlitery, liczby = zip(*pary)\nprint(litery, liczby)",
                "('a', 'b') (1, 2)",
                "zip(*pary) „rozpina” pary z powrotem na dwie krotki.",
            ),
            tiles(
                "Przejdź jednocześnie po indeksach i elementach listy",
                listOf("for", "i, x", "in", "enumerate(lista):"),
                listOf("range(lista):", "zip(lista):"),
                "enumerate(lista) zwraca pary (indeks, element).",
            ),
            output(
                "lista = [3, 8, 1, 9]\nduze = [i for i, x in enumerate(lista) if x > 2]\nprint(duze)",
                "[0, 1, 3]",
                "Zbieramy indeksy elementów większych niż 2.",
            ),
        ),
        lesson(
            "u71l4", "get, setdefault i wyrażenia listowe",
            output(
                "d = {\"a\": 1}\nprint(d.get(\"a\"), d.get(\"b\"), d.get(\"b\", 0))",
                "1 None 0",
                "get() zwraca None albo podaną wartość domyślną, gdy klucza brak.",
            ),
            output(
                "grupy = {}\nfor s in [\"kot\", \"koń\", \"pies\"]:\n    grupy.setdefault(s[0], []).append(s)\nprint(grupy)",
                "{'k': ['kot', 'koń'], 'p': ['pies']}",
                "setdefault tworzy pustą listę tylko przy pierwszym użyciu klucza.",
            ),
            fill(
                "Dopisz słowo do listy pod jego pierwszą literą, tworząc listę, gdy jej brak.",
                "grupy = {}\nfor s in [\"ala\", \"as\"]:\n    grupy.____(s[0], []).append(s)\nprint(grupy)",
                listOf("setdefault", "get", "pop"),
                "setdefault",
                "Tylko setdefault zapisuje nową listę w słowniku.",
            ),
            output(
                "from collections import defaultdict\nd = defaultdict(int)\nfor z in \"abca\":\n    d[z] += 1\nprint(dict(d))",
                "{'a': 2, 'b': 1, 'c': 1}",
                "defaultdict(int) sam tworzy zero dla nowego klucza.",
            ),
            output(
                "kw = [x * x for x in range(5) if x % 2 == 0]\nprint(kw)",
                "[0, 4, 16]",
                "Wyrażenie listowe zastępuje pętlę z append().",
            ),
            output(
                "slowa = [\"ala\", \"ma\", \"kota\"]\nprint({s: len(s) for s in slowa})",
                "{'ala': 3, 'ma': 2, 'kota': 4}",
                "Słownik też można zbudować wyrażeniem.",
            ),
            choice(
                "Kiedy lepiej użyć zwykłej pętli niż wyrażenia listowego?",
                listOf("Gdy jest dużo logiki lub efekty uboczne, np. print()", "Zawsze, bo wyrażenia listowe są wolne", "Gdy lista ma mniej niż 10 elementów", "Nigdy"),
                0,
                "Wyrażenie listowe służy do budowania listy, a nie do wykonywania akcji.",
            ),
            tiles(
                "Zbuduj słownik: liczba → jej kwadrat dla liczb 1, 2, 3",
                listOf("{n:", "n * n", "for n in", "range(1, 4)}"),
                listOf("[n:", "range(3)}"),
                "Wyrażenie słownikowe ma postać {klucz: wartość for ...}.",
            ),
        ),
        lesson(
            "u71l5", "Powtórka: prawdziwość, with i :=",
            output(
                "print(bool([]), bool(\"0\"), bool(0))",
                "False True False",
                "Pusta lista i zero są fałszywe, a niepusty napis \"0\" jest prawdziwy.",
            ),
            output(
                "lista = []\nif not lista:\n    print(\"pusta\")",
                "pusta",
                "Pythonowo sprawdzamy pustość samym obiektem, bez len().",
            ),
            choice(
                "Który zapis jest idiomatyczny?",
                listOf("if lista:", "if len(lista) > 0:", "if lista == True:", "if lista != []:"),
                0,
                "Niepusta lista sama w sobie jest prawdziwa.",
            ),
            output(
                "with open(\"notatki.txt\", \"w\") as f:\n    f.write(\"hej\")\nprint(f.closed)",
                "True",
                "with zamyka plik automatycznie po wyjściu z bloku.",
            ),
            fill(
                "Otwórz plik tak, aby sam się zamknął.",
                "with open(\"notatki.txt\", \"w\") as f:\n    f.write(\"Python\")\n____ open(\"notatki.txt\") as f:\n    print(f.read())",
                listOf("with", "try", "for"),
                "with",
                "with to idiom do pracy z plikami i zasobami.",
            ),
            output(
                "dane = [1, 5, 9]\nif (n := len(dane)) > 2:\n    print(f\"Długa lista: {n}\")",
                "Długa lista: 3",
                "Operator := przypisuje wartość i od razu jej używa.",
            ),
            output(
                "it = iter([\"a\", \"b\", \"\", \"c\"])\nwhile (k := next(it)):\n    print(k)",
                "a\nb",
                "Pętla kończy się na pustym napisie, bo jest fałszywy.",
            ),
            tiles(
                "Zbierz kwadraty liczb z listy dane, ale tylko te większe niż 10",
                listOf("duze", "=", "[y for x in dane", "if (y := x * x) > 10]"),
                listOf("if y = x * x > 10]", "(y for x in dane"),
                "Walrus w warunku liczy x * x tylko raz.",
            ),
        ),
    ),
)
