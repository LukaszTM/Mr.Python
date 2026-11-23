package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

internal val module69Intro = lesson(
    "u69l0", "Introduction: the text game project",
    explain(
        "Rooms as dictionaries",
        "We're building an adventure game. The map is a dictionary: the key is the room's name, and the value " +
            "is a dictionary with a description and exits in different directions.",
        code = "MAP = {\n    \"hall\": {\"description\": \"A dark hall\", \"n\": \"kitchen\"},\n}\nprint(MAP[\"hall\"][\"description\"])\nprint(MAP[\"hall\"][\"n\"])",
        output = "A dark hall\nkitchen",
    ),
    explain(
        "Commands",
        "The player types commands like “go n”. `split()` separates the verb and the direction, " +
            "and `get()` with a default value handles an unknown direction without an error.",
        code = "verb, direction = \"go n\".split()\nexits = {\"n\": \"kitchen\"}\nprint(exits.get(direction, \"no way\"))\nprint(exits.get(\"s\", \"no way\"))",
        output = "kitchen\nno way",
    ),
    explain(
        "Inventory",
        "The inventory is a list: an item taken from a room is removed from the room's list (`remove`) and added " +
            "to yours (`append`). The `in` operator checks whether you have something.",
        code = "room = [\"key\", \"map\"]\ninv = []\nroom.remove(\"key\")\ninv.append(\"key\")\nprint(inv, room, \"key\" in inv)",
        output = "['key'] ['map'] True",
    ),
    explain(
        "The Player class",
        "It's convenient to keep the player's state (room, inventory, health) in an object. Methods such as `go` " +
            "change that state.",
        code = "class Player:\n    def __init__(self):\n        self.room = \"hall\"\n    def go(self, target):\n        self.room = target\np = Player(); p.go(\"lounge\"); print(p.room)",
        output = "lounge",
    ),
    explain(
        "The game loop",
        "The game runs in a loop: read a command, execute it, repeat – until “quit” and `break`. " +
            "In a real game the commands would come from `input()`; in the exercises we give them as a list.",
        code = "for cmd in [\"n\", \"s\", \"quit\", \"n\"]:\n    if cmd == \"quit\":\n        print(\"See you!\")\n        break\n    print(\"Going:\", cmd)",
        output = "Going: n\nGoing: s\nSee you!",
    ),
    output(
        "MAP = {\"hall\": {\"n\": \"lounge\"}}\nprint(MAP[\"hall\"].get(\"w\", \"wall\"))",
        "wall",
        "The hall has no exit \"w\", so get returns the default value.",
    ),
    choice(
        "Which statement ends the game loop after the “quit” command?",
        listOf("break", "continue", "pass", "else"),
        0,
        "break stops the loop immediately.",
    ),
)
