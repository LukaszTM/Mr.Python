package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*
import com.mrpython.app.domain.CourseUnit

internal val module35 = CourseUnit(
    id = "u35",
    title = "Custom exceptions",
    description = "Exception classes, their hierarchy and raise ... from",
    lessons = listOf(
        lesson(
            "u35l1", "Your own exception class",
            output(
                "class LowFundsError(Exception):\n    pass\n\ntry:\n    raise LowFundsError(\"not enough funds\")\nexcept LowFundsError as e:\n    print(e)",
                "not enough funds",
                "A custom exception is a class that inherits from Exception; the message goes in the parentheses.",
            ),
            choice(
                "Which class does a custom exception usually inherit from?",
                listOf("Exception", "Error", "object", "Throwable"),
                0,
                "Custom exceptions inherit from Exception (or one of its subclasses).",
            ),
            output(
                "class BadAgeError(Exception):\n    pass\n\ndef set_age(age):\n    if age < 0:\n        raise BadAgeError(\"age < 0\")\n    return age\n\ntry:\n    set_age(-3)\nexcept BadAgeError as e:\n    print(\"Error:\", e)",
                "Error: age < 0",
                "The function raises a custom exception, and the calling code catches it.",
            ),
            fill(
                "Complete the code so that OutOfStock is an exception.",
                "class OutOfStock(____):\n    pass\n\ntry:\n    raise OutOfStock(\"no milk\")\nexcept OutOfStock as e:\n    print(e)",
                listOf("Exception", "object", "str"),
                "Exception",
                "raise only works with classes that inherit from BaseException, e.g. Exception.",
            ),
            output(
                "class MyError(Exception):\n    pass\n\ntry:\n    raise MyError(\"x\")\nexcept Exception as e:\n    print(type(e).__name__)",
                "MyError",
                "except Exception catches custom exceptions too, and type(e) reveals their class.",
            ),
            tiles(
                "Raise the exception NoFunds with the message \"too little\"",
                listOf("raise", "NoFunds(", "\"too little\"", ")"),
                listOf("throw", "return"),
                "We raise exceptions with the raise keyword.",
            ),
            choice(
                "Why is it worth creating your own exceptions?",
                listOf("The name says what went wrong, and they can be caught separately", "Because built-in exceptions are slower", "Because Python has no built-in exceptions", "So that the program never stops"),
                0,
                "A custom exception precisely describes a problem in our program.",
            ),
            output(
                "class CodeError(Exception):\n    def __init__(self, code):\n        super().__init__(f\"code {code}\")\n        self.code = code\n\ntry:\n    raise CodeError(404)\nexcept CodeError as e:\n    print(e, e.code)",
                "code 404 404",
                "An exception can have its own attributes, and super().__init__ sets the message.",
            ),
        ),
        lesson(
            "u35l2", "Exception hierarchy",
            output(
                "class ApplicationError(Exception):\n    pass\n\nclass LoginError(ApplicationError):\n    pass\n\ntry:\n    raise LoginError(\"wrong password\")\nexcept ApplicationError as e:\n    print(\"Caught:\", e)",
                "Caught: wrong password",
                "An except with a base class also catches exceptions of derived classes.",
            ),
            output(
                "class AppError(Exception):\n    pass\nclass LoginError(AppError):\n    pass\ntry:\n    raise LoginError()\nexcept LoginError:\n    print(\"login\")\nexcept AppError:\n    print(\"app\")",
                "login",
                "The first matching except block runs.",
            ),
            choice(
                "Which class does the built-in ValueError inherit from?",
                listOf("Exception", "KeyError", "TypeError", "ValueBase"),
                0,
                "Almost all built-in exceptions inherit from Exception.",
            ),
            output(
                "print(issubclass(KeyError, LookupError))\nprint(issubclass(ZeroDivisionError, ArithmeticError))",
                "True\nTrue",
                "Built-in exceptions form a class hierarchy too.",
            ),
            choice(
                "What will this code print?",
                listOf("app", "login", "app and login", "Nothing"),
                0,
                "A LoginError is also an AppError, and that except comes first – order matters.",
                code = "class AppError(Exception):\n    pass\nclass LoginError(AppError):\n    pass\ntry:\n    raise LoginError()\nexcept AppError:\n    print(\"app\")\nexcept LoginError:\n    print(\"login\")",
            ),
            fill(
                "Complete the code so that except ApplicationError handles NetworkError.",
                "class ApplicationError(Exception):\n    pass\n\nclass NetworkError(____):\n    pass\n\ntry:\n    raise NetworkError(\"timeout\")\nexcept ApplicationError:\n    print(\"handled\")",
                listOf("ApplicationError", "Exception", "ValueError"),
                "ApplicationError",
                "NetworkError must inherit from ApplicationError for that except to catch it.",
            ),
            tiles(
                "Write the header of the exception FileError that inherits from ApplicationError",
                listOf("class", "FileError(", "ApplicationError", "):"),
                listOf("def", "raise"),
                "We build an exception hierarchy with ordinary inheritance.",
            ),
            output(
                "class ErrorA(Exception):\n    pass\n\nfor err in [ErrorA(\"a\"), ValueError(\"v\")]:\n    try:\n        raise err\n    except Exception as e:\n        print(type(e).__name__, e)",
                "ErrorA a\nValueError v",
                "except Exception catches both custom and built-in exceptions.",
            ),
        ),
        lesson(
            "u35l3", "Re-raising and raise from",
            output(
                "def divide(a, b):\n    try:\n        return a / b\n    except ZeroDivisionError:\n        print(\"logging the error\")\n        raise\n\ntry:\n    divide(1, 0)\nexcept ZeroDivisionError:\n    print(\"handled higher up\")",
                "logging the error\nhandled higher up",
                "A bare raise passes the same exception on to the calling code.",
            ),
            choice(
                "What does the word raise on its own do in an except block?",
                listOf("It re-raises the same exception", "It ends the program without an error", "It ignores the exception", "It raises a new empty Exception"),
                0,
                "raise without an argument passes the exception being handled further on.",
            ),
            output(
                "class ConfigError(Exception):\n    pass\n\ndef load(s):\n    try:\n        return int(s)\n    except ValueError as e:\n        raise ConfigError(\"bad number\") from e\n\ntry:\n    load(\"abc\")\nexcept ConfigError as e:\n    print(e)",
                "bad number",
                "raise ... from turns a low-level error into our own exception.",
            ),
            output(
                "try:\n    try:\n        int(\"x\")\n    except ValueError as e:\n        raise RuntimeError(\"error\") from e\nexcept RuntimeError as e:\n    print(type(e.__cause__).__name__)",
                "ValueError",
                "The original exception ends up in the __cause__ attribute.",
            ),
            fill(
                "Complete the code to keep the cause of the new exception.",
                "class DataError(Exception):\n    pass\n\ntry:\n    try:\n        [][0]\n    except IndexError as e:\n        raise DataError(\"empty\") ____ e\nexcept DataError as b:\n    print(b, type(b.__cause__).__name__)",
                listOf("from", "as", "with"),
                "from",
                "raise NewError(...) from e links the new exception to its cause.",
            ),
            choice(
                "Why write raise NewError(...) from e?",
                listOf("To keep the information about the original cause of the error", "To silence the error", "To raise two exceptions at once", "To speed up the program"),
                0,
                "The error message will show both exceptions: the cause and the new one.",
            ),
            tiles(
                "Raise AppError(\"x\") with the cause e",
                listOf("raise", "AppError(\"x\")", "from", "e"),
                listOf("as", "except"),
                "The syntax is raise NewException from cause.",
            ),
        ),
        lesson(
            "u35l4", "Review: custom exceptions",
            output(
                "class BadAmount(Exception):\n    pass\n\ndef deposit(a):\n    if a <= 0:\n        raise BadAmount(f\"amount {a}\")\n    return a\n\nfor a in [50, -5]:\n    try:\n        print(deposit(a))\n    except BadAmount as e:\n        print(\"error:\", e)",
                "50\nerror: amount -5",
                "A valid amount is returned, and a bad one raises a custom exception.",
            ),
            choice(
                "Which notation correctly defines a custom exception?",
                listOf("class MyError(Exception): pass", "def MyError(Exception): pass", "exception MyError: pass", "class MyError: raise"),
                0,
                "An exception is a class that inherits from Exception.",
            ),
            output(
                "class AppError(Exception):\n    pass\n\nclass DiskError(AppError):\n    pass\n\ntry:\n    raise DiskError(\"disk full\")\nexcept AppError as e:\n    print(type(e).__name__, e)",
                "DiskError disk full",
                "We caught the base class, but the object is still of type DiskError.",
            ),
            fill(
                "Complete the code so the exception is passed on (prints \"log\" and \"caught\").",
                "def check(x):\n    try:\n        return 10 / x\n    except ZeroDivisionError:\n        print(\"log\")\n        ____\n\ntry:\n    check(0)\nexcept ZeroDivisionError:\n    print(\"caught\")",
                listOf("raise", "pass", "return"),
                "raise",
                "A bare raise re-raises the same exception.",
            ),
            output(
                "class A(Exception):\n    pass\n\nclass B(Exception):\n    pass\n\nfor err in [A, B]:\n    try:\n        raise err\n    except (A, B) as e:\n        print(type(e).__name__)",
                "A\nB",
                "You can list several exception classes in parentheses; raise also accepts just the class.",
            ),
            choice(
                "Which except will catch LoginError if it inherits from ApplicationError?",
                listOf("Both except LoginError and except ApplicationError", "Only except LoginError", "Only except ApplicationError", "Neither"),
                0,
                "An exception matches its own class and all of its base classes.",
            ),
            output(
                "try:\n    try:\n        {}[\"x\"]\n    except KeyError as e:\n        raise ValueError(\"missing\") from e\nexcept ValueError as e:\n    print(e, type(e.__cause__).__name__)",
                "missing KeyError",
                "The cause (KeyError) is stored in the __cause__ of the new exception.",
            ),
            tiles(
                "Check whether KeyError inherits from LookupError and print the result",
                listOf("print(", "issubclass(", "KeyError,", "LookupError", "))"),
                listOf("isinstance(", "except"),
                "issubclass checks the relationship between exception classes.",
            ),
        ),
    ),
)
