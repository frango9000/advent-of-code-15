import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day01Test {

    @Test
    fun part1() {
        assertEquals(Day01.part1(listOf("(())")), 0)
        assertEquals(Day01.part1(listOf("()()")), 0)
        assertEquals(Day01.part1(listOf("(((")), 3)
        assertEquals(Day01.part1(listOf("(()(()(")), 3)
        assertEquals(Day01.part1(listOf("))(((((")), 3)
        assertEquals(Day01.part1(listOf("())")), -1)
        assertEquals(Day01.part1(listOf("))(")), -1)
        assertEquals(Day01.part1(listOf("))(")), -1)
        assertEquals(Day01.part1(listOf(")))")), -3)
        assertEquals(Day01.part1(listOf(")())())")), -3)
    }

    @Test
    fun part2() {
        assertEquals(Day01.part2(listOf(")")), 1)
        assertEquals(Day01.part2(listOf("()())")), 5)
    }
}
