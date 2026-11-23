package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*
import com.mrpython.app.domain.CourseUnit

internal val module37 = CourseUnit(
    id = "u37",
    title = "Object composition",
    description = "Objects made of other objects, and delegation",
    lessons = listOf(
        lesson(
            "u37l1", "Objects inside objects",
            output(
                "class Book:\n    def __init__(self, title):\n        self.title = title\n\nclass Library:\n    def __init__(self):\n        self.books = []\n\nlib = Library()\nlib.books.append(Book(\"Emma\"))\nlib.books.append(Book(\"Dune\"))\nprint(lib.books[1].title)",
                "Dune",
                "The library stores a list of Book objects.",
            ),
            output(
                "class Player:\n    def __init__(self, name, goals):\n        self.name = name\n        self.goals = goals\n\nclass Team:\n    def __init__(self, players):\n        self.players = players\n    def goals(self):\n        return sum(p.goals for p in self.players)\n\nteam = Team([Player(\"Amy\", 2), Player(\"Lily\", 3)])\nprint(team.goals())",
                "5",
                "The team adds up its players' goals.",
            ),
            choice(
                "What is composition?",
                listOf("An object contains other objects as its attributes", "A class inherits from several classes", "Joining two lists", "Creating a class inside a function"),
                0,
                "Composition means building an object out of other objects.",
            ),
            output(
                "class Engine:\n    def __init__(self, power):\n        self.power = power\n\nclass Car:\n    def __init__(self, power):\n        self.engine = Engine(power)\n\ncar = Car(150)\nprint(car.engine.power)",
                "150",
                "Through car.engine we reach the Engine object, and then its power.",
            ),
            fill(
                "Fill in the blank to print the power of the car's engine (150).",
                "class Engine:\n    def __init__(self, power):\n        self.power = power\n\nclass Car:\n    def __init__(self, power):\n        self.engine = Engine(power)\n\ncar = Car(150)\nprint(car.____.power)",
                listOf("engine", "Engine", "power"),
                "engine",
                "The car's attribute is called engine (lowercase), while Engine is the name of the class.",
            ),
            output(
                "class Book:\n    def __init__(self, t):\n        self.t = t\n\nclass Shelf:\n    def __init__(self):\n        self.books = [Book(\"A\"), Book(\"B\")]\n    def titles(self):\n        return [b.t for b in self.books]\n\nprint(Shelf().titles())",
                "['A', 'B']",
                "The shelf's method collects the titles of all its books.",
            ),
            tiles(
                "In __init__, create the attribute engine as a new Engine(100) object",
                listOf("self.engine", "=", "Engine(", "100", ")"),
                listOf("Car(", "=="),
                "An attribute can store an object of another class.",
            ),
            choice(
                "A car has an engine. What kind of relationship is that?",
                listOf("Composition (\"has a\")", "Inheritance (\"is a\")", "Polymorphism", "None"),
                0,
                "We model a \"has a\" relationship with composition.",
            ),
        ),
        lesson(
            "u37l2", "Delegation",
            output(
                "class Engine:\n    def start(self):\n        return \"vroom\"\n\nclass Car:\n    def __init__(self):\n        self.engine = Engine()\n    def drive(self):\n        return self.engine.start()\n\nprint(Car().drive())",
                "vroom",
                "The car delegates starting to its engine.",
            ),
            choice(
                "What is delegation?",
                listOf("Handing a task to an object that is part of our object", "Copying methods from the base class", "Deleting an object", "Calling super()"),
                0,
                "The object hands the work over to one of its parts.",
            ),
            output(
                "class Library:\n    def __init__(self):\n        self.books = [\"Emma\", \"Dune\"]\n    def __len__(self):\n        return len(self.books)\n    def __contains__(self, t):\n        return t in self.books\n\nlib = Library()\nprint(len(lib), \"Emma\" in lib)",
                "2 True",
                "The special methods delegate the work to the internal list.",
            ),
            fill(
                "Fill in the blank so the car delegates starting to the engine (prints vroom).",
                "class Engine:\n    def start(self):\n        return \"vroom\"\n\nclass Car:\n    def __init__(self):\n        self.engine = Engine()\n    def drive(self):\n        return self.____.start()\n\nprint(Car().drive())",
                listOf("engine", "Engine", "start"),
                "engine",
                "We call the method on the self.engine attribute.",
            ),
            output(
                "class Player:\n    def __init__(self, name, pts):\n        self.name = name\n        self.pts = pts\n\nclass Team:\n    def __init__(self, players):\n        self.players = players\n    def best(self):\n        p = max(self.players, key=lambda p: p.pts)\n        return p.name\n\nteam = Team([Player(\"John\", 7), Player(\"Eve\", 9)])\nprint(team.best())",
                "Eve",
                "The team searches its players and returns the name of the best one.",
            ),
            choice(
                "Why does Car.drive() call self.engine.start() instead of doing everything itself?",
                listOf("Each class is responsible for its own job – Car hands the work to the engine", "Because Car can't have methods", "Because inheritance requires it", "To make the program run slower"),
                0,
                "Delegation splits responsibility between classes.",
            ),
            tiles(
                "Start the engine of the car car and save the result in the variable r",
                listOf("r", "=", "car.engine", ".start()"),
                listOf("Engine", "super()"),
                "The engine has the start method, so we call it through car.engine.",
            ),
            output(
                "class Team:\n    def __init__(self, players):\n        self.players = players\n    def __getitem__(self, i):\n        return self.players[i]\n\nteam = Team([\"Amy\", \"Lily\", \"Ella\"])\nprint(team[0], team[-1])",
                "Amy Ella",
                "__getitem__ delegates indexing to the list of players.",
            ),
        ),
        lesson(
            "u37l3", "Composition or inheritance?",
            choice(
                "Dog and Animal – how should you connect them?",
                listOf("Inheritance: a dog is an animal", "Composition: a dog has an animal", "No relationship", "Animal inherits from Dog"),
                0,
                "An \"is a\" relationship means inheritance.",
            ),
            tiles(
                "A square is a shape. Write the header of the Square class",
                listOf("class", "Square(", "Shape", "):"),
                listOf("def", "self.shape"),
                "\"Is a\" means inheritance, so Shape goes in the parentheses.",
            ),
            fill(
                "Fill in the blank so the bike has two wheels (prints 2).",
                "class Wheel:\n    pass\n\nclass Bike:\n    def __init__(self):\n        self.wheels = [Wheel(), ____()]\n\nprint(len(Bike().wheels))",
                listOf("Wheel", "Bike", "wheel"),
                "Wheel",
                "A bike has wheels – it contains objects of the Wheel class.",
            ),
            choice(
                "Car and Wheel – how should you connect them?",
                listOf("Composition: a car has wheels", "Inheritance: a car is a wheel", "Inheritance: a wheel is a car", "Multiple inheritance"),
                0,
                "A car is made up of wheels – that's a \"has a\" relationship.",
            ),
            output(
                "class Gas:\n    def run(self):\n        return \"burning\"\n\nclass Electric:\n    def run(self):\n        return \"charging\"\n\nclass Car:\n    def __init__(self, motor):\n        self.motor = motor\n\nfor m in [Gas(), Electric()]:\n    print(Car(m).motor.run())",
                "burning\ncharging",
                "Composition makes it easy to swap out a part of an object.",
            ),
            choice(
                "What does the rule \"composition over inheritance\" mean?",
                listOf("When there is no \"is a\" relationship, it's better to build the object from parts", "Never use inheritance", "Every class must have an attribute holding an object", "Composition is faster"),
                0,
                "We use inheritance only when a class really is a kind of another class.",
            ),
            output(
                "class Stack:\n    def __init__(self):\n        self.items = []\n    def push(self, x):\n        self.items.append(x)\n    def pop(self):\n        return self.items.pop()\n\ns = Stack()\ns.push(1)\ns.push(2)\nprint(s.pop())",
                "2",
                "The stack uses a list inside and exposes only its own operations.",
            ),
            choice(
                "What problem does this version of the stack have?",
                listOf("It inherits all the list methods, e.g. insert, which break the rules of a stack", "You can't create an object", "The push method doesn't work", "SyntaxError"),
                0,
                "A stack is not a list – it's better for it to have a list (composition).",
                code = "class Stack(list):\n    def push(self, x):\n        self.append(x)\n\ns = Stack()\ns.push(1)\ns.insert(0, 5)",
            ),
        ),
        lesson(
            "u37l4", "Review: composition",
            output(
                "class Book:\n    def __init__(self, t, author):\n        self.t = t\n        self.author = author\n\nclass Library:\n    def __init__(self, books):\n        self.books = books\n    def by_author(self, a):\n        return [b.t for b in self.books if b.author == a]\n\nlib = Library([Book(\"A\", \"X\"), Book(\"B\", \"Y\"), Book(\"C\", \"X\")])\nprint(lib.by_author(\"X\"))",
                "['A', 'C']",
                "The library filters its books by author.",
            ),
            choice(
                "Which relationship is composition?",
                listOf("A team has players", "A cat is an animal", "A square is a shape", "ValueError is an exception"),
                0,
                "\"Has a\" is composition, \"is a\" is inheritance.",
            ),
            output(
                "class Playlist:\n    def __init__(self):\n        self.songs = []\n    def add(self, s):\n        self.songs.append(s)\n    def __len__(self):\n        return len(self.songs)\n\np = Playlist()\np.add(\"A\")\np.add(\"B\")\nprint(len(p))",
                "2",
                "The playlist delegates adding and counting to the list of songs.",
            ),
            fill(
                "Fill in the blank to add a player to the team (prints ['Amy']).",
                "class Team:\n    def __init__(self):\n        self.players = []\n    def add(self, p):\n        self.____.append(p)\n\nteam = Team()\nteam.add(\"Amy\")\nprint(team.players)",
                listOf("players", "Team", "add"),
                "players",
                "The team delegates adding to its list of players.",
            ),
            output(
                "from dataclasses import dataclass, field\n\n@dataclass\nclass Player:\n    name: str\n\n@dataclass\nclass Team:\n    players: list = field(default_factory=list)\n\nteam = Team()\nteam.players.append(Player(\"Lily\"))\nprint(team)",
                "Team(players=[Player(name='Lily')])",
                "Dataclasses can be composed of other dataclasses too.",
            ),
            output(
                "class Engine:\n    def __init__(self):\n        self.power = 100\n\nclass Car:\n    def __init__(self):\n        self.engine = Engine()\n\ncar = Car()\ncar.engine.power += 50\nprint(car.engine.power)",
                "150",
                "We change an attribute of an object that is part of the car.",
            ),
            tiles(
                "Add the object Player(\"Lily\") to the players list of the team team",
                listOf("team.players", ".append(", "Player(\"Lily\")", ")"),
                listOf("team.append(", "Team("),
                "The player goes into the list that is an attribute of the team.",
            ),
            choice(
                "When should you choose inheritance over composition?",
                listOf("When the new class really is a kind of the base class", "Whenever a class has attributes", "When an object contains a list of other objects", "Never"),
                0,
                "Inheritance fits an \"is a\" relationship, composition a \"has a\" relationship.",
            ),
        ),
    ),
)
