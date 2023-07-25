fun main() {
    val input = readInput("Day09")
    Day09.part1(input).println()
    Day09.part2(input).println()
}

class Day09 {
    companion object {
        fun part1(input: List<String>): Int {
            val nodes: MutableMap<String, Node> = buildWeightedGraph(input)
            return nodes.findShortestDistance()
        }

        fun part2(input: List<String>): Int {
            val nodes: MutableMap<String, Node> = buildWeightedGraph(input)
            return nodes.findLongestDistance()
        }

        private fun buildWeightedGraph(input: List<String>): MutableMap<String, Node> {
            val nodes: MutableMap<String, Node> = mutableMapOf()
            input.map { it.split(" to ", " = ") }.forEach {
                val nodeA = nodes.getOrPut(it[0]) { Node(it[0]) }
                val nodeB = nodes.getOrPut(it[1]) { Node(it[1]) }
                nodeA.addPath(nodeB, it[2].toInt())
                nodeB.addPath(nodeA, it[2].toInt())
            }
            return nodes
        }
    }
}

private fun MutableMap<String, Node>.findShortestDistance(): Int {
    var shortestDistance = Int.MAX_VALUE
    this.forEach {
        shortestDistance = shortestDistance.coerceAtMost(it.value.findShortestDistance(mutableListOf(), 0))
    }
    return shortestDistance
}

private fun Node.findShortestDistance(visited: MutableList<String>, progress: Int): Int {
    if (visited.size == this.paths.size) {
        return progress
    }

    val newVisited = visited.toMutableList()
    newVisited.add(this.name)
    var shortestDistance = Int.MAX_VALUE
    this.paths.filter { !newVisited.contains(it.key.name) }.forEach { (node, distance) ->
        shortestDistance = shortestDistance.coerceAtMost(node.findShortestDistance(newVisited, progress + distance))
    }
    return shortestDistance
}

private fun MutableMap<String, Node>.findLongestDistance(): Int {
    var shortestDistance = 0
    this.forEach {
        shortestDistance = shortestDistance.coerceAtLeast(it.value.findLongestDistance(mutableListOf(), 0))
    }
    return shortestDistance
}

private fun Node.findLongestDistance(visited: MutableList<String>, progress: Int): Int {
    if (visited.size == this.paths.size) {
        return progress
    }

    val newVisited = visited.toMutableList()
    newVisited.add(this.name)
    var shortestDistance = 0
    this.paths.filter { !newVisited.contains(it.key.name) }.forEach { (node, distance) ->
        shortestDistance = shortestDistance.coerceAtLeast(node.findLongestDistance(newVisited, progress + distance))
    }
    return shortestDistance
}


class Node(var name: String) {
    val paths: MutableMap<Node, Int> = mutableMapOf()

    fun addPath(node: Node, distance: Int) {
        paths.putIfAbsent(node, distance)
    }

    override fun toString(): String {
        return "Node(name='$name')"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as Node
        return name == other.name
    }

    override fun hashCode(): Int {
        return name.hashCode()
    }
}
