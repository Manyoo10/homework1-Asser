package jetbrains.kotlin.course.alias.team

import jetbrains.kotlin.course.alias.util.Identifier

// Data class for Team
data class Team(val id: Identifier, var points: Int = 0) {
    val name: String = "Team#${id + 1}"
}
