package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

internal val module42Cards = listOf(
    cards(
        "u42l1",
        explain(
            "What's left after a with block",
            "Variables created in the block remain after it, but the file is already closed – reading from it " +
                "gives a `ValueError`. `write()` returns the number of characters written, and `readlines()` a list of lines.",
            code = "with open(\"notes.txt\", \"w\") as f:\n    n = f.write(\"one\\ntwo\")\nwith open(\"notes.txt\") as f:\n    lines = f.readlines()\nprint(n, len(lines), f.closed)",
            output = "7 2 True",
        ),
        explain(
            "with doesn't catch exceptions",
            "When an exception occurs in the block, `with` closes the file, but the error keeps going. " +
                "You have to catch it with a regular `try` / `except`.",
            code = "try:\n    with open(\"notes.txt\", \"w\") as f:\n        raise ValueError\nexcept ValueError:\n    print(\"error\", f.closed)",
            output = "error True",
        ),
    ),
    cards(
        "u42l2",
        explain(
            "The parameters of __exit__",
            "`t` is the exception type, `v` the exception itself (printing it shows the message), and `tb` the traceback. " +
                "When the block finished without an error, all three are `None`.",
            code = "class Block:\n    def __enter__(self): return self\n    def __exit__(self, t, v, tb):\n        print(t.__name__, v)\n        return True\nwith Block(): raise ValueError(\"bad\")",
            output = "ValueError bad",
        ),
        explain(
            "When __exit__ doesn't suppress",
            "If `__exit__` returns `False` or nothing (`None`), the exception keeps going – but only after " +
                "`__exit__` has run. The rest of the block after the error is skipped.",
            code = "class Block:\n    def __enter__(self): return self\n    def __exit__(self, t, v, tb): print(\"exit\")\ntry:\n    with Block(): 1 / 0\nexcept ZeroDivisionError: print(\"caught\")",
            output = "exit\ncaught",
        ),
        explain(
            "__enter__ without return",
            "The variable after `as` gets whatever `__enter__` returns. Without `return` that's `None`, " +
                "which is why we usually write `return self`.",
            code = "class Missing:\n    def __enter__(self): pass\n    def __exit__(self, t, v, tb): pass\nwith Missing() as x:\n    print(x)",
            output = "None",
        ),
    ),
    cards(
        "u42l3",
        explain(
            "The value from yield",
            "The value given to `yield` goes to the variable after `as`. A manager made with `@contextmanager` " +
                "can also take arguments like a regular function.",
            code = "from contextlib import contextmanager\n@contextmanager\ndef block(n):\n    yield n * 10\nwith block(3) as x:\n    print(x)",
            output = "30",
        ),
        explain(
            "An error at the yield",
            "An exception from the block shows up in the function at the `yield`. Without `try`, the code after `yield` " +
                "won't run – that's why we put cleanup in `finally`.",
            code = "from contextlib import contextmanager\n@contextmanager\ndef block():\n    try: yield\n    finally: print(\"cleaning up\")\nwith block(): print(\"work\")",
            output = "work\ncleaning up",
        ),
        explain(
            "suppress with several types",
            "`suppress` can take several exception types at once. An exception of a different type won't be " +
                "suppressed and will keep going.",
            code = "from contextlib import suppress\nwith suppress(ValueError, TypeError):\n    print(1 + \"a\")\nprint(\"ok\")",
            output = "ok",
        ),
    ),
)
