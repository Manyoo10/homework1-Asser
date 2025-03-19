package jetbrains.kotlin.course.alias.card

import jetbrains.kotlin.course.alias.util.IdentifierFactory
import org.springframework.stereotype.Service

@Service
class CardService {
    private val identifierFactory = IdentifierFactory()
    private val cards: List<Card> = generateCards()

    companion object {
        const val WORDS_IN_CARD = 4
        val words = listOf("apple", "banana", "car", "dog", "elephant", "fish", "grape", "house", "monkey", "dog", "mouse", "hamster", "avocado", "dolphin", "butterfly", "book")
        val cardsAmount = words.size / WORDS_IN_CARD //+ if (words.size % WORDS_IN_CARD > 0) 1 else 0
    }

    private fun List<String>.toWords(): List<Word> {
        return this.map { Word(it) }
    }

    private fun generateCards(): List<Card> {
        return words.shuffled()
            .chunked(WORDS_IN_CARD)
            .take(cardsAmount)
            .map { chunk -> Card(identifierFactory.uniqueIdentifier(), chunk.toWords()) }
    }

    fun getCardByIndex(index: Int): Card {
        return cards.getOrNull(index) ?: throw IllegalArgumentException("Card not found at index: $index")
    }
}
