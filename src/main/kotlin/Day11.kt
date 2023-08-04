import kotlin.math.pow

fun main() {
    val input = readInput("Day11")
    Day11.part1(input.first()).println()
    Day11.part2(input.first()).println()
}

class Day11 {
    companion object {
        fun part1(input: String): String {
            var current = input.abcToNum()
            while (true) {
                current++
                val abc = current.toAbc().padStart(8, 'a')
                if (abc.santaSecurityValid()) {
                    return abc
                }
            }
        }

        fun part2(input: String): String {
            return part1(part1(input))
        }
    }
}

fun String.abcToNum(): Long {
    var inc = 0L
    for ((index, digit) in this.reversed().withIndex()) {
        inc += (26 pow index) * digit.minus('a').toLong()
    }
    return inc
}

infix fun Int.pow(exponent: Int): Long = toDouble().pow(exponent).toLong()


fun Long.toAbc(): String {
    val sb = StringBuilder()
    var num = this + 1

    while (num > 0) {
        num -= 1
        val remainder = num % 26L
        sb.append(('a'.plus(remainder.toInt())).toString())
        num /= 26
        if (num > 0) num++
    }
    return sb.reverse().toString()
}

fun Int.toAbc(): String {
    return this.toLong().toAbc()
}

val straightPattern = Regex(
    "abc|bcd|cde|def|efg|fgh|pqr|qrs|rst|stu|tuv|uvw|vwx|wxy|xyz"
)

fun String.matchesStraightPattern(): Boolean = straightPattern.find(this) != null

val validCharactersPattern = Regex("^(?:(?![iol])[a-z])+\$")

fun String.matchesValidCharacters(): Boolean = this.matches(validCharactersPattern)

val paisPattern = Regex("(\\w)\\1.*?(\\w)\\2")

fun String.matchesPairPattern(): Boolean = paisPattern.find(this) != null


fun String.santaSecurityValid(): Boolean =
    this.matchesValidCharacters() && this.matchesPairPattern() && this.matchesStraightPattern()
