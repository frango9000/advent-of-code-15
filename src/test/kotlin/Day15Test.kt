import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day15Test {

    private val testInput = listOf(
        "Butterscotch: capacity -1, durability -2, flavor 6, texture 3, calories 8",
        "Cinnamon: capacity 2, durability 3, flavor -2, texture -1, calories 3",
    )

    @Test
    fun part1() {
        assertEquals(62842880, Day15.part1(testInput))
    }

    @Test
    fun part2() {
        assertEquals(57600000, Day15.part2(testInput))
    }
}
