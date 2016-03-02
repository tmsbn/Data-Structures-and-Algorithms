package algorithms.arrays;

import base.AlgorithmsBase;
import base.ArrayQuestions;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by tmsbn on 3/1/16.
 */
public class MaximumAvgSubarray extends ArrayQuestions implements AlgorithmsBase {

    @Override
    public void execute() {

        int[] inputArray = {4, 100, 99, 23, 3};
        System.out.println("Original Array is " + Arrays.toString(inputArray));

        System.out.print("Enter size of sub array:");
        int sizeOfSubArray = new Scanner(System.in).nextInt();

        if (sizeOfSubArray > inputArray.length)
            throw new IllegalArgumentException("Size of sub array cannot be greater than size of array");


        System.out.println("Find duplicates using-");
        System.out.println("1. Using brute force strategy");
        System.out.println("2. Using sliding window method ");
        System.out.print("\nChoose Method of Algorithm:");

        int input = new Scanner(System.in).nextInt();

        switch (input) {
            case 1:
                naiveStrategy(inputArray, sizeOfSubArray);
                break;
            case 2:
                slidingWindowStrategy(inputArray, sizeOfSubArray);
                break;
            default:
                break;
        }
    }


    private void naiveStrategy(int[] inputArray, int sizeOfSubArray) {

        int maxSum = 0;
        int startIndex = 0;
        for (int i = 0; i <= inputArray.length - sizeOfSubArray; i++) {
            int sum = 0;
            for (int j = i; j < i + sizeOfSubArray; j++)
                sum += inputArray[j];

            if (maxSum < sum) {
                maxSum = sum;
                startIndex = i;
            }
        }
        System.out.println("Sub array of size " + sizeOfSubArray + " with maximum average");
        for (int i = startIndex; i < startIndex + sizeOfSubArray; i++)
            System.out.println(inputArray[i]);
    }

    private void slidingWindowStrategy(int[] inputArray, int sizeOfSubArray) {

        int sum = 0;
        int startIndex = 0;
        int length = inputArray.length;

        for (int i = 0; i < sizeOfSubArray; i++) {
            sum += inputArray[i];
        }

        int maxSum = 0;
        for (int i = sizeOfSubArray; i < length; i++) {
            sum = sum - inputArray[i - sizeOfSubArray] + inputArray[i];
            if (maxSum < sum) {
                maxSum = sum;
                startIndex = i - sizeOfSubArray + 1;
            }
        }

        System.out.print("Sub array of size " + sizeOfSubArray + " with maximum average:" + Arrays.toString(Arrays.copyOfRange(inputArray, startIndex, startIndex + sizeOfSubArray)));
    }


}
