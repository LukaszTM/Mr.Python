package com.mrpython.app.domain

/** Languages the app and the course are available in. Polish is the source language. */
enum class Language(val code: String, val label: String) {
    PL("pl", "Polski"),
    EN("en", "English"),
}

/**
 * Texts are written in Polish in the code and looked up in a table for other languages:
 * `"Dalej".t()`. A text missing from the table is shown in Polish, so nothing ever breaks.
 * Values that vary go in as `{0}`, `{1}`: `"Seria {0}".t(days)`.
 */
object I18n {
    @Volatile
    var language: Language = Language.PL

    private val tables: Map<Language, Map<String, String>> = mapOf(Language.EN to translationsEn)

    fun translate(text: String): String = tables[language]?.get(text) ?: text

    /** The language for a device locale such as "pl-PL" or "en_US": Polish for Poles, English for everyone else. */
    fun forLocale(tag: String): Language = if (tag.lowercase().startsWith("pl")) Language.PL else Language.EN

    /** Polish texts that have a translation; used by tests. */
    fun keys(language: Language): Set<String> = tables[language]?.keys.orEmpty()
}

/** This Polish text in the current language, with `{0}`, `{1}`… replaced by [args]. */
fun String.t(vararg args: Any?): String {
    var text = I18n.translate(this)
    args.forEachIndexed { i, arg -> text = text.replace("{$i}", arg.toString()) }
    return text
}
