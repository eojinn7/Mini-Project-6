import java.util.Comparator;

/**
 * Sort using insertion sort.
 *
 * @author Jinny Eo
 */

public class InsertionSort implements Sorter {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The one sorter you can access.
   */
  public static Sorter SORTER = new InsertionSort();

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter.
   */
  private static <T> void insertionSort(T[] values, Comparator<? super T> comparator) {
    for (int i = 1; i < values.length; i++) { 
      // initialize values
      T temp = values[i];
      int j = i - 1; 
      // while loop for elements that are in order
      while (j >= 0 && comparator.compare(values[j], temp) > 0) { 
        // if follow condition (comparator), then insert element to next position
        values[j + 1] = values[j]; 
        j--;
      }
      values[j + 1] = temp; 
    }
  } // InsertionSort(T[], Comparator<? super T>)

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  @Override
  public <T> void sort(T[] values, Comparator<? super T> order) {
    insertionSort(values, order);
  } // sort(T[], Comparator<? super T>)
} // class InsertionSort


