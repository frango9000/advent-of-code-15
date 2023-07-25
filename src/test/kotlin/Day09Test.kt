import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day09Test {

    private val testInput = listOf(
        "London to Dublin = 464", "London to Belfast = 518", "Dublin to Belfast = 141",
    )

    @Test
    fun part1() {
        assertEquals(605, Day09.part1(testInput))
    }

    @Test
    fun part2() {
        assertEquals(982, Day09.part2(testInput))
    }
}
