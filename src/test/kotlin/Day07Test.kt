import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day07Test {

    private val testInput = listOf(
        "x LSHIFT 2 -> f",
        "y RSHIFT 2 -> g",
        "123 -> x",
        "456 -> y",
        "x AND y -> d",
        "x OR y -> e",
        "NOT x -> h",
        "NOT y -> i",
    )

    @Test
    fun part1() {
        assertEquals((72).toUShort(), Day07.part1(testInput, "d"))
        assertEquals((507.toUShort()), Day07.part1(testInput, "e"))
        assertEquals((492.toUShort()), Day07.part1(testInput, "f"))
        assertEquals((114.toUShort()), Day07.part1(testInput, "g"))
        assertEquals((65412.toUShort()), Day07.part1(testInput, "h"))
        assertEquals((65079.toUShort()), Day07.part1(testInput, "i"))
        assertEquals((123.toUShort()), Day07.part1(testInput, "x"))
        assertEquals((456.toUShort()), Day07.part1(testInput, "y"))
    }

    @Test
    fun part2() {
        assertEquals((72).toUShort(), Day07.part2(testInput, "d", "y"))
        assertEquals((507.toUShort()), Day07.part2(testInput, "e", "d"))
        assertEquals((492.toUShort()), Day07.part2(testInput, "f", "e"))
        assertEquals((114.toUShort()), Day07.part2(testInput, "g", "f"))
        assertEquals((65412.toUShort()), Day07.part2(testInput, "h", "g"))
        assertEquals((65079.toUShort()), Day07.part2(testInput, "i", "h"))
        assertEquals((123.toUShort()), Day07.part2(testInput, "x", "i"))
        assertEquals((456.toUShort()), Day07.part2(testInput, "y", "x"))
    }
}
