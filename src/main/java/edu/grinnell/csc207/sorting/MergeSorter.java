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
    }
    int middle = values.length / 2;
    int leftIndex = 0;
    int rightIndex = 0;
    int currIndex = 0;

    T[] LArray = (T[]) new Object[middle];
    T[] RArray = (T[]) new Object[values.length - middle]; // might need to subtract 1??

    for (int i = 0; i < middle; i++) {
      LArray[i] = values[i]; // first array
    } // for

    for (int i = middle; i < values.length; i++) { // has to start at middle of values
      RArray[i - middle] = values[i];
    } // for

    sort(LArray);
    sort(RArray);

    for (; leftIndex < LArray.length && rightIndex < RArray.length; currIndex++) {
      if (order.compare(LArray[leftIndex], RArray[rightIndex]) <= 0) {
        values[currIndex] = LArray[leftIndex];
        leftIndex++;
      } else {
        values[currIndex] = RArray[rightIndex];
        rightIndex++;
      } // if
    } // for

    while (leftIndex < LArray.length) {
      values[currIndex] = LArray[leftIndex];
      leftIndex++;
      currIndex++;
    } // while

    while (rightIndex < RArray.length) {
      values[currIndex] = RArray[rightIndex];
      rightIndex++;
      currIndex++;
    } // while

  } // sort(T[])
} // class MergeSorter
