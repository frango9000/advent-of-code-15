import org.junit.jupiter.api.Test

class Day00Test {

    private val testInput = listOf(
        "1000",
    )

    @Test
    fun part1() {
        check(Day01.part1(testInput) == 1)
    }

    @Test
    fun part2() {
        check(Day01.part2(testInput) == 2)
    }
}
