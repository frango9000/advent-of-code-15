fun main() {
    val input = readInput("Day08")
    Day08.part1(input).println()
    Day08.part2(input).println()
}

class Day08 {
    companion object {
        fun part1(input: List<String>): Int {
            val codeCount = input.map { it.length }.reduce { acc, i -> acc + i }

            val pattern = Regex("\\\\x[0-9a-fA-F]{2}")
            val memory = input.map {

                pattern.replace(
                    it.substring(1, it.length - 1).replace("\\\"", "\"").replace("\\\\", "\\")
                ) { matchResult ->
                    val hexValue = matchResult.value.substring(2)
                    val intValue = hexValue.toInt(16)
                    intValue.toChar().toString()
                }
            }
            val memoryCount = memory.map { it.length }.reduce { acc, i -> acc + i }

            return codeCount - memoryCount
        }

        fun part2(input: List<String>): Int {
            val codeCount = input.map { it.length }.reduce { acc, i -> acc + i }

            val encoded = input.map {
                "\"" + it.replace("\\", "\\\\").replace("\"", "\\\"") + "\""
            }
            val encodedCount = encoded.map { it.length }.reduce { acc, i -> acc + i }

            return encodedCount - codeCount
        }
    }
}
