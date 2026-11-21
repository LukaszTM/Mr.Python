package com.mrpython.app.domain

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import java.io.File
import java.time.LocalDateTime

class I18nTest {

    private fun <T> inEnglish(block: () -> T): T {
        val before = I18n.language
        I18n.language = Language.EN
        try {
            return block()
        } finally {
            I18n.language = before
        }
    }

    @Test
    fun polishIsTheDefaultAndTheKey() {
        assertEquals(Language.PL, I18n.language)
        assertEquals("Dalej  →", "Dalej  →".t())
        assertEquals("Seria 5 dni", "Seria {0} dni".t(5))
    }

    @Test
    fun englishLooksTextsUpAndFillsInValues() {
        inEnglish {
            assertEquals("Continue  →", "Dalej  →".t())
            assertEquals("Language", "Język".t())
            assertEquals("5-day streak", "Seria {0} dni".t(5))
            assertEquals("🎁 Welcome bonus! XP ×2 for 30 minutes", "🎁 {0}! Przez 30 minut XP ×{1}".t("Welcome bonus", 2))
            // A text without a translation stays Polish.
            assertEquals("Nie ma takiego tekstu", "Nie ma takiego tekstu".t())
        }
        assertEquals("Dalej  →", "Dalej  →".t())
    }

    @Test
    fun countsAndTitlesFollowTheLanguage() {
        assertEquals("1 dzień", Moods.days(1))
        assertEquals("5 dni", Moods.days(5))
        inEnglish {
            assertEquals("1 day", Moods.days(1))
            assertEquals("5 days", Moods.days(5))
            assertEquals("Intern", Tier.INTERN.title)
            assertEquals("Architect", Tier.ARCHITECT.title)
            assertEquals("Welcome bonus", Events.title(Events.welcome(0)))
            assertEquals("10-day streak", Events.title(Events.forStreak(10, 0)!!))
        }
        assertEquals("Stażysta", Tier.INTERN.title)
    }

    @Test
    fun everyStoredPolishTitleHasATranslation() {
        val keys = I18n.keys(Language.EN)
        val titles = Tier.entries.map { it.title } +
            SnakeSkin.entries.map { it.title } +
            AccessorySlot.entries.map { it.title } +
            Accessory.entries.map { it.title }
        val now = LocalDateTime.of(2026, 11, 18, 15, 0)
        val reminders = (0L until 30L).flatMap { day ->
            val message = Reminders.message(Progress(), ReminderKind.DAILY, now.plusDays(day))!!
            listOf(message.title, message.text)
        }
        val missing = (titles + reminders).distinct().filter { it !in keys }
        assertTrue("Missing English texts: $missing", missing.isEmpty())
    }

    @Test
    fun noEnglishTextIsBlank() {
        val blank = I18n.keys(Language.EN).filter { key -> inEnglish { key.t() }.isBlank() }
        assertTrue("Blank English texts for: $blank", blank.isEmpty())
    }

    /** Every literal written as `"…".t(` in the app code must have an English text. */
    @Test
    fun everyTranslatedLiteralIsInTheTable() {
        // Unit tests run with the module directory (app/) as the working directory.
        val sources = File("src/main/java")
        if (!sources.isDirectory) return
        val literal = Regex("\"((?:[^\"\\\\\\n]|\\\\.)*)\"\\.t\\(")
        val keys = I18n.keys(Language.EN)
        val missing = sortedSetOf<String>()
        var found = 0
        sources.walkTopDown()
            .filter { it.isFile && it.extension == "kt" }
            .forEach { file ->
                file.readLines()
                    // Doc comments show the mechanism with made-up examples.
                    .filterNot { it.trimStart().run { startsWith("//") || startsWith("*") || startsWith("/*") } }
                    .forEach { line ->
                        literal.findAll(line).forEach { match ->
                            found++
                            val text = unescape(match.groupValues[1])
                            if (text !in keys) missing += "${file.name}: $text"
                        }
                    }
            }
        assertTrue("No translated literals found under ${sources.absolutePath}", found > 0)
        assertTrue("Missing English texts:\n" + missing.joinToString("\n"), missing.isEmpty())
    }

    private fun unescape(text: String): String {
        val out = StringBuilder()
        var i = 0
        while (i < text.length) {
            val c = text[i]
            if (c == '\\' && i + 1 < text.length) {
                when (val next = text[i + 1]) {
                    'n' -> out.append('\n')
                    '"' -> out.append('"')
                    '\\' -> out.append('\\')
                    else -> out.append('\\').append(next)
                }
                i += 2
            } else {
                out.append(c)
                i++
            }
        }
        return out.toString()
    }
}
