import org.junit.jupiter.api.Test

class Day00Test {

    private val testInput = listOf(
        "1000",
    )

    @Test
    fun part1() {
        check(Day00.part1(testInput) == 1)
    }

    @Test
    fun part2() {
        check(Day00.part2(testInput) == 2)
    }
}
