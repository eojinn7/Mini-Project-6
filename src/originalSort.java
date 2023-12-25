import java.util.Arrays;
import java.util.Comparator;

public class HybridSorter<T> implements Sorter<T> {

    // Threshold for switching to insertion sort
    private static final int INSERTION_SORT_THRESHOLD = 10;

    @Override
    public void sort(T[] values, Comparator<? super T> comparator) {
        hybridSort(values, 0, values.length - 1, comparator);
    }

    // Hybrid sorting algorithm
    private void hybridSort(T[] values, int low, int high, Comparator<? super T> comparator) {
        // If the partition size is small, use insertion sort
        if (high - low < INSERTION_SORT_THRESHOLD) {
            insertionSort(values, low, high, comparator);
        } else {
            // Otherwise, use quicksort
            int pivotIndex = partition(values, low, high, comparator);
            hybridSort(values, low, pivotIndex - 1, comparator);
            hybridSort(values, pivotIndex + 1, high, comparator);
        }
    }

    // Partitioning step of quicksort
    private int partition(T[] values, int low, int high, Comparator<? super T> comparator) {
        T pivot = values[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (comparator.compare(values[j], pivot) <= 0) {
                i++;
                swap(values, i, j);
            }
        }

        swap(values, i + 1, high);
        return i + 1;
    }

    // Insertion sort for small partitions
    private void insertionSort(T[] values, int low, int high, Comparator<? super T> comparator) {
        for (int i = low + 1; i <= high; i++) {
            T key = values[i];
            int j = i - 1;

            while (j >= low && comparator.compare(values[j], key) > 0) {
                values[j + 1] = values[j];
                j--;
            }

            values[j + 1] = key;
        }
    }

    // Helper method to swap elements in an array
    private void swap(T[] values, int i, int j) {
        T temp = values[i];
        values[i] = values[j];
        values[j] = temp;
    }

    public static void main(String[] args) {
        HybridSorter<Integer> sorter = new HybridSorter<>();
        Integer[] array = {5, 3, 9, 7, 1, 8, 6, 2, 4};

        System.out.println("Original array: " + Arrays.toString(array));
        sorter.sort(array, Comparator.naturalOrder());
        System.out.println("Sorted array: " + Arrays.toString(array));
    }
}
