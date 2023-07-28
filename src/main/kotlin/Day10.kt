fun main() {
    val input = readInput("Day10")
    Day10.part1(input.first()).println()
    Day10.part2(input.first()).println()
}

class Day10 {
    companion object {
        fun part1(input: String): Int {
            return lookAndSay(input, 40).length
        }

        fun part2(input: String): Int {
            return lookAndSay(input, 50).length
        }
    }
}


fun lookAndSay(start: String, iterations: Int): String {
    var look = start
    for (i in 0..<iterations) {
        look = look.lookAndSayTransform()
    }
    return look
}

private fun String.lookAndSayTransform(): String {
    val regex = Regex("""((\d)\2*)""")
    return regex.replace(this) { matchResult ->
        val group = matchResult.groupValues[1]
        "${group.length}${group[0]}"
    }
}
