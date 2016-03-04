package algorithms.arrays;

import algorithms.annotation.Strategy;
import algorithms.annotation.SwitchMenu;
import base.DSABase;
import base.ArrayQuestions;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by tmsbn on 3/1/16.
 */
public class MaximumAvgSubArray extends ArrayQuestions implements DSABase {

    int[] inputArray = {4, 100, 99, 23, 3};
    int sizeOfSubArray;

    @Override
    public void execute() {


        System.out.println("Original Array is " + Arrays.toString(inputArray));

        System.out.print("Enter size of sub array:");
        sizeOfSubArray = new Scanner(System.in).nextInt();

        if (sizeOfSubArray > inputArray.length)
            throw new IllegalArgumentException("Size of sub array cannot be greater than size of array");

        new SwitchMenu(this).show();


    }

    @Strategy
    public void naiveStrategy() {

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

    @Strategy
    public void slidingWindowStrategy() {

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
