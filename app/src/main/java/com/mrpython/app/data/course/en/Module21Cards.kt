package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

internal val module21Cards = listOf(
    cards(
        "u21l1",
        explain(
            "Mode \"r\" and repeated write()",
            "Without a mode, `open()` uses the mode `\"r\"` (read). Several `write()` calls write " +
                "the texts one after another – `write()` adds neither a space nor a new line by itself.",
            code = "f = open(\"a.txt\", \"w\")\nf.write(\"ab\")\nf.write(\"cd\")\nf.close()\nprint(open(\"a.txt\", \"r\").read())",
            output = "abcd",
        ),
        explain(
            "Numbers in a file",
            "A text file contains only strings. You write a number with `str()`, and after reading " +
                "you convert it back with `int()` or `float()` – otherwise `\"7\" * 3` gives \"777\".",
            code = "f = open(\"a.txt\", \"w\")\nf.write(str(20))\nf.close()\nx = open(\"a.txt\").read()\nprint(int(x) + 1, x * 2)",
            output = "21 2020",
        ),
        explain(
            "A closed file",
            "`close()` finishes work with the file and saves the changes to disk. After closing you can " +
                "no longer write or read – trying to `write()` raises a `ValueError`.",
            code = "f = open(\"a.txt\", \"w\")\nf.close()\ntry:\n    f.write(\"x\")\nexcept ValueError:\n    print(\"file closed\")",
            output = "file closed",
        ),
    ),
    cards(
        "u21l2",
        explain(
            "Is the file closed?",
            "The attribute `f.closed` tells you whether the file is already closed. Inside the `with` block it's `False`, " +
                "and right after it – `True`. That's why writing to `f` after the block ends in an error.",
            code = "with open(\"a.txt\", \"w\") as f:\n    print(f.closed)\nprint(f.closed)",
            output = "False\nTrue",
        ),
        explain(
            "The second read() is empty",
            "A file remembers how far you've already read. The first `read()` takes the whole content, so the next " +
                "one returns an empty string \"\". An empty file gives \"\" too.",
            code = "with open(\"a.txt\", \"w\") as f:\n    f.write(\"abc\")\nwith open(\"a.txt\") as f:\n    a = f.read()\n    b = f.read()\nprint(len(a), len(b))",
            output = "3 0",
        ),
    ),
    cards(
        "u21l3",
        explain(
            "readline and readlines",
            "`readline()` reads one line – the next one (including the `\\n` character), and when no lines are left it returns \"\". " +
                "`readlines()` returns a list of all the lines.",
            code = "with open(\"a.txt\", \"w\") as f:\n    f.write(\"one\\ntwo\\n\")\nwith open(\"a.txt\") as f:\n    print(f.readline().strip())\n    print(f.readlines())",
            output = "one\n['two\\n']",
        ),
        explain(
            "Numbers from lines",
            "A line from a file is a string ending with `\\n` – that's why `len(\"hey\\n\")` is 4. The functions `int()` " +
                "and `float()` skip `\\n` and spaces at the edges by themselves, so `int(\"5\\n\")` is 5.",
            code = "with open(\"a.txt\", \"w\") as f:\n    f.write(\"5\\n\")\nwith open(\"a.txt\") as f:\n    line = f.readline()\nprint(len(line), int(line) * 2)",
            output = "2 10",
        ),
    ),
    cards(
        "u21l4",
        explain(
            "Modes create the file",
            "The modes `\"w\"` and `\"a\"` create the file when it doesn't exist – only reading raises " +
                "a `FileNotFoundError`. You can make an empty file using a `with` block with just `pass` inside.",
            code = "with open(\"new.txt\", \"w\") as f:\n    pass\nwith open(\"new.txt\") as f:\n    print(len(f.read()))",
            output = "0",
        ),
    ),
)
