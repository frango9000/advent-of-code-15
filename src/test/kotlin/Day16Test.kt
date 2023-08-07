import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day16Test {

    private val testInput = listOf(
        "Sue 210: perfumes: 4, cars: 8, samoyeds: 3",
        "Sue 211: perfumes: 2, cars: 8, trees: 9",
        "Sue 212: trees: 7, perfumes: 2, akitas: 5",
        "Sue 213: children: 3, goldfish: 5, vizslas: 0",
        "Sue 214: akitas: 6, goldfish: 0, children: 0",
        "Sue 215: trees: 8, akitas: 3, goldfish: 1",
        "Sue 216: goldfish: 6, perfumes: 8, akitas: 3",
        "Sue 217: children: 7, trees: 2, vizslas: 6",
        "Sue 320: vizslas: 4, akitas: 3, cats: 4",
        "Sue 321: goldfish: 4, akitas: 8, cars: 8",
        "Sue 322: pomeranians: 5, vizslas: 7, cats: 1",
        "Sue 323: perfumes: 1, trees: 6, goldfish: 0",
        "Sue 324: goldfish: 6, trees: 10, cars: 10",
        "Sue 325: akitas: 2, samoyeds: 6, trees: 9",
        "Sue 326: vizslas: 4, akitas: 7, cars: 9"
    )

    @Test
    fun part1() {
        assertEquals(213, Day16.part1(testInput))
    }

    @Test
    fun part2() {
        assertEquals(323, Day16.part2(testInput))
    }
}
