fun main() {
    val input = readInput("Day14")
    Day14.part1(input, 2503).println()
    Day14.part2(input, 2503).println()
}

class Day14 {
    companion object {
        fun part1(input: List<String>, time: Int): Int {
            return input.map { it.getNumbers() }.map { Reindeer(it[0], it[1], it[2]) }
                .maxOf { it.getDistanceAfter(time) }
        }

        fun part2(input: List<String>, time: Int): Int {
            val reindeer = input.map { it.getNumbers() }.map { Reindeer(it[0], it[1], it[2]) }
            for (second in (1..time)) {
                val lead = reindeer.maxOf { it.getDistanceAfter(second) }
                reindeer.filter { it.distance == lead }.forEach { it.points++ }
            }
            return reindeer.maxOf { it.points }
        }
    }
}

private class Reindeer(private val speed: Int, private val endurance: Int, private val recovery: Int) {
    var points: Int = 0
    var distance: Int = 0

    fun getDistanceAfter(seconds: Int): Int {
        val runtime = endurance + recovery
        val fullRuns = seconds / runtime
        val fullRunsDistance = speed * endurance * fullRuns
        val leftoverTime = seconds % runtime
        val leftoverDistance = speed * leftoverTime.coerceAtMost(endurance).coerceAtLeast(0)
        distance = fullRunsDistance + leftoverDistance
        return distance
    }
}
