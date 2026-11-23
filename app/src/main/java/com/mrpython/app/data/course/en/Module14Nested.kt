package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*
import com.mrpython.app.domain.CourseUnit

internal val module14 = CourseUnit(
    id = "u14",
    title = "Nested structures",
    description = "Lists of lists, lists of dictionaries and copying data",
    lessons = listOf(
        lesson(
            "u14l1", "Lists of lists",
            output("m = [[1, 2], [3, 4]]\nprint(m[1][0])", "3", "m[1] is the second row [3, 4], and [0] is its first element."),
            output("m = [[1, 2, 3], [4, 5, 6]]\nprint(m[0])", "[1, 2, 3]", "A single index returns the whole row."),
            output(
                "m = [[1, 2, 3], [4, 5, 6]]\nprint(len(m), len(m[0]))",
                "2 3",
                "len(m) is the number of rows, len(m[0]) is the number of columns.",
            ),
            output("m = [[1, 2], [3, 4]]\nm[0][1] = 9\nprint(m)", "[[1, 9], [3, 4]]", "Two indexes let you change a single element."),
            output(
                "m = [[1, 2], [3, 4], [5, 6]]\nprint([row[1] for row in m])",
                "[2, 4, 6]",
                "Taking row[1] from each row gives us the second column.",
            ),
            choice(
                "What will this code print?",
                listOf("4", "1", "[3, 4]", "Error"),
                0,
                "m[-1] is the last row, and [-1] is its last element.",
                code = "m = [[1, 2], [3, 4]]\nprint(m[-1][-1])",
            ),
            fill(
                "Complete the code to print 6 (2nd row, 3rd column).",
                "m = [[1, 2, 3], [4, 5, 6]]\nprint(m____)",
                listOf("[1][2]", "[2][3]", "[2][1]"),
                "[1][2]",
                "Indexes start at 0, so the 2nd row is [1] and the 3rd column is [2].",
            ),
            tiles(
                "Print the first element of the second row of the matrix m",
                listOf("print(", "m[1]", "[0]", ")"),
                listOf("m[2]", "[1]"),
                "First we pick the row m[1], then the element [0].",
            ),
        ),
        lesson(
            "u14l2", "Lists of dictionaries",
            output(
                "people = [\n    {\"name\": \"Amy\", \"age\": 20},\n    {\"name\": \"Bob\", \"age\": 30},\n]\nprint(people[1][\"name\"])",
                "Bob",
                "people[1] is Bob's dictionary, and [\"name\"] pulls the name out of it.",
            ),
            output(
                "people = [\n    {\"name\": \"Amy\", \"age\": 20},\n    {\"name\": \"Bob\", \"age\": 30},\n]\nfor p in people:\n    print(p[\"name\"], p[\"age\"])",
                "Amy 20\nBob 30",
                "The loop goes through the dictionaries (records) one by one.",
            ),
            output(
                "people = [{\"age\": 20}, {\"age\": 30}]\ntotal = 0\nfor p in people:\n    total += p[\"age\"]\nprint(total)",
                "50",
                "We add up the age from each record: 20 + 30.",
            ),
            choice(
                "What is people[0] in this code?",
                listOf("A dictionary", "A list", "A string", "A number"),
                0,
                "Each element of the list people is a dictionary describing one person.",
                code = "people = [{\"name\": \"Amy\"}, {\"name\": \"Eve\"}]",
            ),
            fill(
                "Complete the code to print the age of the first person.",
                "people = [{\"age\": 20}, {\"age\": 30}]\nprint(people[0][____])",
                listOf("\"age\"", "0", "age"),
                "\"age\"",
                "You reach a value in a dictionary through its key – the string \"age\".",
            ),
            output(
                "people = [\n    {\"name\": \"Amy\", \"age\": 20},\n    {\"name\": \"Bob\", \"age\": 30},\n]\nprint([p[\"name\"] for p in people\n       if p[\"age\"] > 25])",
                "['Bob']",
                "Only Bob is older than 25.",
            ),
            choice(
                "What will this code print?",
                listOf("1 Emma", "0 Emma", "1 title", "Error"),
                0,
                "The list has one dictionary, and its title is “Emma”.",
                code = "books = []\nbooks.append({\"title\": \"Emma\"})\nprint(len(books), books[0][\"title\"])",
            ),
            tiles(
                "Add a new dictionary with the name Eve to the list people",
                listOf("people.append(", "{\"name\":", "\"Eve\"}", ")"),
                listOf("people.add(", "[\"name\":"),
                "append() adds the whole dictionary to the end of the list.",
            ),
        ),
        lesson(
            "u14l3", "Dictionaries of lists and loops",
            output(
                "grades = {\"Amy\": [5, 4], \"Bob\": [3]}\nprint(grades[\"Amy\"][1])",
                "4",
                "grades[\"Amy\"] is the list [5, 4], and [1] is its second element.",
            ),
            output(
                "grades = {\"Amy\": [5, 4]}\ngrades[\"Amy\"].append(3)\nprint(grades)",
                "{'Amy': [5, 4, 3]}",
                "A list inside a dictionary can be changed with list methods.",
            ),
            output(
                "grades = {\"Amy\": [5, 4], \"Bob\": [3]}\nfor name, marks in grades.items():\n    print(name, len(marks))",
                "Amy 2\nBob 1",
                "items() gives the name and the list of grades of each person.",
            ),
            output(
                "m = [[1, 2], [3, 4]]\ntotal = 0\nfor row in m:\n    for x in row:\n        total += x\nprint(total)",
                "10",
                "The outer loop goes over the rows, the inner one over the numbers.",
            ),
            output(
                "groups = {}\nfor s in [\"cat\", \"cow\", \"pig\"]:\n    k = s[0]\n    if k not in groups:\n        groups[k] = []\n    groups[k].append(s)\nprint(groups)",
                "{'c': ['cat', 'cow'], 'p': ['pig']}",
                "We group the words into lists by their first letter.",
            ),
            choice(
                "How do you read Bob's second grade?",
                listOf("d[\"Bob\"][1]", "d[1][\"Bob\"]", "d[\"Bob\"](1)", "d.Bob[1]"),
                0,
                "First the dictionary key, then the list index.",
                code = "d = {\"Bob\": [3, 5]}",
            ),
            fill(
                "Complete the code to add the grade 5 to Amy's list.",
                "grades = {\"Amy\": [4]}\ngrades[\"Amy\"].____(5)\nprint(grades)",
                listOf("append", "add", "insert"),
                "append",
                "grades[\"Amy\"] is a list, and you add to a list with append().",
            ),
            tiles(
                "Loop over the rows of the matrix m",
                listOf("for", "row", "in", "m:"),
                listOf("m[0]:", "of"),
                "A for loop over a list of lists gives the rows one by one.",
            ),
        ),
        lesson(
            "u14l4", "Shallow and deep copies",
            output("a = [1, 2]\nb = a\nb.append(3)\nprint(a)", "[1, 2, 3]", "b = a doesn't copy the list – both names point to the same list."),
            output("a = [1, 2]\nb = a.copy()\nb.append(3)\nprint(a)", "[1, 2]", "copy() creates a new list, so a doesn't change."),
            output(
                "a = [[1], [2]]\nb = a.copy()\nb[0].append(9)\nprint(a)",
                "[[1, 9], [2]]",
                "A shallow copy copies only the outer list – the inner lists are shared.",
            ),
            output(
                "import copy\na = [[1], [2]]\nb = copy.deepcopy(a)\nb[0].append(9)\nprint(a)",
                "[[1], [2]]",
                "deepcopy() copies all the lists inside as well.",
            ),
            choice(
                "What will this code print?",
                listOf("[[1, 0], [1, 0]]", "[[1, 0], [0, 0]]", "[[1, 1], [0, 0]]", "Error"),
                0,
                "* 2 repeats the same inner list, so both rows are one object.",
                code = "m = [[0] * 2] * 2\nm[0][0] = 1\nprint(m)",
            ),
            choice(
                "What does the statement b = a do when a is a list?",
                listOf("Gives the same list a second name", "Creates a shallow copy of a", "Creates a deep copy of a", "Removes everything from a"),
                0,
                "Assignment never copies – both variables point to the same object.",
            ),
            fill(
                "Complete the code so that changing b[0] doesn't change the list a.",
                "import copy\na = [[1, 2]]\nb = copy.____(a)\nb[0][0] = 5\nprint(a)",
                listOf("deepcopy", "copy", "list"),
                "deepcopy",
                "Only deepcopy() copies the lists inside – then a stays [[1, 2]].",
            ),
            output("a = [1, 2]\nb = list(a)\nb[0] = 7\nprint(a, b)", "[1, 2] [7, 2]", "list(a) creates a new list with the same elements."),
        ),
        lesson(
            "u14l5", "Review: nested structures",
            output("m = [[1, 2], [3, 4]]\nprint(m[0][0] + m[1][1])", "5", "The elements on the diagonal are 1 and 4."),
            output("data = {\"x\": [1, 2, 3]}\nprint(sum(data[\"x\"]))", "6", "data[\"x\"] is a list, and sum() adds it up."),
            output(
                "p = [{\"c\": 2}, {\"c\": 3}]\nprint([d[\"c\"] * 2 for d in p])",
                "[4, 6]",
                "From each dictionary we take the value under the key \"c\".",
            ),
            output("m = [[1, 2], [3, 4]]\nfor row in m:\n    print(row[0] * row[1])", "2\n12", "For each row we multiply its two elements."),
            choice(
                "Which operation also copies the inner lists?",
                listOf("copy.deepcopy(a)", "a.copy()", "a[:]", "b = a"),
                0,
                "a.copy() and a[:] are shallow copies, and b = a doesn't copy at all.",
            ),
            choice(
                "What will this code print?",
                listOf("[[0, 7]]", "[[0, 0]]", "[[7, 0]]", "Error"),
                0,
                "a[:] is a shallow copy, so the inner list is shared.",
                code = "a = [[0, 0]]\nb = a[:]\nb[0][1] = 7\nprint(a)",
            ),
            fill(
                "Complete the code to print the last row of the matrix.",
                "m = [[1, 2], [3, 4]]\nprint(m[____])",
                listOf("-1", "2", "0"),
                "-1",
                "The index -1 points to the last element, here the last row.",
            ),
            tiles(
                "Print the name of the first person in the list people",
                listOf("print(", "people[0]", "[\"name\"]", ")"),
                listOf("people[\"name\"]", "[1]"),
                "First the list index [0], then the dictionary key [\"name\"].",
            ),
        ),
    ),
)
