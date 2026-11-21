package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

internal val module56Intro = lesson(
    "u56l0", "Introduction: the to-do list project",
    explain(
        "Project goal",
        "You'll build a to-do list: adding, checking off, removing and filtering, and then a `Task` class " +
            "and saving to JSON. It's a review of lists, dictionaries and classes in one real program.",
    ),
    explain(
        "A task as a dictionary",
        "Each task is a dictionary with the keys `title` and `done`, and we keep all the tasks " +
            "in a list. You reach a field with `tasks[i][\"title\"]`.",
        code = "tasks = [\n    {\"title\": \"Shopping\", \"done\": False},\n    {\"title\": \"Laundry\", \"done\": True},\n]\nprint(len(tasks), tasks[1][\"title\"])",
        output = "2 Laundry",
    ),
    explain(
        "Changes and filtering",
        "`append()` adds a new task, you check it off by setting `done` to `True`, and you remove it " +
            "with `pop(i)`. A list comprehension with `if` selects only the matching tasks.",
        code = "tasks = [{\"title\": \"A\", \"done\": False},\n         {\"title\": \"B\", \"done\": False}]\ntasks[0][\"done\"] = True\nremaining = [t[\"title\"] for t in tasks\n             if not t[\"done\"]]\nprint(remaining)",
        output = "['B']",
    ),
    explain(
        "The Task class",
        "A class combines data and behavior: `__init__` sets the attributes, a method such as `complete()` " +
            "changes the state, and `__str__` decides what the object looks like in `print()`.",
        code = "class Task:\n    def __init__(self, title):\n        self.title = title\n    def __str__(self):\n        return \"[ ] \" + self.title\nprint(Task(\"Study\"))",
        output = "[ ] Study",
    ),
    explain(
        "Saving as JSON",
        "The `json` module turns a list of dictionaries into text (`json.dumps`) and back (`json.loads`). " +
            "Note: in JSON, `True` is written as `true`.",
        code = "import json\n\ntext = json.dumps([{\"done\": True}])\nprint(text)\nprint(json.loads(text)[0][\"done\"])",
        output = "[{\"done\": true}]\nTrue",
    ),
    output(
        "t = {\"title\": \"Study\", \"done\": False}\nt[\"done\"] = True\nprint(t[\"done\"])",
        "True",
        "Checking a task off is simply changing a value in the dictionary.",
    ),
    choice(
        "Which function turns the task list into text in JSON format?",
        listOf("json.dumps", "json.loads", "json.text", "str.json"),
        0,
        "dumps creates the text, and loads reads it back.",
    ),
    tiles(
        "Add a new task t to the tasks list.",
        listOf("tasks.append(", "t", ")"),
        listOf("tasks.pop(", "add("),
        "append adds an element to the end of the list.",
    ),
)
