package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*
import com.mrpython.app.domain.CourseUnit

internal val module34 = CourseUnit(
    id = "u34",
    title = "dataclasses",
    description = "Data classes without writing __init__",
    lessons = listOf(
        lesson(
            "u34l1", "@dataclass – the basics",
            output(
                "from dataclasses import dataclass\n\n@dataclass\nclass Point:\n    x: int\n    y: int\n\nprint(Point(1, 2))",
                "Point(x=1, y=2)",
                "@dataclass creates __init__ and a readable __repr__ for you.",
            ),
            output(
                "from dataclasses import dataclass\n\n@dataclass\nclass Point:\n    x: int\n    y: int\n\nprint(Point(1, 2) == Point(1, 2))",
                "True",
                "A dataclass also gets an __eq__ that compares the fields.",
            ),
            choice(
                "What does @dataclass create automatically?",
                listOf("__init__, __repr__ and __eq__", "Only __init__ and __repr__", "__init__, __lt__ and __gt__", "Nothing – it's just a comment"),
                0,
                "__init__, __repr__ and __eq__ are built from the list of fields.",
            ),
            output(
                "from dataclasses import dataclass\n\n@dataclass\nclass Person:\n    name: str\n    age: int\n\np = Person(\"Anna\", 30)\np.age += 1\nprint(p.age)",
                "31",
                "Dataclass fields are ordinary attributes that you can change.",
            ),
            fill(
                "Complete the import.",
                "from dataclasses import ____\n\n@dataclass\nclass Cat:\n    name: str\n\nprint(Cat(\"Whiskers\"))",
                listOf("dataclass", "dataclasses", "DataClass"),
                "dataclass",
                "We import the dataclass decorator from the dataclasses module.",
            ),
            choice(
                "What will this code print?",
                listOf("P(x='abc')", "TypeError", "P(x=0)", "ValueError"),
                0,
                "The int annotation is only a hint – Python doesn't check the type.",
                code = "from dataclasses import dataclass\n\n@dataclass\nclass P:\n    x: int\n\nprint(P(\"abc\"))",
            ),
            tiles(
                "Declare a field age of type int in a dataclass",
                listOf("age", ":", "int"),
                listOf("==", "int()"),
                "A dataclass field is a name, a colon and a type.",
            ),
            output(
                "from dataclasses import dataclass\n\n@dataclass\nclass Book:\n    title: str\n    pages: int\n\nb = Book(pages=100, title=\"Emma\")\nprint(b)",
                "Book(title='Emma', pages=100)",
                "The order in __repr__ follows the order of the fields in the class.",
            ),
        ),
        lesson(
            "u34l2", "Default values and field",
            output(
                "from dataclasses import dataclass\n\n@dataclass\nclass Player:\n    name: str\n    points: int = 0\n\nprint(Player(\"Olivia\"))",
                "Player(name='Olivia', points=0)",
                "A field with a default value can be skipped when creating the object.",
            ),
            output(
                "from dataclasses import dataclass, field\n\n@dataclass\nclass Cart:\n    items: list = field(default_factory=list)\n\na = Cart()\nb = Cart()\na.items.append(\"cheese\")\nprint(len(a.items), len(b.items))",
                "1 0",
                "default_factory creates a separate, new list for each object.",
            ),
            choice(
                "What happens if you write items: list = [] in a dataclass?",
                listOf("ValueError", "Each object gets its own list", "All objects get one shared list", "SyntaxError"),
                0,
                "A dataclass forbids a list as a plain default value (ValueError), because the objects would share one list; use field(default_factory=list).",
            ),
            choice(
                "What happens when you run this code?",
                listOf("TypeError", "y gets the value 0", "y gets None", "The code runs without an error"),
                0,
                "Field y has no default but comes after a field with one, so the class definition itself raises a TypeError.",
                code = "from dataclasses import dataclass\n\n@dataclass\nclass A:\n    x: int = 0\n    y: int",
            ),
            fill(
                "Complete the code so that each object has its own empty list.",
                "from dataclasses import dataclass, field\n\n@dataclass\nclass Classroom:\n    students: list = field(default_factory=____)\n\nc = Classroom()\nc.students.append(\"Anna\")\nprint(c.students)",
                listOf("list", "[]", "list()"),
                "list",
                "default_factory gets a function (list) that it calls when the object is created.",
            ),
            output(
                "from dataclasses import dataclass, field\n\n@dataclass\nclass Warehouse:\n    stock: dict = field(default_factory=dict)\n\nw = Warehouse()\nw.stock[\"apples\"] = 5\nprint(w)",
                "Warehouse(stock={'apples': 5})",
                "default_factory=dict creates a new empty dictionary.",
            ),
            output(
                "from dataclasses import dataclass\n\n@dataclass\nclass Rect:\n    a: int\n    b: int = 1\n    def area(self):\n        return self.a * self.b\n\nprint(Rect(3).area(), Rect(3, 4).area())",
                "3 12",
                "A dataclass can have ordinary methods.",
            ),
            tiles(
                "Declare a field tags with an empty list as its default value",
                listOf("tags:", "list", "=", "field(", "default_factory=list", ")"),
                listOf("[]", "list()"),
                "We create a default list with field(default_factory=list).",
            ),
        ),
        lesson(
            "u34l3", "frozen and order",
            output(
                "from dataclasses import dataclass\n\n@dataclass(frozen=True)\nclass Color:\n    r: int\n\nc = Color(255)\ntry:\n    c.r = 0\nexcept AttributeError:\n    print(\"cannot change\")",
                "cannot change",
                "An object of a frozen dataclass cannot be changed.",
            ),
            choice(
                "What does the frozen=True parameter do?",
                listOf("The object cannot be changed", "Objects can be sorted", "Fields become private", "The object is created faster"),
                0,
                "frozen=True blocks assigning to fields.",
            ),
            output(
                "from dataclasses import dataclass\n\n@dataclass(order=True)\nclass Version:\n    major: int\n    minor: int\n\nv = sorted([Version(1, 5), Version(1, 2), Version(0, 9)])\nprint(v[0])",
                "Version(major=0, minor=9)",
                "order=True compares the fields one by one – major first.",
            ),
            output(
                "from dataclasses import dataclass\n\n@dataclass(order=True)\nclass W:\n    a: int\n    b: int\n\nprint(W(1, 9) < W(2, 0))",
                "True",
                "The comparison works like for tuples: the first differing field decides.",
            ),
            choice(
                "What happens when you run this code?",
                listOf("TypeError", "It prints True", "It prints False", "SyntaxError"),
                0,
                "Without order=True a dataclass has no < comparison, so W(1) < W(2) raises a TypeError.",
                code = "from dataclasses import dataclass\n\n@dataclass\nclass W:\n    a: int\n\nprint(W(1) < W(2))",
            ),
            fill(
                "Complete the code so the tasks can be sorted (prints 1).",
                "from dataclasses import dataclass\n\n@dataclass(____=True)\nclass Task:\n    priority: int\n\nt = sorted([Task(3), Task(1)])\nprint(t[0].priority)",
                listOf("order", "frozen", "sort"),
                "order",
                "order=True adds the __lt__, __le__, __gt__ and __ge__ methods.",
            ),
            output(
                "from dataclasses import dataclass\n\n@dataclass(frozen=True)\nclass Cell:\n    x: int\n    y: int\n\nvisited = {Cell(0, 0), Cell(0, 0)}\nprint(len(visited))",
                "1",
                "Frozen objects can be put in a set; equal objects count once.",
            ),
            tiles(
                "Sort the list tasks (a dataclass with order=True) and save the result in t",
                listOf("t", "=", "sorted(", "tasks", ")"),
                listOf("tasks.sorted(", "order="),
                "Thanks to order=True the objects can be sorted with the sorted function.",
            ),
        ),
        lesson(
            "u34l4", "Review: dataclasses",
            output(
                "from dataclasses import dataclass\n\n@dataclass\nclass Movie:\n    title: str\n    rating: float = 5.0\n\nprint(Movie(\"Jaws\"))",
                "Movie(title='Jaws', rating=5.0)",
                "The skipped field gets its default value.",
            ),
            output(
                "from dataclasses import dataclass\n\n@dataclass\nclass Movie:\n    title: str\n    rating: float = 5.0\n\nprint(Movie(\"A\") == Movie(\"A\", 4.0))",
                "False",
                "__eq__ compares all the fields, and the ratings are different.",
            ),
            choice(
                "Which parameter do you use so that dataclass objects can be sorted?",
                listOf("order=True", "frozen=True", "sort=True", "eq=False"),
                0,
                "order=True adds the comparison operators.",
            ),
            output(
                "from dataclasses import dataclass\n\n@dataclass(order=True)\nclass Player:\n    points: int\n    name: str\n\np = max([Player(5, \"Olivia\"), Player(7, \"Anna\")])\nprint(p.name)",
                "Anna",
                "The first field is points, so the player with 7 points wins.",
            ),
            fill(
                "Complete the import.",
                "from dataclasses import dataclass, ____\n\n@dataclass\nclass Items:\n    elements: list = field(default_factory=list)\n\nprint(Items())",
                listOf("field", "Field", "default_factory"),
                "field",
                "We import the field function from the dataclasses module.",
            ),
            choice(
                "Which error appears when you try to change a field of an object with frozen=True?",
                listOf("FrozenInstanceError", "ValueError", "KeyError", "None – the field will change"),
                0,
                "FrozenInstanceError inherits from AttributeError.",
            ),
            output(
                "from dataclasses import dataclass, field\n\n@dataclass\nclass Team:\n    name: str\n    players: list = field(default_factory=list)\n\nt = Team(\"Eagles\")\nt.players.append(\"John\")\nprint(t)",
                "Team(name='Eagles', players=['John'])",
                "The list of players is a field and shows up in __repr__.",
            ),
            tiles(
                "Create a Point object with x=3 and y=4 (keyword arguments) and save it in p",
                listOf("p", "=", "Point(", "x=3,", "y=4", ")"),
                listOf("new", "x:3,"),
                "A dataclass accepts keyword arguments like an ordinary function.",
            ),
        ),
    ),
)
