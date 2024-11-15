package edu.grinnell.csc207.sorting;
/**
 * @author Sheilla Muligande a sorting algorithm inspired by insertion and selection sort.
 */
public class MuligandeSheillaSort {

  /**
   * selection sort on a part of the array.
   * @param values the array to be sorted.
   * @param start index where sorting begins.
   * @param end index where sorting ends.
   */
  public void selectionVariant(int[] values, int start, int end) {
    for (int i = start; i < end - 1; i++) {
      int smallest = i;
      for (int j = i + 1; j < end; j++) {
        if (values[j] < values[smallest]) {
          smallest = j;
        } // if
      } // for
      int temp = values[i];
      values[i] = values[smallest];
      values[smallest] = temp;
    } // for
  } // selectionVariant()

  /**
   * insertion sort on the other part of the array.
   * @param values the array to be sorted.
   */
  public void insertVariation(int[] values) {
    for (int i = 1; i < values.length; i++) {
      int key = values[i];
      int j = i - 1;
      while (j >= 0 && values[j] > key) {
        values[j + 1] = values[j];
        j--;
      } // while
      values[j + 1] = key;
    } // for
  } // insertionVariation()

  /**
   * sorts an array using insertion and selection variants. sort small sections of the array using
   * selection, then the they are sorted using insertion.
   * @param values the values to be sorted.
   * @param subArraySize the size of the subarrays that have to be sorted.
   */
  public void sort(int[] values, int subArraySize) {
    int n = values.length;
    // Step 1: Sort each block using Selection Sort
    for (int i = 0; i < n; i += subArraySize) {
      int end = Math.min(i + subArraySize, n); // AI addition
      selectionVariant(values, i, end);
    } // for
    insertVariation(values);
  } // sort()
} // MuligandeSheillaSort