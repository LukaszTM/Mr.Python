package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*
import com.mrpython.app.domain.CourseUnit

internal val module42 = CourseUnit(
    id = "u42",
    title = "Context managers",
    description = "with, __enter__, __exit__, and contextlib",
    lessons = listOf(
        lesson(
            "u42l1", "The with statement",
            output(
                "with open(\"notes.txt\", \"w\") as f:\n    f.write(\"abc\")\nprint(f.closed)",
                "True",
                "After leaving the with block, the file is closed automatically.",
            ),
            choice(
                "What does a with open(...) as f block guarantee?",
                listOf("The file will be closed even after an error", "The file will never be closed", "The file will be empty", "The file will open as read-only"),
                0,
                "A context manager always cleans up – even when an exception occurs.",
            ),
            output(
                "with open(\"notes.txt\", \"w\") as f:\n    f.write(\"one\\ntwo\")\nwith open(\"notes.txt\") as f:\n    print(len(f.readlines()))",
                "2",
                "The file has two lines, and each with block closes the file on its own.",
            ),
            choice(
                "Which code is equivalent to with open(\"a.txt\") as f: ...?",
                listOf("f = open(...), then try, with f.close() in finally", "f = open(...), then try, with f.close() in except", "f = open(...) and the block, never closing the file", "f = open(...), and f.close() before the block"),
                0,
                "with is a shorter way to write the try / finally pattern.",
            ),
            fill(
                "Fill in the keyword that gives the open file a name.",
                "with open(\"notes.txt\", \"w\") ____ file:\n    file.write(\"x\")\nprint(file.closed)",
                listOf("as", "in", "is", "to"),
                "as",
                "After as we give the name of the variable in the with block.",
            ),
            output(
                "with open(\"notes.txt\", \"w\") as a, open(\"b.txt\", \"w\") as b:\n    a.write(\"1\")\n    b.write(\"2\")\nprint(a.closed and b.closed)",
                "True",
                "You can open several files in one with – all of them will be closed.",
            ),
            tiles(
                "Open the file \"notes.txt\" for reading in a with block",
                listOf("with", "open(\"notes.txt\")", "as", "f:"),
                listOf("in", "for"),
                "The pattern: with expression as name:",
            ),
        ),
        lesson(
            "u42l2", "__enter__ and __exit__",
            output(
                "class Block:\n    def __enter__(self):\n        print(\"enter\")\n    def __exit__(self, t, v, tb):\n        print(\"exit\")\nwith Block():\n    print(\"inside\")",
                "enter\ninside\nexit",
                "__enter__ runs at the start of the block, __exit__ at the end.",
            ),
            output(
                "class Counter:\n    def __enter__(self):\n        return 42\n    def __exit__(self, t, v, tb):\n        pass\nwith Counter() as x:\n    print(x)",
                "42",
                "The variable after as gets the value returned by __enter__.",
            ),
            output(
                "class Block:\n    def __enter__(self):\n        return self\n    def __exit__(self, t, v, tb):\n        print(\"cleaning up\")\ntry:\n    with Block():\n        1 / 0\nexcept ZeroDivisionError:\n    print(\"error\")",
                "cleaning up\nerror",
                "__exit__ runs before the exception reaches except.",
            ),
            output(
                "class Quiet:\n    def __enter__(self):\n        return self\n    def __exit__(self, t, v, tb):\n        return True\nwith Quiet():\n    1 / 0\nprint(\"moving on\")",
                "moving on",
                "When __exit__ returns True, the exception is suppressed.",
            ),
            choice(
                "How many parameters (besides self) does the __exit__ method have?",
                listOf("3", "0", "1", "2"),
                0,
                "Three: the exception's type, value and traceback. When there was no error, all three are None.",
            ),
            fill(
                "Fill in the blank so that x in the with block is an object of the class Resource.",
                "class Resource:\n    def __enter__(self):\n        return ____\n    def __exit__(self, t, v, tb):\n        pass\nwith Resource() as x:\n    print(type(x).__name__)",
                listOf("self", "None", "Resource", "True"),
                "self",
                "__enter__ returns self, so x is the object itself.",
            ),
            output(
                "class Block:\n    def __enter__(self):\n        return self\n    def __exit__(self, t, v, tb):\n        print(t)\nwith Block():\n    pass",
                "None",
                "Without an exception, the error type t is None.",
            ),
        ),
        lesson(
            "u42l3", "contextlib",
            output(
                "from contextlib import contextmanager\n@contextmanager\ndef block():\n    print(\"start\")\n    yield\n    print(\"stop\")\nwith block():\n    print(\"work\")",
                "start\nwork\nstop",
                "The code before yield acts like __enter__, and the code after yield like __exit__.",
            ),
            output(
                "from contextlib import contextmanager\n@contextmanager\ndef number():\n    yield 7\nwith number() as n:\n    print(n * 2)",
                "14",
                "The value from yield goes to the variable after as.",
            ),
            fill(
                "Fill in the blank so the function becomes a context manager.",
                "from contextlib import contextmanager\n@____\ndef tag():\n    print(\"<b>\")\n    yield\n    print(\"</b>\")\nwith tag():\n    print(\"text\")",
                listOf("contextmanager", "suppress", "wraps", "lru_cache"),
                "contextmanager",
                "@contextmanager turns a function with yield into a context manager.",
            ),
            output(
                "from contextlib import suppress\nwith suppress(ZeroDivisionError):\n    print(\"A\")\n    1 / 0\n    print(\"B\")\nprint(\"C\")",
                "A\nC",
                "suppress silences the given exception – the rest of the block is skipped.",
            ),
            choice(
                "What will this code do?",
                listOf("Raise a KeyError", "Suppress the error and print nothing", "Print None", "Raise a ValueError"),
                0,
                "d[\"x\"] raises a KeyError, and suppress silences only the types you list – here ValueError.",
                code = "from contextlib import suppress\nd = {}\nwith suppress(ValueError):\n    print(d[\"x\"])",
            ),
            output(
                "from contextlib import suppress\nnumbers = [1, 2]\nwith suppress(IndexError):\n    print(numbers[5])\nprint(\"done\")",
                "done",
                "The IndexError was suppressed, and the program keeps running.",
            ),
            tiles(
                "Ignore a KeyError in a with block",
                listOf("with", "suppress(", "KeyError", "):"),
                listOf("except", "as"),
                "suppress(Type) silences exceptions of that type.",
            ),
            choice(
                "Which code is equivalent to with suppress(ValueError): ...?",
                listOf("try: ... except ValueError: pass", "try: ... finally: pass", "if ValueError: ...", "raise ValueError"),
                0,
                "suppress is shorthand for an empty except.",
            ),
        ),
        lesson(
            "u42l4", "Review: context managers",
            output(
                "class A:\n    def __enter__(self):\n        print(1)\n        return self\n    def __exit__(self, t, v, tb):\n        print(3)\nwith A():\n    print(2)",
                "1\n2\n3",
                "The order: __enter__, the block body, __exit__.",
            ),
            output(
                "from contextlib import contextmanager\n@contextmanager\ndef parens():\n    print(\"(\", end=\"\")\n    yield\n    print(\")\")\nwith parens():\n    print(\"x\", end=\"\")",
                "(x)",
                "The code before yield and after yield surrounds the block body.",
            ),
            output(
                "from contextlib import suppress\nfor s in [\"1\", \"a\", \"3\"]:\n    with suppress(ValueError):\n        print(int(s))",
                "1\n3",
                "The invalid string \"a\" was skipped.",
            ),
            choice(
                "When does __exit__ run?",
                listOf("Always, when leaving the with block", "Only when there was no error", "Only when there was an error", "Never, you have to call it manually"),
                0,
                "__exit__ always runs – that's what context managers are for.",
            ),
            fill(
                "Fill in the blank to separate the \"enter\" part from the \"exit\" part.",
                "from contextlib import contextmanager\n@contextmanager\ndef timer():\n    print(\"start\")\n    ____\n    print(\"end\")\nwith timer():\n    print(\"task\")",
                listOf("yield", "return", "pass", "break"),
                "yield",
                "A manager made with contextmanager must have exactly one yield.",
            ),
            output(
                "class Value:\n    def __enter__(self):\n        return [1, 2, 3]\n    def __exit__(self, t, v, tb):\n        pass\nwith Value() as items:\n    print(sum(items))",
                "6",
                "items is the result of __enter__.",
            ),
            tiles(
                "Import contextmanager",
                listOf("from", "contextlib", "import", "contextmanager"),
                listOf("functools", "with"),
                "contextmanager is in the contextlib module.",
            ),
        ),
    ),
)
