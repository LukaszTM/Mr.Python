package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

internal val module70Intro = lesson(
    "u70l0", "Introduction: the online shop project",
    explain(
        "A product as a dataclass",
        "We're building a shop: products, a cart, discounts and validation. A product is a `@dataclass` – " +
            "you get `__init__`, a readable printout and `==` comparison for free.",
        code = "from dataclasses import dataclass\n@dataclass\nclass Product:\n    name: str\n    price: float\nprint(Product(\"Mug\", 19.99))",
        output = "Product(name='Mug', price=19.99)",
    ),
    explain(
        "The cart",
        "The cart is a name → quantity dictionary. `get(name, 0) + qty` adds units, and `del` removes an item " +
            "when its quantity drops to zero.",
        code = "cart = {}\nfor n in [\"mug\", \"plate\", \"mug\"]:\n    cart[n] = cart.get(n, 0) + 1\nprint(cart, sum(cart.values()))",
        output = "{'mug': 2, 'plate': 1} 3",
    ),
    explain(
        "Totals and discounts",
        "`float` prices can produce `0.30000000000000004`, so we round with `round(x, 2)` " +
            "or calculate with `Decimal`. A discount is just an ordinary condition.",
        code = "def discount(total):\n    if total >= 100:\n        return round(total * 0.9, 2)\n    return total\nprint(discount(50), discount(120))",
        output = "50 108.0",
    ),
    explain(
        "Order summary",
        "We print the receipt with f-strings: `:.2f` always shows two decimal places. " +
            "Tuples are unpacked right in the loop.",
        code = "cart = [(\"Mug\", 2, 10.0), (\"Plate\", 1, 7.5)]\nfor name, qty, price in cart:\n    print(f\"{name} x{qty}: \${qty * price:.2f}\")",
        output = "Mug x2: \$20.00\nPlate x1: \$7.50",
    ),
    explain(
        "Validation",
        "We report a bad order with our own exception using `raise`, and catch it higher up in `try/except`. " +
            "That way the shop won't sell something it doesn't have.",
        code = "class OutOfStock(Exception):\n    pass\ntry:\n    raise OutOfStock(\"mug\")\nexcept OutOfStock as e:\n    print(\"Out of stock:\", e)",
        output = "Out of stock: mug",
    ),
    output(
        "price = 19.9\nprint(f\"\${price:.2f}\")",
        "\$19.90",
        ":.2f prints a number with two decimal places.",
    ),
    choice(
        "Which keyword raises an exception, e.g. for an out-of-stock item?",
        listOf("raise", "except", "try", "error"),
        0,
        "In Python you raise an exception with raise.",
    ),
)
