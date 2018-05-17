package cz.xfabian.oracle.platformtest.solutions.taskthree;

import java.util.*;

/**
 * This matrix stores non zero values in TreeMaps. All the non stored values of the matrix are considered as zeros.
 * TreeMaps allows to do operations as set, or sum in logarithmic time.
 *
 * @author Norbert Fabian
 */
public class SparseMatrix implements Matrix {

    private TreeMap<Integer, TreeMap<Integer, Integer>> columnMap;

    public SparseMatrix() {
        columnMap = new TreeMap<>();
    }

    public void set(int row, int col, int val) {
        if (val == 0) {
            removeValue(row, col);
        } else {
            addOrUpdate(row, col, val);
        }
    }

    public int sum(int row, int col) {
        int sum = 0;

        NavigableMap<Integer, TreeMap<Integer, Integer>> subColumns = columnMap.subMap(0, true, col, true);
        for (TreeMap<Integer, Integer> column: subColumns.values()) {

            NavigableMap<Integer, Integer> subRows = column.subMap(0, true, row, true);
            for (Integer value: subRows.values()) {
                sum += value;
            }
        }

        return sum;
    }

    /**
     * Removes the value at the given row and column from the matrix.
     * If the column doesn't contain more values, the whole column's ThreeMap is removed.
     *
     * @param row Row of the matrix value to remove.
     * @param col Column of the matrix value to remove.
     */
    private void removeValue(int row, int col) {
        if (!columnMap.containsKey(col)) {
            return;
        }
        columnMap.get(col).remove(row);

        // Remove empty TreeMap if exist.
        if (columnMap.get(col).size() == 0) {
            columnMap.remove(col);
        }
    }

    /**
     * Adds the given value to the matrix if there is no value at the given position.
     * Updates the existing value at the given position if already exists.
     * If the column ThreeMap doesn't exist yet, creates a new one.
     *
     * @param row Row of the matrix where to add or update the value.
     * @param col Column of the matrix where to add or update the value.
     * @param val Value to add or update at the given position.
     */
    private void addOrUpdate(int row, int col, int val) {
        if (!columnMap.containsKey(col)) {
            columnMap.put(col, new TreeMap<Integer, Integer>());
        }
        columnMap.get(col).put(row, val);
    }
}
