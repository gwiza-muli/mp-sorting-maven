package edu.grinnell.csc207.sorting;

import java.util.Comparator;

/**
 * Something that sorts using merge sort.
 *
 * @param <T> The types of values that are sorted.
 *
 * @author Samuel A. Rebelsky
 */

public class MergeSorter<T> implements Sorter<T> {
  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The way in which elements are ordered.
   */
  Comparator<? super T> order;

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter using a particular comparator.
   *
   * @param comparator The order in which elements in the array should be ordered after sorting.
   */
  public MergeSorter(Comparator<? super T> comparator) {
    this.order = comparator;
  } // MergeSorter(Comparator)

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Sort an array in place using merge sort.
   *
   * @param values an array to sort.
   *
   * @post The array has been sorted according to some order (often one given to the constructor).
   * @post For all i, 0 &lt; i &lt; values.length, order.compare(values[i-1], values[i]) &lt;= 0
   */
  @Override
  public void sort(T[] values) {
    if (values.length <= 1) {
      return;
    } //if
    int middle = values.length / 2;
    int leftIndex = 0;
    int rightIndex = 0;
    int currIndex = 0;

    T[] leftArray = (T[]) new Object[middle];
    T[] rightArray = (T[]) new Object[values.length - middle]; // might need to subtract 1??

    for (int i = 0; i < middle; i++) {
      leftArray[i] = values[i]; // first array
    } // for

    for (int i = middle; i < values.length; i++) { // has to start at middle of values
      rightArray[i - middle] = values[i];
    } // for

    sort(leftArray);
    sort(rightArray);

    for (; leftIndex < leftArray.length && rightIndex < rightArray.length; currIndex++) {
      if (order.compare(leftArray[leftIndex], rightArray[rightIndex]) <= 0) {
        values[currIndex] = leftArray[leftIndex];
        leftIndex++;
      } else {
        values[currIndex] = rightArray[rightIndex];
        rightIndex++;
      } // if
    } // for

    while (leftIndex < leftArray.length) {
      values[currIndex] = leftArray[leftIndex];
      leftIndex++;
      currIndex++;
    } // while

    while (rightIndex < rightArray.length) {
      values[currIndex] = rightArray[rightIndex];
      rightIndex++;
      currIndex++;
    } // while

  } // sort(T[])
} // class MergeSorter
