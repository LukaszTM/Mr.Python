package com.mrpython.app.data.course

internal val module37Intro = lesson(
    "u37l0", "Wprowadzenie: kompozycja obiektów",
    explain(
        "Obiekty w obiektach",
        "Kompozycja to budowanie obiektu z innych obiektów. Auto ma silnik, więc atrybut `self.silnik` " +
            "przechowuje obiekt klasy `Silnik`. Do jego danych dochodzimy kropka po kropce.",
        code = "class Silnik:\n    def __init__(self, moc):\n        self.moc = moc\n\nclass Auto:\n    def __init__(self, moc):\n        self.silnik = Silnik(moc)\n\nprint(Auto(150).silnik.moc)",
        output = "150",
    ),
    explain(
        "Listy obiektów",
        "Obiekt może też trzymać całą listę innych obiektów – np. drużyna listę graczy. " +
            "Jego metody przechodzą po tej liście i zbierają wyniki.",
        code = "class Gracz:\n    def __init__(self, gole):\n        self.gole = gole\n\nclass Druzyna:\n    def __init__(self, gracze):\n        self.gracze = gracze\n    def gole(self):\n        return sum(g.gole for g in self.gracze)\n\nprint(Druzyna([Gracz(2), Gracz(3)]).gole())",
        output = "5",
    ),
    explain(
        "Delegowanie",
        "Delegowanie to zlecanie pracy swojemu składnikowi: `Auto.jedz()` woła `self.silnik.start()`. " +
            "Każda klasa odpowiada za swoje zadanie. Metody specjalne, jak `__len__`, też mogą delegować do listy.",
        code = "class Silnik:\n    def start(self):\n        return \"brum\"\n\nclass Auto:\n    def __init__(self):\n        self.silnik = Silnik()\n    def jedz(self):\n        return self.silnik.start()\n\nprint(Auto().jedz())",
        output = "brum",
    ),
    explain(
        "„Ma” czy „jest”?",
        "Relacja „jest” (pies jest zwierzęciem) to dziedziczenie. Relacja „ma” (samochód ma koła) " +
            "to kompozycja. Zasada „kompozycja ponad dziedziczenie”: gdy nie ma prawdziwego „jest”, złóż obiekt z części.",
        code = "class Kolo:\n    pass\n\nclass Rower:\n    def __init__(self):\n        self.kola = [Kolo(), Kolo()]\n\nprint(len(Rower().kola))",
        output = "2",
    ),
    choice(
        "Która relacja to kompozycja?",
        listOf("Biblioteka ma książki", "Kot jest zwierzęciem", "Kwadrat jest figurą", "ValueError jest wyjątkiem"),
        0,
        "„Ma” oznacza kompozycję, „jest” – dziedziczenie.",
    ),
    fill(
        "Uzupełnij, aby auto delegowało start do silnika (wypisze brum).",
        "class Silnik:\n    def start(self):\n        return \"brum\"\n\nclass Auto:\n    def __init__(self):\n        self.silnik = Silnik()\n    def jedz(self):\n        return self.____.start()\n\nprint(Auto().jedz())",
        listOf("silnik", "Silnik", "jedz"),
        "silnik",
        "start() wywołujemy na atrybucie self.silnik.",
    ),
    output(
        "class Silnik:\n    def __init__(self):\n        self.moc = 90\n\nclass Auto:\n    def __init__(self):\n        self.silnik = Silnik()\n\na = Auto()\nprint(a.silnik.moc)",
        "90",
        "a.silnik to obiekt Silnik, a jego moc to 90.",
    ),
)
