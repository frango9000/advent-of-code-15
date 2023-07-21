import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day02Test {

    @Test
    fun part1() {
        assertEquals(58, Day02.part1(listOf("2x3x4")))
        assertEquals(43, Day02.part1(listOf("1x1x10")))
    }

    @Test
    fun part2() {
        assertEquals(34, Day02.part2(listOf("2x3x4")))
        assertEquals(14, Day02.part2(listOf("1x1x10")))
    }
}
