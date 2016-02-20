package algorithms;

import base.AlgorithmsBase;

import java.util.Arrays;

/**
 * Created by tmsbn on 2/19/16.
 */
public class BubbleSort implements AlgorithmsBase {

    @Override
    public void execute() {


        int numbers[] = {4, 5, 1, 3, 5, 10, 3};

        System.out.println("The original array is " + Arrays.toString(numbers));

        boolean swap = true;
        int n = numbers.length;
        while (swap) {
            //if no swapping is required, swapping will remain false
            swap = false;
            for (int i = 1; i < n; i++) {
                if (numbers[i-1] > numbers[i]) {
                    swap(i, i - 1, numbers);
                    swap = true;
                }

            }
            n--;
        }
        System.out.println("The sorted array is " + Arrays.toString(numbers));
    }

    public void swap(int i, int j, int[] a) {

        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
