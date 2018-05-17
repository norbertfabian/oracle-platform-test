package cz.xfabian.oracle.platformtest.solutions.taskthree;

/**
 * Interface defines methods for setting a value in a matrix and getting the sum of defined submatrixe.
 *
 * @author Norbert Fabian
 */
public interface Matrix {

    /**
     * Updates matrix value at a given row and column.
     *
     * @param row This matrix's row.
     * @param col This matrix's column.
     * @param val Value to set at the position specified by the given row and column.
     */
    void set(int row, int col, int val);

    /**
     * Returns the sum of values from the top left corner to the given row, column sub-matrix.
     *
     * @param row Row where the sub-matrix has to end.
     * @param col Column where the sub-matrix has to end.
     * @return The sum of the sub-matrix limited by the given row and column.
     */
    int sum(int row, int col);
}
