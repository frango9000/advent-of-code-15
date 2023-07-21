fun main() {
    val input = readInput("Day01")
    Day01.part1(input).println()
    Day01.part2(input).println()
}

class Day01 {
    companion object {
        fun part1(input: List<String>): Int {
            return input[0].split("")
                .map { if ("(" == it) 1 else if (")" == it) -1 else 0 }
                .reduce { acc, i -> acc + i }
        }

        fun part2(input: List<String>): Int {
            val steps = input[0].split("").map { if ("(" == it) 1 else if (")" == it) -1 else 0 }
            var floor = 0
            for (i in steps.indices) {
                floor += steps[i]
                if (floor == -1) {
                    return i
                }
            }
            return -1
        }
    }
}
