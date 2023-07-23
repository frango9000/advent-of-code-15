fun main() {
    val input = readInput("Day07")
    Day07.part1(input, "a").println()
    Day07.part2(input, "a", "b").println()
}

class Day07 {
    companion object {
        fun part1(input: List<String>, wire: String): UShort {
            val connections = input.mapToConnections()

            val orderedConnections = connections.topologicalSort()

            orderedConnections.forEach {
                if (it.left == null) it.left = orderedConnections.firstOrNull { con -> it.leftKey == con.key }?.value
                if (it.right == null) it.right = orderedConnections.firstOrNull { con -> it.rightKey == con.key }?.value
                it.value = when (it.gate) {
                    Gate.AND -> it.left!! and it.right!!
                    Gate.OR -> it.left!! or it.right!!
                    Gate.NOT -> it.right!!.inv()
                    Gate.LSHIFT -> (it.left!!.toInt() shl it.right!!.toInt()).toUShort()
                    Gate.RSHIFT -> (it.left!!.toInt() shr it.right!!.toInt()).toUShort()
                    null -> it.left
                }
            }
            return orderedConnections.firstOrNull { it.key == wire }?.value!!
        }

        fun part2(input: List<String>, wire: String, rewire: String): UShort {
            val connections = input.mapToConnections()
            connections.firstOrNull { it.key == rewire }?.left = part1(input, wire)

            val orderedConnections = connections.topologicalSort()

            orderedConnections.forEach {
                if (it.left == null) it.left = orderedConnections.firstOrNull { con -> it.leftKey == con.key }?.value
                if (it.right == null) it.right = orderedConnections.firstOrNull { con -> it.rightKey == con.key }?.value
                it.value = when (it.gate) {
                    Gate.AND -> it.left!! and it.right!!
                    Gate.OR -> it.left!! or it.right!!
                    Gate.NOT -> it.right!!.inv()
                    Gate.LSHIFT -> (it.left!!.toInt() shl it.right!!.toInt()).toUShort()
                    Gate.RSHIFT -> (it.left!!.toInt() shr it.right!!.toInt()).toUShort()
                    null -> it.left
                }
            }
            return orderedConnections.firstOrNull { it.key == wire }?.value!!
        }
    }
}

private fun List<String>.mapToConnections(): List<Connection> {
    return this.map {
        val parts = it.split(" -> ")
        Connection(parts[1], parts[0])
    }
}

private fun List<Connection>.topologicalSort(): List<Connection> {
    val connections = this.toMutableList()
    val orderedConnections = mutableListOf<Connection>()

    while (connections.isNotEmpty()) {
        connections.toList().forEach {
            if ((it.leftKey == null || orderedConnections.firstOrNull { con -> (con.key == it.leftKey) } != null) &&
                (it.rightKey == null || orderedConnections.firstOrNull { con -> (con.key == it.rightKey) } != null)
            ) {
                connections.remove(it)
                orderedConnections.add(it)
            }
        }
    }
    return orderedConnections
}


class Connection(val key: String, val logic: String) {
    var left: UShort? = null
    var leftKey: String? = null
    var right: UShort? = null
    var rightKey: String? = null
    var gate: Gate? = null
    var value: UShort? = null;

    init {
        val logicParts = logic.split(" ")

        when (logicParts.size) {
            1 -> {
                try {
                    left = logicParts[0].toUShort()
                } catch (ex: NumberFormatException) {
                    leftKey = logicParts[0]
                }
            }

            2 -> {
                gate = Gate.NOT
                rightKey = logicParts[1]
            }

            3 -> {
                try {
                    left = logicParts[0].toUShort()
                } catch (ex: NumberFormatException) {
                    leftKey = logicParts[0]
                }
                gate = Gate.valueOf(logicParts[1])
                try {
                    right = logicParts[2].toUShort()
                } catch (ex: NumberFormatException) {
                    rightKey = logicParts[2]
                }
            }
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Connection

        return key == other.key
    }

    override fun hashCode(): Int {
        return key.hashCode()
    }


}


enum class Gate { AND, OR, NOT, LSHIFT, RSHIFT }
