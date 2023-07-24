import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import kotlin.test.assertTrue

class Day08Test {

    private val testInput = listOf(
        "\"\"",
        "\"abc\"",
        "\"aaa\\\"aaa\"",
        "\"\\x27\"",
    )

    @Test
    fun part1() {
        assertEquals(12, Day08.part1(testInput))
    }

    @Test
    fun part2() {
        assertEquals(19, Day08.part2(testInput))
    }
}
