# Mr.Python 🐍

Aplikacja na Androida do nauki Pythona, inspirowana Duolingo.

## Funkcje

- **Ścieżka nauki na cały rok** – 73 moduły, 442 lekcje, 8653 zadania i 869 kart z teorią: od `print()` przez
  struktury danych, programowanie obiektowe, bibliotekę standardową, algorytmy i projekty
  po egzamin końcowy. Pełny program: [docs/PROGRAM.md](docs/PROGRAM.md).
  Każdy moduł kończy się lekcją-powtórką.
  Lekcje odblokowują się po kolei, a ścieżka wije się jak w Duolingo.
- **4 typy zadań**
  - wybór jednej odpowiedzi,
  - uzupełnianie luki w kodzie,
  - układanie kodu z kafelków (bank słów),
  - „Co wypisze ten program?” – wpisujesz wynik z konsoli.
- **Serca ❤️** – 5 serc, każdy błąd kosztuje jedno; serce odnawia się co 20 minut.
  Powtórka ukończonej lekcji nie kosztuje serc i oddaje jedno.
- **Błędy wracają** – źle rozwiązane zadanie pojawia się ponownie na końcu lekcji.
- **Wprowadzenie na początku każdego modułu** – jak w Duolingo: 4–5 kart z teorią, przykładem
  kodu i jego wynikiem, a potem 2–3 łatwe pytania. Do wprowadzenia można wracać w każdej chwili.
- **Teoria przed każdą nowością** – lekcja, która wprowadza coś nowego, zaczyna się od 1–3 kart
  wyjaśniających to z przykładem, więc nie trzeba niczego zgadywać.
- **Powtórki za każdym razem inne** – pierwsze podejście to 7–8 zadań uczących tematu,
  a każda powtórka losuje 10 zadań z puli ok. 23 zadań danej lekcji.
- **Liga tygodniowa ze ścieżką kariery** – co tydzień rywalizujesz z 19 wirtualnymi
  rywalami; trzy pierwsze miejsca awansują: Stażysta → Junior → Mid → Senior →
  Tech Lead → Architekt → CTO.
- **XP ⚡, seria dni 🔥 i cel dzienny 🎯** (30 XP).
- **Kolorowanie składni** Pythona w przykładach kodu.
- Profil ze statystykami i postępem w każdej części.
- **Ciemny motyw w stylu edytora kodu** w kolorach Pythona – ścieżka lekcji jako oś czasu,
  przykłady w oknie edytora z numerami linii, odpowiedzi wpisywane jak w konsoli.

Postęp jest zapisywany lokalnie na urządzeniu (SharedPreferences).

## Technologie

Kotlin, Jetpack Compose (Material 3), jedna aktywność, `AndroidViewModel` + `StateFlow`.
minSdk 26 (Android 8.0), targetSdk 35.

```
app/src/main/java/com/mrpython/app/
├── domain/   # czysta logika: modele, sprawdzanie odpowiedzi, serca/XP/seria, lekcja, kolorowanie
├── data/     # treść kursu (course/Module*.kt) i zapis postępu
└── ui/       # ViewModel, motyw, komponenty i ekrany Compose
```

## Budowanie

```bash
./gradlew testDebugUnitTest   # testy jednostkowe
./gradlew assembleDebug       # APK: app/build/outputs/apk/debug/app-debug.apk
```

Albo otwórz projekt w Android Studio i uruchom na emulatorze lub telefonie.

Każdy push uruchamia GitHub Actions (`.github/workflows/android.yml`), który
puszcza testy, buduje APK i udostępnia go jako artefakt `mr-python-debug-apk`.

## Dodawanie lekcji

Treść jest w `app/src/main/java/com/mrpython/app/data/course/` – jeden plik na moduł.
Nowe lekcje dodawaj na końcu modułu i nie zmieniaj identyfikatorów istniejących,
bo na nich opiera się zapisany postęp.
Każde zadanie tworzy się jedną funkcją pomocniczą: `choice(...)`, `fill(...)`,
`tiles(...)` lub `output(...)`. Test `CourseContentTest` sprawdza, czy
identyfikatory są unikalne, a odpowiedzi poprawne.
