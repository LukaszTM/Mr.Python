# Mr.Python 🐍

Aplikacja na Androida do nauki Pythona, inspirowana Duolingo.

## Funkcje

- **Ścieżka nauki** – 6 części, 14 lekcji, 72 zadania (od `print()` po funkcje).
  Lekcje odblokowują się po kolei, a ścieżka wije się jak w Duolingo.
- **4 typy zadań**
  - wybór jednej odpowiedzi,
  - uzupełnianie luki w kodzie,
  - układanie kodu z kafelków (bank słów),
  - „Co wypisze ten program?” – wpisujesz wynik z konsoli.
- **Serca ❤️** – 5 serc, każdy błąd kosztuje jedno; serce odnawia się co 20 minut.
  Powtórka ukończonej lekcji nie kosztuje serc i oddaje jedno.
- **Błędy wracają** – źle rozwiązane zadanie pojawia się ponownie na końcu lekcji.
- **XP ⚡, seria dni 🔥 i cel dzienny 🎯** (30 XP).
- **Kolorowanie składni** Pythona w przykładach kodu.
- Profil ze statystykami i postępem w każdej części.

Postęp jest zapisywany lokalnie na urządzeniu (SharedPreferences).

## Technologie

Kotlin, Jetpack Compose (Material 3), jedna aktywność, `AndroidViewModel` + `StateFlow`.
minSdk 26 (Android 8.0), targetSdk 35.

```
app/src/main/java/com/mrpython/app/
├── domain/   # czysta logika: modele, sprawdzanie odpowiedzi, serca/XP/seria, lekcja, kolorowanie
├── data/     # treść kursu (CourseContent.kt) i zapis postępu
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

Cała treść jest w `app/src/main/java/com/mrpython/app/data/CourseContent.kt`.
Każde zadanie tworzy się jedną funkcją pomocniczą: `choice(...)`, `fill(...)`,
`tiles(...)` lub `output(...)`. Test `CourseContentTest` sprawdza, czy
identyfikatory są unikalne, a odpowiedzi poprawne.
