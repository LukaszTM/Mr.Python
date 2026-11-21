package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*
import com.mrpython.app.domain.CourseUnit

internal val module56 = CourseUnit(
    id = "u56",
    title = "Project: To-Do List",
    description = "We build a to-do list: from dictionaries to a class and JSON",
    lessons = listOf(
        lesson(
            "u56l1", "Tasks as dictionaries",
            output(
                "task = {\"title\": \"Shopping\", \"done\": False}\nprint(task[\"title\"], task[\"done\"])",
                "Shopping False",
                "A single task is a dictionary with named fields.",
            ),
            output(
                "tasks = [\n    {\"title\": \"Shopping\", \"done\": False},\n    {\"title\": \"Laundry\", \"done\": True},\n]\nprint(len(tasks), tasks[1][\"title\"])",
                "2 Laundry",
                "The list stores many tasks, and each of them is a dictionary.",
            ),
            choice(
                "Why do we store each task as a dictionary?",
                listOf("A task has several named fields, e.g. a title and a status", "Dictionaries are always sorted", "Lists can't contain strings", "A dictionary takes less memory than a string"),
                0,
                "Keys such as \"title\" and \"done\" describe the data.",
            ),
            fill(
                "Fill in the blank to print the title of the first task.",
                "tasks = [{\"title\": \"Shopping\", \"done\": False}]\nprint(tasks[0][____])",
                listOf("\"title\"", "title", "0"),
                "\"title\"",
                "A dictionary key is a string, so it needs quotes.",
            ),
            output(
                "tasks = [{\"title\": \"A\", \"done\": True},\n         {\"title\": \"B\", \"done\": False}]\nfor t in tasks:\n    mark = \"x\" if t[\"done\"] else \" \"\n    print(f\"[{mark}] {t['title']}\")",
                "[x] A\n[ ] B",
                "The conditional expression picks the checkbox mark.",
            ),
            tiles(
                "Create a dictionary for a new, unfinished task \"Study\".",
                listOf("{", "\"title\": \"Study\",", "\"done\": False", "}"),
                listOf("\"done\": True", "["),
                "A new task starts out as not done.",
            ),
            choice(
                "What kind of structure is the tasks variable in this project?",
                listOf("A list of dictionaries", "A dictionary of lists", "A tuple of strings", "A set of dictionaries"),
                0,
                "The list holds the tasks one after another, and each one is a dictionary.",
            ),
            output(
                "tasks = [{\"title\": \"Shopping\"}, {\"title\": \"Laundry\"}]\nfor i, t in enumerate(tasks, 1):\n    print(i, t[\"title\"])",
                "1 Shopping\n2 Laundry",
                "enumerate(..., 1) numbers the tasks starting from 1.",
            ),
        ),
        lesson(
            "u56l2", "Adding, checking off, removing",
            output(
                "tasks = []\n\ndef add(title):\n    tasks.append({\"title\": title, \"done\": False})\n\nadd(\"Shopping\")\nadd(\"Laundry\")\nprint(len(tasks))",
                "2",
                "The add function appends a new dictionary to the list.",
            ),
            output(
                "tasks = [{\"title\": \"Shopping\", \"done\": False}]\n\ndef complete(i):\n    tasks[i][\"done\"] = True\n\ncomplete(0)\nprint(tasks[0])",
                "{'title': 'Shopping', 'done': True}",
                "We change the \"done\" field in the chosen dictionary.",
            ),
            fill(
                "Fill in the blank to mark the task as done.",
                "tasks = [{\"title\": \"A\", \"done\": False}]\ntasks[0][\"done\"] = ____\nprint(tasks[0][\"done\"])",
                listOf("True", "true", "Done"),
                "True",
                "The boolean value for truth in Python is True with a capital letter.",
            ),
            output(
                "tasks = [\"A\", \"B\", \"C\"]\nremoved = tasks.pop(1)\nprint(removed, tasks)",
                "B ['A', 'C']",
                "pop(i) removes the element at index i and returns it.",
            ),
            output(
                "tasks = [{\"title\": \"A\"}, {\"title\": \"B\"}]\ntasks = [t for t in tasks\n         if t[\"title\"] != \"A\"]\nprint(tasks)",
                "[{'title': 'B'}]",
                "Removing by title: we keep every task with a different title.",
            ),
            choice(
                "What happens when you run this code?",
                listOf("IndexError – there is no task at index 5", "It removes the last task", "It returns None", "KeyError"),
                0,
                "The list only has indexes 0 and 1.",
                code = "tasks = [\"A\", \"B\"]\ntasks.pop(5)",
            ),
            tiles(
                "Remove the first task from the list with the del statement.",
                listOf("del", "tasks[0]"),
                listOf("remove", "tasks(0)"),
                "del list[i] removes the element at the given index.",
            ),
            output(
                "tasks = [{\"title\": \"A\", \"done\": False}]\n\ndef complete(i):\n    if 0 <= i < len(tasks):\n        tasks[i][\"done\"] = True\n        return \"OK\"\n    return \"No such task\"\n\nprint(complete(3), complete(0))",
                "No such task OK",
                "Checking the index protects us from an IndexError.",
            ),
        ),
        lesson(
            "u56l3", "Filtering tasks",
            output(
                "tasks = [\n    {\"title\": \"A\", \"done\": True},\n    {\"title\": \"B\", \"done\": False},\n    {\"title\": \"C\", \"done\": False},\n]\nremaining = [t[\"title\"] for t in tasks\n             if not t[\"done\"]]\nprint(remaining)",
                "['B', 'C']",
                "We filter the tasks that aren't done yet.",
            ),
            fill(
                "Fill in the condition to select only the finished tasks.",
                "tasks = [{\"title\": \"A\", \"done\": True},\n         {\"title\": \"B\", \"done\": False}]\nfinished = [t[\"title\"] for t in tasks if ____]\nprint(finished)",
                listOf("t[\"done\"]", "not t[\"done\"]", "t[\"title\"]"),
                "t[\"done\"]",
                "The \"done\" field is already a boolean – checking it is enough.",
            ),
            output(
                "states = [True, False, True, True]\nprint(sum(states), \"of\", len(states))",
                "3 of 4",
                "True counts as 1, so sum counts the finished tasks.",
            ),
            output(
                "done, total = 3, 4\nprint(f\"Progress: {done / total:.0%}\")",
                "Progress: 75%",
                "The :.0% format multiplies by 100 and adds a percent sign.",
            ),
            choice(
                "What does a filter for unfinished tasks return when all of them are done?",
                listOf("An empty list []", "None", "An error", "The whole list"),
                0,
                "No element meets the condition, so the resulting list is empty.",
            ),
            output(
                "def filter_tasks(tasks, done):\n    return [t[\"title\"] for t in tasks\n            if t[\"done\"] == done]\n\nitems = [{\"title\": \"A\", \"done\": True},\n         {\"title\": \"B\", \"done\": False}]\nprint(filter_tasks(items, True))",
                "['A']",
                "The parameter decides which tasks we select.",
            ),
            tiles(
                "Build a list of the unfinished tasks.",
                listOf("[t", "for t in tasks", "if not", "t[\"done\"]]"),
                listOf("if", "while"),
                "if not selects the tasks that aren't done.",
            ),
            choice(
                "What does any(t[\"done\"] for t in tasks) check?",
                listOf("Whether at least one task is done", "Whether all tasks are done", "How many tasks are done", "Whether the list is empty"),
                0,
                "any returns True if at least one element is true.",
            ),
        ),
        lesson(
            "u56l4", "The Task class",
            output(
                "class Task:\n    def __init__(self, title):\n        self.title = title\n        self.done = False\n\nt = Task(\"Shopping\")\nprint(t.title, t.done)",
                "Shopping False",
                "The dictionary's fields become the object's attributes.",
            ),
            output(
                "class Task:\n    def __init__(self, title):\n        self.title = title\n        self.done = False\n    def complete(self):\n        self.done = True\n\nt = Task(\"Laundry\")\nt.complete()\nprint(t.done)",
                "True",
                "The complete method changes the object's state.",
            ),
            fill(
                "Fill in the method name so that print shows a readable description of the task.",
                "class Task:\n    def __init__(self, title):\n        self.title = title\n    def ____(self):\n        return \"Task: \" + self.title\n\nprint(Task(\"Study\"))",
                listOf("__str__", "__init__", "str"),
                "__str__",
                "print uses the object's __str__ method.",
            ),
            output(
                "class Task:\n    def __init__(self, title, done=False):\n        self.title = title\n        self.done = done\n    def __str__(self):\n        mark = \"x\" if self.done else \" \"\n        return f\"[{mark}] {self.title}\"\n\nprint(Task(\"A\", True))\nprint(Task(\"B\"))",
                "[x] A\n[ ] B",
                "__str__ decides what the object looks like when printed.",
            ),
            choice(
                "What is the main advantage of the Task class over a dictionary?",
                listOf("Data and behavior (methods) live in one place", "A class takes up less space", "Dictionaries can't be changed", "Classes don't need __init__"),
                0,
                "The object itself knows how to complete itself and how to print itself.",
            ),
            output(
                "class TaskList:\n    def __init__(self):\n        self.tasks = []\n    def add(self, title):\n        self.tasks.append(title)\n    def __len__(self):\n        return len(self.tasks)\n\nitems = TaskList()\nitems.add(\"A\")\nitems.add(\"B\")\nprint(len(items))",
                "2",
                "The __len__ method lets you use len on your own object.",
            ),
            tiles(
                "Create a task object \"Shopping\".",
                listOf("t", "=", "Task(", "\"Shopping\"", ")"),
                listOf("new", "=="),
                "You create an object by calling the class like a function – without the word new.",
            ),
            output(
                "from dataclasses import dataclass\n\n@dataclass\nclass Task:\n    title: str\n    done: bool = False\n\nprint(Task(\"Study\"))",
                "Task(title='Study', done=False)",
                "dataclass creates __init__ and a readable description of the object for you.",
            ),
        ),
        lesson(
            "u56l5", "Saving and project summary",
            output(
                "tasks = [{\"title\": \"A\", \"done\": True},\n         {\"title\": \"B\", \"done\": False}]\nlines = [f\"{t['title']};{t['done']}\"\n         for t in tasks]\nprint(\"\\n\".join(lines))",
                "A;True\nB;False",
                "We save each task as one line of text.",
            ),
            output(
                "line = \"Shopping;False\"\ntitle, state = line.split(\";\")\nprint(title, state == \"True\")",
                "Shopping False",
                "When reading the text, we turn the string \"False\" back into a boolean.",
            ),
            output(
                "import json\n\ntasks = [{\"title\": \"A\", \"done\": True}]\nprint(json.dumps(tasks))",
                "[{\"title\": \"A\", \"done\": true}]",
                "In JSON, boolean values are written in lowercase.",
            ),
            output(
                "import json\n\ntext = '[{\"title\": \"B\", \"done\": false}]'\ntasks = json.loads(text)\nprint(tasks[0][\"done\"])",
                "False",
                "json.loads turns JSON text back into a list of dictionaries.",
            ),
            fill(
                "Fill in the blank to turn the task list into a JSON string.",
                "import json\n\ntasks = [{\"title\": \"A\", \"done\": False}]\ntext = json.____(tasks)\nprint(text)",
                listOf("dumps", "loads", "dump"),
                "dumps",
                "dumps (dump string) turns an object into a JSON string.",
            ),
            choice(
                "Why is JSON a better choice for saving than str(tasks)?",
                listOf("JSON is a standard that other programs can read too", "str doesn't work for lists", "JSON is always shorter", "str changes the order of the tasks"),
                0,
                "str gives you Python's format, while JSON is a common data exchange format.",
            ),
            tiles(
                "Load the tasks from the JSON string in the variable text.",
                listOf("tasks", "=", "json.loads(", "text", ")"),
                listOf("json.dumps(", "json.load("),
                "loads reads JSON from a string, and load reads it from a file.",
            ),
            output(
                "import json\n\nclass Task:\n    def __init__(self, title):\n        self.title = title\n        self.done = False\n    def to_dict(self):\n        return {\"title\": self.title,\n                \"done\": self.done}\n\nprint(json.dumps(Task(\"C\").to_dict()))",
                "{\"title\": \"C\", \"done\": false}",
                "We turn the object into a dictionary, and the dictionary into JSON.",
            ),
        ),
    ),
)
