fun main() {
    val input = readInput("Day03")
    Day03.part1(input[0]).println()
    Day03.part2(input[0]).println()
}

class Day03 {
    companion object {
        fun part1(input: String): Int {
            val locations = getDeliveryLocations(input)
            return locations.size
        }

        fun part2(input: String): Int {
            val santaA = input.filterIndexed { index, _ -> index % 2 == 0 }
            val santaB = input.filterIndexed { index, _ -> index % 2 != 0 }
            val santaALocations = getDeliveryLocations(santaA)
            val santaBLocations = getDeliveryLocations(santaB)
            val locations = santaALocations + santaBLocations
            return locations.size
        }

        private fun getDeliveryLocations(moves: String): MutableSet<Pair<Int, Int>> {
            var x = 0
            var y = 0
            val set = mutableSetOf(Pair(x, y))
            moves.split("").forEach { move ->
                run {
                    when (move) {
                        "^" -> y++
                        ">" -> x++
                        "v" -> y--
                        "<" -> x--
                        else -> {}
                    }
                    set.add(Pair(x, y))
                }
            }
            return set
        }
    }
}
