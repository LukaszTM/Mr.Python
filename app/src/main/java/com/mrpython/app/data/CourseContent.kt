package com.mrpython.app.data

import com.mrpython.app.domain.ArrangeTiles
import com.mrpython.app.domain.CourseUnit
import com.mrpython.app.domain.Exercise
import com.mrpython.app.domain.FillInBlank
import com.mrpython.app.domain.Lesson
import com.mrpython.app.domain.MultipleChoice
import com.mrpython.app.domain.PredictOutput

private typealias ExerciseFactory = (id: String) -> Exercise

private fun lesson(id: String, title: String, vararg exercises: ExerciseFactory) =
    Lesson(id, title, exercises.mapIndexed { i, make -> make("$id-e${i + 1}") })

private fun choice(
    instruction: String,
    options: List<String>,
    correct: Int,
    explanation: String,
    code: String? = null,
): ExerciseFactory = { id -> MultipleChoice(id, instruction, code, options, correct, explanation) }

private fun fill(
    instruction: String,
    code: String,
    options: List<String>,
    correct: String,
    explanation: String,
): ExerciseFactory = { id -> FillInBlank(id, instruction, code, options, correct, explanation) }

private fun tiles(
    instruction: String,
    solution: List<String>,
    distractors: List<String>,
    explanation: String,
): ExerciseFactory = { id -> ArrangeTiles(id, instruction, solution + distractors, solution, explanation = explanation) }

private fun output(
    code: String,
    expected: String,
    explanation: String,
    instruction: String = "Co wypisze ten program?",
): ExerciseFactory = { id -> PredictOutput(id, instruction, code, listOf(expected), explanation) }

object CourseContent {

    val units: List<CourseUnit> = listOf(
        CourseUnit(
            id = "u1",
            title = "Pierwsze kroki",
            description = "print(), napisy i komentarze",
            lessons = listOf(
                lesson(
                    "u1l1", "Witaj, świecie!",
                    choice(
                        "Która instrukcja wypisze tekst na ekranie?",
                        listOf("print(\"Cześć\")", "echo \"Cześć\"", "console.log(\"Cześć\")", "printf Cześć"),
                        0,
                        "W Pythonie tekst wypisujemy funkcją print().",
                    ),
                    output(
                        "print(\"Witaj, świecie!\")",
                        "Witaj, świecie!",
                        "print() wypisuje napis bez cudzysłowów.",
                    ),
                    tiles(
                        "Ułóż kod, który wypisze: Hej",
                        listOf("print(", "\"Hej\"", ")"),
                        listOf("echo", "Hej"),
                        "Napis musi być w cudzysłowie i w nawiasach funkcji print.",
                    ),
                    fill(
                        "Uzupełnij, aby wypisać słowo Python.",
                        "____(\"Python\")",
                        listOf("print", "write", "say"),
                        "print",
                        "Funkcja wypisująca tekst to print.",
                    ),
                    output(
                        "print(\"Ala\")\nprint(\"ma kota\")",
                        "Ala\nma kota",
                        "Każde wywołanie print() kończy się nową linią.",
                    ),
                ),
                lesson(
                    "u1l2", "Napisy i komentarze",
                    choice(
                        "Co oznacza znak # w Pythonie?",
                        listOf(
                            "Początek komentarza – Python go pomija",
                            "Liczbę",
                            "Koniec programu",
                            "Mnożenie",
                        ),
                        0,
                        "Wszystko od # do końca linii to komentarz dla ludzi, nie dla komputera.",
                    ),
                    output(
                        "# print(\"A\")\nprint(\"B\")",
                        "B",
                        "Pierwsza linia jest komentarzem, więc się nie wykona.",
                    ),
                    choice(
                        "Który zapis napisu jest poprawny?",
                        listOf("\"tekst\" oraz 'tekst' – oba", "Tylko \"tekst\"", "Tylko 'tekst'", "«tekst»"),
                        0,
                        "Python akceptuje zarówno cudzysłowy, jak i apostrofy.",
                    ),
                    output(
                        "print(\"Py\" + \"thon\")",
                        "Python",
                        "Operator + skleja (konkatenuje) napisy.",
                    ),
                    output(
                        "print(\"ha\" * 3)",
                        "hahaha",
                        "Napis pomnożony przez liczbę powtarza się tyle razy.",
                    ),
                    output(
                        "print(\"Ala\", \"ma\", \"kota\")",
                        "Ala ma kota",
                        "Kilka argumentów print() rozdziela spacjami.",
                    ),
                ),
            ),
        ),
        CourseUnit(
            id = "u2",
            title = "Zmienne i typy",
            description = "Przechowuj dane i poznaj ich typy",
            lessons = listOf(
                lesson(
                    "u2l1", "Zmienne",
                    choice(
                        "Jak zapisać liczbę 5 w zmiennej x?",
                        listOf("x = 5", "x == 5", "5 = x", "let x = 5"),
                        0,
                        "Pojedynczy znak = przypisuje wartość do zmiennej.",
                    ),
                    output(
                        "x = 3\nx = x + 2\nprint(x)",
                        "5",
                        "Najpierw x to 3, potem nadpisujemy go wartością 3 + 2.",
                    ),
                    tiles(
                        "Utwórz zmienną imie z wartością \"Ola\"",
                        listOf("imie", "=", "\"Ola\""),
                        listOf("==", "Ola"),
                        "Nazwa zmiennej, znak = i wartość – w tej kolejności.",
                    ),
                    choice(
                        "Która nazwa zmiennej jest niepoprawna?",
                        listOf("moja_zmienna", "wiek2", "2wiek", "_ukryta"),
                        2,
                        "Nazwa zmiennej nie może zaczynać się od cyfry.",
                    ),
                    output(
                        "a = \"kot\"\nb = a\nprint(b)",
                        "kot",
                        "b dostaje tę samą wartość co a.",
                    ),
                ),
                lesson(
                    "u2l2", "Typy danych",
                    choice(
                        "Jaki typ ma wartość 3.14?",
                        listOf("int", "float", "str", "bool"),
                        1,
                        "Liczby z kropką dziesiętną to float (liczby zmiennoprzecinkowe).",
                    ),
                    output(
                        "print(type(7))",
                        "<class 'int'>",
                        "7 to liczba całkowita, czyli int.",
                    ),
                    output(
                        "print(int(\"4\") + 1)",
                        "5",
                        "int() zamienia napis \"4\" na liczbę 4.",
                    ),
                    choice(
                        "Co wypisze ten kod?",
                        listOf("5", "41", "Błąd", "4 1"),
                        1,
                        "\"4\" i \"1\" to napisy, więc + je skleja.",
                        code = "print(\"4\" + \"1\")",
                    ),
                    fill(
                        "Zamień napis na liczbę całkowitą.",
                        "wiek = ____(\"18\")",
                        listOf("int", "str", "text"),
                        "int",
                        "int() tworzy liczbę całkowitą.",
                    ),
                    output(
                        "print(str(10) + \"0\")",
                        "100",
                        "str(10) to napis \"10\", a doklejenie \"0\" daje \"100\".",
                    ),
                ),
                lesson(
                    "u2l3", "f-stringi i input()",
                    choice(
                        "Co zwraca funkcja input()?",
                        listOf("Zawsze napis (str)", "Zawsze liczbę", "True lub False", "Nic"),
                        0,
                        "input() zwraca to, co wpisał użytkownik, jako napis.",
                    ),
                    output(
                        "imie = \"Ewa\"\nprint(f\"Cześć, {imie}!\")",
                        "Cześć, Ewa!",
                        "W f-stringu {imie} zostaje zastąpione wartością zmiennej.",
                    ),
                    fill(
                        "Uzupełnij, aby wyrażenie w klamrach zostało obliczone.",
                        "print(____\"Wynik: {2 + 2}\")",
                        listOf("f", "$", "#"),
                        "f",
                        "Litera f przed cudzysłowem tworzy f-string.",
                    ),
                    output(
                        "x = 7\nprint(f\"{x} * 2 = {x * 2}\")",
                        "7 * 2 = 14",
                        "W klamrach można umieścić dowolne wyrażenie.",
                    ),
                    tiles(
                        "Wczytaj imię od użytkownika do zmiennej imie",
                        listOf("imie", "=", "input(", "\"Imię: \"", ")"),
                        listOf("print("),
                        "input() pokazuje podpowiedź i zwraca wpisany tekst.",
                    ),
                ),
            ),
        ),
        CourseUnit(
            id = "u3",
            title = "Operatory i warunki",
            description = "Licz, porównuj i podejmuj decyzje",
            lessons = listOf(
                lesson(
                    "u3l1", "Matematyka",
                    output("print(7 // 2)", "3", "// to dzielenie całkowite – odcina część ułamkową."),
                    output("print(7 % 2)", "1", "% zwraca resztę z dzielenia."),
                    output("print(2 ** 3)", "8", "** to potęgowanie: 2 · 2 · 2."),
                    choice(
                        "Co wypisze ten kod?",
                        listOf("2", "2.5", "2.0", "3"),
                        1,
                        "Zwykłe dzielenie / zawsze daje float.",
                        code = "print(10 / 4)",
                    ),
                    fill(
                        "Oblicz resztę z dzielenia 10 przez 3.",
                        "print(10 ____ 3)",
                        listOf("%", "//", "/"),
                        "%",
                        "Reszta z dzielenia to operator %.",
                    ),
                ),
                lesson(
                    "u3l2", "Prawda i fałsz",
                    output("print(3 > 2)", "True", "Porównanie zwraca wartość logiczną True lub False."),
                    choice(
                        "Który operator sprawdza, czy dwie wartości są równe?",
                        listOf("==", "=", "===", "equals"),
                        0,
                        "== porównuje, a pojedyncze = przypisuje.",
                    ),
                    output(
                        "print(5 == 5 and 3 > 4)",
                        "False",
                        "and wymaga, by oba warunki były prawdziwe – a 3 > 4 jest fałszem.",
                    ),
                    output("print(not False)", "True", "not odwraca wartość logiczną."),
                    tiles(
                        "Zapisz warunek: x jest różne od 0",
                        listOf("x", "!=", "0"),
                        listOf("=", "<>"),
                        "Operator „różne od” to !=.",
                    ),
                ),
                lesson(
                    "u3l3", "Instrukcja if",
                    output(
                        "x = 10\nif x > 5:\n    print(\"duże\")\nelse:\n    print(\"małe\")",
                        "duże",
                        "Warunek x > 5 jest prawdziwy, więc wykona się pierwszy blok.",
                    ),
                    fill(
                        "Uzupełnij brakujący znak.",
                        "x = 1\nif x > 0____\n    print(\"dodatnia\")",
                        listOf(":", ";", "{"),
                        ":",
                        "Linia z if kończy się dwukropkiem.",
                    ),
                    choice(
                        "Ile spacji zwykle stosuje się do wcięcia bloku w Pythonie?",
                        listOf("2", "4", "8", "Wcięcia nie mają znaczenia"),
                        1,
                        "Standard PEP 8 zaleca 4 spacje. Wcięcia w Pythonie są obowiązkowe!",
                    ),
                    output(
                        "t = 15\nif t > 25:\n    print(\"gorąco\")\nelif t > 10:\n    print(\"ciepło\")\nelse:\n    print(\"zimno\")",
                        "ciepło",
                        "Pierwszy warunek jest fałszywy, drugi (15 > 10) – prawdziwy.",
                    ),
                    choice(
                        "Które słowo kluczowe znaczy „w przeciwnym razie, jeśli”?",
                        listOf("else if", "elif", "elseif", "otherwise"),
                        1,
                        "W Pythonie piszemy elif.",
                    ),
                ),
            ),
        ),
        CourseUnit(
            id = "u4",
            title = "Pętle",
            description = "Powtarzaj kod bez kopiowania",
            lessons = listOf(
                lesson(
                    "u4l1", "Pętla for",
                    output(
                        "for i in range(3):\n    print(i)",
                        "0\n1\n2",
                        "range(3) daje liczby 0, 1, 2 – bez trójki!",
                    ),
                    choice(
                        "Jakie liczby wygeneruje range(1, 4)?",
                        listOf("1, 2, 3", "1, 2, 3, 4", "0, 1, 2, 3", "4"),
                        0,
                        "Koniec zakresu nie jest wliczany.",
                    ),
                    tiles(
                        "Ułóż nagłówek pętli przechodzącej przez liczby od 0 do 4",
                        listOf("for", "i", "in", "range(5)", ":"),
                        listOf("while", "range(4)"),
                        "for zmienna in sekwencja: – i nie zapomnij o dwukropku.",
                    ),
                    output(
                        "for litera in \"abc\":\n    print(litera)",
                        "a\nb\nc",
                        "Pętla for przechodzi też po kolejnych znakach napisu.",
                    ),
                    output(
                        "suma = 0\nfor i in range(4):\n    suma += i\nprint(suma)",
                        "6",
                        "0 + 1 + 2 + 3 = 6.",
                    ),
                ),
                lesson(
                    "u4l2", "while, break i continue",
                    output(
                        "n = 3\nwhile n > 0:\n    print(n)\n    n -= 1",
                        "3\n2\n1",
                        "Pętla działa, dopóki n > 0; za każdym razem zmniejszamy n o 1.",
                    ),
                    choice(
                        "Co natychmiast przerywa pętlę?",
                        listOf("break", "continue", "stop", "exit loop"),
                        0,
                        "break kończy pętlę, a continue przechodzi do następnego obrotu.",
                    ),
                    output(
                        "for i in range(5):\n    if i == 3:\n        break\n    print(i)",
                        "0\n1\n2",
                        "Gdy i osiąga 3, break kończy pętlę przed wypisaniem.",
                    ),
                    output(
                        "for i in range(4):\n    if i % 2 == 0:\n        continue\n    print(i)",
                        "1\n3",
                        "continue pomija liczby parzyste.",
                    ),
                    fill(
                        "Dokończ pętlę, która działa, dopóki x jest mniejsze od 10.",
                        "x = 0\n____ x < 10:\n    x += 1",
                        listOf("while", "for", "loop"),
                        "while",
                        "while powtarza blok, dopóki warunek jest prawdziwy.",
                    ),
                ),
            ),
        ),
        CourseUnit(
            id = "u5",
            title = "Listy",
            description = "Przechowuj wiele wartości naraz",
            lessons = listOf(
                lesson(
                    "u5l1", "Tworzenie list",
                    choice(
                        "Jak utworzyć listę z liczbami 1, 2, 3?",
                        listOf("[1, 2, 3]", "<1, 2, 3>", "{1 2 3}", "list 1 2 3"),
                        0,
                        "Listy zapisujemy w nawiasach kwadratowych.",
                    ),
                    output(
                        "owoce = [\"jabłko\", \"banan\", \"kiwi\"]\nprint(owoce[0])",
                        "jabłko",
                        "Indeksy zaczynają się od 0.",
                    ),
                    output(
                        "owoce = [\"jabłko\", \"banan\", \"kiwi\"]\nprint(owoce[-1])",
                        "kiwi",
                        "Indeks -1 oznacza ostatni element.",
                    ),
                    output("print(len([4, 8, 15, 16]))", "4", "len() zwraca liczbę elementów."),
                    fill(
                        "Dodaj 3 na koniec listy.",
                        "liczby = [1, 2]\nliczby.____(3)\nprint(liczby)",
                        listOf("append", "add", "push"),
                        "append",
                        "Metoda append() dodaje element na koniec listy.",
                    ),
                ),
                lesson(
                    "u5l2", "Operacje na listach",
                    output(
                        "x = [1, 2, 3, 4, 5]\nprint(x[1:3])",
                        "[2, 3]",
                        "Wycinek [1:3] bierze elementy o indeksach 1 i 2.",
                    ),
                    output(
                        "x = [3, 1, 2]\nx.sort()\nprint(x)",
                        "[1, 2, 3]",
                        "sort() porządkuje listę rosnąco.",
                    ),
                    choice(
                        "Co wypisze ten kod?",
                        listOf("True", "False", "kot", "1"),
                        0,
                        "Operator in sprawdza, czy element jest na liście.",
                        code = "zwierzeta = [\"pies\", \"kot\"]\nprint(\"kot\" in zwierzeta)",
                    ),
                    output(
                        "imiona = [\"Ala\", \"Ola\"]\nfor imie in imiona:\n    print(\"Hej \" + imie)",
                        "Hej Ala\nHej Ola",
                        "Pętla for przechodzi po kolejnych elementach listy.",
                    ),
                    tiles(
                        "Zapisz w zmiennej suma sumę liczb z listy oceny",
                        listOf("suma", "=", "sum(oceny)"),
                        listOf("len(oceny)", "+="),
                        "Wbudowana funkcja sum() dodaje wszystkie elementy.",
                    ),
                ),
            ),
        ),
        CourseUnit(
            id = "u6",
            title = "Funkcje",
            description = "Twórz własne polecenia",
            lessons = listOf(
                lesson(
                    "u6l1", "Definiowanie funkcji",
                    choice(
                        "Które słowo kluczowe definiuje funkcję?",
                        listOf("def", "function", "fun", "func"),
                        0,
                        "Funkcje w Pythonie definiujemy słowem def.",
                    ),
                    output(
                        "def przywitaj():\n    print(\"Cześć!\")\n\nprzywitaj()\nprzywitaj()",
                        "Cześć!\nCześć!",
                        "Funkcję wywołano dwa razy, więc tekst pojawi się dwukrotnie.",
                    ),
                    tiles(
                        "Ułóż nagłówek funkcji dodaj z parametrami a i b",
                        listOf("def", "dodaj(a, b)", ":"),
                        listOf("function", "dodaj[a, b]"),
                        "def nazwa(parametry): – z dwukropkiem na końcu.",
                    ),
                    output(
                        "def podwoj(x):\n    return x * 2\n\nprint(podwoj(4))",
                        "8",
                        "return oddaje wynik funkcji.",
                    ),
                    fill(
                        "Uzupełnij, aby funkcja zwracała kwadrat liczby.",
                        "def kwadrat(x):\n    ____ x * x",
                        listOf("return", "print", "give"),
                        "return",
                        "Wynik funkcji zwracamy słowem return.",
                    ),
                ),
                lesson(
                    "u6l2", "Parametry i wynik",
                    output(
                        "def powitaj(imie=\"gościu\"):\n    return \"Hej, \" + imie\n\nprint(powitaj())\nprint(powitaj(\"Kuba\"))",
                        "Hej, gościu\nHej, Kuba",
                        "Parametr z wartością domyślną można pominąć przy wywołaniu.",
                    ),
                    choice(
                        "Co wypisze ten kod?",
                        listOf("None", "1", "0", "Błąd"),
                        0,
                        "Funkcja bez return zwraca None.",
                        code = "def f():\n    x = 1\n\nprint(f())",
                    ),
                    output(
                        "def maks(a, b):\n    if a > b:\n        return a\n    return b\n\nprint(maks(3, 9))",
                        "9",
                        "3 > 9 to fałsz, więc funkcja zwraca b.",
                    ),
                    output(
                        "def suma_listy(lista):\n    s = 0\n    for e in lista:\n        s += e\n    return s\n\nprint(suma_listy([2, 4, 6]))",
                        "12",
                        "Funkcja dodaje kolejne elementy: 2 + 4 + 6.",
                    ),
                    choice(
                        "Czym jest argument funkcji?",
                        listOf(
                            "Wartością przekazaną do funkcji przy wywołaniu",
                            "Nazwą funkcji",
                            "Komentarzem w funkcji",
                            "Błędem w funkcji",
                        ),
                        0,
                        "W podwoj(4) liczba 4 jest argumentem.",
                    ),
                ),
            ),
        ),
    )

    val allLessons: List<Lesson> get() = units.flatMap { it.lessons }

    fun findLesson(id: String): Lesson? = allLessons.firstOrNull { it.id == id }
}
