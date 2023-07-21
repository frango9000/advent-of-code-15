import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day00Test {

    private val testInput = listOf(
        "1000",
    )

    @Test
    fun part1() {
        assertEquals(1, Day00.part1(testInput))
    }

    @Test
    fun part2() {
        assertEquals(2, Day00.part2(testInput))
    }
}
