package algorithms.sorting;

import base.AlgorithmsBase;
import base.SortingAlgorithms;

import java.util.Arrays;

/**
 * Created by tmsbn on 2/21/16.
 */
public class InsertionSort extends SortingAlgorithms implements AlgorithmsBase {
    @Override
    public void execute() {

        int numbers[] = {3, 4, 19, 3, 5, 10, 11, 7};

        System.out.println("The original array is " + Arrays.toString(numbers));

        int n = numbers.length;
        for (int i = 0; i < n - 1; i++) {
            int j = i + 1;
            int temp = numbers[j];
            while (j > 0 && temp < numbers[j - 1]) {
                numbers[j] = numbers[j - 1];
                j--;
            }
            numbers[j] = temp;
        }

        System.out.println("The sorted array is " + Arrays.toString(numbers));
    }
}
