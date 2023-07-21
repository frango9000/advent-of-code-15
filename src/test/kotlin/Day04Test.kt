import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day04Test {

    private val testInput = listOf(
        "1000",
    )

    @Test
    fun part1() {
        assertEquals(609043, Day04.part1("abcdef"))
        assertEquals(1048970, Day04.part1("pqrstuv"))
    }

    @Test
    fun part2() {
        assertEquals(6742839, Day04.part2("abcdef"))
        assertEquals(5714438, Day04.part2("pqrstuv"))
    }
}
