package questions.arrays;

import base.DSABase;
import base.ArrayQuestions;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by tmsbn on 2/27/16.
 */
public class BinarySearch extends ArrayQuestions implements DSABase {

    @Override
    public void execute() {

        //The array must be sorted for binary doesNumberExist to work
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

        while (start <= end) {

            int middle = (start + end) / 2;
            if (inputNumber == numbers[middle]) {
                foundIndex = middle;
                break;
            } else if (inputNumber > numbers[middle]) {
                start = middle + 1;
            } else {
                end = middle;
            }
        }

        System.out.println(foundIndex != -1 ? "Number found at index:" + foundIndex : "Number doesn't exist");

    }


}
