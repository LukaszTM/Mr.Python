# Publikacja w Google Play – lista kroków

## Co jest już gotowe w repozytorium

- wersja produkcyjna (release) ze zmniejszonym i zoptymalizowanym kodem (R8),
- budowanie pakietu `.aab` dla Google Play w GitHub Actions (artefakt `mr-python-release-bundle`),
- podpisywanie kluczem przechowywanym w sekretach GitHuba (klucz nigdy nie trafia do repozytorium),
- własna ikona aplikacji z maskotką,
- teksty karty sklepu, odpowiedzi do formularzy, ikona 512×512 i grafika główna: `listing.md`,
- polityka prywatności: `../polityka-prywatnosci.md`,
- odblokowanie wszystkich przedmiotów awatara działa tylko w wersji testowej, nie w produkcyjnej.

## Krok 1. Konto dewelopera

1. Załóż konto na https://play.google.com/console (jednorazowa opłata 25 USD).
2. Przejdź weryfikację tożsamości (dokument, adres, numer telefonu).

Uwaga: nowe konta osobiste muszą przed publikacją produkcyjną przeprowadzić **test zamknięty
z co najmniej 12 testerami przez 14 dni**. Dopiero potem Konsola pozwala wystąpić o dostęp
do produkcji.

## Krok 2. Klucz do podpisywania (jednorazowo)

Na swoim komputerze (wymaga Javy lub Android Studio):

```
keytool -genkeypair -v -keystore upload.jks -alias upload -keyalg RSA -keysize 2048 -validity 10000
```

Zapisz hasła w bezpiecznym miejscu i zrób kopię pliku `upload.jks`. Nie dodawaj go do
repozytorium.

Następnie w GitHubie: Settings → Secrets and variables → Actions → New repository secret:

| Sekret | Wartość |
|---|---|
| `MRPYTHON_KEYSTORE_BASE64` | wynik `base64 -w0 upload.jks` (macOS: `base64 -i upload.jks`) |
| `MRPYTHON_KEYSTORE_PASSWORD` | hasło do pliku |
| `MRPYTHON_KEY_ALIAS` | `upload` |
| `MRPYTHON_KEY_PASSWORD` | hasło do klucza |

Od tej chwili każda kompilacja na gałęzi `main` tworzy podpisany plik `app-release.aab`.
Przy pierwszym wgraniu Konsola Play zaproponuje „Podpisywanie aplikacji przez Google Play” –
zaakceptuj.

## Krok 3. Decyzje nieodwracalne po publikacji

- **Identyfikator aplikacji** `com.mrpython.app` – po publikacji nie da się go zmienić.
  Jeśli chcesz inny (np. z własną domeną lub nazwiskiem), trzeba to zrobić teraz.
- **Nazwa „Mr. Python”** – „Python” jest znakiem towarowym Python Software Foundation.
  Użycie w nazwie aplikacji edukacyjnej jest powszechne, ale Google może poprosić o zmianę;
  w opisie jest już dopisek o braku powiązania z PSF.

## Krok 4. Polityka prywatności pod adresem URL

Google wymaga publicznego adresu. Najprościej: GitHub → Settings → Pages → Source: gałąź
`main`, folder `/docs`. Polityka będzie pod adresem
`https://lukasztm.github.io/Mr.Python/polityka-prywatnosci` (wymaga publicznego repozytorium
lub płatnego planu). Wcześniej uzupełnij w niej adres e-mail do kontaktu.

## Krok 5. Karta aplikacji i formularze

Utwórz aplikację w Konsoli (język domyślny: polski, bezpłatna) i wypełnij wszystko według
`listing.md`. Zrzuty ekranu zrób na telefonie.

## Krok 6. Testy i publikacja

1. Testy → Test wewnętrzny → utwórz wydanie → wgraj `app-release.aab` → sprawdź na telefonie.
2. Test zamknięty: 12 testerów, 14 dni (wymóg dla nowych kont osobistych).
3. Wystąp o dostęp do produkcji, utwórz wydanie produkcyjne, wyślij do weryfikacji
   (zwykle od kilku godzin do kilku dni).

## Kolejne wersje

Przed każdym nowym wydaniem zwiększ `versionCode` (o 1) i `versionName` w
`app/build.gradle.kts`. Google Play odrzuci plik z numerem, który już był wgrany.
