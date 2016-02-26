package algorithms.arrays;

import base.AlgorithmsBase;
import base.ArrayQuestions;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by tmsbn on 2/25/16.
 */
public class FrequencyOfArrayElements extends ArrayQuestions implements AlgorithmsBase {

    @Override
    public void execute() {

        int numbers[] = {4, 5, 1, 3, 5, 0, 3};

        System.out.println("The original array is " + Arrays.toString(numbers));

        System.out.println("1. Direct Algorithm:");
        System.out.println("2. Frequency Algorithm");
        System.out.println("3. Optimized Frequency Algorithm");
        System.out.print("\nChoose Method of Algorithm:");

        int input = new Scanner(System.in).nextInt();
        switch (input) {
            case 1:
                n00bAlgorithm(numbers);
                break;
            case 2:
                frequencyAlgorithm(numbers);
                break;
            case 3:
                frequencyAlgorithmWithSameArray(numbers);
                break;
            default:
                break;


        }

    }

    // Algorithm 1: O(n^2) time and O(1) space
    private void n00bAlgorithm(int[] inputArray) {

        int length = inputArray.length;

        for (int i = 0; i < length; i++) {

            int count = 0;
            for (int number : inputArray) {
                if (number == i)
                    count++;
            }

            System.out.println(i + ". " + count);
        }
    }

    // Algorithm 2: O(n) time and O(n) space, BUT the array elements HAS be less than size of the array
    private void frequencyAlgorithm(int[] inputArray) {

        int length = inputArray.length;
        int[] countArray = new int[length];

        for (int number : inputArray) {
            //To prevent index out of bound exception
            if (number < length)
                countArray[number]++;
        }

        for (int i = 0; i < length; i++) {
            System.out.println(i + ". " + countArray[i]);
        }
    }

    // Algorithm 3: O(n) time and O(1) space, BUT the array elements HAS be less than size of the array
    private void frequencyAlgorithmWithSameArray(int[] inputArray) {

        int length = inputArray.length;
        for (int i = 0; i < length; i++) {
            inputArray[inputArray[i] % length] += length;
        }

        for (int i = 0; i < length; i++) {
            System.out.println(i + ". " + inputArray[i] / length);
        }
    }


}
