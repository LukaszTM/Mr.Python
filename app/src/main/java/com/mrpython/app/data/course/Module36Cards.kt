package com.mrpython.app.data.course

internal val module36Cards = listOf(
    cards(
        "u36l4",
        explain(
            "Najpierw sprawdź, potem zmieniaj",
            "Przelew powinien najpierw sprawdzić saldo (np. wywołując `self.wyplac(k)`), a dopiero potem " +
                "dodać pieniądze celowi. Gdy wypłata zgłosi wyjątek, metoda się przerwie i żadne saldo się nie zmieni.",
            code = "class Konto:\n    def __init__(self, s):\n        self.saldo = s\n    def przelej(self, cel, k):\n        if k <= self.saldo:\n            self.saldo -= k\n            cel.saldo += k\na, b = Konto(20), Konto(0)\na.przelej(b, 50)\nprint(a.saldo, b.saldo)",
            output = "20 0",
        ),
    ),
)
