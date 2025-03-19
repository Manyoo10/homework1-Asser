package jetbrains.kotlin.course.alias.util

typealias Identifier = Int

// Class for generating unique identifiers
class IdentifierFactory {
    private var counter: Identifier = 0

    fun uniqueIdentifier(): Identifier {
        return ++counter
    }
}
