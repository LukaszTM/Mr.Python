package com.mrpython.app.data.course

import com.mrpython.app.domain.CourseUnit

internal val module69 = CourseUnit(
    id = "u69",
    title = "Projekt: gra tekstowa",
    description = "Pokoje, komendy, ekwipunek i pętla gry",
    lessons = listOf(
        lesson(
            "u69l1", "Krok 1: pokoje jako słowniki",
            output(
                "hol = {\n    \"opis\": \"Ciemny hol\",\n    \"wyjscia\": {\"północ\": \"kuchnia\"},\n}\nprint(hol[\"opis\"])\nprint(hol[\"wyjscia\"][\"północ\"])",
                "Ciemny hol\nkuchnia",
                "Pokój to słownik z opisem i słownikiem wyjść.",
            ),
            output(
                "pokoje = {\n    \"hol\": {\"opis\": \"Ciemny hol\"},\n    \"kuchnia\": {\"opis\": \"Pachnie chlebem\"},\n}\nprint(pokoje[\"kuchnia\"][\"opis\"])",
                "Pachnie chlebem",
                "Wszystkie pokoje trzymamy w jednym słowniku: nazwa → pokój.",
            ),
            fill(
                "Odczytaj, dokąd prowadzi wyjście na wschód.",
                "wyjscia = {\"wschód\": \"ogród\", \"zachód\": \"las\"}\nprint(wyjscia[____])",
                listOf("\"wschód\"", "wschód", "0"),
                "\"wschód\"",
                "Klucz słownika to napis, więc musi być w cudzysłowie.",
            ),
            choice(
                "Dlaczego pokój najlepiej zapisać jako słownik?",
                listOf("Bo jego części (opis, wyjścia) mają czytelne nazwy-klucze", "Bo słowniki są zawsze posortowane alfabetycznie", "Bo listy nie mogą zawierać napisów", "Bo słownika nie da się zmienić"),
                0,
                "Klucze takie jak \"opis\" i \"wyjscia\" opisują, co przechowujemy.",
            ),
            output(
                "wyjscia = {\"północ\": \"kuchnia\", \"wschód\": \"ogród\"}\nfor kierunek in wyjscia:\n    print(kierunek)",
                "północ\nwschód",
                "Pętla po słowniku przechodzi po jego kluczach.",
            ),
            tiles(
                "Utwórz pokój kuchnia z opisem \"Pachnie chlebem\"",
                listOf("kuchnia", "=", "{\"opis\":", "\"Pachnie chlebem\"}"),
                listOf("[\"opis\",", "(\"opis\":"),
                "Słownik zapisujemy w nawiasach klamrowych: {klucz: wartość}.",
            ),
            output(
                "wyjscia = {\"północ\": \"kuchnia\", \"wschód\": \"ogród\"}\nprint(\"Wyjścia:\", \", \".join(wyjscia))",
                "Wyjścia: północ, wschód",
                "join() na słowniku skleja jego klucze.",
            ),
            output(
                "wyjscia = {\"północ\": \"kuchnia\"}\nprint(wyjscia.get(\"zachód\", \"brak drogi\"))",
                "brak drogi",
                "get() z wartością domyślną chroni przed KeyError.",
            ),
        ),
        lesson(
            "u69l2", "Krok 2: ruch po komendach",
            output(
                "komenda = \"idź północ\"\nczasownik, kierunek = komenda.split()\nprint(kierunek)\nprint(czasownik)",
                "północ\nidź",
                "split() dzieli komendę, a rozpakowanie daje dwie zmienne.",
            ),
            output(
                "MAPA = {\n    \"hol\": {\"północ\": \"kuchnia\"},\n    \"kuchnia\": {\"południe\": \"hol\"},\n}\ndef idz(pokoj, kier):\n    return MAPA[pokoj].get(kier, pokoj)\n\nprint(idz(\"hol\", \"północ\"))\nprint(idz(\"hol\", \"zachód\"))",
                "kuchnia\nhol",
                "Gdy wyjścia nie ma, get() zwraca obecny pokój – gracz stoi w miejscu.",
            ),
            output(
                "MAPA = {\"hol\": {\"n\": \"sala\"},\n        \"sala\": {\"s\": \"hol\", \"n\": \"wieża\"}}\npokoj = \"hol\"\nfor k in [\"n\", \"s\", \"n\", \"n\"]:\n    pokoj = MAPA[pokoj].get(k, pokoj)\nprint(pokoj)",
                "wieża",
                "hol → sala → hol → sala → wieża.",
            ),
            fill(
                "Przejdź tylko wtedy, gdy takie wyjście istnieje.",
                "wyjscia = {\"n\": \"sala\"}\npokoj = \"hol\"\nfor kier in [\"s\", \"n\"]:\n    if kier ____ wyjscia:\n        pokoj = wyjscia[kier]\nprint(pokoj)",
                listOf("in", "not in", "=="),
                "in",
                "Operator in sprawdza, czy klucz jest w słowniku.",
            ),
            choice(
                "Co się stanie przy wyjscia[\"x\"], gdy klucza \"x\" nie ma?",
                listOf("KeyError", "Zwróci None", "Zwróci pusty napis", "IndexError"),
                0,
                "Dlatego przy nieznanych komendach używamy get() albo in.",
            ),
            tiles(
                "Rozbij komendę na czasownik i resztę (najwyżej jeden podział)",
                listOf("czas, arg", "=", "komenda.split(", "maxsplit=1", ")"),
                listOf("komenda.join(", "sep=1"),
                "maxsplit=1 dzieli tylko przy pierwszej spacji, np. \"weź stary klucz\".",
            ),
            output(
                "def pomoc():\n    return \"komendy: idź, weź\"\ndef nie_wiem():\n    return \"nie rozumiem\"\nKOMENDY = {\"pomoc\": pomoc}\nfor k in [\"pomoc\", \"skacz\"]:\n    print(KOMENDY.get(k, nie_wiem)())",
                "komendy: idź, weź\nnie rozumiem",
                "Słownik komend wskazuje funkcje; nieznana komenda dostaje funkcję domyślną.",
            ),
            output(
                "SKROTY = {\"n\": \"północ\", \"s\": \"południe\"}\nfor k in [\"n\", \"wschód\"]:\n    print(SKROTY.get(k, k))",
                "północ\nwschód",
                "Skrót zamieniamy na pełną nazwę, a inne komendy zostawiamy bez zmian.",
            ),
        ),
        lesson(
            "u69l3", "Krok 3: ekwipunek",
            output(
                "ekwipunek = []\nekwipunek.append(\"klucz\")\nekwipunek.append(\"lampa\")\nprint(ekwipunek)",
                "['klucz', 'lampa']",
                "Ekwipunek to zwykła lista, do której dopisujemy przedmioty.",
            ),
            output(
                "w_pokoju = [\"klucz\", \"mapa\"]\nekw = []\nekw.append(w_pokoju.pop(0))\nprint(ekw, w_pokoju)",
                "['klucz'] ['mapa']",
                "pop(0) zabiera przedmiot z pokoju, a append() wkłada go do ekwipunku.",
            ),
            fill(
                "Sprawdź, czy gracz ma klucz.",
                "ekwipunek = [\"lampa\", \"klucz\"]\nif \"klucz\" ____ ekwipunek:\n    print(\"Otwierasz drzwi\")",
                listOf("in", "not in", "is"),
                "in",
                "in sprawdza, czy element jest na liście.",
            ),
            output(
                "def wez(rzecz, pokoj, ekw):\n    if rzecz not in pokoj:\n        return \"Nie ma tu tego.\"\n    pokoj.remove(rzecz)\n    ekw.append(rzecz)\n    return f\"Bierzesz: {rzecz}\"\np, e = [\"miecz\"], []\nprint(wez(\"miecz\", p, e))\nprint(wez(\"miecz\", p, e))",
                "Bierzesz: miecz\nNie ma tu tego.",
                "Za drugim razem miecza już nie ma w pokoju.",
            ),
            choice(
                "Co zrobi lista.remove(\"x\"), gdy \"x\" nie ma na liście?",
                listOf("Zgłosi ValueError", "Nic się nie stanie", "Usunie ostatni element", "Zwróci False"),
                0,
                "remove() zgłasza ValueError, dlatego najpierw sprawdzamy in.",
            ),
            tiles(
                "Wypisz ekwipunek jako napis z przecinkami",
                listOf("print(", "\", \".join(", "ekwipunek", "))"),
                listOf("ekwipunek.split(", "str("),
                "join() skleja elementy listy napisem \", \".",
            ),
            output(
                "ekw = [\"mapa\", \"klucz\", \"lampa\"]\nprint(len(ekw), sorted(ekw))",
                "3 ['klucz', 'lampa', 'mapa']",
                "sorted() zwraca nową, posortowaną listę.",
            ),
            output(
                "ZAMKNIETE = {\"skarbiec\": \"klucz\"}\ndef wejdz(cel, ekw):\n    potrzebny = ZAMKNIETE.get(cel)\n    if potrzebny and potrzebny not in ekw:\n        return \"Zamknięte!\"\n    return f\"Wchodzisz: {cel}\"\nprint(wejdz(\"skarbiec\", []))\nprint(wejdz(\"skarbiec\", [\"klucz\"]))",
                "Zamknięte!\nWchodzisz: skarbiec",
                "Drzwi otwierają się dopiero, gdy klucz jest w ekwipunku.",
            ),
        ),
        lesson(
            "u69l4", "Krok 4: klasa Player",
            output(
                "class Player:\n    def __init__(self, imie):\n        self.imie = imie\n        self.pokoj = \"hol\"\n        self.ekw = []\np = Player(\"Ola\")\nprint(p.imie, p.pokoj, p.ekw)",
                "Ola hol []",
                "Obiekt gracza trzyma jego imię, położenie i ekwipunek razem.",
            ),
            output(
                "MAPA = {\"hol\": {\"n\": \"sala\"}}\nclass Player:\n    def __init__(self):\n        self.pokoj = \"hol\"\n    def idz(self, k):\n        wyj = MAPA.get(self.pokoj, {})\n        self.pokoj = wyj.get(k, self.pokoj)\np = Player()\np.idz(\"n\"); p.idz(\"n\")\nprint(p.pokoj)",
                "sala",
                "Z sali nie ma wyjścia na północ, więc gracz zostaje w sali.",
            ),
            fill(
                "Dodaj przedmiot do ekwipunku gracza.",
                "class Player:\n    def __init__(self):\n        self.ekw = []\n    def wez(self, rzecz):\n        self.ekw.____(rzecz)\np = Player()\np.wez(\"lampa\")\nprint(p.ekw)",
                listOf("append", "add", "push"),
                "append",
                "Do listy dodajemy metodą append().",
            ),
            output(
                "class Player:\n    def __init__(self, imie):\n        self.imie = imie\n        self.pokoj = \"hol\"\n    def __str__(self):\n        return f\"{self.imie} ({self.pokoj})\"\nprint(Player(\"Ola\"))",
                "Ola (hol)",
                "__str__ decyduje, jak print() pokaże obiekt.",
            ),
            choice(
                "Na co wskazuje self w metodzie p.idz(\"n\")?",
                listOf("Na obiekt p, na którym wywołano metodę", "Na klasę Player", "Na napis \"n\"", "Na słownik MAPA"),
                0,
                "Python sam przekazuje obiekt jako pierwszy argument metody.",
            ),
            tiles(
                "Utwórz gracza o imieniu Ola",
                listOf("gracz", "=", "Player(", "\"Ola\"", ")"),
                listOf("new", "Player."),
                "Obiekt tworzymy, wywołując klasę jak funkcję.",
            ),
            output(
                "class Player:\n    def __init__(self):\n        self.hp = 10\n    def obrywa(self, ile):\n        self.hp = max(0, self.hp - ile)\n        return self.hp > 0\np = Player()\nprint(p.obrywa(4), p.hp)\nprint(p.obrywa(9), p.hp)",
                "True 6\nFalse 0",
                "max(0, ...) pilnuje, żeby zdrowie nie spadło poniżej zera.",
            ),
            choice(
                "Gdzie najlepiej trzymać ekwipunek gracza?",
                listOf("W atrybucie obiektu, np. self.ekw", "W zmiennej lokalnej metody __init__", "W stałej MAPA", "W atrybucie klasy wspólnym dla wszystkich graczy"),
                0,
                "Każdy gracz ma własny ekwipunek, więc to atrybut obiektu.",
            ),
        ),
        lesson(
            "u69l5", "Projekt: pętla gry",
            output(
                "MAPA = {\"hol\": {\"n\": \"sala\"}, \"sala\": {\"s\": \"hol\"}}\npokoj = \"hol\"\nfor kom in [\"n\", \"x\", \"s\"]:\n    if kom in MAPA[pokoj]:\n        pokoj = MAPA[pokoj][kom]\n        print(\"Idziesz do:\", pokoj)\n    else:\n        print(\"Nie ma przejścia.\")",
                "Idziesz do: sala\nNie ma przejścia.\nIdziesz do: hol",
                "Pętla gry przetwarza po kolei zaplanowane komendy.",
            ),
            output(
                "for kom in [\"n\", \"s\", \"koniec\", \"n\"]:\n    if kom == \"koniec\":\n        print(\"Do zobaczenia!\")\n        break\n    print(\"Komenda:\", kom)",
                "Komenda: n\nKomenda: s\nDo zobaczenia!",
                "break kończy pętlę gry – ostatnie \"n\" się nie wykona.",
            ),
            fill(
                "Zakończ grę, gdy gracz dotrze do skarbca.",
                "trasa = [\"hol\", \"skarbiec\", \"wieża\"]\nfor pokoj in trasa:\n    print(pokoj)\n    if pokoj == \"skarbiec\":\n        ____",
                listOf("break", "continue", "pass"),
                "break",
                "break przerywa pętlę, więc wieży już nie odwiedzimy.",
            ),
            output(
                "class Gra:\n    def __init__(self):\n        self.ekw = []\n    def wykonaj(self, kom):\n        czas, _, arg = kom.partition(\" \")\n        if czas == \"weź\":\n            self.ekw.append(arg)\ng = Gra()\nfor k in [\"weź klucz\", \"patrz\", \"weź lampa\"]:\n    g.wykonaj(k)\nprint(g.ekw)",
                "['klucz', 'lampa']",
                "partition(\" \") dzieli komendę przy pierwszej spacji.",
            ),
            choice(
                "Dlaczego testujemy grę na liście komend zamiast input()?",
                listOf("Bo wynik jest zawsze taki sam i łatwo go sprawdzić", "Bo input() nie działa w pętli", "Bo listy są szybsze od klawiatury", "Bo input() zwraca liczby"),
                0,
                "Zaplanowany scenariusz daje powtarzalny, deterministyczny przebieg.",
            ),
            tiles(
                "Napisz nagłówek pętli numerującej komendy od 1",
                listOf("for", "nr, kom", "in", "enumerate(komendy, 1):"),
                listOf("range(komendy):", "while"),
                "enumerate(..., 1) numeruje elementy od jedynki.",
            ),
            output(
                "komendy = iter([\"n\", \"n\", \"koniec\", \"s\"])\nkroki = 0\nwhile True:\n    k = next(komendy)\n    if k == \"koniec\":\n        break\n    kroki += 1\nprint(\"Kroki:\", kroki)",
                "Kroki: 2",
                "next() pobiera kolejne komendy, aż trafimy na \"koniec\".",
            ),
            output(
                "skarby = {\"sala\": \"złoto\", \"wieża\": \"korona\"}\nekw = []\nfor pokoj in [\"hol\", \"sala\", \"wieża\"]:\n    if pokoj in skarby:\n        ekw.append(skarby[pokoj])\nwygrana = len(ekw) == len(skarby)\nprint(\"Wygrana!\" if wygrana else \"Szukaj dalej\")\nprint(ekw)",
                "Wygrana!\n['złoto', 'korona']",
                "Gra kończy się zwycięstwem, gdy zebrano wszystkie skarby.",
            ),
        ),
    ),
)
