package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*
import com.mrpython.app.domain.CourseUnit

internal val module69 = CourseUnit(
    id = "u69",
    title = "Project: text game",
    description = "Rooms, commands, inventory and the game loop",
    lessons = listOf(
        lesson(
            "u69l1", "Step 1: rooms as dictionaries",
            output(
                "hall = {\n    \"description\": \"A dark hall\",\n    \"exits\": {\"north\": \"kitchen\"},\n}\nprint(hall[\"description\"])\nprint(hall[\"exits\"][\"north\"])",
                "A dark hall\nkitchen",
                "A room is a dictionary with a description and a dictionary of exits.",
            ),
            output(
                "rooms = {\n    \"hall\": {\"description\": \"A dark hall\"},\n    \"kitchen\": {\"description\": \"Smells like bread\"},\n}\nprint(rooms[\"kitchen\"][\"description\"])",
                "Smells like bread",
                "We keep all the rooms in one dictionary: name → room.",
            ),
            fill(
                "Read where the exit to the east leads.",
                "exits = {\"east\": \"garden\", \"west\": \"forest\"}\nprint(exits[____])",
                listOf("\"east\"", "east", "0"),
                "\"east\"",
                "The dictionary key is a string, so it has to be in quotes.",
            ),
            choice(
                "Why is a dictionary the best way to store a room?",
                listOf("Because its parts (description, exits) have readable key names", "Because dictionaries are always sorted alphabetically", "Because lists can't contain strings", "Because a dictionary can't be changed"),
                0,
                "Keys like \"description\" and \"exits\" describe what we are storing.",
            ),
            output(
                "exits = {\"north\": \"kitchen\", \"east\": \"garden\"}\nfor direction in exits:\n    print(direction)",
                "north\neast",
                "A loop over a dictionary goes through its keys.",
            ),
            tiles(
                "Create the room kitchen with the description \"Smells like bread\"",
                listOf("kitchen", "=", "{\"description\":", "\"Smells like bread\"}"),
                listOf("[\"description\",", "(\"description\":"),
                "We write a dictionary in curly braces: {key: value}.",
            ),
            output(
                "exits = {\"north\": \"kitchen\", \"east\": \"garden\"}\nprint(\"Exits:\", \", \".join(exits))",
                "Exits: north, east",
                "join() on a dictionary glues its keys together.",
            ),
            output(
                "exits = {\"north\": \"kitchen\"}\nprint(exits.get(\"west\", \"no way\"))",
                "no way",
                "get() with a default value protects you from KeyError.",
            ),
        ),
        lesson(
            "u69l2", "Step 2: moving with commands",
            output(
                "command = \"go north\"\nverb, direction = command.split()\nprint(direction)\nprint(verb)",
                "north\ngo",
                "split() divides the command, and unpacking gives two variables.",
            ),
            output(
                "MAP = {\n    \"hall\": {\"north\": \"kitchen\"},\n    \"kitchen\": {\"south\": \"hall\"},\n}\ndef go(room, direction):\n    return MAP[room].get(direction, room)\n\nprint(go(\"hall\", \"north\"))\nprint(go(\"hall\", \"west\"))",
                "kitchen\nhall",
                "When there is no such exit, get() returns the current room – the player stays put.",
            ),
            output(
                "MAP = {\"hall\": {\"n\": \"lounge\"},\n       \"lounge\": {\"s\": \"hall\", \"n\": \"tower\"}}\nroom = \"hall\"\nfor k in [\"n\", \"s\", \"n\", \"n\"]:\n    room = MAP[room].get(k, room)\nprint(room)",
                "tower",
                "hall → lounge → hall → lounge → tower.",
            ),
            fill(
                "Move only when such an exit exists.",
                "exits = {\"n\": \"lounge\"}\nroom = \"hall\"\nfor direction in [\"s\", \"n\"]:\n    if direction ____ exits:\n        room = exits[direction]\nprint(room)",
                listOf("in", "not in", "=="),
                "in",
                "The in operator checks whether a key is in the dictionary.",
            ),
            choice(
                "What happens with exits[\"x\"] when there is no key \"x\"?",
                listOf("KeyError", "It returns None", "It returns an empty string", "IndexError"),
                0,
                "That's why we use get() or in for unknown commands.",
            ),
            tiles(
                "Split the command into a verb and the rest (at most one split)",
                listOf("verb, arg", "=", "command.split(", "maxsplit=1", ")"),
                listOf("command.join(", "sep=1"),
                "maxsplit=1 splits only at the first space, e.g. \"take old key\".",
            ),
            output(
                "def show_help():\n    return \"commands: go, take\"\ndef unknown():\n    return \"I don't understand\"\nCOMMANDS = {\"help\": show_help}\nfor k in [\"help\", \"jump\"]:\n    print(COMMANDS.get(k, unknown)())",
                "commands: go, take\nI don't understand",
                "The command dictionary points to functions; an unknown command gets the default function.",
            ),
            output(
                "SHORTCUTS = {\"n\": \"north\", \"s\": \"south\"}\nfor k in [\"n\", \"east\"]:\n    print(SHORTCUTS.get(k, k))",
                "north\neast",
                "We turn a shortcut into the full name and leave other commands unchanged.",
            ),
        ),
        lesson(
            "u69l3", "Step 3: inventory",
            output(
                "inventory = []\ninventory.append(\"key\")\ninventory.append(\"lamp\")\nprint(inventory)",
                "['key', 'lamp']",
                "The inventory is a plain list that we add items to.",
            ),
            output(
                "in_room = [\"key\", \"map\"]\ninv = []\ninv.append(in_room.pop(0))\nprint(inv, in_room)",
                "['key'] ['map']",
                "pop(0) takes the item out of the room, and append() puts it in the inventory.",
            ),
            fill(
                "Check whether the player has the key.",
                "inventory = [\"lamp\", \"key\"]\nif \"key\" ____ inventory:\n    print(\"You open the door\")",
                listOf("in", "not in", "is"),
                "in",
                "in checks whether an element is in the list.",
            ),
            output(
                "def take(item, room, inv):\n    if item not in room:\n        return \"That's not here.\"\n    room.remove(item)\n    inv.append(item)\n    return f\"You take: {item}\"\nr, i = [\"sword\"], []\nprint(take(\"sword\", r, i))\nprint(take(\"sword\", r, i))",
                "You take: sword\nThat's not here.",
                "The second time, the sword is no longer in the room.",
            ),
            choice(
                "What does my_list.remove(\"x\") do when \"x\" is not in the list?",
                listOf("It raises ValueError", "Nothing happens", "It removes the last element", "It returns False"),
                0,
                "remove() raises ValueError, which is why we check with in first.",
            ),
            tiles(
                "Print the inventory as a string with commas",
                listOf("print(", "\", \".join(", "inventory", "))"),
                listOf("inventory.split(", "str("),
                "join() glues the list elements together with the string \", \".",
            ),
            output(
                "inv = [\"map\", \"key\", \"lamp\"]\nprint(len(inv), sorted(inv))",
                "3 ['key', 'lamp', 'map']",
                "sorted() returns a new, sorted list.",
            ),
            output(
                "LOCKED = {\"vault\": \"key\"}\ndef enter(target, inv):\n    needed = LOCKED.get(target)\n    if needed and needed not in inv:\n        return \"Locked!\"\n    return f\"You enter: {target}\"\nprint(enter(\"vault\", []))\nprint(enter(\"vault\", [\"key\"]))",
                "Locked!\nYou enter: vault",
                "The door opens only once the key is in the inventory.",
            ),
        ),
        lesson(
            "u69l4", "Step 4: the Player class",
            output(
                "class Player:\n    def __init__(self, name):\n        self.name = name\n        self.room = \"hall\"\n        self.inv = []\np = Player(\"Amy\")\nprint(p.name, p.room, p.inv)",
                "Amy hall []",
                "The player object keeps the name, location and inventory together.",
            ),
            output(
                "MAP = {\"hall\": {\"n\": \"lounge\"}}\nclass Player:\n    def __init__(self):\n        self.room = \"hall\"\n    def go(self, k):\n        exits = MAP.get(self.room, {})\n        self.room = exits.get(k, self.room)\np = Player()\np.go(\"n\"); p.go(\"n\")\nprint(p.room)",
                "lounge",
                "The lounge has no exit to the north, so the player stays in the lounge.",
            ),
            fill(
                "Add an item to the player's inventory.",
                "class Player:\n    def __init__(self):\n        self.inv = []\n    def take(self, item):\n        self.inv.____(item)\np = Player()\np.take(\"lamp\")\nprint(p.inv)",
                listOf("append", "add", "push"),
                "append",
                "We add to a list with the append() method.",
            ),
            output(
                "class Player:\n    def __init__(self, name):\n        self.name = name\n        self.room = \"hall\"\n    def __str__(self):\n        return f\"{self.name} ({self.room})\"\nprint(Player(\"Amy\"))",
                "Amy (hall)",
                "__str__ decides how print() shows the object.",
            ),
            choice(
                "What does self refer to in the method call p.go(\"n\")?",
                listOf("The object p that the method was called on", "The Player class", "The string \"n\"", "The MAP dictionary"),
                0,
                "Python passes the object as the method's first argument by itself.",
            ),
            tiles(
                "Create a player named Amy",
                listOf("player", "=", "Player(", "\"Amy\"", ")"),
                listOf("new", "Player."),
                "We create an object by calling the class like a function.",
            ),
            output(
                "class Player:\n    def __init__(self):\n        self.hp = 10\n    def hit(self, amount):\n        self.hp = max(0, self.hp - amount)\n        return self.hp > 0\np = Player()\nprint(p.hit(4), p.hp)\nprint(p.hit(9), p.hp)",
                "True 6\nFalse 0",
                "max(0, ...) makes sure the health doesn't drop below zero.",
            ),
            choice(
                "Where is the best place to keep the player's inventory?",
                listOf("In an object attribute, e.g. self.inv", "In a local variable of the __init__ method", "In the MAP constant", "In a class attribute shared by all players"),
                0,
                "Each player has their own inventory, so it's an object attribute.",
            ),
        ),
        lesson(
            "u69l5", "Project: the game loop",
            output(
                "MAP = {\"hall\": {\"n\": \"lounge\"}, \"lounge\": {\"s\": \"hall\"}}\nroom = \"hall\"\nfor cmd in [\"n\", \"x\", \"s\"]:\n    if cmd in MAP[room]:\n        room = MAP[room][cmd]\n        print(\"You go to:\", room)\n    else:\n        print(\"There's no way through.\")",
                "You go to: lounge\nThere's no way through.\nYou go to: hall",
                "The game loop processes the planned commands one by one.",
            ),
            output(
                "for cmd in [\"n\", \"s\", \"quit\", \"n\"]:\n    if cmd == \"quit\":\n        print(\"See you!\")\n        break\n    print(\"Command:\", cmd)",
                "Command: n\nCommand: s\nSee you!",
                "break ends the game loop – the last \"n\" never runs.",
            ),
            fill(
                "End the game when the player reaches the vault.",
                "route = [\"hall\", \"vault\", \"tower\"]\nfor room in route:\n    print(room)\n    if room == \"vault\":\n        ____",
                listOf("break", "continue", "pass"),
                "break",
                "break stops the loop, so we never visit the tower.",
            ),
            output(
                "class Game:\n    def __init__(self):\n        self.inv = []\n    def run(self, cmd):\n        verb, _, arg = cmd.partition(\" \")\n        if verb == \"take\":\n            self.inv.append(arg)\ng = Game()\nfor k in [\"take key\", \"look\", \"take lamp\"]:\n    g.run(k)\nprint(g.inv)",
                "['key', 'lamp']",
                "partition(\" \") splits the command at the first space.",
            ),
            choice(
                "Why do we test the game on a list of commands instead of input()?",
                listOf("Because the result is always the same and easy to check", "Because input() doesn't work in a loop", "Because lists are faster than the keyboard", "Because input() returns numbers"),
                0,
                "A planned scenario gives a repeatable, deterministic run.",
            ),
            tiles(
                "Write the header of a loop that numbers the commands starting from 1",
                listOf("for", "num, cmd", "in", "enumerate(commands, 1):"),
                listOf("range(commands):", "while"),
                "enumerate(..., 1) numbers the elements starting from one.",
            ),
            output(
                "commands = iter([\"n\", \"n\", \"quit\", \"s\"])\nsteps = 0\nwhile True:\n    k = next(commands)\n    if k == \"quit\":\n        break\n    steps += 1\nprint(\"Steps:\", steps)",
                "Steps: 2",
                "next() fetches the commands one after another until we hit \"quit\".",
            ),
            output(
                "treasures = {\"lounge\": \"gold\", \"tower\": \"crown\"}\ninv = []\nfor room in [\"hall\", \"lounge\", \"tower\"]:\n    if room in treasures:\n        inv.append(treasures[room])\nwon = len(inv) == len(treasures)\nprint(\"You win!\" if won else \"Keep looking\")\nprint(inv)",
                "You win!\n['gold', 'crown']",
                "The game ends in victory when all the treasures have been collected.",
            ),
        ),
    ),
)
