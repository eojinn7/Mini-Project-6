import java.util.Comparator;

/**
 * Implementation of Quicksort.
 *
 * @author Jinny Eo
 */

public class Quicksort implements Sorter {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The one sorter you can access.
   */
  public static Sorter SORTER = new Quicksort();

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter.
   * 
   * @param <T>
   */
  private static <T> void quicksort(T[] values, Comparator<? super T> order, int lb, int ub) {
    // subarrays
    if (lb >= ub) {
      return;
    } else {
     // divide and recursively call
      int mid = partition(values, order, lb, ub);
      quicksort(values, order, lb, mid - 1); 
      quicksort(values, order, mid + 1, ub);
    }
  } // quicksort(T[], Comparator<? super T>, int, int)

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  private static <T> int partition(T[] arr, Comparator<? super T> order, int lb, int ub) {
    // determine pivot value
    T pivotVal = arr[lb];
    int left = lb + 1;
    int right = ub;

    while (true) {
      while (left <= right && order.compare(arr[left], pivotVal) <= 0) {
        left++; 
      }

      while (order.compare(arr[right], pivotVal) > 0) {
        right--; 
      }

      if (left >= right) {
        break; 
      }

      // swap values
      T temp = arr[left];
      arr[left] = arr[right];
      arr[right] = temp;
      left++;
      right--;
    }

    arr[lb] = arr[right];
    arr[right] = pivotVal;

    return right;
  } // partition(T[], Comparator<? super T>, int, int)

  @Override
  public <T> void sort(T[] values, Comparator<? super T> order) {
    quicksort(values, order, 0, values.length - 1);
  } // sort(T[], Comparator<? super T>
} // class Quicksort


