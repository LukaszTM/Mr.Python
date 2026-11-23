package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

internal val module20Cards = listOf(
    cards(
        "u20l1",
        explain(
            "Two ways to import",
            "After `import datetime` you write the full name `datetime.date(...)` – first the module, then the type. " +
                "After `from datetime import date`, just `date(...)` is enough.",
            code = "import datetime\nd = datetime.date(2024, 3, 15)\nprint(d)",
            output = "2024-03-15",
        ),
        explain(
            "Real dates only",
            "Python checks whether such a day exists. `date(2025, 2, 30)` or month 13 raise a " +
                "`ValueError`. February 29 only works in a leap year, e.g. 2024.",
            code = "from datetime import date\ntry:\n    date(2025, 2, 30)\nexcept ValueError:\n    print(\"no such day\")",
            output = "no such day",
        ),
        explain(
            "Date parts are numbers",
            "`d.day`, `d.month` and `d.year` are plain `int` numbers – no leading zeros. Adding something " +
                "to them doesn't change the date. `str(d)` gives a YYYY-MM-DD string (always 10 characters).",
            code = "from datetime import date\nd = date(2025, 1, 31)\nprint(d.day + 1)\nprint(\"Date: \" + str(d))",
            output = "32\nDate: 2025-01-31",
        ),
    ),
    cards(
        "u20l2",
        explain(
            "Weeks and going back",
            "`timedelta` also accepts `weeks=`: a week is 7 days. You can subtract a time span from a date " +
                "to go back in time, and you can add two time spans together.",
            code = "from datetime import date, timedelta\nprint(timedelta(weeks=2).days)\nd = date(2024, 3, 1)\nprint(d - timedelta(days=1))",
            output = "14\n2024-02-29",
        ),
        explain(
            "What can be combined with what?",
            "Date + span = date. Date − date = span (negative when the first date is earlier). " +
                "Two dates can't be added – that's a `TypeError`.",
            code = "from datetime import date\na = date(2025, 1, 10)\nb = date(2025, 1, 20)\nprint((a - b).days)",
            output = "-10",
        ),
    ),
    cards(
        "u20l3",
        explain(
            "A date within a range",
            "Comparisons can be chained: `a <= d <= b` means \"d is between a and b (inclusive)\". " +
                "You can sort a list of dates with `sort()` or `sorted()` – starting from the earliest.",
            code = "from datetime import date\nd = date(2024, 6, 15)\nprint(date(2024, 1, 1) <= d <= date(2024, 12, 31))",
            output = "True",
        ),
        explain(
            "A date is not a string",
            "You can only compare a date with another date. Comparing with `<` against a string, e.g. \"2026-01-01\", " +
                "raises a `TypeError`, and `==` with a string simply gives `False`.",
            code = "from datetime import date\nprint(date(2025, 1, 1) == \"2025-01-01\")",
            output = "False",
        ),
    ),
    cards(
        "u20l4",
        explain(
            "More about the pattern",
            "Plain text in a `strftime` pattern is copied unchanged. Letter case matters: " +
                "`%Y` is the year 2025, `%y` is just 25, and `%M` is minutes, not the month. The result is always a string.",
            code = "from datetime import date\nd = date(2025, 5, 4)\nprint(d.strftime(\"Year %Y, %y\"))\nprint(d.strftime(\"%Y%m%d\"))",
            output = "Year 2025, 25\n20250504",
        ),
        explain(
            "The name of the weekday",
            "The number from `weekday()` works great as an index into a list of day names. " +
                "The weekend is `weekday() >= 5`.",
            code = "from datetime import date\ndays = [\"Mon\", \"Tue\", \"Wed\", \"Thu\", \"Fri\", \"Sat\", \"Sun\"]\nd = date(2025, 10, 22)\nprint(days[d.weekday()])",
            output = "Wed",
        ),
    ),
)
