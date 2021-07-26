import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();
    static CharacterComparator offByOne = new OffByOne();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }
    //Uncomment this class once you've created your Palindrome class.

    //Normal case: cat, racecar, aaaaab, aaaaa
    @Test
    public void testIsPalindrome1() {
        boolean cat = palindrome.isPalindrome("cat");
        boolean racecar = palindrome.isPalindrome("racecar");
        boolean aabaa = palindrome.isPalindrome("aabaa");
        boolean aaaaa = palindrome.isPalindrome("aaaaa");

        assertFalse(cat);
        assertTrue(racecar);
        assertTrue(aabaa);
        assertTrue(aaaaa);
    }

    //Corner case: one word or null or space
    @Test
    public void testIsPalindrome2() {
        boolean oneWord = palindrome.isPalindrome("a");
        boolean space = palindrome.isPalindrome(" ");
        boolean nullWord = palindrome.isPalindrome(null);

        assertTrue(oneWord);
        assertTrue(space);
        assertFalse(nullWord);
    }

    //Normal case: flake (true), blank (false), chrysid (true)
    @Test
    public void testIsPalindromeOverload1() {
        boolean flake = palindrome.isPalindrome("flake", offByOne);
        boolean blank = palindrome.isPalindrome("blank", offByOne);
        boolean chrysid = palindrome.isPalindrome("chrysid", offByOne);

        assertTrue(flake);
        assertFalse(blank);
        assertTrue(chrysid);
    }

}
