package algorithms.sorting;

import base.AlgorithmsBase;

import java.util.Arrays;

/**
 * Created by tmsbn on 2/19/16.
 */
public class SelectionSort extends SortingAlgorithms implements AlgorithmsBase {

    @Override
    public void execute() {


        int numbers[] = {4, 5, 1, 3, 5, 10, 3};

        System.out.println("The original array is " + Arrays.toString(numbers));

        int n = numbers.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (numbers[minIndex] > numbers[j]) {
                    minIndex = j;
                }

            }
            swap(i, minIndex, numbers);
        }
        System.out.println("The sorted array is " + Arrays.toString(numbers));
    }

    public void swap(int i, int j, int[] a) {

        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
