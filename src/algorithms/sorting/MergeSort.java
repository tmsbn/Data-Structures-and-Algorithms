package algorithms.sorting;

import base.AlgorithmsBase;
import base.SortingAlgorithms;

import java.util.Arrays;

/**
 * Created by tmsbn on 2/19/16.
 */
public class MergeSort extends SortingAlgorithms implements AlgorithmsBase {


    @Override
    public void execute() {

        int numbers[] = {4, 5, 1, 3, 5, 10, 3};
        System.out.println("The original array is " + Arrays.toString(numbers));

        int start = 0;
        int end = numbers.length - 1;

        mergeSort(start, end, numbers);

        System.out.println("The sorted array is " + Arrays.toString(numbers));
    }

    private void mergeSort(int start, int end, int[] numbers) {

        if (start < end) {

            int middle = (start + end) / 2;
            mergeSort(start, middle, numbers);
            mergeSort(middle + 1, end, numbers);
            merge(start, middle, end, numbers);
        }

    }

    private void merge(int start, int middle, int end, int[] numbers) {

        int n1 = middle - start + 1; // Start and middle could be the same
        int n2 = end - middle; // End and middle cannot be the same


        int[] temp1 = new int[n1];
        int[] temp2 = new int[n2];

        System.arraycopy(numbers, start, temp1, 0, n1);

        System.arraycopy(numbers, middle+1, temp2, 0, n2);

        int i = 0, j = 0, k = start;

        while (i < n1 && j < n2) {

            if (temp1[i] < temp2[j]) {
                numbers[k] = temp1[i];
                i++;
            } else {
                numbers[k] = temp2[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            numbers[k] = temp1[i];
            k++;
            i++;
        }
        while (j < n2) {
            numbers[k] = temp2[j];
            k++;
            j++;
        }

    }

}
