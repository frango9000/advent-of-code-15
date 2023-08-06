fun main() {
    val input = readInput("Day12")
    Day12.part1(input.first()).println()
    Day12.part2(input.first()).println()
}

class Day12 {
    companion object {
        fun part1(input: String): Int {
            return input.getNumbers().sum()
        }

        fun part2(input: String): Int {
            var filtered = input
            while (filtered.contains(":\"red\"")) {
                val redIndex = filtered.indexOf(":\"red\"")
                var pre = filtered.substring(0..<redIndex)
                var level = 0
                var openIndex = 0
                for ((index, char) in pre.withIndex().reversed()) {
                    if (char == '{') {
                        if (level == 0) {
                            openIndex = index
                            break
                        } else {
                            level--
                        }
                    } else if (char == '}') {
                        level++
                    }
                }

                level = 0
                var post = filtered.substring(redIndex..filtered.lastIndex)
                var closeIndex = filtered.lastIndex
                for ((index, char) in post.withIndex()) {
                    if (char == '}') {
                        if (level == 0) {
                            closeIndex = index + redIndex
                            break
                        } else {
                            level--
                        }
                    } else if (char == '{') {
                        level++
                    }
                }
                pre = filtered.slice(0..<openIndex)
                post = filtered.slice(closeIndex + 1..filtered.lastIndex)
                filtered = pre + post
            }
            return part1(filtered)

        }
    }
}

fun String.getNumbers(): List<Int> {
    return """-?\d+""".toRegex().findAll(this).map { it.value.toInt() }.toList()
}
