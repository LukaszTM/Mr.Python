package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

internal val module18Cards = listOf(
    cards(
        "u18l1",
        explain(
            "Import first",
            "A module's name exists only after `import` has run, which is why we put imports at the top " +
                "of the file. After `import math` we call functions with the prefix – a bare `sqrt(9)` gives a `NameError`.",
            code = "import math\nprint(math.sqrt(9))\nprint(math.floor(7.9))",
            output = "3.0\n7",
        ),
        explain(
            "A square root is a float",
            "`math.sqrt()` always returns a float, even when the result is whole. When you need an int, " +
                "use `int()`, and `round(x, 3)` rounds to three decimal places.",
            code = "import math\nx = math.sqrt(36)\nprint(x, int(x))\nprint(round(math.pi, 3))",
            output = "6.0 6\n3.142",
        ),
    ),
    cards(
        "u18l2",
        explain(
            "Several names and aliases",
            "After `from math import` you can list several names separated by commas. You can also give an `as` alias " +
                "to a single name, e.g. `from math import floor as f`.",
            code = "from math import pi, floor as f\nprint(f(pi))",
            output = "3",
        ),
        explain(
            "Which name exists?",
            "Only the names created by the import are available. After `import math as m`, `m` works but " +
                "`math` doesn't, and after `from math import sqrt` there is `sqrt` but no `math`. Otherwise – `NameError`.",
            code = "import math as m\ntry:\n    print(math.pi)\nexcept NameError:\n    print(\"only m\")",
            output = "only m",
        ),
    ),
    cards(
        "u18l3",
        explain(
            "Powers: math.pow",
            "`math.pow(a, b)` raises `a` to the power `b` and always returns a float. The power 0.5 is the square root.",
            code = "import math\nprint(math.pow(2, 3), math.pow(9, 0.5))",
            output = "8.0 3.0",
        ),
        explain(
            "Negative numbers",
            "`floor` always goes down, to the smaller number, and `ceil` goes up. That's why `floor(-2.5)` " +
                "is -3, and `ceil(-2.5)` is -2. A number that is already whole doesn't change.",
            code = "import math\nprint(math.floor(-2.5), math.ceil(-2.5))\nprint(math.ceil(5.0))",
            output = "-3 -2\n5",
        ),
    ),
    cards(
        "u18l4",
        explain(
            "Importing everything: *",
            "`from math import *` loads all of the module's public names at once. Name conflicts happen easily " +
                "then: a later assignment or your own function with the same name will hide the imported one.",
            code = "from math import *\nprint(floor(2.9))\npi = 3\nprint(pi)",
            output = "2\n3",
        ),
        explain(
            "The standard library",
            "Modules such as `math` or `random` are available as soon as Python is installed. A module " +
                "is loaded only once, even with several imports. When it doesn't exist, you get a `ModuleNotFoundError`.",
            code = "try:\n    import mathematics\nexcept ModuleNotFoundError:\n    print(\"missing\")",
            output = "missing",
        ),
    ),
)
