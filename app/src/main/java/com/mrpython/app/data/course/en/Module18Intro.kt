package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

internal val module18Intro = lesson(
    "u18l0", "Introduction: the math module",
    explain(
        "The import statement",
        "Python has many ready-made modules with extra functions. `import math` loads the math " +
            "module – we call its functions with a prefix, e.g. `math.sqrt()`.",
        code = "import math\nprint(math.sqrt(16))",
        output = "4.0",
    ),
    explain(
        "from … import and as",
        "`from math import sqrt` lets you write just `sqrt()`, without the prefix. " +
            "`import math as m` gives the module a shorter name – then we write `m.floor()`.",
        code = "from math import sqrt\nimport math as m\nprint(sqrt(49))\nprint(m.floor(3.9))",
        output = "7.0\n3",
    ),
    explain(
        "Rounding",
        "`math.floor()` rounds down, and `math.ceil()` rounds up – both return a whole number. " +
            "That's handy, for example, for working out how many buses a group needs.",
        code = "import math\nprint(math.floor(2.7))\nprint(math.ceil(2.1))",
        output = "2\n3",
    ),
    explain(
        "Other useful functions",
        "`math.pi` is the number π, `math.gcd(a, b)` is the greatest common divisor, and `math.isclose()` " +
            "safely compares floats, which often have tiny rounding errors.",
        code = "import math\nprint(math.gcd(12, 18))\nprint(0.1 + 0.2 == 0.3)\nprint(math.isclose(0.1 + 0.2, 0.3))",
        output = "6\nFalse\nTrue",
    ),
    explain(
        "What a module is",
        "A module is simply a `.py` file with code. Your file `helper.py` is a module too – " +
            "from a file next to it you can import a function from it with `from helper import greet`.",
        code = "import math\nprint(type(math.pi))",
        output = "<class 'float'>",
    ),
    output(
        "import math\nprint(math.ceil(4.2))",
        "5",
        "ceil rounds up.",
    ),
    choice(
        "How do you call the function after from math import floor?",
        listOf("floor(2.5)", "math.floor(2.5)", "math(floor(2.5))", "import floor(2.5)"),
        0,
        "After from … import we write the function name without the prefix.",
    ),
    fill(
        "Fill in the blank to give the module the shorter name m.",
        "import math ____ m\nprint(m.floor(1.5))",
        listOf("as", "from", "is"),
        "as",
        "The word as gives the module a different name.",
    ),
)
