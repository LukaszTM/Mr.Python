package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

internal val module35Cards = listOf(
    cards(
        "u35l1",
        explain(
            "An exception with its own data",
            "A custom exception can have an `__init__` with extra attributes. `super().__init__(message)` " +
                "sets the text that `print(e)` will show.",
            code = "class CodeError(Exception):\n    def __init__(self, code):\n        super().__init__(f\"code {code}\")\n        self.code = code\n\ntry:\n    raise CodeError(404)\nexcept CodeError as e:\n    print(e, e.code)",
            output = "code 404 404",
        ),
        explain(
            "What can you raise?",
            "`raise` only accepts exceptions – the class must inherit from `Exception`, otherwise you get a `TypeError`. " +
                "You can raise an object `MyError(\"description\")` or just the class `MyError`. Names usually end in `Error`.",
            code = "class Stop(Exception):\n    pass\n\ntry:\n    raise Stop\nexcept Stop:\n    print(\"caught\")",
            output = "caught",
        ),
    ),
    cards(
        "u35l2",
        explain(
            "The family of built-in exceptions",
            "Built-in exceptions inherit from each other too: `KeyError` and `IndexError` from `LookupError`, " +
                "and `ZeroDivisionError` from `ArithmeticError`. They all inherit from `Exception`.",
            code = "print(issubclass(KeyError, LookupError))\ntry:\n    1 / 0\nexcept ArithmeticError as e:\n    print(type(e).__name__)",
            output = "True\nZeroDivisionError",
        ),
        explain(
            "Several exceptions at once",
            "In a single `except` you can give a tuple of exception classes. The block handles each of them, " +
                "and `type(e).__name__` tells you which one occurred.",
            code = "for err in [KeyError, ValueError]:\n    try:\n        raise err\n    except (KeyError, ValueError) as e:\n        print(type(e).__name__)",
            output = "KeyError\nValueError",
        ),
    ),
)
