package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

internal val module21Intro = lesson(
    "u21l0", "Introduction: files",
    explain(
        "Why files?",
        "Variables disappear when the program ends. A file stays on the disk – you can save notes " +
            "or results in it and load them later. You open a file with the function `open(name, mode)`, " +
            "and when you're done you close it with `close()`.",
    ),
    explain(
        "Writing and reading",
        "The mode `\"w\"` is for writing: it creates the file or clears its old contents. Without a mode the file opens " +
            "for reading, and `read()` returns the whole content as a string. `write()` only accepts strings.",
        code = "f = open(\"notes.txt\", \"w\")\nf.write(\"Hi\")\nf.close()\nf = open(\"notes.txt\")\nprint(f.read())\nf.close()",
        output = "Hi",
    ),
    explain(
        "The with statement",
        "`with open(...) as f:` closes the file by itself when the block ends – even when an error occurs. " +
            "That way you don't have to remember `close()`.",
        code = "with open(\"a.txt\", \"w\") as f:\n    f.write(\"OK\")\nwith open(\"a.txt\") as f:\n    print(f.read())",
        output = "OK",
    ),
    explain(
        "Reading lines",
        "You can go through a file with a `for` loop – line by line. Every line ends with the `\\n` character, " +
            "so we usually cut it off with `strip()`.",
        code = "with open(\"a.txt\", \"w\") as f:\n    f.write(\"x\\ny\\n\")\nwith open(\"a.txt\") as f:\n    for line in f:\n        print(line.strip())",
        output = "x\ny",
    ),
    explain(
        "Appending and missing files",
        "The mode `\"a\"` appends at the end of the file instead of clearing it. Opening a file that doesn't " +
            "exist for reading raises a `FileNotFoundError` – you can catch it in a `try`.",
        code = "try:\n    open(\"missing.txt\")\nexcept FileNotFoundError:\n    print(\"no such file\")",
        output = "no such file",
    ),
    choice(
        "How is the mode \"a\" different from \"w\"?",
        listOf("\"a\" appends at the end, \"w\" clears the file", "\"a\" reads the file, \"w\" writes it", "\"a\" deletes the file", "There is no difference"),
        0,
        "\"a\" (append) keeps the old contents.",
    ),
    output(
        "with open(\"log.txt\", \"w\") as f:\n    f.write(\"A\")\nwith open(\"log.txt\", \"a\") as f:\n    f.write(\"B\")\nprint(open(\"log.txt\").read())",
        "AB",
        "The mode \"a\" appended B after A.",
    ),
    fill(
        "Fill in the blank to open the file in a with block.",
        "with open(\"a.txt\", \"w\") ____ f:\n    f.write(\"hi\")",
        listOf("as", "in", "is"),
        "as",
        "The syntax is with open(...) as name:.",
    ),
)
