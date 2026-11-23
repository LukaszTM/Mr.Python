package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*
import com.mrpython.app.domain.CourseUnit

internal val module36 = CourseUnit(
    id = "u36",
    title = "OOP project: bank account",
    description = "We build an Account class step by step",
    lessons = listOf(
        lesson(
            "u36l1", "The Account class and deposits",
            output(
                "class Account:\n    def __init__(self, owner):\n        self.owner = owner\n        self.balance = 0\n\na = Account(\"Amy\")\nprint(a.owner, a.balance)",
                "Amy 0",
                "A new account has an owner and a zero balance.",
            ),
            output(
                "class Account:\n    def __init__(self, owner):\n        self.owner = owner\n        self.balance = 0\n    def deposit(self, amount):\n        self.balance += amount\n\na = Account(\"Amy\")\na.deposit(100)\na.deposit(50)\nprint(a.balance)",
                "150",
                "Every deposit increases the balance.",
            ),
            fill(
                "Fill in the blank so a deposit increases the balance (prints 150).",
                "class Account:\n    def __init__(self):\n        self.balance = 100\n    def deposit(self, amount):\n        self.balance ____ amount\n\na = Account()\na.deposit(50)\nprint(a.balance)",
                listOf("+=", "=", "-="),
                "+=",
                "+= adds the amount to the current balance.",
            ),
            choice(
                "Where is the best place to set an account's starting balance?",
                listOf("In the __init__ method", "In the deposit method", "As a global variable", "In the __str__ method"),
                0,
                "__init__ prepares the state of every new object, e.g. self.balance = 0.",
            ),
            output(
                "class Account:\n    def __init__(self, balance=0):\n        self.balance = balance\n\nprint(Account().balance, Account(200).balance)",
                "0 200",
                "A parameter with a default value lets you open an account with or without a balance.",
            ),
            output(
                "class Account:\n    def __init__(self):\n        self.balance = 0\n    def deposit(self, amount):\n        self.balance += amount\n        return self.balance\n\na = Account()\nprint(a.deposit(30), a.deposit(20))",
                "30 50",
                "The method returns the balance after each deposit.",
            ),
            tiles(
                "Deposit 100 into account a",
                listOf("a.deposit(", "100", ")"),
                listOf("a.balance(", "deposit(a,"),
                "We call a method on the object: a.deposit(100).",
            ),
            choice(
                "What's the problem with a deposit method that checks nothing?",
                listOf("You can deposit a negative amount", "You can't deposit twice", "The balance always stays 0", "There is no problem"),
                0,
                "A negative \"deposit\" would lower the balance. That's why we'll add validation in the next lesson.",
            ),
        ),
        lesson(
            "u36l2", "Withdrawals and validation",
            output(
                "class Account:\n    def __init__(self, balance):\n        self.balance = balance\n    def withdraw(self, amount):\n        if amount > self.balance:\n            print(\"Insufficient funds\")\n            return\n        self.balance -= amount\n\na = Account(100)\na.withdraw(150)\na.withdraw(30)\nprint(a.balance)",
                "Insufficient funds\n70",
                "A withdrawal that is too large is rejected, and a valid one lowers the balance.",
            ),
            fill(
                "Fill in the blank so you can't withdraw more than the balance (prints 60).",
                "class Account:\n    def __init__(self, balance):\n        self.balance = balance\n    def withdraw(self, amount):\n        if amount ____ self.balance:\n            raise ValueError(\"not enough\")\n        self.balance -= amount\n\na = Account(100)\na.withdraw(40)\nprint(a.balance)",
                listOf(">", "<", "<="),
                ">",
                "We raise the error only when the amount is greater than the balance.",
            ),
            output(
                "class InsufficientFunds(Exception): pass\n\nclass Account:\n    def __init__(self, balance):\n        self.balance = balance\n    def withdraw(self, amount):\n        if amount > self.balance:\n            raise InsufficientFunds(\"not enough\")\n        self.balance -= amount\n\ntry:\n    Account(10).withdraw(50)\nexcept InsufficientFunds as e:\n    print(e)",
                "not enough",
                "The account raises its own exception, InsufficientFunds.",
            ),
            choice(
                "Which built-in exception fits a deposit of a negative amount?",
                listOf("ValueError", "KeyError", "IndexError", "NameError"),
                0,
                "The right type but an unacceptable value – that's a ValueError.",
            ),
            output(
                "class Account:\n    def __init__(self):\n        self.balance = 0\n    def deposit(self, amount):\n        if amount <= 0:\n            raise ValueError(\"bad amount\")\n        self.balance += amount\n\na = Account()\na.deposit(20)\nprint(a.balance)",
                "20",
                "A positive amount passes validation.",
            ),
            choice(
                "What happens when you run this code?",
                listOf("ValueError: bad amount", "The balance will be 0, with no error", "The balance will be -1", "SyntaxError"),
                0,
                "For an amount of 0 the condition amount <= 0 is true, so deposit raises an error.",
                code = "class Account:\n    def __init__(self):\n        self.balance = 0\n    def deposit(self, amount):\n        if amount <= 0:\n            raise ValueError(\"bad amount\")\n        self.balance += amount\n\nAccount().deposit(0)",
            ),
            tiles(
                "Subtract the amount from the balance inside the withdraw method",
                listOf("self.balance", "-=", "amount"),
                listOf("+=", "self.amount"),
                "A withdrawal lowers self.balance by the amount.",
            ),
            choice(
                "Why is it better to raise an exception than to just print \"Insufficient funds\"?",
                listOf("The calling code decides how to handle it", "Exceptions are faster than print", "print doesn't work in methods", "Because then the balance fixes itself"),
                0,
                "An exception tells the calling code that the operation failed, and that code can catch it with try and handle it its own way.",
            ),
        ),
        lesson(
            "u36l3", "Transaction history",
            output(
                "class Account:\n    def __init__(self):\n        self.balance = 0\n        self.history = []\n    def deposit(self, amount):\n        self.balance += amount\n        self.history.append((\"deposit\", amount))\n\na = Account()\na.deposit(100)\nprint(a.history)",
                "[('deposit', 100)]",
                "Every transaction saves a tuple in the history list.",
            ),
            choice(
                "Why do we create history = [] in __init__ and not as a class attribute?",
                listOf("All accounts would share one list", "Class attributes can't be lists", "A list works faster in __init__", "It makes no difference"),
                0,
                "A list in a class attribute is a single list shared by all objects, but every account needs its own history.",
            ),
            fill(
                "Fill in the blank to save the transaction in the history.",
                "class Account:\n    def __init__(self):\n        self.history = []\n    def deposit(self, amount):\n        self.history.____(amount)\n\na = Account()\na.deposit(10)\na.deposit(5)\nprint(a.history)",
                listOf("append", "add", "push"),
                "append",
                "We add items to a list with the append method.",
            ),
            output(
                "class Account:\n    def __init__(self):\n        self.history = []\n    def change(self, x):\n        self.history.append(x)\n    @property\n    def balance(self):\n        return sum(self.history)\n\na = Account()\na.change(100)\na.change(-30)\nprint(a.balance, a.history)",
                "70 [100, -30]",
                "The balance can be computed from the history with a property.",
            ),
            output(
                "class Account:\n    def __init__(self):\n        self.history = [(\"deposit\", 100),\n                        (\"withdrawal\", 40)]\n    def statement(self):\n        for kind, amount in self.history:\n            print(f\"{kind}: {amount}\")\n\nAccount().statement()",
                "deposit: 100\nwithdrawal: 40",
                "The statement method unpacks the tuples from the history.",
            ),
            output(
                "history = [100, -30, 50, -20]\nwithdrawals = [x for x in history if x < 0]\nprint(len(withdrawals), sum(withdrawals))",
                "2 -50",
                "The list comprehension picks only the withdrawals from the history.",
            ),
            tiles(
                "Add the tuple (\"deposit\", amount) to the history",
                listOf("self.history.append(", "(\"deposit\", amount)", ")"),
                listOf("add(", "push("),
                "append adds one tuple to the end of the list.",
            ),
            choice(
                "An account has an empty history. How many items will it hold after two deposits and one withdrawal?",
                listOf("3", "2", "1", "0"),
                0,
                "Every transaction adds one entry.",
            ),
        ),
        lesson(
            "u36l4", "Transfers between accounts",
            output(
                "class Account:\n    def __init__(self, balance):\n        self.balance = balance\n    def transfer(self, target, amount):\n        self.balance -= amount\n        target.balance += amount\n\na = Account(100)\nb = Account(0)\na.transfer(b, 30)\nprint(a.balance, b.balance)",
                "70 30",
                "A transfer lowers the balance of one account and raises the other's.",
            ),
            choice(
                "What do we pass to the transfer method as target?",
                listOf("Another object of the Account class", "The account number as a string", "The amount", "The Account class"),
                0,
                "A method can take other objects and change their attributes.",
            ),
            choice(
                "What happens when you run this code?",
                listOf("ValueError, and the balances don't change", "b gets 80 and a ends up with -30", "b gets 50", "Nothing – the transfer is skipped"),
                0,
                "withdraw raises an error before it changes anything, so the transfer doesn't happen.",
                code = "class Account:\n    def __init__(self, balance):\n        self.balance = balance\n    def withdraw(self, x):\n        if x > self.balance:\n            raise ValueError(\"insufficient funds\")\n        self.balance -= x\n    def transfer(self, target, x):\n        self.withdraw(x)\n        target.balance += x\n\nAccount(50).transfer(Account(0), 80)",
            ),
            fill(
                "Fill in the blank so the transfer uses the target account's deposit method (prints 5 15).",
                "class Account:\n    def __init__(self, balance):\n        self.balance = balance\n    def deposit(self, x):\n        self.balance += x\n    def transfer(self, target, x):\n        self.balance -= x\n        target.____(x)\n\na, b = Account(10), Account(10)\na.transfer(b, 5)\nprint(a.balance, b.balance)",
                listOf("deposit", "balance", "transfer"),
                "deposit",
                "The transfer uses the other account's ready-made deposit method.",
            ),
            output(
                "class Account:\n    def __init__(self, balance):\n        self.balance = balance\n    def transfer(self, target, x):\n        self.balance -= x\n        target.balance += x\n\na, b, c = Account(100), Account(0), Account(0)\na.transfer(b, 60)\nb.transfer(c, 20)\nprint(a.balance, b.balance, c.balance)",
                "40 40 20",
                "The money goes from a to b, and then part of it from b to c.",
            ),
            choice(
                "Why does transfer call self.withdraw(x) first?",
                listOf("To use the same balance validation", "Because otherwise Python raises a SyntaxError", "To withdraw the money twice", "For no reason"),
                0,
                "Reusing the withdraw method keeps the rules in one place.",
            ),
            tiles(
                "Transfer 50 from account a to account b",
                listOf("a.transfer(", "b,", "50", ")"),
                listOf("b.transfer(", "a,"),
                "We call the method on the source account and pass the target as an argument.",
            ),
            output(
                "class Account:\n    def __init__(self, balance):\n        self.balance = balance\n    def transfer(self, target, x):\n        if x <= self.balance:\n            self.balance -= x\n            target.balance += x\n\na, b = Account(20), Account(0)\na.transfer(b, 50)\nprint(a.balance, b.balance)",
                "20 0",
                "The amount is greater than the balance, so the transfer didn't happen.",
            ),
        ),
        lesson(
            "u36l5", "Project: wrap-up",
            output(
                "class Account:\n    def __init__(self, owner, balance):\n        self.owner = owner\n        self.balance = balance\n    def __str__(self):\n        return f\"{self.owner}: \${self.balance}\"\n\nprint(Account(\"Amy\", 120))",
                "Amy: \$120",
                "__str__ gives print a readable description of the account.",
            ),
            output(
                "class Account:\n    def __init__(self):\n        self.history = [100, -40, 25]\n    def summary(self):\n        dep = sum(x for x in self.history if x > 0)\n        wd = -sum(x for x in self.history if x < 0)\n        return f\"deposits {dep}, withdrawals {wd}\"\n\nprint(Account().summary())",
                "deposits 125, withdrawals 40",
                "The summary adds up deposits and withdrawals from the history separately.",
            ),
            fill(
                "Fill in the blank so print(a) prints \"Account Amy\".",
                "class Account:\n    def __init__(self, owner):\n        self.owner = owner\n    def ____(self):\n        return f\"Account {self.owner}\"\n\na = Account(\"Amy\")\nprint(a)",
                listOf("__str__", "__len__", "__eq__"),
                "__str__",
                "print uses __str__.",
            ),
            output(
                "class Account:\n    def __init__(self, balance):\n        self.balance = balance\n    def __str__(self):\n        return f\"Balance: \${self.balance:.2f}\"\n\nprint(Account(99.5))",
                "Balance: \$99.50",
                "The .2f format shows the amount with two decimal places.",
            ),
            output(
                "class Account:\n    def __init__(self, owner, balance):\n        self.owner = owner\n        self.balance = balance\n\naccounts = [Account(\"Lily\", 50), Account(\"John\", 200)]\ntop = max(accounts, key=lambda a: a.balance)\nprint(top.owner)",
                "John",
                "max with key picks the account with the highest balance.",
            ),
            choice(
                "Which method should you add so accounts can be compared with < by balance?",
                listOf("__lt__", "__str__", "__len__", "__add__"),
                0,
                "The < operator calls __lt__.",
            ),
            output(
                "class Account:\n    def __init__(self, balance):\n        self.balance = balance\n\naccounts = [Account(50), Account(200), Account(30)]\nprint(sum(a.balance for a in accounts))",
                "280",
                "The sum of the balances of all accounts in the bank.",
            ),
            tiles(
                "Write the header of the method that print(account) uses",
                listOf("def", "__str__(", "self", "):"),
                listOf("print(", "return"),
                "print calls __str__, which takes only self.",
            ),
        ),
    ),
)
