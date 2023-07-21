import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day05Test {

    private val testInput = listOf(
        "1000",
    )

    @Test
    fun part1() {
        assertEquals(1, Day05.part1(listOf("ugknbfddgicrmopn")))
        assertEquals(1, Day05.part1(listOf("aaa")))
        assertEquals(0, Day05.part1(listOf("jchzalrnumimnmhp")))
        assertEquals(0, Day05.part1(listOf("haegwjzuvuyypxyu")))
        assertEquals(0, Day05.part1(listOf("dvszwmarrgswjxmb")))
    }

    @Test
    fun part2() {
        assertEquals(1, Day05.part2(listOf("qjhvhtzxzqqjkmpb")))
        assertEquals(1, Day05.part2(listOf("xxyxx")))
        assertEquals(0, Day05.part2(listOf("uurcxstgmygtbstg")))
        assertEquals(0, Day05.part2(listOf("ieodomkazucvgmuy")))
    }
}
