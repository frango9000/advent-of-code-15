fun main() {
    val input = readInput("Day05")
    Day05.part1(input).println()
    Day05.part2(input).println()
}

class Day05 {
    companion object {
        fun part1(input: List<String>): Int {
            val vowelPattern = Regex("(.*[aeiou].*){3,}")
            val repeatPattern = Regex("(.)\\1")
            val exclusionsPattern = Regex("(?!.*(?:ab|cd|pq|xy)).*")

            return input.map {
                it.matches(vowelPattern) &&
                    repeatPattern.containsMatchIn(it) &&
                    it.matches(exclusionsPattern)
            }.filter { it }.size
        }

        fun part2(input: List<String>): Int {
            val pairsPattern = "([a-z][a-z]).*\\1".toRegex()
            val repeatPattern = "([a-z])[a-z]\\1".toRegex()
            return input.map {
                it.contains(pairsPattern) && it.contains(repeatPattern)
            }.filter { it }.size
        }

    }
}
