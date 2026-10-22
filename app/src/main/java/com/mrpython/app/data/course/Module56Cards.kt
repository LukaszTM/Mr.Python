package com.mrpython.app.data.course

internal val module56Cards = listOf(
    cards(
        "u56l5",
        explain(
            "JSON prosto do pliku",
            "`json.dump(dane, plik)` zapisuje dane prosto do otwartego pliku, a `json.load(plik)` je z niego " +
                "wczytuje. Wersje z literą `s` (`dumps`, `loads`) działają na napisach, a bez `s` – na plikach.",
            code = "import json\nwith open(\"zadania.json\", \"w\") as f:\n    json.dump([{\"tytul\": \"A\"}], f)\nwith open(\"zadania.json\") as f:\n    print(json.load(f))",
            output = "[{'tytul': 'A'}]",
        ),
    ),
)
