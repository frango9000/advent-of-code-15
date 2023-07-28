import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day10Test {

    @Test
    fun part1() {
        assertEquals(6, lookAndSay("1", 5).length)
    }

    @Test
    fun part2() {
        assertEquals(1166642, lookAndSay("1", 50).length)
    }
}
