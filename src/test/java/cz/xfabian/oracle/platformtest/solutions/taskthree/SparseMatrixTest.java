package cz.xfabian.oracle.platformtest.solutions.taskthree;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Tests for the SparseMatrix.
 *
 * @author Norbert Fabian
 */
public class SparseMatrixTest {

    @DataProvider
    public Object[][] sumDataProvider() {
        return new Object[][]{
                {1, 1, 0},
                {2, 1, 0},
                {1, 2, 1},
                {3, 1, 2},
                {3, 2, 3},
                {4, 4, 7},
                {5, 5, 7}
        };
    }

    @Test(dataProvider = "sumDataProvider")
    public void sum(int row, int col, int expected) {
        Matrix matrix = new SparseMatrix();
        matrix.set(1, 2, 1);
        matrix.set(3, 1, 2);
        matrix.set(4, 4, 4);

        int sum = matrix.sum(row, col);

        Assert.assertEquals(sum, expected, "Matrix's sum calculation failed.");
    }
}
