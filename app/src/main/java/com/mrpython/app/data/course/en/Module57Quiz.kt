package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*
import com.mrpython.app.domain.CourseUnit

internal val module57 = CourseUnit(
    id = "u57",
    title = "Project: Quiz",
    description = "We build a quiz: questions, points, shuffling and a report",
    lessons = listOf(
        lesson(
            "u57l1", "Questions as dictionaries",
            output(
                "question = {\"text\": \"2 + 2 = ?\", \"answer\": \"4\"}\nprint(question[\"text\"])",
                "2 + 2 = ?",
                "A question is a dictionary with the text and the correct answer.",
            ),
            output(
                "questions = [\n    {\"text\": \"Capital of France?\", \"answer\": \"Paris\"},\n    {\"text\": \"5 * 3 = ?\", \"answer\": \"15\"},\n]\nfor q in questions:\n    print(q[\"text\"])",
                "Capital of France?\n5 * 3 = ?",
                "A list of dictionaries stores the whole set of questions.",
            ),
            choice(
                "Why do we store the answer \"15\" as a string and not a number?",
                listOf("The player's answer is a string too, so they're easy to compare", "Numbers can't be kept in a dictionary", "A string takes up less space", "Because 15 is an odd number"),
                0,
                "We compare a string with a string – no type conversion needed.",
            ),
            fill(
                "Fill in the blank to print the correct answers.",
                "questions = [{\"text\": \"2 + 2?\", \"answer\": \"4\"},\n             {\"text\": \"3 + 3?\", \"answer\": \"6\"}]\nfor q in questions:\n    print(q[____])",
                listOf("\"answer\"", "answer", "\"text\""),
                "\"answer\"",
                "The answer is under the \"answer\" key.",
            ),
            output(
                "q = {\"text\": \"Color of the sky?\",\n     \"options\": [\"green\", \"blue\"],\n     \"correct\": 1}\nprint(q[\"options\"][q[\"correct\"]])",
                "blue",
                "A multiple-choice question holds a list of options and the index of the correct one.",
            ),
            output(
                "options = [\"Boston\", \"Denver\", \"Seattle\"]\nfor i, o in enumerate(options, 1):\n    print(f\"{i}) {o}\")",
                "1) Boston\n2) Denver\n3) Seattle",
                "enumerate numbers the options starting from 1.",
            ),
            tiles(
                "Add a question with the text t and the answer a to the list.",
                listOf("questions.append(", "{\"text\": t,", "\"answer\": a}", ")"),
                listOf("questions.add(", "[\"text\": t,"),
                "append adds the new dictionary to the end of the list.",
            ),
            choice(
                "How do you check how many questions the quiz has?",
                listOf("len(questions)", "questions.count()", "size(questions)", "questions.len"),
                0,
                "len returns the number of elements in a list.",
            ),
        ),
        lesson(
            "u57l2", "Checking answers",
            output(
                "def check(question, answer):\n    return answer == question[\"answer\"]\n\nq = {\"text\": \"3 + 4?\", \"answer\": \"7\"}\nprint(check(q, \"7\"), check(q, \"8\"))",
                "True False",
                "The function compares the player's answer with the correct one.",
            ),
            output(
                "correct = \"Paris\"\nanswer = \"  paris \"\nprint(answer == correct)\nprint(answer.strip().lower() == correct.lower())",
                "False\nTrue",
                "We remove the spaces and make the letter case the same before comparing.",
            ),
            fill(
                "Fill in the blank to remove the spaces from the start and end of the answer.",
                "answer = \" YES \"\nprint(answer.____().lower() == \"yes\")",
                listOf("strip", "split", "trim"),
                "strip",
                "strip() removes whitespace from both ends of a string.",
            ),
            output(
                "questions = [{\"answer\": \"4\"}, {\"answer\": \"Paris\"}]\nanswers = [\"4\", \"Rome\"]\nfor q, a in zip(questions, answers):\n    print(\"correct\" if a == q[\"answer\"] else \"wrong\")",
                "correct\nwrong",
                "zip pairs each question with the player's answer.",
            ),
            choice(
                "Why is this condition never true?",
                listOf("It compares the string \"15\" with the number 15", "A colon is missing", "== doesn't work for strings", "answer is empty"),
                0,
                "A string and a number are never equal.",
                code = "answer = \"15\"\nif answer == 15:\n    print(\"correct\")",
            ),
            output(
                "q = {\"options\": [\"A\", \"B\", \"C\"], \"correct\": 2}\nchoice = 2\nprint(q[\"options\"][choice], choice == q[\"correct\"])",
                "C True",
                "The player chose index 2, which is the correct option C.",
            ),
            tiles(
                "Store in ok the result of comparing the answers regardless of letter case.",
                listOf("ok =", "answer.lower()", "==", "correct.lower()"),
                listOf("=", "print("),
                "lower() on both sides makes \"Yes\" and \"yes\" equal.",
            ),
            output(
                "def feedback(ok, correct):\n    if ok:\n        return \"Well done!\"\n    return f\"Wrong, correct: {correct}\"\n\nprint(feedback(False, \"Nile\"))",
                "Wrong, correct: Nile",
                "For a wrong answer we show the correct one.",
            ),
        ),
        lesson(
            "u57l3", "Points and percentages",
            output(
                "results = [True, False, True, True]\npoints = sum(results)\nprint(points)",
                "3",
                "Every True is one point.",
            ),
            output(
                "points, total = 3, 4\npercent = points / total * 100\nprint(percent)",
                "75.0",
                "3 / 4 = 0.75, and times 100 gives 75.0.",
            ),
            output(
                "print(round(2 / 3 * 100))\nprint(f\"{2 / 3:.1%}\")",
                "67\n66.7%",
                "round rounds to a whole number, and :.1% shows one digit after the decimal point.",
            ),
            fill(
                "Fill in the operator so that 85% earns the grade \"very good\".",
                "percent = 85\nif percent ____ 80:\n    print(\"very good\")",
                listOf(">=", "<", "=="),
                ">=",
                "85 is greater than or equal to 80.",
            ),
            output(
                "def grade(p):\n    if p >= 90:\n        return \"A\"\n    if p >= 70:\n        return \"B\"\n    if p >= 50:\n        return \"C\"\n    return \"F\"\n\nprint(grade(95), grade(70), grade(49))",
                "A B F",
                "We check the thresholds starting from the highest.",
            ),
            choice(
                "What happens when the quiz has no questions and we compute points / len(questions)?",
                listOf("ZeroDivisionError", "The result is 0", "The result is None", "The result is 100"),
                0,
                "len of an empty list is 0 – you have to check for that first.",
            ),
            tiles(
                "Calculate the percentage of points earned.",
                listOf("percent =", "points", "/", "total", "* 100"),
                listOf("//", "% 100"),
                "We divide the points by the number of questions and multiply by 100.",
            ),
            output(
                "correct = [\"a\", \"c\", \"b\"]\nanswers = [\"a\", \"b\", \"b\"]\npoints = 0\nfor c, a in zip(correct, answers):\n    if c == a:\n        points += 1\nprint(f\"{points}/{len(correct)}\")",
                "2/3",
                "The first and third answers match.",
            ),
        ),
        lesson(
            "u57l4", "Shuffling questions",
            choice(
                "Which function shuffles the order of a list's elements in place?",
                listOf("random.shuffle(items)", "random.choice(items)", "items.sort()", "random.randint(items)"),
                0,
                "shuffle changes the order of the elements in the same list.",
            ),
            choice(
                "What does random.shuffle(items) return?",
                listOf("None – it changes the list in place", "A new, shuffled list", "The first element", "The number of elements"),
                0,
                "That's why we don't write items = random.shuffle(items).",
            ),
            output(
                "import random\n\nitems = [1, 2, 3, 4]\nrandom.shuffle(items)\nprint(sorted(items))",
                "[1, 2, 3, 4]",
                "The order is random, but the elements are the same – after sorting the result is certain.",
            ),
            output(
                "import random\n\nitems = [1, 2, 3, 4]\nrandom.shuffle(items)\nprint(len(items), sum(items))",
                "4 10",
                "Shuffling doesn't change the number or the values of the elements.",
            ),
            output(
                "import random\n\nquestions = [\"Q1\", \"Q2\", \"Q3\"]\nqueue = questions[:]\nrandom.shuffle(queue)\nprint(questions)",
                "['Q1', 'Q2', 'Q3']",
                "We shuffle a copy, so the original list stays unchanged.",
            ),
            fill(
                "Fill in the name of the function that shuffles a list.",
                "import random\n\nitems = [3, 1, 2]\nrandom.____(items)\nprint(len(items))",
                listOf("shuffle", "mix", "sort"),
                "shuffle",
                "The random module has a shuffle function; mix and sort don't exist in random.",
            ),
            output(
                "import random\n\nq = [\"A\", \"B\", \"C\"]\nnew = random.sample(q, len(q))\nprint(len(new), sorted(new) == q)",
                "3 True",
                "sample returns a new list in random order and doesn't change the original.",
            ),
            tiles(
                "Shuffle the questions list.",
                listOf("random.shuffle(", "questions", ")"),
                listOf("random.sort(", "questions ="),
                "shuffle works in place, so we don't assign the result.",
            ),
        ),
        lesson(
            "u57l5", "The Question class and project summary",
            output(
                "class Question:\n    def __init__(self, text, answer):\n        self.text = text\n        self.answer = answer\n    def check(self, answer):\n        return answer.strip().lower() == self.answer.lower()\n\nq = Question(\"Capital of Italy?\", \"Rome\")\nprint(q.check(\" rome\"))",
                "True",
                "The question object knows how to check an answer itself.",
            ),
            fill(
                "Fill in the name of the method that sets the attributes of a new object.",
                "class Question:\n    def ____(self, text, answer):\n        self.text = text\n        self.answer = answer\n\nq = Question(\"2 + 2?\", \"4\")\nprint(q.answer)",
                listOf("__init__", "init", "__str__"),
                "__init__",
                "__init__ is called when the object is created.",
            ),
            output(
                "class Quiz:\n    def __init__(self, questions):\n        self.questions = questions\n        self.points = 0\n    def answer(self, i, answer):\n        if self.questions[i][\"answer\"] == answer:\n            self.points += 1\n\nquiz = Quiz([{\"answer\": \"4\"}, {\"answer\": \"9\"}])\nquiz.answer(0, \"4\")\nquiz.answer(1, \"8\")\nprint(quiz.points)",
                "1",
                "Only the first answer is correct.",
            ),
            output(
                "points, total = 4, 5\npercent = points / total * 100\nprint(f\"Score: {points}/{total}\")\nprint(f\"Percent: {percent:.0f}%\")",
                "Score: 4/5\nPercent: 80%",
                "The report shows the points and the percentage.",
            ),
            output(
                "questions = [\"2+2\", \"3*3\", \"10-7\"]\ncorrect = [\"4\", \"9\", \"3\"]\nanswers = [\"4\", \"6\", \"3\"]\nmistakes = [q for q, a, b\n            in zip(questions, correct, answers)\n            if a != b]\nprint(mistakes)",
                "['3*3']",
                "The report can list the questions that were answered wrong.",
            ),
            choice(
                "How do we store the set of questions in this project?",
                listOf("As a list of dictionaries or a list of Question objects", "As one long string", "As a set of numbers", "In a separate variable for each question"),
                0,
                "A list makes it easy to add, shuffle and loop over the questions.",
            ),
            tiles(
                "Add a point to the points attribute inside a quiz method.",
                listOf("self.points", "+=", "1"),
                listOf("==", "self.score"),
                "+= 1 increases the point counter by one.",
            ),
            output(
                "class Result:\n    def __init__(self, ok, n):\n        self.ok, self.n = ok, n\n    def __str__(self):\n        return f\"{self.ok}/{self.n} ({self.ok / self.n:.0%})\"\n\nprint(Result(3, 4))",
                "3/4 (75%)",
                "__str__ returns a ready-made summary of the quiz.",
            ),
        ),
    ),
)
