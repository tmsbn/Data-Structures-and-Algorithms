package algorithms.arrays;

import base.AlgorithmsBase;
import base.ArrayQuestions;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by tmsbn on 2/27/16.
 */
public class BinarySearch extends ArrayQuestions implements AlgorithmsBase {

    @Override
    public void execute() {

        //The array must be sorted for binary search to work
        int[] sortedArray = {1, 2, 4, 5, 6};

        System.out.println("Original Array is " + Arrays.toString(sortedArray));
        System.out.print("Enter a number to find:");

        int inputNumber = new Scanner(System.in).nextInt();
        performBinarySearch(sortedArray, inputNumber);
    }

    private void performBinarySearch(int numbers[], int inputNumber) {

        int start = 0;
        int end = numbers.length - 1;

        int foundIndex = -1;

        while (start != end) {
            int middle = (start + end) / 2;
            if (inputNumber == numbers[middle]) {
                foundIndex = middle;
                break;
            } else if (inputNumber > numbers[middle]) {
                start = middle + 1;
            } else {
                //end is not middle-1, because if we search for a number less than the number[0], then end becomes -1
                end = middle;
            }
        }

        System.out.println(foundIndex != -1 ? "Number found at index:" + foundIndex : "Number doesn't exist");

    }


}
