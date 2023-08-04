import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day12Test {

    @Test
    fun part1() {
        assertEquals(6, Day12.part1("[1,2,3]"))
        assertEquals(6, Day12.part1("{\"a\":2,\"b\":4}"))
        assertEquals(3, Day12.part1("{\"a\":{\"b\":4},\"c\":-1}"))
        assertEquals(3, Day12.part1("[[[3]]] "))
        assertEquals(0, Day12.part1("{\"a\":[-1,1]}"))
        assertEquals(0, Day12.part1("[-1,{\"a\":1}]"))
        assertEquals(0, Day12.part1("[]"))
        assertEquals(0, Day12.part1("{}"))
    }

    @Test
    fun part2() {
        assertEquals(6, Day12.part2("[1,2,3]"))
        assertEquals(6, Day12.part2("{\"a\":2,\"b\":4}"))
        assertEquals(3, Day12.part2("{\"a\":{\"b\":4},\"c\":-1}"))
        assertEquals(3, Day12.part2("[[[3]]] "))
        assertEquals(0, Day12.part2("{\"a\":[-1,1]}"))
        assertEquals(0, Day12.part2("[-1,{\"a\":1}]"))
        assertEquals(0, Day12.part2("[]"))
        assertEquals(0, Day12.part2("{}"))

        assertEquals(6, Day12.part2("[1,2,3]"))
        assertEquals(4, Day12.part2("[1,{\"c\":\"red\",\"b\":2},3]"))
        assertEquals(0, Day12.part2("{\"d\":\"red\",\"e\":[1,2,3,4],\"f\":5}"))
        assertEquals(6, Day12.part2("[1,\"red\",5]"))
    }
}
