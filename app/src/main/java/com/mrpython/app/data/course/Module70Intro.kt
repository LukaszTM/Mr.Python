package com.mrpython.app.data.course

internal val module70Intro = lesson(
    "u70l0", "Wprowadzenie: projekt sklepu internetowego",
    explain(
        "Produkt jako dataclass",
        "Budujemy sklep: produkty, koszyk, rabaty i walidację. Produkt to `@dataclass` – " +
            "dostajemy za darmo `__init__`, czytelny wydruk i porównanie `==`.",
        code = "from dataclasses import dataclass\n@dataclass\nclass Produkt:\n    nazwa: str\n    cena: float\nprint(Produkt(\"Kubek\", 19.99))",
        output = "Produkt(nazwa='Kubek', cena=19.99)",
    ),
    explain(
        "Koszyk",
        "Koszyk to słownik nazwa → ilość. `get(nazwa, 0) + ile` dodaje sztuki, a `del` usuwa pozycję, " +
            "gdy ilość spadnie do zera.",
        code = "koszyk = {}\nfor n in [\"kubek\", \"talerz\", \"kubek\"]:\n    koszyk[n] = koszyk.get(n, 0) + 1\nprint(koszyk, sum(koszyk.values()))",
        output = "{'kubek': 2, 'talerz': 1} 3",
    ),
    explain(
        "Sumy i rabaty",
        "Ceny `float` potrafią dać `0.30000000000000004`, dlatego zaokrąglamy przez `round(x, 2)` " +
            "albo liczymy na `Decimal`. Rabat to zwykły warunek.",
        code = "def rabat(suma):\n    if suma >= 100:\n        return round(suma * 0.9, 2)\n    return suma\nprint(rabat(50), rabat(120))",
        output = "50 108.0",
    ),
    explain(
        "Podsumowanie zamówienia",
        "Paragon wypisujemy f-stringami: `:.2f` zawsze pokazuje dwa miejsca po przecinku. " +
            "Krotki rozpakowujemy prosto w pętli.",
        code = "koszyk = [(\"Kubek\", 2, 10.0), (\"Talerz\", 1, 7.5)]\nfor nazwa, ile, cena in koszyk:\n    print(f\"{nazwa} x{ile}: {ile * cena:.2f} zł\")",
        output = "Kubek x2: 20.00 zł\nTalerz x1: 7.50 zł",
    ),
    explain(
        "Walidacja",
        "Błędne zamówienie zgłaszamy własnym wyjątkiem przez `raise`, a wyżej łapiemy go w `try/except`. " +
            "Dzięki temu sklep nie sprzeda czegoś, czego nie ma.",
        code = "class BrakTowaru(Exception):\n    pass\ntry:\n    raise BrakTowaru(\"kubek\")\nexcept BrakTowaru as e:\n    print(\"Brak:\", e)",
        output = "Brak: kubek",
    ),
    output(
        "cena = 19.9\nprint(f\"{cena:.2f} zł\")",
        "19.90 zł",
        ":.2f wypisuje liczbę z dwoma miejscami po przecinku.",
    ),
    choice(
        "Jakim słowem zgłaszamy wyjątek, np. brak towaru?",
        listOf("raise", "except", "throw", "error"),
        0,
        "W Pythonie wyjątek zgłasza się przez raise.",
    ),
)
