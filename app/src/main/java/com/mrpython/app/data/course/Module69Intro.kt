package com.mrpython.app.data.course

internal val module69Intro = lesson(
    "u69l0", "Wprowadzenie: projekt gry tekstowej",
    explain(
        "Pokoje jako słowniki",
        "Budujemy grę przygodową. Mapa to słownik: kluczem jest nazwa pokoju, a wartością słownik " +
            "z opisem i wyjściami w różne strony.",
        code = "MAPA = {\n    \"hol\": {\"opis\": \"Ciemny hol\", \"n\": \"kuchnia\"},\n}\nprint(MAPA[\"hol\"][\"opis\"])\nprint(MAPA[\"hol\"][\"n\"])",
        output = "Ciemny hol\nkuchnia",
    ),
    explain(
        "Komendy",
        "Gracz wpisuje komendy typu „idź n”. `split()` rozdziela czasownik i kierunek, " +
            "a `get()` z wartością domyślną obsłuży nieznany kierunek bez błędu.",
        code = "czasownik, kier = \"idź n\".split()\nwyjscia = {\"n\": \"kuchnia\"}\nprint(wyjscia.get(kier, \"brak drogi\"))\nprint(wyjscia.get(\"s\", \"brak drogi\"))",
        output = "kuchnia\nbrak drogi",
    ),
    explain(
        "Ekwipunek",
        "Ekwipunek to lista: przedmiot zabrany z pokoju usuwamy z jego listy (`remove`) i dodajemy " +
            "do swojej (`append`). Operator `in` sprawdza, czy coś masz.",
        code = "pokoj = [\"klucz\", \"mapa\"]\nekw = []\npokoj.remove(\"klucz\")\nekw.append(\"klucz\")\nprint(ekw, pokoj, \"klucz\" in ekw)",
        output = "['klucz'] ['mapa'] True",
    ),
    explain(
        "Klasa Player",
        "Stan gracza (pokój, ekwipunek, życie) wygodnie trzymać w obiekcie. Metody, np. `idz`, " +
            "zmieniają ten stan.",
        code = "class Player:\n    def __init__(self):\n        self.pokoj = \"hol\"\n    def idz(self, cel):\n        self.pokoj = cel\np = Player(); p.idz(\"sala\"); print(p.pokoj)",
        output = "sala",
    ),
    explain(
        "Pętla gry",
        "Gra kręci się w pętli: wczytaj komendę, wykonaj, powtórz – aż do „koniec” i `break`. " +
            "W prawdziwej grze komendy dałby `input()`, w ćwiczeniach podajemy je listą.",
        code = "for kom in [\"n\", \"s\", \"koniec\", \"n\"]:\n    if kom == \"koniec\":\n        print(\"Do zobaczenia!\")\n        break\n    print(\"Idę:\", kom)",
        output = "Idę: n\nIdę: s\nDo zobaczenia!",
    ),
    output(
        "MAPA = {\"hol\": {\"n\": \"sala\"}}\nprint(MAPA[\"hol\"].get(\"w\", \"ściana\"))",
        "ściana",
        "W holu nie ma wyjścia \"w\", więc get zwraca wartość domyślną.",
    ),
    choice(
        "Która instrukcja kończy pętlę gry po komendzie „koniec”?",
        listOf("break", "continue", "pass", "else"),
        0,
        "break natychmiast przerywa pętlę.",
    ),
)
