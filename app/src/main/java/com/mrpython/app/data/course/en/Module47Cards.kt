package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

internal val module47Cards = listOf(
    cards(
        "u47l1",
        explain(
            "Text into rows: splitlines",
            "`splitlines()` splits the whole text into a list of rows – it cuts at the newline character `\\n`. " +
                "A row read from a file often ends with `\\n`, which stays in the last field; " +
                "`strip()` removes it.",
            code = "text = \"a,1\\nb,2\"\nprint(text.splitlines())\nprint(\"x,y\\n\".strip().split(\",\"))",
            output = "['a,1', 'b,2']\n['x', 'y']",
        ),
        explain(
            "Empty fields and join",
            "Two commas next to each other mean an empty field – `split` then returns an empty string `''`. " +
                "Going the other way, `\",\".join(list)` glues the fields back into one CSV row.",
            code = "print(\"a,,c\".split(\",\"))\nprint(\",\".join([\"Amy\", \"25\"]))",
            output = "['a', '', 'c']\nAmy,25",
        ),
    ),
    cards(
        "u47l2",
        explain(
            "Row by row: next",
            "`csv.reader` hands out rows one at a time, like an iterator. `next(r)` fetches the next row " +
                "(e.g. a header we want to skip), and `list(r)` collects all the remaining ones.",
            code = "import csv, io\nr = csv.reader(io.StringIO(\"a,b\\n1,2\\n3,4\"))\nnext(r)\nprint(list(r))",
            output = "[['1', '2'], ['3', '4']]",
        ),
        explain(
            "writerows and getvalue",
            "`writerow(list)` writes one row, and `writerows(list_of_lists)` writes many at once. " +
                "Each row ends with a newline character. `getvalue()` returns all the text " +
                "written to an `io.StringIO`.",
            code = "import csv, io\nf = io.StringIO()\ncsv.writer(f).writerows([[1, 2], [3, 4]])\nprint(f.getvalue().splitlines())",
            output = "['1,2', '3,4']",
        ),
    ),
    cards(
        "u47l3",
        explain(
            "Column names: fieldnames",
            "The `fieldnames` attribute of a `DictReader` object is the list of column names taken from the header. " +
                "It's handy when you want to check which columns a file has.",
            code = "import csv, io\nr = csv.DictReader(io.StringIO(\"name,age\\nAmy,25\"))\nprint(r.fieldnames)",
            output = "['name', 'age']",
        ),
    ),
)
