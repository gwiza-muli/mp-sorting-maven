package edu.grinnell.csc207.sorting;

import java.util.Comparator;
import java.util.Random;

/**
 * Something that sorts using Quicksort.
 *
 * @param <T> The types of values that are sorted.
 *
 * @author Samuel A. Rebelsky
 */

public class Quicksorter<T> implements Sorter<T> {
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
  public Quicksorter(Comparator<? super T> comparator) {
    this.order = comparator;
  } // Quicksorter(Comparator)

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Sort an array in place using Quicksort.
   *
   * @param values an array to sort.
   *
   * @post The array has been sorted according to some order (often one given to the constructor).
   * @post For all i, 0 &lt; i &lt; values.length, order.compare(values[i-1], values[i]) &lt;= 0
   */
  @Override
  public void sort(T[] values) {
    quicksort(values, 0, values.length - 1);
  } // sort(T[])
/**
 * @param values values to be sorted.
 * @param lb lower bound.
 * @param ub upper bound.
 */
  public void quicksort(T[] values, int lb, int ub) {
    if (lb >= ub) {
      return;
    } // if
    int[] dnf = dutchNationalFlag(values, lb, ub);
    quicksort(values, lb, dnf[0] - 1);
    quicksort(values, dnf[1] + 1, ub);
  } // quicksort
  /**
   * @param values array of values to be sorted.
   * @param lb index of left bound (red).
   * @param ub index of right bound (blue).
   * @return an array with the index where all the elements are less than the pivot,
   * equal to the pivot and all the elements are greater than the pivot.
   */
  public int[] dutchNationalFlag(T[] values, int lb, int ub) {
    Random rand = new Random();
    int pivotIndex = lb + rand.nextInt(ub - lb + 1);
    T pivot = values[pivotIndex];
    swap(values, pivotIndex, lb);

    int red = lb;
    int blue = ub;
    int curr = lb + 1;

    while (curr <= blue) {
      if (order.compare(values[curr], pivot) < 0) {
        swap(values, curr, red);
        red++;
        curr++;
      } else if (order.compare(values[curr], pivot) > 0) {
        swap(values, curr, blue);
        blue--;
      } else {
        curr++;
      } // if
    } // while
    return new int[] {red, blue};
  } // dutchNationalFlag

  /**
   * @param values the array whose values we are swapping.
   * @param indexOne index of first element
   * @param indexTwo index of second element
   */
  public void swap(T[] values, int indexOne, int indexTwo) {
    T val = values[indexOne];
    values[indexOne] = values[indexTwo];
    values[indexTwo] = val;
  } //swap()



} // class Quicksorter
