package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*
import com.mrpython.app.domain.CourseUnit

internal val module47 = CourseUnit(
    id = "u47",
    title = "CSV and tabular data",
    description = "Rows, columns, the csv module and simple statistics",
    lessons = listOf(
        lesson(
            "u47l1", "Splitting lines",
            output(
                "line = \"Amy,25,Boston\"\nfields = line.split(\",\")\nprint(fields[2])",
                "Boston",
                "split(\",\") splits a CSV row into fields.",
            ),
            output(
                "fields = \"John,30\".split(\",\")\nprint(int(fields[1]) + 1)",
                "31",
                "Fields are strings – a number has to be converted with int().",
            ),
            output(
                "line = \"a,b\\n\"\nprint(line.strip().split(\",\"))",
                "['a', 'b']",
                "strip() removes the newline character from the end of the row.",
            ),
            output(
                "text = \"x,1\\ny,2\"\nfor row in text.splitlines():\n    print(row.split(\",\")[0])",
                "x\ny",
                "splitlines() splits the text into rows.",
            ),
            choice(
                "How many items does split(\",\") give for this row?",
                listOf("3", "2", "1", "Error"),
                0,
                "A comma inside quotes also cuts the string – that's why the csv module is better for CSV.",
                code = "row = '\"Smith, John\",30'\nprint(len(row.split(\",\")))",
            ),
            output(
                "data = \"a;b;c\"\nprint(data.split(\";\"))",
                "['a', 'b', 'c']",
                "The separator can also be a semicolon.",
            ),
            fill(
                "Fill in the blank to split the row into fields.",
                "line = \"apple,3,2.5\"\nfields = line.____(\",\")\nprint(fields[1])",
                listOf("split", "join", "strip"),
                "split",
                "split() splits a string; join() glues pieces together, and strip() doesn't split.",
            ),
            tiles(
                "Split the row line at the commas and store the result in the variable fields",
                listOf("fields", "=", "line.split(\",\")"),
                listOf("line.join(\",\")", "split(line)"),
                "We call split on the string and pass the separator.",
            ),
        ),
        lesson(
            "u47l2", "csv.reader and csv.writer",
            output(
                "import csv, io\nf = io.StringIO(\"a,b\\n1,2\\n\")\nfor row in csv.reader(f):\n    print(row)",
                "['a', 'b']\n['1', '2']",
                "csv.reader returns each row as a list of strings.",
            ),
            output(
                "import csv, io\nf = io.StringIO('\"Smith, John\",30')\nprint(next(csv.reader(f)))",
                "['Smith, John', '30']",
                "csv.reader understands quotes, so a comma inside them doesn't split the field.",
            ),
            output(
                "import csv, io\nf = io.StringIO(\"x;y;z\")\nr = csv.reader(f, delimiter=\";\")\nprint(next(r))",
                "['x', 'y', 'z']",
                "delimiter sets the column separator.",
            ),
            choice(
                "What is io.StringIO used for in these examples?",
                listOf(
                    "It acts as a file in memory",
                    "It saves data to disk",
                    "It converts text to numbers",
                    "It downloads a file from the internet",
                ),
                0,
                "StringIO behaves like an open text file in memory.",
            ),
            output(
                "import csv, io\nf = io.StringIO()\nw = csv.writer(f)\nw.writerow([\"a\", 1])\nprint(f.getvalue().strip())",
                "a,1",
                "writerow() writes a list as one CSV row.",
            ),
            output(
                "import csv, io\nf = io.StringIO()\ncsv.writer(f).writerow([\"x,y\", 2])\nprint(f.getvalue().strip())",
                "\"x,y\",2",
                "The writer puts a field containing a comma in quotes on its own.",
            ),
            fill(
                "Fill in the blank to write one row.",
                "import csv, io\nf = io.StringIO()\nw = csv.writer(f)\nw.____([\"Amy\", 25])\nprint(f.getvalue().strip())",
                listOf("writerow", "write", "append"),
                "writerow",
                "A csv.writer object has a writerow() method; write and append don't exist.",
            ),
            tiles(
                "Create a CSV reader for the file f and store it in the variable r",
                listOf("r", "=", "csv.reader(", "f)"),
                listOf("csv.writer(", "f.reader("),
                "csv.reader(file) returns an object we iterate over row by row.",
            ),
        ),
        lesson(
            "u47l3", "DictReader and statistics",
            output(
                "import csv, io\nf = io.StringIO(\"name,age\\nAmy,25\\nJohn,30\")\nfor r in csv.DictReader(f):\n    print(r[\"name\"])",
                "Amy\nJohn",
                "DictReader uses the header as the dictionary keys.",
            ),
            output(
                "import csv, io\nf = io.StringIO(\"name,age\\nAmy,25\")\nprint(next(csv.DictReader(f)))",
                "{'name': 'Amy', 'age': '25'}",
                "Each row is a dictionary: column → value (a string).",
            ),
            output(
                "import csv, io\nf = io.StringIO(\"a,b\\n1,2\")\nr = csv.DictReader(f)\nprint(r.fieldnames)",
                "['a', 'b']",
                "fieldnames is the list of column names from the header.",
            ),
            output(
                "import csv, io\nf = io.StringIO(\"n,price\\nA,10\\nB,20\")\ntotal = 0\nfor r in csv.DictReader(f):\n    total += int(r[\"price\"])\nprint(total)",
                "30",
                "We sum the column, converting each value to int.",
            ),
            output(
                "import csv, io\nf = io.StringIO(\"p\\n4\\n5\\n3\")\ngrades = [int(r[\"p\"]) for r in csv.DictReader(f)]\nprint(sum(grades) / len(grades))",
                "4.0",
                "The average is the sum divided by the number of rows.",
            ),
            choice(
                "What happens without int()?",
                listOf("TypeError", "It prints 30", "It prints 1020", "It prints 0"),
                0,
                "Values from CSV are strings, and 0 + \"10\" raises a TypeError – you can't add a string to a number.",
                code = "import csv, io\nf = io.StringIO(\"c\\n10\\n20\")\ns = 0\nfor r in csv.DictReader(f):\n    s += r[\"c\"]\nprint(s)",
            ),
            fill(
                "Fill in the blank to read rows as dictionaries.",
                "import csv, io\nf = io.StringIO(\"x\\n7\")\nfor r in csv.____(f):\n    print(r[\"x\"])",
                listOf("DictReader", "reader", "writer"),
                "DictReader",
                "A plain reader gives lists, so r[\"x\"] would raise an error.",
            ),
            choice(
                "What value does r[\"age\"] from DictReader have for the row \"Amy,25\"?",
                listOf("'25' (a string)", "25 (int)", "25.0 (float)", "None"),
                0,
                "The csv module doesn't convert anything – all fields are strings.",
            ),
        ),
        lesson(
            "u47l4", "Review: CSV",
            output(
                "print(\"Eve,22,Denver\".split(\",\")[1])",
                "22",
                "The second field has index 1.",
            ),
            output(
                "import csv, io\nf = io.StringIO('a,\"b,c\",d')\nprint(len(next(csv.reader(f))))",
                "3",
                "csv.reader treats the quoted \"b,c\" as one field.",
            ),
            output(
                "import csv, io\nf = io.StringIO(\"k,v\\nx,1\\ny,5\")\nd = {r[\"k\"]: int(r[\"v\"]) for r in csv.DictReader(f)}\nprint(d)",
                "{'x': 1, 'y': 5}",
                "It's easy to build a dictionary from DictReader rows.",
            ),
            output(
                "import csv, io\nf = io.StringIO(\"t\\n3\\n9\\n6\")\nt = [int(r[\"t\"]) for r in csv.DictReader(f)]\nprint(max(t), min(t))",
                "9 3",
                "After converting to int we can compute the max and min of a column.",
            ),
            choice(
                "Why is the csv module better for CSV than split(\",\")?",
                listOf(
                    "It correctly handles quoted fields that contain commas",
                    "It is the only way to read text",
                    "It automatically converts fields to numbers",
                    "split doesn't work on strings with digits",
                ),
                0,
                "csv understands quotes, while split cuts at every comma.",
            ),
            fill(
                "Fill in the blank to read columns separated by a semicolon.",
                "import csv, io\nf = io.StringIO(\"a;b\")\nprint(next(csv.reader(f, ____=\";\")))",
                listOf("delimiter", "sep", "split"),
                "delimiter",
                "The parameter is called delimiter; sep and split would raise a TypeError.",
            ),
            choice(
                "What does f.getvalue() return for an io.StringIO object?",
                listOf("All the text (str)", "A list of rows (list)", "The character count (int)", "The file name (str)"),
                0,
                "getvalue() returns the entire contents of the buffer.",
            ),
            tiles(
                "Write the list row as one CSV row using the writer w",
                listOf("w.writerow(", "row)"),
                listOf("w.write(", "csv.writerow("),
                "The writer object's writerow() method writes one list.",
            ),
        ),
    ),
)
