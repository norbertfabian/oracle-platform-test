package cz.xfabian.oracle.platformtest.solutions.taskone;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * Tests for the ArrayUtils class
 *
 * @author Norbert Fabian
 */
public class ArrayUtilsTest {

    @DataProvider
    public Object[][] moveZerosToEndDataProvider() {
        return new int[][][]{
                {{1,3,0,8,12,0,4,0,7}, {1,3,8,12,4,7,0,0,0}},
                {{}, {}},
                {{0,0,0}, {0,0,0}},
                {{1,1,1}, {1,1,1}},
                {{-1,0,1}, {-1,1,0}},
        };
    }

    @Test(dataProvider = "moveZerosToEndDataProvider")
    public void moveZerosToEndTest(int[] input, int[] expected) {
        ArrayUtils arrayUtils = new ArrayUtils();

        int[] result = arrayUtils.moveZerosToEnd(input);

        Assert.assertEquals(Arrays.toString(result), Arrays.toString(expected), "MoveZerosToEnd test failed.");
    }
}