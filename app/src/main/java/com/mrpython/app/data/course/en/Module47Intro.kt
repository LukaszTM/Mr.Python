package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

internal val module47Intro = lesson(
    "u47l0", "Introduction: CSV and tabular data",
    explain(
        "What is CSV?",
        "CSV is a simple table format: each row is one line of text, and the columns are separated by " +
            "a comma (sometimes a semicolon). This is how spreadsheets export data. You can split " +
            "a row with the `split(\",\")` method – the fields are strings.",
        code = "line = \"Amy,25,Boston\"\nfields = line.split(\",\")\nprint(fields[2])\nprint(int(fields[1]) + 1)",
        output = "Boston\n26",
    ),
    explain(
        "The split trap",
        "A quoted field can contain a comma, e.g. \"Smith, John\". `split` cuts at every " +
            "comma, while the `csv` module understands quotes. `io.StringIO` pretends to be a file kept " +
            "in memory – it will come in handy in the examples.",
        code = "import csv, io\nrow = '\"Smith, John\",30'\nprint(len(row.split(\",\")))\nprint(next(csv.reader(io.StringIO(row))))",
        output = "3\n['Smith, John', '30']",
    ),
    explain(
        "csv.reader and csv.writer",
        "`csv.reader(file)` returns each row as a list of strings, and `delimiter=\";\"` changes " +
            "the separator. `csv.writer(file).writerow(list)` writes one row and adds " +
            "quotes on its own when needed.",
        code = "import csv, io\nf = io.StringIO()\ncsv.writer(f).writerow([\"x,y\", 2])\nprint(f.getvalue().strip())",
        output = "\"x,y\",2",
    ),
    explain(
        "DictReader",
        "`csv.DictReader` takes the first row as the header and returns the following rows as " +
            "dictionaries: column name → value. That lets you write `r[\"name\"]` instead of `r[0]`.",
        code = "import csv, io\nf = io.StringIO(\"name,age\\nAmy,25\\nJohn,30\")\nfor r in csv.DictReader(f):\n    print(r[\"name\"], r[\"age\"])",
        output = "Amy 25\nJohn 30",
    ),
    explain(
        "Simple statistics",
        "The `csv` module doesn't convert anything to numbers – all fields are strings. Before computing " +
            "a sum, an average or a maximum we use `int()` or `float()`.",
        code = "import csv, io\nf = io.StringIO(\"price\\n10\\n20\\n30\")\nc = [int(r[\"price\"]) for r in csv.DictReader(f)]\nprint(sum(c), max(c))",
        output = "60 30",
    ),
    output(
        "print(\"Eve,22,Denver\".split(\",\")[0])",
        "Eve",
        "The first field of a row has index 0.",
    ),
    choice(
        "What type are the values read by csv.reader?",
        listOf("Strings (str)", "Numbers (int)", "It depends on the content", "Tuples"),
        0,
        "The csv module returns all fields as strings.",
    ),
    fill(
        "Fill in the blank to read rows as dictionaries.",
        "import csv, io\nf = io.StringIO(\"x\\n7\")\nfor r in csv.____(f):\n    print(r[\"x\"])",
        listOf("DictReader", "reader", "writer"),
        "DictReader",
        "A plain reader gives lists, so r[\"x\"] would raise an error.",
    ),
)
