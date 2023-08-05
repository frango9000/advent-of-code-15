fun main() {
    val input = readInput("Day13")
    Day13.part1(input).println()
    Day13.part2(input).println()
}

class Day13 {
    companion object {
        fun part1(input: List<String>): Int {
            return input.getInvitedMap().values.first().getMaxHappiness(0, listOf())
        }

        fun part2(input: List<String>): Int {
            val invitedMap = input.getInvitedMap()
            val me = Invited("me")
            invitedMap.values.forEach { it.relations[me] = 0 }
            me.relations = invitedMap.values.associateWith { 0 }.toMutableMap()
            invitedMap["me"] = me
            return invitedMap.values.first().getMaxHappiness(0, listOf())
        }
    }
}

private fun Invited.getMaxHappiness(happiness: Int, sat: List<Invited>): Int {
    val newSat = sat.plus(this)
    var leftHappinessDelta = 0
    if (sat.isNotEmpty()) {
        val left = sat.last()
        leftHappinessDelta = this.relations[left]!!.plus(left.relations[this]!!)
    }
    return if (newSat.size == this.relations.size + 1) {
        val right = newSat[0]
        val rightHappinessDelta: Int = this.relations[right]!!.plus(right.relations[this]!!)
        happiness + leftHappinessDelta + rightHappinessDelta
    } else {
        val standing = this.relations.keys.filter { !sat.contains(it) }
        standing.maxOf { it.getMaxHappiness(happiness + leftHappinessDelta, newSat) }
    }
}

private class Invited(private val name: String) {
    var relations = mutableMapOf<Invited, Int>()

    override fun toString(): String {
        return "Invited(name='$name')"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Invited

        return name == other.name
    }

    override fun hashCode(): Int {
        return name.hashCode()
    }
}

private fun List<String>.getInvitedMap(): MutableMap<String, Invited> {
    val invitedMap = mutableMapOf<String, Invited>()
    this.map {
        it.replace("lose ", "gain -").replace("would gain ", "").replace("happiness units by sitting next to ", "")
            .replace(".", "").split(" ")
    }.forEach {
        val invA = invitedMap.getOrPut(it[0]) { Invited(it[0]) }
        val invB = invitedMap.getOrPut(it[2]) { Invited(it[2]) }
        invA.relations[invB] = it[1].toInt()
    }
    return invitedMap
}
