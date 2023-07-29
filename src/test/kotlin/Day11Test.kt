import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class Day11Test {

    @Test
    fun part1() {
        assertEquals("abcdffaa", Day11.part1("abcdefgh"))
    }

    @Test
    fun part2() {
        assertEquals("abcdffbb", Day11.part2("abcdefgh"))
    }

    @Test
    fun abc_to_num() {
        assertEquals(0, "a".abcToNum())
        assertEquals(0, "aa".abcToNum())
        assertEquals(1, "b".abcToNum())
        assertEquals(25, "z".abcToNum())
        assertEquals(26, "ba".abcToNum())
        assertEquals(27, "bb".abcToNum())
        assertEquals(51, "bz".abcToNum())
        assertEquals(52, "ca".abcToNum())
        assertEquals(675, "zz".abcToNum())
        assertEquals(676, "baa".abcToNum())
        assertEquals(17575, "zzz".abcToNum())
        assertEquals(17576, "baaa".abcToNum())
        assertEquals(119438867, "kbjosp".abcToNum())
        assertEquals(Int.MAX_VALUE.toLong(), "gytisyx".abcToNum())
        assertEquals(8031810175, "zzzzzzz".abcToNum())
        assertEquals(8031810176, "baaaaaaa".abcToNum())
        assertEquals(208827064575, "zzzzzzzz".abcToNum())
        assertEquals(208827064576, "baaaaaaaa".abcToNum())
        assertEquals((Long.MAX_VALUE - 1), "dsqyomtlwmkgig".abcToNum())
    }

    @Test
    fun num_to_abc() {
        assertEquals("a", 0.toAbc())
        assertEquals("b", 1.toAbc())
        assertEquals("z", 25.toAbc())
        assertEquals("ba", 26.toAbc())
        assertEquals("bb", 27.toAbc())
        assertEquals("bc", 28.toAbc())
        assertEquals("bz", 51.toAbc())
        assertEquals("ca", 52.toAbc())
        assertEquals("zz", 675.toAbc())
        assertEquals("baa", 676.toAbc())
        assertEquals("zzz", 17575.toAbc())
        assertEquals("baaa", 17576.toAbc())
        assertEquals("kbjosp", 119438867.toAbc())
        assertEquals("gytisyx", Int.MAX_VALUE.toAbc())
        assertEquals("zzzzzzz", 8031810175.toAbc())
        assertEquals("baaaaaaa", 8031810176.toAbc())
        assertEquals("zzzzzzzz", 208827064575.toAbc())
        assertEquals("baaaaaaaa", 208827064576.toAbc())
        assertEquals("dsqyomtlwmkgig", (Long.MAX_VALUE - 1L).toAbc())
    }

    @Test
    fun santa_security_valid() {
        assertFalse("hijklmmn".santaSecurityValid())
        assertFalse("abbceffg".santaSecurityValid())
        assertFalse("abbcegjk".santaSecurityValid())
        assertTrue("abcdffaa".santaSecurityValid())
        assertTrue("ghjaabcc".santaSecurityValid())
    }
}
