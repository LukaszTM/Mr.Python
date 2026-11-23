package com.mrpython.app.data.course

import com.mrpython.app.domain.CourseUnit

internal val module35 = CourseUnit(
    id = "u35",
    title = "Własne wyjątki",
    description = "Klasy wyjątków, ich hierarchia i raise ... from",
    lessons = listOf(
        lesson(
            "u35l1", "Własna klasa wyjątku",
            output(
                "class ZaMaloError(Exception):\n    pass\n\ntry:\n    raise ZaMaloError(\"za mało środków\")\nexcept ZaMaloError as e:\n    print(e)",
                "za mało środków",
                "Własny wyjątek to klasa dziedzicząca po Exception; komunikat podajemy w nawiasie.",
            ),
            choice(
                "Po jakiej klasie zwykle dziedziczy własny wyjątek?",
                listOf("Exception", "Error", "object", "Throwable"),
                0,
                "Własne wyjątki dziedziczą po Exception (lub jej podklasie).",
            ),
            output(
                "class ZlyWiekError(Exception):\n    pass\n\ndef ustaw(wiek):\n    if wiek < 0:\n        raise ZlyWiekError(\"wiek < 0\")\n    return wiek\n\ntry:\n    ustaw(-3)\nexcept ZlyWiekError as e:\n    print(\"Błąd:\", e)",
                "Błąd: wiek < 0",
                "Funkcja zgłasza własny wyjątek, a kod wywołujący go przechwytuje.",
            ),
            fill(
                "Uzupełnij, aby BrakTowaru był wyjątkiem.",
                "class BrakTowaru(____):\n    pass\n\ntry:\n    raise BrakTowaru(\"brak mleka\")\nexcept BrakTowaru as e:\n    print(e)",
                listOf("Exception", "object", "str"),
                "Exception",
                "raise działa tylko z klasami dziedziczącymi po BaseException, np. Exception.",
            ),
            output(
                "class MojBlad(Exception):\n    pass\n\ntry:\n    raise MojBlad(\"x\")\nexcept Exception as e:\n    print(type(e).__name__)",
                "MojBlad",
                "except Exception łapie też własne wyjątki, a type(e) zdradza ich klasę.",
            ),
            tiles(
                "Zgłoś wyjątek BrakSrodkow z komunikatem \"za mało\"",
                listOf("raise", "BrakSrodkow(", "\"za mało\"", ")"),
                listOf("throw", "return"),
                "Wyjątki zgłaszamy słowem raise.",
            ),
            choice(
                "Dlaczego warto tworzyć własne wyjątki?",
                listOf("Nazwa mówi, co poszło nie tak, i można je łapać osobno", "Bo wbudowane wyjątki są wolniejsze", "Bo Python nie ma wbudowanych wyjątków", "Żeby program nigdy się nie zatrzymał"),
                0,
                "Własny wyjątek precyzyjnie opisuje problem w naszym programie.",
            ),
            output(
                "class KodError(Exception):\n    def __init__(self, kod):\n        super().__init__(f\"kod {kod}\")\n        self.kod = kod\n\ntry:\n    raise KodError(404)\nexcept KodError as e:\n    print(e, e.kod)",
                "kod 404 404",
                "Wyjątek może mieć własne atrybuty, a super().__init__ ustawia komunikat.",
            ),
        ),
        lesson(
            "u35l2", "Hierarchia wyjątków",
            output(
                "class BladAplikacji(Exception):\n    pass\n\nclass BladLogowania(BladAplikacji):\n    pass\n\ntry:\n    raise BladLogowania(\"złe hasło\")\nexcept BladAplikacji as e:\n    print(\"Złapano:\", e)",
                "Złapano: złe hasło",
                "except z klasą bazową łapie też wyjątki klas pochodnych.",
            ),
            output(
                "class BladApp(Exception):\n    pass\nclass BladLog(BladApp):\n    pass\ntry:\n    raise BladLog()\nexcept BladLog:\n    print(\"logowanie\")\nexcept BladApp:\n    print(\"aplikacja\")",
                "logowanie",
                "Wykonuje się pierwszy pasujący blok except.",
            ),
            choice(
                "Po jakiej klasie dziedziczy wbudowany ValueError?",
                listOf("Exception", "KeyError", "TypeError", "ValueBase"),
                0,
                "Prawie wszystkie wbudowane wyjątki dziedziczą po Exception.",
            ),
            output(
                "print(issubclass(KeyError, LookupError))\nprint(issubclass(ZeroDivisionError, ArithmeticError))",
                "True\nTrue",
                "Wbudowane wyjątki też tworzą hierarchię klas.",
            ),
            choice(
                "Co wypisze ten kod?",
                listOf("aplikacja", "logowanie", "aplikacja i logowanie", "Nic"),
                0,
                "BladLog jest też BladApp, a ten except stoi pierwszy – kolejność ma znaczenie.",
                code = "class BladApp(Exception):\n    pass\nclass BladLog(BladApp):\n    pass\ntry:\n    raise BladLog()\nexcept BladApp:\n    print(\"aplikacja\")\nexcept BladLog:\n    print(\"logowanie\")",
            ),
            fill(
                "Uzupełnij, aby except BladAplikacji obsłużył BladSieci.",
                "class BladAplikacji(Exception):\n    pass\n\nclass BladSieci(____):\n    pass\n\ntry:\n    raise BladSieci(\"timeout\")\nexcept BladAplikacji:\n    print(\"obsłużone\")",
                listOf("BladAplikacji", "Exception", "ValueError"),
                "BladAplikacji",
                "BladSieci musi dziedziczyć po BladAplikacji, aby ten except go złapał.",
            ),
            tiles(
                "Napisz nagłówek wyjątku BladPliku dziedziczącego po BladAplikacji",
                listOf("class", "BladPliku(", "BladAplikacji", "):"),
                listOf("def", "raise"),
                "Hierarchię wyjątków budujemy zwykłym dziedziczeniem.",
            ),
            output(
                "class BladA(Exception):\n    pass\n\nfor blad in [BladA(\"a\"), ValueError(\"v\")]:\n    try:\n        raise blad\n    except Exception as e:\n        print(type(e).__name__, e)",
                "BladA a\nValueError v",
                "except Exception łapie zarówno własne, jak i wbudowane wyjątki.",
            ),
        ),
        lesson(
            "u35l3", "Ponowne zgłaszanie i raise from",
            output(
                "def dziel(a, b):\n    try:\n        return a / b\n    except ZeroDivisionError:\n        print(\"loguję błąd\")\n        raise\n\ntry:\n    dziel(1, 0)\nexcept ZeroDivisionError:\n    print(\"obsłużone wyżej\")",
                "loguję błąd\nobsłużone wyżej",
                "Samo raise zgłasza ten sam wyjątek dalej, do kodu wywołującego.",
            ),
            choice(
                "Co robi samo słowo raise w bloku except?",
                listOf("Zgłasza ponownie ten sam wyjątek", "Kończy program bez błędu", "Ignoruje wyjątek", "Zgłasza nowy pusty wyjątek Exception"),
                0,
                "raise bez argumentu przekazuje obsługiwany wyjątek dalej.",
            ),
            output(
                "class BladKonfig(Exception):\n    pass\n\ndef wczytaj(s):\n    try:\n        return int(s)\n    except ValueError as e:\n        raise BladKonfig(\"zła liczba\") from e\n\ntry:\n    wczytaj(\"abc\")\nexcept BladKonfig as e:\n    print(e)",
                "zła liczba",
                "raise ... from zamienia błąd niskiego poziomu na nasz własny wyjątek.",
            ),
            output(
                "try:\n    try:\n        int(\"x\")\n    except ValueError as e:\n        raise RuntimeError(\"błąd\") from e\nexcept RuntimeError as e:\n    print(type(e.__cause__).__name__)",
                "ValueError",
                "Oryginalny wyjątek trafia do atrybutu __cause__.",
            ),
            fill(
                "Uzupełnij, aby zachować przyczynę nowego wyjątku.",
                "class BladDanych(Exception):\n    pass\n\ntry:\n    try:\n        [][0]\n    except IndexError as e:\n        raise BladDanych(\"pusto\") ____ e\nexcept BladDanych as b:\n    print(b, type(b.__cause__).__name__)",
                listOf("from", "as", "with"),
                "from",
                "raise NowyBlad(...) from e łączy nowy wyjątek z jego przyczyną.",
            ),
            choice(
                "Po co pisać raise NowyBlad(...) from e?",
                listOf("Żeby zachować informację o oryginalnej przyczynie błędu", "Żeby wyciszyć błąd", "Żeby zgłosić dwa wyjątki naraz", "Żeby przyspieszyć program"),
                0,
                "Komunikat błędu pokaże oba wyjątki: przyczynę i nowy.",
            ),
            tiles(
                "Zgłoś BladApp(\"x\") z przyczyną e",
                listOf("raise", "BladApp(\"x\")", "from", "e"),
                listOf("as", "except"),
                "Składnia to raise NowyWyjatek from przyczyna.",
            ),
        ),
        lesson(
            "u35l4", "Powtórka: własne wyjątki",
            output(
                "class ZlaKwota(Exception):\n    pass\n\ndef wplac(k):\n    if k <= 0:\n        raise ZlaKwota(f\"kwota {k}\")\n    return k\n\nfor k in [50, -5]:\n    try:\n        print(wplac(k))\n    except ZlaKwota as e:\n        print(\"błąd:\", e)",
                "50\nbłąd: kwota -5",
                "Poprawna kwota jest zwracana, a zła zgłasza własny wyjątek.",
            ),
            choice(
                "Który zapis poprawnie definiuje własny wyjątek?",
                listOf("class MojBlad(Exception): pass", "def MojBlad(Exception): pass", "exception MojBlad: pass", "class MojBlad: raise"),
                0,
                "Wyjątek to klasa dziedzicząca po Exception.",
            ),
            output(
                "class BladApp(Exception):\n    pass\n\nclass BladDysku(BladApp):\n    pass\n\ntry:\n    raise BladDysku(\"pełny dysk\")\nexcept BladApp as e:\n    print(type(e).__name__, e)",
                "BladDysku pełny dysk",
                "Złapaliśmy klasę bazową, ale obiekt nadal jest typu BladDysku.",
            ),
            fill(
                "Uzupełnij, aby wyjątek poszedł dalej (wypisze „log” i „złapany”).",
                "def sprawdz(x):\n    try:\n        return 10 / x\n    except ZeroDivisionError:\n        print(\"log\")\n        ____\n\ntry:\n    sprawdz(0)\nexcept ZeroDivisionError:\n    print(\"złapany\")",
                listOf("raise", "pass", "return"),
                "raise",
                "Samo raise ponownie zgłasza ten sam wyjątek.",
            ),
            output(
                "class A(Exception):\n    pass\n\nclass B(Exception):\n    pass\n\nfor blad in [A, B]:\n    try:\n        raise blad\n    except (A, B) as e:\n        print(type(e).__name__)",
                "A\nB",
                "W nawiasie można podać kilka klas wyjątków; raise przyjmuje też samą klasę.",
            ),
            choice(
                "Który except złapie BladLogowania, jeśli dziedziczy on po BladAplikacji?",
                listOf("Zarówno except BladLogowania, jak i except BladAplikacji", "Tylko except BladLogowania", "Tylko except BladAplikacji", "Żaden"),
                0,
                "Wyjątek pasuje do swojej klasy i do wszystkich klas bazowych.",
            ),
            output(
                "try:\n    try:\n        {}[\"x\"]\n    except KeyError as e:\n        raise ValueError(\"brak\") from e\nexcept ValueError as e:\n    print(e, type(e.__cause__).__name__)",
                "brak KeyError",
                "Przyczyna (KeyError) jest zapisana w __cause__ nowego wyjątku.",
            ),
            tiles(
                "Sprawdź, czy KeyError dziedziczy po LookupError, i wypisz wynik",
                listOf("print(", "issubclass(", "KeyError,", "LookupError", "))"),
                listOf("isinstance(", "except"),
                "issubclass sprawdza zależność między klasami wyjątków.",
            ),
        ),
    ),
)
