public class Palindrome {
    /*
    Return a Deque where the characters appear in the same order as in the String.
     */
    public Deque<Character> wordToDeque(String word) {
        if (word == null) {
            return null;
        }

        Deque<Character> stringDeque = new LinkedListDeque<>();

        for (int i = word.length() - 1; i >= 0; i--) {
            stringDeque.addFirst(word.charAt(i));
        }

        return stringDeque;
    }

    /*
    Return true if the given word is a palindrome, and false otherwise.
     */
    public boolean isPalindrome(String word) {
        //Special case, return false
        if (word == null)  {
            return false;
        }

        return isPalindromeHelper(wordToDeque(word));
    }

    private boolean isPalindromeHelper(Deque<Character> word) {
        //for word length of 0 or 1, always true
        if (word.size() == 0 || word.size() == 1) {
            return true;
        }

        //compare front and end
        char front = word.removeFirst();
        char last = word.removeLast();
        if (front != last) {
            return false;
        }

        return isPalindromeHelper(word);
    }

//    Without deque, recursive function
//    private boolean isPalindromeHelper(String word, int start, boolean isPal) {
//        if ((word.length() == start && isPal) || (word.length() == 1 && isPal)) {
//            return true;
//        }
//
//        if (word.charAt(start) == word.charAt(word.length() - 1) && isPal) {
//            isPalindromeHelper(word.substring(start + 1), start + 1, isPal);
//        } else {
//            isPal = false;
//        }
//        return isPal;
//    }

    //Overload method, for testing palindrome off by one
    public boolean isPalindrome(String word, CharacterComparator cc) {
        if (word == null) {
            return false;
        }

        return isPalindromeHelper(wordToDeque(word), cc);
    }

    //Overload method, for helping testing palindrome off by one
    private boolean isPalindromeHelper(Deque<Character> word, CharacterComparator cc) {
        if (word.size() == 0 || word.size() == 1) {
            return true;
        }

        char first = word.removeFirst();
        char last = word.removeLast();

        //call offByOne.java equalChars method to check whether their
        //difference is 1
        if (!cc.equalChars(first, last)) {
            return false;
        }

        return isPalindromeHelper(word, cc);
    }
}
