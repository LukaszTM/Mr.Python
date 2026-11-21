package com.mrpython.app.domain

/** Which part of the course is free and which needs the one-time "full course" purchase. */
object Paywall {
    /** The first modules are free, so the app can be tried before paying. */
    const val FREE_UNITS = 5

    /** True when [lessonId] belongs to a module that needs the full course. */
    fun isPaid(course: List<CourseUnit>, lessonId: String): Boolean {
        val unit = course.indexOfFirst { unit -> unit.lessons.any { it.id == lessonId } }
        return unit >= FREE_UNITS
    }

    /** Lessons that the purchase adds on top of the free modules. */
    fun paidLessons(course: List<CourseUnit>): Int = course.drop(FREE_UNITS).sumOf { it.lessons.size }
}
