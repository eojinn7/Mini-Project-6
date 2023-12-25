import java.util.Arrays;
import java.util.Comparator;

/**
 * Implementation of merge sort.
 *
 * @author Jinny Eo
 */

public class MergeSort implements Sorter {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The one sorter you can access.
   */
  public static Sorter SORTER = new MergeSort();

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter.
   * 
   * @param <T>
   */
  public static <T> void mergeSort(T[] vals, int lo, int hi, Comparator<? super T> comparator) {

    if (lo < hi) {

      int mid = lo + (hi - lo) / 2;

      // call to left and right array
      mergeSort(vals, lo, mid, comparator);
      mergeSort(vals, mid + 1, hi, comparator);

      // merge sorted
      merge(vals, lo, mid, hi, comparator);

    } // if
  } // mergeSort()

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+
  
  private static <T> void merge(T[] vals, int lo, int mid, int hi, Comparator<? super T> comparator) {
    int leftSize = mid - lo + 1; 
    int rightSize = hi - mid;

    T[] left = Arrays.copyOfRange(vals, lo, mid + 1); 
    T[] right = Arrays.copyOfRange(vals, mid + 1, hi + 1);

   // initialize pointers
    int i = 0; 
    int j = 0; 
    int k = lo; 

    while (i < leftSize && j < rightSize) {
      if (comparator.compare(left[i], right[j]) <= 0) { // Perform merging of the array
        vals[k] = left[i]; 
        i++;
      } else {
        vals[k] = right[j]; 
        j++;
      }
      k++;
    }

    while (i < leftSize) { 
      vals[k] = left[i];
      i++;
      k++;
    }

    while (j < rightSize) { 
      vals[k] = right[j];
      j++;
      k++;
    }
  } // merge(T[], int, int, Comparator<? super T>)

  public static <T> void mergeHelper(T[] vals, Comparator<? super T> comparator) {
    mergeSort(vals, 0, vals.length - 1, comparator);
  } // mergeHelper()

  @Override
  public <T> void sort(T[] values, Comparator<? super T> order) {
    mergeHelper(values, order);
  } // sort(T[], Comparator<? super T>
} // class MergeSort



