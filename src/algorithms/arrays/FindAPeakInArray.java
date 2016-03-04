package algorithms.arrays;

import base.DSABase;
import base.ArrayQuestions;

import java.util.Arrays;

/**
 * Created by tmsbn on 2/27/16.
 */
public class FindAPeakInArray extends ArrayQuestions implements DSABase {

    @Override
    public void execute() {

        int[] inputArray = {1, 4, 2, 5, 6};

        System.out.println("Original Array is " + Arrays.toString(inputArray));

        int peak = findPeak(inputArray);
        System.out.println(peak != -1 ? "Peak found at index:" + peak : "Peak doesn't exist");


    }

    private int findPeak(int[] inputArray) {

        int start = 0;
        int end = inputArray.length - 1;
        int n = inputArray.length;

        //if the peak is in the corners, then start can become equal to end
        while (start <= end) {
            int middle = (start + end) / 2;

            int right = middle + 1;
            int left = middle - 1;

            if ((middle == n - 1 || inputArray[middle] >= inputArray[right]) &&
                    (middle == 0 || inputArray[middle] >= inputArray[left])) {
                return middle;


            } else if (inputArray[middle] < inputArray[right]) {
                start = middle + 1;
            } else if (inputArray[middle] < inputArray[left]) {
                end = middle - 1;
            }

        }
        return -1;
    }
}
