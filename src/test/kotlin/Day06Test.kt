import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day06Test {

    private val testInput = listOf(
        "turn on 0,0 through 999,999",
        "toggle 0,0 through 999,0",
        "turn off 499,499 through 500,500",
    )

    @Test
    fun part1() {
        assertEquals(998996, Day06.part1(testInput))
    }

    @Test
    fun part2() {
        assertEquals(1001996, Day06.part2(testInput))
    }
}
