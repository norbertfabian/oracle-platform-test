package cz.xfabian.oracle.platformtest.solutions.tasktwo;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Tests for the StringAnalyzer.
 *
 * @author Norbert Fabian
 */
public class StringAnalyzerTest {

    @DataProvider
    public Object[][] isPalindromeDataProvider() {
        return new Object[][]{
                {"dabcbad", true},
                {"dabbad", true},
                {"d", true},
                {"", true},
                {"Deed", false},
                {" dabbad ", false},
                {" dabbad", false},
                {" ", false},
                {"33", false},
                {"3", false},
                {"..", false},
                {".", false}
        };
    }

    @Test(dataProvider = "isPalindromeDataProvider")
    public void isPalindromeTest(String input, boolean expected) {
        StringAnalyzer stringAnalyzer = new StringAnalyzer();

        boolean result = stringAnalyzer.isPalindrome(input);

        Assert.assertEquals(result, expected, "IsPalindrome test failed.");
    }
}