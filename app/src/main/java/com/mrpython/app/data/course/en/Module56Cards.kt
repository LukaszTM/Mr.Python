package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.*

internal val module56Cards = listOf(
    cards(
        "u56l5",
        explain(
            "JSON straight to a file",
            "`json.dump(data, file)` writes data straight to an open file, and `json.load(file)` reads it " +
                "back. The versions with the letter `s` (`dumps`, `loads`) work on strings, and the ones without `s` work on files.",
            code = "import json\nwith open(\"tasks.json\", \"w\") as f:\n    json.dump([{\"title\": \"A\"}], f)\nwith open(\"tasks.json\") as f:\n    print(json.load(f))",
            output = "[{'title': 'A'}]",
        ),
    ),
)
