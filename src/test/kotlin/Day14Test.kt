import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day14Test {

    private val testInput = listOf(
        "Comet can fly 14 km/s for 10 seconds, but then must rest for 127 seconds.",
        "Dancer can fly 16 km/s for 11 seconds, but then must rest for 162 seconds.",
    )

    @Test
    fun part1() {
        assertEquals(1120, Day14.part1(testInput, 1000))
    }

    @Test
    fun part2() {
        assertEquals(689, Day14.part2(testInput, 1000))
    }
}
