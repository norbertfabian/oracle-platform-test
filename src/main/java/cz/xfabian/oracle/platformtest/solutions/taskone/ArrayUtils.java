package cz.xfabian.oracle.platformtest.solutions.taskone;

/**
 * This contains methods for manipulating arrays.
 *
 * @author Norbert Fabian
 */
public class ArrayUtils {

    /**
     * Creates and returns a new array with the same length as the given array.
     * The new array contains all non zero numbers from the given array
     * at the beginning in the same order. The rest of the array fields are zeros.
     *
     * @param toSortArray Array with non zero numbers to move to the beginning.
     * @return New array with non zero numbers at beginning.
     */
    public int[] moveZerosToEnd(int[] toSortArray) {
        int[] sortedArray = new int[toSortArray.length];
        int sortedIndex = 0;

        for (int toSortIndex = 0; toSortIndex < toSortArray.length; toSortIndex++ ) {
            if (toSortArray[toSortIndex] != 0) {
                sortedArray[sortedIndex++] = toSortArray[toSortIndex];
            }
        }

        return sortedArray;
    }
}
