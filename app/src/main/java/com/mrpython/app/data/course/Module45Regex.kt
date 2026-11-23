package com.mrpython.app.data.course

import com.mrpython.app.domain.CourseUnit

internal val module45 = CourseUnit(
    id = "u45",
    title = "Wyrażenia regularne",
    description = "Moduł re: wyszukiwanie, grupy, zamiana i walidacja tekstu",
    lessons = listOf(
        lesson(
            "u45l1", "re.search i dopasowanie",
            output(
                "import re\nm = re.search(r\"\\d+\", \"mam 25 lat\")\nprint(m.group())",
                "25",
                "re.search() znajduje pierwsze dopasowanie, a group() zwraca dopasowany tekst.",
            ),
            output(
                "import re\nm = re.search(r\"\\d\", \"abc123\")\nprint(m.start())",
                "3",
                "start() zwraca indeks, od którego zaczyna się dopasowanie.",
            ),
            choice(
                "Co zwraca re.search(), gdy wzorzec nie pasuje nigdzie w napisie?",
                listOf("None", "Pustą listę", "False", "Zgłasza błąd ValueError"),
                0,
                "Brak dopasowania to None, dlatego przed group() warto sprawdzić wynik.",
            ),
            output(
                "import re\nm = re.search(\"kot\", \"Ala ma kota\")\nprint(m.span())",
                "(7, 10)",
                "span() zwraca krotkę (początek, koniec) dopasowania.",
            ),
            choice(
                "Co wypisze ten kod?",
                listOf("None", "kot", "(7, 10)", "True"),
                0,
                "re.match() sprawdza tylko początek napisu, a napis zaczyna się od „Ala”.",
                code = "import re\nprint(re.match(\"kot\", \"Ala ma kota\"))",
            ),
            output(
                "import re\nm = re.match(r\"\\d+\", \"123abc\")\nprint(m.group())",
                "123",
                "Tu napis zaczyna się od cyfr, więc re.match() się udaje.",
            ),
            choice(
                "Po co piszemy r przed wzorcem, np. r\"\\d+\"?",
                listOf(
                    "Żeby ukośnik \\ nie był traktowany jako znak specjalny napisu",
                    "Żeby wzorzec działał szybciej",
                    "Żeby wielkość liter nie miała znaczenia",
                    "Bez r moduł re nie działa w ogóle",
                ),
                0,
                "Surowy napis (raw string) przekazuje ukośniki do re bez zmian.",
            ),
            fill(
                "Uzupełnij, aby znaleźć pierwszą liczbę w napisie.",
                "import re\nm = re.____(r\"\\d+\", \"nr 42\")\nprint(m.group())",
                listOf("search", "match", "split", "findall"),
                "search",
                "search() szuka w całym napisie; match() patrzy tylko na początek i tu zwróci None.",
            ),
        ),
        lesson(
            "u45l2", "re.findall",
            output(
                "import re\nt = \"1 kot, 22 psy, 333 ryby\"\nprint(re.findall(r\"\\d+\", t))",
                "['1', '22', '333']",
                "findall() zwraca listę wszystkich dopasowań.",
            ),
            choice(
                "Czym różni się re.findall() od re.search()?",
                listOf(
                    "findall() zwraca listę wszystkich dopasowań, search() tylko pierwsze",
                    "findall() działa tylko na liczbach",
                    "search() zwraca listę, findall() obiekt dopasowania",
                    "Niczym, to synonimy",
                ),
                0,
                "search() daje jeden obiekt dopasowania, a findall() listę napisów.",
            ),
            output(
                "import re\nprint(re.findall(r\"\\d\", \"a1b2\"))",
                "['1', '2']",
                "\\d pasuje do jednej cyfry, więc dostajemy cyfry osobno.",
            ),
            output(
                "import re\nprint(re.findall(r\"\\d+\", \"brak\"))",
                "[]",
                "Brak dopasowań to pusta lista, a nie None.",
            ),
            choice(
                "Co zwraca re.findall() dla wzorca bez grup?",
                listOf("Listę napisów", "Jeden obiekt dopasowania", "Liczbę dopasowań", "Krotkę indeksów"),
                0,
                "findall() zwraca listę wszystkich dopasowanych fragmentów.",
            ),
            output(
                "import re\nt = \"3 + 4 + 5\"\nliczby = re.findall(r\"\\d+\", t)\nprint(sum(int(x) for x in liczby))",
                "12",
                "Dopasowania to napisy, więc zamieniamy je na int przed dodaniem.",
            ),
            tiles(
                "Znajdź wszystkie liczby w napisie tekst i zapisz je w zmiennej wyniki",
                listOf("wyniki", "=", "re.findall(", "r\"\\d+\",", "tekst)"),
                listOf("re.search(", "tekst.findall("),
                "re.findall(wzorzec, tekst) zwraca listę wszystkich dopasowań.",
            ),
            fill(
                "Uzupełnij, aby policzyć słowa „tak” w napisie.",
                "import re\nt = \"tak nie tak tak\"\nprint(len(re.____(\"tak\", t)))",
                listOf("findall", "search", "match"),
                "findall",
                "findall() zwraca listę, której długość to liczba dopasowań; obiekt dopasowania nie ma len().",
            ),
        ),
        lesson(
            "u45l3", "Klasy znaków i kwantyfikatory",
            output(
                "import re\nprint(re.findall(r\"\\w+\", \"Ala ma kota\"))",
                "['Ala', 'ma', 'kota']",
                "\\w to litera, cyfra lub _, a + oznacza „jeden lub więcej”.",
            ),
            output(
                "import re\nprint(re.findall(r\"\\d{3}\", \"12345678\"))",
                "['123', '456']",
                "{3} to dokładnie trzy powtórzenia; reszta „78” jest za krótka.",
            ),
            output(
                "import re\nprint(re.findall(\"ab*\", \"a ab abbb\"))",
                "['a', 'ab', 'abbb']",
                "* oznacza „zero lub więcej”, więc samo a też pasuje.",
            ),
            fill(
                "Uzupełnij, aby dopasować liczby złożone z jednej lub więcej cyfr.",
                "import re\nprint(re.findall(r\"\\d____\", \"5 i 120\"))",
                listOf("+", "?", "{2}"),
                "+",
                "+ oznacza „co najmniej raz”, więc dostaniemy ['5', '120'].",
            ),
            output(
                "import re\nt = \"kolor kolour\"\nprint(re.findall(\"kolou?r\", t))",
                "['kolor', 'kolour']",
                "? oznacza, że znak jest opcjonalny (0 lub 1 raz).",
            ),
            output(
                "import re\nprint(re.findall(\"[aeiou]\", \"programista\"))",
                "['o', 'a', 'i', 'a']",
                "Nawias kwadratowy to klasa: pasuje dowolny jeden znak z listy.",
            ),
            choice(
                "Do czego pasuje \\s we wzorcu?",
                listOf("Do białego znaku, np. spacji", "Do dowolnej litery", "Do cyfry", "Do litery s"),
                0,
                "\\s to spacja, tabulator, znak nowej linii itp.",
            ),
            fill(
                "Uzupełnij, aby dopasować dokładnie 4 cyfry naraz.",
                "import re\nprint(re.findall(r\"\\d____\", \"12345678\"))",
                listOf("{4}", "+", "*", "?"),
                "{4}",
                "{4} wymaga dokładnie czterech cyfr, więc dostaniemy ['1234', '5678'].",
            ),
        ),
        lesson(
            "u45l4", "Grupy i grupy nazwane",
            output(
                "import re\nm = re.search(r\"(\\d+)-(\\d+)\", \"tel 12-34\")\nprint(m.group(1))",
                "12",
                "Nawiasy tworzą grupę; group(1) to pierwsza z nich.",
            ),
            output(
                "import re\nm = re.search(r\"(\\d+)-(\\d+)\", \"tel 12-34\")\nprint(m.groups())",
                "('12', '34')",
                "groups() zwraca krotkę wszystkich grup.",
            ),
            choice(
                "Co zwraca m.group(0)?",
                listOf("Całe dopasowanie", "Pierwszą grupę", "Indeks początku", "None"),
                0,
                "group(0) to całe dopasowanie, tak jak group() bez argumentu.",
            ),
            output(
                "import re\nw = r\"(?P<rok>\\d{4})-(?P<mies>\\d{2})\"\nm = re.search(w, \"2026-10\")\nprint(m.group(\"mies\"))",
                "10",
                "Do grupy nazwanej odwołujemy się po nazwie.",
            ),
            output(
                "import re\nw = r\"(?P<rok>\\d{4})-(?P<mies>\\d{2})\"\nm = re.search(w, \"2026-10\")\nprint(m.groupdict())",
                "{'rok': '2026', 'mies': '10'}",
                "groupdict() zwraca słownik: nazwa grupy → tekst.",
            ),
            output(
                "import re\nprint(re.findall(r\"(\\w)=(\\d)\", \"a=1 b=2\"))",
                "[('a', '1'), ('b', '2')]",
                "Gdy wzorzec ma kilka grup, findall() zwraca listę krotek.",
            ),
            choice(
                "Jak zapisać grupę nazwaną „kod”?",
                listOf("(?P<kod>...)", "(kod: ...)", "{kod}...", "<kod>(...)"),
                0,
                "Składnia grupy nazwanej w Pythonie to (?P<nazwa>wzorzec).",
            ),
            fill(
                "Uzupełnij, aby wypisać pierwszą grupę.",
                "import re\nm = re.search(r\"(\\d+)zł\", \"cena 15zł\")\nprint(m.____(1))",
                listOf("group", "get", "find"),
                "group",
                "group(n) zwraca tekst n-tej grupy; get i find nie istnieją w obiekcie dopasowania.",
            ),
        ),
        lesson(
            "u45l5", "re.sub, re.split i walidacja",
            output(
                "import re\nprint(re.sub(r\"\\d\", \"#\", \"pin 1234\"))",
                "pin ####",
                "re.sub() zamienia każde dopasowanie na podany tekst.",
            ),
            output(
                "import re\nprint(re.sub(r\"\\s+\", \" \", \"a   b    c\"))",
                "a b c",
                "Wiele spacji z rzędu zamieniamy na jedną.",
            ),
            output(
                "import re\nprint(re.sub(r\"(\\d+)-(\\d+)\", r\"\\2-\\1\", \"12-34\"))",
                "34-12",
                "W tekście zamiany \\1 i \\2 oznaczają zawartość grup.",
            ),
            output(
                "import re\nprint(re.split(r\"[,;]\", \"a,b;c\"))",
                "['a', 'b', 'c']",
                "re.split() dzieli napis w każdym miejscu pasującym do wzorca.",
            ),
            output(
                "import re\nw = r\"\\d{2}-\\d{3}\"\nfor k in [\"00-950\", \"0-950\", \"12345\"]:\n    print(bool(re.fullmatch(w, k)))",
                "True\nFalse\nFalse",
                "fullmatch() sprawdza, czy cały napis to poprawny kod pocztowy.",
            ),
            choice(
                "Dlaczego do walidacji kodu pocztowego lepszy jest fullmatch() niż search()?",
                listOf(
                    "search() znajdzie kod także w napisie „x00-950x”",
                    "search() nie obsługuje {n}",
                    "fullmatch() jest jedyną funkcją zwracającą True",
                    "search() działa tylko na liczbach",
                ),
                0,
                "fullmatch() wymaga, by wzorzec pasował do całego napisu, a nie do fragmentu.",
            ),
            output(
                "import re\nw = r\"[\\w.]+@\\w+\\.\\w+\"\nprint(re.fullmatch(w, \"ola@poczta.pl\") is not None)\nprint(re.fullmatch(w, \"ola@pl\") is not None)",
                "True\nFalse",
                "Uproszczony wzorzec e-maila wymaga kropki po @.",
            ),
            tiles(
                "Zamień w napisie tekst każdą cyfrę na gwiazdkę i zapisz wynik w zmiennej nowy",
                listOf("nowy", "=", "re.sub(", "r\"\\d\",", "\"*\",", "tekst)"),
                listOf("re.split(", "tekst.sub("),
                "re.sub(wzorzec, zamiana, tekst) zwraca nowy napis.",
            ),
        ),
        lesson(
            "u45l6", "Powtórka: wyrażenia regularne",
            output(
                "import re\nm = re.search(r\"\\d+\", \"ok 7 i 80\")\nprint(m.group())",
                "7",
                "search() zwraca tylko pierwsze dopasowanie.",
            ),
            output(
                "import re\nprint(re.findall(r\"\\d+\", \"ok 7 i 80\"))",
                "['7', '80']",
                "findall() zbiera wszystkie dopasowania.",
            ),
            choice(
                "Który wzorzec pasuje do jednej lub więcej liter, cyfr lub _?",
                listOf("\\w+", "\\d*", "\\s+", "\\w?"),
                0,
                "\\w to znak słowa, a + to „co najmniej raz”.",
            ),
            output(
                "import re\nm = re.search(r\"(?P<x>\\d+)x(?P<y>\\d+)\", \"1920x1080\")\nprint(m.group(\"y\"))",
                "1080",
                "Grupa nazwana y przechwyciła drugą liczbę.",
            ),
            output(
                "import re\nprint(re.sub(\"a+\", \"a\", \"baaardzo\"))",
                "bardzo",
                "Ciąg wielu liter a zamieniamy na jedną.",
            ),
            output(
                "import re\nprint(re.split(r\"\\s*;\\s*\", \"x ; y;z\"))",
                "['x', 'y', 'z']",
                "\\s* pozwala na dowolne spacje wokół średnika.",
            ),
            fill(
                "Uzupełnij, aby sprawdzić, czy CAŁY napis to dokładnie 3 cyfry.",
                "import re\nprint(re.____(r\"\\d{3}\", \"1234\"))",
                listOf("fullmatch", "search", "findall"),
                "fullmatch",
                "fullmatch() zwraca None dla „1234”, a search() i findall() znalazłyby fragment „123”.",
            ),
            tiles(
                "Znajdź pierwsze dopasowanie wzorca w napisie tekst i zapisz je w zmiennej m",
                listOf("m", "=", "re.search(", "wzorzec,", "tekst)"),
                listOf("re.sub(", "m.group("),
                "re.search(wzorzec, tekst) zwraca obiekt dopasowania lub None.",
            ),
        ),
    ),
)
