package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*
import com.mrpython.app.domain.CourseUnit

internal val module20 = CourseUnit(
    id = "u20",
    title = "Date and time",
    description = "Dates, time spans and formatting",
    lessons = listOf(
        lesson(
            "u20l1", "Dates: datetime.date",
            output(
                "import datetime\nd = datetime.date(2024, 3, 15)\nprint(d)",
                "2024-03-15",
                "A date prints in the format year-month-day.",
            ),
            output(
                "from datetime import date\nd = date(2024, 12, 24)\nprint(d.year)\nprint(d.month)",
                "2024\n12",
                "The attributes year and month hold the year and the month.",
            ),
            choice(
                "In what order do you pass the arguments to date(...)?",
                listOf("year, month, day", "day, month, year", "month, day, year", "any order"),
                0,
                "date(year, month, day) – starting from the largest unit.",
            ),
            fill(
                "Fill in the blank to print the day of the month.",
                "from datetime import date\nd = date(2025, 5, 9)\nprint(d.____)",
                listOf("day", "days", "date"),
                "day",
                "The day of the month is the attribute day.",
            ),
            output(
                "from datetime import date\nd = date(2025, 1, 31)\nprint(d.day + 1)",
                "32",
                "d.day is a plain int – adding to it doesn't change the date.",
            ),
            choice(
                "What happens after date(2025, 2, 30)?",
                listOf(
                    "ValueError – February doesn't have 30 days",
                    "It creates the date March 2",
                    "It creates the date February 28",
                    "Nothing",
                ),
                0,
                "Python checks whether such a day exists.",
            ),
            tiles(
                "Create the date May 1, 2025.",
                listOf("d =", "date(", "2025, 5, 1", ")"),
                listOf("1, 5, 2025", "date.today("),
                "The order is year, month, day.",
            ),
            output(
                "from datetime import date\nd = date(2024, 7, 4)\nprint(\"Date: \" + str(d))",
                "Date: 2024-07-04",
                "str(d) turns the date into a YYYY-MM-DD string.",
            ),
        ),
        lesson(
            "u20l2", "timedelta – time spans",
            output(
                "from datetime import date, timedelta\nd = date(2024, 1, 30)\nprint(d + timedelta(days=5))",
                "2024-02-04",
                "timedelta rolls over into the next month by itself.",
            ),
            output(
                "from datetime import date\na = date(2024, 3, 10)\nb = date(2024, 3, 1)\nprint((a - b).days)",
                "9",
                "The difference of two dates is a timedelta, and .days is the number of days.",
            ),
            choice(
                "What type is the result of subtracting two dates?",
                listOf("timedelta", "date", "int", "str"),
                0,
                "A date minus a date is a time span – a timedelta.",
            ),
            fill(
                "Fill in the blank to move the date one week forward.",
                "from datetime import date, timedelta\nd = date(2025, 6, 1)\nprint(d + timedelta(____=7))",
                listOf("days", "day", "date"),
                "days",
                "The timedelta parameter is days (plural).",
            ),
            output(
                "from datetime import date, timedelta\nd = date(2024, 3, 1)\nprint(d - timedelta(days=1))",
                "2024-02-29",
                "2024 is a leap year, so February has 29 days.",
            ),
            output(
                "from datetime import timedelta\nt = timedelta(weeks=2)\nprint(t.days)",
                "14",
                "Two weeks is 14 days.",
            ),
            tiles(
                "Add 10 days to the date d.",
                listOf("d", "+", "timedelta(", "days=10", ")"),
                listOf("-", "date("),
                "We add a timedelta to a date.",
            ),
            output(
                "from datetime import date\nstart = date(2025, 1, 1)\nend = date(2025, 12, 31)\nprint((end - start).days + 1)",
                "365",
                "There are 364 days between January 1 and December 31, plus the starting day.",
            ),
        ),
        lesson(
            "u20l3", "Comparing dates",
            output(
                "from datetime import date\na = date(2024, 5, 1)\nb = date(2024, 4, 30)\nprint(a > b)",
                "True",
                "A later date is \"greater\".",
            ),
            output(
                "from datetime import date\nprint(date(2025, 1, 1) == date(2025, 1, 1))",
                "True",
                "Dates with the same year, month and day are equal.",
            ),
            output(
                "from datetime import date\ndates = [date(2024, 3, 1), date(2023, 7, 9)]\nprint(min(dates))",
                "2023-07-09",
                "min returns the earliest date.",
            ),
            choice(
                "What does a < b mean for two dates?",
                listOf("a is earlier than b", "a is later than b", "a has fewer days in its month", "A string comparison"),
                0,
                "The smaller date is the earlier date.",
            ),
            output(
                "from datetime import date\ndeadlines = [date(2025, 5, 2), date(2025, 1, 9)]\ndeadlines.sort()\nprint(deadlines[0])",
                "2025-01-09",
                "Sorting puts dates in order starting from the earliest.",
            ),
            fill(
                "Fill in the blank to print a message when the deadline has already passed.",
                "from datetime import date\ntoday = date(2025, 6, 10)\ndeadline = date(2025, 6, 1)\nif deadline ____ today:\n    print(\"past due\")",
                listOf("<", ">", "=="),
                "<",
                "The deadline has passed if it is earlier than today.",
            ),
            output(
                "from datetime import date\nd = date(2024, 6, 15)\nstart = date(2024, 1, 1)\nend = date(2024, 12, 31)\nprint(start <= d <= end)",
                "True",
                "The date falls within the year 2024.",
            ),
            choice(
                "What happens when you run this code?",
                listOf("TypeError – you can't compare a date with a string", "True", "False", "ValueError"),
                0,
                "A date can only be compared with another date.",
                code = "from datetime import date\nprint(date(2025, 1, 1) < \"2026-01-01\")",
            ),
        ),
        lesson(
            "u20l4", "strftime and weekday",
            output(
                "from datetime import date\nd = date(2024, 3, 5)\nprint(d.strftime(\"%d.%m.%Y\"))",
                "05.03.2024",
                "%d is the day, %m the month, %Y the year – with leading zeros.",
            ),
            choice(
                "What does %Y mean in strftime?",
                listOf("The four-digit year", "The month", "The day of the week", "Minutes"),
                0,
                "%Y is the full year, e.g. 2024.",
            ),
            output(
                "from datetime import date\nd = date(2024, 1, 1)\nprint(d.weekday())",
                "0",
                "January 1, 2024 is a Monday, and weekday() counts from 0.",
            ),
            choice(
                "What does weekday() return for Sunday?",
                listOf("6", "0", "7", "1"),
                0,
                "Monday is 0 and Sunday is 6.",
            ),
            fill(
                "Fill in the blank to print 25/12.",
                "from datetime import date\nd = date(2025, 12, 25)\nprint(d.strftime(\"%d/____\"))",
                listOf("%m", "%M", "%Y"),
                "%m",
                "Lowercase %m is the month, and uppercase %M is minutes.",
            ),
            output(
                "from datetime import date\nd = date(2025, 7, 4)\nprint(d.strftime(\"%Y-%m\"))",
                "2025-07",
                "The format contains only the year and the month.",
            ),
            output(
                "from datetime import date\ndays = [\"Mon\", \"Tue\", \"Wed\", \"Thu\", \"Fri\", \"Sat\", \"Sun\"]\nd = date(2025, 10, 22)\nprint(days[d.weekday()])",
                "Wed",
                "October 22, 2025 is a Wednesday – weekday() returns 2.",
            ),
            tiles(
                "Print the date d in the format day.month.year.",
                listOf("print(", "d.strftime(", "\"%d.%m.%Y\"", "))"),
                listOf("\"%Y.%m.%d\"", "d.weekday("),
                "The order of the codes in the string sets the order in the result.",
            ),
        ),
        lesson(
            "u20l5", "Review: date and time",
            output(
                "from datetime import date, timedelta\nd = date(2024, 12, 30)\nprint(d + timedelta(days=3))",
                "2025-01-02",
                "timedelta also rolls over the end of the year.",
            ),
            output(
                "from datetime import date\nd = date(2024, 3, 1) - date(2024, 2, 1)\nprint(d.days)",
                "29",
                "February 2024 has 29 days.",
            ),
            choice(
                "Which method turns a date into a string in a format you choose?",
                listOf("strftime", "weekday", "timedelta", "isoweek"),
                0,
                "strftime formats a date according to the given pattern.",
            ),
            output(
                "from datetime import date\nd = date(2025, 10, 25)\nprint(d.weekday() >= 5)",
                "True",
                "October 25, 2025 is a Saturday (5) – the weekend.",
            ),
            fill(
                "Fill in the import so the code works.",
                "from datetime import ____\nprint(date(2025, 1, 1).year)",
                listOf("date", "time", "datetime"),
                "date",
                "To write just date(...), we import the name date.",
            ),
            output(
                "from datetime import date\nbirthday = date(2025, 8, 20)\ntoday = date(2025, 8, 1)\nleft = (birthday - today).days\nprint(\"Only\", left, \"days left\")",
                "Only 19 days left",
                "There are 19 days between August 1 and August 20.",
            ),
            tiles(
                "Calculate the number of days from date a to date b.",
                listOf("days =", "(b - a)", ".days"),
                listOf(".day", "(b + a)"),
                "The difference of dates is a timedelta, and .days gives the number of days.",
            ),
            choice(
                "What does print(date(2025, 3, 9)) print?",
                listOf("2025-03-09", "9.3.2025", "2025-3-9", "09/03/2025"),
                0,
                "A date prints in the format YYYY-MM-DD with leading zeros.",
            ),
        ),
    ),
)
