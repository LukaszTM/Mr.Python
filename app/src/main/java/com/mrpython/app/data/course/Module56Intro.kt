package com.mrpython.app.data.course

internal val module56Intro = lesson(
    "u56l0", "Wprowadzenie: projekt lista zadań",
    explain(
        "Cel projektu",
        "Zbudujesz listę zadań: dodawanie, odhaczanie, usuwanie i filtrowanie, a potem klasę `Zadanie` " +
            "i zapis do JSON. To powtórka list, słowników i klas w jednym, prawdziwym programie.",
    ),
    explain(
        "Zadanie jako słownik",
        "Każde zadanie to słownik z kluczami `tytul` i `zrobione`, a wszystkie zadania trzymamy " +
            "w liście. Do pola dostajemy się przez `zadania[i][\"tytul\"]`.",
        code = "zadania = [\n    {\"tytul\": \"Zakupy\", \"zrobione\": False},\n    {\"tytul\": \"Pranie\", \"zrobione\": True},\n]\nprint(len(zadania), zadania[1][\"tytul\"])",
        output = "2 Pranie",
    ),
    explain(
        "Zmiany i filtrowanie",
        "Nowe zadanie dodaje `append()`, odhaczamy je, ustawiając `zrobione` na `True`, a usuwamy " +
            "przez `pop(i)`. Wyrażenie listowe z `if` wybiera tylko pasujące zadania.",
        code = "zadania = [{\"tytul\": \"A\", \"zrobione\": False},\n           {\"tytul\": \"B\", \"zrobione\": False}]\nzadania[0][\"zrobione\"] = True\nreszta = [z[\"tytul\"] for z in zadania\n          if not z[\"zrobione\"]]\nprint(reszta)",
        output = "['B']",
    ),
    explain(
        "Klasa Zadanie",
        "Klasa łączy dane i zachowanie: `__init__` ustawia atrybuty, metoda taka jak `zakoncz()` " +
            "zmienia stan, a `__str__` decyduje, jak obiekt wygląda w `print()`.",
        code = "class Zadanie:\n    def __init__(self, tytul):\n        self.tytul = tytul\n    def __str__(self):\n        return \"[ ] \" + self.tytul\nprint(Zadanie(\"Nauka\"))",
        output = "[ ] Nauka",
    ),
    explain(
        "Zapis w JSON",
        "Moduł `json` zamienia listę słowników na tekst (`json.dumps`) i z powrotem (`json.loads`). " +
            "Uwaga: w JSON `True` zapisuje się jako `true`.",
        code = "import json\n\ntekst = json.dumps([{\"zrobione\": True}])\nprint(tekst)\nprint(json.loads(tekst)[0][\"zrobione\"])",
        output = "[{\"zrobione\": true}]\nTrue",
    ),
    output(
        "z = {\"tytul\": \"Nauka\", \"zrobione\": False}\nz[\"zrobione\"] = True\nprint(z[\"zrobione\"])",
        "True",
        "Odhaczenie to po prostu zmiana wartości w słowniku.",
    ),
    choice(
        "Która funkcja zamienia listę zadań na tekst w formacie JSON?",
        listOf("json.dumps", "json.loads", "json.text", "str.json"),
        0,
        "dumps tworzy tekst, a loads odczytuje go z powrotem.",
    ),
    tiles(
        "Dodaj do listy zadania nowe zadanie z.",
        listOf("zadania.append(", "z", ")"),
        listOf("zadania.pop(", "add("),
        "append dopisuje element na koniec listy.",
    ),
)
