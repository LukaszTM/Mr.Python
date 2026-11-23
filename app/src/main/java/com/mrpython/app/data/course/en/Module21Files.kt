package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*
import com.mrpython.app.domain.CourseUnit

internal val module21 = CourseUnit(
    id = "u21",
    title = "Files",
    description = "Writing and reading text files",
    lessons = listOf(
        lesson(
            "u21l1", "open, write and read",
            output(
                "f = open(\"notes.txt\", \"w\")\nf.write(\"Hi\")\nf.close()\nf = open(\"notes.txt\")\nprint(f.read())\nf.close()",
                "Hi",
                "First we write text to the file, then we read it back.",
            ),
            choice(
                "What does the mode \"w\" mean in open()?",
                listOf(
                    "Writing",
                    "Reading",
                    "Appending at the end",
                    "Deleting the file",
                ),
                0,
                "\"w\" (write) opens the file for writing and erases the old contents.",
            ),
            choice(
                "What mode does open(\"file.txt\") use without a second argument?",
                listOf("\"r\" – reading", "\"w\" – writing", "\"a\" – appending", "None – it's an error"),
                0,
                "By default a file opens for reading.",
            ),
            fill(
                "Fill in the mode to write text to the file.",
                "f = open(\"notes.txt\", \"____\")\nf.write(\"abc\")\nf.close()",
                listOf("w", "r", "read"),
                "w",
                "The mode for writing is \"w\".",
            ),
            output(
                "f = open(\"data.txt\", \"w\")\nf.write(\"ab\")\nf.write(\"cd\")\nf.close()\nprint(open(\"data.txt\").read())",
                "abcd",
                "write doesn't add a new line – the texts are joined together.",
            ),
            output(
                "f = open(\"numbers.txt\", \"w\")\nf.write(str(5 * 4))\nf.close()\nf = open(\"numbers.txt\")\nprint(int(f.read()) + 1)\nf.close()",
                "21",
                "From the file we read the string \"20\", which we convert to a number.",
            ),
            choice(
                "What happens after f.write(5) for a file opened in mode \"w\"?",
                listOf(
                    "A TypeError",
                    "It writes the string \"5\"",
                    "It writes five spaces",
                    "Nothing happens",
                ),
                0,
                "write only accepts strings, so a number gives a TypeError – convert it with str() first.",
            ),
            tiles(
                "Open the file notes.txt for writing.",
                listOf("f =", "open(", "\"notes.txt\",", "\"w\"", ")"),
                listOf("\"r\"", "read("),
                "open(name, mode) – the mode \"w\" means writing.",
            ),
        ),
        lesson(
            "u21l2", "The with statement",
            output(
                "with open(\"a.txt\", \"w\") as f:\n    f.write(\"OK\")\nwith open(\"a.txt\") as f:\n    print(f.read())",
                "OK",
                "with opens the file and closes it by itself after the block.",
            ),
            choice(
                "What do you gain by writing with open(...) as f?",
                listOf(
                    "The file is closed automatically after the block",
                    "The file opens faster",
                    "The file becomes read-only",
                    "The file is deleted after the block",
                ),
                0,
                "with takes care of closing the file for us.",
            ),
            output(
                "with open(\"a.txt\", \"w\") as f:\n    f.write(\"x\")\nprint(f.closed)",
                "True",
                "After leaving the with block, the file is already closed.",
            ),
            fill(
                "Fill in the blank to name the opened file f.",
                "with open(\"a.txt\", \"w\") ____ f:\n    f.write(\"hi\")",
                listOf("as", "in", "is"),
                "as",
                "with open(...) as name:",
            ),
            output(
                "with open(\"a.txt\", \"w\") as f:\n    f.write(\"Ann\\nhas a cat\")\nwith open(\"a.txt\") as f:\n    print(f.read())",
                "Ann\nhas a cat",
                "The \\n character in a file is a move to a new line.",
            ),
            tiles(
                "Open the file data.txt for reading in a with block.",
                listOf("with", "open(\"data.txt\")", "as", "f:"),
                listOf("in", "for"),
                "with open(name) as f: – no mode means reading.",
            ),
            output(
                "with open(\"a.txt\", \"w\") as f:\n    f.write(\"12345\")\nwith open(\"a.txt\") as f:\n    text = f.read()\nprint(len(text))",
                "5",
                "read() returns the whole contents as a string.",
            ),
            choice(
                "Why is it worth using with for files?",
                listOf(
                    "It always closes the file for you",
                    "Without with you can't read files",
                    "It encrypts the file",
                    "It only works with .txt files",
                ),
                0,
                "with always closes the file – even after an exception.",
            ),
        ),
        lesson(
            "u21l3", "Reading lines",
            output(
                "with open(\"a.txt\", \"w\") as f:\n    f.write(\"a\\nb\\nc\\n\")\nwith open(\"a.txt\") as f:\n    print(len(f.readlines()))",
                "3",
                "readlines() returns a list of lines – here there are three.",
            ),
            output(
                "with open(\"a.txt\", \"w\") as f:\n    f.write(\"x\\ny\\n\")\nwith open(\"a.txt\") as f:\n    for line in f:\n        print(line.strip())",
                "x\ny",
                "A for loop over a file gives its lines one by one.",
            ),
            choice(
                "Why do we often use strip() when reading lines?",
                listOf(
                    "Lines end with the newline character \\n",
                    "Without strip() a line can't be printed",
                    "strip() converts the line to a number",
                    "strip() closes the file",
                ),
                0,
                "strip() removes \\n and spaces from the ends of a line.",
            ),
            output(
                "with open(\"a.txt\", \"w\") as f:\n    f.write(\"one\\ntwo\\n\")\nwith open(\"a.txt\") as f:\n    print(f.readline().strip())",
                "one",
                "readline() reads just one line – the next one.",
            ),
            fill(
                "Fill in the blank to loop over the lines of the file.",
                "with open(\"a.txt\", \"w\") as f:\n    f.write(\"hi\\n\")\nwith open(\"a.txt\") as f:\n    for line ____ f:\n        print(line.strip())",
                listOf("in", "of", "as"),
                "in",
                "We iterate over a file like over a list: for line in f.",
            ),
            output(
                "with open(\"a.txt\", \"w\") as f:\n    f.write(\"3\\n4\\n5\\n\")\ntotal = 0\nwith open(\"a.txt\") as f:\n    for line in f:\n        total += int(line)\nprint(total)",
                "12",
                "int() copes with the newline character at the end.",
            ),
            output(
                "with open(\"a.txt\", \"w\") as f:\n    f.write(\"a\\nb\")\nwith open(\"a.txt\") as f:\n    lines = f.read().split(\"\\n\")\nprint(len(lines))",
                "2",
                "Splitting on \\n gives two lines.",
            ),
            tiles(
                "Read all the lines of the file f into the list lines.",
                listOf("lines", "=", "f.readlines()"),
                listOf("f.readline()", "f.write()"),
                "readlines() returns a list of all the lines.",
            ),
        ),
        lesson(
            "u21l4", "Appending and missing files",
            output(
                "with open(\"log.txt\", \"w\") as f:\n    f.write(\"A\")\nwith open(\"log.txt\", \"a\") as f:\n    f.write(\"B\")\nprint(open(\"log.txt\").read())",
                "AB",
                "The mode \"a\" appends at the end of the file.",
            ),
            output(
                "with open(\"log.txt\", \"w\") as f:\n    f.write(\"A\")\nwith open(\"log.txt\", \"w\") as f:\n    f.write(\"B\")\nprint(open(\"log.txt\").read())",
                "B",
                "Opening in mode \"w\" a second time erased the previous contents.",
            ),
            choice(
                "How is the mode \"a\" different from \"w\"?",
                listOf(
                    "\"a\" appends at the end, \"w\" clears the file",
                    "\"a\" reads the file, \"w\" writes it",
                    "\"a\" deletes the file",
                    "There is no difference",
                ),
                0,
                "\"a\" (append) keeps the old contents.",
            ),
            fill(
                "Fill in the mode so the program prints 12.",
                "with open(\"log.txt\", \"w\") as f:\n    f.write(\"1\")\nwith open(\"log.txt\", \"____\") as f:\n    f.write(\"2\")\nprint(open(\"log.txt\").read())",
                listOf("a", "w", "r"),
                "a",
                "Only the mode \"a\" keeps the 1 written earlier.",
            ),
            output(
                "with open(\"log.txt\", \"w\") as f:\n    pass\nfor i in range(3):\n    with open(\"log.txt\", \"a\") as f:\n        f.write(str(i))\nprint(open(\"log.txt\").read())",
                "012",
                "Each time the file is opened in mode \"a\", another digit is appended.",
            ),
            tiles(
                "Open the file log.txt for appending.",
                listOf("with", "open(\"log.txt\",", "\"a\")", "as f:"),
                listOf("\"w\")", "\"r\")"),
                "The mode \"a\" is for appending.",
            ),
            output(
                "try:\n    open(\"missing.txt\")\nexcept FileNotFoundError:\n    print(\"no such file\")",
                "no such file",
                "Reading a file that doesn't exist raises a FileNotFoundError.",
            ),
            choice(
                "What does open(\"new.txt\", \"a\") do if the file doesn't exist?",
                listOf("It creates an empty file", "It raises a FileNotFoundError", "It returns None", "It creates a folder"),
                0,
                "The modes \"a\" and \"w\" create a missing file – only reading raises an error.",
            ),
        ),
        lesson(
            "u21l5", "Review: files",
            output(
                "with open(\"p.txt\", \"w\") as f:\n    f.write(\"Ann\\n\")\n    f.write(\"Bob\\n\")\nwith open(\"p.txt\") as f:\n    names = [l.strip() for l in f]\nprint(names)",
                "['Ann', 'Bob']",
                "A list comprehension works on the lines of a file too.",
            ),
            output(
                "def load(name):\n    try:\n        with open(name) as f:\n            return f.read()\n    except FileNotFoundError:\n        return \"missing\"\n\nprint(load(\"unknown.txt\"))",
                "missing",
                "We catch the missing file and return a fallback value.",
            ),
            choice(
                "Which mode removes the file's existing contents?",
                listOf("\"w\"", "\"a\"", "\"r\"", "None of them"),
                0,
                "The mode \"w\" starts the file from scratch.",
            ),
            fill(
                "Fill in the name of the error.",
                "try:\n    open(\"missing.txt\")\nexcept ____:\n    print(\"file not found\")",
                listOf("FileNotFoundError", "KeyError", "FileError"),
                "FileNotFoundError",
                "A missing file is a FileNotFoundError.",
            ),
            output(
                "with open(\"p.txt\", \"w\") as f:\n    f.write(\"a\")\nwith open(\"p.txt\", \"a\") as f:\n    f.write(\"a\")\nwith open(\"p.txt\") as f:\n    print(f.read() * 2)",
                "aaaa",
                "The file contains \"aa\", and a string times 2 is \"aaaa\".",
            ),
            tiles(
                "Loop over the lines of the file f.",
                listOf("for", "line", "in", "f:"),
                listOf("f.read():", "while"),
                "A for loop over a file returns its lines one by one.",
            ),
            output(
                "with open(\"p.txt\", \"w\") as f:\n    f.write(\"1 2 3\")\nwith open(\"p.txt\") as f:\n    numbers = f.read().split()\nprint(sum(map(int, numbers)))",
                "6",
                "split() splits the text into strings, and map(int, …) converts them to numbers.",
            ),
            choice(
                "What does f.read() return for an empty file?",
                listOf("An empty string \"\"", "None", "FileNotFoundError", "0"),
                0,
                "An empty file is an empty string.",
            ),
        ),
    ),
)
