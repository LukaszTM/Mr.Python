package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

internal val module36Cards = listOf(
    cards(
        "u36l4",
        explain(
            "Check first, then change",
            "A transfer should first check the balance (e.g. by calling `self.withdraw(x)`) and only then " +
                "add the money to the target. If the withdrawal raises an exception, the method stops and no balance changes.",
            code = "class Account:\n    def __init__(self, b):\n        self.balance = b\n    def transfer(self, target, x):\n        if x <= self.balance:\n            self.balance -= x\n            target.balance += x\na, b = Account(20), Account(0)\na.transfer(b, 50)\nprint(a.balance, b.balance)",
            output = "20 0",
        ),
    ),
)
