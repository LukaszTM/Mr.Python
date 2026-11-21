package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

internal val module37Intro = lesson(
    "u37l0", "Introduction: object composition",
    explain(
        "Objects inside objects",
        "Composition means building an object out of other objects. A car has an engine, so the attribute `self.engine` " +
            "stores an object of the `Engine` class. We reach its data dot by dot.",
        code = "class Engine:\n    def __init__(self, power):\n        self.power = power\n\nclass Car:\n    def __init__(self, power):\n        self.engine = Engine(power)\n\nprint(Car(150).engine.power)",
        output = "150",
    ),
    explain(
        "Lists of objects",
        "An object can also hold a whole list of other objects – e.g. a team holds a list of players. " +
            "Its methods go through that list and collect the results.",
        code = "class Player:\n    def __init__(self, goals):\n        self.goals = goals\n\nclass Team:\n    def __init__(self, players):\n        self.players = players\n    def goals(self):\n        return sum(p.goals for p in self.players)\n\nprint(Team([Player(2), Player(3)]).goals())",
        output = "5",
    ),
    explain(
        "Delegation",
        "Delegation means handing work over to one of your parts: `Car.drive()` calls `self.engine.start()`. " +
            "Each class is responsible for its own job. Special methods such as `__len__` can delegate to a list too.",
        code = "class Engine:\n    def start(self):\n        return \"vroom\"\n\nclass Car:\n    def __init__(self):\n        self.engine = Engine()\n    def drive(self):\n        return self.engine.start()\n\nprint(Car().drive())",
        output = "vroom",
    ),
    explain(
        "\"Has a\" or \"is a\"?",
        "An \"is a\" relationship (a dog is an animal) means inheritance. A \"has a\" relationship (a car has wheels) " +
            "means composition. The rule \"composition over inheritance\": when there is no real \"is a\", build the object from parts.",
        code = "class Wheel:\n    pass\n\nclass Bike:\n    def __init__(self):\n        self.wheels = [Wheel(), Wheel()]\n\nprint(len(Bike().wheels))",
        output = "2",
    ),
    choice(
        "Which relationship is composition?",
        listOf("A library has books", "A cat is an animal", "A square is a shape", "ValueError is an exception"),
        0,
        "\"Has a\" means composition, \"is a\" means inheritance.",
    ),
    fill(
        "Fill in the blank so the car delegates starting to the engine (prints vroom).",
        "class Engine:\n    def start(self):\n        return \"vroom\"\n\nclass Car:\n    def __init__(self):\n        self.engine = Engine()\n    def drive(self):\n        return self.____.start()\n\nprint(Car().drive())",
        listOf("engine", "Engine", "drive"),
        "engine",
        "We call start() on the self.engine attribute.",
    ),
    output(
        "class Engine:\n    def __init__(self):\n        self.power = 90\n\nclass Car:\n    def __init__(self):\n        self.engine = Engine()\n\ncar = Car()\nprint(car.engine.power)",
        "90",
        "car.engine is an Engine object, and its power is 90.",
    ),
)
