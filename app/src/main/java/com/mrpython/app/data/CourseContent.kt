package com.mrpython.app.data

import com.mrpython.app.domain.CourseUnit
import com.mrpython.app.domain.I18n
import com.mrpython.app.domain.Language
import com.mrpython.app.domain.Lesson

/**
 * The course in the current language. Every language has the same modules, lessons and
 * exercise ids, so progress carries over when the language changes. A language is only
 * loaded into memory when it is first used.
 */
object CourseContent {
    val units: List<CourseUnit>
        get() = when (I18n.language) {
            Language.PL -> CoursePl.units
            Language.EN -> CourseEn.units
        }

    val allLessons: List<Lesson> get() = units.flatMap { it.lessons }

    fun findLesson(id: String): Lesson? = allLessons.firstOrNull { it.id == id }
}
