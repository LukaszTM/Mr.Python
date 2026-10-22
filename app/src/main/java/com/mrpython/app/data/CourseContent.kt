package com.mrpython.app.data

import com.mrpython.app.data.course.module1
import com.mrpython.app.data.course.module2
import com.mrpython.app.data.course.module3
import com.mrpython.app.data.course.module4
import com.mrpython.app.data.course.module5
import com.mrpython.app.data.course.module6
import com.mrpython.app.data.course.module7
import com.mrpython.app.data.course.module8
import com.mrpython.app.data.course.module9
import com.mrpython.app.data.course.module10
import com.mrpython.app.data.course.module11
import com.mrpython.app.domain.CourseUnit
import com.mrpython.app.domain.Lesson

object CourseContent {

    val units: List<CourseUnit> = listOf(
        module1, module2, module3, module4, module5, module6,
        module7, module8, module9, module10, module11,
    )

    val allLessons: List<Lesson> get() = units.flatMap { it.lessons }

    fun findLesson(id: String): Lesson? = allLessons.firstOrNull { it.id == id }
}
