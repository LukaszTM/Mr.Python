package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

internal val module35Intro = lesson(
    "u35l0", "Introduction: custom exceptions",
    explain(
        "Your own exception class",
        "An exception is a class. We create our own by inheriting from `Exception` – often `pass` is enough. " +
            "The name says right away what went wrong, and such an error can be caught separately.",
        code = "class LowFundsError(Exception):\n    pass\n\ntry:\n    raise LowFundsError(\"not enough funds\")\nexcept LowFundsError as e:\n    print(e)",
        output = "not enough funds",
    ),
    explain(
        "Exception hierarchy",
        "Exceptions can inherit from each other. An `except` with a base class also catches all derived classes. " +
            "The first matching block runs, so we write more specific `except` blocks higher up.",
        code = "class AppError(Exception):\n    pass\n\nclass LoginError(AppError):\n    pass\n\ntry:\n    raise LoginError(\"wrong password\")\nexcept AppError as e:\n    print(\"Caught:\", e)",
        output = "Caught: wrong password",
    ),
    explain(
        "Re-raising: raise",
        "Sometimes we want to react to an error (e.g. write a log) but still pass it on. " +
            "A bare `raise` in an `except` block raises the same exception again.",
        code = "try:\n    try:\n        1 / 0\n    except ZeroDivisionError:\n        print(\"logging\")\n        raise\nexcept ZeroDivisionError:\n    print(\"handled higher up\")",
        output = "logging\nhandled higher up",
    ),
    explain(
        "raise ... from",
        "`raise NewError(...) from e` turns a technical error into our own, but keeps the cause. " +
            "The original exception ends up in the `__cause__` attribute of the new exception.",
        code = "try:\n    try:\n        int(\"x\")\n    except ValueError as e:\n        raise RuntimeError(\"bad number\") from e\nexcept RuntimeError as e:\n    print(e, type(e.__cause__).__name__)",
        output = "bad number ValueError",
    ),
    choice(
        "Which class does a custom exception usually inherit from?",
        listOf("Exception", "object", "Error", "str"),
        0,
        "Custom exceptions inherit from Exception.",
    ),
    tiles(
        "Raise the exception BadAge with the message \"negative\"",
        listOf("raise", "BadAge(", "\"negative\"", ")"),
        listOf("throw", "return"),
        "We raise exceptions with the raise keyword.",
    ),
    output(
        "class A(Exception):\n    pass\n\nclass B(A):\n    pass\n\ntry:\n    raise B(\"x\")\nexcept A:\n    print(\"caught by A\")",
        "caught by A",
        "B inherits from A, so except A catches B as well.",
    ),
)
