import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day01Test {

    @Test
    fun part1() {
        assertEquals( 0,Day01.part1(listOf("(())")))
        assertEquals( 0,Day01.part1(listOf("()()")))
        assertEquals( 3,Day01.part1(listOf("(((")))
        assertEquals( 3,Day01.part1(listOf("(()(()(")))
        assertEquals( 3,Day01.part1(listOf("))(((((")))
        assertEquals( -1,Day01.part1(listOf("())")))
        assertEquals( -1,Day01.part1(listOf("))(")))
        assertEquals( -1,Day01.part1(listOf("))(")))
        assertEquals( -3,Day01.part1(listOf(")))")))
        assertEquals( -3,Day01.part1(listOf(")())())")))
    }

    @Test
    fun part2() {
        assertEquals(1, Day01.part2(listOf(")")))
        assertEquals(5, Day01.part2(listOf("()())")))
    }
}
