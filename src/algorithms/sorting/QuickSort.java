package algorithms.sorting;

import base.AlgorithmsBase;
import base.SortingAlgorithms;

import java.util.Arrays;

/**
 * Created by tmsbn on 2/28/16.
 */
public class QuickSort extends SortingAlgorithms implements AlgorithmsBase {

    @Override
    public void execute() {

        int numbers[] = {10, 0, 1, 3, 5, 10, 20, 7};
        System.out.println("The original array is " + Arrays.toString(numbers));

        quickSort(numbers, 0, numbers.length - 1);

        System.out.println("The swapped array is " + Arrays.toString(numbers));

    }

    private int partition(int[] numbers, int lo, int hi) {

        int pivot = numbers[hi];
        int i = lo;
        for (int j = lo; j < hi; j++) {
            if (numbers[j] <= pivot) {
                swap(numbers, i, j);
                i++;
            }
        }
        swap(numbers, i, hi);
        return i;
    }

    private void quickSort(int[] numbers, int lo, int hi) {

        if (lo < hi) {
            int p = partition(numbers, lo, hi);
            quickSort(numbers, lo, p - 1);
            quickSort(numbers, p + 1, hi);
        }
    }


    private void swap(int[] numbers, int i, int j) {

        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }

}
