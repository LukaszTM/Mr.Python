package com.mrpython.app.data.course

internal val module8Cards = listOf(
    cards(
        "u8l1",
        explain(
            "Pusty słownik i len()",
            "Puste klamry `{}` tworzą pusty słownik, do którego później dodajesz pary. `len()` podaje, " +
                "ile par zawiera słownik.",
            code = "d = {}\nd[\"x\"] = 1\nd[\"y\"] = 2\nprint(len(d))",
            output = "2",
        ),
        explain(
            "Słownik nie ma indeksów",
            "Słownik nie ma numerów pozycji – w `d[...]` zawsze podajesz klucz. Kluczem może być też liczba, " +
                "ale `d[0]` szuka klucza 0, a nie pierwszej pary.",
            code = "dni = {1: \"pon\", 2: \"wt\"}\nprint(dni[1])",
            output = "pon",
        ),
    ),
    cards(
        "u8l2",
        explain(
            "get() bez domyślnej",
            "Gdy nie podasz drugiego argumentu, `get()` dla brakującego klucza zwraca `None`. Uwaga: `del` " +
                "z brakującym kluczem kończy się błędem `KeyError`.",
            code = "d = {\"a\": 1}\nprint(d.get(\"a\"))\nprint(d.get(\"z\"))",
            output = "1\nNone",
        ),
        explain(
            "in sprawdza klucze",
            "`in` szuka tylko wśród kluczy słownika, nie wśród wartości.",
            code = "d = {\"a\": 1}\nprint(\"a\" in d)\nprint(1 in d)",
            output = "True\nFalse",
        ),
        explain(
            "Klucze jako lista",
            "`keys()` i `values()` dają specjalne „widoki” słownika. `list()` zamienia je na zwykłą listę. " +
                "Można je też podać do `sum()` albo `sorted()`.",
            code = "d = {\"b\": 2, \"a\": 5}\nprint(list(d.keys()))\nprint(sum(d.values()))\nprint(sorted(d.keys()))",
            output = "['b', 'a']\n7\n['a', 'b']",
        ),
    ),
    cards(
        "u8l3",
        explain(
            "Wartość w pętli po kluczach",
            "Pętla `for k in d` daje klucze. Wartość dla danego klucza odczytasz w środku pętli przez `d[k]`.",
            code = "d = {\"x\": 3, \"y\": 4}\nfor k in d:\n    print(k, d[k])",
            output = "x 3\ny 4",
        ),
        explain(
            "Liczenie wystąpień",
            "Zapis `d[z] = d.get(z, 0) + 1` bierze dotychczasowy licznik (albo 0, gdy klucza jeszcze nie ma), " +
                "dodaje 1 i zapisuje wynik z powrotem pod tym samym kluczem.",
            code = "d = {}\nfor z in \"oko\":\n    d[z] = d.get(z, 0) + 1\nprint(d)",
            output = "{'o': 2, 'k': 1}",
        ),
    ),
    cards(
        "u8l4",
        explain(
            "Lista w słowniku",
            "Wartością w słowniku może być lista. `d[\"a\"]` daje wtedy listę, więc możesz dopisać do niej " +
                "element albo sięgnąć po indeks: `d[\"a\"][0]`.",
            code = "d = {\"a\": [1, 2]}\nd[\"a\"].append(3)\nprint(d[\"a\"][2])",
            output = "3",
        ),
        explain(
            "Słownik w f-stringu",
            "Gdy f-string jest w cudzysłowie `\"`, klucz w klamrach zapisz w apostrofach `'`. Taki sam " +
                "cudzysłów zamknąłby napis za wcześnie.",
            code = "o = {\"imie\": \"Ola\"}\nprint(f\"Hej, {o['imie']}!\")",
            output = "Hej, Ola!",
        ),
        explain(
            "Powtórzony klucz",
            "Jeśli w klamrach ten sam klucz pojawi się dwa razy, zostanie tylko ostatnia wartość – " +
                "klucze w słowniku się nie powtarzają.",
            code = "d = {\"x\": 1, \"x\": 9}\nprint(d)",
            output = "{'x': 9}",
        ),
    ),
)
