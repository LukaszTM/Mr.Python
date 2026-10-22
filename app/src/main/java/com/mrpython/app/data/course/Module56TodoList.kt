package com.mrpython.app.data.course

import com.mrpython.app.domain.CourseUnit

internal val module56 = CourseUnit(
    id = "u56",
    title = "Projekt: lista zadań",
    description = "Budujemy listę zadań: od słowników do klasy i JSON",
    lessons = listOf(
        lesson(
            "u56l1", "Zadania jako słowniki",
            output(
                "zadanie = {\"tytul\": \"Zakupy\", \"zrobione\": False}\nprint(zadanie[\"tytul\"], zadanie[\"zrobione\"])",
                "Zakupy False",
                "Jedno zadanie to słownik z nazwanymi polami.",
            ),
            output(
                "zadania = [\n    {\"tytul\": \"Zakupy\", \"zrobione\": False},\n    {\"tytul\": \"Pranie\", \"zrobione\": True},\n]\nprint(len(zadania), zadania[1][\"tytul\"])",
                "2 Pranie",
                "Lista przechowuje wiele zadań, a każde z nich jest słownikiem.",
            ),
            choice(
                "Dlaczego każde zadanie zapisujemy jako słownik?",
                listOf("Zadanie ma kilka nazwanych pól, np. tytuł i stan", "Słowniki są zawsze posortowane", "Listy nie mogą zawierać napisów", "Słownik zajmuje mniej pamięci niż napis"),
                0,
                "Klucze takie jak \"tytul\" i \"zrobione\" opisują dane.",
            ),
            fill(
                "Uzupełnij, aby wypisać tytuł pierwszego zadania.",
                "zadania = [{\"tytul\": \"Zakupy\", \"zrobione\": False}]\nprint(zadania[0][____])",
                listOf("\"tytul\"", "tytul", "0"),
                "\"tytul\"",
                "Klucz słownika to napis, więc potrzebny jest cudzysłów.",
            ),
            output(
                "zadania = [{\"tytul\": \"A\", \"zrobione\": True},\n           {\"tytul\": \"B\", \"zrobione\": False}]\nfor z in zadania:\n    znak = \"x\" if z[\"zrobione\"] else \" \"\n    print(f\"[{znak}] {z['tytul']}\")",
                "[x] A\n[ ] B",
                "Wyrażenie warunkowe wybiera znak pola wyboru.",
            ),
            tiles(
                "Utwórz słownik nowego, niezrobionego zadania \"Nauka\".",
                listOf("{", "\"tytul\": \"Nauka\",", "\"zrobione\": False", "}"),
                listOf("\"zrobione\": True", "["),
                "Nowe zadanie zaczyna jako niezrobione.",
            ),
            choice(
                "Jaką strukturą jest zmienna zadania w tym projekcie?",
                listOf("Listą słowników", "Słownikiem list", "Krotką napisów", "Zbiorem słowników"),
                0,
                "Lista trzyma kolejne zadania, a każde jest słownikiem.",
            ),
            output(
                "zadania = [{\"tytul\": \"Zakupy\"}, {\"tytul\": \"Pranie\"}]\nfor i, z in enumerate(zadania, 1):\n    print(i, z[\"tytul\"])",
                "1 Zakupy\n2 Pranie",
                "enumerate(..., 1) numeruje zadania od 1.",
            ),
        ),
        lesson(
            "u56l2", "Dodawanie, odhaczanie, usuwanie",
            output(
                "zadania = []\n\ndef dodaj(tytul):\n    zadania.append({\"tytul\": tytul, \"zrobione\": False})\n\ndodaj(\"Zakupy\")\ndodaj(\"Pranie\")\nprint(len(zadania))",
                "2",
                "Funkcja dodaj dopisuje nowy słownik do listy.",
            ),
            output(
                "zadania = [{\"tytul\": \"Zakupy\", \"zrobione\": False}]\n\ndef zakoncz(i):\n    zadania[i][\"zrobione\"] = True\n\nzakoncz(0)\nprint(zadania[0])",
                "{'tytul': 'Zakupy', 'zrobione': True}",
                "Zmieniamy pole \"zrobione\" w wybranym słowniku.",
            ),
            fill(
                "Uzupełnij, aby oznaczyć zadanie jako zrobione.",
                "zadania = [{\"tytul\": \"A\", \"zrobione\": False}]\nzadania[0][\"zrobione\"] = ____\nprint(zadania[0][\"zrobione\"])",
                listOf("True", "true", "Done"),
                "True",
                "Wartość logiczna prawdy w Pythonie to True z wielkiej litery.",
            ),
            output(
                "zadania = [\"A\", \"B\", \"C\"]\nusuniete = zadania.pop(1)\nprint(usuniete, zadania)",
                "B ['A', 'C']",
                "pop(i) usuwa element o indeksie i i go zwraca.",
            ),
            output(
                "zadania = [{\"tytul\": \"A\"}, {\"tytul\": \"B\"}]\nzadania = [z for z in zadania\n           if z[\"tytul\"] != \"A\"]\nprint(zadania)",
                "[{'tytul': 'B'}]",
                "Usuwanie po tytule: zostawiamy wszystkie zadania o innym tytule.",
            ),
            choice(
                "Co się stanie po uruchomieniu tego kodu?",
                listOf("IndexError – nie ma zadania o indeksie 5", "Usunie ostatnie zadanie", "Zwróci None", "KeyError"),
                0,
                "Lista ma tylko indeksy 0 i 1.",
                code = "zadania = [\"A\", \"B\"]\nzadania.pop(5)",
            ),
            tiles(
                "Usuń pierwsze zadanie z listy instrukcją del.",
                listOf("del", "zadania[0]"),
                listOf("remove", "zadania(0)"),
                "del lista[i] usuwa element o podanym indeksie.",
            ),
            output(
                "zadania = [{\"tytul\": \"A\", \"zrobione\": False}]\n\ndef zakoncz(i):\n    if 0 <= i < len(zadania):\n        zadania[i][\"zrobione\"] = True\n        return \"OK\"\n    return \"Brak zadania\"\n\nprint(zakoncz(3), zakoncz(0))",
                "Brak zadania OK",
                "Sprawdzenie indeksu chroni przed IndexError.",
            ),
        ),
        lesson(
            "u56l3", "Filtrowanie zadań",
            output(
                "zadania = [\n    {\"tytul\": \"A\", \"zrobione\": True},\n    {\"tytul\": \"B\", \"zrobione\": False},\n    {\"tytul\": \"C\", \"zrobione\": False},\n]\nreszta = [z[\"tytul\"] for z in zadania\n          if not z[\"zrobione\"]]\nprint(reszta)",
                "['B', 'C']",
                "Filtrujemy zadania, które nie są jeszcze zrobione.",
            ),
            fill(
                "Uzupełnij warunek, aby wybrać tylko zrobione zadania.",
                "zadania = [{\"tytul\": \"A\", \"zrobione\": True},\n           {\"tytul\": \"B\", \"zrobione\": False}]\ngotowe = [z[\"tytul\"] for z in zadania if ____]\nprint(gotowe)",
                listOf("z[\"zrobione\"]", "not z[\"zrobione\"]", "z[\"tytul\"]"),
                "z[\"zrobione\"]",
                "Pole \"zrobione\" jest już wartością logiczną – wystarczy je sprawdzić.",
            ),
            output(
                "stany = [True, False, True, True]\nprint(sum(stany), \"z\", len(stany))",
                "3 z 4",
                "True liczy się jako 1, więc sum zlicza zrobione zadania.",
            ),
            output(
                "zrobione, wszystkie = 3, 4\nprint(f\"Postęp: {zrobione / wszystkie:.0%}\")",
                "Postęp: 75%",
                "Format :.0% mnoży przez 100 i dodaje znak procentu.",
            ),
            choice(
                "Co zwróci filtr niezrobionych zadań, gdy wszystkie są zrobione?",
                listOf("Pustą listę []", "None", "Błąd", "Całą listę"),
                0,
                "Żaden element nie spełnia warunku, więc lista wynikowa jest pusta.",
            ),
            output(
                "def filtruj(zadania, zrobione):\n    return [z[\"tytul\"] for z in zadania\n            if z[\"zrobione\"] == zrobione]\n\nlista = [{\"tytul\": \"A\", \"zrobione\": True},\n         {\"tytul\": \"B\", \"zrobione\": False}]\nprint(filtruj(lista, True))",
                "['A']",
                "Parametr decyduje, które zadania wybieramy.",
            ),
            tiles(
                "Zbuduj listę niezrobionych zadań.",
                listOf("[z", "for z in zadania", "if not", "z[\"zrobione\"]]"),
                listOf("if", "while"),
                "if not wybiera zadania, które nie są zrobione.",
            ),
            choice(
                "Co sprawdza any(z[\"zrobione\"] for z in zadania)?",
                listOf("Czy choć jedno zadanie jest zrobione", "Czy wszystkie zadania są zrobione", "Ile zadań jest zrobionych", "Czy lista jest pusta"),
                0,
                "any zwraca True, jeśli choć jeden element jest prawdziwy.",
            ),
        ),
        lesson(
            "u56l4", "Klasa Zadanie",
            output(
                "class Zadanie:\n    def __init__(self, tytul):\n        self.tytul = tytul\n        self.zrobione = False\n\nz = Zadanie(\"Zakupy\")\nprint(z.tytul, z.zrobione)",
                "Zakupy False",
                "Pola słownika stają się atrybutami obiektu.",
            ),
            output(
                "class Zadanie:\n    def __init__(self, tytul):\n        self.tytul = tytul\n        self.zrobione = False\n    def zakoncz(self):\n        self.zrobione = True\n\nz = Zadanie(\"Pranie\")\nz.zakoncz()\nprint(z.zrobione)",
                "True",
                "Metoda zakoncz zmienia stan obiektu.",
            ),
            fill(
                "Uzupełnij nazwę metody, aby print wypisał czytelny opis zadania.",
                "class Zadanie:\n    def __init__(self, tytul):\n        self.tytul = tytul\n    def ____(self):\n        return \"Zadanie: \" + self.tytul\n\nprint(Zadanie(\"Nauka\"))",
                listOf("__str__", "__init__", "str"),
                "__str__",
                "print używa metody __str__ obiektu.",
            ),
            output(
                "class Zadanie:\n    def __init__(self, tytul, zrobione=False):\n        self.tytul = tytul\n        self.zrobione = zrobione\n    def __str__(self):\n        znak = \"x\" if self.zrobione else \" \"\n        return f\"[{znak}] {self.tytul}\"\n\nprint(Zadanie(\"A\", True))\nprint(Zadanie(\"B\"))",
                "[x] A\n[ ] B",
                "__str__ decyduje o tym, jak obiekt wygląda po wypisaniu.",
            ),
            choice(
                "Jaka jest główna zaleta klasy Zadanie nad słownikiem?",
                listOf("Dane i zachowanie (metody) są w jednym miejscu", "Klasa zajmuje mniej miejsca", "Słowników nie da się zmieniać", "Klasy nie wymagają __init__"),
                0,
                "Obiekt sam wie, jak się zakończyć i jak się wypisać.",
            ),
            output(
                "class ListaZadan:\n    def __init__(self):\n        self.zadania = []\n    def dodaj(self, tytul):\n        self.zadania.append(tytul)\n    def __len__(self):\n        return len(self.zadania)\n\nlista = ListaZadan()\nlista.dodaj(\"A\")\nlista.dodaj(\"B\")\nprint(len(lista))",
                "2",
                "Metoda __len__ pozwala użyć len na własnym obiekcie.",
            ),
            tiles(
                "Utwórz obiekt zadania \"Zakupy\".",
                listOf("z", "=", "Zadanie(", "\"Zakupy\"", ")"),
                listOf("new", "=="),
                "Obiekt tworzymy, wywołując klasę jak funkcję – bez słowa new.",
            ),
            output(
                "from dataclasses import dataclass\n\n@dataclass\nclass Zadanie:\n    tytul: str\n    zrobione: bool = False\n\nprint(Zadanie(\"Nauka\"))",
                "Zadanie(tytul='Nauka', zrobione=False)",
                "dataclass sam tworzy __init__ i czytelny opis obiektu.",
            ),
        ),
        lesson(
            "u56l5", "Zapis i podsumowanie projektu",
            output(
                "zadania = [{\"tytul\": \"A\", \"zrobione\": True},\n           {\"tytul\": \"B\", \"zrobione\": False}]\nlinie = [f\"{z['tytul']};{z['zrobione']}\"\n         for z in zadania]\nprint(\"\\n\".join(linie))",
                "A;True\nB;False",
                "Każde zadanie zapisujemy jako jedną linię tekstu.",
            ),
            output(
                "linia = \"Zakupy;False\"\ntytul, stan = linia.split(\";\")\nprint(tytul, stan == \"True\")",
                "Zakupy False",
                "Odczytując tekst, zamieniamy napis \"False\" z powrotem na wartość logiczną.",
            ),
            output(
                "import json\n\nzadania = [{\"tytul\": \"A\", \"zrobione\": True}]\nprint(json.dumps(zadania))",
                "[{\"tytul\": \"A\", \"zrobione\": true}]",
                "W JSON wartości logiczne zapisuje się małymi literami.",
            ),
            output(
                "import json\n\ntekst = '[{\"tytul\": \"B\", \"zrobione\": false}]'\nzadania = json.loads(tekst)\nprint(zadania[0][\"zrobione\"])",
                "False",
                "json.loads zamienia tekst JSON z powrotem na listę słowników.",
            ),
            fill(
                "Uzupełnij, aby zamienić listę zadań na napis JSON.",
                "import json\n\nzadania = [{\"tytul\": \"A\", \"zrobione\": False}]\ntekst = json.____(zadania)\nprint(tekst)",
                listOf("dumps", "loads", "dump"),
                "dumps",
                "dumps (dump string) zamienia obiekt na napis JSON.",
            ),
            choice(
                "Dlaczego do zapisu lepiej użyć JSON niż str(zadania)?",
                listOf("JSON to standard, który odczytają też inne programy", "str nie działa dla list", "JSON jest zawsze krótszy", "str zmienia kolejność zadań"),
                0,
                "str daje format Pythona, a JSON jest wspólnym formatem wymiany danych.",
            ),
            tiles(
                "Wczytaj zadania z napisu JSON w zmiennej tekst.",
                listOf("zadania", "=", "json.loads(", "tekst", ")"),
                listOf("json.dumps(", "json.load("),
                "loads wczytuje JSON z napisu, a load – z pliku.",
            ),
            output(
                "import json\n\nclass Zadanie:\n    def __init__(self, tytul):\n        self.tytul = tytul\n        self.zrobione = False\n    def do_slownika(self):\n        return {\"tytul\": self.tytul,\n                \"zrobione\": self.zrobione}\n\nprint(json.dumps(Zadanie(\"C\").do_slownika()))",
                "{\"tytul\": \"C\", \"zrobione\": false}",
                "Obiekt zamieniamy na słownik, a słownik na JSON.",
            ),
        ),
    ),
)
