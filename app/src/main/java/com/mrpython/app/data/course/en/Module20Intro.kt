package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

internal val module20Intro = lesson(
    "u20l0", "Introduction: date and time",
    explain(
        "A date: date",
        "The `datetime` module has the `date` type for storing dates. You pass the year, month and day – in that " +
            "order. You can read the parts of a date with `.year`, `.month` and `.day`.",
        code = "from datetime import date\nd = date(2024, 12, 24)\nprint(d)\nprint(d.month)",
        output = "2024-12-24\n12",
    ),
    explain(
        "A time span: timedelta",
        "A `timedelta` is a span of time, e.g. `timedelta(days=5)`. Added to a date, it moves the date – Python " +
            "takes care of month ends and leap years for you.",
        code = "from datetime import date, timedelta\nd = date(2024, 1, 30)\nprint(d + timedelta(days=5))",
        output = "2024-02-04",
    ),
    explain(
        "How many days have passed?",
        "Subtracting two dates gives a `timedelta`. Its `.days` field tells you how many days separate the dates – " +
            "perfect for counting down, e.g. to a birthday.",
        code = "from datetime import date\na = date(2024, 3, 10)\nb = date(2024, 3, 1)\nprint((a - b).days)",
        output = "9",
    ),
    explain(
        "Comparing dates",
        "You compare dates like numbers: an earlier date is \"smaller\". That's why `<`, `==`, " +
            "`min()` and sorting all work.",
        code = "from datetime import date\na = date(2024, 5, 1)\nb = date(2023, 7, 9)\nprint(a > b)\nprint(min(a, b))",
        output = "True\n2023-07-09",
    ),
    explain(
        "strftime and weekday",
        "`strftime()` turns a date into a string in a format you choose: `%d` – day, `%m` – month, " +
            "`%Y` – year. `weekday()` returns the day of the week: 0 is Monday, 6 is Sunday.",
        code = "from datetime import date\nd = date(2024, 1, 1)\nprint(d.strftime(\"%d.%m.%Y\"))\nprint(d.weekday())",
        output = "01.01.2024\n0",
    ),
    output(
        "from datetime import date\nd = date(2025, 5, 9)\nprint(d.year)",
        "2025",
        "The year field holds the date's year.",
    ),
    choice(
        "What type is the result of subtracting two dates?",
        listOf("timedelta", "date", "int", "str"),
        0,
        "The difference of dates is a time span – a timedelta.",
    ),
    fill(
        "Fill in the blank to move the date by one week.",
        "from datetime import date, timedelta\nd = date(2025, 6, 1)\nprint(d + timedelta(____=7))",
        listOf("days", "day", "months"),
        "days",
        "timedelta accepts the argument days.",
    ),
)
