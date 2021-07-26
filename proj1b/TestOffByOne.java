import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    //False cases: a b, 1 2
    @Test
    public void testEqualChars1() {
        char a = 'a';
        char b = 'a';
        char c = 'z';
        char d = 'B';

        boolean result1 = offByOne.equalChars(a, b);
        boolean result2 = offByOne.equalChars(a, c);
        boolean result3 = offByOne.equalChars(a, d);

        assertFalse(result1);
        assertFalse(result2);
        assertFalse(result3);
    }

    //True cases: a a, 1 1
    @Test
    public void testEqualChars2() {
        char a = 'a';
        char b = 'b';
        char c = '1';
        char d = '2';

        boolean result1 = offByOne.equalChars(a, b);
        boolean result2 = offByOne.equalChars(c, d);

        assertTrue(result1);
        assertTrue(result2);
    }

    //Corner cases: whitespace, special char
    @Test
    public void testEqualChar3() {
        char a = '%';
        char b = '!';
        char c = '\t';
        char d = '\n';

        boolean result1 = offByOne.equalChars(a, b);
        boolean result2 = offByOne.equalChars(c, d);

        assertFalse(result1);
        assertTrue(result2);
    }
}
