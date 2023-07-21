fun main() {
    val input = readInput("Day02")
    Day02.part1(input).println()
    Day02.part2(input).println()
}

class Day02 {
    companion object {
        fun part1(input: List<String>): Int {
            return input
                .map { it.split("x").map { size -> size.toInt() } }
                .sumOf { Package(it[0], it[1], it[2]).requiredArea() }
        }

        fun part2(input: List<String>): Int {
            return input
                .map { it.split("x").map { size -> size.toInt() } }
                .sumOf { Package(it[0], it[1], it[2]).ribbonLength() }
        }
    }
}

class Package(private val length: Int, private val width: Int, private val height: Int) {
    fun requiredArea(): Int {
        return surfaceArea() + smallestSideArea()
    }

    fun ribbonLength(): Int {
        return (smallestFace() * 2) + volume()
    }

    private fun surfaceArea(): Int {
        return 2 * length * width + 2 * width * height + 2 * height * length
    }

    private fun volume(): Int {
        return length * width * height
    }

    private fun smallestSideArea(): Int {
        return listOf(length * width, width * height, height * length).minOrNull()!!
    }

    private fun smallestFace(): Int {
        return listOf(length + width, width + height, height + length).minOrNull()!!
    }

}
