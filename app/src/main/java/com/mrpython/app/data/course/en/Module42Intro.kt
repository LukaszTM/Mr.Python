package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

internal val module42Intro = lesson(
    "u42l0", "Introduction: context managers",
    explain(
        "The with statement",
        "The `with` statement opens a resource, e.g. a file, and \"cleans it up\" on its own when the block ends. " +
            "We give the resource a name after `as`. After leaving the block, the file is already closed.",
        code = "with open(\"notes.txt\", \"w\") as f:\n    f.write(\"abc\")\nprint(f.closed)",
        output = "True",
    ),
    explain(
        "Cleanup even after an error",
        "`with` is a shorter way to write the `try` / `finally` pattern: the file will be closed even " +
            "when an exception occurs in the block. You can open several files in one `with` " +
            "by separating them with a comma.",
        code = "f = open(\"notes.txt\", \"w\")\ntry:\n    f.write(\"abc\")\nfinally:\n    f.close()\nprint(f.closed)",
        output = "True",
    ),
    explain(
        "__enter__ and __exit__",
        "Your own context manager is a class with two methods. `__enter__` runs at the start of " +
            "the block, and whatever it returns goes to the variable after `as`. `__exit__` always runs at the end " +
            "and gets 3 parameters describing the exception, if there was one.",
        code = "class Block:\n    def __enter__(self):\n        return \"data\"\n    def __exit__(self, t, v, tb):\n        print(\"end\")\nwith Block() as x:\n    print(x)",
        output = "data\nend",
    ),
    explain(
        "Suppressing exceptions",
        "When `__exit__` returns `True`, the exception from the block is suppressed. An easier way is " +
            "`suppress(Type)` from the `contextlib` module – it works like `except Type: pass`, and the rest " +
            "of the block is skipped.",
        code = "from contextlib import suppress\nwith suppress(ZeroDivisionError):\n    print(\"A\")\n    1 / 0\n    print(\"B\")\nprint(\"C\")",
        output = "A\nC",
    ),
    explain(
        "@contextmanager",
        "The `@contextmanager` decorator from `contextlib` turns a function with a single `yield` into a context " +
            "manager. The code before `yield` acts like `__enter__`, and the code after it like `__exit__`.",
        code = "from contextlib import contextmanager\n@contextmanager\ndef block():\n    print(\"start\")\n    yield\n    print(\"stop\")",
    ),
    choice(
        "When does the __exit__ method run?",
        listOf("Always, when leaving the with block", "Only when there was no error", "Only when there was an error", "Never on its own"),
        0,
        "A context manager always cleans up, even after an exception.",
    ),
    output(
        "from contextlib import suppress\nwith suppress(ValueError):\n    print(int(\"x\"))\nprint(\"moving on\")",
        "moving on",
        "suppress silenced the ValueError, and the program keeps running.",
    ),
    fill(
        "Fill in the word after which we give the open file's name.",
        "with open(\"notes.txt\", \"w\") ____ file:\n    file.write(\"x\")",
        listOf("as", "in", "is", "to"),
        "as",
        "The pattern is: with expression as name:",
    ),
)
