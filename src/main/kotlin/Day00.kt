fun main() {
    val input = readInput("Day00")
    println(Day01.part1(input))
    println(Day01.part2(input))
}

class Day01 {
    companion object {
        fun part1(input: List<String>): Int {
            return input.size
        }

        fun part2(input: List<String>): Int {
            return input.size * 2
        }
    }
}
