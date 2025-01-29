package com.w1nkkkk.presentation

fun Int.pluralize(pluralize : Pluralize): String {
    val mod10 = this % 10
    val mod100 = this % 100
    return when {
        mod10 == 1 && mod100 != 11 -> pluralize.one
        mod10 in 2..4 && (mod100 < 10 || mod100 > 20) -> pluralize.few
        else -> pluralize.many
    }
}

sealed class Pluralize() {
    abstract val one : String
    abstract val few : String
    abstract val many : String

    data object HumanPluralize : Pluralize() {
        override val one: String
            get() = "человек"

        override val few: String
            get() = "человека"

        override val many: String
            get() = one
    }

    data object VacancyPluralize : Pluralize() {
        override val one: String
            get() = "вакансия"

        override val few: String
            get() = "вакансии"

        override val many: String
            get() = "вакансий"
    }
}

