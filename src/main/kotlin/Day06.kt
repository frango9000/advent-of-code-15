fun main() {
    val input = readInput("Day06")
    Day06.part1(input).println()
    Day06.part2(input).println()
}

class Day06 {
    companion object {
        fun part1(input: List<String>): Int {
            val array: Array<BooleanArray> = Array(1000) { BooleanArray(1000) }

            val actions = input.mapToLightActions()

            for (action in actions) {
                for (x in action.cornerA.first..action.cornerB.first) {
                    for (y in action.cornerA.second..action.cornerB.second) {
                        when (action.type) {
                            ActionType.on -> array[x][y] = true
                            ActionType.off -> array[x][y] = false
                            else -> array[x][y] = !array[x][y]
                        }
                    }
                }
            }
            return array.map { it.filter { it }.size }.reduce { acc, curr -> acc + curr }
        }

        fun part2(input: List<String>): Int {
            val array: Array<IntArray> = Array(1000) { IntArray(1000) }

            val actions = input.mapToLightActions()

            for (action in actions) {
                for (x in action.cornerA.first..action.cornerB.first) {
                    for (y in action.cornerA.second..action.cornerB.second) {
                        when (action.type) {
                            ActionType.on -> array[x][y]++
                            ActionType.off -> array[x][y]--
                            else -> array[x][y] += 2
                        }
                        if (array[x][y] < 0) array[x][y] = 0
                    }
                }
            }
            return array.map { it.reduce { acc, curr -> acc + curr } }.reduce { acc, curr -> acc + curr }
        }
    }
}

class LightAction(val type: ActionType, val cornerA: Pair<Int, Int>, val cornerB: Pair<Int, Int>) {

}

enum class ActionType { on, off, toggle }


fun List<String>.mapToLightActions(): List<LightAction> {
    return this.map { it.replace("turn ", "").split(" ") }
        .map {
            val cornerA = it[1].split(",")
            val cornerB = it[3].split(",")
            LightAction(
                ActionType.valueOf(it[0]),
                Pair(cornerA[0].toInt(), cornerA[1].toInt()),
                Pair(cornerB[0].toInt(), cornerB[1].toInt())
            )
        }
}
