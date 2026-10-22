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
import com.mrpython.app.data.course.module12
import com.mrpython.app.data.course.module13
import com.mrpython.app.data.course.module14
import com.mrpython.app.data.course.module15
import com.mrpython.app.data.course.module16
import com.mrpython.app.data.course.module17
import com.mrpython.app.data.course.module18
import com.mrpython.app.data.course.module19
import com.mrpython.app.data.course.module20
import com.mrpython.app.data.course.module21
import com.mrpython.app.data.course.module22
import com.mrpython.app.data.course.module23
import com.mrpython.app.data.course.module24
import com.mrpython.app.data.course.module25
import com.mrpython.app.data.course.module26
import com.mrpython.app.data.course.module27
import com.mrpython.app.data.course.module28
import com.mrpython.app.data.course.module29
import com.mrpython.app.data.course.module30
import com.mrpython.app.data.course.module31
import com.mrpython.app.data.course.module32
import com.mrpython.app.data.course.module33
import com.mrpython.app.data.course.module34
import com.mrpython.app.data.course.module35
import com.mrpython.app.data.course.module36
import com.mrpython.app.data.course.module37
import com.mrpython.app.data.course.module38
import com.mrpython.app.data.course.module39
import com.mrpython.app.data.course.module40
import com.mrpython.app.data.course.module41
import com.mrpython.app.data.course.module42
import com.mrpython.app.data.course.module43
import com.mrpython.app.data.course.module44
import com.mrpython.app.data.course.module45
import com.mrpython.app.data.course.module46
import com.mrpython.app.data.course.module47
import com.mrpython.app.data.course.module48
import com.mrpython.app.data.course.module49
import com.mrpython.app.data.course.module50
import com.mrpython.app.data.course.module51
import com.mrpython.app.data.course.module52
import com.mrpython.app.data.course.module53
import com.mrpython.app.data.course.module54
import com.mrpython.app.data.course.module55
import com.mrpython.app.data.course.module56
import com.mrpython.app.data.course.module57
import com.mrpython.app.data.course.module58
import com.mrpython.app.data.course.module59
import com.mrpython.app.data.course.module60
import com.mrpython.app.data.course.module61
import com.mrpython.app.data.course.module62
import com.mrpython.app.data.course.module63
import com.mrpython.app.data.course.module64
import com.mrpython.app.data.course.module65
import com.mrpython.app.data.course.module66
import com.mrpython.app.data.course.module67
import com.mrpython.app.data.course.module68
import com.mrpython.app.data.course.module69
import com.mrpython.app.data.course.module70
import com.mrpython.app.data.course.module71
import com.mrpython.app.data.course.module72
import com.mrpython.app.data.course.module73
import com.mrpython.app.domain.CourseUnit
import com.mrpython.app.domain.Lesson

object CourseContent {

    /** The whole course: 73 modules, 365 lessons – one lesson a day for a year. */
    val units: List<CourseUnit> = listOf(
        module1, module2, module3, module4, module5, module6,
        module7, module8, module9, module10, module11, module12,
        module13, module14, module15, module16, module17, module18,
        module19, module20, module21, module22, module23, module24,
        module25, module26, module27, module28, module29, module30,
        module31, module32, module33, module34, module35, module36,
        module37, module38, module39, module40, module41, module42,
        module43, module44, module45, module46, module47, module48,
        module49, module50, module51, module52, module53, module54,
        module55, module56, module57, module58, module59, module60,
        module61, module62, module63, module64, module65, module66,
        module67, module68, module69, module70, module71, module72,
        module73,
    )

    val allLessons: List<Lesson> get() = units.flatMap { it.lessons }

    fun findLesson(id: String): Lesson? = allLessons.firstOrNull { it.id == id }
}
