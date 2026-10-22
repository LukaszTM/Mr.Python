package com.mrpython.app.data

import com.mrpython.app.data.course.module1
import com.mrpython.app.data.course.module2
import com.mrpython.app.data.course.module3
import com.mrpython.app.data.course.module4
import com.mrpython.app.data.course.module5
import com.mrpython.app.data.course.module6
import com.mrpython.app.domain.CourseUnit
import com.mrpython.app.domain.Lesson

object CourseContent {

    val units: List<CourseUnit> = listOf(module1, module2, module3, module4, module5, module6)

    val allLessons: List<Lesson> get() = units.flatMap { it.lessons }

    fun findLesson(id: String): Lesson? = allLessons.firstOrNull { it.id == id }
}
