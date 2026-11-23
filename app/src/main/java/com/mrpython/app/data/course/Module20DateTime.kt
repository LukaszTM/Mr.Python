package com.mrpython.app.data.course

import com.mrpython.app.domain.CourseUnit

internal val module20 = CourseUnit(
    id = "u20",
    title = "Data i czas",
    description = "Daty, odstępy czasu i formatowanie",
    lessons = listOf(
        lesson(
            "u20l1", "Daty: datetime.date",
            output(
                "import datetime\nd = datetime.date(2024, 3, 15)\nprint(d)",
                "2024-03-15",
                "Data wypisuje się w formacie rok-miesiąc-dzień.",
            ),
            output(
                "from datetime import date\nd = date(2024, 12, 24)\nprint(d.year)\nprint(d.month)",
                "2024\n12",
                "Atrybuty year i month przechowują rok i miesiąc.",
            ),
            choice(
                "W jakiej kolejności podajesz argumenty date(...)?",
                listOf("rok, miesiąc, dzień", "dzień, miesiąc, rok", "miesiąc, dzień, rok", "dowolnej"),
                0,
                "date(rok, miesiąc, dzień) – od największej jednostki.",
            ),
            fill(
                "Uzupełnij, aby wypisać dzień miesiąca.",
                "from datetime import date\nd = date(2025, 5, 9)\nprint(d.____)",
                listOf("day", "days", "dzien"),
                "day",
                "Dzień miesiąca to atrybut day.",
            ),
            output(
                "from datetime import date\nd = date(2025, 1, 31)\nprint(d.day + 1)",
                "32",
                "d.day to zwykła liczba int – dodawanie nie zmienia daty.",
            ),
            choice(
                "Co się stanie po date(2025, 2, 30)?",
                listOf("ValueError – luty nie ma 30 dni", "Powstanie data 2 marca", "Powstanie data 28 lutego", "Nic"),
                0,
                "Python sprawdza, czy taki dzień istnieje.",
            ),
            tiles(
                "Utwórz datę 1 maja 2025.",
                listOf("d =", "date(", "2025, 5, 1", ")"),
                listOf("1, 5, 2025", "date.today("),
                "Kolejność to rok, miesiąc, dzień.",
            ),
            output(
                "from datetime import date\nd = date(2024, 7, 4)\nprint(\"Data: \" + str(d))",
                "Data: 2024-07-04",
                "str(d) zamienia datę na napis RRRR-MM-DD.",
            ),
        ),
        lesson(
            "u20l2", "timedelta – odstępy czasu",
            output(
                "from datetime import date, timedelta\nd = date(2024, 1, 30)\nprint(d + timedelta(days=5))",
                "2024-02-04",
                "timedelta sam przechodzi do kolejnego miesiąca.",
            ),
            output(
                "from datetime import date\na = date(2024, 3, 10)\nb = date(2024, 3, 1)\nprint((a - b).days)",
                "9",
                "Różnica dwóch dat to timedelta, a .days to liczba dni.",
            ),
            choice(
                "Jaki typ ma wynik odejmowania dwóch dat?",
                listOf("timedelta", "date", "int", "str"),
                0,
                "Data minus data to odstęp czasu – timedelta.",
            ),
            fill(
                "Uzupełnij, aby przesunąć datę o tydzień do przodu.",
                "from datetime import date, timedelta\nd = date(2025, 6, 1)\nprint(d + timedelta(____=7))",
                listOf("days", "day", "dni"),
                "days",
                "Parametr timedelta to days (liczba mnoga).",
            ),
            output(
                "from datetime import date, timedelta\nd = date(2024, 3, 1)\nprint(d - timedelta(days=1))",
                "2024-02-29",
                "Rok 2024 jest przestępny, więc luty ma 29 dni.",
            ),
            output(
                "from datetime import timedelta\nt = timedelta(weeks=2)\nprint(t.days)",
                "14",
                "Dwa tygodnie to 14 dni.",
            ),
            tiles(
                "Dodaj 10 dni do daty d.",
                listOf("d", "+", "timedelta(", "days=10", ")"),
                listOf("-", "date("),
                "Do daty dodajemy timedelta.",
            ),
            output(
                "from datetime import date\nstart = date(2025, 1, 1)\nkoniec = date(2025, 12, 31)\nprint((koniec - start).days + 1)",
                "365",
                "Między 1 stycznia a 31 grudnia jest 364 dni, plus dzień startowy.",
            ),
        ),
        lesson(
            "u20l3", "Porównywanie dat",
            output(
                "from datetime import date\na = date(2024, 5, 1)\nb = date(2024, 4, 30)\nprint(a > b)",
                "True",
                "Późniejsza data jest „większa”.",
            ),
            output(
                "from datetime import date\nprint(date(2025, 1, 1) == date(2025, 1, 1))",
                "True",
                "Daty z tym samym rokiem, miesiącem i dniem są równe.",
            ),
            output(
                "from datetime import date\ndaty = [date(2024, 3, 1), date(2023, 7, 9)]\nprint(min(daty))",
                "2023-07-09",
                "min zwraca najwcześniejszą datę.",
            ),
            choice(
                "Co oznacza a < b dla dwóch dat?",
                listOf("a jest wcześniej niż b", "a jest później niż b", "a ma mniej dni w miesiącu", "Porównanie napisów"),
                0,
                "Mniejsza data to data wcześniejsza.",
            ),
            output(
                "from datetime import date\nterminy = [date(2025, 5, 2), date(2025, 1, 9)]\nterminy.sort()\nprint(terminy[0])",
                "2025-01-09",
                "Sortowanie układa daty od najwcześniejszej.",
            ),
            fill(
                "Uzupełnij, aby wypisać komunikat, gdy termin już minął.",
                "from datetime import date\ndzis = date(2025, 6, 10)\ntermin = date(2025, 6, 1)\nif termin ____ dzis:\n    print(\"po terminie\")",
                listOf("<", ">", "=="),
                "<",
                "Termin minął, jeśli jest wcześniej niż dziś.",
            ),
            output(
                "from datetime import date\nd = date(2024, 6, 15)\npocz = date(2024, 1, 1)\nkon = date(2024, 12, 31)\nprint(pocz <= d <= kon)",
                "True",
                "Data mieści się w roku 2024.",
            ),
            choice(
                "Co się stanie po uruchomieniu tego kodu?",
                listOf("TypeError – nie można porównać daty z napisem", "True", "False", "ValueError"),
                0,
                "Datę można porównać tylko z inną datą.",
                code = "from datetime import date\nprint(date(2025, 1, 1) < \"2026-01-01\")",
            ),
        ),
        lesson(
            "u20l4", "strftime i weekday",
            output(
                "from datetime import date\nd = date(2024, 3, 5)\nprint(d.strftime(\"%d.%m.%Y\"))",
                "05.03.2024",
                "%d to dzień, %m miesiąc, %Y rok – z zerami na początku.",
            ),
            choice(
                "Co oznacza %Y w strftime?",
                listOf("Rok czterocyfrowy", "Miesiąc", "Dzień tygodnia", "Minuty"),
                0,
                "%Y to pełny rok, np. 2024.",
            ),
            output(
                "from datetime import date\nd = date(2024, 1, 1)\nprint(d.weekday())",
                "0",
                "1 stycznia 2024 to poniedziałek, a weekday() liczy od 0.",
            ),
            choice(
                "Co zwraca weekday() dla niedzieli?",
                listOf("6", "0", "7", "1"),
                0,
                "Poniedziałek to 0, a niedziela to 6.",
            ),
            fill(
                "Uzupełnij, aby wypisać 25/12.",
                "from datetime import date\nd = date(2025, 12, 25)\nprint(d.strftime(\"%d/____\"))",
                listOf("%m", "%M", "%Y"),
                "%m",
                "Małe %m to miesiąc, a duże %M to minuty.",
            ),
            output(
                "from datetime import date\nd = date(2025, 7, 4)\nprint(d.strftime(\"%Y-%m\"))",
                "2025-07",
                "Format zawiera tylko rok i miesiąc.",
            ),
            output(
                "from datetime import date\ndni = [\"pn\", \"wt\", \"śr\", \"cz\", \"pt\", \"sb\", \"nd\"]\nd = date(2025, 10, 22)\nprint(dni[d.weekday()])",
                "śr",
                "22 października 2025 to środa – weekday() zwraca 2.",
            ),
            tiles(
                "Wypisz datę d w formacie dzień.miesiąc.rok.",
                listOf("print(", "d.strftime(", "\"%d.%m.%Y\"", "))"),
                listOf("\"%Y.%m.%d\"", "d.weekday("),
                "Kolejność kodów w napisie wyznacza kolejność w wyniku.",
            ),
        ),
        lesson(
            "u20l5", "Powtórka: data i czas",
            output(
                "from datetime import date, timedelta\nd = date(2024, 12, 30)\nprint(d + timedelta(days=3))",
                "2025-01-02",
                "timedelta przechodzi także przez koniec roku.",
            ),
            output(
                "from datetime import date\nd = date(2024, 3, 1) - date(2024, 2, 1)\nprint(d.days)",
                "29",
                "Luty 2024 ma 29 dni.",
            ),
            choice(
                "Którą metodą zamienisz datę na napis w wybranym formacie?",
                listOf("strftime", "weekday", "timedelta", "isoweek"),
                0,
                "strftime formatuje datę według podanego wzoru.",
            ),
            output(
                "from datetime import date\nd = date(2025, 10, 25)\nprint(d.weekday() >= 5)",
                "True",
                "25 października 2025 to sobota (5) – weekend.",
            ),
            fill(
                "Uzupełnij import, aby kod działał.",
                "from datetime import ____\nprint(date(2025, 1, 1).year)",
                listOf("date", "time", "datetime"),
                "date",
                "Aby pisać samo date(...), importujemy nazwę date.",
            ),
            output(
                "from datetime import date\nurodziny = date(2025, 8, 20)\ndzis = date(2025, 8, 1)\nile = (urodziny - dzis).days\nprint(\"Zostało\", ile, \"dni\")",
                "Zostało 19 dni",
                "Między 1 a 20 sierpnia jest 19 dni.",
            ),
            tiles(
                "Oblicz liczbę dni od daty a do daty b.",
                listOf("dni =", "(b - a)", ".days"),
                listOf(".day", "(b + a)"),
                "Różnica dat to timedelta, a .days daje liczbę dni.",
            ),
            choice(
                "Co wypisze print(date(2025, 3, 9))?",
                listOf("2025-03-09", "9.3.2025", "2025-3-9", "09/03/2025"),
                0,
                "Data wypisuje się w formacie RRRR-MM-DD z zerami.",
            ),
        ),
    ),
)
