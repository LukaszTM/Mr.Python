package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

internal val module37Cards = listOf(
    cards(
        "u37l2",
        explain(
            "Looping over an object: __iter__",
            "To make an object work in a `for` loop, add an `__iter__` method. The simplest way is to delegate: " +
                "return `iter(self.items)`, the iterator of the internal list.",
            code = "class Playlist:\n    def __init__(self, songs):\n        self.songs = songs\n    def __iter__(self):\n        return iter(self.songs)\n\nfor s in Playlist([\"A\", \"B\"]):\n    print(s)",
            output = "A\nB",
        ),
    ),
    cards(
        "u37l3",
        explain(
            "Swappable parts",
            "A part of an object can be passed to the constructor. The car doesn't need to know what kind of motor it has – " +
                "it's enough that the motor has a `run()` method. Swapping the part requires no changes in the Car class.",
            code = "class Electric:\n    def run(self):\n        return \"charging\"\nclass Car:\n    def __init__(self, motor):\n        self.motor = motor\nprint(Car(Electric()).motor.run())",
            output = "charging",
        ),
        explain(
            "A stack is not a list",
            "`class Stack(list)` inherits all the list methods, e.g. `insert()`, which break the rules of a stack. " +
                "It's better for the stack to keep a list in an attribute and expose only its own operations.",
            code = "class Stack:\n    def __init__(self):\n        self.items = []\n    def push(self, x):\n        self.items.append(x)\n    def pop(self):\n        return self.items.pop()\ns = Stack()\ns.push(1)\nprint(s.pop())",
            output = "1",
        ),
    ),
)
