fun main() {
    val input = readInput("Day04")
    Day04.part1(input[0]).println()
    Day04.part2(input[0]).println()
}

class Day04 {
    companion object {
        fun part1(input: String): Int {
            return findPostfix(input, 5)
        }

        fun part2(input: String): Int {
            return findPostfix(input, 6)
        }

        private fun findPostfix(input: String, zeroes: Int): Int {
            var postfix = 1
            while (true) {
                val hex = (input + postfix.toString()).md5()
                if (hex.startsWith("0".repeat(zeroes))) {
                    return postfix
                } else {
                    postfix++;
                }
            }
        }
    }
}
