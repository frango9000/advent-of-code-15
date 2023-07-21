import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day03Test {

    @Test
    fun part1() {
        assertEquals(2, Day03.part1(">"))
        assertEquals(4, Day03.part1("^>v<"))
        assertEquals(2, Day03.part1("^v^v^v^v^v"))
    }

    @Test
    fun part2() {
        assertEquals(3, Day03.part2("^v"))
        assertEquals(3, Day03.part2("^>v<"))
        assertEquals(11, Day03.part2("^v^v^v^v^v"))
    }
}
