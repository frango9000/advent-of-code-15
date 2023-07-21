fun main() {
    val input = readInput("Day00")
    Day00.part1(input).println()
    Day00.part2(input).println()
}

class Day00 {
    companion object {
        fun part1(input: List<String>): Int {
            return input.size
        }

        fun part2(input: List<String>): Int {
            return input.size * 2
        }
    }
}
