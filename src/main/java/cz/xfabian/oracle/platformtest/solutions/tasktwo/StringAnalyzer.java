package cz.xfabian.oracle.platformtest.solutions.tasktwo;

/**
 * This class contains methods to analyze Strings.
 *
 * @author Norbert Fabian
 */
public class StringAnalyzer {

    /**
     * Returns true if the given word is a palindrome
     * and doesn't contain whitespaces or special character, otherwise false.
     *
     * @param word String to check, if it is a palindrome.
     * @return True, if the given string is palindrome.
     */
    public boolean isPalindrome(String word) {
        int forwardIndex = 0;
        int backwardIndex = word.length() - 1;

        while (forwardIndex <= backwardIndex) {
            char first = word.charAt(forwardIndex++);
            char last = word.charAt(backwardIndex--);

            if (first != last || !(Character.isLetter(first) && Character.isLetter(last))) {
                return false;
            }
        }
        return true;
    }
}
