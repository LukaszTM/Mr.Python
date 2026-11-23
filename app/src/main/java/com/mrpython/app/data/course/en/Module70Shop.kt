package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*
import com.mrpython.app.domain.CourseUnit

internal val module70 = CourseUnit(
    id = "u70",
    title = "Project: online shop",
    description = "Products, a cart, discounts and order validation",
    lessons = listOf(
        lesson(
            "u70l1", "Step 1: a product as a dataclass",
            output(
                "from dataclasses import dataclass\n@dataclass\nclass Product:\n    name: str\n    price: float\np = Product(\"Mug\", 19.99)\nprint(p)",
                "Product(name='Mug', price=19.99)",
                "@dataclass creates __init__ and a readable __repr__ for you.",
            ),
            output(
                "from dataclasses import dataclass\n@dataclass\nclass Product:\n    name: str\n    price: float\np = Product(\"Plate\", 12.5)\nprint(p.name, p.price)",
                "Plate 12.5",
                "Dataclass fields are ordinary object attributes.",
            ),
            fill(
                "Add a quantity field with a default value of 1.",
                "from dataclasses import dataclass\n@dataclass\nclass Product:\n    name: str\n    quantity: int ____ 1\nprint(Product(\"Mug\"))",
                listOf("=", ":", "=="),
                "=",
                "A field's default value goes after the = sign.",
            ),
            output(
                "from dataclasses import dataclass\n@dataclass\nclass Product:\n    name: str\n    price: float\na = Product(\"Mug\", 5)\nb = Product(\"Mug\", 5)\nprint(a == b, a is b)",
                "True False",
                "A dataclass compares fields (==), but these are still two separate objects.",
            ),
            choice(
                "What does @dataclass create automatically?",
                listOf("__init__, __repr__ and __eq__", "Only __init__", "A product database", "Methods for saving to a file"),
                0,
                "That's why a data class takes just a few lines of code.",
            ),
            output(
                "from dataclasses import dataclass\n@dataclass(frozen=True)\nclass Product:\n    name: str\np = Product(\"Mug\")\ntry:\n    p.name = \"Plate\"\nexcept AttributeError:\n    print(\"No changes allowed!\")",
                "No changes allowed!",
                "frozen=True blocks changing fields after the object is created.",
            ),
            tiles(
                "Add a price field of type float with a default value of 0.0",
                listOf("price", ":", "float", "=", "0.0"),
                listOf("==", "->"),
                "A dataclass field: name: type = default value.",
            ),
            output(
                "from dataclasses import dataclass\n@dataclass\nclass Product:\n    name: str\n    price: float\nitems = [Product(\"Mouse\", 50),\n         Product(\"Cable\", 9)]\ncheap = min(items, key=lambda p: p.price)\nprint(cheap.name)",
                "Cable",
                "key=lambda p: p.price compares products by price.",
            ),
        ),
        lesson(
            "u70l2", "Step 2: the cart",
            output(
                "class Cart:\n    def __init__(self):\n        self.items = {}\n    def add(self, name, qty=1):\n        n = self.items.get(name, 0)\n        self.items[name] = n + qty\nc = Cart()\nc.add(\"mug\"); c.add(\"mug\", 2)\nprint(c.items)",
                "{'mug': 3}",
                "The same product increases the quantity instead of creating a new entry.",
            ),
            fill(
                "Remove an item from the cart.",
                "items = {\"mug\": 2, \"plate\": 1}\nitems.____(\"plate\", None)\nprint(items)",
                listOf("pop", "get", "remove"),
                "pop",
                "pop() removes a key from the dictionary; get() only reads.",
            ),
            output(
                "def remove(items, name, qty=1):\n    items[name] -= qty\n    if items[name] <= 0:\n        del items[name]\np = {\"mug\": 2, \"plate\": 1}\nremove(p, \"plate\")\nremove(p, \"mug\")\nprint(p)",
                "{'mug': 1}",
                "When the quantity drops to zero, the item disappears from the cart.",
            ),
            choice(
                "Why is the cart a name → quantity dictionary rather than a list of products?",
                listOf("It's easy to increase a quantity and quick to find an item by name", "Because lists can't store strings", "Because a dictionary always sorts products by price", "Because lists have no append() method"),
                0,
                "A dictionary gives fast access by key and a place for the quantity.",
            ),
            output(
                "items = {\"mug\": 3, \"plate\": 1}\nprint(len(items), sum(items.values()))",
                "2 4",
                "len() is the number of entries; the sum of the values is the number of units.",
            ),
            tiles(
                "Add 2 mugs to the cart c",
                listOf("c.add(", "\"mug\",", "qty=2", ")"),
                listOf("c.append(", "qty==2"),
                "The keyword argument qty=2 says how many units to add.",
            ),
            output(
                "class Cart:\n    def __init__(self):\n        self.items = {\"mug\": 2, \"map\": 1}\n    def __len__(self):\n        return sum(self.items.values())\nprint(len(Cart()))",
                "3",
                "__len__ lets you use len() on our cart.",
            ),
            output(
                "from collections import Counter\nc = Counter()\nc[\"mug\"] += 2\nc[\"spoon\"] += 1\nc[\"mug\"] -= 1\nprint(c[\"mug\"], sum(c.values()))",
                "1 2",
                "A Counter also works well as a cart.",
            ),
        ),
        lesson(
            "u70l3", "Step 3: totals and discounts",
            output(
                "print(0.1 + 0.2)\nprint(round(0.1 + 0.2, 2))",
                "0.30000000000000004\n0.3",
                "Floats can be inexact, which is why we round amounts of money.",
            ),
            output(
                "from decimal import Decimal\nprint(Decimal(\"0.1\") + Decimal(\"0.2\"))",
                "0.3",
                "Decimal calculates exactly like a calculator – perfect for money.",
            ),
            choice(
                "Why do we write Decimal(\"19.99\") and not Decimal(19.99)?",
                listOf("The float 19.99 is already inexact, while the string keeps the exact value", "Decimal doesn't accept numbers", "A string is faster", "There's no difference"),
                0,
                "Decimal(19.99) would copy the float's rounding error.",
            ),
            output(
                "from decimal import Decimal\nPRICES = {\"mug\": Decimal(\"19.99\"),\n          \"plate\": Decimal(\"12.50\")}\ncart = {\"mug\": 2, \"plate\": 1}\ntotal = sum(PRICES[n] * q\n            for n, q in cart.items())\nprint(total)",
                "52.48",
                "2 × 19.99 + 12.50 = 52.48 – with no rounding errors.",
            ),
            output(
                "from decimal import Decimal\ntotal = Decimal(\"52.48\")\ndiscount = total * Decimal(\"0.10\")\ncent = Decimal(\"0.01\")\nprint(discount.quantize(cent))\nprint((total - discount).quantize(cent))",
                "5.25\n47.23",
                "quantize() rounds the amount to cents.",
            ),
            fill(
                "Round the amount to cents.",
                "from decimal import Decimal\namount = Decimal(\"7.456\")\nprint(amount.quantize(Decimal(____)))",
                listOf("\"0.01\"", "\"0.1\"", "\"1\""),
                "\"0.01\"",
                "The pattern 0.01 means two decimal places.",
            ),
            tiles(
                "Calculate the price after a 20% discount",
                listOf("final_price", "=", "price", "*", "Decimal(\"0.8\")"),
                listOf("+", "Decimal(\"0.2\")"),
                "After a 20% discount you pay 80% of the price, so we multiply by 0.8.",
            ),
            output(
                "def discount(total):\n    if total >= 100:\n        return round(total * 0.9, 2)\n    return total\nprint(discount(50))\nprint(discount(120))",
                "50\n108.0",
                "The 10% discount only applies from \$100 up.",
            ),
        ),
        lesson(
            "u70l4", "Step 4: order summary",
            output(
                "price = 19.9\nprint(f\"\${price:.2f}\")",
                "\$19.90",
                ":.2f always shows two decimal places.",
            ),
            output(
                "cart = [(\"Mug\", 2, 10.0),\n        (\"Plate\", 1, 7.5)]\nfor name, qty, price in cart:\n    print(f\"{name} x{qty}: {qty*price:.2f}\")",
                "Mug x2: 20.00\nPlate x1: 7.50",
                "Each item is a tuple that we unpack in the loop.",
            ),
            output(
                "cart = [(\"Mug\", 2, 10.0),\n        (\"Plate\", 1, 7.5)]\ntotal = sum(q * p for _, q, p in cart)\nprint(f\"Total: \${total:.2f}\")",
                "Total: \$27.50",
                "The total is quantity × price for every item.",
            ),
            fill(
                "Print the price with exactly two decimal places.",
                "price = 19.99\nprint(f\"{price:____}\")",
                listOf(".2f", ".2", "2f"),
                ".2f",
                ".2f is the floating-point format with two decimal places.",
            ),
            choice(
                "What does :>8 mean in f\"{name:>8}\"?",
                listOf("Right-align in a field 8 characters wide", "The first 8 letters of the name", "The name repeated 8 times", "A number greater than 8"),
                0,
                "> aligns to the right, and 8 is the field width.",
            ),
            output(
                "print(f\"{1234567.5:,.2f}\")",
                "1,234,567.50",
                "The comma in the format separates thousands.",
            ),
            tiles(
                "Join the receipt lines and print them, each on its own line",
                listOf("print(", "\"\\n\".join(", "lines", "))"),
                listOf("lines.join(", "split("),
                "\"\\n\".join() glues the lines together with a newline character.",
            ),
            output(
                "def receipt(items):\n    lines = [f\"{n}: {p:.2f}\" for n, p in items]\n    lines.append(\"-\" * 10)\n    total = sum(p for _, p in items)\n    lines.append(f\"Total: {total:.2f}\")\n    return \"\\n\".join(lines)\nprint(receipt([(\"A\", 2.5), (\"B\", 1)]))",
                "A: 2.50\nB: 1.00\n----------\nTotal: 3.50",
                "The function builds the whole receipt as a single string.",
            ),
        ),
        lesson(
            "u70l5", "Project: validation and the whole shop",
            output(
                "class OutOfStock(Exception):\n    pass\ntry:\n    raise OutOfStock(\"mug\")\nexcept OutOfStock as e:\n    print(\"Out of stock:\", e)",
                "Out of stock: mug",
                "A custom exception is a class that inherits from Exception.",
            ),
            output(
                "class BadQuantity(ValueError):\n    pass\ndef add(cart, name, qty):\n    if qty <= 0:\n        raise BadQuantity(f\"bad quantity: {qty}\")\n    cart[name] = qty\nc = {}\ntry:\n    add(c, \"mug\", 2); add(c, \"spoon\", 0)\nexcept ValueError as e:\n    print(e, c)",
                "bad quantity: 0 {'mug': 2}",
                "A bad quantity stops the add before it can break the cart.",
            ),
            fill(
                "Create the shop's own exception.",
                "class ShopError(____):\n    pass\ntry:\n    raise ShopError(\"empty cart\")\nexcept ShopError as e:\n    print(e)",
                listOf("Exception", "object", "str"),
                "Exception",
                "You can only raise classes that inherit from Exception.",
            ),
            choice(
                "Why does except ValueError catch the BadQuantity exception?",
                listOf("Because BadQuantity inherits from ValueError", "Because except catches all exceptions", "Because the names look similar", "It won't catch it"),
                0,
                "except catches the given class and all of its subclasses.",
            ),
            output(
                "STOCK = {\"mug\": 1}\nclass OutOfStock(Exception): pass\ndef order(n):\n    if STOCK.get(n, 0) < 1:\n        raise OutOfStock(n)\n    STOCK[n] -= 1\n    return \"OK\"\nfor n in [\"mug\", \"mug\"]:\n    try: print(order(n))\n    except OutOfStock as e: print(\"No\", e)",
                "OK\nNo mug",
                "The second order fails because the stock is empty.",
            ),
            tiles(
                "Raise the custom OutOfStock exception with the message \"mug\"",
                listOf("raise", "OutOfStock(", "\"mug\"", ")"),
                listOf("throw", "except"),
                "In Python you raise an exception with the raise keyword.",
            ),
            output(
                "from dataclasses import dataclass\n@dataclass\nclass Product:\n    name: str\n    price: float\nmug = Product(\"Mug\", 20)\nc = [mug, mug, Product(\"Map\", 5)]\ntotal = sum(p.price for p in c)\nprint(f\"{len(c)} items, \${total:.2f}\")",
                "3 items, \$45.00",
                "Products as dataclasses, the cart as a list and the summary in an f-string.",
            ),
            choice(
                "Where is the best place to check that a quantity is valid?",
                listOf("In the method that adds to the cart, before it changes the cart's state", "Only when printing the receipt", "In the exception class", "Nowhere – bad data will fix itself"),
                0,
                "Validating at the entry point protects the cart from bad data.",
            ),
        ),
    ),
)
