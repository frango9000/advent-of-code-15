fun main() {
    val input = readInput("Day16")
    Day16.part1(input).println()
    Day16.part2(input).println()
}

class Day16 {

    companion object {
        val targetProps = mapOf(
            "children" to 3,
            "cats" to 7,
            "samoyeds" to 2,
            "pomeranians" to 3,
            "akitas" to 0,
            "vizslas" to 0,
            "goldfish" to 5,
            "trees" to 3,
            "cars" to 2,
            "perfumes" to 1,
        )

        fun part1(input: List<String>): Int {
            val aunts = input.mapToAuntSue()

            val possibleAunts = aunts.filter { auntSue ->
                auntSue.props.all { targetProps[it.key] == it.value }
            }

            return possibleAunts.first().id
        }

        fun part2(input: List<String>): Int {
            val aunts = input.mapToAuntSue()

            val possibleAunts = aunts.filter { auntSue ->
                auntSue.props.all {
                    when (it.key) {
                        "cats" -> it.value > targetProps[it.key]!!
                        "trees" -> it.value > targetProps[it.key]!!
                        "pomeranians" -> it.value < targetProps[it.key]!!
                        "goldfish" -> it.value < targetProps[it.key]!!
                        else -> it.value == targetProps[it.key]
                    }
                }
            }

            return possibleAunts.first().id
        }
    }
}

private fun List<String>.mapToAuntSue(): List<AuntSue> {
    return this.map {
        val sue = it.split(": ")
        val sueId = sue[0].replace("Sue ", "").toInt()
        AuntSue(sueId, sue.subList(1, sue.size).joinToString(": "))
    }
}

private class AuntSue(val id: Int, rawProps: String) {
    val props = mutableMapOf<String, Int>()

    init {
        rawProps.split(", ").forEach {
            val prop = it.split(": ")
            props[prop[0]] = prop[1].toInt()
        }
    }
}
