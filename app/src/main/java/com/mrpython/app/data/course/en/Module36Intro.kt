package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

internal val module36Intro = lesson(
    "u36l0", "Introduction: the bank account project",
    explain(
        "What this project is about",
        "In this module you'll build an `Account` class step by step: deposits, withdrawals with validation, " +
            "a transaction history, transfers and a nice account description. You'll use everything you've learned about classes.",
        code = "class Account:\n    def __init__(self, owner):\n        self.owner = owner\n        self.balance = 0\n\na = Account(\"Amy\")\nprint(a.owner, a.balance)",
        output = "Amy 0",
    ),
    explain(
        "State and methods",
        "We set the account's state (the balance) in `__init__` and change it with methods such as `deposit()`. " +
            "Every object has its own state, so two accounts never mix up their money.",
        code = "class Account:\n    def __init__(self):\n        self.balance = 0\n    def deposit(self, amount):\n        self.balance += amount\n\na = Account()\na.deposit(100)\na.deposit(50)\nprint(a.balance)",
        output = "150",
    ),
    explain(
        "Validation with exceptions",
        "A method should reject bad data: a negative deposit or a withdrawal larger than the balance. " +
            "Instead of just calling `print`, raise an exception – the calling code decides what to do with it.",
        code = "class Account:\n    def __init__(self, balance):\n        self.balance = balance\n    def withdraw(self, amount):\n        if amount > self.balance:\n            raise ValueError(\"not enough\")\n        self.balance -= amount\n\ntry:\n    Account(10).withdraw(50)\nexcept ValueError as e:\n    print(e)",
        output = "not enough",
    ),
    explain(
        "History and transfers",
        "We create the history list in `__init__` so every account has its own, and we add tuples to it " +
            "with `append()`. A transfer is a method that receives another `Account` object and changes both balances.",
        code = "class Account:\n    def __init__(self, balance):\n        self.balance = balance\n    def transfer(self, target, amount):\n        self.balance -= amount\n        target.balance += amount\n\na, b = Account(100), Account(0)\na.transfer(b, 30)\nprint(a.balance, b.balance)",
        output = "70 30",
    ),
    explain(
        "Tip: __str__",
        "Finally we'll add `__str__` so that `print(account)` shows a readable description. The `:.2f` format " +
            "prints the amount with two decimal places.",
        code = "class Account:\n    def __init__(self, balance):\n        self.balance = balance\n    def __str__(self):\n        return f\"Balance: \${self.balance:.2f}\"\n\nprint(Account(99.5))",
        output = "Balance: \$99.50",
    ),
    fill(
        "Fill in the blank so a withdrawal lowers the balance (prints 60).",
        "class Account:\n    def __init__(self):\n        self.balance = 100\n    def withdraw(self, amount):\n        self.balance ____ amount\n\na = Account()\na.withdraw(40)\nprint(a.balance)",
        listOf("-=", "+=", "="),
        "-=",
        "-= subtracts the amount from the current balance.",
    ),
    choice(
        "Where is the best place to create the account's transaction history list?",
        listOf("In the __init__ method", "As a class attribute", "In the __str__ method", "As a global variable"),
        0,
        "A list created in __init__ with self.history = [] belongs to one account, so every account has its own history.",
    ),
)
